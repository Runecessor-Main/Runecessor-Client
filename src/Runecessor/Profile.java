package Runecessor;

/**
 * Profile interface.
 * @author Lava, created on 29-12-2015.
 */
public class Profile {

	/**
	 * Draw the search text.
	 */
	public static void drawBiography() {
		if (Client.profileBiographyLineEdited == 0) {
			return;
		}
		int y = 86 + (Client.profileBiographyLineEdited * 18);
		//TODO #FULLSCREEN ADJUST interface, profile interface.
		int x1 = Client.isFixedScreen() ? 0 : (Client.getClientWidth() / 2) - 256;
		int y1 = Client.isFixedScreen() ? 0 : (Client.getClientHeight() / 2) - 267;
		Client.instance.newRegularFont.drawBasicString1(Client.profileBiographyText + (Client.loopCycle % 40 < 20 ? "|" : ""), 264 + x1, y + y1, true, 0xffb000, false);
	}

	public static void sendProfileBiographyToServer() {
		Client.instance.sendCommandPacket("::biography" + Client.profileBiographyLineEdited + ":" + Client.profileBiographyText);
		switch (Client.profileBiographyLineEdited) {
			case 1:
				Client.instance.sendFrame126(Client.profileBiographyText, 25359);
				break;
			case 2:
				Client.instance.sendFrame126(Client.profileBiographyText, 25360);
				break;
			case 3:
				Client.instance.sendFrame126(Client.profileBiographyText, 25361);
				break;
			case 4:
				Client.instance.sendFrame126(Client.profileBiographyText, 25362);
				break;
			case 5:
				Client.instance.sendFrame126(Client.profileBiographyText, 25373);
				break;
		}
		Client.profileBiographyLineEdited = 0;
		Client.profileBiographyText = "";
	}

	public static void profileBiographyButton(String text) {
		String textResume = "";
		textResume = text.substring(18);
		text = text.substring(17, 18);
		int value = Integer.parseInt(text);
		if (Client.profileBiographyLineEdited != 0 && Client.profileBiographyLineEdited != value) {

			sendProfileBiographyToServer();
			int line = 0;
			switch (Client.profileBiographyLineEdited) {
				case 1:
					line = 25359;
					break;
				case 2:
					line = 25360;
					break;
				case 3:
					line = 25361;
					break;
				case 4:
					line = 25362;
					break;
				case 5:
					line = 25373;
					break;
			}
			Client.instance.sendFrame126(Client.profileBiographyText, line);
		}
		Client.profileBiographyText = textResume;
		Client.profileBiographyLineEdited = 0;
		switch (value) {

			case 1:
				Client.profileBiographyLineEdited = 1;
				Client.instance.sendFrame126("", 25359);
				break;

			case 2:
				Client.profileBiographyLineEdited = 2;
				Client.instance.sendFrame126("", 25360);
				break;

			case 3:
				Client.profileBiographyLineEdited = 3;
				Client.instance.sendFrame126("", 25361);
				break;

			case 4:
				Client.profileBiographyLineEdited = 4;
				Client.instance.sendFrame126("", 25362);
				break;

			case 5:
				Client.profileBiographyLineEdited = 5;
				Client.instance.sendFrame126("", 25373);
				break;
		}
	}

	/**
	 * Search button action.
	 */
	public static void searchButton() {
		Client.profileSearching = !Client.profileSearching;
		if (Client.profileSearching) {
			Client.setMessagePromptRaised(false, false);
			Client.setUpdateChatAreaPending(true);
			Client.instance.sendFrame126("", 25326);
			Client.instance.sendFrame126("", 25539);
		}
		else {
			stopSearching(true);
		}

	}

	/**
	 * Stop profile searchin.
	 * @param ignoreCheck
	 * 			True to ignore if profile searching is true.
	 */
	public static void stopSearching(boolean ignoreCheck) {
		if (!Client.profileSearching && !ignoreCheck) {
			return;
		}
		Client.profileSearching = false;
		Client.instance.sendFrame126("Search", 25326);
		Client.instance.sendFrame126("Search", 25539);
		Client.profileSearchString = "";
	}

	/**
	 * Draw the search text.
	 */
	public static void drawSearch() {
		if (!Client.profileSearching) {
			return;
		}
		//TODO #FULLSCREEN ADJUST interface, profile interface.
		int x1 = Client.isFixedScreen() ? 0 : (Client.getClientWidth() / 2) - 256;
		int y1 = Client.isFixedScreen() ? 0 : (Client.getClientHeight() / 2) - 267;
		boolean weaponInterface = Client.getInterfaceDisplayed() == 25403;
		Client.instance.newSmallFont.drawBasicString1(Client.capitalize(Client.profileSearchString) + (Client.loopCycle % 40 < 20 ? "|" : ""), (weaponInterface ? 371 : 400) + x1, (weaponInterface ? 29 : 56) + y1, true, 0xffb000, false);
	}

	/**
	 * Inform the server of the player to search for.
	 */
	public static void sendProfileSearch() {
		Client.instance.sendCommandPacket("::search " + Client.profileSearchString.toLowerCase());
	}

}
