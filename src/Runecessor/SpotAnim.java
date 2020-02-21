package Runecessor;

public final class SpotAnim {


	public static void unpackConfig(StreamLoader streamLoader) {
		Stream stream = null;
		if (Config.PRE_EOC) {
			stream = new Stream(FileOperations.ReadFile(ClientConstants.getMainCacheLocation() + "718_cache/spotanim.dat"));
		}
		else {
			stream = new Stream(streamLoader.getDataForName("spotanim.dat"));
		}
		int length = stream.readUnsignedWord();
		if (ClientDebugConfiguration.DEBUG_MODE) {
		Utility.print(String.format("Loaded %d graphics", length));
		}

		if (cache == null)
			cache = new SpotAnim[length + 2000];
		for (int j = 0; j < length; j++) {
			if (cache[j] == null)
				cache[j] = new SpotAnim();
			cache[j].index = j;
			if (Config.PRE_EOC) {
				cache[j].readValues(stream);
			}
			else {
				cache[j].readValuesOsrs(stream);
			}
		}

		customGfxOsrs();

		int gfxToDebug = 0;
		String random = "tayar";
		String random1 = "kk";
		if (gfxToDebug > 0) {
			Utility.print("cache[" + random + random1 + "].ambient = " + cache[gfxToDebug].ambient + ";");
			Utility.print("cache[" + random + random1 + "].ambient = " + cache[gfxToDebug].animationId + ";");
			Utility.print("cache[" + random + random1 + "].ambient = " + cache[gfxToDebug].contrast + ";");
			Utility.print("cache[" + random + random1 + "].ambient = " + cache[gfxToDebug].height + ";");
			Utility.print("cache[" + random + random1 + "].ambient = " + cache[gfxToDebug].index + ";");
			Utility.print("cache[" + random + random1 + "].ambient = " + cache[gfxToDebug].model + ";");
			Utility.print("cache[" + random + random1 + "].ambient = " + cache[gfxToDebug].ambient + ";");
			Utility.print("cache[" + random + random1 + "].ambient = " + cache[gfxToDebug].rotation + ";");
			Utility.print("cache[" + random + random1 + "].ambient = " + cache[gfxToDebug].scale + ";");
			Utility.print("cache[" + random + random1 + "].animationSequence = Sequences.anims[" + cache[gfxToDebug].animationId + "];");
		}

		if (stream.currentOffset != stream.buffer.length) {
			Utility.print("Gfx mismatch! " + stream.currentOffset + " " + stream.buffer.length);
		}
	}

	private static void customGfxOsrs() {
		if (Config.PRE_EOC) {
			return;
		}

		//1374 is highest osrs gfx id.
		//33k is highest model id used by 139 data.
		// Td magic projectile
		cache[2003] = new SpotAnim();
		cache[2003].ambient = 0;
		cache[2003].contrast = 0;
		cache[2003].height = 128;
		cache[2003].index = 1884;
		cache[2003].model = 44666;
		cache[2003].rotation = 0;
		cache[2003].scale = 128;
		cache[2003].animationId = 11016;
		cache[2003].animationSequence = Sequences.anims[11016];

		// Td ranged projectile
		cache[2004] = new SpotAnim();
		cache[2004].ambient = 0;
		cache[2004].contrast = 0;
		cache[2004].height = 128;
		cache[2004].index = 1889;
		cache[2004].model = 44654;
		cache[2004].rotation = 0;
		cache[2004].scale = 128;
		cache[2004].animationId = 11014;
		cache[2004].animationSequence = Sequences.anims[11014];

		// Td melee gfx
		cache[2001] = new SpotAnim();
		cache[2001].ambient = 0;
		cache[2001].contrast = 0;
		cache[2001].height = 128;
		cache[2001].index = 1886;
		cache[2001].model = 44629;
		cache[2001].rotation = 0;
		cache[2001].scale = 128;
		cache[2001].animationId = 11015;
		cache[2001].animationSequence = Sequences.anims[11015];

		// Dice gfx id.
		cache[2000] = new SpotAnim();
		cache[2000].ambient = 0;
		cache[2000].contrast = 0;
		cache[2000].height = 128;
		cache[2000].index = 2075;
		cache[2000].model = 47874;
		cache[2000].rotation = 0;
		cache[2000].scale = 128;
		cache[2000].animationId = 11002;
		cache[2000].animationSequence = Sequences.anims[11002];
		
	}

	private void readValues(Stream stream) {
		while (true) {
			int i = stream.readUnsignedByte();

			if (i == 0) {
				return;
			}
			else if (i == 1) {
				model = stream.readDWord();
			}
			else if (i == 2) {
				animationId = stream.readDWord();
				if (Sequences.anims != null) {
					animationSequence = Sequences.anims[animationId];
				}
			}
			else if (i == 4) {
				scale = stream.readUnsignedWord();
			}
			else if (i == 5) {
				height = stream.readUnsignedWord();
			}
			else if (i == 6) {
				rotation = stream.readUnsignedWord();
			}
			else if (i == 7) {
				ambient = stream.readUnsignedWord();
			}
			else if (i == 8) {
				contrast = stream.readUnsignedWord();
			}
			else if (i == 40) {
				int length = stream.readUnsignedByte();
				for (int index = 0; index < length; index++) {
					srcColors[index] = stream.readUnsignedWord();
					dstColors[index] = stream.readUnsignedWord();
				}
			}
			else if (i == 41) {
				int length = stream.readUnsignedByte();
				for (int index = 0; index < length; ++index) {
					retextureToFind[index] = stream.readUnsignedWord();
					retextureToReplace[index] = stream.readUnsignedWord();
				}
			}
			else {
				Utility.print("Error graphics opcode: " + i);
			}
		}
	}

	private void readValuesOsrs(Stream buffer) {
		while (true) {
			final int opcode = buffer.readUnsignedByte();

			if (opcode == 0) {
				return;
			}
			else if (opcode == 1) {
				model = buffer.readUnsignedWord();
			}
			else if (opcode == 2) {
				animationId = buffer.readUnsignedWord();
				if (Sequences.anims != null) {
					animationSequence = Sequences.anims[animationId];
				}
			}
			else if (opcode == 4) {
				scale = buffer.readUnsignedWord();
			}
			else if (opcode == 5) {
				height = buffer.readUnsignedWord();
			}
			else if (opcode == 6) {
				rotation = buffer.readUnsignedWord();
			}
			else if (opcode == 7) {
				ambient = buffer.readUnsignedByte();
			}
			else if (opcode == 8) {
				contrast = buffer.readUnsignedByte();
			}
			else if (opcode == 40) {
				final int len = buffer.readUnsignedByte();
				srcColorsOsrs = new short[len];
				dstColorsOsrs = new short[len];
				for (int i = 0; i < len; i++) {
					srcColorsOsrs[i] = (short) buffer.readUnsignedWord();
					dstColorsOsrs[i] = (short) buffer.readUnsignedWord();
				}
			}
			else if (opcode == 41) {
				final int len = buffer.readUnsignedByte();
				retextureToFindOsrs = new short[len];
				retextureToReplaceOsrs = new short[len];
				for (int i = 0; i < len; i++) {
					retextureToFindOsrs[i] = (short) buffer.readUnsignedWord();
					retextureToReplaceOsrs[i] = (short) buffer.readUnsignedWord();
				}
			}
			else {
				Utility.print("gfx invalid opcode: " + opcode);
			}
		}
	}

	public Model getModel() {
		Model model = (Model) models.insertFromCache(index);
		if (model != null) {
			return model;
		}
		model = Model.getModel(this.model);
		if (model == null) {
			return null;
		}
		if (!Config.PRE_EOC) {
			// osrs new way of recoloring
			if (srcColorsOsrs != null) {
				for (int i = 0; i < dstColorsOsrs.length; i++) {
					model.setColour(srcColorsOsrs[i], dstColorsOsrs[i]);
				}
			}

			// osrs added support for retexturing
			if (retextureToFindOsrs != null) {
				for (int i = 0; i < dstColorsOsrs.length; i++) {
					model.retexture((short) retextureToFindOsrs[i], (short) retextureToReplaceOsrs[i]);
				}
			}
		}
		if (Config.PRE_EOC) {
			for (int i = 0; i < 6; i++) {
				if (srcColors[0] != 0) {
					model.setColour(srcColors[i], dstColors[i]);
				}
			}
		}

		models.removeFromCache(model, index);
		return model;
	}

	private SpotAnim() {
		animationId = -1;
		if (Config.PRE_EOC) {
			srcColors = new int[6];
			dstColors = new int[6];
		}
		scale = 128;
		height = 128;
	}

	public static SpotAnim cache[];

	private int index;

	int model;

	private int animationId;

	public Sequences animationSequence;

	private int[] srcColors;

	private int[] dstColors;

	private int[] retextureToFind;

	private int[] retextureToReplace;

	private short[] srcColorsOsrs;

	private short[] dstColorsOsrs;

	private short[] retextureToFindOsrs;

	private short[] retextureToReplaceOsrs;

	public int scale;

	public int height;

	public int rotation;

	public int ambient;

	public int contrast;

	public static ReferenceCache models = new ReferenceCache(30);

}