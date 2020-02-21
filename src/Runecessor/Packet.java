package Runecessor;

import java.io.IOException;

public class Packet extends Client {

	private static final long serialVersionUID = -4316850110787825707L;

	public static boolean debugEntityPackets = false;

	public Packet() {
		super(null, false); // why the fuck are we extending client just so we dont have to use static access or accessors? :/ - jason
	}

	public static boolean parsePacket() {

		int interfaceId = 0;
		if (Client.instance.isDisconnected()) {
			return false;
		}
		if (Client.instance.socketStream == null) {
			return false;
		}

		try {
			int availableSize = Client.instance.socketStream.available();

			if (availableSize == 0) {
				return false;
			}
			if (Client.instance.packetType == -1) {
				Client.instance.socketStream.flushInputStream(Client.instance.inStream.buffer, 1);
				Client.instance.packetType = Client.instance.inStream.buffer[0] & 0xff;
				if (Client.instance.encryption != null) {
					Client.instance.packetType = Client.instance.packetType - Client.instance.encryption.getNextKey() & 0xff;
				}

				Client.instance.pktSize = SizeConstants.packetSizes[Client.instance.packetType];
				availableSize--;
			}
			if (Client.instance.pktSize == -1) {
				if (availableSize > 0) {
					Client.instance.socketStream.flushInputStream(Client.instance.inStream.buffer, 1);
					Client.instance.pktSize = Client.instance.inStream.buffer[0] & 0xff;
					availableSize--;
				} else {
					return false;
				}
			}
			if (Client.instance.pktSize == -2) {
				if (availableSize > 1) {
					Client.instance.socketStream.flushInputStream(Client.instance.inStream.buffer, 2);
					Client.instance.inStream.currentOffset = 0;
					Client.instance.pktSize = Client.instance.inStream.readUnsignedWord();
					availableSize -= 2;
				} else {
					return false;
				}
			}

			if (debugEntityPackets) {
				String extra = "";
				// Update players & update npcs packet.
				if (Client.instance.packetType == 81 || Client.instance.packetType == 65) {
					extra = "#";
				}
				Utility.print(extra + "----Packet size: " + Client.instance.pktSize + ", packet type: " + getPacketName(Client.instance.packetType) + ", limit: " + availableSize);
			}

			if (availableSize < Client.instance.pktSize) {
				Utility.print("Packet too big returned: " + getPacketName(Client.instance.packetType));
				Utility.print("Available limit: " + availableSize);
				Utility.print("Packet size: " + Client.instance.pktSize);
				return false;
			}

			if (ClientDebugConfiguration.DEBUG_MODE) {
				//Utility.print(String.format("packetId=%s, packetSize=%s", Client.instance.packetType, Client.instance.pktSize));
			}
			Client.instance.inStream.currentOffset = 0;
			Client.instance.socketStream.flushInputStream(Client.instance.inStream.buffer, Client.instance.pktSize);
			Client.instance.netIdleCycles = 0;
			Client.instance.ptype2 = Client.instance.ptype1;
			Client.instance.ptype1 = Client.instance.ptype0;
			Client.instance.ptype0 = Client.instance.packetType;
			timeReceivedPacket = System.currentTimeMillis();

			switch (Client.instance.packetType) {
				case 81:
					UpdateEntity.updatePlayers(Client.instance.pktSize, Client.instance.inStream);
					Client.instance.sceneIsLoading = false;
					Client.instance.packetType = -1;
					return true;

				case 176:
					Client.instance.packetType = -1;
					return true;

				case 64:
					Client.instance.anInt1268 = Client.instance.inStream.method427();
					Client.instance.anInt1269 = Client.instance.inStream.method428();
					for (int j = Client.instance.anInt1268; j < Client.instance.anInt1268 + 8; j++) {
						for (int l9 = Client.instance.anInt1269; l9 < Client.instance.anInt1269 + 8; l9++) {
							if (Client.instance.groundArray[Client.instance.plane][j][l9] != null) {
								Client.instance.groundArray[Client.instance.plane][j][l9] = null;
								Client.instance.spawnGroundItem(j, l9);
							}
						}
					}
					for (TemporaryObject class30_sub1 = (TemporaryObject) Client.instance.objects.reverseGetFirst(); class30_sub1 != null; class30_sub1 = (TemporaryObject) Client.instance.objects.reverseGetNext())
						if (class30_sub1.x >= Client.instance.anInt1268 && class30_sub1.x < Client.instance.anInt1268 + 8 && class30_sub1.y >= Client.instance.anInt1269 && class30_sub1.y < Client.instance.anInt1269 + 8 && class30_sub1.plane == Client.instance.plane)
							class30_sub1.cycle = 0;
					Client.instance.packetType = -1;
					return true;

				case 185:
					int k = Client.instance.inStream.method436();
					RSInterface.interfaceCache[k].modelTypeDisabled = 3;
					if (myPlayer.desc == null)
						RSInterface.interfaceCache[k].mediaID = (myPlayer.colours[0] << 25) + (myPlayer.colours[4] << 20) + (myPlayer.equipment[0] << 15) + (myPlayer.equipment[8] << 10) + (myPlayer.equipment[11] << 5) + myPlayer.equipment[1];
					else
						RSInterface.interfaceCache[k].mediaID = (int) (0x12345678L + myPlayer.desc.type);
					Client.instance.packetType = -1;
					return true;

				/* Clan chat packet */
				case 217:
					try {
						Client.instance.name = Client.instance.inStream.readString();
						Client.instance.message = Client.instance.inStream.readString();
						Client.instance.clanname = Client.instance.inStream.readString();
						rights = Client.instance.inStream.readUnsignedWord();
						long l17 = TextClass.longForName(Client.instance.name);
						boolean ignored = Utility.isIgnored(l17) && !ClientConstants.isModeratorOrAbove(rights);
						if (!ignored) {
							Client.instance.pushMessage(Client.instance.message, ClientConstants.CHAT_TYPE_CLAN, Client.instance.name, Client.instance.name);
						}
						rights = 0;
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					Client.instance.packetType = -1;
					return true;

				case 107:
					Client.instance.inCutsceneMode = false;
					for (int l = 0; l < 5; l++) {
						Client.instance.cameraEffectEnabled[l] = false;
					}
					Client.instance.packetType = -1;
					return true;

				case 72:
					int i1 = Client.instance.inStream.method434();
					RSInterface class9 = RSInterface.interfaceCache[i1];
					for (int k15 = 0; k15 < class9.inv.length; k15++) {
						class9.inv[k15] = -1;
						class9.inv[k15] = 0;
					}
					Client.instance.packetType = -1;
					return true;

				case 214:
					try {
						Client.instance.ignoreCount = Client.instance.pktSize / 8;
						for (int j1 = 0; j1 < Client.instance.ignoreCount; j1++) {
							Client.instance.ignoreListAsLongs[j1] = Client.instance.inStream.readQWord();
						}
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					Client.instance.packetType = -1;
					return true;

				case 19:
					Client.instance.xCameraPos = Client.instance.inStream.readUnsignedWord();
					Client.xCameraCurve = Client.instance.inStream.readUnsignedWord();
					Client.instance.yCameraPos = Client.instance.inStream.readUnsignedWord();
					Client.yCameraCurve = Client.instance.inStream.readUnsignedWord();

					Client.instance.packetType = -1;
					return true;

				case 166:
					Client.instance.inCutsceneMode = true;
					Client.instance.cutsceneLocalX = Client.instance.inStream.readUnsignedByte();
					Client.instance.cutsceneLocalY = Client.instance.inStream.readUnsignedByte();
					Client.instance.cutsceneZ = Client.instance.inStream.readUnsignedWord();
					Client.instance.cutsceneSpeed = Client.instance.inStream.readUnsignedByte();
					Client.instance.cutsceneSpeedMul = Client.instance.inStream.readUnsignedByte();
					if (Client.instance.cutsceneSpeedMul >= 100) {
						Client.instance.xCameraPos = Client.instance.cutsceneLocalX * 128 + 64;
						Client.instance.yCameraPos = Client.instance.cutsceneLocalY * 128 + 64;
						zCameraPos = Client.instance.getLand(Client.instance.plane, Client.instance.yCameraPos, Client.instance.xCameraPos) - Client.instance.cutsceneZ;
					}
					Client.instance.packetType = -1;
					return true;

				case 134:
					int skillId = Client.instance.inStream.readUnsignedByte();
					int experience = Client.instance.inStream.method439();
					int level = Client.instance.inStream.readUnsignedByte();

					// Current skill level is needed client sided for Vengeance/Ancient magicks/Modern spellbook glow to work.
					Client.instance.skillExperience[skillId] = experience;

					// This is base skill level for all skills, except for magic it is current level.
					Client.instance.baseSkillLevel[skillId] = level;
					Client.instance.maxStats[skillId] = 1;
					for (int k20 = 0; k20 < 98; k20++) {
						if (experience >= XP_LOOKUP[k20]) {
							Client.instance.maxStats[skillId] = k20 + 2;
						}
					}
					Client.instance.packetType = -1;
					return true;

				case 71:
					int l1 = Client.instance.inStream.readUnsignedWord();
					int j10 = Client.instance.inStream.method426();
					if (l1 == 65535)
						l1 = -1;
					tabInterfaceId[j10] = l1;

					if (is562PlusGameFrame) {
						tabInterfaceId[1] = ClientConstants.getQuestTabInterfaceId(); // Achievement tab.
						tabInterfaceId[2] = 3917; // Skill tab.
						tabInterfaceId[14] = ClientConstants.getQuestTabInterfaceId(); // Quest tab.
					}
					setTabAreaAltered(true);
					Client.instance.packetType = -1;
					return true;

				case 74:
					int i2 = Client.instance.inStream.method434();
					if (i2 != currentSong && musicEnabled && !lowMem && Client.instance.previousSong == 0) {
						nextSong = i2;
						onDemandFetcher.sendImmediately(2, nextSong);
						currentSong = i2;
					}
					sentRequestToPlayNextSong = false;
					if (!musicEnabled) {
						Client.instance.sendFrame126("No music selected.", 4439);
					}
					Client.instance.packetType = -1;
					return true;

				case 121:
					int j2 = Client.instance.inStream.method436();
					int k10 = Client.instance.inStream.method435();
					if (musicEnabled && !lowMem) {
						nextSong = j2;
						onDemandFetcher.sendImmediately(2, nextSong);
						Client.instance.previousSong = k10;
					}
					Client.instance.packetType = -1;
					return true;

				case 109:
					Utility.print("Kicked5 due to packet 109 from server: " + Client.instance.getLoadingStage());
					Client.instance.logOutUpdate();
					Client.instance.packetType = -1;
					return false;

				case 70:
					int k2 = Client.instance.inStream.readSignedWord();
					int l10 = Client.instance.inStream.method437();
					int i16 = Client.instance.inStream.method434();
					RSInterface class9_5 = RSInterface.interfaceCache[i16];
					class9_5.offsetX = k2;
					class9_5.offsetY = l10;
					Client.instance.packetType = -1;
					return true;

				case 73:
				case 241:
					int l2 = Client.instance.regionX;
					int i11 = Client.instance.regionY;
					if (Client.instance.packetType == 73) {
						l2 = Client.instance.mapX = Client.instance.inStream.method435();
						i11 = Client.instance.mapY = Client.instance.inStream.readUnsignedWord();
						Client.instance.loadingReceivedMap = false;
					}
					if (Client.instance.packetType == 241) {
						i11 = Client.instance.inStream.method435();
						Client.instance.inStream.initBitAccess();
						for (int j16 = 0; j16 < 4; j16++) {
							for (int l20 = 0; l20 < 13; l20++) {
								for (int j23 = 0; j23 < 13; j23++) {
									int i26 = Client.instance.inStream.readBits(1);
									if (i26 == 1)
										Client.instance.regionChunkUIDs[j16][l20][j23] = Client.instance.inStream.readBits(26);
									else
										Client.instance.regionChunkUIDs[j16][l20][j23] = -1;
								}
							}
						}
						Client.instance.inStream.finishBitAccess();
						l2 = Client.instance.inStream.readUnsignedWord();
						Client.instance.loadingReceivedMap = true;
					}
					if (Client.instance.regionX == l2 && Client.instance.regionY == i11 && Client.instance.getLoadingStage() == 2) {
						Client.instance.packetType = -1;
						return true;
					}
					Client.instance.regionX = l2;
					Client.instance.regionY = i11;
					Client.instance.baseX = (Client.instance.regionX - 6) * 8;
					Client.instance.baseY = (Client.instance.regionY - 6) * 8;
					Client.instance.regionIsRestricted = (Client.instance.regionX / 8 == 48 || Client.instance.regionX / 8 == 49) && Client.instance.regionY / 8 == 48;
					if (Client.instance.regionX / 8 == 48 && Client.instance.regionY / 8 == 148) {
						Client.instance.regionIsRestricted = true;
					}
					Client.instance.setLoadingStage(1);
					Client.instance.aLong824 = System.currentTimeMillis();
					Client.instance.inGameScreen.initDrawingArea();
					Content.loadingPleaseWait();
					Client.instance.inGameScreen.drawGraphics(isFixedScreen() ? 4 : 0, Client.instance.graphics, isFixedScreen() ? 4 : 0);
					if (Client.instance.packetType == 73) {
						int k16 = 0;
						for (int i21 = (Client.instance.regionX - 6) / 8; i21 <= (Client.instance.regionX + 6) / 8; i21++) {
							for (int k23 = (Client.instance.regionY - 6) / 8; k23 <= (Client.instance.regionY + 6) / 8; k23++)
								k16++;
						}
						Client.instance.objectScapeData = new byte[k16][];
						Client.instance.landScapeData = new byte[k16][];
						Client.instance.chunkUIDs = new int[k16];
						Client.instance.objectScapeUIDs = new int[k16];
						Client.instance.landScapeUIDs = new int[k16];
						k16 = 0;
						for (int l23 = (Client.instance.regionX - 6) / 8; l23 <= (Client.instance.regionX + 6) / 8; l23++) {
							for (int j26 = (Client.instance.regionY - 6) / 8; j26 <= (Client.instance.regionY + 6) / 8; j26++) {
								Client.instance.chunkUIDs[k16] = (l23 << 8) + j26;
								if (Client.instance.regionIsRestricted && (j26 == 49 || j26 == 149 || j26 == 147 || l23 == 50 || l23 == 49 && j26 == 47)) {
									Client.instance.objectScapeUIDs[k16] = -1;
									Client.instance.landScapeUIDs[k16] = -1;
									k16++;
								}
								else {
									int k28 = Client.instance.objectScapeUIDs[k16] = onDemandFetcher.getRegionUID(0, j26, l23);
									if (k28 != -1)
										onDemandFetcher.sendImmediately(3, k28);
									int j30 = Client.instance.landScapeUIDs[k16] = onDemandFetcher.getRegionUID(1, j26, l23);
									if (j30 != -1)
										onDemandFetcher.sendImmediately(3, j30);
									k16++;
								}
							}
						}
					}
					if (Client.instance.packetType == 241) {
						int l16 = 0;
						int ai[] = new int[676];
						for (int i24 = 0; i24 < 4; i24++) {
							for (int k26 = 0; k26 < 13; k26++) {
								for (int l28 = 0; l28 < 13; l28++) {
									int k30 = Client.instance.regionChunkUIDs[i24][k26][l28];
									if (k30 != -1) {
										int k31 = k30 >> 14 & 0x3ff;
										int i32 = k30 >> 3 & 0x7ff;
										int k32 = (k31 / 8 << 8) + i32 / 8;
										for (int j33 = 0; j33 < l16; j33++) {
											if (ai[j33] != k32)
												continue;
											k32 = -1;

										}
										if (k32 != -1)
											ai[l16++] = k32;
									}
								}
							}
						}
						Client.instance.objectScapeData = new byte[l16][];
						Client.instance.landScapeData = new byte[l16][];
						Client.instance.chunkUIDs = new int[l16];
						Client.instance.objectScapeUIDs = new int[l16];
						Client.instance.landScapeUIDs = new int[l16];
						for (int l26 = 0; l26 < l16; l26++) {
							int i29 = Client.instance.chunkUIDs[l26] = ai[l26];
							int l30 = i29 >> 8 & 0xff;
							int l31 = i29 & 0xff;
							int j32 = Client.instance.objectScapeUIDs[l26] = onDemandFetcher.getRegionUID(0, l31, l30);
							if (j32 != -1)
								onDemandFetcher.sendImmediately(3, j32);
							int i33 = Client.instance.landScapeUIDs[l26] = onDemandFetcher.getRegionUID(1, l31, l30);
							if (i33 != -1)
								onDemandFetcher.sendImmediately(3, i33);
						}
					}
					int i17 = Client.instance.baseX - Client.instance.anInt1036;
					int j21 = Client.instance.baseY - Client.instance.anInt1037;
					Client.instance.anInt1036 = Client.instance.baseX;
					Client.instance.anInt1037 = Client.instance.baseY;
					for (int j24 = 0; j24 < 16384; j24++) {
						Npc npc = Client.instance.npcArray[j24];
						if (npc != null) {
							for (int j29 = 0; j29 < 10; j29++) {
								npc.smallX[j29] -= i17;
								npc.smallY[j29] -= j21;
							}
							npc.x -= i17 * 128;
							npc.y -= j21 * 128;
						}
					}
					for (int i27 = 0; i27 < Client.instance.maxPlayers; i27++) {
						Player player = Client.instance.playerArray[i27];
						if (player != null) {
							for (int i31 = 0; i31 < 10; i31++) {
								player.smallX[i31] -= i17;
								player.smallY[i31] -= j21;
							}
							player.x -= i17 * 128;
							player.y -= j21 * 128;
						}
					}
					Client.instance.sceneIsLoading = true;
					byte byte1 = 0;
					byte byte2 = 104;
					byte byte3 = 1;
					if (i17 < 0) {
						byte1 = 103;
						byte2 = -1;
						byte3 = -1;
					}
					byte byte4 = 0;
					byte byte5 = 104;
					byte byte6 = 1;
					if (j21 < 0) {
						byte4 = 103;
						byte5 = -1;
						byte6 = -1;
					}
					for (int k33 = byte1; k33 != byte2; k33 += byte3) {
						for (int l33 = byte4; l33 != byte5; l33 += byte6) {
							int i34 = k33 + i17;
							int j34 = l33 + j21;
							for (int k34 = 0; k34 < 4; k34++)
								if (i34 >= 0 && j34 >= 0 && i34 < 104 && j34 < 104)
									Client.instance.groundArray[k34][k33][l33] = Client.instance.groundArray[k34][i34][j34];
								else
									Client.instance.groundArray[k34][k33][l33] = null;
						}
					}
					for (TemporaryObject class30_sub1_1 = (TemporaryObject) Client.instance.objects.reverseGetFirst(); class30_sub1_1 != null; class30_sub1_1 = (TemporaryObject) Client.instance.objects.reverseGetNext()) {
						class30_sub1_1.x -= i17;
						class30_sub1_1.y -= j21;
						if (class30_sub1_1.x < 0 || class30_sub1_1.y < 0 || class30_sub1_1.x >= 104 || class30_sub1_1.y >= 104)
							class30_sub1_1.unlink();
					}
					if (Client.instance.destX != 0) {
						Client.instance.destX -= i17;
						Client.instance.destY -= j21;
					}
					Client.instance.inCutsceneMode = false;
					Client.instance.packetType = -1;
					return true;

				case 208:
					int walkableInterface = Client.instance.inStream.method437();
					if ((walkableInterface == 24395 || walkableInterface == 24390) && useOldWildernessInterface) {
						walkableInterface = 197;
					}
					if (walkableInterface >= 0) {
						resetInterfaceSequence(walkableInterface);
					}
					Client.instance.walkableInterfaceId = walkableInterface;
					Client.instance.packetType = -1;
					return true;

				case 99:
					Client.instance.minimapState = Client.instance.inStream.readUnsignedByte();
					Client.instance.packetType = -1;
					return true;

				case 75:
					int npcId = Client.instance.inStream.method436();
					int frame1 = Client.instance.inStream.method436();
					RSInterface.interfaceCache[frame1].modelTypeDisabled = 2;
					RSInterface.interfaceCache[frame1].mediaID = npcId;
					Client.instance.packetType = -1;
					return true;

				case 114:
					Client.instance.systemUpdateCycle = Client.instance.inStream.method434() * 30;
					Client.instance.packetType = -1;
					return true;

				case 60:
					Client.instance.anInt1269 = Client.instance.inStream.readUnsignedByte();
					Client.instance.anInt1268 = Client.instance.inStream.method427();
					while (Client.instance.inStream.currentOffset < Client.instance.pktSize) {
						int k3 = Client.instance.inStream.readUnsignedByte();
						Client.instance.handleSecondaryPacket(Client.instance.inStream, k3);
					}
					Client.instance.packetType = -1;
					return true;

				case 35:
					int l3 = Client.instance.inStream.readUnsignedByte();
					int k11 = Client.instance.inStream.readUnsignedByte();
					int j17 = Client.instance.inStream.readUnsignedByte();
					int k21 = Client.instance.inStream.readUnsignedByte();
					Client.instance.cameraEffectEnabled[l3] = true;
					Client.instance.anIntArray873[l3] = k11;
					Client.instance.anIntArray1203[l3] = j17;
					Client.instance.anIntArray928[l3] = k21;
					Client.instance.cameraEffectCycles[l3] = 0;
					Client.instance.packetType = -1;
					return true;

				case 174:
					int soundId = Client.instance.inStream.readUnsignedWord();
					int type = Client.instance.inStream.readUnsignedByte();
					int delay = Client.instance.inStream.readUnsignedWord();
					int volume = Client.instance.inStream.readUnsignedWord();
					sound[currentSound] = soundId;
					soundType[currentSound] = type;
					soundDelay[currentSound] = delay + WaveSound.delays[soundId];
					soundVolume[currentSound] = volume;
					currentSound++;
					Client.instance.packetType = -1;
					return true;

				case 104:
					int j4 = Client.instance.inStream.method427();
					int i12 = Client.instance.inStream.method426();
					String s6 = Client.instance.inStream.readString();
					if (j4 >= 1 && j4 <= 5) {
						if (s6.equalsIgnoreCase("null")) {
							s6 = null;
						}
						Client.instance.atPlayerActions[j4 - 1] = s6;
						Client.instance.atPlayerArray[j4 - 1] = i12 == 0;
					}
					Client.instance.packetType = -1;
					return true;

				case 78:
					Client.instance.destX = 0;
					Client.instance.packetType = -1;
					return true;

				case 253:
					String string = Client.instance.inStream.readString();
					if (string.startsWith(":packet:yell")) {
						String[] args = string.split("#&!");
						String name = args[2];
						String text = args[3];
						if (!Utility.isIgnored(name)) {
							Client.instance.pushMessage(text, ClientConstants.CHAT_TYPE_YELL, name, name);
						}
					} else if (string.endsWith(":tradereq:")) {
						String s3 = string.substring(0, string.indexOf(":"));
						long l17 = TextClass.longForName(s3);
						if (!Utility.isIgnored(l17)) {
							Client.instance.pushMessage("wishes to trade with you.", ClientConstants.CHAT_TYPE_TRADE, s3, "");
						}
					}
					else if (string.startsWith(":gamemode")) {
						starterType = string.substring(9);
					}
					else if (string.equals(":musicstate:")) {
						Music.updateServerMusicState();
					} else if (string.startsWith(":deduct_money_pouch:")) {
						String[] parse = string.split(":");
						int id = Integer.parseInt(parse[2]);
						MoneyPouchOrb.sendDeduction(id);
					} else if (string.startsWith(":add_money_pouch:")) {
						String[] parse = string.split(":");
						int id = Integer.parseInt(parse[2]);
						MoneyPouchOrb.sendAddition(id);
					}
					else if (string.contains(":rights")) {
						playerRights = Integer.parseInt(string.substring(7, 8));
					}
					else if (string.contains(":xpdisplaybar")) {
						xpCounter += Integer.parseInt(string.substring(13));
					}
					else if (string.contains(":closecombatbox")) {
						CombatBox.stopTime();
					}
					else if (string.contains(":xpdisplay")) {
						String[] parse = string.split(" ");
						int xpPositionStart = 0;
						if (Client.osrsXpOrb && Client.is474GameFrame) {
							xpPositionStart = 73;
						}
						String skillIdsToAdd = "";
						for (int index = 0; index < parse.length; index++) {
							if (index <= 1) {
								continue;
							}
							boolean match = false;
							String secondParse[] = skillIdsToAdd.split(" ");
							for (int i = 0; i < secondParse.length; i++) {
								if (secondParse[i].equals(parse[index])) {
									match = true;
									break;
								}
							}
							if (!match) {
								skillIdsToAdd = skillIdsToAdd + (skillIdsToAdd.isEmpty() ? "" : " ") + parse[index];
							}
						}
						String[] split = skillIdsToAdd.split(" ");
						int[] skillIds = new int[split.length];
						for (int index = 0; index < split.length; index++) {
							skillIds[index] = Integer.parseInt(split[index]);
						}
						XpDropData.xpDropDataList.add(new XpDropData(Integer.parseInt(parse[1]), xpPositionStart, 0, skillIds));
						//Client.xpDropsToDisplay.add(parse[1] + " " + xpPositionStart + " 0 -" + skillIdsToAdd);
					}

					else if (string.contains(":xptotal")) {
						Client.xpCounter = Integer.parseInt(string.substring(8));
					}

					else if (string.contains(":xpshowsession")) {
						Client.xpBarShowType = "SESSION";
					}

					else if (string.contains(":xpshowcombat")) {
						Client.xpBarShowType = "COMBAT";
					}

					else if (string.contains(":xpshowtotal")) {
						Client.xpBarShowType = "TOTAL";
					}
					else if (string.endsWith(":compu:")) {
						myPlayer.compNeedsUpdate = true;
						Client.instance.uLinkNodes();
					}
					else if (string.startsWith(":npctype")) {
						Client.npcChatHeadUsed = Integer.parseInt(string.substring(8));
					}
					else if (string.endsWith(":restingon:")) {
						Client.instance.setResting(true);
					}
					else if (string.endsWith(":restingoff:")) {
						Client.instance.setResting(false);
					}
					else if (string.endsWith(":summoningon:")) {
						showSummoningGlow = true;
						Client.specOrb = true;
						Client.disableSpecOrb = false;
					}
					else if (string.endsWith(":summoningoff:")) {
						showSummoningGlow = false;
						Client.specOrb = false;
						Client.disableSpecOrb = true;
					}
					else if (string.endsWith(":quickprayeron:")) {
						Client.instance.setQuickPrayerOn(true);
					}
					else if (string.endsWith(":quickprayeroff:")) {
						Client.instance.setQuickPrayerOn(false);
					}
					else if (string.endsWith(":poisonon:")) {
						poisoned = true;
					}
					else if (string.endsWith(":poisonoff:")) {
						poisoned = false;
					}
					else if (string.startsWith(":rottenpotatov2")) {
						Content.rottenPotatoV2(string);
					}
					else if (string.endsWith(":7uj8f5ghjdr5tl:")) {
						displayInputBox(11, "Enter your new password or leave blank and press enter to cancel.");
					}
					else if (string.endsWith(":namechange:")) {
						displayInputBox(15, "Enter your new username");
					}
					else if (string.endsWith(":ccbanplayer:")) {
						displayInputBox(12, "Enter player to ban");
					}
					else if (string.endsWith(":ccmodplayer:")) {
						displayInputBox(13, "Enter player to promote to moderator");
					}
					else if (string.endsWith(":cctitle:")) {
						displayInputBox(14, "Enter title of clan chat.");
					}
					else if (string.contains(":profilebiography")) {
						Profile.profileBiographyButton(string);
					}
					else if (string.endsWith(":updatetabs:")) {
						drawTabs = true;
						Client.instance.setSidebarInterface(0, 2423); // Combat interface.
						Client.instance.setSidebarInterface(1, 3917); // Skilltab.
						Client.instance.setSidebarInterface(2, ClientConstants.getQuestTabInterfaceId()); // Quest tab
						Content.showCorrectQuestTab(true);
						Client.instance.setSidebarInterface(3, 3213); // Inventory tab.
						Client.instance.setSidebarInterface(4, 1644); // Equipment tab
						Client.instance.setSidebarInterface(7, 18128); // Clan chat 18128
						Client.instance.setSidebarInterface(8, 5065); // Friends tab.
						Client.instance.setSidebarInterface(9, 5715); // Ignore tab.
						Client.instance.setSidebarInterface(10, 2449); // Empty tab
						Settings.showSettingsInterface();
						Client.instance.setSidebarInterface(12, 147); // Run tab
						Client.instance.setSidebarInterface(13, 962); // Music tab 6299 for lowdetail. 962 for highdetail
						Client.instance.setSidebarInterface(14, ClientConstants.getQuestTabInterfaceId()); // Achievement Tab
						if (is562GameFrame || is562PlusGameFrame) {
							Client.instance.setSidebarInterface(15, 18500); // Note tab
						}
						else if (is474GameFrame) {
							Client.instance.setSidebarInterface(15, 962); // Music tab //6299 disabled, 962 enabled.
						}
						setTabId(3, true); // This is to make the inventory tab clicked on.
						if (noClip) {
							Client.instance.sendCommandPacket("::noclip");
						}
					}
					else if (string.endsWith(":duelreq:")) {
						String s4 = string.substring(0, string.indexOf(":"));
						long l18 = TextClass.longForName(s4);
						if (!Utility.isIgnored(l18)) {
							Client.instance.pushMessage("wishes to duel with you.", ClientConstants.CHAT_TYPE_DUEL, s4, "");
						}
					}
					else if (string.endsWith(":resetautocast:")) {
						Client.instance.Autocast = false;
						Client.instance.autocastId = 0;
					}
					else if (string.startsWith(":autocasthighlight")) {
						string = string.substring(18);
						string = string.replace(":", "");
						Client.instance.Autocast = true;
						Client.instance.autocastId = Integer.parseInt(string);
					}
					else if (string.endsWith(":tutorial:")) {
						ArrowTutorial.startTutorial();
					}
					else if (string.startsWith(":achievement:popup0:")) {
						Client.achievementTitlePopup = string.substring(20);
					}
					else if (string.startsWith(":achievement:popup1:")) {
						Client.achievementPopUp = true;
						Client.achievementPopUpTime = System.currentTimeMillis();
						Client.achievementDifficultyPopUp = string.substring(20);
					}
					else if (string.startsWith(":achievement:popup2:")) {
						Client.achievementTaskPopUp = string.substring(20);
					}
					else if (string.equals(":joincc:")) {
						setUpdateChatAreaPending(true);
						inputDialogState = 0;
						setMessagePromptRaised(true, false);
						setChatAreaInputBoxPlayerInput("");
						bankSearchSent = "";
						friendsListAction = 6;
						setChatAreaInputBoxTitle("Enter the name of the chat you wish to join");
					}
					else if (string.startsWith(":packet:")) {
						string = string.replace(":packet:", "");
						String split[] = string.split(" ");
						if (string.startsWith("setclicked")) {
							String[] args = string.split(" ");
							int parentInterfaceId = Integer.parseInt(args[1]);
							interfaceId = Integer.parseInt(args[2]);
							boolean state = Boolean.parseBoolean(args[3]);
							setInterfaceClicked(parentInterfaceId, interfaceId, state, true);
						}
						else if (string.startsWith("quickchat"))  {
							String[] args = string.split("!#!");
							String playerName = args[1];
							int playerIndex = 0;
							for (int index = 0; index < Client.instance.playerArray.length; index++) {
								Player instance = Client.instance.playerArray[index];
								if (instance == null) {
									continue;
								}
								if (instance.getName().equals(playerName)) {
									playerIndex = index;
									break;
								}
							}
							boolean quickChatIcon = args[2].equals("true");
							String message = args[3];
							//player is the player who sent the quick chat
							Player player = Client.instance.playerArray[playerIndex];
							if (player != null) {
								boolean ignored = Utility.isIgnored(TextClass.longForName(player.getName())) && !ClientConstants.isModeratorOrAbove(player.privelage);
								if (!ignored) {
									Client.rights = player.privelage;
									Client.instance.pushMessage((quickChatIcon ? "<img=8>" : "") + message, player == Client.myPlayer ? ClientConstants.CHAT_TYPE_MY_PLAYER : ClientConstants.CHAT_TYPE_OTHER_PLAYERS, PlayerRank.getIconText(player.privelage) + PlayerTitle.messagesOfOtherPlayers(player), player.getName());
									Client.rights = 0;
								}
							}
						}
						else if (string.startsWith("modeyell")) {
							switch (split[1])
							{
								case "ON":
									Client.yellMode = ClientConstants.YELL_MODE_ON;
								break;
								case "FRIENDS":
									Client.yellMode = ClientConstants.YELL_MODE_FRIENDS;
									break;
								case "OFF":
									Client.yellMode = ClientConstants.YELL_MODE_OFF;
									break;
							}
						}
						else if (string.equals("updatebank")) {
							Content.drawOnBankInterface();
						}
						else if (string.startsWith("setinventoryoverlay")) {
							int overlayId = Integer.parseInt(split[1]);
							setInvOverlayInterfaceID(overlayId);
						}
						else if (string.startsWith("textcountdown")) {
							interfaceId = Integer.parseInt(split[1]);
							int secondsLeft = Integer.parseInt(split[2]);
							RSInterface.interfaceCache[interfaceId].textCountDownSecondsLeft = secondsLeft;
						}
						else if (string.startsWith("spriteloadingpercentage")) {
							interfaceId = Integer.parseInt(split[1]);
							int percentage = Integer.parseInt(split[2]);
							RSInterface.interfaceCache[interfaceId].spriteLoadingBarPercentage = percentage;
						}
						else if (string.startsWith("prioritizetarget")) {
							String[] args = string.split(" ");
							int prioritizeEntityId = Integer.parseInt(args[1]);
							Client.instance.setInteractingWithEntityId(prioritizeEntityId);
							Client.alwaysRightClickAttack = false;
						}
						else if (string.startsWith("startoverlaytimer")) {
							String[] args = string.split(" ");
							int overlayTimerSpriteId = Integer.parseInt(args[1]);
							int secondsDuration = Integer.parseInt(args[2]);
							OverlayTimers.addNewOverlay(overlayTimerSpriteId, secondsDuration);
						}
						else if (string.startsWith("stopoverlaytimer")) {
							String[] args = string.split(" ");
							int overlayTimerSpriteId = Integer.parseInt(args[1]);
							OverlayTimers.remove(overlayTimerSpriteId);
						}
						else if (string.startsWith("stopalloverlaytimers")) {
							OverlayTimers.clearAllTimers();
						}
						else if (string.startsWith("venomon")) {
							venomed = true;
						}
						else if (string.startsWith("venomoff")) {
							venomed = false;
						}
						else if (string.startsWith("staminaeffecton")) {
							staminaEffect = true;
						}
						else if (string.startsWith("staminaeffectoff")) {
							staminaEffect = false;
						}
						else if (string.startsWith("regularSpellbook")) {
							Client.spellbookType = 0;
							Settings.saveSettings();
						}
						else if (string.startsWith("lunarSpellbook")) {
							Client.spellbookType = 1;
							Settings.saveSettings();
						}
						else if (string.startsWith("ancientSpellbook")) {
							Client.spellbookType = 2;
							Settings.saveSettings();
						}
						else if (string.startsWith("deletefriendslist")) {
							Client.instance.friendsList = new String[200];
							Client.instance.friendsListAsLongs = new long[200];
							Client.instance.friendsNodeIds = new int[200];
							Client.friendsCount = 0;
						}
						else if (string.startsWith("enteramounttext")) {
							Client.enterAmountText = string.substring(16);
						}
						else if (string.startsWith("latestgamblearray9")) {
							String parse[] = string.substring(19).split("#");
							for (int index = 0; index < parse.length; index++) {
								if (parse[index].isEmpty()) {
									continue;
								}
								Client.gambleFirst9Items.add(parse[index]);
							}
						} else if (string.startsWith("latestgamblearrayend9")) {
							for (int index = 0; index < Client.gambleFirst9Items.size(); index++) {
								if (Client.gambleFirst9Items.get(index).isEmpty()) {
									continue;
								}
								String[] parseFurther = Client.gambleFirst9Items.get(index).split(" ");
								RSInterface.interfaceCache[26726 + index].inv[0] = Integer.parseInt(parseFurther[0]) + 1;
								RSInterface.interfaceCache[26735 + index].message = parseFurther[1].equals("0") ? "" : parseFurther[1];
								Client.changeInterfaceSprite(26717 + index, Integer.parseInt(parseFurther[2]));
							}
							Client.gambleFirst9Items.clear();
						} else if (string.startsWith("latestgamblearray")) {
							String parse[] = string.substring(18).split("#");
							for (int index = 0; index < parse.length; index++) {
								if (parse[index].isEmpty()) {
									continue;
								}
								Client.gambleItems.add(parse[index]);
							}
						} else if (string.equals("latestgamblestart")) {
							Client.gambleTravelledTotal = 0;
							Client.gambleRandomX = Utility.random(0, 51);
							Client.randomSpeedDividerGamble = Utility.random(84, 87);
							Client.enableGamble = true;

							// Item model on Npc gamble interface.
							RSInterface.interfaceCache[26745].disableModel = true;
							Client.changeInterfaceSprite(26707, 801);
						}
						else if (string.equals("gambleresetinterface")) {
							RSInterface.interfaceCache[26745].disableModel = true;
							Client.changeInterfaceSprite(26707, 801);
						}
						else if (string.equals("gambleinterfaceenablemodel")) {
							RSInterface.interfaceCache[26745].disableModel = false;
						}
						//---------------------------------
						else if (string.startsWith("latestboxarray9")) {
							String parse[] = string.substring(16).split("#");
							for (int index = 0; index < parse.length; index++) {
								if (parse[index].isEmpty()) {
									continue;
								}
								Client.mysteryBoxFirst9Items.add(parse[index]);
							}
						}
						else if (string.startsWith("latestboxarrayend9")) {
							for (int index = 0; index < Client.mysteryBoxFirst9Items.size(); index++) {
								if (Client.mysteryBoxFirst9Items.get(index).isEmpty()) {
									continue;
								}
								String[] parseFurther = Client.mysteryBoxFirst9Items.get(index).split(" ");
								RSInterface.interfaceCache[26425 + index].inv[0] = Integer.parseInt(parseFurther[0]) + 1; // Item id
								Client.changeInterfaceSprite(26416 + index, Integer.parseInt(parseFurther[2])); // Background colour of item
							}
							Client.mysteryBoxFirst9Items.clear();
						}
						else if (string.startsWith("latestboxarray")) {
							String parse[] = string.substring(15).split("#");
							for (int index = 0; index < parse.length; index++) {
								if (parse[index].isEmpty()) {
									continue;
								}
								Client.mysteryBoxItems.add(parse[index]);
							}
						}
						else if (string.equals("latestmysteryboxstart")) {
							Client.mysteryBoxTravelledTotal = 0;
							Client.mysteryBoxRandomX = Utility.random(0, 51);
							Client.randomSpeedDividerMysteryBox = Utility.random(84, 87);
							Client.enableMysteryBox = true;

							// Item model on mystery box interface.
							RSInterface.interfaceCache[26435].disableModel = true;
							Client.changeInterfaceSprite(26405, 801);
						}
						else if (string.startsWith("winningitemid")) {
							String parse[] = string.substring(14).split(" ");
							Client.mysteryBoxWinningItemId = Integer.parseInt(parse[0]);
							Client.mysteryBoxWinningItemOffset = Integer.parseInt(parse[1]);
						}
						else if (string.startsWith("gamblewinningitemid")) {
							String parse[] = string.substring(20).split(" ");
							Client.gambleXAmountWon = parse[0];
						}
						else if (string.equals("petmysteryboxstart")) {
							Client.availablePets.clear();
							Client.unlockedPet = 0;
							Client.availablePetsCurrentIndex = 0;
							petInterfaceLoops = 0;
						}
						else if (string.startsWith("petmysteryboxarray")) {
							String parse[] = string.substring(19).split("#");
							for (int index = 0; index < parse.length; index++) {
								if (parse[index].isEmpty()) {
									continue;
								}
								int itemId = Integer.parseInt(parse[index]);
								Client.availablePets.add(itemId);
							}
						}
						else if (string.startsWith("petmysteryboxend")) {
							String[] args = string.split(" ");
							int unlockedPet = Integer.parseInt(args[1]);
							Client.unlockedPet = unlockedPet;
						}
						else if (string.startsWith("interfaceedit")) {
							interfaceId = Integer.parseInt(split[1]);
							int newSpriteId = Integer.parseInt(split[2]);
							Client.changeInterfaceSprite(interfaceId, newSpriteId);
						}
						else if (string.startsWith("interfacemodeledit")) {
							interfaceId = Integer.parseInt(split[1]);
							int newModelId = Integer.parseInt(split[2]);
							int modelZoom = Integer.parseInt(split[3]);
							int xRotate = Integer.parseInt(split[4]);
							int yRotate = Integer.parseInt(split[5]);
							int xOffset = Integer.parseInt(split[6]);
							int yOffset = Integer.parseInt(split[7]);
							Client.changeInterfaceModel(interfaceId, newModelId, modelZoom, xRotate, yRotate, xOffset, yOffset);
						}
						else if (string.startsWith("height")) {
							int height = Integer.parseInt(string.substring(6));
							Client.playerHeight = height;
							Client.forceObjectUpdate = true;
						}
						else if (string.startsWith("combatstyle")) {
							int id = Integer.parseInt(string.substring(12));
							RSInterface class9_2 = RSInterface.interfaceCache[id];
							if (class9_2.valueIndexArray != null && class9_2.valueIndexArray[0][0] == 5) {
								int ig = class9_2.valueIndexArray[0][1];
								if (Client.instance.variousSettings[ig] != class9_2.scriptCompareValue[0]) {
									Client.instance.variousSettings[ig] = class9_2.scriptCompareValue[0];
									Client.instance.handleVarp(ig);
								}
							}
						}

						else if (string.startsWith("otherbutton")) {
							int id = Integer.parseInt(string.substring(12));
							RSInterface class9_3 = RSInterface.interfaceCache[id];
							if (class9_3.valueIndexArray != null && class9_3.valueIndexArray[0][0] == 5) {
								int l8 = class9_3.valueIndexArray[0][1];
								Client.instance.variousSettings[l8] = 1 - Client.instance.variousSettings[l8];
								Client.instance.handleVarp(l8);
							}
						}
						else if (string.startsWith("showgrounditem")) {
							String parse[] = string.substring(15).split("#");
							for (int index = 0; index < parse.length; index++) {
								String secondParse[] = parse[index].split(" ");
								int itemId = Integer.parseInt(secondParse[2]);
								int itemAmount = Integer.parseInt(secondParse[3]);
								if (itemAmount > 2147000000) {
									itemAmount = 2147000000;
								}
								int i8 = 0;
								int regionX = Integer.parseInt(secondParse[1]) + (i8 >> 4 & 7);
								int regionY = Integer.parseInt(secondParse[0]) + (i8 & 7);
								if (regionX >= 0 && regionY >= 0 && regionX < 104 && regionY < 104) {
									Item class30_sub2_sub4_sub2_1 = new Item();
									class30_sub2_sub4_sub2_1.itemId = itemId;
									class30_sub2_sub4_sub2_1.amount = itemAmount;
									class30_sub2_sub4_sub2_1.value = ItemPrice.getValueDropsOnly(itemId, itemAmount);
									class30_sub2_sub4_sub2_1.setLocal(regionX, regionY);
									if (Client.instance.groundArray[Client.instance.plane][regionX][regionY] == null) {
										Client.instance.groundArray[Client.instance.plane][regionX][regionY] = new NodeList();
									}
									Client.instance.groundArray[Client.instance.plane][regionX][regionY].insertHead(class30_sub2_sub4_sub2_1);
									Client.instance.spawnGroundItem(regionX, regionY);
									Client.instance.groundArray[Client.instance.plane][regionX][regionY].sort(Client.COMPARE_ITEM_BY_VALUE);
								}
							}
						}
						else if (string.startsWith("removegrounditem")) {
							String parse[] = string.substring(17).split("#");
							for (int index = 0; index < parse.length; index++) {
								String secondParse[] = parse[index].split(" ");

								int itemId = Integer.parseInt(secondParse[2]);
								int amount = Integer.parseInt(secondParse[3]);
								int i8 = 0;
								int regionX = Integer.parseInt(secondParse[1]) + (i8 >> 4 & 7);
								int regionY = Integer.parseInt(secondParse[0]) + (i8 & 7);
								if (regionX >= 0 && regionY >= 0 && regionX < 104 && regionY < 104) {
									NodeList class19 = Client.instance.groundArray[Client.instance.plane][regionX][regionY];
									if (class19 != null) {
										for (Item item = (Item) class19.reverseGetFirst(); item != null; item = (Item) class19.reverseGetNext()) {
											if (item.itemId != (itemId & 0x7fff)) {
												continue;
											}
											if (item.amount != amount) {
												continue;
											}
											item.unlink();
											break;
										}

										if (class19.reverseGetFirst() == null) {
											Client.instance.groundArray[Client.instance.plane][regionX][regionY] = null;
										}
										Client.instance.spawnGroundItem(regionX, regionY);
									}
								}
							}
						}
						else if (string.startsWith("grounditemsremove")) {
							int index1 = Client.instance.plane; // Height.
							for (int i3 = 0; i3 < 104; i3++) {
								for (int a = 0; a < 104; a++) {
									NodeList class19 = Client.instance.groundArray[index1][i3][a];
									if (class19 != null) {
										for (Item item = (Item) class19.reverseGetFirst(); item != null;) {
											item.unlink();
											break;
										}

										Client.instance.groundArray[index1][i3][a] = null;
										Client.instance.spawnGroundItem(i3, a);
									}
								}
							}
						}
						else if (string.startsWith("raidprayer")) {
							String[] args = string.split(" ");
							if (args[1].equals("true")) {
								Client.rigourUnlocked = true;
							}
							if (args[2].equals("true")) {
								Client.auguryUnlocked = true;
							}
						}
						else if (string.startsWith("senditemchat")) {
							String[] args = string.split(" ");
							int id = Integer.parseInt(args[1]);
							int offset1 = Integer.parseInt(args[2]);
							int offset2 = Integer.parseInt(args[3]);
							RSInterface.interfaceCache[id].mediaIdOffset1 = offset1;
							RSInterface.interfaceCache[id].mediaIdOffset2 = offset2;
						}
						else if (string.startsWith("facecompass")) {
							Client.instance.viewRotation = 1000;
						}
						else if (string.startsWith("targethint")) {
							String[] args = string.split(":");
							Client.targetHintX = Integer.parseInt(args[1]);
							Client.targetHintY = Integer.parseInt(args[2]);
							Client.targetHintPlayerId = Integer.parseInt(args[3]);
						}
						else if (string.startsWith("npcpetid")) {
							String[] args = string.split(":");
							Client.npcPetId = Integer.parseInt(args[1]);
						}
						else if (string.startsWith("npcsecondpetid")) {
							String[] args = string.split(":");
							Client.npcSecondPetId = Integer.parseInt(args[1]);
						}
						else if (string.startsWith("summoningorboff")) {
							Client.specOrb = false;
							Client.disableSpecOrb = true;
						}
						else if (string.startsWith("summoningorbon")) {
							Client.specOrb = true;
							Client.disableSpecOrb = false;
						}
						else if (string.startsWith("citytimer")) {
							Client.timeCityTimerStarted = System.currentTimeMillis();
							Client.cityTimer = true;
						}
						else if (string.startsWith("offcitytimer")) {
							Client.cityTimer = false;
						}
						else if (string.startsWith("screenshot")) {
							String[] args = string.split(" ");
							String name = args[1];
							String location = args[2];
							new Thread(new Screenshot(name, location)).start();
						}
						else if (string.equals("closepminterface")) {
							setMessagePromptRaised(false, false);
							Client.setUpdateChatAreaPending(true);
						}
						else if (string.startsWith("scrollmax")) {
							String[] args = string.split(" ");
							int scrollValue = Integer.parseInt(args[2]);
							interfaceId = Integer.parseInt(args[1]);
							RSInterface.interfaceCache[interfaceId].scrollMax = scrollValue;
						}
						else if (string.equals("zombiecountdown")) {
							showCountdown = true;
							countDownTime = System.currentTimeMillis();
						}
						else if (string.startsWith("zombierequest")) {
							String s4 = string.replace("zombierequest ", "");
							long l18 = TextClass.longForName(s4);
							if (!Utility.isIgnored(l18)) {
								Client.instance.pushMessage("wishes to duo with you.", ClientConstants.CHAT_TYPE_DUEL, s4, "");
							}
						}
						else if (string.startsWith("scrollup")) {
							scrollUp = true;
						}
						else if (string.equals("donatornotification")) {
							Client.showDonatorNotification = true;
						}
						else if (string.equals("donatornotificationoff")) {
							Client.showDonatorNotification = false;
						}
						else if (string.equals("xpbonusinterfaceon")) {
							Client.showXpBonusInterface = true;
						} else if (string.equals("xpbonusinterfaceoff")) {
							Client.showXpBonusInterface = false;
						}
						else if (string.startsWith("settextclicked")) {
							String[] args = string.split(" ");
							int id = Integer.parseInt(args[1]);
							boolean state = Boolean.parseBoolean(args[2]);
							setTextClicked(id, state);
						}
						else if (string.startsWith("displaybots")) {
							String[] args = string.split(":");
							if (args[1].equals("on")) {
								botsOff = false;
							}
							else {
								botsOff = true;
							}
						}
						else if (string.startsWith("textcolour")) {
							String[] args = string.split(" ");
							int id = Integer.parseInt(args[1]);
							int colour = Integer.parseInt(args[2]);
							RSInterface.interfaceCache[id].textColour = colour;
						}
						else if (string.startsWith("itemchange")) {
							String[] args = string.split(" ");
							int itemId = Integer.parseInt(args[1]);
							itemId++;
							interfaceId = Integer.parseInt(args[2]);
							RSInterface.interfaceCache[interfaceId].inv[0] = itemId;
						}
						else if (string.startsWith("website")) {

							String[] args = string.split(" ");
							Client.instance.openURL(args[1]);
						}
						else if (string.startsWith("achievementpercentage")) {
							String[] args = string.split(" ");
							int percentage = Integer.parseInt(args[1]);
							achievementPercentage = percentage;
						}
						else if (string.startsWith("titlepercentage")) {
							String[] args = string.split(" ");
							int percentage = Integer.parseInt(args[1]);
							titleInterfacePercentage = percentage;
						}
						else if (string.startsWith("clearframes")) {

							String[] args = string.split(" ");
							int firstId = Integer.parseInt(args[1]);
							int lastId = Integer.parseInt(args[2]);
							for (int frame = firstId; frame <= lastId; frame++) {
								Client.instance.sendFrame126("", frame);
								if (frame >= 24600 && frame <= 24699) {
									Client.instance.clanList[frame - 24600] = "";
								}
							}

						}
						else if (string.startsWith("cleartextclicked")) {
							clearTextClicked();
						}
						else if (string.startsWith("lastxamount")) {
							lastXAmount = Integer.parseInt(split[1]);
						}
						else if (string.startsWith("addpvpblacklist")) {
							displayInputBox(16, "Enter player to Pvp blacklist");
						}
						else if (string.startsWith("namepreset")) {
							displayInputBox(17, "Enter the name of your preset");
						}
					/*
					 * else if (string.equals("readwebsite")) { new Thread(new Runnable() { public
					 * void run() { WebsiteRead.readWebsiteData(); } }).start(); }
					 */

						else if (string.startsWith("closedialogue")) {
							Client.setDialogueOptionUsed(0);
							backDialogueId = -1;
							setUpdateChatAreaPending(true);
							setDialogueOptionsShowing(false);
						}
					}
					else if (string.startsWith(":capepart")) {
						completionistCapePartEdited = string.substring(9);
					}
					else if (string.startsWith(":capecolour")) {
						completionistCapeColourClicked = string.substring(11);
					}
					else if (string.startsWith(":capemainpart")) {
						string = string.substring(13);
						if (string.contains("TOP DETAIL")) {
							Client.completionistCapeTopDetailColour = string.substring(10);
						}

						else if (string.contains("TOP")) {
							Client.completionistCapeTopColour = string.substring(3);
						}
						else if (string.contains("BOTTOM DETAIL")) {
							Client.completionistCapeBottomDetailColour = string.substring(13);
						}
						else if (string.contains("BOTTOM")) {
							Client.completionistCapeBottomColour = string.substring(6);
						}
					}
					else {
						Client.instance.pushMessage(string, ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
					}
					Client.instance.packetType = -1;
					return true;

				case 1:
					for (int k4 = 0; k4 < Client.instance.playerArray.length; k4++)
						if (Client.instance.playerArray[k4] != null)
							Client.instance.playerArray[k4].anim = -1;
					for (int j12 = 0; j12 < Client.instance.npcArray.length; j12++)
						if (Client.instance.npcArray[j12] != null)
							Client.instance.npcArray[j12].anim = -1;
					Client.instance.packetType = -1;
					return true;

				case 50:
					long l4 = Client.instance.inStream.readQWord();
					int i18 = Client.instance.inStream.readUnsignedByte();
					String s7 = TextClass.fixName(TextClass.nameForLong(l4));
					for (int k24 = 0; k24 < friendsCount; k24++) {
						if (l4 != Client.instance.friendsListAsLongs[k24])
							continue;
						if (Client.instance.friendsNodeIds[k24] != i18) {
							Client.instance.friendsNodeIds[k24] = i18;
							if (i18 >= 2) {
								Client.instance.pushMessage(s7 + " has logged in.", ClientConstants.CHAT_TYPE_PRIVATE_MESSAGE_LOGGED_IN_OR_OUT, "", s7);
							}
							if (i18 <= 1) {
								Client.instance.pushMessage(s7 + " has logged out.", ClientConstants.CHAT_TYPE_PRIVATE_MESSAGE_LOGGED_IN_OR_OUT, "", s7);
							}
						}
						s7 = null;

					}
					if (s7 != null && friendsCount < 200) {
						Client.instance.friendsListAsLongs[friendsCount] = l4;
						Client.instance.friendsList[friendsCount] = s7;
						Client.instance.friendsNodeIds[friendsCount] = i18;
						friendsCount++;
					}
					for (boolean flag6 = false; !flag6;) {
						flag6 = true;
						for (int k29 = 0; k29 < friendsCount - 1; k29++)
							if (Client.instance.friendsNodeIds[k29] != nodeID && Client.instance.friendsNodeIds[k29 + 1] == nodeID || Client.instance.friendsNodeIds[k29] == 0 && Client.instance.friendsNodeIds[k29 + 1] != 0) {
								int j31 = Client.instance.friendsNodeIds[k29];
								Client.instance.friendsNodeIds[k29] = Client.instance.friendsNodeIds[k29 + 1];
								Client.instance.friendsNodeIds[k29 + 1] = j31;
								String s10 = Client.instance.friendsList[k29];
								Client.instance.friendsList[k29] = Client.instance.friendsList[k29 + 1];
								Client.instance.friendsList[k29 + 1] = s10;
								long l32 = Client.instance.friendsListAsLongs[k29];
								Client.instance.friendsListAsLongs[k29] = Client.instance.friendsListAsLongs[k29 + 1];
								Client.instance.friendsListAsLongs[k29 + 1] = l32;
								flag6 = false;
							}
					}
					Client.instance.packetType = -1;
					return true;

				case 110:
					Client.instance.packetType = -1;
					return true;

				case 254:
					Client.instance.markType = Client.instance.inStream.readUnsignedByte();
					if (Client.instance.markType == 1) {
						Client.instance.markedNpc = Client.instance.inStream.readUnsignedWord();
					}
					if (Client.instance.markType >= 2 && Client.instance.markType <= 6) {
						if (Client.instance.markType == 2) {
							Client.instance.anInt937 = 64;
							Client.instance.anInt938 = 64;
						}
						if (Client.instance.markType == 3) {
							Client.instance.anInt937 = 0;
							Client.instance.anInt938 = 64;
						}
						if (Client.instance.markType == 4) {
							Client.instance.anInt937 = 128;
							Client.instance.anInt938 = 64;
						}
						if (Client.instance.markType == 5) {
							Client.instance.anInt937 = 64;
							Client.instance.anInt938 = 0;
						}
						if (Client.instance.markType == 6) {
							Client.instance.anInt937 = 64;
							Client.instance.anInt938 = 128;
						}
						Client.instance.markType = 2;
						Client.instance.markedX = Client.instance.inStream.readUnsignedWord();
						Client.instance.markedY = Client.instance.inStream.readUnsignedWord();
						Client.instance.anInt936 = Client.instance.inStream.readUnsignedByte();
					}
					if (Client.instance.markType == 10) {
						Client.instance.markedPlayer = Client.instance.inStream.readUnsignedWord();
					}
					Client.instance.packetType = -1;
					return true;

				case 248:
					interfaceId = Client.instance.inStream.method435();
					int overlayInterfaceId = Client.instance.inStream.readUnsignedWord();

					if (backDialogueId != -1) {
						backDialogueId = -1;
						setUpdateChatAreaPending(true);
					}
					if (inputDialogState != 0) {
						inputDialogState = 0;
						setUpdateChatAreaPending(true);
					}
					setInterfaceDisplayed(interfaceId);
					setInvOverlayInterfaceID(overlayInterfaceId);
					Client.setTabId(3, true);
					setTabAreaAltered(true);
					setDialogueOptionsShowing(false);
					Client.instance.packetType = -1;
					return true;

				case 79:
					int j5 = Client.instance.inStream.method434();
					int l12 = Client.instance.inStream.method435();
					RSInterface class9_3 = RSInterface.interfaceCache[j5];
					if (class9_3 != null && class9_3.getType() == 0) {
						if (l12 < 0)
							l12 = 0;
						if (l12 > class9_3.scrollMax - class9_3.height)
							l12 = class9_3.scrollMax - class9_3.height;
						class9_3.scrollPosition = l12;
					}
					Client.instance.packetType = -1;
					return true;

				case 68:
					for (int k5 = 0; k5 < Client.instance.variousSettings.length; k5++)
						if (Client.instance.variousSettings[k5] != Client.instance.anIntArray1045[k5]) {
							Client.instance.variousSettings[k5] = Client.instance.anIntArray1045[k5];
							Client.instance.handleVarp(k5);
						}
					Client.instance.packetType = -1;
					return true;

				case 196:
					// Private messaging according to the server packet. player.getOutStream().createFrameVarSize(196);
					long l5 = Client.instance.inStream.readQWord();
					Client.instance.inStream.readDWord();
					int authority = Client.instance.inStream.readUnsignedByte();
					boolean ignored = false;
					if (Utility.isIgnored(l5) && !ClientConstants.isModeratorOrAbove(authority)) {
						ignored = true;
					}
					if (!ignored && Client.instance.messagesAreIgnored == 0) {
						try {
							String s9 = TextInput.method525(Client.instance.pktSize - 13, Client.instance.inStream);

							// Moderator or Administrator.
							if (ClientConstants.isModeratorOrAbove(authority)) {
								Client.instance.pushMessage(s9, ClientConstants.CHAT_TYPE_PRIVATE_MESSAGE_RECEIVED_MOD, PlayerRank.getIconText(authority) + TextClass.fixName(TextClass.nameForLong(l5)), TextClass.fixName(TextClass.nameForLong(l5)));
							}
							else {
								Client.instance.pushMessage(s9, ClientConstants.CHAT_TYPE_PRIVATE_MESSAGE_RECEIVED_NORMAL, PlayerRank.getIconText(authority) + TextClass.fixName(TextClass.nameForLong(l5)), TextClass.fixName(TextClass.nameForLong(l5)));
							}
						}
						catch (Exception e) {
							e.printStackTrace();
							SignLink.reporterror("cde1");
						}
					}
					Client.instance.packetType = -1;
					return true;

				case 85:
					Client.instance.anInt1269 = Client.instance.inStream.method427();
					Client.instance.anInt1268 = Client.instance.inStream.method427();
					Client.instance.packetType = -1;
					return true;

				case 24:
					Client.instance.flashingSidebarTab = Client.instance.inStream.method428();
					if (Client.instance.flashingSidebarTab == getTabId()) {
						if (Client.instance.flashingSidebarTab == 3)
							setTabId(1, true);
						else
							setTabId(3, true);
					}
					Client.instance.packetType = -1;
					return true;

				case 246:
					interfaceId = Client.instance.inStream.method434();
					int i13 = Client.instance.inStream.readUnsignedWord();
					int k18 = Client.instance.inStream.readUnsignedWord();

					if (RSInterface.interfaceCache[interfaceId] == null) {
						Utility.print(String.format("Null interface for packet 246; %s", interfaceId));
					}
					if (k18 == 65535) {
						RSInterface.interfaceCache[interfaceId].modelTypeDisabled = 0;
						Client.instance.packetType = -1;
						return true;
					}
					else {
						ItemDefinition itemDef = ItemDefinition.forId(k18);
						RSInterface.interfaceCache[interfaceId].modelTypeDisabled = 4;
						RSInterface.interfaceCache[interfaceId].mediaID = k18;
						RSInterface.interfaceCache[interfaceId].modelRotationY = itemDef.rotationY;
						RSInterface.interfaceCache[interfaceId].modelRotationX = itemDef.rotationX;
						RSInterface.interfaceCache[interfaceId].modelZoom = (itemDef.zoom * 100) / i13;
						Client.instance.packetType = -1;
						return true;
					}

				case 171:
					boolean flag1 = Client.instance.inStream.readUnsignedByte() == 1;
					int j13 = Client.instance.inStream.readUnsignedWord();
					RSInterface.interfaceCache[j13].invisible = flag1;
					Client.instance.packetType = -1;
					return true;

				case 142:
					int j6 = Client.instance.inStream.method434();
					resetInterfaceSequence(j6);
					if (backDialogueId != -1) {
						backDialogueId = -1;
						setUpdateChatAreaPending(true);
					}
					if (inputDialogState != 0) {
						inputDialogState = 0;
						setUpdateChatAreaPending(true);
					}
					setInvOverlayInterfaceID(j6);
					setTabAreaAltered(true);
					setInterfaceDisplayed(-1);
					setDialogueOptionsShowing(false);
					Client.instance.packetType = -1;
					return true;

				case 126:
					String text = Client.instance.inStream.readString();
					int frame = Client.instance.inStream.method435();
					if ((frame == 24396 || frame == 24391) && useOldWildernessInterface) {
						frame = 199;
					}
					Client.instance.sendFrame126(text, frame);
					if (frame >= 24600 && frame <= 24699) {
						if (text.startsWith("<img=")) {
							text = text.substring(text.indexOf(">") + 1);
						}
						Client.instance.clanList[frame - 24600] = text;
					}

					// Update Kdr overlay text
					if (frame >= 28038 && frame <= 28040) {
						String[] parse = text.split("@");
						int index = frame - 28038;
						String[] kdrOverlayText =
						{"Kills: ", "Deaths: ", "K/D Ratio: "};
						Client.instance.sendFrame126(kdrOverlayText[index] + parse[2], 14251 + index);
					}
					// Clan chat "Owner: xx" frame.
					if (frame == 18139) {
						Client.clanName = text;
					}
					Client.instance.packetType = -1;
					return true;

				case 206:
					Client.instance.publicChatMode = Client.instance.inStream.readUnsignedByte();
					Client.instance.privateChatMode = Client.instance.inStream.readUnsignedByte();
					Client.instance.tradeMode = Client.instance.inStream.readUnsignedByte();
					setUpdateChatAreaPending(true);
					Client.instance.packetType = -1;
					return true;

				case 240:
					Client.instance.weight = Client.instance.inStream.readSignedWord();
					Client.instance.packetType = -1;
					return true;

				case 8:
					int k6 = Client.instance.inStream.method436();
					int l13 = Client.instance.inStream.readUnsignedWord();
					RSInterface.interfaceCache[k6].modelTypeDisabled = 1;
					RSInterface.interfaceCache[k6].mediaID = l13;
					Client.instance.packetType = -1;
					return true;

				case 122:
					int l6 = Client.instance.inStream.method436();
					int i14 = Client.instance.inStream.readSignedWord();
					RSInterface.interfaceCache[l6].textColour = i14;
					Client.instance.packetType = -1;
					return true;

				case 53:
					// Item update packet
					int frameId = Client.instance.inStream.readUnsignedWord();
					RSInterface class9_1 = RSInterface.interfaceCache[frameId];
					int totalItems = Client.instance.inStream.readUnsignedWord();
					for (int j22 = 0; j22 < totalItems; j22++) {
						int i25 = Client.instance.inStream.readUnsignedByte();
						if (i25 == 255) {
							i25 = Client.instance.inStream.method440();
						}
						class9_1.inv[j22] = Client.instance.inStream.method436();
						class9_1.invStackSizes[j22] = i25;
					}
					for (int j25 = totalItems; j25 < class9_1.inv.length; j25++) {
						class9_1.inv[j25] = 0;
						class9_1.invStackSizes[j25] = 0;
					}
					Content.updateVengeanceRunes();
					Client.instance.packetType = -1;
					return true;

				case 9:
					boolean show = Client.instance.inStream.readUnsignedByte() == 1;

					if (!show) {
						for (int tabId = 0; tabId < 8; tabId++) {
							RSInterface container = RSInterface.interfaceCache[tabId == 0 ? 5382 : 35_000 + tabId];

							RSInterface separator = RSInterface.interfaceCache[35_009 + tabId];

							if (container == null || separator == null) {
								continue;
							}
							container.height = 36;
							container.invisible = true;
							separator.invisible = true;
						}
					} else {
						int containerWithSeparator = 35_009;

						int y = 0;

						for (int tabId = 0; tabId < 9; tabId++) {
							RSInterface container = RSInterface.interfaceCache[tabId == 0 ? 5382 : 35_000 + tabId];

							if (container == null) {
								continue;
							}
							int lastRowWithItem = container.lastRowWithItem();

							if (lastRowWithItem == -1) {
								container.height = 0;
								container.invisible = true;
								continue;
							}
							container.height = lastRowWithItem;
							container.invisible = false;

							RSInterface separator = RSInterface.interfaceCache[containerWithSeparator];

							if (tabId > 0) {
								container.offsetY = y + 7;
							}
							int value = (tabId == 0 ? (26 + container.invSpritePadX) : (32 + container.invSpritePadX));

							y += Math.max(40, lastRowWithItem * value);

							if (separator == null) {
								continue;
							}
							separator.offsetY = y;
							separator.invisible = false;

							containerWithSeparator++;
						}
						if (containerWithSeparator > 35_009) {
							containerWithSeparator--;
						}

						while (containerWithSeparator < 35_018) {
							RSInterface separator = RSInterface.interfaceCache[containerWithSeparator++];

							if (separator == null) {
								continue;
							}
							separator.offsetY = 0;
							separator.invisible = true;
						}
						//RSInterface.interfaceCache[5385].scrollMax = Math.max(y, Config.PRE_EOC ? 420 : 228);
					}
					Client.instance.packetType = -1;
					return true;

				case 230:
					int j7 = Client.instance.inStream.method435();
					int j14 = Client.instance.inStream.readUnsignedWord();
					int k19 = Client.instance.inStream.readUnsignedWord();
					int k22 = Client.instance.inStream.method436();
					RSInterface.interfaceCache[j14].modelRotationY = k19;
					RSInterface.interfaceCache[j14].modelRotationX = k22;
					RSInterface.interfaceCache[j14].modelZoom = j7;
					Client.instance.packetType = -1;
					return true;

				case 221:
					Client.instance.friendserverState = Client.instance.inStream.readUnsignedByte();
					Client.instance.packetType = -1;
					return true;

				case 177:
					Client.instance.inCutsceneMode = true;
					Client.instance.cutsceneFocusLocalX = Client.instance.inStream.readUnsignedByte();
					Client.instance.cutsceneFocusLocalY = Client.instance.inStream.readUnsignedByte();
					Client.instance.cutsceneFocusZ = Client.instance.inStream.readUnsignedWord();
					Client.instance.cutsceneRotateSpeed = Client.instance.inStream.readUnsignedByte();
					Client.instance.cutsceneRotateMul = Client.instance.inStream.readUnsignedByte();
					if (Client.instance.cutsceneRotateMul >= 100) {
						int k7 = Client.instance.cutsceneFocusLocalX * 128 + 64;
						int k14 = Client.instance.cutsceneFocusLocalY * 128 + 64;
						int i20 = Client.instance.getLand(Client.instance.plane, k14, k7) - Client.instance.cutsceneFocusZ;
						int l22 = k7 - Client.instance.xCameraPos;
						int k25 = i20 - zCameraPos;
						int j28 = k14 - Client.instance.yCameraPos;
						int i30 = (int) Math.sqrt(l22 * l22 + j28 * j28);
						yCameraCurve = (int) (Math.atan2(k25, i30) * 325.94900000000001D) & 0x7ff;
						xCameraCurve = (int) (Math.atan2(l22, j28) * -325.94900000000001D) & 0x7ff;
						if (yCameraCurve < 128)
							yCameraCurve = 128;
						if (yCameraCurve > 383)
							yCameraCurve = 383;
					}
					Client.instance.packetType = -1;
					return true;

				case 249:
					Client.instance.anInt1046 = Client.instance.inStream.method426();
					Client.instance.unknownInt10 = Client.instance.inStream.method436();
					Client.instance.packetType = -1;
					return true;

				case 65:
					UpdateEntity.updateNPCs(Client.instance.inStream, Client.instance.pktSize);
					Client.instance.packetType = -1;
					return true;

				case 27:
					setMessagePromptRaised(false, false);
					inputDialogState = 1;
					Client.instance.amountOrNameInput = "";
					setUpdateChatAreaPending(true);
					Client.instance.packetType = -1;
					return true;

				case 187:
					setMessagePromptRaised(false, false);
					inputDialogState = 2;
					Client.instance.amountOrNameInput = "";
					setUpdateChatAreaPending(true);
					Client.instance.packetType = -1;
					return true;

				case 97:
					int l7 = Client.instance.inStream.readUnsignedWord();
					System.out.println("setting itf id to " + l7);
					resetInterfaceSequence(l7);
					if (getInvOverlayInterfaceID() != -1) {
						setInvOverlayInterfaceID(-1);
						setTabAreaAltered(true);
					}
					if (backDialogueId != -1) {
						backDialogueId = -1;
						setUpdateChatAreaPending(true);
					}
					if (inputDialogState != 0) {
						inputDialogState = 0;
						setUpdateChatAreaPending(true);
					}
					setInterfaceDisplayed(l7);
					setDialogueOptionsShowing(false);
					Client.instance.packetType = -1;
					return true;

				case 218:
					int i8 = Client.instance.inStream.method438();
					Client.instance.dialogId = i8;
					setUpdateChatAreaPending(true);
					Client.instance.packetType = -1;
					return true;

				case 87:
					int j8 = Client.instance.inStream.method434();
					int l14 = Client.instance.inStream.method439();
					Client.instance.anIntArray1045[j8] = l14;
					if (Client.instance.variousSettings[j8] != l14) {
						Client.instance.variousSettings[j8] = l14;
						Client.instance.handleVarp(j8);
						if (Client.instance.dialogId != -1)
							setUpdateChatAreaPending(true);
					}
					Client.instance.packetType = -1;
					return true;

				case 36:
					int id = Client.instance.inStream.method434();
					byte state = Client.instance.inStream.readSignedByte();
					Client.instance.anIntArray1045[id] = state;
					if (Client.instance.variousSettings[id] != state) {
						Client.instance.variousSettings[id] = state;
						Client.instance.handleVarp(id);
						if (Client.instance.dialogId != -1) {
							setUpdateChatAreaPending(true);
						}
					}
					Client.instance.packetType = -1;
					return true;

				case 61:
					Client.instance.anInt1055 = Client.instance.inStream.readUnsignedByte();
					Client.instance.packetType = -1;
					return true;

				case 200:
					int l8 = Client.instance.inStream.readUnsignedWord();
					int animation = Client.instance.inStream.readSignedWord();
					RSInterface class9_4 = RSInterface.interfaceCache[l8];
					/*
					if (npcChatHeadUsed >= 6392)
					{
							class9_4.modelZoom = 2000;
					}
					else
					{
							if (animation == 9764)
							{
									animation = 596;
							}
							else if (animation == 9850)
							{
									animation = 591;
							}
							else if (animation == 9760)
							{
									animation = 591;
							}
							class9_4.modelZoom = 900;
					}
					*/
					class9_4.modelZoom = Config.PRE_EOC ? 1800 : 900;
					class9_4.sequenceDisabled = animation;
					if (animation == -1) {
						class9_4.sequenceFrame = 0;
						class9_4.sequenceCycle = 0;
					}
					//class9_4.offsetY = 20; // TODO #TIP this will set the x offset of the model. of npc chat head

					Client.instance.packetType = -1;
					return true;

				case 219:
					Client.closeAllInterfaces();
					Client.instance.packetType = -1;
					return true;

				case 29:
					int npcIndex = Client.instance.inStream.readUnsignedWord();

					int item = Client.instance.inStream.readUnsignedWord();

					int slot = Client.instance.inStream.readUnsignedByte();

					Npc npc = Client.instance.npcArray[npcIndex];


					if (npc != null) {
						EntityDefinition definition = npc.desc;

						if (definition != null) {
							ItemDefinition itemDefinition = ItemDefinition.forId(item);

							if (itemDefinition != null) {
								definition.models[slot] = itemDefinition.maleModel;
								definition.modelColourToEdit = itemDefinition.modelColourToEdit;
								definition.newModelColourProduced = itemDefinition.newModelColourProduced;
							}
						}
					} else {
					}

					Client.instance.packetType = -1;

					return true;

				case 34:
					int interface1 = Client.instance.inStream.readUnsignedWord();
					RSInterface class9_2 = RSInterface.interfaceCache[interface1];
					while (Client.instance.inStream.currentOffset < Client.instance.pktSize) {
						int itemSlot = Client.instance.inStream.method422();
						int itemId = Client.instance.inStream.readUnsignedWord();
						int itemAmount = Client.instance.inStream.readUnsignedByte();
						if (itemAmount == 255) {
							itemAmount = Client.instance.inStream.readDWord();
						}
						if (itemSlot >= 0 && itemSlot < class9_2.inv.length) {
							class9_2.inv[itemSlot] = itemId;
							class9_2.invStackSizes[itemSlot] = itemAmount;
						}
					}

					// Rune pouch.
					if (interface1 == 22917) {
						Content.updateVengeanceRunes();
					}
					Client.instance.packetType = -1;
					return true;

                case 102:
                    String textForFade = Client.instance.inStream.readString();

                    byte stateForFade = Client.instance.inStream.readSignedByte();

                    byte seconds = Client.instance.inStream.readSignedByte();

                    byte elongation = Client.instance.inStream.readSignedByte();

                    Client.fadingScreen = new BlackFadingScreen(Client.instance.newBoldFont, textForFade, stateForFade, seconds, elongation, 0, 0, Client.getGameScreenWidth(),
                            Client.getGameScreenHeight(), 100);

                    Client.instance.packetType = -1;

                    return true;

				case 4:
				case 44:
				case 84:
				case 101:
				case 105:
				case 117:
				case 147:
				case 151:
				case 156:
				case 160:
				case 215:
					Client.instance.handleSecondaryPacket(Client.instance.inStream, Client.instance.packetType);
					Client.instance.packetType = -1;
					return true;

				case 106:
					setTabId(Client.instance.inStream.method427(), true);
					setTabAreaAltered(true);
					Client.instance.packetType = -1;
					return true;

				case 164:
					interfaceId = Client.instance.inStream.method434();
					resetInterfaceSequence(interfaceId);
					if (getInvOverlayInterfaceID() != -1) {
						setInvOverlayInterfaceID(-1);
						setTabAreaAltered(true);
					}
					Client.timeUpdateChatSent = System.currentTimeMillis();
					backDialogueId = interfaceId;
					setUpdateChatAreaPending(true);
					setDialogueOptionsShowing(false);
					Client.instance.packetType = -1;
					return true;

			}
			SignLink.reporterror("T1 - Packet Type: " + Client.instance.packetType + "," + Client.instance.pktSize + " - " + Client.instance.ptype1 + "," + Client.instance.ptype2);
		}
		catch (IOException e) {
			e.printStackTrace();
			Client.instance.dropClient("Packet exception");
		}
		catch (Exception e) {
			e.printStackTrace();
			String s2 = "T2 - Packet Type: " + Client.instance.packetType + "," + Client.instance.ptype1 + "," + Client.instance.ptype2 + " - " + Client.instance.pktSize + "," + (Client.instance.baseX + myPlayer.smallX[0]) + "," + (Client.instance.baseY + myPlayer.smallY[0]) + " - ";
			for (int j15 = 0; j15 < Client.instance.pktSize && j15 < 50; j15++) {
				s2 = s2 + Client.instance.inStream.buffer[j15] + ",";
			}
			SignLink.reporterror(s2);
		}
		Client.instance.packetType = -1;
		return true;
	}

	private static String getPacketName(int packetType) {
		switch (packetType) {
			case 85:
			case 117:
				return "Projectile";

			case 208:
				return "Walkable interface";

			case 73:
				return "Region update";
			case 219:
				return "Close all interfaces";
			case 174:
				return "Sound";
			case 253:
				return "Send message";

			case 134:
				return "Update skill level";

			case 71:
				return "Set side bar interface";
			case 126:
				return "Interface frame update";
			case 53:
				return "Inventory update---------------";
			case 246:
				return "Update Combat interface etc";

			case 81:
				return "Update players";

			case 65:
				return "Update npcs";

			case 36: // Such as setting quick prayers to ticked, or run orb to run/walk.
				return "Interface config";

			case 70:
				return "Update special bar bits";

			case 171:
				return "Special attack bar config";

			case 50:
				return "Friends list update";

			case 34: // Such as updating runes inside rune pouch, looting bag.
				return "Update interface item id";

			case 104:
				return "Update right click options";
		}
		return "Unknown packet: " + packetType;
	}
}
