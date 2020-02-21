package Runecessor;

public class InventoryTab {

	public static void drawSideIcons317(Client client) {
		if (Client.tabInterfaceId[0] != -1)
			Client.cacheSprite[920].drawSprite(32, 10);//Cb interface

		if (Client.tabInterfaceId[1] != -1)
			Client.cacheSprite[921].drawSprite(56, 7);//Stats

		if (Client.tabInterfaceId[2] != -1)
			Client.cacheSprite[922].drawSprite(87, 8);//quest

		if (Client.tabInterfaceId[3] != -1)
			Client.cacheSprite[923].drawSprite(115, 5);//invent

		if (Client.tabInterfaceId[4] != -1)
			Client.cacheSprite[924].drawSprite(156, 6);//equipment

		if (Client.tabInterfaceId[5] != -1)
			Client.cacheSprite[925].drawSprite(183, 6);//prayer

		if (Client.tabInterfaceId[6] != -1)
			Client.cacheSprite[926].drawSprite(213, 12);//spellbook

		//bottom row
		if (Client.tabInterfaceId[7] != -1)
			Client.cacheSprite[933].drawSprite(32, 303);//Clan chat

		if (Client.tabInterfaceId[8] != -1)
			Client.cacheSprite[927].drawSprite(56, 306);//friends

		if (Client.tabInterfaceId[9] != -1)
			Client.cacheSprite[928].drawSprite(85, 306);//ignore

		if (Client.tabInterfaceId[10] != -1)
			Client.cacheSprite[929].drawSprite(120, 306);//logout

		if (Client.tabInterfaceId[11] != -1)
			Client.cacheSprite[930].drawSprite(155, 303);//settings

		if (Client.tabInterfaceId[12] != -1)
			Client.cacheSprite[931].drawSprite(186, 303);//emotes

		if (Client.tabInterfaceId[13] != -1)
			Client.cacheSprite[932].drawSprite(213, 303);//music
	}

	public static void determineTopTabs(Client client) {

		int x = client.mouseX;
		int y = client.mouseY;
		int yExtra = Client.isFixedScreen() ? 0 : 3;
		// TODO #FULLSCREEN ADJUST inventory tab clicking, the top ones.
		if (!Client.isFixedScreen()) {
			x = client.mouseX - (Client.getClientWidth() - Client.getFullscreenModeMinimapX(970));
			y = client.mouseY - (Client.getClientHeight() - Client.getFullscreenModeChatAreaY(242));
			if (Client.is562GameFrame || Client.is562PlusGameFrame) {
				x -= 9;
			}
		}



		if (!Client.isFixedScreen()) {
			if (Client.getInventoryLayout("DOUBLE STACK")) {
				x -= 191;
				y += 37;
			}
			else if (Client.getInventoryLayout("OLD")) {
				x -= 190;
				y += 300;
			}
		}
		if (!Client.is562GameFrame && !Client.is562PlusGameFrame && !Client.is317GameFrame) {
			if (x >= 522 + (Client.isFixedScreen() ? 0 : 2) && x <= 559 && y >= 168 && y < 203 + yExtra) {
				client.menuActionName[1] = "Combat Options";
				client.menuActionID[1] = 1021;
				client.menuActionRow = 2;
			}
			else if (x >= 560 && x <= 592 && y >= 168 && y < 203 + yExtra) {
				client.menuActionName[1] = "Stats";
				client.menuActionID[1] = 1022;
				client.menuActionRow = 2;
			}
			else if (x >= 593 && x <= 625 && y >= 168 && y < 203 + yExtra) {
				client.menuActionName[1] = "Quest List";
				client.menuActionID[1] = 1023;
				client.menuActionRow = 2;
			}
			else if (x >= 626 && x <= 658 && y >= 168 && y < 203 + yExtra) {
				client.menuActionName[1] = "Inventory";
				client.menuActionID[1] = 1024;
				client.menuActionRow = 2;
			} //1025 is used to examine.
			else if (x >= 659 && x <= 691 && y >= 168 && y < 203 + yExtra) {
				client.menuActionName[1] = "Worn Equipment";
				client.menuActionID[1] = 1052;
				client.menuActionRow = 2;
			}
			else if (x >= 692 && x <= 724 && y >= 168 && y < 203 + yExtra) {
				client.menuActionName[1] = "Prayer";
				client.menuActionID[1] = 1026;
				client.menuActionRow = 2;
			}
			else if (x >= 725 && x <= 762 && y >= 168 && y < 203 + yExtra) {
				client.menuActionName[1] = "Magic";
				client.menuActionID[1] = 1027;
				client.menuActionRow = 2;
			}
		}
		else if (Client.is317GameFrame) {
			if (x >= 540 && x <= 568 && y >= 170 && y < 206 + yExtra) {
				client.menuActionName[1] = "Combat Options";
				client.menuActionID[1] = 1021;
				client.menuActionRow = 2;
			}
			else if (x >= 569 && x <= 597 && y >= 170 && y < 206 + yExtra) {
				client.menuActionName[1] = "Stats";
				client.menuActionID[1] = 1022;
				client.menuActionRow = 2;
			}
			else if (x >= 598 && x <= 624 && y >= 169 && y < 206 + yExtra) {
				client.menuActionName[1] = "Quest List";
				client.menuActionID[1] = 1023;
				client.menuActionRow = 2;
			}
			else if (x >= 625 && x <= 669 && y >= 168 && y < 202 + yExtra) {
				client.menuActionName[1] = "Inventory";
				client.menuActionID[1] = 1024;
				client.menuActionRow = 2;
			} //1025 is used to examine.
			else if (x >= 670 && x <= 697 && y >= 168 && y < 204 + yExtra) {
				client.menuActionName[1] = "Worn Equipment";
				client.menuActionID[1] = 1052;
				client.menuActionRow = 2;
			}
			else if (x >= 698 && x <= 726 && y >= 168 && y < 205 + yExtra) {
				client.menuActionName[1] = "Prayer";
				client.menuActionID[1] = 1026;
				client.menuActionRow = 2;
			}
			else if (x >= 727 && x <= 757 && y >= 168 && y < 206 + yExtra) {
				client.menuActionName[1] = "Magic";
				client.menuActionID[1] = 1027;
				client.menuActionRow = 2;
			}
		}
		else {
			if (x >= 521 && x <= 550 && y >= 169 && y < 205) {
				client.menuActionName[1] = "Combat Options";
				client.menuActionID[1] = 1021;
				client.menuActionRow = 2;
			}
			else if (x >= 552 && x <= 581 && y >= 168 && y < 205) {
				client.menuActionName[1] = Client.is562PlusGameFrame ? "Achievement List" : "Stats";
				client.menuActionID[1] = 1029;
				client.menuActionRow = 2;
			}
			else if (x >= 582 && x <= 611 && y >= 168 && y < 205) {
				client.menuActionName[1] = Client.is562PlusGameFrame ? "Stats" : "Quest List";
				client.menuActionID[1] = 1030;
				client.menuActionRow = 2;
			}
			else if (x >= 612 && x <= 641 && y >= 168 && y < 203) {
				client.menuActionName[1] = Client.is562PlusGameFrame ? "Quest List" : "Achievement List";
				client.menuActionID[1] = 1031;
				client.menuActionRow = 2;
			}
			else if (x >= 642 && x <= 671 && y >= 168 && y < 205) {
				client.menuActionName[1] = "Inventory";
				client.menuActionID[1] = 1024;
				client.menuActionRow = 2;
			}
			else if (x >= 672 && x <= 701 && y >= 168 && y < 205) {
				client.menuActionName[1] = "Worn Equipment";
				client.menuActionID[1] = 1052;
				client.menuActionRow = 2;
			}
			else if (x >= 702 && x <= 731 && y >= 169 && y < 205) {
				client.menuActionName[1] = "Prayer";
				client.menuActionID[1] = 1026;
				client.menuActionRow = 2;
			}
			else if (x >= 732 && x <= 761 && y >= 169 && y < 205) {
				client.menuActionName[1] = "Magic";
				client.menuActionID[1] = 1027;
				client.menuActionRow = 2;
			}
		}
	}

	public static void determineBottomTabs(Client client) {
		int x = client.mouseX;
		int y = client.mouseY;
		int yExtra = Client.isFixedScreen() ? 0 : 3;
		// TODO #FULLSCREEN ADJUST inventory tab clicking, the bottom ones.
		if (!Client.isFixedScreen()) {
			x = client.mouseX - (Client.getClientWidth() - Client.getFullscreenModeMinimapX(775));
			y = client.mouseY - (Client.getClientHeight() - Client.getFullscreenModeChatAreaY(543));
			if (Client.getInventoryLayout("DOUBLE STACK")) {
				x += 4;
				y -= 2;
			}
			else if (Client.getInventoryLayout("OLD")) {
				x += 3;
				y -= 2;
			}

			if (Client.is562GameFrame || Client.is562PlusGameFrame) {
				x -= 25;
			}
		}

		if (!Client.is562GameFrame && !Client.is562PlusGameFrame && !Client.is317GameFrame) {
			if ((Client.is474GameFrame || Client.isOSRSGameFrame) && x >= 522 && x <= 559 && y >= 466 && y < 503 + yExtra) {
				client.menuActionName[1] = "Clan Chat";
				client.menuActionID[1] = 1036;
				client.menuActionRow = 2;
			}
			else if (x >= 626 && x <= 658 && y >= 466 && y < 503 + yExtra) {
				client.menuActionName[1] = (Client.is474GameFrame || Client.isOSRSGameFrame) ? "Logout" : "Clan Chat";
				client.menuActionID[1] = (Client.is474GameFrame || Client.isOSRSGameFrame) ? 1037 : 1036;
				client.menuActionRow = 2;
			}
			else if (x >= 560 && x <= 592 && y >= 466 && y < 503 + yExtra) {
				client.menuActionName[1] = "Friend List";
				client.menuActionID[1] = 1038;
				client.menuActionRow = 2;
			}
			else if (x >= 593 && x <= 625 && y >= 466 && y < 503 + yExtra) {
				client.menuActionName[1] = "Ignore List";
				client.menuActionID[1] = 1039;
				client.menuActionRow = 2;
			}
			else if (x >= 659 && x <= 691 && y >= 466 && y < 503 + yExtra) {
				client.menuActionName[1] = "Options";
				client.menuActionID[1] = 1040;
				client.menuActionRow = 2;
			}
			else if (x >= 692 && x <= 724 && y >= 466 && y < 503 + yExtra) {
				client.menuActionName[1] = "Emotes";
				client.menuActionID[1] = 1041;
				client.menuActionRow = 2;
			}
			else if (x >= 725 && x <= 762 && y >= 466 && y < 503 + yExtra) {
				client.menuActionName[1] = "Music Player";
				client.menuActionID[1] = 1042;
				client.menuActionRow = 2;
			}
		}
		else if (Client.is317GameFrame) {
			if (x >= 540 && x <= 570 && y >= 466 && y < 503 + yExtra) {
				client.menuActionName[1] = "Clan Chat";
				client.menuActionID[1] = 1036;
				client.menuActionRow = 2;
			}
			else if (x >= 571 && x <= 597 && y >= 465 && y < 502 + yExtra) {
				client.menuActionName[1] = "Friend List";
				client.menuActionID[1] = 1038;
				client.menuActionRow = 2;
			}
			else if (x >= 598 && x <= 625 && y >= 465 && y < 502 + yExtra) {
				client.menuActionName[1] = "Ignore List";
				client.menuActionID[1] = 1039;
				client.menuActionRow = 2;
			}
			else if (x >= 626 && x <= 669 && y >= 466 && y < 502 + yExtra) {
				client.menuActionName[1] = "Logout";
				client.menuActionID[1] = 1037;
				client.menuActionRow = 2;
			}
			else if (x >= 670 && x <= 697 && y >= 466 && y < 503 + yExtra) {
				client.menuActionName[1] = "Options";
				client.menuActionID[1] = 1040;
				client.menuActionRow = 2;
			}
			else if (x >= 698 && x <= 725 && y >= 466 && y < 503 + yExtra) {
				client.menuActionName[1] = "Emotes";
				client.menuActionID[1] = 1041;
				client.menuActionRow = 2;
			}
			else if (x >= 726 && x <= 755 && y >= 466 && y < 503 + yExtra) {
				client.menuActionName[1] = "Music Player";
				client.menuActionID[1] = 1042;
				client.menuActionRow = 2;
			}
		}
		else {
			if (x >= 552 && x <= 581 && y >= 466 && y < 503) {
				client.menuActionName[1] = "Friend List";
				client.menuActionID[1] = 1038;
				client.menuActionRow = 2;
			}
			else if (x >= 582 && x <= 611 && y >= 466 && y < 503) {
				client.menuActionName[1] = "Ignore List";
				client.menuActionID[1] = 1039;
				client.menuActionRow = 2;
			}
			else if (x >= 612 && x <= 641 && y >= 466 && y < 503) {
				client.menuActionName[1] = "Clan Chat";
				client.menuActionID[1] = 1036;
				client.menuActionRow = 2;
			}
			else if (x >= 642 && x <= 671 && y >= 466 && y < 503) {
				client.menuActionName[1] = "Options";
				client.menuActionID[1] = 1040;
				client.menuActionRow = 2;
			}
			else if (x >= 672 && x <= 701 && y >= 466 && y < 503) {
				client.menuActionName[1] = "Emotes";
				client.menuActionID[1] = 1041;
				client.menuActionRow = 2;
			}
			else if (x >= 702 && x <= 731 && y >= 466 && y < 502) {
				client.menuActionName[1] = "Music Player";
				client.menuActionID[1] = 1048;
				client.menuActionRow = 2;
			}
		}
	}


	public static void draw474SideIcons(Client client) {
		if (Client.tabInterfaceId[0] != -1)
			Client.cacheSprite[85].drawSprite(17, 9);
		if (Client.tabInterfaceId[1] != -1)
			Client.cacheSprite[86].drawSprite(49, 7);
		if (Client.tabInterfaceId[2] != -1)
			Client.cacheSprite[87].drawSprite(83, 7);
		if (Client.tabInterfaceId[3] != -1)
			Client.cacheSprite[739].drawSprite(114, 5);
		if (Client.tabInterfaceId[4] != -1)
			Client.cacheSprite[89].drawSprite(146, 2);
		if (Client.tabInterfaceId[5] != -1)
			Client.cacheSprite[90].drawSprite(180, 3);
		if (Client.tabInterfaceId[6] != -1)
			if (!Config.PRE_EOC) {
				switch (Client.spellbookType) {
					case 0:
						Client.cacheSprite[91].drawSprite(214, 7); //regular
						break;
					case 1:
						Client.cacheSprite[1255].drawSprite(214, 7); //lunars
						break;
					case 2:
						Client.cacheSprite[1256].drawSprite(214, 7); //ancients
						break;
					case 3:
						Client.cacheSprite[1257].drawSprite(214, 7); //arceuus
						break;

				}
			}
			else {
				Client.cacheSprite[91].drawSprite(214, 7); //regular
			}
		if (Client.tabInterfaceId[7] != -1)
			Client.cacheSprite[92].drawSprite(14, 303);//
		if (Client.tabInterfaceId[8] != -1)
			Client.cacheSprite[93].drawSprite(49, 306);
		if (Client.tabInterfaceId[9] != -1)
			Client.cacheSprite[94].drawSprite(82, 306);
		if (Client.tabInterfaceId[10] != -1)
			Client.cacheSprite[99].drawSprite(116, 302);
		if (Client.tabInterfaceId[11] != -1)
			Client.cacheSprite[96].drawSprite(148, 304);
		if (Client.tabInterfaceId[12] != -1)
			Client.cacheSprite[97].drawSprite(184, 302);
		if (Client.tabInterfaceId[13] != -1)
			Client.cacheSprite[98].drawSprite(216, 303);
	}

	public static void draw525SideIconsResizable(Client client) {
		// TODO #FULLSCREEN ADJUST inventory tab icons
		int x = Client.isFixedScreen() ? 0 : (Client.getClientWidth() - Client.getFullscreenModeMinimapX(455));
		int y = Client.isFixedScreen() ? 0 : (Client.getClientHeight() - Client.getFullscreenModeChatAreaY(75));

		if (!Client.isFixedScreen()) {
			if (Client.getInventoryLayout("DOUBLE STACK")) {
				x += 191;
				y -= 37;
			}
			else if (Client.getInventoryLayout("OLD")) {
				x += 192;
				y -= 299;
			}
		}

		/* 223 for x top
		 * 299 for y top
		 * 8 for x bottom
		 * 
		 */
		if (Client.tabInterfaceId[0] != -1) {
			Client.cacheSprite[85].drawSprite(17 + x, 9 + y);
		}
		if (Client.tabInterfaceId[1] != -1) {
			Client.cacheSprite[86].drawSprite(49 + x, 7 + y);
		}
		if (Client.tabInterfaceId[2] != -1) {
			Client.cacheSprite[87].drawSprite(83 + x, 7 + y);
		}
		if (Client.tabInterfaceId[3] != -1) {
			Client.cacheSprite[739].drawSprite(114 + x, 5 + y);
		}
		if (Client.tabInterfaceId[4] != -1) {
			Client.cacheSprite[89].drawSprite(146 + x, 3 + y);
		}
		if (Client.tabInterfaceId[5] != -1) {
			Client.cacheSprite[90].drawSprite(180 + x, 3 + y);
		}
		if (Client.tabInterfaceId[6] != -1) {
			if (!Config.PRE_EOC) {
				switch (Client.spellbookType) {
					case 0:
						Client.cacheSprite[91].drawSprite(214 + x, 7 + y); //regular
						break;
					case 1:
						Client.cacheSprite[1255].drawSprite(214 + x, 7 + y); //lunars
						break;
					case 2:
						Client.cacheSprite[1256].drawSprite(214 + x, 7 + y); //ancients
						break;
					case 3:
						Client.cacheSprite[1257].drawSprite(214 + x, 7 + y); //arceuus
						break;

				}
			}
			else {
				Client.cacheSprite[91].drawSprite(214, 7); //regular
			}
		}

		// Bottom side icons.
		x = Client.isFixedScreen() ? 0 : (Client.getClientWidth() - Client.getFullscreenModeMinimapX(257));
		y = Client.isFixedScreen() ? 0 : (Client.getClientHeight() - Client.getFullscreenModeChatAreaY(374));
		if (!Client.isFixedScreen() && Client.getInventoryLayout("OLD")) {
			x -= 6;
		}

		if (!Client.isFixedScreen()) {
			if (Client.getInventoryLayout("DOUBLE STACK")) {
				x -= 7;
			}
		}
		if (Client.tabInterfaceId[8] != -1) {
			Client.cacheSprite[93].drawSprite(49 + x, 306 + y);
		}
		if (Client.tabInterfaceId[9] != -1) {
			Client.cacheSprite[94].drawSprite(82 + x, 306 + y);
		}
		if (Client.tabInterfaceId[10] != -1) {
			Client.cacheSprite[92].drawSprite(115 + x, 304 + y);
		}
		if (Client.tabInterfaceId[11] != -1) {
			Client.cacheSprite[96].drawSprite(148 + x, 304 + y);
		}
		if (Client.tabInterfaceId[12] != -1) {
			Client.cacheSprite[97].drawSprite(183 + x, 302 + y);
		}
		if (Client.tabInterfaceId[13] != -1) {
			Client.cacheSprite[98].drawSprite(216 + x + (Client.isFixedScreen() ? 0 : -2), 303 + y);
		}
	}

	public static void drawSideIcons562(Client client) {

		int x = Client.isFixedScreen() ? 0 : (Client.getClientWidth() - Client.getFullscreenModeMinimapX(444));
		int y = Client.isFixedScreen() ? 0 : (Client.getClientHeight() - Client.getFullscreenModeChatAreaY(73));
		if (Client.tabInterfaceId[0] != -1) {
			Client.cacheSprite[100].drawSprite(11 + x, 8 + y);
		}
		if (Client.tabInterfaceId[1] != -1) {
			Client.cacheSprite[Client.is562PlusGameFrame ? 115 : 101].drawSprite(37 + 3 + x, 8 + y);
		}
		if (Client.tabInterfaceId[2] != -1) {
			Client.cacheSprite[Client.is562PlusGameFrame ? 101 : 102].drawSprite(67 + 3 + x, 8 + y);
		}
		if (Client.tabInterfaceId[14] != -1) {
			Client.cacheSprite[Client.is562PlusGameFrame ? 102 : 103].drawSprite(97 + 3 + x, 8 + y);
		}
		if (Client.tabInterfaceId[3] != -1) {
			Client.cacheSprite[104].drawSprite(127 + 3 + x, 8 + y);
		}
		if (Client.tabInterfaceId[4] != -1) {
			Client.cacheSprite[105].drawSprite(159 + 3 + x, 8 + y);
		}
		if (Client.tabInterfaceId[5] != -1) {
			Client.cacheSprite[106].drawSprite(187 + 3 + x, 8 + y);
		}
		if (Client.tabInterfaceId[6] != -1) {
			Client.cacheSprite[107].drawSprite(217 + 3 + x + (Client.isFixedScreen() ? 0 : 1), 8 + y);
		}
		x = Client.isFixedScreen() ? 0 : (Client.getClientWidth() - Client.getFullscreenModeMinimapX(233));
		y = Client.isFixedScreen() ? 0 : (Client.getClientHeight() - Client.getFullscreenModeChatAreaY(372));
		if (Client.tabInterfaceId[8] != -1) {
			Client.cacheSprite[108].drawSprite(38 + 3 + x, 306 + y);
		}
		if (Client.tabInterfaceId[9] != -1) {
			Client.cacheSprite[109].drawSprite(70 + 3 + x, 306 + y);
		}
		if (Client.tabInterfaceId[7] != -1) {
			Client.cacheSprite[113].drawSprite(97 + 3 + x, 306 + y);
		}
		if (Client.tabInterfaceId[11] != -1) {
			Client.cacheSprite[110].drawSprite(127 + 3 + x, 306 + y);
		}
		if (Client.tabInterfaceId[12] != -1) {
			Client.cacheSprite[111].drawSprite(157 + 3 + x, 306 + y);
		}
		if (Client.tabInterfaceId[13] != -1) {
			Client.cacheSprite[112].drawSprite(187 + 3 + x, 306 + y);
		}

	}

	public static void drawRedStones317(Client client) {
		if (!Client.drawTabs) {
			return;
		}
		if (Client.tabInterfaceId[Client.getTabId()] != -1) {
			if (Client.getTabId() == 0)
				Client.cacheSprite[934].drawSprite(22, 4);
			if (Client.getTabId() == 1)
				Client.cacheSprite[935].drawSprite(54, 2);
			if (Client.getTabId() == 2)
				Client.cacheSprite[935].drawSprite(82, 2);
			if (Client.getTabId() == 3)
				Client.cacheSprite[936].drawSprite(110, 2);
			if (Client.getTabId() == 4)
				Client.cacheSprite[937].drawSprite(153, 2);
			if (Client.getTabId() == 5)
				Client.cacheSprite[937].drawSprite(181, 2);
			if (Client.getTabId() == 6)
				Client.cacheSprite[938].drawSprite(209, 4);


			if (Client.getTabId() == 7)
				Client.cacheSprite[941].drawSprite(22, 298);
			if (Client.getTabId() == 8)
				Client.cacheSprite[937].drawSprite(56, 297);
			if (Client.getTabId() == 9)
				Client.cacheSprite[937].drawSprite(83, 297);
			if (Client.getTabId() == 10)
				Client.cacheSprite[939].drawSprite(110, 300);
			if (Client.getTabId() == 11)
				Client.cacheSprite[935].drawSprite(152, 297);
			if (Client.getTabId() == 12)
				Client.cacheSprite[935].drawSprite(180, 298);
			if (Client.getTabId() == 13)
				Client.cacheSprite[940].drawSprite(210, 297);
			if (Client.getTabId() == 15)
				Client.cacheSprite[119].drawSprite(209, 298);
		}
	}

	public static void draw474RedStones(Client client) {
		if (!Client.drawTabs) {
			return;
		}
		if (Client.tabInterfaceId[Client.getTabId()] != -1) {
			if (Client.getTabId() == 0)
				Client.cacheSprite[116].drawSprite(6, 0);
			if (Client.getTabId() == 1)
				Client.cacheSprite[120].drawSprite(44, 0);
			if (Client.getTabId() == 2)
				Client.cacheSprite[120].drawSprite(77, 0);
			if (Client.getTabId() == 3)
				Client.cacheSprite[120].drawSprite(110, 0);
			if (Client.getTabId() == 4)
				Client.cacheSprite[120].drawSprite(143, 0);
			if (Client.getTabId() == 5)
				Client.cacheSprite[120].drawSprite(176, 0);
			if (Client.getTabId() == 6)
				Client.cacheSprite[117].drawSprite(209, 0);
			if (Client.getTabId() == 7)
				Client.cacheSprite[118].drawSprite(6, 298);
			if (Client.getTabId() == 8)
				Client.cacheSprite[120].drawSprite(44, 298);
			if (Client.getTabId() == 9)
				Client.cacheSprite[120].drawSprite(77, 298);
			if (Client.getTabId() == 10)
				Client.cacheSprite[120].drawSprite(110, 298);
			if (Client.getTabId() == 11)
				Client.cacheSprite[120].drawSprite(143, 298);
			if (Client.getTabId() == 12)
				Client.cacheSprite[120].drawSprite(176, 298);
			if (Client.getTabId() == 13)
				Client.cacheSprite[119].drawSprite(209, 298);
			if (Client.getTabId() == 15)
				Client.cacheSprite[119].drawSprite(209, 298);
		}
	}

	public static void draw525RedStonesResizable(Client client) {
		if (!Client.drawTabs) {
			return;
		}

		if (Client.hideInventoryInterfaceAction && !Client.isFixedScreen()) {
			return;
		}
		// TODO #FULLSCREEN ADJUST inventory tab red stones
		int x = Client.isFixedScreen() ? 0 : (Client.getClientWidth() - Client.getFullscreenModeMinimapX(455));
		int y = Client.isFixedScreen() ? 0 : (Client.getClientHeight() - Client.getFullscreenModeChatAreaY(75));

		if (!Client.isFixedScreen()) {
			if (Client.getInventoryLayout("DOUBLE STACK")) {
				x += 191;
				y -= 37;
			}
			else if (Client.getInventoryLayout("OLD")) {
				x += 192;
				y -= 299;
			}
		}
		if (Client.tabInterfaceId[Client.getTabId()] != -1) {
			if (Client.getTabId() == 0) {
				if (!Client.getInventoryLayout("LANDSCAPE") && !Client.isFixedScreen()) {
					Client.cacheSprite[116].drawSprite(6 + x, 0 + y);
				}
				else {
					Client.cacheSprite[Client.isFixedScreen() ? 116 : 120].drawSprite(5 + x + (Client.isFixedScreen() ? 0 : 6), 0 + y);
				}
			}
			if (Client.getTabId() == 1) {
				Client.cacheSprite[120].drawSprite(44 + x, 0 + y);
			}
			if (Client.getTabId() == 2) {
				Client.cacheSprite[120].drawSprite(77 + x, 0 + y);
			}
			if (Client.getTabId() == 3) {
				Client.cacheSprite[120].drawSprite(110 + x, 0 + y);
			}
			if (Client.getTabId() == 4) {
				Client.cacheSprite[120].drawSprite(143 + x, 0 + y);
			}
			if (Client.getTabId() == 5) {
				Client.cacheSprite[120].drawSprite(176 + x, 0 + y);
			}
			if (Client.getTabId() == 6) {
				if (!Client.getInventoryLayout("LANDSCAPE") && !Client.isFixedScreen()) {
					Client.cacheSprite[117].drawSprite(209 + x, 0 + y);
				}
				else {
					Client.cacheSprite[Client.isFixedScreen() ? 117 : 120].drawSprite(209 + x, 0 + y);
				}
			}


			x = Client.isFixedScreen() ? 0 : (Client.getClientWidth() - Client.getFullscreenModeMinimapX(257));
			y = Client.isFixedScreen() ? 0 : (Client.getClientHeight() - Client.getFullscreenModeChatAreaY(373));

			if (!Client.isFixedScreen()) {
				if (!Client.getInventoryLayout("LANDSCAPE")) {
					x -= 7;
				}
			}


			if (Client.getTabId() == 7) {
				Client.cacheSprite[120].drawSprite(110 + x, 298 + y);
			}
			if (Client.getTabId() == 8) {
				Client.cacheSprite[120].drawSprite(44 + x, 298 + y);
			}
			if (Client.getTabId() == 9) {
				Client.cacheSprite[120].drawSprite(77 + x, 298 + y);
			}
			if (Client.getTabId() == 11) {
				Client.cacheSprite[120].drawSprite(143 + x, 298 + y);
			}
			if (Client.getTabId() == 12) {
				Client.cacheSprite[120].drawSprite(176 + x, 298 + y);
			}
			if (Client.getTabId() == 13) {
				if (!Client.getInventoryLayout("LANDSCAPE") && !Client.isFixedScreen()) {
					Client.cacheSprite[119].drawSprite(209 + x, 297 + y);
				}
				else {
					Client.cacheSprite[Client.isFixedScreen() ? 119 : 120].drawSprite(209 + x - (Client.isFixedScreen() ? 0 : 1), 298 + y);
				}
			}
			if (Client.getTabId() == 15) {
				Client.cacheSprite[Client.isFixedScreen() ? 116 : 120].drawSprite(209 + x, 298 + y);
			}
		}
	}

	public static void drawRedStones562(Client client) {
		if (!Client.drawTabs) {
			return;
		}
		drawTabHover562(client);

		if (Client.hideInventoryInterfaceAction && !Client.isFixedScreen()) {
			return;
		}
		int x = Client.isFixedScreen() ? 0 : (Client.getClientWidth() - Client.getFullscreenModeMinimapX(444));
		int y = Client.isFixedScreen() ? 0 : (Client.getClientHeight() - Client.getFullscreenModeChatAreaY(73));
		if (Client.tabInterfaceId[Client.getTabId()] != -1) {
			if (Client.getTabId() == 0) {
				Client.cacheSprite[64].drawSprite(2 + 3 + x, 0 + y);
			}
			else if (Client.getTabId() == 1) {
				Client.cacheSprite[64].drawSprite(32 + 3 + x, 0 + y);
			}
			else if (Client.getTabId() == 2) {
				Client.cacheSprite[64].drawSprite(62 + 3 + x, 0 + y);
			}
			else if (Client.getTabId() == 14) {
				Client.cacheSprite[64].drawSprite(92 + 3 + x, 0 + y);
			}
			else if (Client.getTabId() == 3) {
				Client.cacheSprite[64].drawSprite(122 + 3 + x, 0 + y);
			}
			else if (Client.getTabId() == 4) {
				Client.cacheSprite[64].drawSprite(152 + 3 + x, 0 + y);
			}
			else if (Client.getTabId() == 5) {
				Client.cacheSprite[64].drawSprite(182 + 3 + x, 0 + y);
			}
			else if (Client.getTabId() == 6) {
				Client.cacheSprite[64].drawSprite(212 + 3 + x, 0 + y);
			}


			x = Client.isFixedScreen() ? 0 : (Client.getClientWidth() - Client.getFullscreenModeMinimapX(233));
			y = Client.isFixedScreen() ? 0 : (Client.getClientHeight() - Client.getFullscreenModeChatAreaY(372));
			if (Client.getTabId() == 16) {
				Client.cacheSprite[64].drawSprite(2 + 3 + x, 298 + y);
			}
			else if (Client.getTabId() == 8) {
				Client.cacheSprite[64].drawSprite(32 + 3 + x, 298 + y);
			}
			else if (Client.getTabId() == 9) {
				Client.cacheSprite[64].drawSprite(62 + 3 + x, 298 + y);
			}
			else if (Client.getTabId() == 7) {
				Client.cacheSprite[64].drawSprite(92 + 3 + x, 298 + y);
			}
			else if (Client.getTabId() == 11) {
				Client.cacheSprite[64].drawSprite(122 + 3 + x, 298 + y);
			}
			else if (Client.getTabId() == 12) {
				Client.cacheSprite[64].drawSprite(152 + 3 + x, 298 + y);
			}
			else if (Client.getTabId() == 13) {
				Client.cacheSprite[64].drawSprite(182 + 3 + x, 298 + y);
			}
		}
	}

	public static void drawTabHover562(Client client) {
		int x = Client.isFixedScreen() ? 0 : (Client.getClientWidth() - Client.getFullscreenModeMinimapX(444));
		int y = Client.isFixedScreen() ? 0 : (Client.getClientHeight() - Client.getFullscreenModeChatAreaY(73));
		if (!Client.isFixedScreen()) {
			y -= 1;
		}
		if (client.tabHPos == 0 && Client.tabInterfaceId[0] != -1) {
			Client.cacheSprite[63].drawSprite(6 + x, 0 + y);
		}
		else if (client.tabHPos == 1 && Client.tabInterfaceId[1] != -1) {
			Client.cacheSprite[63].drawSprite(36 + x, 0 + y);
		}
		else if (client.tabHPos == 2 && Client.tabInterfaceId[2] != -1) {
			Client.cacheSprite[63].drawSprite(66 + x, 0 + y);
		}
		else if (client.tabHPos == 3 && Client.tabInterfaceId[14] != -1) {
			Client.cacheSprite[63].drawSprite(96 + x, 0 + y);
		}
		else if (client.tabHPos == 4 && Client.tabInterfaceId[3] != -1) {
			Client.cacheSprite[63].drawSprite(126 + x, 0 + y);
		}
		else if (client.tabHPos == 5 && Client.tabInterfaceId[4] != -1) {
			Client.cacheSprite[63].drawSprite(156 + x, 0 + y);
		}
		else if (client.tabHPos == 6 && Client.tabInterfaceId[5] != -1) {
			Client.cacheSprite[63].drawSprite(186 + x, 0 + y);
		}
		else if (client.tabHPos == 7 && Client.tabInterfaceId[6] != -1) {
			Client.cacheSprite[63].drawSprite(216 + x, 0 + y);
		}

		x = Client.isFixedScreen() ? 0 : (Client.getClientWidth() - Client.getFullscreenModeMinimapX(233));
		y = Client.isFixedScreen() ? 0 : (Client.getClientHeight() - Client.getFullscreenModeChatAreaY(372));
		if (client.tabHPos == 8 && Client.tabInterfaceId[9] != -1) {
			Client.cacheSprite[63].drawSprite(36 + x, 298 + y);
		}
		else if (client.tabHPos == 9 && Client.tabInterfaceId[8] != -1) {
			Client.cacheSprite[63].drawSprite(66 + x, 298 + y);
		}
		else if (client.tabHPos == 10 && Client.tabInterfaceId[7] != -1) {
			Client.cacheSprite[63].drawSprite(96 + x, 298 + y);
		}
		else if (client.tabHPos == 11 && Client.tabInterfaceId[11] != -1) {
			Client.cacheSprite[63].drawSprite(126 + x, 298 + y);
		}
		else if (client.tabHPos == 12 && Client.tabInterfaceId[12] != -1) {
			Client.cacheSprite[63].drawSprite(156 + x, 298 + y);
		}
		else if (client.tabHPos == 13 && Client.tabInterfaceId[13] != -1) {
			Client.cacheSprite[63].drawSprite(186 + x, 298 + y);
		}
		else if (client.tabHPos == 14 && Client.tabInterfaceId[14] != -1) {
			Client.cacheSprite[63].drawSprite(216 + x, 298 + y);
		}
	}


	private static int inventoryGlowIndex = 250;

	private static boolean inventoryGlowSubtract = true;

	public static void drawTabArea(Client client) {
		if (Client.getTabId() < 0) {
			return;
		}
		if (Client.isFixedScreen()) {
			client.inventoryBackImage.initDrawingArea();
		}
		// TODO #FULLSCREEN ADJUST inventory tab
		int x = Client.isFixedScreen() ? 0 : (Client.getClientWidth() - Client.getFullscreenModeMinimapX(244));
		int y = Client.isFixedScreen() ? 0 : (Client.getClientHeight() - Client.getFullscreenModeChatAreaY(374));
		Rasterizer.offsets = client.sidebarOffsets;
		if (!Client.isFixedScreen()) {

			if (Client.getInventoryLayout("OLD")) {
				x = Client.getClientWidth() - Client.getFullscreenModeMinimapX(257);
				Client.cacheSprite[628].drawSprite(x, y);
			}
			else {
				int inventoryBackgroundY = y + 32;
				boolean is562GameFrame = Client.is562GameFrame || Client.is562PlusGameFrame;
				int inventoryLayoutSpriteId = is562GameFrame ? 636 : 622;
				int inventoryLayoutSpriteX = is562GameFrame ? 195 : 200;
				int inventoryLayoutSpriteY = is562GameFrame ? 301 : 299;
				if (Client.getInventoryLayout("DOUBLE STACK")) {
					inventoryLayoutSpriteId = 627;
					inventoryBackgroundY -= 37;
					inventoryLayoutSpriteX = 14;
					inventoryLayoutSpriteY = 262;
				}
				if (is562GameFrame) {
					inventoryBackgroundY += 2;
				}
				if (!Client.hideInventoryInterfaceAction) {
					if (!Client.isFixedScreen()) {
						if (Client.transparentTab) {
							Client.cacheSprite[908].drawSprite3(x + 31, inventoryBackgroundY, 100); // Inventory background with transparency.
						}
						else {
							Client.cacheSprite[908].drawSprite(x + 31, inventoryBackgroundY); // Inventory background for resize-able.
						}
					}
					else {
						Client.cacheSprite[623].drawSprite(x + 31, inventoryBackgroundY); // Inventory background.
					}
					Client.cacheSprite[621].drawSprite(x + 24, inventoryBackgroundY - 7); // Inventory border.
				}
				Client.cacheSprite[inventoryLayoutSpriteId].drawSprite(x - inventoryLayoutSpriteX, y + inventoryLayoutSpriteY); // Inventory tabs.
				inventoryGlow(1290, x + 30, inventoryBackgroundY - 1);
			}
		}
		if (Client.isFixedScreen()) {
			if (Client.is525GameFrame || Client.is508PlusGameFrame) {
				Client.cacheSprite[66].drawSprite(x, y);
			}
			else if (Client.is498GameFrame) {
				Client.cacheSprite[574].drawSprite(x, y);
			}
			else if (Client.is474GameFrame) {
				Client.cacheSprite[Client.is317GameFrame ? 917 : 65].drawSprite(x, y);
			}
			else if (Client.is562GameFrame || Client.is562PlusGameFrame) {
				Client.cacheSprite[67].drawSprite(x, y);
			}
			if (Client.is317GameFrame) {
				inventoryGlow(1289, x + 39, y + 37);
			} else {
				inventoryGlow(1282, x + 32, y + 37);
			}
		}
		if (Client.getInvOverlayInterfaceID() == -1 && !Client.usingEquipmentInterface) {
			if (Client.is525GameFrame || Client.is508PlusGameFrame || Client.is498GameFrame || Client.is474GameFrame && !Client.isFixedScreen()) {
				draw525RedStonesResizable(client);
				if (Client.drawTabs) {
					draw525SideIconsResizable(client);
				}
			}
			else if (Client.is474GameFrame) {
				if (Client.drawTabs) {
					if (Client.is317GameFrame) {
						drawRedStones317(client);
						drawSideIcons317(client);
					}
					else {
						draw474RedStones(client);
						draw474SideIcons(client);
					}
				}
			}
			else if (Client.is562GameFrame || Client.is562PlusGameFrame) {
				drawRedStones562(client);
				if (Client.drawTabs) {
					drawSideIcons562(client);
				}
			}
		}
		if (!Client.hideInventoryInterfaceAction && !Client.isFixedScreen() || Client.isFixedScreen()) {
			if (Client.is317GameFrame) {
				x += 6;
			}
			drawMusicBackground();
			// TODO #FULLSCREEN ADJUST inventory tab, the position of interfaces.
			int yInventory = Client.isFixedScreen() ? 0 : -6;
			int xInventory = 0;
			if (!Client.isFixedScreen()) {
				if (Client.getInventoryLayout("DOUBLE STACK")) {
					yInventory = -43;
				}
				else if (Client.getInventoryLayout("OLD")) {
					yInventory = -2;
					xInventory -= 6;
				}

				if (Client.is562GameFrame || Client.is562PlusGameFrame) {
					yInventory += 2;
				}
			}//this never had any errors at allwaiit sec

			if (Client.getInvOverlayInterfaceID() != -1) {
				client.drawInterface(0, 32 + x + xInventory, RSInterface.interfaceCache[Client.getInvOverlayInterfaceID()], 37 + y + yInventory);
			}
			else if (Client.tabInterfaceId[Client.getTabId()] != -1) {
				client.drawInterface(0, 32 + x + xInventory, RSInterface.interfaceCache[Client.tabInterfaceId[Client.getTabId()]], 37 + y + yInventory);
			}
			CombatInterface.applyCombatInterfaceTooltips();

			if (Client.instance.menuActionRow != 0) {
				if (Client.instance.menuActionName[Client.instance.menuActionRow - 1] != null) {
					String s1 = Client.instance.menuActionName[Client.instance.menuActionRow - 1];

					if (s1.contains("Vengeance") && !s1.contains("Other") && Client.getTabId() == 6) {

						//TODO #FULLSCREEN ADJUST interface, vengeance hover.
						int x1 = Client.isFixedScreen() ? 0 : (Client.getClientWidth() - Client.getFullscreenModeMinimapX(244));
						int y1 = Client.isFixedScreen() ? 0 : (Client.getClientHeight() - Client.getFullscreenModeChatAreaY(380));
						Client.cacheSprite[555].drawSprite(36 + x1, 47 + y1);
						Client.instance.newSmallFont.drawBasicString1(Client.astralRuneAmount + "/4", 62 + x1, 123 + y1, true, Client.astralRuneAmount < 4 ? 0xff0000 : 0x40ff00, true);
						Client.instance.newSmallFont.drawBasicString1(Client.deathRuneAmount + "/2", 124 + x1, 123 + y1, true, Client.deathRuneAmount < 2 ? 0xff0000 : 0x40ff00, true);
						Client.instance.newSmallFont.drawBasicString1(Client.earthRuneAmount + "/10", 180 + x1, 123 + y1, true, Client.earthRuneAmount < 10 ? 0xff0000 : 0x40ff00, true);

					}
				}
			}

			Settings.drawSettingTicks();
			Settings.drawSettingsToolTip();
			ArrowTutorial.drawTutorial(false);
		}
		if (client.menuOpen && client.getMenuScreenArea() == 1) {
			client.drawMenu();
		}
		if (Client.isFixedScreen()) {
			client.inventoryBackImage.drawGraphics(168, client.graphics, 516);
			client.inGameScreen.initDrawingArea();
		}
		Rasterizer.offsets = client.viewportOffsets;
	}


	private static void inventoryGlow(int sprite, int x, int y) {
		if (Client.getInterfaceDisplayed() != 26702) {
			return;
		}
		if (inventoryGlowSubtract) {
			if (inventoryGlowIndex > 0) {
				inventoryGlowIndex -= 6;
			} else if (inventoryGlowIndex <= 0) {
				inventoryGlowSubtract = false;
			}
		} else {

			if (inventoryGlowIndex < 250) {
				inventoryGlowIndex += 6;
			} else if (inventoryGlowIndex >= 250) {
				inventoryGlowSubtract = true;
			}
		}
		Client.cacheSprite[sprite].drawTransparentSprite(x, y, inventoryGlowIndex);
	}

	/**
	 * Draw the music background, behind the music interface.
	 */
	private static void drawMusicBackground() {

		// Bank, shop and duel arena interface.
		if (Client.getInterfaceDisplayed() == 24959 || Client.getInterfaceDisplayed() == 3824 || Client.getInterfaceDisplayed() == 6575) {
			return;
		}
		// on 474 gameframe, music tab becomes 15.
		if (Client.getTabId() == 15 || Client.getTabId() == 13) {
			//TODO #FULLSCREEN ADJUST interface, music tab background
			int x = Client.isFixedScreen() ? 0 : (Client.getClientWidth() - Client.getFullscreenModeMinimapX(244));
			int y = Client.isFixedScreen() ? 0 : (Client.getClientHeight() - Client.getFullscreenModeChatAreaY(380));
			if (!Client.isFixedScreen() && Client.getInventoryLayout("DOUBLE STACK")) {
				y -= 38;
			}

			if (!Client.isFixedScreen() && (Client.is562GameFrame || Client.is562PlusGameFrame)) {
				y += 2;
			}
			Client.cacheSprite[0].drawSprite(41 + x, 96 + y);
		}
	}

	static void processTabClick(Client client) {
		if (!Client.drawTabs) {
			return;
		}
		if (Client.getInvOverlayInterfaceID() != -1 || Client.usingEquipmentInterface) {
			return;
		}
		if (Client.getTabId() != 11) {
			Client.setShowSettingTicks(false);
		}
		else if ((Client.tabInterfaceId[11] == 17300 || Client.tabInterfaceId[11] == 17338 || Client.tabInterfaceId[11] == 17367 || Client.tabInterfaceId[11] == 17299 || Client.tabInterfaceId[11] == 26010 || Client.tabInterfaceId[11] == 26060) && Client.getTabId() == 11 && Client.getInterfaceDisplayed() != 24959 && Client.getInterfaceDisplayed() != 3824) // If bank interface not opened.
		{
			Client.setShowSettingTicks(true);
		}
		process562TabCLick(client);
	}

	private static void process562TabCLick(Client client) {
		if (!Client.is562GameFrame && !Client.is562PlusGameFrame) {
			return;
		}
		int x = client.mouseX;
		int y = client.mouseY;

		int x1Extra = Client.isFixedScreen() ? 0 : 212;
		if (!Client.isFixedScreen()) {
			x = client.mouseX - (Client.getClientWidth() - Client.getFullscreenModeMinimapX(961));
			y = client.mouseY - (Client.getClientHeight() - Client.getFullscreenModeChatAreaY(242));
		}
		try {
			if (x >= 522 && x <= 551 && y >= 168 && y < 205) {
				client.tabHPos = 0;
				Client.setTabAreaAltered(true);
			}
			else if (x >= 552 && x <= 581 && y >= 168 && y < 205) {
				client.tabHPos = 1;
				Client.setTabAreaAltered(true);
			}
			else if (x >= 582 && x <= 611 && y >= 168 && y < 205) {
				client.tabHPos = 2;
				Client.setTabAreaAltered(true);
			}
			else if (x >= 612 && x <= 641 && y >= 168 && y < 203) {
				client.tabHPos = 3;
				Client.setTabAreaAltered(true);
			}
			else if (x >= 642 && x <= 671 && y >= 168 && y < 205) {
				client.tabHPos = 4;
				Client.setTabAreaAltered(true);
			}
			else if (x >= 672 && x <= 701 && y >= 168 && y < 205) {
				client.tabHPos = 5;
				Client.setTabAreaAltered(true);
			}
			else if (x >= 702 && x <= 731 && y >= 169 && y < 205) {
				client.tabHPos = 6;
				Client.setTabAreaAltered(true);
			}
			else if (x >= 732 && x <= 761 && y >= 169 && y < 205) {
				client.tabHPos = 7;
				Client.setTabAreaAltered(true);
			}
			else if (x >= 522 + x1Extra && x <= 551 + x1Extra && (Client.isFixedScreen() ? y >= 466 && y < 503 : y >= 169 && y < 205)) {
				client.tabHPos = 15;
				Client.setTabAreaAltered(true);
			}
			else if (x >= 552 + x1Extra && x <= 581 + x1Extra && (Client.isFixedScreen() ? y >= 466 && y < 503 : y >= 169 && y < 205)) {
				client.tabHPos = 8;
				Client.setTabAreaAltered(true);
			}
			else if (x >= 582 + x1Extra && x <= 611 + x1Extra && (Client.isFixedScreen() ? y >= 466 && y < 503 : y >= 169 && y < 205)) {
				client.tabHPos = 9;
				Client.setTabAreaAltered(true);
			}
			else if (x >= 612 + x1Extra && x <= 641 + x1Extra && (Client.isFixedScreen() ? y >= 466 && y < 503 : y >= 169 && y < 205)) {
				client.tabHPos = 10;
				Client.setTabAreaAltered(true);
			}
			else if (x >= 642 + x1Extra && x <= 671 + x1Extra && (Client.isFixedScreen() ? y >= 466 && y < 503 : y >= 169 && y < 205)) {
				client.tabHPos = 11;
				Client.setTabAreaAltered(true);
			}
			else if (x >= 672 + x1Extra && x <= 701 + x1Extra && (Client.isFixedScreen() ? y >= 466 && y < 503 : y >= 169 && y < 205)) {
				client.tabHPos = 12;
				Client.setTabAreaAltered(true);
			}
			else if (x >= 702 + x1Extra && x <= 731 + x1Extra && (Client.isFixedScreen() ? y >= 466 && y < 503 : y >= 169 && y < 205)) {
				client.tabHPos = 13;
				Client.setTabAreaAltered(true);
			}

			else {
				client.tabHPos = -1;
				Client.setTabAreaAltered(true);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


}
