package Runecessor;

public class MiniMap {



	/**
	 * Map icon locations to remove. Cannot remove trees.
	 */
	private final static int[][] mapIconLocationsRemoved = {
		//@formatter:off.
			{3080, 3509},
			{3090, 3504},
			{3096, 3504},
			{3094, 3494},
			{3096, 3511},
			{3077, 3489},
			{3077, 3496},
			{3095, 3515},
			{3114, 3516},
			{3109, 3516},
			{3092, 3491},
			{3095, 3492},
			{3084, 3502},
			{3203, 3437}, //old varrock staff shop fix
			{3092, 3488}, // Poll booth icon inside Edgeville bank
			{2545, 2716},
			{2542, 2701},
			//removed
			{2742, 3554},
			{2741, 3562},
			//@formatter:on.
	};

	/**
	 * Custom icon locations.
	 */
	private final static int[][] customMapIconLocations = {
			
			{10, 2978, 3233},
			{0, 3080, 3510},
			{51, 3079, 3494},
			{26, 3086, 3500},
			{38, 3089, 3490},
			{64, 3093, 3488},
			{76, 3085, 3506},
			// 2020 EASTER EVENT
			{57, 3081, 3485},
			{74, 3078, 3488},
			{5, 3096, 3497},
			{12, 3076, 3485},
			{12, 3079, 3482},
			// END 2020 EASTER EVENT
			{56, 3089, 3495}, // Transportation icon
			{73, 3093, 3492}, // Membership bond icon
			{72, 3078, 3506}, // Ironman icon
			{75, 3092, 3497}, // Wise old man Icon
			/* ICON DEFS
			0 - General Store
			1 - Weapons Store
			2 - Runes Store
			3 - Battle Axe Store
			4 - Helmet Store
			5 - Bank
			6 - Quest
			7 - 
			
			19 - Altar
			20 - Herblore 
			21 - Jewlrey Store
			
			26 - Fishing Spot
			38 - Minigame
			51 - Slayer
			64 - Poll Booth
			END */ 
			
			
			// Altar.
			{19, 3096, 3511},
			{19, 2981, 3236},
			{0, 2969, 3244},
			//
			
			// Bank at Edgeville wild
			//{5, 3080, 3515},
			//Bank at Edgeville wild
	
			// Rare tree @ entrana
			{34, 2853, 3337},
			{51, 2990, 2780},
			// Rare tree @ dz
			{34, 2196, 3260},
			// Bank @ dz
			{5, 2198, 3255},
			// Donator dungeon @ dz
			{12, 2205, 3256},
			// Donator max dummy @ dz
			{11, 2192, 3249},
			// Weapon shop icon @ home
		//	{1, 3080, 3509},
			// Fishing spot @ dz
			{26, 2195, 3231},
			// Ladder by orb charging
			{12, 3088, 3559},
			// Teleporter at home
		//	{56, 3087, 3493},
			// Varrock staff shop
			{71, 3203, 3437},
			{0, 2955, 2782},
			
			{66, 2982, 3231},
			// Bank @ fally market
			{5, 3004, 3383},
			// Holiday event icon at home
			// {57, 3101, 3502}, //TODO uncomment when holiday is released
			// bank icon for home
			{69, 3312, 2800},
			//
			// Holiday event icon at home (halloween 2019)
					//	{57, 3097, 3498},
					//	{57, 3096, 3489},
			//test icons
			{13, 3300, 2785},
			//
			// Bank @ entrana
		{5, 2861, 3337},
		{5, 2982, 3244},
		{26, 2971, 3231},
		// Bank @ dz
		{5, 2529, 2720},
		// Donator dungeon @ dz
		{12, 2554, 2722},
		// Donator max dummy @ dz
		{11, 2528, 2729},
		// Rare tree @ dz
		{34, 2510, 2709},
		{34, 2990, 3236},
		{34, 2520, 2712},
		// Fishing spot @ dz
		{26, 2526, 2710},
		{26, 2534, 2712},
		// Mining spot @ dz
		{8, 2533, 2737},
		{8, 2997, 3230},
		// Furnace @ dz
		{9, 2539, 2721},
		{9, 2978, 3230},
		// Agility @ dz
		{49, 2552, 2712},};

	/**
	 * Custom icon locations.
	 */
	private final static int[][] customMapIconLocationsPvpOnly = {
			// Bank at Edgeville wild
			//{5, 3095, 3515},
			// Bank at Edgeville wild
			{5, 1, 1},};
			// Makeover mage icon inside Edgeville bank, too crowded if i enable it.
			// {54, 3090, 3495},
			// Slayer master icon inside Edgeville bank
		//	{51, 3095, 3498},};

	/**
	 * Custom icon locations.
	 */
	private final static int[][] customMapIconLocationsEcoOnly = {
			// guide npc at home
		//	{55, 3089, 3503},
			
			// quest start home
			// {6, 3102, 3494},
			// Slayer master icon @ home
		//	{51, 3094, 3477},
			// thieving icon @ home
		//	{36, 3096, 3504},
			// Makeover mage icon @ home
		//	{54, 3094, 3498},
			// Hunter icon @ entrana
			{63, 2810, 3380},};

	public static void drawMinimap(Client client) {
		int compassX, compassY, mapY, mapX;
		// TODO #FULLSCREEN ADJUST minimap drawing.
		int xOffset = Client.isFixedScreen() ? 0
				: Client.getClientWidth() - Client.getFullscreenModeMinimapX(210);
		int yOffset = Client.isFixedScreen() ? 0 : -4;
		int spriteId = Client.isFixedScreen() ? 84 : 84;
		if (Client.isFixedScreen()) {
			client.mapBackImage.initDrawingArea();
		}
		if (Client.is474GameFrame && Client.isFixedScreen()) {
			compassX = 30;
			compassY = 4;
			mapX = 50;
			mapY = 9;// 8 removes white dot
		} else {
			compassX = 11;
			compassY = 8;
			mapX = 35;
			mapY = 9;
		}
		if (!Client.isFixedScreen()) {
			compassX += 19;
			compassY += 2;
			if (Client.is474GameFrame) {
				compassX -= 12;
				compassY -= 0;
				mapY += 2;
			}
		}
		mapX += xOffset;
		compassX += xOffset;
		mapY += yOffset;
		compassY += yOffset;

		// There used to be if (client.minimapState == 2) { return } check other clients, this is for
		// barrows underground on other servers

		int i = client.viewRotation + client.minimapRotation & 0x7ff;
		int j = 48 + Client.myPlayer.x / 32;
		int l2 = 464 - Client.myPlayer.y / 32;
		int[] one = client.compassOffsets1;
		int[] two = client.compassOffsets0;
		client.landImage.method352(152, i, one, 256 + client.minimapZoom, two, l2, mapY, mapX, 146,
				j);
		for (int j5 = 0; j5 < client.objectIconCount; j5++) {
			try {
				int xPosition = (client.objectIconX[j5] * 4 + 2) - Client.myPlayer.x / 32;
				int i3 = (client.objectIconY[j5] * 4 + 2) - Client.myPlayer.y / 32;

				boolean match = false;
				for (int index = 0; index < mapIconLocationsRemoved.length; index++) {
					int x = ((mapIconLocationsRemoved[index][0] - Client.instance.baseX) * 4 + 2)
							- Client.myPlayer.x / 32;
					int y = ((mapIconLocationsRemoved[index][1] - Client.instance.baseY) * 4 + 2)
							- Client.myPlayer.y / 32;
					if (xPosition == x && i3 == y) {
						match = true;
					}
				}
				if (match) {
					continue;
				}
				markMinimap(client, client.objectIcon[j5], xPosition, i3);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		for (int index = 0; index < customMapIconLocations.length; index++) {
			int x = ((customMapIconLocations[index][1] - Client.instance.baseX) * 4 + 2)
					- Client.myPlayer.x / 32;
			int y = ((customMapIconLocations[index][2] - Client.instance.baseY) * 4 + 2)
					- Client.myPlayer.y / 32;
			markMinimap(client, client.mapFunctions[customMapIconLocations[index][0]], x, y);
		}
		if (Config.PVP) {
			for (int index = 0; index < customMapIconLocationsEcoOnly.length; index++) {
				int x = ((customMapIconLocationsEcoOnly[index][1] - Client.instance.baseX) * 4 + 2)
						- Client.myPlayer.x / 32;
				int y = ((customMapIconLocationsEcoOnly[index][2] - Client.instance.baseY) * 4 + 2)
						- Client.myPlayer.y / 32;
				markMinimap(client, client.mapFunctions[customMapIconLocationsEcoOnly[index][0]], x, y);
			}
		} else {
			for (int index = 0; index < customMapIconLocationsPvpOnly.length; index++) {
				int x = ((customMapIconLocationsPvpOnly[index][1] - Client.instance.baseX) * 4 + 2)
						- Client.myPlayer.x / 32;
				int y = ((customMapIconLocationsPvpOnly[index][2] - Client.instance.baseY) * 4 + 2)
						- Client.myPlayer.y / 32;
				markMinimap(client, client.mapFunctions[customMapIconLocationsPvpOnly[index][0]], x, y);
			}
			
		}
		
		for (int k5 = 0; k5 < 104; k5++) {
			for (int l5 = 0; l5 < 104; l5++) {
				NodeList class19 = client.groundArray[client.plane][k5][l5];
				if (class19 != null) {
					int l = (k5 * 4 + 2) - Client.myPlayer.x / 32;
					int j3 = (l5 * 4 + 2) - Client.myPlayer.y / 32;
					markMinimap(client, client.mapDotItem, l, j3);
				}
			}
		}
		for (int i6 = 0; i6 < client.npcCount; i6++) {
			Npc npc = client.npcArray[client.npcIndices[i6]];
			if (npc != null && npc.isVisible()) {
				EntityDefinition entityDef = npc.desc;
				if (entityDef.childrenIDs != null)
					entityDef = entityDef.getOverride();
				if (entityDef != null && entityDef.showOnMinimap && entityDef.interactable) {
					int x = npc.x / 32 - Client.myPlayer.x / 32;
					int y = npc.y / 32 - Client.myPlayer.y / 32;
					markMinimap(client, client.mapDotNpc, x, y);
				}
			}
		}
		for (int j6 = 0; j6 < client.playerCount; j6++) {
			Player player = client.playerArray[client.playerIndices[j6]];
			if (player != null) {
				if (player.gameModeTitle.contains("[Bot]") && Client.botsOff
						&& (System.currentTimeMillis() - player.lastCombatTime) >= 5000) {
					continue;
				}
			}
			if (player != null && player.isVisible() && !player.isPlayerPet()) {
				int j1 = player.x / 32 - Client.myPlayer.x / 32;
				int l3 = player.y / 32 - Client.myPlayer.y / 32;
				boolean flag1 = false;
				boolean flag3 = false;
				for (int j3 = 0; j3 < client.clanList.length; j3++) {
					if (client.clanList[j3] == null)
						continue;
					if (!client.clanList[j3].equalsIgnoreCase(player.getName()))
						continue;
					flag3 = true;
					break;
				}
				long l6 = TextClass.longForName(player.getName());
				for (int k6 = 0; k6 < Client.friendsCount; k6++) {
					if (l6 != client.friendsListAsLongs[k6] || client.friendsNodeIds[k6] == 0) {
						continue;
					}
					flag1 = true;
					break;
				}
				boolean flag2 = false;
				if (Client.myPlayer.team != 0 && player.team != 0
						&& Client.myPlayer.team == player.team) {
					flag2 = true;
				}
				if (flag1) {
					markMinimap(client, client.mapDotFriend, j1, l3);
				} else if (flag3) {
					markMinimap(client, client.mapDotClan, j1, l3);
				} else if (flag2) {
					markMinimap(client, client.mapDotTeam, j1, l3);
				} else {
					markMinimap(client, client.mapDotPlayer, j1, l3);
				}
			}
		}
		if (client.markType != 0 && Client.loopCycle % 20 < 10) {
			if (client.markType == 1 && client.markedNpc >= 0
					&& client.markedNpc < client.npcArray.length) {
				Npc class30_sub2_sub4_sub1_sub1_1 = client.npcArray[client.markedNpc];
				if (class30_sub2_sub4_sub1_sub1_1 != null) {
					int k1 = class30_sub2_sub4_sub1_sub1_1.x / 32 - Client.myPlayer.x / 32;
					int i4 = class30_sub2_sub4_sub1_sub1_1.y / 32 - Client.myPlayer.y / 32;
					drawMinimapMark(client, client.mapMarker, i4, k1);
				}
			}

			if (client.markType == 10 && client.markedPlayer >= 0
					&& client.markedPlayer < client.playerArray.length) {

				int x = ((Client.targetHintX - Client.instance.baseX) * 4 + 2) - Client.myPlayer.x / 32;// Set
																																		// x
																																		// and
																																		// Y
																																		// cord
																																		// for
																																		// display
																																		// area,
																																		// or
																																		// just
																																		// use
																																		// method
																																		// 254
				int y = ((Client.targetHintY - Client.instance.baseY) * 4 + 2) - Client.myPlayer.y / 32;
				drawMinimapMarkTarget(client, client.mapMarker, y, x);
			}

		}
		if (client.destX != 0) {
			int j2 = (client.destX * 4 + 2) - Client.myPlayer.x / 32;
			int l4 = (client.destY * 4 + 2) - Client.myPlayer.y / 32;
			markMinimap(client, client.mapFlag,
					j2 + (Client.is474GameFrame && Client.isFixedScreen() ? -1 : -1),
					l4 + (Client.is474GameFrame && Client.isFixedScreen() ? 0 : 0));
		}
		if (Client.is474GameFrame && Client.isFixedScreen()) {
			Client.cacheSprite[Client.is317GameFrame ? 919 : 82].drawSprite(+xOffset, 0 + yOffset);
			DrawingArea.drawPixels(3, 84 + yOffset, 123 + xOffset, 0xffffff, 3);
		} else {
			if (Client.is498GameFrame && Client.isFixedScreen()) {
				Client.cacheSprite[83].drawSprite(0, 0);
			} else {
				if (Client.isFixedScreen()) {
					Client.cacheSprite[spriteId].drawSprite(xOffset, 0);
				} else {
					Client.cacheSprite[Client.is474GameFrame ? 629 : 626].drawSprite(
							xOffset + (Client.is474GameFrame ? 12 : 24), Client.is474GameFrame ? 1 : 0);
				}
			}

			// My player white dot.
			DrawingArea.drawPixels(3, 84 + yOffset, 108 + xOffset, 0xffffff, 3);
		}
		loadOrbs(client);

		if (Client.is474GameFrame && Client.isFixedScreen()) {
			client.compass.method352(33, client.viewRotation, client.mapbackOffsets1, 245,
					client.mapbackOffsets0, 25, compassY, compassX - 1, 30, 25);
		} else {
			if (!Client.isFixedScreen()) {
				client.compass.method352(33, client.viewRotation, client.mapbackOffsets1, 256,
						client.mapbackOffsets0, 24, compassY, compassX - 1, 33, 25);
			} else {
				client.compass.method352(33, client.viewRotation, client.mapbackOffsets1, 240,
						client.mapbackOffsets0, 25, compassY, compassX - 1, 33, 25);
			}
		}
		if (client.menuOpen && client.getMenuScreenArea() == 3) {
			client.drawMenu();
		}
		client.inGameScreen.initDrawingArea();
		if (Client.isFixedScreen()) {
			client.mapBackImage.drawGraphics(0, client.graphics, 516);
		}
	}

	public static void loadOrbs(Client client) {
		MoneyPouchOrb.drawMoneyPouchOrb();
		Orbs.drawExperienceCounterOrb();
		Orbs.drawLogout();
		if (Client.is474GameFrame && !Client.isOSRSGameFrame) {
			return;
		}
		Orbs.drawWorldMap();
		Orbs.drawQuestionMark();
		if (Client.interfacesReloaded) {
			return;
		}
		Orbs.drawHitPoints();
		Orbs.drawPrayerOrb();
		Orbs.drawRun();
		Orbs.drawSpecialOrb();
	}

	public static void processMinimapActions(Client client) {
		int x = client.mouseX;
		int y = client.mouseY;
		// TODO #FULLSCREEN ADJUST orbs clicking and right clicking.
		int mouseX = Client.instance.mouseX - (Client.isFixedScreen() ? 0
				: (Client.getClientWidth() - Client.getFullscreenModeMinimapX(782)));
		x = mouseX;

		if (MoneyPouchOrb.canDrawMoneyPouch()) {
			if (MoneyPouchOrb.moneyPouchHover) {
				client.menuActionName[4] = "Toggle";
				client.menuActionID[4] = 1515;
				client.menuActionRow = 2;
				client.menuActionName[3] = "Withdraw";
				client.menuActionID[3] = 1516;
				client.menuActionName[2] = "Examine";
				client.menuActionID[2] = 1517;
				client.menuActionName[1] = "Price Checker";
				client.menuActionID[1] = 1518;
				client.menuActionRow = 5;
			}
		}

		if (!Client.is474GameFrame && !Client.isOSRSGameFrame) {
			if ((Client.is562GameFrame || Client.is562PlusGameFrame) && x >= 745 && x <= 765 && y >= 0
					&& y <= 20) {
				client.menuActionName[1] = "Logout";
				client.menuActionID[1] = 1512;
				client.menuActionRow = 2;
			} else if (x >= (Client.is498GameFrame ? 743 : 745) && x <= 765 && y >= 0
					&& y <= (Client.is498GameFrame ? 25 : 21)) {
				client.menuActionName[1] = "Logout";
				client.menuActionID[1] = 1512;
				client.menuActionRow = 2;
			}
		}
		if (!Client.is474GameFrame || !Client.isFixedScreen()) {
			if (Client.isFixedScreen() && x >= 523 && x <= 564 && y >= 3 && y <= 40
					|| !Client.isFixedScreen() && x >= 598 && x <= 635 && y >= 0 && y <= 40
							&& !Client.is474GameFrame
					|| !Client.isFixedScreen() && Client.is474GameFrame
							&& Client.inCircle(580, 0, x, y, 22)) {
				client.menuActionName[1] = "Face North";
				client.menuActionID[1] = 477;
				client.menuActionRow = 2;
			}
			if (Client.isOSRSGameFrame || !Client.is474GameFrame) {

				if (Client.isFixedScreen() && x >= 706 && x <= 762 && y >= 95 && y <= 124
						|| !Client.isFixedScreen() && x >= 564 && x <= 621 && y >= 107 && y <= 140
								&& !Client.is474GameFrame
						|| !Client.isFixedScreen() && Client.isOSRSGameFrame && x >= 580 && x <= 631
								&& y >= 130 && y <= 161) {
					client.menuActionName[1] =
							!Client.runClicked ? "Toggle Run-Mode On" : "Toggle Run-Mode Off";
					client.menuActionID[1] = 1050;
					client.menuActionName[0] = "Rest";
					client.menuActionID[0] = 1051;
					client.menuActionRow = 2;
				} else if (Client.isFixedScreen() && x >= 706 && x <= 762 && client.mouseY >= 54
						&& client.mouseY <= 86
						|| !Client.isFixedScreen() && x >= 554 && x <= 610 && y >= 72 && y <= 104
								&& !Client.is474GameFrame
						|| !Client.isFixedScreen() && Client.isOSRSGameFrame && x >= 557 && x <= 612
								&& y >= 92 && y <= 126) {
					client.menuActionName[2] =
							Client.getQuickPrayerOn() ? "Turn Quick Prayers Off" : "Turn Quick Prayers On";
					client.menuActionID[2] = 1500;
					client.menuActionRow = 2;
					client.menuActionName[1] = "Select Quick Prayers";
					client.menuActionID[1] = 1506;
					client.menuActionRow = 3;
				} else if (Client.isFixedScreen() && x >= 690 && x <= 746 && client.mouseY >= 128
						&& client.mouseY <= 159
						|| !Client.isFixedScreen() && x >= 587 && x <= 643 && y >= 141 && y <= 172
								&& !Client.is474GameFrame
						|| !Client.isFixedScreen() && Client.isOSRSGameFrame && x >= 615 && x <= 671
								&& y >= 159 && y <= 188) {
					if (!Client.specOrb) {
						return;
					}
					if (Client.disableSpecOrb) {
						return;
					}
					if (Client.showSummoningGlow) {
						client.menuActionName[2] = "Cast @gr3@Magic focus";
						client.menuActionID[2] = 1507;
					}
					// client.menuActionName[1] = "Dismiss";
					// client.menuActionID[1] = 1508;
					// client.menuActionName[0] = "Call familiar";
					// client.menuActionID[0] = 1511;
					// client.menuActionRow = Client.showSummoningGlow ? 3 : 2;
				}
			}

		} else if (Client.isOSRSGameFrame) {
			if (x >= 542 && x <= 578 && y >= 0 && y <= 39) {
				client.menuActionName[1] = "Face North";
				client.menuActionID[1] = 477;
				client.menuActionRow = 2;
			} else if (Client.specOrb && x >= 530 && x <= 581 && client.mouseY >= 111
					&& client.mouseY <= 135
					|| !Client.specOrb && x >= 541 && x <= 594 && client.mouseY >= 122
							&& client.mouseY <= 153) {
				client.menuActionName[1] =
						!Client.runClicked ? "Toggle Run-Mode On" : "Toggle Run-Mode Off";
				client.menuActionID[1] = 1050;
				client.menuActionName[0] = "Rest";
				client.menuActionID[0] = 1051;
				client.menuActionRow = 2;
			} else if (Client.specOrb && x >= 515 && x <= 569 && client.mouseY >= 78
					&& client.mouseY <= 110
					|| !Client.specOrb && x >= 515 && x <= 569 && client.mouseY >= 85
							&& client.mouseY <= 119) {
				client.menuActionName[2] =
						Client.getQuickPrayerOn() ? "Turn Quick Prayers Off" : "Turn Quick Prayers On";
				client.menuActionID[2] = 1500;
				client.menuActionRow = 2;
				client.menuActionName[1] = "Select Quick Prayers";
				client.menuActionID[1] = 1506;
				client.menuActionRow = 3;
			} else if (x >= 563 && x <= 618 && client.mouseY >= 135 && client.mouseY < 163) {
				if (!Client.specOrb) {
					return;
				}
				if (Client.disableSpecOrb) {
					return;
				}
				if (Client.showSummoningGlow) {
					client.menuActionName[2] = "Cast @gr3@Magic focus";
					client.menuActionID[2] = 1507;
				}
				// client.menuActionName[1] = "Dismiss";
				// client.menuActionID[1] = 1508;
				// client.menuActionName[0] = "Call familiar";
				// client.menuActionID[0] = 1511;
				// client.menuActionRow = Client.showSummoningGlow ? 3 : 2;
			}
		} else {
			if (x >= 542 && x <= 578 && y >= 5 && y <= 39) {
				client.menuActionName[1] = "Face North";
				client.menuActionID[1] = 477;
				client.menuActionRow = 2;
			}
		}
	}

	public static void drawMinimapMark(Client client, Sprite sprite, int y, int x) {
		int l = x * x + y * y;
		if (l > 4225) {
			int i1 = client.viewRotation + client.minimapRotation & 0x7ff;
			int j1 = Model.modelIntArray1[i1];
			int k1 = Model.modelIntArray2[i1];
			j1 = (j1 * 256) / (client.minimapZoom + 256);
			k1 = (k1 * 256) / (client.minimapZoom + 256);
			int l1 = y * j1 + x * k1 >> 16;
			int i2 = y * k1 - x * j1 >> 16;
			double d = Math.atan2(l1, i2);
			int j2 = (int) (Math.sin(d) * 63D);
			int k2 = (int) (Math.cos(d) * 57D);

			y = (94 + j2 + 4) - 10;
			x = 83 - k2 - 20;
			Client.instance.mapEdgeMarker.method353(x, 0.0, y);
			return;
		} else {
			markMinimap(client, sprite, x, y);
		}
	}

	public static void drawMinimapMarkTarget(Client client, Sprite sprite, int y, int x) {
		int distance = x * x + y * y;
		if (distance > 4225) {
			int i1 = client.viewRotation + client.minimapRotation & 0x7ff;
			int j1 = Model.modelIntArray1[i1];
			int k1 = Model.modelIntArray2[i1];
			j1 = (j1 * 256) / (client.minimapZoom + 256);
			k1 = (k1 * 256) / (client.minimapZoom + 256);
			int l1 = y * j1 + x * k1 >> 16;
			int i2 = y * k1 - x * j1 >> 16;
			double d = Math.atan2(l1, i2);
			int j2 = (int) (Math.sin(d) * 63D);
			int k2 = (int) (Math.cos(d) * 57D);

			y = (94 + j2 + 4) - 10;
			x = 83 - k2 - 20;
			x += Client.isFixedScreen() ? 0 : 0;
			y += Client.isFixedScreen() ? 0
					: (Client.getClientWidth()) - Client.getFullscreenModeMinimapX(224);
			if (Client.is474GameFrame) {
				Client.instance.mapEdgeMarker.method353(x + 5, 0.0, y + 35);
			} else {
				y += Client.isFixedScreen() ? 0 : 23;
				Client.instance.mapEdgeMarker.method353(x + 5, 0.0, y + 15);
			}
			return;
		} else {
			Player target = client.playerArray[Client.targetHintPlayerId];
			if (target == null) {
				return;
			}
			x = target.x / 32 - Client.myPlayer.x / 32;
			y = target.y / 32 - Client.myPlayer.y / 32;
			drawMinimapMark(client, client.mapMarker, y, x);
		}
	}

	static void markMinimap(Client client, Sprite sprite, int xPosition, int yPosition) {
		if (sprite == null) {
			return;
		}
		int k = client.viewRotation + client.minimapRotation & 0x7ff;
		int l = xPosition * xPosition + yPosition * yPosition;
		if (l > 6400) {
			return;
		}
		// TODO #FULLSCREEN ADJUST minimap, marking map with objects players npcs etc..
		int xOffset = Client.isFixedScreen() ? 0
				: Client.getClientWidth() - Client.getFullscreenModeMinimapX(211);
		int yOffset = Client.isFixedScreen() ? 0 : -4;
		int i1 = Model.modelIntArray1[k];
		int j1 = Model.modelIntArray2[k];
		i1 = (i1 * 256) / (client.minimapZoom + 256);
		j1 = (j1 * 256) / (client.minimapZoom + 256);
		int k1 = yPosition * i1 + xPosition * j1 >> 16;
		int l1 = yPosition * j1 - xPosition * i1 >> 16;
		try {
			int x = Client.is474GameFrame && Client.isFixedScreen() ? 124 : 109;
			int y = Client.is474GameFrame && Client.isFixedScreen() ? 85 : 85;
			sprite.drawSprite(((x + k1) - sprite.maxWidth / 2) + xOffset,
					(y - l1) - (sprite.maxHeight / 2) + yOffset);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void drawMinimapWall(Client client, int i, int k, int l, int i1, int j1) {
		int k1 = client.landScape.getWallUID(j1, l, i);
		if (k1 != 0) {
			int l1 = client.landScape.getArrangement(j1, l, i, k1);
			int k2 = l1 >> 6 & 3;
			int i3 = l1 & 0x1f;
			int k3 = k;
			if (k1 > 0)
				k3 = i1;
			int ai[] = client.landImage.myPixels;
			int k4 = 24624 + l * 4 + (103 - i) * 512 * 4;
			int i5 = k1 >> 14 & 0x7fff;
			ObjectDefinition class46_2 = ObjectDefinition.forId(i5);
			if (class46_2.mapscene != -1) {
				Background background_2 = client.mapScenes[class46_2.mapscene];
				if (background_2 != null) {
					int i6 = (class46_2.sizeX * 4 - background_2.width) / 2;
					int j6 = (class46_2.sizeY * 4 - background_2.height) / 2;
					background_2.drawBackground(48 + l * 4 + i6,
							48 + (104 - i - class46_2.sizeY) * 4 + j6);
				}
			} else {
				if (i3 == 0 || i3 == 2) {
					if (k2 == 0) {
						ai[k4] = k3;
						ai[k4 + 512] = k3;
						ai[k4 + 1024] = k3;
						ai[k4 + 1536] = k3;
					} else if (k2 == 1) {
						ai[k4] = k3;
						ai[k4 + 1] = k3;
						ai[k4 + 2] = k3;
						ai[k4 + 3] = k3;
					} else if (k2 == 2) {
						ai[k4 + 3] = k3;
						ai[k4 + 3 + 512] = k3;
						ai[k4 + 3 + 1024] = k3;
						ai[k4 + 3 + 1536] = k3;
					} else if (k2 == 3) {
						ai[k4 + 1536] = k3;
						ai[k4 + 1536 + 1] = k3;
						ai[k4 + 1536 + 2] = k3;
						ai[k4 + 1536 + 3] = k3;
					}
				}
				if (i3 == 3) {
					if (k2 == 0) {
						ai[k4] = k3;
					} else if (k2 == 1) {
						ai[k4 + 3] = k3;
					}
				} else if (k2 == 2) {
					ai[k4 + 3 + 1536] = k3;
				} else if (k2 == 3) {
					ai[k4 + 1536] = k3;
				}
				if (i3 == 2) {
					if (k2 == 3) {
						ai[k4] = k3;
						ai[k4 + 512] = k3;
						ai[k4 + 1024] = k3;
						ai[k4 + 1536] = k3;
					} else if (k2 == 0) {
						ai[k4] = k3;
						ai[k4 + 1] = k3;
						ai[k4 + 2] = k3;
						ai[k4 + 3] = k3;
					} else if (k2 == 1) {
						ai[k4 + 3] = k3;
						ai[k4 + 3 + 512] = k3;
						ai[k4 + 3 + 1024] = k3;
						ai[k4 + 3 + 1536] = k3;
					} else if (k2 == 2) {
						ai[k4 + 1536] = k3;
						ai[k4 + 1536 + 1] = k3;
						ai[k4 + 1536 + 2] = k3;
						ai[k4 + 1536 + 3] = k3;
					}
				}
			}
		}
		k1 = client.landScape.getObjectUID(j1, l, i);
		if (k1 != 0) {
			int i2 = client.landScape.getArrangement(j1, l, i, k1);
			int l2 = i2 >> 6 & 3;
			int j3 = i2 & 0x1f;
			int l3 = k1 >> 14 & 0x7fff;
			ObjectDefinition class46_1 = ObjectDefinition.forId(l3);
			if (class46_1.mapscene != -1) {
				Background background_1 = client.mapScenes[class46_1.mapscene];
				if (background_1 != null) {
					int j5 = (class46_1.sizeX * 4 - background_1.width) / 2;
					int k5 = (class46_1.sizeY * 4 - background_1.height) / 2;
					background_1.drawBackground(48 + l * 4 + j5,
							48 + (104 - i - class46_1.sizeY) * 4 + k5);
				}
			} else if (j3 == 9) {
				int l4 = 0xeeeeee;
				if (k1 > 0)
					l4 = 0xee0000;
				int ai1[] = client.landImage.myPixels;
				int l5 = 24624 + l * 4 + (103 - i) * 512 * 4;
				if (l2 == 0 || l2 == 2) {
					ai1[l5 + 1536] = l4;
					ai1[l5 + 1024 + 1] = l4;
					ai1[l5 + 512 + 2] = l4;
					ai1[l5 + 3] = l4;
				} else {
					ai1[l5] = l4;
					ai1[l5 + 512 + 1] = l4;
					ai1[l5 + 1024 + 2] = l4;
					ai1[l5 + 1536 + 3] = l4;
				}
			}
		}
		k1 = client.landScape.getGroundDecorationUID(j1, l, i);
		if (k1 != 0) {
			int j2 = k1 >> 14 & 0x7fff;
			ObjectDefinition class46 = ObjectDefinition.forId(j2);
			if (class46.mapscene != -1) {
				Background background = client.mapScenes[class46.mapscene];
				if (background != null) {
					int i4 = (class46.sizeX * 4 - background.width) / 2;
					int j4 = (class46.sizeY * 4 - background.height) / 2;
					background.drawBackground(48 + l * 4 + i4, 48 + (104 - i - class46.sizeY) * 4 + j4);
				}
			}
		}
	}

	static void clickOnMiniMap() {
		if (Client.instance.minimapState != 0) {
			return;
		}
		if (Client.instance.getClickMode3() == 1) {
			if (Client.is474GameFrame && Client.isFixedScreen()) {
				int mouseX = Client.instance.saveClickX - 567;
				int mouseY = Client.instance.saveClickY - 9;
				if ((Client.inCircle(0, 0, mouseX, mouseY, 73)
						&& !(mouseX >= 21 && mouseX <= 48 && mouseY >= 132 && mouseY <= 141)
						&& !(mouseX >= 21 && mouseX <= 43 && mouseY >= 124 && mouseY <= 131))
						|| mouseX >= 61 && mouseX <= 80 && mouseY >= 135 && mouseY <= 149) {
					mouseX -= 73;
					mouseY -= 75;
					int k = Client.instance.viewRotation + Client.instance.minimapRotation & 0x7ff;
					int i1 = Rasterizer.sin[k];
					int j1 = Rasterizer.cos[k];
					i1 = i1 * (Client.instance.minimapZoom + 256) >> 8;
					j1 = j1 * (Client.instance.minimapZoom + 256) >> 8;
					int k1 = mouseY * i1 + mouseX * j1 >> 11;
					int l1 = mouseY * j1 - mouseX * i1 >> 11;
					int i2 = Client.myPlayer.x + k1 >> 7;
					int j2 = Client.myPlayer.y - l1 >> 7;
					boolean flag1 = Client.instance.doWalkTo(1, 0, 0, 0, Client.myPlayer.smallY[0], 0, 0,
							j2, Client.myPlayer.smallX[0], true, i2);
					if (flag1) {
						Client.alwaysRightClickAttack = false;
						Client.instance.stream.writeWordBigEndian(mouseX);
						Client.instance.stream.writeWordBigEndian(mouseY);
						Client.instance.stream.writeWord(Client.instance.viewRotation);
						Client.instance.stream.writeWordBigEndian(57);
						Client.instance.stream.writeWordBigEndian(Client.instance.minimapRotation);
						Client.instance.stream.writeWordBigEndian(Client.instance.minimapZoom);
						Client.instance.stream.writeWordBigEndian(89);
						Client.instance.stream.writeWord(Client.myPlayer.x);
						Client.instance.stream.writeWord(Client.myPlayer.y);
						Client.instance.stream.writeWordBigEndian(Client.instance.anInt1264);
						Client.instance.stream.writeWordBigEndian(63);
					}
				}
			} else {
				int x = Client.instance.saveClickX - 550;
				int y = Client.instance.saveClickY - 11;
				if (!Client.isFixedScreen()) {
					// TODO #FULLSCREEN ADJUST minimap clicking flag position.
					x = Client.instance.saveClickX - 3
							- (Client.getClientWidth() - Client.getFullscreenModeMinimapX(180));
					y += 4;
				}
				if (Client.inCircle(0, 0, x, y, 76)) {
					x -= 75;
					y -= 75;
					int k = Client.instance.viewRotation + Client.instance.minimapRotation & 0x7ff;
					int i1 = Rasterizer.sin[k];
					int j1 = Rasterizer.cos[k];
					i1 = i1 * (Client.instance.minimapZoom + 256) >> 8;
					j1 = j1 * (Client.instance.minimapZoom + 256) >> 8;
					int k1 = y * i1 + x * j1 >> 11;
					int l1 = y * j1 - x * i1 >> 11;
					int i2 = Client.myPlayer.x + k1 >> 7;
					int j2 = Client.myPlayer.y - l1 >> 7;
					boolean flag1 = Client.instance.doWalkTo(1, 0, 0, 0, Client.myPlayer.smallY[0], 0, 0,
							j2, Client.myPlayer.smallX[0], true, i2);
					if (flag1) {
						Client.alwaysRightClickAttack = false;
						Client.instance.stream.writeWordBigEndian(x);
						Client.instance.stream.writeWordBigEndian(y);
						Client.instance.stream.writeWord(Client.instance.viewRotation);
						Client.instance.stream.writeWordBigEndian(57);
						Client.instance.stream.writeWordBigEndian(Client.instance.minimapRotation);
						Client.instance.stream.writeWordBigEndian(Client.instance.minimapZoom);
						Client.instance.stream.writeWordBigEndian(89);
						Client.instance.stream.writeWord(Client.myPlayer.x);
						Client.instance.stream.writeWord(Client.myPlayer.y);
						Client.instance.stream.writeWordBigEndian(Client.instance.anInt1264);
						Client.instance.stream.writeWordBigEndian(63);
					}
				}
			}
			Client.anInt1117++;
			if (Client.anInt1117 > 1151) {
				Client.alwaysRightClickAttack = false;
				Client.anInt1117 = 0;
				Client.instance.stream.createFrame(246);
				Client.instance.stream.writeWordBigEndian(0);
				int l = Client.instance.stream.currentOffset;
				if ((int) (Math.random() * 2D) == 0) {
					Client.instance.stream.writeWordBigEndian(101);
				}
				Client.instance.stream.writeWordBigEndian(197);
				Client.instance.stream.writeWord((int) (Math.random() * 65536D));
				Client.instance.stream.writeWordBigEndian((int) (Math.random() * 256D));
				Client.instance.stream.writeWordBigEndian(67);
				Client.instance.stream.writeWord(14214);
				if ((int) (Math.random() * 2D) == 0) {
					Client.instance.stream.writeWord(29487);
				}
				Client.instance.stream.writeWord((int) (Math.random() * 65536D));
				if ((int) (Math.random() * 2D) == 0) {
					Client.instance.stream.writeWordBigEndian(220);
				}
				Client.instance.stream.writeWordBigEndian(180);
				Client.instance.stream.writeBytes(Client.instance.stream.currentOffset - l);
			}
		}
	}

	public static void drawSplitPrivateChat() {
		if (Client.splitPrivateChat == 0) {
			return;
		}
		int i = 0;
		if (Client.instance.systemUpdateCycle != 0) {
			i = 1;
		}
		// TODO #FULLSCREEN ADJUST private messaging split chat.
		int y1 = Client.isFixedScreen() ? 0
				: Client.getClientHeight() - Client.getFullscreenModeChatAreaY(538);
		for (int j = 0; j < 100; j++) {
			if (Client.instance.chatMessages[j] != null) {
				int chatType = Client.instance.chatTypes[j];
				String s = Client.instance.chatNames[j];
				String chatNameRaw = Client.instance.chatNamesRaw[j];
				if ((chatType == ClientConstants.CHAT_TYPE_PRIVATE_MESSAGE_RECEIVED_NORMAL
						|| chatType == ClientConstants.CHAT_TYPE_PRIVATE_MESSAGE_RECEIVED_MOD)
						&& (chatType == ClientConstants.CHAT_TYPE_PRIVATE_MESSAGE_RECEIVED_MOD
								|| Client.instance.privateChatMode == 0
								|| Client.instance.privateChatMode == 1
										&& Client.instance.isFriendOrSelf(chatNameRaw))) {
					int y = 329 - i * 13 + y1;
					int x = 4;
					Client.instance.newRegularFont.drawBasicString("From", x, y, 65535, 0);
					x += Client.instance.newRegularFont.getTextWidth("From ");
					Client.instance.newRegularFont
							.drawBasicString(s + ": " + Client.instance.chatMessages[j], x, y, 65535, 0);
					if (++i >= 5) {
						return;
					}
				}
				boolean friendsOnly = Client.instance.privateChatMode == ClientConstants.PUBLIC_FRIENDS
						&& !Client.instance.isFriendOrSelf(chatNameRaw);
				if (chatType == ClientConstants.CHAT_TYPE_PRIVATE_MESSAGE_LOGGED_IN_OR_OUT
						&& Client.instance.privateChatMode < 2 && !friendsOnly) {
					int y = 329 - i * 13 + y1;
					Client.instance.newRegularFont.drawBasicString(Client.instance.chatMessages[j], 4, y,
							65535, 0);
					if (++i >= 5) {
						return;
					}
				}
				if (chatType == ClientConstants.CHAT_TYPE_PRIVATE_MESSAGE_SENT
						&& Client.instance.privateChatMode < 2) {
					int y = 329 - i * 13 + y1;
					Client.instance.newRegularFont.drawBasicString(
							"To " + s + ": " + Client.instance.chatMessages[j], 4, y, 65535, 0);
					if (++i >= 5) {
						return;
					}
				}
			}
		}
	}
}
