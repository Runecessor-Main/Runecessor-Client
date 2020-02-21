package Runecessor;

/**
 * Handles the pre eoc login screen
 * 
 * @author 2012
 *
 */
public class PreEocScreen {

	/**
	 * The full loading bar
	 */
	private static final int FULL_LOADING_BAR = 190;

	/**
	 * The full percentage
	 */
	private static final int FULL_PERCENTAGE = 767;

	/**
	 * The loading bar sprite
	 */
	private static final int LOADING_BAR_SPRITE = 7;

	/**
	 * The login cycle
	 */
	private static int loginCycle = 0;

	/**
	 * The login sprite
	 */
	private static int loginOrbSprite = 0;

	/**
	 * Attempt logging in
	 */
	public static boolean attemptLogin = false;

	/**
	 * The loading background
	 */
	public static int loadingBackground = 4;

	/**
	 * The loading background opacity
	 */
	public static int loadingBackgroundOpacity = 256;

	/**
	 * The loading cycle
	 */
	public static int loadingCycle;

	/**
	 * Whether switching backgrounds
	 */
	public static int switchingBackgroundType;

	/**
	 * Whether the background is animated
	 */
	public static boolean changingBackground;

	/**
	 * Entered the wrong password
	 */
	public static boolean wrongPass;

	/**
	 * Drawing the loading screen
	 * 
	 * @param percentage the percentage
	 */
	public static void drawLoadingScreen(int percentage, String s) {
		/*
		 * Background
		 */
		Client.instance.backgroundSprite[Config.currentServer].drawAdvancedSprite(0, 0);
		/*
		 * Loading bar
		 */
		Client.instance.backgroundSprite[LOADING_BAR_SPRITE]
				.drawAdvancedSprite((Client.getClientWidth() / 2) - (358 / 2), 8);
		/*
		 * The loading bar component x
		 */
		int loadingBarX = 0;
		/*
		 * The percentage completed
		 */
		int complete = (percentage * 100) / FULL_PERCENTAGE;
		/*
		 * The loading bar progress
		 */
		int loadingBar = (complete * 24) / FULL_LOADING_BAR;
		/*
		 * Drawing the bar
		 */
		for (int i = 0; i < loadingBar; i++) {
			Client.instance.backgroundSprite[8].drawAdvancedSprite(
					84 + (Client.getClientWidth() / 2) - (358 / 2) + loadingBarX, 34);
			loadingBarX += 16;
		}
		/*
		 * Draw the text
		 */
		Client.instance.smallText.drawText(0xFFFFFF, s + " " + complete + "%", 29,
				(Client.getClientWidth() / 2));
	}

	/**
	 * Drawing the login screen
	 */
	public static void drawLoginScreen() {
		if (changingBackground) {
			/*
			 * Fix background
			 */
			if (loadingBackground < 4) {
				loadingBackground = 4;
			}
			/*
			 * The loading cycle
			 */
			loadingCycle++;
			/*
			 * Time to switch
			 */
			if (loadingCycle % 200 == 0 && switchingBackgroundType < 1) {
				switchingBackgroundType = 1;
			}
			/*
			 * Switching background
			 */
			if (switchingBackgroundType == 1) {
				/*
				 * Decrease opacity
				 */
				if (loadingBackgroundOpacity > 24) {
					if (loadingCycle % 4 == 0) {
						loadingBackgroundOpacity -= 1;
					}
				} else {
					switchingBackgroundType = 2;
				}
			} else if (switchingBackgroundType == 2) {
				/*
				 * Change background
				 */
				loadingBackground++;
				/*
				 * Fix overlapping
				 */
				if (loadingBackground > 6) {
					loadingBackground = 4;
				}
				/*
				 * Next stage
				 */
				switchingBackgroundType = 3;
				/*
				 * Final stage
				 */
			} else if (switchingBackgroundType == 3) {
				/*
				 * Increase opacity
				 */
				if (loadingBackgroundOpacity < 254) {
					if (loadingCycle % 4 == 0) {
						loadingBackgroundOpacity += 1;
					}
				} else {
					switchingBackgroundType = -1;
				}
			}
			Client.instance.backgroundSprite[Config.currentServer].drawTransparentSprite(
					(Client.getClientWidth() / 2) - (768 / 2), 0, loadingBackgroundOpacity);
		} else {
			Client.cacheSprite[1120].drawAdvancedSprite((Client.getClientWidth() / 2) - (768 / 2), 0);
		}
		/*
		 * The x offset
		 */
		int loginBoxX = (Client.getClientWidth() / 2) - (266 / 2);
		/*
		 * The y offset
		 */
		int loginBoxY = (Client.getClientHeight() / 2) - (245 / 2);
		/*
		 * The x hover
		 */
		int xHover = Client.isFixedScreen() ? Client.instance.mouseX
				: Client.instance.mouseX - (Client.getClientWidth() / 2) + 375;
		/*
		 * The y hover
		 */
		int yHover = Client.instance.mouseY;
		Client.instance.aTextDrawingArea_1271.method389(true, 15, 0xFFFFFF, "X: " + xHover + "", 100);
		Client.instance.aTextDrawingArea_1271.method389(true, 15, 0xFFFFFF, "Y: " + yHover + "", 120);
		/*
		 * Wrong pass
		 */
		if (wrongPass) {
			Client.cacheSprite[1258].drawAdvancedSprite((Client.getClientWidth() / 2) - (250 / 2),
					(Client.getClientHeight() / 2) - (195 / 2));
			/*
			 * Try again hover
			 */
			if (xHover >= 297 && xHover <= 464 && yHover >= 314 && yHover <= 338) {
				Client.cacheSprite[1259].drawAdvancedSprite(
						(Client.getClientWidth() / 2) - (250 / 2) + 40,
						(Client.getClientHeight() / 2) - (195 / 2) + 159);
			}
			/*
			 * Try again click
			 */
			if (Client.isWithInClicked(297, 464, 314, 338, false)
					|| Client.isWithInClicked(297, 464, 282, 309, false)) {
				wrongPass = false;
			}
			/*
			 * Forgotten your password?
			 */
			if (xHover >= 297 && xHover <= 464 && yHover >= 282 && yHover <= 309) {
				Client.cacheSprite[1260].drawAdvancedSprite(
						(Client.getClientWidth() / 2) - (250 / 2) + 40,
						(Client.getClientHeight() / 2) - (195 / 2) + 129);
			}
			return;
		}
		/*
		 * Attempting login
		 */
		if (attemptLogin) {
			/*
			 * Increase the login cycle
			 */
			loginCycle++;
			/*
			 * Draw the background
			 */
			Client.cacheSprite[1169].drawAdvancedSprite((Client.getClientWidth() / 2) - (250 / 2),
					(Client.getClientHeight() / 2) - (149 / 2));
			/*
			 * Draw the orb
			 */
			Client.cacheSprite[1161 + (loginOrbSprite / 5)].drawAdvancedSprite(
					68 + (Client.getClientWidth() / 2) - (250 / 2),
					15 + (Client.getClientHeight() / 2) - (149 / 2));
			Client.cacheSprite[1223].drawAdvancedSprite((Client.getClientWidth() / 2) - (250 / 2),
					(Client.getClientHeight() / 2) - (149 / 2));
			/*
			 * Increase orb sprite
			 */
			loginOrbSprite++;
			/*
			 * Restart
			 */
			if (loginOrbSprite == 40) {
				loginOrbSprite = 0;
			}
			/*
			 * Login
			 */
			if (loginCycle >= 60) {
				Client.instance.login(Client.instance.myUsername, Client.instance.myPassword, false);
				attemptLogin = false;
				loginCycle = 0;
				loginOrbSprite = 0;
			}
			return;
		}
		/*
		 * The login box
		 */
		Client.cacheSprite[1121].drawAdvancedSprite(loginBoxX, loginBoxY);
		/*
		 * The fullscreen offset
		 */
		int fullscreenXOffset = Client.isFixedScreen() ? 0 : (Client.getClientWidth() / 2) - 375;
		/*
		 * The username text
		 */
		String usernameText =
				new StringBuilder().append("").append(Client.capitalize(Client.instance.myUsername))
						.append(((Client.instance.loginScreenCursorPos == 0 ? 1 : 0)
								& (Client.loopCycle % 40 < 20 ? 1 : 0)) != 0 ? "|" : "")
						.toString();
		/*
		 * The password text
		 */
		String passwordText = new StringBuilder().append("")
				.append(TextClass.passwordAsterisks(Client.instance.myPassword))
				.append(((Client.instance.loginScreenCursorPos == 1 ? 1 : 0)
						& (Client.loopCycle % 40 < 20 ? 1 : 0)) != 0 ? "|" : "")
				.toString();
		/*
		 * Login messages
			 */
		Client.instance.newSmallFont.drawCenteredString(Client.instance.getLoginMessage1(), 381 + fullscreenXOffset, 147, 0xffe1be, 0x000000);
		Client.instance.newSmallFont.drawCenteredString(Client.instance.getLoginMessage2(), 381 + fullscreenXOffset, 160, 0xffe1be, 0x000000);
		Client.instance.newSmallFont.drawCenteredString(Client.instance.getLoginMessage3(), 381 + fullscreenXOffset, 173, 0xffe1be, 0x000000);
		/*
		 * Username hover
		 */
		if (xHover >= 271 && xHover <= 487 && yHover >= 189 && yHover <= 213) {
			Client.cacheSprite[1122].drawAdvancedSprite(loginBoxX + (266 / 2) - (220 / 2),
					loginBoxY + 59);
			/*
			 * Clicking username
			 */
			if (Client.isWithInClicked(271, 487, 189, 213, false)) {
				Client.instance.loginScreenCursorPos = 0;
			}
		}
		/*
		 * Password hover
		 */
		if (xHover >= 271 && xHover <= 487 && yHover >= 235 && yHover <= 260) {
			Client.cacheSprite[1122].drawAdvancedSprite(loginBoxX + (266 / 2) - (220 / 2),
					loginBoxY + 105);
			/*
			 * Clicking password
			 */
			if (Client.isWithInClicked(271, 487, 235, 260, false)) {
				Client.instance.loginScreenCursorPos = 1;
			}
		}
		/*
		 * Draw username
		 */
		Client.instance.aTextDrawingArea_1271.method389(true, 280 + fullscreenXOffset, 0xffffff,
				usernameText, 208);
		/*
		 * Draw password
		 */
		Client.instance.newRegularFont.drawBasicString1(passwordText, 280 + fullscreenXOffset, 256,
				0xffffff, -1);
		/*
		 * Login button hover
		 */
		boolean loginBoxHover = xHover >= 292 && xHover <= 471 && yHover >= 287 && yHover <= 312;
		/*
		 * Login box
		 */
		Client.cacheSprite[loginBoxHover ? 1123 : 1124].drawAdvancedSprite(loginBoxX + (266 / 2) - 90,
				loginBoxY + 157);
		/*
		 * Login in
		 */
		if (Client.isWithInClicked(292, 471, 287, 312, false)) {
			attemptLogin = true;
		}
	}
}
