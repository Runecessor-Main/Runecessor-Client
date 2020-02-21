package Runecessor;

public final class VarBit {

	public static void unpackConfig(StreamLoader streamLoader) {
		Stream stream = null;
		if (Config.PRE_EOC) {
			stream = new Stream(FileOperations.ReadFile(ClientConstants.getMainCacheLocation() + "718_cache/varbit.dat"));
		}
		else {
			stream = new Stream(streamLoader.getDataForName("varbit.dat"));
		}
		final int cacheSize = stream.readUnsignedWord();
		if (cache == null) {
			cache = new VarBit[cacheSize];
		}
		if (ClientDebugConfiguration.DEBUG_MODE) {
			Utility.print(String.format("Loaded %d varbits", cacheSize));
		}
		for (int j = 0; j < cacheSize; j++) {
			if (cache[j] == null) {
				cache[j] = new VarBit();
			}
			if (!Config.PRE_EOC) {
				cache[j].readValuesOsrs(stream);
			}
			else {
				cache[j].readValues(stream);
			}

			if (cache[j].aBoolean651 && !Config.PRE_EOC)
			{
				Varp.cache[cache[j].setting].aBoolean713 = true;
			}
		}

		if (!Config.PRE_EOC) {
			if (stream.currentOffset != stream.buffer.length)
				Utility.print("Varbit load mismatch! " + stream.currentOffset + " " + stream.buffer.length);
		}
	}

	private void readValues(Stream stream) {
		setting = stream.readUnsignedWord();
		startbit = stream.readUnsignedByte();
		endbit = stream.readUnsignedByte();
	}

	private void readValuesOsrs(Stream stream) {
		int opcode = stream.readUnsignedByte();

		if (opcode == 0) {
			return;
		}
		else if (opcode == 1) {
			setting = stream.readUnsignedWord();
			startbit = stream.readUnsignedByte();
			endbit = stream.readUnsignedByte();
		}
		else {
			Utility.print(opcode);
		}
	}

	private VarBit() {
		aBoolean651 = false;
	}

	public static VarBit cache[];

	public int setting;

	public int startbit;

	public int endbit;

	private boolean aBoolean651; // Dummy?
}
