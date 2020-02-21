package Runecessor;

import java.util.Arrays;

public final class FramesBase {

	public final int length;

	public final int[] opcode;

	public final int[][] skinlist;

	public FramesBase(Stream stream) {
		if (Config.PRE_EOC) {
			length = stream.readUnsignedByte();
			opcode = new int[length];
			skinlist = new int[length][];
			for (int j = 0; j < length; j++) {
				opcode[j] = stream.readUnsignedByte();
			}
			for (int j = 0; j < length; j++) {
				skinlist[j] = new int[stream.readUnsignedByte()];
			}
			for (int j = 0; j < length; j++) {
				for (int l = 0; l < skinlist[j].length; l++)
					skinlist[j][l] = stream.readUnsignedByte();
			}
		}
		else {
			length = stream.readUnsignedWord();
			opcode = new int[length];
			skinlist = new int[length][];
			for (int j = 0; j < length; j++) {
				opcode[j] = stream.readUnsignedWord();
			}
			for (int j = 0; j < length; j++) {
				skinlist[j] = new int[stream.readUnsignedWord()];
			}
			for (int j = 0; j < length; j++) {
				for (int l = 0; l < skinlist[j].length; l++)
					skinlist[j][l] = stream.readUnsignedWord();
			}
		}
	}
}