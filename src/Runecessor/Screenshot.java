package Runecessor;

import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Window;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;

/**
 * Screenshot system.
 * @author Lava, created on 19-11-2016.
 */
public class Screenshot extends Thread {

	public String screenshotName;

	public String saveLocation;

	public Screenshot(String screenshotName, String saveLocation) {
		this.screenshotName = screenshotName;
		this.saveLocation = saveLocation;
	}

	@Override
	public void run() {
		takeScreenshot(screenshotName, saveLocation);
	}

	public static long screenShotTime;

	static Object test = new Object();

	public static boolean canScreenshot() {
		synchronized (test) {
			if (System.currentTimeMillis() - screenShotTime < 500) {
				return false;
			}
			screenShotTime = System.currentTimeMillis();
			return true;
		}
	}

	public static void takeScreenshot(String name, String saveLocation) {
		if (name.isEmpty()) {
			if (!canScreenshot()) {
				return;
			}
		}
		try {
			Window window = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusedWindow();
			if (window == null) {
				return;
			}
			Point point = window.getLocationOnScreen();
			if (point == null) {
				return;
			}
			int x = (int) point.getX();
			int y = (int) point.getY();
			int w = window.getWidth();
			int h = window.getHeight();
			Robot robot = new Robot(window.getGraphicsConfiguration().getDevice());
			//Rectangle captureSize = new Rectangle(x + 3, y + 22, w - 6, h - 25); // Old laptop
			//Rectangle captureSize = new Rectangle(x + 3, y + 26, w - 6, h - 29); // New laptop.
			Rectangle captureSize = null;
			if (Client.isFixedScreen()) {
				if (Client.osName.equals("Windows 7")) {
					captureSize = new Rectangle(x + 3, y + 22, w - 6, h - 25);

				}
				else {
					captureSize = new Rectangle(x + 3, y + 26, w - 6, h - 29);
				}
			}
			else {
				if (Client.osName.equals("Windows 7")) {
					captureSize = new Rectangle(x + 3, y + 22, w - 6, h - 25);

				}
				else {
					captureSize = new Rectangle(x + 8, y + 31, w - 16, h - 39);
				}
			}
			java.awt.image.BufferedImage bufferedimage = robot.createScreenCapture(captureSize);
			String imagePath = ClientConstants.getRunecessorFolderLocation();
			String fullImagePath = "";

			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Calendar cal = Calendar.getInstance();
			String dateName = dateFormat.format(cal.getTime());
			if (!name.isEmpty()) {
				fullImagePath = imagePath + saveLocation + "/" + "" + ClientConstants.getServerName().toLowerCase() + "_" + Client.screenShotNumber + "_" + name + "_date_" + dateName + ".png";
			}
			else {
				fullImagePath = imagePath + saveLocation + "/" + "" + ClientConstants.getServerName().toLowerCase() + "_" + Client.screenShotNumber + "_date_" + dateName + ".png";
			}
			File folder = new File(fullImagePath);
			if (!folder.exists()) {
				folder.mkdir();
			}
			File file = new File(fullImagePath);
			ImageIO.write(bufferedimage, "png", file);
			if (!saveLocation.equals("kill_screenshots")) {
				Client.instance.pushMessage(fullImagePath, ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
			}
			Screenshot.saveScreenshotNumber();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void saveScreenshotNumber() {
		Client.screenShotNumber++;
		try {
			FileOutputStream writer = new FileOutputStream(ClientConstants.getScreenShotLocation());
			writer.write((new String()).getBytes());
			writer.close();

		}
		catch (IOException ex) {
			ex.printStackTrace();
		}

		try {
			BufferedWriter bw = null;
			bw = new BufferedWriter(new FileWriter(ClientConstants.getScreenShotLocation(), true));
			bw.write(Client.screenShotNumber + "");
			bw.newLine();
			bw.flush();
			bw.close();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static void loadScreenShotNumber() {
		File location = new File(ClientConstants.getScreenShotLocation());
		if (!location.exists()) {
			return;
		}
		try {
			BufferedReader file = new BufferedReader(new FileReader(ClientConstants.getScreenShotLocation()));
			String line;
			while ((line = file.readLine()) != null) {
				if (!line.isEmpty()) {
					Client.screenShotNumber = Integer.parseInt(line);
				}
			}
			file.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
