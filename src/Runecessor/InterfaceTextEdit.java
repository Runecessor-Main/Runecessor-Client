package Runecessor;

/**
 * Edit specific interface frames to a different text.
 * @author Lava, created on 22-03-2015.
 */
public class InterfaceTextEdit {

	/**
	 * Apply the modified interface frames.
	 */
	public static void apply() {
		for (int value = 0; value < interfaceFrameID.length; value++) {
			Client.instance.sendFrame126(interfaceFrameText[value], interfaceFrameID[value]);
		}

		// Change log out text to a different yellow, so when i use resizable, it doesn't turn to blue, because it was 0xfff000.
		RSInterface.interfaceCache[2450].textColour = 16773120;
		RSInterface.interfaceCache[2451].textColour = 16773120;
		RSInterface.interfaceCache[2452].textColour = 16773120;
	}

	private static String[] interfaceFrameText =
	{
		"The Bank Of " + ClientConstants.getServerName() + "",
		"    When you want to logout of",
		"" + ClientConstants.getServerName() + ", use the button",
		"        below to logout safely.",
		"Welcome to " + ClientConstants.getServerName() + " - Character Design",
		"Welcome to " + ClientConstants.getServerName() + "",
		"Teleports",
		"Teleports",
		"Teleports",
		"Teleports",
		"Teleports",
		"Teleports",
		"Teleports",
		"Teleports",
		"Teleports",
		"Teleports",
		"Teleports",
		"Teleports",
		"Teleports",
		"Teleports",
		"Teleports",
		"A teleportation spell",
		"A teleportation spell",
		"A teleportation spell",
		"A teleportation spell",
		"A teleportation spell",
		"A teleportation spell",
		"A teleportation spell",
		"",
		"",
		"",
		"",};

	private static int[] interfaceFrameID =
	{5383, 2450, 2451, 2452, 3649, 15259, 13037, 13047, 13055, 13063, 13071, 13081, 13089, 13097, 1350, 1325, 1300, 1382, 1415, 1454, 7457, 1301, 1326, 1351, 1383, 1416, 1455, 7458, 963, 8934, 5449, 14923, // Bank pin interface, "your pin will be deleted in x days"

	};

}