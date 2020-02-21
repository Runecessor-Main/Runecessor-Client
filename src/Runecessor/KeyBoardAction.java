package Runecessor;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Keyboard actions.
 */
public class KeyBoardAction {
	public static ArrayList<String> test = new ArrayList<String>();

	public static long timeChatSent;

	private static void tabToReplyPm() {
		String name = null;
		for (int k = 0; k < 100; k++) {
			if (Client.instance.chatMessages[k] == null) {
				continue;
			}
			int chatType = Client.instance.chatTypes[k];
			if (chatType == ClientConstants.CHAT_TYPE_PRIVATE_MESSAGE_RECEIVED_NORMAL
					|| chatType == ClientConstants.CHAT_TYPE_PRIVATE_MESSAGE_RECEIVED_MOD) {
				name = Client.instance.chatNames[k];
				break;
			}
		}

		if (name == null) {
			Client.instance.pushMessage("You haven't received any messages to which you can reply.",
					ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
			return;
		}
		if (name.startsWith("<img=")) {
			name = name.substring(name.indexOf(">") + 1);
		}

		long nameAsLong = TextClass.longForName(name.trim());
		int k3 = -1;
		for (int i4 = 0; i4 < Client.friendsCount; i4++) {
			if (Client.instance.friendsListAsLongs[i4] != nameAsLong) {
				continue;
			}
			k3 = i4;
			break;
		}
		boolean forceTalk = false;
		if (k3 == -1) {
			FriendSystem.addFriend(nameAsLong, Client.instance);
		}
		for (int i4 = 0; i4 < Client.friendsCount; i4++) {
			if (Client.instance.friendsListAsLongs[i4] != nameAsLong) {
				continue;
			}

			// Match found after adding the friend.
			forceTalk = true;
			k3 = i4;
			break;
		}
		if (k3 == -1) {
			Client.instance.pushMessage("Your friends list is too full to add them.",
					ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
			return;
		}
		if (Client.instance.friendsNodeIds[k3] > 0 || forceTalk) {
			Client.setUpdateChatAreaPending(true);
			Client.inputDialogState = 0;
			Client.setMessagePromptRaised(true, false);
			Client.setChatAreaInputBoxPlayerInput("");
			Client.bankSearchSent = "";
			Client.friendsListAction = 3;
			Client.instance.aLong953 = Client.instance.friendsListAsLongs[k3];
			Client.setChatAreaInputBoxTitle("Enter message to send to " + Client.instance.friendsList[k3]);
		} else {
			Client.instance.pushMessage("That player is currently offline.", ClientConstants.CHAT_TYPE_GAME_MESSAGE, "",
					"");
		}
	}

	public final static int[] CONTINUE_IDS = { 979, 968, 973, 986, 306, 4887, 4893, 356, 310, 4882, 4900, 6247, 6253,
			6206, 6216, 4443, 6242, 6211, 6226, 4272, 6231, 6258, 4282, 6263, 6221, 4416, 6237, 4277, 4261, 12122, 5267,
			4267,

	};

	public static void handleKeyboard() {
		do {
			int key = Client.instance.readChar(-796);
			if (key == -1) {
				break;
			}
			Client.lastTimeTyped = System.currentTimeMillis();
			Client.loginThenLogoutEnabled = false;
			if (!Client.isDialogueOptionsShowing() && Client.backDialogueId > 0 && Client.inputValue == -1
					&& Client.inputDialogState == 0 && !Client.isMessagePromptRaised()) {
				// Space button to trigger "continue" in the statement dialogue.
				if (key == 32) {
					for (int index = 0; index < CONTINUE_IDS.length; index++) {
						if (Client.backDialogueId == CONTINUE_IDS[index]) {
							Client.instance.stream.createFrame(40);
							Client.instance.stream.writeWord(4892);
							Client.setDialogueOptionsShowing(true);
							Client.setUpdateChatAreaPending(true);
							break;
						}
					}
				}

				// Keys 1 to 5 to trigger option 1-5/1-4/1-3/1-2 on dialogue
				// options.
				else {
					int index = key - 49;
					int packetInteger = 0;
					if (Client.backDialogueId == 2480) {
						packetInteger = 2482;
					} else if (Client.backDialogueId == 2469) {
						packetInteger = 2471;
					} else if (Client.backDialogueId == 2459) {
						packetInteger = 2461;
					} else if (Client.backDialogueId == 2492) {
						packetInteger = 2494;
					}
					if (packetInteger != 0) {
						Client.instance.stream.createFrame(185);
						Client.instance.stream.writeWord(packetInteger + index);
						Client.setDialogueOptionUsed(packetInteger + index);
					}
				}
			} else if (Client.isMessagePromptRaised()) {
				if (key >= 32 && key <= 122 && Client.getChatAreaInputBoxPlayerInput().length() < 80) {
					Client.setChatAreaInputBoxPlayerInput(Client.getChatAreaInputBoxPlayerInput() + (char) key);
					Client.setUpdateChatAreaPending(true);
				}
				if (key == 8 && Client.getChatAreaInputBoxPlayerInput().length() > 0) {
					Client.setChatAreaInputBoxPlayerInput(Client.getChatAreaInputBoxPlayerInput().substring(0,
							Client.getChatAreaInputBoxPlayerInput().length() - 1));
					Client.setUpdateChatAreaPending(true);
				}
				if (key == 13 || key == 10) {
					Client.setMessagePromptRaised(false, true);
					Content.closeSearch(true, true);
					Client.setUpdateChatAreaPending(true);
					if (Client.friendsListAction == 1) {
						long l = TextClass.longForName(Client.getChatAreaInputBoxPlayerInput());
						FriendSystem.addFriend(l, Client.instance);
					}
					if (Client.friendsListAction == 2 && Client.friendsCount > 0) {
						long l1 = TextClass.longForName(Client.getChatAreaInputBoxPlayerInput());
						FriendSystem.deleteFriend(l1, Client.instance);
					}

					// Send private message packet to server.
					if (Client.friendsListAction == 3 && Client.getChatAreaInputBoxPlayerInput().length() > 0) {
						Client.instance.stream.createFrame(126);
						Client.instance.stream.writeWordBigEndian(0);
						int k = Client.instance.stream.currentOffset;
						Client.instance.stream.writeQWord(Client.instance.aLong953);
						TextInput.method526(Client.getChatAreaInputBoxPlayerInput(), Client.instance.stream);
						Client.instance.stream.writeBytes(Client.instance.stream.currentOffset - k);
						Client.setChatAreaInputBoxPlayerInput(
								TextInput.processText(Client.getChatAreaInputBoxPlayerInput()));
						Client.instance.pushMessage(Client.getChatAreaInputBoxPlayerInput(),
								ClientConstants.CHAT_TYPE_PRIVATE_MESSAGE_SENT,
								TextClass.fixName(TextClass.nameForLong(Client.instance.aLong953)),
								TextClass.fixName(TextClass.nameForLong(Client.instance.aLong953)));
						if (Client.instance.privateChatMode == 2) {
							Client.instance.privateChatMode = 1;
							Client.instance.stream.createFrame(95);
							Client.instance.stream.writeWordBigEndian(Client.instance.publicChatMode);
							Client.instance.stream.writeWordBigEndian(Client.instance.privateChatMode);
							Client.instance.stream.writeWordBigEndian(Client.instance.tradeMode);
						}
					}
					if (Client.friendsListAction == 4 && Client.instance.ignoreCount < 100) {
						long l2 = TextClass.longForName(Client.getChatAreaInputBoxPlayerInput());
						FriendSystem.addIgnore(l2, Client.instance);
					}
					if (Client.friendsListAction == 5 && Client.instance.ignoreCount > 0) {
						long l3 = TextClass.longForName(Client.getChatAreaInputBoxPlayerInput());
						FriendSystem.deleteIgnore(l3, Client.instance);
					}
					if (Client.friendsListAction == 6) {
						long l3 = TextClass.longForName(Client.getChatAreaInputBoxPlayerInput());
						Client.instance.chatJoin(l3);
					} else if (Client.inputValue == 11 && Client.getChatAreaInputBoxPlayerInput().length() >= 1) {
						Client.instance.sendCommandPacket("::mapvalidility" + Client.getChatAreaInputBoxPlayerInput());
					} else if (Client.inputValue == 12 && Client.getChatAreaInputBoxPlayerInput().length() >= 1) {
						Client.instance.sendCommandPacket("::ccban" + Client.getChatAreaInputBoxPlayerInput());
					} else if (Client.inputValue == 13 && Client.getChatAreaInputBoxPlayerInput().length() >= 1) {
						Client.instance.sendCommandPacket("::ccmod" + Client.getChatAreaInputBoxPlayerInput());
					} else if (Client.inputValue == 14 && Client.getChatAreaInputBoxPlayerInput().length() >= 1) {
						Client.instance.sendCommandPacket("::cctitle" + Client.getChatAreaInputBoxPlayerInput());
					} else if (Client.inputValue == 15 && Client.getChatAreaInputBoxPlayerInput().length() >= 1) {
						Client.instance.sendCommandPacket("::namechange" + Client.getChatAreaInputBoxPlayerInput());
					} else if (Client.inputValue == 16 && Client.getChatAreaInputBoxPlayerInput().length() >= 1) {
						Client.instance
								.sendCommandPacket("::addpvpblacklist" + Client.getChatAreaInputBoxPlayerInput());
					} else if (Client.inputValue == 17 && Client.getChatAreaInputBoxPlayerInput().length() >= 1) {
						Client.instance.sendCommandPacket("::namepreset" + Client.getChatAreaInputBoxPlayerInput());
					}
				}
			} else if (Client.inputDialogState == 1) {
				if (key >= 48 && key <= 57 && Client.instance.amountOrNameInput.length() < 10) {
					Client.instance.amountOrNameInput += (char) key;
					Client.setUpdateChatAreaPending(true);
				}
				if ((!Client.instance.amountOrNameInput.toLowerCase().contains("k")
						&& !Client.instance.amountOrNameInput.toLowerCase().contains("m")
						&& !Client.instance.amountOrNameInput.toLowerCase().contains("b")) && (key == 107 || key == 109)
						|| key == 98 || key == 66 || key == 75 || key == 77) {
					Client.instance.amountOrNameInput += (char) key;
					Client.setUpdateChatAreaPending(true);
				}
				if (key == 8 && Client.instance.amountOrNameInput.length() > 0) {
					Client.instance.amountOrNameInput = Client.instance.amountOrNameInput.substring(0,
							Client.instance.amountOrNameInput.length() - 1);
					Client.setUpdateChatAreaPending(true);
				}
				if (key == 13 || key == 10) {
					if (Client.instance.amountOrNameInput.length() > 0) {
						if (Client.instance.amountOrNameInput.toLowerCase().contains("k")) {
							Client.instance.amountOrNameInput = Client.instance.amountOrNameInput.replaceAll("k",
									"000");
							Client.instance.amountOrNameInput = Client.instance.amountOrNameInput.replaceAll("K",
									"000");
						} else if (Client.instance.amountOrNameInput.toLowerCase().contains("m")) {
							Client.instance.amountOrNameInput = Client.instance.amountOrNameInput.replaceAll("m",
									"000000");
							Client.instance.amountOrNameInput = Client.instance.amountOrNameInput.replaceAll("M",
									"000000");
						} else if (Client.instance.amountOrNameInput.toLowerCase().contains("b")) {
							Client.instance.amountOrNameInput = Client.instance.amountOrNameInput.replaceAll("b",
									"000000000");
							Client.instance.amountOrNameInput = Client.instance.amountOrNameInput.replaceAll("B",
									"000000000");
						}
						int amount = 0;
						try {
							long amount1 = Long.parseLong(Client.instance.amountOrNameInput);
							if (amount1 > Integer.MAX_VALUE) {
								amount1 = Integer.MAX_VALUE;
							}
							amount = (int) amount1;
						} catch (Exception e) {
							if (ClientDebugConfiguration.PRINT_ALL_EXCEPTION) {
								e.printStackTrace();
							}
						}
						Client.instance.stream.createFrame(208);
						Client.instance.stream.writeDWord(amount);
					} else {

						Client.instance.stream.createFrame(208);
						Client.instance.stream.writeDWord(0);
					}
					Client.inputDialogState = 0;
					Client.setUpdateChatAreaPending(true);

					if (!Client.searching) {
						Content.closeSearch(true, true);
					} else {
						Client.setIgnorePromptInputReset(true);
						Content.openSearch("Enter an item to search for");
						Client.setIgnorePromptInputReset(false);
					}
				}
			} else if (Client.inputDialogState == 2) {
				if (key >= 32 && key <= 122 && Client.instance.amountOrNameInput.length() < 12) {
					Client.instance.amountOrNameInput += (char) key;
					Client.setUpdateChatAreaPending(true);
				}
				if (key == 8 && Client.instance.amountOrNameInput.length() > 0) {
					Client.instance.amountOrNameInput = Client.instance.amountOrNameInput.substring(0,
							Client.instance.amountOrNameInput.length() - 1);
					Client.setUpdateChatAreaPending(true);
				}
				if (key == 13 || key == 10) {
					if (Client.instance.amountOrNameInput.length() > 0) {
						Client.instance.stream.createFrame(60);
						Client.instance.stream.writeQWord(TextClass.longForName(Client.instance.amountOrNameInput));
					}
					Client.inputDialogState = 0;
					Client.setUpdateChatAreaPending(true);
				}
			} else if (Client.backDialogueId == -1) {
				if (key >= 32 && key <= 122) {
					if (Client.customCameraPosition && (key == 122 || key == 120 || key == 99 || key == 118)) {
						switch (key) {

						// Z
						case 122:
							Client.zCameraPos -= 5;
							break;

						// X
						case 120:
							Client.zCameraPos += 5;
							break;

						// C
						case 99:
							Client.xCameraCurve += 5;
							if (Client.xCameraCurve > 2035) {
								Client.xCameraCurve = 0;
							}
							break;

						// V
						case 118:
							Client.yCameraCurve += 5;
							if (Client.yCameraCurve > 375) {
								Client.yCameraCurve = 128;
							}
							break;
						}
						return;
					}
					if (Client.profileSearching) {
						if (Client.profileSearchString.length() < 12) {
							Client.profileSearchString += (char) key;
						}
					} else if (Client.shopSearching) {
						if (Client.shopString.length() < 12) {
							Client.shopString += (char) key;
						}
					} else if (Client.profileBiographyLineEdited > 0) {
						if (Client.profileBiographyText.length() < 41) {
							Client.profileBiographyText += (char) key;
						}
					} else if (Client.instance.inputString.length() < 80) {
						Client.instance.inputString += (char) key;
						Client.setUpdateChatAreaPending(true);
					}
				}

				// Backspace
				if (key == 8) {
					if (Client.profileSearching && Client.profileSearchString.length() > 0) {
						Client.profileSearchString = Client.profileSearchString.substring(0,
								Client.profileSearchString.length() - 1);
					} else if (Client.shopSearching && Client.shopString.length() > 0) {
						Client.shopString = Client.shopString.substring(0, Client.shopString.length() - 1);
					} else if (Client.profileBiographyLineEdited > 0 && Client.profileBiographyText.length() > 0) {
						Client.profileBiographyText = Client.profileBiographyText.substring(0,
								Client.profileBiographyText.length() - 1);
					} else if (Client.instance.inputString.length() > 0) {
						Client.instance.inputString = Client.instance.inputString.substring(0,
								Client.instance.inputString.length() - 1);
						Client.setUpdateChatAreaPending(true);
					}
				}
				if (key == 9) {
					tabToReplyPm();
				}

				if ((key == 13 || key == 10) && Client.profileSearching) {
					Profile.sendProfileSearch();
					Profile.stopSearching(false);
				} else if ((key == 13 || key == 10) && Client.shopSearching) {
					Client.shopSearching = false;
					Client.shopString = "";
					Client.instance.sendCommandPacket("::shopsearch");
				} else if ((key == 13 || key == 10) && Client.profileBiographyLineEdited > 0) {
					Profile.sendProfileBiographyToServer();
				} else if ((key == 13 || key == 10) && Client.instance.inputString.length() > 0) {
					boolean refuse = false;
					if (Client.instance.inputString.toLowerCase().equals("::transparenttab")) {
						Client.transparentTab = !Client.transparentTab;
						Client.instance.pushMessage("Transparent tab: " + Client.transparentTab,
								ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
						Settings.saveSettings();
					} else if (Client.instance.inputString.toLowerCase().equals("::transparentchat")) {
						Client.transparentChat = !Client.transparentChat;
						Client.instance.pushMessage("Transparent chat: " + Client.transparentChat,
								ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
						Settings.saveSettings();
					} else if (Client.instance.inputString.toLowerCase().equals("::donate")) {
						Client.instance.launchURL("https://runecessor.com/forum/index.php?/store/");
						
					} else if (Client.instance.inputString.toLowerCase().equals("::vote")) {
						Client.instance.launchURL("https://Runecessor.com/forum/index.php?/vote/");
					} else if (Client.instance.inputString.toLowerCase().equals("::hs")) {
						Client.instance.launchURL("https://Runecessor.com/forum/index.php?/Highscores/");
					} else if (Client.instance.inputString.toLowerCase().equals("::rules")) {
						Client.instance.launchURL("https://Runecessor.com/forum/index.php?/topic/96-official-rules/");
					} else if (Client.instance.inputString.toLowerCase().equals("::bug")) {
						Client.instance.launchURL("https://runecessor.com/forum/index.php?/forum/38-report-a-bug/");
					} else if (Client.instance.inputString.toLowerCase().equals("::help")) {
						Client.instance.launchURL("https://Runecessor.com/forum/index.php?/topic/98-help/");
					} else if (Client.instance.inputString.toLowerCase().equals("::appeal")) {
						Client.instance.launchURL("https://Runecessor.com/forum/index.php?/forum/20-appeals/&page=1");
					} else if (Client.instance.inputString.toLowerCase().equals("::staffapp")) {					
						Client.instance.launchURL("https://Runecessor.com/forum/index.php?/forum/25-applications/");
					
					} else if (Client.instance.inputString.toLowerCase().equals("::fps")) {
						Client.fpsOn = !Client.fpsOn;
						Client.instance.pushMessage("Fps set to: " + Client.fpsOn,
								ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");

					} else if (Client.instance.inputString.toLowerCase().equals("::angle")) {
						Client.customCameraPosition = !Client.customCameraPosition;
						Client.instance.pushMessage(
								"Use arrow keys and zxcv to navigate camera set to: " + Client.customCameraPosition,
								ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
						Client.instance.pushMessage("Go to settings to slow down the camera movement.",
								ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
						Client.instance.pushMessage("Type ::angle to turn it off.",
								ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
					} else if (Client.instance.inputString.toLowerCase().startsWith("::type")) {
						Client.autoType = !Client.autoType;
						if (Client.instance.inputString.toLowerCase().equals("::type") && Client.autoType
								&& !Client.autoTypeText.isEmpty()) {
							Client.instance.pushMessage("Auto typer has been resumed.",
									ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
						} else {
							if (Client.instance.inputString.toLowerCase().startsWith("::type ") && !Client.autoType
									&& !Client.autoTypeText.isEmpty()) {
								Client.autoType = true;
							}
							if (Client.autoType) {
								boolean successful = false;
								if (Client.instance.inputString.length() >= 8) {
									String text = Client.instance.inputString.substring(7);
									if (!text.isEmpty()) {
										Client.autoTypeText = text;
										successful = true;
										Client.instance.pushMessage("Auto typer has been changed.",
												ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
									}
								}
								if (!successful) {
									Client.autoType = false;
									Client.instance.pushMessage(
											"Please type in ::type advertismentHere to start autotyping.",
											ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
								}
							} else {
								Client.instance.pushMessage("Auto typer has been paused.",
										ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
							}
						}
					} else if (Client.instance.inputString.toLowerCase().equals("::toggletitles")) {
						Client.titlesInWild = !Client.titlesInWild;
						Settings.saveSettingsJframe();
						Client.instance.pushMessage("Player titles in Pvp set to: " + Client.titlesInWild,
								ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");

					} else if (Client.instance.inputString.toLowerCase().equals("::togglemaximizable")) {
						if (Client.isFixedScreen()) {
							Client.maximizable = !Client.maximizable;
							ClientFrame.frame.setResizable(Client.maximizable);
							Settings.saveSettingsJframe();
							Client.instance.pushMessage("Maximizing client set to: " + Client.maximizable,
									ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
							ClientFrame.setPreferredSize();
						} else {
							Client.instance.pushMessage("This only works on fixed mode.",
									ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
						}
					} else if (Client.instance.inputString.toLowerCase().equals("::facing")) {
						Client.instance.pushMessage("client facing: " + Client.myPlayer.turnDirection + ".", 0, "", "");
					} else if (Client.instance.inputString.toLowerCase().equals("::toggleclickfix")) {
						Client.mouseRightClickFix = !Client.mouseRightClickFix;
						Settings.saveSettingsJframe();
						Client.instance.pushMessage("Right click fix set to: " + Client.mouseRightClickFix,
								ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
					} else if (Client.instance.inputString.toLowerCase().equals("::snow")) {
						Client.groundSnow = !Client.groundSnow;
						Settings.saveSettingsJframe();
						Client.instance.pushMessage("Ground snow set to: " + Client.groundSnow,
								ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
						StreamLoader streamLoader = Client.instance.streamLoaderForName(2, "config", "config",
								Client.instance.expectedCRCs[2], 30);
						FloorDefinition.unpackConfig(streamLoader);
						Client.instance.setLoadingStage(1);
					} else if (Client.instance.inputString.toLowerCase().equals("::lightsnow")) {
						Client.lightSnow = !Client.lightSnow;
						Client.groundSnow = false;
						Settings.saveSettingsJframe();
						Client.instance.pushMessage("Light snow set to: " + Client.lightSnow,
								ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
						StreamLoader streamLoader = Client.instance.streamLoaderForName(2, "config", "config",
								Client.instance.expectedCRCs[2], 30);
						FloorDefinition.unpackConfig(streamLoader);
						Client.instance.setLoadingStage(1);
					} else if (Client.instance.inputString.toLowerCase().equals("::snowparticles")) {
						Client.snowParticles = !Client.snowParticles;
						Settings.saveSettingsJframe();
						Client.instance.pushMessage("Snow particles set to: " + Client.snowParticles,
								ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
					}
					else if (Client.instance.inputString.toLowerCase().equals("::colour")) {
						Client.itemRarityColour = !Client.itemRarityColour;
						Settings.saveSettings();
						Client.instance.pushMessage("Item rarity colour set to: " + Client.itemRarityColour, ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
					}
					else if (Client.instance.inputString.toLowerCase().equals("::togglenpcclick")) {
						Client.npcAttackOptions++;
						if (Client.npcAttackOptions > 2) {
							Client.npcAttackOptions = 0;
						}
						String text = "";
						switch (Client.npcAttackOptions) {
							case 0 :
								text = "right click if npc is higher combat level";
								break;
							case 1 :
								text = "always right click";
								break;
							case 2 :
								text = "always left click";
								break;
						}
						Settings.saveSettings();
						Client.instance.pushMessage("NPC attack options is set to: " + text + ".", ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
					}
					else if (Client.instance.inputString.toLowerCase().equals("::defaultplayer")) {
						Client.playerAttackOptions = 0;
						Settings.saveSettings();
						Client.instance.pushMessage("Player attack options set to default OSRS style.", ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
					}
					else if (Client.instance.inputString.toLowerCase().equals("::hiddenplayer")) {
						Client.playerAttackOptions = 1;
						Settings.saveSettings();
						Client.instance.pushMessage("Player attack options set to hidden.", ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
					}
					else if (Client.instance.inputString.toLowerCase().equals("::rightclickplayer")) {
						Client.playerAttackOptions = 2;
						Settings.saveSettings();
						Client.instance.pushMessage("Player attack options set to right click only.", ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
					}
					else if (Client.instance.inputString.toLowerCase().equals("::leftclickplayer")) {
						Client.playerAttackOptions = 3;
						Settings.saveSettings();
						Client.instance.pushMessage("Player attack options set to left click only.", ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
					}

					else if (Client.instance.inputString.toLowerCase().equals("::small")) {
						Client.overlayTextSize = 0;
						Settings.saveSettings();
						Client.instance.pushMessage("Item overlay text size set to small", ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
					}
					else if (Client.instance.inputString.toLowerCase().equals("::checkvalue")) {
						Settings.saveSettings();
						Client.instance.pushMessage("Minimum overlay value is " + Client.customValueToShow, ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
					}
					else if (Client.instance.inputString.toLowerCase().equals("::hide")) {
						Client.hideNoValueItems = !Client.hideNoValueItems;
						Settings.saveSettings();
						Client.instance.pushMessage("Hide item overlay for zero value items set to:  " + Client.hideNoValueItems, ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
					}
					else if (Client.instance.inputString.toLowerCase().equals("::regular")) {
						Client.overlayTextSize = 1;
						Settings.saveSettings();
						Client.instance.pushMessage("Item overlay text size set to regular", ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
					}
					else if (Client.instance.inputString.toLowerCase().equals("::resetautochat")) {
						Client.autoTypeText = "";
						Client.instance.pushMessage("Autochat message cleared.", ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
					}
					else if (Client.instance.inputString.toLowerCase().equals("::autochat")) {
						Client.instance.pushMessage("testing12345.", ClientConstants.CHAT_TYPE_AUTOCHAT, "", "");
					}
                    else if (Client.instance.inputString.toLowerCase().startsWith("::largemessage")) {
					    String[] split = Client.instance.inputString.split(" ");

					    int length = split.length <= 1 ? 227 : Integer.parseInt(split[1]);

					    StringBuilder message = new StringBuilder();

					    //228 is magicn umber
					    for (int index = 0; index < length; index++) {
					        message.append(0);
                        }
                        Client.instance.stream.createFrame(103);
                        Client.instance.stream.writeWordBigEndian(message.length() - 1);
                        Client.instance.stream.writeString(message.substring(2));
                    }
					else if (Client.instance.inputString.toLowerCase().equals("::large")) {
						Client.overlayTextSize = 2;
						Settings.saveSettings();
						Client.instance.pushMessage("Item overlay text size set to large", ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
					}
					else if (Client.instance.inputString.toLowerCase().equals("::value")) {
						Client.displayItemOverlayValue = !Client.displayItemOverlayValue;
						Settings.saveSettings();
						Client.instance.pushMessage("Value toggle set to: " + Client.displayItemOverlayValue, ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
					}
					else if (Client.instance.inputString.toLowerCase().equals("::overlay")) {
						Client.groundItemOverlay = !Client.groundItemOverlay;
						Settings.saveSettings();
						Client.instance.pushMessage("Item overlay toggle set to: " + Client.groundItemOverlay, ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
					} else if (Client.instance.inputString.toLowerCase().equals("::toggletrees")) {
						Client.toggleTrees = !Client.toggleTrees;
						Settings.saveSettingsJframe();
						Client.instance.pushMessage("Christmas tree toggle set to : " + Client.toggleTrees,
								ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
						StreamLoader streamLoader = Client.instance.streamLoaderForName(2, "config", "config",
								Client.instance.expectedCRCs[2], 30);
						ObjectDefinition.unpackConfig(streamLoader);
						Client.instance.setLoadingStage(1);
					} else if (Client.instance.inputString.toLowerCase().equals("::toggleitems")
							&& ClientDebugConfiguration.DEBUG_MODE) {
						/*
						 * Client.toggleItems = !Client.toggleItems;
						 * 
						 * // Dragon javelin projectile model. if
						 * (Client.toggleItems) { Runecessor.SpotAnim.cache[1301].model =
						 * 48589; } else { Runecessor.SpotAnim.cache[1301].model = 31497; }
						 * Settings.saveSettingsJframe(); Client.instance.
						 * pushMessage("Pre eoc item appearance toggle set to : "
						 * + Client.toggleItems,
						 * ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
						 * Runecessor.StreamLoader streamLoader =
						 * Client.instance.streamLoaderForName(2, "config",
						 * "config", Client.instance.expectedCRCs[2], 30);
						 * ItemDefinition.unpackConfig(streamLoader);
						 * Client.instance.setLoadingStage(1);
						 */
						Client.instance.pushMessage("This feature is no longer available.",
								ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
					} else if (Client.instance.inputString.toLowerCase().startsWith("::drag")) {
						try {
							int drag = Integer.parseInt(Client.instance.inputString.substring(7));
							Client.instance.pushMessage("Previous item drag: " + Client.draggingSensitivity,
									ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
							Client.draggingSensitivity = drag;
							Client.instance.pushMessage("Item drag set to: " + drag,
									ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
							Settings.saveSettings();

						} catch (Exception e) {
							Client.instance.pushMessage("Use as ::drag 12 (5-15 is suggested)",
									ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
						}

					}
					// End of Remove these for the live client dataon/off and m
					// and lag and m
					else if (Client.instance.inputString.startsWith("//")) {
						Client.instance.inputString = "::chat" + Client.instance.inputString;
						Client.instance.stream.createFrame(103);
						Client.instance.stream.writeWordBigEndian(Client.instance.inputString.length() - 1);
						Client.instance.stream.writeString(Client.instance.inputString.substring(2));
					} else if (Client.instance.inputString.startsWith("/")) {
						Client.instance.inputString = "::" + Client.instance.inputString;
						Client.instance.stream.createFrame(103);
						Client.instance.stream.writeWordBigEndian(Client.instance.inputString.length() - 1);
						Client.instance.stream.writeString(Client.instance.inputString.substring(2));
					} else if (Client.instance.inputString.startsWith("::")) {
						if (ClientDebugConfiguration.DEBUG_MODE) {
							if (Client.instance.inputString.toLowerCase().equals("::test")) {
								Client.dumpidx(1, 35118, 35118);
							} else if (Client.instance.inputString.toLowerCase().equals("::npcinvisibleclient")) {
								for (int index = 0; index < Client.npcInvisible.size(); index++) {
									Utility.print(Client.npcInvisible.get(index));
								}

								for (int index = 0; index < Client.instance.npcArray.length; index++) {
									Npc npc = Client.instance.npcArray[index];
									if (npc == null) {
										continue;
									}
									String name = "null";
									EntityDefinition definition = npc.desc;
									if (definition != null) {
										String name1 = "empty";
										if (definition.name != null) {
											name1 = definition.name;
										}
										Utility.print("Array: " + index + ", " + definition.type + ", " + name1 + ", "
												+ npc.x + ", " + npc.y + ", " + npc.height);
									}
								}
							} else if (Client.instance.inputString.toLowerCase().equals("::dumpitemimages")) {
								Client.dumpItemImages(true);
							} else if (Client.instance.inputString.toLowerCase().equals("::dumpitemdefs")) {
								test.clear();
								for (int index = 0; index < ItemDefinition.totalItems; index++) {
									if (ItemDefinition.forId(index) != null) {
										if (ItemDefinition.forId(index).name != null) {
											if (!ItemDefinition.forId(index).name.toLowerCase().contains("null")) {
												ItemDefinition itemDefinition = ItemDefinition.forId(index);
												test.add("case " + index + ":");
												test.add("itemDefinition.name = \"" + itemDefinition.name + "\";");
												if (itemDefinition.inventoryModel != 0) {
													test.add("itemDefinition.inventoryModel = "
															+ itemDefinition.inventoryModel + ";");
												}
												if (itemDefinition.maleModel >= 1) {
													test.add("itemDefinition.maleModel = " + itemDefinition.maleModel
															+ ";");
												}
												if (itemDefinition.maleEquip2 >= 1) {
													test.add("itemDefinition.maleEquip2 = " + itemDefinition.maleEquip2
															+ ";");
												}
												if (itemDefinition.maleEquipOffset != 0) {
													test.add("itemDefinition.maleEquipOffset = "
															+ itemDefinition.maleEquipOffset + ";");
												}
												if (itemDefinition.femaleModel != 0) {
													test.add("itemDefinition.femaleModel = "
															+ itemDefinition.femaleModel + ";");
												}
												if (itemDefinition.femaleEquip2 >= 1) {
													test.add("itemDefinition.femaleEquip2 = "
															+ itemDefinition.femaleEquip2 + ";");
												}
												if (itemDefinition.femaleEquipOffset != 0) {
													test.add("itemDefinition.femaleEquipOffset = "
															+ itemDefinition.femaleEquipOffset + ";");
												}
												if (itemDefinition.zoom != 0) {
													test.add("itemDefinition.zoom = " + itemDefinition.zoom + ";");
												}
												if (itemDefinition.rotationX != 0) {
													test.add("itemDefinition.rotationX = " + itemDefinition.rotationX
															+ ";");
												}
												if (itemDefinition.rotationY != 0) {
													test.add("itemDefinition.rotationY = " + itemDefinition.rotationY
															+ ";");
												}
												if (itemDefinition.rotationZ != 0) {
													test.add("itemDefinition.rotationZ = " + itemDefinition.rotationZ
															+ ";");
												}
												if (itemDefinition.inventoryX != 0) {
													test.add("itemDefinition.inventoryX = " + itemDefinition.inventoryX
															+ ";");
												}
												if (itemDefinition.inventoryY != 0) {
													test.add("itemDefinition.inventoryY = " + itemDefinition.inventoryY
															+ ";");
												}
												if (itemDefinition.brightness != 0) {
													test.add("itemDefinition.brightness = " + itemDefinition.brightness
															+ ";");
												}
												if (itemDefinition.contrast != 0) {
													test.add("itemDefinition.contrast = " + itemDefinition.contrast
															+ ";");
												}
												if (itemDefinition.scaleX != 128) {
													test.add("itemDefinition.scaleX = " + itemDefinition.scaleX + ";");
												}
												if (itemDefinition.scaleY != 128) {
													test.add("itemDefinition.scaleY = " + itemDefinition.scaleY + ";");
												}
												if (itemDefinition.scaleZ != 128) {
													test.add("itemDefinition.scaleZ = " + itemDefinition.scaleZ + ";");
												}
												if (itemDefinition.inventoryOptions != null) {
													test.add("itemDefinition.inventoryOptions = new String["
															+ itemDefinition.inventoryOptions.length + "];");
													for (int i = 0; i < itemDefinition.inventoryOptions.length; i++) {
														if (itemDefinition.inventoryOptions[i] == null) {
															test.add("itemDefinition.inventoryOptions[" + i
																	+ "] = null;");
														} else {
															test.add("itemDefinition.inventoryOptions[" + i + "] = \""
																	+ itemDefinition.inventoryOptions[i] + "\";");
														}
													}
												}
												if (itemDefinition.modelColourToEdit != null) {
													test.add("itemDefinition.modelColourToEdit = new int["
															+ itemDefinition.modelColourToEdit.length + "];");
													for (int i = 0; i < itemDefinition.modelColourToEdit.length; i++) {
														test.add("itemDefinition.modelColourToEdit[" + i + "] = "
																+ itemDefinition.modelColourToEdit[i] + ";");
													}
												}
												if (itemDefinition.newModelColourProduced != null) {
													test.add("itemDefinition.newModelColourProduced = new int["
															+ itemDefinition.newModelColourProduced.length + "];");
													for (int i = 0; i < itemDefinition.newModelColourProduced.length; i++) {
														test.add("itemDefinition.newModelColourProduced[" + i + "] = "
																+ itemDefinition.newModelColourProduced[i] + ";");
													}
												}
												test.add("break;");
												test.add("");
											}
										}
									}
								}

								String location = "item_definitions.txt";
								Utility.deleteAllLines(location);
								Utility.saveArrayContents(location, test);
								Utility.print("Dumped: " + test.size());
								test.clear();
								// Client.dumpItemImages(true);
							}

							else if (Client.instance.inputString.toLowerCase().equals("::dumpnpcdefs")) {
								test.clear();
								for (int index = 0; index < EntityDefinition.total; index++) {
									if (EntityDefinition.forId(index) != null) {
										if (EntityDefinition.forId(index).name != null) {
											if (!EntityDefinition.forId(index).name.toLowerCase().contains("null")) {
												EntityDefinition npc = EntityDefinition.forId(index);
												test.add("case " + index + ":");
												test.add("npc.name = \"" + npc.name + "\";");
												if (npc.combatLevel > 0) {
													test.add("npc.combatLevel = " + npc.combatLevel + ";");
												}
												if (npc.size != 0) {
													test.add("npc.size = " + npc.size + ";");
												}
												if (npc.standAnim != 0) {
													test.add("npc.standAnim = " + npc.standAnim + ";");
												}
												if (npc.walkAnim != 0) {
													test.add("npc.walkAnim = " + npc.walkAnim + ";");
												}
												if (npc.turnLeftSequence != 0) {
													test.add("npc.turnLeftSequence = " + npc.turnLeftSequence + ";");
												}
												if (npc.turnRightSequence != 0) {
													test.add("npc.turnRightSequence = " + npc.turnRightSequence + ";");
												}
												if (npc.turn180Sequence != 0) {
													test.add("npc.turn180Sequence = " + npc.turn180Sequence + ";");
												}
												if (npc.turnSpeed != 0) {
													test.add("npc.turnSpeed = " + npc.turnSpeed + ";");
												}
												if (npc.varbit != 0) {
													test.add("npc.varbit = " + npc.varbit + ";");
												}
												if (npc.setting != 0) {
													test.add("npc.setting = " + npc.setting + ";");
												}
												if (npc.headicons != 0) {
													test.add("npc.headicons = " + npc.headicons + ";");
												}
												if (npc.brightness != 0) {
													test.add("npc.brightness = " + npc.brightness + ";");
												}
												if (npc.brightness != 0) {
													test.add("npc.brightness = " + npc.brightness + ";");
												}
												if (npc.scaleZ != 0) {
													test.add("npc.scaleZ = " + npc.scaleZ + ";");
												}
												if (npc.scaleX != 0) {
													test.add("npc.scaleX = " + npc.scaleX + ";");
												}
												if (npc.contrast != 0) {
													test.add("npc.contrast = " + npc.contrast + ";");
												}
												if (npc.interactable) {
													test.add("npc.interactable = " + npc.interactable + ";");
												}
												if (npc.showOnMinimap) {
													test.add("npc.showOnMinimap = " + npc.showOnMinimap + ";");
												}
												if (npc.hasRenderPriority) {
													test.add("npc.hasRenderPriority = " + npc.hasRenderPriority + ";");
												}
												if (npc.actions != null) {
													test.add("npc.actions = new String[" + npc.actions.length + "];");
													for (int i = 0; i < npc.actions.length; i++) {
														if (npc.actions[i] == null) {
															test.add("npc.actions[" + i + "] = null;");
														} else {
															test.add("npc.actions[" + i + "] = \"" + npc.actions[i]
																	+ "\";");
														}
													}
												}
												if (npc.models != null) {
													test.add("npc.models = new int[" + npc.models.length + "];");
													for (int i = 0; i < npc.models.length; i++) {
														test.add("npc.models[" + i + "] = " + npc.models[i] + ";");
													}
												}
												if (npc.modelColourToEdit != null) {
													test.add("npc.modelColourToEdit = new int["
															+ npc.modelColourToEdit.length + "];");
													for (int i = 0; i < npc.modelColourToEdit.length; i++) {
														test.add("npc.modelColourToEdit[" + i + "] = "
																+ npc.modelColourToEdit[i] + ";");
													}
												}
												if (npc.newModelColourProduced != null) {
													test.add("npc.newModelColourProduced = new int["
															+ npc.newModelColourProduced.length + "];");
													for (int i = 0; i < npc.newModelColourProduced.length; i++) {
														test.add("npc.newModelColourProduced[" + i + "] = "
																+ npc.newModelColourProduced[i] + ";");
													}
												}
												if (npc.childrenIDs != null) {
													test.add("npc.childrenIDs = new int[" + npc.childrenIDs.length
															+ "];");
													for (int i = 0; i < npc.childrenIDs.length; i++) {
														test.add("npc.childrenIDs[" + i + "] = " + npc.childrenIDs[i]
																+ ";");
													}
												}
												test.add("break;");
												test.add("");
											}
										}
									}
								}

								String location = "npc_definitions.txt";
								Utility.deleteAllLines(location);
								Utility.saveArrayContents(location, test);
								Utility.print("Dumped: " + test.size());
								test.clear();
								// Client.dumpItemImages(true);
							} else if (Client.instance.inputString.toLowerCase().equals("::dumpitems")) {
								test.clear();
								for (int index = 0; index < ItemDefinition.totalItems; index++) {
									ItemDefinition data = ItemDefinition.forId(index);
									if (data == null) {
										continue;
									}
									if (data.name == null) {
										continue;
									}
									if (data.name.isEmpty()) {
										continue;
									}
									if (data.name.toLowerCase().contains("null")) {
										continue;
									}
									test.add(index + " " + data.name);
								}

								String location = "item_list.txt";
								Utility.deleteAllLines(location);
								Utility.saveArrayContents(location, test);
								Utility.print("Dumped: " + test.size());
								test.clear();
							} else if (Client.instance.inputString.toLowerCase().equals("::compare_npcs")) {
								// Compare old npc list with new one to see if
								// any names have changes.
								ArrayList<String> data = new ArrayList<String>();
								ArrayList<String> data1 = new ArrayList<String>();

								data = Utility.readFile("156 npcs.txt");
								data1 = Utility.readFile("161 npcs.txt");

								Utility.print("here1: " + data.size() + ", " + data1.size());
								for (int index = 0; index < data.size(); index++) {
									String[] parse = data.get(index).split(" ");
									try {
										String oldName = data.get(index).replaceAll(parse[0] + " ", "");
										for (int i = 0; i < data1.size(); i++) {
											String[] parse1 = data1.get(i).split(" ");
											String newName = data1.get(i).replaceAll(parse1[0] + " ", "");
											if (parse[0].equals(parse1[0])) {
												if (!newName.equals(oldName)) {
													Utility.print(parse[0] + ", old: " + oldName + ", new: " + newName);
												}
												break;
											}
										}
									} catch (Exception e) {

									}
								}
							} else if (Client.instance.inputString.toLowerCase().equals("::dumpnpcs")) {
								test.clear();
								for (int index = 0; index < EntityDefinition.total; index++) {
									EntityDefinition data = EntityDefinition.forId(index);
									if (data == null) {
										continue;
									}
									if (data.name == null) {
										continue;
									}
									if (data.name.isEmpty()) {
										continue;
									}
									if (data.name.toLowerCase().contains("null")) {
										continue;
									}
									test.add(index + " " + data.name);
								}
								String location = "npc_list.txt";
								Utility.deleteAllLines(location);
								Utility.saveArrayContents(location, test);
								Utility.print("Dumped: " + test.size());
								test.clear();
							} else if (Client.instance.inputString.toLowerCase().equals("::dumpobjects")) {
								test.clear();
								for (int index = 0; index < ObjectDefinition.totalObjects; index++) {
									ObjectDefinition data = ObjectDefinition.forId(index);
									if (data == null) {
										continue;
									}
									if (data.name == null) {
										continue;
									}
									if (data.name.isEmpty()) {
										continue;
									}
									if (data.name.toLowerCase().contains("null")) {
										continue;
									}
									test.add(index + " " + data.name);
								}
								String location = "object_list.txt";
								Utility.deleteAllLines(location);
								Utility.saveArrayContents(location, test);
								Utility.print("Dumped: " + test.size());
								test.clear();
							} else if (Client.instance.inputString.toLowerCase().equals("::interfaceloop")) {
								Client.interfacesReloadLoop = !Client.interfacesReloadLoop;
								Client.interfacesReloaded = !Client.interfacesReloaded;
								Client.instance.pushMessage("Interface looping: " + Client.interfacesReloadLoop,
										ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");

							} else if (Client.instance.inputString.toLowerCase().equals("::rsi")) {
								Client.interfacesReloadLoop = true;
								RSInterface.reloadInterfaces(true);

							}
						}
						if (ClientDebugConfiguration.NO_CLIP_COMMAND) {
							if (Client.instance.inputString.toLowerCase().equals("::noclip"))
							{
								Client.noClip = !Client.noClip;
								Client.instance.pushMessage("Client clipping: " + Client.noClip,
										ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
								Settings.saveSettings();
							}

							else if (Client.instance.inputString.toLowerCase().equals("::lag")) {
								// Client.instance.printDebug();
							} else if (Client.instance.inputString.startsWith("::nullconfig")) {
								String[] split = Client.instance.inputString.split(" ");

								if (split.length < 2) {
									return;
								}
								int id = Integer.parseInt(split[1]);

								boolean found = false;

								for (RSInterface component : RSInterface.interfaceCache) {
									if (component == null || component.valueIndexArray == null) {
										continue;
									}

									if (component.valueIndexArray[0][1] == id) {
										found = true;
										Client.instance.pushMessage(String.format("Interface #%s already has the config %s.", component.id, id), 0, "", "");
										break;
									}
								}
								if (!found) {
									Client.instance.pushMessage(String.format("Config #%s is available for usage.", id), 0, "", "");
								}
							} else if (Client.instance.inputString.startsWith("::rsi")) {
								int id = Integer.parseInt(Client.instance.inputString.split(" ")[1]);

								RSInterface rsi = RSInterface.interfaceCache[id];

								Utility.print(rsi + "");
							} else if (Client.instance.inputString.startsWith("::nullrsi")) {
								int id = 0;

								int offset = 0;

								String[] data = null;

								try {
									data = Client.instance.inputString.split(" ");

									id = Integer.parseInt(data[1]);

									offset = Integer.parseInt(data[2]);

									if (id <= 0 || offset <= 0) {
										Client.instance.pushMessage("Identification value and or offset is negative.", 0, "", "");
									} else if (id + offset > RSInterface.interfaceCache.length - 1) {
										Client.instance.pushMessage("The total sum of the key and offset are greater than the size of the cache.", 0, "", "");
									} else {
										Collection<Integer> nullList = new ArrayList<>(offset);

										Collection<Integer> nonNull = new ArrayList<>(offset);

										for (int interfaceId = id; interfaceId < id + offset; interfaceId++) {
											RSInterface rsi = RSInterface.interfaceCache[interfaceId];

											if (rsi == null) {
												nullList.add(interfaceId);
											} else {
												nonNull.add(interfaceId);
											}
										}
										Client.instance.pushMessage("There are a total of " + nullList.size() + "/" + offset + " null interfaces from " + id + " to " + (id + offset) + ".", 0, "", "");
										if (nonNull.size() <= 25) {
											for (int nonNullRSI : nonNull) {
												Client.instance.pushMessage("NotNull: " + nonNullRSI + ", Parent: " + RSInterface.interfaceCache[nonNullRSI].parentId, 0, "", "");
											}
										} else {
											Client.instance.pushMessage("NonNull list is greater than 25, cannot output results.", 0, "", "");
										}
									}
								} catch (ArrayIndexOutOfBoundsException | NumberFormatException exception) {
								}
							} else if (Client.instance.inputString.toLowerCase().equals("::itemupdate")) {
								Client.itemUpdate = !Client.itemUpdate;
								Client.instance.pushMessage("Live item update toggled to: " + Client.itemUpdate, ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
							} else if (Client.instance.inputString.toLowerCase().equals("::data")) {
								Client.clientData = !Client.clientData;
								Client.instance.pushMessage("Client data: " + Client.clientData, ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
								Settings.saveSettings();
							} else if (Client.instance.inputString.toLowerCase().equals("::coords")) {
								Client.coordinatesDisplay = !Client.coordinatesDisplay;
								Client.clientData = false;
								Client.instance.pushMessage("Coordinates: " + Client.coordinatesDisplay, ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
								Settings.saveSettings();
							}
						}
						Client.instance.stream.createFrame(103);
						Client.instance.stream.writeWordBigEndian(Client.instance.inputString.length() - 1);
						Client.instance.stream.writeString(Client.instance.inputString.substring(2));
					} else if (Client.playerUpdateCompleted) {
						String s = Client.instance.inputString.toLowerCase();
						refuse = Client.sendChat(s, false);
					}
					if (!refuse) {
						Client.instance.inputString = "";
						Client.setUpdateChatAreaPending(true);
					}
				}
			}
		} while (true);
	}
}
