package Runecessor;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Download data from website, such as cache download link, client version etc..
 * @author Lava, created on 09-11-2017.
 */
public class WebsiteRead {

	public static String mainCacheDownloadLink = "https://www.dropbox.com/s/v185ri3bjajwbs2/osrscache.zip?dl=1";

	public static String spriteCacheDownloadLink = "https://www.dropbox.com/s/lwppval64jlm2nw/spriteosrs.zip?dl=1";

	public static int websiteClientLatestVersion = 0;

	public static String pvpIp = "127.0.0.1";

	public static String ecoIp = "35.237.60.151";

	public static int voteReward = 1000;

	public static int port = 43595;

	public static boolean error;
	private static ArrayList<String> websiteLines = new ArrayList<String>();

	public static void readWebsiteData() {
		if (ClientDebugConfiguration.DEBUG_MODE) {
			return;
		}

		error = false;
		error = readDataFile(ClientConstants.WEBSITE_DATA_LOCATION);
		if (error) {
			error = readDataFile(ClientConstants.WEBSITE_DATA_LOCATION.replace("http", "https"));
		}
		if (error) {
			error = readDataFile(ClientConstants.WEBSITE_DATA_LOCATION_DROPBOX_VERSION);
		}
		if (error) {
			error = readDataFile(ClientConstants.WEBSITE_DATA_LOCATION_DROPBOX_VERSION.replace("http", "https"));
		}
		if (error) {
			Object[] options =
			{"Continue", "", "", ""};
			int option = JOptionPane.showOptionDialog(null, "Click continue!.", "Client", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, options, null);

			String link = "";
			switch (option) {
				case 1:
					link = "";
					break;
				case 2:
					link = "";
					break;
				case 3:
					link = "";
					break;
			}
			if (!link.isEmpty()) {
				try {
					Desktop.getDesktop().browse(new URI(link));
				}
				catch (IOException | URISyntaxException e1) {
					e1.printStackTrace();
				}
			}
		}
		else {
			for (int index = 0; index < websiteLines.size(); index++) {
				String string = websiteLines.get(index);
				String type = string.substring(0, string.indexOf("="));
				String text = string.replace(type + "=", "");
				switch (type) {
					case "mainCacheDownloadLink":
						mainCacheDownloadLink = text;
						break;
					case "spriteCacheDownloadLink":
						spriteCacheDownloadLink = text;
						break;
					case "pvpIp":
						pvpIp = text;
						break;
					case "ecoIp":
						ecoIp = text;
						break;
					case "websiteClientLatestVersion":
						websiteClientLatestVersion = Integer.parseInt(text);
						break;
					case "port":
						port = Integer.parseInt(text);
						break;
				}
				if (Config.PVP) {
					switch (type) {
						case "voteReward":
							voteReward = Integer.parseInt(text);
							break;
					}
				}
				else {
					switch (type) {
						case "voteRewardEco":
							voteReward = Integer.parseInt(text);
							break;
					}
				}
			}
		}
	}

	private static boolean readDataFile(String websiteUrl) {
		boolean error = false;
		websiteLines.clear();
		try {
			URL tmp = new URL(websiteUrl);
			BufferedReader br = new BufferedReader(new InputStreamReader(tmp.openStream()));
			String inputLine;

			boolean firstLineRead = false;
			while ((inputLine = br.readLine()) != null) {
				if (!inputLine.startsWith("websiteClientLatestVersion") && !firstLineRead) {
					error = true;
					break;
				}
				websiteLines.add(inputLine);
				firstLineRead = true;
			}
		} catch (IOException e) {
			e.printStackTrace();
			error = true;
		}
		return error;
	}
}
