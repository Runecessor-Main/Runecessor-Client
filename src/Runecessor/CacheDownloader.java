package Runecessor;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.swing.JOptionPane;

/**
 * Cache downloading.
 * @author Lava, start of updating: 12-11-2013.
 */
public class CacheDownloader {

	private final int BUFFER = 1024;

	private static double kbps;


	public CacheDownloader(Client client) {
		Client.instance = client;
	}



	public static ArrayList<String> mainCacheDownloadLinks = new ArrayList<String>();
	public static ArrayList<String> spriteDownloadLinks = new ArrayList<String>();

	private static int cacheDownloadIndex = 0;
	public CacheDownloader downloadCache(String action) {
		if (action.equals("FIRST")) {
			mainCacheDownloadLinks.add(WebsiteRead.mainCacheDownloadLink);
			mainCacheDownloadLinks.add("http://Runecessor.net/game/osrscache.zip");
			mainCacheDownloadLinks.add("https://Runecessor.com/game/osrscache.zip");

			spriteDownloadLinks.add(WebsiteRead.spriteCacheDownloadLink);
			spriteDownloadLinks.add("http://Runecessor.net/game/spriteosrs.zip");
			spriteDownloadLinks.add("https://Runecessor.com/game/spriteosrs.zip");
		}
		if (!ClientDebugConfiguration.DOWNLOAD_LATEST_CACHE) {
			return null;
		}
		File location = new File(ClientConstants.getCacheRevisionLocation() + "/main_file_cache.dat");

		long size = location.length();

		File location1 = new File(ClientConstants.getSpritesLocation() + "sprites.dat");
		long size1 = location1.length();

		if (ClientDebugConfiguration.DEBUG_MODE) {
			Utility.print("Size of revision cache: " + size);
			Utility.print("Size of sprites: " + size1);
		}
		String downloadLink = "";
		String zipName = "";
		String zipLocation = "";
		String downloadingText = "";
		int mainCacheSize = 0;

		downloadLink = mainCacheDownloadLinks.get(cacheDownloadIndex);
		zipName = "474_cache.zip";
		zipLocation = ClientConstants.getCacheRevisionLocation() + "/474_cache";
		downloadingText = "Downloading step 1/2 ";
		mainCacheSize = ClientLiveConfiguration.MAIN_CACHE_SIZE;
		if (size == mainCacheSize) {
			downloadFile(downloadLink, zipName, zipLocation, downloadingText);
			unZip(zipLocation, zipName);
			deleteZIP(zipLocation);
		}
		// Will be enabled in the future when needed.
		//Client.getCachedUUIDGroup().add(new CachedUUIDEntry(Paths.get(ClientConstants.getCacheRevisionLocation(), "main_file_cache.idx6"), 131072, 1024 * 356, false));
		downloadLink = spriteDownloadLinks.get(cacheDownloadIndex);
		zipName = "cache.zip";
		zipLocation = ClientConstants.getCacheLocation() + "cache";
		downloadingText = "Downloading step 2/2 ";

		if (size1 == ClientLiveConfiguration.SPRITES_SIZE) {
			downloadFile(downloadLink, zipName, zipLocation, downloadingText);
			unZip(zipLocation, zipName);
			deleteZIP(zipLocation);
		} else if (!error) {
			return null;
		}
		if (error) {
			cacheDownloadIndex++;
			if (cacheDownloadIndex > mainCacheDownloadLinks.size() - 1) {
				cacheDownloadIndex = 0;
			}
			error = false;
			Object[] options =
			{"Try again", "Close"};
			int input = JOptionPane.showOptionDialog(null, "The cache has failed to download, error2, try again.", ClientConstants.getServerName(), JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, options, null);

			if (input == JOptionPane.OK_OPTION) {
				downloadCache("RETRY");
			}
		}
		return null;
	}

	private void downloadFile(String address, String localFileName, String location, String text) {
		RSApplet.shouldClearScreen = true;
		OutputStream out = null;
		URLConnection conn;
		InputStream in = null;
		try {
			URL url = new URL(address);
			out = new BufferedOutputStream(new FileOutputStream(location + ".zip"));

			conn = url.openConnection();
			in = conn.getInputStream();

			byte[] data = new byte[BUFFER];

			int numRead;


			while ((numRead = in.read(data)) != -1) {
				out.write(data, 0, numRead);
				long max = conn.getContentLength();
				long totalDownloaded = 0;
				byte[] b = new byte[1024];
				int len;
				long startup = System.currentTimeMillis();
				while ((len = in.read(b, 0, b.length)) > -1) {
					out.write(b, 0, len);
					totalDownloaded += len;

					try {
						long time = (System.currentTimeMillis() - startup) / 1000;
						kbps = (totalDownloaded / time) / 1024D;
					}
					catch (ArithmeticException e) {
						if (ClientDebugConfiguration.PRINT_ALL_EXCEPTION) {
							e.printStackTrace();
						}
					}

					setDownloadPercent(text, (int) ((totalDownloaded * 100) / max));
				}
			}
			Client.instance.drawLoadingTextCacheDownloader(100, "                 100% completed, extracting files.", true);

		}
		catch (Exception exception) {
			Utility.print("Address: " + address);
			exception.printStackTrace();
			error = true;
		}
		try {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
			error = true;
		}
	}

	public static boolean error;

	public static int percent = 0;

	public static void setDownloadPercent(String text, int amount) {
		percent = amount;

		String kbps = String.valueOf(CacheDownloader.kbps);

		if (kbps.contains(".")) {
			kbps = kbps.substring(0, kbps.indexOf('.'));
		}
		Client.instance.drawLoadingTextCacheDownloader(amount, text + ", " + amount + "% complete, average: " + kbps + " kbps", false);
	}

	private void unZip(String zipLocation, String zipName) {
		zipLocation = zipLocation + ".zip";
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(zipLocation));
			ZipInputStream zin = new ZipInputStream(in);
			ZipEntry e;
			String location = zipLocation.replace(zipName, "/");
			while ((e = zin.getNextEntry()) != null) {

				if (e.isDirectory()) {
					(new File(location + e.getName())).mkdir();
				}
				else {
					unzip(zin, location + e.getName());
				}
			}
			in.close();

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void unzip(ZipInputStream zin, String s) throws IOException {
		FileOutputStream out = new FileOutputStream(s);
		byte[] b = new byte[BUFFER];
		int len = 0;

		while ((len = zin.read(b)) != -1) {
			out.write(b, 0, len);
		}
		out.close();
	}

	private void deleteZIP(String fileName) {
		fileName = fileName + ".zip";
		File f = new File(fileName);
		if (!f.exists()) {
			Utility.print("Delete: no such file or directory: " + fileName);
		}

		if (!f.canWrite()) {
			Utility.print("Delete: write protected: " + fileName);
		}
		if (f.isDirectory()) {
			String[] files = f.list();
			if (files.length > 0) {
				Utility.print("Delete: directory not empty: " + fileName);
			}
		}
		boolean success = f.delete();
		if (!success) {
			Utility.print("Delete: deletion failed");
		}
	}
}