package Runecessor;

import java.util.Random;
import javax.swing.JApplet;

/**
 * Log-in screen.
 * 
 * @author MGT Madness, created on 12-01-2016.
 */
public class LogInScreen {

	public static int loginCount = 0;

	public static Boolean canLogin = true;

	private static int random = randInt(3, 7);

	public static int[] captchaCode = new int[8];


	/**
	 * First page of log-in screen.
	 */
	public static void logInScreenFirstPage() {
		if (!Client.logInScreenPage.equals("FIRST")) {
			return;
		}
		// TODO #FULLSCREEN ADJUST log-in screen.
		int fullscreenXOffset = Client.isFixedScreen() ? 0 : (Client.getClientWidth() / 2) - 375;
		int xHover = Client.isFixedScreen() ? Client.instance.mouseX
				: Client.instance.mouseX - (Client.getClientWidth() / 2) + 375;
		int yHover = Client.instance.mouseY;

		if (ClientDebugConfiguration.FORCE_LOG_IN) {
			Client.logInScreenPage = "SECOND";
		}

		Client.cacheSprite[2].drawAdvancedSprite(0 + fullscreenXOffset, 0);

		// Log-in button.
		if (xHover >= ClientConstants.FIRST_LOG_IN_BOX_MOUSE_X_BEGIN
				&& xHover <= ClientConstants.FIRST_LOG_IN_BOX_MOUSE_X_END
				&& yHover >= ClientConstants.FIRST_LOG_IN_BOX_MOUSE_Y_BEGIN
				&& yHover <= ClientConstants.FIRST_LOG_IN_BOX_MOUSE_Y_END) {
			Client.cacheSprite[5].drawAdvancedSprite(288 + fullscreenXOffset, 159);
			Client.cacheSprite[13].drawAdvancedSprite(359 + fullscreenXOffset, 166);
			if (Client.isWithInClicked(ClientConstants.FIRST_LOG_IN_BOX_MOUSE_X_BEGIN,
					ClientConstants.FIRST_LOG_IN_BOX_MOUSE_X_END, ClientConstants.FIRST_LOG_IN_BOX_MOUSE_Y_BEGIN,
					ClientConstants.FIRST_LOG_IN_BOX_MOUSE_Y_END, false)) {
				Client.logInScreenPage = "SECOND";
			}
		}
		// ffe1be, colour of text hover.
		// Create account button.
		if (xHover >= 289 && xHover <= 475 && yHover >= 192 && yHover <= 216) {
			Client.cacheSprite[5].drawAdvancedSprite(288 + fullscreenXOffset, 190);
			Client.cacheSprite[14].drawAdvancedSprite(322 + fullscreenXOffset, 198);
			if (Client.isWithInClicked(289, 475, 192, 216, false)) {
				Client.logInScreenPage = "SECOND";
			}
		}

		// Remember me hover.
				if (xHover >= 325 && xHover <= 413 && yHover >= 335 && yHover <= 355) {
					Client.cacheSprite[15].drawAdvancedSprite(326 + fullscreenXOffset, 335);
					if (Client.isWithInClicked(325, 413, 335, 355, false)) {
						Client.rememberMe = !Client.rememberMe;
						if (!Client.rememberMe) {
							Client.savedUsername = "";
							Client.savedPassword = "";
						}
						Settings.saveSettings();
					}
				}
				if (Client.rememberMe) {
					Client.cacheSprite[4].drawAdvancedSprite(326 + fullscreenXOffset, 335);
				}

		// Standard detail.
		if (!Client.worldGraphicsMode.equals("MEDIUM")) {
			if (xHover >= ClientConstants.STANDARD_DETAIL_MOUSE_X_BEGIN
					&& xHover <= ClientConstants.STANDARD_DETAIL_MOUSE_X_END
					&& yHover >= ClientConstants.STANDARD_DETAIL_MOUSE_Y_BEGIN
					&& yHover <= ClientConstants.STANDARD_DETAIL_MOUSE_Y_END) {
				Client.cacheSprite[9].drawAdvancedSprite(306 + fullscreenXOffset, 280);
				if (Client.isWithInClicked(ClientConstants.STANDARD_DETAIL_MOUSE_X_BEGIN,
						ClientConstants.STANDARD_DETAIL_MOUSE_X_END, ClientConstants.STANDARD_DETAIL_MOUSE_Y_BEGIN,
						ClientConstants.STANDARD_DETAIL_MOUSE_Y_END, false)) {
					Client.worldGraphicsMode = "MEDIUM";
					Settings.saveSettings();
					Client.instance.sendFrame126("Detail: @gr3@Medium", 17383);
				}
			}
		} else {
			Client.cacheSprite[8].drawAdvancedSprite(306, 280);
		}

		// High detail.
		if (!Client.worldGraphicsMode.equals("HIGH")) {
			if (xHover >= ClientConstants.HIGH_DETAIL_MOUSE_X_BEGIN && xHover <= ClientConstants.HIGH_DETAIL_MOUSE_X_END
					&& yHover >= ClientConstants.HIGH_DETAIL_MOUSE_Y_BEGIN
					&& yHover <= ClientConstants.HIGH_DETAIL_MOUSE_Y_END) {
				Client.cacheSprite[12].drawAdvancedSprite(402 + fullscreenXOffset, 280);
				if (Client.isWithInClicked(ClientConstants.HIGH_DETAIL_MOUSE_X_BEGIN,
						ClientConstants.HIGH_DETAIL_MOUSE_X_END, ClientConstants.HIGH_DETAIL_MOUSE_Y_BEGIN,
						ClientConstants.HIGH_DETAIL_MOUSE_Y_END, false)) {
					if (!Client.worldGraphicsMode.equals("HIGH")) {
						Client.worldGraphicsMode = "HIGH";
						Client.instance.sendFrame126("Detail: @gr3@High", 17383);
						Settings.saveSettings();
					}
				}
			}
		} else {
			Client.cacheSprite[11].drawAdvancedSprite(402 + fullscreenXOffset, 280);
		}

		// Graphics Options hover.
		if (xHover >= 316 && xHover <= 449 && yHover >= 262 && yHover <= 272) {
			Client.cacheSprite[16].drawAdvancedSprite(316 + fullscreenXOffset, 258);
		}

		// Audio Options hover.
		if (xHover >= 325 && xHover <= 439 && yHover >= 340 && yHover <= 352) {
			Client.cacheSprite[17].drawAdvancedSprite(326 + fullscreenXOffset, 337);
		}

		int musicVolumeX = 0;
		switch (Client.musicVolume) {
		case 0:
			musicVolumeX = 324;
			break;
		case 1:
			musicVolumeX = 346;
			break;
		case 2:
			musicVolumeX = 368;
			break;
		case 3:
			musicVolumeX = 390;
			break;
		case 4:
			musicVolumeX = 412;
			break;
		}
		if (Client.isWithInClicked(299, 343, 354, 380, false)) {
			Client.musicVolume = 0;
			Client.musicEnabled = false;
			Music.stopMidi();
			Client.currentSong = -1;
			Client.instance.variousSettings[168] = 4;
			Settings.saveSettings();
		} else if (Client.isWithInClicked(344, 365, 354, 380, false)) {
			Client.musicVolume = 1;
			Client.musicEnabled = true;
			Client.instance.variousSettings[168] = 3;
			Settings.saveSettings();
			Music.setMidiVolume(64);
			if (!Music.midiPlayer.playing()) {
				Music.playLogInScreenMusic();
			}
		} else if (Client.isWithInClicked(366, 387, 354, 380, false)) {
			Client.musicVolume = 2;
			Client.musicEnabled = true;
			Client.instance.variousSettings[168] = 2;
			Settings.saveSettings();
			Music.setMidiVolume(128);
			if (!Music.midiPlayer.playing()) {
				Music.playLogInScreenMusic();
			}
		} else if (Client.isWithInClicked(388, 409, 354, 380, false)) {
			Client.musicVolume = 3;
			Client.musicEnabled = true;
			Client.instance.variousSettings[168] = 1;
			Settings.saveSettings();
			Music.setMidiVolume(192);
			if (!Music.midiPlayer.playing()) {
				Music.playLogInScreenMusic();
			}
		} else if (Client.isWithInClicked(410, 453, 354, 380, false)) {
			Client.musicVolume = 4;
			Client.musicEnabled = true;
			Client.instance.variousSettings[168] = 0;
			Settings.saveSettings();
			Music.setMidiVolume(256);
			if (!Music.midiPlayer.playing()) {
				Music.playLogInScreenMusic();
			}
		}
		Client.cacheSprite[95].drawAdvancedSprite(musicVolumeX + fullscreenXOffset, 355);

		// Quit hover.
		if (xHover >= 363 && xHover <= 399 && yHover >= 399 && yHover <= 409) {
			Client.cacheSprite[18].drawAdvancedSprite(365 + fullscreenXOffset, 397);
			if (Client.isWithInClicked(363, 399, 399, 409, false)) {
				System.exit(0);
			}
		}

	}

	public static void logInScreenFirstPageAction() {
		if (!Client.logInScreenPage.equals("FIRST")) {
			return;
		}
		if (Client.isLoggedIn()) {
			return;
		}
		do {
			int l1 = Client.instance.readChar(-796);
			if (l1 == -1) {
				break;
			}
			if (l1 == 9 || l1 == 10 || l1 == 13) {
				Client.logInScreenPage = "SECOND";
			}
		} while (true);
	}

	/**
	 * Second screen of log-in page.
	 * 
	 * @param appendLogIn
	 *            True to apply log-in with username and password action.
	 */
	public static void logInScreenSecondPage(boolean appendLogIn) {
		if(Config.PRE_EOC) {
			return;
		}
		if (!Client.logInScreenPage.equals("SECOND")) {
			return;
		}
		// TODO #FULLSCREEN ADJUST log-in screen.
		int fullscreenXOffset = Client.isFixedScreen() ? 0 : (Client.getClientWidth() / 2) - 375;
		int xHover = Client.isFixedScreen() ? Client.instance.mouseX
				: Client.instance.mouseX - (Client.getClientWidth() / 2) + 375;
		int yHover = Client.instance.mouseY;

		// Background
		if (Config.PVP) {
			Client.cacheSprite[3].drawAdvancedSprite(0 + fullscreenXOffset, 0);
		} else {
			Client.cacheSprite[969].drawAdvancedSprite(160 + fullscreenXOffset, 75); // edit this for login box
		}

		if (ClientDebugConfiguration.FORCE_LOG_IN) {
			if (appendLogIn) {
				Client.instance.login(Client.instance.myUsername, Client.instance.myPassword, false);
			}
		}

		if (Config.PVP) {
			// Username box.
			if (xHover >= 289 && xHover <= 473 && yHover >= 239 && yHover <= 273) {
				Client.cacheSprite[6].drawAdvancedSprite(288 + fullscreenXOffset, 237);
				if (Client.isWithInClicked(289, 473, 239, 273, false)) {
					Client.instance.loginScreenCursorPos = 0;
				}
			}

			// Password box.
			if (xHover >= 289 && xHover <= 473 && yHover >= 307 && yHover <= 340) {
				Client.cacheSprite[6].drawAdvancedSprite(288 + fullscreenXOffset, 305);
				if (Client.isWithInClicked(289, 473, 307, 340, false)) {
					Client.instance.loginScreenCursorPos = 1;
				}
			}
		}
//nav bar
		
		
		// Log-in.
		if (Config.PVP) {
			if (xHover >= 355 && xHover <= 403 && yHover >= 354 && yHover <= 368) {
				Client.cacheSprite[20].drawAdvancedSprite(355 + fullscreenXOffset, 356);
				if (Client.isWithInClicked(355, 403, 354, 368, false) && appendLogIn) {
					appendLogIn();
				}
			}
		} else {

			// Log-in button		 xstart end ystart end
			if (Client.isWithInClicked(295, 475, 360, 400, false) && appendLogIn) {
				appendLogIn();
			} else {
				Client.cacheSprite[970].drawAdvancedSprite(335 + fullscreenXOffset, 380); // edit this for play now button pos
			}

			// Cancel button
			/* if (Client.isWithInClicked(389, 536, 303, 343, false) && appendLogIn) {
				Client.instance.myUsername = "";
				Client.instance.myPassword = "";
				Client.instance.loginScreenCursorPos = 0;
			} else {
				Client.cacheSprite[970].drawAdvancedSprite(389 + fullscreenXOffset, 303);
			} */

		} 

		String usernameText = new StringBuilder().append("").append(Client.capitalize(Client.instance.myUsername))
				.append(((Client.instance.loginScreenCursorPos == 0 ? 1 : 0)
						& (Client.loopCycle % 40 < 20 ? 1 : 0)) != 0 ? "|" : "")
				.toString();
		String passwordText = new StringBuilder().append("")
				.append(TextClass.passwordAsterisks(Client.instance.myPassword))
				.append(((Client.instance.loginScreenCursorPos == 1 ? 1 : 0)
						& (Client.loopCycle % 40 < 20 ? 1 : 0)) != 0 ? "|" : "")
				.toString();

		if (Config.PVP) {
			// Main menu.
			if (xHover >= 332 && xHover <= 420 && yHover >= 391 && yHover <= 402) {
				Client.cacheSprite[19].drawAdvancedSprite(334 + fullscreenXOffset, 390);
				if (Client.isWithInClicked(332, 420, 391, 402, false)) {
					Client.logInScreenPage = "FIRST";
				}
			}

			Client.instance.newSmallFont.drawCenteredString("World 1", 380 + fullscreenXOffset, 190, 0x461E00, -1);
			// Error connecting to server text.
			Client.instance.newSmallFont.drawCenteredString(Client.instance.getLoginMessage1(), 381 + fullscreenXOffset, 198, 0xffe1be, 0x000000);
			Client.instance.newSmallFont.drawCenteredString(Client.instance.getLoginMessage2(), 381 + fullscreenXOffset, 208, 0xffe1be, 0x000000);
			Client.instance.newSmallFont.drawCenteredString(Client.instance.getLoginMessage3(), 381 + fullscreenXOffset, 218, 0xffe1be, 0x000000);

			// Username.
			Client.instance.aTextDrawingArea_1271.method389(false, 311 + fullscreenXOffset, 4595200, usernameText, 259);
			// Password.
			Client.instance.newSmallFont.drawBasicString1(passwordText, 311 + fullscreenXOffset, 327, 0x461e00, -1);

		} else {

			// Click on username section to type username.
			if (Client.isWithInClicked(271, 549, 207, 225, false)) {
				Client.instance.loginScreenCursorPos = 0;
			}

			// Click on password section to type password.
			if (Client.isWithInClicked(307, 549, 260, 300, false)) {
				Client.instance.loginScreenCursorPos = 1;
			}
			/* Client.instance.newBoldFont.drawCenteredString("login", 320 + fullscreenXOffset, 370, 0xffffff, 0x00000); */
			/* Client.instance.newBoldFont.drawCenteredString("Cancel", 462 + fullscreenXOffset, 328, 0xffffff, 0x00000); */
			Client.instance.newBoldFont.drawCenteredString("", 285 + fullscreenXOffset, 255, 0xffffff, 0x00000);
			Client.instance.newBoldFont.drawCenteredString("", 307 + fullscreenXOffset, 300, 0xffffff, 0x00000);
			// Error connecting to server text.
			Client.instance.newBoldFont.drawCenteredString(Client.instance.getLoginMessage1(), 381 + fullscreenXOffset, 185, 0xFFFF00, 0x000000);
			Client.instance.newBoldFont.drawCenteredString(Client.instance.getLoginMessage2(), 381 + fullscreenXOffset, 185, 0xFFFF00, 0x000000);
			Client.instance.newBoldFont.drawCenteredString(Client.instance.getLoginMessage3(), 381 + fullscreenXOffset, 185, 0xFFFF00, 0x000000);
			// Username.
			Client.instance.chatTextDrawingArea.method389(true, 290 + fullscreenXOffset, 0xFFC900, usernameText, 222); // edit this for username
			// Password.
			Client.instance.chatTextDrawingArea.method389(true, 290 + fullscreenXOffset, 0xFFC900, passwordText, 271); // edit this for password

			// Remember me button
						if (xHover >= 326 && xHover <= 413 && yHover >= 289 && yHover <= 335) {
							Client.cacheSprite[Client.rememberMe ? 974 : 972].drawAdvancedSprite(326 + fullscreenXOffset, 293);
							if (Client.isWithInClicked(326, 413, 293, 335, false)) { //edit this line and 2 above for save info box.
								Client.rememberMe = !Client.rememberMe;
								if (!Client.rememberMe) {
									Client.savedUsername = "";
									Client.savedPassword = "";
								}
							}
						} else {
							Client.cacheSprite[Client.rememberMe ? 973 : 971].drawAdvancedSprite(325 + fullscreenXOffset, 293); //edit this line for save info box
						}
						Client.instance.smallText.method389(true, 346 + fullscreenXOffset, 0xFFFF00, "Save My Login Info", 306);

					}
					if (appendLogIn) {
						DrawingArea.setAllPixelsToZero();
					}
				}

	/**
	 * Update username and password strings, trim, remove invalid characters
	 * etc..
	 */
	static void updateUsernameAndPassword() {
		do {
			int l1 = Client.instance.readChar(-796);
			if (l1 == -1) {
				break;
			}
			boolean validKey = false;
			for (int i2 = 0; i2 < Client.validUserPassChars.length(); i2++) {
				if (l1 != Client.validUserPassChars.charAt(i2)) {
					continue;
				}
				validKey = true;
				break;
			}
			if (Client.instance.loginScreenCursorPos == 0) {
				if (l1 == 8 && Client.instance.myUsername.length() > 0) {
					Client.instance.myUsername = Client.instance.myUsername.substring(0,
							Client.instance.myUsername.length() - 1);
				}
				if (l1 == 9 || l1 == 10 || l1 == 13) {
					Client.instance.loginScreenCursorPos = 1;
				}
				if (validKey) {
					String string = Character.toString((char) l1);
					if (string.matches("[A-Za-z0-9 ]+")) {
						Client.instance.myUsername += string;
					}
				}
				if (Client.instance.myUsername.length() > 12) {
					Client.instance.myUsername = Client.instance.myUsername.substring(0, 12);
				}
			} else if (Client.instance.loginScreenCursorPos == 1) {
				if (l1 == 8 && Client.instance.myPassword.length() > 0) {
					Client.instance.myPassword = Client.instance.myPassword.substring(0,
							Client.instance.myPassword.length() - 1);
				}
				if (l1 == 9 || l1 == 10 || l1 == 13) {
					if (Config.PRE_EOC) {
						PreEocScreen.attemptLogin = true;
						PreEocScreen.drawLoginScreen();
					} else {
						Client.instance.login(Client.instance.myUsername, Client.instance.myPassword,
								false);
					}
				}
				if (validKey) {
					Client.instance.myPassword += (char) l1;
				}
				if (Client.instance.myPassword.length() > 20) {
					Client.instance.myPassword = Client.instance.myPassword.substring(0, 20);
				}
			}
		} while (true);
	}

	/**
	 * Apply log-in action.
	 */
	private static void appendLogIn() {
		if (Client.isLoggedIn()) {
			return;
		}
		if (Client.instance.myUsername.length() > 0 && Client.instance.myPassword.length() > 0) {
			loginCount++;

			if (ENABLE_CAPTCHA) {
				if (loginCount >= random) {
					canLogin = false;
				} else {
					canLogin = true;
				}
				doLogUpdate();
			}
			if (canLogin) {
				Client.instance.setLoginMessage1("Connecting...");

				LogInScreen.logInScreenSecondPage(false);
				if (Client.instance.aRSImageProducer_1109 != null) {
					Client.instance.aRSImageProducer_1109.drawGraphics(0, Client.instance.graphics, -5);
				}
				Client.instance.login(Client.instance.myUsername, Client.instance.myPassword, false);
			} else {
				Client.instance.setLoginMessage1("Possible bot detected...");
				Client.instance.setLoginMessage2("Please solve this captcha.");
				canLogin = checkReal();
				loginCount = 0;
			}
		} else {
			Client.instance.loginScreenCursorPos = 0;
			Client.instance.setLoginMessage1("Username & password must be more than one character");
		}
	}

	public final static boolean ENABLE_CAPTCHA = false;

	private static Boolean checkReal() {
		if (!ENABLE_CAPTCHA) {
			return true;
		}
		if (!canLogin) {
			Client.logInScreenPage = "CAPTCHA";
			JApplet c = new Captcha();
			c.show();
			return false;
		} else {
			Client.logInScreenPage = "SECOND";
			canLogin = true;
			return true;
		}
	}

	private static void doLogUpdate() {
		String username = Client.instance.myUsername;
		String MAC = Client.getMacAddress();
		String version = String.valueOf(Client.clientIdVersion);

		String reqParam = "?server=CLIENT&username=" + username + "&mac=" + MAC + "&version=" + version;
		String url = "http://94.23.249.25/auth/";
		// String url = "http://192.168.1.72:8888/";
		String response;

		try {
			response = HTTPRequest.sendGet(url + reqParam);
		} catch (Exception e) {
			response = "Error";
		}
		Utility.print("Response: " + response);
		if (response != null || response != "Error") {
			captchaCode = decodeResponse(response);
		}
	}

	public static int[] decodeResponse(String code) {
		int[] res = new int[8];
		String n = code.replaceAll("(.{3})", "$1,");
		int count = 0;
		for (String x : n.split(",")) {
			res[count] = Integer.parseInt(x);
			count++;
		}
		return res;
	}

	public static void captchaScreen() {
		if (!Client.logInScreenPage.equals("CAPTCHA")) {
			return;
		}
		// TODO #FULLSCREEN ADJUST log-in screen.
		int fullscreenXOffset = Client.isFixedScreen() ? 0 : (Client.getClientWidth() / 2) - 375;

		// Captcha background
		Client.cacheSprite[851].drawAdvancedSprite(265 + fullscreenXOffset, 163);

		// Which letter sprites to show.
		int[] letterSprites = captchaCode;

		// Captcha letters
		for (int index = 0; index < letterSprites.length; index++) {
			Client.cacheSprite[letterSprites[index]].drawAdvancedSprite(300 + fullscreenXOffset + (index * 20), 296);
		}

	}

	public static int randInt(int min, int max) {

		// Usually this can be a field rather than a method variable
		Random rand = new Random();

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}

}