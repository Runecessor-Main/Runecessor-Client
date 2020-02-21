package Runecessor;

import java.util.HashMap;
import java.util.Map;


public class Interfaces {

	public static void customInterfaces(TextDrawingArea textDrawingAreas[]) {

		gambleItemsOverlayInterface(textDrawingAreas);
		npcDoublerInterface(textDrawingAreas);
		changepasswordInterface(textDrawingAreas);

		// Eco quest tab
		questTabInformationTabEco(textDrawingAreas);
		questTabPanelTabEco(textDrawingAreas);
		questTabActivitiesTabEco(textDrawingAreas);
		questTabQuestTabEco(textDrawingAreas);
		RSInterface.RandomTeleInt(textDrawingAreas);
		// Pvp quest tab
		questTabPvpInformation(textDrawingAreas);

		gameModeInterface(textDrawingAreas);
		//TeleportMenu.init(textDrawingAreas);
		donatorInterfaceBundlesTab(textDrawingAreas);
		donatorInterfaceNormalTab(textDrawingAreas);
		donatorInterfaceMainTab(textDrawingAreas);
		donatorNotification(textDrawingAreas);

		bonusXpInterface(textDrawingAreas);

		// Other
		duelArenaInterfaceModified(textDrawingAreas);
		mysteryBox(textDrawingAreas);
		cityPkingInterfacePvp(textDrawingAreas);
		cityPkingInterfaceSafe(textDrawingAreas);
		jewelry(textDrawingAreas);
		runePouch(textDrawingAreas);
		enchantBolts(textDrawingAreas);
		clientSettings(textDrawingAreas);
		clientSettings1(textDrawingAreas);
		clientSettings2(textDrawingAreas);
		clientSettings3(textDrawingAreas);
		clientSettings4(textDrawingAreas);
		clientSettings5(textDrawingAreas);
		equipmentScreenBank(textDrawingAreas);
		bankInterface(textDrawingAreas);
		itemsOnDeathDATA(textDrawingAreas);
		itemsOnDeath(textDrawingAreas);
		wildernessInterface(textDrawingAreas);
		
		barrowsInterface(textDrawingAreas);
		weaponTracker(textDrawingAreas);
		trade(textDrawingAreas);
		tournamentLobby(textDrawingAreas);
		Client.instance.drawLoadingText(682, Client.loadingGameString());
		shop(textDrawingAreas);
		emoteTab();

		equipmentTab(textDrawingAreas);
		optionTab(textDrawingAreas);
		clanChatTab(textDrawingAreas);
		combatInterfaces(textDrawingAreas);
		friendsTab(textDrawingAreas);
		ignoreTab(textDrawingAreas);
		equipmentScreen(textDrawingAreas);
		achievementOpenedInterface(textDrawingAreas);
		achievementRewards(textDrawingAreas);
		profileInterface(textDrawingAreas);
		profileInterface1(textDrawingAreas);
		profileInterface2(textDrawingAreas);
		profileInterface3(textDrawingAreas);
		profileInterface4(textDrawingAreas);
		Client.instance.drawLoadingText(724, Client.loadingGameString());
		gwdInterface(textDrawingAreas);
		quickSetUpInterface(textDrawingAreas);
		dropDownTest(textDrawingAreas);

		questInterface(textDrawingAreas);
		highscoresInterface1(textDrawingAreas);
		completionistCape(textDrawingAreas);
		lootingBag(textDrawingAreas);
		titleInterface(textDrawingAreas);
		clanChatSetUp(textDrawingAreas);
		teleportInterface(textDrawingAreas);
		hallOfFame(textDrawingAreas);
		resizableSettings(textDrawingAreas);
		zombieInterface(textDrawingAreas);
		zombieReadyInterface(textDrawingAreas);
		guideInterface(textDrawingAreas);
		interfaceResizableClicking(textDrawingAreas);
		pvpBlacklist(textDrawingAreas);
		gamblingRules(textDrawingAreas);
		donatorTokensTradingPost(textDrawingAreas);
		TournamentInfo(textDrawingAreas);
		TournamentInfo1(textDrawingAreas);
		TournamentInfo2(textDrawingAreas);
		TournamentInfo3(textDrawingAreas);
		priceChecker(textDrawingAreas);
		orbChargingInterface(textDrawingAreas);
		obeliskInterface(textDrawingAreas);
		questInformation(textDrawingAreas);
		kdrOverlay(textDrawingAreas);
		spinning(textDrawingAreas);
		lootKeyInterface(textDrawingAreas);
		petMysteryBox(textDrawingAreas);
		untradeableRepairing(textDrawingAreas);
		updatesListInterface(textDrawingAreas);
		EcoQuickSetup(textDrawingAreas);
		EcoQuickSetupChar(textDrawingAreas);
		colourChanger(textDrawingAreas);
		npcDropTable(textDrawingAreas);
		levelUpFix(textDrawingAreas);
		itemOverlaySettings(textDrawingAreas);

		ancientMagicTab(textDrawingAreas);
		ancientMagicTab1(textDrawingAreas);
		ancientMagicTab2(textDrawingAreas);

		configureLunar(textDrawingAreas);

		magicBottomComponent(textDrawingAreas);
		modernSpellBookPreEoc(textDrawingAreas);

		if (Config.PRE_EOC) {
			/*
			 * Summoning
			 */
			familiarDetails(textDrawingAreas);
			petDetails(textDrawingAreas);
			bobStorage(textDrawingAreas);
			/*
			 * Bank booth
			 */
			depositBoothPreEoc(textDrawingAreas);
			/*
			 * Spell books
			 */
			RSInterface.miasmics();
			magicBottomComponent(textDrawingAreas);
			ancientMagicTabPreEoc(textDrawingAreas);
			modernSpellBookPreEoc(textDrawingAreas);
			/*
			 * Prayer books
			 */
			normalPrayerBookPreEoc(textDrawingAreas);
			curseTab(textDrawingAreas);
			/*
			 * Quick prayers
			 */
			normalQuickPrayerBookPreEoc(textDrawingAreas);
			cursesQuickPrayerBookPreEoc(textDrawingAreas);
			// skillTab602(textDrawingAreas);
		} else {
			skillTab474(RSInterface.fonts);
			modernSpellBook(textDrawingAreas);
			normalPrayerBook(textDrawingAreas);
			quickPrayers(textDrawingAreas);
		}
	}

	private static void gambleItemsOverlayInterface(TextDrawingArea[] textDrawingAreas) {
		int interfaceId = 25584;
		RSInterface.interfaceCache[interfaceId] = new RSInterface();
		RSInterface.interfaceCache[interfaceId].children = new int[1];
		RSInterface.interfaceCache[interfaceId].childX = new int[1];
		RSInterface.interfaceCache[interfaceId].childY = new int[1];
		RSInterface.interfaceCache[interfaceId].children[0] = interfaceId + 1;
		RSInterface.interfaceCache[interfaceId].childX[0] = 16;
		RSInterface.interfaceCache[interfaceId].childY[0] = 8;

		RSInterface.interfaceCache[interfaceId].id = interfaceId;
		RSInterface.interfaceCache[interfaceId].height = 334;
		RSInterface.interfaceCache[interfaceId].isMouseoverTriggered = -1;
		RSInterface.interfaceCache[interfaceId].parentId = interfaceId;
		RSInterface.interfaceCache[interfaceId].width = 512;

		interfaceId++;
		RSInterface.interfaceCache[interfaceId] = new RSInterface();//
		RSInterface.interfaceCache[interfaceId].actions = new String[5];
		RSInterface.interfaceCache[interfaceId].actions[0] = "Gamble 1";
		RSInterface.interfaceCache[interfaceId].actions[1] = "Gamble 5";
		RSInterface.interfaceCache[interfaceId].actions[2] = "Gamble 10";
		RSInterface.interfaceCache[interfaceId].actions[3] = "Gamble All";
		RSInterface.interfaceCache[interfaceId].actions[4] = "Gamble X";
		RSInterface.interfaceCache[interfaceId].inv = new int[28];
		RSInterface.interfaceCache[interfaceId].invStackSizes = new int[28];//
		RSInterface.interfaceCache[interfaceId].inv[0] = 0;
		RSInterface.interfaceCache[interfaceId].invStackSizes[0] = 0;

		RSInterface.interfaceCache[interfaceId].inv[1] = 0;
		RSInterface.interfaceCache[interfaceId].invStackSizes[1] = 0;

		RSInterface.interfaceCache[interfaceId].inv[2] = 0;
		RSInterface.interfaceCache[interfaceId].invStackSizes[2] = 0;

		RSInterface.interfaceCache[interfaceId].inv[3] = 0;
		RSInterface.interfaceCache[interfaceId].invStackSizes[3] = 0;

		RSInterface.interfaceCache[interfaceId].inv[4] = 0;
		RSInterface.interfaceCache[interfaceId].invStackSizes[4] = 0;

		RSInterface.interfaceCache[interfaceId].inv[5] = 0;
		RSInterface.interfaceCache[interfaceId].invStackSizes[5] = 0;

		RSInterface.interfaceCache[interfaceId].inv[6] = 0;
		RSInterface.interfaceCache[interfaceId].invStackSizes[6] = 0;

		RSInterface.interfaceCache[interfaceId].inv[7] = 0;
		RSInterface.interfaceCache[interfaceId].invStackSizes[7] = 0;

		RSInterface.interfaceCache[interfaceId].inv[8] = 0;
		RSInterface.interfaceCache[interfaceId].invStackSizes[8] = 0;

		RSInterface.interfaceCache[interfaceId].inv[9] = 0;
		RSInterface.interfaceCache[interfaceId].invStackSizes[9] = 0;

		RSInterface.interfaceCache[interfaceId].inv[10] = 0;
		RSInterface.interfaceCache[interfaceId].invStackSizes[10] = 0;

		RSInterface.interfaceCache[interfaceId].inv[11] = 0;
		RSInterface.interfaceCache[interfaceId].invStackSizes[11] = 0;

		RSInterface.interfaceCache[interfaceId].inv[12] = 0;
		RSInterface.interfaceCache[interfaceId].invStackSizes[12] = 0;

		RSInterface.interfaceCache[interfaceId].inv[13] = 0;
		RSInterface.interfaceCache[interfaceId].invStackSizes[13] = 0;

		RSInterface.interfaceCache[interfaceId].inv[14] = 0;
		RSInterface.interfaceCache[interfaceId].invStackSizes[14] = 0;

		RSInterface.interfaceCache[interfaceId].inv[15] = 0;
		RSInterface.interfaceCache[interfaceId].invStackSizes[15] = 0;

		RSInterface.interfaceCache[interfaceId].inv[16] = 0;
		RSInterface.interfaceCache[interfaceId].invStackSizes[16] = 0;

		RSInterface.interfaceCache[interfaceId].inv[17] = 0;
		RSInterface.interfaceCache[interfaceId].invStackSizes[17] = 0;

		RSInterface.interfaceCache[interfaceId].inv[18] = 0;
		RSInterface.interfaceCache[interfaceId].invStackSizes[18] = 0;

		RSInterface.interfaceCache[interfaceId].inv[19] = 0;
		RSInterface.interfaceCache[interfaceId].invStackSizes[19] = 0;

		RSInterface.interfaceCache[interfaceId].inv[20] = 0;
		RSInterface.interfaceCache[interfaceId].invStackSizes[20] = 0;

		RSInterface.interfaceCache[interfaceId].inv[21] = 0;
		RSInterface.interfaceCache[interfaceId].invStackSizes[21] = 0;

		RSInterface.interfaceCache[interfaceId].inv[22] = 0;
		RSInterface.interfaceCache[interfaceId].invStackSizes[22] = 0;

		RSInterface.interfaceCache[interfaceId].inv[23] = 0;
		RSInterface.interfaceCache[interfaceId].invStackSizes[23] = 0;

		RSInterface.interfaceCache[interfaceId].inv[24] = 0;
		RSInterface.interfaceCache[interfaceId].invStackSizes[24] = 0;

		RSInterface.interfaceCache[interfaceId].inv[25] = 0;
		RSInterface.interfaceCache[interfaceId].invStackSizes[25] = 0;

		RSInterface.interfaceCache[interfaceId].inv[26] = 0;
		RSInterface.interfaceCache[interfaceId].invStackSizes[26] = 0;

		RSInterface.interfaceCache[interfaceId].inv[27] = 0;
		RSInterface.interfaceCache[interfaceId].invStackSizes[27] = 0;

		RSInterface.interfaceCache[interfaceId].spritesX = new int[20];
		RSInterface.interfaceCache[interfaceId].spritesY = new int[20];
		RSInterface.interfaceCache[interfaceId].spritesX[0] = 0;
		RSInterface.interfaceCache[interfaceId].spritesY[0] = 0;

		RSInterface.interfaceCache[interfaceId].spritesX[1] = 0;
		RSInterface.interfaceCache[interfaceId].spritesY[1] = 0;

		RSInterface.interfaceCache[interfaceId].spritesX[2] = 0;
		RSInterface.interfaceCache[interfaceId].spritesY[2] = 0;

		RSInterface.interfaceCache[interfaceId].spritesX[3] = 0;
		RSInterface.interfaceCache[interfaceId].spritesY[3] = 0;

		RSInterface.interfaceCache[interfaceId].spritesX[4] = 0;
		RSInterface.interfaceCache[interfaceId].spritesY[4] = 0;

		RSInterface.interfaceCache[interfaceId].spritesX[5] = 0;
		RSInterface.interfaceCache[interfaceId].spritesY[5] = 0;

		RSInterface.interfaceCache[interfaceId].spritesX[6] = 0;
		RSInterface.interfaceCache[interfaceId].spritesY[6] = 0;

		RSInterface.interfaceCache[interfaceId].spritesX[7] = 0;
		RSInterface.interfaceCache[interfaceId].spritesY[7] = 0;

		RSInterface.interfaceCache[interfaceId].spritesX[8] = 0;
		RSInterface.interfaceCache[interfaceId].spritesY[8] = 0;

		RSInterface.interfaceCache[interfaceId].spritesX[9] = 0;
		RSInterface.interfaceCache[interfaceId].spritesY[9] = 0;

		RSInterface.interfaceCache[interfaceId].spritesX[10] = 0;
		RSInterface.interfaceCache[interfaceId].spritesY[10] = 0;

		RSInterface.interfaceCache[interfaceId].spritesX[11] = 0;
		RSInterface.interfaceCache[interfaceId].spritesY[11] = 0;

		RSInterface.interfaceCache[interfaceId].spritesX[12] = 0;
		RSInterface.interfaceCache[interfaceId].spritesY[12] = 0;

		RSInterface.interfaceCache[interfaceId].spritesX[13] = 0;
		RSInterface.interfaceCache[interfaceId].spritesY[13] = 0;

		RSInterface.interfaceCache[interfaceId].spritesX[14] = 0;
		RSInterface.interfaceCache[interfaceId].spritesY[14] = 0;

		RSInterface.interfaceCache[interfaceId].spritesX[15] = 0;
		RSInterface.interfaceCache[interfaceId].spritesY[15] = 0;

		RSInterface.interfaceCache[interfaceId].spritesX[16] = 0;
		RSInterface.interfaceCache[interfaceId].spritesY[16] = 0;

		RSInterface.interfaceCache[interfaceId].spritesX[17] = 0;
		RSInterface.interfaceCache[interfaceId].spritesY[17] = 0;

		RSInterface.interfaceCache[interfaceId].spritesX[18] = 0;
		RSInterface.interfaceCache[interfaceId].spritesY[18] = 0;

		RSInterface.interfaceCache[interfaceId].spritesX[19] = 0;
		RSInterface.interfaceCache[interfaceId].spritesY[19] = 0;

		RSInterface.interfaceCache[interfaceId].spellName = "@gre@@whi@";
		RSInterface.interfaceCache[interfaceId].itemsAreDraggable = true;
		RSInterface.interfaceCache[interfaceId].id = interfaceId;
		RSInterface.interfaceCache[interfaceId].height = 7;
		RSInterface.interfaceCache[interfaceId].invSpritePadX = 10;
		RSInterface.interfaceCache[interfaceId].invSpritePadY = 4;
		RSInterface.interfaceCache[interfaceId].isMouseoverTriggered = -1;
		RSInterface.interfaceCache[interfaceId].parentId = interfaceId - 1;
		RSInterface.interfaceCache[interfaceId].type = 2;
		RSInterface.interfaceCache[interfaceId].width = 4;
	}
	private static void changepasswordInterface(TextDrawingArea[] textDrawingAreas) {
		int textAmountFirst = 3;
		int totalChildren = 12 + textAmountFirst;
		int interfaceId = 35067;
		int child = 0;
		int xOffset = 17;
		int yOffset = -35;
		RSInterface.addText(41_090, "0", textDrawingAreas, 0, ClientConstants.YELLOW,
				false);

		RSInterface interfaces = RSInterface.addInterface(interfaceId, 70, 448, 20, 322);
		interfaceId++;

		RSInterface.setChildren(totalChildren, interfaces);

		RSInterface.addSprite(interfaceId, 1281);
		RSInterface.setBounds(interfaceId, 50 + xOffset, 50 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Change password", textDrawingAreas, 2, ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 245 + xOffset, 58 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "ALERT", textDrawingAreas, 2, ClientConstants.RED, true);
		RSInterface.setBounds(interfaceId, 237 + xOffset, 90 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Please make sure don't use old rsps password", textDrawingAreas, 1, ClientConstants.RED, true);
		RSInterface.setBounds(interfaceId, 237 + xOffset, 105 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "next if you do not take action!", textDrawingAreas, 1, ClientConstants.RED, true);
		RSInterface.setBounds(interfaceId, 237 + xOffset, 119 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		String[] reasonText = {
				"Players get hacked because they use the same password from another",
				"website/game. Thousands of Runescape and non-runescape related",
				"databases have been hacked and leaked for hackers to use.",
		};
		for (int index = 0; index < textAmountFirst; index++) {
			RSInterface.addText(interfaceId, reasonText[index], textDrawingAreas, 0, ClientConstants.ORANGE, false);
			RSInterface.setBounds(interfaceId, 63 + xOffset, 145 + yOffset + (index * 15), child, interfaces);
			interfaceId++;
			child++;
		}

		String[] protectText = {
				"@yel@Never use the same password from another website/game, even if",
				"@yel@the usernames are different!",
				"",
				"If a player asks you for your username on another website/game",
				"do not give them it because they can easily find your password",
				"on this website/game by going through its leaked database.",
				"",
				"You must now use a new password that you have not used on any",
				"other website/game. If you are unsure weather your current",
				"password is safe, it is best to change it to a unique",
				"password you have not used before.",
				"",
				"Before typing in a new password, please write it down on a piece of",
				"paper or on a text document on your Pc.",
		};
		RSInterface scrollTab1 = RSInterface.addInterface(interfaceId);
		interfaces.child(child, interfaceId, 46 + xOffset, 193 + yOffset); // Scroll
		interfaceId++;
		child++;
		int scrollChildren = protectText.length + 1;
		scrollTab1.totalChildren(scrollChildren);
		int lengthIncrease = 15;

		RSInterface.addText(interfaceId, "How to protect myself?", textDrawingAreas, 2, ClientConstants.PALE_GREEN, false);
		scrollTab1.child(0, interfaceId, 90 + xOffset, 38 + yOffset);
		interfaceId++;

		for (int index = 0; index < protectText.length; index++) {
			RSInterface.addText(interfaceId, protectText[index], textDrawingAreas, 0, ClientConstants.ORANGE, false);
			scrollTab1.child(index + 1, interfaceId, 0 + xOffset, 58 + yOffset + (index * lengthIncrease));
			interfaceId++;
		}
		scrollTab1.width = 355;
		scrollTab1.height = 126;
		scrollTab1.scrollMax = (scrollChildren * lengthIncrease) + 22;

		int keepButtonX = 44;
		RSInterface.addHoverButtonComplete(interfaceId, child, 200 + xOffset + keepButtonX, 320 + yOffset, 746, 749, 120, 26, "Select", interfaces, true);
		interfaceId += 3;
		child += 2;

		RSInterface.addText(interfaceId, "Keep password", textDrawingAreas, 1, ClientConstants.YELLOW, true);
		RSInterface.setBounds(interfaceId, 258 + xOffset + keepButtonX, 324 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		int passwordButtonX = 45;
		RSInterface.addHoverButtonComplete(interfaceId, child, 70 + xOffset + passwordButtonX, 320 + yOffset, 746, 749, 120, 26, "Select", interfaces, true);
		interfaceId += 3;
		child += 2;

		RSInterface.addText(interfaceId, "Change password", textDrawingAreas, 1, ClientConstants.PALE_GREEN, true);
		RSInterface.setBounds(interfaceId, 128 + xOffset + passwordButtonX, 324 + yOffset, child, interfaces);
		interfaceId++;
		child++;
	}

	private static void dropDownTest(TextDrawingArea[] TDA) {
		RSInterface component = RSInterface.addInterface(44444);
		RSInterface.addDropMenu(44445, 208, 26, "Title", TDA,
				new RSMenuItem(Client.cacheSprite[458], "Item 1"),
				new RSMenuItem(Client.cacheSprite[459], "Item 2"));
		RSInterface.setChildren(1, component);
		RSInterface.setBounds(44445, 512 / 2 - 60 - 12, 334 / 2 - 75, 0, component);
	}


	private static void bonusXpInterface(TextDrawingArea[] textDrawingAreas) {
		int totalChildren = 3;
		int interfaceId = 21370;
		int originalInterfaceId = interfaceId;
		int child = 0;
		int xOffset = -169;
		int yOffset = -66;

		RSInterface interfaces = RSInterface.addInterface(interfaceId, 0, 0, 0, 0);
		interfaceId++;

		RSInterface.setChildren(totalChildren, interfaces);

		RSInterface.addTransparentSprite(interfaceId, 1135, 200);
		RSInterface.setBounds(interfaceId, 398 + xOffset, 68 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Bonus xp: ", textDrawingAreas, 0, ClientConstants.YELLOW, false);
		RSInterface.setTextCountdown(originalInterfaceId, interfaceId);
		RSInterface.setBounds(interfaceId, 401 + xOffset, 71 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "", textDrawingAreas, 0, ClientConstants.YELLOW, false);
		RSInterface.setTextCountdown(originalInterfaceId, interfaceId);
		RSInterface.setBounds(interfaceId, 454 + xOffset, 71 + yOffset, child, interfaces);
		interfaceId++;
		child++;
	}


	private static void bobStorage(TextDrawingArea[] tda) {
		int frame = 0;
		int id = 33_500;

		RSInterface tab = RSInterface.addInterface(id++);
		tab.totalChildren(6);

		RSInterface.addSprite(id, 1017);
		tab.child(frame++, id++, 71, 14);

		tab.child(frame++, 7423, 114, 85);

		tab.child(frame++, 40002, 418, 21);
		tab.child(frame++, 40003, 418, 21);

		RSInterface storage = RSInterface.itemGroup(id, 6, 5, 22, 22);
		storage.actions = new String[5];
		storage.actions =
				new String[] {"Withdraw 1", "Withdraw 5", "Withdraw 10", "Withdraw All", "Withdraw X",};
		tab.child(frame++, id++, 87, 58);

		RSInterface.addButton(id, 1134, "Withdraw All");
		tab.child(frame++, id++, 412, 288);

	}

	private static void depositBoothPreEoc(TextDrawingArea[] tda) {
		int frame = 0;
		int id = 33_444;

		RSInterface tab = RSInterface.addInterface(id++);
		tab.totalChildren(13);

		RSInterface.addSprite(id, 1092);
		tab.child(frame++, id++, 74, 30);

		tab.child(frame++, 7423, 114, 85);
		tab.child(frame++, 7421, 135, 36);

		tab.child(frame++, 40002, 415, 38);
		tab.child(frame++, 40003, 415, 38);

		tab.child(frame++, 22012, 333 - 51, 297 - 27);
		tab.child(frame++, 22013, 333 - 51, 297 - 27);

		tab.child(frame++, 22016, 373 - 54, 297 - 27);
		tab.child(frame++, 22017, 373 - 54, 297 - 27);

		RSInterface.addHoverButton(id, 1080, 35, 25, "Deposit familiar", -1, id + 1, 1);
		RSInterface.addHoveredButton(id + 1, 1081, 35, 25, id + 2);
		tab.child(frame++, id, 356, 297 - 27);
		tab.child(frame++, id + 1, 356, 297 - 27);
		id += 3;

		RSInterface.addHoverButton(id, 1082, 35, 25, "Deposit money pouch", -1, id + 1, 1);
		RSInterface.addHoveredButton(id + 1, 1083, 35, 25, id + 2);
		tab.child(frame++, id, 393, 297 - 27);
		tab.child(frame++, id + 1, 393, 297 - 27);
		id += 3;
	}

	public static void modernSpellBookPreEoc(TextDrawingArea[] tda) {
		RSInterface hover = RSInterface.addTabInterface(1151);

		hover.totalChildren(2);
		hover.child(0, 37333, 0, 0);
		hover.child(1, 34933, 0, 0);

		RSInterface tab = RSInterface.addTabInterface(37333);
		tab.scrollMax = 0;// 290
		tab.height = 229;
		tab.width = 200; // 173
		RSInterface homeHover = RSInterface.addTabInterface(1196);

		int[] spellButton = {1196, 1199, 1206, 1215, 1224, 1231, 1240, 1249, 1258, 1267, 1274, 1283,
				1573, 1290, 1299, 1308, 1315, 1324, 1333, 1340, 1349, 1358, 1367, 1374, 1381, 1388,
				1397, 1404, 1583, 12038, 1414, 1421, 1430, 1437, 1446, 1453, 1460, 1469, 15878, 1602,
				1613, 1624, 7456, 1478, 1485, 1494, 1503, 1512, 1521, 1530, 1544, 1553, 1563, 1593,
				1635, 12426, 12436, 12446, 12456, 6004, 18471};

		tab.totalChildren(spellButton.length + SpellBookManager.SpellBook.MODERN.getNormal().length);

		int frame = 0;

		int x = -10;
		int y = 10;

		for (int spell : SpellBookManager.SpellBook.MODERN.getNormal()) {

			if (x >= 23 * 6 - 10) {
				x = -10;
				y += 24;
			}
			x += 25;
			tab.child(frame, spell, x, y);
			frame++;
		}

		for (int i1 = 0; i1 < spellButton.length; i1++) {
			int yPos = i1 > 34 ? 8 : 183;
			tab.child(frame, spellButton[i1], 5, yPos);
			frame++;
		}

		RSInterface.addButton(1195, 1077, "Cast @gre@Home Teleport");
		RSInterface homeButton = RSInterface.interfaceCache[1195];
		homeButton.isMouseoverTriggered = 1196;
		homeHover.invisible = true;
		RSInterface.addText(1197, Config.serverNames[Config.currentServer] + " Home Teleport", tda, 1, 0xFE981F, true, true);
		RSInterface homeLevel = RSInterface.interfaceCache[1197];
		homeLevel.width = 174;
		homeLevel.height = 68;
		RSInterface.addText(1198, "A teleport which requires no", tda, 0, 0xAF6A1A, true, true);
		RSInterface.addText(18998, "runes and no required level that", tda, 0, 0xAF6A1A, true, true);
		RSInterface.addText(18999, "teleports you to the main land.", tda, 0, 0xAF6A1A, true, true);
		homeHover.totalChildren(4);
		homeHover.child(0, 1197, 3, 4);
		homeHover.child(1, 1198, 91, 23);
		homeHover.child(2, 18998, 91, 34);
		homeHover.child(3, 18999, 91, 45);
	}

	public static void cursesQuickPrayerBookPreEoc(TextDrawingArea[] TDA) {
		RSInterface tab = RSInterface.addTabInterface(34_200);
		RSInterface.addSprite(17201, 147);
		RSInterface.addText(17230, "Select your quick prayers:", TDA, 0, 0xff981f, false, true);
		RSInterface.addTransparentSprite(17229, 245, 50);
		RSInterface.addHoverButton(17231, 248, 190, 24, "Confirm Selection", -1, 17232, 1);
		RSInterface.addHoveredButton(17232, 249, 190, 24, 17233);
		RSInterface.setChildren(46, tab);
		int id = 34_700;
		int frame = 0;
		int x = 8;
		int y = 43;
		int[] SPRITE_ORDER = {1021, 1023, 1059, 1025, 1027, 1029, 1031, 1033, 1035, 1037, 1039, 1041,
				1043, 1045, 1047, 1049, 1051, 1053, 1055, 1057};
		for (int l = 0; l < SPRITE_ORDER.length; l++) {
			int spriteId = SPRITE_ORDER[l];
			Sprite sprite = RSInterface.getSprite(id, spriteId);
			int centerX = 3 + sprite.myWidth / 2;
			int centerY = sprite.myHeight / 2;
			if (x > 160) {
				x = 8;
				y += 35;
			}
			RSInterface.setBounds(id++, x, y - centerY, frame++, tab);
			RSInterface.addConfigButton(id, 34_565, 247, 246, 14, 15, "Select", 0, 1, 690 + l);
			RSInterface.setBounds(id++, x - 3, y - centerY - 3, frame++, tab);
			x += 20 + centerX;
		}
		RSInterface.setBounds(17229, 0, 25, frame++, tab);
		RSInterface.setBounds(17201, 0, 22, frame++, tab);
		RSInterface.setBounds(17201, 0, 237, frame++, tab);
		RSInterface.setBounds(17230, 5, 5, frame++, tab);
		RSInterface.setBounds(17231, 0, 237, frame++, tab);
		RSInterface.setBounds(17232, 0, 237, frame++, tab);
		Utility.print("curse frame: " + frame);
	}

	public static void normalQuickPrayerBookPreEoc(TextDrawingArea[] TDA) {
		RSInterface tab = RSInterface.addTabInterface(22923);
		RSInterface.addSprite(17201, 147);
		RSInterface.addText(17230, "Select your quick prayers:", TDA, 0, 0xff981f, false, true);
		RSInterface.addTransparentSprite(17229, 245, 50);
		RSInterface.addHoverButton(17231, 248, 190, 24, "Confirm Selection", -1, 17232, 1);
		RSInterface.addHoveredButton(17232, 249, 190, 24, 17233);
		RSInterface.setChildren(66, tab);
		int id = 34_565;
		int frame = 0;
		int x = 8;
		int y = 43;
		int[] SPRITE_ORDER = {1093, 1094, 1095, 1111, 1112, 1096, 1097, 1098, 1099, 1100, 1101, 1113,
				1114, 1102, 1103, 1104, 1074, 1105, 1106, 1107, 1115, 1116, 1109, 1108, 1110, 1117,
				1072, 1118, 725, 726};
		for (int l = 0; l < SPRITE_ORDER.length; l++) {
			int spriteId = SPRITE_ORDER[l];
			Sprite sprite = RSInterface.getSprite(id, spriteId);
			int centerX = 3 + sprite.myWidth / 2;
			int centerY = sprite.myHeight / 2;
			if (x > 160) {
				x = 8;
				y += 35;
			}
			RSInterface.setBounds(id++, x, y - centerY, frame++, tab);
			RSInterface.addConfigButton(id, 34_565, 247, 246, 14, 15, "Select", 0, 1, 650 + l);
			RSInterface.setBounds(id++, x - 3, y - centerY - 3, frame++, tab);
			x += 20 + centerX;
		}
		RSInterface.setBounds(17229, 0, 25, frame++, tab);
		RSInterface.setBounds(17201, 0, 22, frame++, tab);
		RSInterface.setBounds(17201, 0, 237, frame++, tab);
		RSInterface.setBounds(17230, 5, 5, frame++, tab);
		RSInterface.setBounds(17231, 0, 237, frame++, tab);
		RSInterface.setBounds(17232, 0, 237, frame++, tab);
	}

	public static void normalPrayerBookPreEoc(TextDrawingArea[] tda) {

		RSInterface tab1 = RSInterface.addTabInterface(35800);
		tab1.totalChildren(7);

		RSInterface.setBounds(38439, 0, 0, 0, tab1);
		RSInterface.setBounds(22784, 0, 223, 1, tab1);
		RSInterface.setBounds(22782, 60, 227, 2, tab1);
		RSInterface.setBounds(28786, 0, 3, 3, tab1);

		tab1.child(4, 5651, 65, 243);
		tab1.child(5, 687, 20, 242);
		tab1.child(6, 22043, 65, 236);

		RSInterface tab = RSInterface.addTabInterface(38439);
		RSInterface currentPray = RSInterface.interfaceCache[687];
		currentPray.textColour = 0xFF981F;
		currentPray.textShadow = true;
		currentPray.message = "%1/%2";
		RSInterface.addSprite(5651, 232);
		int xOffset = -3;
		int yOffset = 5;
		// These are the glow locations
		RSInterface.addPrayer(18000, 0, 601, 7, 1111, 401, "Sharp Eye");
		RSInterface.addPrayer(18002, 0, 602, 8, 1112, 402, "Mystic Will");
		RSInterface.addPrayer(18004, 0, 603, 25, 1113, 403, "Hawk Eye");
		RSInterface.addPrayer(18006, 0, 604, 26, 1114, 404, "Mystic Lore");
		RSInterface.addPrayer(18008, 0, 605, 43, 1115, 405, "Eagle Eye");
		RSInterface.addPrayer(18010, 0, 606, 44, 1116, 406, "Mystic Might");
		RSInterface.addPrayer(18012, 0, 607, 59, 1117, 407, "Chivalry");
		RSInterface.addPrayer(18014, 0, 608, 69, 1118, 408, "Piety");
		RSInterface.addPrayer(32930, 0, 609, 64, 1072, 1073, "Rapid Renewal");
		RSInterface.addPrayer(22962, 0, 610, 73, 725, 728, "Rigour");
		RSInterface.addPrayer(22964, 0, 611, 76, 726, 729, "Augury");
		RSInterface.addSpriteOld(22043, "Prayer/ICON 0");

		tab.totalChildren(93);

		/* Buttons/glows */
		tab.child(0, 5609, 6 + xOffset, -1 + yOffset); // Thick skin
		tab.child(1, 5610, 43 + xOffset, -1 + yOffset);
		tab.child(2, 5611, 80 + xOffset, -1 + yOffset);
		tab.child(3, 5612, 6 + xOffset, 36 + yOffset); // Rock skin
		tab.child(4, 5613, 43 + xOffset, 36 + yOffset);
		tab.child(5, 5614, 80 + xOffset, 36 + yOffset);
		tab.child(6, 5615, 117 + xOffset, 36 + yOffset); // Rapid restore
		tab.child(7, 5616, 154 + xOffset, 36 + yOffset); // Rapid heal
		tab.child(8, 5617, 6 + xOffset, 72 + yOffset); // Protect item
		tab.child(9, 5618, 117 + xOffset, 73 + yOffset); // Steel skin
		tab.child(10, 5619, 154 + xOffset, 74 + yOffset); // Ultimate strength
		tab.child(11, 5620, 6 + xOffset, 110 + yOffset);

		tab.child(12, 5621, 80 + xOffset, 110 + yOffset); // prot from mag
		tab.child(13, 5622, 118 + xOffset, 110 + yOffset); // prot fro range
		tab.child(14, 5623, 154 + xOffset, 110 + yOffset); // Protect from melee

		tab.child(30, 5644, 82 + xOffset, 112 + yOffset); // Protect from magic
		tab.child(31, 686, 120 + xOffset, 112 + yOffset); // Protect from ranged
		tab.child(32, 5645, 156 + xOffset, 112 + yOffset); // Protect from melee

		/* Sprites */
		tab.child(18, 5632, 8 + xOffset, 1 + yOffset); // Thick skin
		tab.child(19, 5633, 45 + xOffset, 1 + yOffset);
		tab.child(20, 5634, 82 + xOffset, 1 + yOffset);
		tab.child(21, 5635, 8 + xOffset, 38 + yOffset); // Rock skin
		tab.child(22, 5636, 45 + xOffset, 38 + yOffset); // Superhuman strength
		tab.child(23, 5637, 82 + xOffset, 38 + yOffset); // Improved reflexes
		tab.child(24, 5638, 119 + xOffset, 38 + yOffset); // Rapid restore
		tab.child(25, 5639, 156 + xOffset, 38 + yOffset); // Rapid heal
		tab.child(26, 5640, 8 + xOffset, 75 + yOffset); // Protect item
		tab.child(27, 5641, 119 + xOffset, 75 + yOffset); // Steel skin
		tab.child(28, 5642, 156 + xOffset, 75 + yOffset); // Ultimate strength
		tab.child(29, 5643, 8 + xOffset, 112 + yOffset); // Ultimate reflexes

		tab.child(46, 18010, 43 + xOffset, 149 + yOffset); // Mystic might
		tab.child(47, 18011, 45 + xOffset, 152 + yOffset); // Mystic might

		tab.child(33, 5649, 82 + xOffset, 149 + yOffset); // Retribution
		tab.child(34, 5647, 120 + xOffset, 149 + yOffset); // Redemption
		tab.child(35, 5648, 155 + xOffset, 149 + yOffset); // Smite

		tab.child(15, 683, 80 + xOffset, 149 + yOffset); // Retribution
		tab.child(16, 684, 118 + xOffset, 147 + yOffset); // Redemption
		tab.child(17, 685, 153 + xOffset, 147 + yOffset); // Smite
		/* New prayers */
		tab.child(36, 18000, 117 + xOffset, -1 + yOffset); // Even number is
		// prayer glow.
		// Sharp eye
		tab.child(37, 18001, 120 + xOffset, 3 + yOffset); // Odd number is
		// prayer off. Sharp
		// eye
		tab.child(38, 18002, 154 + xOffset, 1 + yOffset); // Mystic will
		tab.child(39, 18003, 157 + xOffset, 4 + yOffset); // Mystic will
		tab.child(40, 18004, 43 + xOffset, 73 + yOffset); // Hawk eye
		tab.child(41, 18005, 46 + xOffset, 77 + yOffset); // Hawk eye
		tab.child(42, 18006, 80 + xOffset, 73 + yOffset); // Mystic lore
		tab.child(43, 18007, 83 + xOffset, 78 + yOffset); // Mystic lore

		tab.child(44, 18008, 6 + xOffset, 149 + yOffset); // Eagle eye
		tab.child(45, 18009, 9 + xOffset, 152 + yOffset);// Eagle eye

		tab.child(55, 18012, 7 + xOffset, 180 + yOffset); // Rapid renewal
		tab.child(56, 18013, 14 + xOffset, 184 + yOffset); // Rapid renewal

		tab.child(48, 32930, 43 + xOffset, 181 + yOffset); // Chivalry glow
		tab.child(49, 32931, 46 + xOffset, 186 + yOffset); // Chivalry

		tab.child(50, 18014, 80 + xOffset, 181 + yOffset); // Piety glow
		tab.child(51, 18015, 82 + xOffset, 192 + yOffset); // Piety

		tab.child(57, 22962, 117 + xOffset, 182 + yOffset); // Rigour
		tab.child(58, 22963, 119 + xOffset, 184 + yOffset); // Rigour
		tab.child(59, 22964, 156 + xOffset, 184 + yOffset); // Augury
		tab.child(60, 22965, 159 + xOffset, 184 + yOffset); // Augury
		tab.child(52, 5651, 500, 500);
		tab.child(53, 687, 500, 500);
		tab.child(54, 22043, 500, 500);
		/* Prayer icons & text */
		String[] hoverText = {"Level 01\\nThick Skin\\nIncreases your Defence by 5%",
				"Level 04\\nBurst of Strength\\nIncreases your Strength by 5%",
				"Level 07\\nClarity of Thought\\nIncreases your Attack by 5%",
				"Level 08\\nSharp Eye\\nIncreases your Ranged by 5%",
				"Level 09\\nMystic Will\\nIncreases your Magic by 5%",
				"Level 10\\nRock Skin\\nIncreases your Defence by 10%",
				"Level 13\\nSuperhuman Strength\\nIncreases your Strength by 10%",
				"Level 16\\nImproved Reflexes\\nIncreases your Attack by 10%",
				"Level 19\\nRapid Restore\\n2x restore rate for all stats\\nexcept Hitpoints and Prayer",
				"Level 22\\nRapid Heal\\n2x restore rate for the\\nHitpoints stat",
			"Level 25\\nProtect Item\\nKeep 1 extra item if you die",
				"Level 26\\nHawk Eye\\nIncreases your Ranged by 10%",
				"Level 27\\nMystic Lore\\nIncreases your Magic by 10%",
				"Level 28\\nSteel Skin\\nIncreases your Defence by 15%",
				"Level 31\\nUltimate Strength\\nIncreases your Strength by 15%",
				"Level 34\\nIncredible Reflexes\\nIncreases your Attack by 15%",
				"Level 35\\nProtect from Summoning\\nProtection from summoning attacks",
				"Level 37\\nProtect from Magic\\nProtection from magical attacks",
				"Level 40\\nProtect from Missles\\nProtection from ranged attacks",
				"Level 43\\nProtect from Melee\\nProtection from melee attacks",
				"Level 44\\nEagle Eye\\nIncreases your Ranged by 15%",
				"Level 45\\nMystic Might\\nIncreases your Magic by 15%",
				"Level 46\\nRetribution\\nInflicts damage to nearby\\ntargets if you die",
				"Level 49\\nRedemption\\nHeals you when damaged\\nand Hitpoints falls\\nbelow 10%",
				"Level 52\\nSmite\\n1/4 of damage dealt is\\nalso removed from\\nopponent's Prayer",
				"Level 60\\nChivalry\\nIncreases your Defence by 20%,\\nStrength by 18%, and Attack by\\n15%",
				"Level 65\\nRapid Renewal\\n5x restore rate for the\\nHitpoints stat",
				"Level 70\\nPiety\\nIncreases your Defence by 25%,\\nStrength by 23%, and Attack by\\n20%",
				"Level 74\\nRigour\\nIncreases your Ranged by 20%,\\nRanged strength by 23%, and\\nDefence by 25%",
				"Level 77\\nAugury\\nIncreases your Magic by 25%\\nand Defence by 25%",};

		// Position of the hover box.
		int[][] hoverBoxPosition = {{36, 80}, {36, 80}, {41, 80}, {45, 80}, {55, 80}, {36, 116},
				{36, 116}, {41, 116}, {50, 116}, {83, 116}, {34, 152}, {36, 152}, {40, 152}, {34, 152},
				{32, 152}, {36, 188}, {33, 188}, {34, 188}, {42, 188}, {41, 188}, {35, 224}, {38, 110},
				{50, 93}, {87, 93}, // Index 23
				{35, 224}, // Preserve tooltip
				{30, 134}, // Chivalry tooltip
				{50, 134}, // Piety tooltip
				{50, 134}, // Rigour tooltip
				{50, 134}, // Augury tooltip
				{50, 134}, // Augury tooltip
		};
		int x = 8;
		int y = 6;
		RSInterface.addPrayer(38504, 0, 612, 34, 1074, 1075, "Protect from Summoning");
		tab.child(61, 38504, 43 + xOffset, 110 + yOffset);
		tab.child(62, 38505, 45 + xOffset, 110 + yOffset);

		for (int index = 0; index < 30; index++) {
			RSInterface.createTimedHoverBox(22150 + index, hoverText[index], 33, 33,
					hoverBoxPosition[index][0], hoverBoxPosition[index][1]);
			tab.child(63 + index, 22150 + index, x, y);
			x += 34;
			if (index == 4 || index == 9 || index == 14 || index == 19 || index == 24) {
				x = 8;
				y += 36;
			}
		}

		String[] tools = {"Thick Skin", "Burst of Strength", "Clarity of Thought", "Rock Skin",
				"Superhuman Strength", "Improved Reflexes", "Rapid Restore", "Rapid Heal",
			"Protect Item",
			"Steel Skin",
			"Ultimate Strength",
			"Incredible Reflexes",
				"Protect from Magic", "Protect from Range", "Protect from Melee", "Retribution",
				"Redemption", "Smite"};
		int count = 0;
		for (int j = 5609; j <= 5623; j++) {
			RSInterface tab2 = RSInterface.interfaceCache[j];
			tab2.tooltip = "Activate @or2@" + tools[count++];
		}
		for (int j = 683; j <= 685; j++) {
			RSInterface tab2 = RSInterface.interfaceCache[j];
			tab2.tooltip = "Activate @or2@" + tools[count++];
		}
	}

	public static void itemOverlaySettings(TextDrawingArea[] tda) {
		int interfaceId = 40000;
		int totalChildren = 33;
		int child = 0;
		int xOffset = 160;
		RSInterface interfaces = RSInterface.addInterface(interfaceId, 0, 500, 0, 500);
		interfaceId++;
		RSInterface.setChildren(totalChildren, interfaces);

		int originalInterfaceId = interfaceId;
		interfaceId = 40040;

		// Background
		RSInterface.addSpriteComplete(interfaceId, child, 286, -160 + xOffset, 42, interfaces, true);
		interfaceId++;
		child++;
		RSInterface.addSpriteComplete(interfaceId, child, 285, -160 + xOffset, 40, interfaces, true);
		interfaceId++;
		child++;
		RSInterface.addSpriteComplete(interfaceId, child, 285, -160 + xOffset, 251, interfaces, true);
		interfaceId++;
		child++;
		interfaceId = originalInterfaceId;

		RSInterface.addHoverButtonComplete(interfaceId, child, xOffset, 45, 972, 971, 17, 17, "Display ground item text overlay", interfaces, true);
		RSInterface.setSpriteClicked(interfaceId, 974);
		interfaceId += 3;
		child += 2;

		RSInterface.addHoverButtonComplete(interfaceId, child, xOffset, 78, 972, 971, 17, 17, "Item rarity colour", interfaces, true);
		RSInterface.setSpriteClicked(interfaceId, 974);
		interfaceId += 3;
		child += 2;

		RSInterface.addHoverButtonComplete(interfaceId, child, xOffset, 100, 972, 971, 17, 17, "Show estimated value", interfaces, true);
		RSInterface.setSpriteClicked(interfaceId, 974);
		interfaceId += 3;
		child += 2;

		RSInterface.addHoverButtonComplete(interfaceId, child, xOffset, 120, 972, 971, 17, 17, "Hide 0 value items", interfaces, true);
		RSInterface.setSpriteClicked(interfaceId, 974);
		interfaceId += 3;
		child += 2;

		RSInterface.addHoverButtonComplete(interfaceId, child, xOffset, 145, 972, 971, 17, 17, "Right-click item amount", interfaces, true);
		RSInterface.setSpriteClicked(interfaceId, 974);
		interfaceId += 3;
		child += 2;

		RSInterface.addHoverButtonComplete(interfaceId, child, xOffset, 185, 972, 971, 17, 17, "Small", interfaces, true);
		RSInterface.setSpriteClicked(interfaceId, 974);
		interfaceId += 3;
		child += 2;

		RSInterface.addHoverButtonComplete(interfaceId, child, xOffset, 210, 972, 971, 17, 17, "Medium", interfaces, true);
		RSInterface.setSpriteClicked(interfaceId, 974);
		interfaceId += 3;
		child += 2;

		RSInterface.addHoverButtonComplete(interfaceId, child, xOffset, 233, 972, 971, 17, 17, "Large", interfaces, true);
		RSInterface.setSpriteClicked(interfaceId, 974);
		interfaceId += 3;
		child += 2;

		RSInterface.addHoverButton(interfaceId, 148, 16, 16, "Close", -1, interfaceId + 1, 1);
		RSInterface.setBounds(interfaceId, 165, 5, child, interfaces);
		interfaceId += 2;
		child += 2;

		RSInterface.addHoveredButton(interfaceId, 149, 16, 16, interfaceId + 1);
		RSInterface.setBounds(interfaceId, 165, 5, child, interfaces);
		interfaceId += 2;
		child += 2;

		RSInterface.addText(interfaceId, "Item overlay settings", tda, 2, 0xFF981F, true, true);
		RSInterface.setBounds(interfaceId, 93, 20, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Display ground item\\ntext overlay", tda, 1, 0xffffff, true, true);
		RSInterface.setBounds(interfaceId, 93, 45, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Item rarity colour", tda, 1, 0xffffff, true, true);
		RSInterface.setBounds(interfaceId, 93, 78, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Show estimated value", tda, 1, 0xffffff, true, true);
		RSInterface.setBounds(interfaceId, 93, 100, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Hide 0 value items", tda, 1, 0xffffff, true, true);
		RSInterface.setBounds(interfaceId, 93, 120, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Right-click item amount", tda, 1, 0xffffff, true, true);
		RSInterface.setBounds(interfaceId, 93, 145, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Small text", tda, 0, 0xffffff, true, true);
		RSInterface.setBounds(interfaceId, 93, 189, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Medium text", tda, 1, 0xffffff, true, true);
		RSInterface.setBounds(interfaceId, 93, 210, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Large text", tda, 2, 0xffffff, true, true);
		RSInterface.setBounds(interfaceId, 93, 233, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Text size", tda, 2, 0xFF981F, true, true);
		RSInterface.setBounds(interfaceId, 93, 165, child, interfaces);
		interfaceId++;
		child++;
	}

	public static void magicBottomComponent(TextDrawingArea[] tda) {
		if (!Config.PRE_EOC) {
			return;
		}
		int frame = 0;
		int id = 38404;

		RSInterface tab = RSInterface.addInterface(id++);
		tab.totalChildren(8);

		RSInterface.addSprite(id, 1063);
		tab.child(frame++, id++, 0, 229);

		int DEFENSIVE_CONFIG = 503;

		RSInterface.addConfigButton(id, id, 290, 290, 18, 18, "Toggle defensive casting", 1, 5,
				DEFENSIVE_CONFIG);
		tab.child(frame++, id++, 3, 236);

		RSInterface.addSprite(id, 296);
		tab.child(frame++, id++, 7, 240);

		RSInterface.addButton(id, 290, "Toggle combat spells");
		tab.child(frame++, id++, 47, 236);

		RSInterface.addButton(id, 290, "Toggle teleport spells");
		tab.child(frame++, id++, 82, 236);

		RSInterface.addSprite(id, 297);
		tab.child(frame++, id++, 50, 239);

		RSInterface.addSprite(id, 298);
		tab.child(frame++, id++, 86, 240);

		tab.child(frame++, 38_413, 0, 0);

		tab = RSInterface.addInterface(id++);
		tab.totalChildren(3);
		frame = 0;
		tab.child(frame++, 24811, 167, 239);
		tab.child(frame++, 24829, 148, 242);
		tab.child(frame++, 24847, 131, 241);

		/*
		 * Teleport selected
		 */
		RSInterface teleport = RSInterface.addInterface(id++);
		teleport.totalChildren(8);
		frame = 0;
		teleport.child(frame++, 24825, 162, 236);
		teleport.child(frame++, 24815, 144, 237);
		teleport.child(frame++, 24816, 144, 237);
		teleport.child(frame++, 24833, 125, 237);
		teleport.child(frame++, 24834, 125, 237);
		teleport.child(frame++, 24811, 165, 239);
		teleport.child(frame++, 24829, 147, 242);
		teleport.child(frame++, 24847, 129, 241);

		/*
		 * Combat selected
		 */
		RSInterface combat = RSInterface.addInterface(id++);
		combat.totalChildren(8);
		frame = 0;
		combat.child(frame++, 24830, 163, 237);
		combat.child(frame++, 24831, 163, 237);
		combat.child(frame++, 24825, 143, 236);
		combat.child(frame++, 24833, 125, 237);
		combat.child(frame++, 24834, 125, 237);
		combat.child(frame++, 24811, 165, 239);
		combat.child(frame++, 24829, 147, 242);
		combat.child(frame++, 24847, 129, 241);

		/*
		 * Original selected
		 */
		RSInterface original = RSInterface.addInterface(id++);
		original.totalChildren(8);
		frame = 0;
		original.child(frame++, 24815, 144, 237);
		original.child(frame++, 24816, 144, 237);
		original.child(frame++, 24830, 163, 237);
		original.child(frame++, 24831, 163, 237);
		original.child(frame++, 24843, 124, 236);
		original.child(frame++, 24811, 165, 239);
		original.child(frame++, 24829, 147, 242);
		original.child(frame++, 24847, 129, 241);
		/*
		 * Modern
		 */
		id = 34933;
		frame = 0;
		tab = RSInterface.addInterface(id++);
		tab.totalChildren(12);

		RSInterface.addSprite(id, 1063);
		tab.child(frame++, id++, 0, 229);

		RSInterface.addConfigButton(id, id, 290, 290, 18, 18, "Toggle defensive casting", 1, 5,
				DEFENSIVE_CONFIG);
		tab.child(frame++, id++, 3, 236);

		RSInterface.addSprite(id, 296);
		tab.child(frame++, id++, 7, 240);

		RSInterface.addButton(id, 290, "Toggle combat spells" + frame);
		tab.child(frame++, id++, 33, 236);

		RSInterface.addSprite(id, 297);
		tab.child(frame++, id++, 36, 239);

		RSInterface.addButton(id, 290, "Toggle teleport spells" + frame);
		tab.child(frame++, id++, 54, 236);

		RSInterface.addSprite(id, 298);
		tab.child(frame++, id++, 58, 240);

		RSInterface.addButton(id, 290, "Toggle misc spells " + frame);
		tab.child(frame++, id++, 75, 236);

		RSInterface.addSprite(id, 1090);
		tab.child(frame++, id++, 78, 240);

		RSInterface.addButton(id, 290, "Toggle skill spells" + frame);
		tab.child(frame++, id++, 96, 236);

		RSInterface.addSprite(id, 1091);
		tab.child(frame++, id++, 100, 240);

		Utility.print("clsoe: " + frame);
		tab.child(frame++, 38_413, 0, 0);
		/*
		 * Lunar
		 */
		id = 38_292;
		frame = 0;
		tab = RSInterface.addInterface(id++);
		tab.totalChildren(10);

		RSInterface.addSprite(id, 1063);
		tab.child(frame++, id++, 0, 229);

		RSInterface.addConfigButton(id, id, 290, 290, 18, 18, "Toggle defensive casting", 1, 5,
				DEFENSIVE_CONFIG);
		tab.child(frame++, id++, 3, 236);

		RSInterface.addSprite(id, 296);
		tab.child(frame++, id++, 7, 240);

		RSInterface.addButton(id, 290, "Toggle combat spells" + frame);
		tab.child(frame++, id++, 38, 236);

		RSInterface.addSprite(id, 297);
		tab.child(frame++, id++, 41, 239);

		RSInterface.addButton(id, 290, "Toggle teleport spells" + frame);
		tab.child(frame++, id++, 64, 236);

		RSInterface.addSprite(id, 298);
		tab.child(frame++, id++, 68, 240);

		RSInterface.addButton(id, 290, "Toggle misc spells " + frame);
		tab.child(frame++, id++, 90, 236);

		RSInterface.addSprite(id, 1090);
		tab.child(frame++, id++, 93, 240);

		Utility.print("close lunar: " + frame);
		tab.child(frame++, 38_413, 0, 0);
	}

	public static void ancientMagicTabPreEoc(TextDrawingArea[] tda) {
		if (!Config.PRE_EOC) {
			return;
		}
		RSInterface tab = RSInterface.addInterface(37493);
		RSInterface.addButton(12856, 1077, "Cast @gre@Home Teleport");
		RSInterface homeButton = RSInterface.interfaceCache[12856];
		homeButton.isMouseoverTriggered = 1196;
		int[] itfChildren = {
				// teleport below
				12856, 13035, 13045, 13053, 13061, 13069, 13079, 13087, 13095,

				// combat below
				12939, 12987, 12901, 12861, 32600, 12963, 13011, 12919, 12881, 32620, 12951, 12999,
				12911, 12871, 32640, 12975, 13023, 12929, 12891, 32660,

				// hover ids below
				1196, 12940, 12988, 13036, 12902, 12862, 13046, 12964, 13012, 13054, 12920, 12882,
				13062, 12952, 13000, 13070, 12912, 12872, 13080, 12976, 13024, 13088, 12930, 12892,
				13096};
		tab.totalChildren(itfChildren.length + 1);
		for (int i1 = 0, xPos = 20, yPos = 16; i1 < itfChildren.length; i1++, xPos += 33) {
			if (xPos > 175) {
				xPos = 19;
				yPos += 35;
			}
			tab.child(i1, itfChildren[i1], xPos, yPos);
		}
		tab.child(itfChildren.length, 38404, 0, 0);
	}

	public static void curseTab(final TextDrawingArea[] TDA) {
		if (!Config.PRE_EOC) {
			return;
		}

		final RSInterface Interface = RSInterface.addTabInterface(21356);
		int index = 0;

		RSInterface.addText(22499, "99/99", 0xFF981F, false, false, -1, TDA, 1);
		RSInterface.addSprite(22502, 232);

		int config = 624;
		RSInterface.addPrayer(22503, 0, config, 49, 1021, "Protect Item", 22582);
		config++;
		RSInterface.addPrayer(22505, 0, config, 49, 1023, "Sap Warrior", 22544);
		config++;
		RSInterface.addPrayer(22507, 0, config, 51, 1059, "Sap Ranger", 22546);
		config++;
		RSInterface.addPrayer(22509, 0, config, 53, 1025, "Sap Mage", 22548);
		config++;
		RSInterface.addPrayer(22511, 0, config, 55, 1027, "Sap Spirit", 22550);
		config++;
		RSInterface.addPrayer(22513, 0, config, 58, 1029, "Berserker", 22552);
		config++;
		RSInterface.addPrayer(22515, 0, config, 61, 1031, "Deflect Summoning", 22554);
		config++;
		RSInterface.addPrayer(22517, 0, config, 64, 1033, "Deflect Magic", 22556);
		config++;
		RSInterface.addPrayer(22519, 0, config, 67, 1035, "Deflect Missiles", 22558);
		config++;
		RSInterface.addPrayer(22521, 0, config, 70, 1037, "Deflect Melee", 22560);
		config++;
		RSInterface.addPrayer(22523, 0, config, 73, 1039, "Leech Attack", 22562);
		config++;
		RSInterface.addPrayer(22525, 0, config, 75, 1041, "Leech Ranged", 22564);
		config++;
		RSInterface.addPrayer(22527, 0, config, 77, 1043, "Leech Magic", 22566);
		config++;
		RSInterface.addPrayer(22529, 0, config, 79, 1045, "Leech Defence", 22568);
		config++;
		RSInterface.addPrayer(22531, 0, config, 81, 1047, "Leech Strength", 22570);
		config++;
		RSInterface.addPrayer(22533, 0, config, 83, 1049, "Leech Energy", 22572);
		config++;
		RSInterface.addPrayer(22535, 0, config, 85, 1051, "Leech Special Attack", 22574);
		config++;
		RSInterface.addPrayer(22537, 0, config, 88, 1053, "Wrath", 22576);
		config++;
		RSInterface.addPrayer(22539, 0, config, 91, 1055, "Soul Split", 22578);
		config++;
		RSInterface.addPrayer(22541, 0, config, 94, 1057, "Turmoil", 22580);
		config++;
		RSInterface.drawTooltip(22582, "Level 50\nProtect Item\nKeep 1 extra item if you die");
		RSInterface.drawTooltip(22544,
				"Level 50\nSap Warrior\nDrains 10% of enemy Attack,\nStrength and Defence,\nincreasing to 20% over time");
		RSInterface.drawTooltip(22546,
				"Level 52\nSap Ranger\nDrains 10% of enemy Ranged\nand Defence, increasing to 20%\nover time");
		RSInterface.drawTooltip(22548,
				"Level 54\nSap Mage\nDrains 10% of enemy Magic\nand Defence, increasing to 20%\nover time");
		RSInterface.drawTooltip(22550, "Level 56\nSap Spirit\nDrains enenmy special attack\nenergy");
		RSInterface.drawTooltip(22552, "Level 59\nBerserker\nBoosted stats last 15% longer");
		RSInterface.drawTooltip(22554,
				"Level 62\nDeflect Summoning\nReduces damage dealt from\nSummoning scrolls, prevents the\nuse of a familiar's special\nattack, and can deflect some of\ndamage back to the attacker");
		RSInterface.drawTooltip(22556,
				"Level 65\nDeflect Magic\nProtects against magical attacks\nand can deflect some of the\ndamage back to the attacker");
		RSInterface.drawTooltip(22558,
				"Level 68\nDeflect Missiles\nProtects against ranged attacks\nand can deflect some of the\ndamage back to the attacker");
		RSInterface.drawTooltip(22560,
				"Level 71\nDeflect Melee\nProtects against melee attacks\nand can deflect some of the\ndamage back to the attacker");
		RSInterface.drawTooltip(22562,
				"Level 74\nLeech Attack\nBoosts Attack by 5%, increasing\nto 10% over time, while draining\nenemy Attack by 10%, increasing\nto 25% over time");
		RSInterface.drawTooltip(22564,
				"Level 76\nLeech Ranged\nBoosts Ranged by 5%, increasing\nto 10% over time, while draining\nenemy Ranged by 10%,\nincreasing to 25% over\ntime");
		RSInterface.drawTooltip(22566,
				"Level 78\nLeech Magic\nBoosts Magic by 5%, increasing\nto 10% over time, while draining\nenemy Magic by 10%, increasing\nto 25% over time");
		RSInterface.drawTooltip(22568,
				"Level 80\nLeech Defence\nBoosts Defence by 5%, increasing\nto 10% over time, while draining\n enemy Defence by10%,\nincreasing to 25% over\ntime");
		RSInterface.drawTooltip(22570,
				"Level 82\nLeech Strength\nBoosts Strength by 5%, increasing\nto 10% over time, while draining\nenemy Strength by 10%, increasing\n to 25% over time");
		RSInterface.drawTooltip(22572,
				"Level 84\nLeech Energy\nDrains enemy run energy, while\nincreasing your own");
		RSInterface.drawTooltip(22574,
				"Level 86\nLeech Special Attack\nDrains enemy special attack\nenergy, while increasing your\nown");
		RSInterface.drawTooltip(22576,
				"Level 89\nWrath\nInflicts damage to nearby\ntargets if you die");
		RSInterface.drawTooltip(22578,
				"Level 92\nSoul Split\n1/4 of damage dealt is also removed\nfrom opponent's Prayer and\nadded to your Hitpoints");
		RSInterface.drawTooltip(22580,
				"Level 95\nTurmoil\nIncreases Attack and Defence\nby 15%, plus 15% of enemy's\nlevel, and Strength by 23% plus\n10% of enemy's level");
		RSInterface.setChildren(65, Interface);

		RSInterface.setBounds(22499, 85, 241, index, Interface);
		index++;
		RSInterface.setBounds(22502, 65, 241, index, Interface);
		index++;
		RSInterface.setBounds(22503, 2, 5, index, Interface);
		index++;
		RSInterface.setBounds(22504, 8, 8, index, Interface);
		index++;
		RSInterface.setBounds(22505, 40, 5, index, Interface);
		index++;
		RSInterface.setBounds(22506, 47, 12, index, Interface);
		index++;
		RSInterface.setBounds(22507, 76, 5, index, Interface);
		index++;
		RSInterface.setBounds(22508, 82, 11, index, Interface);
		index++;
		RSInterface.setBounds(22509, 113, 5, index, Interface);
		index++;
		RSInterface.setBounds(22510, 116, 8, index, Interface);
		index++;
		RSInterface.setBounds(22511, 150, 5, index, Interface);
		index++;
		RSInterface.setBounds(22512, 155, 10, index, Interface);
		index++;
		RSInterface.setBounds(22513, 2, 45, index, Interface);
		index++;
		RSInterface.setBounds(22514, 9, 48, index, Interface);
		index++;
		RSInterface.setBounds(22515, 39, 45, index, Interface);
		index++;
		RSInterface.setBounds(22516, 42, 47, index, Interface);
		index++;
		RSInterface.setBounds(22517, 76, 45, index, Interface);
		index++;
		RSInterface.setBounds(22518, 79, 48, index, Interface);
		index++;
		RSInterface.setBounds(22519, 113, 45, index, Interface);
		index++;
		RSInterface.setBounds(22520, 116, 48, index, Interface);
		index++;
		RSInterface.setBounds(22521, 151, 45, index, Interface);
		index++;
		RSInterface.setBounds(22522, 154, 48, index, Interface);
		index++;
		RSInterface.setBounds(22523, 2, 82, index, Interface);
		index++;
		RSInterface.setBounds(22524, 6, 86, index, Interface);
		index++;
		RSInterface.setBounds(22525, 40, 82, index, Interface);
		index++;
		RSInterface.setBounds(22526, 42, 86, index, Interface);
		index++;
		RSInterface.setBounds(22527, 77, 82, index, Interface);
		index++;
		RSInterface.setBounds(22528, 79, 86, index, Interface);
		index++;
		RSInterface.setBounds(22529, 114, 83, index, Interface);
		index++;
		RSInterface.setBounds(22530, 119, 87, index, Interface);
		index++;
		RSInterface.setBounds(22531, 153, 83, index, Interface);
		index++;
		RSInterface.setBounds(22532, 156, 86, index, Interface);
		index++;
		RSInterface.setBounds(22533, 2, 120, index, Interface);
		index++;
		RSInterface.setBounds(22534, 7, 125, index, Interface);
		index++;
		RSInterface.setBounds(22535, 40, 120, index, Interface);
		index++;
		RSInterface.setBounds(22536, 45, 124, index, Interface);
		index++;
		RSInterface.setBounds(22537, 78, 120, index, Interface);
		index++;
		RSInterface.setBounds(22538, 86, 124, index, Interface);
		index++;
		RSInterface.setBounds(22539, 114, 120, index, Interface);
		index++;
		RSInterface.setBounds(22540, 120, 125, index, Interface);
		index++;
		RSInterface.setBounds(22541, 151, 120, index, Interface);
		index++;
		RSInterface.setBounds(22542, 153, 127, index, Interface);
		index++;
		RSInterface.setBounds(22582, 10, 40, index, Interface);
		index++;
		RSInterface.setBounds(22544, 20, 40, index, Interface);
		index++;
		RSInterface.setBounds(22546, 20, 40, index, Interface);
		index++;
		RSInterface.setBounds(22548, 20, 40, index, Interface);
		index++;
		RSInterface.setBounds(22550, 20, 40, index, Interface);
		index++;
		RSInterface.setBounds(22552, 10, 80, index, Interface);
		index++;
		RSInterface.setBounds(22554, 10, 80, index, Interface);
		index++;
		RSInterface.setBounds(22556, 10, 80, index, Interface);
		index++;
		RSInterface.setBounds(22558, 10, 80, index, Interface);
		index++;
		RSInterface.setBounds(22560, 10, 80, index, Interface);
		index++;
		RSInterface.setBounds(22562, 10, 120, index, Interface);
		index++;
		RSInterface.setBounds(22564, 10, 120, index, Interface);
		index++;
		RSInterface.setBounds(22566, 10, 120, index, Interface);
		index++;
		RSInterface.setBounds(22568, 5, 120, index, Interface);
		index++;
		RSInterface.setBounds(22570, 5, 120, index, Interface);
		index++;
		RSInterface.setBounds(22572, 10, 160, index, Interface);
		index++;
		RSInterface.setBounds(22574, 10, 160, index, Interface);
		index++;
		RSInterface.setBounds(22576, 10, 160, index, Interface);
		index++;
		RSInterface.setBounds(22578, 10, 160, index, Interface);
		index++;
		RSInterface.setBounds(22580, 10, 160, index, Interface);
		index++;

		RSInterface.addSprite(22784, 1062);
		RSInterface.setBounds(22784, 0, 220, index, Interface);
		index++;

		RSInterface.addHoverClickText(22782, "Show stat adjustments.", "Toggle adjustments display",
				TDA, 0, 0xFFCC00, true, true, 90);
		RSInterface.setBounds(22782, 60, 224, index, Interface);
		index++;

		int id = 28786;
		RSInterface.setBounds(id, 0, 0, index, Interface);
		index++;

		Utility.print("curse tab: " + id);
		RSInterface tab = RSInterface.addInterface(id);
		tab.childInvisibilitySupported = true;
		tab.invisible = true;
		id++;

		index = 0;
		RSInterface.setChildren(6, tab);

		RSInterface.addSprite(id, 1061);
		RSInterface.setBounds(id, 0, 176, index, tab);
		index++;
		id++;

		RSInterface.addText(id, "" + id, 0xFF981F, true, true, -1, TDA, 0);
		RSInterface.setBounds(id, 20, 206, index, tab);
		index++;
		id++;

		RSInterface.addText(id, "" + id, 0xFF981F, true, true, -1, TDA, 0);
		RSInterface.setBounds(id, 60, 206, index, tab);
		index++;
		id++;

		RSInterface.addText(id, "" + id, 0xFF981F, true, true, -1, TDA, 0);
		RSInterface.setBounds(id, 97, 206, index, tab);
		index++;
		id++;

		RSInterface.addText(id, "" + id, 0xFF981F, true, true, -1, TDA, 0);
		RSInterface.setBounds(id, 135, 206, index, tab);
		index++;
		id++;

		RSInterface.addText(id, "" + id, 0xFF981F, true, true, -1, TDA, 0);
		RSInterface.setBounds(id, 173, 206, index, tab);
		index++;
		id++;

	}

	private static void familiarDetails(TextDrawingArea[] tda) {


		RSInterface.addText(MoneyPouchOrb.MONEY_POUCH_LINE, "2000000000", tda, 0, 0xffffff, true,
				true);

		int id = 39560;

		RSInterface tab = RSInterface.addInterface(id++);

		int children = 0;
		RSInterface.setChildren(16, tab);

		RSInterface.addHoverButton(id, 1020, 38, 38, "Call Familiar", 250, id + 1, 5);
		RSInterface.setBounds(id, 14, 218, children++, tab);

		RSInterface.addHoveredButton(id + 1, 1019, 38, 38, id + 2);
		RSInterface.setBounds(id + 1, 14, 218, children++, tab);
		id += 3;

		RSInterface.addHoverButton(id, 1020, 38, 38, "Withdraw Storage", 250, id + 1, 5);
		RSInterface.setBounds(id, 56, 218, children++, tab);

		RSInterface.addHoveredButton(id + 1, 1019, 38, 38, id + 2);
		RSInterface.setBounds(id + 1, 56, 218, children++, tab);
		id += 3;

		RSInterface.addHoverButton(id, 1020, 38, 38, "Renew Familiar", 250, id + 1, 5);
		RSInterface.setBounds(id, 97, 218, children++, tab);

		RSInterface.addHoveredButton(id + 1, 1019, 38, 38, id + 2);
		RSInterface.setBounds(id + 1, 97, 218, children++, tab);
		id += 3;

		RSInterface.addHoverButton(id, 1020, 38, 38, "Dismiss Familiar", 250, id + 1, 5);
		RSInterface.setBounds(id, 138, 218, children++, tab);

		RSInterface.addHoveredButton(id + 1, 1019, 38, 38, id + 2);
		RSInterface.setBounds(id + 1, 138, 218, children++, tab);
		id += 3;

		RSInterface.addSprite(id, 1016);
		RSInterface.setBounds(id++, 0, 0, children++, tab);

		RSInterface.addText(id, "99/99 " + id, tda, 1, 0xff9933, true, true);
		RSInterface.setBounds(id++, 43, 200, children++, tab);

		RSInterface.addText(id, "64.00 " + id, tda, 1, 0xff9933, true, true);
		RSInterface.setBounds(id++, 140, 200, children++, tab);

		RSInterface.addText(id, "A_VERY_LONG_NAME " + id, tda, 2, 0xff9933, true, true);
		RSInterface.setBounds(id++, 95, 146, children++, tab);

		RSInterface.addText(id, "S P E C I A L A T T A C K " + id, tda, 0, 0xffffff, true, true);
		RSInterface.setBounds(id++, 95, 10, children++, tab);

		RSInterface.addText(id, "1,544 " + id, tda, 0, 0xff9933, true, true);
		RSInterface.setBounds(id++, 23, 61, children++, tab);

		RSInterface.addHead(id, 75, 55, 800);
		RSInterface.setBounds(id++, 63, 60, children++, tab);

		RSInterface.addConfigButton(id, 39560, 1132, 1133, 30, 31, "Activate Scroll", 0, 1, 705);
		RSInterface.setBounds(id++, 8, 28, children++, tab);
	}

	private static void petDetails(TextDrawingArea[] tda) {

		int id = 38560;

		RSInterface tab = RSInterface.addInterface(id++);

		int children = 0;
		RSInterface.setChildren(9, tab);

		RSInterface.addHoverButton(id, 1020, 38, 38, "Call Familiar", 250, id + 1, 5);
		RSInterface.setBounds(id, 23, 217, children++, tab);

		RSInterface.addHoveredButton(id + 1, 1019, 38, 38, id + 2);
		RSInterface.setBounds(id + 1, 23, 217, children++, tab);
		id += 3;

		RSInterface.addHoverButton(id, 1020, 38, 38, "Dismiss Familiar", 250, id + 1, 5);
		RSInterface.setBounds(id, 129, 217, children++, tab);

		RSInterface.addHoveredButton(id + 1, 1019, 38, 38, id + 2);
		RSInterface.setBounds(id + 1, 129, 217, children++, tab);
		id += 3;

		RSInterface.addSprite(id, 1018);
		RSInterface.setBounds(id++, 0, 0, children++, tab);

		RSInterface.addText(id, "99/99 " + id, tda, 1, 0xff9933, true, true);
		RSInterface.setBounds(id++, 43, 200, children++, tab);

		RSInterface.addText(id, "64.00 " + id, tda, 1, 0xff9933, true, true);
		RSInterface.setBounds(id++, 140, 200, children++, tab);

		RSInterface.addText(id, "A_VERY_LONG_NAME " + id, tda, 2, 0xff9933, true, true);
		RSInterface.setBounds(id++, 95, 146, children++, tab);

		Utility.print("pet head: " + id);
		RSInterface.addHead(id, 75, 55, 800);
		RSInterface.setBounds(id++, 63, 75, children++, tab);
	}

	private static void levelUpFix(TextDrawingArea[] tda) {

		// Ranged level up missing text fixed.
		RSInterface.interfaceCache[6114].textDrawingAreas = tda[3];
		RSInterface.interfaceCache[6114].textSize = 3;
		RSInterface.interfaceCache[6114].message = "Line1";
		RSInterface.interfaceCache[6114].centerText = true;
		RSInterface.interfaceCache[6114].id = 6114;
		RSInterface.interfaceCache[6114].height = 18;
		RSInterface.interfaceCache[6114].isMouseoverTriggered = -1;
		RSInterface.interfaceCache[6114].parentId = 4443;
		RSInterface.interfaceCache[6114].type = 4;
		RSInterface.interfaceCache[6114].width = 390;

	}

	private static void npcDropTable(TextDrawingArea[] tda) {
		RSInterface tab = RSInterface.addInterface(29050);// 54500
		RSInterface.addSprite(29051, 962);// 54501
		RSInterface.addHoverButton(29052, 148, 16, 16, "Close", 250, 29053, 3);// 54502
		RSInterface.addHoveredButton(29053, 149, 16, 16, 29054);// 54503, 54504
		RSInterface.addText(29055, "Npc Droptable", tda, 2, 0xff9933, true, true);// 54505
		RSInterface.addText(29058, "Item:", tda, 1, 0xff9933, true, true);// 54508
		RSInterface.addText(29059, "Quantity:", tda, 1, 0xff9933, true, true);// 54509
		RSInterface.addText(29060, "Price:", tda, 1, 0xff9933, true, true);// 54510
		RSInterface.addText(29061, "Chance:", tda, 1, 0xff9933, true, true);// 54511

		int children = 0;
		RSInterface.setChildren(16, tab);
		RSInterface.setBounds(29051, 9, 5, children++, tab);
		RSInterface.setBounds(29052, 479, 12, children++, tab);
		RSInterface.setBounds(29053, 479, 12, children++, tab);
		RSInterface.setBounds(29055, 255, 12, children++, tab);
		RSInterface.setBounds(29058, 202, 38, children++, tab);
		RSInterface.setBounds(29059, 331, 38, children++, tab);
		RSInterface.setBounds(29060, 383, 38, children++, tab);
		RSInterface.setBounds(29061, 445, 38, children++, tab);
		RSInterface.setBounds(30500, 143, 56, children++, tab);
		RSInterface.setBounds(27700, 23, 89, children++, tab);

		RSInterface mainScroll = RSInterface.addTabInterface(30500);// 54550
		mainScroll.width = 594 - 261;
		mainScroll.height = 264;
		mainScroll.scrollMax = 600;

		int dropsAmount = 100;
		RSInterface.setChildren((dropsAmount * 6), mainScroll);
		int child = 0, y = 1, x = 0, sprite = 0;
		int start = 33300;
		for (int i = 0; i < dropsAmount * 6; i += 6) {
			int id = sprite % 2 == 0 ? 965 : 966;
			sprite++;
			RSInterface.addSprite(start + i, id);// 54552
			RSInterface.addText((start + (i + 1)), "", tda, 0, sprite % 2 == 0 ? 0xFFB83F : 0xFF981F,
					false, false);
			RSInterface.addText((start + (i + 2)), "", tda, 0, sprite % 2 == 0 ? 0xFFB83F : 0xFF981F,
					true, false);
			RSInterface.addText((start + (i + 3)), "", tda, 0, sprite % 2 == 0 ? 0xFFB83F : 0xFF981F,
					true, false);
			RSInterface.addText((start + (i + 4)), "", tda, 0, 0xFF981F, true, false);
			RSInterface.addToItemGroup((start + (i + 5)), 0, 1, 1, 24, 24, false, null, null, null,
					true, true);
			mainScroll.child(child++, start + i, x + 254 - 254, y);
			mainScroll.child(child++, (start + (i + 1)), x + 300 - 254, y + 10);
			mainScroll.child(child++, (start + (i + 2)), x + 440 - 254, y + 10);
			mainScroll.child(child++, (start + (i + 3)), x + 496 - 254, y + 10);
			mainScroll.child(child++, (start + (i + 4)), x + 555 - 254, y + 10);
			mainScroll.child(child++, (start + (i + 5)), x + 260 - 254, y + 0);
			y += 32;
		}

		RSInterface npcListScroll = RSInterface.addTabInterface(27700);// 54515
		npcListScroll.width = 100;
		npcListScroll.height = 231;
		npcListScroll.scrollMax = 300;
		int npcListMax = 149;
		RSInterface.setChildren(npcListMax, npcListScroll);
		int y2 = 0, child2 = 0;
		int interfaceId = 0;
		for (int i = 0; i < npcListMax * 2; i += 2) {
			RSInterface.addText((27701 + (i + 1)), "", tda, 0, ClientConstants.ORANGE, false, false,
					ClientConstants.WHITE, "Select", 99);
			RSInterface.textClicked((27701 + (i + 1)), 645, 1, 2);
			npcListScroll.child(child2++, (27701 + (i + 1)), 0, y2 + 3);
			interfaceId = (27701 + (i + 1));
			y2 += 18;
		}
		interfaceId = 30420;

		int yOffset = -57;
		RSInterface.addHoverButtonComplete(interfaceId, children, 19, 95 + yOffset, 999, 1000, 120,
				25, "Search an npc", tab, true);
		RSInterface.setSpriteClicked(interfaceId, 1001);
		children += 2;
		interfaceId += 3;

		RSInterface.addText(interfaceId, "Search an npc", tda, 0, ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 88, 102 + yOffset, children, tab);
		interfaceId++;
		children++;

		RSInterface.addHoverButtonComplete(interfaceId, children, 19, 120 + yOffset, 999, 1000, 120,
				25, "Search an item", tab, true);
		RSInterface.setSpriteClicked(interfaceId, 1001);
		children += 2;
		interfaceId += 3;

		RSInterface.addText(interfaceId, "Search an item", tda, 0, ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 88, 126 + yOffset, children, tab);
		interfaceId++;
		children++;
	}

	private static void donatorInterfaceBundlesTab(TextDrawingArea[] textDrawingAreas) {

		int interfaceId = 31000;
		int child = 0;
		RSInterface interfaces = RSInterface.addInterface(interfaceId, 11, 507, 13, 330);
		interfaceId++;
		RSInterface.setChildren(17, interfaces);
		int xOffset = 0;
		int yOffset = 0;

		// Background
		RSInterface.addSpriteComplete(interfaceId, child, 975, 7 + xOffset, 8 + yOffset, interfaces,
				true);
		interfaceId++;
		child++;

		int originalInterfaceId = 0;
		originalInterfaceId = interfaceId;
		interfaceId = 30990;
		// Close button
		RSInterface.addHoverButtonComplete(interfaceId, child, 477 + xOffset, 16 + yOffset, 148, 149,
				15, 15, "Close Window", interfaces, true);
		interfaceId += 3;
		child += 2;
		// Search button
		RSInterface.addHoverButtonComplete(interfaceId, child, 370 + xOffset, 18 + yOffset, 599, 599,
				101, 15, "Search", interfaces, true);
		interfaceId += 3;
		child += 2;
		interfaceId = originalInterfaceId;

		// Tabs
		int tickXSpaces = 0;
		int tickXSpaceIncrease = 121;
		String[] text = {"Main", "Normal shop", "Bundles shop"};
		for (int index = 0; index < text.length; index++) {
			RSInterface.addHoverButtonComplete(interfaceId, child, 12 + xOffset + tickXSpaces,
					41 + yOffset, 977, 978, 130, 17, "Select", interfaces, true);
			RSInterface.setSpriteClicked(interfaceId, 979);
			interfaceId += 3;
			child += 2;

			RSInterface.addText(interfaceId, text[index], textDrawingAreas, 2, ClientConstants.ORANGE,
					true);
			RSInterface.setBounds(interfaceId, 72 + xOffset + tickXSpaces, 43 + yOffset, child,
					interfaces);
			interfaceId++;
			child++;

			tickXSpaces += tickXSpaceIncrease;
		}
		interfaceId += 4;
		Client.setInterfaceClicked(31000, 31010, true, true); // Set Shop tab as
		// default clicked

		// Donator shop text
		RSInterface.addText(interfaceId, "Donator shop", textDrawingAreas, 2, ClientConstants.ORANGE,
				true);
		RSInterface.setBounds(interfaceId, 250 + xOffset, 17 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		// Right click an item to buy
		RSInterface.addText(interfaceId, "Right click an item to buy.", textDrawingAreas, 1,
				ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 250 + xOffset, 68 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		// Scroll content
		RSInterface scrollTab1 = RSInterface.addInterface(interfaceId);
		interfaces.child(child, interfaceId, -13 + xOffset, 90 + yOffset); // Scroll
		// interface.
		scrollTab1.width = 493;
		scrollTab1.height = 228;
		scrollTab1.scrollMax = 390;
		interfaceId++;
		child++;
		int buttonsAmount = 15;
		scrollTab1.totalChildren(6 * buttonsAmount);
		int xAdd = 0;
		int yAdd = 0;
		int scrollChild = 0;
		yOffset -= 80;
		xOffset += 9;
		int xAddConstant = 111;
		int yAddConstant = 114;
		for (int index = 0; index < buttonsAmount; index++) {

			if ((index) % 4 == 0 && index != 0) {
				yAdd += yAddConstant;
				xAdd = 0;
			}

			String[] tooltips = {"Value", "Buy 1", "Buy 5", "Buy 10", "Buy X"};
			RSInterface.addButtonMultiWithHover(interfaceId, 599, tooltips, 107, 110, 992);
			scrollTab1.child(scrollChild, interfaceId, 30 + xOffset + xAdd, 80 + yOffset + yAdd);
			interfaceId += tooltips.length; // Must be same amount as tooltips
			// length because of the way it
			// works in the client class.
			scrollChild++;

			// Before discount price text
			RSInterface.addText(interfaceId, "", textDrawingAreas, 0, ClientConstants.ORANGE, true);
			scrollTab1.child(scrollChild, interfaceId, 83 + xOffset + xAdd, 87 + yOffset + yAdd);
			interfaceId++;
			scrollChild++;

			// After discount price text
			RSInterface.addText(interfaceId, "", textDrawingAreas, 1, ClientConstants.YELLOW, true);
			scrollTab1.child(scrollChild, interfaceId, 83 + xOffset + xAdd, 98 + yOffset + yAdd);
			interfaceId++;
			scrollChild++;

			// Before discount price dash
			RSInterface.addSprite(interfaceId, 599);
			scrollTab1.child(scrollChild, interfaceId, 49 + xOffset + xAdd, 92 + yOffset + yAdd);
			interfaceId++;
			scrollChild++;

			// Offer badge
			RSInterface.addSprite(interfaceId, 599);
			scrollTab1.child(scrollChild, interfaceId, 30 + xOffset + xAdd, 115 + yOffset + yAdd);
			interfaceId++;
			scrollChild++;

			// Offer text
			RSInterface.addText(interfaceId, "", textDrawingAreas, 1, ClientConstants.BLUE, true,
					false);
			scrollTab1.child(scrollChild, interfaceId, 82 + xOffset + xAdd, 117 + yOffset + yAdd);
			interfaceId++;
			scrollChild++;

			xAdd += xAddConstant;
		}
	}

	private static void donatorInterfaceNormalTab(TextDrawingArea[] textDrawingAreas) {

		int interfaceId = 31000;
		int child = 0;
		RSInterface interfaces = RSInterface.addInterface(31200, 11, 507, 13, 330);
		interfaceId++;
		RSInterface.setChildren(17, interfaces);
		int xOffset = 0;
		int yOffset = 0;

		// Background
		RSInterface.addSpriteComplete(interfaceId, child, 975, 7 + xOffset, 8 + yOffset, interfaces,
				false);
		interfaceId++;
		child++;

		int originalInterfaceId = 0;
		originalInterfaceId = interfaceId;
		interfaceId = 30990;
		// Close button
		RSInterface.addHoverButtonComplete(interfaceId, child, 477 + xOffset, 16 + yOffset, 148, 149,
				15, 15, "Close Window", interfaces, false);
		interfaceId += 3;
		child += 2;
		// Search button
		RSInterface.addHoverButtonComplete(interfaceId, child, 370 + xOffset, 18 + yOffset, 599, 599,
				101, 15, "Search", interfaces, false);
		interfaceId += 3;
		child += 2;
		interfaceId = originalInterfaceId;

		// Tabs
		int tickXSpaces = 0;
		int tickXSpaceIncrease = 121;
		String[] text = {"Main", "Normal shop", "Bundles shop"};
		for (int index = 0; index < text.length; index++) {
			RSInterface.addHoverButtonComplete(interfaceId, child, 12 + xOffset + tickXSpaces,
					41 + yOffset, 977, 978, 130, 17, "Select", interfaces, false);
			RSInterface.setSpriteClicked(interfaceId, 979);
			interfaceId += 3;
			child += 2;

			RSInterface.setBounds(interfaceId, 72 + xOffset + tickXSpaces, 43 + yOffset, child,
					interfaces);
			interfaceId++;
			child++;

			tickXSpaces += tickXSpaceIncrease;
		}
		interfaceId += 4;
		Client.setInterfaceClicked(31000, 31006, true, true); // Set Shop tab as
		// default clicked

		// Donator shop text
		RSInterface.setBounds(interfaceId, 250 + xOffset, 17 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		// Right click an item to buy
		RSInterface.setBounds(interfaceId, 250 + xOffset, 68 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		interfaceId = 31201;
		// Scroll content
		RSInterface scrollTab1 = RSInterface.addInterface(interfaceId);
		interfaces.child(child, interfaceId, -17 + xOffset, 90 + yOffset); // Scroll
		// interface.
		scrollTab1.width = 497;
		scrollTab1.height = 228;
		scrollTab1.scrollMax = 1000;
		interfaceId++;
		child++;
		int buttonsAmount = 200;
		scrollTab1.totalChildren(3 * buttonsAmount);
		int xAdd = 0;
		int yAdd = 0;
		int scrollChild = 0;
		yOffset -= 80;
		xOffset += 9;
		int xAddConstant = 76;
		int yAddConstant = 65;
		for (int index = 0; index < buttonsAmount; index++) {

			if ((index) % 6 == 0 && index != 0) {
				yAdd += yAddConstant;
				xAdd = 0;
			}

			String[] tooltips = {"Value", "Buy 1", "Buy 5", "Buy 10", "Buy X"};
			RSInterface.addButtonMultiWithHover(interfaceId, 599, tooltips, 71, 60, 993);
			scrollTab1.child(scrollChild, interfaceId, 30 + xOffset + xAdd, 80 + yOffset + yAdd);
			interfaceId += tooltips.length; // Must be same amount as tooltips
			// length because of the way it
			// works in the client class.
			scrollChild++;

			// Price
			RSInterface.addText(interfaceId, "", textDrawingAreas, 0, ClientConstants.ORANGE, true);
			scrollTab1.child(scrollChild, interfaceId, 62 + xOffset + xAdd, 87 + yOffset + yAdd);
			interfaceId++;
			scrollChild++;

			RSInterface.addToItemGroup(interfaceId, 0, 1, 1, 24, 24, false, null, null, null, true,
					false);
			scrollTab1.child(scrollChild, interfaceId, 48 + xOffset + xAdd, 100 + yOffset + yAdd);
			interfaceId++;
			scrollChild++;

			xAdd += xAddConstant;
		}
	}

	private static void donatorInterfaceMainTab(TextDrawingArea[] textDrawingAreas) {
		int interfaceId = 31000;
		int child = 0;
		RSInterface interfaces = RSInterface.addInterface(33000, 11, 507, 13, 330);
		interfaceId++;
		RSInterface.setChildren(76, interfaces);
		int xOffset = 0;
		int yOffset = 0;

		// Background
		RSInterface.addSpriteComplete(interfaceId, child, 975, 7 + xOffset, 8 + yOffset, interfaces,
				false);
		interfaceId++;
		child++;

		int originalInterfaceId = 0;
		originalInterfaceId = interfaceId;
		interfaceId = 30990;
		// Close button
		RSInterface.addHoverButtonComplete(interfaceId, child, 477 + xOffset, 16 + yOffset, 148, 149,
				15, 15, "Close Window", interfaces, false);
		interfaceId += 3;
		child += 2;
		// Search button
		RSInterface.addHoverButtonComplete(interfaceId, child, 370 + xOffset, 18 + yOffset, 599, 599,
				101, 15, "Search", interfaces, false);
		interfaceId += 3;
		child += 2;
		interfaceId = originalInterfaceId;

		// Tabs
		int tickXSpaces = 0;
		int tickXSpaceIncrease = 121;
		String[] text = {"Main", "Normal shop", "Bundles shop"};
		for (int index = 0; index < text.length; index++) {
			RSInterface.addHoverButtonComplete(interfaceId, child, 12 + xOffset + tickXSpaces,
					41 + yOffset, 977, 978, 130, 17, "Select", interfaces, false);
			RSInterface.setSpriteClicked(interfaceId, 979);
			interfaceId += 3;
			child += 2;

			RSInterface.setBounds(interfaceId, 72 + xOffset + tickXSpaces, 43 + yOffset, child,
					interfaces);
			interfaceId++;
			child++;

			tickXSpaces += tickXSpaceIncrease;
		}
		interfaceId += 4;
		Client.setInterfaceClicked(31000, 31002, true, true); // Set Shop tab as
		// default clicked

		// Donator shop text
		RSInterface.setBounds(interfaceId, 250 + xOffset, 17 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		// Differences start here
		interfaceId = 33001;

		// First timer
		RSInterface.addText(interfaceId, "", textDrawingAreas, 1, ClientConstants.YELLOW, false);
		RSInterface.setTextCountdown(33000, interfaceId);
		RSInterface.setBounds(interfaceId, 398 + xOffset, 68 + yOffset, child, interfaces);
		interfaceId++;
		child++;
		int xAdd = 0;
		int yAdd = 0;
		yOffset += 9;
		int xAddConstant = 123;
		int yAddConstant = 114;
		int buttonsAmount = 4;
		xOffset -= 13;
		for (int index = 0; index < buttonsAmount; index++) {

			if ((index) % 4 == 0 && index != 0) {
				yAdd += yAddConstant;
				xAdd = 0;
			}

			String[] tooltips = {"Value", "Buy 1", "Buy 5", "Buy 10", "Buy X"};
			RSInterface.addButtonMultiWithHover(interfaceId, 599, tooltips, 107, 110, 992);
			RSInterface.setBounds(interfaceId, 30 + xOffset + xAdd, 80 + yOffset + yAdd, child,
					interfaces);
			interfaceId += tooltips.length; // Must be same amount as tooltips
			// length because of the way it
			// works in the client class.
			child++;

			RSInterface.addToItemGroup(interfaceId, 0, 1, 1, 24, 24, false, null, null, null, true,
					false);
			RSInterface.setBounds(interfaceId, 69 + xOffset + xAdd, 143 + yOffset + yAdd, child,
					interfaces);
			interfaceId++;
			child++;

			// Before discount price text
			RSInterface.addText(interfaceId, "", textDrawingAreas, 0, ClientConstants.ORANGE, true);
			RSInterface.setBounds(interfaceId, 83 + xOffset + xAdd, 87 + yOffset + yAdd, child,
					interfaces);
			interfaceId++;
			child++;

			// After discount price text
			RSInterface.addText(interfaceId, "", textDrawingAreas, 1, ClientConstants.YELLOW, true);
			RSInterface.setBounds(interfaceId, 83 + xOffset + xAdd, 98 + yOffset + yAdd, child,
					interfaces);
			interfaceId++;
			child++;

			// Before discount price dash
			RSInterface.addSprite(interfaceId, 599);
			RSInterface.setBounds(interfaceId, 49 + xOffset + xAdd, 92 + yOffset + yAdd, child,
					interfaces);
			interfaceId++;
			child++;

			// Offer badge
			RSInterface.addSprite(interfaceId, 599);
			RSInterface.setBounds(interfaceId, 30 + xOffset + xAdd, 115 + yOffset + yAdd, child,
					interfaces);
			interfaceId++;
			child++;

			// Offer text
			RSInterface.addText(interfaceId, "", textDrawingAreas, 1, ClientConstants.BLUE, true,
					false);
			RSInterface.setBounds(interfaceId, 82 + xOffset + xAdd, 117 + yOffset + yAdd, child,
					interfaces);
			interfaceId++;
			child++;

			xAdd += xAddConstant;
		}

		xOffset += 27;
		yOffset -= 25;
		yOffset -= 28;
		// Purchase button
		RSInterface.addHoverButtonComplete(interfaceId, child, 356 + xOffset, 250 + yOffset, 1220, 1221,
				120, 26, "Select", interfaces, true);
		interfaceId += 3;
		child += 2;

		RSInterface.addText(interfaceId, "Purchase tokens &", textDrawingAreas, 0,
				ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 415 + xOffset, 252 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "view Donator perks", textDrawingAreas, 0,
				ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 415 + xOffset, 262 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		yOffset += 28;
		// View mystery box rewards
		RSInterface.addHoverButtonComplete(interfaceId, child, 356 + xOffset, 250 + yOffset, 746, 749,
				120, 26, "Select", interfaces, true);
		interfaceId += 3;
		child += 2;

		RSInterface.addText(interfaceId, "View mystery", textDrawingAreas, 0, ClientConstants.ORANGE,
				true);
		RSInterface.setBounds(interfaceId, 415 + xOffset, 252 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "box rewards", textDrawingAreas, 0, ClientConstants.ORANGE,
				true);
		RSInterface.setBounds(interfaceId, 415 + xOffset, 262 + yOffset, child, interfaces);
		interfaceId++;
		child++;
		yOffset -= 40;
		xOffset -= 27;
		yOffset += 40;
		yOffset += 25;

		// Background
		RSInterface.addSpriteComplete(interfaceId, child, 1004, 29 + xOffset, 195 + yOffset,
				interfaces, true);
		interfaceId++;
		child++;

		// Loading bar
		RSInterface.addSpriteComplete(interfaceId, child, 1008, 34 + xOffset, 249 + yOffset,
				interfaces, true);
		RSInterface.setSpriteLoadingBarPercentage(interfaceId, 0);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Account offer", textDrawingAreas, 2, ClientConstants.ORANGE,
				true);
		RSInterface.setBounds(interfaceId, 160 + xOffset, 201 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		// Star
		RSInterface.addSpriteComplete(interfaceId, child, 1006, 210 + xOffset, 199 + yOffset,
				interfaces, true);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "", textDrawingAreas, 1, ClientConstants.ORANGE, false);
		RSInterface.setBounds(interfaceId, 33 + xOffset, 215 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "", textDrawingAreas, 1, ClientConstants.ORANGE, false);
		RSInterface.setBounds(interfaceId, 33 + xOffset, 230 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "", textDrawingAreas, 0, ClientConstants.BLACK, true, false);
		RSInterface.setBounds(interfaceId, 155 + xOffset, 252 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		// Second timer
		xOffset += 26;
		RSInterface.addText(interfaceId, "", textDrawingAreas, 0, ClientConstants.YELLOW, false);
		RSInterface.setBounds(interfaceId, 278 + xOffset, 230 + yOffset, child, interfaces);
		RSInterface.setTextCountdown(33000, interfaceId);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "", textDrawingAreas, 0, ClientConstants.ORANGE,
				true);
		RSInterface.setBounds(interfaceId, 309 + xOffset, 240 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "", textDrawingAreas, 0, ClientConstants.ORANGE,
				true);
		RSInterface.setBounds(interfaceId, 309 + xOffset, 250 + yOffset, child, interfaces);
		interfaceId++;
		child++;
		xOffset -= 26;

		yOffset -= 4;
		// Background
		RSInterface.addSpriteComplete(interfaceId, child, 1005, 29 + xOffset, 275 + yOffset,
				interfaces, true);
		interfaceId++;
		child++;

		// Loading bar
		RSInterface.addSpriteComplete(interfaceId, child, 1007, 72 + xOffset, 280 + yOffset,
				interfaces, true);
		RSInterface.setSpriteLoadingBarPercentage(interfaceId, 0);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "", textDrawingAreas, 0, ClientConstants.BLACK, true, false);
		RSInterface.setBounds(interfaceId, 51 + xOffset, 292 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "", textDrawingAreas, 0, ClientConstants.BLACK, true, false);
		RSInterface.setBounds(interfaceId, 220 + xOffset, 294 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "", textDrawingAreas, 0, ClientConstants.BLACK, true, false);
		RSInterface.setBounds(interfaceId, 220 + xOffset, 283 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		yOffset += 7;
		xOffset += 28;
		// View mystery box rewards
		RSInterface.addHoverButtonComplete(interfaceId, child, 356 + xOffset, 250 + yOffset, 746, 749,
				120, 26, "Select", interfaces, true);
		interfaceId += 3;
		child += 2;

		RSInterface.addText(interfaceId, "Claim donation", textDrawingAreas, 0,
				ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 415 + xOffset, 252 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "rewards", textDrawingAreas, 0, ClientConstants.ORANGE,
				true);
		RSInterface.setBounds(interfaceId, 415 + xOffset, 262 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		yOffset += 28;
		// View mystery box rewards
		RSInterface.addHoverButtonComplete(interfaceId, child, 356 + xOffset, 250 + yOffset, 746, 749,
				120, 26, "Select", interfaces, true);
		interfaceId += 3;
		child += 2;

		RSInterface.addText(interfaceId, "Claim account", textDrawingAreas, 0, ClientConstants.ORANGE,
				true);
		RSInterface.setBounds(interfaceId, 415 + xOffset, 252 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "offer rewards", textDrawingAreas, 0, ClientConstants.ORANGE,
				true);
		RSInterface.setBounds(interfaceId, 415 + xOffset, 262 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Right click an item to buy. The item offer expires in",
				textDrawingAreas, 1, ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 238 + xOffset, 28 + yOffset, child, interfaces);
		interfaceId++;
		child++;
	}

	private static void donatorNotification(TextDrawingArea[] textDrawingAreas) {
		int interfaceId = 33200;
		int child = 0;
		RSInterface interfaces = RSInterface.addInterface(interfaceId, 449, 513, 270, 335);
		interfaceId++;
		RSInterface.setChildren(3, interfaces);
		int xOffset = 416;
		int yOffset = 195;

		RSInterface.addHoverButtonComplete(interfaceId, child, 27 + xOffset, 70 + yOffset, 1010, 1011,
				70, 70, "View", interfaces, true);
		RSInterface.setInterfaceIdAdvancedSprite(interfaceId);
		RSInterface.setInterfaceIdAdvancedSprite(interfaceId + 2);
		interfaceId += 3;
		child += 2;

		RSInterface.addText(interfaceId, "New offer!", textDrawingAreas, 0, ClientConstants.ORANGE,
				true);
		RSInterface.setBounds(interfaceId, 62 + xOffset, 82 + yOffset, child, interfaces);
		interfaceId++;
		child++;
	}

	private static void gameModeInterface(TextDrawingArea[] textDrawingAreas) {
		int interfaceId = 23439;
		int child = 0;
		RSInterface interfaces = RSInterface.addInterface(interfaceId, 0, 524, 0, 520);
		interfaceId++;
		RSInterface.setChildren(37, interfaces);
		int xOffset = 29;
		int yOffset = 1;

		// Background
		RSInterface.addSpriteComplete(interfaceId, child, 949, 3 + xOffset, 11 + yOffset, interfaces,
				true);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Gameplay selection", textDrawingAreas, 2,
				ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 228 + xOffset, 15 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Difficulty info", textDrawingAreas, 2,
				ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 308 + xOffset, 49 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Game mode info", textDrawingAreas, 2,
				ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 308 + xOffset, 173 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "You may change your gameplay settings later on",
				textDrawingAreas, 0, ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 186 + xOffset, 285 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Choose difficulty", textDrawingAreas, 2,
				ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 98 + xOffset, 42 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Normal", textDrawingAreas, 0, ClientConstants.ORANGE,
				false);
		RSInterface.setBounds(interfaceId, 50 + xOffset, 73 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		int tickYSpaces = -1;
		int tickYSpaceIncrease = 19;
		RSInterface.addHoverButtonComplete(interfaceId, child, 27 + xOffset,
				70 + yOffset + tickYSpaces, 950, 951, 130, 17, "Select", interfaces, true);
		RSInterface.setSpriteClicked(interfaceId, 952);
		Client.setInterfaceClicked(23439, interfaceId, true, true); // Set information
		// tab to
		// default
		// clicked.
		interfaceId += 3;
		child += 2;
		tickYSpaces += tickYSpaceIncrease;

		RSInterface.addHoverButtonComplete(interfaceId, child, 27 + xOffset,
				70 + yOffset + tickYSpaces, 950, 951, 130, 17, "Select", interfaces, true);
		RSInterface.setSpriteClicked(interfaceId, 952);
		interfaceId += 3;
		child += 2;
		tickYSpaces += tickYSpaceIncrease;

		yOffset -= 4;
		tickYSpaces = 0;
		tickYSpaces = 123;
		RSInterface.addHoverButtonComplete(interfaceId, child, 27 + xOffset,
				70 + yOffset + tickYSpaces, 950, 951, 130, 17, "Select", interfaces, true);
		RSInterface.setSpriteClicked(interfaceId, 952);
		Client.setInterfaceClicked(23440, interfaceId, true, true); // Set information
		// tab to
		// default
		// clicked.
		interfaceId += 3;
		child += 2;
		tickYSpaces += tickYSpaceIncrease;

		RSInterface.addHoverButtonComplete(interfaceId, child, 27 + xOffset,
				70 + yOffset + tickYSpaces, 950, 951, 130, 17, "Select", interfaces, true);
		RSInterface.setSpriteClicked(interfaceId, 952);
		interfaceId += 3;
		child += 2;
		tickYSpaces += tickYSpaceIncrease;

		RSInterface.addHoverButtonComplete(interfaceId, child, 27 + xOffset,
				70 + yOffset + tickYSpaces, 950, 951, 130, 17, "Select", interfaces, true);
		RSInterface.setSpriteClicked(interfaceId, 952);
		interfaceId += 3;
		child += 2;
		tickYSpaces += tickYSpaceIncrease;

		RSInterface.addHoverButtonComplete(interfaceId, child, 27 + xOffset,
				70 + yOffset + tickYSpaces, 950, 951, 130, 17, "Select", interfaces, true);
		RSInterface.setSpriteClicked(interfaceId, 952);
		interfaceId += 3;
		child += 2;
		tickYSpaces += tickYSpaceIncrease;

		int originalId = interfaceId;
		interfaceId = 23557;
		RSInterface.addHoverButtonComplete(interfaceId, child, 27 + xOffset,
				70 + yOffset + tickYSpaces, 950, 951, 130, 17, "Select", interfaces, true);
		RSInterface.setSpriteClicked(interfaceId, 952);
		interfaceId = originalId;
		child += 2;
		tickYSpaces += tickYSpaceIncrease;
		yOffset += 4;

		// Information text
		RSInterface.addText(interfaceId, "Gladiator", textDrawingAreas, 0, ClientConstants.ORANGE,
				false);
		RSInterface.setBounds(interfaceId, 50 + xOffset, 95 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		// Information text
		RSInterface.addText(interfaceId, "Choose game mode", textDrawingAreas, 2,
				ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 98 + xOffset, 166 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		// Information text
		RSInterface.addText(interfaceId, "None", textDrawingAreas, 0, ClientConstants.ORANGE, false);
		RSInterface.setBounds(interfaceId, 50 + xOffset, 192 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		// Information text
		originalId = interfaceId;
		interfaceId = 23560;
		RSInterface.addText(interfaceId, "Pker", textDrawingAreas, 0, ClientConstants.ORANGE, false);
		RSInterface.setBounds(interfaceId, 50 + xOffset, 211 + yOffset, child, interfaces);
		interfaceId = originalId;
		child++;

		// Information text
		RSInterface.addText(interfaceId, "<img=9> Standard Iron man", textDrawingAreas, 0,
				ClientConstants.ORANGE, false);
		RSInterface.setBounds(interfaceId, 50 + xOffset, 230 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		// Information text
		RSInterface.addText(interfaceId, "<img=26> Hardcore Iron Man", textDrawingAreas, 0,
				ClientConstants.ORANGE, false);
		RSInterface.setBounds(interfaceId, 50 + xOffset, 250 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		// Information text
		RSInterface.addText(interfaceId, "<img=25> Ultimate Iron Man", textDrawingAreas, 0,
				ClientConstants.ORANGE, false);
		RSInterface.setBounds(interfaceId, 50 + xOffset, 270 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		// Confirm button
		RSInterface.addHoverButtonComplete(interfaceId, child, 357 + xOffset, 283 + yOffset, 850, 847,
				84, 26, "Confirm", interfaces, true);
		interfaceId += 3;
		child += 2;

		// Confirm text
		RSInterface.addText(interfaceId, "Confirm", textDrawingAreas, 2, ClientConstants.ORANGE,
				true);
		RSInterface.setBounds(interfaceId, 390 + xOffset, 288 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		// Scroll content
		RSInterface scrollTab1 = RSInterface.addInterface(interfaceId);
		interfaces.child(child, interfaceId, 198 + xOffset, 67 + yOffset); // Scroll
		// interface.
		interfaceId++;
		child++;
		int scrollChildren = 35;
		scrollTab1.totalChildren(scrollChildren);
		int y = 5;
		for (int index = 0; index < scrollChildren; index++) {
			RSInterface.addText(interfaceId, "", textDrawingAreas, 0, 0xffb000, false, true);
			scrollTab1.child(index, interfaceId, 0, y);
			interfaceId++;
			y += 13;
		}
		scrollTab1.width = 225;
		scrollTab1.height = 91;
		scrollTab1.scrollMax = 120;

		// Scroll content
		scrollTab1 = RSInterface.addInterface(interfaceId);
		interfaces.child(child, interfaceId, 199 + xOffset, 191 + yOffset); // Scroll
		// interface.
		interfaceId++;
		child++;
		scrollChildren = 35;
		scrollTab1.totalChildren(scrollChildren);
		y = 5;
		for (int index = 0; index < scrollChildren; index++) {
			RSInterface.addText(interfaceId, "", textDrawingAreas, 0, 0xffb000, false, true);
			scrollTab1.child(index, interfaceId, 0, y);
			interfaceId++;
			y += 13;
		}
		scrollTab1.width = 224;
		scrollTab1.height = 91;
		scrollTab1.scrollMax = 120;

		// Close button
		RSInterface.addHoverButtonComplete(interfaceId, child, 429 + xOffset, 14 + yOffset, 148, 149,
				15, 15, "Close Window", interfaces, true);
		interfaceId += 3;
		child += 2;

		RSInterface.addText(interfaceId, "by talking to the Guide npc.", textDrawingAreas, 0,
				ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 186 + xOffset, 297 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		// Background
		RSInterface.addSpriteComplete(interfaceId, child, 953, 420 + xOffset, 290 + yOffset,
				interfaces, true);
		interfaceId++;
		child++;
	}

	public static void lootKeyInterface(TextDrawingArea[] tda) {
		RSInterface tab = RSInterface.addInterface(29100);
		RSInterface.addSprite(29101, 888);
		// 4 rows of 10 items = 40 (28 inventory + 11 worn = 39)
		RSInterface.addHoverButtonLatest(29102, 29103, 29104, 148, 149, 15, 15, "Close Window");
		RSInterface.addText(29105, "Loot key reward", tda, 2, ClientConstants.RED, true, true);
		RSInterface.itemGroup(29106, 10, 4, 12, 8);
		RSInterface.addText(29107, "Estimated loot value: 0", tda, 1, ClientConstants.WHITE, true,
				true);
		RSInterface.addHoverButtonLatest(29108, 29109, 29110, 889, 890, 35, 25, "Bank all");
		tab.totalChildren(8);
		tab.child(0, 29101, 20, 20); // background
		tab.child(1, 29102, 462, 30); // close
		tab.child(2, 29103, 462, 30); // close hover
		tab.child(3, 29105, 265, 30); // title
		tab.child(4, 29106, 40, 63); // item group
		tab.child(5, 29107, 265, 257); // value text
		tab.child(6, 29108, 240, 230); // bank all
		tab.child(7, 29109, 240, 230); // bank all hover
	}

	public static void EcoQuickSetup(TextDrawingArea[] TDA) {
		RSInterface tab = RSInterface.addTabInterface(29900);
		tab.totalChildren(1);
		tab.child(0, 29905, 40, 130); // Scroll

		RSInterface list = RSInterface.addTabInterface(29905);
		/* List/scrollbar */
		int maximumLines = 500;
		for (int i = 29906; i < 29906 + maximumLines; i++) {
			// RSInterface.addSprite(i, 851); //temporary
		}
		list.totalChildren(maximumLines + 5);
		int y = 5;
		for (int index = 0; index < maximumLines; index++) {
			list.child(index, 29906 + index, 0, y);
			y += 19;
		}
		list.width = 80;
		list.height = 145;
		list.scrollMax = 200;

		/*
		 * int newY = 0; int newX = 0; int yStart1 = 22; int yPosition = 0; int interfaceIdStart1 =
		 * 29910; int interfaceIdApplied = 0; int xOffset = 0; int yOffset = 20;
		 */
		/*
		 * for (int index = 0; index < 9; index++) { RSInterface.setBounds(interfaceIdStart1 +
		 * interfaceIdApplied, 34 + xOffset + newX, 240 + yStart1 + yOffset + newY, childIdStart,
		 * tab); //button childIdStart++; RSInterface.setBounds(interfaceIdStart1 + interfaceIdApplied
		 * + 1, 34 + xOffset + newX, 240 + yStart1 + yOffset + newY, childIdStart, tab);
		 * childIdStart++; interfaceIdApplied += 3; RSInterface.setBounds(interfaceIdStart1 +
		 * interfaceIdApplied, 76 + xOffset + newX, 244 + yStart1 + yOffset + newY, childIdStart,
		 * tab); //text childIdStart++; interfaceIdApplied++; newX += 90; if (index == 2 || index ==
		 * 5) { newY += 29; newX = 0; } }
		 */
	}

	public static void EcoQuickSetupChar(TextDrawingArea[] TDA) {
		RSInterface tab = RSInterface.addTabInterface(29950);
		RSInterface.addChar(29951, 700);
		RSInterface.addHoverButton(29952, 765, 43, 29, "Previous", -1, 29953, 1);
		RSInterface.addHoveredButton(29953, 766, 43, 29, 29954);
		RSInterface.addText(29955, "Preview", TDA, 2, ClientConstants.ORANGE, true, true);
		RSInterface.addText(29956, "Back", TDA, 2, ClientConstants.ORANGE, true, true);

		tab.totalChildren(5);
		tab.child(0, 29951, 10, 135);
		tab.child(1, 29952, 10, 215);
		tab.child(2, 29953, 10, 215);
		tab.child(3, 29955, 100, 240);
		tab.child(4, 29956, 25, 240);
	}

	public static void updatesListInterface(TextDrawingArea[] TDA) {
		RSInterface tab = RSInterface.addTabInterface(29300);
		RSInterface.addSprite(29301, 250);
		RSInterface.addHoverButton(29302, 71, 22, 21, "Close", -1, 29303, 3);
		RSInterface.addHoveredButton(29303, 72, 22, 21, 29304);
		RSInterface.addText(29305, "Game Updates Archive", TDA, 2, ClientConstants.ORANGE, true,
				true);
		RSInterface.addSprite(29306, 827);
		tab.totalChildren(6);
		tab.child(0, 29301, 10, 10); // Background
		tab.child(1, 29302, 467, 17); // Close
		tab.child(2, 29303, 467, 17); // Close hover
		tab.child(3, 29305, 260, 19); // Title
		tab.child(4, 29306, 30, 50); // Logo
		tab.child(5, 29307, 40, 130); // Scroll

		RSInterface list = RSInterface.addTabInterface(29307);
		/* List/scrollbar */
		int maximumLines = 500;
		for (int i = 29308; i < 29308 + maximumLines; i++) {
			RSInterface.addText(i, "", TDA, 2, ClientConstants.PALE_ORANGE, true, true, 0xffffff,
					"View update thread", 430);
			RSInterface.addSprite(i, 845);
			RSInterface.addSprite(i, 846);
		}
		list.totalChildren(maximumLines + 5);
		int y = 5;
		for (int index = 0; index < maximumLines; index++) {
			list.child(index, 29308 + index, 0, y);
			y += 19;
		}
		list.width = 430;
		list.height = 175;
		list.scrollMax = 2000;
	}

	private static void npcDoublerInterface(TextDrawingArea[] textDrawingAreas) {
		int interfaceId = 26702;
		int child = 0;
		RSInterface interfaces = RSInterface.addInterface(interfaceId, 23, 498, 36, 308);
		interfaceId++;
		RSInterface.setChildren(50, interfaces);
		int xOffset = 10;
		int yOffset = -43;

		// Background
		RSInterface.addSprite(interfaceId, 800);
		RSInterface.setBounds(interfaceId, 9 + xOffset, 74 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		// Close button.
		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 148, 149, 15, 15, "Close Window");
		RSInterface.setBounds(interfaceId, 461 + xOffset, 77 + yOffset, child, interfaces);
		child++;
		RSInterface.setBounds(interfaceId + 1, 461 + xOffset, 77 + yOffset, child, interfaces);
		child++;
		interfaceId += 3;

		// Background of item prize
		RSInterface.addSprite(interfaceId, 801);
		RSInterface.setBounds(interfaceId, 79 + xOffset, 245 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		int spinSectionY = 4;
		// Background of spinning section
		RSInterface.addSprite(interfaceId, 802);
		RSInterface.setBounds(interfaceId, 20 + xOffset, 169 + yOffset + spinSectionY, child, interfaces);
		interfaceId++;
		child++;

		int spinButtonY = 20;

		// Spin button
		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 809, 810, 80, 33, "Spin!");
		RSInterface.setBounds(interfaceId, 207 + xOffset, 220 + yOffset + spinSectionY + spinButtonY, child, interfaces);
		child++;
		RSInterface.setBounds(interfaceId + 1, 207 + xOffset, 220 + yOffset + spinSectionY + spinButtonY, child, interfaces);
		child++;
		interfaceId += 3;

		// Question mark
		RSInterface.addSprite(interfaceId, 1287);
		RSInterface.setBounds(interfaceId, 223 + xOffset, 224 + yOffset + spinSectionY + spinButtonY, child, interfaces);
		interfaceId++;
		child++;

		// Interface title
		RSInterface.addText(interfaceId, "Double Items", textDrawingAreas, 2, ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 241 + xOffset, 77 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		// Spin text
		RSInterface.addText(interfaceId, "ROLL!", textDrawingAreas, 1, ClientConstants.GOLD, false);
		RSInterface.setBounds(interfaceId, 241 + xOffset, 229 + yOffset + spinSectionY + spinButtonY, child, interfaces);
		interfaceId++;
		child++;

		// Spin description title
		RSInterface.addText(interfaceId, "Roll to double your items!", textDrawingAreas, 3, ClientConstants.GOLD, true);
		RSInterface.setBounds(interfaceId, 241 + xOffset, 116 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		// Spin description
		RSInterface.addText(interfaceId, "You have a chance at doubling or even tripling your item!", textDrawingAreas, 3, ClientConstants.GOLD, true);
		RSInterface.setBounds(interfaceId, 241 + xOffset, 138 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		int x = 0;

		for (int index = 0; index < 9; index++) {
			RSInterface.addSprite(interfaceId, 806); // Background.
			RSInterface.interfaceCache[interfaceId].mysteryBoxX = 0;
			RSInterface.setBounds(interfaceId, 20 + xOffset + x, 175 + yOffset + spinSectionY, child, interfaces);
			interfaceId++;
			child++;
			x += 57;
		}
		x = 0;
		for (int index = 0; index < 9; index++) {
			RSInterface.addToItemGroup(interfaceId, 0, 1, 1, 24, 24, false, null, null, null, true, true);
			RSInterface.interfaceCache[interfaceId].mysteryBoxX = 0;
			RSInterface.setBounds(interfaceId, 31 + xOffset + x, 178 + yOffset + spinSectionY, child, interfaces);
			interfaceId++;
			child++;
			x += 57;
		}
		x = 0;
		for (int index = 0; index < 9; index++) {
			RSInterface.addText(interfaceId, "", textDrawingAreas, 0, ClientConstants.YELLOW, true);
			RSInterface.interfaceCache[interfaceId].mysteryBoxX = 0;
			RSInterface.setBounds(interfaceId, 49 + xOffset + x, 199 + yOffset + spinSectionY, child, interfaces);
			interfaceId++;
			child++;
			x += 57;
		}

		// Arrow pointer
		RSInterface.addSprite(interfaceId, 1292);
		RSInterface.setInterfaceIdAdvancedSprite(interfaceId);
		RSInterface.setBounds(interfaceId, 233 + xOffset, 200 + yOffset + spinSectionY, child, interfaces);
		interfaceId++;
		child++;

		// 3d item won model
		RSInterface.add3dModel(interfaceId, 28075);
		RSInterface.setBounds(interfaceId, 34 + xOffset, 170 + yOffset + spinSectionY + spinButtonY, child, interfaces);
		interfaceId++;
		child++;

		// Prize title
		RSInterface.addText(interfaceId, "Prize", textDrawingAreas, 2, ClientConstants.GOLD, true);
		RSInterface.setBounds(interfaceId, 122 + xOffset, 206 + yOffset + spinSectionY + spinButtonY, child, interfaces);
		interfaceId++;
		child++;

		// Donate for more button
		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 1283, 1285, 97, 33, "Donate for more");
		RSInterface.setBounds(interfaceId, 332 + xOffset, 220 + yOffset + spinSectionY + spinButtonY, child, interfaces);
		child++;
		RSInterface.setBounds(interfaceId + 1, 332 + xOffset, 220 + yOffset + spinSectionY + spinButtonY, child, interfaces);
		child++;
		interfaceId += 3;

		// Donate for more text
		RSInterface.addText(interfaceId, "Donate for more", textDrawingAreas, 0, ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 380 + xOffset, 226 + yOffset + spinSectionY + spinButtonY, child, interfaces);
		interfaceId++;
		child++;

		// Items text
		RSInterface.addText(interfaceId, "Items!", textDrawingAreas, 0, ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 380 + xOffset, 237 + yOffset + spinSectionY + spinButtonY, child, interfaces);
		interfaceId++;
		child++;

		yOffset += 40;
		// Open bank button
		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 1284, 1286, 97, 33, "Open bank");
		RSInterface.setBounds(interfaceId, 332 + xOffset, 220 + yOffset + spinSectionY + spinButtonY, child, interfaces);
		child++;
		RSInterface.setBounds(interfaceId + 1, 332 + xOffset, 220 + yOffset + spinSectionY + spinButtonY, child, interfaces);
		child++;
		interfaceId += 3;

		// Open bank text
		RSInterface.addText(interfaceId, "Open bank", textDrawingAreas, 0, ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 380 + xOffset, 230 + yOffset + spinSectionY + spinButtonY, child, interfaces);
		interfaceId++;
		child++;

		//3d item model amount
		RSInterface.addText(interfaceId, "", textDrawingAreas, 2, ClientConstants.GOLD, true);
		RSInterface.setBounds(interfaceId, 121 + xOffset, 245 + yOffset + spinSectionY + spinButtonY, child, interfaces);
		interfaceId++;
		child++;

	}

	private static void mysteryBox(TextDrawingArea[] textDrawingAreas) {
		int interfaceId = 26400;
		int child = 0;
		RSInterface interfaces = RSInterface.addInterface(interfaceId, 23, 498, 36, 308);
		interfaceId++;
		RSInterface.setChildren(38, interfaces);
		int xOffset = 10;
		int yOffset = -43;

		// Background
		RSInterface.addSprite(interfaceId, 800);
		RSInterface.setBounds(interfaceId, 9 + xOffset, 74 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		// Close button.
		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 1319, 1320, 15,
				15, "Close Window");
		RSInterface.setBounds(interfaceId, 460 + xOffset, 82 + yOffset, child, interfaces);
		child++;
		RSInterface.setBounds(interfaceId + 1, 460 + xOffset, 82 + yOffset, child, interfaces);
		child++;
		interfaceId += 3;

		// Background of item prize
		RSInterface.addSprite(interfaceId, 801);
		RSInterface.setBounds(interfaceId, 79 + xOffset, 245 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		int spinSectionY = 4;
		// Background of spinning section
		RSInterface.addSprite(interfaceId, 802);
		RSInterface.setBounds(interfaceId, 20 + xOffset, 169 + yOffset + spinSectionY, child,
				interfaces);
		interfaceId++;
		child++;

		int spinButtonY = 20;

		// Spin button
		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 809, 810, 80,
				33, "Spin!");
		RSInterface.setBounds(interfaceId, 207 + xOffset, 230 + yOffset + spinSectionY + spinButtonY,
				child, interfaces);
		child++;
		RSInterface.setBounds(interfaceId + 1, 207 + xOffset,
				230 + yOffset + spinSectionY + spinButtonY, child, interfaces);
		child++;
		interfaceId += 3;

		// Question mark
		RSInterface.addSprite(interfaceId, 804);
		RSInterface.setBounds(interfaceId, 223 + xOffset, 224 + yOffset + spinSectionY + spinButtonY,
				child, interfaces);
		interfaceId++;
		child++;

		// Interface title
		RSInterface.addText(interfaceId, "Mystery Box", textDrawingAreas, 2, ClientConstants.ORANGE,
				true);
		RSInterface.setBounds(interfaceId, 241 + xOffset, 77 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		// Spin text
		RSInterface.addText(interfaceId, "", textDrawingAreas, 1, ClientConstants.GOLD, false);
		RSInterface.setBounds(interfaceId, 241 + xOffset, 229 + yOffset + spinSectionY + spinButtonY,
				child, interfaces);
		interfaceId++;
		child++;

		// Spin description title
		RSInterface.addText(interfaceId, "", textDrawingAreas, 3,
				ClientConstants.GOLD, true);
		RSInterface.setBounds(interfaceId, 241 + xOffset, 110 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		// Spin description
		RSInterface.addText(interfaceId,
				"You feeling lucky, PUNK ! ? Take a spin and see just how lucky you are!", textDrawingAreas, 1,
				ClientConstants.GOLD, true);
		RSInterface.setBounds(interfaceId, 241 + xOffset, 128 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		// Spin description
		RSInterface.addText(interfaceId,
				"Mystery boxes give better loot than any item in the donator store.",
				textDrawingAreas, 1, ClientConstants.GOLD, true);
		RSInterface.setBounds(interfaceId, 241 + xOffset, 144 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		int x = 0;

		for (int index = 0; index < 9; index++) {
			RSInterface.addSprite(interfaceId, 806); // Background.
			RSInterface.interfaceCache[interfaceId].mysteryBoxX = 0;
			RSInterface.setBounds(interfaceId, 20 + xOffset + x, 175 + yOffset + spinSectionY, child,
					interfaces);
			interfaceId++;
			child++;
			x += 57;
		}
		x = 0;
		for (int index = 0; index < 9; index++) {
			RSInterface.addToItemGroup(interfaceId, 0, 1, 1, 24, 24, false, null, null, null, true,
					false);
			RSInterface.interfaceCache[interfaceId].mysteryBoxX = 0;
			RSInterface.setBounds(interfaceId, 31 + xOffset + x, 178 + yOffset + spinSectionY, child,
					interfaces);
			interfaceId++;
			child++;
			x += 57;
		}

		// Golden Ags
		RSInterface.addSprite(interfaceId, 807);
		RSInterface.setBounds(interfaceId, 233 + xOffset, 200 + yOffset + spinSectionY, child,
				interfaces);
		interfaceId++;
		child++;

		// 3d item won model
		RSInterface.add3dModel(interfaceId, 28075);
		RSInterface.setBounds(interfaceId, 34 + xOffset, 170 + yOffset + spinSectionY + spinButtonY,
				child, interfaces);
		interfaceId++;
		child++;

		// Prize title
		RSInterface.addText(interfaceId, "Prize", textDrawingAreas, 2, ClientConstants.GOLD, true);
		RSInterface.setBounds(interfaceId, 122 + xOffset, 206 + yOffset + spinSectionY + spinButtonY,
				child, interfaces);
		interfaceId++;
		child++;

		// Donate for more button
		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 803, 805, 97,
				33, "Donate for more");
		RSInterface.setBounds(interfaceId, 332 + xOffset, 220 + yOffset + spinSectionY + spinButtonY,
				child, interfaces);
		child++;
		RSInterface.setBounds(interfaceId + 1, 332 + xOffset,
				220 + yOffset + spinSectionY + spinButtonY, child, interfaces);
		child++;
		interfaceId += 3;

		// Donate for more text
		RSInterface.addText(interfaceId, "", textDrawingAreas, 0,
				ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 380 + xOffset, 226 + yOffset + spinSectionY + spinButtonY,
				child, interfaces);
		interfaceId++;
		child++;

		// Donate for more text
		RSInterface.addText(interfaceId, "", textDrawingAreas, 0,
				ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 380 + xOffset, 237 + yOffset + spinSectionY + spinButtonY,
				child, interfaces);
		interfaceId++;
		child++;

	}

	private static void duelArenaInterfaceModified(TextDrawingArea[] tda) {
		// Opponents Stake:, 6677
		// Your Stake:, 6678
		RSInterface.interfaceCache[6677].textDrawingAreas = tda[0];
		RSInterface.interfaceCache[6677].textSize = 0;
		RSInterface.interfaceCache[6678].textDrawingAreas = tda[0];
		RSInterface.interfaceCache[6678].textSize = 0;
		RSInterface.interfaceCache[6677].offsetY -= 1;
		RSInterface.interfaceCache[6678].offsetY -= 1;
		RSInterface.interfaceCache[669].message = "Anti-scam";
		RSInterface.interfaceCache[8278].message =
				"While enabled there is absolutely no way you can get scammed!";
	}

	public static void spinning(TextDrawingArea[] tda) {
		RSInterface rsinterface = RSInterface.addInterface(26110);
		RSInterface.addSprite(26111, 799);
		RSInterface.addHoverButton(26112, 761, 16, 16, "Close", -1, 26113, 3);
		RSInterface.addHoveredButton(26113, 762, 16, 16, 26114);
		RSInterface.addButton(26115, "Spin Wool", 80, 80, "Spin Wool", 1);
		RSInterface.addButton(26116, "Spin Flax", 80, 80, "Spin Flax", 1);
		RSInterface.addButton(26117, "Spin Sinew", 80, 80, "Spin Sinew", 1);
		RSInterface.addButton(26118, "Spin Roots", 80, 80, "Spin Roots", 1);
		RSInterface.addButton(26119, "Spin Magic Roots", 80, 80, "Spin Magic Roots", 1);
		RSInterface.addButton(26120, "Spin Yak Hair", 80, 80, "Spin Yak Hair", 1);
		RSInterface.addText(26121, "@gre@Ball of Wool", tda, 1, 0xff9933, true, true);
		RSInterface.addText(26122, "@gre@Bow String", tda, 1, 0xff9933, true, true);
		RSInterface.addText(26123, "@gre@Magic Amulet String", tda, 1, 0xff9933, true, true);
		RSInterface.addText(26124, "@gre@C'Bow String", tda, 1, 0xff9933, true, true);
		RSInterface.addText(26125, "@gre@C'Bow String", tda, 1, 0xff9933, true, true);
		RSInterface.addText(26126, "@gre@Rope", tda, 1, 0xff9933, true, true);
		rsinterface.totalChildren(15);
		rsinterface.child(0, 26111, 9, 5);
		rsinterface.child(1, 26112, 443, 15);
		rsinterface.child(2, 26113, 443, 15);
		rsinterface.child(3, 26115, 70, 50); // wool
		rsinterface.child(4, 26116, 200, 50); // flax
		rsinterface.child(5, 26117, 325, 50); // sinew
		rsinterface.child(6, 26118, 70, 170); // roots
		rsinterface.child(7, 26119, 200, 170); // magic roots
		rsinterface.child(8, 26120, 325, 170); // yak hair
		rsinterface.child(9, 26121, 110, 115); // Text
		rsinterface.child(10, 26122, 240, 115); // Text
		rsinterface.child(11, 26123, 360, 115); // Text
		rsinterface.child(12, 26124, 110, 235); // Text
		rsinterface.child(13, 26125, 240, 235); // Text
		rsinterface.child(14, 26126, 360, 235); // Text
	}

	public static void kdrOverlay(TextDrawingArea[] TDA) {
		RSInterface tab = RSInterface.addInterface(14250);
		tab.totalChildren(3);

		RSInterface.addText(14251, "Kills: 0", TDA, 0, ClientConstants.YELLOW, false, true);
		RSInterface.addText(14252, "Deaths: 0", TDA, 0, ClientConstants.YELLOW, false, true);
		RSInterface.addText(14253, "K/D Ratio: 0", TDA, 0, ClientConstants.YELLOW, false, true);

		tab.child(0, 14251, 3, 70);
		tab.child(1, 14252, 3, 82);
		tab.child(2, 14253, 3, 94);
	}

	public static void questInformation(TextDrawingArea[] TDA) {
		RSInterface tab = RSInterface.addTabInterface(14202);
		RSInterface.addSprite(14100, 796);
		RSInterface.addHoverButton(14101, -1, 24, 23, "Close", -1, 14102, 3);
		RSInterface.addHoveredButton(14102, 797, 24, 23, 14103);
		RSInterface.addText(14104, "Quest Name Here", TDA, 3, ClientConstants.BURGUNDY, false, false);
		tab.totalChildren(5);
		tab.child(0, 14100, 25, 5); // Background
		tab.child(1, 14101, 438, 35); // Close
		tab.child(2, 14102, 438, 35); // Close hover
		tab.child(3, 14104, 50, 38); // Quest name
		tab.child(4, 14210, 65, 65); // Scroll

		RSInterface scrollInterface = RSInterface.addTabInterface(14210);
		// scrollInterface.scrollPosition = 0;
		scrollInterface.width = 380;
		scrollInterface.height = 205;
		scrollInterface.scrollMax = 1200;
		int x = 180, y = 5;
		int amountOfLines = 25;
		scrollInterface.totalChildren(amountOfLines);
		for (int i = 0; i < amountOfLines; i++) {
			RSInterface.addText(14105 + i, "", TDA, 1, ClientConstants.DARK_BLUE, true, false);
			RSInterface.addText(14105 + i, "", TDA, 1, ClientConstants.DARK_BLUE, true, false);
			scrollInterface.child(i, 14105 + i, x, y);
			y += 20;
		}
	}

	public static void questTabEcoQuestsList(TextDrawingArea[] TDA) {
		RSInterface tab = RSInterface.addTabInterface(14000);
		RSInterface list = RSInterface.addTabInterface(14001);
		RSInterface.addSprite(14004, 795);
		RSInterface.addText(14002, "Quests", TDA, 2, ClientConstants.ORANGE, false, true);
		RSInterface.addText(14005, "Quest Points: 0", TDA, 2, ClientConstants.ORANGE, false, true);
		RSInterface.addClickableText(26130, "Back", "Back", TDA, 1, 0xff0000, false, true, 500);
		tab.totalChildren(5);
		tab.child(0, 14004, 5, 25); // background
		tab.child(1, 14005, 14, 7); // quest points:
		tab.child(2, 14002, 14, 35); // quests
		tab.child(3, 26130, 140, 7); // back
		tab.child(4, 14001, 5, 50); // scroll

		/* List/scrollbar */
		int questMaximumEntries = 50;
		for (int i = 14007; i < 14007 + questMaximumEntries; i++) {
			RSInterface.addText(i, "", TDA, 0, 0xff0000, false, true, 0xffffff, "Show Quest Tip", 216);
		}
		list.totalChildren(questMaximumEntries + 5);
		int y = 3;
		for (int index = 0; index < questMaximumEntries; index++) {
			list.child(index, 14007 + index, 9, y);
			y += 15;
		}
		list.width = 168;
		list.height = 196;
		list.scrollMax = 900;

		/*
		 * RSInterface scrollTab1 = RSInterface.addInterface(interfaceId);
		 * RSInterface.setBounds(interfaceId, 14 + xOffset, 58 + yOffset, child, interfaces);
		 * interfaceId++; child++; //15 scrollTab1.width = 101; scrollTab1.height = 237;
		 * scrollTab1.scrollMax = 635;
		 * 
		 * int npcList = 30; scrollTab1.totalChildren(npcList); int y = 1; for (int i = 0; i <
		 * npcList; i++) { RSInterface.addText(interfaceId, "", textDrawingAreas, i == 0 ? 2 : 1, i ==
		 * 0 ? ClientConstants.PALE_GREEN : ClientConstants.ORANGE, false, false,
		 * ClientConstants.WHITE, "Select", 150); RSInterface.textClicked(interfaceId, 645, 0, 0);
		 * scrollTab1.child(i, interfaceId, 0, y); interfaceId++; y += 15; }
		 */
	}

	public static void obeliskInterface(TextDrawingArea[] tda) {
		RSInterface rsi = RSInterface.addInterface(24242);
		RSInterface.addSprite(20850, 792);
		RSInterface.addHoverButton(20851, 794, 23, 23, "Close", -1, 20852, 3);
		RSInterface.addHoveredButton(20852, 793, 23, 23, 20853);
		RSInterface.addClickableText(20854, "Level 44 Wilderness", "Select", tda, 1, 0x46320A, true,
				false, 130);
		RSInterface.addClickableText(20855, "Level 27 Wilderness", "Select", tda, 1, 0x46320A, true,
				false, 130);
		RSInterface.addClickableText(20856, "Level 35 Wilderness", "Select", tda, 1, 0x46320A, true,
				false, 130);
		RSInterface.addClickableText(20857, "Level 13 Wilderness", "Select", tda, 1, 0x46320A, true,
				false, 130);
		RSInterface.addClickableText(20858, "Level 19 Wilderness", "Select", tda, 1, 0x46320A, true,
				false, 130);
		RSInterface.addClickableText(20859, "Level 50 Wilderness", "Select", tda, 1, 0x46320A, true,
				false, 130);
		rsi.totalChildren(9);
		rsi.child(0, 20850, 0, 0);
		rsi.child(1, 20851, 465, 35);
		rsi.child(2, 20852, 466, 38);
		rsi.child(3, 20854, 195, 75);
		rsi.child(4, 20855, 195, 92);
		rsi.child(5, 20856, 195, 109);
		rsi.child(6, 20857, 195, 126);
		rsi.child(7, 20858, 195, 143);
		rsi.child(8, 20859, 195, 160);
	}

	public static void orbChargingInterface(TextDrawingArea[] tda) {
		RSInterface rsi = RSInterface.addInterface(24510);
		RSInterface.addSprite(20801, 780);
		RSInterface.addHoverButton(20802, 148, 16, 16, "Close", -1, 20803, 3);
		RSInterface.addHoveredButton(20803, 149, 16, 16, 20804);
		RSInterface.addButton(20805, 781, "Charge @gre@Air orbs");
		RSInterface.addButton(20806, 782, "Charge @gre@Water orbs");
		RSInterface.addButton(20807, 783, "Charge @gre@Earth orbs");
		RSInterface.addButton(20808, 784, "Charge @gre@Fire orbs");
		RSInterface.addText(20811, "Orb Charging", tda, 2, 0xFF981F, true, true);
		RSInterface.addText(20812, "Air - Level 66 Crafting", tda, 1, 0xffffff, true, true);
		RSInterface.addText(20813, "Water - Level 56 Crafting", tda, 1, 0xffffff, true, true);
		RSInterface.addText(20814, "Earth - Level 60 Crafting", tda, 1, 0xffffff, true, true);
		RSInterface.addText(20815, "Fire - Level 63 Crafting", tda, 1, 0xffffff, true, true);
		RSInterface.addText(20816, "Select an orb to begin charging", tda, 1, ClientConstants.ORANGE,
				true, true);
		rsi.totalChildren(13);
		rsi.child(0, 20801, 110, 10);
		rsi.child(1, 20802, 385, 19);
		rsi.child(2, 20803, 385, 19);
		rsi.child(3, 20805, 145, 60);
		rsi.child(4, 20806, 145, 100);
		rsi.child(5, 20807, 145, 140);
		rsi.child(6, 20808, 145, 180);
		rsi.child(7, 20811, 260, 19);
		rsi.child(8, 20812, 260, 70);
		rsi.child(9, 20813, 260, 110);
		rsi.child(10, 20814, 260, 150);
		rsi.child(11, 20815, 260, 190);
		rsi.child(12, 20816, 260, 230);
	}

	public static void priceChecker(TextDrawingArea[] tda) {
		RSInterface rsi = RSInterface.addInterface(24980);
		RSInterface.addSprite(20501, 775);
		RSInterface.addHoverButton(20502, 148, 16, 16, "Close", -1, 20503, 3);
		RSInterface.addHoveredButton(20503, 149, 16, 16, 20504);
		RSInterface.addHoverButton(20505, 776, 36, 36, "Add all", -1, 20506, 1);
		RSInterface.addHoveredButton(20506, 777, 36, 36, 20507);
		RSInterface.addHoverButton(20578, 776, 36, 36, "Withdraw all", -1, 20579, 1);
		RSInterface.addHoveredButton(20579, 776, 36, 36, 20580);
		RSInterface.addText(20511, "Price Checker", tda, 2, 0xFF981F, true, true);
		RSInterface.addText(20512, "Total guide price:", tda, 1, 0xFF981F, true, true);
		RSInterface.addText(20513, "", tda, 0, 0xffffff, true, true);
		rsi.totalChildren(9);
		rsi.child(0, 20501, 15, 10);
		rsi.child(1, 20502, 470, 19);
		rsi.child(2, 20503, 470, 19);
		rsi.child(3, 20505, 450, 280);
		rsi.child(4, 20506, 450, 280);
		rsi.child(5, 20511, 255, 20);
		rsi.child(6, 20512, 255, 282);
		rsi.child(7, 20513, 255, 300);
		rsi.child(8, 20542, 32, 43);

		RSInterface mainScroll = RSInterface.addTabInterface(20542);
		mainScroll.width = 440;
		mainScroll.height = 229;
		mainScroll.scrollMax = 400;
		int itemsAmount = 28;
		RSInterface.setChildren((itemsAmount * 2) + 1, mainScroll);
		int child = 0;
		int y = 0;
		int x = 0;
		RSInterface.addPriceChecker(20543);
		mainScroll.child(child++, 20543, x + 10, y + 5);
		int secondIndex = 0;
		for (int index = 0; index < itemsAmount * 1; index++) {

			RSInterface.addText(20550 + secondIndex, "", tda, 0, 0xffffff, true, true);
			mainScroll.child(child++, 20550 + secondIndex, x + 26, y + 39);
			secondIndex++;
			RSInterface.addText(20550 + secondIndex, "", tda, 0, 0xffffff, true, true);
			mainScroll.child(child++, 20550 + secondIndex, x + 26, y + 49);
			secondIndex++;
			x += 88;
			if ((index + 1) % 5 == 0) {
				x = 0;
				y += 67;
			}
		}
	}

	private static void petMysteryBox(TextDrawingArea[] textDrawingAreas) {
		int interfaceId = 29211;
		int child = 0;
		RSInterface interfaces = RSInterface.addInterface(interfaceId, 165, 368, 74, 295);
		interfaceId++;
		RSInterface.setChildren(10, interfaces);
		int xOffset = 0;
		int yOffset = 0;

		RSInterface.addSprite(interfaceId, 750); // Background.
		RSInterface.setBounds(interfaceId, 100 + xOffset, 71 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Which pet will you unlock?", textDrawingAreas, 2,
				ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 263 + xOffset, 269 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addSprite(interfaceId, 752); // Question mark background
		RSInterface.setBounds(interfaceId, 195 + xOffset, 108 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addSprite(interfaceId, 751); // Question mark.
		RSInterface.setBounds(interfaceId, 245 + xOffset, 125 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addToItemGroup(interfaceId, 0, 1, 1, 24, 24, false, null, null, null, true,
				false);
		RSInterface.setBounds(interfaceId, 248 + xOffset, 145 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 754, 755, 240,
				26, "Claim");
		RSInterface.setBounds(interfaceId, 172 + xOffset, 226 + yOffset, child, interfaces);
		child++;
		RSInterface.setBounds(interfaceId + 1, 172 + xOffset, 226 + yOffset, child, interfaces);
		child++;
		interfaceId += 3;

		RSInterface.addText(interfaceId, "Unlock a pet!", textDrawingAreas, 2, ClientConstants.ORANGE,
				true);
		RSInterface.setBounds(interfaceId, 265 + xOffset, 232 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 148, 149, 15,
				15, "Close Window");
		RSInterface.setBounds(interfaceId, 351 + xOffset, 71 + yOffset, child, interfaces);
		RSInterface.setBounds(interfaceId + 1, 351 + xOffset, 71 + yOffset, child + 1, interfaces);
		child += 2;
		interfaceId += 3;

	}

	private static void donatorTokensTradingPost(TextDrawingArea[] textDrawingAreas) {
		int interfaceId = 28950;
		int child = 0;
		RSInterface interfaces = RSInterface.addInterface(interfaceId, 1, 516, 51, 293);
		interfaceId++;
		RSInterface.setChildren(36, interfaces);
		int xOffset = -8;
		int yOffset = 27;

		RSInterface.addSprite(interfaceId, 744); // Background.
		RSInterface.setBounds(interfaceId, 9 + xOffset, 21 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Donator tokens trading post: (avrg x2,100 bm)",
				textDrawingAreas, 2, ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 265 + xOffset, 30 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Buying", textDrawingAreas, 2, ClientConstants.ORANGE,
				false);
		RSInterface.setBounds(interfaceId, 120 + xOffset, 59 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Selling", textDrawingAreas, 2, ClientConstants.ORANGE,
				false);
		RSInterface.setBounds(interfaceId, 367 + xOffset, 59 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addToItemGroup(interfaceId, 7478, 1, 1, 24, 24, false, null, null, null, false,
				false);
		RSInterface.setBounds(interfaceId, 23 + xOffset, 87 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addToItemGroup(interfaceId, 7478, 1, 1, 24, 24, false, null, null, null, false,
				false);
		RSInterface.setBounds(interfaceId, 273 + xOffset, 87 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "none", textDrawingAreas, 0, ClientConstants.ORANGE, false);
		RSInterface.setBounds(interfaceId, 23 + xOffset, 80 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Price: N/A", textDrawingAreas, 0, ClientConstants.ORANGE,
				false);
		RSInterface.setBounds(interfaceId, 70 + xOffset, 92 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Status: empty", textDrawingAreas, 0, ClientConstants.ORANGE,
				false);
		RSInterface.setBounds(interfaceId, 140 + xOffset, 92 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(14099, "", textDrawingAreas, 0, ClientConstants.ORANGE, false);
		RSInterface.setBounds(14099, 140 + xOffset, 103 + yOffset, child, interfaces);
		child++;

		RSInterface.addText(interfaceId, "none", textDrawingAreas, 0, ClientConstants.ORANGE, false);
		RSInterface.setBounds(interfaceId, 274 + xOffset, 80 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Price: N/A", textDrawingAreas, 0, ClientConstants.ORANGE,
				false);
		RSInterface.setBounds(interfaceId, 319 + xOffset, 92 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Status: empty", textDrawingAreas, 0, ClientConstants.ORANGE,
				false);
		RSInterface.setBounds(interfaceId, 390 + xOffset, 92 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(14098, "", textDrawingAreas, 0, ClientConstants.ORANGE, false);
		RSInterface.setBounds(14098, 390 + xOffset, 103 + yOffset, child, interfaces);
		child++;

		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 746, 749, 120,
				26, "Edit");
		RSInterface.setBounds(interfaceId, 19 + xOffset, 119 + yOffset, child, interfaces);
		child++;
		RSInterface.setBounds(interfaceId + 1, 19 + xOffset, 119 + yOffset, child, interfaces);
		child++;
		interfaceId += 3;

		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 746, 749, 120,
				26, "Cancel");
		RSInterface.setBounds(interfaceId, 139 + xOffset, 119 + yOffset, child, interfaces);
		child++;
		RSInterface.setBounds(interfaceId + 1, 139 + xOffset, 119 + yOffset, child, interfaces);
		child++;
		interfaceId += 3;

		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 745, 748, 240,
				26, "Claim");
		RSInterface.setBounds(interfaceId, 19 + xOffset, 145 + yOffset, child, interfaces);
		child++;
		RSInterface.setBounds(interfaceId + 1, 19 + xOffset, 145 + yOffset, child, interfaces);
		child++;
		interfaceId += 3;

		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 746, 749, 120,
				26, "Edit");
		RSInterface.setBounds(interfaceId, 270 + xOffset, 119 + yOffset, child, interfaces);
		child++;
		RSInterface.setBounds(interfaceId + 1, 270 + xOffset, 119 + yOffset, child, interfaces);
		child++;
		interfaceId += 3;

		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 746, 749, 120,
				26, "Cancel");
		RSInterface.setBounds(interfaceId, 390 + xOffset, 119 + yOffset, child, interfaces);
		child++;
		RSInterface.setBounds(interfaceId + 1, 390 + xOffset, 119 + yOffset, child, interfaces);
		child++;
		interfaceId += 3;

		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 745, 748, 240,
				26, "Claim");
		RSInterface.setBounds(interfaceId, 270 + xOffset, 145 + yOffset, child, interfaces);
		child++;
		RSInterface.setBounds(interfaceId + 1, 270 + xOffset, 145 + yOffset, child, interfaces);
		child++;
		interfaceId += 3;

		int extraOffset = 15;

		RSInterface.addText(interfaceId, "Edit buy offer", textDrawingAreas, 0,
				ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 65 + extraOffset + xOffset, 126 + yOffset, child,
				interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Confirm buy offer", textDrawingAreas, 0,
				ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 184 + extraOffset + xOffset, 126 + yOffset, child,
				interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Nothing to claim", textDrawingAreas, 0,
				ClientConstants.ORANGE, false);
		RSInterface.setBounds(interfaceId, 98 + xOffset, 153 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Edit sell offer", textDrawingAreas, 0,
				ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 316 + extraOffset + xOffset, 126 + yOffset, child,
				interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Confirm sell offer", textDrawingAreas, 0,
				ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 434 + extraOffset + xOffset, 126 + yOffset, child,
				interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Nothing to claim", textDrawingAreas, 0,
				ClientConstants.ORANGE, false);
		RSInterface.setBounds(interfaceId, 353 + xOffset, 153 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 148, 149, 15,
				15, "Close Window");
		RSInterface.setBounds(interfaceId, 495 + xOffset, 30 + yOffset, child, interfaces);
		RSInterface.setBounds(interfaceId + 1, 495 + xOffset, 30 + yOffset, child + 1, interfaces);
		child += 2;
		interfaceId += 3;

		RSInterface.addText(interfaceId, "History", textDrawingAreas, 2, ClientConstants.ORANGE,
				false);
		RSInterface.setBounds(interfaceId, 240 + xOffset, 176 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface scrollTab1 = RSInterface.addInterface(interfaceId);
		RSInterface.setBounds(interfaceId, 2 + xOffset, 175 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		scrollTab1.width = 492;
		scrollTab1.height = 77;
		scrollTab1.scrollMax = 300;

		int textAmount = 20;
		scrollTab1.totalChildren(textAmount);
		for (int index = 0; index < textAmount; index++) {
			RSInterface.addText(interfaceId, "", textDrawingAreas, 0, ClientConstants.ORANGE, false);
			scrollTab1.child(index, interfaceId, 30 + xOffset, -24 + yOffset + ((index + 1) * 16));
			interfaceId++;
		}

	}

	private static void gamblingRules(TextDrawingArea[] textDrawingAreas) {
		int interfaceId = 28870;
		int child = 0;
		RSInterface interfaces = RSInterface.addInterface(interfaceId, 95, 422, 19, 326);
		interfaceId++;
		RSInterface.setChildren(6, interfaces);
		int xOffset = 82;
		int yOffset = -7;

		RSInterface.addSprite(interfaceId, 741); // Background.
		RSInterface.setBounds(interfaceId, 9 + xOffset, 21 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "", textDrawingAreas, 2, ClientConstants.YELLOW, true);
		RSInterface.setBounds(interfaceId, 175 + xOffset, 30 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 742, 743, 145,
				26, "Accept");
		RSInterface.setBounds(interfaceId, 101 + xOffset, 290 + yOffset, child, interfaces);
		child++;
		RSInterface.setBounds(interfaceId + 1, 101 + xOffset, 290 + yOffset, child, interfaces);
		child++;
		interfaceId += 3;

		RSInterface.addText(interfaceId, "I will follow the rules", textDrawingAreas, 2,
				ClientConstants.WHITE, false);
		RSInterface.setBounds(interfaceId, 105 + xOffset, 295 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface scrollTab1 = RSInterface.addInterface(interfaceId);
		RSInterface.setBounds(interfaceId, 0 + xOffset, 58 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		scrollTab1.width = 311;
		scrollTab1.height = 230;
		scrollTab1.scrollMax = 300;

		int textAmount = 50;
		scrollTab1.totalChildren(textAmount);
		for (int index = 0; index < textAmount; index++) {
			RSInterface.addText(interfaceId, "", textDrawingAreas, 0, ClientConstants.ORANGE, true);
			scrollTab1.child(index, interfaceId, 83 + xOffset, 0 + yOffset + ((index + 1) * 16));
			interfaceId++;
		}

	}

	private static void cityPkingInterfacePvp(TextDrawingArea[] textDrawingAreas) {
		int interfaceId = 26000;
		int child = 0;
		RSInterface interfaces = RSInterface.addInterface(interfaceId, 104, 424, 21, 320);
		interfaceId++;
		RSInterface.setChildren(2, interfaces);
		int xOffset = 463;
		int yOffset = 231;

		RSInterface.addSprite(interfaceId, 326); // Background.
		RSInterface.setBounds(interfaceId, 9 + xOffset, 21 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "109-126", textDrawingAreas, 0, ClientConstants.ORANGE,
				true);
		RSInterface.setBounds(interfaceId, 20 + xOffset, 46 + yOffset, child, interfaces);
		interfaceId++;
		child++;
	}

	private static void cityPkingInterfaceSafe(TextDrawingArea[] textDrawingAreas) {
		int interfaceId = 26005;
		int child = 0;
		RSInterface interfaces = RSInterface.addInterface(interfaceId, 104, 424, 21, 320);
		interfaceId++;
		RSInterface.setChildren(3, interfaces);
		int xOffset = 463;
		int yOffset = 231;

		RSInterface.addSprite(interfaceId, 326); // Background.
		RSInterface.setBounds(interfaceId, 9 + xOffset, 21 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addSprite(interfaceId, 732); // Safe icon.
		RSInterface.setBounds(interfaceId, 9 + xOffset, 21 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(26002, "109-126", textDrawingAreas, 0, ClientConstants.ORANGE, true);
		RSInterface.setBounds(26002, 20 + xOffset, 46 + yOffset, child, interfaces);
		child++;
	}

	private static void tournamentLobby(TextDrawingArea[] textDrawingAreas) {
		int interfaceId = 25980;
		RSInterface interfaces = RSInterface.addInterface(interfaceId);
		interfaceId++;
		RSInterface.setChildren(4, interfaces);
		int child = 0;
		int xOffset = 160;
		int yOffset = -21;

		// RSInterface.addSprite(interfaceId, 724); // Background.
		RSInterface.addTransparentSprite(interfaceId, 724, 200);
		RSInterface.setBounds(interfaceId, 51 + xOffset, 24 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Lobby:", textDrawingAreas, 0, ClientConstants.ORANGE,
				false);
		RSInterface.setBounds(interfaceId, 57 + xOffset, 30 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Tournament:", textDrawingAreas, 0, ClientConstants.ORANGE,
				false);
		RSInterface.setBounds(interfaceId, 57 + xOffset, 44 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Next round in:", textDrawingAreas, 0,
				ClientConstants.ORANGE, false);
		RSInterface.setBounds(interfaceId, 57 + xOffset, 58 + yOffset, child, interfaces);
		interfaceId++;
		child++;
	}

	private static void interfaceResizableClicking(TextDrawingArea[] textDrawingAreas) {
		int interfaceId = 0;
		// Deposit box interface.
		interfaceId = 4465;
		RSInterface.interfaceCache[interfaceId].interfaceStartX = 87;
		RSInterface.interfaceCache[interfaceId].interfaceEndX = 449;
		RSInterface.interfaceCache[interfaceId].interfaceStartY = 23;
		RSInterface.interfaceCache[interfaceId].interfaceEndY = 269;

		// Quest interface.
		interfaceId = 25000;
		RSInterface.interfaceCache[interfaceId].interfaceStartX = 21;
		RSInterface.interfaceCache[interfaceId].interfaceEndX = 498;
		RSInterface.interfaceCache[interfaceId].interfaceStartY = 15;
		RSInterface.interfaceCache[interfaceId].interfaceEndY = 327;

		// Xp lamp interface.
		interfaceId = 2808;
		RSInterface.interfaceCache[interfaceId].interfaceStartX = 85;
		RSInterface.interfaceCache[interfaceId].interfaceEndX = 504;
		RSInterface.interfaceCache[interfaceId].interfaceStartY = 12;
		RSInterface.interfaceCache[interfaceId].interfaceEndY = 290;

		// First duel arena interface.
		interfaceId = 6575;
		RSInterface.interfaceCache[interfaceId].interfaceStartX = 15;
		RSInterface.interfaceCache[interfaceId].interfaceEndX = 504;
		RSInterface.interfaceCache[interfaceId].interfaceStartY = 20;
		RSInterface.interfaceCache[interfaceId].interfaceEndY = 331;

		// Second duel arena interface.
		interfaceId = 6412;
		RSInterface.interfaceCache[interfaceId].interfaceStartX = 15;
		RSInterface.interfaceCache[interfaceId].interfaceEndX = 502;
		RSInterface.interfaceCache[interfaceId].interfaceStartY = 24;
		RSInterface.interfaceCache[interfaceId].interfaceEndY = 322;
	}

	private static void zombieReadyInterface(TextDrawingArea[] textDrawingAreas) {
		int interfaceId = 20240;
		RSInterface interfaces = RSInterface.addInterface(interfaceId);
		interfaceId++;
		RSInterface.setChildren(4, interfaces);
		int child = 0;
		int xOffset = 184;
		int yOffset = -21;

		RSInterface.addSprite(interfaceId, 643); // Background.
		RSInterface.setBounds(interfaceId, 1 + xOffset, 24 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "", textDrawingAreas, 0, ClientConstants.ORANGE, false);
		RSInterface.setBounds(interfaceId, 7 + xOffset, 50 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "", textDrawingAreas, 0, ClientConstants.ORANGE, false);
		RSInterface.setBounds(interfaceId, 7 + xOffset, 64 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Ready", textDrawingAreas, 0, ClientConstants.ORANGE, false);
		RSInterface.setBounds(interfaceId, 57 + xOffset, 32 + yOffset, child, interfaces);
		interfaceId++;
		child++;
	}

	private static void zombieInterface(TextDrawingArea[] textDrawingAreas) {
		int interfaceId = 20230;
		RSInterface interfaces = RSInterface.addInterface(interfaceId);
		interfaceId++;
		RSInterface.setChildren(4, interfaces);
		int child = 0;
		int xOffset = 356;
		int yOffset = -21;

		RSInterface.addSprite(interfaceId, 642); // Background.
		RSInterface.setBounds(interfaceId, 51 + xOffset, 24 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "", textDrawingAreas, 0, ClientConstants.ORANGE, false);
		RSInterface.setBounds(interfaceId, 57 + xOffset, 30 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "", textDrawingAreas, 0, ClientConstants.ORANGE, false);
		RSInterface.setBounds(interfaceId, 57 + xOffset, 44 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "", textDrawingAreas, 0, ClientConstants.ORANGE, false);
		RSInterface.setBounds(interfaceId, 57 + xOffset, 58 + yOffset, child, interfaces);
		interfaceId++;
		child++;
	}

	private static void resizableSettings(TextDrawingArea[] textDrawingAreas) {
		int interfaceId = 20200;
		RSInterface interfaces = RSInterface.addInterface(interfaceId, 181, 431, 78, 298);
		interfaceId++;
		RSInterface.setChildren(22, interfaces);
		int child = 0;
		int xOffset = 175;
		int yOffset = 53;

		RSInterface.addSprite(interfaceId, 641); // Background.
		RSInterface.setBounds(interfaceId, 2 + xOffset, 21 + yOffset, child, interfaces);
		interfaceId++;
		child++;
		RSInterface.addText(interfaceId, "Resizable Settings", textDrawingAreas, 2,
				ClientConstants.YELLOW, true);
		RSInterface.setBounds(interfaceId, 97 + xOffset, 30 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 639, 640, 54,
				46, "Toggle");
		RSInterface.setSpriteClicked(interfaceId, 640);
		RSInterface.setBounds(interfaceId, 205, 70 + yOffset, child, interfaces);
		child++;
		RSInterface.setBounds(interfaceId + 1, 205, 70 + yOffset, child, interfaces);
		child++;
		interfaceId += 3;

		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 637, 638, 54,
				46, "Toggle");
		RSInterface.setSpriteClicked(interfaceId, 638);
		RSInterface.setBounds(interfaceId, 275, 70 + yOffset, child, interfaces);
		child++;
		RSInterface.setBounds(interfaceId + 1, 275, 70 + yOffset, child, interfaces);
		child++;
		interfaceId += 3;

		int xOffset1 = 30;
		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 342, 343, 122,
				24, "Toggle");
		RSInterface.setBounds(interfaceId, 211 + xOffset1, 125 + yOffset, child, interfaces);
		child++;
		RSInterface.setBounds(interfaceId + 1, 211 + xOffset1, 125 + yOffset, child, interfaces);
		child++;
		interfaceId += 3;

		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 342, 343, 122,
				24, "Toggle");
		RSInterface.setBounds(interfaceId, 211 + xOffset1, 151 + yOffset, child, interfaces);
		child++;
		RSInterface.setBounds(interfaceId + 1, 211 + xOffset1, 151 + yOffset, child, interfaces);
		child++;
		interfaceId += 3;

		RSInterface.addText(interfaceId, "Landscape tab", textDrawingAreas, 1, ClientConstants.ORANGE,
				false);
		RSInterface.setBounds(interfaceId, 53 + xOffset1 + xOffset, 130 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Hide tab", textDrawingAreas, 1, ClientConstants.ORANGE,
				false);
		RSInterface.setBounds(interfaceId, 75 + xOffset1 + xOffset, 156 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 148, 149, 15,
				15, "Close Window");
		RSInterface.setBounds(interfaceId, 226 + xOffset, 29 + yOffset, child, interfaces);
		RSInterface.setBounds(interfaceId + 1, 226 + xOffset, 29 + yOffset, child + 1, interfaces);
		child += 2;
		interfaceId += 3;

		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 906, 907, 54,
				46, "Toggle");
		RSInterface.setSpriteClicked(interfaceId, 907);
		RSInterface.setBounds(interfaceId, 345, 70 + yOffset, child, interfaces);
		child++;
		RSInterface.setBounds(interfaceId + 1, 345, 70 + yOffset, child, interfaces);
		child++;
		interfaceId += 3;

		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 342, 343, 122,
				24, "Toggle");
		RSInterface.setBounds(interfaceId, 211 + xOffset1, 177 + yOffset, child, interfaces);
		child++;
		RSInterface.setBounds(interfaceId + 1, 211 + xOffset1, 177 + yOffset, child, interfaces);
		child++;
		interfaceId += 3;

		RSInterface.addText(interfaceId, "Transparent tab", textDrawingAreas, 1,
				ClientConstants.ORANGE, false);
		RSInterface.setBounds(interfaceId, 42 + xOffset1 + xOffset, 182 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 342, 343, 122,
				24, "Toggle");
		RSInterface.setBounds(interfaceId, 211 + xOffset1, 203 + yOffset, child, interfaces);
		child++;
		RSInterface.setBounds(interfaceId + 1, 211 + xOffset1, 203 + yOffset, child, interfaces);
		child++;
		interfaceId += 3;

		interfaceId = 20270;
		RSInterface.addText(interfaceId, "Transparent chat", textDrawingAreas, 1,
				ClientConstants.ORANGE, false);
		RSInterface.setBounds(interfaceId, 42 + xOffset1 + xOffset, 208 + yOffset, child, interfaces);
		interfaceId++;
		child++;
	}

	private static void guideInterface(TextDrawingArea[] textDrawingAreas) {

		int interfaceId = 22550;
		RSInterface interfaces = RSInterface.addInterface(interfaceId, 14, 503, 14, 322);
		interfaceId++;
		RSInterface.setChildren(7, interfaces);
		int child = 0;
		int xOffset = 4;
		int yOffset = -8;

		RSInterface.addSprite(interfaceId, 646); // Background.
		RSInterface.setBounds(interfaceId, 2 + xOffset, 21 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "" + ClientConstants.getServerName() + " Guide",
				textDrawingAreas, 2, ClientConstants.YELLOW, true);
		RSInterface.setBounds(interfaceId, 257 + xOffset, 30 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 148, 149, 15,
				15, "Close Window");
		RSInterface.setBounds(interfaceId, 475 + xOffset, 30 + yOffset, child, interfaces);
		RSInterface.setBounds(interfaceId + 1, 475 + xOffset, 30 + yOffset, child + 1, interfaces);
		child += 2;
		interfaceId += 3;

		RSInterface.addText(interfaceId, "", textDrawingAreas, 2, ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 311 + xOffset, 62 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface scrollTab2 = RSInterface.addInterface(interfaceId);
		RSInterface.setBounds(interfaceId, 140 + xOffset, 86 + yOffset, child, interfaces); // scrollTab1
		interfaceId++;
		child++;

		scrollTab2.width = 334;
		scrollTab2.height = 231;
		scrollTab2.scrollMax = 760;
		scrollTab2.totalChildren(50);
		int increaseY = 0;
		for (int i = 0; i < 50; i++) {
			RSInterface.addText(interfaceId, "", textDrawingAreas, 1, ClientConstants.PALE_ORANGE,
					false);
			scrollTab2.child(i, interfaceId, 0 + xOffset, 12 + yOffset + increaseY);
			increaseY += 18;
			interfaceId++;
		}

		RSInterface scrollTab1 = RSInterface.addInterface(interfaceId);
		RSInterface.setBounds(interfaceId, 14 + xOffset, 58 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		scrollTab1.width = 101;
		scrollTab1.height = 259;
		scrollTab1.scrollMax = 450;

		int npcList = 30;
		scrollTab1.totalChildren(npcList);
		int y = 1;
		for (int i = 0; i < npcList; i++) {
			RSInterface.addText(interfaceId, "", textDrawingAreas, i == 0 ? 2 : 1,
					i == 0 ? ClientConstants.PALE_GREEN : ClientConstants.ORANGE, false, false,
					ClientConstants.WHITE, "Select", 150);
			RSInterface.textClicked(interfaceId, 645, 0, 0);
			scrollTab1.child(i, interfaceId, 0, y);
			interfaceId++;
			y += 15;
		}

	}

	private static void hallOfFame(TextDrawingArea[] textDrawingAreas) {

		int interfaceId = 19850;
		RSInterface interfaces = RSInterface.addInterface(interfaceId, 7, 503, 9, 317);
		interfaceId++;
		RSInterface.setChildren(15, interfaces);
		int child = 0;
		int xOffset = 0;
		int yOffset = -16;

		RSInterface.addSprite(interfaceId, 615); // Background.
		RSInterface.setBounds(interfaceId, 2 + xOffset, 21 + yOffset, child, interfaces);
		interfaceId++;
		child++;
		int x1 = 177;

		RSInterface.addText(interfaceId, "Hall Of Fame", textDrawingAreas, 2, ClientConstants.YELLOW,
				true);
		RSInterface.setBounds(interfaceId, 250 + xOffset, 30 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 251, 252, 18,
				18, "Back");
		RSInterface.setBounds(interfaceId, 463, 30 + yOffset, child, interfaces);
		child++;
		RSInterface.setBounds(interfaceId + 1, 463, 30 + yOffset, child, interfaces);
		child++;
		interfaceId += 3;

		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 148, 149, 15,
				15, "Close Window");
		RSInterface.setBounds(interfaceId, 482 + xOffset, 30 + yOffset, child, interfaces);
		RSInterface.setBounds(interfaceId + 1, 482 + xOffset, 30 + yOffset, child + 1, interfaces);
		child += 2;
		interfaceId += 3;

		RSInterface.addSprite(interfaceId, 619);
		RSInterface.setBounds(interfaceId, 12 + xOffset, 57 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "First players to:", textDrawingAreas, 2,
				ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 90 + xOffset, 59 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		String[] numbers = {"1st", "2nd", "3rd"};

		for (int i = 0; i < 3; i++) {
			RSInterface.addSprite(interfaceId, 618);
			RSInterface.setBounds(interfaceId, 6 + xOffset + x1, 57 + yOffset, child, interfaces);
			interfaceId++;
			child++;

			RSInterface.addText(interfaceId, numbers[i], textDrawingAreas, 2, ClientConstants.ORANGE,
					true);
			RSInterface.setBounds(interfaceId, 54 + xOffset + x1, 59 + yOffset, child, interfaces);
			interfaceId++;
			child++;

			x1 += 101;
		}

		RSInterface scrollTab1 = RSInterface.addInterface(interfaceId);
		RSInterface.setBounds(interfaceId, 11 + xOffset, 87 + yOffset, child, interfaces);
		interfaceId++;
		child++;
		scrollTab1.width = 469;
		scrollTab1.height = 231;
		scrollTab1.scrollMax = 635;

		int highscoresAmount = 30;
		scrollTab1.totalChildren(highscoresAmount * 8);
		int y = -66;
		int childHighscores = 0;
		int x2 = 6;
		for (int i = 0; i < highscoresAmount; i++) {
			RSInterface.addSprite(interfaceId, 617);
			scrollTab1.child(childHighscores, interfaceId, 0, 67 + y);
			interfaceId++;
			childHighscores++;

			RSInterface.addSprite(interfaceId, 616);
			scrollTab1.child(childHighscores, interfaceId, 167 + x2, 67 + y);
			interfaceId++;
			childHighscores++;

			RSInterface.addSprite(interfaceId, 616);
			scrollTab1.child(childHighscores, interfaceId, 267 + x2, 67 + y);
			interfaceId++;
			childHighscores++;

			RSInterface.addSprite(interfaceId, 616);
			scrollTab1.child(childHighscores, interfaceId, 367 + x2, 67 + y);
			interfaceId++;
			childHighscores++;

			RSInterface.addText(interfaceId, "", ClientConstants.ORANGE, false, true, -1,
					textDrawingAreas, 1);
			scrollTab1.child(childHighscores, interfaceId, 5, 69 + y + 0);
			interfaceId++;
			childHighscores++;

			RSInterface.addText(interfaceId, "", textDrawingAreas, 1, 0xffb000, true, true, 0xffffff,
					"View profile", 97);
			scrollTab1.child(childHighscores, interfaceId, 166 + x2, 69 + y + 0);
			interfaceId++;
			childHighscores++;
			RSInterface.addText(interfaceId, "", textDrawingAreas, 1, 0xffb000, true, true, 0xffffff,
					"View profile", 97);
			scrollTab1.child(childHighscores, interfaceId, 266 + x2, 69 + y + 0);
			interfaceId++;
			childHighscores++;

			RSInterface.addText(interfaceId, "", textDrawingAreas, 1, 0xffb000, true, true, 0xffffff,
					"View profile", 97);
			scrollTab1.child(childHighscores, interfaceId, 366 + x2, 69 + y + 0);
			interfaceId++;
			childHighscores++;
			y += 21;
		}
	}

	private static void teleportInterface(TextDrawingArea[] textDrawingAreas) {

		int interfaceId = 19700;
		int child = 0;
		RSInterface interfaces = RSInterface.addInterface(interfaceId, 91, 427, 64, 283);
		interfaceId++;
		RSInterface.setChildren(26, interfaces);
		int xOffset = 80;
		int yOffset = 40;

		RSInterface.addSprite(interfaceId, 609); // Background.
		RSInterface.setBounds(interfaceId, 9 + xOffset, 21 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, Config.serverNames[Config.currentServer] + " Teleports", textDrawingAreas, 2, ClientConstants.ORANGE,
				false);
		RSInterface.setBounds(interfaceId, 150 + xOffset, 30 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		int yExtra = -1, count = 0;
		for (int index = 0; index < 7; index++) {
			RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2,
					count % 2 == 0 ? 614 : 968, 610, 89, 26, "Toggle");
			count++;
			RSInterface.setSpriteClicked(interfaceId, 612);
			RSInterface.setBounds(interfaceId, 16 + xOffset, 57 + yOffset + yExtra, child, interfaces);
			RSInterface.hoverHasText(interfaceId + 2);
			child++;
			RSInterface.setBounds(interfaceId + 1, 16 + xOffset, 56 + yOffset + yExtra, child,
					interfaces);
			child++;
			interfaceId += 3;

			RSInterface.addText(interfaceId, "", textDrawingAreas, 2, ClientConstants.ORANGE, true);
			RSInterface.setBounds(interfaceId, 60 + xOffset, 61 + yOffset + yExtra, child, interfaces);
			interfaceId++;
			child++;
			yExtra += 25;
		}
		yExtra = 0;

		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 148, 149, 15,
				15, "Close Window");
		RSInterface.setBounds(interfaceId, 317 + xOffset, 30 + yOffset, child, interfaces);
		RSInterface.setBounds(interfaceId + 1, 317 + xOffset, 30 + yOffset, child + 1, interfaces);
		child += 2;
		interfaceId += 3;

		RSInterface scrollTab1 = RSInterface.addInterface(interfaceId);
		RSInterface.setBounds(interfaceId, 111 + xOffset, 56 + yOffset, child, interfaces); // scrollTab1
		interfaceId++;
		child++;

		scrollTab1.width = 209;
		scrollTab1.height = 174;
		scrollTab1.scrollMax = 402;
		scrollTab1.totalChildren(75);
		int increaseY = 0, childNew = 0;
		for (int i = 0; i < 25; i++) {

			RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2,
					count % 2 == 0 ? 613 : 967, 611, 224, 26, "Click");
			count++;
			RSInterface.hoverHasText(interfaceId + 2);
			scrollTab1.child(childNew, interfaceId, 0, increaseY);
			childNew++;
			scrollTab1.child(childNew, interfaceId + 1, 0, increaseY);
			childNew++;
			interfaceId += 3;

			RSInterface.addText(interfaceId, "", textDrawingAreas, 1, ClientConstants.ORANGE, true);
			scrollTab1.child(childNew, interfaceId, 104, increaseY + 4);
			increaseY += 25;
			interfaceId++;
			childNew++;
		}

	}

	private static void clanChatSetUp(TextDrawingArea[] textDrawingAreas) {
		int interfaceId = 19580;
		int child = 0;
		RSInterface interfaces = RSInterface.addInterface(interfaceId, 106, 414, 22, 330);
		interfaceId++;
		RSInterface.setChildren(36, interfaces);
		int xOffset = 93;
		int yOffset = -4;

		RSInterface.addSprite(interfaceId, 604); // Background.
		RSInterface.setBounds(interfaceId, 9 + xOffset, 21 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Clan Chat", textDrawingAreas, 2, ClientConstants.ORANGE,
				false);
		RSInterface.setBounds(interfaceId, 212 + xOffset, 30 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 599, 605, 53,
				17, "Toggle to public/friends only");
		RSInterface.setBounds(interfaceId, 18 + xOffset, 30 + yOffset, child, interfaces);
		child++;
		RSInterface.setBounds(interfaceId + 1, 18 + xOffset, 30 + yOffset, child, interfaces);
		child++;
		interfaceId += 3;

		RSInterface.addText(interfaceId, "", textDrawingAreas, 0, ClientConstants.ORANGE, false);
		RSInterface.setBounds(interfaceId, 27 + xOffset, 33 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "", textDrawingAreas, 0, ClientConstants.ORANGE, false);
		RSInterface.setBounds(interfaceId, 82 + xOffset, 33 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Moderator", textDrawingAreas, 1, ClientConstants.YELLOW,
				false);
		RSInterface.setBounds(interfaceId, 60 + xOffset, 60 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Banned", textDrawingAreas, 1, ClientConstants.YELLOW,
				false);
		RSInterface.setBounds(interfaceId, 217 + xOffset, 60 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 607, 606, 16,
				16, "Add mod");
		RSInterface.setBounds(interfaceId, 124 + xOffset, 60 + yOffset, child, interfaces);
		child++;
		RSInterface.setBounds(interfaceId + 1, 124 + xOffset, 60 + yOffset, child, interfaces);
		child++;
		interfaceId += 3;

		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 607, 606, 16,
				16, "Add ban");
		RSInterface.setBounds(interfaceId, 265 + xOffset, 60 + yOffset, child, interfaces);
		child++;
		RSInterface.setBounds(interfaceId + 1, 265 + xOffset, 60 + yOffset, child, interfaces);
		child++;
		interfaceId += 3;

		int increaseY = 0;
		for (int index = 0; index < 18; index++) {
			RSInterface.addText(interfaceId, "", textDrawingAreas, 0, ClientConstants.ORANGE, false,
					true, ClientConstants.WHITE, "Demote", 100);
			RSInterface.setBounds(interfaceId, 27 + xOffset, 87 + yOffset + increaseY, child,
					interfaces);
			interfaceId++;
			child++;
			increaseY += 15;
		}

		RSInterface scrollTab1 = RSInterface.addInterface(interfaceId);
		RSInterface.setBounds(interfaceId, 172 + xOffset, 83 + yOffset, child, interfaces); // scrollTab1
		interfaceId++;
		child++;

		scrollTab1.width = 120;
		scrollTab1.height = 236;
		scrollTab1.scrollMax = 760;
		scrollTab1.totalChildren(50);
		increaseY = 0;
		for (int i = 0; i < 50; i++) {
			RSInterface.addText(interfaceId, "", textDrawingAreas, 0, ClientConstants.RED, false,
					false, ClientConstants.WHITE, "Unban", 100);
			scrollTab1.child(i, interfaceId, 7, 8 + yOffset + increaseY);
			increaseY += 15;
			interfaceId++;
		}

		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 599, 608, 117,
				17, "Change name");
		RSInterface.setBounds(interfaceId, 73 + xOffset, 30 + yOffset, child, interfaces);
		child++;
		RSInterface.setBounds(interfaceId + 1, 73 + xOffset, 30 + yOffset, child, interfaces);
		child++;
		interfaceId += 3;

		RSInterface.addText(interfaceId, "", textDrawingAreas, 0, ClientConstants.ORANGE, false);
		RSInterface.setBounds(interfaceId, 82 + xOffset, 33 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 148, 149, 15,
				15, "Close Window");
		RSInterface.setBounds(interfaceId, 386, 26, child, interfaces);
		RSInterface.setBounds(interfaceId + 1, 386, 26, child + 1, interfaces);
		child += 2;
		interfaceId += 3;
	}

	private static void pvpBlacklist(TextDrawingArea[] textDrawingAreas) {
		int interfaceId = 22700;
		int child = 0;
		RSInterface interfaces = RSInterface.addInterface(interfaceId, 186, 343, 30, 311);
		interfaceId++;
		RSInterface.setChildren(7, interfaces);
		int xOffset = 173;
		int yOffset = 4;

		RSInterface.addSprite(interfaceId, 707); // Background.
		RSInterface.setBounds(interfaceId, 9 + xOffset, 21 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Blacklisted", textDrawingAreas, 2, ClientConstants.YELLOW,
				false);
		RSInterface.setBounds(interfaceId, 36 + xOffset, 34 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 607, 606, 16,
				16, "Add blacklist");
		RSInterface.setBounds(interfaceId, 112 + xOffset, 33 + yOffset, child, interfaces);
		child++;
		RSInterface.setBounds(interfaceId + 1, 112 + xOffset, 33 + yOffset, child, interfaces);
		child++;
		interfaceId += 3;

		int increaseY = 0;

		RSInterface scrollTab1 = RSInterface.addInterface(interfaceId);
		RSInterface.setBounds(interfaceId, 22 + xOffset, 56 + yOffset, child, interfaces); // scrollTab1
		interfaceId++;
		child++;

		scrollTab1.width = 120;
		scrollTab1.height = 236;
		scrollTab1.scrollMax = 760;
		scrollTab1.totalChildren(50);
		increaseY = 0;
		for (int i = 0; i < 50; i++) {
			RSInterface.addText(interfaceId, "", textDrawingAreas, 0, ClientConstants.RED, false,
					false, ClientConstants.WHITE, "Remove", 100);
			scrollTab1.child(i, interfaceId, 7, 8 + yOffset + increaseY);
			increaseY += 15;
			interfaceId++;
		}

		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 148, 149, 15,
				15, "Close Window");
		RSInterface.setBounds(interfaceId, 140 + xOffset, 33 + yOffset, child, interfaces);
		RSInterface.setBounds(interfaceId + 1, 140 + xOffset, 33 + yOffset, child + 1, interfaces);
		child += 2;
		interfaceId += 3;
	}

	private static void jewelry(TextDrawingArea[] textDrawingAreas) {

		int interfaceId = 19501;
		int child = 0;
		RSInterface interfaces = RSInterface.addInterface(interfaceId, 104, 424, 21, 320);
		interfaceId++;
		RSInterface.setChildren(10, interfaces);
		int xOffset = 91;
		int yOffset = -4;

		RSInterface.addSprite(interfaceId, 601); // Background.
		RSInterface.setBounds(interfaceId, 9 + xOffset, 21 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Rings", textDrawingAreas, 2, ClientConstants.YELLOW, false);
		RSInterface.setBounds(interfaceId, 150 + xOffset, 58 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "", textDrawingAreas, 1, ClientConstants.WHITE, true);
		RSInterface.setBounds(interfaceId, 169 + xOffset, 113 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "", textDrawingAreas, 1, ClientConstants.WHITE, true);
		RSInterface.setBounds(interfaceId, 169 + xOffset, 207 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "", textDrawingAreas, 1, ClientConstants.WHITE, true);
		RSInterface.setBounds(interfaceId, 169 + xOffset, 286 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 148, 149, 15,
				15, "Close Window");
		RSInterface.setBounds(interfaceId, 304 + xOffset, 30 + yOffset, child, interfaces);
		child++;
		RSInterface.setBounds(interfaceId + 1, 304 + xOffset, 30 + yOffset, child, interfaces);
		child++;
		interfaceId += 4;

		String[] tooltips = {"Gold", "Sapphire", "Emerald", "Ruby", "Diamond", "Dragonstone", "Onyx","Enchanted Gem","Eternal Gem"};
		RSInterface.addButtonMulti(interfaceId, 599, tooltips, 43, 38);
		RSInterface.setBounds(interfaceId, 147 + xOffset, 77 + yOffset, child, interfaces);
		interfaceId += tooltips.length; // Must be same amount as tooltips
		// length because of the way it works in
		// the client class.
		child++;

		RSInterface.addButtonMulti(interfaceId, 599, tooltips, 43, 53);
		RSInterface.setBounds(interfaceId, 144 + xOffset, 169 + yOffset, child, interfaces);
		interfaceId += tooltips.length;
		child++;

		RSInterface.addButtonMulti(interfaceId, 599, tooltips, 40, 36);
		RSInterface.setBounds(interfaceId, 147 + xOffset, 253 + yOffset, child, interfaces);
		interfaceId += tooltips.length;
		child++;
	}

	private static void runePouch(TextDrawingArea[] textDrawingAreas) {
		int interfaceId = 22910;
		int child = 0;
		RSInterface interfaces = RSInterface.addInterface(interfaceId, 89, 440, 29, 314);
		interfaceId++;
		RSInterface.setChildren(9, interfaces);
		int xOffset = 75;
		int yOffset = 4;

		RSInterface.addSprite(interfaceId, 716); // Background.
		RSInterface.setBounds(interfaceId, 9 + xOffset, 21 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Inventory", textDrawingAreas, 1, ClientConstants.ORANGE,
				false);
		RSInterface.setBounds(interfaceId, 158 + xOffset, 138 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 148, 149, 15,
				15, "Close Window");
		RSInterface.setBounds(interfaceId, 335 + xOffset, 30 + yOffset, child, interfaces);
		child++;
		RSInterface.setBounds(interfaceId + 1, 335 + xOffset, 30 + yOffset, child, interfaces);
		child++;
		interfaceId += 4;

		RSInterface.itemGroup(interfaceId, 3, 1, 23, 0);
		RSInterface.setBounds(interfaceId, 115 + xOffset, 86 + yOffset, child, interfaces);
		child++;
		interfaceId += 1;

		String[] tooltips = {"Withdraw All"};
		RSInterface.addButtonMulti(interfaceId, 599, tooltips, 35, 40);
		RSInterface.setBounds(interfaceId, 113 + xOffset, 80 + yOffset, child, interfaces);
		interfaceId += tooltips.length; // Must be same amount as tooltips
		// length because of the way it works in
		// the client class.
		child++;

		RSInterface.addButtonMulti(interfaceId, 599, tooltips, 35, 40);
		RSInterface.setBounds(interfaceId, 167 + xOffset, 80 + yOffset, child, interfaces);
		interfaceId += tooltips.length; // Must be same amount as tooltips
		// length because of the way it works in
		// the client class.
		child++;

		RSInterface.addButtonMulti(interfaceId, 599, tooltips, 35, 40);
		RSInterface.setBounds(interfaceId, 221 + xOffset, 80 + yOffset, child, interfaces);
		interfaceId += tooltips.length; // Must be same amount as tooltips
		// length because of the way it works in
		// the client class.
		child++;

		RSInterface.itemGroup(interfaceId, 7, 4, 15, 2);
		RSInterface.setBounds(interfaceId, 29 + xOffset, 159 + yOffset, child, interfaces);
		child++;
		interfaceId += 1;
	}

	private static void enchantBolts(TextDrawingArea[] textDrawingAreas) {
		int interfaceId = 19530;
		int child = 0;
		RSInterface interfaces = RSInterface.addInterface(interfaceId, 16, 503, 17, 323);
		interfaceId++;
		RSInterface.setChildren(34, interfaces);
		int xOffset = 3;
		int yOffset = -7;

		RSInterface.addSprite(interfaceId, 602); // Background.
		RSInterface.setBounds(interfaceId, 9 + xOffset, 21 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Magic 4", textDrawingAreas, 1, ClientConstants.ORANGE,
				false);
		RSInterface.setBounds(interfaceId, 36 + xOffset, 76 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Magic 7", textDrawingAreas, 1, ClientConstants.ORANGE,
				true);
		RSInterface.setBounds(interfaceId, 154 + xOffset, 76 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Magic 14", textDrawingAreas, 1, ClientConstants.ORANGE,
				true);
		RSInterface.setBounds(interfaceId, 254 + xOffset, 76 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Magic 24", textDrawingAreas, 1, ClientConstants.ORANGE,
				true);
		RSInterface.setBounds(interfaceId, 349 + xOffset, 76 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Magic 27", textDrawingAreas, 1, ClientConstants.ORANGE,
				true);
		RSInterface.setBounds(interfaceId, 440 + xOffset, 76 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Magic 29", textDrawingAreas, 1, ClientConstants.ORANGE,
				true);
		RSInterface.setBounds(interfaceId, 69 + xOffset, 206 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Magic 49", textDrawingAreas, 1, ClientConstants.ORANGE,
				true);
		RSInterface.setBounds(interfaceId, 154 + xOffset, 206 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "1", textDrawingAreas, 0, ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 124 + xOffset, 297 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "5", textDrawingAreas, 0, ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 154 + xOffset, 297 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "1", textDrawingAreas, 0, ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 183 + xOffset, 297 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "1", textDrawingAreas, 0, ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 220 + xOffset, 297 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "10", textDrawingAreas, 0, ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 248 + xOffset, 297 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "2", textDrawingAreas, 0, ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 277 + xOffset, 297 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "1", textDrawingAreas, 0, ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 312 + xOffset, 297 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "15", textDrawingAreas, 0, ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 340 + xOffset, 297 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "1", textDrawingAreas, 0, ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 369 + xOffset, 297 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "1", textDrawingAreas, 0, ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 412 + xOffset, 297 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "20", textDrawingAreas, 0, ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 441 + xOffset, 297 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "1", textDrawingAreas, 0, ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 472 + xOffset, 297 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		// Close button.
		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 148, 149, 15,
				15, "Close Window");
		RSInterface.setBounds(interfaceId, 472 + xOffset, 30 + yOffset, child, interfaces);
		child++;
		RSInterface.setBounds(interfaceId + 1, 472 + xOffset, 30 + yOffset, child, interfaces);
		child++;
		interfaceId += 4;

		RSInterface.addButton(interfaceId, 599, "Enchant", 50, 50);
		RSInterface.setBounds(interfaceId, 125 + xOffset, 224 + yOffset, child, interfaces);
		interfaceId += 1;
		child++;

		RSInterface.addButton(interfaceId, 599, "Enchant", 50, 50);
		RSInterface.setBounds(interfaceId, 223 + xOffset, 224 + yOffset, child, interfaces);
		interfaceId += 1;
		child++;

		RSInterface.addButton(interfaceId, 599, "Enchant", 50, 50);
		RSInterface.setBounds(interfaceId, 315 + xOffset, 224 + yOffset, child, interfaces);
		interfaceId += 1;
		child++;

		RSInterface.addButton(interfaceId, 599, "Enchant", 50, 50);
		RSInterface.setBounds(interfaceId, 414 + xOffset, 224 + yOffset, child, interfaces);
		interfaceId += 1;
		child++;

		RSInterface.addButton(interfaceId, 599, "Enchant", 50, 50);
		RSInterface.setBounds(interfaceId, 120 + xOffset, 97 + yOffset, child, interfaces);
		interfaceId += 1;
		child++;

		RSInterface.addButton(interfaceId, 599, "Enchant", 50, 50);
		RSInterface.setBounds(interfaceId, 414 + xOffset, 97 + yOffset, child, interfaces);
		interfaceId += 1;
		child++;

		RSInterface.addText(interfaceId, "1", textDrawingAreas, 0, ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 123 + xOffset, 167 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "1", textDrawingAreas, 0, ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 152 + xOffset, 167 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "1", textDrawingAreas, 0, ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 182 + xOffset, 167 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "1", textDrawingAreas, 0, ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 414 + xOffset, 167 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "3", textDrawingAreas, 0, ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 445 + xOffset, 167 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "1", textDrawingAreas, 0, ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 473 + xOffset, 167 + yOffset, child, interfaces);
		interfaceId++;
		child++;
	}

	public static void titleInterface(TextDrawingArea[] tda) {
		int interfaceId = 19360;
		int child = 0;
		RSInterface interfaces = RSInterface.addInterface(interfaceId, 111, 420, 16, 324);
		interfaceId++;
		int xOffset = 98;
		int yOffset = -10;

		RSInterface.setChildren(33, interfaces);

		RSInterface.addSprite(interfaceId, 398); // Background.
		RSInterface.setBounds(interfaceId, 9 + xOffset, 21 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		// Tab buttons.
		int x = 15 + xOffset;
		int y = 55 + yOffset;
		for (int index = 0; index < 4; index++) {
			RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 350, 351,
					75, 20, "Select");
			RSInterface.setSpriteClicked(interfaceId, 397);
			RSInterface.setBounds(interfaceId, x, y, child, interfaces);
			child++;
			RSInterface.setBounds(interfaceId + 1, x, y, child, interfaces);
			interfaceId += 4;
			child++;
			x += 74;
		}

		// Interface title.
		RSInterface.addText(interfaceId, "Titles", tda, 2, ClientConstants.ORANGE, false);
		RSInterface.setBounds(interfaceId, 145 + xOffset, 30 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		// Tab titles.
		RSInterface.addText(interfaceId, "Skilling        Pking           Misc       Unlocked", tda,
				2, ClientConstants.YELLOW, false);
		RSInterface.setBounds(interfaceId, 29 + xOffset, 58 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		// Requirements title
		RSInterface.addText(interfaceId, "Requirements", tda, 1, ClientConstants.ORANGE, false);
		RSInterface.setBounds(interfaceId, 200 + xOffset, 86 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		// Current title, title.
		RSInterface.addText(interfaceId, "Current title", tda, 1, ClientConstants.ORANGE, false);
		RSInterface.setBounds(interfaceId, 50 + xOffset, 265 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		// Current title, text.
		RSInterface.addText(interfaceId, "", tda, 1, ClientConstants.YELLOW, true);
		RSInterface.setBounds(interfaceId, 91 + xOffset, 284 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		// Available titles scroll.
		RSInterface scrollTab1 = RSInterface.addInterface(interfaceId);
		RSInterface.setBounds(interfaceId, 26 + xOffset, 86 + yOffset, child, interfaces); // scrollTab1
		interfaceId++;
		child++;

		scrollTab1.width = 120;
		scrollTab1.height = 172;
		scrollTab1.scrollMax = 620;
		scrollTab1.totalChildren(40);
		y = 5;
		for (int i = 0; i < 40; i++) {
			RSInterface.addText(interfaceId, "", tda, 0, ClientConstants.RED, false, false, 0xffffff,
					"Select", 150);
			RSInterface.textClicked(interfaceId, 600, 1, 2);
			scrollTab1.child(i, interfaceId, 0, y);
			y += 15;
			interfaceId++;
		}
		y = 109;
		for (int i = 0; i < 8; i++) {
			RSInterface.addText(interfaceId, "", tda, 0, ClientConstants.PALE_ORANGE, false);
			RSInterface.setBounds(interfaceId, 169 + xOffset, y + yOffset, child, interfaces);
			y += 15;
			interfaceId++;
			child++;
		}

		// Equip button.
		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 199, 200, 72,
				32, "Select");
		RSInterface.setBounds(interfaceId, 160 + xOffset, 275 + yOffset, child, interfaces);
		child++;
		RSInterface.setBounds(interfaceId + 1, 160 + xOffset, 275 + yOffset, child, interfaces);
		child++;
		interfaceId += 4;

		// Un-equip button.
		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 199, 200, 72,
				32, "Select");
		RSInterface.setBounds(interfaceId, 237 + xOffset, 275 + yOffset, child, interfaces);
		child++;
		RSInterface.setBounds(interfaceId + 1, 237 + xOffset, 275 + yOffset, child, interfaces);
		child++;
		interfaceId += 4;

		// Equip text.
		RSInterface.addText(interfaceId, "Equip title", tda, 0, ClientConstants.ORANGE, false);
		RSInterface.setBounds(interfaceId, 173 + xOffset, 285 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		// Un-equip text.
		RSInterface.addText(interfaceId, "Clear title", tda, 0, ClientConstants.ORANGE, false);
		RSInterface.setBounds(interfaceId, 248 + xOffset, 285 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		// Close button.
		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 148, 149, 15,
				15, "Close Window");
		RSInterface.setBounds(interfaceId, 292 + xOffset, 30 + yOffset, child, interfaces);
		child++;
		RSInterface.setBounds(interfaceId + 1, 292 + xOffset, 30 + yOffset, child, interfaces);
		child++;
		interfaceId += 4;

		// Current title, text.
		RSInterface.addText(interfaceId, "", tda, 1, ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 91 + xOffset, 300 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		// Loading bar text.
		RSInterface.addText(interfaceId, "", tda, 0, ClientConstants.WHITE, true);
		RSInterface.setBounds(interfaceId, 233 + xOffset, 239 + yOffset, child, interfaces);
		interfaceId++;
		child++;
	}

	public static void lootingBag(TextDrawingArea[] tda) {
		RSInterface tab = RSInterface.addInterface(22245);
		RSInterface.addSprite(22246, 565);

		RSInterface.addHoverButtonLatest(22247, 22248, 22249, 148, 149, 15, 15, "Close Window");
		RSInterface.addText(22250, "Looting bag", tda, 2, 0xFF9900, true, true);
		RSInterface.itemGroup(22251, 4, 7, 13, 0);
		RSInterface.addText(22252, "Value: 0", tda, 0, 0xFF9900, true, true);
		tab.totalChildren(6);
		tab.child(0, 22246, 9, 21);
		tab.child(1, 22247, 168, 4);
		tab.child(2, 22248, 168, 4);
		tab.child(3, 22250, 95, 4);
		tab.child(4, 22251, 12, 23);
		tab.child(5, 22252, 95, 250);
	}

	public static void untradeableRepairing(TextDrawingArea[] tda) {
		RSInterface tab = RSInterface.addInterface(13500);
		// RSInterface.addSprite(13501, 741);
		RSInterface.addTransparentSprite(13501, 888, 190);

		RSInterface.addHoverButtonLatest(13502, 13503, 13504, 148, 149, 15, 15, "Close Window");
		RSInterface.addText(13505, "Repairable untradeables list", tda, 2, 0xFF9900, true, true);
		RSInterface.itemGroup(13506, 10, 4, 12, 4);
		RSInterface.addText(13507, "", tda, 2, ClientConstants.WHITE, true, true);
		tab.totalChildren(6);
		tab.child(0, 13501, 15, 21);
		tab.child(1, 13502, 455, 32);
		tab.child(2, 13503, 455, 32);
		tab.child(3, 13505, 250, 32);
		tab.child(4, 13506, 35, 65);
		tab.child(5, 13507, 250, 230);
	}

	private static void completionistCape(TextDrawingArea[] textDrawingAreas) {
		int interfaceId = 22060;
		int child = 0;
		RSInterface Interface = RSInterface.addInterface(interfaceId, 55, 461, 10, 334);
		interfaceId++;

		RSInterface.setChildren(17 + 16 * 2, Interface);

		RSInterface.addSprite(interfaceId, 518);
		RSInterface.setBounds(interfaceId, 49, 6, child, Interface); // Background.
		child++;
		interfaceId++;

		RSInterface.addChar(interfaceId, 550);
		RSInterface.setBounds(interfaceId, 275, 200, child, Interface); // Character
		// model.
		child++;
		interfaceId++;

		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 521, 522, 61,
				58, "Choose");
		RSInterface.setBounds(interfaceId, 94, 51, child, Interface);
		RSInterface.setBounds(interfaceId + 1, 94, 51, child + 1, Interface);
		child += 2;
		interfaceId += 3;

		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 521, 522, 61,
				58, "Choose");
		RSInterface.setBounds(interfaceId, 173, 51, child, Interface);
		RSInterface.setBounds(interfaceId + 1, 173, 51, child + 1, Interface);
		child += 2;
		interfaceId += 3;

		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 521, 522, 61,
				58, "Choose");
		RSInterface.setBounds(interfaceId, 94, 126, child, Interface);
		RSInterface.setBounds(interfaceId + 1, 94, 126, child + 1, Interface);
		child += 2;
		interfaceId += 3;

		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 521, 522, 61,
				58, "Choose");
		RSInterface.setBounds(interfaceId, 173, 126, child, Interface);
		RSInterface.setBounds(interfaceId + 1, 173, 126, child + 1, Interface);
		child += 2;
		interfaceId += 3;

		// x += 22
		int x1Original = 79;
		int x1 = 79;
		int y1 = 233;
		for (int i = 0; i < 16; i++) {
			RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 525, 526,
					20, 20, "Choose");
			RSInterface.setBounds(interfaceId, x1, y1, child, Interface);
			RSInterface.setBounds(interfaceId + 1, x1, y1, child + 1, Interface);
			child += 2;
			interfaceId += 3;
			x1 += 25;
			if (i == 6 || i == 13) {
				y1 += 22;
				x1 = x1Original;
			}
		}

		RSInterface.addText(interfaceId, "Top", 0xffff01, true, true, -1, textDrawingAreas, 0);
		RSInterface.setBounds(interfaceId, 125, 110, child, Interface);
		child++;
		interfaceId++;

		RSInterface.addText(interfaceId, "Top detail", 0xffff01, true, true, -1, textDrawingAreas, 0);
		RSInterface.setBounds(interfaceId, 204, 110, child, Interface);
		child++;
		interfaceId++;

		RSInterface.addText(interfaceId, "Bottom", 0xffff01, true, true, -1, textDrawingAreas, 0);
		RSInterface.setBounds(interfaceId, 125, 185, child, Interface);
		child++;
		interfaceId++;

		RSInterface.addText(interfaceId, "Bottom detail", 0xffff01, true, true, -1, textDrawingAreas,
				0);
		RSInterface.setBounds(interfaceId, 204, 185, child, Interface);
		child++;
		interfaceId++;

		RSInterface.addText(interfaceId, "Completionist cape customizer", 0xffff01, true, true, -1,
				textDrawingAreas, 2);
		RSInterface.setBounds(interfaceId, 252, 9, child, Interface);
		child++;
		interfaceId++;

		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 148, 149, 15,
				15, "Close Window");
		RSInterface.setBounds(interfaceId, 435, 9, child, Interface);
		RSInterface.setBounds(interfaceId + 1, 435, 9, child + 1, Interface);
		child += 2;
		interfaceId += 3;

	}

	private static void highscoresInterface1(TextDrawingArea[] textDrawingAreas) {
		int x6 = 2;
		int y6 = -29;
		RSInterface Interface = RSInterface.addInterface(21030, 6, 510, 9, 317);
		RSInterface.setChildren(31, Interface);

		RSInterface.addSprite(21031, 507); // Background
		RSInterface.setBounds(21031, 2, 5, 0, Interface); // Background.

		RSInterface scrollTab1 = RSInterface.addInterface(21040);
		RSInterface.setBounds(21040, 0 + x6, 100 + y6, 1, Interface);

		RSInterface.addHoverButtonLatest(21041, 21042, 21043, 148, 149, 15, 15, "Close Window");
		RSInterface.setBounds(21041, 480 + x6, 43 + y6, 2, Interface);
		RSInterface.setBounds(21042, 480 + x6, 43 + y6, 3, Interface);

		RSInterface.addText(21044, "@yel@Highscores", textDrawingAreas, 2, 0xfffff, true, true);
		RSInterface.setBounds(21044, 250, 13, 4, Interface);

		RSInterface.addText(21045, "@yel@Category", textDrawingAreas, 2, 0xfffff, true, true);
		RSInterface.setBounds(21045, 54, 42, 5, Interface);

		int child = 6;
		int interfaceId = 21050;

		// Start of First column that is outside of the scroll.

		RSInterface.addSprite(interfaceId, 344);
		RSInterface.setBounds(interfaceId, 103 + x6, 70 + y6, child, Interface);
		interfaceId++;
		child++;

		RSInterface.addSprite(interfaceId, 514);
		RSInterface.setBounds(interfaceId, 210 + x6, 70 + y6, child, Interface);
		interfaceId++;
		child++;

		RSInterface.addSprite(interfaceId, 348);//
		RSInterface.setBounds(interfaceId, 316 + x6, 70 + y6, child, Interface);
		interfaceId++;
		child++;

		RSInterface.addSprite(interfaceId, 514);
		RSInterface.setBounds(interfaceId, 376 + x6, 70 + y6, child, Interface);
		interfaceId++;
		child++;
		RSInterface.addText(interfaceId, "Player name:", 0xffb000, false, true, -1, textDrawingAreas,
				2);
		RSInterface.setBounds(interfaceId, 111 + x6, 72 + y6, child, Interface);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Kills:", 0xffb000, true, true, -1, textDrawingAreas, 2);
		RSInterface.setBounds(interfaceId, 261 + x6, 72 + y6, child, Interface);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "Deaths:", 0xffb000, true, true, -1, textDrawingAreas, 2);
		RSInterface.setBounds(interfaceId, 343 + x6, 72 + y6, child, Interface);
		interfaceId++;
		child++;

		RSInterface.addText(interfaceId, "KDR:", 0xffb000, true, true, -1, textDrawingAreas, 2);
		RSInterface.setBounds(interfaceId, 425 + x6, 72 + y6, child, Interface);
		interfaceId++;
		child++;

		int y = 63;
		for (int i = 0; i < 17; i++) {
			interfaceId++;
			RSInterface.addText(interfaceId, "", textDrawingAreas, 0, 0xffb000, false, false, 0xffffff,
					"Select", 83);
			RSInterface.textClicked(interfaceId, 320, 1, 2);
			RSInterface.setBounds(interfaceId, 12 + x6, 30 + y6 + y, child, Interface);
			child++;
			y += 15;
		}
		interfaceId++;

		// End

		int highscoresAmount = 30;
		scrollTab1.totalChildren(highscoresAmount * 8);
		child = 0;
		y = -37;
		for (int i = 0; i < highscoresAmount; i++) {
			RSInterface.addSprite(interfaceId, 347);
			scrollTab1.child(child, interfaceId, 100 + x6, 67 + y + y6);
			interfaceId++;
			child++;

			RSInterface.addSprite(interfaceId, 512);
			scrollTab1.child(child, interfaceId, 208 + x6, 67 + y + y6);
			interfaceId++;
			child++;

			RSInterface.addSprite(interfaceId, 349);
			scrollTab1.child(child, interfaceId, 314 + x6, 67 + y + y6);
			interfaceId++;
			child++;

			RSInterface.addSprite(interfaceId, 512);
			scrollTab1.child(child, interfaceId, 374 + x6, 67 + y + y6);
			interfaceId++;
			child++;
			RSInterface.addText(interfaceId, "", textDrawingAreas, 1, 0xffb000, false, true, 0xffffff,
					"View profile", 97);
			scrollTab1.child(child, interfaceId, 100 + x6, 69 + y + 0 + y6);
			interfaceId++;
			child++;

			RSInterface.addText(interfaceId, "", 0xffb000, true, true, -1, textDrawingAreas, 1);
			scrollTab1.child(child, interfaceId, 258 + x6, 69 + y + 0 + y6);
			interfaceId++;
			child++;

			RSInterface.addText(interfaceId, "", 0xffb000, true, true, -1, textDrawingAreas, 1);
			scrollTab1.child(child, interfaceId, 341 + x6, 69 + y + 0 + y6);
			interfaceId++;
			child++;

			RSInterface.addText(interfaceId, "", 0xffb000, true, true, -1, textDrawingAreas, 1);
			scrollTab1.child(child, interfaceId, 424 + x6, 69 + y + 0 + y6);
			interfaceId++;
			child++;
			y += 21;
		}
		scrollTab1.width = 478;
		scrollTab1.height = 231;
		scrollTab1.scrollMax = 635;

	}

	private static void gwdInterface(TextDrawingArea[] textDrawingAreas) {
		RSInterface tab = RSInterface.addInterface(25957);

		tab.totalChildren(9);
		int yOriginal = 32;
		int y = yOriginal;
		String[] text = {"Armadyl kills", "Bandos kills", "Saradomin kills", "Zamorak kills",
				"@cya@0", "@cya@0", "@cya@0", "@cya@0"};
		int x = 378;
		RSInterface.addText(25958, "NPC Killcount", 0xffb000, false, true, -1, textDrawingAreas, 0);
		tab.child(0, 25958, x, 9);
		for (int i = 0; i < 8; i++) {
			RSInterface.addText(25959 + i, text[i], 0xffb000, false, true, -1, textDrawingAreas, 0);
			tab.child(1 + i, 25959 + i, x, y + 2);
			y += 15;
			if (i == 3) {
				x += 105;
				y = yOriginal;
			}
		}

	}

	static void quickSetUpInterface(TextDrawingArea[] TDA) {
		int xOffset = 0;
		int yOffset = -30;
		RSInterface Interface = RSInterface.addInterface(24280, 23, 513, 8, 333);
		RSInterface.addSprite(24281, 695);
		RSInterface.addHoverButton(24282, 148, 16, 16, "Close", -1, 24283, 1);
		RSInterface.addHoveredButton(24283, 149, 16, 16, 24284);
		RSInterface.addChar(15125, 550);
		if (Config.PVP) {
			RSInterface.addText(24289, "Quick set-up", TDA, 2, 0xffff01, true, true);
		}
		if (Config.PVP) {
			RSInterface.addText(24289, "Equipment presets", TDA, 2, ClientConstants.ORANGE, true,
					true);
			RSInterface.addHoverButton(29600, 281, 72, 32, "Return To Bank", -1, 29601, 5);
			RSInterface.addHoveredButton(29601, 282, 72, 32, 29602);
		}

		String[] equipmentSets =
				{"126 Melee", "126 Hybrid", "126 Tribrid", "Zerk Melee", "Zerk Hybrid", "Pure",
						"Pure Tribrid", "Ranged Tank", "F2P", "Vengeance", "Barrage", "Teleblock"};
		int interfaceIdStart = 24290;
		int interfaceIdModifier = 0;
		for (int i = 0; i < (equipmentSets.length); i++) {
			RSInterface.addHoverButton(interfaceIdStart + interfaceIdModifier, 696, 54, 38, "Spawn",
					-1, (interfaceIdStart + 1) + interfaceIdModifier, 1);
			interfaceIdModifier++;

			RSInterface.addHoveredButton(interfaceIdStart + interfaceIdModifier, 697, 54, 38,
					(interfaceIdStart + 1) + interfaceIdModifier);
			interfaceIdModifier++;
			interfaceIdModifier++;

			RSInterface.addText(interfaceIdStart + interfaceIdModifier, equipmentSets[i], TDA, 0,
					0xffb000, true, false);
			interfaceIdModifier++;
		}

		int childIdStart = 5;
		RSInterface.setChildren(((equipmentSets.length) * 3) + childIdStart + 43, Interface);
		RSInterface.setBounds(24281, 19 + xOffset, 5, 0, Interface); // Background.
		RSInterface.setBounds(24282, 470 + xOffset, 38 + yOffset, 1, Interface); // Close
		// button.
		RSInterface.setBounds(24283, 470 + xOffset, 38 + yOffset, 2, Interface); // Close
		// button
		// hover.
		RSInterface.setBounds(15125, 310 + xOffset, 230 + yOffset, 3, Interface); // Character
		RSInterface.setBounds(24289, 245 + xOffset, 38 + yOffset, 4, Interface); // Quick
		// set-up
		// text.
		int yPosition = 0;
		int interfaceIdStart1 = 24290;
		int interfaceIdApplied = 0;
		int yStart = 65;
		int ySTart2 = 105;
		int x = 0;
		for (int a = 0; a < equipmentSets.length; a++) {
			RSInterface.setBounds(interfaceIdStart1 + interfaceIdApplied, 43 + x + xOffset,
					yStart + yPosition + yOffset, childIdStart, Interface); // Spawn
			// 1
			// button.
			interfaceIdApplied++;
			childIdStart++;
			RSInterface.setBounds(interfaceIdStart1 + interfaceIdApplied, 43 + x + xOffset,
					yStart + yPosition + yOffset, childIdStart, Interface); // Spawn
			// 1
			// hover
			// button.
			interfaceIdApplied++;
			interfaceIdApplied++;
			childIdStart++;
			RSInterface.setBounds(interfaceIdStart1 + interfaceIdApplied, 71 + x + xOffset,
					ySTart2 + yPosition + yOffset, childIdStart, Interface); // Spawn
			// 1
			// text.
			interfaceIdApplied++;
			childIdStart++;
			x += 65;
			if (a == 3 || a == 7) {
				x = 0;
				yPosition += 60;
			}
		}

		yPosition = 0;

		// 126 melee
		RSInterface.addSprite(interfaceIdStart1 + interfaceIdApplied, 698);
		RSInterface.setBounds(interfaceIdStart1 + interfaceIdApplied, 56 + xOffset, 67 + yOffset,
				childIdStart, Interface);
		childIdStart++;
		interfaceIdApplied++;

		// 126 hybrid
		RSInterface.addSprite(interfaceIdStart1 + interfaceIdApplied, 698);
		RSInterface.setBounds(interfaceIdStart1 + interfaceIdApplied, 108 + xOffset, 67 + yOffset,
				childIdStart, Interface);
		childIdStart++;
		interfaceIdApplied++;

		RSInterface.addSprite(interfaceIdStart1 + interfaceIdApplied, 700);
		RSInterface.setBounds(interfaceIdStart1 + interfaceIdApplied, 130 + xOffset, 67 + yOffset,
				childIdStart, Interface);
		childIdStart++;
		interfaceIdApplied++;

		// 126 tribrid
		RSInterface.addSprite(interfaceIdStart1 + interfaceIdApplied, 1015);
		RSInterface.setBounds(interfaceIdStart1 + interfaceIdApplied, 176 + xOffset, 67 + yOffset,
				childIdStart, Interface);
		childIdStart++;
		interfaceIdApplied++;

		// Zerk melee
		RSInterface.addSprite(interfaceIdStart1 + interfaceIdApplied, 699);
		RSInterface.setBounds(interfaceIdStart1 + interfaceIdApplied, 250 + xOffset, 67 + yOffset,
				childIdStart, Interface);
		childIdStart++;
		interfaceIdApplied++;

		// Zerk hybrid
		RSInterface.addSprite(interfaceIdStart1 + interfaceIdApplied, 699);
		RSInterface.setBounds(interfaceIdStart1 + interfaceIdApplied, 45 + xOffset, 128 + yOffset,
				childIdStart, Interface);
		childIdStart++;
		interfaceIdApplied++;

		RSInterface.addSprite(interfaceIdStart1 + interfaceIdApplied, 700);
		RSInterface.setBounds(interfaceIdStart1 + interfaceIdApplied, 65 + xOffset, 128 + yOffset,
				childIdStart, Interface);
		childIdStart++;
		interfaceIdApplied++;

		// Pure
		RSInterface.addSprite(interfaceIdStart1 + interfaceIdApplied, 701);
		RSInterface.setBounds(interfaceIdStart1 + interfaceIdApplied, 121 + xOffset, 128 + yOffset,
				childIdStart, Interface);
		childIdStart++;
		interfaceIdApplied++;

		// Pure tribrid
		RSInterface.addSprite(interfaceIdStart1 + interfaceIdApplied, 706);
		RSInterface.setBounds(interfaceIdStart1 + interfaceIdApplied, 174 + xOffset, 128 + yOffset,
				childIdStart, Interface);
		childIdStart++;
		interfaceIdApplied++;

		RSInterface.addSprite(interfaceIdStart1 + interfaceIdApplied, 702);
		RSInterface.setBounds(interfaceIdStart1 + interfaceIdApplied, 199 + xOffset, 128 + yOffset,
				childIdStart, Interface);
		childIdStart++;
		interfaceIdApplied++;

		// Ranged tank
		RSInterface.addSprite(interfaceIdStart1 + interfaceIdApplied, 704);
		RSInterface.setBounds(interfaceIdStart1 + interfaceIdApplied, 239 + xOffset, 128 + yOffset,
				childIdStart, Interface);
		childIdStart++;
		interfaceIdApplied++;

		RSInterface.addSprite(interfaceIdStart1 + interfaceIdApplied, 706);
		RSInterface.setBounds(interfaceIdStart1 + interfaceIdApplied, 259 + xOffset, 128 + yOffset,
				childIdStart, Interface);
		childIdStart++;
		interfaceIdApplied++;
		// F2p
		RSInterface.addSprite(interfaceIdStart1 + interfaceIdApplied, 703);
		RSInterface.setBounds(interfaceIdStart1 + interfaceIdApplied, 56 + xOffset, 189 + yOffset,
				childIdStart, Interface);
		childIdStart++;
		interfaceIdApplied++;
		// Vengeance
		RSInterface.addSprite(interfaceIdStart1 + interfaceIdApplied, 694);
		RSInterface.setBounds(interfaceIdStart1 + interfaceIdApplied, 128 + xOffset, 195 + yOffset,
				childIdStart, Interface);
		childIdStart++;
		interfaceIdApplied++;
		// Barrage
		RSInterface.addSprite(interfaceIdStart1 + interfaceIdApplied, 711);
		RSInterface.setBounds(interfaceIdStart1 + interfaceIdApplied, 191 + xOffset, 195 + yOffset,
				childIdStart, Interface);
		childIdStart++;
		interfaceIdApplied++;
		// Teleblock
		RSInterface.addSprite(interfaceIdStart1 + interfaceIdApplied, 709);
		RSInterface.setBounds(interfaceIdStart1 + interfaceIdApplied, 255, 195 + yOffset,
				childIdStart, Interface);
		childIdStart++;
		interfaceIdApplied++;

		int newY = 0;
		int newX = 0;
		int yStart1 = 22;
		interfaceIdStart1 = 22800;
		for (int index = 0; index < 9; index++) {
			RSInterface.addHoverButtonLatest(interfaceIdStart1 + interfaceIdApplied,
					interfaceIdStart1 + interfaceIdApplied + 1,
					interfaceIdStart1 + interfaceIdApplied + 2, 288, 289, 85, 20, "Load preset");
			RSInterface.setBounds(interfaceIdStart1 + interfaceIdApplied, 34 + xOffset + newX,
					240 + yStart1 + yOffset + newY, childIdStart, Interface);
			childIdStart++;
			RSInterface.setBounds(interfaceIdStart1 + interfaceIdApplied + 1, 34 + xOffset + newX,
					240 + yStart1 + yOffset + newY, childIdStart, Interface);
			childIdStart++;
			interfaceIdApplied += 3;
			RSInterface.addText(interfaceIdStart1 + interfaceIdApplied, "Empty preset", TDA, 0,
					ClientConstants.YELLOW, true, false);
			RSInterface.setBounds(interfaceIdStart1 + interfaceIdApplied, 76 + xOffset + newX,
					244 + yStart1 + yOffset + newY, childIdStart, Interface);
			childIdStart++;
			interfaceIdApplied++;
			newX += 90;
			if (index == 2 || index == 5) {
				newY += 29;
				newX = 0;
			}
		}

	}

	public static void wildernessInterface(TextDrawingArea[] tda) {
		RSInterface tab = RSInterface.addInterface(24390);
		tab.totalChildren(2);

		RSInterface.addText(24391, "", 0xe1981c, true, true, -1, tda, 1);
		RSInterface.addTransparentSprite(24392, 326, 128);

		tab.child(0, 24391, 476, 37);
		tab.child(1, 24392, 469, 10);
	}

	


	public static void barrowsInterface(TextDrawingArea[] tda) {
		RSInterface tab = RSInterface.addInterface(22045);

		tab.totalChildren(6);
		int y = 235;
		String[] text = {"Dharok", "Guthan", "Ahrim", "Torag", "Verac", "Karil"};
		for (int i = 0; i < 6; i++) {
			RSInterface.addText(22046 + i, text[i], 0xff0000, true, true, -1, tda, 1);
			tab.child(0 + i, 22046 + i, 470, y);
			y += 15;
		}
	}

	public static void normalPrayerBook(TextDrawingArea[] tda) {
		RSInterface tab = RSInterface.addTabInterface(5608);
		RSInterface currentPray = RSInterface.interfaceCache[687];
		currentPray.textColour = 0xFF981F;
		currentPray.textShadow = true;
		currentPray.message = "%1/%2";
		RSInterface.addSprite(5651, 232);
		int xOffset = -3;
		int yOffset = 10;
		// These are the glow locations
		RSInterface.addPrayer(18000, 0, 601, 7, 233, 401, "Sharp Eye");
		RSInterface.addPrayer(18002, 0, 602, 8, 234, 402, "Mystic Will");
		RSInterface.addPrayer(18004, 0, 603, 25, 235, 403, "Hawk Eye");
		RSInterface.addPrayer(18006, 0, 604, 26, 236, 404, "Mystic Lore");
		RSInterface.addPrayer(18008, 0, 605, 43, 237, 405, "Eagle Eye");
		RSInterface.addPrayer(18010, 0, 606, 44, 238, 406, "Mystic Might");
		RSInterface.addPrayer(18012, 0, 607, 59, 239, 407, "Chivalry");
		RSInterface.addPrayer(18014, 0, 608, 69, 240, 408, "Piety");
		RSInterface.addPrayer(22960, 0, 609, 54, 727, 730, "Preserve");
		RSInterface.addPrayer(22962, 0, 610, 73, 725, 728, "Rigour");
		RSInterface.addPrayer(22964, 0, 611, 76, 726, 729, "Augury");
		RSInterface.addSpriteOld(22043, "Prayer/ICON 0");
		tab.totalChildren(90);
		/* Buttons/glows */
		tab.child(0, 5609, 6 + xOffset, -1 + yOffset); // Thick skin
		tab.child(1, 5610, 43 + xOffset, -1 + yOffset);
		tab.child(2, 5611, 80 + xOffset, -1 + yOffset);
		tab.child(3, 5612, 6 + xOffset, 36 + yOffset); // Rock skin
		tab.child(4, 5613, 43 + xOffset, 36 + yOffset);
		tab.child(5, 5614, 80 + xOffset, 36 + yOffset);
		tab.child(6, 5615, 117 + xOffset, 36 + yOffset); // Rapid restore
		tab.child(7, 5616, 154 + xOffset, 36 + yOffset); // Rapid heal
		tab.child(8, 5617, 6 + xOffset, 72 + yOffset); // Protect item
		tab.child(9, 5618, 117 + xOffset, 73 + yOffset); // Steel skin
		tab.child(10, 5619, 154 + xOffset, 74 + yOffset); // Ultimate strength
		tab.child(11, 5620, 6 + xOffset, 110 + yOffset);
		tab.child(12, 5621, 43 + xOffset, 110 + yOffset);
		tab.child(13, 5622, 80 + xOffset, 110 + yOffset);
		tab.child(14, 5623, 117 + xOffset, 110 + yOffset); // Protect from melee
		tab.child(15, 683, 43 + xOffset, 149 + yOffset); // Retribution
		tab.child(16, 684, 80 + xOffset, 147 + yOffset); // Redemption
		tab.child(17, 685, 117 + xOffset, 147 + yOffset); // Smite
		/* Sprites */
		tab.child(18, 5632, 8 + xOffset, 1 + yOffset); // Thick skin
		tab.child(19, 5633, 45 + xOffset, 1 + yOffset);
		tab.child(20, 5634, 82 + xOffset, 1 + yOffset);
		tab.child(21, 5635, 8 + xOffset, 38 + yOffset); // Rock skin
		tab.child(22, 5636, 45 + xOffset, 38 + yOffset); // Superhuman strength
		tab.child(23, 5637, 82 + xOffset, 38 + yOffset); // Improved reflexes
		tab.child(24, 5638, 119 + xOffset, 38 + yOffset); // Rapid restore
		tab.child(25, 5639, 156 + xOffset, 38 + yOffset); // Rapid heal
		tab.child(26, 5640, 8 + xOffset, 75 + yOffset); // Protect item
		tab.child(27, 5641, 119 + xOffset, 75 + yOffset); // Steel skin
		tab.child(28, 5642, 156 + xOffset, 75 + yOffset); // Ultimate strength
		tab.child(29, 5643, 8 + xOffset, 112 + yOffset); // Ultimate reflexes
		tab.child(30, 5644, 45 + xOffset, 112 + yOffset); // Protect from magic
		tab.child(31, 686, 82 + xOffset, 112 + yOffset); // Protect from ranged
		tab.child(32, 5645, 119 + xOffset, 112 + yOffset); // Protect from melee
		tab.child(33, 5649, 45 + xOffset, 149 + yOffset); // Retribution
		tab.child(34, 5647, 82 + xOffset, 149 + yOffset); // Redemption
		tab.child(35, 5648, 119 + xOffset, 149 + yOffset); // Smite
		/* New prayers */
		tab.child(36, 18000, 117 + xOffset, -1 + yOffset); // Even number is
		// prayer glow.
		// Sharp eye
		tab.child(37, 18001, 120 + xOffset, 3 + yOffset); // Odd number is
		// prayer off. Sharp
		// eye
		tab.child(38, 18002, 154 + xOffset, 1 + yOffset); // Mystic will
		tab.child(39, 18003, 157 + xOffset, 4 + yOffset); // Mystic will
		tab.child(40, 18004, 43 + xOffset, 73 + yOffset); // Hawk eye
		tab.child(41, 18005, 46 + xOffset, 77 + yOffset); // Hawk eye
		tab.child(42, 18006, 80 + xOffset, 73 + yOffset); // Mystic lore
		tab.child(43, 18007, 83 + xOffset, 78 + yOffset); // Mystic lore
		tab.child(44, 18008, 154 + xOffset, 109 + yOffset); // Eagle eye
		tab.child(45, 18009, 157 + xOffset, 114 + yOffset);// Eagle eye
		tab.child(46, 18010, 6 + xOffset, 149 + yOffset); // Mystic might
		tab.child(47, 18011, 9 + xOffset, 152 + yOffset); // Mystic might
		tab.child(48, 18012, 6 + xOffset, 183 + yOffset); // Chivalry glow
		tab.child(49, 18013, 13 + xOffset, 186 + yOffset); // Chivalry
		tab.child(50, 18014, 43 + xOffset, 183 + yOffset); // Piety glow
		tab.child(51, 18015, 45 + xOffset, 194 + yOffset); // Piety
		/* Prayer icons & text */
		tab.child(52, 5651, 65 + xOffset, 228 + yOffset);
		tab.child(53, 687, 23 + xOffset, 227 + yOffset);
		tab.child(54, 22043, 65 + xOffset, 230 + yOffset);
		String[] hoverText = {"Level 01\\nThick Skin\\nIncreases your Defence by 5%",
				"Level 04\\nBurst of Strength\\nIncreases your Strength by 5%",
				"Level 07\\nClarity of Thought\\nIncreases your Attack by 5%",
				"Level 08\\nSharp Eye\\nIncreases your Ranged by 5%",
				"Level 09\\nMystic Will\\nIncreases your Magic by 5%",
				"Level 10\\nRock Skin\\nIncreases your Defence by 10%",
				"Level 13\\nSuperhuman Strength\\nIncreases your Strength by 10%",
				"Level 16\\nImproved Reflexes\\nIncreases your Attack by 10%",
				"Level 19\\nRapid Restore\\n2x restore rate for all stats\\nexcept Hitpoints and Prayer",
				"Level 22\\nRapid Heal\\n2x restore rate for the\\nHitpoints stat",
			"Level 25\\nProtect Item\\nKeep 1 extra item if you die",
				"Level 26\\nHawk Eye\\nIncreases your Ranged by 10%",
				"Level 27\\nMystic Lore\\nIncreases your Magic by 10%",
				"Level 28\\nSteel Skin\\nIncreases your Defence by 15%",
				"Level 31\\nUltimate Strength\\nIncreases your Strength by 15%",
				"Level 34\\nIncredible Reflexes\\nIncreases your Attack by 15%",
				"Level 37\\nProtect from Magic\\nProtection from magical attacks",
				"Level 40\\nProtect from Missles\\nProtection from ranged attacks",
				"Level 43\\nProtect from Melee\\nProtection from melee attacks",
				"Level 44\\nEagle Eye\\nIncreases your Ranged by 15%",
				"Level 45\\nMystic Might\\nIncreases your Magic by 15%",
				"Level 46\\nRetribution\\nInflicts damage to nearby\\ntargets if you die",
				"Level 49\\nRedemption\\nHeals you when damaged\\nand Hitpoints falls\\nbelow 10%",
				"Level 52\\nSmite\\n1/4 of damage dealt is\\nalso removed from\\nopponent's Prayer",
				"Level 55\\nPreserve\\nBoosted stats last 50% longer",
				"Level 60\\nChivalry\\nIncreases your Defence by 20%,\\nStrength by 18%, and Attack by\\n15%",
				"Level 70\\nPiety\\nIncreases your Defence by 25%,\\nStrength by 23%, and Attack by\\n20%",
				"Level 74\\nRigour\\nIncreases your Ranged by 20%,\\nRanged strength by 23%, and\\nDefence by 25%",
				"Level 77\\nAugury\\nIncreases your Magic by 25%\\nand Defence by 25%",};

		// Position of the hover box.
		int[][] hoverBoxPosition = {{36, 80}, {36, 80}, {41, 80}, {45, 80}, {55, 80}, {36, 116},
				{36, 116}, {41, 116}, {50, 116}, {83, 116}, {34, 152}, {36, 152}, {40, 152}, {34, 152},
				{32, 152}, {36, 188}, {33, 188}, {34, 188}, {42, 188}, {41, 188}, {35, 224}, {38, 110},
				{50, 93}, {87, 93}, // Index 23
				{35, 224}, // Preserve tooltip
				{30, 134}, // Chivalry tooltip
				{50, 134}, // Piety tooltip
				{50, 134}, // Rigour tooltip
				{50, 134}, // Augury tooltip
		};
		tab.child(55, 22960, 154 + xOffset, 149 + yOffset); // Preserve
		tab.child(56, 22961, 156 + xOffset, 149 + yOffset); // Preserve
		tab.child(57, 22962, 80 + xOffset, 184 + yOffset); // Rigour
		tab.child(58, 22963, 82 + xOffset, 186 + yOffset); // Rigour
		tab.child(59, 22964, 117 + xOffset, 186 + yOffset); // Augury
		tab.child(60, 22965, 119 + xOffset, 186 + yOffset); // Augury
		int x = 8;
		int y = 6;
		for (int index = 0; index < 29; index++) {
			RSInterface.createTimedHoverBox(22150 + index, hoverText[index], 33, 33,
					hoverBoxPosition[index][0], hoverBoxPosition[index][1]);
			tab.child(61 + index, 22150 + index, x, y);
			x += 34;
			if (index == 4 || index == 9 || index == 14 || index == 19 || index == 24) {
				x = 8;
				y += 36;
			}
		}

		String[] tools = {"Thick Skin", "Burst of Strength", "Clarity of Thought", "Rock Skin",
				"Superhuman Strength", "Improved Reflexes", "Rapid Restore", "Rapid Heal",
			"Protect Item",
			"Steel Skin",
			"Ultimate Strength",
			"Incredible Reflexes",
				"Protect from Magic", "Protect from Range", "Protect from Melee", "Retribution",
				"Redemption", "Smite"};
		int count = 0;
		for (int j = 5609; j <= 5623; j++) {
			RSInterface tab2 = RSInterface.interfaceCache[j];
			tab2.tooltip = "Activate @or2@" + tools[count++];
		}
		for (int j = 683; j <= 685; j++) {
			RSInterface tab2 = RSInterface.interfaceCache[j];
			tab2.tooltip = "Activate @or2@" + tools[count++];
		}
	}

	public static void quickPrayers(TextDrawingArea[] TDA) {

		// use 22966
		int frame = 0;
		RSInterface tab = RSInterface.addTabInterface(22923);
		RSInterface.addSprite(17201, 147);
		RSInterface.addText(17230, "Select your quick prayers:", TDA, 0, 0xff981f, false, true);
		RSInterface.addTransparentSprite(17229, 245, 50);
		int i = 17202;
		int j = 0;
		for (j = 650; i <= 17228 && j <= 676; j++, i++) {
			RSInterface.addConfigButton(i, 22923, 247, 246, 14, 15, "Select", 0, 1, j);
		}
		RSInterface.addConfigButton(22966, 22923, 247, 246, 14, 15, "Select", 0, 1, j);
		j++;
		RSInterface.addConfigButton(22967, 22923, 247, 246, 14, 15, "Select", 0, 1, j);
		j++;
		RSInterface.addConfigButton(22968, 22923, 247, 246, 14, 15, "Select", 0, 1, j);

		RSInterface.addHoverButton(17231, 248, 190, 24, "Confirm Selection", -1, 17232, 1);
		RSInterface.addHoveredButton(17232, 249, 190, 24, 17233);
		RSInterface.setChildren(64, tab);
		RSInterface.setBounds(5632, 5, 28, frame++, tab);
		RSInterface.setBounds(5633, 44, 28, frame++, tab);
		RSInterface.setBounds(5634, 79, 31, frame++, tab);
		RSInterface.setBounds(18001, 116, 30, frame++, tab);
		RSInterface.setBounds(18003, 153, 29, frame++, tab);

		RSInterface.setBounds(5635, 5, 68, frame++, tab);
		RSInterface.setBounds(5636, 44, 67, frame++, tab);
		RSInterface.setBounds(5637, 79, 69, frame++, tab);
		RSInterface.setBounds(5638, 116, 70, frame++, tab);
		RSInterface.setBounds(5639, 154, 70, frame++, tab);

		RSInterface.setBounds(5640, 4, 104, frame++, tab);
		RSInterface.setBounds(18005, 44, 107, frame++, tab);
		RSInterface.setBounds(18007, 81, 105, frame++, tab);
		RSInterface.setBounds(5641, 117, 105, frame++, tab);
		RSInterface.setBounds(5642, 156, 107, frame++, tab);

		RSInterface.setBounds(5643, 5, 145, frame++, tab);
		RSInterface.setBounds(5644, 43, 144, frame++, tab);
		RSInterface.setBounds(686, 83, 144, frame++, tab);
		RSInterface.setBounds(5645, 115, 141, frame++, tab);
		RSInterface.setBounds(18009, 154, 144, frame++, tab);

		RSInterface.setBounds(18011, 5, 180, frame++, tab);
		RSInterface.setBounds(5649, 41, 178, frame++, tab);
		RSInterface.setBounds(5647, 79, 183, frame++, tab);
		RSInterface.setBounds(5648, 116, 178, frame++, tab);
		RSInterface.setBounds(18013, 11, 207, frame++, tab); // Chivalry icon
		RSInterface.setBounds(18015, 40, 221, frame++, tab); // Piety icon
		RSInterface.setBounds(22961, 153, 180, frame++, tab); // Preserve icon
		RSInterface.setBounds(22963, 80, 211, frame++, tab); // Rigour icon
		RSInterface.setBounds(22965, 117, 208, frame++, tab); // Augury icon

		RSInterface.setBounds(17229, 0, 25, frame++, tab);
		RSInterface.setBounds(17201, 0, 22, frame++, tab);
		RSInterface.setBounds(17201, 0, 237, frame++, tab);

		RSInterface.setBounds(17202, 2, 25, frame++, tab); // First prayer
		// defence tick
		RSInterface.setBounds(17203, 41, 25, frame++, tab);
		RSInterface.setBounds(17204, 76, 25, frame++, tab);
		RSInterface.setBounds(17205, 113, 25, frame++, tab);
		RSInterface.setBounds(17206, 150, 25, frame++, tab);
		RSInterface.setBounds(17207, 2, 65, frame++, tab);
		RSInterface.setBounds(17208, 41, 65, frame++, tab);
		RSInterface.setBounds(17209, 76, 65, frame++, tab);
		RSInterface.setBounds(17210, 113, 65, frame++, tab);
		RSInterface.setBounds(17211, 150, 65, frame++, tab);
		RSInterface.setBounds(17212, 2, 102, frame++, tab);
		RSInterface.setBounds(17213, 41, 102, frame++, tab);
		RSInterface.setBounds(17214, 76, 102, frame++, tab);
		RSInterface.setBounds(17215, 113, 102, frame++, tab);
		RSInterface.setBounds(17216, 150, 102, frame++, tab);
		RSInterface.setBounds(17217, 2, 141, frame++, tab);
		RSInterface.setBounds(17218, 41, 141, frame++, tab);
		RSInterface.setBounds(17219, 76, 141, frame++, tab);
		RSInterface.setBounds(17220, 113, 141, frame++, tab);
		RSInterface.setBounds(17221, 150, 141, frame++, tab);
		RSInterface.setBounds(17222, 2, 177, frame++, tab);
		RSInterface.setBounds(17223, 41, 177, frame++, tab);
		RSInterface.setBounds(17224, 76, 177, frame++, tab);
		RSInterface.setBounds(17225, 113, 177, frame++, tab);
		RSInterface.setBounds(17226, 150, 177, frame++, tab); // Chivalry tick
		RSInterface.setBounds(17227, 1, 211, frame++, tab); // Piety tick
		RSInterface.setBounds(22966, 41, 211, frame++, tab); //
		RSInterface.setBounds(22967, 76, 211, frame++, tab); //
		RSInterface.setBounds(22968, 113, 211, frame++, tab); //

		RSInterface.setBounds(17230, 5, 5, frame++, tab);
		RSInterface.setBounds(17231, 5, 237, frame++, tab);
		RSInterface.setBounds(17232, 5, 237, frame++, tab);
	}

	public static void questInterface(TextDrawingArea atextdrawingarea[]) {
		RSInterface rsinterface = RSInterface.addInterface(25000, 21, 497, 8, 330);
		rsinterface.centerText = true;
		RSInterface.addSprite(25001, 243);
		RSInterface.addSprite(25002, 244);
		RSInterface.addText(25003, "", 0, true, false, 52, atextdrawingarea, 3);
		RSInterface.addHover(25004, 3, 0, 25005, 241, 26, 23, "Close Window");
		RSInterface.addHovered(25005, 242, 26, 23, 25006);
		RSInterface.setChildren(6, rsinterface);
		RSInterface.setBounds(25002, 18, 4, 0, rsinterface);
		RSInterface.setBounds(25001, 18, 62, 1, rsinterface);
		RSInterface.setBounds(25003, 260, 15, 2, rsinterface);
		RSInterface.setBounds(25007, 50, 86, 3, rsinterface);
		RSInterface.setBounds(25004, 452, 63, 4, rsinterface);
		RSInterface.setBounds(25005, 452, 63, 5, rsinterface);
		rsinterface = RSInterface.addInterface(25007);
		rsinterface.height = 217;
		rsinterface.width = 404;
		rsinterface.scrollMax = 1700;
		RSInterface.setChildren(291, rsinterface);
		int i = 18;
		int j = 0;//
		for (int k = 25008; k <= 25298; k++) {
			RSInterface.addText(k, "", 128, true, false, 52, atextdrawingarea, 1);
			RSInterface.setBounds(k, 202, i, j, rsinterface);
			j++;
			i += 19;
			i++;
		}
	}

	public static void clientSettings(TextDrawingArea[] tda) {
		RSInterface rsi = RSInterface.addTabInterface(17300);
		RSInterface.addSprite(17301, 286);
		RSInterface.addText(17302, "@yel@Settings", tda, 2, 0xFFFFFF, true, true);
		RSInterface.addHoverButton(17303, 148, 16, 16, "Close Window", -1, 17304, 1);
		RSInterface.addHoveredButton(17304, 149, 16, 16, 17305);
		RSInterface.addSprite(17306, 285);
		RSInterface.addSprite(17307, 285);
		RSInterface.addHoverButton(17295, 253, 16, 16, "Next", -1, 17296, 1);
		RSInterface.addHoveredButton(17296, 254, 16, 16, 17297);
		RSInterface.addText(17298, "Page 1/6", tda, 0, 0xffb000, true, true);
		int child1 = 0;
		int base = 17310;
		String[] settingName = {"Gameframe: @gr3@562", "Hitsplats: @gr3@562", "New menu",
				"XP counter  ", "X10 damage  ", "New HP bar  ", "Spec attack orb   "};
		int settingsAmount = settingName.length;
		int order1 = 0;
		for (int i = 0; i < settingsAmount; i++) {
			RSInterface.addHoverButton(base + child1, 342, 122, 24,
					"Toggle " + Settings.hoverText[i][0], -1, (base + child1) + 1, 1);
			child1++;
			RSInterface.addHoveredButton(base + child1, 343, 122, 24, (base + child1) + 1);
			child1 += 2;
			RSInterface.addText(base + child1, settingName[order1], tda, 1, 0xffb000, true, true);
			child1++;
			order1++;
		}
		int child = 0;
		int y = 41;
		int order = 9;
		rsi.totalChildren((settingsAmount * 3) + order);
		rsi.child(0, 17301, 0, 44); // Background.
		rsi.child(1, 17302, 90, 6); // Settings text.
		rsi.child(2, 17303, 171, 6); // Close.
		rsi.child(3, 17304, 171, 6); // Close hover.
		rsi.child(4, 17306, 0, 44); // Line.
		rsi.child(5, 17307, 0, 250); // Line.
		rsi.child(6, 17295, 171, 25); // Arrow.
		rsi.child(7, 17296, 171, 25); // Arrow.
		rsi.child(8, 17298, 124, 28); // Page text.

		for (int i = 0; i < settingsAmount; i++) {
			rsi.child(order, base + child, 34, y + 10); // Hover.
			child++;
			order++;
			rsi.child(order, base + child, 34, y + 10); // Hover.
			order++;
			child++;
			child++;
			rsi.child(order, base + child, 93, y + 15);
			order++;
			child++;
			y += 28;
		}
	}

	private static void questTabInformationTabEco(TextDrawingArea[] textDrawingAreas) {
		int interfaceId = 22980;
		int child = 0;
		RSInterface interfaces = RSInterface.addInterface(interfaceId, 0, 524, 0, 520);
		interfaceId++;
		RSInterface.setChildren(17, interfaces);
		int xOffset = 0;
		int yOffset = 1;

		// Background
		RSInterface.addSpriteComplete(interfaceId, child, 831, 4 + xOffset, 39 + yOffset, interfaces,
				true);
		interfaceId++;
		child++;

		// Mini background
		RSInterface.addSpriteComplete(interfaceId, child, 833, 11 + xOffset, 74 + yOffset, interfaces,
				true);
		interfaceId++;
		child++;

		// Information text background
		RSInterface.addSpriteComplete(interfaceId, child, 832, 11 + xOffset, 46 + yOffset, interfaces,
				true);
		interfaceId++;
		child++;

		// Information text
		RSInterface.addText(interfaceId, "Information", textDrawingAreas, 2, ClientConstants.RED,
				true);
		RSInterface.setBounds(interfaceId, 95 + xOffset, 49 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		int buttonSpacing = 0;
		int buttonSpacingIncrease = 45;
		// Information button
		RSInterface.addHoverButtonComplete(interfaceId, child, 4 + xOffset, 5 + yOffset, 830, 835, 46,
				35, "Information", interfaces, true);
		RSInterface.setSpriteClicked(interfaceId, 834);
		Client.setInterfaceClicked(22980, interfaceId, true, true); // Set information
		// tab to
		// default
		// clicked.
		interfaceId += 3;
		child += 2;
		buttonSpacing += buttonSpacingIncrease;

		// Information button icon
		RSInterface.addSpriteComplete(interfaceId, child, 829, 16 + xOffset, 13 + yOffset, interfaces,
				true);
		interfaceId++;
		child++;

		// Panel button
		RSInterface.addHoverButtonComplete(interfaceId, child, 4 + xOffset + buttonSpacing,
				5 + yOffset, 830, 835, 46, 35, "Panel", interfaces, true);
		RSInterface.setSpriteClicked(interfaceId, 834);
		interfaceId += 3;
		child += 2;
		buttonSpacing += buttonSpacingIncrease;

		// Panel button icon
		RSInterface.addSpriteComplete(interfaceId, child, 827, 63 + xOffset, 13 + yOffset, interfaces,
				true);
		interfaceId++;
		child++;

		// Activity button
		RSInterface.addHoverButtonComplete(interfaceId, child, 4 + xOffset + buttonSpacing,
				5 + yOffset, 830, 835, 46, 35, "Activities", interfaces, true);
		RSInterface.setSpriteClicked(interfaceId, 834);
		interfaceId += 3;
		child += 2;
		buttonSpacing += buttonSpacingIncrease;

		// Activity button icon
		RSInterface.addSpriteComplete(interfaceId, child, 828, 107 + xOffset, 12 + yOffset,
				interfaces, true);
		interfaceId++;
		child++;

		// Quest button
		RSInterface.addHoverButtonComplete(interfaceId, child, 4 + xOffset + buttonSpacing,
				5 + yOffset, 830, 835, 46, 35, "Quest", interfaces, true);
		RSInterface.setSpriteClicked(interfaceId, 834);
		interfaceId += 3;
		child += 2;

		// Quest button icon
		RSInterface.addSpriteComplete(interfaceId, child, 87, 152 + xOffset, 12 + yOffset, interfaces,
				true);
		interfaceId++;
		child++;

		// Scroll content
		RSInterface scrollTab1 = RSInterface.addInterface(interfaceId);
		interfaces.child(child, interfaceId, 14, 76); // Scroll interface.
		interfaceId++;
		child++;
		int scrollChildren = 35;
		scrollTab1.totalChildren(scrollChildren);
		int y = 5;
		for (int index = 0; index < scrollChildren; index++) {
			if (index == 0 || index == 4 || index == 9) {
				RSInterface.addText(interfaceId, "", textDrawingAreas, 0, 0xffb000, false, true);
			} else {
				if (index <= 9) {
					RSInterface.addText(interfaceId, "", textDrawingAreas, 0, 0xffb000, false, true);
				} else {
					RSInterface.addText(interfaceId, "", textDrawingAreas, 0, 0xffb000, false, true,
							0xffffff, "Quick chat", 226);
				}
			}
			scrollTab1.child(index, interfaceId, 0, y);
			interfaceId++;
			y += 13;
		}
		scrollTab1.width = 148;
		scrollTab1.height = 170;
		scrollTab1.scrollMax = 380;
	}

	private static void questTabPanelTabEco(TextDrawingArea[] textDrawingAreas) {
		int interfaceId = 22980;
		int child = 0;
		RSInterface interfaces = RSInterface.addInterface(23089, 0, 524, 0, 520); // Must
		// change
		// id
		// to
		// a
		// different
		// one
		// for
		// duplicate
		// interfaces
		interfaceId++;
		RSInterface.setChildren(17, interfaces);
		int xOffset = 0;
		int yOffset = 1;

		// Background
		RSInterface.addSpriteComplete(interfaceId, child, 831, 4 + xOffset, 39 + yOffset, interfaces,
				false);
		interfaceId++;
		child++;

		// Mini background
		RSInterface.addSpriteComplete(interfaceId, child, 833, 11 + xOffset, 74 + yOffset, interfaces,
				false);
		interfaceId++;
		child++;

		// Information text background
		RSInterface.addSpriteComplete(interfaceId, child, 832, 11 + xOffset, 46 + yOffset, interfaces,
				false);
		interfaceId++;
		child++;

		// Information text
		RSInterface.addText(interfaceId, "Information", textDrawingAreas, 2, ClientConstants.ORANGE,
				true);
		RSInterface.setBounds(interfaceId, 95 + xOffset, 49 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		int buttonSpacing = 0;
		int buttonSpacingIncrease = 45;
		// Information button
		RSInterface.addHoverButtonComplete(interfaceId, child, 4 + xOffset, 5 + yOffset, 830, 835, 46,
				35, "Information", interfaces, false);
		interfaceId += 3;
		child += 2;
		buttonSpacing += buttonSpacingIncrease;

		// Information button icon
		RSInterface.addSpriteComplete(interfaceId, child, 829, 16 + xOffset, 13 + yOffset, interfaces,
				false);
		interfaceId++;
		child++;

		// Panel button
		RSInterface.addHoverButtonComplete(interfaceId, child, 4 + xOffset + buttonSpacing,
				5 + yOffset, 830, 835, 46, 35, "Panel", interfaces, false);
		interfaceId += 3;
		child += 2;
		buttonSpacing += buttonSpacingIncrease;

		// Panel button icon
		RSInterface.addSpriteComplete(interfaceId, child, 827, 63 + xOffset, 13 + yOffset, interfaces,
				false);
		interfaceId++;
		child++;

		// Activity button
		RSInterface.addHoverButtonComplete(interfaceId, child, 4 + xOffset + buttonSpacing,
				5 + yOffset, 830, 835, 46, 35, "Activities", interfaces, false);
		interfaceId += 3;
		child += 2;
		buttonSpacing += buttonSpacingIncrease;

		// Activity button icon
		RSInterface.addSpriteComplete(interfaceId, child, 828, 107 + xOffset, 12 + yOffset,
				interfaces, false);
		interfaceId++;
		child++;

		// Quest button
		RSInterface.addHoverButtonComplete(interfaceId, child, 4 + xOffset + buttonSpacing,
				5 + yOffset, 830, 835, 46, 35, "Quest", interfaces, false);
		interfaceId += 3;
		child += 2;

		// Quest button icon
		RSInterface.addSpriteComplete(interfaceId, child, 87, 152 + xOffset, 12 + yOffset, interfaces,
				false);
		interfaceId++;
		child++;

		// Start of duplicate interface changes.
		interfaceId += 110;

		// Scroll content
		RSInterface scrollTab1 = RSInterface.addInterface(interfaceId);
		interfaces.child(child, interfaceId, 11, 74); // Scroll interface.
		interfaceId++;
		child++;

		String[] buttonNames =
		{"Achievements", "Titles", "Profile", "Npc drops", "Presets", "Pets", "Guide"};
		int[][] iconData = {
				// @formatter:off
				{
						// Achievements
						838, // Runecessor.Sprite id
						12, 6 // Icon location
				}, {
						// Titles
						843, 12, 6 },
				{
						// Profile
						840, 13, 9 },
				{
						// Npc drops
						841, 11, 5 },
				{
						// Presets
						842, 14, 9 },
				{
						// Pets
						839, 10, 7 },
				{
						// Guide
						844, 12, 6 }, };
		// @formatter:on
		int scrollChildren = buttonNames.length;
		scrollTab1.totalChildren(scrollChildren * 4);
		int y = 1;
		int panelYIncrease = 28;
		int scrollChild = 0;
		for (int index = 0; index < scrollChildren; index++) {
			// First panel button
			RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 836, 837,
					167, 29, "Open");
			scrollTab1.child(scrollChild, interfaceId, 0, y);
			scrollChild++;
			scrollTab1.child(scrollChild, interfaceId + 1, 0, y);
			scrollChild++;
			interfaceId += 3;

			// First panel icon
			RSInterface.addSprite(interfaceId, iconData[index][0]);
			scrollTab1.child(scrollChild, interfaceId, iconData[index][1], y + iconData[index][2]);
			scrollChild++;
			interfaceId++;

			// First panel text
			RSInterface.addText(interfaceId, buttonNames[index], textDrawingAreas, 2,
					ClientConstants.ORANGE, true);
			scrollTab1.child(scrollChild, interfaceId, 92, y + 7);
			scrollChild++;
			interfaceId++;

			y += panelYIncrease;
		}
		scrollTab1.width = 151;
		scrollTab1.height = 173;
		scrollTab1.scrollMax = (scrollChildren * panelYIncrease) + 2;

	}

	private static void questTabActivitiesTabEco(TextDrawingArea[] textDrawingAreas) {
		int interfaceId = 22980;
		int child = 0;
		RSInterface interfaces = RSInterface.addInterface(23180, 0, 524, 0, 520); // Must
		// change
		// id
		// to
		// a
		// different
		// one
		// for
		// duplicate
		// interfaces
		interfaceId++;
		RSInterface.setChildren(24, interfaces);
		int xOffset = 0;
		int yOffset = 1;

		// Background
		RSInterface.addSpriteComplete(interfaceId, child, 831, 4 + xOffset, 39 + yOffset, interfaces,
				false);
		interfaceId++;
		child++;

		// Mini background
		RSInterface.addSpriteComplete(interfaceId, child, 833, 11 + xOffset, 74 + yOffset, interfaces,
				false);
		interfaceId++;
		child++;

		// Information text background
		RSInterface.addSpriteComplete(interfaceId, child, 832, 11 + xOffset, 46 + yOffset, interfaces,
				false);
		interfaceId++;
		child++;

		// Information text
		RSInterface.addText(interfaceId, "Information", textDrawingAreas, 2, ClientConstants.ORANGE,
				true);
		RSInterface.setBounds(interfaceId, 95 + xOffset, 49 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		int buttonSpacing = 0;
		int buttonSpacingIncrease = 45;
		// Information button
		RSInterface.addHoverButtonComplete(interfaceId, child, 4 + xOffset, 5 + yOffset, 830, 835, 46,
				35, "Information", interfaces, false);
		interfaceId += 3;
		child += 2;
		buttonSpacing += buttonSpacingIncrease;

		// Information button icon
		RSInterface.addSpriteComplete(interfaceId, child, 829, 16 + xOffset, 13 + yOffset, interfaces,
				false);
		interfaceId++;
		child++;

		// Panel button
		RSInterface.addHoverButtonComplete(interfaceId, child, 4 + xOffset + buttonSpacing,
				5 + yOffset, 830, 835, 46, 35, "Panel", interfaces, false);
		interfaceId += 3;
		child += 2;
		buttonSpacing += buttonSpacingIncrease;

		// Panel button icon
		RSInterface.addSpriteComplete(interfaceId, child, 827, 63 + xOffset, 13 + yOffset, interfaces,
				false);
		interfaceId++;
		child++;

		// Activity button
		RSInterface.addHoverButtonComplete(interfaceId, child, 4 + xOffset + buttonSpacing,
				5 + yOffset, 830, 835, 46, 35, "Activities", interfaces, false);
		interfaceId += 3;
		child += 2;
		buttonSpacing += buttonSpacingIncrease;

		// Activity button icon
		RSInterface.addSpriteComplete(interfaceId, child, 828, 107 + xOffset, 12 + yOffset,
				interfaces, false);
		interfaceId++;
		child++;

		// Quest button
		RSInterface.addHoverButtonComplete(interfaceId, child, 4 + xOffset + buttonSpacing,
				5 + yOffset, 830, 835, 46, 35, "Quest", interfaces, false);
		interfaceId += 3;
		child += 2;

		// Quest button icon
		RSInterface.addSpriteComplete(interfaceId, child, 87, 152 + xOffset, 12 + yOffset, interfaces,
				false);
		interfaceId++;
		child++;

		// Start of duplicate interface changes.
		interfaceId += 201;

		// Mini background different
		RSInterface.addSpriteComplete(interfaceId, child, 848, 11 + xOffset, 74 + yOffset, interfaces,
				true);
		interfaceId++;
		child++;

		// Call players button
		RSInterface.addHoverButtonComplete(interfaceId, child, 10 + xOffset, 74 + yOffset, 850, 847,
				84, 26, "Quest", interfaces, true);
		interfaceId += 3;
		child += 2;

		// Call players text
		RSInterface.addText(interfaceId, "Call players", textDrawingAreas, 1, ClientConstants.ORANGE,
				true);
		RSInterface.setBounds(interfaceId, 51 + xOffset, 79 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		// World events
		RSInterface.addHoverButtonComplete(interfaceId, child, 94 + xOffset, 74 + yOffset, 850, 847,
				84, 26, "Quest", interfaces, true);
		interfaceId += 3;
		child += 2;

		// World event text
		RSInterface.addText(interfaceId, "World event", textDrawingAreas, 1, ClientConstants.ORANGE,
				true);
		RSInterface.setBounds(interfaceId, 134 + xOffset, 79 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		// Scroll content
		RSInterface scrollTab1 = RSInterface.addInterface(interfaceId);
		interfaces.child(child, interfaceId, 11, 101); // Scroll interface.
		interfaceId++;
		child++;

		int scrollChildren = 30;
		scrollTab1.totalChildren(scrollChildren * 2);
		int y = 0;
		int scrollChild = 0;
		String[] activitiesTitle = {"World event", "Activities"};
		int[] activitiesTitleIndex = {0, 3};
		int panelYIncrease = 16;
		for (int index = 0; index < scrollChildren; index++) {
			panelYIncrease = 14;
			int spriteId = 599;
			int xExtra = 5;
			String text = "";
			boolean hover = true;
			for (int i = 0; i < activitiesTitleIndex.length; i++) {
				if (index == activitiesTitleIndex[i]) {
					text = activitiesTitle[i];
					spriteId = 849;
					xExtra = 0;
					hover = false;
					panelYIncrease = 17;
					break;
				}
				if (index > 0 && index == activitiesTitleIndex[i] - 1) {
					panelYIncrease = 18;
				}
			}
			// Title sprite background
			RSInterface.addSprite(interfaceId, spriteId);
			scrollTab1.child(scrollChild, interfaceId, 2, y + 0);
			scrollChild++;
			interfaceId++;

			// Text
			if (hover) {
				RSInterface.addText(interfaceId, "", textDrawingAreas, 0, 0xffb000, false, true,
						0xffffff, "Teleport", 226);
			} else {
				RSInterface.addText(interfaceId, text, 0xffb000, false, true, -1, textDrawingAreas, 0);
			}
			scrollTab1.child(scrollChild, interfaceId, 4 + xExtra, y + 4);
			scrollChild++;
			interfaceId++;

			y += panelYIncrease;
		}
		scrollTab1.width = 151;
		scrollTab1.height = 146;
		scrollTab1.scrollMax = 185;

	}

	private static void questTabQuestTabEco(TextDrawingArea[] textDrawingAreas) {
		int interfaceId = 22980;
		int child = 0;
		RSInterface interfaces = RSInterface.addInterface(23181, 0, 524, 0, 520); // Must
		// change
		// id
		// to
		// a
		// different
		// one
		// for
		// duplicate
		// interfaces
		interfaceId++;
		RSInterface.setChildren(19, interfaces);
		int xOffset = 0;
		int yOffset = 1;

		// Background
		RSInterface.addSpriteComplete(interfaceId, child, 831, 4 + xOffset, 39 + yOffset, interfaces,
				false);
		interfaceId++;
		child++;

		// Mini background
		RSInterface.addSpriteComplete(interfaceId, child, 833, 11 + xOffset, 74 + yOffset, interfaces,
				false);
		interfaceId++;
		child++;

		// Information text background
		RSInterface.addSpriteComplete(interfaceId, child, 832, 11 + xOffset, 46 + yOffset, interfaces,
				false);
		interfaceId++;
		child++;

		// Information text
		RSInterface.addText(interfaceId, "Information", textDrawingAreas, 2, ClientConstants.ORANGE,
				true);
		RSInterface.setBounds(interfaceId, 95 + xOffset, 49 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		int buttonSpacing = 0;
		int buttonSpacingIncrease = 45;
		// Information button
		RSInterface.addHoverButtonComplete(interfaceId, child, 4 + xOffset, 5 + yOffset, 830, 835, 46,
				35, "Information", interfaces, false);
		interfaceId += 3;
		child += 2;
		buttonSpacing += buttonSpacingIncrease;

		// Information button icon
		RSInterface.addSpriteComplete(interfaceId, child, 829, 16 + xOffset, 13 + yOffset, interfaces,
				false);
		interfaceId++;
		child++;

		// Panel button
		RSInterface.addHoverButtonComplete(interfaceId, child, 4 + xOffset + buttonSpacing,
				5 + yOffset, 830, 835, 46, 35, "Panel", interfaces, false);
		interfaceId += 3;
		child += 2;
		buttonSpacing += buttonSpacingIncrease;

		// Panel button icon
		RSInterface.addSpriteComplete(interfaceId, child, 827, 63 + xOffset, 13 + yOffset, interfaces,
				false);
		interfaceId++;
		child++;

		// Activity button
		RSInterface.addHoverButtonComplete(interfaceId, child, 4 + xOffset + buttonSpacing,
				5 + yOffset, 830, 835, 46, 35, "Activities", interfaces, false);
		interfaceId += 3;
		child += 2;
		buttonSpacing += buttonSpacingIncrease;

		// Activity button icon
		RSInterface.addSpriteComplete(interfaceId, child, 828, 107 + xOffset, 12 + yOffset,
				interfaces, false);
		interfaceId++;
		child++;

		// Quest button
		RSInterface.addHoverButtonComplete(interfaceId, child, 4 + xOffset + buttonSpacing,
				5 + yOffset, 830, 835, 46, 35, "Quest", interfaces, false);
		interfaceId += 3;
		child += 2;

		// Quest button icon
		RSInterface.addSpriteComplete(interfaceId, child, 87, 152 + xOffset, 12 + yOffset, interfaces,
				false);
		interfaceId++;
		child++;

		// Start of duplicate interface changes.
		interfaceId += 301;

		// Quest points background
		RSInterface.addSpriteComplete(interfaceId, child, 948, 11 + xOffset, 228 + yOffset,
				interfaces, true);
		interfaceId++;
		child++;

		// Quest points text
		RSInterface.addText(interfaceId, "Quest points: 0", textDrawingAreas, 1,
				ClientConstants.ORANGE, true);
		RSInterface.setBounds(interfaceId, 95 + xOffset, 230 + yOffset, child, interfaces);
		interfaceId++;
		child++;

		// Scroll content
		RSInterface scrollTab1 = RSInterface.addInterface(interfaceId);
		interfaces.child(child, interfaceId, 14, 76); // Scroll interface.
		interfaceId++;
		child++;
		int scrollChildren = 35;
		scrollTab1.totalChildren(scrollChildren);
		int y = 5;
		for (int index = 0; index < scrollChildren; index++) {
			RSInterface.addText(interfaceId, "", textDrawingAreas, 0, 0xffb000, false, true, 0xffffff,
					"Quick chat", 226);
			scrollTab1.child(index, interfaceId, 0, y);
			interfaceId++;
			y += 13;
		}
		scrollTab1.width = 148;
		scrollTab1.height = 150;
		scrollTab1.scrollMax = 151;
	}

	public static void questTabPvpInformation(TextDrawingArea[] tda) {
		RSInterface tab = RSInterface.addTabInterface(19500);
		RSInterface.addSprite(28024, 287);
		RSInterface.addHoverButton(28000, 288, 85, 20, "View", -1, 28001, 1);
		RSInterface.addHoveredButton(28001, 289, 85, 20, 28002);
		RSInterface.addText(28003, "Achievements", tda, 1, 0xffb000, false, true);
		RSInterface.addHoverButton(28004, 288, 85, 20, "View", -1, 28005, 1);
		RSInterface.addHoveredButton(28005, 289, 85, 20, 28006);
		RSInterface.addText(28007, "Profile", tda, 1, 0xffb000, true, true);
		RSInterface.addHoverButton(28008, 288, 85, 20, "View", -1, 28009, 1);
		RSInterface.addHoveredButton(28009, 289, 85, 20, 28010);
		if (Config.PVP) {
			RSInterface.addText(28011, "Quick setup", tda, 1, 0xffb000, true, true);
		}
		if (Config.ECO) {
			RSInterface.addText(28011, "Quests", tda, 1, 0xffb000, true, true);
		}
		RSInterface.addHoverButton(28012, 288, 85, 20, "View", -1, 28013, 1);
		RSInterface.addHoveredButton(28013, 289, 85, 20, 28014);
		RSInterface.addText(28015, "Guide", tda, 1, 0xffb000, true, true);
		tab.totalChildren(1);
	/*	tab.child(0, 28024, 2, 10); // Statistics background.
		tab.child(1, 28000, 5, 209); // Achievements button.
		tab.child(2, 28001, 5, 209); // Achievements button hover.
		tab.child(3, 28003, 8, 211); // Achievements text.
		tab.child(4, 28004, 98, 209); // Achievements button.
		tab.child(5, 28005, 98, 209); // Achievements button hover.
		tab.child(6, 28007, 140, 211); // Achievements text.
		tab.child(7, 28008, 5, 237); // Achievements button.
		tab.child(8, 28009, 5, 237); // Achievements button hover.
		tab.child(9, 28011, 49, 239); // Achievements text.
		tab.child(10, 28012, 98, 237); // Achievements button.
		tab.child(11, 28013, 98, 237); // Achievements button hover.
		tab.child(12, 28015, 140, 239); // Achievements text.*/

		RSInterface scrollTab1 = RSInterface.addInterface(28025);
		tab.child(0, 28025, 8, 9); // Scroll interface.

		int scrollChildren = 50;
		scrollTab1.totalChildren(scrollChildren);
		int y = 4;
		for (int index = 0; index < scrollChildren; index++) {

			if (index == 0 || index == 9) {
				RSInterface.addText(28026 + index, "", tda, 0, 0xffb000, false, true);
			} else {
				if (index >= 5) {
					RSInterface.addText(28026 + index, "", tda, 0, 0xffb000, false, true);
				} else {
					RSInterface.addText(28026 + index, "", tda, 0, 0xffb000, false, true, 0xffffff,
							"", 226);
				}
			}
			scrollTab1.child(index, 28026 + index, 0, y);
			y += 13;
		}

		scrollTab1.width = 159;
		scrollTab1.height = 235;
		scrollTab1.scrollMax = 380;

	}

	public static void modernSpellBook(TextDrawingArea[] tda) {
		RSInterface tab = RSInterface.addTabInterface(1151);
		RSInterface homeHover = RSInterface.addTabInterface(1196);
		RSInterface spellButtons = RSInterface.interfaceCache[12424];

		spellButtons.scrollMax = 0;
		spellButtons.height = 260;
		spellButtons.width = 190;
		int[] spellButton = {1196, 1199, 1206, 1215, 1224, 1231, 1240, 1249, 1258, 1267, 1274, 1283,
				1573, 1290, 1299, 1308, 1315, 1324, 1333, 1340, 1349, 1358, 1367, 1374, 1381, 1388,
				1397, 1404, 1583, 12038, 1414, 1421, 1430, 1437, 1446, 1453, 1460, 1469, 15878, 1602,
				1613, 1624, 7456, 1478, 1485, 1494, 1503, 1512, 1521, 1530, 1544, 1553, 1563, 1593,
				1635, 12426, 12436, 12446, 12456, 6004, 18471};
		tab.totalChildren(63);
		tab.child(0, 12424, 13, 24);
		tab.child(1, 1195, 13, 24);
		for (int i1 = 0; i1 < spellButton.length; i1++) {
			int yPos = i1 > 34 ? 8 : 183;
			tab.child(i1 + 2, spellButton[i1], 5, yPos);
			RSInterface.addButton(1195, 651, "Cast @gre@Home Teleport");
			RSInterface homeButton = RSInterface.interfaceCache[1195];
			homeButton.isMouseoverTriggered = 1196;
		}
		for (int i2 = 0; i2 < spellButton.length; i2++) {
			if (i2 < 60) {
				spellButtons.childX[i2] = spellButtons.childX[i2] + 24;
			}
			if (i2 == 6 || i2 == 12 || i2 == 19 || i2 == 35 || i2 == 41 || i2 == 44 || i2 == 49
					|| i2 == 51) {
				spellButtons.childX[i2] = 0;
			}
			spellButtons.childY[6] = 24;
			spellButtons.childY[12] = 48;
			spellButtons.childY[19] = 72;
			spellButtons.childY[49] = 96;
			spellButtons.childY[44] = 120;
			spellButtons.childY[35] = 170;

			spellButtons.childY[21] = 67; // Superheat item.
			spellButtons.childY[41] = 195; // Charge.
			spellButtons.childY[51] = 147; // Trollheim teleport.
			spellButtons.childY[53] = 172; // Teleother lumbridge.
			spellButtons.childX[53] = 74; // Teleother lumbridge.
			spellButtons.childY[54] = 195; // Teleother falador.
			spellButtons.childY[55] = 195; // Teleblock.
			spellButtons.childX[55] = 50; // Teleblock.
			spellButtons.childY[56] = 194; // Teleother camelot.
			spellButtons.childX[56] = 97; // Teleother camelot.
			spellButtons.childY[57] = 194; // Lvl-6 enchant.
			spellButtons.childX[57] = 74; // Lvl-6 enchant.
			spellButtons.childX[46] = 46; // Enfeeble.
			spellButtons.childY[46] = 168; // Enfeeble.
			spellButtons.childX[35] = -2; // Lvl-5 enchant.
			spellButtons.childX[36] = 22; // Earth wave.
			spellButtons.childY[36] = 167; // Earth wave.
			spellButtons.childX[31] = 23; // Wind wave.
			spellButtons.childY[31] = 143; // Wind wave.
			spellButtons.childX[43] = 49; // Test
			spellButtons.childX[30] = 49; // Test
			spellButtons.childX[32] = 49; // Test
			spellButtons.childX[38] = 98; // Test
			spellButtons.childY[38] = 123; // Test
		}
		homeHover.invisible = true;
		RSInterface.addText(1197, Config.serverNames[Config.currentServer] + " Home Teleport", tda, 1, 0xFE981F, true, true);
		RSInterface homeLevel = RSInterface.interfaceCache[1197];
		homeLevel.width = 174;
		homeLevel.height = 68;
		RSInterface.addText(1198, "A teleport which requires no", tda, 0, 0xAF6A1A, true, true);
		RSInterface.addText(18998, "runes and no required level that", tda, 0, 0xAF6A1A, true, true);
		RSInterface.addText(18999, "teleports you to the main land.", tda, 0, 0xAF6A1A, true, true);
		homeHover.totalChildren(4);
		homeHover.child(0, 1197, 3, 4);
		homeHover.child(1, 1198, 91, 23);
		homeHover.child(2, 18998, 91, 34);
		homeHover.child(3, 18999, 91, 45);
	}

	private static int getAncientMagicksTabClickedFilterSprite() {
		return Config.PRE_EOC ? 290 : 1076;
	}

	public static void ancientMagicTab1(TextDrawingArea[] tda) {
		RSInterface tab = RSInterface.addInterface(24800);
		RSInterface.addButton(12856, 651, "Cast @gre@Home Teleport");
		RSInterface homeButton = RSInterface.interfaceCache[12856];
		homeButton.isMouseoverTriggered = 1196;
		int[] itfChildren = {
				// teleport below
				12856, 13035, 13045, 13053, 13061, 13069, 13079, 13087, 13095, 12939, 12987,

				// combat below
				12901, 12861, 12963, 13011, 12919, 12881, 12951, 12999, 12911, 12871, 12975, 13023,
				12929, 12891,

				// hover ids below
				1196, 12940, 12988, 13036, 12902, 12862, 13046, 12964, 13012, 13054, 12920, 12882,
				13062, 12952, 13000, 13070, 12912, 12872, 13080, 12976, 13024, 13088, 12930, 12892,
				13096};
		RSInterface.addSprite(24801, 299);
		RSInterface.addSprite(24802, 300);
		RSInterface.addSprite(24803, 300);
		RSInterface.addSprite(24804, 291);
		RSInterface.addSprite(24805, getAncientMagicksTabClickedFilterSprite());
		RSInterface.addSprite(24806, getAncientMagicksTabClickedFilterSprite());
		RSInterface.addSprite(24807, getAncientMagicksTabClickedFilterSprite());
		RSInterface.addSprite(24808, 296);
		RSInterface.addSprite(24809, 297);
		RSInterface.addSprite(24810, 298);
		RSInterface.addSprite(24811, 295);
		RSInterface.addHoverButton(24812, 301, 18, 18, "Toggle", -1, 24813, 1);
		RSInterface.addHoveredButton(24813, 302, 18, 18, 24814);
		RSInterface.addHoverButton(24815, 305, 18, 18, "Toggle", -1, 24816, 1);
		RSInterface.addHoveredButton(24816, 306, 18, 18, 24817);
		tab.totalChildren(itfChildren.length + 15);
		for (int i1 = 0, xPos = 20, yPos = 11; i1 < itfChildren.length; i1++, xPos += 44) // x
		// 60/18
		// is
		// original,
		// 18/8
		// y
		// is
		// original,
		// 45
		// is
		// original
		// of
		// x.
		{
			if (xPos > 175) {
				xPos = 19;
				yPos += 28;
			}
			if (i1 < 25) {
				tab.child(i1, itfChildren[i1], xPos, yPos);
			}
			if (i1 > 24) {
				yPos = i1 < 41 ? 181 : 1;
				if (yPos > 150) {
					yPos = 150;
				}
				tab.child(i1, itfChildren[i1], 4, yPos);
			}
		}
		tab.child(itfChildren.length, 24801, 500, 228);
		tab.child(itfChildren.length + 1, 24802, 500, 230);
		tab.child(itfChildren.length + 2, 24803, 500, 230);
		tab.child(itfChildren.length + 3, 24804, 500, 237);
		tab.child(itfChildren.length + 4, 24805, 500, 236);
		tab.child(itfChildren.length + 5, 24806, 500, 236);
		tab.child(itfChildren.length + 6, 24807, 164, 237);
		tab.child(itfChildren.length + 7, 24808, 500, 240);
		tab.child(itfChildren.length + 8, 24809, 500, 239);
		tab.child(itfChildren.length + 9, 24810, 500, 240);
		tab.child(itfChildren.length + 10, 24811, 167, 240);
		tab.child(itfChildren.length + 11, 24812, 124, 237);
		tab.child(itfChildren.length + 12, 24813, 124, 237);
		tab.child(itfChildren.length + 13, 24815, 144, 237);
		tab.child(itfChildren.length + 14, 24816, 144, 237);
	}

	public static void ancientMagicTab2(TextDrawingArea[] tda) {
		RSInterface tab = RSInterface.addInterface(24818);
		RSInterface.addButton(12856, 651, "Cast @gre@Home Teleport");
		RSInterface homeButton = RSInterface.interfaceCache[12856];
		homeButton.isMouseoverTriggered = 1196;
		int[] itfChildren = {
				// combat below
				12939, 12987, 12901, 12861, 12963, 13011, 12919, 12881, 12951, 12999, 12911, 12871,
				12975, 13023, 12929, 12891,

				// teleport below
				12856, 13035, 13045, 13053, 13061, 13069, 13079, 13087, 13095,

				// hover ids below
				1196, 12940, 12988, 13036, 12902, 12862, 13046, 12964, 13012, 13054, 12920, 12882,
				13062, 12952, 13000, 13070, 12912, 12872, 13080, 12976, 13024, 13088, 12930, 12892,
				13096};
		RSInterface.addSprite(24819, 299);
		RSInterface.addSprite(24820, 300);
		RSInterface.addSprite(24821, 300);
		RSInterface.addSprite(24822, 291);
		RSInterface.addSprite(24823, getAncientMagicksTabClickedFilterSprite());
		RSInterface.addSprite(24824, getAncientMagicksTabClickedFilterSprite());
		RSInterface.addSprite(24825, getAncientMagicksTabClickedFilterSprite());
		RSInterface.addSprite(24826, 296);
		RSInterface.addSprite(24827, 297);
		RSInterface.addSprite(24828, 298);
		RSInterface.addSprite(24829, 294);
		RSInterface.addHoverButton(24830, 303, 18, 18, "Toggle", -1, 24831, 1);
		RSInterface.addHoveredButton(24831, 304, 18, 18, 24832);
		RSInterface.addHoverButton(24833, 301, 18, 18, "Toggle", -1, 24834, 1);
		RSInterface.addHoveredButton(24834, 302, 18, 18, 24835);
		tab.totalChildren(itfChildren.length + 15);
		for (int i1 = 0, xPos = 20, yPos = 11; i1 < itfChildren.length; i1++, xPos += 44) // x
		// 60/18
		// is
		// original,
		// 18/8
		// y
		// is
		// original,
		// 45
		// is
		// original
		// of
		// x.
		{
			if (xPos > 175) {
				xPos = 19;
				yPos += 28;
			}
			if (i1 < 25) {
				tab.child(i1, itfChildren[i1], xPos, yPos);
			}
			if (i1 > 24) {
				yPos = i1 < 41 ? 181 : 1;
				if (yPos > 150) {
					yPos = 150;
				}
				tab.child(i1, itfChildren[i1], 4, yPos);
			}
		}
		tab.child(itfChildren.length, 24819, 500, 228);
		tab.child(itfChildren.length + 1, 24820, 500, 230);
		tab.child(itfChildren.length + 2, 24821, 500, 230);
		tab.child(itfChildren.length + 3, 24822, 500, 237);
		tab.child(itfChildren.length + 4, 24823, 500, 236);
		tab.child(itfChildren.length + 5, 24824, 500, 236);
		tab.child(itfChildren.length + 6, 24825, 144, 237);
		tab.child(itfChildren.length + 7, 24826, 500, 240);
		tab.child(itfChildren.length + 8, 24827, 500, 239);
		tab.child(itfChildren.length + 9, 24828, 500, 240);
		tab.child(itfChildren.length + 10, 24829, 148, 242);
		tab.child(itfChildren.length + 11, 24830, 164, 237);
		tab.child(itfChildren.length + 12, 24831, 164, 237);
		tab.child(itfChildren.length + 13, 24833, 124, 237);
		tab.child(itfChildren.length + 14, 24834, 124, 237);
	}

	public static void TournamentInfo(TextDrawingArea[] tda) {
		RSInterface tab = RSInterface.addInterface(24950);
		RSInterface.addSprite(26200, 760);
		RSInterface.addText(26201,
				"" + ClientConstants.getServerName() + " Tournaments - Information Panel", tda, 2,
				0xff9933, true, true);
		RSInterface.addHoverButton(26202, 761, 16, 16, "Close", -1, 26203, 1);
		RSInterface.addHoveredButton(26203, 762, 16, 16, 26204);
		RSInterface.addHoverButton(26205, 763, 30, 23, "Next", -1, 26206, 1);
		RSInterface.addHoveredButton(26206, 764, 30, 23, 26207);
		RSInterface.addHoverButton(26208, 767, 140, 30, "Enter Tournament", -1, 26209, 1);
		RSInterface.addHoveredButton(26209, 767, 140, 30, 26210);
		RSInterface.addSprite(26211, 768);
		RSInterface.addText(26212,
				"" + ClientConstants.getServerName()
						+ "'s tournaments are fun and highly competitive.\\n"
						+ "Do you think you have what it takes to come out on top?\\n" + "\\n",
				tda, 1, 0xff9933, true, true);
		RSInterface.addText(26213, "Enter Tournament", tda, 1, 0xFFFFFF, true, true);
		RSInterface.addSprite(26214, 769);
		RSInterface.addText(26215,
				"Upon entering, you will be moved to an instanced map of Clan Wars.\\n"
						+ "This is the lobby or waiting area.\\n",
				tda, 1, 0xff9933, true, true);
		RSInterface.addText(26216, "Next", tda, 2, 0xff9933, true, true);

		tab.totalChildren(15);
		tab.child(0, 26200, 5, 5);
		tab.child(1, 26201, 258, 14);
		tab.child(2, 26202, 480, 14);
		tab.child(3, 26203, 480, 14);
		tab.child(4, 26208, 188, 265);
		tab.child(5, 26209, 188, 265);
		tab.child(6, 26211, 155, 262);
		tab.child(7, 26211, 334, 262);
		tab.child(8, 26212, 258, 45);
		tab.child(9, 26213, 260, 273);
		tab.child(10, 26214, 110, 80);
		tab.child(11, 26215, 258, 230);
		tab.child(12, 26216, 477, 175);
		tab.child(13, 26205, 465, 150);
		tab.child(14, 26206, 465, 150);
	}

	public static void TournamentInfo1(TextDrawingArea[] tda) {
		RSInterface tab = RSInterface.addTabInterface(24951);
		RSInterface.addHoverButton(26255, 765, 43, 29, "Previous", -1, 26256, 1);
		RSInterface.addHoveredButton(26256, 766, 43, 29, 26257);
		RSInterface.addHoverButton(26258, 763, 30, 23, "Next", -1, 26259, 1);
		RSInterface.addHoveredButton(26259, 764, 30, 23, 26260);
		RSInterface.addText(26261,
				"Once in the lobby, you will receive a gear setup.\\n"
						+ "There is a supplies/items chest and a box of health.\\n" + "\\n",
				tda, 1, 0xff9933, true, true);
		RSInterface.addSprite(26262, 770);
		RSInterface.addSprite(26263, 771);
		RSInterface.addText(26264, "Different items will be available depending on the tournament.\\n"
				+ "Participants can re-stock between rounds.\\n", tda, 1, 0xff9933, true, true);
		RSInterface.addText(26265, "Back", tda, 2, 0xff9933, true, true);

		tab.totalChildren(19);
		tab.child(0, 26200, 5, 5);
		tab.child(1, 26265, 30, 175);
		tab.child(2, 26201, 258, 14);
		tab.child(3, 26202, 480, 14);
		tab.child(4, 26203, 480, 14);
		tab.child(5, 26208, 188, 265);
		tab.child(6, 26209, 188, 265);
		tab.child(7, 26211, 155, 262);
		tab.child(8, 26211, 334, 262);
		tab.child(9, 26261, 258, 45);
		tab.child(10, 26213, 260, 273);
		tab.child(11, 26263, 210, 75);
		tab.child(12, 26262, 55, 88);
		tab.child(13, 26264, 258, 230);
		tab.child(14, 26216, 477, 175);
		tab.child(15, 26255, 16, 150);
		tab.child(16, 26256, 16, 150);
		tab.child(17, 26258, 465, 150);
		tab.child(18, 26259, 465, 150);
	}

	public static void TournamentInfo2(TextDrawingArea[] tda) {
		RSInterface tab = RSInterface.addTabInterface(24952);
		RSInterface.addHoverButton(26280, 765, 43, 29, "Previous", -1, 26281, 1);
		RSInterface.addHoveredButton(26281, 766, 43, 29, 26282);
		RSInterface.addHoverButton(26283, 763, 30, 23, "Next", -1, 26284, 1);
		RSInterface.addHoveredButton(26284, 764, 30, 23, 26285);
		RSInterface.addText(26286,
				"Each player that is still in the tournament will have a golden skull.\\n"
						+ "Your opponent will have a big yellow arrow over them.\\n" + "\\n",
				tda, 1, 0xff9933, true, true);
		RSInterface.addSprite(26287, 772);
		RSInterface.addSprite(26288, 773);
		RSInterface.addText(26289, "If there is an odd number of participants, one player will\\n"
				+ "sit out until the next round.\\n" + "\\n", tda, 1, 0xff9933, true, true);

		tab.totalChildren(19);
		tab.child(0, 26200, 5, 5);
		tab.child(1, 26265, 30, 175);
		tab.child(2, 26201, 258, 14);
		tab.child(3, 26202, 480, 14);
		tab.child(4, 26203, 480, 14);
		tab.child(5, 26208, 188, 265);
		tab.child(6, 26209, 188, 265);
		tab.child(7, 26211, 155, 262);
		tab.child(8, 26211, 334, 262);
		tab.child(9, 26286, 258, 45);
		tab.child(10, 26213, 260, 273);
		tab.child(11, 26288, 275, 110);
		tab.child(12, 26287, 60, 83);
		tab.child(13, 26289, 258, 230);
		tab.child(14, 26216, 477, 175);
		tab.child(15, 26280, 16, 150);
		tab.child(16, 26281, 16, 150);
		tab.child(17, 26283, 465, 150);
		tab.child(18, 26284, 465, 150);
	}

	public static void TournamentInfo3(TextDrawingArea[] tda) {
		RSInterface tab = RSInterface.addTabInterface(24953);
		RSInterface.addHoverButton(26350, 765, 43, 29, "Previous", -1, 26351, 1);
		RSInterface.addHoveredButton(26351, 766, 43, 29, 26352);
		RSInterface.addHoverButton(26353, 763, 30, 23, "Next", -1, 26354, 1);
		RSInterface.addHoveredButton(26354, 764, 30, 23, 26355);
		RSInterface.addText(26356,
				"Each player that is still in the tournament will have a golden skull.\\n"
						+ "Between each round participants will have 2 minutes to re-gear.\\n" + "\\n",
				tda, 1, 0xff9933, true, true);
		RSInterface.addSprite(26357, 774);
		RSInterface.addText(26358,
				"The winner will receive 1500 Blood money * number of starting participants.\\n"
						+ "Runner-up receives half of winner's prize. \\n"
						+ "Event winnings can be claimed by doing ::claimevent.\\n",
				tda, 1, 0xff9933, true, true);

		tab.totalChildren(15);
		tab.child(0, 26200, 5, 5);
		tab.child(1, 26265, 30, 175);
		tab.child(2, 26201, 258, 14);
		tab.child(3, 26202, 480, 14);
		tab.child(4, 26203, 480, 14);
		tab.child(5, 26208, 188, 265);
		tab.child(6, 26209, 188, 265);
		tab.child(7, 26211, 155, 262);
		tab.child(8, 26211, 334, 262);
		tab.child(9, 26356, 258, 45);
		tab.child(10, 26357, 115, 105);
		tab.child(11, 26358, 258, 215);
		tab.child(12, 26350, 16, 150);
		tab.child(13, 26351, 16, 150);
		tab.child(14, 26213, 260, 273);
	}

	public static void ancientMagicTab(TextDrawingArea[] tda) {
		RSInterface tab = RSInterface.addInterface(24836);
		RSInterface.addButton(12856, 651, "Cast @gre@Home Teleport");
		RSInterface homeButton = RSInterface.interfaceCache[12856];
		homeButton.isMouseoverTriggered = 1196;
		int[] itfChildren = {12856, 12939, 12987, 13035, 12901, 12861, 13045, 12963, 13011, 13053,
				12919, 12881, 13061, 12951, 12999, 13069, 12911, 12871, 13079, 12975, 13023, 13087,
				12929, 12891, 13095, 1196, 12940, 12988, 13036, 12902, 12862, 13046, 12964, 13012,
				13054, 12920, 12882, 13062, 12952, 13000, 13070, 12912, 12872, 13080, 12976, 13024,
				13088, 12930, 12892, 13096};
		RSInterface.addSprite(24837, 299);
		RSInterface.addSprite(24838, 300);
		RSInterface.addSprite(24839, 300);
		RSInterface.addSprite(24840, 291);
		RSInterface.addSprite(24841, getAncientMagicksTabClickedFilterSprite());
		RSInterface.addSprite(24842, getAncientMagicksTabClickedFilterSprite());
		RSInterface.addSprite(24843, getAncientMagicksTabClickedFilterSprite());
		RSInterface.addSprite(24844, 296);
		RSInterface.addSprite(24845, 297);
		RSInterface.addSprite(24846, 298);
		RSInterface.addSprite(24847, 293);
		RSInterface.addHoverButton(24848, 305, 18, 18, "Toggle", -1, 24849, 1);
		RSInterface.addHoveredButton(24849, 306, 18, 18, 24850);
		RSInterface.addHoverButton(24851, 303, 18, 18, "Toggle", -1, 24852, 1);
		RSInterface.addHoveredButton(24852, 304, 18, 18, 24853);
		RSInterface.addSprite(24855, 740);
		tab.totalChildren(itfChildren.length + 15 + 1);
		for (int i1 = 0, xPos = 20, yPos = 10; i1 < itfChildren.length; i1++, xPos += 44) // x
		// 60/18
		// is
		// original,
		// 18/8
		// y
		// is
		// original,
		// 45
		// is
		// original
		// of
		// x.
		{
			if (i1 == 19) {
				xPos += 50;
			}
			if (xPos > 175) {
				xPos = 20;
				yPos += 28;
			}
			int xOffset = 0;
			int yOffset = 0;
			switch (i1) {
				case 1:
					xOffset += 1;
					yOffset += -1;
					break;
				case 2:
					xOffset += 3;
					yOffset -= 1;
					break;
				case 4:
					xOffset -= 1;
					yOffset -= 1;
					break;
				case 5:
					xOffset += 1;
					yOffset -= 1;
					break;
				case 6:
					xOffset += 3;
					break;
				case 7:
					yOffset -= 1;
					break;
				case 8:
					yOffset -= 1;
					break;
				case 9:
					xOffset += 1;
					break;
				case 10:
					xOffset += 2;
					yOffset -= 1;
					break;
				case 11:
					xOffset += 1;
					yOffset -= 1;
					break;
				case 13:
					yOffset += 1;
					xOffset += 1;
					break;
				case 14:
					yOffset += 1;
					xOffset += 4;
					break;
				case 16:
					yOffset += 1;
					break;
				case 17:
					yOffset += 1;
					xOffset += 1;
					break;
				case 18:
					xOffset += 3;
					break;
				case 20:
					xOffset += 2;
					break;
				case 21:
					xOffset += 3;
					break;
				case 22:
				case 24:
					xOffset += 1;
					break;
				case 23:
					xOffset += 1;
					break;
			}
			if (i1 < 25) {
				tab.child(i1, itfChildren[i1], xPos + xOffset, yPos + yOffset);
			}
			if (i1 > 24) {
				yPos = i1 < 41 ? 181 : 1;
				if (yPos > 150) {
					yPos = 150;
				}
				tab.child(i1, itfChildren[i1], 4, yPos);
			}
		}
		tab.child(itfChildren.length, 24837, 500, 228);
		tab.child(itfChildren.length + 1, 24838, 500, 230);
		tab.child(itfChildren.length + 2, 24839, 500, 230);
		tab.child(itfChildren.length + 3, 24840, 500, 237);
		tab.child(itfChildren.length + 4, 24841, 500, 236);
		tab.child(itfChildren.length + 5, 24842, 500, 236);
		tab.child(itfChildren.length + 6, 24843, 124, 237);
		tab.child(itfChildren.length + 7, 24844, 500, 240);
		tab.child(itfChildren.length + 8, 24845, 500, 239);
		tab.child(itfChildren.length + 9, 24846, 500, 240);
		tab.child(itfChildren.length + 10, 24847, 128, 242);
		tab.child(itfChildren.length + 11, 24848, 144, 237);
		tab.child(itfChildren.length + 12, 24849, 144, 237);
		tab.child(itfChildren.length + 13, 24851, 164, 237);
		tab.child(itfChildren.length + 14, 24852, 164, 237);
		tab.child(itfChildren.length + 15, 24855, 152, 122);
	}

	public static void clientSettings1(TextDrawingArea[] tda) {
		RSInterface rsi = RSInterface.addTabInterface(17338);
		RSInterface.addHoverButton(17292, 251, 16, 16, "Next", -1, 17293, 1);
		RSInterface.addHoveredButton(17293, 252, 16, 164, 17294);
		int child1 = 0;
		int base = 17339;
		String[] settingName = {"Names  ", "Smooth char turn     ", "Cursor", "Zoom: @gr3@Normal",
			"Cam speed: @gr3@Slow",
			"New click",
			"HP overlay"};
		int settingsAmount = settingName.length;
		int order1 = 0;
		for (int i = 0; i < settingsAmount; i++) {
			RSInterface.addHoverButton(base + child1, 342, 122, 24,
					"Toggle " + Settings.hoverText[i + 7][0], -1, (base + child1) + 1, 1);
			child1++;
			RSInterface.addHoveredButton(base + child1, 343, 122, 24, (base + child1) + 1);
			child1 += 2;
			RSInterface.addText(base + child1, settingName[order1], tda, 1, 0xffb000, true, true);
			child1++;
			order1++;
		}
		int child = 0;
		int y = 41;
		int order = 11;
		rsi.totalChildren((settingsAmount * 3) + order);
		rsi.child(0, 17301, 0, 44); // Background.
		rsi.child(1, 17302, 90, 6); // Settings text.
		rsi.child(2, 17303, 171, 6); // Close.
		rsi.child(3, 17304, 171, 6); // Close hover.
		rsi.child(4, 17306, 0, 44); // Line.
		rsi.child(5, 17307, 0, 250); // Line.
		rsi.child(6, 17295, 171, 25); // Arrow.
		rsi.child(7, 17296, 171, 25); // Arrow.
		rsi.child(8, 17292, 151, 25); // Arrow.
		rsi.child(9, 17293, 151, 25); // Arrow.
		rsi.child(10, 17298, 124, 28); // Page text.
		for (int i = 0; i < settingsAmount; i++) {
			rsi.child(order, base + child, 34, y + 10); // Hover.
			child++;
			order++;
			rsi.child(order, base + child, 34, y + 10); // Hover.
			order++;
			child++;
			child++;
			rsi.child(order, base + child, 93, y + 15);
			order++;
			child++;
			y += 28;
		}
	}

	public static void clientSettings2(TextDrawingArea[] tda) {
		RSInterface rsi = RSInterface.addTabInterface(17367);
		RSInterface.addText(17291, "@yel@Performance", tda, 2, 0xFFFFFF, true, true);
		int child1 = 0;
		int base = 17368;
		String[] settingName = {"Smooth textures     ", "Smooth shadows     ", "Soft animations    ",
				"Detail: @gr3@High", "HD floor", "Fog: @gr3@Off black", "Roofs     "};
		int settingsAmount = settingName.length;
		int order1 = 0;
		for (int i = 0; i < settingsAmount; i++) {
			RSInterface.addHoverButton(base + child1, 342, 122, 24,
					"Toggle " + Settings.hoverText[i + 14][0], -1, (base + child1) + 1, 1);
			child1++;
			RSInterface.addHoveredButton(base + child1, 343, 122, 24, (base + child1) + 1);
			child1 += 2;
			RSInterface.addText(base + child1, settingName[order1], tda, 1, 0xffb000, true, true);
			child1++;
			order1++;
		}
		int child = 0;
		int y = 41;
		int order = 11;
		rsi.totalChildren((settingsAmount * 3) + order);
		rsi.child(0, 17301, 0, 44); // Background.
		rsi.child(1, 17291, 90, 6); // Settings text.
		rsi.child(2, 17303, 171, 6); // Close.
		rsi.child(3, 17304, 171, 6); // Close hover.
		rsi.child(4, 17306, 0, 44); // Line.
		rsi.child(5, 17307, 0, 250); // Line.
		rsi.child(6, 17295, 171, 25); // Arrow.
		rsi.child(7, 17296, 171, 25); // Arrow.
		rsi.child(8, 17292, 151, 25); // Arrow.
		rsi.child(9, 17293, 151, 25); // Arrow.
		rsi.child(10, 17298, 124, 28); // Page text.
		for (int i = 0; i < settingsAmount; i++) {
			rsi.child(order, base + child, 34, y + 10); // Hover.
			child++;
			order++;
			rsi.child(order, base + child, 34, y + 10); // Hover.
			order++;
			child++;
			child++;
			rsi.child(order, base + child, 93, y + 15);
			order++;
			child++;
			y += 28;
		}
	}

	public static void clientSettings3(TextDrawingArea[] tda) {
		RSInterface rsi = RSInterface.addTabInterface(17299);
		int child1 = 0;
		int base = 17396;
		String[] settingName =
		{"Smooth minimap     ", "Moving water     "};
		int settingsAmount = settingName.length;
		int order1 = 0;
		for (int i = 0; i < settingsAmount; i++) {
			RSInterface.addHoverButton(base + child1, 342, 122, 24,
					"Toggle " + Settings.hoverText[i + 35][0], -1, (base + child1) + 1, 1);
			child1++;
			RSInterface.addHoveredButton(base + child1, 343, 122, 24, (base + child1) + 1);
			child1 += 2;
			RSInterface.addText(base + child1, settingName[order1], tda, 1, 0xffb000, true, true);
			child1++;
			order1++;
		}
		int child = 0;
		int y = 41;
		int order = 9;
		rsi.totalChildren((settingsAmount * 3) + order);
		rsi.child(0, 17301, 0, 44); // Background.
		rsi.child(1, 17291, 90, 6); // Settings text.
		rsi.child(2, 17303, 171, 6); // Close.
		rsi.child(3, 17304, 171, 6); // Close hover.
		rsi.child(4, 17306, 0, 44); // Line.
		rsi.child(5, 17307, 0, 250); // Line.
		rsi.child(6, 17292, 151, 25); // Arrow.
		rsi.child(7, 17293, 151, 25); // Arrow.
		rsi.child(8, 17298, 124, 28); // Page text.
		for (int i = 0; i < settingsAmount; i++) {
			rsi.child(order, base + child, 34, y + 10); // Hover.
			child++;
			order++;
			rsi.child(order, base + child, 34, y + 10); // Hover.
			order++;
			child++;
			child++;
			rsi.child(order, base + child, 93, y + 15);
			order++;
			child++;
			y += 28;
		}
	}

	public static void clientSettings4(TextDrawingArea[] tda) {
		RSInterface rsi = RSInterface.addTabInterface(26010);
		RSInterface.addText(26011, "@yel@Settings", tda, 2, 0xFFFFFF, true, true);
		int child1 = 0;
		int base = 26012;
		String[] settingName = {"Combat: @gr3@F5", "Inventory: @gr3@F1", "Equipment: @gr3@F2",
			"Prayer: @gr3@F3",
			"Magic: @gr3@F4",
			"Screenshot: @gr3@F12",
			"Reset F-keys"};
		int settingsAmount = settingName.length;
		int order1 = 0;
		for (int i = 0; i < settingsAmount; i++) {
			RSInterface.addHoverButton(base + child1, 342, 122, 24,
					"Toggle " + Settings.hoverText[i + 28][0], -1, (base + child1) + 1, 1);
			child1++;
			RSInterface.addHoveredButton(base + child1, 343, 122, 24, (base + child1) + 1);
			child1 += 2;
			RSInterface.addText(base + child1, settingName[order1], tda, 1, 0xffb000, true, true);
			child1++;
			order1++;
		}
		int child = 0;
		int y = 41;
		int order = 11;
		rsi.totalChildren((settingsAmount * 3) + order);
		rsi.child(0, 17301, 0, 44); // Background.
		rsi.child(1, 26011, 90, 6); // Settings text.
		rsi.child(2, 17303, 171, 6); // Close.
		rsi.child(3, 17304, 171, 6); // Close hover.
		rsi.child(4, 17306, 0, 44); // Line.
		rsi.child(5, 17307, 0, 250); // Line.
		rsi.child(6, 17295, 171, 25); // Arrow.
		rsi.child(7, 17296, 171, 25); // Arrow.
		rsi.child(8, 17292, 151, 25); // Arrow.
		rsi.child(9, 17293, 151, 25); // Arrow.
		rsi.child(10, 17298, 124, 28); // Page text.
		for (int i = 0; i < settingsAmount; i++) {
			rsi.child(order, base + child, 34, y + 10); // Hover.
			child++;
			order++;
			rsi.child(order, base + child, 34, y + 10); // Hover.
			order++;
			child++;
			child++;
			rsi.child(order, base + child, 93, y + 15);
			order++;
			child++;
			y += 28;
		}
	}

	public static void clientSettings5(TextDrawingArea[] tda) {
		RSInterface rsi = RSInterface.addTabInterface(26060);
		RSInterface.addText(26011, "@yel@Settings", tda, 2, 0xFFFFFF, true, true);
		int child1 = 0;
		int base = 26061;
		String[] settingName =
		{"New font", "Mouse zoom", "Overlay timers", "Item overlay",
				"New prayer swap    ", "Shift to drop     ", "KDR overlay"};
		int settingsAmount = settingName.length;
		int order1 = 0;
		for (int i = 0; i < settingsAmount; i++) {
			RSInterface.addHoverButton(base + child1, 342, 122, 24,
					"Toggle " + Settings.hoverText[i + 21][0], -1, (base + child1) + 1, 1);
			child1++;
			RSInterface.addHoveredButton(base + child1, 343, 122, 24, (base + child1) + 1);
			child1 += 2;
			RSInterface.addText(base + child1, settingName[order1], tda, 1, 0xffb000, true, true);
			child1++;
			order1++;
		}
		int child = 0;
		int y = 41;
		int order = 11;
		rsi.totalChildren((settingsAmount * 3) + order);
		rsi.child(0, 17301, 0, 44); // Background.
		rsi.child(1, 26011, 90, 6); // Settings text.
		rsi.child(2, 17303, 171, 6); // Close.
		rsi.child(3, 17304, 171, 6); // Close hover.
		rsi.child(4, 17306, 0, 44); // Line.
		rsi.child(5, 17307, 0, 250); // Line.
		rsi.child(6, 17295, 171, 25); // Arrow.
		rsi.child(7, 17296, 171, 25); // Arrow.
		rsi.child(8, 17292, 151, 25); // Arrow.
		rsi.child(9, 17293, 151, 25); // Arrow.
		rsi.child(10, 17298, 124, 28); // Page text.
		for (int i = 0; i < settingsAmount; i++) {
			rsi.child(order, base + child, 34, y + 10); // Hover.
			child++;
			order++;
			rsi.child(order, base + child, 34, y + 10); // Hover.
			order++;
			child++;
			child++;
			rsi.child(order, base + child, 93, y + 15);
			order++;
			child++;
			y += 28;
		}
	}

	public static void itemsOnDeath(TextDrawingArea[] tda) {
		RSInterface rsinterface = RSInterface.addInterface(17100, 12, 507, 12, 328);
		RSInterface.addSprite(17101, 310);
		RSInterface.addHover(17102, 3, 0, 10601, 148, 17, 17, "Close Window");
		RSInterface.addHovered(10601, 149, 17, 17, 10602);
		RSInterface.addText(17103, "Items Kept On Death", 0xff981f, false, true, 0, tda, 2);
		RSInterface.addText(17104, "Items you will keep on death (if not skulled):", 0xff981f, false,
				true, 0, tda, 2);
		RSInterface.addText(17105, "Items you will lose on death (if not skulled):", 0xff981f, false,
				true, 0, tda, 2);
		RSInterface.addText(17106, "Information", 0xff981f, false, true, 0, tda, 1);
		RSInterface.addText(17107, "Max items kept on death:", 0xff981f, false, true, 0, tda, 1);
		RSInterface.addText(17108, "~ 3 ~", 0xffcc33, false, true, 0, tda, 1);
		RSInterface.addText(17131, "Carried wealth:", ClientConstants.ORANGE, false, true, 0, tda, 0);
		RSInterface.addText(17132, "", ClientConstants.ORANGE, false, true, 0, tda, 0);
		RSInterface.addText(17133, "Risked wealth:", ClientConstants.ORANGE, false, true, 0, tda, 0);
		RSInterface.addText(17134, "", ClientConstants.ORANGE, false, true, 0, tda, 0);
		rsinterface.scrollMax = 0;
		rsinterface.invisible = false;
		rsinterface.children = new int[16];
		rsinterface.childX = new int[16];
		rsinterface.childY = new int[16];

		rsinterface.children[0] = 17101;
		rsinterface.childX[0] = 7;
		rsinterface.childY[0] = 8;
		rsinterface.children[1] = 17102;
		rsinterface.childX[1] = 480;
		rsinterface.childY[1] = 17;
		rsinterface.children[2] = 17103;
		rsinterface.childX[2] = 185;
		rsinterface.childY[2] = 18;
		rsinterface.children[3] = 17104;
		rsinterface.childX[3] = 22;
		rsinterface.childY[3] = 50;
		rsinterface.children[4] = 17105;
		rsinterface.childX[4] = 22;
		rsinterface.childY[4] = 110;
		rsinterface.children[5] = 17106;
		rsinterface.childX[5] = 347;
		rsinterface.childY[5] = 47;
		rsinterface.children[6] = 17107;
		rsinterface.childX[6] = 349;
		rsinterface.childY[6] = 270;
		rsinterface.children[7] = 17108;
		rsinterface.childX[7] = 398;
		rsinterface.childY[7] = 298;
		rsinterface.children[8] = 17115;
		rsinterface.childX[8] = 348;
		rsinterface.childY[8] = 64;
		rsinterface.children[9] = 10494;
		rsinterface.childX[9] = 26;
		rsinterface.childY[9] = 74;
		rsinterface.children[10] = 10600;
		rsinterface.childX[10] = 26;
		rsinterface.childY[10] = 133;
		rsinterface.children[11] = 10601;
		rsinterface.childX[11] = 480;
		rsinterface.childY[11] = 17;
		rsinterface.children[12] = 17131;
		rsinterface.childX[12] = 350;
		rsinterface.childY[12] = 220;
		rsinterface.children[13] = 17132;
		rsinterface.childX[13] = 350;
		rsinterface.childY[13] = 231;
		rsinterface.children[14] = 17133;
		rsinterface.childX[14] = 350;
		rsinterface.childY[14] = 242;
		rsinterface.children[15] = 17134;
		rsinterface.childX[15] = 350;
		rsinterface.childY[15] = 254;
		rsinterface = RSInterface.interfaceCache[10494];
		rsinterface.invSpritePadX = 6;
		rsinterface.invSpritePadY = 5;
		rsinterface = RSInterface.interfaceCache[10600];
		rsinterface.invSpritePadX = 6;
		rsinterface.invSpritePadY = 5;
	}

	public static void itemsOnDeathDATA(TextDrawingArea[] tda) {
		RSInterface RSinterface = RSInterface.addInterface(17115);
		RSInterface.addText(17109, "", 0xff981f, false, false, 0, tda, 0);
		RSInterface.addText(17110, "Risked wealth notes:", 0xff981f, false, false, 0, tda, 0);
		RSInterface.addText(17111, "Untradeable items that", 0xff981f, false, false, 0, tda, 0);
		RSInterface.addText(17112, "go to the shop after", 0xff981f, false, false, 0, tda, 0);
		RSInterface.addText(17113, "death are worth:", 0xff981f, false, false, 0, tda, 0);
		RSInterface.addText(17114, "Item price divided by 10", 0xff981f, false, false, 0, tda, 0);
		RSInterface.addText(17117, "", 0xff981f, false, false, 0, tda, 0);
		RSInterface.addText(17118, "Untradeables items that", 0xff981f, false, false, 0, tda, 0);
		RSInterface.addText(17119, "go to your inventory", 0xff981f, false, false, 0, tda, 0);
		RSInterface.addText(17120, "after death are worth 0", 0xff981f, false, false, 0, tda, 0);
		RSInterface.addText(17121, "", 0xff981f, false, false, 0, tda, 0);
		RSInterface.addText(17122, "", 0xff981f, false, false, 0, tda, 0);
		RSInterface.addText(17123, "", 0xff981f, false, false, 0, tda, 0);
		RSInterface.addText(17124, "", 0xff981f, false, false, 0, tda, 0);
		RSInterface.addText(17125, "", 0xff981f, false, false, 0, tda, 0);
		RSInterface.addText(17126, "", 0xff981f, false, false, 0, tda, 0);
		RSInterface.addText(17127, "", 0xff981f, false, false, 0, tda, 0);
		RSInterface.addText(17128, "", 0xff981f, false, false, 0, tda, 0);
		RSInterface.addText(17129, "", 0xff981f, false, false, 0, tda, 0);
		RSInterface.addText(17130, "", 0xff981f, false, false, 0, tda, 0);
		RSinterface.parentId = 17115;
		RSinterface.id = 17115;
		RSinterface.setType(0);
		RSinterface.atActionType = 0;
		RSinterface.actionType = 0;
		RSinterface.width = 130;
		RSinterface.height = 147;
		RSinterface.opacity = 0;
		RSinterface.hoverType = -1;
		RSinterface.scrollMax = 230;
		RSinterface.children = new int[20];
		RSinterface.childX = new int[20];
		RSinterface.childY = new int[20];
		RSinterface.children[0] = 17109;
		RSinterface.childX[0] = 0;
		RSinterface.childY[0] = 0;
		RSinterface.children[1] = 17110;
		RSinterface.childX[1] = 0;
		RSinterface.childY[1] = 12;
		RSinterface.children[2] = 17111;
		RSinterface.childX[2] = 0;
		RSinterface.childY[2] = 24;
		RSinterface.children[3] = 17112;
		RSinterface.childX[3] = 0;
		RSinterface.childY[3] = 36;
		RSinterface.children[4] = 17113;
		RSinterface.childX[4] = 0;
		RSinterface.childY[4] = 48;
		RSinterface.children[5] = 17114;
		RSinterface.childX[5] = 0;
		RSinterface.childY[5] = 60;
		RSinterface.children[6] = 17117;
		RSinterface.childX[6] = 0;
		RSinterface.childY[6] = 72;
		RSinterface.children[7] = 17118;
		RSinterface.childX[7] = 0;
		RSinterface.childY[7] = 84;
		RSinterface.children[8] = 17119;
		RSinterface.childX[8] = 0;
		RSinterface.childY[8] = 96;
		RSinterface.children[9] = 17120;
		RSinterface.childX[9] = 0;
		RSinterface.childY[9] = 108;
		RSinterface.children[10] = 17121;
		RSinterface.childX[10] = 0;
		RSinterface.childY[10] = 120;
		RSinterface.children[11] = 17122;
		RSinterface.childX[11] = 0;
		RSinterface.childY[11] = 132;
		RSinterface.children[12] = 17123;
		RSinterface.childX[12] = 0;
		RSinterface.childY[12] = 144;
		RSinterface.children[13] = 17124;
		RSinterface.childX[13] = 0;
		RSinterface.childY[13] = 156;
		RSinterface.children[14] = 17125;
		RSinterface.childX[14] = 0;
		RSinterface.childY[14] = 168;
		RSinterface.children[15] = 17126;
		RSinterface.childX[15] = 0;
		RSinterface.childY[15] = 180;
		RSinterface.children[16] = 17127;
		RSinterface.childX[16] = 0;
		RSinterface.childY[16] = 192;
		RSinterface.children[17] = 17128;
		RSinterface.childX[17] = 0;
		RSinterface.childY[17] = 204;
		RSinterface.children[18] = 17129;
		RSinterface.childX[18] = 0;
		RSinterface.childY[18] = 216;
		RSinterface.children[19] = 17130;
		RSinterface.childX[19] = 0;
		RSinterface.childY[19] = 228;
	}

	public static void equipmentScreenBank(TextDrawingArea[] wid) {
		RSInterface tab = RSInterface.addTabInterface(15150, 18, 506, 7, 332);
		RSInterface.addSprite(15107, 283);
		RSInterface.addHoverButton(15210, 148, 21, 21, "Close Window", 250, 15211, 3);
		RSInterface.addHoveredButton(15211, 149, 21, 21, 15212);
		RSInterface.addHoverButton(21024, 281, 72, 32, "Return To Bank", -1, 21025, 5);
		RSInterface.addHoveredButton(21025, 282, 72, 32, 21026);
		RSInterface.addText(15111, "", wid, 2, 0xe4a146, false, true);
		RSInterface.addText(15112, "Attack bonuses", wid, 2, 0xFF8900, false, true);
		RSInterface.addText(15113, "Defence bonuses", wid, 2, 0xFF8900, false, true);
		RSInterface.addText(15114, "Other bonuses", wid, 2, 0xFF8900, false, true);
		RSInterface.addText(15115, "Ranged strength:", wid, 1, 0xFF8900, false, true);
		RSInterface.addText(15116, "Magic damage bonus:", wid, 1, 0xFF8900, false, true);
		for (int i = 1675; i <= 1684; i++) {
			RSInterface.textSize(i, wid, 1);
		}
		RSInterface.textSize(1686, wid, 1);
		RSInterface.textSize(1687, wid, 1);
		RSInterface.addChar(15125, 550);
		tab.totalChildren(48);
		tab.child(0, 15107, 15, 5);
		tab.child(1, 15210, 476, 8);
		tab.child(2, 15211, 476, 8);
		tab.child(3, 15111, 14, 30);
		int Child = 4;
		int Y = 45;
		for (int i = 1675; i <= 1679; i++) {
			tab.child(Child, i, 29, Y);
			Child++;
			Y += 14;
		}
		tab.child(9, 1680, 29, 137); // 161
		tab.child(10, 1681, 29, 153);
		tab.child(11, 1682, 29, 168);
		tab.child(12, 1683, 29, 183);
		tab.child(13, 1684, 29, 197);
		tab.child(14, 1686, 29, 262 - 24);
		tab.child(17, 1687, 29, 276 - 24);
		tab.child(15, 15125, 170, 200);
		tab.child(16, 15112, 24, 30);
		tab.child(18, 15113, 24, 122); // 147
		tab.child(19, 15114, 24, 223);
		tab.child(20, 1645, 104 + 295, 149 - 52);
		tab.child(21, 1646, 399, 163);
		tab.child(22, 1647, 399, 163);
		tab.child(23, 1648, 399, 58 + 146);
		tab.child(24, 1649, 26 + 22 + 297 - 2, 110 - 44 + 118 - 13 + 5);
		tab.child(25, 1650, 321 + 22, 58 + 154);
		tab.child(26, 1651, 321 + 134, 58 + 118);
		tab.child(27, 1652, 321 + 134, 58 + 154);
		tab.child(28, 1653, 321 + 48, 58 + 81);
		tab.child(29, 1654, 321 + 107, 58 + 81);
		tab.child(30, 1655, 321 + 58, 58 + 42);
		tab.child(31, 1656, 321 + 112, 58 + 41);
		tab.child(32, 1657, 321 + 78, 58 + 4);
		tab.child(33, 1658, 321 + 37, 58 + 43);
		tab.child(34, 1659, 321 + 78, 58 + 43);
		tab.child(35, 1660, 321 + 119, 58 + 43);
		tab.child(36, 1661, 321 + 22, 58 + 82);
		tab.child(37, 1662, 321 + 78, 58 + 82);
		tab.child(38, 1663, 321 + 134, 58 + 82);
		tab.child(39, 1664, 321 + 78, 58 + 122);
		tab.child(40, 1665, 321 + 78, 58 + 162);
		tab.child(41, 1666, 321 + 22, 58 + 162);
		tab.child(42, 1667, 321 + 134, 58 + 162);
		tab.child(43, 1688, 50 + 297 - 2, 110 - 13 + 5);
		tab.child(44, 21024, 457, 30);
		tab.child(45, 21025, 457, 30);
		tab.child(46, 15115, 29, 266);
		tab.child(47, 15116, 29, 280);

		for (int i = 1675; i <= 1684; i++) {
			RSInterface rsi = RSInterface.interfaceCache[i];
			rsi.textColour = 0xFF9200;
			rsi.centerText = false;
		}
		for (int i = 1686; i <= 1687; i++) {
			RSInterface rsi = RSInterface.interfaceCache[i];
			rsi.textColour = 0xFF9200;
			rsi.centerText = false;
		}
	}

	public static void bankInterface(TextDrawingArea[] wid) {
		int xOffset = -2;
		RSInterface Interface = RSInterface.addTabInterface(24959, 16, 500, 10, 335);
		RSInterface.setChildren(42, Interface);
		RSInterface.addSprite(5293, Config.PRE_EOC ? 1078 : 373);
		RSInterface.setBounds(5293, 15 + xOffset, 6, 0, Interface);
		RSInterface.addHover(5384, 3, 0, 5380, 148, 17, 17, "Close Window");
		RSInterface.addHovered(5380, 149, 17, 17, 5379);
		RSInterface.setBounds(5384, 476 + xOffset, 9, 3, Interface);
		RSInterface.setBounds(5380, 476 + xOffset, 9, 4, Interface);
		RSInterface.addHover(5294, 4, 0, 5295, 374, 114, 25, "Set a bank pin");
		RSInterface.addHovered(5295, 375, 114, 25, 5296);
		RSInterface.setBounds(5294, 110 + xOffset, 297, 5, Interface);
		RSInterface.setBounds(5295, 110 + xOffset, 297, 6, Interface);

		RSInterface.addBankHover(22000, 4, 22001, 142, 143, 35, 25, 304, 1, "Swap withdraw mode",
				22002, 7, 6, "interfaces/Bank/BANK", 22003, "Switch to insert items \nmode", "", 12,
				20);
		RSInterface.setBounds(22000, 25 + xOffset, 297, 7, Interface);
		RSInterface.setBounds(22001, 10 + xOffset, 237, 8, Interface);

		// RSInterface.addBankHover(interfaceID, actionType, hoverid, spriteId1,
		// spriteId2, Width, Height, configFrame, configId, Tooltip, hoverId2,
		// hoverSpriteId, hoverSpriteId2, hoverSpriteName, hoverId3,
		// hoverDisabledText, hoverEnabledText, X, Y);

		RSInterface.addHoverButton(22004, 379, 35, 25, "Search", -1, 22005, 1);
		RSInterface.addHoveredButton(22005, 380, 35, 25, 22006);
		RSInterface.setBounds(22004, 65 + xOffset, 297, 9, Interface);
		RSInterface.setBounds(22005, 65 + xOffset, 297, 10, Interface);

		RSInterface.addHoverButton(22008, 376, 35, 25, "Withdraw", -1, 22009, 1);
		RSInterface.addHoveredButton(22009, 377, 35, 25, 22010);
		RSInterface.setBounds(22008, 240 + xOffset, 297, 11, Interface);
		RSInterface.setBounds(22009, 240 + xOffset, 297, 12, Interface);

		RSInterface.addHoverButton(22012, 382, 35, 25, "Deposit inventory", -1, 22013, 1);
		RSInterface.addHoveredButton(22013, 383, 35, 25, 22014);
		RSInterface.setBounds(22012, 333 + xOffset, 297, 13, Interface);
		RSInterface.setBounds(22013, 333 + xOffset, 297, 14, Interface);

		RSInterface.addHoverButton(22016, 384, 35, 25, "Deposit worn equipment", -1, 22017, 1);
		RSInterface.addHoveredButton(22017, 385, 35, 25, 22018);
		RSInterface.setBounds(22016, 373 + xOffset, 297, 15, Interface);
		RSInterface.setBounds(22017, 373 + xOffset, 297, 16, Interface);

		RSInterface.addHoverButton(22020, 386, 35, 25, "Show equipment stats", -1, 22021, 1);
		RSInterface.addHoveredButton(22021, 387, 35, 25, 22022);
		RSInterface.setBounds(22020, 413 + xOffset, 297, 17, Interface);
		RSInterface.setBounds(22021, 413 + xOffset, 297, 18, Interface);

		RSInterface.setBounds(5383, 120 + xOffset, 8, 1, Interface);
		RSInterface.setBounds(5385, -4 + xOffset, 74, 2, Interface);
		RSInterface.addButton(22024, 388, "Click here to view the full contents of your bank");
		RSInterface.setBounds(22024, 22 + xOffset, 29, 19, Interface);
		RSInterface.addButton(22025, 392, "Drag an item here to create a new tab");
		RSInterface.setBounds(22025, 70 + xOffset, 29, 20, Interface);
		RSInterface.addButton(22026, 392, "Drag an item here to create a new tab");
		RSInterface.setBounds(22026, 118 + xOffset, 29, 21, Interface);
		RSInterface.addButton(22027, 392, "Drag an item here to create a new tab");
		RSInterface.setBounds(22027, 166 + xOffset, 29, 22, Interface);
		RSInterface.addButton(22028, 392, "Drag an item here to create a new tab");
		RSInterface.setBounds(22028, 214 + xOffset, 29, 23, Interface);
		RSInterface.addButton(22029, 392, "Drag an item here to create a new tab");
		RSInterface.setBounds(22029, 262 + xOffset, 29, 24, Interface);
		RSInterface.addButton(22030, 392, "Drag an item here to create a new tab");
		RSInterface.setBounds(22030, 310 + xOffset, 29, 25, Interface);
		RSInterface.addButton(22031, 392, "Drag an item here to create a new tab");
		RSInterface.setBounds(22031, 358 + xOffset, 29, 26, Interface);
		RSInterface.addButton(22032, 392, "Drag an item here to create a new tab");
		RSInterface.setBounds(22032, 406 + xOffset, 29, 27, Interface);
		RSInterface.addText(22033, "134", wid, 0, 0xB4965A, true, false);
		RSInterface.setBounds(22033, 473 + xOffset, 35, 28, Interface);
		RSInterface.addText(22034, "496", wid, 0, 0xB4965A, true, false);
		RSInterface.setBounds(22034, 473 + xOffset, 50, 29, Interface);
		RSInterface.addBankItem(22035, false);
		RSInterface.setBounds(22035, 77 + xOffset, 32, 30, Interface);
		RSInterface.addBankItem(22036, false);
		RSInterface.setBounds(22036, 125 + xOffset, 32, 31, Interface);
		RSInterface.addBankItem(22037, false);
		RSInterface.setBounds(22037, 173 + xOffset, 32, 32, Interface);
		RSInterface.addBankItem(22038, false);
		RSInterface.setBounds(22038, 221 + xOffset, 32, 33, Interface);
		RSInterface.addBankItem(22039, false);
		RSInterface.setBounds(22039, 269 + xOffset, 32, 34, Interface);
		RSInterface.addBankItem(22040, false);
		RSInterface.setBounds(22040, 317 + xOffset, 32, 35, Interface);
		RSInterface.addBankItem(22041, false);
		RSInterface.setBounds(22041, 365 + xOffset, 32, 36, Interface);
		RSInterface.addBankItem(22042, false);
		RSInterface.setBounds(22042, 413 + xOffset, 32, 37, Interface);

		for (int interfaceId = 22035; interfaceId <= 22042; interfaceId++) {
			RSInterface.interfaceCache[interfaceId].componentSupportsItemOpacity = true;
		}

		RSInterface.addHoverButton(22055, 825, 35, 25, "View presets", -1, 22056, 1);
		RSInterface.addHoveredButton(22056, 826, 35, 25, 22057);
		RSInterface.setBounds(22055, 453 + xOffset, 297, 38, Interface);
		RSInterface.setBounds(22056, 453 + xOffset, 297, 39, Interface);

		RSInterface.addHoverButton(34990, 1012, 35, 25, "Set always placeholder", -1, 34991, 1);
		RSInterface.interfaceCache[34990].setConfigFrame(835);
		RSInterface.interfaceCache[34990].setScriptCompare(1);
		RSInterface.addHoveredButton(34991, 1013, 35, 25, 34992);
		RSInterface.setBounds(34990, 280, 297, 40, Interface);
		RSInterface.setBounds(34991, 280, 297, 41, Interface);

		// These text are used by the bank, if removed, client will crash.
		RSInterface.addText(27000, "0", 0xFF981F, false, true, 52, wid, 1);
		RSInterface.addText(27001, "0", 0xFF981F, false, true, 52, wid, 1);
		RSInterface.addText(27002, "0", 0xFF981F, false, true, 52, wid, 1);

		Interface = RSInterface.interfaceCache[5385];
		Interface.height = 227;
		Interface.width = 480;
		Interface.scrollMax = 1333;
		RSInterface.interfaceCache[5385].offsetY -= 7; // height for bank items
		// on interface

		int mainContainerX = Interface.childX[0];

		int mainContainerY = Interface.childY[0];

		RSInterface.setChildren(Config.PRE_EOC ? 36 : 18, Interface);
		RSInterface.setBounds(5382, mainContainerX, mainContainerY, 0, Interface);

		if (Config.PRE_EOC) {
			RSInterface.addSprite(38432, 1079);
		}

		for (int tab = 1; tab < 9; tab++) {

			RSInterface container = RSInterface.itemGroup(35_000 + tab, 10, 36, 12, 12);

			container.childInvisibilitySupported = true;
			container.populateContainer(0, 1);
			container.actions = RSInterface.interfaceCache[5382].actions;
			container.parentId = 5292;
			container.itemsAreSwappable = true;
			container.invSpritePadX = 12;
			container.componentSupportsItemOpacity = true;
			// 595144
			RSInterface separator = RSInterface.addPixels(35_000 + 8 + tab,
					420 + (Config.PRE_EOC ? 24 : 0), Config.PRE_EOC ? 1 : 3,
					Config.PRE_EOC ? 0x595144 : 0x000000, Config.PRE_EOC ? 256 : 96);

			if (Config.PRE_EOC) {
				RSInterface.setChildren(2, separator);
				RSInterface.setBounds(38432, mainContainerX, mainContainerY, 0, separator);
				RSInterface.addText(38445 + tab, tab == 1 ? "" : "Tab " + tab, wid, 0, 0xF2AA3E, false,
						true);
				RSInterface.setBounds(38445 + tab, mainContainerX, mainContainerY, 1, separator);
			}

			separator.childInvisibilitySupported = true;
			separator.parentId = 5385;

			if (Config.PRE_EOC) {
				RSInterface.setBounds(35_000 + tab, mainContainerX, mainContainerY + 13, tab,
						Interface);
				RSInterface.setBounds(35_000 + 8 + tab, mainContainerX - 6, 15, 8 + tab, Interface);
			} else {
				RSInterface.setBounds(35_000 + tab, mainContainerX, mainContainerY, tab, Interface);
				RSInterface.setBounds(35_000 + 8 + tab, mainContainerX, 0, 8 + tab, Interface);
			}
		}
		RSInterface separator = RSInterface.addPixels(35_017, 420, 3, 0x000000, 96);

		separator.childInvisibilitySupported = true;
		separator.parentId = 5385;

		RSInterface.setBounds(35_017, mainContainerX, 0, 17, Interface);

		// RSInterface.interfaceCache[5382].offsetY += 7; //offset for bank
		// items
		Interface = RSInterface.interfaceCache[5382];
		Interface.width = 10;
		Interface.invSpritePadX = 12;
		Interface.height = 35;
		Interface.componentSupportsItemOpacity = true;
	}

	private static void compareValues(int first, int second) {
		Map<String, String> withdrawButtonMapping = new HashMap<>();

		String[] keyValuePairs = RSInterface.interfaceCache[first].toString().split(",");

		for (String keyValuePair : keyValuePairs) {
			withdrawButtonMapping.put(keyValuePair.split("=")[0], keyValuePair.split("=")[1]);
		}

		Map<String, String> placeholderButtonMapping = new HashMap<>();

		keyValuePairs = RSInterface.interfaceCache[second].toString().split(",");

		for (String keyValuePair : keyValuePairs) {
			placeholderButtonMapping.put(keyValuePair.split("=")[0], keyValuePair.split("=")[1]);
		}

		for (Map.Entry<String, String> entry : withdrawButtonMapping.entrySet()) {
			String key = entry.getKey();

			String value = entry.getValue();

			String otherValue = placeholderButtonMapping.get(key);

			if (value == null || otherValue == null || !value.equals(otherValue)) {
				Utility.print(String.format("value for key %s doesn't match: (%s) %s -> (%s) %s",
						first, key, second, value, otherValue));
			}
		}
	}

	public static void testContainer(TextDrawingArea[] tda) {
		RSInterface parent = RSInterface.addInterface(37_000);

	}

	public static void weaponTracker(TextDrawingArea[] tda) {

		RSInterface Interface = RSInterface.addInterface(25403, 11, 506, 12, 328);
		int xBase1 = -3;
		int yBase1 = -2;
		int children = 4;
		int id = 25407 + children;

		int yBase = 76;
		int y = yBase + yBase1;
		int x = 43 + xBase1;
		int[] items = {1215, 3204, 1305, 1434, 20784, 11802, 11804, 11806, 11808, 11838, 13271, 19481,
				20785, 10887, 11235, 861, 9244, 4718, -1};
		int amountOfItems = items.length;
		int rowMaximum = 4;
		int currentRow = 0;
		RSInterface.setChildren((amountOfItems * 4) + children + 8, Interface);

		RSInterface.addSprite(25404, 315);
		RSInterface.setBounds(25404, 10 + xBase1, 10 + yBase1, 0, Interface);

		RSInterface.addText(25405, "", tda, 2, 0xffb000, false, true); // Profile
		// of
		// Mgt
		// Madness.
		RSInterface.setBounds(25405, 20 + xBase1, 19 + yBase1, 1, Interface);

		RSInterface.addHoverButton(25406, 148, 16, 16, "Close Window", -1, 25407, 1); // Close
		// button.
		RSInterface.addHoveredButton(25407, 149, 16, 16, 25408); // Close button
		// hover.
		RSInterface.setBounds(25406, 483 + xBase1, 19 + yBase1, 2, Interface);
		RSInterface.setBounds(25407, 483 + xBase1, 19 + yBase1, 3, Interface);

		for (int index = 0; index < amountOfItems; index++) {
			if (items[index] == -1) // Vengeance sprite
			{
				RSInterface.addHoverButton(id, 316, 56, 40, "View", -1, id + 1, 1);
				RSInterface.addHoveredButton(id + 1, 317, 56, 40, id + 2);
			} else {
				RSInterface.addHoverButton(id, 318, 56, 40, "View", -1, id + 1, 1);
				RSInterface.addHoveredButton(id + 1, 319, 56, 40, id + 2);
			}
			RSInterface.interfaceCache[id + 2].toolTipSpecialX = x - 21;
			RSInterface.interfaceCache[id + 2].toolTipSpecialY = y - 39;

			RSInterface.setBounds(id, x - 13, y - 4, children, Interface);
			children++;
			RSInterface.setBounds(id + 1, x - 13, y - 4, children, Interface);
			id += 3;
			children++;
			RSInterface.addToItemGroup(id, items[index], 1, 1, 24, 24, false, null, null, null, false,
					false);
			RSInterface.setBounds(id, x, y, children, Interface);
			id++;
			children++;

			RSInterface.addText(id, "", tda, 1, 0xffb000, true, true);
			RSInterface.setBounds(id, x + 13, y - 20, children, Interface);
			y += 67;
			id++;
			children++;
			currentRow++;
			if (currentRow == rowMaximum) {
				y = yBase - 2;
				x += 65;
				currentRow = 0;
			}
		}
		// 80
		RSInterface.addHover(25521, 4, 0, 25522, 251, 17, 17, "Back");
		RSInterface.setBounds(25521, 459, 17, 80, Interface);

		RSInterface.addHovered(25522, 252, 17, 17, 25523);
		RSInterface.setBounds(25522, 459, 17, 81, Interface);

		RSInterface.addHoverButton(25536, 336, 84, 15, "Search", -1, 25537, 1); // Search
		// button.
		RSInterface.addHoveredButton(25537, 337, 84, 15, 25538); // Search
		// button
		// hover..
		RSInterface.setBounds(25536, 368, 18, 82, Interface);
		RSInterface.setBounds(25537, 368, 18, 83, Interface);
		RSInterface.addText(25539, "Search", tda, 1, 0xffb000, true, true); // Search
		// text.
		RSInterface.setBounds(25539, 412, 18, 84, Interface);

		RSInterface.addHoverButton(20251, 647, 159, 17, "Change", -1, 20252, 1); // Close
		// button.
		RSInterface.addHoveredButton(20252, 648, 159, 17, 20253); // Close
		// button
		// hover.
		RSInterface.setBounds(20251, 204 + xBase1, 19 + yBase1, 85, Interface);
		RSInterface.setBounds(20252, 204 + xBase1, 19 + yBase1, 86, Interface);

		RSInterface.addText(20250, "", tda, 0, ClientConstants.YELLOW, false, true); // Profile
		// of
		// Mgt
		// Madness.
		RSInterface.setBounds(20250, 208 + xBase1, 22 + yBase1, 87, Interface);

	}

	public static void trade(TextDrawingArea[] TDA) {
		RSInterface Interface = RSInterface.addTabInterface(3323, 4, 515, 19, 333);
		RSInterface.setChildren(20, Interface);
		RSInterface.addSprite(3324, 153);
		RSInterface.addHover(3442, 3, 0, 3325, 148, 17, 17, "Close Window");
		RSInterface.addHovered(3325, 149, 17, 17, 3326);

		RSInterface.addText(3417, "Trading With:", 0xFF9933, true, true, 52, TDA, 2);
		RSInterface.addText(3418, "Trader's Offer", 0xFF9933, false, true, 52, TDA, 1);
		RSInterface.addText(3419, "Your Offer", 0xFF9933, false, true, 52, TDA, 1);
		RSInterface.addText(3421, "Accept", 0x00C000, true, true, 52, TDA, 1);
		RSInterface.addText(3423, "Decline", 0xC00000, true, true, 52, TDA, 1);
		RSInterface.addText(3431, "Waiting For Other Player", 0xFFFFFF, true, true, 52, TDA, 1);
		RSInterface.addText(21350, "", ClientConstants.ORANGE, true, true, 52, TDA, 0);
		RSInterface.addText(21351, "", ClientConstants.ORANGE, true, true, 52, TDA, 0);
		RSInterface.addText(21352, "inventory slots.", ClientConstants.ORANGE, true, true, 52, TDA,
				0);
		RSInterface.addText(21353, "", ClientConstants.ORANGE, false, true, 52, TDA, 0);
		RSInterface.addText(21354, "", ClientConstants.ORANGE, false, true, 52, TDA, 0);

		RSInterface.addHover(3420, 1, 0, 3327, 152, 65, 32, "Accept");
		RSInterface.addHovered(3327, 150, 65, 32, 3328);

		RSInterface.addHover(3422, 1, 0, 3329, 152, 65, 32, "Close Window");
		RSInterface.addHovered(3329, 150, 65, 32, 3330);

		RSInterface.setBounds(3324, 0, 16, 0, Interface);
		RSInterface.setBounds(3442, 485, 26, 1, Interface);
		RSInterface.setBounds(3325, 485, 26, 2, Interface);
		RSInterface.setBounds(3417, 258, 25, 3, Interface);
		RSInterface.setBounds(3418, 355, 51, 4, Interface);
		RSInterface.setBounds(3419, 68, 51, 5, Interface);
		RSInterface.setBounds(3420, 223, 120, 6, Interface);
		RSInterface.setBounds(3327, 223, 120, 7, Interface);
		RSInterface.setBounds(3422, 223, 160, 8, Interface);
		RSInterface.setBounds(3329, 223, 160, 9, Interface);
		RSInterface.setBounds(3421, 256, 127, 10, Interface);
		RSInterface.setBounds(3423, 256, 167, 11, Interface);
		RSInterface.setBounds(3431, 256, 272, 12, Interface);
		RSInterface.setBounds(3415, 12, 64, 13, Interface);
		RSInterface.setBounds(3416, 321, 64, 14, Interface);

		RSInterface.setBounds(21350, 256, 66, 15, Interface);
		RSInterface.setBounds(21351, 256, 78, 16, Interface);
		RSInterface.setBounds(21352, 256, 90, 17, Interface);
		RSInterface.setBounds(21353, 13, 310, 18, Interface);
		RSInterface.setBounds(21354, 400, 310, 19, Interface);
		Interface = RSInterface.addTabInterface(3443);
		RSInterface.setChildren(15, Interface);
		RSInterface.addSprite(3444, 151);
		RSInterface.addButton(3546, "Bank/SHOP 2", 63, 24, "Accept", 1);
		RSInterface.addButton(3548, "Bank/SHOP 2", 63, 24, "Decline", 1);
		RSInterface.addText(3547, "Accept", 0x00C000, true, true, 52, TDA, 1);
		RSInterface.addText(3549, "Decline", 0xC00000, true, true, 52, TDA, 1);
		RSInterface.addText(3450, "Trading With:", 0x00FFFF, true, true, 52, TDA, 2);
		RSInterface.addText(3451, "Yourself", 0x00FFFF, true, true, 52, TDA, 2);
		RSInterface.setBounds(3444, 12, 20, 0, Interface);
		RSInterface.setBounds(3442, 470, 32, 1, Interface);
		RSInterface.setBounds(3325, 470, 32, 2, Interface);
		RSInterface.setBounds(3535, 130, 28, 3, Interface);
		RSInterface.setBounds(3536, 105, 47, 4, Interface);
		RSInterface.setBounds(3546, 189, 295, 5, Interface);
		RSInterface.setBounds(3548, 258, 295, 6, Interface);
		RSInterface.setBounds(3547, 220, 299, 7, Interface);
		RSInterface.setBounds(3549, 288, 299, 8, Interface);
		RSInterface.setBounds(3557, 71, 87, 9, Interface);
		RSInterface.setBounds(3558, 315, 87, 10, Interface);
		RSInterface.setBounds(3533, 64, 70, 11, Interface);
		RSInterface.setBounds(3534, 297, 70, 12, Interface);
		RSInterface.setBounds(3450, 95, 289, 13, Interface);
		RSInterface.setBounds(3451, 95, 304, 14, Interface);
	}

	public static void shop(TextDrawingArea[] TDA) {
		RSInterface rsinterface = RSInterface.addTabInterface(3824, 16, 501, 16, 322);
		RSInterface.setChildren(10, rsinterface);

		RSInterface.addSprite(3825, 250);
		RSInterface.addHover(3902, 4, 0, 3826, 148, 17, 17, "Close Window");
		RSInterface.addHovered(3826, 149, 17, 17, 3827);
		RSInterface.addText(19301, "Shop", 0xff981f, true, true, 52, TDA, 2);

		RSInterface.addHover(25400, 4, 0, 25401, 251, 17, 17, "Back");
		RSInterface.addHovered(25401, 252, 17, 17, 25402);

		RSInterface.addHoverButton(24270, 717, 101, 15, "Search", -1, 24271, 1); // Search
		// button.
		RSInterface.addHoveredButton(24271, 718, 101, 15, 24272); // Search
		// button
		// hover.
		RSInterface.addText(24273, "", 0xff981f, false, true, 52, TDA, 0);

		RSInterface.setBounds(3825, 12, 13, 0, rsinterface); // Background
		RSInterface.setBounds(3902, 474, 22, 1, rsinterface); // Close
		RSInterface.setBounds(3826, 474, 22, 2, rsinterface); // Close hover

		RSInterface scrollTab1 = RSInterface.addInterface(19683);
		RSInterface.setBounds(19683, 24, 47, 3, rsinterface);
		RSInterface.setBounds(19301, 244, 22, 4, rsinterface); // Text
		RSInterface.setBounds(25400, 700, 22, 5, rsinterface);
		RSInterface.setBounds(25401, 700, 22, 6, rsinterface);
		RSInterface.setBounds(24270, 347, 23, 7, rsinterface);
		RSInterface.setBounds(24271, 347, 23, 8, rsinterface);
		RSInterface.setBounds(24273, 350, 25, 9, rsinterface);

		rsinterface = RSInterface.interfaceCache[3900];
		int ITEMS_LENGTH = 200;
		rsinterface.inv = new int[ITEMS_LENGTH];
		rsinterface.invStackSizes = new int[ITEMS_LENGTH];
		rsinterface.invSpritePadX = 14;
		rsinterface.width = 10;
		rsinterface.height = ITEMS_LENGTH / 10;
		rsinterface.invSpritePadY = 20;
		rsinterface = RSInterface.addTabInterface(19682);

		scrollTab1.width = 452;
		scrollTab1.height = 259;
		scrollTab1.scrollMax = 650;

		scrollTab1.totalChildren(1);
		scrollTab1.child(0, 3900, 0, 15);
	}

	public static void emoteTab() {
		RSInterface tab = RSInterface.addTabInterface(147);
		RSInterface scroll = RSInterface.addTabInterface(148);
		tab.totalChildren(1);
		tab.child(0, 148, 0, 1);
		RSInterface.addButton(168, 154, "Yes", 41, 47);
		RSInterface.addButton(169, 155, "No", 41, 47);
		RSInterface.addButton(164, 156, "Bow", 37, 40);
		RSInterface.addButton(165, 157, "Angry", 41, 47);
		RSInterface.addButton(162, 158, "Think", 38, 47);
		RSInterface.addButton(163, 159, "Wave", 41, 47);
		RSInterface.addButton(13370, 160, "Shrug", 41, 47);
		RSInterface.addButton(171, 161, "Cheer", 41, 47);
		RSInterface.addButton(167, 162, "Beckon", 41, 47);
		RSInterface.addButton(170, 163, "Laugh", 41, 47);
		RSInterface.addButton(13366, 164, "Jump for Joy", 41, 47);
		RSInterface.addButton(13368, 166, "Yawn", 41, 47);
		RSInterface.addButton(166, 167, "Dance", 41, 47);
		RSInterface.addButton(13363, 168, "Jig", 39, 47);
		RSInterface.addButton(13364, 169, "Spin", 41, 47);
		RSInterface.addButton(13365, 170, "Headbang", 41, 47);
		RSInterface.addButton(161, 171, "Cry", 41, 47);
		RSInterface.addButton(11100, 172, "Blow kiss", 41, 47);
		RSInterface.addButton(13362, 173, "Panic", 38, 47);
		RSInterface.addButton(13367, 174, "Raspberry", 41, 47);
		RSInterface.addButton(172, 175, "Clap", 41, 47);
		RSInterface.addButton(13369, 176, "Salute", 36, 47);
		RSInterface.addButton(13383, 177, "Goblin Bow", 41, 44);
		RSInterface.addButton(13384, 178, "Goblin Salute", 41, 47);
		RSInterface.addButton(667, 179, "Glass Box", 41, 47);
		RSInterface.addButton(6503, 180, "Climb Rope", 41, 47);
		RSInterface.addButton(6506, 181, "Lean On Air", 41, 47);
		RSInterface.addButton(666, 182, "Glass Wall", 41, 47);
		RSInterface.addButton(18464, 183, "Zombie Walk", 41, 47);
		RSInterface.addButton(18465, 184, "Zombie Dance", 41, 47);
		RSInterface.addButton(15166, 185, "Scared", 41, 47);
		RSInterface.addButton(18686, 186, "Bunny Hop", 41, 47);// 1
		RSInterface.addConfigButton(154, 147, 599, 599, 41, 47, "Skillcape Emote", 0, 1, 700);// 10
		RSInterface.addButton(24400, 192, "Explore", 41, 47);// no 1.1
		RSInterface.addButton(24401, 193, "Stomp", 41, 47);// no 1.2
		RSInterface.addButton(24402, 194, "Flap", 41, 47);// no 1.3
		RSInterface.addButton(24403, 195, "Slap head", 41, 47);// no 1.4

		RSInterface.addButton(24404, 719, "Sit ups", 41, 39);// no
		RSInterface.addButton(24405, 720, "Push ups", 41, 40);// 2
		RSInterface.addButton(24406, 721, "Star jumps", 41, 47);// 3
		RSInterface.addButton(24407, 722, "Jog", 41, 47);// 4

		RSInterface.addButton(24408, 790, "Smooth dance", 41, 47);// no
		RSInterface.addButton(24409, 791, "Crazy dance", 34, 47);// 9

		RSInterface.addButton(24260, 723, "Air Guitar", 41, 41);// 5
		RSInterface.addButton(24261, 187, "Skillcape Emote", 41, 41);// 6
		RSInterface.addButton(24262, 599, "Empty", 41, 41);
		RSInterface.addButton(24263, 599, "Empty", 41, 41);

		scroll.totalChildren(94);
		int[][] emotePositions = {{168, 10, 7}, {169, 54, 7}, {164, 98, 14}, {165, 137, 7},
				{162, 9, 56}, {163, 48, 56}, {13370, 95, 56}, {171, 137, 56}, {167, 7, 105},
				{170, 51, 105}, {13366, 95, 104}, {13368, 139, 105}, {166, 6, 154}, {13363, 50, 154},
				{13364, 90, 154}, {13365, 135, 154}, {161, 8, 204}, {11100, 51, 203}, {13362, 99, 204},
				{13367, 137, 203}, {172, 10, 253}, {13369, 53, 253}, {13383, 88, 258},
				{13384, 138, 252}, {667, 2, 303}, {6503, 49, 302}, {6506, 93, 302}, {666, 137, 302},
				{18464, 9, 352}, {18465, 50, 352}, {15166, 94, 356}, {18686, 141, 353}, {154, 95, 551},
				{24400, 1, 402}, {24401, 54, 402}, {24402, 96, 404}, {24403, 139, 403}, {24404, 3, 460}, // 37
				// is
				// situps
				{24405, 48, 460}, {24406, 96, 455}, {24407, 139, 455}, {24408, 9, 504}, // Smooth
				// dance
				// index
				// 41
				{24409, 54, 501}, // Crazy dance index 42

				{24260, 88, 502}, // Air guitar index 43
				{24261, 131, 502}, // Skill cape emote index 44
				{24262, 101, 805}, // Empty
				{24263, 142, 805},}; // Empty (index 46)

		int childId = 0;
		int interfaceId = 0;
		for (int index = 0; index < emotePositions.length; index++) {
			scroll.child(childId, emotePositions[index][0], emotePositions[index][1],
					emotePositions[index][2]);
			childId++;
		}
		for (int index = 0; index < emotePositions.length; index++) {
			int x = emotePositions[index][1] + 30;
			if (x > 160) {
				x = 130;
			}
			int y = emotePositions[index][2] + 85;
			// Goblin salute.
			if (index == 23) {
				RSInterface.createTimedHoverBox(22195 + interfaceId, "Emote", 40, 50, 125, y);
			}
			// Snowman dance.
			else if (index == 27) {
				RSInterface.createTimedHoverBox(22195 + interfaceId, "Emote", 40, 50, 109, y);
			}
			// Skillcape emote
			else if (index == 32) {
				RSInterface.createTimedHoverBox(22195 + interfaceId, "Emote", 40, 50, 90, y - 70);
			}

			// Zombie hand
			else if (index == 32) {
				RSInterface.createTimedHoverBox(22195 + interfaceId, "Emote", 40, 50, x - 7, y - 70);
			} else if (index == 33) {
				RSInterface.createTimedHoverBox(22195 + interfaceId, "Emote", 40, 50, x + 10, y - 70);
			}

			// Osrs emotes is 43 and above.
			else if (index == 34 || index == 35) {
				y -= 18;
				RSInterface.createTimedHoverBox(22195 + interfaceId, "Emote", 40, 50, x, y);
			} else if (index == 36 || index == 37) {
				RSInterface.createTimedHoverBox(22195 + interfaceId, "Emote", 40, 50, x, y);
			}
			// Smooth dance, crazy dance, air guitar.
			else if (index >= 41 && index <= 43) {
				RSInterface.createTimedHoverBox(22195 + interfaceId, "Emote", 40, 50, x, y - 75);
			}
			// Skill cape emote
			else if (index == 44) {
				RSInterface.createTimedHoverBox(22195 + interfaceId, "Emote", 40, 50, x - 30, y - 70);
			}

			else {
				RSInterface.createTimedHoverBox(22195 + interfaceId, "Emote", 40, 50, x, y);
			}
			int x1 = emotePositions[index][1];
			int y1 = emotePositions[index][2];

			scroll.child(childId, 22195 + interfaceId, x1, y1);
			childId++;
			interfaceId++;
		}

		scroll.width = 173;
		scroll.height = 258;
		scroll.scrollMax = 550;
	}

	public static void optionTab(TextDrawingArea[] tda) {
		RSInterface tab = RSInterface.addTabInterface(904);
		RSInterface energy = RSInterface.interfaceCache[149];
		energy.textColour = 0xff9933;
		RSInterface.addSprite(905, 203);
		RSInterface.addSprite(907, 212);
		RSInterface.addSprite(909, 223);
		RSInterface.addSprite(951, 226);
		RSInterface.addSprite(953, 227);
		RSInterface.addSprite(955, 228);
		RSInterface.addSprite(947, 230);
		RSInterface.addSprite(949, 229);
		RSInterface.addSprite(949, 229);
		// run button here
		RSInterface.addConfigButton(152, 904, 224, 225, 40, 40, "Toggle-run", 1, 5, 173);
		RSInterface.addConfigButton(906, 904, 204, 208, 32, 16, "Dark", 1, 5, 166);
		RSInterface.addConfigButton(908, 904, 205, 209, 32, 16, "Normal", 2, 5, 166);
		RSInterface.addConfigButton(910, 904, 206, 210, 32, 16, "Bright", 3, 5, 166);
		RSInterface.addConfigButton(912, 904, 207, 211, 32, 16, "Very Bright", 4, 5, 166);
		RSInterface.addConfigButton(930, 904, 213, 218, 26, 16, "Music Off", 4, 5, 168);
		RSInterface.addConfigButton(931, 904, 214, 219, 26, 16, "Music Level-1", 3, 5, 168);
		RSInterface.addConfigButton(932, 904, 215, 220, 26, 16, "Music Level-2", 2, 5, 168);
		RSInterface.addConfigButton(933, 904, 216, 221, 26, 16, "Music Level-3", 1, 5, 168);
		RSInterface.addConfigButton(934, 904, 217, 222, 24, 16, "Music Level-4", 0, 5, 168);
		RSInterface.addConfigButton(941, 904, 213, 218, 26, 16, "Sound Effects Off", 4, 5, 169);
		RSInterface.addConfigButton(942, 904, 214, 219, 26, 16, "Sound Effects Level-1", 3, 5, 169);
		RSInterface.addConfigButton(943, 904, 215, 220, 26, 16, "Sound Effects Level-2", 2, 5, 169);
		RSInterface.addConfigButton(944, 904, 216, 221, 26, 16, "Sound Effects Level-3", 1, 5, 169);
		RSInterface.addConfigButton(945, 904, 217, 222, 24, 16, "Sound Effects Level-4", 0, 5, 169);
		RSInterface.addConfigButton(913, 904, 225, 224, 40, 40, "Open Resizable Settings", 0, 5, 200);
		RSInterface.addConfigButton(915, 904, 224, 225, 40, 40, "Toggle-Chat Effects", 0, 5, 171);
		RSInterface.addConfigButton(957, 904, 224, 225, 40, 40, "Toggle-Split Private Chat", 1, 5,
				287);
		RSInterface.addConfigButton(12464, 904, 224, 225, 40, 40, "Toggle-Accept Aid", 0, 5, 427);
		RSInterface.addButton(24264, 202, "Client Settings");
		tab.totalChildren(38);
		int x = 0;
		int y = 2;
		tab.child(0, 905, 13 + x, 10 + y);
		tab.child(1, 906, 48 + x, 18 + y);
		tab.child(2, 908, 80 + x, 18 + y);
		tab.child(3, 910, 112 + x, 18 + y);
		tab.child(4, 912, 144 + x, 18 + y);
		tab.child(5, 907, 14 + x, 55 + y);
		tab.child(6, 930, 49 + x, 61 + y);
		tab.child(7, 931, 75 + x, 61 + y);
		tab.child(8, 932, 101 + x, 61 + y);
		tab.child(9, 933, 127 + x, 61 + y);
		tab.child(10, 934, 151 + x, 61 + y);
		tab.child(11, 909, 13 + x, 99 + y);
		tab.child(12, 941, 49 + x, 104 + y);
		tab.child(13, 942, 75 + x, 104 + y);
		tab.child(14, 943, 101 + x, 104 + y);
		tab.child(15, 944, 127 + x, 104 + y);
		tab.child(16, 945, 151 + x, 104 + y);
		tab.child(17, 913, 15, 153);
		tab.child(18, 955, 21, 159);
		tab.child(19, 915, 75, 153);
		tab.child(20, 953, 79, 160);
		tab.child(21, 957, 135, 153);
		tab.child(22, 951, 139, 159);
		tab.child(23, 12464, 15, 208);
		tab.child(24, 949, 20, 213);
		tab.child(25, 152, 75, 208);
		tab.child(26, 947, 87, 212);
		tab.child(27, 149, 80, 231);
		tab.child(28, 24264, 135, 208);
		String[] hoverText =
		{
			"Adjust Screen Brightness",
			"Adjust Music Volume",
				"Adjust Sound Effect Volume", "Resizable settings", "Chat Effects\\n(currently on)",
				"Split Private Chat\\n(currently on)", "Accept Aid\\n(currently on)",
				"Run (on) Energy 100%", "Advanced settings",};

		// X of hover start, Y of hover start, Width, Height, X of box, Y of box
		int[][] hoverBoxLocation = {{11, 10, 45, 85, 33, 33}, {11, 52, 45, 129, 33, 33},
				{11, 94, 45, 173, 33, 33}, {12, 151, 45, 237, 42, 42
				// Mouse button
				}, {74, 151, 105, 237, 42, 42}, {134, 151, 105, 237, 42, 42}, {12, 206, 45, 196, 42, 42
				// Accept aid.
				}, {74, 206, 63, 213, 42, 42}, {134, 206, 105, 213, 42, 42},};
		for (int index = 0; index < 9; index++) {
			RSInterface.createTimedHoverBox(22180 + index, hoverText[index],
					hoverBoxLocation[index][4], hoverBoxLocation[index][5], hoverBoxLocation[index][2],
					hoverBoxLocation[index][3]);
			tab.child(29 + index, 22180 + index, hoverBoxLocation[index][0],
					hoverBoxLocation[index][1]);
		}

	}

	static int[] spriteNames = {256, 266, 269, 275, 255, 274, 260, 265, 263, 271, 277, 258, 270, 259,
			262, 268, 264, 278, 272, 273, 261, 257, 267, 276};

	static int[] spriteNamesOrdered = {256, 275, 260, 271, 270, 268, 272, 266, 255, 265, 277, 259,
			264, 273, 269, 274, 263, 258, 262, 278, 261, 279};

	public static void skillTab602(TextDrawingArea[] TDA) {
		int y = +4;
		int y1 = -3;
		int x = -2;
		RSInterface skill = RSInterface.addInterface(3917);
		RSInterface.addSprite(24362, 231); // Total level sprite.
		RSInterface.createSkillHover(24363, 9, 190, 28);

		// The interface identity of the background of the icons. Which is the
		// button.png
		int[] buttons = {8654, 8655, 8656, 8657, 8658, 8659, 8660, 13929, 8662, 8663, 8664, 8665,
				8666, 8667, 8668, 8669, 8670, 8671, 8672, 12162, 13928};
		int[] hovers = {4040, 4076, 4112, 4046, 4082, 4118, 4052, 4088, 4124, 4058, 4094, 4130, 4064,
				4100, 4136, 4070, 4106, 4142, 4160, 2832, 13917};
		int[][] text = {{4004, 4005}, {4016, 4017}, {4028, 4029}, {4006, 4007}, {4018, 4019},
				{4030, 4031}, {4008, 4009}, {4020, 4021}, {4032, 4033}, {4010, 4011}, {4022, 4023},
				{4034, 4035}, {4012, 4013}, {4024, 4025}, {4036, 4037}, {4014, 4015}, {4026, 4027},
				{4038, 4039}, {4152, 4153}, {12166, 12167}, {13926, 13927}};
		int[] icons = {3965, 3966, 3967, 3968, 3969, 3970, 3971, 3972, 3973, 3974, 3975, 3976, 3977,
				3978, 3979, 3980, 3981, 3982, 4151, 12165, 13925};
		int[][] buttonCoords = {{4, 4}, {66, 4}, {128, 4}, {4, 32}, {66, 32}, {128, 32}, {4, 60},
				{66, 60}, {128, 60}, {4, 88}, {66, 88}, {128, 88}, {4, 116}, {66, 116}, {128, 116},
				{4, 144}, {66, 144}, {128, 144}, {4, 172}, {66, 172}, {128, 172}};
		int[][] iconCoords = {{6, 6}, {69, 7}, {131, 6}, {9, 34}, {68, 33}, {131, 36}, {9, 64},
				{67, 63}, {131, 61}, {7, 91}, {68, 94}, {133, 90}, {6, 118}, {70, 120}, {130, 118},
				{6, 147}, {69, 146}, {132, 146}, {6, 173}, {69, 173}, {130, 174}};
		int[][] textCoords = {
				// X coordinate of bottom number, which is the current number of
				// a skill (118/99) the 118.
				// Y coordinate of bottom number, which is the current number of
				// a skill (118/99) the 118.
				// X coordinate of bottom number, which is the base number of a
				// skill (118/99) the 99.
				// Y coordinate of bottom number, which is the base number of a
				// skill (118/99) the 99.
				{31, 7, 44, 18}, {93, 7, 106, 18}, {155, 7, 168, 18}, {31, 35, 44, 46},
				{93, 35, 106, 46}, {155, 35, 168, 46}, {31, 63, 44, 74}, {93, 63, 106, 74},
				{155, 63, 168, 74}, {31, 91, 44, 102}, {93, 91, 106, 102}, {155, 91, 168, 102},
				{31, 119, 44, 130}, {93, 119, 106, 130}, {155, 119, 168, 130}, {31, 149, 44, 158},
				{93, 147, 106, 158}, {155, 147, 168, 158}, {31, 175, 44, 186}, {93, 175, 106, 186},
				{155, 175, 168, 186}};
		for (int i = 0; i < hovers.length; i++) {
			RSInterface.createSkillHover(hovers[i], 9, 60, 31);
			RSInterface.addSkillButton(buttons[i]);
			RSInterface.addImage(icons[i], spriteNames[i]);
		}
		skill.children(icons.length + (text.length * 2) + hovers.length + buttons.length + 3);
		int frame = 0;
		RSInterface totalLevel = RSInterface.interfaceCache[3984];
		totalLevel.textColour = 0xffff01;
		totalLevel.message = "Total Level:";
		totalLevel.textDrawingAreas = RSInterface.fonts[2];
		totalLevel.textSize = 2;
		totalLevel.centerText = true;

		skill.child(frame, 24362, 6 + x, 228 + y1);
		frame++;
		skill.child(frame, 24363, 6 + x, 228 + y1);
		frame++;
		skill.child(frame, 3984, 65 + x, 234 + y1);
		frame++;
		int yExtra = 0;
		for (int i = 0; i < buttons.length; i++) {
			if (i == 3 || i == 6 || i == 9 || i == 12 || i == 15 || i == 18) {
				yExtra += 3;
			}
			skill.child(frame, buttons[i], buttonCoords[i][0] + x, buttonCoords[i][1] + y + yExtra);
			frame++;
		}
		yExtra = 0;
		for (int i = 0; i < icons.length; i++) {

			if (i == 3 || i == 6 || i == 9 || i == 12 || i == 15 || i == 18) {
				yExtra += 3;
			}
			skill.child(frame, icons[i], iconCoords[i][0] + x, iconCoords[i][1] + y + yExtra + 1);
			frame++;
		}
		yExtra = 0;
		for (int i = 0; i < text.length; i++) {
			if (i == 3 || i == 6 || i == 9 || i == 12 || i == 15 || i == 18) {
				yExtra += 3;
			}
			RSInterface text1 = RSInterface.interfaceCache[text[i][0]];
			text1.textColour = 0xffff01;
			RSInterface text2 = RSInterface.interfaceCache[text[i][1]];
			text2.textColour = 0xffff01;
			skill.child(frame, text[i][0], textCoords[i][0] + x, textCoords[i][1] + y + yExtra);
			frame++;
		}
		yExtra = 0;
		for (int i = 0; i < text.length; i++) {
			if (i == 3 || i == 6 || i == 9 || i == 12 || i == 15 || i == 18) {
				yExtra += 3;
			}
			skill.child(frame, text[i][1], textCoords[i][2] + x, textCoords[i][3] + y + yExtra);
			frame++;
		}
		yExtra = 0;
		for (int i = 0; i < hovers.length; i++) {

			if (i == 3 || i == 6 || i == 9 || i == 12 || i == 15 || i == 18) {
				yExtra += 3;
			}
			skill.child(frame, hovers[i], buttonCoords[i][0] + x, buttonCoords[i][1] + y + yExtra);
			frame++;
		}
	}

	public static void skillTab474(TextDrawingArea[] TDA) {
			int globalY = 3;
			int y = -3;
			int y1 = -3;
			int x = -4;
			RSInterface skill = RSInterface.addInterface(3917);
			RSInterface.addSprite(24362, 788); // Total level sprite.
			RSInterface.createSkillHover(24363, 9, 181, 36);

			// The interface identity of the background of the icons. Which is
			// the button.png
			int[] buttonsInterfaceId = {8654, 8655, 8656, 8657, 8658, 8659, 8660, 13929, 8662, 8663,
					8664, 8665, 8666, 8667, 8668, 8669, 8670, 8671, 8672, 12162, 13928, 26370};
			int[] hoversInterfaceId = {4040, 4076, 4112, 4046, 4082, 4118, 4052, 4088, 4124, 4058,
					4094, 4130, 4064, 4100, 4136, 4070, 4106, 4142, 4160, 2832, 13917, 26375};
			int[][] textInterfaceId = {{4004, 4005}, {4016, 4017}, {4028, 4029}, {4006, 4007},
					{4018, 4019}, {4030, 4031}, {4008, 4009}, {4020, 4021}, {4032, 4033}, {4010, 4011},
					{4022, 4023}, {4034, 4035}, {4012, 4013}, {4024, 4025}, {4036, 4037}, {4014, 4015},
					{4026, 4027}, {4038, 4039}, {4152, 4153}, {12166, 12167}, {13926, 13927},
					{26380, 26381}};
			int[] iconsInterfaceId = {3965, 3966, 3967, 3968, 3969, 3970, 3971, 3972, 3973, 3974, 3975,
					3976, 3977, 3978, 3979, 3980, 3981, 3982, 4151, 12165, 13925, 26385};
			int[][] buttonCoords = {{4, 4}, {67, 4}, {130, 4}, {4, 32}, {67, 32}, {130, 32}, {4, 60},
					{67, 60}, {130, 60}, {4, 88}, {67, 88}, {130, 88}, {4, 116}, {67, 116}, {130, 116},
					{4, 144}, {67, 144}, {130, 144}, {4, 172}, {67, 172}, {130, 172}, {4, 200}};
			int[][] iconCoords = {{6, 6}, {72, 10}, {136, 8}, {11, 37}, {74, 36}, {138, 38}, {11, 67},
					{72, 67}, {135, 64}, {9, 93}, {72, 98}, {139, 93}, {9, 120}, {72, 121}, {136, 120},
					{8, 148}, {71, 147}, {139, 149}, {8, 175}, {71, 174}, {134, 177}, {9, 204}};
			int[][] textCoords = {
					// X coordinate of bottom number, which is the current
					// number of a skill (118/99) the 118.
					// Y coordinate of bottom number, which is the current
					// number of a skill (118/99) the 118.
					// X coordinate of bottom number, which is the base number
					// of a skill (118/99) the 99.
					// Y coordinate of bottom number, which is the base number
					// of a skill (118/99) the 99.
					{36, 8, 47, 21}, {98, 7, 109, 18}, {162, 7, 173, 18}, {36, 36, 47, 49},
					{98, 35, 109, 46}, {162, 35, 173, 46}, {36, 8, 47, 77}, {98, 63, 109, 74},
					{162, 63, 173, 74}, {36, 8, 47, 21}, {98, 91, 109, 102}, {162, 91, 173, 102},
					{36, 8, 47, 21}, {98, 119, 109, 130}, {162, 119, 173, 130}, {36, 8, 47, 21},
					{98, 147, 109, 158}, {162, 147, 173, 158}, {36, 8, 47, 21}, {98, 175, 109, 186},
					{162, 175, 173, 186}, {37, 200, 49, 210}};
			for (int i = 0; i < hoversInterfaceId.length; i++) {
				RSInterface.createSkillHover(hoversInterfaceId[i], 9, 60, 31);
				RSInterface.addSkillButton474(buttonsInterfaceId[i]);
				RSInterface.addImage(iconsInterfaceId[i], spriteNames[i] + (320));
			}
			skill.children(iconsInterfaceId.length + (textInterfaceId.length * 2)
					+ hoversInterfaceId.length + buttonsInterfaceId.length + 3 + 2);
			int frame = 0;
			RSInterface totalLevel = RSInterface.interfaceCache[3984];
			totalLevel.textColour = ClientConstants.SKILL_TAB_YELLOW;
			totalLevel.message = "Total Level: 0";
			totalLevel.textDrawingAreas = RSInterface.fonts[3];
			totalLevel.textSize = 1;
			totalLevel.offsetY -= 6;
		totalLevel.offsetX -= 2;

			skill.child(frame, 24362, 64 + x + 3, 222 + y1 + globalY);
			frame++;
			skill.child(frame, 24363, 6 + x, 224 + y1 + globalY);
			frame++;
			skill.child(frame, 3984, 70, 232 + globalY);// Total level text
			frame++;

			/*
			 * RSInterface.addText(20246, "Combat Lvl: 0", TDA, 1, ClientConstants.YELLOW, false,
			 * true); skill.child(frame, 20246, 89, 220 + globalY); frame++;
			 */

			RSInterface.addText(20247, "QP: 0", TDA, 1, ClientConstants.YELLOW, false, true);
			skill.child(frame, 20247, 20, 232 + globalY);
			frame++;
			int yExtra = 0;
			for (int i = 0; i < buttonsInterfaceId.length; i++) {
				if (i == 3 || i == 6 || i == 9 || i == 12 || i == 15 || i == 18 || i == 21) {
					yExtra += 3;
				}
				skill.child(frame, buttonsInterfaceId[i], buttonCoords[i][0] + x,
						buttonCoords[i][1] + y + yExtra + globalY);
				frame++;
			}
			yExtra = 0;
			int xExtra = 0;
			int yExtra1 = 0;
			for (int i = 0; i < iconsInterfaceId.length; i++) {

				if (i == 3 || i == 6 || i == 9 || i == 12 || i == 15 || i == 18 || i == 21) {
					yExtra += 3;
				}
				skill.child(frame, iconsInterfaceId[i], iconCoords[i][0] + x + xExtra + (0),
						iconCoords[i][1] + y + yExtra + yExtra1 + 1 + (0) + globalY);
				frame++;
				xExtra = 0;
				yExtra1 = 0;
			}
			yExtra = 0;
			int yOne = 5;

		// Create the object for the Hunter interface ids, it shows on the
			// front of the skilltab.
			RSInterface.addText(26380, "99", TDA, 0, 0000, false);
			RSInterface.addText(26381, "99", TDA, 0, 0000, false);
			for (int i = 0; i < textInterfaceId.length; i++) {
				if (i == 3 || i == 6 || i == 9 || i == 12 || i == 15 || i == 18 || i == 21) {
					yExtra += 3;
					yOne += 31;
				}
				RSInterface text1 = RSInterface.interfaceCache[textInterfaceId[i][0]];
				text1.textColour = ClientConstants.SKILL_TAB_YELLOW;
				RSInterface text2 = RSInterface.interfaceCache[textInterfaceId[i][1]];
				text2.textColour = ClientConstants.SKILL_TAB_YELLOW;
				skill.child(frame, textInterfaceId[i][0], textCoords[i][0] + x, yOne + globalY);
				frame++;
			}
			yExtra = 0;
			yOne = 19;
			for (int i = 0; i < textInterfaceId.length; i++) {
				if (i == 3 || i == 6 || i == 9 || i == 12 || i == 15 || i == 18 || i == 21) {
					yExtra += 3;
					yOne += 31;
				}
				skill.child(frame, textInterfaceId[i][1], textCoords[i][2] + x + 1, yOne - 2 + globalY);
				frame++;
			}
			yExtra = 0;
			for (int i = 0; i < hoversInterfaceId.length; i++) {

				if (i == 3 || i == 6 || i == 9 || i == 12 || i == 15 || i == 18 || i == 21) {
					yExtra += 3;
				}
				skill.child(frame, hoversInterfaceId[i], buttonCoords[i][0] + x,
						buttonCoords[i][1] + y + yExtra + globalY);
				frame++;
			}
		/*int y = -3;
		int y1 = -3;
		int x = -4;
		RSInterface skill = RSInterface.addInterface(3917);
		RSInterface.addSprite(24362, 649); // Total level sprite.
		RSInterface.createSkillHover(24363, 9, 181, 36);
		
		// The interface identity of the background of the icons. Which is
		// the button.png
		int[] buttons = {8654, 8655, 8656, 8657, 8658, 8659, 8660, 13929, 8662, 8663, 8664, 8665,
				8666, 8667, 8668, 8669, 8670, 8671, 8672, 12162, 13928};
		int[] hovers = {4040, 4076, 4112, 4046, 4082, 4118, 4052, 4088, 4124, 4058, 4094, 4130,
				4064, 4100, 4136, 4070, 4106, 4142, 4160, 2832, 13917};
		int[][] text = {{4004, 4005}, {4016, 4017}, {4028, 4029}, {4006, 4007}, {4018, 4019},
				{4030, 4031}, {4008, 4009}, {4020, 4021}, {4032, 4033}, {4010, 4011}, {4022, 4023},
				{4034, 4035}, {4012, 4013}, {4024, 4025}, {4036, 4037}, {4014, 4015}, {4026, 4027},
				{4038, 4039}, {4152, 4153}, {12166, 12167}, {13926, 13927}};
		int[] icons = {3965, 3966, 3967, 3968, 3969, 3970, 3971, 3972, 3973, 3974, 3975, 3976,
				3977, 3978, 3979, 3980, 3981, 3982, 4151, 12165, 13925};
		int[][] buttonCoords = {{4, 4}, {67, 4}, {130, 4}, {4, 32}, {67, 32}, {130, 32}, {4, 60},
				{67, 60}, {130, 60}, {4, 88}, {67, 88}, {130, 88}, {4, 116}, {67, 116}, {130, 116},
				{4, 144}, {67, 144}, {130, 144}, {4, 172}, {67, 172}, {130, 172}};
		int[][] iconCoords = {{6, 6}, {72, 10}, {136, 8}, {11, 37}, {74, 36}, {138, 38}, {11, 67},
				{72, 67}, {135, 64}, {9, 93}, {72, 98}, {139, 93}, {9, 120}, {72, 121}, {136, 120},
				{8, 148}, {71, 147}, {139, 149}, {8, 175}, {71, 174}, {134, 177}};
		int[][] textCoords = {
				// X coordinate of bottom number, which is the current
				// number of a skill (118/99) the 118.
				// Y coordinate of bottom number, which is the current
				// number of a skill (118/99) the 118.
				// X coordinate of bottom number, which is the base number
				// of a skill (118/99) the 99.
				// Y coordinate of bottom number, which is the base number
				// of a skill (118/99) the 99.
				{36, 8, 47, 21}, {98, 7, 109, 18}, {162, 7, 173, 18}, {36, 36, 47, 49},
				{98, 35, 109, 46}, {162, 35, 173, 46}, {36, 8, 47, 77}, {98, 63, 109, 74},
				{162, 63, 173, 74}, {36, 8, 47, 21}, {98, 91, 109, 102}, {162, 91, 173, 102},
				{36, 8, 47, 21}, {98, 119, 109, 130}, {162, 119, 173, 130}, {36, 8, 47, 21},
				{98, 147, 109, 158}, {162, 147, 173, 158}, {36, 8, 47, 21}, {98, 175, 109, 186},
				{162, 175, 173, 186}};
		for (int i = 0; i < hovers.length; i++) {
			RSInterface.createSkillHover(hovers[i], 9, 60, 31);
			RSInterface.addSkillButton474(buttons[i]);
			RSInterface.addImage(icons[i], spriteNames[i] + (320));
		}
		skill.children(icons.length + (text.length * 2) + hovers.length + buttons.length + 3 + 2);
		int frame = 0;
		RSInterface totalLevel = RSInterface.interfaceCache[3984];
		totalLevel.textColour = 0xffff01;
		totalLevel.message = "Total level: 0";
		totalLevel.textDrawingAreas = RSInterface.fonts[1];
		totalLevel.textSize = 1;
		
		skill.child(frame, 24362, 5 + x + 3, 225 + y1);
		frame++;
		skill.child(frame, 24363, 6 + x, 224 + y1);
		frame++;
		skill.child(frame, 3984, 89, 240);
		frame++;
		
		RSInterface.addText(20246, "Combat Lvl: 0", TDA, 1, ClientConstants.YELLOW, false, true);
		skill.child(frame, 20246, 89, 225);
		frame++;
		
		RSInterface.addText(20247, "QP: 0", TDA, 1, ClientConstants.YELLOW, false, true);
		skill.child(frame, 20247, 20, 232);
		frame++;
		int yExtra = 0;
		for (int i = 0; i < buttons.length; i++) {
			if (i == 3 || i == 6 || i == 9 || i == 12 || i == 15 || i == 18) {
				yExtra += 3;
			}
			skill.child(frame, buttons[i], buttonCoords[i][0] + x, buttonCoords[i][1] + y + yExtra);
			frame++;
		}
		yExtra = 0;
		int xExtra = 0;
		int yExtra1 = 0;
		for (int i = 0; i < icons.length; i++) {
		
			if (i == 3 || i == 6 || i == 9 || i == 12 || i == 15 || i == 18) {
				yExtra += 3;
			}
			skill.child(frame, icons[i], iconCoords[i][0] + x + xExtra + (0),
					iconCoords[i][1] + y + yExtra + yExtra1 + 1 + (0));
			frame++;
			xExtra = 0;
			yExtra1 = 0;
		}
		yExtra = 0;
		int yOne = 5;
		for (int i = 0; i < text.length; i++) {
			if (i == 3 || i == 6 || i == 9 || i == 12 || i == 15 || i == 18) {
				yExtra += 3;
				yOne += 31;
			}
			RSInterface text1 = RSInterface.interfaceCache[text[i][0]];
			text1.textColour = 0xffff01;
			RSInterface text2 = RSInterface.interfaceCache[text[i][1]];
			text2.textColour = 0xffff01;
			skill.child(frame, text[i][0], textCoords[i][0] + x, yOne);
			frame++;
		}
		yExtra = 0;
		yOne = 19;
		for (int i = 0; i < text.length; i++) {
			if (i == 3 || i == 6 || i == 9 || i == 12 || i == 15 || i == 18) {
				yExtra += 3;
				yOne += 31;
			}
			skill.child(frame, text[i][1], textCoords[i][2] + x + 1, yOne - 2);
			frame++;
		}
		yExtra = 0;
		for (int i = 0; i < hovers.length; i++) {
		
			if (i == 3 || i == 6 || i == 9 || i == 12 || i == 15 || i == 18) {
				yExtra += 3;
			}
			skill.child(frame, hovers[i], buttonCoords[i][0] + x, buttonCoords[i][1] + y + yExtra);
			frame++;
		}
		}*/
	}

	public static void equipmentTab(TextDrawingArea[] wid) {
		RSInterface Interface = RSInterface.interfaceCache[1644];
		RSInterface.addSpriteOld(15101, ""); // cheap hax
		RSInterface.addSpriteOld(15102, ""); // cheap hax
		RSInterface.addSpriteOld(15109, ""); // cheap hax
		Interface.children[23] = 15101;
		Interface.childX[23] = 40;
		Interface.childY[23] = 205;
		Interface.children[24] = 15102;
		Interface.childX[24] = 110;
		Interface.childY[24] = 205;
		Interface.children[25] = 15109;
		Interface.childX[25] = 39;
		Interface.childY[25] = 240;
		Interface.children[26] = 26602;
		Interface.childX[26] = 0;
		Interface.childY[26] = 0;
		Interface = RSInterface.addInterface(26602);

		RSInterface.setChildren(Config.PRE_EOC ? 7 : 8, Interface);

		int frame = 0;

		if (Config.PRE_EOC) {
			RSInterface.addSprite(39_330, 1125);
			RSInterface.setBounds(39_330, 37, 4, frame++, Interface);
		}

		// View Equipment Stats
		RSInterface.addHover(28853, 4, 0, 28854, Config.PRE_EOC ? 1126 : 311, 40, 40,
				"View Equipment Stats");
		RSInterface.addHovered(28854, Config.PRE_EOC ? 1129 : 312, 40, 40, 28855);
		RSInterface.setBounds(28853, Config.PRE_EOC ? 20 : 6, 208, frame++, Interface);
		RSInterface.setBounds(28854, Config.PRE_EOC ? 20 : 6, 208, frame++, Interface);

		// View price checker
		RSInterface.addHover(26100, 4, 0, 26101, Config.PRE_EOC ? 1127 : 756, 40, 40,
				"View guide prices");
		RSInterface.addHovered(26101, Config.PRE_EOC ? 1130 : 757, 40, 40, 26102);
		RSInterface.setBounds(26100, Config.PRE_EOC ? 77 : 51, 208, frame++, Interface);
		RSInterface.setBounds(26101, Config.PRE_EOC ? 77 : 51, 208, frame++, Interface);

		// View items kept on death
		RSInterface.addHover(28850, 4, 0, 28851, Config.PRE_EOC ? 1128 : 313, 40, 40,
				"View items kept on death");
		RSInterface.addHovered(28851, Config.PRE_EOC ? 1131 : 314, 40, 40, 28852);
		RSInterface.setBounds(28850, Config.PRE_EOC ? 132 : 96, 208, frame++, Interface);
		RSInterface.setBounds(28851, Config.PRE_EOC ? 132 : 96, 208, frame++, Interface);

		if (!Config.PRE_EOC) {
			// Call follower
			RSInterface.addHover(26105, 4, 0, 26106, 758, 40, 40, "Call follower");
			RSInterface.addHovered(26106, 759, 40, 40, 26107);
			RSInterface.setBounds(26105, 141, 208, frame++, Interface);
			RSInterface.setBounds(26106, 141, 208, frame++, Interface);
		}

	}

	public static void clanChatTab(TextDrawingArea[] tda) {
		RSInterface tab = RSInterface.addTabInterface(18128);
		RSInterface.addHoverButton(18129, 307, 72, 32, "Join/Leave a Clan", -1, 18130, 1);
		RSInterface.addHoveredButton(18130, 308, 72, 32, 18131);
		RSInterface.addHoverButton(18132, 307, 72, 32, "Clan setup", -1, 18133, 5);
		RSInterface.addHoveredButton(18133, 308, 72, 32, 18134);
		RSInterface.addText(18135, "Join Chat", tda, 0, 0xff9b00, true, true);
		RSInterface.addText(18136, "Clan setup", tda, 0, 0xff9b00, true, true);
		RSInterface.addSprite(18137, 309);
		RSInterface.addText(18138, "Clan Chat", tda, 1, 0xff9b00, true, true);
		RSInterface.addText(18139, "Owner:", tda, 0, 0xff9b00, false, true);
		RSInterface.addText(18140, "Talking in:", tda, 0, 0xff9b00, false, true);
		tab.totalChildren(11);
		tab.child(0, 18137, 0, 60);
		tab.child(1, 18143, 0, 62);
		tab.child(2, 18129, 15, 226);
		tab.child(3, 18130, 15, 226);
		tab.child(4, 18132, 103, 226);
		tab.child(5, 18133, 103, 226);
		tab.child(6, 18135, 51, 237);
		tab.child(7, 18136, 139, 237);
		tab.child(8, 18138, 95, 1);
		tab.child(9, 18139, 20, 23);
		tab.child(10, 18140, 21, 38); /* Text area */
		RSInterface list = RSInterface.addTabInterface(18143);
		list.totalChildren(100);

		for (int i = 24600; i <= 24699; i++) {
			RSInterface.addText(i, "", tda, 0, 0xffffff, false, true);
		}

		for (int id = 24600, i = 0; id <= 24699 && i <= 99; id++, i++) {
			if (ClientDebugConfiguration.DEBUG_INTERFACES) {
				RSInterface.interfaceIds.add(id);
			}
			list.children[i] = id;
			list.childX[i] = 12;
			for (int id2 = 24600, i2 = 1; id2 <= 24699 && i2 <= 99; id2++, i2++) {
				list.childY[0] = 2;
				list.childY[i2] = list.childY[i2 - 1] + 14;
			}
		}
		list.height = 158;
		list.width = 174;
		list.scrollMax = 1405;
	}

	public static void combatInterfaces(TextDrawingArea[] tda) {
		RSInterface.Sidebar0a(1698, 1701, 7499, "Chop", "Hack", "Smash", "Block", 42, 75, 127, 75, 39,
				128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, tda);
		RSInterface.Sidebar0a(2276, 2279, 7574, "Stab", "Lunge", "Slash", "Block", 43, 75, 124, 75,
				41, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, tda);
		RSInterface.Sidebar0a(2423, 2426, 7599, "Chop", "Slash", "Lunge", "Block", 42, 75, 125, 75,
				40, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, tda);
		RSInterface.Sidebar0a(3796, 3799, 7624, "Pound", "Pummel", "Spike", "Block", 39, 75, 121, 75,
				41, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, tda);
		RSInterface.Sidebar0a(4679, 4682, 7674, "Lunge", "Swipe", "Pound", "Block", 40, 75, 124, 75,
				39, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, tda);
		RSInterface.Sidebar0a(4705, 4708, 7699, "Chop", "Slash", "Smash", "Block", 42, 75, 125, 75,
				39, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, tda);
		RSInterface.Sidebar0a(5570, 5573, 7724, "Spike", "Impale", "Smash", "Block", 41, 75, 123, 75,
				39, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, tda);
		RSInterface.Sidebar0a(7762, 7765, 7800, "Chop", "Slash", "Lunge", "Block", 42, 75, 125, 75,
				40, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, tda);
		RSInterface.Sidebar0b(776, 779, "Reap", "Chop", "Jab", "Block", 42, 75, 126, 75, 46, 128, 125,
				128, 122, 103, 122, 50, 40, 103, 40, 50, tda);
		RSInterface.Sidebar0c(425, 428, 7474, "Pound", "Pummel", "Block", 39, 75, 121, 75, 42, 128,
				40, 103, 40, 50, 122, 50, tda);
		RSInterface.Sidebar0c(1749, 1752, 7524, "Accurate", "Rapid", "Longrange", 33, 75, 125, 75, 29,
				128, 40, 103, 40, 50, 122, 50, tda);
		RSInterface.Sidebar0c(1764, 1767, 7549, "Accurate", "Rapid", "Longrange", 33, 75, 125, 75, 29,
				128, 40, 103, 40, 50, 122, 50, tda);
		RSInterface.Sidebar0c(4446, 4449, 7649, "Accurate", "Rapid", "Longrange", 33, 75, 125, 75, 29,
				128, 40, 103, 40, 50, 122, 50, tda);
		RSInterface.Sidebar0c(5855, 5857, 7749, "Punch", "Kick", "Block", 40, 75, 129, 75, 42, 128,
				40, 50, 122, 50, 40, 103, tda);
		RSInterface.Sidebar0c(6103, 6132, 6117, "Bash", "Pound", "Block", 43, 75, 124, 75, 42, 128,
				40, 103, 40, 50, 122, 50, tda);

		RSInterface.Sidebar0c(8460, 8463, 8493, "Jab", "Swipe", "Fend", 46, 75, 124, 75, 43, 128, 40,
				50, 122, 50, 40, 103, tda);

		RSInterface.Sidebar0c(12290, 12293, 12323, "Flick", "Lash", "Deflect", 44, 75, 127, 75, 36,
				128, 40, 50, 40, 103, 122, 50, tda);

		RSInterface.Sidebar0d(328, 331, "Bash", "Pound", "Focus", 42, 66, 39, 101, 41, 136, 40, 120,
				40, 50, 40, 85, tda);

		RSInterface.createCombatIcons(27503, 27500, 787, 786, 785);
		RSInterface.Sidebar0c(27500, 27503, 7524, "Short fuse", "Medium fuse", "Long fuse", 46 - 17, 75, 124 - 15, 75, 43 - 12, 128, 40,
				50, 122, 50, 40, 103, tda);

		RSInterface rsi = RSInterface.addInterface(19300);
		RSInterface.addToggleButton(150, 415, 416, 172, 150, 44, "Auto Retaliate");
		rsi.totalChildren(3, 3, 3);
		rsi.child(0, 19000, 92, 26); // Combat level
		rsi.child(2, 19001, 500, 500); // Constitution updating
		rsi.child(1, 150, 21, 153); // auto retaliate
		RSInterface.addText(19000, "Combat level:", tda, 0, 0xff981f, true, false);
		RSInterface.addText(19001, "", tda, 0, 0xff981f, true, false);
	}

	public static void friendsTab(TextDrawingArea[] tda) {
		RSInterface tab = RSInterface.addTabInterface(5065); // Interface
		// identity of
		// friends tab.
		tab.totalChildren(11);

		RSInterface.addText(5067, "Friends List", tda, 1, 0xff9933, true, true); // Friends
		// list
		// text
		// at
		// the
		// top.
		tab.child(0, 5067, 95, 4);

		RSInterface.addSprite(16127, 201); // The brown background.
		tab.child(1, 16127, 0, 25);

		RSInterface.addSprite(16126, 198); // The line at the top and bottom.
		tab.child(2, 16126, 0, 220);
		tab.child(3, 16126, 0, 22);

		RSInterface list = RSInterface.interfaceCache[5066]; // The scroll.
		tab.child(4, 5066, 0, 24);

		RSInterface.addHoverButton(5068, 199, 72, 32, "Add Friend", 201, 5072, 1); // The
		// Add
		// friend
		// button.
		tab.child(5, 5068, 15, 226);

		RSInterface.addHoveredButton(5072, 200, 72, 32, 5073); // The add friend
		// hovered
		// button.
		tab.child(6, 5072, 15, 226);

		RSInterface.addHoverButton(5069, 199, 72, 32, "Delete Friend", 202, 5074, 1); // The
		// delete
		// friend
		// button.
		tab.child(7, 5069, 103, 226);

		RSInterface.addHoveredButton(5074, 200, 72, 32, 5075); // The delete
		// friend
		// hovered
		// button.
		tab.child(8, 5074, 103, 226);

		RSInterface.addText(5070, "Add Friend", tda, 0, 0xff9933, false, true); // Add
		// friend
		// text.
		tab.child(9, 5070, 25, 237);

		RSInterface.addText(5071, "Delete Friend", tda, 0, 0xff9933, false, true); // Delete
		// friend
		// text.
		tab.child(10, 5071, 106, 237);

		/* Everything to do with the scroll */
		list.height = 196;
		list.width = 174;
		for (int id = 5092, i = 0; id <= 5191 && i <= 99; id++, i++) {
			list.children[i] = id;
			list.childX[i] = 3;
			list.childY[i] = list.childY[i] - 7;
		}
		for (int id = 5192, i = 100; id <= 5291 && i <= 199; id++, i++) {
			list.children[i] = id;
			list.childX[i] = 131;
			list.childY[i] = list.childY[i] - 7;
		}
	}

	public static void ignoreTab(TextDrawingArea[] tda) {
		RSInterface tab = RSInterface.addTabInterface(5715);
		RSInterface list = RSInterface.interfaceCache[5716];
		RSInterface.addText(5717, "Ignore List", tda, 1, 0xff9933, true, true);
		RSInterface.addText(5720, "Add Name", tda, 0, 0xff9933, false, true);
		RSInterface.addText(5721, "Delete Name", tda, 0, 0xff9933, false, true);
		RSInterface.addHoverButton(5718, 199, 72, 32, "Add Name", 501, 5722, 1);
		RSInterface.addHoveredButton(5722, 200, 72, 32, 5723);
		RSInterface.addHoverButton(5719, 199, 72, 32, "Delete Name", 502, 5724, 1);
		RSInterface.addHoveredButton(5724, 200, 72, 32, 5725);
		tab.totalChildren(11);
		tab.child(0, 5717, 95, 4);
		tab.child(1, 16127, 0, 25);
		tab.child(2, 16126, 0, 220);
		tab.child(3, 16126, 0, 22);
		tab.child(4, 5718, 15, 226);
		tab.child(5, 5722, 15, 226);
		tab.child(6, 5719, 103, 226);
		tab.child(7, 5724, 103, 226);
		tab.child(8, 5720, 27, 237);
		tab.child(9, 5721, 108, 237);
		tab.child(10, 5716, 0, 24);
		list.height = 196;
		list.width = 174;
		for (int id = 5742, i = 0; id <= 5841 && i <= 99; id++, i++) {
			list.children[i] = id;
			list.childX[i] = 3;
			list.childY[i] = list.childY[i] - 7;
		}
	}

	public static void equipmentScreen(TextDrawingArea[] wid) {
		RSInterface tab = RSInterface.addTabInterface(15106, 20, 504, 9, 332);
		RSInterface.addSprite(15107, 283);
		RSInterface.addHoverButton(15210, 148, 21, 21, "Close Window", 250, 15211, 3);
		RSInterface.addHoveredButton(15211, 149, 21, 21, 15212);
		RSInterface.addText(15111, "", wid, 2, 0xe4a146, false, true);
		RSInterface.addText(15112, "Attack bonuses", wid, 2, 0xFF8900, false, true);
		RSInterface.addText(15113, "Defence bonuses", wid, 2, 0xFF8900, false, true);
		RSInterface.addText(15114, "Other bonuses", wid, 2, 0xFF8900, false, true);
		RSInterface.addText(15115, "Ranged strength:", wid, 1, 0xFF8900, false, true);
		RSInterface.addText(15116, "Magic damage bonus:", wid, 1, 0xFF8900, false, true);
		for (int i = 1675; i <= 1684; i++) {
			RSInterface.textSize(i, wid, 1);
		}
		RSInterface.textSize(1686, wid, 1);
		RSInterface.textSize(1687, wid, 1);
		RSInterface.addChar(15125, 550);
		tab.totalChildren(46);
		tab.child(0, 15107, 15, 5);
		tab.child(1, 15210, 476, 8);
		tab.child(2, 15211, 476, 8);
		tab.child(3, 15111, 14, 30);
		int Child = 4;
		int Y = 45;
		for (int i = 1675; i <= 1679; i++) {
			tab.child(Child, i, 29, Y);
			Child++;
			Y += 14;
		}
		tab.child(9, 1680, 29, 137); // 161
		tab.child(10, 1681, 29, 153);
		tab.child(11, 1682, 29, 168);
		tab.child(12, 1683, 29, 183);
		tab.child(13, 1684, 29, 197);
		tab.child(14, 1686, 29, 262 - 24);
		tab.child(17, 1687, 29, 276 - 24);
		tab.child(15, 15125, 170, 200);
		tab.child(16, 15112, 24, 30);
		tab.child(18, 15113, 24, 122); // 147
		tab.child(19, 15114, 24, 223);
		tab.child(20, 1645, 104 + 295, 149 - 52);
		tab.child(21, 1646, 399, 163);
		tab.child(22, 1647, 399, 163);
		tab.child(23, 1648, 399, 58 + 146);
		tab.child(24, 1649, 343, 176);
		tab.child(25, 1650, 321 + 22, 58 + 154);
		tab.child(26, 1651, 321 + 134, 58 + 118);
		tab.child(27, 1652, 321 + 134, 58 + 154);
		tab.child(28, 1653, 321 + 48, 58 + 81);
		tab.child(29, 1654, 321 + 107, 58 + 81);
		tab.child(30, 1655, 321 + 58, 58 + 42);
		tab.child(31, 1656, 321 + 112, 58 + 41);
		tab.child(32, 1657, 321 + 78, 58 + 4);
		tab.child(33, 1658, 321 + 37, 58 + 43);
		tab.child(34, 1659, 321 + 78, 58 + 43);
		tab.child(35, 1660, 321 + 119, 58 + 43);
		tab.child(36, 1661, 321 + 22, 58 + 82);
		tab.child(37, 1662, 321 + 78, 58 + 82);
		tab.child(38, 1663, 321 + 134, 58 + 82);
		tab.child(39, 1664, 321 + 78, 58 + 122);
		tab.child(40, 1665, 321 + 78, 58 + 162);
		tab.child(41, 1666, 321 + 22, 58 + 162);
		tab.child(42, 1667, 321 + 134, 58 + 162);
		tab.child(43, 1688, 50 + 297 - 2, 110 - 13 + 5);
		tab.child(44, 15115, 29, 266);
		tab.child(45, 15116, 29, 280);
		for (int i = 1675; i <= 1684; i++) {
			RSInterface rsi = RSInterface.interfaceCache[i];
			rsi.textColour = 0xFF9200;
			rsi.centerText = false;
		}
		for (int i = 1686; i <= 1687; i++) {
			RSInterface rsi = RSInterface.interfaceCache[i];
			rsi.textColour = 0xFF9200;
			rsi.centerText = false;
		}
	}

	public static void configureLunar(TextDrawingArea[] TDA) {// 186
		RSInterface.constructLunar();
		RSInterface.homeTeleport();
		RSInterface.drawRune(30003, 1, "Fire");
		RSInterface.drawRune(30004, 2, "Water");
		RSInterface.drawRune(30005, 3, "Air");
		RSInterface.drawRune(30006, 4, "Earth");
		RSInterface.drawRune(30007, 5, "Mind");
		RSInterface.drawRune(30008, 6, "Body");
		RSInterface.drawRune(30009, 7, "Death");
		RSInterface.drawRune(30010, 8, "Nature");
		RSInterface.drawRune(30011, 9, "Chaos");
		RSInterface.drawRune(30012, 10, "Law");
		RSInterface.drawRune(30013, 11, "Cosmic");
		RSInterface.drawRune(30014, 12, "Blood");
		RSInterface.drawRune(30015, 13, "Soul");
		RSInterface.drawRune(30016, 14, "Astral");
		if (Config.PRE_EOC) {
			RSInterface.addLunar3RunesSmallBox(30017, 9075, 554, 555, 0, 4, 3, 30003, 30004, 64,
					"Bake Pie", "Bake pies without a stove", TDA, 1170, 16, 2);
			RSInterface.addLunar2RunesSmallBox(30025, 9075, 557, 0, 7, 30006, 65, "Cure Plant",
					"Cure disease on farming patch", TDA, 1171, 4, 2);
			RSInterface.addLunar3RunesBigBox(30032, 9075, 564, 558, 0, 0, 0, 30013, 30007, 65,
					"Monster Examine", "Detect the combat statistics of a\\nmonster", TDA, 1172, 2, 2);
			RSInterface.addLunar3RunesSmallBox(30040, 9075, 564, 556, 0, 0, 1, 30013, 30005, 66,
					"NPC Contact", "Speak with varied NPCs", TDA, 1173, 0, 2);

			RSInterface.addLunar3RunesSmallBox(30048, 9075, 563, 557, 0, 0, 9, 30012, 30006, 67,
					"Cure Other", "Cure poisoned players", TDA, 1174, 8, 2);
			RSInterface.addLunar3RunesSmallBox(30056, 9075, 555, 554, 0, 2, 0, 30004, 30003, 67,
					"Humidify", "fills certain vessels with water", TDA, 1175, 0, 5);

			RSInterface.addLunar3RunesSmallBox(30064, 9075, 563, 557, 1, 0, 1, 30012, 30006, 68,
					"Teleports", "Teleports you to moonclan island", TDA, 1176, 0, 5);
			RSInterface.addLunar3RunesBigBox(30075, 9075, 563, 557, 1, 0, 3, 30012, 30006, 69,
					"Teleports", "Teleports players to Moonclan\\nisland", TDA, 1177, 0, 5);
			RSInterface.addLunar3RunesSmallBox(30083, 9075, 563, 557, 1, 0, 5, 30012, 30006, 70,
					"Teleports", "Teleports you to ourania rune altar", TDA, 1178, 0, 5);

			RSInterface.addLunar3RunesSmallBox(30091, 9075, 564, 563, 1, 1, 0, 30013, 30012, 70,
					"Cure Me", "Cures Poison", TDA, 1179, 0, 5);
			RSInterface.addLunar2RunesSmallBox(30099, 9075, 557, 1, 1, 30006, 70, "Hunter Kit",
					"Get a kit of hunting gear", TDA, 1180, 0, 5);

			RSInterface.addLunar3RunesSmallBox(30106, 9075, 563, 555, 1, 0, 0, 30012, 30004, 71,
					"Teleports", "Teleports you to Waterbirth island", TDA, 1181, 0, 5);
			RSInterface.addLunar3RunesBigBox(30114, 9075, 563, 555, 1, 0, 4, 30012, 30004, 72,
					"Teleports", "Teleports players to Waterbirth\\nisland", TDA, 1182, 0, 5);


			RSInterface.addLunar3RunesSmallBox(30122, 9075, 564, 563, 1, 1, 1, 30013, 30012, 73,
					"Cure Group", "Cures Poison on players", TDA, 1183, 0, 5);

			RSInterface.addLunar3RunesBigBox(30130, 9075, 564, 559, 1, 1, 4, 30013, 30008, 74,
					"Stat Spy", "Cast on another player to see their\\nskill levels", TDA, 1184, 8, 2);

			RSInterface.addLunar3RunesBigBox(30138, 9075, 563, 554, 1, 1, 2, 30012, 30003, 74,
					"Teleports", "Teleports you to the Barbarian\\noutpost", TDA, 1224, 0, 5);

			RSInterface.addLunar3RunesBigBox(30146, 9075, 563, 554, 1, 1, 5, 30012, 30003, 75,
					"Tele Group Barbarian", "Teleports players to the Barbarian\\noutpost", TDA, 1185, 0,
					5);

			RSInterface.addLunar3RunesSmallBox(30154, 9075, 554, 556, 1, 5, 9, 30003, 30005, 76,
					"Superglass Make", "Make glass without a furnace", TDA, 1187, 16, 2);



			RSInterface.addLunar3RunesSmallBox(30162, 9075, 563, 555, 1, 1, 3, 30012, 30004, 77,
					"Teleports", "Teleports you to Port khazard", TDA, 1186, 0, 5);
			RSInterface.addLunar3RunesSmallBox(30170, 9075, 563, 555, 1, 1, 7, 30012, 30004, 78,
					"Teleports", "Teleports players to Port khazard", TDA, 1188, 0, 5);

			RSInterface.addLunar3RunesBigBox(30178, 9075, 564, 559, 1, 0, 4, 30013, 30008, 78, "Dream",
					"Take a rest and restore hitpoints 3\\n times faster", TDA, 1189, 0, 5);
			RSInterface.addLunar3RunesSmallBox(30186, 9075, 557, 555, 1, 9, 4, 30006, 30004, 79,
					"String Jewellery", "String amulets without wool", TDA, 1190, 0, 5);
			RSInterface.addLunar3RunesLargeBox(30194, 9075, 557, 555, 1, 9, 9, 30006, 30004, 80,
					"Stat Restore Pot\\nShare", "Share a potion with up to 4 nearby\\nplayers", TDA,
					1191,
					0, 5);
			RSInterface.addLunar3RunesSmallBox(30202, 9075, 554, 555, 1, 6, 6, 30003, 30004, 81,
					"Magic Imbue", "Combine runes without a talisman", TDA, 1192, 0, 5);
			RSInterface.addLunar3RunesBigBox(30210, 9075, 561, 557, 2, 1, 14, 30010, 30006, 82,
					"Fertile Soil", "Fertilise a farming patch with super\\ncompost", TDA, 1194, 4, 2);
			RSInterface.addLunar3RunesBigBox(30218, 9075, 557, 555, 2, 11, 9, 30006, 30004, 83,
					"Boost Potion Share", "Shares a potion with up to 4 nearby\\nplayers", TDA, 1195, 0,
					5);
			RSInterface.addLunar3RunesSmallBox(30226, 9075, 563, 555, 2, 2, 9, 30012, 30004, 84,
					"Fishing Guild Teleport", "Teleports you to the fishing guild", TDA, 1196, 0, 5);
			RSInterface.addLunar3RunesLargeBox(30234, 9075, 563, 555, 1, 2, 13, 30012, 30004, 85,
					"Tele Group Fishing\\nGuild", "Teleports players to the Fishing\\nGuild", TDA, 1197,
					0,
					5);
			RSInterface.addLunar3RunesSmallBox(30242, 9075, 557, 561, 2, 14, 0, 30006, 30010, 85,
					"Plank Make", "Turn Logs into planks", TDA, 1198, 16, 5);
			/******** Cut Off Limit **********/
			RSInterface.addLunar3RunesSmallBox(30250, 9075, 563, 555, 2, 2, 9, 30012, 30004, 86,
					"Catherby Teleport", "Teleports you to Catherby", TDA, 1199, 0, 5);
			RSInterface.addLunar3RunesSmallBox(30258, 9075, 563, 555, 2, 2, 14, 30012, 30004, 87,
					"Tele Group Catherby", "Teleports players to Catherby", TDA, 1200, 0, 5);
			RSInterface.addLunar3RunesSmallBox(30266, 9075, 563, 555, 2, 2, 7, 30012, 30004, 88,
					"Ice Plateau Teleport", "Teleports you to Ice Plateau", TDA, 1201, 0, 5);

			RSInterface.addLunar3RunesBigBox(30274, 9075, 563, 555, 2, 2, 15, 30012, 30004, 89,
					"Tele Group Ice\\n Plateau", "Teleports players to Ice Plateau", TDA, 1202, 0, 5);
			RSInterface.addLunar3RunesBigBox(30282, 9075, 563, 561, 2, 1, 0, 30012, 30010, 90,
					"Energy Transfer",
					"Spend hitpoints and SA Energy to\\n give another player hitpoints and run energy",
					TDA, 1204, 8, 2);
			RSInterface.addLunar3RunesBigBox(30290, 9075, 563, 565, 2, 2, 0, 30012, 30014, 91,
					"Heal Other", "Transfer up to 75% of hitpoints\\n to another player", TDA, 1205, 8,
					2);


			RSInterface.addLunar3RunesBigBox(30298, 9075, 560, 557, 2, 1, 9, 30009, 30006, 92,
					"Vengeance Other", "Allows another player to rebound\\ndamage to an opponent", TDA,
					1208, 8, 2);
			RSInterface.addLunar3RunesSmallBox(30306, 9075, 560, 557, 3, 1, 9, 30009, 30006, 93,
					"Vengeance", "Rebound damage to an opponent", TDA, 1209, 0, 5);
			RSInterface.addLunar3RunesBigBox(30314, 9075, 565, 563, 3, 2, 5, 30014, 30012, 94,
					"Heal Group", "Transfer up to 75% of hitpoints to a group", TDA, 1210, 0, 5);
			RSInterface.addLunar3RunesBigBox(30322, 9075, 564, 563, 2, 1, 0, 30013, 30012, 95,
					"Spellbook Swap", "Change to another spellbook for 1\\nspell cast", TDA, 1211, 0, 5);
		} else {

			RSInterface.addLunar3RunesSmallBox(30017, 9075, 554, 555, 0, 4, 3, 30003, 30004, 64, "Bake Pie", "Bake pies without a stove", TDA, 0, 16, 2);
			RSInterface.addLunar2RunesSmallBox(30025, 9075, 557, 0, 7, 30006, 65, "Cure Plant", "Cure disease on farming patch", TDA, 1, 4, 2);
			RSInterface.addLunar3RunesBigBox(30032, 9075, 564, 558, 0, 0, 0, 30013, 30007, 65, "Monster Examine", "Detect the combat statistics of a\\nmonster", TDA, 2, 2, 2);
			RSInterface.addLunar3RunesSmallBox(30040, 9075, 564, 556, 0, 0, 1, 30013, 30005, 66, "NPC Contact", "Speak with varied NPCs", TDA, 3, 0, 2);
			RSInterface.addLunar3RunesSmallBox(30048, 9075, 563, 557, 0, 0, 9, 30012, 30006, 67, "Cure Other", "Cure poisoned players", TDA, 4, 8, 2);
			RSInterface.addLunar3RunesSmallBox(30056, 9075, 555, 554, 0, 2, 0, 30004, 30003, 67, "Humidify", "fills certain vessels with water", TDA, 5, 0, 5);
			RSInterface.addLunar3RunesSmallBox(30064, 9075, 563, 557, 1, 0, 1, 30012, 30006, 68, "Teleports", "Teleports you to moonclan island", TDA, 6, 0, 5);
			RSInterface.addLunar3RunesBigBox(30075, 9075, 563, 557, 1, 0, 3, 30012, 30006, 69, "Teleports", "Teleports players to Moonclan\\nisland", TDA, 7, 0, 5);
			RSInterface.addLunar3RunesSmallBox(30083, 9075, 563, 557, 1, 0, 5, 30012, 30006, 70, "Teleports", "Teleports you to ourania rune altar", TDA, 8, 0, 5);
			RSInterface.addLunar3RunesSmallBox(30091, 9075, 564, 563, 1, 1, 0, 30013, 30012, 70, "Cure Me", "Cures Poison", TDA, 9, 0, 5);
			RSInterface.addLunar2RunesSmallBox(30099, 9075, 557, 1, 1, 30006, 70, "Hunter Kit", "Get a kit of hunting gear", TDA, 10, 0, 5);
			RSInterface.addLunar3RunesSmallBox(30106, 9075, 563, 555, 1, 0, 0, 30012, 30004, 71, "Teleports", "Teleports you to Waterbirth island", TDA, 11, 0, 5);
			RSInterface.addLunar3RunesBigBox(30114, 9075, 563, 555, 1, 0, 4, 30012, 30004, 72, "Teleports", "Teleports players to Waterbirth\\nisland", TDA, 12, 0, 5);
			RSInterface.addLunar3RunesSmallBox(30122, 9075, 564, 563, 1, 1, 1, 30013, 30012, 73,
					"Cure Group", "Cures Poison on players", TDA, 13, 0, 5);
			RSInterface.addLunar3RunesBigBox(30130, 9075, 564, 559, 1, 1, 4, 30013, 30008, 74, "Stat Spy", "Cast on another player to see their\\nskill levels", TDA, 14, 8, 2);
			RSInterface.addLunar3RunesBigBox(30138, 9075, 563, 554, 1, 1, 2, 30012, 30003, 74,
					"Teleports", "Teleports you to the Barbarian\\noutpost", TDA, 15, 0, 5);
			RSInterface.addLunar3RunesBigBox(30146, 9075, 563, 554, 1, 1, 5, 30012, 30003, 75,
					"Tele Group Barbarian", "Teleports players to the Barbarian\\noutpost", TDA, 16, 0, 5);
			RSInterface.addLunar3RunesSmallBox(30154, 9075, 554, 556, 1, 5, 9, 30003, 30005, 76,
					"Superglass Make", "Make glass without a furnace", TDA, 17, 16, 2);
			RSInterface.addLunar3RunesSmallBox(30162, 9075, 563, 555, 1, 1, 3, 30012, 30004, 77, "Teleports", "Teleports you to Port khazard", TDA, 18, 0, 5);
			RSInterface.addLunar3RunesSmallBox(30170, 9075, 563, 555, 1, 1, 7, 30012, 30004, 78, "Teleports", "Teleports players to Port khazard", TDA, 19, 0, 5);
			RSInterface.addLunar3RunesBigBox(30178, 9075, 564, 559, 1, 0, 4, 30013, 30008, 78, "Dream", "Take a rest and restore hitpoints 3\\n times faster", TDA, 20, 0, 5);
			RSInterface.addLunar3RunesSmallBox(30186, 9075, 557, 555, 1, 9, 4, 30006, 30004, 79, "String Jewellery", "String amulets without wool", TDA, 21, 0, 5);
			RSInterface.addLunar3RunesLargeBox(30194, 9075, 557, 555, 1, 9, 9, 30006, 30004, 80, "Stat Restore Pot\\nShare", "Share a potion with up to 4 nearby\\nplayers", TDA, 22, 0, 5);
			RSInterface.addLunar3RunesSmallBox(30202, 9075, 554, 555, 1, 6, 6, 30003, 30004, 81, "Magic Imbue", "Combine runes without a talisman", TDA, 23, 0, 5);
			RSInterface.addLunar3RunesBigBox(30210, 9075, 561, 557, 2, 1, 14, 30010, 30006, 82, "Fertile Soil", "Fertilise a farming patch with super\\ncompost", TDA, 24, 4, 2);
			RSInterface.addLunar3RunesBigBox(30218, 9075, 557, 555, 2, 11, 9, 30006, 30004, 83, "Boost Potion Share", "Shares a potion with up to 4 nearby\\nplayers", TDA, 25, 0, 5);
			RSInterface.addLunar3RunesSmallBox(30226, 9075, 563, 555, 2, 2, 9, 30012, 30004, 84, "Fishing Guild Teleport", "Teleports you to the fishing guild", TDA, 26, 0, 5);
			RSInterface.addLunar3RunesLargeBox(30234, 9075, 563, 555, 1, 2, 13, 30012, 30004, 85, "Tele Group Fishing\\nGuild", "Teleports players to the Fishing\\nGuild", TDA, 27, 0,
					5);
			RSInterface.addLunar3RunesSmallBox(30242, 9075, 557, 561, 2, 14, 0, 30006, 30010, 85, "Plank Make", "Turn Logs into planks", TDA, 28, 16, 5);
			/******** Cut Off Limit **********/
			RSInterface.addLunar3RunesSmallBox(30250, 9075, 563, 555, 2, 2, 9, 30012, 30004, 86, "Catherby Teleport", "Teleports you to Catherby", TDA, 29, 0, 5);
			RSInterface.addLunar3RunesSmallBox(30258, 9075, 563, 555, 2, 2, 14, 30012, 30004, 87, "Tele Group Catherby", "Teleports players to Catherby", TDA, 30, 0, 5);
			RSInterface.addLunar3RunesSmallBox(30266, 9075, 563, 555, 2, 2, 7, 30012, 30004, 88, "Ice Plateau Teleport", "Teleports you to Ice Plateau", TDA, 31, 0, 5);
			RSInterface.addLunar3RunesBigBox(30274, 9075, 563, 555, 2, 2, 15, 30012, 30004, 89, "Tele Group Ice\\n Plateau", "Teleports players to Ice Plateau", TDA, 32, 0, 5);
			RSInterface.addLunar3RunesBigBox(30282, 9075, 563, 561, 2, 1, 0, 30012, 30010, 90, "Energy Transfer", "Spend hitpoints and SA Energy to\\n give another player hitpoints and run energy", TDA, 33, 8, 2);
			RSInterface.addLunar3RunesBigBox(30290, 9075, 563, 565, 2, 2, 0, 30012, 30014, 91, "Heal Other", "Transfer up to 75% of hitpoints\\n to another player", TDA, 34, 8, 2);
			RSInterface.addLunar3RunesBigBox(30298, 9075, 560, 557, 2, 1, 9, 30009, 30006, 92, "Vengeance Other", "Allows another player to rebound\\ndamage to an opponent", TDA, 35, 8, 2);
			RSInterface.addLunar3RunesSmallBox(30306, 9075, 560, 557, 3, 1, 9, 30009, 30006, 93, "Vengeance", "Rebound damage to an opponent", TDA, 36, 0, 5);
			RSInterface.addLunar3RunesBigBox(30314, 9075, 565, 563, 3, 2, 5, 30014, 30012, 94, "Heal Group", "Transfer up to 75% of hitpoints to a group", TDA, 37, 0, 5);
			RSInterface.addLunar3RunesBigBox(30322, 9075, 564, 563, 2, 1, 0, 30013, 30012, 95, "Spellbook Swap", "Change to another spellbook for 1\\nspell cast", TDA, 38, 0, 5);
		}
	}

	static void achievementRewards(TextDrawingArea[] TDA) {
		int interfaceId = 19302;
		int children = 0;
		int totalChildren = 36;
		int y1 = -20;
		RSInterface Interface = RSInterface.addInterface(interfaceId, 164, 351, 20, 323);
		RSInterface.setChildren(totalChildren, Interface);

		interfaceId++;
		RSInterface.addSprite(interfaceId, 573); // Background.
		RSInterface.setBounds(interfaceId, 160, 36 + y1, children, Interface);

		interfaceId++;
		children++;
		RSInterface.addText(interfaceId, "Rewards", TDA, 2, 0xffb000, true, true);
		RSInterface.setBounds(interfaceId, 243, 43 + y1, children, Interface);

		interfaceId++;
		children++;
		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 148, 149, 16,
				16, "Close Window");
		RSInterface.setBounds(interfaceId, 323, 43 + y1, children, Interface);
		children++;
		RSInterface.setBounds(interfaceId + 1, 323, 43 + y1, children, Interface);
		interfaceId++;
		interfaceId++;

		interfaceId++;
		children++;
		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 251, 252, 16,
				16, "Back");
		RSInterface.setBounds(interfaceId, 304, 43 + y1, children, Interface);
		children++;
		RSInterface.setBounds(interfaceId + 1, 304, 43 + y1, children, Interface);
		interfaceId++;
		interfaceId++;

		int x = 168;
		for (int index = 0; index < 4; index++) {
			interfaceId++;
			children++;
			RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 567, 568,
					44, 20, "Select");
			RSInterface.setSpriteClicked(interfaceId, 569);
			RSInterface.setBounds(interfaceId, x, 68 + y1, children, Interface);
			children++;
			RSInterface.setBounds(interfaceId + 1, x, 68 + y1, children, Interface);
			interfaceId++;
			interfaceId++;
			x += 43;
		}

		x = 189;
		String[] string = {"Easy", "Med", "Hard", "Elite"};
		for (int index = 0; index < 4; index++) {
			interfaceId++;
			children++;
			RSInterface.addText(interfaceId, string[index], TDA, 2, 0xffb000, true, true);
			RSInterface.setBounds(interfaceId, x, 51, children, Interface);
			x += 43;
		}

		int y = 92;
		for (int index = 0; index < 18; index++) {
			interfaceId++;
			children++;
			RSInterface.addText(interfaceId, "", TDA, 0, 0xffb000, false, true);
			RSInterface.setBounds(interfaceId, 173, y + y1, children, Interface);
			y += 13;
		}
	}

	static void achievementOpenedInterface(TextDrawingArea[] TDA) {
		int interfaceId = 22260;
		int children = 0;
		int totalChildren = 16;
		RSInterface Interface = RSInterface.addInterface(interfaceId, 17, 500, 19, 318);
		RSInterface.setChildren(totalChildren, Interface);

		interfaceId++;
		RSInterface.addSprite(interfaceId, 566); // Background.
		RSInterface.setBounds(interfaceId, 13, 14, children, Interface);

		interfaceId++;
		children++;
		RSInterface.addText(interfaceId, "Achievements", TDA, 2, 0xffb000, true, true);
		RSInterface.setBounds(interfaceId, 265, 21, children, Interface);

		// Progress bar text.
		interfaceId++;
		children++;
		RSInterface.addText(interfaceId, "", TDA, 1, 0xffffff, true, true);
		RSInterface.setBounds(interfaceId, 342, 280, children, Interface);

		// Points: text.
		interfaceId++;
		children++;
		RSInterface.addText(interfaceId, "", TDA, 1, 0xffb000, true, true);
		RSInterface.setBounds(interfaceId, 109, 273, children, Interface);

		// Easy Completed text.
		interfaceId++;
		children++;
		RSInterface.addText(interfaceId, "", TDA, 1, 0xffb000, true, true);
		RSInterface.setBounds(interfaceId, 107, 280, children, Interface);

		interfaceId++;
		children++;
		RSInterface.addHoverButtonLatest(interfaceId, interfaceId + 1, interfaceId + 2, 148, 149, 15,
				15, "Close Window");
		RSInterface.setBounds(interfaceId, 473, 21, children, Interface);
		children++;
		RSInterface.setBounds(interfaceId + 1, 473, 21, children, Interface);
		interfaceId++;
		interfaceId++;

		for (int index = 0; index < 4; index++) {
			// It contained easy/med/hard/elite buttons.
			interfaceId++;
			interfaceId++;
			interfaceId++;
		}

		interfaceId++; // leave, this had the Easy/Med/Hard/Elite text.

		// Achievement title on the right.
		interfaceId++;
		children++;
		RSInterface.addText(interfaceId, "", TDA, 2, 0xffb000, true, true);
		RSInterface.setBounds(interfaceId, 345, 55, children, Interface);

		interfaceId++;
		children++;
		RSInterface.addText(interfaceId, "Description", TDA, 1, 0xffb000, true, true);
		RSInterface.setBounds(interfaceId, 345, 55, children, Interface);

		// Description sub text.
		int y1 = 78;
		for (int index = 0; index < 3; index++) {
			interfaceId++;
			children++;
			RSInterface.addText(interfaceId, "", TDA, 0, 0xffffff, true, true);
			RSInterface.setBounds(interfaceId, 345, y1, children, Interface);
			y1 += 13;
		}

		interfaceId++;
		children++;
		RSInterface.addText(interfaceId, "Rewards", TDA, 1, 0xffb000, true, true);
		RSInterface.setBounds(interfaceId, 345, 120, children, Interface);

		// Requirements sub text.
		for (int index = 0; index < 2; index++) {
			interfaceId++;
		}

		// Rewards button.
		interfaceId++;
		interfaceId++;

		interfaceId++;
		children++;
		RSInterface.addText(interfaceId, "", TDA, 0, 0xffffff, true, true);
		RSInterface.setBounds(interfaceId, 345, 145, children, Interface);

		interfaceId++;
		children++;
		RSInterface.itemGroup(interfaceId, 4, 3, 13, 0);
		RSInterface.setBounds(interfaceId, 265, 163, children, Interface);

		interfaceId++;
		children++;
		RSInterface scrollTab1 = RSInterface.addInterface(interfaceId);
		RSInterface.setBounds(interfaceId, 25, 49, children, Interface); // scrollTab1
		scrollTab1.width = 150;
		scrollTab1.height = 219;
		scrollTab1.scrollMax = 900;

		// Achievement title on the scroll.
		scrollTab1.totalChildren(70);
		int y = 5;
		for (int i = 0; i < 70; i++) {
			interfaceId++;
			RSInterface.addText(interfaceId, "", TDA, 0, 0xff0000, false, false, 0xffffff, "Select",
					150);
			RSInterface.textClicked(interfaceId, 570, 1, 2);
			scrollTab1.child(i, interfaceId, 0, y);
			y += 15;
		}
	}

	static void profileInterface(TextDrawingArea[] tda) {
		RSInterface Interface = RSInterface.addInterface(25320, 12, 508, 13, 329);
		RSInterface.addSprite(25321, 327); // Background.

		RSInterface.addHoverButton(25322, 148, 16, 16, "Close Window", -1, 25323, 1); // Close
		// button.
		RSInterface.addHoveredButton(25323, 149, 16, 16, 25324); // Close button
		// hover.
		RSInterface.addText(25325, "Profile of", tda, 2, 0xffb000, false, true); // Profile
		// of
		// Mgt
		// Madness.
		RSInterface.addText(25326, "Search", tda, 0, 0xffb000, true, true); // Search
		// text.
		RSInterface.addHoverButton(25327, 409, 106, 20, "Search", -1, 25328, 1); // Search
		// button.
		RSInterface.addHoveredButton(25328, 328, 106, 20, 25329); // Search
		// button
		// hover.
		RSInterface.addSprite(25330, 330); // Left image.
		RSInterface.addSprite(25331, 330); // Right image.

		RSInterface.setChildren(50, Interface);
		int x = -3;
		int y = -3;
		RSInterface.setBounds(25321, 10 + x, 12 + y, 0, Interface); // Background.
		RSInterface.setBounds(25322, 481 + x, 21 + y, 1, Interface); // Close
		// button.
		RSInterface.setBounds(25323, 481 + x, 21 + y, 2, Interface); // Close
		// button
		// hover.
		RSInterface.setBounds(25325, 193 + x, 21 + y, 3, Interface); // Profile
		// of
		// Mgt
		// Madness.
		RSInterface.setBounds(25327, 398 + x, 48 + y, 4, Interface); // Search
		// button.
		RSInterface.setBounds(25328, 395 + x, 45 + y, 5, Interface); // Search
		// button
		// hover.
		RSInterface.setBounds(25326, 448 + x, 50 + y, 6, Interface); // Search
		// text.
		RSInterface.setBounds(25330, 21 + x, 73 + y, 7, Interface); // Left
		// image
		RSInterface.setBounds(25331, 261 + x, 73 + y, 8, Interface); // Right
		// image
		int index = 0;
		int interfaceId = 25332;
		int children = 9;
		int x1 = 0;
		String tabs[] = {"Info", "Pking", "Skilling", "Pvm", "Misc"};
		// setChildren(19, Interface); Is declared before any setBounds are
		// called.
		// And remember that the order of setBounds has to be in order, look
		// above, 0 to 3 is above this for loop, because this for loop starts at
		// 4.
		for (int i = 0; i < 5; i++) {
			RSInterface.addHoverButton(interfaceId + index, 350, 75, 20, "Toggle", -1,
					(interfaceId + index) + 1, 1);
			RSInterface.setBounds(interfaceId + index, 16 + x1 + x, 45 + y, children, Interface); // Info
			// button.
			RSInterface.setSpriteClicked(interfaceId + index, 397);
			index++;
			children++;

			RSInterface.addHoveredButton(interfaceId + index, 351, 75, 20, (interfaceId + index) + 1);
			RSInterface.setBounds(interfaceId + index, 16 + x1 + x, 45 + y, children, Interface); // Info
			// button
			// hover.
			index += 2;
			children++;
			RSInterface.addText(interfaceId + index, tabs[i], tda, 2, 0xffff01, true, true);
			RSInterface.setBounds(interfaceId + index, 54 + x1 + x, 48 + y, children, Interface); // Info
			// text.
			index++;
			children++;
			x1 += 75;
		}

		RSInterface.addText(25369, "", tda, 1, 0xffff01, true, true);
		RSInterface.setBounds(25369, 164 + x, 194 + y, 24, Interface);
		RSInterface.addText(25370, "", tda, 1, 0xffff01, true, true);
		RSInterface.setBounds(25370, 350 + x, 194 + y, 25, Interface);

		RSInterface.addText(25353, "", tda, 1, 0xffb000, false, true);
		RSInterface.setBounds(25353, 27 + x, 77 + y, 26, Interface);
		RSInterface.addText(25354, "", tda, 1, 0xffb000, false, true);
		RSInterface.setBounds(25354, 27 + x, 95 + y, 27, Interface);
		RSInterface.addText(25355, "", tda, 1, 0xffb000, false, true);
		RSInterface.setBounds(25355, 27 + x, 113 + y, 28, Interface);
		RSInterface.addText(25356, "", tda, 1, 0xffb000, false, true);
		RSInterface.setBounds(25356, 27 + x, 131 + y, 29, Interface);
		RSInterface.addText(25357, "", tda, 1, 0xffb000, false, true);
		RSInterface.setBounds(25357, 27 + x, 149 + y, 30, Interface);

		RSInterface.addText(25358, "Bio (name, country, age, hobbies):", tda, 1, 0xffb000, false,
				true);
		RSInterface.setBounds(25358, 267 + x, 77 + y, 31, Interface);
		RSInterface.addText(25359, "", tda, 1, 0xffb000, false, true, 0xffffff, "Change", 226);
		RSInterface.setBounds(25359, 267 + x, 95 + y, 32, Interface);
		RSInterface.addText(25360, "", tda, 1, 0xffb000, false, true, 0xffffff, "Change", 226);
		RSInterface.setBounds(25360, 267 + x, 113 + y, 33, Interface);
		RSInterface.addText(25361, "", tda, 1, 0xffb000, false, true, 0xffffff, "Change", 226);
		RSInterface.setBounds(25361, 267 + x, 131 + y, 34, Interface);
		RSInterface.addText(25362, "", tda, 1, 0xffb000, false, true, 0xffffff, "Change", 226);
		RSInterface.setBounds(25362, 267 + x, 149 + y, 35, Interface);

		RSInterface.addSprite(25363, 329); // Left image
		RSInterface.setBounds(25363, 110 + x, 189 + y, 36, Interface);

		RSInterface.addSprite(25364, 329); // Right image
		RSInterface.setBounds(25364, 300 + x, 189 + y, 37, Interface);

		RSInterface.addText(25365, "Player killing rank", tda, 1, 0xffff01, true, true);
		RSInterface.setBounds(25365, 164 + x, 192 + y, 38, Interface);
		RSInterface.addText(25366, "Adventurer rank", tda, 1, 0xffff01, true, true);
		RSInterface.setBounds(25366, 355 + x, 192 + y, 39, Interface);

		RSInterface.addText(25367, "", tda, 1, 0xffff01, true, true);
		RSInterface.setBounds(25367, 164 + x, 217 + y, 40, Interface);
		RSInterface.addText(25368, "", tda, 1, 0xffff01, true, true);
		RSInterface.setBounds(25368, 355 + x, 217 + y, 41, Interface);

		RSInterface.addText(25371, "", tda, 1, 0xffb000, false, true); // Gameplay
		// type:
		RSInterface.setBounds(25371, 27 + x, 167 + y, 42, Interface);

		RSInterface.addText(25373, "", tda, 1, 0xffb000, false, true, 0xffffff, "Change", 226);
		RSInterface.setBounds(25373, 267 + x, 167 + y, 43, Interface);
		//

		RSInterface.addToItemGroup(25374, 1205, 1, 1, 24, 24, false, null, null, null, false, false);
		RSInterface.setBounds(25374, 150 + x, 238 + y, 44, Interface);

		RSInterface.addToItemGroup(25375, 1117, 1, 1, 24, 24, false, null, null, null, false, false);
		RSInterface.setBounds(25375, 123 + x, 277 + y, 45, Interface);

		RSInterface.addToItemGroup(25376, 1075, 1, 1, 24, 24, false, null, null, null, false, false);
		RSInterface.setBounds(25376, 175 + x, 277 + y, 46, Interface);
		//

		RSInterface.addToItemGroup(25377, 1205, 1, 1, 24, 24, false, null, null, null, false, false);
		RSInterface.setBounds(25377, 340 + x, 238 + y, 47, Interface);

		RSInterface.addToItemGroup(25378, 1117, 1, 1, 24, 24, false, null, null, null, false, false);
		RSInterface.setBounds(25378, 313 + x, 277 + y, 48, Interface);

		RSInterface.addToItemGroup(25379, 1075, 1, 1, 24, 24, false, null, null, null, false, false);
		RSInterface.setBounds(25379, 365 + x, 277 + y, 49, Interface);
	}

	static void profileInterface1(TextDrawingArea[] tda) {
		RSInterface Interface = RSInterface.addInterface(25380, 12, 508, 13, 329);
		RSInterface.setChildren(50, Interface);
		int x = -3;
		int y = -3;
		RSInterface.setBounds(25321, 10 + x, 12 + y, 0, Interface); // Background.
		RSInterface.setBounds(25322, 481 + x, 21 + y, 1, Interface); // Close
		// button.
		RSInterface.setBounds(25323, 481 + x, 21 + y, 2, Interface); // Close
		// button
		// hover.
		RSInterface.setBounds(25325, 193 + x, 21 + y, 3, Interface); // Profile
		// of
		// Mgt
		// Madness.
		RSInterface.setBounds(25327, 398 + x, 48 + y, 4, Interface); // Search
		// button.
		RSInterface.setBounds(25328, 395 + x, 45 + y, 5, Interface); // Search
		// button
		// hover.
		RSInterface.setBounds(25326, 448 + x, 50 + y, 6, Interface); // Search
		// text.
		RSInterface.addSprite(25548, 331); // Left image
		RSInterface.addSprite(25549, 331); // Right image
		RSInterface.setBounds(25548, 36 + x, 83 + y, 7, Interface); // Left
		// image
		RSInterface.setBounds(25549, 267 + x, 83 + y, 8, Interface); // Right
		// image
		int index = 0;
		int interfaceId = 25332;
		int children = 9;
		int x1 = 0;
		// setChildren(19, Interface); Is declared before any setBounds are
		// called.
		// And remember that the order of setBounds has to be in order, look
		// above, 0 to 3 is above this for loop, because this for loop starts at
		// 4.
		for (int i = 0; i < 5; i++) {
			RSInterface.setBounds(interfaceId + index, 16 + x1 + x, 45 + y, children, Interface); // Info
			// button.
			index++;
			children++;

			RSInterface.setBounds(interfaceId + index, 16 + x1 + x, 45 + y, children, Interface); // Info
			// button
			// hover.
			index += 2;
			children++;

			RSInterface.setBounds(interfaceId + index, 54 + x1 + x, 48 + y, children, Interface); // Info
			// text.
			index++;
			children++;
			x1 += 75;
		}
		interfaceId = 25550;
		int yBase = 87;
		y = yBase;
		for (int i = 0; i < 23; i++) {

			RSInterface.addText(interfaceId, "Profile", tda, 1, 0xffb000, false, true);
			RSInterface.setBounds(interfaceId, x + 46, y, children, Interface);
			children++;
			interfaceId++;
			y += 20;
			if (i > 10) {
				y -= 4;
			}
			if (i == 10) {
				x += 232;
				y = yBase;
			}
		}
		RSInterface.addHoverButton(25578, 338, 90, 20, "Open", -1, 25579, 1);
		RSInterface.setBounds(25578, 326, 282, 47, Interface);

		RSInterface.addHoveredButton(25579, 339, 90, 20, 25580);
		RSInterface.setBounds(25579, 326, 282, 48, Interface);

		RSInterface.addText(25581, "Weapon stats", tda, 1, 0xffff01, true);
		RSInterface.setBounds(25581, 371, 284, 49, Interface);
	}

	static void profileInterface2(TextDrawingArea[] tda) {
		RSInterface Interface = RSInterface.addInterface(25590, 12, 508, 13, 329);

		RSInterface.setChildren(116, Interface);
		int x = -3;
		int y = -3;
		RSInterface.setBounds(25321, 10 + x, 12 + y, 0, Interface); // Background.
		RSInterface.setBounds(25322, 481 + x, 21 + y, 1, Interface); // Close
		// button.
		RSInterface.setBounds(25323, 481 + x, 21 + y, 2, Interface); // Close
		// button
		// hover.
		RSInterface.setBounds(25325, 193 + x, 21 + y, 3, Interface); // Profile
		// of
		// Mgt
		// Madness.
		RSInterface.setBounds(25327, 398 + x, 48 + y, 4, Interface); // Search
		// button.
		RSInterface.setBounds(25328, 395 + x, 45 + y, 5, Interface); // Search
		// button
		// hover.
		RSInterface.setBounds(25326, 448 + x, 50 + y, 6, Interface); // Search
		// text.
		RSInterface.addSprite(25591, 332); // Left image
		RSInterface.setBounds(25591, 22 + x, 73 + y, 7, Interface); // Left
		// image
		RSInterface.addSprite(25592, 334); // Right image
		RSInterface.setBounds(25592, 342 + x, 73 + y, 8, Interface); // Right
		// image
		RSInterface.addSprite(25593, 334); // Right image
		RSInterface.setBounds(25593, 183 + x, 73 + y, 9, Interface); // Right
		// image
		RSInterface.addSprite(25594, 333); // Total level image background.
		RSInterface.setBounds(25594, 22 + x, 291 + y, 10, Interface);

		int index = 0;
		int interfaceId = 25332;
		int children = 11;
		int x1 = 0;
		String tabs[] = {"Info", "Pking", "Skilling", "Pvm", "Misc"};
		// setChildren(19, Interface); Is declared before any setBounds are
		// called.
		// And remember that the order of setBounds has to be in order, look
		// above, 0 to 3 is above this for loop, because this for loop starts at
		// 4.
		for (int i = 0; i < 5; i++) {
			RSInterface.setBounds(interfaceId + index, 16 + x1 + x, 45 + y, children, Interface); // Info
			// button.
			index++;
			children++;

			RSInterface.setBounds(interfaceId + index, 16 + x1 + x, 45 + y, children, Interface); // Info
			// button
			// hover.
			index += 2;
			children++;

			RSInterface.addText(interfaceId + index, tabs[i], tda, 2, 0xffff01, true, true);
			RSInterface.setBounds(interfaceId + index, 54 + x1 + x, 48 + y, children, Interface); // Info
			// text.
			index++;
			children++;
			x1 += 75;
		}
		interfaceId = 25600;
		int yBase = 77;
		x = 25;
		y = yBase;
		for (int i = 0; i < 22; i++) {

			if (i == 21) {
				x = 20;
				y += 6;
			}

			RSInterface.addHoverButton(interfaceId, spriteNamesOrdered[i] + (320), i == 21 ? 155 : 40,
					23, "Open", -1, interfaceId + 1, 1);
			RSInterface.setBounds(interfaceId, x, y, children, Interface);
			interfaceId++;
			children++;

			RSInterface.addHoveredButton(interfaceId, spriteNamesOrdered[i] + (320),
					i == 21 ? 155 : 40, 23, interfaceId + 1);
			RSInterface.setBounds(interfaceId, x, y, children, Interface);
			RSInterface.interfaceCache[interfaceId + 1].toolTipSpecialX = i == 21 ? x + 2 : x - 21;
			RSInterface.interfaceCache[interfaceId + 1].toolTipSpecialY = y - 25;
			children++;
			interfaceId += 2;

			RSInterface.addText(interfaceId, "", tda, i == 21 ? 2 : 0, 0xffff01, true, true);
			RSInterface.setBounds(interfaceId, i == 21 ? x + (77) : x + 32, i == 21 ? y + 2 : y + 7,
					children, Interface);
			children++;
			interfaceId++;

			y += 30;
			if (i == 6 || i == 13) {
				x += 52;
				y = yBase;
			}
		}

		yBase = 77;
		x = 145;
		y = yBase;
		for (int i = 0; i < 24; i++) {

			RSInterface.addText(interfaceId, "", tda, 1, 0xffb000, false, true);
			RSInterface.setBounds(interfaceId, x + 46, y, children, Interface);
			children++;
			interfaceId++;
			y += 20;
			if (i == 11) {
				x += 158;
				y = yBase;
			}
		}

	}

	static void profileInterface3(TextDrawingArea[] tda) {
		RSInterface Interface = RSInterface.addInterface(25740, 12, 508, 13, 329);
		RSInterface scrollTab1 = RSInterface.addInterface(25741);
		RSInterface scrollTab2 = RSInterface.addInterface(25742);

		RSInterface.setChildren(28, Interface);
		int x = -3;
		int y = -3;
		RSInterface.setBounds(25321, 10 + x, 12 + y, 0, Interface); // Background.
		RSInterface.setBounds(25322, 481 + x, 21 + y, 1, Interface); // Close
		// button.
		RSInterface.setBounds(25323, 481 + x, 21 + y, 2, Interface); // Close
		// button
		// hover.
		RSInterface.setBounds(25325, 193 + x, 21 + y, 3, Interface); // Profile
		// of
		// Mgt
		// Madness.
		RSInterface.setBounds(25327, 398 + x, 48 + y, 4, Interface); // Search
		// button.
		RSInterface.setBounds(25328, 395 + x, 45 + y, 5, Interface); // Search
		// button
		// hover.
		RSInterface.setBounds(25326, 448 + x, 50 + y, 6, Interface); // Search
		// text.

		int index = 0;
		int interfaceId = 25332;
		int children = 7;
		int x1 = 0;
		for (int i = 0; i < 5; i++) {
			RSInterface.setBounds(interfaceId + index, 16 + x1 + x, 45 + y, children, Interface); // Info
			// button.
			index++;
			children++;

			RSInterface.setBounds(interfaceId + index, 16 + x1 + x, 45 + y, children, Interface); // Info
			// button
			// hover.
			index += 2;
			children++;

			RSInterface.setBounds(interfaceId + index, 54 + x1 + x, 48 + y, children, Interface); // Info
			// text.
			index++;
			children++;
			x1 += 75;
		}

		int yScroll = -10;
		RSInterface.addSprite(25743, 335); // Left image
		RSInterface.setBounds(25743, 36 + x, 93 + y + yScroll, 22, Interface); // Left
		// image
		RSInterface.addSprite(25744, 335); // Right image
		RSInterface.setBounds(25744, 267 + x, 93 + y + yScroll, 23, Interface); // Right
		// image
		RSInterface.addText(25745, "Npc kills: 6200, Boss kills: 66", tda, 1, 0xffb000, true, true);
		RSInterface.setBounds(25745, 140, 93 + yScroll, 24, Interface);

		RSInterface.addText(25746, "", tda, 1, 0xffb000, true, true);
		RSInterface.setBounds(25746, 371, 93 + yScroll, 25, Interface);

		RSInterface.setBounds(25741, 62, 115 + yScroll, 26, Interface); // scrollTab1
		RSInterface.setBounds(25742, 270, 115 + yScroll, 27, Interface); // scrollTab2

		scrollTab1.totalChildren(100);
		int interfaceId1 = 25755;
		y = 5;
		for (int i = 0; i < 100; i++) {
			RSInterface.addText(interfaceId1 + i, "", tda, 0, 0xffb000, true, true);
			scrollTab1.child(i, interfaceId1 + i, 75, y);
			y += 15;

		}
		scrollTab1.width = 168;
		scrollTab1.height = 199;
		scrollTab1.scrollMax = 1512;

		scrollTab2.totalChildren(100);
		interfaceId1 = 25755 + 100;
		y = 5;
		for (int i = 0; i < 100; i++) {
			RSInterface.addText(interfaceId1 + i, "", tda, 0, 0xffb000, true, true);
			scrollTab2.child(i, interfaceId1 + i, 92, y);
			y += 15;

		}
		scrollTab2.width = 188;
		scrollTab2.height = 199;
		scrollTab2.scrollMax = 1512;
	}

	static void profileInterface4(TextDrawingArea[] tda) {
		RSInterface Interface = RSInterface.addInterface(22052, 12, 508, 13, 329);
		RSInterface.setChildren(45, Interface);
		int x = -3;
		int y = -3;
		RSInterface.setBounds(25321, 10 + x, 12 + y, 0, Interface); // Background.
		RSInterface.setBounds(25322, 481 + x, 21 + y, 1, Interface); // Close
		// button.
		RSInterface.setBounds(25323, 481 + x, 21 + y, 2, Interface); // Close
		// button
		// hover.
		RSInterface.setBounds(25325, 193 + x, 21 + y, 3, Interface); // Profile
		// of
		// Mgt
		// Madness.
		RSInterface.setBounds(25327, 398 + x, 48 + y, 4, Interface); // Search
		// button.
		RSInterface.setBounds(25328, 395 + x, 45 + y, 5, Interface); // Search
		// button
		// hover.
		RSInterface.setBounds(25326, 448 + x, 50 + y, 6, Interface); // Search
		// text.
		RSInterface.setBounds(25548, 36 + x, 83 + y, 7, Interface); // Left
		// image
		RSInterface.setBounds(25549, 267 + x, 83 + y, 8, Interface); // Right
		// image
		int index = 0;
		int interfaceId = 25332;
		int children = 9;
		int x1 = 0;
		// setChildren(19, Interface); Is declared before any setBounds are
		// called.
		// And remember that the order of setBounds has to be in order, look
		// above, 0 to 3 is above this for loop, because this for loop starts at
		// 4.
		for (int i = 0; i < 5; i++) {
			RSInterface.setBounds(interfaceId + index, 16 + x1 + x, 45 + y, children, Interface); // Info
			// button.
			index++;
			children++;

			RSInterface.setBounds(interfaceId + index, 16 + x1 + x, 45 + y, children, Interface); // Info
			// button
			// hover.
			index += 2;
			children++;

			RSInterface.setBounds(interfaceId + index, 54 + x1 + x, 48 + y, children, Interface); // Info
			// text.
			index++;
			children++;
			x1 += 75;
		}
		interfaceId = 25550;
		int yBase = 87;
		y = yBase;
		for (int i = 0; i < 21; i++) {

			RSInterface.setBounds(interfaceId, x + 46, y, children, Interface);
			children++;
			interfaceId++;
			y += 20;
			if (i == 10) {
				x += 232;
				y = yBase;
			}
		}
	}

	/*
	 * private static void keyBinding(Runecessor.TextDrawingArea[] tda) { RSInterface tab =
	 * RSInterface.addInterface(39300); RSInterface.addSprite(39301, 697);
	 * RSInterface.addHoverButton(39302, 252, 21, 21, "Close", 250, 39303, 3);
	 * RSInterface.addHoveredButton(39303, 253, 21, 21, 39304); int startingLine = 39305; for (int
	 * index = 0; index < 14; index++) { //RSInterface.addDropdownMenu(startingLine, 85, -1, false,
	 * false, 7, "None", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "F10", "F11", "F12",
	 * "ESC"); startingLine++; } RSInterface.addHoverButton(39319, 247, 117, 35,
	 * "Restore default value", -1, 39320, 1); RSInterface.addHoveredButton(39320, 246, 117, 35,
	 * 39321); RSInterface.addText(39322, "Default values", tda, 2, 0xFF9900, true, true);
	 * RSInterface.addConfigButton(39323, 39300, 235, 234, 15, 15,
	 * "Toggle 'esc' button closing interface", 0, 1, 594); tab.totalChildren(21); tab.child(0,
	 * 39301, 5, 15); tab.child(1, 39302, 477, 23); tab.child(2, 39303, 477, 23); tab.child(3, 39309,
	 * 70, 237); tab.child(4, 39308, 70, 194); tab.child(5, 39307, 70, 151); tab.child(6, 39306, 70,
	 * 108); tab.child(7, 39319, 360, 267); tab.child(8, 39320, 360, 267); tab.child(9, 39322, 417,
	 * 275); tab.child(10, 39323, 35, 283); tab.child(11, 39305, 70, 65); tab.child(12, 39314, 230,
	 * 237); tab.child(13, 39313, 230, 194); tab.child(14, 39312, 230, 151); tab.child(15, 39311,
	 * 230, 108); tab.child(16, 39310, 230, 65); tab.child(17, 39315, 390, 194); tab.child(18, 39316,
	 * 390, 151); tab.child(19, 39317, 390, 108); tab.child(20, 39318, 390, 65); }
	 */

	public static void colourChanger(TextDrawingArea[] tda) {
		RSInterface rsi = RSInterface.addTabInterface(26500);// 56700
		// Added comments for original ids, so its easier to modify the other
		// code in the client / settings classes
		RSInterface.addSprite(26501, 954);// 56701
		RSInterface.addText(26502, "Colour Changer", tda, 2, 0xE1981F, true, true);// 56702
		RSInterface.addHoverButton(26503, 148, 16, 16, "Close", 250, 26504, 3);// 56703
		RSInterface.addHoveredButton(26504, 149, 16, 16, 26505);// 56704, 56705
		RSInterface.addText(26506, "Private message", tda, 0, 0xff9933, false, true);// 56706
		RSInterface.addText(26507, "Player title", tda, 0, 0xff9933, false, true);// 56707
		RSInterface.addText(26508, "Yell", tda, 0, 0xff9933, false, true);// 56708
		RSInterface.addText(26509, "Fog", tda, 0, 0xff9933, false, true);// 56709

		RSInterface.addColorBox(26510, 0xff0000, 178, 40, true);// 56710
		RSInterface.addColorBox(26511, 0xff0000, 12, 12, false);// 56711
		RSInterface.addColorBox(26512, 0xff0000, 12, 12, false);// 56712
		RSInterface.addColorBox(26513, 0xff0000, 12, 12, false);// 56713
		RSInterface.addColorBox(26514, 0xff0000, 12, 12, false);// 56714
		RSInterface.addHDButton(26515, 955, "Select");// 56715
		RSInterface.interfaceCache[26515].atActionType = 10;// 56715
		RSInterface.addButton(26516, 956, "Select");// 56716
		RSInterface.interfaceCache[26516].atActionType = 10;// 56716
		RSInterface.addSprite(26517, 961);// 56717
		RSInterface.addColorBox(26518, 0xff0000, 133, 133, false);// 56718
		RSInterface.addText(26519, "Hello, this is a preview.", tda, 0, 0xFFFFFF, true, true);// 56719
		RSInterface.addHoverButton(26550, 958, 192, 23, "Select private message colour", -1, 26551,
				1);// 56750
		RSInterface.addHoveredButton(26551, 957, 192, 23, 26552);// 56751, 56752
		RSInterface.addHoverButton(26553, 958, 192, 23, "Select player title colour", -1, 26554, 1);// 56753,
		// 56754
		RSInterface.addHoveredButton(26554, 957, 192, 23, 26555);// 56754, 56755
		RSInterface.addHoverButton(26556, 958, 192, 23, "Select yell colour", -1, 26557, 1);// 56756,
		// 56757
		RSInterface.addHoveredButton(26557, 957, 192, 23, 26558);// 56757, 56758
		RSInterface.addHoverButton(26559, 958, 192, 23, "Select fog colour", -1, 26560, 1);// 56759,
		// 56760
		RSInterface.addHoveredButton(26560, 957, 192, 23, 26561);// 56760, 56761
		RSInterface.addConfigButton(26562, 26500, 958, 960, 0, 0, "", 0, 5, 836);// 56762,
		// 56700

		//
		// RSInterface.addConfigButton(ID, pID, spriteId1, spriteId2, width,
		// height, tT, configID, aT, configFrame);
		//

		RSInterface.addHoverButton(26563, 958, 74, 26, "Reset to default", -1, 26564, 1);// 56763
		RSInterface.addHoveredButton(26564, 959, 74, 26, 26565);// 56764, 56765
		RSInterface.addHoverButton(26566, 958, 74, 26, "Confirm", -1, 26567, 1);// 56766,
		// 56767
		RSInterface.addHoveredButton(26567, 959, 74, 26, 26568);// 56767, 56768
		RSInterface.addText(26569, "Default", tda, 0, 0xff9933, true, true);// 56769
		RSInterface.addText(26570, "Confirm", tda, 0, 0xff9933, true, true);// 56770

		rsi.totalChildren(33);
		rsi.child(0, 26501, 34, 50);
		rsi.child(1, 26502, 255, 53);
		rsi.child(2, 26503, 450, 54);
		rsi.child(3, 26504, 450, 54);
		rsi.child(4, 26550, 253, 98);
		rsi.child(5, 26551, 253, 98);
		rsi.child(6, 26553, 253, 130);
		rsi.child(7, 26554, 253, 130);
		rsi.child(8, 26556, 253, 162);
		rsi.child(9, 26557, 253, 162);
		rsi.child(10, 26559, 253, 193);
		rsi.child(11, 26560, 253, 193);
		rsi.child(12, 26506, 260, 104);
		rsi.child(13, 26507, 260, 135);
		rsi.child(14, 26508, 260, 168);
		rsi.child(15, 26509, 260, 200);
		rsi.child(16, 26510, 168, 248);
		rsi.child(17, 26511, 423, 103);
		rsi.child(18, 26518, 58, 90);
		rsi.child(19, 26512, 423, 135);
		rsi.child(20, 26513, 423, 167);
		rsi.child(21, 26514, 423, 198);
		rsi.child(22, 26515, 58, 90);
		rsi.child(23, 26516, 198, 90);
		rsi.child(24, 26517, 196, 89);
		rsi.child(25, 26562, 172, 254);
		rsi.child(26, 26519, 257, 262);
		rsi.child(27, 26563, 66, 254);
		rsi.child(28, 26564, 66, 254);
		rsi.child(29, 26566, 374, 254);
		rsi.child(30, 26567, 374, 254);
		rsi.child(31, 26569, 102, 262);
		rsi.child(32, 26570, 409, 262);

		RSInterface privateMessage = RSInterface.addTabInterface(26610);// 56720
		privateMessage.totalChildren(1);
		privateMessage.child(0, 26601, 0, 0);

		RSInterface title = RSInterface.addTabInterface(26611);
		title.totalChildren(1);
		title.child(0, 26601, 0, 0);

		RSInterface yell = RSInterface.addTabInterface(26612);
		yell.totalChildren(1);
		yell.child(0, 26601, 0, 0);

		RSInterface fog = RSInterface.addTabInterface(26613);
		fog.totalChildren(1);
		fog.child(0, 26601, 0, 0);
	}

}
