package Runecessor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Handle client settings.
 * @author Lava.
 */
public class Settings {

	private static String fileLine = "";

	public static String fileText;

	public static String location;

	static int PRIVATE_MESSAGE = 65535;

	static int PLAYER_TITLE = 0x255;

	static int YELL = 65535;

	private static void createLastSelectedDataFile(String location1) {
		File location = new File(location1);
		if (location.exists()) {
			return;
		}
		try {
			location.createNewFile();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void createSettingsFileJframe(String location1) {
		File dtFolder = new File(ClientConstants.getRunecessorFolderLocation());
		if (!dtFolder.exists()) {
			dtFolder.mkdir();
		}
		File thirdFolder3 = new File(ClientConstants.getRunecessorFolderLocation() + "settings");
		if (!thirdFolder3.exists()) {
			thirdFolder3.mkdir();
		}
		File location = new File(location1);
		if (location.exists()) {
			return;
		}
		try {
			location.createNewFile();
			saveSettingsJframe();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void createSettingsFile(String location1) {
		File location = new File(location1);
		if (location.exists()) {
			return;
		}
		try {
			saveSettings();
			location.createNewFile();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static boolean contains(String match) {
		String string = fileLine.substring(0, fileLine.indexOf(" = "));
		if (string.equals(match)) {
			return true;
		}
		return false;
	}

	private static boolean readBoolean() {
		fileLine = fileLine.substring(fileLine.lastIndexOf("=") + 2);
		if (fileLine.equals("true")) {
			return true;
		}
		return false;
	}

	private static String readString() {
		fileLine = fileLine.substring(fileLine.indexOf("=") + 2);
		return fileLine;
	}


	private static int readInt() {
		fileLine = fileLine.substring(fileLine.lastIndexOf("=") + 2);
		return Integer.parseInt(fileLine);
	}

	private static Double readDouble() {
		fileLine = fileLine.substring(fileLine.lastIndexOf("=") + 2);
		return Double.parseDouble(fileLine);
	}

	public static void loadLastDataSelected() {
		String location = ClientConstants.getRunecessorFolderLocation() + "settings/" + "last_data_selected.txt";
		createLastSelectedDataFile(location);

		try {
			BufferedReader file = new BufferedReader(new FileReader(location));
			String line;
			while ((line = file.readLine()) != null) {
				fileLine = line;
				if (contains("lastDataSelected")) {
					Client.lastDataSelected = readString();
				}

			}
			file.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void saveLastDataSelected() {
		String location = ClientConstants.getRunecessorFolderLocation() + "settings/" + "last_data_selected.txt";
		BufferedWriter bw = null;
		try {
			// Clear file contents.
			FileOutputStream writer = new FileOutputStream(location);
			writer.write((new String()).getBytes());
			writer.close();

			// Write new contents.
			bw = new BufferedWriter(new FileWriter(location, true));

			writeLine("lastDataSelected", Client.lastDataSelected, bw);

			bw.flush();
			bw.close();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static void loadSettings() {
		fileText = "settings474.txt";
		location = ClientConstants.getRunecessorFolderLocation() + "settings/" + fileText;
		createSettingsFile(location);

		try {
			BufferedReader file = new BufferedReader(new FileReader(location));
			String line;
			while ((line = file.readLine()) != null) {
				fileLine = line;
				if (contains("savedUsername")) {
					Client.savedUsername = readString();
				}
				// Old un-encrypted passwords
				else if (contains("savedPassword")) {
					Client.savedPassword = Client.encrypt(readString());
				}
				else if (contains("savedPassword1")) {
					Client.savedPassword = readString();
				}
				else if (contains("rememberMe")) {
					Client.rememberMe = readBoolean();
				}
				else if (contains("cameraSpeed")) {
					Client.cameraSpeed = readString();
				}
				else if (contains("hitsplatRevision")) {
					Client.hitsplatRevision = readString();
				}
				else if (contains("worldGraphicsMode")) {
					Client.worldGraphicsMode = readString();
				}
				else if (contains("overlayTextSize1")) {
					Client.overlayTextSize = readInt();
				}
				else if (contains("npcAttackOptions")) {
					Client.npcAttackOptions = readInt();
				}
				else if (contains("playerAttackOptions1")) {
					Client.playerAttackOptions = readInt();
				}
				else if (contains("overlayValueToShow")) {
					Client.customValueToShow = readInt();
				}
				else if (contains("fog")) {
					Client.fog = readString();
				}
				else if (contains("loop")) {
					Client.loop = readBoolean();
				}
				else if (contains("autoMusic")) {
					Client.autoMusic = readBoolean();
				}
				else if (contains("transparentTab")) {
					Client.transparentTab = readBoolean();
				}
				else if (contains("transparentChat")) {
					Client.transparentChat = readBoolean();
				}
				else if (contains("noClip")) {
					Client.noClip = readBoolean();
				}
				else if (contains("itemRarityColour")) {
					Client.itemRarityColour = readBoolean();
				}
				else if (contains("displayItemOverlayValue")) {
					Client.displayItemOverlayValue = readBoolean();
				}
				else if (contains("hideNoValueItems")) {
					Client.hideNoValueItems = readBoolean();
				}
				else if (contains("displayGroundItemAmount")) {
					Client.displayGroundItemAmount = readBoolean();
				}
				else if (contains("groundItemOverlay")) {
					Client.groundItemOverlay = readBoolean();
				}
				else if (contains("groundSnow1")) {
					Client.groundSnow = readBoolean();
				}
				else if (contains("lightSnow1")) {
					Client.lightSnow = readBoolean();
				}
				else if (contains("snowParticles2")) {
					Client.snowParticles = readBoolean();
				}
				else if (contains("toggleTrees1")) {
					Client.toggleTrees = readBoolean();
				}
				else if (contains("toggleItems7")) {
					Client.toggleItems = readBoolean();
				}
				else if (contains("coordinatesDisplay")) {
					Client.coordinatesDisplay = readBoolean();
				}
				else if (contains("clientData")) {
					Client.clientData = readBoolean();
				}
				else if (contains("osrsXpOrbMiddle")) {
					Client.osrsXpOrbMiddle = readBoolean();
				}
				else if (contains("useOldWildernessInterface")) {
					Client.useOldWildernessInterface = readBoolean();
				}
				else if (contains("smoothMiniMap")) {
					Client.smoothMiniMap = readBoolean();
				}
				else if (contains("movingWater")) {
					Client.movingWater = readBoolean();
				}
				else if (contains("smoothShadow")) {
					Client.smoothShadow = readBoolean();
				}
				else if (contains("tweening")) {
					Client.tweening = readBoolean();
				}
				else if (contains("newCompass")) {
					Client.newCompass = readBoolean();
				}
				else if (contains("smoothCharacterTurn")) {
					Client.smoothCharacterTurn = readBoolean();
				}
				else if (contains("hdFloorTexturing")) {
					Client.otherFloorTexturing = readBoolean();
				}
				else if (contains("x10Damage")) {
					Client.x10Damage = readBoolean();
				}
				else if (contains("is498GameFrame")) {
					Client.is498GameFrame = readBoolean();
				}
				else if (contains("is508PlusGameFrame")) {
					Client.is508PlusGameFrame = readBoolean();
				}
				else if (contains("is562PlusGameFrame")) {
					Client.is562PlusGameFrame = readBoolean();
				}
				else if (contains("is317GameFrame1")) {
					Client.is317GameFrame = readBoolean();
				}
				else if (contains("newClick")) {
					Client.newClick = readBoolean();
				}
				else if (contains("nameAbove")) {
					Client.nameAbove = readBoolean();
				}
				else if (contains("mouseRightClickFix")) {
					Client.mouseRightClickFix = readBoolean();
				}
				else if (contains("filtered")) {
					Client.filtered = readBoolean();
				}
				else if (contains("counterOn")) {
					Client.counterOn = readBoolean();
				}
				else if (contains("titlesInWild")) {
					Client.titlesInWild = readBoolean();
				}
				else if (contains("newFont")) {
					Client.newFont = readBoolean();
				}
				else if (contains("is474PlusGameFrame")) {
					Client.isOSRSGameFrame = readBoolean();
				}
				else if (contains("enableRoof")) {
					Client.enableRoof = readBoolean();
				}
				else if (contains("mouseScroll")) {
					Client.mouseScroll = readBoolean();
				}
				else if (contains("overlayTimers")) {
					Client.overlayTimers = readBoolean();
				}
				else if (contains("hpOverlayOn")) {
					Client.hpOverlayOn = readBoolean();
				}
				else if (contains("disableSummoningOrb")) {
					Client.disableSpecOrb = readBoolean();
				}
				else if (contains("smoothShading1")) {
					Client.smoothShading = readBoolean();
				}
				else if (contains("is474GameFrame")) {
					Client.is474GameFrame = readBoolean();
				}
				else if (contains("is525GameFrame")) {
					Client.is525GameFrame = readBoolean();
				}
				else if (contains("is562GameFrame")) {
					Client.is562GameFrame = readBoolean();
				}
				else if (contains("newHitPointsBar")) {
					Client.newHitPointsBar = readBoolean();
				}
				else if (contains("contextMenu")) {
					Client.contextMenu = readString();
				}
				else if (contains("experienceOrb")) {
					Client.experienceOrb = readBoolean();
				}
				else if (contains("fpsOn")) {
					Client.fpsOn = readBoolean();
				}
				else if (contains("showQuestionMark")) {
					Client.showQuestionMark = readBoolean();
				}
				else if (contains("old562GameFrame")) {
					Client.old562GameFrame = readBoolean();
				}
				else if (contains("isInDetailedSettingsInterface")) {
					Client.isInDetailedSettingsInterface = readBoolean();
				}
				else if (contains("shiftDrop")) {
					Client.shiftDrop = readBoolean();
				}
				else if (contains("kdrOverlay1")) {
					Client.kdrOverlay = readBoolean();
				}
				else if (contains("volume")) {
					SoundPlayer.setVolume(readInt(), true, false);
				}
				else if (contains("CameraPos2")) {
					Client.CameraPos2 = readInt();
				}
				else if (contains("questTabOpenedTab")) {
					Client.questTabOpenedTab = readInt();
				}
				else if (contains("isCursor")) {
					Client.isCursor = readInt();
				}
				else if (contains("brightness")) {
					Client.brightness = readInt();
				}
				else if (contains("musicVolume")) {
					Client.musicVolume = readInt();
				}
				else if (contains("draggingSensitivity")) {
					Client.draggingSensitivity = readInt();
				}
				else if (contains("combatTabFKey")) {
					Client.combatTabFKey = readInt();
				}
				else if (contains("equipmentTabFKey")) {
					Client.equipmentTabFKey = readInt();
				}
				else if (contains("inventoryTabFKey")) {
					Client.inventoryTabFKey = readInt();
				}
				else if (contains("magicTabFKey")) {
					Client.magicTabFKey = readInt();
				}
				else if (contains("prayerTabFKey")) {
					Client.prayerTabFKey = readInt();
				}
				else if (contains("screenshotFKey")) {
					Client.screenshotFKey = readInt();
				}
				else if (contains("settingsPage")) {
					Client.settingsPage = readInt();
				}
				else if (contains("combatTabFKeyName")) {
					Client.combatTabFKeyName = readString();
				}
				else if (contains("equipmentTabFKeyName")) {
					Client.equipmentTabFKeyName = readString();
				}
				else if (contains("inventoryTabFKeyName")) {
					Client.inventoryTabFKeyName = readString();
				}
				else if (contains("magicTabFKeyName")) {
					Client.magicTabFKeyName = readString();
				}
				else if (contains("prayerTabFKeyName")) {
					Client.prayerTabFKeyName = readString();
				}
				else if (contains("screenshotFKeyName")) {
					Client.screenshotFKeyName = readString();
				}
				else if (contains("inventoryLayout")) {
					Client.inventoryLayout = readString();
				}
				else if (contains("hideInventoryInterface")) {
					Client.hideInventoryInterface = readBoolean();
				}
				else if (contains("raidPrayersSwitch")) {
					Client.raidPrayersSwitch = readBoolean();
				}
			}
			file.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void loadSettingsJframe() {
		String fileText = "settings_frame.txt";
		String location = ClientConstants.getRunecessorFolderLocation() + "settings/" + fileText;
		createSettingsFileJframe(location);

		try {
			BufferedReader file = new BufferedReader(new FileReader(location));
			String line;
			while ((line = file.readLine()) != null) {
				fileLine = line;
				if (contains("isFixedScreenSaved")) {
					Client.isFixedScreenSaved = readBoolean();
				}
				else if (contains("clientWidthSaved")) {
					Client.clientWidthSaved = readInt();
				}
				else if (contains("clientHeightSaved")) {
					Client.clientHeightSaved = readInt();
				}
				else if (contains("clientFixedLocationX")) {
					Client.clientFixedLocationX = readDouble();
				}
				else if (contains("clientFixedLocationY")) {
					Client.clientFixedLocationY = readDouble();
				}
				else if (contains("clientResizedLocationX")) {
					Client.clientResizedLocationX = readDouble();
				}
				else if (contains("clientResizedLocationY")) {
					Client.clientResizedLocationY = readDouble();
				}
				else if (contains("clientMaximized")) {
					Client.clientMaximized = readBoolean();
				}
				else if (contains("maximizable")) {
					Client.maximizable = readBoolean();
				}
				else if (contains("maximizableWidth")) {
					Client.maximizableWidth = readInt();
				}
				else if (contains("maximizableHeight")) {
					Client.maximizableHeight = readInt();
				}
				else if (contains("loadFullscreenNextStartup")) {
					Client.loadFullscreenNextStartup = readBoolean();
				}
				else if (contains("disableFullscreenModeNextStartup")) {
					Client.disableFullscreenModeNextStartup = readBoolean();
				}
				else if (contains("fullscreenMode")) {
					Client.fullscreenMode = readBoolean();
				}
			}
			file.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		if (Client.loadFullscreenNextStartup) {
			Client.fullscreenMode = true;
			Client.isFixedScreenSaved = false;
		}
		if (Client.fullscreenMode) {
			Client.fullscreenModeOnStartUp = true;
		}
		if (Client.disableFullscreenModeNextStartup) {
			Client.disableFullscreenModeNextStartup = false;
			Client.fullscreenMode = false;

		}
		Client.loadFullscreenNextStartup = false;
	}

	public static void saveSettingsJframe() {
		String fileText = "settings_frame.txt";
		String location = ClientConstants.getRunecessorFolderLocation() + "settings/" + fileText;
		BufferedWriter bw = null;
		try {
			// Clear file contents.
			FileOutputStream writer = new FileOutputStream(location);
			writer.write((new String()).getBytes());
			writer.close();

			// Write new contents.
			bw = new BufferedWriter(new FileWriter(location, true));

			writeLine("isFixedScreenSaved", Client.isFixedScreenSaved, bw);
			writeLine("clientWidthSaved", Client.clientWidthSaved, bw);
			writeLine("clientHeightSaved", Client.clientHeightSaved, bw);
			if (Client.isFixedScreen() && ClientFrame.frame != null) {
				Client.clientFixedLocationX = ClientFrame.frame.getLocation().getX();
				Client.clientFixedLocationY = ClientFrame.frame.getLocation().getY();
				writeLine("clientFixedLocationX", Client.clientFixedLocationX, bw);
				writeLine("clientFixedLocationY", Client.clientFixedLocationY, bw);
				writeLine("clientResizedLocationX", Client.clientResizedLocationX, bw);
				writeLine("clientResizedLocationY", Client.clientResizedLocationY, bw);
			}
			else if (!Client.isFixedScreen()) {
				if (System.currentTimeMillis() - Client.clientMaximimzedTime >= 500) {
					if (!Client.clientIgnoreLocationSave && !Client.clientMaximized) {
						if (ClientFrame.frame != null) {
							Client.clientResizedLocationX = ClientFrame.frame.getLocation().getX();
							Client.clientResizedLocationY = ClientFrame.frame.getLocation().getY();
						}
					}
				}
				writeLine("clientFixedLocationX", Client.clientFixedLocationX, bw);
				writeLine("clientFixedLocationY", Client.clientFixedLocationY, bw);
				writeLine("clientResizedLocationX", Client.clientResizedLocationX, bw);
				writeLine("clientResizedLocationY", Client.clientResizedLocationY, bw);
			}

			writeLine("clientMaximized", Client.clientMaximized, bw);
			writeLine("maximizable", Client.maximizable, bw);
			writeLine("maximizableWidth", Client.maximizableWidth, bw);
			writeLine("maximizableHeight", Client.maximizableHeight, bw);
			writeLine("loadFullscreenNextStartup", Client.loadFullscreenNextStartup, bw);
			writeLine("disableFullscreenModeNextStartup", Client.disableFullscreenModeNextStartup, bw);
			writeLine("fullscreenMode", Client.fullscreenMode, bw);
			bw.flush();
			bw.close();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static void saveSettings() {
		if (location == null) {
			return;
		}
		BufferedWriter bw = null;
		try {
			// Clear file contents.
			FileOutputStream writer = new FileOutputStream(location);
			writer.write((new String()).getBytes());
			writer.close();

			// Write new contents.
			bw = new BufferedWriter(new FileWriter(location, true));

			writeLine("savedUsername", Client.savedUsername, bw);
			writeLine("savedPassword1", Client.savedPassword, bw);
			writeLine("rememberMe", Client.rememberMe, bw);
			writeLine("hitsplatRevision", Client.hitsplatRevision, bw);
			writeLine("cameraSpeed", Client.cameraSpeed, bw);
			writeLine("worldGraphicsMode", Client.worldGraphicsMode, bw);
			writeLine("overlayTextSize1", Client.overlayTextSize, bw);
			writeLine("npcAttackOptions", Client.npcAttackOptions, bw);
			writeLine("playerAttackOptions1", Client.playerAttackOptions, bw);
			writeLine("overlayValueToShow", Client.customValueToShow, bw);
			writeLine("fog", Client.fog, bw);
			writeLine("loop", Client.loop, bw);
			writeLine("autoMusic", Client.autoMusic, bw);
			writeLine("noClip", Client.noClip, bw);
			writeLine("itemRarityColour", Client.itemRarityColour, bw);
			writeLine("displayItemOverlayValue", Client.displayItemOverlayValue, bw);
			writeLine("hideNoValueItems", Client.hideNoValueItems, bw);
			writeLine("displayGroundItemAmount", Client.displayGroundItemAmount, bw);
			writeLine("groundItemOverlay", Client.groundItemOverlay, bw);
			writeLine("groundSnow1", Client.groundSnow, bw);
			writeLine("lightSnow1", Client.lightSnow, bw);
			writeLine("toggleTrees1", Client.toggleTrees, bw);
			writeLine("snowParticles2", Client.snowParticles, bw);
			writeLine("toggleItems7", Client.toggleItems, bw);
			writeLine("coordinatesDisplay", Client.coordinatesDisplay, bw);
			writeLine("mouseRightClickFix", Client.mouseRightClickFix, bw);
			writeLine("clientData", Client.clientData, bw);
			writeLine("osrsXpOrbMiddle", Client.osrsXpOrbMiddle, bw);
			writeLine("useOldWildernessInterface", Client.useOldWildernessInterface, bw);
			writeLine("smoothMiniMap", Client.smoothMiniMap, bw);
			writeLine("movingWater", Client.movingWater, bw);
			writeLine("smoothShadow", Client.smoothShadow, bw);
			writeLine("tweening", Client.tweening, bw);
			writeLine("newCompass", Client.newCompass, bw);
			writeLine("smoothCharacterTurn", Client.smoothCharacterTurn, bw);
			writeLine("hdFloorTexturing", Client.otherFloorTexturing, bw);
			writeLine("x10Damage", Client.x10Damage, bw);
			writeLine("is498GameFrame", Client.is498GameFrame, bw);
			writeLine("is508PlusGameFrame", Client.is508PlusGameFrame, bw);
			writeLine("is317GameFrame1", Client.is317GameFrame, bw);
			writeLine("is562PlusGameFrame", Client.is562PlusGameFrame, bw);
			writeLine("newClick", Client.newClick, bw);
			writeLine("nameAbove", Client.nameAbove, bw);
			writeLine("filtered", Client.filtered, bw);
			writeLine("titlesInWild", Client.titlesInWild, bw);
			writeLine("newFont", Client.newFont, bw);
			writeLine("is474PlusGameFrame", Client.isOSRSGameFrame, bw);
			writeLine("enableRoof", Client.enableRoof, bw);
			writeLine("mouseScroll", Client.mouseScroll, bw);
			writeLine("counterOn", Client.counterOn, bw);
			writeLine("overlayTimers", Client.overlayTimers, bw);
			writeLine("hpOverlayOn", Client.hpOverlayOn, bw);
			writeLine("disableSummoningOrb", Client.disableSpecOrb, bw);
			writeLine("smoothShading1", Client.smoothShading, bw);
			writeLine("is474GameFrame", Client.is474GameFrame, bw);
			writeLine("is525GameFrame", Client.is525GameFrame, bw);
			writeLine("is562GameFrame", Client.is562GameFrame, bw);
			writeLine("newHitPointsBar", Client.newHitPointsBar, bw);
			writeLine("contextMenu", Client.contextMenu, bw);
			writeLine("experienceOrb", Client.experienceOrb, bw);
			writeLine("fpsOn", Client.fpsOn, bw);
			writeLine("volume", SoundPlayer.getVolume(), bw);
			writeLine("CameraPos2", Client.CameraPos2, bw);
			writeLine("questTabOpenedTab", Client.questTabOpenedTab, bw);
			writeLine("isCursor", Client.isCursor, bw);
			writeLine("brightness", Client.brightness, bw);
			writeLine("musicVolume", Client.musicVolume, bw);
			writeLine("draggingSensitivity", Client.draggingSensitivity, bw);
			writeLine("combatTabFKey", Client.combatTabFKey, bw);
			writeLine("equipmentTabFKey", Client.equipmentTabFKey, bw);
			writeLine("inventoryTabFKey", Client.inventoryTabFKey, bw);
			writeLine("magicTabFKey", Client.magicTabFKey, bw);
			writeLine("prayerTabFKey", Client.prayerTabFKey, bw);
			writeLine("screenshotFKey", Client.screenshotFKey, bw);
			writeLine("settingsPage", Client.settingsPage, bw);
			writeLine("showQuestionMark", Client.showQuestionMark, bw);
			writeLine("isInDetailedSettingsInterface", Client.isInDetailedSettingsInterface, bw);
			writeLine("old562GameFrame", Client.old562GameFrame, bw);
			writeLine("shiftDrop", Client.shiftDrop, bw);
			writeLine("kdrOverlay1", Client.kdrOverlay, bw);
			writeLine("combatTabFKeyName", Client.combatTabFKeyName, bw);
			writeLine("equipmentTabFKeyName", Client.equipmentTabFKeyName, bw);
			writeLine("inventoryTabFKeyName", Client.inventoryTabFKeyName, bw);
			writeLine("magicTabFKeyName", Client.magicTabFKeyName, bw);
			writeLine("prayerTabFKeyName", Client.prayerTabFKeyName, bw);
			writeLine("screenshotFKeyName", Client.screenshotFKeyName, bw);
			writeLine("inventoryLayout", Client.inventoryLayout, bw);
			writeLine("hideInventoryInterface", Client.hideInventoryInterface, bw);
			writeLine("raidPrayersSwitch", Client.raidPrayersSwitch, bw);
			bw.flush();
			bw.close();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private static void writeLine(String line, String line1, BufferedWriter bw) {
		try {
			bw.write(line + " = " + line1);
			bw.newLine();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void writeLine(String line, Boolean line1, BufferedWriter bw) {
		try {
			bw.write(line + " = " + line1);
			bw.newLine();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void writeLine(String line, Double line1, BufferedWriter bw) {
		try {
			bw.write(line + " = " + line1);
			bw.newLine();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void writeLine(String line, int line1, BufferedWriter bw) {
		try {
			bw.write(line + " = " + line1);
			bw.newLine();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is called after the Client Settings .dat file has been
	 * loaded.. Update the client depending on the loaded Client Settings.
	 */
	public static void updateClientSettings() {
		updateBrightness();
		SoundPlayer.setVolume(SoundPlayer.getVolume(), false, false);
		Client.hdMinimap = Client.otherFloorTexturing;
		FogHandler.adjustFogEndDistance();
		FogHandler.updateFogColour();
		updateSettingsInterfaceText();

		if (!Client.disableSpecOrb) {
			Client.specOrb = true;
		}
		int buttonId = -1;
		if (Client.groundItemOverlay) {
			buttonId = 40001;
			Client.setInterfaceClicked(40000, buttonId, true, false);
		}
		if (Client.itemRarityColour) {
			buttonId = 40004;
			Client.setInterfaceClicked(40000, buttonId, true, false);
		}
		if (Client.displayItemOverlayValue) {
			buttonId = 40007;
			Client.setInterfaceClicked(40000, buttonId, true, false);
		}
		if (Client.hideNoValueItems) {
			buttonId = 40010;
			Client.setInterfaceClicked(40000, buttonId, true, false);
		}
		if (Client.displayGroundItemAmount) {
			buttonId = 40013;
			Client.setInterfaceClicked(40000, buttonId, true, false);
		}
		if (Client.overlayTextSize == 0) {
			buttonId = 40016;
			Client.setInterfaceClicked(40001, buttonId, true, true);
		}
		if (Client.overlayTextSize == 1) {
			buttonId = 40019;
			Client.setInterfaceClicked(40001, buttonId, true, true);
		}
		if (Client.overlayTextSize == 2) {
			buttonId = 40022;
			Client.setInterfaceClicked(40001, buttonId, true, true);
		}
	}

	private static void updateSettingsInterfaceText() {
		if (Client.is317GameFrame) {
			Client.instance.sendFrame126("Gameframe: @gr3@317", 17313);
		}
		else if (Client.is525GameFrame) {
			Client.instance.sendFrame126("Gameframe: @gr3@525", 17313);
		}
		else if (Client.is562GameFrame && Client.old562GameFrame) {
			Client.instance.sendFrame126("Gameframe: @gr3@562 old", 17313);
		}
		else if (Client.is562GameFrame && Client.showQuestionMark) {
			Client.instance.sendFrame126("Gameframe: @gr3@562+", 17313);
		}
		else if (Client.is562GameFrame) {
			Client.instance.sendFrame126("Gameframe: @gr3@562", 17313);
		}
		else if (Client.is562PlusGameFrame & Client.newCompass) {
			Client.instance.sendFrame126("Gameframe: @gr3@562+++", 17313);
		}
		else if (Client.is562PlusGameFrame) {
			Client.instance.sendFrame126("Gameframe: @gr3@562++", 17313);
		}
		else if (Client.is474GameFrame && !Client.isOSRSGameFrame) {
			Client.instance.sendFrame126("Gameframe: @gr3@474", 17313);
		}
		else if (Client.isOSRSGameFrame) {
			Client.instance.sendFrame126("Gameframe: @gr3@OSRS", 17313);
		}
		else if (Client.is498GameFrame) {
			Client.instance.sendFrame126("Gameframe: @gr3@498", 17313);
		}
		else if (Client.is508PlusGameFrame) {
			Client.instance.sendFrame126("Gameframe: @gr3@508", 17313);
		}

		String text = "";
		switch (Client.contextMenu) {
			case "OLD":
				text = "Old";
				break;
			case "OLD HOVER":
				text = "Old hover";
				break;
			case "NEW":
				text = "New";
				break;
		}
		Client.instance.sendFrame126("Menu: @gr3@" + text, 17321);

		Client.instance.sendFrame126("Hitsplats: @gr3@" + Client.hitsplatRevision, 17317);
		switch (Client.CameraPos2) {
			case 400:
				Client.instance.sendFrame126("Zoom: @gr3@Very Close", 17354);
				break;
			case 500:
				Client.instance.sendFrame126("Zoom: @gr3@Close", 17354);
				break;
			case 600:
				Client.instance.sendFrame126("Zoom: @gr3@Normal", 17354);
				break;
			case 700:
				Client.instance.sendFrame126("Zoom: @gr3@Far", 17354);
				break;
			case 800:
				Client.instance.sendFrame126("Zoom: @gr3@Very far", 17354);
				break;
		}
		if (Camera.CameraData.SUPER_SLOW.toString().equals(Client.cameraSpeed)) {
			Client.instance.sendFrame126("Cam speed: @gr3@Super Slow", 17358);
		}
		else if (Camera.CameraData.SLOW.toString().equals(Client.cameraSpeed)) {
			Client.instance.sendFrame126("Cam speed: @gr3@Slow", 17358);
		}
		else if (Camera.CameraData.MEDIUM.toString().equals(Client.cameraSpeed)) {
			Client.instance.sendFrame126("Cam speed: @gr3@Medium", 17358);
		}
		else if (Camera.CameraData.FAST.toString().equals(Client.cameraSpeed)) {
			Client.instance.sendFrame126("Cam speed: @gr3@Fast", 17358);
		}
		else if (Camera.CameraData.VERY_FAST.toString().equals(Client.cameraSpeed)) {
			Client.instance.sendFrame126("Cam speed: @gr3@Fast+", 17358);
		}
		else if (Camera.CameraData.EXTREMELY_FAST.toString().equals(Client.cameraSpeed)) {
			Client.instance.sendFrame126("Cam speed: @gr3@Fast++", 17358);
		}
		if (Client.worldGraphicsMode.equals("HIGH")) {
			Client.instance.sendFrame126("Detail: @gr3@High", 17383);
		}
		else if (Client.worldGraphicsMode.equals("MEDIUM")) {
			Client.instance.sendFrame126("Detail: @gr3@Medium", 17383);
		}
		else {
			Client.instance.sendFrame126("Detail: @gr3@Low", 17383);
		}
		switch (Client.fog) {
			case "OFF BLACK":
				Client.instance.sendFrame126("Fog: @gr3@Off black", 17391);
				break;
			case "OFF WHITE":
				Client.instance.sendFrame126("Fog: @gr3@Off white", 17391);
				break;
			case "DEFAULT":
				Client.instance.sendFrame126("Fog: @gr3@Default", 17391);
				break;
			case "SKY":
				Client.instance.sendFrame126("Fog: @gr3@Sky", 17391);
				break;
			case "DAWN":
				Client.instance.sendFrame126("Fog: @gr3@Dawn", 17391);
				break;
			case "NIGHT":
				Client.instance.sendFrame126("Fog: @gr3@Night", 17391);
				break;
		}

		Client.instance.sendFrame126("Combat: @gr3@" + Client.combatTabFKeyName, 26015);
		Client.instance.sendFrame126("Inventory: @gr3@" + Client.inventoryTabFKeyName, 26019);
		Client.instance.sendFrame126("Equipment: @gr3@" + Client.equipmentTabFKeyName, 26023);
		Client.instance.sendFrame126("Prayer: @gr3@" + Client.prayerTabFKeyName, 26027);
		Client.instance.sendFrame126("Magic: @gr3@" + Client.magicTabFKeyName, 26031);
		Client.instance.sendFrame126("Screenshot: @gr3@" + Client.screenshotFKeyName, 26035);
	}

	/**
	 * Update the client brightness on client start-up depending on the settting.
	 */
	private static void updateBrightness() {
		Client.instance.variousSettings[166] = Client.brightness;
		Client.instance.handleVarp(166);
	}


	/**
	 * Perform the action of the settings button.
	 * @param button
	 */
	public static boolean settingButton(int button) {
		switch (button) {

			case 26012:
				Client.combatTabFKey = changeHotKey("Combat", Client.combatTabFKey, button + 3);
				Client.combatTabFKeyName = getHotKeyName(Client.combatTabFKey);
				Settings.saveSettings();
				return true;
			case 26016:
				Client.inventoryTabFKey = changeHotKey("Inventory", Client.inventoryTabFKey, button + 3);
				Client.inventoryTabFKeyName = getHotKeyName(Client.inventoryTabFKey);
				Settings.saveSettings();
				return true;
			case 26020:
				Client.equipmentTabFKey = changeHotKey("Equipment", Client.equipmentTabFKey, button + 3);
				Client.equipmentTabFKeyName = getHotKeyName(Client.equipmentTabFKey);
				Settings.saveSettings();
				return true;
			case 26024:
				Client.prayerTabFKey = changeHotKey("Prayer", Client.prayerTabFKey, button + 3);
				Client.prayerTabFKeyName = getHotKeyName(Client.prayerTabFKey);
				Settings.saveSettings();
				return true;
			case 26028:
				Client.magicTabFKey = changeHotKey("Magic", Client.magicTabFKey, button + 3);
				Client.magicTabFKeyName = getHotKeyName(Client.magicTabFKey);
				Settings.saveSettings();
				return true;
			case 26032:
				Client.screenshotFKey = changeHotKey("Screenshot", Client.screenshotFKey, button + 3);
				Client.screenshotFKeyName = getHotKeyName(Client.screenshotFKey);
				Settings.saveSettings();
				return true;

			case 26036:
				Client.combatTabFKey = RSApplet.HotKeyData.F5.getHotKeyId();
				Client.inventoryTabFKey = RSApplet.HotKeyData.F1.getHotKeyId();
				Client.equipmentTabFKey = RSApplet.HotKeyData.F2.getHotKeyId();
				Client.prayerTabFKey = RSApplet.HotKeyData.F3.getHotKeyId();
				Client.magicTabFKey = RSApplet.HotKeyData.F4.getHotKeyId();
				Client.screenshotFKey = RSApplet.HotKeyData.F12.getHotKeyId();

				Client.combatTabFKeyName = RSApplet.HotKeyData.F5.name();
				Client.inventoryTabFKeyName = RSApplet.HotKeyData.F1.name();
				Client.equipmentTabFKeyName = RSApplet.HotKeyData.F2.name();
				Client.prayerTabFKeyName = RSApplet.HotKeyData.F3.name();
				Client.magicTabFKeyName = RSApplet.HotKeyData.F4.name();
				Client.screenshotFKeyName = RSApplet.HotKeyData.F12.name();
				Client.instance.sendFrame126("Combat: @gr3@F5", 26015);
				Client.instance.sendFrame126("Inventory: @gr3@F1", 26019);
				Client.instance.sendFrame126("Equipment: @gr3@F2", 26023);
				Client.instance.sendFrame126("Prayer: @gr3@F3", 26027);
				Client.instance.sendFrame126("Magic: @gr3@F4", 26031);
				Client.instance.sendFrame126("Screenshot: @gr3@F12", 26035);
				Settings.saveSettings();
				return true;
			case 17310:
				Client.setUpdateChatAreaPending(true);
				StreamLoader streamLoader_2 = Client.instance.streamLoaderForName(4, "2d graphics", "media", Client.instance.expectedCRCs[4], 40);
				if (Client.is474GameFrame && !Client.isOSRSGameFrame && !Client.is317GameFrame) {
					Client.is474GameFrame = true;
					Client.isOSRSGameFrame = true;
					Client.is498GameFrame = false;
					Client.is508PlusGameFrame = false;
					Client.is525GameFrame = false;
					Client.is562GameFrame = false;
					Client.is562PlusGameFrame = false;
					Client.setTabId(11, true);
					Client.instance.sendFrame126("Gameframe: @gr3@OSRS", 17313);
					Client.useOldWildernessInterface = true;
					Client.instance.sendCommandPacket("::useoldwildernessinterface");
				}
				else if (Client.is474GameFrame && Client.isOSRSGameFrame) {
					if (Client.isFixedScreen()) {
						Client.is474GameFrame = false;
						Client.isOSRSGameFrame = false;
						Client.is498GameFrame = true;
						Client.is508PlusGameFrame = false;
						Client.is525GameFrame = false;
						Client.is562GameFrame = false;
						Client.is562PlusGameFrame = false;
						Client.instance.setSidebarInterface(2, ClientConstants.getQuestTabInterfaceId());
						Client.setTabId(11, true);
						Client.instance.sendFrame126("Gameframe: @gr3@498", 17313);
						Client.useOldWildernessInterface = false;
						Client.instance.sendCommandPacket("::useoldwildernessinterface");
					}
					else {
						Client.instance.pushMessage("498 & 508 gameframe is not available on resizable.", ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");

						Client.is474GameFrame = false;
						Client.isOSRSGameFrame = false;
						Client.is498GameFrame = false;
						Client.is508PlusGameFrame = false;
						Client.is525GameFrame = true;
						Client.is562GameFrame = false;
						Client.is562PlusGameFrame = false;
						Client.setTabId(11, true);
						Client.instance.sendFrame126("Gameframe: @gr3@525", 17313);
						Client.useOldWildernessInterface = false;
						Client.instance.sendCommandPacket("::useoldwildernessinterface");
					}
				}
				else if (Client.is498GameFrame) {
					Client.is474GameFrame = false;
					Client.isOSRSGameFrame = false;
					Client.is498GameFrame = false;
					Client.is508PlusGameFrame = true;
					Client.is525GameFrame = false;
					Client.is562GameFrame = false;
					Client.is562PlusGameFrame = false;
					Client.setTabId(11, true);
					Client.instance.sendFrame126("Gameframe: @gr3@508", 17313);
					Client.useOldWildernessInterface = false;
					Client.instance.sendCommandPacket("::useoldwildernessinterface");
				}
				else if (Client.is508PlusGameFrame) {
					Client.is474GameFrame = false;
					Client.isOSRSGameFrame = false;
					Client.is498GameFrame = false;
					Client.is508PlusGameFrame = false;
					Client.is525GameFrame = true;
					Client.is562GameFrame = false;
					Client.is562PlusGameFrame = false;
					Client.setTabId(11, true);
					Client.instance.sendFrame126("Gameframe: @gr3@525", 17313);
					Client.useOldWildernessInterface = false;
					Client.instance.sendCommandPacket("::useoldwildernessinterface");
				}
				else if (Client.is525GameFrame) {
					Client.is474GameFrame = false;
					Client.isOSRSGameFrame = false;
					Client.is498GameFrame = false;
					Client.is508PlusGameFrame = false;
					Client.is525GameFrame = false;
					Client.is562GameFrame = true;
					Client.is562PlusGameFrame = false;
					Client.old562GameFrame = true;
					Client.instance.setSidebarInterface(15, 18500); // Note tab
					Client.instance.setSidebarInterface(14, ClientConstants.getQuestTabInterfaceId()); // Achievement Tab
					Client.setTabId(11, true);
					Client.instance.sendFrame126("Gameframe: @gr3@562 old", 17313);
					Client.useOldWildernessInterface = false;
					Client.instance.sendCommandPacket("::useoldwildernessinterface");
					if (Client.getInventoryLayout("DOUBLE STACK") && (Client.is562GameFrame || Client.is562PlusGameFrame)) {
						Client.inventoryLayout = "LANDSCAPE";
						Client.instance.pushMessage("Double stack inventory layout is unavailable for 562 gameframes.", ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
					}
				}
				else if (Client.old562GameFrame) {
					Client.old562GameFrame = false;
					Client.instance.sendFrame126("Gameframe: @gr3@562", 17313);
					Client.useOldWildernessInterface = false;
					Client.instance.sendCommandPacket("::useoldwildernessinterface");
				}

				else if (Client.is562GameFrame && !Client.showQuestionMark) {
					Client.is562GameFrame = true;
					Client.is562PlusGameFrame = false;
					Client.showQuestionMark = true;
					Client.instance.setSidebarInterface(1, ClientConstants.getQuestTabInterfaceId()); // Achievement tab.
					Client.instance.setSidebarInterface(2, 3917); // Skill tab.
					Client.instance.setSidebarInterface(14, ClientConstants.getQuestTabInterfaceId()); // Quest tab.
					Client.setTabId(11, true);
					Client.instance.sendFrame126("Gameframe: @gr3@562+", 17313);
					Client.useOldWildernessInterface = false;
					Client.instance.sendCommandPacket("::useoldwildernessinterface");
				}
				else if (Client.is562GameFrame && Client.showQuestionMark) {
					Client.is562GameFrame = false;
					Client.is562PlusGameFrame = true;
					Client.instance.sendFrame126("Gameframe: @gr3@562++", 17313);
					Client.useOldWildernessInterface = false;
					Client.instance.sendCommandPacket("::useoldwildernessinterface");
				}
				else if (Client.is562PlusGameFrame && !Client.newCompass) {

					if (Client.isFixedScreen()) {

						Client.instance.compass = new Sprite(streamLoader_2, "compass", 1);
						Client.newCompass = true;
						saveSettings();
						Client.instance.sendFrame126("Gameframe: @gr3@562+++", 17313);
						Client.useOldWildernessInterface = false;
						Client.instance.sendCommandPacket("::useoldwildernessinterface");
					}
					else {
						Client.instance.pushMessage("562+++ (new compass) gameframe is not available on resizable.", ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
						Client.is474GameFrame = true;
						Client.isOSRSGameFrame = false;
						Client.is498GameFrame = false;
						Client.is508PlusGameFrame = false;
						Client.is525GameFrame = false;
						Client.is562GameFrame = false;
						Client.is562PlusGameFrame = false;
						Client.newCompass = false;
						Client.instance.setSidebarInterface(15, 962);
						Client.instance.setSidebarInterface(2, ClientConstants.getQuestTabInterfaceId());
						Client.instance.setSidebarInterface(1, 3917); // Skill tab.
						Client.setTabId(11, true);
						Client.instance.compass = new Sprite(streamLoader_2, "compass", 0);
						Client.instance.sendFrame126("Gameframe: @gr3@474", 17313);
						Client.useOldWildernessInterface = true;
						Client.instance.sendCommandPacket("::useoldwildernessinterface");
						Client.showQuestionMark = false;
						saveSettings();
					}
				}
				else if (Client.newCompass) {
					Client.is317GameFrame = true;
					Client.is474GameFrame = true;
					Client.isOSRSGameFrame = false;
					Client.is498GameFrame = false;
					Client.is508PlusGameFrame = false;
					Client.is525GameFrame = false;
					Client.is562GameFrame = false;
					Client.is562PlusGameFrame = false;
					Client.newCompass = false;
					Client.instance.setSidebarInterface(15, 962);
					Client.instance.setSidebarInterface(2, ClientConstants.getQuestTabInterfaceId());
					Client.instance.setSidebarInterface(1, 3917); // Skill tab.
					Client.setTabId(11, true);
					Client.instance.compass = new Sprite(streamLoader_2, "compass", 2);
					Client.instance.sendFrame126("Gameframe: @gr3@317", 17313);
					Client.showQuestionMark = false;
					Client.useOldWildernessInterface = true;
					Client.instance.sendCommandPacket("::useoldwildernessinterface");
					saveSettings();
				}
				else if (Client.is317GameFrame) {
					Client.is317GameFrame = false;
					Client.is474GameFrame = true;
					Client.isOSRSGameFrame = false;
					Client.is498GameFrame = false;
					Client.is508PlusGameFrame = false;
					Client.is525GameFrame = false;
					Client.is562GameFrame = false;
					Client.is562PlusGameFrame = false;
					Client.newCompass = false;
					Client.instance.setSidebarInterface(15, 962);
					Client.instance.setSidebarInterface(2, ClientConstants.getQuestTabInterfaceId());
					Client.instance.setSidebarInterface(1, 3917); // Skill tab.
					Client.setTabId(11, true);
					Client.instance.compass = new Sprite(streamLoader_2, "compass", 0);
					Client.instance.sendFrame126("Gameframe: @gr3@474", 17313);
					Client.showQuestionMark = false;
					Client.useOldWildernessInterface = true;
					Client.instance.sendCommandPacket("::useoldwildernessinterface");
					saveSettings();
				}
				InventoryTab.drawTabArea(Client.instance); // Keep here to update something important when switching gameframes?
				saveSettings();

				// Inform server that the client is using 474 gameframe to use old wild interface.
				String data = "";
				if (Client.is474GameFrame) {
					data = "::oldgameframe";
				}
				else {
					data = "::newgameframe";
				}
				Client.instance.sendCommandPacket(data);
				return true;
			case 17396:
				Client.smoothMiniMap = !Client.smoothMiniMap;
				saveSettings();
				break;
			case 17400:
				Client.movingWater = !Client.movingWater;
				StreamLoader streamLoader = Client.instance.streamLoaderForName(2, "config", "config", Client.instance.expectedCRCs[2], 30);
				FloorDefinition.unpackConfig(streamLoader);
				Client.instance.setLoadingStage(1);
				saveSettings();
				break;
			case 17368:
				if (!Client.fog.equals("OFF BLACK") && !Client.fog.equals("OFF WHITE") && Client.smoothShading) {
					Client.instance.pushMessage("Smooth textures is required for fog.", ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
					return true;
				}
				Client.smoothShading = !Client.smoothShading;
				Client.instance.setLoadingStage(1);
				saveSettings();
				return true;
			case 17372:
				if (Client.otherFloorTexturing) {
					Client.instance.pushMessage("This feature is force enabled while using HD floors.", ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
					return true;
				}
				if (!Client.fog.equals("OFF BLACK") && !Client.fog.equals("OFF WHITE") && Client.smoothShading) {
					Client.instance.pushMessage("Smooth textures is required for fog.", ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
					return true;
				}
				Client.smoothShadow = !Client.smoothShadow;
				saveSettings();
				return true;
			case 17295:
				switch (Client.settingsPage) {
					case 1:
						Client.instance.sendFrame126("Page 2/6", 17298);
						Client.settingsPage++;
						Client.instance.setSidebarInterface(11, 17338);
						break;
					case 2:
						Client.instance.sendFrame126("Page 3/6", 17298);
						Client.settingsPage++;
						Client.instance.setSidebarInterface(11, 26010);
						break;
					case 3:
						Client.instance.sendFrame126("Page 4/6", 17298);
						Client.settingsPage++;
						Client.instance.setSidebarInterface(11, 26060);
						break;
					case 4:
						Client.instance.sendFrame126("Page 5/6", 17298);
						Client.settingsPage++;
						Client.instance.setSidebarInterface(11, 17367);
						break;
					case 5:
						Client.instance.sendFrame126("Page 6/6", 17298);
						Client.settingsPage++;
						Client.instance.setSidebarInterface(11, 17299);
						break;
				}
				saveSettings();
				return true;
			case 17292:
				switch (Client.settingsPage) {
					case 2:
						Client.instance.sendFrame126("Page 1/6", 17298);
						Client.settingsPage--;
						Client.instance.setSidebarInterface(11, 17300);
						break;
					case 3:
						Client.instance.sendFrame126("Page 2/6", 17298);
						Client.settingsPage--;
						Client.instance.setSidebarInterface(11, 17338);
						break;

					case 4:
						Client.instance.sendFrame126("Page 3/6", 17298);
						Client.settingsPage--;
						Client.instance.setSidebarInterface(11, 26010);
						break;

					case 5:
						Client.instance.sendFrame126("Page 4/6", 17298);
						Client.settingsPage--;
						Client.instance.setSidebarInterface(11, 26060);
						break;
					case 6:
						Client.instance.sendFrame126("Page 5/6", 17298);
						Client.settingsPage--;
						Client.instance.setSidebarInterface(11, 17367);
						break;
				}
				saveSettings();
				return true;
			case 17322:
				Client.experienceOrb = !Client.experienceOrb;
				saveSettings();
				return true;
			case 17318:
				String text = "";
				switch (Client.contextMenu) {
					case "OLD":
						Client.contextMenu = "OLD HOVER";
						text = "Old hover";
						break;
					case "OLD HOVER":
						Client.contextMenu = "NEW";
						text = "New";
						break;
					case "NEW":
						Client.contextMenu = "OLD";
						text = "Old";
						break;
				}
				Client.instance.sendFrame126("Menu: @gr3@" + text, 17321);
				saveSettings();
				return true;
			case 17343:
				Client.smoothCharacterTurn = !Client.smoothCharacterTurn;
				saveSettings();
				return true;
			case 17330:
				if (Client.newHitPointsBar) {
					Client.newHitPointsBar = false;
				}
				else {
					Client.newHitPointsBar = true;
				}
				saveSettings();
				return true;
			case 17314:
				String[] hitsplats =
				{"474", "562", "562+", "634"};
				for (int index = 0; index < hitsplats.length; index++) {
					if (Client.hitsplatRevision(hitsplats[index])) {
						if (index == hitsplats.length - 1) {
							index = -1;
						}
						Client.hitsplatRevision = hitsplats[index + 1];
						break;
					}
				}

				Client.instance.sendFrame126("Hitsplats: @gr3@" + Client.hitsplatRevision, 17317);
				saveSettings();
				return true;


			case 17334:
				Client.disableSpecOrb = !Client.disableSpecOrb;
				if (Client.disableSpecOrb) {
					Client.specOrb = false;
				}
				else {
					Client.specOrb = true;
				}
				saveSettings();
				break;
			case 17326:
				if (Client.x10Damage) {
					Client.x10Damage = false;
				}
				else {
					Client.x10Damage = true;
				}
				saveSettings();
				return true;
			case 17347:
				if (Client.isCursor == 0) {
					Client.isCursor = 1;
				}
				else if (Client.isCursor == 1) {
					Client.isCursor = 2;
				}
				else if (Client.isCursor == 2) {
					Client.isCursor = 3;
				}
				else if (Client.isCursor == 3) {
					Client.isCursor = 4;
				}
				else if (Client.isCursor == 4) {
					Client.isCursor = 5;
				}
				else if (Client.isCursor == 5) {
					Client.isCursor = 0;
				}
				ClientFrame.getCursorType();
				saveSettings();
				return true;
			case 17376:
				Client.tweening = !Client.tweening;
				saveSettings();
				return true;
			case 17380:
				if (Client.worldGraphicsMode.equals("HIGH")) {
					Client.worldGraphicsMode = "LOW";
					Client.instance.sendFrame126("Detail: @gr3@Low", 17383);
				}
				else if (Client.worldGraphicsMode.equals("MEDIUM")) {
					Client.worldGraphicsMode = "HIGH";
					Client.instance.sendFrame126("Detail: @gr3@High", 17383);
				}
				else {
					Client.worldGraphicsMode = "MEDIUM";
					Client.instance.sendFrame126("Detail: @gr3@Medium", 17383);
				}

				Client.instance.setLoadingStage(1);
				Client.setWorldGraphics(Client.worldGraphicsMode);
				saveSettings();
				return true;
			case 17384:
				Client.otherFloorTexturing = !Client.otherFloorTexturing;
				Client.instance.setLoadingStage(1);
				Client.hdMinimap = Client.otherFloorTexturing;
				saveSettings();
				return true;

			case 26061:
				Client.newFont = !Client.newFont;
				Client.loadTextFonts();
				saveSettings();
				return true;

			case 17388:
				switch (Client.fog) {
					case "DEFAULT":
						Client.instance.sendFrame126("Fog: @gr3@Sky", 17391);
						FogHandler.forceSmoothShadowAndShading();
						Client.fog = "SKY";
						FogHandler.fogColour = 0xc8c7ff;
						break;


					case "SKY":
						Client.instance.sendFrame126("Fog: @gr3@Dawn", 17391);
						FogHandler.forceSmoothShadowAndShading();
						Client.fog = "DAWN";
						FogHandler.fogColour = 0xffd170;
						break;


					case "DAWN":
						Client.instance.sendFrame126("Fog: @gr3@Night", 17391);
						FogHandler.forceSmoothShadowAndShading();
						Client.fog = "NIGHT";
						FogHandler.fogColour = 0x1F1F1F;
						break;

					case "NIGHT":
						Client.instance.sendFrame126("Fog: @gr3@Off black", 17391);
						Client.fog = "OFF BLACK";
						FogHandler.fogColour = 0x000000;
						break;

					case "OFF BLACK":
						Client.instance.sendFrame126("Fog: @gr3@Off white", 17391);
						Client.fog = "OFF WHITE";
						FogHandler.fogColour = 0xC8C0A8;
						break;

					case "OFF WHITE":
						Client.instance.sendFrame126("Fog: @gr3@Default", 17391);
						FogHandler.forceSmoothShadowAndShading();
						Client.fog = "DEFAULT";
						break;
				}
				saveSettings();
				return true;

			case 26065:
				Client.mouseScroll = !Client.mouseScroll;
				saveSettings();
				return true;

			case 26069:
				Client.overlayTimers = !Client.overlayTimers;
				saveSettings();
				return true;

			case 26073:
				Client.instance.setSidebarInterface(11, 40000);
				Client.setShowSettingTicks(false);
				saveSettings();
				return true;

			case 26077:
				Client.raidPrayersSwitch = !Client.raidPrayersSwitch;
				Content.switchRaidPrayers();
				saveSettings();
				return true;

			case 26081:
				Client.shiftDrop = !Client.shiftDrop;
				saveSettings();
				return true;

			case 26085:
				Client.kdrOverlay = !Client.kdrOverlay;
				saveSettings();
				return true;

			case 17351:
				if (Client.CameraPos2 <= 400) {
					Client.CameraPos2 = 500;
					Client.instance.sendFrame126("Zoom: @gr3@Close", 17354);
				}
				else if (Client.CameraPos2 >= 500 && Client.CameraPos2 <= 575) {
					Client.CameraPos2 = 600;
					Client.instance.sendFrame126("Zoom: @gr3@Normal", 17354);
				}
				else if (Client.CameraPos2 >= 600 && Client.CameraPos2 <= 675) {
					Client.CameraPos2 = 700;
					Client.instance.sendFrame126("Zoom: @gr3@Far", 17354);
				}
				else if (Client.CameraPos2 >= 700 && Client.CameraPos2 <= 775) {
					Client.CameraPos2 = 800;
					Client.instance.sendFrame126("Zoom: @gr3@Very far", 17354);
				}
				else if (Client.CameraPos2 >= 800) {
					Client.CameraPos2 = 400;
					Client.instance.sendFrame126("Zoom: @gr3@Very Close", 17354);
				}
				FogHandler.adjustFogEndDistance();
				saveSettings();
				return true;

			case 17339:
				if (Client.nameAbove) {
					Client.nameAbove = false;
				}
				else {
					Client.nameAbove = true;
				}
				saveSettings();
				return true;

			case 17355:
				if (Camera.CameraData.SLOW.toString().equals(Client.cameraSpeed)) {
					Client.cameraSpeed = Camera.CameraData.MEDIUM.toString();
					Client.instance.sendFrame126("Cam speed: @gr3@Medium", 17358);
				}
				else if (Camera.CameraData.MEDIUM.toString().equals(Client.cameraSpeed)) {
					Client.cameraSpeed = Camera.CameraData.FAST.toString();
					Client.instance.sendFrame126("Cam speed: @gr3@Fast", 17358);
				}
				else if (Camera.CameraData.FAST.toString().equals(Client.cameraSpeed)) {
					Client.cameraSpeed = Camera.CameraData.VERY_FAST.toString();
					Client.instance.sendFrame126("Cam speed: @gr3@Fast+", 17358);
				}
				else if (Camera.CameraData.VERY_FAST.toString().equals(Client.cameraSpeed)) {
					Client.cameraSpeed = Camera.CameraData.EXTREMELY_FAST.toString();
					Client.instance.sendFrame126("Cam speed: @gr3@Fast++", 17358);
				}
				else if (Camera.CameraData.EXTREMELY_FAST.toString().equals(Client.cameraSpeed)) {
					Client.cameraSpeed = Camera.CameraData.SUPER_SLOW.toString();
					Client.instance.sendFrame126("Cam speed: @gr3@Super Slow", 17358);
				}
				else if (Camera.CameraData.SUPER_SLOW.toString().equals(Client.cameraSpeed)) {
					Client.cameraSpeed = Camera.CameraData.SLOW.toString();
					Client.instance.sendFrame126("Cam speed: @gr3@Slow", 17358);
				}
				saveSettings();
				break;
			case 17392:
				if (Client.worldGraphicsMode.equals("LOW") || Client.worldGraphicsMode.equals("MEDIUM")) {
					Client.instance.pushMessage("This feature is disabled while using low/medium detail.", ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
					return true;
				}
				Client.enableRoof = !Client.enableRoof;
				saveSettings();
				return true;

			case 24264:
				Client.isInDetailedSettingsInterface = true;
				// Client settings
				showSettingsInterface();
				saveSettings();
				return true;

			case 17303:
				Client.isInDetailedSettingsInterface = false;
				// Close button on settings tab.
				Client.instance.setSidebarInterface(11, 904);
				Client.setShowSettingTicks(false);
				saveSettings();
				return true;

			case 40025:
				Client.isInDetailedSettingsInterface = true;
				// Close button on item overlay settings tab.
				Client.instance.setSidebarInterface(11, 26060);
				Client.setShowSettingTicks(true);
				saveSettings();
				return true;

			case 17359:
				Client.newClick = !Client.newClick;
				saveSettings();
				break;

			case 17363:
				Client.hpOverlayOn = !Client.hpOverlayOn;
				saveSettings();
				break;
		}

		return false;
	}

	private static String getHotKeyName(int fKey) {
		for (RSApplet.HotKeyData data : RSApplet.HotKeyData.values()) {
			if (fKey == data.getHotKeyId()) {
				if (data.name().equals("F10")) {
					Client.instance.pushMessage("F10 might be bugged on some computers.", ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
				}
				return data.name();
			}
		}
		return "NONE";
	}

	private static int changeHotKey(String hotKeyFunction, int currentHotKey, int interfaceId) {
		int nextHotKeyIndex = 0;
		if (nextHotKeyIndex == -1) {
			nextHotKeyIndex = 0;
		}
		else {

			for (RSApplet.HotKeyData data : RSApplet.HotKeyData.values()) {
				if (currentHotKey == data.getHotKeyId()) {
					nextHotKeyIndex = data.ordinal() + 1;
					break;
				}
			}
			if (nextHotKeyIndex > RSApplet.HotKeyData.values().length - 1) {
				nextHotKeyIndex = -1;
			}
		}
		if (nextHotKeyIndex == -1) {
			Client.instance.sendFrame126(hotKeyFunction + ": @red@NONE", interfaceId);
			return -1;
		}
		else {
			Client.instance.sendFrame126(hotKeyFunction + ": @gr3@" + RSApplet.HotKeyData.values()[nextHotKeyIndex].name(), interfaceId);
			return RSApplet.HotKeyData.values()[nextHotKeyIndex].getHotKeyId();
		}
	}

	public static void drawToolTipOther(String text, int xPos, int yPos) {
		//TODO #FULLSCREEN ADJUST interface, settings tab tooltips and combat tab tooltips
		int x = Client.isFixedScreen() ? 0 : (Client.getClientWidth() - Client.getFullscreenModeMinimapX(244));
		int y = Client.isFixedScreen() ? 0 : (Client.getClientHeight() - Client.getFullscreenModeChatAreaY(380));
		if (!Client.isFixedScreen() && Client.getInventoryLayout("DOUBLE STACK")) {
			y -= 38;
		}

		if (!Client.isFixedScreen() && (Client.is562GameFrame || Client.is562PlusGameFrame)) {
			y += 2;
		}
		xPos += x;
		yPos += y;
		int boxWidth = 0;
		int boxHeight = 0;
		TextDrawingArea textDrawingArea_2 = Client.instance.aTextDrawingArea_1271;
		for (String s1 = text; s1.length() > 0;) {
			int l7 = s1.indexOf("\\n");
			String s4;
			if (l7 != -1) {
				s4 = s1.substring(0, l7);
				s1 = s1.substring(l7 + 2);
			}
			else {
				s4 = s1;
				s1 = "";
			}
			int j10 = textDrawingArea_2.getTextWidth(s4);
			if (j10 > boxWidth) {
				boxWidth = j10;
			}
			boxHeight += textDrawingArea_2.anInt1497 - (Client.newFont ? 5 : 1);
		}
		boxWidth += 6;
		boxHeight += Client.newFont ? 10 : 10; // Length of box towards the bottom.
		DrawingArea.drawPixels(boxHeight, yPos, xPos, 0xFFFFA0, boxWidth);
		DrawingArea.fillPixels(xPos, boxWidth, boxHeight, 0, yPos);
		String s2 = text;
		for (int j11 = yPos + textDrawingArea_2.anInt1497 + (Client.newFont ? -2 : 2); s2.length() > 0; j11 += textDrawingArea_2.anInt1497 - (Client.newFont ? 4 : 0)) {
			int l11 = s2.indexOf("\\n");
			String s5;
			if (l11 != -1) {
				s5 = s2.substring(0, l11);
				s2 = s2.substring(l11 + 2);
			}
			else {
				s5 = s2;
				s2 = "";
			}
			textDrawingArea_2.method389(false, xPos + 3, 0, s5, j11);
		}
	}

	public final static String[][] hoverText =
	{
		{"Gameframe", "Change the gameframe layout",},
		{"Hitsplats", "Change the combat hitsplats\\n562+ is 562 but without text\\nshadow",},
		{"Menu", "Change right click context menu",},
		{"XP counter", "Display experience counter",},
		{"X10 damage", "Display X10 multiplied damage",},
		{"HP bar", "Change hitpoints bar",},
		{"Spec attack orb", "Display special attack orb",},
		{"Names", "Display names",},
		{"Smooth character turn", "Character turning direction(rotation)\\nto be smooth like in 2009",},
		{"Cursor", "Change cursor looks",},
		{"Zoom", "Adjust camera zoom level",},
		{"Camera speed", "Camera movement speed\\nslow is the default Runescape speed",},
		{"New click", "Display new left clicking like in 2011",},
		{"HP overlay", "Displays your opponent's health",},

		{"Smooth textures", "Display smooth\\nplayer, NPC & object textures",},
		{"Smooth shadows", "Display smooth ground shadows",},
		{"Soft animations", "Enable increased animation\\nframes like in 2010",},
		{"Detail", "Change world details.\\nMedium will disable movement of\\ntextures & ground detail.\\nLow will disable water/lava textures.",},
		{"HD floor", "Display floor texturing",},
		{"Fog", "Enable advanced fog",},
		{"Roofs", "Enable roofs",},
		{"New font", "Change the font style.\\nNew is 2009 era.\\nYou will need to restart client\\nto update the interfaces, such\\nas the quest tab etc..",},
		{"Mouse zoom", "Enable zooming with mouse scroll",},
		{"Overlay timers", "Enable timers for events\\nsuch as freeze times,\\nvengeance etc.",},
		{"Ground item overlay", "Allows the ability to\\nsee ground item names,\\nwith a colour toggle",},
		{"New prayer swap", "Swap the position of augury\\nand rigour with\\neagle eye and mystic might",},
		{"Shift to drop", "While enabled, you can hold\\ndown the shift key\\nthen left click an item\\nto drop it.",},
		{"KDR overlay", "While in the Wilderness,\\nthis will enable a KDR\\noverlay, similar to OSRS.",},
		{"Combat:", "Change combat tab f-key",},
		{"Inventory:", "Change inventory tab f-key",},
		{"Equipment:", "Change equipment tab f-key",},
		{"Prayer:", "Change prayer tab f-key",},
		{"Magic", "Change magic tab f-key",},
		{"Screenshot", "Change screenshot f-key",},
		{"Reset F-keys", "Reset f-keys to default settings",},
		{"Smooth minimap", "Enable Smooth Minimap Lines",},
		{"Moving water", "Toggles a moving water texture",},};

	private final static int[][] hoverBoxLocation =
	{
		{37, 115},
		{44, 143},
		{35, 171},
		{45, 199},
		{39, 227},
		{66, 255},
		{60, 233},

		// Names.
		{84, 115},
		{21, 143},
		{64, 171},
		{48, 199},
		{20, 227},
		{20, 255},
		{44, 216},

		// Smooth textures.
		{37, 115},
		{33, 143},
		{50, 171},
		{25, 199},
		{62, 227},
		{66, 255},
		{88, 233},

		// Smooth minimap.
		{36, 115},
		{30, 142},
		{65, 169},
		{75, 198},
		{42, 226}, // Swap new prayers
		{33, 255}, // Shift to drop
		{54, 210}, // KDR overlay
		//Fkeys start.
		{52, 113},
		{45, 140},
		{43, 170},
		{54, 198},
		{57, 225},
		{51, 253},
		{30, 233}, // Reset f-keys to default
		{45, 113}, // Smooth minimap
		{40, 143},

	};

	/**
	 * Draw the settings tooltip, this is done manually because if i add it to interfaces, the hover of the button won't show, but the tooltip will.
	 * So doing it this way, the hover will show & the tooltip.
	 */
	static void drawSettingsToolTip() {
		if (!Client.isShowSettingTicks()) {
			return;
		}
		boolean hovered = false;
		int delay = 90;
		int settingIndex = 0;
		for (int index = 0; index < hoverText.length; index++) {
			if (Client.instance.menuActionRow - 1 > Client.instance.menuActionName.length - 1) {
				continue;
			}
			if (Client.instance.menuActionName[Client.instance.menuActionRow - 1].contains(hoverText[index][0])) {
				if (Client.toolTipOtherTimer < delay) {
					Client.toolTipOtherTimer++;
				}
				settingIndex = index;
				hovered = true;
				break;
			}
		}
		if (!hovered) {
			if (Client.toolTipOtherTimer > 0) {
				Client.toolTipOtherTimer--;
			}
		}
		else {
			if (Client.toolTipOtherTimer >= delay) {
				drawToolTipOther(hoverText[settingIndex][1], hoverBoxLocation[settingIndex][0], hoverBoxLocation[settingIndex][1]);
			}
		}
	}

	/**
	 * Apply the setting ticks on the interface.
	 */
	public static void drawSettingTicks() {
		if (!Client.isShowSettingTicks()) {
			return;
		}
		//TODO #FULLSCREEN ADJUST interface, setting tab ticks
		int x = Client.isFixedScreen() ? 0 : (Client.getClientWidth() - Client.getFullscreenModeMinimapX(244));
		int y = Client.isFixedScreen() ? 0 : (Client.getClientHeight() - Client.getFullscreenModeChatAreaY(380));
		if (!Client.isFixedScreen() && Client.getInventoryLayout("DOUBLE STACK")) {
			y -= 38;
		}

		if (!Client.isFixedScreen() && (Client.is562GameFrame || Client.is562PlusGameFrame)) {
			y += 2;
		}

		switch (Client.settingsPage) {
			case 1:
				Client.cacheSprite[Client.experienceOrb ? 341 : 340].drawSprite(167 + x, 177 + y);
				Client.cacheSprite[Client.x10Damage ? 341 : 340].drawSprite(167 + x, 205 + y);
				Client.cacheSprite[Client.newHitPointsBar ? 341 : 340].drawSprite(167 + x, 233 + y);
				Client.cacheSprite[!Client.disableSpecOrb ? 341 : 340].drawSprite(167 + x, 261 + y);
				break;
			case 2:
				Client.cacheSprite[Client.nameAbove ? 341 : 340].drawSprite(167 + x, 93 + y);
				Client.cacheSprite[Client.smoothCharacterTurn ? 341 : 340].drawSprite(167 + x, 121 + y);
				Client.cacheSprite[Client.isCursor > 0 ? 341 : 340].drawSprite(167 + x, 149 + y);
				Client.cacheSprite[Client.newClick ? 341 : 340].drawSprite(167 + x, 233 + y);
				Client.cacheSprite[Client.hpOverlayOn ? 341 : 340].drawSprite(167 + x, 261 + y);
				break;
			case 4:
				Client.cacheSprite[Client.newFont ? 341 : 340].drawSprite(167 + x, 93 + y);
				Client.cacheSprite[Client.mouseScroll ? 341 : 340].drawSprite(167 + x, 121 + y);
				Client.cacheSprite[Client.overlayTimers ? 341 : 340].drawSprite(167 + x, 149 + y);
				Client.cacheSprite[Client.raidPrayersSwitch ? 341 : 340].drawSprite(168 + x, 205 + y);
				Client.cacheSprite[Client.shiftDrop ? 341 : 340].drawSprite(168 + x, 233 + y);
				Client.cacheSprite[Client.kdrOverlay ? 341 : 340].drawSprite(167 + x, 261 + y);
				break;
			case 5:
				Client.cacheSprite[Client.smoothShading ? 341 : 340].drawSprite(167 + x, 93 + y);
				Client.cacheSprite[Client.smoothShadow || Client.otherFloorTexturing ? 341 : 340].drawSprite(167 + x, 121 + y);
				Client.cacheSprite[Client.tweening ? 341 : 340].drawSprite(167 + x, 149 + y);
				Client.cacheSprite[Client.otherFloorTexturing ? 341 : 340].drawSprite(167 + x, 205 + y);
				Client.cacheSprite[(Client.enableRoof && !Client.worldGraphicsMode.equals("LOW") && !Client.worldGraphicsMode.equals("MEDIUM")) ? 341 : 340].drawSprite(167 + x, 261 + y);
				break;
			case 6:
				Client.cacheSprite[Client.smoothMiniMap ? 341 : 340].drawSprite(167 + x, 93 + y);
				Client.cacheSprite[Client.movingWater ? 341 : 340].drawSprite(167 + x, 121 + y);
				break;
		}
	}

	public static void showSettingsInterface() {
		if (!Client.isInDetailedSettingsInterface) {
			Client.instance.setSidebarInterface(11, 904);
			return;
		}
		int interfaceId = 17300;
		switch (Client.settingsPage) {
			case 2:
				interfaceId = 17338;
				break;
			case 3:
				interfaceId = 26010;
				break;
			case 4:
				interfaceId = 26060;
				break;
			case 5:
				interfaceId = 17367;
				break;
			case 6:
				interfaceId = 17299;
				break;
		}
		Client.instance.setSidebarInterface(11, interfaceId);
		Client.instance.sendFrame126("Page " + Client.settingsPage + "/6", 17298);
	}

	public static void drawResizableSettings() {
		if (Client.getInterfaceDisplayed() != 20200) {
			return;
		}
		//TODO #FULLSCREEN ADJUST interface, setting tab ticks resizable
		int x1 = Client.isFixedScreen() ? 0 : (Client.getClientWidth() / 2) - 256;
		int y1 = Client.isFixedScreen() ? 0 : (Client.getClientHeight() / 2) - 267;
		Client.cacheSprite[Client.inventoryLayout.equals("LANDSCAPE") ? 341 : 340].drawSprite(343 + x1, 183 + y1);
		Client.cacheSprite[Client.hideInventoryInterface ? 341 : 340].drawSprite(343 + x1, 209 + y1);
		Client.cacheSprite[Client.transparentTab ? 341 : 340].drawSprite(343 + x1, 234 + y1);
		Client.cacheSprite[Client.transparentChat ? 341 : 340].drawSprite(343 + x1, 261 + y1);

	}

	public static boolean canSwitchToResizable(boolean fullscreenSwitch) {
		if (Client.getTutorialStage() > 0) {
			Client.instance.pushMessage("Please complete the tutorial before changing the screen size.", ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
			return false;
		}
		if (Client.displayMode.equals("RESIZABLE") && !fullscreenSwitch) {
			return false;
		}
		if (Client.is498GameFrame) {
			Client.instance.pushMessage("Resizable is not available on 498 gameframe. Please change the gameframe.", ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
			return false;
		}
		if (Client.is508PlusGameFrame) {
			Client.instance.pushMessage("Resizable is not available on 508 gameframe. Please change the gameframe.", ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
			return false;
		}
		if (Client.is317GameFrame) {
			Client.instance.pushMessage("Resizable is not available on 317 gameframe. Please change the gameframe.", ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
			return false;
		}
		return true;
	}
}