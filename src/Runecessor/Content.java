package Runecessor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Content {

	public static void sendPopUpSearchToServer() {
		if (!Client.isPopUpSearching) {
			return;
		}
		if (Client.popUpNotSearchButton) {
			return;
		}
		if (System.currentTimeMillis() - Client.timePopUpSearchTermSent <= 700) {
			return;
		}
		if (Client.getChatAreaInputBoxPlayerInput().equals(Client.popUpSearchTermSent)) {
			return;
		}
		if (System.currentTimeMillis() - Client.lastTimeTyped <= 300) {
			return;
		}
		Client.instance.sendCommandPacket(
				"::popupsearch " + Client.popUpInterfaceButtonUsedId + " " + Client.getChatAreaInputBoxPlayerInput());
		Client.popUpSearchTermSent = Client.getChatAreaInputBoxPlayerInput();
		Client.timePopUpSearchTermSent = System.currentTimeMillis();
	}

	public static void popUpSearchInterfaceDisplayedChanged(int openInterfaceId, boolean enterPressed) {
		if (Client.isPopUpSearching) {
			if (openInterfaceId != Client.popUpParentInterfaceUsedId) {
				closePopUpSearch(enterPressed);
			}
		}
	}

	public static boolean isPopUpSearchButton(int buttonId) {
		switch (buttonId) {
			// Search an npc, Npc droptable interface.
		case 30420:
				Content.togglePopUpSearch(29050, buttonId, "Search an npc", false);
			return true;
			// Search an item, Npc droptable interface.
		case 30424:
				Content.togglePopUpSearch(29050, buttonId, "Search an item", false);
			return true;
			// Change password, Change password interface.
			case 35096 :
				Content.togglePopUpSearch(35096, buttonId, "Change password", true);
				return true;
		}
		return false;
	}

	public static void togglePopUpSearch(int parentInterfaceId, int interfaceId, String searchTextTitle, boolean isNotSearchButton) {
		boolean enabled = RSInterface.interfaceCache[interfaceId].isClicked;
		boolean toggleOn = !enabled;
		if (!isNotSearchButton) {
			Client.setInterfaceClicked(parentInterfaceId, interfaceId, toggleOn, true);
		}
		else {
			if (Client.isPopUpSearching) {
				toggleOn = false;
			}
		}
		Client.isPopUpSearching = toggleOn;
		Client.popUpNotSearchButton = isNotSearchButton;
		if (toggleOn) {
			Client.setChatAreaInputBoxTitle(searchTextTitle);
			Client.setChatAreaInputBoxPlayerInput("");
			Client.setMessagePromptRaised(true, false);
			Client.setUpdateChatAreaPending(true);
			Client.popUpParentInterfaceUsedId = parentInterfaceId;
			Client.popUpInterfaceButtonUsedId = interfaceId;
		} else {
			closePopUpSearch(false);
		}

	}

	public static void closePopUpSearch(boolean enterPressed) {
		if (enterPressed) {
			Client.instance.sendCommandPacket("::popuptermsent " + Client.popUpInterfaceButtonUsedId + " " + Client.getChatAreaInputBoxPlayerInput());
		}
		Client.setInterfaceClicked(Client.popUpParentInterfaceUsedId, Client.popUpInterfaceButtonUsedId, false, true);
		if (!Client.popUpNotSearchButton) {
			Client.instance.sendCommandPacket("::popupsearch " + Client.popUpInterfaceButtonUsedId + " ");
		}
		Client.popUpInterfaceButtonUsedId = 0;
		Client.popUpParentInterfaceUsedId = 0;
		Client.isPopUpSearching = false;
		Client.setChatAreaInputBoxTitle("");
		Client.setChatAreaInputBoxPlayerInput("");
		Client.setMessagePromptRaised(false, false);
		Client.setUpdateChatAreaPending(true);
	}

	/**
	 * Show the correct clicked tab on the Quest tab.
	 */
	public static void showCorrectQuestTab(boolean logInUpdate) {
		if (Config.PVP) {
			return;
		}
		if (logInUpdate) {
			int[] interfaceId = { 22985, 22989, 22993, 22997 };
			Client.setInterfaceClicked(22980, interfaceId[Client.questTabOpenedTab - 1], true, true);
		}
		for (int index = 0; index < Client.interfaceClickedList.size(); index++) {
			String[] parse = Client.interfaceClickedList.get(index).split(" ");
			int parentIdParse = Integer.parseInt(parse[0]);
			int interfaceIdParse = Integer.parseInt(parse[1]);
			if (parentIdParse != 22980) {
				continue;
			}

			switch (interfaceIdParse) {
			// Information tab on the Eco Quest Interface.
			case 22985:
				Client.instance.sendFrame126("Information", 22984);
				Client.instance.setSidebarInterface(2, 22980);
				Client.questTabOpenedTab = 1;
				break;
			// Panel tab on the Eco Quest Interface.
			case 22989:
				Client.instance.sendFrame126("Tools & More", 22984);
				Client.instance.setSidebarInterface(2, 23089);
				Client.questTabOpenedTab = 2;
				break;
			// Activities tab on the Eco Quest Interface.
			case 22993:
				Client.instance.sendFrame126("Activities & Events", 22984);
				Client.instance.setSidebarInterface(2, 23180);
				Client.questTabOpenedTab = 3;
				break;
			// Quest tab on the Eco Quest Interface.
			case 22997:
				Client.instance.sendFrame126("Quests", 22984);
				Client.instance.setSidebarInterface(2, 23181);
				Client.questTabOpenedTab = 4;
				break;
			}
			if (!logInUpdate) {
				Settings.saveSettings();
			}
		}
	}

	public static void loadingPleaseWait() {
		if (Client.contextMenu.equals("NEW")) {
			Client.cacheSprite[22].drawSprite(8, 9); // Loading please wait, new
														// version.
		} else {
			DrawingArea.fillPixels(2, 130, 22, 0xffffff, 2);
			DrawingArea.drawPixels(20, 3, 3, 0, 128);
			Client.instance.aTextDrawingArea_1271.drawText(0, "Loading - please wait.", 18, 68);
			Client.instance.aTextDrawingArea_1271.drawText(0xffffff, "Loading - please wait.", 17, 67);
		}
	}

	public static void showPetMysteryBoxInterfaceActions() {
		if (Client.unlockedPet == 0) {
			return;
		}

		if (System.currentTimeMillis() - Client.timePetInterfaceChanged <= 250) {
			return;
		}
		Client.timePetInterfaceChanged = System.currentTimeMillis();

		int petLoopItemId = Client.availablePets.get(Client.availablePetsCurrentIndex) + 1;
		if (Client.petInterfaceLoops == 23) {
			petLoopItemId = Client.unlockedPet + 1;
			Client.unlockedPet = 0;
			Client.changeInterfaceSprite(29214, 753); // Change background
														// border to gold.
		}

		Client.changeInterfaceSprite(29215, -1); // Delete question mark.
		RSInterface.interfaceCache[29216].inv[0] = petLoopItemId; // The pet
																	// item ids
																	// to show.

		Client.availablePetsCurrentIndex++;
		if (Client.availablePetsCurrentIndex > Client.availablePets.size() - 1) {
			Client.availablePetsCurrentIndex = 0;
		}
		Client.petInterfaceLoops++;

	}

	protected static void updateVengeanceRunes() {
		RSInterface class9_1 = RSInterface.interfaceCache[3214];
		Client.astralRuneAmount = 0;
		Client.deathRuneAmount = 0;
		Client.earthRuneAmount = 0;

		for (int j25 = 0; j25 < class9_1.inv.length; j25++) {
			int itemId = class9_1.inv[j25] - 1;
			int itemAmount = class9_1.invStackSizes[j25];
			if (itemId == 9075) {
				Client.astralRuneAmount = itemAmount;
			} else if (itemId == 560) {
				Client.deathRuneAmount = itemAmount;
			} else if (itemId == 557) {
				Client.earthRuneAmount = itemAmount;
			} else if (itemId == 12791) {
				// Search rune pouch for runes.
				RSInterface class9_2 = RSInterface.interfaceCache[22917];
				for (int i = 0; i < class9_2.inv.length; i++) {
					if (class9_2.inv[i] == 9075 + 1) {
						Client.astralRuneAmount += class9_2.invStackSizes[i];
					} else if (class9_2.inv[i] == 560 + 1) {
						Client.deathRuneAmount += class9_2.invStackSizes[i];
					} else if (class9_2.inv[i] == 557 + 1) {
						Client.earthRuneAmount += class9_2.invStackSizes[i];
					}

				}
			}
		}
	}

	public static void noClip() {
		if (!Client.noClip) {
			return;
		}
		if (System.currentTimeMillis() - Client.noClipTime > 500) {
			Client.noClipTime = System.currentTimeMillis();
		}
		for (int k1 = 0; k1 < 4; k1++) {
			for (int i2 = 1; i2 < 103; i2++) {
				for (int k2 = 1; k2 < 103; k2++) {
					Client.instance.collisionMap[k1].flags[i2][k2] = 0;
				}

			}

		}
	}

	public static void rottenPotatoV2(String command) {
		File secondFolder = new File(ClientConstants.getCacheLocation() + "raw/" + command.substring(15) + ".dat");
		if (!secondFolder.exists()) {
			try {
				secondFolder.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Client.friendsListAction = 0;

	}

	public static void drawLoginScreen() {
		Client.instance.resetImageProducers();
		// TODO #FULLSCREEN ADJUST log-in screen.
		int fullscreenXOffset = Client.isFixedScreen() ? 0 : (Client.getClientWidth() / 2) - 480;
		if (!Config.PRE_EOC) {
			Client.instance.backgroundSprite[Config.currentServer]
					.drawSprite(0 + fullscreenXOffset, 0);
		}
		Client.instance.aRSImageProducer_1109.initDrawingArea();
		char c = '\u0168';
		if (ClientDebugConfiguration.DEBUG_MODE) {
			Client.instance.aTextDrawingArea_1271.method389(true, 15, 0xFFFFFF, "X: " + Client.instance.mouseX + "", 60);
			Client.instance.aTextDrawingArea_1271.method389(true, 15, 0xFFFFFF, "Y: " + Client.instance.mouseY + "", 80);
		}
		Client.instance.aTextDrawingArea_1271.method382(0x75a9a9, c / 190, Client.onDemandFetcher.statusString, 100,
				true); // What is this.

		if (Config.PRE_EOC) {
			Client.logInScreenPage = "SECOND";
			PreEocScreen.drawLoginScreen();
		} else {
			LogInScreen.logInScreenFirstPage();
			LogInScreen.logInScreenSecondPage(false);
			LogInScreen.captchaScreen();
		}
		if (Client.instance.aRSImageProducer_1109 != null) {
			Client.instance.aRSImageProducer_1109.drawGraphics(0, Client.instance.graphics, 0);
		}
	}

	public static void drawBankClickedButtons() {
		if (Client.getInterfaceDisplayed() != 24959) {
			return;
		}
		// TODO #FULLSCREEN ADJUST interfaces, bank buttons/noted/search
		// hovers/clicked.
		int x = Client.isFixedScreen() ? 0 : (Client.getClientWidth() / 2) - 256;
		int y = Client.isFixedScreen() ? 0 : (Client.getClientHeight() / 2) - 267;
		if (Client.searching) {
			Client.cacheSprite[381].drawSprite(63 + x, 297 + y);
		}

		// Withdraw noted item clicked sprite
		if (Client.instance.variousSettings[115] == 1) {
			Client.cacheSprite[378].drawSprite(238 + x, 297 + y);
		}

		if (Client.instance.variousSettings[835] == 1) {
			Client.cacheSprite[1014].drawSprite(280 + x, 297 + y);
		}

		// Swap items hover
		if (Client.isWithIn(27, 59, 301, 325) && Client.instance.variousSettings[304] == 0) {
			Client.cacheSprite[393].drawSprite(23 + x, 297 + y);
		}

	}

	public static void sendSearchToServer() {
		if (Client.getInterfaceDisplayed() != 24959) {
			return;
		}
		if (!Client.searching) {
			return;
		}
		if (System.currentTimeMillis() - Client.timeSentBankSearch > 100) {
			if (Client.getChatAreaInputBoxPlayerInput().equals(Client.bankSearchSent)) {
				return;
			}
			String previous = Client.instance.inputString;
			Client.instance.inputString = "::banksearch" + Client.getChatAreaInputBoxPlayerInput();
			Client.instance.stream.createFrame(103);
			Client.bankSearchSent = Client.getChatAreaInputBoxPlayerInput();
			Client.instance.stream.writeWordBigEndian(Client.instance.inputString.length() - 1);
			Client.instance.stream.writeString(Client.instance.inputString.substring(2));
			Client.instance.inputString = previous;
			Client.inputValue = -1;
			Client.timeSentBankSearch = System.currentTimeMillis();
		}
	}

	/**
	 * Character rotation in equipment interface.
	 */
	public static void characterRotation() {
		if ((Client.getInterfaceDisplayed() == 15106 || Client.getInterfaceDisplayed() == 15150)
				&& Client.isWithInClicked(185, 264, 34, 320, true)) {
			if (!Client.rotateCharacterState.equals("CLOCKWISE")) {
				Client.rotateCharacterState = "CLOCKWISE";
			} else if (Client.rotateCharacterState.equals("CLOCKWISE")) {
				Client.rotateCharacterState = "NONE";
			}
		} else if ((Client.getInterfaceDisplayed() == 15106 || Client.getInterfaceDisplayed() == 15150)
				&& Client.isWithInClicked(265, 341, 34, 320, true)) {
			if (!Client.rotateCharacterState.equals("ANTI-CLOCKWISE")) {
				Client.rotateCharacterState = "ANTI-CLOCKWISE";
			} else if (Client.rotateCharacterState.equals("ANTI-CLOCKWISE")) {
				Client.rotateCharacterState = "NONE";
			}
		}
	}

	static void zombieReadyInterface() {

		if (Client.showCountdown) {
			Client.cacheSprite[318].drawSprite(234 + (Client.isFixedScreen() ? 0 : (Client.getClientWidth() / 2) - 263),
					9);
			int left = (int) (System.currentTimeMillis() - Client.countDownTime) / 1000;
			left = 5 - left;
			if (left == 0) {
				Client.showCountdown = false;
				return;
			}
			Client.instance.newRegularFont.drawBasicString1(left + "",
					258 + (Client.isFixedScreen() ? 0 : (Client.getClientWidth() / 2) - 263), 33, false,
					ClientConstants.YELLOW, false);

		}
		if (Client.instance.walkableInterfaceId == ClientConstants.ZOMBIE_READY_INTERFACE) {
			int offset = !Client.isFixedScreen() ? 4 : 0;
			if (Client.instance.mouseX >= 228 + (Client.isFixedScreen() ? 0 : (Client.getClientWidth() / 2) - 267)
					&& Client.instance.mouseX <= 293
							+ (Client.isFixedScreen() ? 0 : (Client.getClientWidth() / 2) - 267)
					&& Client.instance.mouseY >= 13 - offset && Client.instance.mouseY <= 27) {
				Client.cacheSprite[572]
						.drawSprite(224 + (Client.isFixedScreen() ? 0 : (Client.getClientWidth() / 2) - 263), 9);
			} else {
				Client.cacheSprite[571]
						.drawSprite(224 + (Client.isFixedScreen() ? 0 : (Client.getClientWidth() / 2) - 263), 9);
			}
			if (Client.clickPositionUpdateRequired) {
				return;
			}
			if (Client.instance.saveClickX == Client.clickedX && Client.instance.saveClickY == Client.clickedY) {
				return;
			}
			int saveClickX = Client.instance.saveClickX;
			int saveClickY = Client.instance.saveClickY;
			if (Client.instance.clickMode2 == 1
					&& saveClickX >= 228 + (Client.isFixedScreen() ? 0 : (Client.getClientWidth() / 2) - 267)
					&& saveClickX <= 293 + (Client.isFixedScreen() ? 0 : (Client.getClientWidth() / 2) - 267)
					&& saveClickY >= 13 - offset && saveClickY <= 27) {
				Client.clickedX = Client.instance.saveClickX;
				Client.clickedY = Client.instance.saveClickY;
				Client.instance.sendCommandPacket("::togglezombieready");
			}
		}

	}

	static void drawShopSearch() {
		if (!Client.shopSearching) {
			return;
		}
		int x1 = Client.isFixedScreen() ? 0 : (Client.getClientWidth() / 2) - 256;
		int y1 = Client.isFixedScreen() ? 0 : (Client.getClientHeight() / 2) - 267;
		Client.instance.newSmallFont.drawBasicString1(
				Client.capitalize(Client.shopString) + (Client.loopCycle % 40 < 20 ? "|" : ""), 350 + x1, 35 + y1, true,
				0xffb000, false);
		if (System.currentTimeMillis() - Client.timeShopSearchSent > 100) {
			if (Client.shopStringSent.equals(Client.shopString)) {
				return;
			}
			Client.shopStringSent = Client.shopString;
			String previous = Client.instance.inputString;
			Client.instance.inputString = "::shopsearch" + Client.shopString;
			Client.instance.stream.createFrame(103);
			Client.instance.stream.writeWordBigEndian(Client.instance.inputString.length() - 1);
			Client.instance.stream.writeString(Client.instance.inputString.substring(2));
			Client.instance.inputString = previous;
			Client.inputValue = -1;
			Client.timeShopSearchSent = System.currentTimeMillis();
		}

	}

	public static String combatDiffColor(int i, int j) {
		int k = i - j;
		if (k < -9)
			return "@red@";
		if (k < -6)
			return "@or3@";
		if (k < -3)
			return "@or2@";
		if (k < 0)
			return "@or1@";
		if (k > 9)
			return "@gre@";
		if (k > 6)
			return "@gr3@";
		if (k > 3)
			return "@gr2@";
		if (k > 0)
			return "@gr1@";
		else
			return "@yel@";
	}

	public static void drawBlackBox(int xPos, int yPos) {
		DrawingArea.drawPixels(71, yPos - 1, xPos - 2, 0x726451, 1);
		DrawingArea.drawPixels(69, yPos, xPos + 174, 0x726451, 1);
		DrawingArea.drawPixels(1, yPos - 2, xPos - 2, 0x726451, 178);
		DrawingArea.drawPixels(1, yPos + 68, xPos, 0x726451, 174);
		DrawingArea.drawPixels(71, yPos - 1, xPos - 1, 0x2E2B23, 1);
		DrawingArea.drawPixels(71, yPos - 1, xPos + 175, 0x2E2B23, 1);
		DrawingArea.drawPixels(1, yPos - 1, xPos, 0x2E2B23, 175);
		DrawingArea.drawPixels(1, yPos + 69, xPos, 0x2E2B23, 175);
		DrawingArea.method335(0, yPos, 174, 68, 220, xPos);
	}

	/**
	 * Delets a dir recursively deleting anything inside it.
	 * 
	 * @param dir
	 *            The dir to delete
	 * @return true if the dir was successfully deleted
	 */
	public static boolean deleteDirectory(File dir) {
		if (!dir.exists() || !dir.isDirectory()) {
			return false;
		}
		String[] files = dir.list();
		for (int i = 0, len = files.length; i < len; i++) {
			File f = new File(dir, files[i]);
			if (f.isDirectory()) {
				deleteDirectory(f);
			} else {
				f.delete();
			}
		}
		return dir.delete();
	}

	public static void shouldApplyScheduledDelete() {
		if (ClientDebugConfiguration.DEBUG_MODE) {
			return;
		}
		ArrayList<String> arraylist = Utility
				.readFile(ClientConstants.getRunecessorFolderLocation() + "schedule_delete.txt");
		if (arraylist.isEmpty()) {
			return;
		}
		Utility.deleteAllLines(ClientConstants.getRunecessorFolderLocation() + "schedule_delete.txt");
		Content.deleteDirectory(
				new File(ClientConstants.getRunecessorFolderLocation() + "/" + ClientConstants.getMainCacheVersion()));
	}

	public static void scheduleCacheDelete() {
		if (ClientDebugConfiguration.DEBUG_MODE) {
			return;
		}
		if (Client.cacheDeleteScheduled) {
			return;
		}
		Client.cacheDeleteScheduled = true;
		Utility.addLineOnTxt(ClientConstants.getRunecessorFolderLocation() + "schedule_delete.txt", "delete");
	}

	public static void deleteOldVersions() {
		if (ClientDebugConfiguration.LOCAL_CACHE) {
			return;
		}
		String version = ClientConstants.getMainCacheVersion().substring(1);
		int version1 = Integer.parseInt(version);
		for (int i = 0; i < version1; i++) {
			File firstFolder = new File(ClientConstants.getRunecessorFolderLocation() + "/v" + i);
			deleteDirectory(firstFolder);
		}
		String version3 = ClientConstants.getSpritesCacheVersion().substring(1);
		int version2 = Integer.parseInt(version3);
		for (int i = 0; i < version2; i++) {
			File firstFolder = new File(ClientConstants.getMainCacheLocation() + "cache_v" + i);
			deleteDirectory(firstFolder);
		}
	}
	public static void drawOnBankInterface() {
		// Only sent once per refresh, so not overusing resources at all.
		if (Client.getInterfaceDisplayed() == 24959) {
			if (RSInterface.interfaceCache[27000].message.equals("1")) {
				// Sent on bank opening etc, refresh tabs
				int tabs = Integer.parseInt(RSInterface.interfaceCache[27001].message); // #
																						// of
																						// tabs
																						// used
				int tab = Integer.parseInt(RSInterface.interfaceCache[27002].message); // current
																						// tab
																						// selected
				if (tab != Client.currentBankTab) {
					Client.scrollUp = true;
				}
				Client.currentBankTab = tab;
				for (int i = 0; i <= tabs; i++) {
					RSInterface.interfaceCache[22025 + i].sprite1 = Client.cacheSprite[391];
					RSInterface.interfaceCache[22025 + i].tooltip = "Click here to select tab " + (int) (i + 1);
				}
				for (int i = tabs + 1; i <= 8; i++) {
					RSInterface.interfaceCache[22024 + i].sprite1 = new Sprite("");
					RSInterface.interfaceCache[22024 + i].tooltip = "";
				}
				if (tabs != 8) {
					RSInterface.interfaceCache[22025 + tabs].sprite1 = Client.cacheSprite[392];
					RSInterface.interfaceCache[22025 + tabs].tooltip = "Drag an item here to create a new tab";
				}
				if (tab == -1) // searching
				{
					RSInterface.interfaceCache[22024].sprite1 = Client.cacheSprite[389];
				} else if (tab > 0) {
					RSInterface.interfaceCache[22024 + tab].sprite1 = Client.cacheSprite[390];
					RSInterface.interfaceCache[22024].sprite1 = Client.cacheSprite[389];
				} else {
					RSInterface.interfaceCache[22024].sprite1 = Client.cacheSprite[388];
				}
				RSInterface.interfaceCache[27000].message = "0";
			}
		}
	}

	public static void closeSearch(boolean toggleImage, boolean informServer) {
		if (!Client.searching) {
			return;
		}
		if (informServer) {
			Client.instance.sendCommandPacket("::stopsearch");
		}
		Client.searching = false;
		Client.setChatAreaInputBoxPlayerInput("");
		Client.bankSearchSent = "";
		Client.setChatAreaInputBoxTitle("");
		Client.setMessagePromptRaised(false, false);
		Client.setUpdateChatAreaPending(true);
		if (toggleImage) {
			Client.instance.anIntArray1045[116] = 0;
			if (Client.instance.variousSettings[116] != 0) {
				Client.instance.variousSettings[116] = 0;
				Client.instance.handleVarp(116);
				if (Client.instance.dialogId != -1) {
					Client.setUpdateChatAreaPending(true);
				}
			}
		}
	}

	public static void openSearch(String message) {
		Client.searching = true;
		Client.scrollUp = true;
		if (!Client.isIgnorePromptInputReset()) {
			Client.setChatAreaInputBoxPlayerInput("");
			Client.bankSearchSent = "";
		}
		Client.setChatAreaInputBoxTitle(message);
		Client.setMessagePromptRaised(true, false);
		Client.setUpdateChatAreaPending(true);
	}

	static void connectionLostAlert() {
		if (Client.contextMenu.equals("NEW")) {
			Client.cacheSprite[21].drawSprite(8, 9); // Connection lost, new
														// version.
		} else {
			DrawingArea.fillPixels(2, 130, 22, 0xffffff, 2);
			DrawingArea.drawPixels(20, 3, 3, 0, 128);
			Client.instance.aTextDrawingArea_1271.drawText(0, "Connection lost", 18, 55);
			Client.instance.aTextDrawingArea_1271.drawText(0xffffff, "Connection lost", 17, 54);
		}
	}

	public static void updateMusicVolume() {
		switch (Client.musicVolume) {
		case 0:
			Client.musicEnabled = false;
			Client.instance.variousSettings[168] = 4;
			break;
		case 1:
			Music.setMidiVolume(64);
			Client.instance.variousSettings[168] = 3;
			break;
		case 2:
			Music.setMidiVolume(128);
			Client.instance.variousSettings[168] = 2;
			break;
		case 3:
			Music.setMidiVolume(192);
			Client.instance.variousSettings[168] = 1;
			break;
		case 4:
			Music.setMidiVolume(256);
			Client.instance.variousSettings[168] = 0;
			break;
		}
	}

	public static void switchRaidPrayers() {
		RSInterface data = RSInterface.interfaceCache[5608];
		int eagleX1 = data.childX[44];
		int eagleX2 = data.childX[45];
		int eagleY1 = data.childY[44];
		int eagleY2 = data.childY[45];

		int mysticX1 = data.childX[46];
		int mysticX2 = data.childX[47];
		int mysticY1 = data.childY[46];
		int mysticY2 = data.childY[47];

		int auguryX1 = data.childX[59];
		int auguryX2 = data.childX[60];
		int auguryY1 = data.childY[59];
		int auguryY2 = data.childY[60];

		int rigourX1 = data.childX[57];
		int rigourX2 = data.childX[58];
		int rigourY1 = data.childY[57];
		int rigourY2 = data.childY[58];

		data.childX[44] = rigourX1;
		data.childY[44] = rigourY1;
		data.childX[45] = rigourX2 + 1;
		data.childY[45] = rigourY2 + 2;

		data.childX[57] = eagleX1;
		data.childY[57] = eagleY1;
		data.childX[58] = eagleX2 - 1;
		data.childY[58] = eagleY2 - 2;

		data.childX[46] = auguryX1;
		data.childY[46] = auguryY1;
		data.childX[47] = auguryX2 + 1;
		data.childY[47] = auguryY2 + 3;

		data.childX[59] = mysticX1;
		data.childY[59] = mysticY1;
		data.childX[60] = mysticX2 - 1;
		data.childY[60] = mysticY2 - 3;

		RSInterface hover = RSInterface.interfaceCache[22177];
		String eagle = hover.message;

		hover = RSInterface.interfaceCache[22178];
		String mystic = hover.message;

		hover = RSInterface.interfaceCache[22169];
		String rigour = hover.message;

		hover = RSInterface.interfaceCache[22170];
		String augury = hover.message;

		hover = RSInterface.interfaceCache[22177];
		hover.message = rigour;

		hover = RSInterface.interfaceCache[22178];
		hover.message = augury;

		hover = RSInterface.interfaceCache[22169];
		hover.message = eagle;

		hover = RSInterface.interfaceCache[22170];
		hover.message = mystic;

	}

	public static void mysteryBoxLoop() {
		if (Client.enableMysteryBox) {
			Client.mysteryBoxSpeed = 30;
			int subtract = Client.mysteryBoxTravelledTotal / Client.randomSpeedDividerMysteryBox;
			Client.mysteryBoxSpeed -= subtract;
			if (Client.mysteryBoxSpeed <= 0) {
				Client.mysteryBoxSpeed = 1;
			}
			int end = 2511 + Client.mysteryBoxOffset + Client.mysteryBoxRandomX - Client.mysteryBoxOffsetOther;
			if (Client.mysteryBoxTravelledTotal >= end) {
				// item model on mystery box interface.
				RSInterface.interfaceCache[26435].disableModel = false;
				Client.changeInterfaceSprite(26405, 814);
				Client.enableMysteryBox = false;
				if (Client.mysteryBoxOffset != 54) {
					Client.mysteryBoxOffset += 54;
				}
				Client.mysteryBoxOffsetOther = Client.mysteryBoxRandomX;
				Client.instance.sendCommandPacket("::mysteryboxend");
				// Means it bugged, so we can have reposition.
				if (Client.mysteryBoxTravelledTotal >= end) {
					int fixAmount = Client.mysteryBoxTravelledTotal - end;
					Client.mysteryBoxX += fixAmount;
				}
			} else {
				Client.mysteryBoxX -= Client.mysteryBoxSpeed;
				Client.mysteryBoxTravelledTotal += Client.mysteryBoxSpeed;
			}
		}

	}

	public static void gambleLoop() {
		if (Client.enableGamble) {
			Client.gambleSpeed = 30;
			int subtract = Client.gambleTravelledTotal / Client.randomSpeedDividerGamble;
			Client.gambleSpeed -= subtract;
			if (Client.gambleSpeed <= 0) {
				Client.gambleSpeed = 1;
			}
			int end = 2511 + Client.gambleOffset + Client.gambleRandomX - Client.gambleOffsetOther;
			if (Client.gambleTravelledTotal >= end) {
				// item model on Npc gamble interface.
				RSInterface.interfaceCache[26745].disableModel = false;
				Client.changeInterfaceSprite(26707, 801);
				Client.enableGamble = false;
				Client.instance.sendFrame126(Client.gambleXAmountWon, 26756);
				Client.gambleXAmountWon = "";
				if (Client.gambleOffset != 54) {
					Client.gambleOffset += 54;
				}
				Client.gambleOffsetOther = Client.gambleRandomX;
				Client.instance.sendCommandPacket("::gambleend");
				// Means it bugged, so we can have reposition.
				if (Client.gambleTravelledTotal >= end) {
					int fixAmount = Client.gambleTravelledTotal - end;
					Client.gambleX += fixAmount;
				}
			} else {
				Client.gambleX -= Client.gambleSpeed;
				Client.gambleTravelledTotal += Client.gambleSpeed;
			}
		}

	}

	public static void autoType() {
		if (!Client.autoType) {
			return;
		}

		if (System.currentTimeMillis() - Client.timeAutoTyped <= 3100) {
			return;
		}
		Client.timeAutoTyped = System.currentTimeMillis();
		Client.sendChat(Client.autoTypeText, true);
	}

}
