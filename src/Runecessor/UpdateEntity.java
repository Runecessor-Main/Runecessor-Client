package Runecessor;

public class UpdateEntity {

	public static int playerMovements = 0;

	public static int newPlayers = 0;

	public static int appearanceUpdatesCount;

	public static int playerMasks = 0;

	public static void updatePlayers(int i, Stream stream) {
		Client.instance.entityUpdateCount = 0;
		Client.instance.entityCount = 0;
		updateLocalPlayer(stream);
		updatePlayerMovements(stream);
		updateNewPlayers(stream, i);
		updatePlayerMasks(stream);
		if (Packet.debugEntityPackets) {
			Utility.print("Player movements: " + playerMovements + ", new players: " + newPlayers + ", player masks: " + playerMasks + ", appearance: " + appearanceUpdatesCount);
		}
		playerMovements = 0;
		newPlayers = 0;
		playerMasks = 0;
		appearanceUpdatesCount = 0;
		for (int k = 0; k < Client.instance.entityUpdateCount; k++) {
			int l = Client.instance.entityUpdateIndices[k];
			if (Client.instance.playerArray[l].updateCycle != Client.loopCycle) {
				Client.instance.playerArray[l] = null;
			}
		}

		if (stream.currentOffset != i) {
			SignLink.reporterror("Error packet size mismatch in getplayer pos:" + stream.currentOffset + " psize:" + i);
			throw new RuntimeException("eek");
		}
		for (int i1 = 0; i1 < Client.instance.playerCount; i1++) {
			if (Client.instance.playerArray[Client.instance.playerIndices[i1]] == null) {
				SignLink.reporterror(Client.instance.myUsername + " null entry in pl list - pos:" + i1 + " size:" + Client.instance.playerCount);
				throw new RuntimeException("eek");
			}
		}

	}

	private static void updatePlayerMovements(Stream stream) {
		int j = stream.readBits(8);
		if (j < Client.instance.playerCount) {
			for (int k = j; k < Client.instance.playerCount; k++) {
				Client.instance.entityUpdateIndices[Client.instance.entityUpdateCount++] = Client.instance.playerIndices[k];
			}

		}
		if (j > Client.instance.playerCount) {
			SignLink.reporterror(Client.instance.myUsername + " Too many players");
			throw new RuntimeException("eek");
		}
		Client.instance.playerCount = 0;
		for (int l = 0; l < j; l++) {
			int i1 = Client.instance.playerIndices[l];
			Player player = Client.instance.playerArray[i1];
			int j1 = stream.readBits(1);
			player.index = i1;
			playerMovements++;
			if (j1 == 0) {
				Client.instance.playerIndices[Client.instance.playerCount++] = i1;
				player.updateCycle = Client.loopCycle;
			}
			else {
				int k1 = stream.readBits(2);
				if (k1 == 0) {
					Client.instance.playerIndices[Client.instance.playerCount++] = i1;
					player.updateCycle = Client.loopCycle;
					Client.instance.entityIndices[Client.instance.entityCount++] = i1;
				}
				else if (k1 == 1) {
					Client.instance.playerIndices[Client.instance.playerCount++] = i1;
					player.updateCycle = Client.loopCycle;
					int l1 = stream.readBits(3);
					player.moveInDir(false, l1);
					int j2 = stream.readBits(1);
					if (j2 == 1)
						Client.instance.entityIndices[Client.instance.entityCount++] = i1;
				}
				else if (k1 == 2) {
					Client.instance.playerIndices[Client.instance.playerCount++] = i1;
					player.updateCycle = Client.loopCycle;
					int i2 = stream.readBits(3);
					player.moveInDir(true, i2);
					int k2 = stream.readBits(3);
					player.moveInDir(true, k2);
					int l2 = stream.readBits(1);
					if (l2 == 1) {
						Client.instance.entityIndices[Client.instance.entityCount++] = i1;
					}
				}
				else if (k1 == 3) {
					Client.instance.entityUpdateIndices[Client.instance.entityUpdateCount++] = i1;
				}
			}
		}
	}

	private static void updateLocalPlayer(Stream stream) {
		stream.initBitAccess();
		int j = stream.readBits(1);
		if (j == 0)
			return;
		int k = stream.readBits(2);
		if (k == 0) {
			Client.instance.entityIndices[Client.instance.entityCount++] = Client.instance.myPlayerIndex;
			return;
		}
		if (k == 1) {
			int l = stream.readBits(3);
			Client.myPlayer.moveInDir(false, l);
			int k1 = stream.readBits(1);
			if (k1 == 1)
				Client.instance.entityIndices[Client.instance.entityCount++] = Client.instance.myPlayerIndex;
			return;
		}
		if (k == 2) {
			int i1 = stream.readBits(3);
			Client.myPlayer.moveInDir(true, i1);
			int l1 = stream.readBits(3);
			Client.myPlayer.moveInDir(true, l1);
			int j2 = stream.readBits(1);
			if (j2 == 1)
				Client.instance.entityIndices[Client.instance.entityCount++] = Client.instance.myPlayerIndex;
			return;
		}
		if (k == 3) {
			int height = stream.readBits(2);
			Client.instance.plane = height;
			int j1 = stream.readBits(1);
			int updateRequired = stream.readBits(1);
			if (updateRequired == 1) {
				Client.instance.entityIndices[Client.instance.entityCount++] = Client.instance.myPlayerIndex;
			}
			int y = stream.readBits(7);
			int x = stream.readBits(7);
			Client.myPlayer.setPos(x, y, j1 == 1);
		}
	}


	public static void handlePlayers() {
		for (int i = -1; i < Client.instance.playerCount; i++) {
			int j;
			if (i == -1) {
				j = Client.instance.myPlayerIndex;
			}
			else {
				j = Client.instance.playerIndices[i];
			}
			Player player = Client.instance.playerArray[j];
			if (player != null) {
				Entity.handleEntity(Client.instance, player);
			}
		}

	}

	private static void updateNewNPCs(int i, Stream stream) {
		while (stream.bitPosition + 21 < i * 8) {
			int k = stream.readBits(14);
			if (k == 16383) {
				break;
			}
			if (Client.instance.npcArray[k] == null) {
				Client.instance.npcArray[k] = new Npc();
			}
			newNpcAmount++;
			Npc npc = Client.instance.npcArray[k];
			Client.instance.npcIndices[Client.instance.npcCount++] = k;
			npc.updateCycle = Client.loopCycle;
			int l = stream.readBits(5);
			if (l > 15) {
				l -= 32;
			}
			int i1 = stream.readBits(5);
			if (i1 > 15) {
				i1 -= 32;
			}
			int j1 = stream.readBits(1);
			int npcBits = stream.readBits(14);
			npc.desc = EntityDefinition.forId(npcBits);
			int k1 = stream.readBits(1);
			if (k1 == 1) {
				Client.instance.entityIndices[Client.instance.entityCount++] = k;
			}
			boolean sent = false;
			if (npc.desc != null) {
				if (npc.desc.name != null) {
					Client.npcInvisible.add(npc.id + ", " + npc.desc.name);
					sent = true;
				}
			}
			else {
				Utility.print(npcBits + " is null.");
			}
			npc.size = npc.desc.size;
			Entity.rotateSpeed = npc.desc.turnSpeed;
			npc.walkSequence = npc.desc.walkAnim;
			npc.turn180Sequence = npc.desc.turn180Sequence;
			npc.turnRightSequence = npc.desc.turnRightSequence;
			npc.turnLeftSequence = npc.desc.turnLeftSequence;
			npc.standAnimation = npc.desc.standAnim;
			npc.setPos(Client.myPlayer.smallX[0] + i1, Client.myPlayer.smallY[0] + l, j1 == 1);
		}
		stream.finishBitAccess();
	}

	private static void updateNewPlayers(Stream stream, int i) {
		while (stream.bitPosition + 10 < i * 8) {
			newPlayers++;

			int j = stream.readBits(11);

			if (j == 2047)
				break;
			if (Client.instance.playerArray[j] == null) {
				Client.instance.playerArray[j] = new Player();
				if (Client.instance.aStreamArray895s[j] != null) {
					Client.instance.playerArray[j].updatePlayer(Client.instance.aStreamArray895s[j]);
				}
			}
			Client.instance.playerIndices[Client.instance.playerCount++] = j;
			Player player = Client.instance.playerArray[j];
			player.updateCycle = Client.loopCycle;
			int k = stream.readBits(1);
			if (k == 1) {
				Client.instance.entityIndices[Client.instance.entityCount++] = j;
			}
			int l = stream.readBits(1);
			int i1 = stream.readBits(5);
			if (i1 > 15) {
				i1 -= 32;
			}
			int j1 = stream.readBits(5);
			if (j1 > 15) {
				j1 -= 32;
			}
			int orientation = stream.readBits(5);

			player.turnDirection = orientation <= 14 && orientation >= 8 ? (orientation - 8) * 128 : (orientation + 8) * 128;

			player.setPos(Client.myPlayer.smallX[0] + j1, Client.myPlayer.smallY[0] + i1, l == 1);
		}
		stream.finishBitAccess();
	}

	private static void updatePlayerMask(int i, int j, Stream stream, Player player) {
		if ((i & 0x400) != 0) {
			player.moveX0 = stream.method428();
			player.moveY0 = stream.method428();
			player.moveX1 = stream.method428();
			player.moveY1 = stream.method428();
			player.moveEndCycle = stream.method436() + Client.loopCycle;
			player.moveStartCycle = stream.method435() + Client.loopCycle;
			player.moveDirection = stream.method428();
			player.resetPath();
		}
		if ((i & 0x100) != 0) {
			int gfx = stream.method434();
			int height = stream.readDWord();
			if (player.spotanim != -1) {
				player.spotanim = -1;
			}
			if (gfx >= 0) {
				player.spotanim = gfx;
				player.spotanimY = height >> 16;
				player.spotanimEndCycle = Client.loopCycle + (height & 0xffff);
				player.spotanimFrame = 0;
				player.spotanimCycle = 0;
				if (player.spotanimEndCycle > Client.loopCycle)
					player.spotanimFrame = -1;
				if (player.spotanim == 65535)
					player.spotanim = -1;
				try {
					if (player.spotanim != -1 && player.spotanim <= SpotAnim.cache.length - 1) {
						if (SpotAnim.cache[player.spotanim] != null) {
							if (Frames.animationlist[SpotAnim.cache[player.spotanim].animationSequence.files[0]].length == 0) {
								Client.onDemandFetcher.sendImmediately(1, SpotAnim.cache[player.spotanim].animationSequence.files[0]);
							}
						}
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		if ((i & 8) != 0) {
			int anim = stream.method434();
			if (anim == 65535) {
				anim = -1;
			}
			int i2 = stream.method427();

			if (anim == player.anim && anim != -1) {
				int i3 = Sequences.anims[anim].delayType;
				if (i3 == 1) {
					player.sequenceFrame = 0;
					player.sequenceCycle = 0;
					player.sequenceDelayCycle = i2;
					player.sequenceResetCycle = 0;
				}
				if (i3 == 2)
					player.sequenceResetCycle = 0;
			}
			else if (anim == -1 || player.anim == -1 || Sequences.anims[anim].priority1 >= Sequences.anims[player.anim].priority1) {
				player.setAnim(anim);
				player.sequenceFrame = 0;
				player.sequenceCycle = 0;
				player.sequenceDelayCycle = i2;
				player.sequenceResetCycle = 0;
				player.stationaryPathPosition = player.smallXYIndex;
			}
		}

		// Forced text.
		if ((i & 4) != 0) {
			player.textSpoken = stream.readString();
			if (player.textSpoken.charAt(0) == '~') {
				player.textSpoken = player.textSpoken.substring(1);
			}

			long l3 = TextClass.longForName(player.getName());
			boolean ignored = Utility.isIgnored(l3) && !ClientConstants.isModeratorOrAbove(player.privelage);
			String s = player.textSpoken;
			String original = s;
			if (s.contains("<img=")) {
				String replace = s.substring(s.indexOf("<"), s.indexOf(">") + 1);
				if (replace != null) {
					player.textSpoken = s.replace(replace, "");
				}
			}

			if (!ignored) {
				Client.rights = 0;
			}

			else {
				player.textSpoken = "";
			}
			player.spokenColor = 0;
			player.spokenEffect = 0;
			player.textCycle = 150;
		}

		// Receiving chat update.
		if ((i & 0x80) != 0) {
			int i1 = stream.method434();
			int authority = stream.readUnsignedByte();
			int j3 = stream.method427();
			int k3 = stream.currentOffset;
			if (player.getName() != null && player.visible) {
				long l3 = TextClass.longForName(player.getName());
				boolean ignored = false;
				if (!ClientConstants.isModeratorOrAbove(player.privelage)) {
					ignored = Utility.isIgnored(l3);
				}
				if (!ignored && Client.instance.messagesAreIgnored == 0) {
					try {
						Client.instance.aStream_834.currentOffset = 0;
						stream.method442(j3, 0, Client.instance.aStream_834.buffer);
						Client.instance.aStream_834.currentOffset = 0;
						Client.oldText = "";
						String s = TextInput.method525(j3, Client.instance.aStream_834);//
						player.textSpoken = s;
						player.spokenColor = i1 >> 8;
						player.spokenEffect = i1 & 0xff;
						player.textCycle = 150;
						// Messages of other players appearing in the chatbox.
						Client.rights = player.privelage;
						Client.instance.pushMessage(s, ClientConstants.CHAT_TYPE_OTHER_PLAYERS, PlayerRank.getIconText(authority) + PlayerTitle.messagesOfOtherPlayers(player), player.getName());
						Client.rights = 0;
					}
					catch (Exception e) {
						e.printStackTrace();
						SignLink.reporterror("cde2");
					}
				}
			}
			stream.currentOffset = k3 + j3;
		}
		if ((i & 1) != 0) {
			player.interactingEntity = stream.method434();
			if (Client.rubberBandEffect && player.interactingEntity == 0) {
				player.interactingEntity = -1;
			}
			if (player.interactingEntity == 65535)
				player.interactingEntity = -1;
		}
		if ((i & 0x10) != 0) {
			int j1 = stream.method427();
			byte abyte0[] = new byte[j1];
			Stream stream_1 = new Stream(abyte0);
			stream.readBytes(j1, 0, abyte0);
			Client.instance.aStreamArray895s[j] = stream_1;
			player.updatePlayer(stream_1);
		}
		if ((i & 2) != 0) {
			player.faceX = stream.method436();
			player.faceY = stream.method434();
		}

		// First hitsplat on same gametick.
		if ((i & 0x20) != 0) {
			int damage = Client.instance.inStream.method435();
			int hitsplatColour = stream.readUnsignedByte();
			int icon = stream.readUnsignedByte();
			int soakDamage = Client.instance.inStream.method435();
			player.updateHitData(hitsplatColour, damage, Client.loopCycle, icon, soakDamage);
			player.lastCombatTime = System.currentTimeMillis();
			player.loopCycleStatus = Client.loopCycle + 300;
			player.constitution = player.currentHealth = Client.instance.inStream.method435();
			player.maxConstitution = player.maxHealth = Client.instance.inStream.method435();
		}

		// Second hitsplat on same gametick.
		if ((i & 0x200) != 0) {
			int damage = Client.instance.inStream.method435();
			int hitsplatColour = stream.readUnsignedByte();
			int icon = stream.readUnsignedByte();
			int soakDamage = Client.instance.inStream.method435();
			player.updateHitData(hitsplatColour, damage, Client.loopCycle, icon, soakDamage);
			player.loopCycleStatus = Client.loopCycle + 300;
			player.constitution = player.currentHealth = Client.instance.inStream.method435();
			player.maxConstitution = player.maxHealth = Client.instance.inStream.method435();
		}
	}

	private static void updateNPCMasks(Stream stream) {
		for (int j = 0; j < Client.instance.entityCount; j++) {
			int k = Client.instance.entityIndices[j];
			Npc npc = Client.instance.npcArray[k];
			int l = stream.readUnsignedByte();

			if ((l & 4) != 0) {
				l += stream.readUnsignedByte() << 8;
			}
			npcMaskAmount++;

			// Animation update
			if ((l & 0x10) != 0) {
				int anim = stream.method434();
				if (anim == 65535) {
					anim = -1;
				}
				int i2 = stream.readUnsignedByte();
				if (anim == npc.anim && anim != -1) {
					int l2 = Sequences.anims[anim].delayType;
					if (l2 == 1) {
						npc.sequenceFrame = 0;
						npc.sequenceCycle = 0;
						npc.sequenceDelayCycle = i2;
						npc.sequenceResetCycle = 0;
					}
					if (l2 == 2)
						npc.sequenceResetCycle = 0;
				}
				else if (anim == -1 || npc.anim == -1 || Sequences.anims[anim].priority1 >= Sequences.anims[npc.anim].priority1) {
					if (anim != -50) {
						npc.setAnim(anim);
						npc.sequenceFrame = 0;
						npc.sequenceCycle = 0;
						npc.sequenceDelayCycle = i2;
						npc.sequenceResetCycle = 0;
						npc.stationaryPathPosition = npc.smallXYIndex;
					}
				}
			}
			if ((l & 8) != 0) {
				int j1 = Client.instance.inStream.method435();
				int j2 = stream.method427();
				int icon = stream.readUnsignedByte();
				npc.updateHitData(j2, j1, Client.loopCycle, icon, 0);
				npc.loopCycleStatus = Client.loopCycle + 300;
				npc.currentHealth = Client.instance.inStream.method435();
				npc.maxHealth = Client.instance.inStream.method435();
			}
			if ((l & 0x80) != 0) {
				npc.spotanim = stream.readUnsignedWord();
				int k1 = stream.readDWord();
				npc.spotanimY = k1 >> 16;
				npc.spotanimEndCycle = Client.loopCycle + (k1 & 0xffff);
				npc.spotanimFrame = 0;
				npc.spotanimCycle = 0;
				if (npc.spotanimEndCycle > Client.loopCycle)
					npc.spotanimFrame = -1;
				if (npc.spotanim == 65535)
					npc.spotanim = -1;

				if (npc.spotanim > 0) {
					try {
						int file = SpotAnim.cache[npc.spotanim].animationSequence.files[0];

						if (Frames.animationlist[file].length == 0) {
							Client.onDemandFetcher.sendImmediately(1, file);
						}
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			if ((l & 0x20) != 0) {
				npc.interactingEntity = stream.readUnsignedWord();

				if (npc.interactingEntity == 65535)
					npc.interactingEntity = -1;
			}
			if ((l & 1) != 0) {
				npc.textSpoken = stream.readString();
				npc.textCycle = 100;

			}
			if ((l & 0x40) != 0) {
				int l1 = Client.instance.inStream.method435();
				int k2 = stream.method428();
				int icon = stream.readUnsignedByte();
				npc.updateHitData(k2, l1, Client.loopCycle, icon, 0);
				npc.loopCycleStatus = Client.loopCycle + 300;
				npc.currentHealth = Client.instance.inStream.method435();
				npc.maxHealth = Client.instance.inStream.method435();
			}

			// Npc transformation mask
			if ((l & 2) != 0) {
				npc.desc = EntityDefinition.forId(stream.method436());

				if (npc.desc != null) {
					npc.size = npc.desc.size;
					Entity.rotateSpeed = npc.desc.turnSpeed;
					npc.walkSequence = npc.desc.walkAnim;
					npc.turn180Sequence = npc.desc.turn180Sequence;
					npc.turnRightSequence = npc.desc.turnRightSequence;
					npc.turnLeftSequence = npc.desc.turnLeftSequence;
					npc.standAnimation = npc.desc.standAnim;
				}
			}
			if ((l & 0x200) != 0) {
				npc.faceX = stream.method434();
				npc.faceY = stream.method434();
			}

			if ((l & 0x100) != 0) {
				npc.standAnimation = stream.readDWord();
			}
		}
	}

	private static void updateNPCMovement(Stream stream) {
		stream.initBitAccess();
		int k = stream.readBits(8);
		if (k < Client.instance.npcCount) {
			for (int l = k; l < Client.instance.npcCount; l++) {
				Client.instance.entityUpdateIndices[Client.instance.entityUpdateCount++] = Client.instance.npcIndices[l];
			}

		}
		if (k > Client.instance.npcCount) {
			SignLink.reporterror(Client.instance.myUsername + " Too many npcs, " + k + ", " + Client.instance.npcCount);
		}
		Client.instance.npcCount = 0;
		for (int i1 = 0; i1 < k; i1++) {
			int j1 = Client.instance.npcIndices[i1];
			Npc npc = Client.instance.npcArray[j1];
			int k1 = stream.readBits(1);
			npc.index = j1;
			npcMovementAmount++;
			if (k1 == 0) {
				Client.instance.npcIndices[Client.instance.npcCount++] = j1;
				npc.updateCycle = Client.loopCycle;
			}
			else {
				int l1 = stream.readBits(2);
				if (l1 == 0) {
					Client.instance.npcIndices[Client.instance.npcCount++] = j1;
					npc.updateCycle = Client.loopCycle;
					Client.instance.entityIndices[Client.instance.entityCount++] = j1;
				}
				else if (l1 == 1) {
					Client.instance.npcIndices[Client.instance.npcCount++] = j1;
					npc.updateCycle = Client.loopCycle;
					int i2 = stream.readBits(3);
					npc.moveInDir(false, i2);
					int k2 = stream.readBits(1);
					if (k2 == 1)
						Client.instance.entityIndices[Client.instance.entityCount++] = j1;
				}
				else if (l1 == 2) {
					Client.instance.npcIndices[Client.instance.npcCount++] = j1;
					npc.updateCycle = Client.loopCycle;
					int j2 = stream.readBits(3);
					npc.moveInDir(true, j2);
					int l2 = stream.readBits(3);
					npc.moveInDir(true, l2);
					int i3 = stream.readBits(1);
					if (i3 == 1)
						Client.instance.entityIndices[Client.instance.entityCount++] = j1;
				}
				else if (l1 == 3)
					Client.instance.entityUpdateIndices[Client.instance.entityUpdateCount++] = j1;
			}
		}

	}

	public static int npcMovementAmount = 0;

	public static int newNpcAmount = 0;

	public static int npcMaskAmount = 0;

	public static void updateNPCs(Stream stream, int i) {
		npcMovementAmount = 0;
		newNpcAmount = 0;
		npcMaskAmount = 0;
		Client.instance.entityUpdateCount = 0;
		Client.instance.entityCount = 0;
		updateNPCMovement(stream);
		updateNewNPCs(i, stream);
		updateNPCMasks(stream);
		if (Packet.debugEntityPackets) {
			Utility.print("Npc movements: " + npcMovementAmount + ", New npcs: " + newNpcAmount + ", npc masks: " + npcMaskAmount);
		}
		for (int k = 0; k < Client.instance.entityUpdateCount; k++) {
			int l = Client.instance.entityUpdateIndices[k];
			if (Client.instance.npcArray[l].updateCycle != Client.loopCycle) {
				Client.instance.npcArray[l].desc = null;
				Client.instance.npcArray[l] = null;
			}
		}

		if (stream.currentOffset != i) {
			SignLink.reporterror(Client.instance.myUsername + " size mismatch in getnpcpos - pos:" + stream.currentOffset + " psize:" + i);
			throw new RuntimeException("eek");
		}
		for (int i1 = 0; i1 < Client.instance.npcCount; i1++)
			if (Client.instance.npcArray[Client.instance.npcIndices[i1]] == null) {
				SignLink.reporterror(Client.instance.myUsername + " null entry in npc list - pos:" + i1 + " size:" + Client.instance.npcCount);
				throw new RuntimeException("eek");
			}

	}

	private static void updatePlayerMasks(Stream stream) {
		for (int j = 0; j < Client.instance.entityCount; j++) {
			playerMasks++;
			int k = Client.instance.entityIndices[j];
			Player player = Client.instance.playerArray[k];
			int l = stream.readUnsignedByte();
			if ((l & 0x40) != 0)
				l += stream.readUnsignedByte() << 8;
			updatePlayerMask(l, k, stream, player);
		}
	}

	public static void updateEntities() {
		try {
			int anInt974 = 0;
			for (int j = -1; j < Client.instance.playerCount + Client.instance.npcCount; j++) {
				Object obj;
				if (j == -1)
					obj = Client.myPlayer;
				else if (j < Client.instance.playerCount)
					obj = Client.instance.playerArray[Client.instance.playerIndices[j]];
				else
					obj = Client.instance.npcArray[Client.instance.npcIndices[j - Client.instance.playerCount]];
				if (obj == null || !((Entity) (obj)).isVisible())
					continue;
				if (obj instanceof Player && Client.botsOff) {
					if (((Player) obj).gameModeTitle.contains("[Bot]") && (System.currentTimeMillis() - ((Player) obj).lastCombatTime) >= 5000) {
						continue;
					}
				}

				if (obj instanceof Npc) {
					EntityDefinition entityDef = ((Npc) obj).desc;

					if (Client.nameAbove && entityDef.showOnMinimap) {
						String s = entityDef.name;
						s = s + Content.combatDiffColor(Client.myPlayer.combatLevel, entityDef.combatLevel);
						if (entityDef.combatLevel > 0)
						{
							s = s + " (level-" + entityDef.combatLevel + ")";
						}
						int yPositionExtra = 0;
						if (entityDef.headicons >= 0) {
							yPositionExtra += -26;
						}
						TextDrawingArea textDrawingArea = Client.instance.aTextDrawingArea_1271;
						Client.instance.npcScreenPos(((Entity) (obj)), ((Entity) (obj)).height + 15, entityDef.name);
						textDrawingArea.method382(0xFFFF33, Client.spriteDrawX, s, Client.spriteDrawY - 8 + yPositionExtra, true);
					}

					if (entityDef.childrenIDs != null) {
						entityDef = entityDef.getOverride();
					}
					if (entityDef == null) {
						continue;
					}
				}
				if (j < Client.instance.playerCount) {
					int l = 30;
					Player player = (Player) obj;
					if (player.headIcon >= 0) {
						Client.instance.npcScreenPos(((Entity) (obj)), ((Entity) (obj)).height + 15, "");
						if (Client.spriteDrawX > -1) {
							if (player.skullIcon < Client.instance.skullIcons.length) {
								Client.instance.skullIcons[player.skullIcon].drawSprite(Client.spriteDrawX - 12, Client.spriteDrawY - l);
								l += 24;
							}
							if (player.headIcon < 24) {
								Client.instance.headIcons[player.headIcon].drawSprite(Client.spriteDrawX - 12, Client.spriteDrawY - l);
								l += 21;
							}

							if (Client.nameAbove) {
								int col = 0x3399ff;
								Client.instance.newSmallFont.drawCenteredString(player.getName(), Client.spriteDrawX, Client.spriteDrawY - l + 20, col, 100);
							}
						}
					}
					if (j >= 0 && Client.instance.markType == 10 && Client.instance.markedPlayer == Client.instance.playerIndices[j]) {
						Client.instance.npcScreenPos(((Entity) (obj)), ((Entity) (obj)).height + 15, "");
						if (Client.spriteDrawX > -1) {
							Client.instance.headIconsHint[player.hintIcon].drawSprite(Client.spriteDrawX - 12, Client.spriteDrawY - l);
						}
					}
				}
				else {
					EntityDefinition entityDef_1 = ((Npc) obj).desc;
					if (entityDef_1.headicons >= 0 && entityDef_1.headicons < Client.instance.headIcons.length) {
						Client.instance.npcScreenPos(((Entity) (obj)), ((Entity) (obj)).height + 15, entityDef_1.name);
						if (Client.spriteDrawX > -1) {
							Client.instance.headIcons[entityDef_1.headicons].drawSprite(Client.spriteDrawX - 12, Client.spriteDrawY - 30);
						}
					}
					if (Client.instance.markType == 1 && Client.instance.markedNpc == Client.instance.npcIndices[j - Client.instance.playerCount] && Client.loopCycle % 20 < 10) {
						Client.instance.npcScreenPos(((Entity) (obj)), ((Entity) (obj)).height + 15, "");
						if (Client.spriteDrawX > -1) {
							Client.instance.headIconsHint[0].drawSprite(Client.spriteDrawX - 12, Client.spriteDrawY - 28);
						}
					}
				}
				if (((Entity) (obj)).textSpoken != null && (j >= Client.instance.playerCount || ClientConstants.isModeratorOrAbove(((Player) obj).privelage) || Client.instance.publicChatMode == ClientConstants.PUBLIC_ON || Client.instance.publicChatMode == ClientConstants.PUBLIC_HIDE || Client.instance.publicChatMode == ClientConstants.PUBLIC_FRIENDS && Client.instance.isFriendOrSelf(((Player) obj).getName()))) {
					Client.instance.npcScreenPos(((Entity) (obj)), ((Entity) (obj)).height, "");
					if (Client.spriteDrawX > -1 && anInt974 < Client.instance.spokenMaxCount) {
						Client.instance.spokenOffsetX[anInt974] = Client.instance.chatTextDrawingArea.method384(((Entity) (obj)).textSpoken) / 2;
						Client.instance.spokenOffsetY[anInt974] = Client.instance.chatTextDrawingArea.anInt1497;
						Client.instance.spokenX[anInt974] = Client.spriteDrawX;
						Client.instance.spokenY[anInt974] = Client.spriteDrawY;
						Client.instance.spokenColor[anInt974] = ((Entity) (obj)).spokenColor;
						Client.instance.spokenEffect[anInt974] = ((Entity) (obj)).spokenEffect;
						Client.instance.spokenCycle[anInt974] = ((Entity) (obj)).textCycle;
						Client.instance.spokenMessage[anInt974++] = ((Entity) (obj)).textSpoken;
						if (Client.instance.showSpokenEffects == 0 && ((Entity) (obj)).spokenEffect >= 1 && ((Entity) (obj)).spokenEffect <= 3) {
							Client.instance.spokenOffsetY[anInt974] += 10;
							Client.instance.spokenY[anInt974] += 5;
						}
						if (Client.instance.showSpokenEffects == 0 && ((Entity) (obj)).spokenEffect == 4)
							Client.instance.spokenOffsetX[anInt974] = 60;
						if (Client.instance.showSpokenEffects == 0 && ((Entity) (obj)).spokenEffect == 5)
							Client.instance.spokenOffsetY[anInt974] += 5;
					}
				}
				if (((Entity) (obj)).loopCycleStatus > Client.loopCycle) {
					try {
						Client.instance.npcScreenPos(((Entity) (obj)), ((Entity) (obj)).height + 15, "");
						if (Client.spriteDrawX > -1) {
							drawHpBar(((Entity) (obj)), obj);
						}
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
				// combat box
				if (obj instanceof Npc) {
					Npc npc = ((Npc) obj);
					if (Client.myPlayer.interactingEntity == -1) {
						if ((npc.interactingEntity - 32768) == Client.instance.myPlayerIndex) {
							Client.instance.currentInteract = npc;
							CombatBox.startTime();
						}
					} else {
						if (npc.index == Client.myPlayer.interactingEntity) {
							Client.instance.currentInteract = npc;
							CombatBox.startTime();
						}
					}
				} else if (obj instanceof Player) {
					Player player = ((Player) obj);
					if (Client.myPlayer.interactingEntity == -1) {
						if ((player.interactingEntity - 32768) == Client.instance.myPlayerIndex) {
							Client.instance.currentInteract = player;
							CombatBox.startTime();
						}

					} else {
						if (player.index == Client.myPlayer.interactingEntity - 32768) {
							Client.instance.currentInteract = player;
							CombatBox.startTime();
						}
					}
				}
				HitSplat.draw(obj);
				for (int k = 0; k < anInt974; k++) {
					int k1 = Client.instance.spokenX[k];
					int l1 = Client.instance.spokenY[k];
					int j2 = Client.instance.spokenOffsetX[k];
					int k2 = Client.instance.spokenOffsetY[k];
					boolean flag = true;
					while (flag) {
						flag = false;
						for (int l2 = 0; l2 < k; l2++)
							if (l1 + 2 > Client.instance.spokenY[l2] - Client.instance.spokenOffsetY[l2] && l1 - k2 < Client.instance.spokenY[l2] + 2 && k1 - j2 < Client.instance.spokenX[l2] + Client.instance.spokenOffsetX[l2] && k1 + j2 > Client.instance.spokenX[l2] - Client.instance.spokenOffsetX[l2] && Client.instance.spokenY[l2] - Client.instance.spokenOffsetY[l2] < l1) {
								l1 = Client.instance.spokenY[l2] - Client.instance.spokenOffsetY[l2];
								flag = true;
							}

					}
					Client.spriteDrawX = Client.instance.spokenX[k];
					Client.spriteDrawY = Client.instance.spokenY[k] = l1;
					String s = Client.instance.spokenMessage[k];
					if (Client.instance.showSpokenEffects == 0) {
						int i3 = 0xffff00;
						if (Client.instance.spokenColor[k] < 6)
							i3 = ClientConstants.SPOKEN_PALETTE[Client.instance.spokenColor[k]];
						if (Client.instance.spokenColor[k] == 6)
							i3 = Client.instance.sceneCycle % 20 >= 10 ? 0xffff00 : 0xff0000;
						if (Client.instance.spokenColor[k] == 7)
							i3 = Client.instance.sceneCycle % 20 >= 10 ? 65535 : 255;
						if (Client.instance.spokenColor[k] == 8)
							i3 = Client.instance.sceneCycle % 20 >= 10 ? 0x80ff80 : 45056;
						if (Client.instance.spokenColor[k] == 9) {
							int j3 = 150 - Client.instance.spokenCycle[k];
							if (j3 < 50)
								i3 = 0xff0000 + 1280 * j3;
							else if (j3 < 100)
								i3 = 0xffff00 - 0x50000 * (j3 - 50);
							else if (j3 < 150)
								i3 = 65280 + 5 * (j3 - 100);
						}
						if (Client.instance.spokenColor[k] == 10) {
							int k3 = 150 - Client.instance.spokenCycle[k];
							if (k3 < 50)
								i3 = 0xff0000 + 5 * k3;
							else if (k3 < 100)
								i3 = 0xff00ff - 0x50000 * (k3 - 50);
							else if (k3 < 150)
								i3 = (255 + 0x50000 * (k3 - 100)) - 5 * (k3 - 100);
						}
						if (Client.instance.spokenColor[k] == 11) {
							int l3 = 150 - Client.instance.spokenCycle[k];
							if (l3 < 50)
								i3 = 0xffffff - 0x50005 * l3;
							else if (l3 < 100)
								i3 = 65280 + 0x50005 * (l3 - 50);
							else if (l3 < 150)
								i3 = 0xffffff - 0x50000 * (l3 - 100);
						}
						if (Client.instance.spokenEffect[k] == 0) {
							Client.instance.chatTextDrawingArea.drawText(0, s, Client.spriteDrawY + 1, Client.spriteDrawX);
							Client.instance.chatTextDrawingArea.drawText(i3, s, Client.spriteDrawY, Client.spriteDrawX);
						}
						if (Client.instance.spokenEffect[k] == 1) {
							Client.instance.chatTextDrawingArea.method386(0, s, Client.spriteDrawX, Client.instance.sceneCycle, Client.spriteDrawY + 1);
							Client.instance.chatTextDrawingArea.method386(i3, s, Client.spriteDrawX, Client.instance.sceneCycle, Client.spriteDrawY);
						}
						if (Client.instance.spokenEffect[k] == 2) {
							Client.instance.chatTextDrawingArea.method387(Client.spriteDrawX, s, Client.instance.sceneCycle, Client.spriteDrawY + 1, 0);
							Client.instance.chatTextDrawingArea.method387(Client.spriteDrawX, s, Client.instance.sceneCycle, Client.spriteDrawY, i3);
						}
						if (Client.instance.spokenEffect[k] == 3) {
							Client.instance.chatTextDrawingArea.method388(150 - Client.instance.spokenCycle[k], s, Client.instance.sceneCycle, Client.spriteDrawY + 1, Client.spriteDrawX, 0);
							Client.instance.chatTextDrawingArea.method388(150 - Client.instance.spokenCycle[k], s, Client.instance.sceneCycle, Client.spriteDrawY, Client.spriteDrawX, i3);
						}
						if (Client.instance.spokenEffect[k] == 4) {
							int i4 = Client.instance.chatTextDrawingArea.method384(s);
							int k4 = ((150 - Client.instance.spokenCycle[k]) * (i4 + 100)) / 150;
							DrawingArea.setDrawingArea(334, Client.spriteDrawX - 50, Client.spriteDrawX + 50, 0);
							Client.instance.chatTextDrawingArea.method385(0, s, (Client.spriteDrawX + 50) - k4, Client.spriteDrawY + 1);
							Client.instance.chatTextDrawingArea.method385(i3, s, (Client.spriteDrawX + 50) - k4, Client.spriteDrawY);
							DrawingArea.defaultDrawingAreaSize();
						}
						if (Client.instance.spokenEffect[k] == 5) {
							int j4 = 150 - Client.instance.spokenCycle[k];
							int l4 = 0;
							if (j4 < 25)
								l4 = j4 - 25;
							else if (j4 > 125)
								l4 = j4 - 125;
							DrawingArea.setDrawingArea(Client.spriteDrawY + 5, 0, 512, Client.spriteDrawY - Client.instance.chatTextDrawingArea.anInt1497 - 1);
							Client.instance.chatTextDrawingArea.drawText(0, s, Client.spriteDrawY + 1 + l4, Client.spriteDrawX);
							Client.instance.chatTextDrawingArea.drawText(i3, s, Client.spriteDrawY + l4, Client.spriteDrawX);
							DrawingArea.defaultDrawingAreaSize();
						}
					}
					else {
						Client.instance.chatTextDrawingArea.drawText(0, s, Client.spriteDrawY + 1, Client.spriteDrawX);
						Client.instance.chatTextDrawingArea.drawText(0xffff00, s, Client.spriteDrawY, Client.spriteDrawX);
					}
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void drawHpBar(Entity entity, Object obj) {
		if (((Entity) (obj)).maxHealth == 0) {
			return;
		}
		int hpPercentOld = (((Entity) (obj)).currentHealth * 30) / ((Entity) (obj)).maxHealth;
		if (hpPercentOld > 30) {
			hpPercentOld = 30;
		}
		if (hpPercentOld < 1 && ((Entity) (obj)).currentHealth > 0) {
			hpPercentOld = 1;
		}
		int hpPercent = (((Entity) (obj)).currentHealth * 56) / ((Entity) (obj)).maxHealth;
		if (hpPercent > 56) {
			hpPercent = 56;
		}
		if (hpPercent < 2 && ((Entity) (obj)).currentHealth > 0) {
			hpPercent = 2;
		}
		if (Client.newHitPointsBar) {
			if (((Entity) (obj)).maxHealth > 255) {
				Client.cacheSprite[652].drawSprite(Client.spriteDrawX - 44, Client.spriteDrawY - 5);
				hpPercent = (((Entity) (obj)).currentHealth * 90) / ((Entity) (obj)).maxHealth;
				Client.cacheSprite[653] = new Sprite(ClientConstants.getSpritesLocation() + "653.png", hpPercent, 7);
				Client.cacheSprite[653].drawSprite(Client.spriteDrawX - 44, Client.spriteDrawY - 5);
			}
			else {
				Client.cacheSprite[60].drawSprite(Client.spriteDrawX - 28, Client.spriteDrawY - 5);
				Client.cacheSprite[59] = new Sprite(ClientConstants.getSpritesLocation() + "59.png", hpPercent, 7);
				Client.cacheSprite[59].drawSprite(Client.spriteDrawX - 28, Client.spriteDrawY - 5);
			}
		}
		else {
			if (((Entity) (obj)).maxHealth > 255) {
				hpPercentOld = (((Entity) (obj)).currentHealth * 90) / ((Entity) (obj)).maxHealth;
				DrawingArea.method336(5, Client.spriteDrawY - 3, Client.spriteDrawX - 44, 65280, hpPercentOld);
				DrawingArea.method336(5, Client.spriteDrawY - 3, (Client.spriteDrawX - 44) + hpPercentOld, 0xff0000, 90 - hpPercentOld);
			}
			else {
				DrawingArea.method336(5, Client.spriteDrawY - 3, Client.spriteDrawX - 15, 65280, hpPercentOld);
				DrawingArea.method336(5, Client.spriteDrawY - 3, (Client.spriteDrawX - 15) + hpPercentOld, 0xff0000, 30 - hpPercentOld);
			}
		}

	}

}