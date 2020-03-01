package Runecessor;

public final class ItemDefinition {
	public int rdc = 0;
	public int rdc2 = 0;
	public int rdc3 = 0;
	public static void nullLoader() {
		mruNodes2 = null;
		mruNodes1 = null;
		cache = null;
	}

	public boolean faceIsValid(int j) {
		int k = manHead0;
		int l = manHead1;
		if (j == 1) {
			k = womanHead0;
			l = womanHead1;
		}
		if (k == -1)
			return true;
		boolean flag = true;
		if (!Model.isCached(k))
			flag = false;
		if (l != -1 && !Model.isCached(l))
			flag = false;
		return flag;
	}

	public Model getHead(int j) {
		int k = manHead0;
		int l = manHead1;
		if (j == 1) {
			k = womanHead0;
			l = womanHead1;
		}
		if (k == -1)
			return null;
		Model model = Model.getModel(k);
		if (rdc > 0)
    		model.method1337(rdc);
    		if (rdc2 != 0)
    		model.method1338(rdc2);
    		if (rdc3 != 0)
    		model.method1339(rdc3);
		if (l != -1) {
			Model model_1 = Model.getModel(l);
			Model models[] = {model, model_1};
			model = new Model(2, models);
		}
		if (modelColourToEdit != null) {
			for (int i1 = 0; i1 < modelColourToEdit.length; i1++)
				model.setColour(modelColourToEdit[i1], newModelColourProduced[i1]);
		}
		return model;
	}

	public boolean modelIsValid(int j) {
		int k = maleModel;
		int l = maleEquip2;
		int i1 = manModel2;
		if (j == 1) {
			k = femaleModel;
			l = femaleEquip2;
			i1 = womanModel2;
		}
		if (k == -1)
			return true;
		boolean flag = true;
		if (!Model.isCached(k))
			flag = false;
		if (l != -1 && !Model.isCached(l))
			flag = false;
		if (i1 != -1 && !Model.isCached(i1))
			flag = false;
		return flag;
	}

	private final String[] femaleWeaponsFor474 = {"maul", "ket-om", "anchor", "halberd", "scimitar",
			"sword", "xil-ek", "spear", "knife", "hatchet", "pickaxe", "crossbow", "cross bow"};

	public Model getWornModel(int genderType) {
		int j = maleModel;
		int k = maleEquip2;
		int l = manModel2;
		int FEMALE = 1;
		if (genderType == FEMALE) {
			j = femaleModel;
			k = femaleEquip2;
			l = womanModel2;
		}
		if (j == -1)
			return null;
		Model model = Model.getModel(j);
		
		if (k != -1) {
			if (l != -1) {
				Model model_1 = Model.getModel(k);
				Model model_3 = Model.getModel(l);
				Model model_1s[] = {model, model_1, model_3};
				model = new Model(3, model_1s);
			} else {
				Model model_2 = Model.getModel(k);
				Model models[] = {model, model_2};
				model = new Model(2, models);
			}
		}
			if (femaleEquipOffset != 0 && genderType == 1) {
				model.method475(0, femaleEquipOffset, femaleEquipOffsetOther);
			}
			if (maleEquipOffset != 0 && genderType == 0) {
				model.method475(0, maleEquipOffset, 0);
			}
		applyTexturing(model, itemId);

		if (modelColourToEdit != null) {
			for (int i1 = 0; i1 < modelColourToEdit.length; i1++) {
				model.setColour(modelColourToEdit[i1], newModelColourProduced[i1]);
			}
		}
		return model;
	}

	public void setDefaults() {
		operateOptions = new String[6];
		inventoryModel = 0;
		name = null;
		description = null;
		modelColourToEdit = null;
		newModelColourProduced = null;
		zoom = 2000;
		rotationY = 0;
		rotationX = 0;
		rotationZ = 0;
		inventoryX = 0;
		inventoryY = 0;
		stackable = false;
		value = 1;
		membersObject = false;
		groundOptions = null;
		inventoryOptions = null;
		maleModel = -1;
		maleEquip2 = -1;
		maleEquipOffset = 0;
		femaleModel = -1;
		femaleEquip2 = -1;
		femaleEquipOffset = 0;
		femaleEquipOffsetOther = 0;
		manModel2 = -1;
		womanModel2 = -1;
		manHead0 = -1;
		manHead1 = -1;
		womanHead0 = -1;
		womanHead1 = -1;
		stackIds = null;
		stackAmounts = null;
		unNotedId = -1;
		notedItemTemplate = -1;
		scaleX = 128;
		scaleY = 128;
		scaleZ = 128;
		brightness = 0;
		contrast = 0;
		team = 0;
		 rdc = 0;
	        rdc2 = 0;
	        rdc3 = 0;
		lendId = -1;
		lentItemId = -1;
	}

	public static void unpackConfig(StreamLoader streamLoader) {
		stream = new Stream(
				FileOperations.ReadFile(ClientConstants.getCacheRevisionLocation() + "/obj.dat"));
		Stream stream = new Stream(
				FileOperations.ReadFile(ClientConstants.getCacheRevisionLocation() + "/obj.idx"));
		totalItems = stream.readUnsignedWord();
		streamIndices = new int[totalItems];
		if (ClientDebugConfiguration.DEBUG_MODE) {
		Utility.print(String.format("Loaded %d items", totalItems));
		}
		int i = 2;
		for (int j = 0; j < totalItems; j++) {
			streamIndices[j] = i;
			i += stream.readUnsignedWord();
		}
		cache = new ItemDefinition[10];
		for (int k = 0; k < 10; k++) {
			cache[k] = new ItemDefinition();
		}
		Model.initiate622ModelsList();
	}

	public static ItemDefinition forId(int itemId) {
		if (itemId > streamIndices.length - 1) {
			if (Config.PRE_EOC) {
				itemId = 0;
			} else {
				return null;
			}
		}
		if (!Client.itemUpdate && !Config.PRE_EOC) {
			for (int j = 0; j < 10; j++) {
				if (cache[j].itemId == itemId) {
					ItemDefinition cached = cache[j];

					return cached;
				}
			}
		}
		cacheIndex = (cacheIndex + 1) % 10;
		ItemDefinition itemDef = cache[cacheIndex];
		itemDef.itemId = itemId;

		stream.currentOffset = streamIndices[itemId];
		itemDef.setDefaults();
		if (Config.PRE_EOC) {
			itemDef.readValuesPreEoc(stream, itemId);
		} else {
			itemDef.readValuesOsrs(stream);
		}

		boolean stop = false;
		if (!stop) {
			CustomItem.applyCustomItems(itemDef, itemId);
		}
		if(Client.playerRights >= 0) {
            itemDef.name = itemDef.name + " [" + itemId + "]";
        }
		if (Config.PRE_EOC) {
			if (itemDef.itemId == 995) {
				itemDef.name = "Coins";
				itemDef.inventoryOptions = new String[5];
				itemDef.inventoryOptions[4] = "Drop";
				itemDef.inventoryOptions[3] = "Add-to-pouch";
			}
		}

		if (itemDef.notedItemTemplate != -1) {
			itemDef.toNote();
		}
		if (itemDef.lentItemId != -1) {
			itemDef.toLend();
		}
		if (itemDef.modelColourToEdit != null) {
			for (int i2 = 0; i2 < itemDef.modelColourToEdit.length; i2++) {
				if (itemDef.newModelColourProduced[i2] == 0) {
					itemDef.newModelColourProduced[i2] = 1;
				}
			}
		}
		return itemDef;
	}

	public void readValuesPreEoc(Stream stream, int itemId) {
		do {
			int i = stream.readUnsignedByte();
			if (i == 0)
				return;
			if (i == 1) {
				inventoryModel = stream.readDWord();
			} else if (i == 2) {
				name = stream.readString();
			} else if (i == 3) {
				description = stream.readBytes();
			} else if (i == 4) {
				zoom = stream.readUnsignedWord();
			} else if (i == 5) {
				rotationY = stream.readUnsignedWord();
			} else if (i == 6) {
				rotationX = stream.readUnsignedWord();
			} else if (i == 7) {
				inventoryX = stream.readUnsignedWord();
				if (inventoryX > 32767) {
					inventoryX -= 0x10000;
				}
			} else if (i == 8) {
				inventoryY = stream.readUnsignedWord();
				if (inventoryY > 32767) {
					inventoryY -= 0x10000;
				}
			} else if (i == 10) {
				stream.readUnsignedWord();
			} else if (i == 11) {
				stackable = true;
			} else if (i == 12) {
				value = stream.readDWord();
			} else if (i == 16) {
				membersObject = true;
			} else if (i == 23) {
				maleModel = stream.readDWord();
				maleEquipOffset = stream.readSignedByte();
			} else if (i == 24) {
				maleEquip2 = stream.readDWord();
			} else if (i == 25) {
				femaleModel = stream.readDWord();
				femaleEquipOffset = stream.readSignedByte();
			} else if (i == 26) {
				femaleEquip2 = stream.readDWord();
			} else if (i >= 30 && i < 35) {
				if (groundOptions == null) {
					groundOptions = new String[5];
				}
				groundOptions[i - 30] = stream.readString();
				if (groundOptions[i - 30].equalsIgnoreCase("hidden")) {
					groundOptions[i - 30] = null;
				}
			} else if (i >= 35 && i < 40) {
				if (inventoryOptions == null) {
					inventoryOptions = new String[5];
				}
				inventoryOptions[i - 35] = stream.readString();
			} else if (i == 40) {
				int j = stream.readUnsignedByte();
				modelColourToEdit = new int[j];
				newModelColourProduced = new int[j];
				for (int k = 0; k < j; k++) {
					modelColourToEdit[k] = stream.readUnsignedWord();
					newModelColourProduced[k] = stream.readUnsignedWord();
				}
			} else if (i == 78) {
				manModel2 = stream.readDWord();
			} else if (i == 79) {
				womanModel2 = stream.readDWord();
			} else if (i == 90) {
				manHead0 = stream.readDWord();
			} else if (i == 91) {
				womanHead0 = stream.readDWord();
			} else if (i == 92) {
				manHead1 = stream.readDWord();
			} else if (i == 93) {
				womanHead1 = stream.readDWord();
			} else if (i == 95) {
				rotationZ = stream.readUnsignedWord();
			} else if (i == 97) {
				unNotedId = stream.readUnsignedWord();
			} else if (i == 98) {
				notedItemTemplate = stream.readUnsignedWord();
			} else if (i >= 100 && i < 110) {
				if (stackIds == null) {
					stackIds = new int[10];
					stackAmounts = new int[10];
				}
				stackIds[i - 100] = stream.readUnsignedWord();
				stackAmounts[i - 100] = stream.readUnsignedWord();
			} else if (i == 110) {
				scaleX = stream.readUnsignedWord();
			} else if (i == 111) {
				scaleY = stream.readUnsignedWord();
			} else if (i == 112) {
				scaleZ = stream.readUnsignedWord();
			} else if (i == 113) {
				brightness = stream.readSignedByte();
			} else if (i == 114) {
				contrast = stream.readSignedByte() * 5;
			} else if (i == 115) {
				team = stream.readUnsignedByte();
			} else {
				Utility.print("Nulled item? " + itemId);
			}
		} while (true);
	}

	public void readValuesOsrs(Stream stream) {
		do {
			int i = stream.readUnsignedByte();
			if (i == 0)
				return;
			if (i == 1) {
				inventoryModel = stream.readUnsignedWord();
			} else if (i == 2) {
				name = stream.readString();
			} else if (i == 3) {
				description = stream.readBytes();
			} else if (i == 4) {
				zoom = stream.readUnsignedWord();
			} else if (i == 5) {
				rotationY = stream.readUnsignedWord();
			} else if (i == 6) {
				rotationX = stream.readUnsignedWord();
			} else if (i == 7) {
				inventoryX = stream.readUnsignedWord();
				if (inventoryX > 32767) {
					inventoryX -= 0x10000;
				}
			} else if (i == 8) {
				inventoryY = stream.readUnsignedWord();
				if (inventoryY > 32767) {
					inventoryY -= 0x10000;
				}
			} else if (i == 10) {
				stream.readUnsignedWord();
			} else if (i == 11) {
				stackable = true;
			} else if (i == 12) {
				value = stream.readDWord();
			} else if (i == 16) {
				membersObject = true;
			} else if (i == 23) {
				maleModel = stream.readUnsignedWord();
				maleEquipOffset = stream.readSignedByte();
			} else if (i == 24) {
				maleEquip2 = stream.readUnsignedWord();
			} else if (i == 25) {
				femaleModel = stream.readUnsignedWord();
				femaleEquipOffset = stream.readSignedByte();
				if (femaleModel == 65535) {
					femaleModel = -1;
				}
			} else if (i == 26) {
				femaleEquip2 = stream.readUnsignedWord();
			} else if (i >= 30 && i < 35) {
				if (groundOptions == null) {
					groundOptions = new String[5];
				}
				groundOptions[i - 30] = stream.readString();
				if (groundOptions[i - 30].equalsIgnoreCase("hidden")) {
					groundOptions[i - 30] = null;
				}
			} else if (i >= 35 && i < 40) {
				if (inventoryOptions == null) {
					inventoryOptions = new String[5];
				}
				inventoryOptions[i - 35] = stream.readString();
			} else if (i == 40) {
				int j = stream.readUnsignedByte();
				modelColourToEdit = new int[j];
				newModelColourProduced = new int[j];
				for (int k = 0; k < j; k++) {
					newModelColourProduced[k] = stream.readUnsignedWord();
					modelColourToEdit[k] = stream.readUnsignedWord();
				}
			}
			else if (i == 41) {
				int len = stream.readUnsignedByte();
				originalTexture = new short[len];
				modifiedTexture = new short[len];
				for (int l = 0; l < len; l++) {
					originalTexture[l] = (short) stream.readUnsignedWord();
					modifiedTexture[l] = (short) stream.readUnsignedWord();
				}
			}
			else if (i == 42) {
				shiftClickIndex = stream.readUnsignedByte();
			}
			else if (i == 78) {
				manModel2 = stream.readUnsignedWord();
			} else if (i == 79) {
				womanModel2 = stream.readUnsignedWord();
			} else if (i == 90) {
				manHead0 = stream.readUnsignedWord();
			} else if (i == 91) {
				womanHead0 = stream.readUnsignedWord();
			} else if (i == 92) {
				manHead1 = stream.readUnsignedWord();
			} else if (i == 93) {
				womanHead1 = stream.readUnsignedWord();
			} else if (i == 95) {
				rotationZ = stream.readUnsignedWord();
			} else if (i == 97) {
				unNotedId = stream.readUnsignedWord();
			} else if (i == 98) {
				notedItemTemplate = stream.readUnsignedWord();
			} else if (i >= 100 && i < 110) {
				if (stackIds == null) {
					stackIds = new int[10];
					stackAmounts = new int[10];
				}
				stackIds[i - 100] = stream.readUnsignedWord();
				stackAmounts[i - 100] = stream.readUnsignedWord();
			} else if (i == 110) {
				scaleX = stream.readUnsignedWord();
			} else if (i == 111) {
				scaleY = stream.readUnsignedWord();
			} else if (i == 112) {
				scaleZ = stream.readUnsignedWord();
			} else if (i == 113) {
				brightness = stream.readSignedByte();
			} else if (i == 114) {
				contrast = stream.readSignedByte();
			} else if (i == 115) {
				team = stream.readUnsignedByte();
			}
			else if (i == 139) {
				unNotedId = stream.readUnsignedWord(); // un-noted id
			}
			else if (i == 140) {
				notedItemTemplate = stream.readUnsignedWord(); // noted id
			}
			else if (i == 148) {
				stream.readUnsignedWord(); // placeholder id
			}
			else if (i == 149) {
				stream.readUnsignedWord(); // placeholder template
			}
		} while (true);
	}


	public void toNote() {
		ItemDefinition itemDef = forId(notedItemTemplate);
		inventoryModel = itemDef.inventoryModel;
		zoom = itemDef.zoom;
		rotationY = itemDef.rotationY;
		rotationX = itemDef.rotationX;
		rotationZ = itemDef.rotationZ;
		inventoryX = itemDef.inventoryX;
		inventoryY = itemDef.inventoryY;
		modelColourToEdit = itemDef.modelColourToEdit;
		newModelColourProduced = itemDef.newModelColourProduced;
		ItemDefinition itemDef_1 = forId(unNotedId);
		name = itemDef_1.name;
		membersObject = itemDef_1.membersObject;
		value = itemDef_1.value;
		String s = "a";
		if (itemDef_1.name != null) {
			char c = itemDef_1.name.charAt(0);
			if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
				s = "an";
			}
		}
		description = ("Swap this note at any bank for " + s + " " + itemDef_1.name + ".").getBytes();
		stackable = true;
	}

	private void toLend() {
		ItemDefinition itemDef = forId(lentItemId);
		inventoryOptions = new String[5];
		inventoryModel = itemDef.inventoryModel;
		inventoryX = itemDef.inventoryX;
		rotationX = itemDef.rotationX;
		inventoryY = itemDef.inventoryY;
		zoom = itemDef.zoom;
		rotationY = itemDef.rotationY;
		rotationZ = itemDef.rotationZ;
		value = 0;
		ItemDefinition itemDef_1 = forId(lendId);
		manHead1 = itemDef_1.manHead1;
		modelColourToEdit = itemDef_1.modelColourToEdit;
		manModel2 = itemDef_1.manModel2;
		maleEquip2 = itemDef_1.maleEquip2;
		womanHead1 = itemDef_1.womanHead1;
		manHead0 = itemDef_1.manHead0;
		groundOptions = itemDef_1.groundOptions;
		maleModel = itemDef_1.maleModel;
		name = itemDef_1.name;
		femaleModel = itemDef_1.femaleModel;
		membersObject = itemDef_1.membersObject;
		womanHead0 = itemDef_1.womanHead0;
		femaleEquip2 = itemDef_1.femaleEquip2;
		womanModel2 = itemDef_1.womanModel2;
		newModelColourProduced = itemDef_1.newModelColourProduced;
		team = itemDef_1.team;
		if (itemDef_1.inventoryOptions != null) {
			for (int i_33_ = 0; i_33_ < 4; i_33_++)
				inventoryOptions[i_33_] = itemDef_1.inventoryOptions[i_33_];
		}
		inventoryOptions[4] = "Discard";
	}

	public static Sprite getSprite(int itemId, int itemAmount, int colourHighlight) {
		if (colourHighlight == 0) {
			Sprite sprite = (Sprite) mruNodes1.insertFromCache(itemId);
			if (sprite != null && sprite.maxHeight != itemAmount && sprite.maxHeight != -1) {
				sprite.unlink();
				sprite = null;
			}
			if (sprite != null)
				return sprite;
		}
		ItemDefinition itemDef = forId(itemId);
		if (itemDef == null) {
			return null;
		}
		if (itemDef.stackIds == null)
			itemAmount = -1;
		if (itemAmount > 1) {
			int i1 = -1;

			// Turning a coin into a larger pile of coins.
			for (int j1 = 0; j1 < 10; j1++) {
				if (itemAmount >= itemDef.stackAmounts[j1] && itemDef.stackAmounts[j1] != 0) {
					i1 = itemDef.stackIds[j1];
				}
			}

			if (i1 != -1) {
				itemDef = forId(i1);
			}
		}
		Model model = itemDef.getModel(1);
		if (model == null)
			return null;
		Sprite sprite = null;
		if (itemDef.notedItemTemplate != -1) {
			sprite = getSprite(itemDef.unNotedId, 10, -1);
			if (sprite == null)
				return null;
		}
		if (itemDef.lentItemId != -1) {
			sprite = getSprite(itemDef.lendId, 50, 0);
			if (sprite == null)
				return null;
		}
		Sprite sprite2 = new Sprite(32, 32);
		int k1 = Rasterizer.centerX;
		int l1 = Rasterizer.centerY;
		int ai[] = Rasterizer.offsets;
		int ai1[] = DrawingArea.pixels;
		float depthBuffer[] = DrawingArea.depthBuffer;
		int i2 = DrawingArea.width;
		int j2 = DrawingArea.height;
		int k2 = DrawingArea.topX;
		int l2 = DrawingArea.getBottomX();
		int i3 = DrawingArea.topY;
		int j3 = DrawingArea.getBottomY();
		Rasterizer.drawTexturized = false;
		DrawingArea.initDrawingArea(32, 32, sprite2.myPixels, new float[32 * 32]);
		DrawingArea.drawPixels(32, 0, 0, 0, 32);
		Rasterizer.prepare3d1();
		int k3 = itemDef.zoom;
		if (colourHighlight == -1)
			k3 = (int) ((double) k3 * 1.5D);
		if (colourHighlight > 0)
			k3 = (int) ((double) k3 * 1.04D);
		int l3 = Rasterizer.sin[itemDef.rotationY] * k3 >> 16;
		int i4 = Rasterizer.cos[itemDef.rotationY] * k3 >> 16;
		model.method482(itemDef.rotationX, itemDef.rotationZ, itemDef.rotationY, itemDef.inventoryX,
				l3 + model.modelHeight / 2 + itemDef.inventoryY, i4 + itemDef.inventoryY, true);
		for (int i5 = 31; i5 >= 0; i5--) {
			for (int j4 = 31; j4 >= 0; j4--)
				if (sprite2.myPixels[i5 + j4 * 32] == 0)
					if (i5 > 0 && sprite2.myPixels[(i5 - 1) + j4 * 32] > 1)
						sprite2.myPixels[i5 + j4 * 32] = 1;
					else if (j4 > 0 && sprite2.myPixels[i5 + (j4 - 1) * 32] > 1)
						sprite2.myPixels[i5 + j4 * 32] = 1;
					else if (i5 < 31 && sprite2.myPixels[i5 + 1 + j4 * 32] > 1)
						sprite2.myPixels[i5 + j4 * 32] = 1;
					else if (j4 < 31 && sprite2.myPixels[i5 + (j4 + 1) * 32] > 1)
						sprite2.myPixels[i5 + j4 * 32] = 1;
		}
		if (colourHighlight > 0) {
			for (int j5 = 31; j5 >= 0; j5--) {
				for (int k4 = 31; k4 >= 0; k4--)
					if (sprite2.myPixels[j5 + k4 * 32] == 0)
						if (j5 > 0 && sprite2.myPixels[(j5 - 1) + k4 * 32] == 1)
							sprite2.myPixels[j5 + k4 * 32] = colourHighlight;
						else if (k4 > 0 && sprite2.myPixels[j5 + (k4 - 1) * 32] == 1)
							sprite2.myPixels[j5 + k4 * 32] = colourHighlight;
						else if (j5 < 31 && sprite2.myPixels[j5 + 1 + k4 * 32] == 1)
							sprite2.myPixels[j5 + k4 * 32] = colourHighlight;
						else if (k4 < 31 && sprite2.myPixels[j5 + (k4 + 1) * 32] == 1)
							sprite2.myPixels[j5 + k4 * 32] = colourHighlight;
			}
		} else if (colourHighlight == 0) {
			for (int k5 = 31; k5 >= 0; k5--) {
				for (int l4 = 31; l4 >= 0; l4--)
					if (sprite2.myPixels[k5 + l4 * 32] == 0 && k5 > 0 && l4 > 0
							&& sprite2.myPixels[(k5 - 1) + (l4 - 1) * 32] > 0)
						sprite2.myPixels[k5 + l4 * 32] = 0x302020;
			}
		}
		if (itemDef.notedItemTemplate != -1) {
			int l5 = sprite.maxWidth;
			int j6 = sprite.maxHeight;
			sprite.maxWidth = 32;
			sprite.maxHeight = 32;
			sprite.drawSprite(0, 0);
			sprite.maxWidth = l5;
			sprite.maxHeight = j6;
		}
		if (itemDef.lentItemId != -1) {
			int l5 = sprite.maxWidth;
			int j6 = sprite.maxHeight;
			sprite.maxWidth = 32;
			sprite.maxHeight = 32;
			sprite.drawSprite(0, 0);
			sprite.maxWidth = l5;
			sprite.maxHeight = j6;
		}
		if (colourHighlight == 0)
			mruNodes1.removeFromCache(sprite2, itemId);
		DrawingArea.initDrawingArea(j2, i2, ai1, depthBuffer);
		DrawingArea.setDrawingArea(j3, k2, l2, i3);
		Rasterizer.centerX = k1;
		Rasterizer.centerY = l1;
		Rasterizer.offsets = ai;
		Rasterizer.drawTexturized = true;
		if (itemDef.stackable)
			sprite2.maxWidth = 33;
		else
			sprite2.maxWidth = 32;
		sprite2.maxHeight = itemAmount;
		return sprite2;
	}

	public Model getModel(long i) {
		if (stackIds != null && i > 1) {
			int j = -1;
			for (int k = 0; k < 10; k++) {
				if (i >= stackAmounts[k] && stackAmounts[k] != 0) {
					j = stackIds[k];
				}
			}
			if (j != -1) {
				return forId(j).getModel(1);
			}
		}
		Model model = (Model) mruNodes2.insertFromCache(itemId);
		if (model != null) {
			return model;
		}
		model = Model.getModel(inventoryModel);
		if (model == null) {
			return null;
		}
		applyTexturing(model, itemId);
		if (scaleX != 128 || scaleY != 128 || scaleZ != 128) {
			model.scaleModel(scaleX, scaleZ, scaleY);
		}
		if (modelColourToEdit != null) {
			for (int l = 0; l < modelColourToEdit.length; l++) {
				model.setColour(modelColourToEdit[l], newModelColourProduced[l]);
			}
		}
		model.method479(64 + brightness, 768 + contrast, -50, -10, -50, true);
		model.aBoolean1659 = true;
		mruNodes2.removeFromCache(model, itemId);
		return model;
	}

	public static void applyTexturing(Model model, int itemId) {
		int colour = 0;
		if (Config.PRE_EOC) {
			return;
		}
		switch (itemId) {
			// Elder maul white & purple
			case 16325:

				// It was black
				colour = 51136;
				model.setColour(0, colour);

				// Dark grey
				colour = 51140;
				model.setColour(16, colour);

				// Dark grey
				colour = 51150;
				model.setColour(20, colour);

				// Grey
				colour = 51120;
				model.setColour(33, colour);

				// Orange dark
				colour = 127;
				model.setColour(5056, colour);

				// Orange lighter
				colour = 100;
				model.setColour(8125, colour);
				break;
			case 16304:
				// It was black
				colour = 8128;
				model.setColour(0, colour);

				// Dark grey
				model.setColour(16, 8135);

				// Dark grey
				model.setColour(20, 8135);

				// Grey
				model.setColour(33, 8145);

				// Orange dark
				model.setColour(5056, 51130);

				// Orange lighter
				model.setColour(8125, 51140);
				break;

			case 16297:
				// It was black
				colour = 419770;
				// model.setColour(0, colour);

				// Dark grey
				// model.setColour(16, colour);

				// Dark grey
				// model.setColour(20, colour);

				// Grey
				// model.setColour(33, colour);

				// Orange dark
				model.setColour(5056, 419765);

				// Orange lighter
				model.setColour(8125, colour);
				break;
			// Elder maul lime green
			case 16255:

				// It was black
				colour = 332770;
				model.setColour(0, colour);

				// Dark grey
				model.setColour(16, colour);

				// Dark grey
				model.setColour(20, colour);

				// Grey
				model.setColour(33, colour);

				// Orange dark
				model.setColour(5056, colour);

				// Orange lighter
				model.setColour(8125, colour);
				break;
			// Elder maul lime green
			case 16225:

				// It was black
				colour = 17350;
				model.setColour(0, colour);

				// Dark grey
				colour = 17350;
				model.setColour(16, colour);

				// Dark grey
				colour = 17350;
				model.setColour(20, colour);

				// Grey
				colour = 17350;
				model.setColour(33, colour);

				// Orange dark
				colour = 17350;
				model.setColour(5056, colour);

				// Orange lighter
				colour = 17350;
				model.setColour(8125, colour);
				break;
			// Elder maul gold & silver
			case 16224:

				// It was black
				colour = 7114;
				model.setColour(0, colour);

				// Dark grey
				colour = 7114;
				model.setColour(16, colour);

				// Dark grey
				colour = 7114;
				model.setColour(20, colour);

				// Grey
				colour = 7114;
				model.setColour(33, colour);

				// Orange dark
				colour = 90;
				model.setColour(5056, colour);

				// Orange lighter
				colour = 90;
				model.setColour(8125, colour);
				break;
			// Rainbow Armadyl godsword for I Solo
			case 16183:
				// Hilt colour
				model.setColour(-22477, 338770);
				model.setColour(-22208, 332770);
				model.setColour(-22464, 419770);
				model.setColour(-24279, 380770);
				model.setColour(-24271, 476770);

				// Blade colour
				model.setColour(-22423, 51136);
				model.setColour(-22444, 127);
				model.setColour(-22415, 296880);
				model.setColour(-22419, 374770);
				model.setColour(-22440, 675);
				break;

			// A recoloured Armadyl godsword into a Black Armadyl godsword for Slice u ko
			case 16163:
				// Hilt colour
				colour = 0;
				model.setColour(-22477, colour);
				model.setColour(-22208, colour);
				model.setColour(-22464, colour);
				model.setColour(-24279, colour);
				model.setColour(-24271, colour);

				// Blade colour
				colour = 0;
				model.setColour(-22423, colour);
				model.setColour(-22444, colour);
				model.setColour(-22415, colour);
				model.setColour(-22419, colour);
				model.setColour(-22440, colour);
				break;

			// Runecessoral tentacle (g)
			case 16151:
				// Stripe colour
				colour = 7114;
				model.setColour(11150, colour);

				// Not used
				colour = 0;
				model.setColour(9108, colour);

				// Spikes colour
				colour = 0;
				model.setColour(10355, colour);
				break;
			// Runecessoral tentacle (Shattered)
			case 16136:
				// Stripe colour
				colour = 0;
				model.setColour(11150, colour);

				// Not used
				colour = 0;
				model.setColour(9108, colour);

				// Spikes colour
				colour = 127;
				model.setColour(10355, colour);
				break;
			case 16124:
				// Dark red
				colour = 0;
				model.setColour(280, colour);

				// Red
				colour = 0;
				model.setColour(924, colour);

				// Red
				colour = 0;
				model.setColour(920, colour);

				// Grey
				colour = 6;
				// model.setColour(-22370, colour);

				// Dark grey
				colour = 6;
				// model.setColour(-22380, colour);

				// Grey
				colour = 6;
				// model.setColour(538, colour);

				// White
				colour = 127;
				// model.setColour(520, colour);

				// Dark grey on item model only
				colour = 127;
				// model.setColour(520, colour);
				break;
			// Elder maul Cyan
			case 16122:

				// It was black
				colour = 34770;
				model.setColour(0, colour);

				// Dark grey
				colour = 296880;
				model.setColour(16, colour);

				// Dark grey
				colour = 296880;
				model.setColour(20, colour);

				// Grey
				colour = 34770;
				model.setColour(33, colour);

				// Orange dark
				colour = 296770;
				model.setColour(5056, colour);

				// Orange lighter
				colour = 296770;
				model.setColour(8125, colour);
				break;
			// Elysian spirit shield (blood)
			case 16113:
				// Sigil colour
				colour = 0;
				model.setColour(127, colour);

				// Rest of spirit shield colour
				colour = 933;
				model.setColour(-28716, colour);
				model.setColour(-29116, colour);
				model.setColour(-29019, colour);
				model.setColour(-29125, colour);
				model.setColour(-29110, colour);
				break;

			// Quest point cape (b)
			case 16104:
				colour = 0;
				model.setColour(-8256, colour);

				colour = 0;
				model.setColour(-11353, colour);

				colour = 0;
				model.setColour(-29244, colour);

				colour = 0;
				model.setColour(-29236, colour);

				break;
			
			// B & W Partyhat
			case 16103:
				colour = 127;
				model.setColour(6067, colour);

				colour = 000000;
				model.setColour(947, colour);

				colour = 127;
				model.setColour(-10340, colour);

				colour = 127;
				model.setColour(-10350, colour);

				colour = 000000;
				model.setColour(11187, colour);

				colour = 127;
				model.setColour(17331, colour);

				colour = 000000;
				model.setColour(-21581, colour);

				colour = 000000;
				model.setColour(27571, colour);

				colour = 127;
				model.setColour(-26701, colour);
				break;
			// Runecessoral tentacle (Ely)
			case 16100:
				// Stripe colour
				colour = -29116;
				model.setColour(11150, colour);

				// Inventory model strip colour
				colour = -29116;
				model.setColour(9108, colour);
				break;

			// Elder maul (b)
			case 16098:

				// It was black
				colour = 302770;
				model.setColour(0, colour);

				// Dark grey
				colour = 302890;
				model.setColour(16, colour);

				// Dark grey
				colour = 302890;
				model.setColour(20, colour);

				// Grey
				colour = 302790;
				model.setColour(33, colour);

				// Orange dark
				colour = 0;
				model.setColour(5056, colour);

				// Orange lighter
				colour = 15;
				model.setColour(8125, colour);
				break;
			// Elysian spirit shield (w)
			case 16097:
				// Sigil colour
				colour = 0;
				model.setColour(127, colour);

				// Rest of spirit shield colour
				colour = 127;
				model.setColour(-28716, colour);
				model.setColour(-29116, colour);
				model.setColour(-29019, colour);
				model.setColour(-29125, colour);
				model.setColour(-29110, colour);
				break;

			// Black Defender icon for Oatrix
			case 16093:
				colour = 0;
				model.setColour(22451, colour);
				model.setColour(-21581, colour);
				model.setColour(11200, colour);
				model.setColour(947, colour);
				break;

			// Armadyl godsword (lava coloured)
			case 16091:
				// Hilt colour
				colour = 6073;
				model.setColour(-22477, colour);
				model.setColour(-22208, colour);
				model.setColour(-22464, colour);
				model.setColour(-24279, colour);
				model.setColour(-24271, colour);

				// Blade colour
				colour = 6073;
				model.setColour(-22423, colour);
				model.setColour(-22444, colour);
				model.setColour(-22415, colour);
				model.setColour(-22419, colour);
				model.setColour(-22440, colour);
				break;

			// Black Elysian spirit shield
			case 16090:
				colour = 0;
				model.setColour(-28716, colour);
				model.setColour(-29116, colour);
				model.setColour(-29019, colour);
				model.setColour(-29125, colour);
				model.setColour(-29110, colour);
				model.setColour(-21610, colour);
				break;
			/*
			 * // 3rd age platelegs recolour case 16091: // Stripes colour = 0; model.setColour(74,
			 * colour);
			 * 
			 * // Knee pad outer design colour = 0; model.setColour(57, colour);
			 * 
			 * // Main colour colour = 0; model.setColour(86, colour);
			 * 
			 * // Stripes colour = 0; model.setColour(90, colour);
			 * 
			 * // Knee pad middle colour = 0; model.setColour(66, colour);
			 * 
			 * // Upper waist colour = 0; model.setColour(-32506, colour);
			 * 
			 * // Unknown. colour = 0; model.setColour(10262, colour); break;
			 */

			// A recoloured Elysian spirit shield into a Divine spirit shield for Austin W
			case 16041:
				colour = 350770;
				model.setColour(-28716, colour);
				model.setColour(-29116, colour);
				model.setColour(-29019, colour);
				model.setColour(-29125, colour);
				model.setColour(-29110, colour);
				model.setColour(-21610, colour);
				break;

			// A recoloured Armadyl godsword into a Gold Armadyl godsword for C0nZ0le
			case 16042:
				// Hilt colour
				colour = 7114;
				model.setColour(-22477, colour);
				model.setColour(-22208, colour);
				model.setColour(-22464, colour);
				model.setColour(-24279, colour);
				model.setColour(-24271, colour);

				// Blade colour
				colour = 7114;
				model.setColour(-22423, colour);
				model.setColour(-22444, colour);
				model.setColour(-22415, colour);
				model.setColour(-22419, colour);
				model.setColour(-22440, colour);
				break;

			// A recoloured Armadyl godsword into a Pink Armadyl godsword for Trenbolone E
			case 16047:
				// Hilt colour
				colour = 380770;
				model.setColour(-22477, colour);
				model.setColour(-22208, colour);
				model.setColour(-22464, colour);
				model.setColour(-24279, colour);
				model.setColour(-24271, colour);

				// Blade colour
				colour = 380770;
				model.setColour(-22423, colour);
				model.setColour(-22444, colour);
				model.setColour(-22415, colour);
				model.setColour(-22419, colour);
				model.setColour(-22440, colour);
				break;

			// Twisted bow (locals)
			case 16052:
				// Design colour
				colour = 302770;
				model.setColour(16, colour);

				// Design too
				colour = 302770;
				model.setColour(8, colour);

				// Stripes all aroound
				colour = 127;
				model.setColour(24, colour);

				// Lower stripes
				colour = 17350;
				model.setColour(33, colour);

				// Bow string stripes
				colour = 51136;
				model.setColour(10318, colour);

				// Tiny design at bow lower tips
				colour = 461770;
				model.setColour(41, colour);

				// Long stripe bow string
				colour = 419770;
				model.setColour(10334, colour);

				// Tiny tip of bow
				colour = 332770;
				model.setColour(14236, colour);

				// Tiny tip of bow too
				colour = 296770;
				model.setColour(13223, colour);
				break;


			// Runecessoral tentacle (Verticle)
			case 16055:
				// Stripe colour
				colour = 302770;
				model.setColour(11150, colour);

				// Not used
				colour = 302770;
				model.setColour(9108, colour);

				// Spikes colour
				colour = 4960;
				model.setColour(10355, colour);
				break;

			// Twisted bow (Thuggahh)
			case 16056:
				// Design colour
				colour = 0;
				model.setColour(16, colour);

				// Design too
				colour = 0;
				model.setColour(8, colour);

				// Stripes all aroound
				colour = 7114;
				model.setColour(24, colour);

				// Lower stripes
				colour = 7114;
				model.setColour(33, colour);

				// Bow string stripes
				colour = 0;
				model.setColour(10318, colour);

				// Tiny design at bow lower tips
				colour = 0;
				model.setColour(41, colour);

				// Long stripe bow string
				colour = 0;
				model.setColour(10334, colour);

				// Tiny tip of bow
				colour = 0;
				model.setColour(14236, colour);

				// Tiny tip of bow too
				colour = 0;
				model.setColour(13223, colour);
				break;

			// A recoloured Armadyl godsword into a Black Armadyl godsword for Bites
			case 16060:
				// Hilt colour
				colour = 0;
				model.setColour(-22477, colour);
				model.setColour(-22208, colour);
				model.setColour(-22464, colour);
				model.setColour(-24279, colour);
				model.setColour(-24271, colour);

				// Blade colour
				colour = 0;
				model.setColour(-22423, colour);
				model.setColour(-22444, colour);
				model.setColour(-22415, colour);
				model.setColour(-22419, colour);
				model.setColour(-22440, colour);
				break;

			// Armadyl godsword (Russman887) recoloured to white
			case 16063:
				// Hilt colour
				colour = 124;
				model.setColour(-22477, colour);
				model.setColour(-22208, colour);
				model.setColour(-22464, colour);
				model.setColour(-24279, colour);
				model.setColour(-24271, colour);

				// Blade colour
				colour = 124;
				model.setColour(-22423, colour);
				model.setColour(-22444, colour);
				model.setColour(-22415, colour);
				model.setColour(-22419, colour);
				model.setColour(-22440, colour);
				break;

			/*
			 * case 12371: // Lava dragon mask. model.setColour(38119, 6073); break; case 12773: //
			 * Volcanic Runecessoral whip model.setColour(0, 6073); break; case 12774: // Frozen Runecessoral
			 * whip model.setColour(0, 359770); break;
			 */
		}
	}

	public Model getInterfaceModel(int i) {
		if (stackIds != null && i > 1) {
			int j = -1;
			for (int k = 0; k < 10; k++) {
				if (i >= stackAmounts[k] && stackAmounts[k] != 0) {
					j = stackIds[k];
				}
			}

			if (j != -1) {
				return forId(j).getInterfaceModel(1);
			}
		}
		Model model = Model.getModel(inventoryModel);
		if (rdc > 0)
    		model.method1337(rdc);
    		if (rdc2 != 0)
    		model.method1338(rdc2);
    		if (rdc3 != 0)
    		model.method1339(rdc3);
		if (model == null) {
			return null;
		}
		if (modelColourToEdit != null) {
			for (int l = 0; l < modelColourToEdit.length; l++) {
				model.setColour(modelColourToEdit[l], newModelColourProduced[l]);
			}
		}
		return model;
	}

	public ItemDefinition() {
		itemId = -1;
	}

	public static int[] streamIndices;

	public static int totalItems;

	public byte femaleEquipOffset;

	public byte femaleEquipOffsetOther;

	public int value;

	public int[] modelColourToEdit;

	public int itemId;

	static ReferenceCache mruNodes1 = new ReferenceCache(100);

	public static ReferenceCache mruNodes2 = new ReferenceCache(50);

	public int[] newModelColourProduced;

	public short[] modifiedTexture;

	public short[] originalTexture;

	private int shiftClickIndex = -2;

	public boolean membersObject;

	public int womanModel2;

	public int notedItemTemplate;

	public int femaleEquip2;

	public int maleModel;

	public int manHead1;

	public int scaleX;

	public String groundOptions[];

	public int inventoryX;

	public String name;

	public static ItemDefinition[] cache;

	public int womanHead1;

	public int inventoryModel;

	public int manHead0;

	public boolean stackable;

	public byte[] description;

	public int unNotedId;

	public static int cacheIndex;

	public int zoom;


	private static Stream stream;

	public int contrast;

	public int manModel2;

	public int maleEquip2;

	public String inventoryOptions[];

	public int rotationY;

	public int scaleZ;

	public int scaleY;

	public int[] stackIds;

	public int inventoryY;

	public int brightness;

	public int womanHead0;

	public int rotationX;

	public int femaleModel;

	public int[] stackAmounts;

	public int team;

	public int rotationZ;

	public byte maleEquipOffset;

	public int lendId;

	public int lentItemId;

	public int lendTemplateId;

	public String operateOptions[];

	public static void reloadItems() {
		if (!Client.itemUpdate) {
			return;
		}
		if (System.currentTimeMillis() - Client.lastItemUpdate < 500) {
			return;
		}
		Client.myPlayer.compNeedsUpdate = true;
		Client.instance.uLinkNodes();
		Client.lastItemUpdate = System.currentTimeMillis();
		mruNodes2.unlinkAll();
		mruNodes1.unlinkAll();
		EntityDefinition.mruNodes.unlinkAll();
		Client.preloadModels();
	}
}
