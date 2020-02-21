package Runecessor;

public class Entity extends SceneNode {

	public final void setPos(int i, int j, boolean flag) {
		if (anim != -1 && Sequences.anims[anim].walkFlag == 1)
			setAnim(-1);
		if (!flag) {
			int k = i - smallX[0];
			int l = j - smallY[0];
			if (k >= -8 && k <= 8 && l >= -8 && l <= 8) {
				if (smallXYIndex < 9)
					smallXYIndex++;
				for (int i1 = smallXYIndex; i1 > 0; i1--) {
					smallX[i1] = smallX[i1 - 1];
					smallY[i1] = smallY[i1 - 1];
					pathRunning[i1] = pathRunning[i1 - 1];
				}

				smallX[0] = i;
				smallY[0] = j;
				pathRunning[0] = false;
				return;
			}
		}
		smallXYIndex = 0;
		stationaryPathPosition = 0;
		resyncWalkCycle = 0;
		smallX[0] = i;
		smallY[0] = j;
		x = smallX[0] * 128 + size * 64;
		y = smallY[0] * 128 + size * 64;
	}

	public final void resetPath() {
		smallXYIndex = 0;
		stationaryPathPosition = 0;
	}

	public int index;
	public int[] hitmarkMove = new int[4];

	public long[] fadeAppliedTime = new long[4];

	public long[] hitSplatAppliedTime = new long[4];

	public int[] moveTimer = new int[4];

	public int[] hitmarkTrans = new int[4];

	public int[] hitIcon = new int[4];

	public int[] soakDamage = new int[4];

	public int[] hitMarkPos = new int[4];

	public final void updateHitData(int hitsplatColour, int damage, int clientCycle, int icon, int soak) {
		for (int i1 = 0; i1 < 4; i1++) {
			if (hitsLoopCycleEndTime[i1] <= System.currentTimeMillis()) {
				hitIcon[i1] = icon;
				hitmarkMove[i1] = 5;
				moveTimer[i1] = 2;
				hitmarkTrans[i1] = 255;
				soakDamage[i1] = soak;
				hitArray[i1] = damage * ((Client.x10Damage == true && damage > 0) ? 10 : 1);
				if (Client.x10Damage && damage > 0) {
					hitArray[i1] += new java.util.Random().nextInt(9);
				}
				long time = System.currentTimeMillis();
				hitMarkTypes[i1] = hitsplatColour;
				int random = Utility.random(0, 0);
				hitSplatAppliedTime[i1] = time + random;
				hitsLoopCycleEndTime[i1] = time + 1000 + random;
				hitsLoopCycleStartTime[i1] = time + random;
				hitMarkPos[i1] = 0;
				return;
			}
		}

		int index = 0;
		long lowest = Long.MAX_VALUE;
		//if no new hitsplat applied, then scan through again and the one that is nearly finished shall be replaced.
		for (int i1 = 0; i1 < 4; i1++) {
			if (hitsLoopCycleEndTime[i1] < lowest) {
				lowest = hitsLoopCycleEndTime[i1];
				index = i1;
			}
		}
		hitIcon[index] = icon;
		hitmarkMove[index] = 5;
		moveTimer[index] = 2;
		hitmarkTrans[index] = 255;
		soakDamage[index] = soak;
		hitArray[index] = damage * ((Client.x10Damage == true && damage > 0) ? 10 : 1);
		if (Client.x10Damage && damage > 0) {
			hitArray[index] += new java.util.Random().nextInt(9);
		}
		hitMarkTypes[index] = hitsplatColour;

		long time = System.currentTimeMillis();
		int random = Utility.random(0, 0);
		hitSplatAppliedTime[index] = time + random;
		hitsLoopCycleEndTime[index] = time + 1250 + random;
		hitsLoopCycleStartTime[index] = time + random;
		hitMarkPos[index] = 0;
	}

	public static void handleNPCs(Client client) {
		for (int j = 0; j < client.npcCount; j++) {
			int k = client.npcIndices[j];
			Npc npc = client.npcArray[k];
			if (npc != null) {
				handleEntity(client, npc);
			}
		}
	}

	public static void handleEntity(Client client, Entity entity) {
		if (entity.x < 128 || entity.y < 128 || entity.x >= 13184 || entity.y >= 13184) {
			entity.setAnim(-1);
			entity.spotanim = -1;
			entity.moveEndCycle = 0;
			entity.moveStartCycle = 0;
			entity.x = entity.smallX[0] * 128 + entity.size * 64;
			entity.y = entity.smallY[0] * 128 + entity.size * 64;
			entity.resetPath();
		}
		if (entity == Client.myPlayer && (entity.x < 1536 || entity.y < 1536 || entity.x >= 11776 || entity.y >= 11776)) {
			entity.setAnim(-1);
			entity.spotanim = -1;
			entity.moveEndCycle = 0;
			entity.moveStartCycle = 0;
			entity.x = entity.smallX[0] * 128 + entity.size * 64;
			entity.y = entity.smallY[0] * 128 + entity.size * 64;
			entity.resetPath();
		}
		if (entity.moveEndCycle > Client.loopCycle) {
			resyncEntityMovement(entity);
		}
		else if (entity.moveStartCycle >= Client.loopCycle) {
			startEntityMovement(entity);
		}
		else {
			handleEntityMovement(entity);
		}
		handleEntityRotation(client, entity);
		handleEntitySequences(entity);
	}

	private static void resyncEntityMovement(Entity entity) {
		int i = entity.moveEndCycle - Client.loopCycle;
		int j = entity.moveX0 * 128 + entity.size * 64;
		int k = entity.moveY0 * 128 + entity.size * 64;
		entity.x += (j - entity.x) / i;
		entity.y += (k - entity.y) / i;
		entity.resyncWalkCycle = 0;
		if (entity.moveDirection == 0)
			entity.turnDirection = 1024;
		if (entity.moveDirection == 1)
			entity.turnDirection = 1536;
		if (entity.moveDirection == 2)
			entity.turnDirection = 0;
		if (entity.moveDirection == 3)
			entity.turnDirection = 512;
	}

	private static void startEntityMovement(Entity entity) {
		if (entity.anim >= 0 && entity.anim <= Sequences.anims.length - 1) {
			if (entity.moveStartCycle == Client.loopCycle || entity.anim == -1 || entity.sequenceDelayCycle != 0 || entity.sequenceCycle + 1 > Sequences.anims[entity.anim].getDuration(entity.sequenceFrame)) {
				int i = entity.moveStartCycle - entity.moveEndCycle;
				int j = Client.loopCycle - entity.moveEndCycle;
				int k = entity.moveX0 * 128 + entity.size * 64;
				int l = entity.moveY0 * 128 + entity.size * 64;
				int i1 = entity.moveX1 * 128 + entity.size * 64;
				int j1 = entity.moveY1 * 128 + entity.size * 64;
				entity.x = (k * (i - j) + i1 * j) / i;
				entity.y = (l * (i - j) + j1 * j) / i;
			}
		}
		entity.resyncWalkCycle = 0;
		if (entity.moveDirection == 0) {
			entity.turnDirection = 1024;
		}
		if (entity.moveDirection == 1) {
			entity.turnDirection = 1536;
		}
		if (entity.moveDirection == 2) {
			entity.turnDirection = 0;
		}
		if (entity.moveDirection == 3) {
			entity.turnDirection = 512;
		}
		entity.yaw = entity.turnDirection;
	}

	@SuppressWarnings("static-access")
	private static void handleEntityMovement(Entity entity) {
		entity.rotateSpeed = Client.smoothCharacterTurn ? 32 : 32;
		entity.moveSequence = entity.standAnimation;
		if (entity.smallXYIndex == 0) {
			entity.resyncWalkCycle = 0;
			return;
		}
		if (entity.anim >= 0 && entity.anim <= Sequences.anims.length - 1 && entity.sequenceDelayCycle == 0) {
			if (entity.anim > Sequences.anims.length - 1) {
				int old = entity.anim;
				entity.setAnim(1);
				Utility.print("Out of bounds animation: " + old);
			}
			Sequences animation = Sequences.anims[entity.anim];
			if (entity.stationaryPathPosition > 0 && animation.runFlag == 0) {
				entity.resyncWalkCycle++;
				return;
			}
			if (entity.stationaryPathPosition <= 0 && animation.walkFlag == 0) {
				entity.resyncWalkCycle++;
				return;
			}
		}
		int i = entity.x;
		int j = entity.y;
		int k = entity.smallX[entity.smallXYIndex - 1] * 128 + entity.size * 64;
		int l = entity.smallY[entity.smallXYIndex - 1] * 128 + entity.size * 64;
		if (k - i > 256 || k - i < -256 || l - j > 256 || l - j < -256) {
			entity.x = k;
			entity.y = l;
			return;
		}
		if (i < k) {// x
			if (j < l) { // y
				entity.turnDirection = 1280;
			}
			else if (j > l) {
				entity.turnDirection = 1792;
			}
			else {
				entity.turnDirection = 1536;
			}
		}
		else if (i > k) { // y
			if (j < l) {
				entity.turnDirection = 768;
			}
			else if (j > l) {
				entity.turnDirection = 256;
			}
			else {
				entity.turnDirection = 512;
			}
		}
		else if (j < l) {
			entity.turnDirection = 1024;
		}
		else {
			entity.turnDirection = 0;
		}
		int i1 = entity.turnDirection - entity.yaw & 0x7ff;
		if (i1 > 1024) {
			i1 -= 2048;
		}
		int j1 = entity.turn180Sequence;
		if (i1 >= -256 && i1 <= 256) {
			j1 = entity.walkSequence;
		}
		else if (i1 >= 256 && i1 < 768) {
			j1 = entity.turnLeftSequence;
		}
		else if (i1 >= -768 && i1 <= -256) {
			j1 = entity.turnRightSequence;
		}
		if (Client.smoothCharacterTurn) {
			j1 = entity.walkSequence;
		}
		if (j1 == -1) {
			j1 = entity.walkSequence;
		}
		entity.moveSequence = j1;

		int k1 = 4;
		if (entity.yaw != entity.turnDirection && entity.interactingEntity == -1 && entity.rotateSpeed != 0) {
			k1 = 2;
		}
		if (entity.smallXYIndex > 2) {
			k1 = 6;
		}
		if (entity.smallXYIndex > 3) {
			k1 = 8;
		}
		if (entity.resyncWalkCycle > 0 && entity.smallXYIndex > 1) {
			k1 = 8;
			entity.resyncWalkCycle--;
		}
		if (entity.pathRunning[entity.smallXYIndex - 1]) {
			k1 <<= 1;
		}
		if (k1 >= 8 && entity.moveSequence == entity.walkSequence && entity.runSequence != -1) {
			entity.moveSequence = entity.runSequence;
		}
		if (i < k) {
			entity.x += k1;
			if (entity.x > k) {
				entity.x = k;
			}
		}
		else if (i > k) {
			entity.x -= k1;
			if (entity.x < k) {
				entity.x = k;
			}
		}
		if (j < l) {
			entity.y += k1;
			if (entity.y > l) {
				entity.y = l;
			}
		}
		else if (j > l) {
			entity.y -= k1;
			if (entity.y < l) {
				entity.y = l;
			}
		}
		if (entity.x == k && entity.y == l) {
			entity.smallXYIndex--;
			if (entity.stationaryPathPosition > 0) {
				entity.stationaryPathPosition--;
			}
		}
	}

	@SuppressWarnings("static-access")
	private static void handleEntityRotation(Client client, Entity entity) {
		if (entity.rotateSpeed == 0) {
			return;
		}
		if (entity.interactingEntity != -1 && entity.interactingEntity < 32768) {
			try {
				Npc npc = client.npcArray[entity.interactingEntity];
				if (npc != null) {
					int i1 = entity.x - npc.x;
					int k1 = entity.y - npc.y;
					if (i1 != 0 || k1 != 0) {
						entity.turnDirection = (int) (Math.atan2(i1, k1) * 325.94900000000001D) & 0x7ff;
					}
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (entity.interactingEntity >= 32768) {
			int j = entity.interactingEntity - 32768;
			if (j == client.unknownInt10) {
				j = client.myPlayerIndex;
			}
			Player player = client.playerArray[j];
			if (player != null) {
				int l1 = entity.x - player.x;
				int i2 = entity.y - player.y;
				if (l1 != 0 || i2 != 0) {
					entity.turnDirection = (int) (Math.atan2(l1, i2) * 325.94900000000001D) & 0x7ff;
				}
			}
		}
		if ((entity.faceX != 0 || entity.faceY != 0) && (entity.smallXYIndex == 0 || entity.resyncWalkCycle > 0)) {
			int k = entity.x - (entity.faceX - client.baseX - client.baseX) * 64;
			int j1 = entity.y - (entity.faceY - client.baseY - client.baseY) * 64;
			if (k != 0 || j1 != 0) {
				entity.turnDirection = (int) (Math.atan2(k, j1) * 325.94900000000001D) & 0x7ff;
			}
			entity.faceX = 0;
			entity.faceY = 0;
		}
		int l = entity.turnDirection - entity.yaw & 0x7ff;
		if (l != 0) {
			if (l < entity.rotateSpeed || l > 2048 - entity.rotateSpeed) {
				entity.yaw = entity.turnDirection;
			}
			else if (l > 1024) {
				entity.yaw -= entity.rotateSpeed;
			}
			else {
				entity.yaw += entity.rotateSpeed;
			}
			entity.yaw &= 0x7ff;
			if (entity.moveSequence == entity.standAnimation && entity.yaw != entity.turnDirection) {
				if (entity.turnSequence != -1) {
					entity.moveSequence = entity.turnSequence;
					return;
				}
				entity.moveSequence = entity.walkSequence;
			}
		}
	}

	private static int[] gfxAnimationFixList =
	{
		1211, // Armadyl godsword
		1212, //  Bandos godsword
		1209, // Saradomin godsword gfx
		1283, // Runecessoral dagger
		1210, // Zamorak godsword
	};

	/**
	 * @return True, if the entity's animation matches the given array.
	 */
	private static boolean cancelGfxAnimations(int animation) {
		for (int value = 0; value < gfxAnimationFixList.length; value++) {
			if (animation == gfxAnimationFixList[value]) {
				return true;
			}
		}
		return false;
	}

	public static void handleEntitySequences(Entity entity) {
		entity.canRotate = false;
		entity.moveSequenceCycle++;
		if (entity.moveSequence != -1) {
			if (entity.moveSequence > Sequences.anims.length) {
				entity.moveSequence = 0;
			}
			Sequences animation = Sequences.anims[entity.moveSequence];
			if (animation != null) {
				if (entity.moveSequenceFrame < animation.length && entity.moveSequenceCycle > animation.getDuration(entity.moveSequenceFrame)) {
					// Make godsword run animation faster.
					entity.moveSequenceCycle = entity.moveSequence == 7043 ? 1 : 0;
					entity.moveSequenceFrame++;
					entity.nextIdleAnimationFrame++;
				}
				entity.nextIdleAnimationFrame = entity.moveSequenceFrame + 1;
				if (entity.nextIdleAnimationFrame >= animation.length) {
					entity.nextIdleAnimationFrame = 0;
				}
				if (entity.moveSequenceFrame >= animation.length) {
					entity.moveSequenceCycle = 1;
					entity.moveSequenceFrame = 0;
				}
			}
		}
		if (entity.spotanim != -1 && Client.loopCycle >= entity.spotanimEndCycle) {
			if (entity.spotanimFrame < 0) {
				entity.spotanimFrame = 0;
			}
			Sequences animation_1 = SpotAnim.cache[entity.spotanim].animationSequence;
			if (animation_1 == null) {
				return;
			}
			for (entity.spotanimCycle++; entity.spotanimFrame < animation_1.length && entity.spotanimCycle > animation_1.getDuration(entity.spotanimFrame); entity.spotanimFrame++) {
				entity.spotanimCycle -= animation_1.getDuration(entity.spotanimFrame);
			}

			if (entity.spotanimFrame >= animation_1.length && (entity.spotanimFrame < 0 || entity.spotanimFrame >= animation_1.length)) {
				entity.spotanim = -1;
			}
			entity.nextGraphicsAnimationFrame = entity.spotanimFrame + (cancelGfxAnimations(entity.spotanim) ? 0 : 0); // It was +1 which caused Ags Special attack bug, statius warhammer bug and air guitar emote bug.
			if (entity.nextGraphicsAnimationFrame >= animation_1.length) {
				if (entity.nextGraphicsAnimationFrame < 0 || entity.nextGraphicsAnimationFrame >= animation_1.length) {
					entity.spotanim = -1;
				}
			}
		}
		if (entity.anim >= 0 && entity.anim <= Sequences.anims.length - 1 && entity.sequenceDelayCycle <= 1) {
			Sequences animation_2 = Sequences.anims[entity.anim];
			if (animation_2.runFlag == 1 && entity.stationaryPathPosition > 0 && entity.moveEndCycle <= Client.loopCycle && entity.moveStartCycle < Client.loopCycle) {
				entity.sequenceDelayCycle = 1;
				return;
			}
		}
		if (entity.anim >= 0 && entity.anim <= Sequences.anims.length - 1 && entity.sequenceDelayCycle == 0) {
			Sequences animation_3 = Sequences.anims[entity.anim];
			for (entity.sequenceCycle++; entity.sequenceFrame < animation_3.length && entity.sequenceCycle > animation_3.getDuration(entity.sequenceFrame); entity.sequenceFrame++) {
				entity.sequenceCycle -= animation_3.getDuration(entity.sequenceFrame);
			}

			if (entity.sequenceFrame >= animation_3.length) {
				entity.sequenceFrame -= animation_3.padding;
				entity.sequenceResetCycle++;
				if (entity.sequenceResetCycle >= animation_3.resetCycle) {
					entity.setAnim(-1);
				}
				if (entity.sequenceFrame < 0 || entity.sequenceFrame >= animation_3.length) {
					entity.setAnim(-1);
				}
			}
			entity.nextAnimationFrame = entity.sequenceFrame + (cancelAnimations(entity.anim) ? 0 : 1); // +1 to make animations more smoother, however, it will make the emotes excluded too smooth.
			if (entity.nextAnimationFrame >= animation_3.length) {
				if (entity.sequenceResetCycle >= animation_3.resetCycle) {
					entity.nextAnimationFrame = entity.sequenceFrame + 1;
				}
				if (entity.nextAnimationFrame < 0 || entity.nextAnimationFrame >= animation_3.length) {
					entity.nextAnimationFrame = entity.sequenceFrame;
				}
			}
			entity.canRotate = animation_3.allowsRotation;
		}
		if (entity.sequenceDelayCycle > 0) {
			entity.sequenceDelayCycle--;
		}
	}

	private static int[] cancelledAnimations =
	{
		// @formatter:off.
		1979, 1978, 4230, 420, 4177, 12567, 
		9276 ,// Jad Ranged attack.
		2756, // Pushup emote.
		// @formatter:on.
	};

	/**
	 * @return True, if the entity's animation matches the given array.
	 */
	private static boolean cancelAnimations(int animation) {
		for (int value = 0; value < cancelledAnimations.length; value++) {
			if (animation == cancelledAnimations[value]) {
				return true;
			}
		}
		return false;
	}

	public final void moveInDir(boolean flag, int i) {
		int j = smallX[0];
		int k = smallY[0];
		if (i == 0) {
			j--;
			k++;
		}
		if (i == 1)
			k++;
		if (i == 2) {
			j++;
			k++;
		}
		if (i == 3)
			j--;
		if (i == 4)
			j++;
		if (i == 5) {
			j--;
			k--;
		}
		if (i == 6)
			k--;
		if (i == 7) {
			j++;
			k--;
		}
		if (anim != -1 && Sequences.anims[anim].walkFlag == 1)
			setAnim(-1);
		if (smallXYIndex < 9)
			smallXYIndex++;
		for (int l = smallXYIndex; l > 0; l--) {
			smallX[l] = smallX[l - 1];
			smallY[l] = smallY[l - 1];
			pathRunning[l] = pathRunning[l - 1];
		}
		smallX[0] = j;
		smallY[0] = k;
		pathRunning[0] = flag;
	}

	public int entScreenX;

	public int entScreenY;

	public boolean isVisible() {
		return false;
	}

	Entity() {
		smallX = new int[10];
		smallY = new int[10];
		interactingEntity = -1;
		rotateSpeed = 32;
		runSequence = -1;
		height = 200;
		standAnimation = -1;
		turnSequence = -1;
		hitArray = new int[4];
		hitMarkTypes = new int[4];
		hitsLoopCycleEndTime = new long[4];
		hitsLoopCycleStartTime = new long[4];
		moveSequence = -1;
		spotanim = -1;
		anim = -1;
		loopCycleStatus = -1000;
		textCycle = 100;
		size = 1;
		canRotate = false;
		pathRunning = new boolean[10];
		walkSequence = -1;
		turn180Sequence = -1;
		turnRightSequence = -1;
		turnLeftSequence = -1;
	}

	public final int[] smallX;

	public final int[] smallY;

	public int interactingEntity;

	int resyncWalkCycle;

	public static int rotateSpeed;

	int runSequence;

	public String textSpoken;

	public int height;

	public int turnDirection;

	int standAnimation;

	int turnSequence;

	int spokenColor;

	final int[] hitArray;

	final int[] hitMarkTypes;

	final long[] hitsLoopCycleEndTime;

	final long[] hitsLoopCycleStartTime;

	int moveSequence;

	int moveSequenceFrame;

	int moveSequenceCycle;

	int spotanim;

	int spotanimFrame;

	int spotanimCycle;

	int spotanimEndCycle;

	int spotanimY;

	int smallXYIndex;

	public int anim;

	int sequenceFrame;

	int sequenceCycle;

	int sequenceDelayCycle;

	int sequenceResetCycle;

	int spokenEffect;

	public int loopCycleStatus;

	public int currentHealth;

	public int maxHealth;

	int textCycle;

	int updateCycle;

	int faceX;

	int faceY;

	int size;

	boolean canRotate;

	int stationaryPathPosition;

	int moveX0;

	int moveX1;

	int moveY0;

	int moveY1;

	int moveEndCycle;

	int moveStartCycle;

	int moveDirection;

	public int x;

	public int y;

	int yaw;

	final boolean[] pathRunning;

	int walkSequence;

	int turn180Sequence;

	int turnRightSequence;

	int turnLeftSequence;

	public int nextGraphicsAnimationFrame;

	public int nextIdleAnimationFrame;

	public int nextAnimationFrame;

	public void setAnim(int anim) {
		this.anim = anim;
	}
}