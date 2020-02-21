package Runecessor;

// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Decompiler options: packimports(3) 
public final class Player extends Entity {

	public Model getRotatedModel() {
		if (!visible)
			return null;
		Model model = getBuiltModel();
		if (model == null)
			return null;
		super.height = model.modelHeight;

		model.aBoolean1659 = true;
		if (ignoreSequences)
			return model;
		if (super.spotanim != -1 && super.spotanimFrame != -1) {
			SpotAnim spotAnim = SpotAnim.cache[super.spotanim];
			Model model_2 = spotAnim.getModel();
			if (spotAnim.animationSequence != null)
			{
				if (Frames.animationlist[spotAnim.animationSequence.files[0]].length == 0) {
					model_2 = null;
				}
			}
			if (model_2 != null) {
				Model model_3 = new Model(true, Frames.isNegativeZero(super.spotanimFrame), false, model_2);
				int nextFrame = spotAnim.animationSequence.primary[super.nextGraphicsAnimationFrame];
				int cycle1 = spotAnim.animationSequence.duration[super.spotanimFrame];
				int cycle2 = super.spotanimCycle;
				model_3.method475(0, -super.spotanimY, 0);
				model_3.method469();
				model_3.method470(spotAnim.animationSequence.primary[super.spotanimFrame], nextFrame, cycle1, cycle2);
				model_3.anIntArrayArray1658 = null;
				model_3.anIntArrayArray1657 = null;
				if (spotAnim.scale != 128 || spotAnim.height != 128) {
					model_3.scaleModel(
							customModelHeight > 0 ? customModelHeight : spotAnim.scale,
							customModelHeight > 0 ? customModelHeight : spotAnim.scale,
							customModelHeight > 0 ? customModelHeight : spotAnim.height);
				}
				model_3.method479(64 + spotAnim.ambient, 850 + spotAnim.contrast, -30, -50, -30, true, true);
				Model aclass30_sub2_sub4_sub6_1s[] =
				{model, model_3};
				model = new Model(aclass30_sub2_sub4_sub6_1s);
			}
		}
		if (aModel_1714 != null) {
			if (Client.loopCycle >= objectEndCycle)
				aModel_1714 = null;
			if (Client.loopCycle >= objectStartCycle && Client.loopCycle < objectEndCycle) {
				Model model_1 = aModel_1714;
				model_1.method475(objectX - super.x, objectZ - z, objectY - super.y);
				if (super.turnDirection == 512) {
					model_1.method473();
					model_1.method473();
					model_1.method473();
				}
				else if (super.turnDirection == 1024) {
					model_1.method473();
					model_1.method473();
				}
				else if (super.turnDirection == 1536)
					model_1.method473();
				Model aclass30_sub2_sub4_sub6s[] =
				{model, model_1};
				model = new Model(aclass30_sub2_sub4_sub6s);
				if (super.turnDirection == 512)
					model_1.method473();
				else if (super.turnDirection == 1024) {
					model_1.method473();
					model_1.method473();
				}
				else if (super.turnDirection == 1536) {
					model_1.method473();
					model_1.method473();
					model_1.method473();
				}
				model_1.method475(super.x - objectX, z - objectZ, super.y - objectY);
			}
		}
		model.aBoolean1659 = true;
		return model;
	}

	public int constitution, maxConstitution;

	public void updatePlayer(Stream stream) {
		UpdateEntity.appearanceUpdatesCount++;
		stream.currentOffset = 0;
		gender = stream.readUnsignedByte();
		headIcon = stream.readUnsignedByte();
		skullIcon = stream.readUnsignedByte();
		compColor1 = stream.readUnsignedWord();
		compColor2 = stream.readUnsignedWord();
		compColor3 = stream.readUnsignedWord();
		compColor4 = stream.readUnsignedWord();
		desc = null;
		team = 0;
		for (int j = 0; j < 12; j++) {
			int k = stream.readUnsignedByte();
			if (k == 0) {
				equipment[j] = 0;
				continue;
			}
			int i1 = stream.readUnsignedByte();
			equipment[j] = (k << 8) + i1;
			if (j == 0 && equipment[0] == 65535) {
				desc = EntityDefinition.forId(stream.readUnsignedWord());
				break;
			}
			/*
			if (((k << 8) + i1 - 512) == 14011)
			{
				wearingCompletionistCape = true;
			}
			*/
			boolean accepted = false;
			if (Config.PRE_EOC) {
				accepted = equipment[j] >= 512 && equipment[j] < 32768 && equipment[j] - 512 < ItemDefinition.totalItems;
			}
			else {
				accepted = equipment[j] >= 512 && equipment[j] - 512 < ItemDefinition.totalItems;
			}
			if (accepted) {
				int l1 = ItemDefinition.forId(equipment[j] - 512).team;
				if (l1 != 0) {
					team = l1;
				}
			}
		}

		for (int l = 0; l < 5; l++) {
			int j1 = stream.readUnsignedByte();
			if (j1 < 0 || j1 >= ClientConstants.CLOTHES_COLOUR[l].length)
				j1 = 0;
			colours[l] = j1;
		}

		super.standAnimation = stream.readUnsignedWord();
		if (super.standAnimation == 65535) {
			super.standAnimation = -1;
		}
		super.turnSequence = stream.readUnsignedWord();
		if (super.turnSequence == 65535) {
			super.turnSequence = -1;
		}
		super.walkSequence = stream.readUnsignedWord();
		if (super.walkSequence == 65535) {
			super.walkSequence = -1;
		}

		super.turn180Sequence = stream.readUnsignedWord();
		if (super.turn180Sequence == 65535) {
			super.turn180Sequence = -1;
		}
		super.turnRightSequence = stream.readUnsignedWord();
		if (super.turnRightSequence == 65535) {
			super.turnRightSequence = -1;
		}
		super.turnLeftSequence = stream.readUnsignedWord();
		if (super.turnLeftSequence == 65535) {
			super.turnLeftSequence = -1;
		}
		super.runSequence = stream.readUnsignedWord();
		if (super.runSequence == 65535) {
			super.runSequence = -1;
		}
		debug();
		constitution = stream.readUnsignedWord();
		maxConstitution = stream.readUnsignedWord();
		setName(stream.readString());
		playerPet = getName().contains("Mini-");
		combatLevel = stream.readUnsignedByte();
		gameModeTitle = stream.readString();
		playerTitle = stream.readString();
		titleColour = stream.readString();
		if(Config.PRE_EOC) {
			summoningLevel = stream.readUnsignedWord();
		}
		titleSwap = stream.readUnsignedByte();
		privelage = stream.readUnsignedByte();
        customModelHeight = stream.readUnsignedByte();
        playerPetIndex = stream.readSignedWord();
		visible = true;
		modelUID = 0L;
		for (int k1 = 0; k1 < 12; k1++) {
			if (Config.PRE_EOC) {
				modelUID <<= 4;
				if (equipment[k1] >= 256 && equipment[k1] < 32768)
					modelUID += equipment[k1] - 256;
				if (equipment[k1] >= 32768)
					modelUID += equipment[k1] - 32768;
			}
			else {
				modelUID <<= 4;
				if (equipment[k1] >= 256) {
					modelUID += equipment[k1] - 256;
				}
			}
		}
		if (Config.PRE_EOC) {
			if (equipment[0] >= 256 && equipment[0] < 32768)
				modelUID += equipment[0] - 256 >> 4;

			if (equipment[0] >= 32768)
				modelUID += equipment[0] - 32768 >> 4;

			if (equipment[1] >= 256 && equipment[1] < 32768)
				modelUID += equipment[1] - 256 >> 8;

			if (equipment[1] >= 32768)
				modelUID += equipment[1] - 32768 >> 8;

			for (int i2 = 0; i2 < 5; i2++) {
				modelUID <<= 3;
				modelUID += colours[i2];
			}
		}
		else {
			if (equipment[0] >= 256) {
				modelUID += equipment[0] - 256 >> 4;
			}
			if (equipment[1] >= 256) {
				modelUID += equipment[1] - 256 >> 8;
			}
			for (int i2 = 0; i2 < 5; i2++) {
				modelUID <<= 3;
				modelUID += colours[i2];
			}
		}

		modelUID <<= 1;
		modelUID += gender;
		Client.playerUpdateCompleted = true;
	}

	private void debug() {
		boolean debug = false;
		if (debug) {
			Utility.print("Stand: " + super.standAnimation);
			Utility.print("Walk: " + super.walkSequence);
			Utility.print("Run: " + super.runSequence);
			Utility.print("Turn: " + super.turnSequence);
			Utility.print("Turn right: " + super.turnRightSequence);
			Utility.print("Turn left: " + super.turnLeftSequence);
			Utility.print("180: " + super.turn180Sequence);
			Utility.print("---");
		}
	}

	public int compColor1;

	public int compColor2;

	public int compColor3;

	public int compColor4;

	public Model getBuiltModel() {
		if (desc != null) {
			int currentFrame = -1;
			int nextFrame = -1;
			int cycle1 = 0;
			int cycle2 = 0;
			if (super.anim >= 0 && super.sequenceDelayCycle == 0) {
				Sequences animation = Sequences.anims[super.anim];
				currentFrame = animation.primary[super.sequenceFrame];
				nextFrame = animation.primary[super.nextAnimationFrame];
				cycle1 = animation.duration[super.sequenceFrame];
				cycle2 = super.sequenceCycle;
			}
			else if (super.moveSequence >= 0) {
				Sequences animation = Sequences.anims[super.moveSequence];
				currentFrame = animation.primary[super.moveSequenceFrame];
				nextFrame = animation.primary[super.nextIdleAnimationFrame];
				cycle1 = animation.duration[super.moveSequenceFrame];
				cycle2 = super.moveSequenceCycle;
			}
			Model model = desc.method164(-1, currentFrame, null, nextFrame, cycle1, cycle2);

			if (customModelHeight > 0) {
				model.scaleModel(customModelHeight);
			}
			return model;
		}
		long l = modelUID;
		int currentFrame = -1;
		int nextFrame = -1;
		int cycle1 = 0;
		int cycle2 = 0;
		int i1 = -1;
		int shieldModel = -1;
		int weaponModel = -1;
		if (super.anim >= 0 && super.sequenceDelayCycle == 0) {
			Sequences animation = Sequences.anims[super.anim];
			currentFrame = animation.primary[super.sequenceFrame];
			if (super.nextAnimationFrame <= animation.primary.length - 1) {
				nextFrame = animation.primary[super.nextAnimationFrame];
			}
			cycle1 = animation.duration[super.sequenceFrame];
			cycle2 = super.sequenceCycle;
			if (super.moveSequence >= 0 && super.moveSequence != super.standAnimation)
				i1 = Sequences.anims[super.moveSequence].primary[super.moveSequenceFrame];
			if (animation.shield >= 0) {
				shieldModel = animation.shield;
				l += shieldModel - equipment[5] << 40;
			}
			if (animation.weapon >= 0) {
				weaponModel = animation.weapon;
				l += weaponModel - equipment[3] << 48;
			}
		}
		else if (super.moveSequence >= 0) {
			Sequences animation = Sequences.anims[super.moveSequence];
			currentFrame = animation.primary[super.moveSequenceFrame];
			nextFrame = animation.primary[super.nextIdleAnimationFrame];
			cycle1 = animation.duration[super.moveSequenceFrame];
			cycle2 = super.moveSequenceCycle;
		}
		Model model_1 = (Model) mruNodes.insertFromCache(l);

		if (model_1 == null) {
			boolean fetchModels = false;
			if (Config.PRE_EOC) {
				for (int bodyPart = 0; bodyPart < 12; bodyPart++) {
					int appearanceModel = equipment[bodyPart];
					if (weaponModel >= 0 && bodyPart == 3)
						appearanceModel = weaponModel;
					if (shieldModel >= 0 && bodyPart == 5)
						appearanceModel = shieldModel;
					if (appearanceModel >= 32768 && !IdentityKit.cache[appearanceModel - 32768].modelIsValid())
						fetchModels = true;
					if (appearanceModel >= 512 && appearanceModel < 32768) {
						if (ItemDefinition.forId(appearanceModel - 512) != null) {
							if (!ItemDefinition.forId(appearanceModel - 512).modelIsValid(gender)) {
								fetchModels = true;
							}
						}
					}
				}
			}
			else {
			for (int bodyPart = 0; bodyPart < 12; bodyPart++) {
				int k2 = equipment[bodyPart];
				if (weaponModel >= 0 && bodyPart == 3)
					k2 = weaponModel;
				if (shieldModel >= 0 && bodyPart == 5)
					k2 = shieldModel;
				if (k2 >= 256 && k2 < 512 && !IdentityKit.cache[k2 - 256].modelIsValid())
					fetchModels = true;
				if (k2 >= 512) {
					if (ItemDefinition.forId(k2 - 512) != null) {
						if (!ItemDefinition.forId(k2 - 512).modelIsValid(gender)) {
							fetchModels = true;
						}
					}
				}
			}
			}

			if (fetchModels) {
				if (uid != -1L)
					model_1 = (Model) mruNodes.insertFromCache(uid);

				if (model_1 == null)
					return null;
			}
		}
		if (model_1 == null || compNeedsUpdate) {
			Model aclass30_sub2_sub4_sub6s[] = new Model[15];
			int j2 = 0;
			//model_1 = new Model(j2, aclass30_sub2_sub4_sub6s);
			//aclass30_sub2_sub4_sub6s[j2++] = Model.getModel(16314);
			for (int l2 = 0; l2 < 12; l2++) {
				int i3 = equipment[l2];
				if (weaponModel >= 0 && l2 == 3)
					i3 = weaponModel;
				if (shieldModel >= 0 && l2 == 5)
					i3 = shieldModel;
				if (Config.PRE_EOC) {
					if (i3 >= 32768) {
						Model model_3 = IdentityKit.cache[i3 - 32768].getModel();
						if (model_3 != null)
							aclass30_sub2_sub4_sub6s[j2++] = model_3;
					}
				}
				else {
					if (i3 >= 256 && i3 < 512) {
						Model model_3 = IdentityKit.cache[i3 - 256].getModel();
						if (model_3 != null)
							aclass30_sub2_sub4_sub6s[j2++] = model_3;
					}
				}
				boolean accepted = false;
				if (Config.PRE_EOC) {
					accepted = i3 < 32768;
				}
				else {
					accepted = true;
				}
				if (i3 >= 512 && accepted) {
					if (ItemDefinition.forId(i3 - 512) != null) {
						Model model_4 = ItemDefinition.forId(i3 - 512).getWornModel(gender);
						if (model_4 != null || compNeedsUpdate) {
							if (i3 - 512 == 14011 && model_4 != null) {
								model_4.setColour(65214, compColor1);
								model_4.setColour(65200, compColor2);
								model_4.setColour(65186, compColor3);
								model_4.setColour(62995, compColor4);
							}
							compNeedsUpdate = false;

							aclass30_sub2_sub4_sub6s[j2++] = model_4;
						}
					}
				}
			}
			//aclass30_sub2_sub4_sub6s[j2++] = Model.method462(9996);
			model_1 = new Model(j2, aclass30_sub2_sub4_sub6s);

			for (int j3 = 0; j3 < 5; j3++)
				if (colours[j3] != 0) {
					model_1.setColour(ClientConstants.CLOTHES_COLOUR[j3][0], ClientConstants.CLOTHES_COLOUR[j3][colours[j3]]);
					if (j3 == 1) {
						model_1.setColour(ClientConstants.anIntArray1204[0], ClientConstants.anIntArray1204[colours[j3]]);
					}
				}

			model_1.method469();
			model_1.scaleModel(132);
			model_1.method479(64, 850, -30, -50, -30, true, true);
			mruNodes.removeFromCache(model_1, l);
			uid = l;
		}
		if (ignoreSequences)
			return model_1;
		Model model_2 = Model.aModel_1621;
		model_2.method464(model_1, Frames.isNegativeZero(currentFrame) & Frames.isNegativeZero(i1));
		if (currentFrame != -1 && i1 != -1)
			model_2.method471(Sequences.anims[super.anim].vertices, i1, currentFrame);
		else if (currentFrame != -1 && nextFrame != -1)
			model_2.method470(currentFrame, nextFrame, cycle1, cycle2);
		else
			model_2.method470(currentFrame);
		model_2.method466();
		model_2.anIntArrayArray1658 = null;
		model_2.anIntArrayArray1657 = null;
		if (customModelHeight > 0) {
			model_2.scaleModel(customModelHeight);
		}
		return model_2;
	}


	public boolean isVisible() {
		return visible;
	}

	public int privelage;

	public Model method453() {
		if (!visible)
			return null;
		if (desc != null)
			return desc.getHead();
		boolean flag = false;
		for (int i = 0; i < 12; i++) {
			int j = equipment[i];
			if (Config.PRE_EOC) {
				if (j >= 32768 && !IdentityKit.cache[j - 32768].faceIsValid()) {
					flag = true;
				}
				if (j >= 512 && j < 32768 && !ItemDefinition.forId(j - 512).faceIsValid(gender)) {
					flag = true;
				}
			}
			else {
				if (j >= 256 && j < 512 && !IdentityKit.cache[j - 256].faceIsValid()) {
					flag = true;
				}
				if (j >= 512 && !ItemDefinition.forId(j - 512).faceIsValid(gender)) {
					flag = true;
				}
			}
		}

		if (flag)
			return null;
		Model aclass30_sub2_sub4_sub6s[] = new Model[12];
		int k = 0;
		for (int l = 0; l < 12; l++) {
			int i1 = equipment[l];
			if (Config.PRE_EOC) {
				if (i1 >= 32768) {
					Model model_1 = IdentityKit.cache[i1 - 32768].getHead();
					if (model_1 != null)
						aclass30_sub2_sub4_sub6s[k++] = model_1;
				}
				if (i1 >= 512 && i1 < 32768) {
					Model model_2 = ItemDefinition.forId(i1 - 512).getHead(gender);
					if (model_2 != null)
						aclass30_sub2_sub4_sub6s[k++] = model_2;
				}
			}
			else {
				if (i1 >= 256 && i1 < 512) {
					Model model_1 = IdentityKit.cache[i1 - 256].getHead();
					if (model_1 != null)
						aclass30_sub2_sub4_sub6s[k++] = model_1;
				}
				if (i1 >= 512) {
					Model model_2 = ItemDefinition.forId(i1 - 512).getHead(gender);
					if (model_2 != null)
						aclass30_sub2_sub4_sub6s[k++] = model_2;
				}
			}
		}

		Model model = new Model(k, aclass30_sub2_sub4_sub6s);
		for (int j1 = 0; j1 < 5; j1++)
			if (colours[j1] != 0) {
				model.setColour(ClientConstants.CLOTHES_COLOUR[j1][0], ClientConstants.CLOTHES_COLOUR[j1][colours[j1]]);
				if (j1 == 1) {
					model.setColour(ClientConstants.anIntArray1204[0], ClientConstants.anIntArray1204[colours[j1]]);
				}
			}

		return model;
	}

	Player() {
		uid = -1L;
		ignoreSequences = false;
		colours = new int[5];
		visible = false;
		equipment = new int[12];
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private long uid;

	public EntityDefinition desc;

	boolean ignoreSequences;

	final int[] colours;

	public int team;

	private int gender;

	private String name;

	static ReferenceCache mruNodes = new ReferenceCache(260);

	public int combatLevel;

	public int headIcon;

	public int skullIcon;

	public int hintIcon;

	public int objectStartCycle;

	int objectEndCycle;

	int z;

	boolean visible;

	int objectX;

	int objectZ;

	int objectY;

	Model aModel_1714;

	public final int[] equipment;

	private long modelUID;

	int objectX0;

	int objectX1;

	int objectY0;

	int objectY1;

	public String gameModeTitle = "";

	public String playerTitle = "";

	/**
	 * 1 if the title is after the name.
	 */
	public int titleSwap;

	public String titleColour = "";
	
	public int summoningLevel;

	public boolean compNeedsUpdate;

	public long lastCombatTime;

	public int customModelHeight;

	public int playerPetIndex;

	private boolean playerPet;

	public boolean isPlayerPet() {
		return playerPet;//TODO send byte inidcating pet or not instead of this cheaphax
	}

}