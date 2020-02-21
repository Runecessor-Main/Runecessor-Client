package Runecessor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public final class Sequences {

	public static final int CUSTOM_ANIMATION_OFFSET = 10_000;

	public static final String CUSTOM_SEQUENCE_FILE = "custom_seq.dat";

	public static int customAnimationCount;

	public static void unpackCustomConfiguration(StreamLoader loader) {
		if (Config.PRE_EOC || Config.PVP) {
			return;
		}
		if (!loader.exists(CUSTOM_SEQUENCE_FILE)) {
			throw new IllegalStateException("Custom sequence file does not exist in cache: " + CUSTOM_SEQUENCE_FILE);

		}
		byte[] sequenceData = loader.getDataForName(CUSTOM_SEQUENCE_FILE);

		if (sequenceData == null || sequenceData.length < 2) {
			throw new IllegalStateException("data for custom sequences is null or length is less than 2.");
		}
		Stream stream = new Stream(sequenceData);

		if (stream.buffer == null || stream.buffer.length < 2) {
			throw new IllegalStateException("length of stream is less than 2 bytes, expects at least two.");
		}
		customAnimationCount = stream.readUnsignedWord();

		if (customAnimationCount < 1) {
			return;
		}
		IntStream.range(CUSTOM_ANIMATION_OFFSET, CUSTOM_ANIMATION_OFFSET + customAnimationCount).forEach(index -> {
			if (anims[index] == null) {
				anims[index] = new Sequences();
			}
			if (Config.PRE_EOC) {
				anims[index].readValuesPreEoc(stream);
			} else {
				anims[index].readValuesOsrs(stream);
			}
		});
	}

	public static void unpackConfig(StreamLoader streamLoader) {
		Stream stream = null;
		if (Config.PRE_EOC) {
			stream = new Stream(FileOperations.ReadFile(ClientConstants.getMainCacheLocation() + "718_cache/seq.dat"));
		}
		else {
			stream = new Stream(streamLoader.getDataForName("seq.dat"));
		}
		int length = stream.readUnsignedWord();

		if (anims == null) {
			anims = new Sequences[length + 4000 + CUSTOM_ANIMATION_OFFSET];
		}
		if (ClientDebugConfiguration.DEBUG_MODE) {
			Utility.print(String.format("Loaded %d animations with a total length of %d", length, anims.length));
		}
		for (int j = 0; j < length; j++) {
			if (anims[j] == null) {
				anims[j] = new Sequences();
			}
			if (Config.PRE_EOC) {
				anims[j].readValuesPreEoc(stream);
			}
			else {
				anims[j].readValuesOsrs(stream);
			}
		}
		boolean debug = false;
		int animationToDebug = 806;
		String random = "tayar";
		String random1 = "tayar";
		random = random + random1;
		if (debug) {
			Utility.print("anims[" + random + "].allowsRotation = " + anims[animationToDebug].allowsRotation + ";");
			Utility.print("anims[" + random + "].delayType = " + anims[animationToDebug].delayType + ";");
			Utility.print("anims[" + random + "].length = " + anims[animationToDebug].length + ";");
			Utility.print("anims[" + random + "].padding = " + anims[animationToDebug].padding + ";");
			Utility.print("anims[" + random + "].priority1 = " + anims[animationToDebug].priority1 + ";");
			Utility.print("anims[" + random + "].resetCycle = " + anims[animationToDebug].resetCycle + ";");
			Utility.print("anims[" + random + "].runFlag = " + anims[animationToDebug].runFlag + ";");
			Utility.print("anims[" + random + "].shield = " + anims[animationToDebug].shield + ";");
			Utility.print("anims[" + random + "].walkFlag = " + anims[animationToDebug].walkFlag + ";");
			Utility.print("anims[" + random + "].weapon = " + anims[animationToDebug].weapon + ";");
			if (anims[animationToDebug].vertices != null) {
				Utility.print("anims[" + random + "].vertices = new int[" + anims[animationToDebug].vertices.length + "];");
				for (int index = 0; index < anims[animationToDebug].vertices.length; index++) {
					Utility.print("anims[" + random + "].vertices[" + index + "] = " + anims[animationToDebug].vertices[index] + ";");
				}
			}
			if (anims[animationToDebug].duration != null) {
				Utility.print("anims[" + random + "].duration = new int[" + anims[animationToDebug].duration.length + "];");
				for (int index = 0; index < anims[animationToDebug].duration.length; index++) {
					Utility.print("anims[" + random + "].duration[" + index + "] = " + anims[animationToDebug].duration[index] + ";");
				}
			}
			if (anims[animationToDebug].primary != null) {
				Utility.print("anims[" + random + "].primary = new int[" + anims[animationToDebug].primary.length + "];");
				for (int index = 0; index < anims[animationToDebug].primary.length; index++) {
					Utility.print("anims[" + random + "].primary[" + index + "] = " + anims[animationToDebug].primary[index] + ";");
				}
			}
			if (anims[animationToDebug].secondary != null) {
				Utility.print("anims[" + random + "].secondary = new int[" + anims[animationToDebug].secondary.length + "];");
				for (int index = 0; index < anims[animationToDebug].secondary.length; index++) {
					Utility.print("anims[" + random + "].secondary[" + index + "] = " + anims[animationToDebug].secondary[index] + ";");
				}
			}
		}


		boolean debugFileId = false;
		int variableToDebug = 174325766;
		if (debugFileId) {
			debugFileId(variableToDebug);
		}

		// Highest animation file id used by 139 data is 1900.
		// 667 data highest file id is 3.7k.
		// Animations up to file id 2090 on 169 data
		// Animations up to file id 2220 and animation id up to 8186 on 174 data (vesta's release etc..)
		osrsCustomAnimations();
		//convertMgtWay(10999, 4002);
	}

	private static int highestAnimationFile;
	private static void debugFileId(int variableToDebug) {
		String s = "";
		int fileId = 0;
		@SuppressWarnings("unused")
		int k = 0;
		s = Integer.toHexString(variableToDebug);
		try {
			fileId = Integer.parseInt(s.substring(0, s.length() - 4), 16);
			Utility.print("File id: " + fileId);
			if (fileId > highestAnimationFile) {
				highestAnimationFile = fileId;
			}
		} catch (Exception e) {
			Utility.print("Invalid for primary: " + variableToDebug);
			e.printStackTrace();
		}
	}

	public static int getFileId(int frame) {
		String hexRepresentation = addLeadingZeros(Integer.toHexString(frame), 8);

		return Integer.parseInt(hexRepresentation.substring(0, hexRepresentation.length() - 4), 16);
	}

	public static int getFileIndex(int frame) {
		String hexRepresentation = addLeadingZeros(Integer.toHexString(frame), 8);

		return Integer.parseInt(hexRepresentation.substring(hexRepresentation.length() - 4), 16);
	}

	public static int toDecimal(int file, int index) {
		return Integer.parseInt(String.format("%s%s",
				addLeadingZeros(Integer.toHexString(file), 4),
				addLeadingZeros(Integer.toHexString(index), 4)), 16);
	}

	private static String addLeadingZeros(String value, int width) {
		if (value.length() >= width) {
			return value;
		}
		if (value.isEmpty()) {
			return String.format("%04d", 0);
		}
		StringBuilder builder = new StringBuilder(value);

		for (int index = value.length(); index < width; index++) {
			builder.insert(0, 0);
		}
		return builder.toString();
	}

	/* Keep commented out to keep obfuscated.
	public static void main(String[] args) {
		int[] converted = convert(4003,
				143065886, 143065911, 143065990, 143065968, 143065922, 143065987,
				143065912, 143065898, 143065949, 143065982, 143065923, 143065943,
				143065956, 143065904, 143065983, 143065939, 143066365, 143066315,
				143066376, 143066347, 143066352, 143066382, 143066325, 143066380
		);
	
		System.out.println("Converted = " + Arrays.toString(converted));
	}
	*/

	public static void convertMgtWay(int animationIdToConvert, int newFileId) {
		int[] primary = anims[animationIdToConvert].primary;
		int[] converted = new int[primary.length];

		for (int index = 0; index < converted.length; index++) {
			converted[index] = toDecimal(newFileId, getFileIndex(primary[index]));
		}
		for (int index = 0; index < converted.length; index++) {
			Utility.print("anims[" + animationIdToConvert + "].primary[" + index + "] = " + converted[index] + ";");
		}
	}

	public static int[] convert(int file, int... frames) {
		int[] converted = new int[frames.length];

		for (int index = 0; index < converted.length; index++) {
			converted[index] = toDecimal(file, getFileIndex(frames[index]));
		}
		return converted;
	}

	private static void osrsCustomAnimations() {
		if (Config.PRE_EOC) {
			return;
		}
		// Item id, animation id
		int[][] armadylGodswordAnimations =
		{
			{16042, 11032}, // Armadyl godsword (g) for C0nz0le
			{16047, 11033}, // Armadyl godsword (p) for Trenbolone e
			{16060, 11034}, // Armadyl godsword (Bites)
			{16063, 11035}, // Armadyl godsword (Russman887)
			{16091, 11036}, // Armadyl godsword (lava) for wespoonedyou
			{16112, 11037}, // Armadyl godsword (blood) for Thuggahhh
			{16183, 11048}, // Armadyl godsword (rainbow) for I Solo
			{16187, 11049}, // Light Blue Armadyl godsword for Bluezia
			{16206, 11050}, // Green Armadyl godsword for Dirty Specz
			{16207, 11051}, // Pink Armadyl godsword for Muppets
			{16260, 11053}, // Purple Armadyl godsword for Demian
			{16271, 11054}, // USA Armadyl godsword for Pannibal
			{16315, 11056}, // Armadyl godsword (or) with Black hilt for MrJustin
			{16316, 11057}, // Pink Armadyl godsword with white blade for Chamo
						{16337, 11058}, // Armadyl Godsword, White Black and some lime for Tag
						{16380, 11059}, // Armadyl godsword being blue on top white in the middle and the bottom hilt area/handle being red for Rap
						{16396, 11060}, // Armadyl godsword blood red for Zachery
			{16401, 11061}, // Armadyl godsword, dark orange blade and black hilt for Kourtney
			{16404, 11062}, // Armadyl godsword, Purple hilt, blade half white and half black for Half life
			{16409, 11063}, // Armadyl godsword, Lava colour for hilt, right side of blade white, left side of blade golden for I Whale Hunt
			{16411, 11064}, // Armadyl godsword, Bright red handle, White and light blue trim for Middle
			{16415, 11065}, // Armadyl godsword, red hilt, black blade for Volbeat
			{16424, 11066}, // Armadyl godsword, blue blade (like blue phat) and white hilt for Wallah Bro
			{16426, 11067}, // Armadyl godsword, pink blade and cyan hilt for Foul
			{16435, 11068}, // Armadyl godsword, red for Hac Coin2
		};
		for (int index = 0; index < armadylGodswordAnimations.length; index++) {
			anims[armadylGodswordAnimations[index][1]] = new Sequences();
			anims[armadylGodswordAnimations[index][1]].allowsRotation = true;
			anims[armadylGodswordAnimations[index][1]].delayType = 2;
			anims[armadylGodswordAnimations[index][1]].length = 31;
			anims[armadylGodswordAnimations[index][1]].padding = -1;
			anims[armadylGodswordAnimations[index][1]].priority1 = 6;
			anims[armadylGodswordAnimations[index][1]].resetCycle = 99;
			anims[armadylGodswordAnimations[index][1]].runFlag = 2;
			anims[armadylGodswordAnimations[index][1]].shield = armadylGodswordAnimations[index][0] + 512;
			anims[armadylGodswordAnimations[index][1]].walkFlag = 2;
			anims[armadylGodswordAnimations[index][1]].weapon = armadylGodswordAnimations[index][0] + 512;
			anims[armadylGodswordAnimations[index][1]].vertices = new int[22];
			anims[armadylGodswordAnimations[index][1]].vertices[0] = 164;
			anims[armadylGodswordAnimations[index][1]].vertices[1] = 166;
			anims[armadylGodswordAnimations[index][1]].vertices[2] = 168;
			anims[armadylGodswordAnimations[index][1]].vertices[3] = 170;
			anims[armadylGodswordAnimations[index][1]].vertices[4] = 172;
			anims[armadylGodswordAnimations[index][1]].vertices[5] = 174;
			anims[armadylGodswordAnimations[index][1]].vertices[6] = 176;
			anims[armadylGodswordAnimations[index][1]].vertices[7] = 178;
			anims[armadylGodswordAnimations[index][1]].vertices[8] = 180;
			anims[armadylGodswordAnimations[index][1]].vertices[9] = 182;
			anims[armadylGodswordAnimations[index][1]].vertices[10] = 183;
			anims[armadylGodswordAnimations[index][1]].vertices[11] = 185;
			anims[armadylGodswordAnimations[index][1]].vertices[12] = 193;
			anims[armadylGodswordAnimations[index][1]].vertices[13] = 194;
			anims[armadylGodswordAnimations[index][1]].vertices[14] = 196;
			anims[armadylGodswordAnimations[index][1]].vertices[15] = 197;
			anims[armadylGodswordAnimations[index][1]].vertices[16] = 198;
			anims[armadylGodswordAnimations[index][1]].vertices[17] = 200;
			anims[armadylGodswordAnimations[index][1]].vertices[18] = 202;
			anims[armadylGodswordAnimations[index][1]].vertices[19] = 203;
			anims[armadylGodswordAnimations[index][1]].vertices[20] = 204;
			anims[armadylGodswordAnimations[index][1]].vertices[21] = 9999999;
			anims[armadylGodswordAnimations[index][1]].duration = new int[31];
			anims[armadylGodswordAnimations[index][1]].duration[0] = 3;
			anims[armadylGodswordAnimations[index][1]].duration[1] = 3;
			anims[armadylGodswordAnimations[index][1]].duration[2] = 3;
			anims[armadylGodswordAnimations[index][1]].duration[3] = 3;
			anims[armadylGodswordAnimations[index][1]].duration[4] = 3;
			anims[armadylGodswordAnimations[index][1]].duration[5] = 3;
			anims[armadylGodswordAnimations[index][1]].duration[6] = 3;
			anims[armadylGodswordAnimations[index][1]].duration[7] = 3;
			anims[armadylGodswordAnimations[index][1]].duration[8] = 3;
			anims[armadylGodswordAnimations[index][1]].duration[9] = 3;
			anims[armadylGodswordAnimations[index][1]].duration[10] = 3;
			anims[armadylGodswordAnimations[index][1]].duration[11] = 3;
			anims[armadylGodswordAnimations[index][1]].duration[12] = 3;
			anims[armadylGodswordAnimations[index][1]].duration[13] = 3;
			anims[armadylGodswordAnimations[index][1]].duration[14] = 3;
			anims[armadylGodswordAnimations[index][1]].duration[15] = 3;
			anims[armadylGodswordAnimations[index][1]].duration[16] = 3;
			anims[armadylGodswordAnimations[index][1]].duration[17] = 3;
			anims[armadylGodswordAnimations[index][1]].duration[18] = 3;
			anims[armadylGodswordAnimations[index][1]].duration[19] = 3;
			anims[armadylGodswordAnimations[index][1]].duration[20] = 3;
			anims[armadylGodswordAnimations[index][1]].duration[21] = 3;
			anims[armadylGodswordAnimations[index][1]].duration[22] = 3;
			anims[armadylGodswordAnimations[index][1]].duration[23] = 3;
			anims[armadylGodswordAnimations[index][1]].duration[24] = 3;
			anims[armadylGodswordAnimations[index][1]].duration[25] = 3;
			anims[armadylGodswordAnimations[index][1]].duration[26] = 3;
			anims[armadylGodswordAnimations[index][1]].duration[27] = 3;
			anims[armadylGodswordAnimations[index][1]].duration[28] = 3;
			anims[armadylGodswordAnimations[index][1]].duration[29] = 3;
			anims[armadylGodswordAnimations[index][1]].duration[30] = 3;
			anims[armadylGodswordAnimations[index][1]].primary = new int[31];
			anims[armadylGodswordAnimations[index][1]].primary[0] = 114295000;
			anims[armadylGodswordAnimations[index][1]].primary[1] = 114294953;
			anims[armadylGodswordAnimations[index][1]].primary[2] = 114295281;
			anims[armadylGodswordAnimations[index][1]].primary[3] = 114295193;
			anims[armadylGodswordAnimations[index][1]].primary[4] = 114295189;
			anims[armadylGodswordAnimations[index][1]].primary[5] = 114295249;
			anims[armadylGodswordAnimations[index][1]].primary[6] = 114295182;
			anims[armadylGodswordAnimations[index][1]].primary[7] = 114295061;
			anims[armadylGodswordAnimations[index][1]].primary[8] = 114295124;
			anims[armadylGodswordAnimations[index][1]].primary[9] = 114295007;
			anims[armadylGodswordAnimations[index][1]].primary[10] = 114295337;
			anims[armadylGodswordAnimations[index][1]].primary[11] = 114295102;
			anims[armadylGodswordAnimations[index][1]].primary[12] = 114294995;
			anims[armadylGodswordAnimations[index][1]].primary[13] = 114295283;
			anims[armadylGodswordAnimations[index][1]].primary[14] = 114295025;
			anims[armadylGodswordAnimations[index][1]].primary[15] = 114294899;
			anims[armadylGodswordAnimations[index][1]].primary[16] = 114295233;
			anims[armadylGodswordAnimations[index][1]].primary[17] = 114294879;
			anims[armadylGodswordAnimations[index][1]].primary[18] = 114295175;
			anims[armadylGodswordAnimations[index][1]].primary[19] = 114295169;
			anims[armadylGodswordAnimations[index][1]].primary[20] = 114294903;
			anims[armadylGodswordAnimations[index][1]].primary[21] = 114295091;
			anims[armadylGodswordAnimations[index][1]].primary[22] = 114295059;
			anims[armadylGodswordAnimations[index][1]].primary[23] = 114295267;
			anims[armadylGodswordAnimations[index][1]].primary[24] = 114295003;
			anims[armadylGodswordAnimations[index][1]].primary[25] = 114294981;
			anims[armadylGodswordAnimations[index][1]].primary[26] = 114294951;
			anims[armadylGodswordAnimations[index][1]].primary[27] = 114295031;
			anims[armadylGodswordAnimations[index][1]].primary[28] = 114294986;
			anims[armadylGodswordAnimations[index][1]].primary[29] = 114294820;
			anims[armadylGodswordAnimations[index][1]].primary[30] = 114295226;
		}

		// Vesta's longsword special attack with file id 2571
		anims[10999] = new Sequences();
		anims[10999].allowsRotation = false;
		anims[10999].delayType = 2;
		anims[10999].length = 18;
		anims[10999].padding = -1;
		anims[10999].priority1 = 5;
		anims[10999].resetCycle = 99;
		anims[10999].runFlag = 0;
		anims[10999].shield = -1;
		anims[10999].walkFlag = 0;
		anims[10999].weapon = -1;
		anims[10999].duration = new int[18];
		anims[10999].duration[0] = 3;
		anims[10999].duration[1] = 3;
		anims[10999].duration[2] = 3;
		anims[10999].duration[3] = 3;
		anims[10999].duration[4] = 3;
		anims[10999].duration[5] = 3;
		anims[10999].duration[6] = 3;
		anims[10999].duration[7] = 3;
		anims[10999].duration[8] = 3;
		anims[10999].duration[9] = 3;
		anims[10999].duration[10] = 3;
		anims[10999].duration[11] = 3;
		anims[10999].duration[12] = 3;
		anims[10999].duration[13] = 3;
		anims[10999].duration[14] = 3;
		anims[10999].duration[15] = 3;
		anims[10999].duration[16] = 3;
		anims[10999].duration[17] = 3;
		anims[10999].primary = new int[18];
		anims[10999].primary[0] = 168493102;
		anims[10999].primary[1] = 168493119;
		anims[10999].primary[2] = 168493200;
		anims[10999].primary[3] = 168493113;
		anims[10999].primary[4] = 168493153;
		anims[10999].primary[5] = 168493194;
		anims[10999].primary[6] = 168493134;
		anims[10999].primary[7] = 168493213;
		anims[10999].primary[8] = 168493149;
		anims[10999].primary[9] = 168493122;
		anims[10999].primary[10] = 168493098;
		anims[10999].primary[11] = 168493170;
		anims[10999].primary[12] = 168493170;
		anims[10999].primary[13] = 168493188;
		anims[10999].primary[14] = 168493205;
		anims[10999].primary[15] = 168493196;
		anims[10999].primary[16] = 168493165;
		anims[10999].primary[17] = 168493102;
		anims[10999].secondary = new int[18];
		anims[10999].secondary[0] = -1;
		anims[10999].secondary[1] = -1;
		anims[10999].secondary[2] = -1;
		anims[10999].secondary[3] = -1;
		anims[10999].secondary[4] = -1;
		anims[10999].secondary[5] = -1;
		anims[10999].secondary[6] = -1;
		anims[10999].secondary[7] = -1;
		anims[10999].secondary[8] = -1;
		anims[10999].secondary[9] = -1;
		anims[10999].secondary[10] = -1;
		anims[10999].secondary[11] = -1;
		anims[10999].secondary[12] = -1;
		anims[10999].secondary[13] = -1;
		anims[10999].secondary[14] = -1;
		anims[10999].secondary[15] = -1;
		anims[10999].secondary[16] = -1;
		anims[10999].secondary[17] = -1;

		// Royal seed pod animation fixed.
		anims[4544].allowsRotation = true;
		anims[4544].delayType = 2;
		anims[4544].length = 31;
		anims[4544].padding = -1;
		anims[4544].priority1 = 5;
		anims[4544].resetCycle = 99;
		anims[4544].runFlag = 0;
		anims[4544].shield = 0;
		anims[4544].walkFlag = 0;
		anims[4544].weapon = 0;
		anims[4544].duration = new int[31];
		anims[4544].duration[0] = 4;
		anims[4544].duration[1] = 4;
		anims[4544].duration[2] = 4;
		anims[4544].duration[3] = 4;
		anims[4544].duration[4] = 4;
		anims[4544].duration[5] = 4;
		anims[4544].duration[6] = 4;
		anims[4544].duration[7] = 4;
		anims[4544].duration[8] = 4;
		anims[4544].duration[9] = 4;
		anims[4544].duration[10] = 4;
		anims[4544].duration[11] = 4;
		anims[4544].duration[12] = 4;
		anims[4544].duration[13] = 4;
		anims[4544].duration[14] = 4;
		anims[4544].duration[15] = 4;
		anims[4544].duration[16] = 4;
		anims[4544].duration[17] = 4;
		anims[4544].duration[18] = 4;
		anims[4544].duration[19] = 4;
		anims[4544].duration[20] = 25;
		anims[4544].duration[21] = 4;
		anims[4544].duration[22] = 4;
		anims[4544].duration[23] = 4;
		anims[4544].duration[24] = 4;
		anims[4544].duration[25] = 4;
		anims[4544].duration[26] = 4;
		anims[4544].duration[27] = 4;
		anims[4544].duration[28] = 4;
		anims[4544].duration[29] = 4;
		anims[4544].duration[30] = 4;
		anims[4544].primary = new int[31];
		anims[4544].primary[0] = 78512193;
		anims[4544].primary[1] = 78512204;
		anims[4544].primary[2] = 78512215;
		anims[4544].primary[3] = 78512218;
		anims[4544].primary[4] = 78512219;
		anims[4544].primary[5] = 78512220;
		anims[4544].primary[6] = 78512221;
		anims[4544].primary[7] = 78512222;
		anims[4544].primary[8] = 78512223;
		anims[4544].primary[9] = 78512194;
		anims[4544].primary[10] = 78512195;
		anims[4544].primary[11] = 78512196;
		anims[4544].primary[12] = 78512197;
		anims[4544].primary[13] = 78512198;
		anims[4544].primary[14] = 78512199;
		anims[4544].primary[15] = 78512200;
		anims[4544].primary[16] = 78512201;
		anims[4544].primary[17] = 78512202;
		anims[4544].primary[18] = 78512203;
		anims[4544].primary[19] = 78512205;
		anims[4544].primary[20] = 78512206;
		anims[4544].primary[21] = 78512207;
		anims[4544].primary[22] = 78512208;
		anims[4544].primary[23] = 78512209;
		anims[4544].primary[24] = 78512210;
		anims[4544].primary[25] = 78512211;
		anims[4544].primary[26] = 78512212;
		anims[4544].primary[27] = 78512213;
		anims[4544].primary[28] = 78512214;
		anims[4544].primary[29] = 78512216;
		anims[4544].primary[30] = 78512217;
		anims[4544].secondary = new int[31];
		anims[4544].secondary[0] = -1;
		anims[4544].secondary[1] = -1;
		anims[4544].secondary[2] = -1;
		anims[4544].secondary[3] = -1;
		anims[4544].secondary[4] = -1;
		anims[4544].secondary[5] = -1;
		anims[4544].secondary[6] = -1;
		anims[4544].secondary[7] = -1;
		anims[4544].secondary[8] = -1;
		anims[4544].secondary[9] = -1;
		anims[4544].secondary[10] = -1;
		anims[4544].secondary[11] = -1;
		anims[4544].secondary[12] = -1;
		anims[4544].secondary[13] = -1;
		anims[4544].secondary[14] = -1;
		anims[4544].secondary[15] = -1;
		anims[4544].secondary[16] = -1;
		anims[4544].secondary[17] = -1;
		anims[4544].secondary[18] = -1;
		anims[4544].secondary[19] = -1;
		anims[4544].secondary[20] = -1;
		anims[4544].secondary[21] = -1;
		anims[4544].secondary[22] = -1;
		anims[4544].secondary[23] = -1;
		anims[4544].secondary[24] = -1;
		anims[4544].secondary[25] = -1;
		anims[4544].secondary[26] = -1;
		anims[4544].secondary[27] = -1;
		anims[4544].secondary[28] = -1;
		anims[4544].secondary[29] = -1;
		anims[4544].secondary[30] = -1;

		// Cyan Toxic staff of the dead animation
		anims[11052] = new Sequences();
		anims[11052].allowsRotation = false;
		anims[11052].delayType = 2;
		anims[11052].length = 16;
		anims[11052].padding = -1;
		anims[11052].priority1 = 6;
		anims[11052].resetCycle = 99;
		anims[11052].runFlag = 2;
		anims[11052].shield = -1;
		anims[11052].walkFlag = 2;
		anims[11052].weapon = 16209 + 512;
		anims[11052].vertices = new int[28];
		anims[11052].vertices[0] = 1;
		anims[11052].vertices[1] = 2;
		anims[11052].vertices[2] = 9;
		anims[11052].vertices[3] = 11;
		anims[11052].vertices[4] = 13;
		anims[11052].vertices[5] = 15;
		anims[11052].vertices[6] = 17;
		anims[11052].vertices[7] = 19;
		anims[11052].vertices[8] = 37;
		anims[11052].vertices[9] = 39;
		anims[11052].vertices[10] = 41;
		anims[11052].vertices[11] = 43;
		anims[11052].vertices[12] = 45;
		anims[11052].vertices[13] = 164;
		anims[11052].vertices[14] = 166;
		anims[11052].vertices[15] = 168;
		anims[11052].vertices[16] = 170;
		anims[11052].vertices[17] = 172;
		anims[11052].vertices[18] = 174;
		anims[11052].vertices[19] = 176;
		anims[11052].vertices[20] = 178;
		anims[11052].vertices[21] = 180;
		anims[11052].vertices[22] = 182;
		anims[11052].vertices[23] = 183;
		anims[11052].vertices[24] = 185;
		anims[11052].vertices[25] = 191;
		anims[11052].vertices[26] = 192;
		anims[11052].vertices[27] = 9999999;
		anims[11052].duration = new int[16];
		anims[11052].duration[0] = 3;
		anims[11052].duration[1] = 2;
		anims[11052].duration[2] = 3;
		anims[11052].duration[3] = 6;
		anims[11052].duration[4] = 2;
		anims[11052].duration[5] = 2;
		anims[11052].duration[6] = 5;
		anims[11052].duration[7] = 5;
		anims[11052].duration[8] = 5;
		anims[11052].duration[9] = 5;
		anims[11052].duration[10] = 3;
		anims[11052].duration[11] = 2;
		anims[11052].duration[12] = 3;
		anims[11052].duration[13] = 3;
		anims[11052].duration[14] = 4;
		anims[11052].duration[15] = 4;
		anims[11052].primary = new int[16];
		anims[11052].primary[0] = 18087977;
		anims[11052].primary[1] = 18087978;
		anims[11052].primary[2] = 18087979;
		anims[11052].primary[3] = 18087980;
		anims[11052].primary[4] = 18087981;
		anims[11052].primary[5] = 18087969;
		anims[11052].primary[6] = 18087970;
		anims[11052].primary[7] = 18087971;
		anims[11052].primary[8] = 18087972;
		anims[11052].primary[9] = 18087973;
		anims[11052].primary[10] = 18087979;
		anims[11052].primary[11] = 18087978;
		anims[11052].primary[12] = 18087977;
		anims[11052].primary[13] = 18087976;
		anims[11052].primary[14] = 18087975;
		anims[11052].primary[15] = 18087974;

		// Rainbow Toxic staff of the dead animation
		anims[11055] = new Sequences();
		anims[11055].allowsRotation = false;
		anims[11055].delayType = 2;
		anims[11055].length = 16;
		anims[11055].padding = -1;
		anims[11055].priority1 = 6;
		anims[11055].resetCycle = 99;
		anims[11055].runFlag = 2;
		anims[11055].shield = -1;
		anims[11055].walkFlag = 2;
		anims[11055].weapon = 16272 + 512;
		anims[11055].vertices = new int[28];
		anims[11055].vertices[0] = 1;
		anims[11055].vertices[1] = 2;
		anims[11055].vertices[2] = 9;
		anims[11055].vertices[3] = 11;
		anims[11055].vertices[4] = 13;
		anims[11055].vertices[5] = 15;
		anims[11055].vertices[6] = 17;
		anims[11055].vertices[7] = 19;
		anims[11055].vertices[8] = 37;
		anims[11055].vertices[9] = 39;
		anims[11055].vertices[10] = 41;
		anims[11055].vertices[11] = 43;
		anims[11055].vertices[12] = 45;
		anims[11055].vertices[13] = 164;
		anims[11055].vertices[14] = 166;
		anims[11055].vertices[15] = 168;
		anims[11055].vertices[16] = 170;
		anims[11055].vertices[17] = 172;
		anims[11055].vertices[18] = 174;
		anims[11055].vertices[19] = 176;
		anims[11055].vertices[20] = 178;
		anims[11055].vertices[21] = 180;
		anims[11055].vertices[22] = 182;
		anims[11055].vertices[23] = 183;
		anims[11055].vertices[24] = 185;
		anims[11055].vertices[25] = 191;
		anims[11055].vertices[26] = 192;
		anims[11055].vertices[27] = 9999999;
		anims[11055].duration = new int[16];
		anims[11055].duration[0] = 3;
		anims[11055].duration[1] = 2;
		anims[11055].duration[2] = 3;
		anims[11055].duration[3] = 6;
		anims[11055].duration[4] = 2;
		anims[11055].duration[5] = 2;
		anims[11055].duration[6] = 5;
		anims[11055].duration[7] = 5;
		anims[11055].duration[8] = 5;
		anims[11055].duration[9] = 5;
		anims[11055].duration[10] = 3;
		anims[11055].duration[11] = 2;
		anims[11055].duration[12] = 3;
		anims[11055].duration[13] = 3;
		anims[11055].duration[14] = 4;
		anims[11055].duration[15] = 4;
		anims[11055].primary = new int[16];
		anims[11055].primary[0] = 18087977;
		anims[11055].primary[1] = 18087978;
		anims[11055].primary[2] = 18087979;
		anims[11055].primary[3] = 18087980;
		anims[11055].primary[4] = 18087981;
		anims[11055].primary[5] = 18087969;
		anims[11055].primary[6] = 18087970;
		anims[11055].primary[7] = 18087971;
		anims[11055].primary[8] = 18087972;
		anims[11055].primary[9] = 18087973;
		anims[11055].primary[10] = 18087979;
		anims[11055].primary[11] = 18087978;
		anims[11055].primary[12] = 18087977;
		anims[11055].primary[13] = 18087976;
		anims[11055].primary[14] = 18087975;
		anims[11055].primary[15] = 18087974;

		// -----Animation id: 7397, file: 1890 Revenant werewolf attack
		anims[11040] = new Sequences();
		anims[11040].allowsRotation = false;
		anims[11040].delayType = 2;
		anims[11040].length = 17;
		anims[11040].padding = -1;
		anims[11040].priority1 = 7;
		anims[11040].resetCycle = 99;
		anims[11040].runFlag = 0;
		anims[11040].shield = -1;
		anims[11040].walkFlag = 0;
		anims[11040].weapon = -1;
		anims[11040].duration = new int[]
		{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
		anims[11040].primary = new int[]
		{123863043, 123863135, 123863102, 123863113, 123863062, 123863160, 123863064, 123863045, 123863044, 123863128, 123863121, 123863086, 123863109, 123863084, 123863131, 123863060, 123863079};

		// -----Animation id: 7398, file: 1890 Revenant werewolf death
		anims[11041] = new Sequences();
		anims[11041].allowsRotation = false;
		anims[11041].delayType = 2;
		anims[11041].length = 21;
		anims[11041].padding = -1;
		anims[11041].priority1 = 10;
		anims[11041].resetCycle = 99;
		anims[11041].runFlag = 0;
		anims[11041].shield = -1;
		anims[11041].walkFlag = 0;
		anims[11041].weapon = -1;
		anims[11041].duration = new int[]
		{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 300};
		anims[11041].primary = new int[]
		{123863099, 123863147, 123863104, 123863052, 123863095, 123863161, 123863133, 123863111, 123863092, 123863055, 123863152, 123863072, 123863058, 123863081, 123863076, 123863120, 123863140, 123863129, 123863124, 123863063, 123863118};

		// -----Animation id: 7399, file: 1890 Revenant werewolf block
		anims[11042] = new Sequences();
		anims[11042].allowsRotation = false;
		anims[11042].delayType = 2;
		anims[11042].length = 14;
		anims[11042].padding = -1;
		anims[11042].priority1 = 6;
		anims[11042].resetCycle = 99;
		anims[11042].runFlag = 0;
		anims[11042].shield = -1;
		anims[11042].walkFlag = 0;
		anims[11042].weapon = -1;
		anims[11042].duration = new int[]
		{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
		anims[11042].primary = new int[]
		{123863073, 123863071, 123863082, 123863159, 123863047, 123863156, 123863068, 123863074, 123863136, 123863105, 123863106, 123863093, 123863056, 123863059};

		// -----Animation id: 7400, file: 1890 Revenant werewolf stand
		anims[11043] = new Sequences();
		anims[11043].allowsRotation = false;
		anims[11043].delayType = 2;
		anims[11043].length = 16;
		anims[11043].padding = -1;
		anims[11043].priority1 = 5;
		anims[11043].resetCycle = 99;
		anims[11043].runFlag = 0;
		anims[11043].shield = -1;
		anims[11043].walkFlag = 0;
		anims[11043].weapon = -1;
		anims[11043].duration = new int[]
		{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
		anims[11043].primary = new int[]
		{123863096, 123863091, 123863048, 123863042, 123863057, 123863127, 123863141, 123863149, 123863089, 123863065, 123863087, 123863125, 123863130, 123863138, 123863162, 123863123};

		// -----Animation id: 7397, file: 1890 Revenant werewolf walk
		anims[11044] = new Sequences();
		anims[11044].allowsRotation = false;
		anims[11044].delayType = 2;
		anims[11044].length = 16;
		anims[11044].padding = -1;
		anims[11044].priority1 = 7;
		anims[11044].resetCycle = 99;
		anims[11044].runFlag = 0;
		anims[11044].shield = -1;
		anims[11044].walkFlag = 0;
		anims[11044].weapon = -1;
		anims[11044].duration = new int[]
		{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
		anims[11044].primary = new int[]
		{123863049, 123863067, 123863050, 123863075, 123863094, 123863085, 123863116, 123863117, 123863070, 123863132, 123863119, 123863112, 123863077, 123863090, 123863054, 123863078};


		// -----Animation id: 14261, file: 3313 Revenant dragon attack
		anims[11045] = new Sequences();
		anims[11045].allowsRotation = false;
		anims[11045].delayType = 2;
		anims[11045].length = 19;
		anims[11045].padding = -1;
		anims[11045].priority1 = 7;
		anims[11045].resetCycle = 99;
		anims[11045].runFlag = 0;
		anims[11045].shield = -1;
		anims[11045].walkFlag = 0;
		anims[11045].weapon = -1;
		anims[11045].duration = new int[]
		{3, 3, 3, 3, 3, 2, 2, 3, 2, 3, 3, 3, 2, 3, 3, 4, 4, 5, 4};
		anims[11045].primary = new int[]
		{217120849, 217120799, 217120919, 217120832, 217120913, 217120800, 217120773, 217120794, 217120890, 217120836, 217120859, 217120790, 217120857, 217120844, 217120803, 217120793, 217120921, 217120894, 217120883};

		// -----Animation id: 14262, file: 3313 Revenant dragon stand anim
		anims[11046] = new Sequences();
		anims[11046].allowsRotation = false;
		anims[11046].delayType = 2;
		anims[11046].length = 20;
		anims[11046].padding = -1;
		anims[11046].priority1 = 5;
		anims[11046].resetCycle = 99;
		anims[11046].runFlag = 0;
		anims[11046].shield = -1;
		anims[11046].walkFlag = 0;
		anims[11046].weapon = -1;
		anims[11046].duration = new int[]
		{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 2, 2, 2, 4, 4, 4, 4};
		anims[11046].primary = new int[]
		{217120866, 217120839, 217120901, 217120768, 217120821, 217120891, 217120811, 217120896, 217120802, 217120885, 217120815, 217120912, 217120910, 217120895, 217120907, 217120778, 217120911, 217120874, 217120808, 217120920};

		// -----Animation id: 14263, file: 3313 Revenant dragon walk anim
		anims[11047] = new Sequences();
		anims[11047].allowsRotation = false;
		anims[11047].delayType = 2;
		anims[11047].length = 20;
		anims[11047].padding = -1;
		anims[11047].priority1 = 5;
		anims[11047].resetCycle = 99;
		anims[11047].runFlag = 0;
		anims[11047].shield = -1;
		anims[11047].walkFlag = 0;
		anims[11047].weapon = -1;
		anims[11047].duration = new int[]
		{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1, 2, 3, 3, 3};
		anims[11047].primary = new int[]
		{217120788, 217120914, 217120812, 217120855, 217120904, 217120856, 217120884, 217120809, 217120817, 217120877, 217120822, 217120854, 217120775, 217120865, 217120846, 217120864, 217120770, 217120900, 217120798, 217120813};

		// -----Animation id: 14264, file: 3313 Revenant dragon block anim
		anims[11038] = new Sequences();
		anims[11038].allowsRotation = false;
		anims[11038].delayType = 2;
		anims[11038].length = 24;
		anims[11038].padding = -1;
		anims[11038].priority1 = 6;
		anims[11038].resetCycle = 99;
		anims[11038].runFlag = 0;
		anims[11038].shield = -1;
		anims[11038].walkFlag = 0;
		anims[11038].weapon = -1;
		anims[11038].duration = new int[]
		{4, 4, 4, 4, 4, 3, 3, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
		anims[11038].primary = new int[]
		{
			217120806,
			217120823,
			217120779,
			217120826,
			217120861,
			217120870,
			217120838,
			217120909,
			217120804,
			217120873,
			217120786,
			217120797,
			217120769,
			217120810,
			217120887,
			217120902,
			217120829,
			217120881,
			217120831,
			217120852,
			217120828,
			217120833,
			217120820,
			217120791};

		// -----Animation id: 14265, file: 3313 Revenant dragon death anim
		anims[11039] = new Sequences();
		anims[11039].allowsRotation = false;
		anims[11039].delayType = 2;
		anims[11039].length = 13;
		anims[11039].padding = -1;
		anims[11039].priority1 = 10;
		anims[11039].resetCycle = 99;
		anims[11039].runFlag = 0;
		anims[11039].shield = -1;
		anims[11039].walkFlag = 0;
		anims[11039].weapon = -1;
		anims[11039].duration = new int[]
		{5, 3, 4, 3, 4, 3, 5, 5, 5, 5, 13, 10, 5};
		anims[11039].primary = new int[]
		{217120868, 217120917, 217120848, 217120816, 217120875, 217120872, 217120818, 217120908, 217120869, 217120860, 217120796, 217120843, 217120807};

		// Dragon claws special attack.
		anims[7527].runFlag = 2; // Can run and animation will continue
		anims[7527].walkFlag = 2; // Can walk and animation will continue
		anims[7527].priority1 = 6; // It waits untill this animation is completed before performing another animation.

		// Sitting down, extending the sitting down part animation repeat.
		anims[3363].duration[4] = 100000;


		// Herblore animation fix.
		anims[363].weapon = 515;

		// Woodcutting animation loop cheap fix, the original delayType was 1, but because wc is a 1 tick cycle,
		//the animation was spammed and looked silly.
		anims[2846].delayType = 2; // Dragon
		anims[879].delayType = 2; // Bronze
		anims[877].delayType = 2; // Iron
		anims[875].delayType = 2; // Steel
		anims[873].delayType = 2; // Black
		anims[871].delayType = 2; // Mithril
		anims[869].delayType = 2; // Adamant
		anims[867].delayType = 2; // Rune
		anims[2117].delayType = 2; // Infernal
		anims[7264].delayType = 2; // 3rd age

		// -----Animation id: 7466, file: 1887 hellhound walk animation
		anims[11031] = new Sequences();
		anims[11031].allowsRotation = false;
		anims[11031].delayType = 2;
		anims[11031].length = 8;
		anims[11031].padding = -1;
		anims[11031].priority1 = 5;
		anims[11031].resetCycle = 99;
		anims[11031].runFlag = 0;
		anims[11031].shield = -1;
		anims[11031].walkFlag = 0;
		anims[11031].weapon = -1;
		anims[11031].duration = new int[8];
		anims[11031].duration[0] = 5;
		anims[11031].duration[1] = 5;
		anims[11031].duration[2] = 5;
		anims[11031].duration[3] = 5;
		anims[11031].duration[4] = 5;
		anims[11031].duration[5] = 5;
		anims[11031].duration[6] = 5;
		anims[11031].duration[7] = 5;
		anims[11031].primary = new int[8];
		anims[11031].primary[0] = 123666569;
		anims[11031].primary[1] = 123666464;
		anims[11031].primary[2] = 123666603;
		anims[11031].primary[3] = 123666442;
		anims[11031].primary[4] = 123666628;
		anims[11031].primary[5] = 123666440;
		anims[11031].primary[6] = 123666502;
		anims[11031].primary[7] = 123666433;

		// -----Animation id: 7465, file: 1887 hellhound stand animation
		anims[11030] = new Sequences();
		anims[11030].allowsRotation = false;
		anims[11030].delayType = 2;
		anims[11030].length = 16;
		anims[11030].padding = -1;
		anims[11030].priority1 = 5;
		anims[11030].resetCycle = 99;
		anims[11030].runFlag = 0;
		anims[11030].shield = -1;
		anims[11030].walkFlag = 0;
		anims[11030].weapon = -1;
		anims[11030].duration = new int[16];
		anims[11030].duration[0] = 5;
		anims[11030].duration[1] = 5;
		anims[11030].duration[2] = 5;
		anims[11030].duration[3] = 5;
		anims[11030].duration[4] = 5;
		anims[11030].duration[5] = 5;
		anims[11030].duration[6] = 5;
		anims[11030].duration[7] = 5;
		anims[11030].duration[8] = 5;
		anims[11030].duration[9] = 5;
		anims[11030].duration[10] = 5;
		anims[11030].duration[11] = 5;
		anims[11030].duration[12] = 5;
		anims[11030].duration[13] = 5;
		anims[11030].duration[14] = 5;
		anims[11030].duration[15] = 5;
		anims[11030].primary = new int[16];
		anims[11030].primary[0] = 123666489;
		anims[11030].primary[1] = 123666455;
		anims[11030].primary[2] = 123666576;
		anims[11030].primary[3] = 123666520;
		anims[11030].primary[4] = 123666477;
		anims[11030].primary[5] = 123666566;
		anims[11030].primary[6] = 123666475;
		anims[11030].primary[7] = 123666549;
		anims[11030].primary[8] = 123666496;
		anims[11030].primary[9] = 123666493;
		anims[11030].primary[10] = 123666506;
		anims[11030].primary[11] = 123666545;
		anims[11030].primary[12] = 123666640;
		anims[11030].primary[13] = 123666507;
		anims[11030].primary[14] = 123666479;
		anims[11030].primary[15] = 123666571;

		// -----Animation id: 7462, file: 1887 hellhound block animation
		anims[11029] = new Sequences();
		anims[11029].allowsRotation = false;
		anims[11029].delayType = 2;
		anims[11029].length = 14;
		anims[11029].padding = -1;
		anims[11029].priority1 = 6;
		anims[11029].resetCycle = 99;
		anims[11029].runFlag = 0;
		anims[11029].shield = -1;
		anims[11029].walkFlag = 0;
		anims[11029].weapon = -1;
		anims[11029].duration = new int[14];
		anims[11029].duration[0] = 3;
		anims[11029].duration[1] = 3;
		anims[11029].duration[2] = 3;
		anims[11029].duration[3] = 3;
		anims[11029].duration[4] = 3;
		anims[11029].duration[5] = 3;
		anims[11029].duration[6] = 3;
		anims[11029].duration[7] = 3;
		anims[11029].duration[8] = 3;
		anims[11029].duration[9] = 3;
		anims[11029].duration[10] = 3;
		anims[11029].duration[11] = 3;
		anims[11029].duration[12] = 3;
		anims[11029].duration[13] = 3;
		anims[11029].primary = new int[14];
		anims[11029].primary[0] = 123666642;
		anims[11029].primary[1] = 123666486;
		anims[11029].primary[2] = 123666523;
		anims[11029].primary[3] = 123666501;
		anims[11029].primary[4] = 123666650;
		anims[11029].primary[5] = 123666483;
		anims[11029].primary[6] = 123666503;
		anims[11029].primary[7] = 123666439;
		anims[11029].primary[8] = 123666531;
		anims[11029].primary[9] = 123666485;
		anims[11029].primary[10] = 123666488;
		anims[11029].primary[11] = 123666437;
		anims[11029].primary[12] = 123666638;
		anims[11029].primary[13] = 123666642;

		// -----Animation id: 7461, file: 1887 hellhound death animation
		anims[11028] = new Sequences();
		anims[11028].allowsRotation = false;
		anims[11028].delayType = 2;
		anims[11028].length = 23;
		anims[11028].padding = -1;
		anims[11028].priority1 = 10;
		anims[11028].resetCycle = 99;
		anims[11028].runFlag = 0;
		anims[11028].shield = -1;
		anims[11028].walkFlag = 0;
		anims[11028].weapon = -1;
		anims[11028].duration = new int[23];
		anims[11028].duration[0] = 4;
		anims[11028].duration[1] = 4;
		anims[11028].duration[2] = 4;
		anims[11028].duration[3] = 4;
		anims[11028].duration[4] = 4;
		anims[11028].duration[5] = 4;
		anims[11028].duration[6] = 4;
		anims[11028].duration[7] = 3;
		anims[11028].duration[8] = 3;
		anims[11028].duration[9] = 3;
		anims[11028].duration[10] = 3;
		anims[11028].duration[11] = 3;
		anims[11028].duration[12] = 3;
		anims[11028].duration[13] = 3;
		anims[11028].duration[14] = 3;
		anims[11028].duration[15] = 3;
		anims[11028].duration[16] = 3;
		anims[11028].duration[17] = 3;
		anims[11028].duration[18] = 3;
		anims[11028].duration[19] = 3;
		anims[11028].duration[20] = 3;
		anims[11028].duration[21] = 3;
		anims[11028].duration[22] = 244;
		anims[11028].primary = new int[23];
		anims[11028].primary[0] = 123666643;
		anims[11028].primary[1] = 123666614;
		anims[11028].primary[2] = 123666546;
		anims[11028].primary[3] = 123666639;
		anims[11028].primary[4] = 123666606;
		anims[11028].primary[5] = 123666548;
		anims[11028].primary[6] = 123666567;
		anims[11028].primary[7] = 123666470;
		anims[11028].primary[8] = 123666613;
		anims[11028].primary[9] = 123666562;
		anims[11028].primary[10] = 123666472;
		anims[11028].primary[11] = 123666644;
		anims[11028].primary[12] = 123666648;
		anims[11028].primary[13] = 123666476;
		anims[11028].primary[14] = 123666618;
		anims[11028].primary[15] = 123666529;
		anims[11028].primary[16] = 123666593;
		anims[11028].primary[17] = 123666573;
		anims[11028].primary[18] = 123666589;
		anims[11028].primary[19] = 123666601;
		anims[11028].primary[20] = 123666554;
		anims[11028].primary[21] = 123666438;
		anims[11028].primary[22] = 123666609;

		// -----Animation id: 7460, file: 1887 hellhound attack
		anims[11027] = new Sequences();
		anims[11027].allowsRotation = false;
		anims[11027].delayType = 2;
		anims[11027].length = 13;
		anims[11027].padding = -1;
		anims[11027].priority1 = 7;
		anims[11027].resetCycle = 99;
		anims[11027].runFlag = 0;
		anims[11027].shield = -1;
		anims[11027].walkFlag = 0;
		anims[11027].weapon = -1;
		anims[11027].duration = new int[13];
		anims[11027].duration[0] = 5;
		anims[11027].duration[1] = 5;
		anims[11027].duration[2] = 5;
		anims[11027].duration[3] = 3;
		anims[11027].duration[4] = 3;
		anims[11027].duration[5] = 3;
		anims[11027].duration[6] = 3;
		anims[11027].duration[7] = 3;
		anims[11027].duration[8] = 5;
		anims[11027].duration[9] = 5;
		anims[11027].duration[10] = 5;
		anims[11027].duration[11] = 5;
		anims[11027].duration[12] = 5;
		anims[11027].primary = new int[13];
		anims[11027].primary[0] = 123666509;
		anims[11027].primary[1] = 123666542;
		anims[11027].primary[2] = 123666633;
		anims[11027].primary[3] = 123666578;
		anims[11027].primary[4] = 123666494;
		anims[11027].primary[5] = 123666552;
		anims[11027].primary[6] = 123666537;
		anims[11027].primary[7] = 123666561;
		anims[11027].primary[8] = 123666457;
		anims[11027].primary[9] = 123666625;
		anims[11027].primary[10] = 123666471;
		anims[11027].primary[11] = 123666521;
		anims[11027].primary[12] = 123666509;

		// -----Animation id: 7469, file: 1887 dark beast block
		anims[11026] = new Sequences();
		anims[11026].allowsRotation = false;
		anims[11026].delayType = 2;
		anims[11026].length = 14;
		anims[11026].padding = -1;
		anims[11026].priority1 = 6;
		anims[11026].resetCycle = 99;
		anims[11026].runFlag = 0;
		anims[11026].shield = -1;
		anims[11026].walkFlag = 0;
		anims[11026].weapon = -1;
		anims[11026].duration = new int[14];
		anims[11026].duration[0] = 3;
		anims[11026].duration[1] = 3;
		anims[11026].duration[2] = 3;
		anims[11026].duration[3] = 3;
		anims[11026].duration[4] = 3;
		anims[11026].duration[5] = 3;
		anims[11026].duration[6] = 3;
		anims[11026].duration[7] = 3;
		anims[11026].duration[8] = 3;
		anims[11026].duration[9] = 3;
		anims[11026].duration[10] = 3;
		anims[11026].duration[11] = 3;
		anims[11026].duration[12] = 3;
		anims[11026].duration[13] = 3;
		anims[11026].primary = new int[14];
		anims[11026].primary[0] = 123666610;
		anims[11026].primary[1] = 123666505;
		anims[11026].primary[2] = 123666474;
		anims[11026].primary[3] = 123666467;
		anims[11026].primary[4] = 123666512;
		anims[11026].primary[5] = 123666598;
		anims[11026].primary[6] = 123666649;
		anims[11026].primary[7] = 123666459;
		anims[11026].primary[8] = 123666484;
		anims[11026].primary[9] = 123666624;
		anims[11026].primary[10] = 123666480;
		anims[11026].primary[11] = 123666645;
		anims[11026].primary[12] = 123666636;
		anims[11026].primary[13] = 123666610;

		// -----Animation id: 7415, file: 1893 ork walk animation
		anims[11025] = new Sequences();
		anims[11025].allowsRotation = false;
		anims[11025].delayType = 2;
		anims[11025].length = 16;
		anims[11025].padding = -1;
		anims[11025].priority1 = 5;
		anims[11025].resetCycle = 99;
		anims[11025].runFlag = 0;
		anims[11025].shield = -1;
		anims[11025].walkFlag = 0;
		anims[11025].weapon = -1;
		anims[11025].duration = new int[16];
		anims[11025].duration[0] = 3;
		anims[11025].duration[1] = 3;
		anims[11025].duration[2] = 3;
		anims[11025].duration[3] = 3;
		anims[11025].duration[4] = 3;
		anims[11025].duration[5] = 3;
		anims[11025].duration[6] = 3;
		anims[11025].duration[7] = 3;
		anims[11025].duration[8] = 3;
		anims[11025].duration[9] = 3;
		anims[11025].duration[10] = 3;
		anims[11025].duration[11] = 3;
		anims[11025].duration[12] = 3;
		anims[11025].duration[13] = 3;
		anims[11025].duration[14] = 3;
		anims[11025].duration[15] = 3;
		anims[11025].primary = new int[16];
		anims[11025].primary[0] = 124059740;
		anims[11025].primary[1] = 124059700;
		anims[11025].primary[2] = 124059709;
		anims[11025].primary[3] = 124059713;
		anims[11025].primary[4] = 124059693;
		anims[11025].primary[5] = 124059736;
		anims[11025].primary[6] = 124059750;
		anims[11025].primary[7] = 124059732;
		anims[11025].primary[8] = 124059716;
		anims[11025].primary[9] = 124059724;
		anims[11025].primary[10] = 124059666;
		anims[11025].primary[11] = 124059668;
		anims[11025].primary[12] = 124059660;
		anims[11025].primary[13] = 124059722;
		anims[11025].primary[14] = 124059729;
		anims[11025].primary[15] = 124059703;

		// -----Animation id: 7414, file: 1893 ork stand animation
		anims[11024] = new Sequences();
		anims[11024].allowsRotation = false;
		anims[11024].delayType = 2;
		anims[11024].length = 16;
		anims[11024].padding = -1;
		anims[11024].priority1 = 5;
		anims[11024].resetCycle = 99;
		anims[11024].runFlag = 0;
		anims[11024].shield = -1;
		anims[11024].walkFlag = 0;
		anims[11024].weapon = -1;
		anims[11024].duration = new int[16];
		anims[11024].duration[0] = 3;
		anims[11024].duration[1] = 3;
		anims[11024].duration[2] = 3;
		anims[11024].duration[3] = 3;
		anims[11024].duration[4] = 3;
		anims[11024].duration[5] = 3;
		anims[11024].duration[6] = 3;
		anims[11024].duration[7] = 3;
		anims[11024].duration[8] = 3;
		anims[11024].duration[9] = 3;
		anims[11024].duration[10] = 3;
		anims[11024].duration[11] = 3;
		anims[11024].duration[12] = 3;
		anims[11024].duration[13] = 3;
		anims[11024].duration[14] = 3;
		anims[11024].duration[15] = 3;
		anims[11024].primary = new int[16];
		anims[11024].primary[0] = 124059648;
		anims[11024].primary[1] = 124059728;
		anims[11024].primary[2] = 124059748;
		anims[11024].primary[3] = 124059746;
		anims[11024].primary[4] = 124059690;
		anims[11024].primary[5] = 124059670;
		anims[11024].primary[6] = 124059711;
		anims[11024].primary[7] = 124059657;
		anims[11024].primary[8] = 124059739;
		anims[11024].primary[9] = 124059717;
		anims[11024].primary[10] = 124059679;
		anims[11024].primary[11] = 124059741;
		anims[11024].primary[12] = 124059669;
		anims[11024].primary[13] = 124059683;
		anims[11024].primary[14] = 124059752;
		anims[11024].primary[15] = 124059664;

		// -----Animation id: 7412, file: 1893 ork death animation
		anims[11023] = new Sequences();
		anims[11023].allowsRotation = false;
		anims[11023].delayType = 2;
		anims[11023].length = 13;
		anims[11023].padding = -1;
		anims[11023].priority1 = 10;
		anims[11023].resetCycle = 99;
		anims[11023].runFlag = 0;
		anims[11023].shield = -1;
		anims[11023].walkFlag = 0;
		anims[11023].weapon = -1;
		anims[11023].duration = new int[13];
		anims[11023].duration[0] = 3;
		anims[11023].duration[1] = 3;
		anims[11023].duration[2] = 3;
		anims[11023].duration[3] = 3;
		anims[11023].duration[4] = 3;
		anims[11023].duration[5] = 3;
		anims[11023].duration[6] = 3;
		anims[11023].duration[7] = 3;
		anims[11023].duration[8] = 3;
		anims[11023].duration[9] = 3;
		anims[11023].duration[10] = 3;
		anims[11023].duration[11] = 3;
		anims[11023].duration[12] = 44;
		anims[11023].primary = new int[13];
		anims[11023].primary[0] = 124059667;
		anims[11023].primary[1] = 124059704;
		anims[11023].primary[2] = 124059659;
		anims[11023].primary[3] = 124059698;
		anims[11023].primary[4] = 124059687;
		anims[11023].primary[5] = 124059726;
		anims[11023].primary[6] = 124059653;
		anims[11023].primary[7] = 124059682;
		anims[11023].primary[8] = 124059658;
		anims[11023].primary[9] = 124059676;
		anims[11023].primary[10] = 124059719;
		anims[11023].primary[11] = 124059710;
		anims[11023].primary[12] = 124059749;

		// -----Animation id: 7411, file: 1893 ork attack animation
		anims[11022] = new Sequences();
		anims[11022].allowsRotation = false;
		anims[11022].delayType = 2;
		anims[11022].length = 11;
		anims[11022].padding = -1;
		anims[11022].priority1 = 7;
		anims[11022].resetCycle = 99;
		anims[11022].runFlag = 0;
		anims[11022].shield = -1;
		anims[11022].walkFlag = 0;
		anims[11022].weapon = -1;
		anims[11022].duration = new int[11];
		anims[11022].duration[0] = 3;
		anims[11022].duration[1] = 3;
		anims[11022].duration[2] = 3;
		anims[11022].duration[3] = 3;
		anims[11022].duration[4] = 3;
		anims[11022].duration[5] = 3;
		anims[11022].duration[6] = 3;
		anims[11022].duration[7] = 3;
		anims[11022].duration[8] = 3;
		anims[11022].duration[9] = 3;
		anims[11022].duration[10] = 3;
		anims[11022].primary = new int[11];
		anims[11022].primary[0] = 124059654;
		anims[11022].primary[1] = 124059651;
		anims[11022].primary[2] = 124059727;
		anims[11022].primary[3] = 124059702;
		anims[11022].primary[4] = 124059705;
		anims[11022].primary[5] = 124059694;
		anims[11022].primary[6] = 124059678;
		anims[11022].primary[7] = 124059650;
		anims[11022].primary[8] = 124059714;
		anims[11022].primary[9] = 124059701;
		anims[11022].primary[10] = 124059692;

		anims[7533].weapon = 6210; //donator emote dds

		anims[7534].weapon = 6210;
		anims[7534].shield = 13466;

		anims[7535].weapon = 6210;
		anims[7535].shield = 13466;

		// -----Animation id: 7468, file: 1887 dark beast death
		anims[11021] = new Sequences();
		anims[11021].allowsRotation = false;
		anims[11021].delayType = 2;
		anims[11021].length = 23;
		anims[11021].padding = -1;
		anims[11021].priority1 = 10;
		anims[11021].resetCycle = 99;
		anims[11021].runFlag = 0;
		anims[11021].shield = -1;
		anims[11021].walkFlag = 0;
		anims[11021].weapon = -1;
		anims[11021].duration = new int[23];
		anims[11021].duration[0] = 4;
		anims[11021].duration[1] = 4;
		anims[11021].duration[2] = 4;
		anims[11021].duration[3] = 4;
		anims[11021].duration[4] = 4;
		anims[11021].duration[5] = 4;
		anims[11021].duration[6] = 4;
		anims[11021].duration[7] = 3;
		anims[11021].duration[8] = 3;
		anims[11021].duration[9] = 3;
		anims[11021].duration[10] = 3;
		anims[11021].duration[11] = 3;
		anims[11021].duration[12] = 3;
		anims[11021].duration[13] = 3;
		anims[11021].duration[14] = 3;
		anims[11021].duration[15] = 3;
		anims[11021].duration[16] = 3;
		anims[11021].duration[17] = 3;
		anims[11021].duration[18] = 3;
		anims[11021].duration[19] = 3;
		anims[11021].duration[20] = 3;
		anims[11021].duration[21] = 3;
		anims[11021].duration[22] = 244;
		anims[11021].primary = new int[23];
		anims[11021].primary[0] = 123666460;
		anims[11021].primary[1] = 123666632;
		anims[11021].primary[2] = 123666572;
		anims[11021].primary[3] = 123666565;
		anims[11021].primary[4] = 123666468;
		anims[11021].primary[5] = 123666597;
		anims[11021].primary[6] = 123666616;
		anims[11021].primary[7] = 123666535;
		anims[11021].primary[8] = 123666596;
		anims[11021].primary[9] = 123666469;
		anims[11021].primary[10] = 123666533;
		anims[11021].primary[11] = 123666599;
		anims[11021].primary[12] = 123666551;
		anims[11021].primary[13] = 123666579;
		anims[11021].primary[14] = 123666445;
		anims[11021].primary[15] = 123666584;
		anims[11021].primary[16] = 123666553;
		anims[11021].primary[17] = 123666514;
		anims[11021].primary[18] = 123666510;
		anims[11021].primary[19] = 123666539;
		anims[11021].primary[20] = 123666556;
		anims[11021].primary[21] = 123666482;
		anims[11021].primary[22] = 123666454;

		// -----Animation id: 7467, file: 1887 dark beast attack animation
		anims[11020] = new Sequences();
		anims[11020].allowsRotation = false;
		anims[11020].delayType = 2;
		anims[11020].length = 13;
		anims[11020].padding = -1;
		anims[11020].priority1 = 7;
		anims[11020].resetCycle = 99;
		anims[11020].runFlag = 0;
		anims[11020].shield = -1;
		anims[11020].walkFlag = 0;
		anims[11020].weapon = -1;
		anims[11020].duration = new int[13];
		anims[11020].duration[0] = 5;
		anims[11020].duration[1] = 5;
		anims[11020].duration[2] = 5;
		anims[11020].duration[3] = 3;
		anims[11020].duration[4] = 3;
		anims[11020].duration[5] = 3;
		anims[11020].duration[6] = 3;
		anims[11020].duration[7] = 3;
		anims[11020].duration[8] = 5;
		anims[11020].duration[9] = 5;
		anims[11020].duration[10] = 5;
		anims[11020].duration[11] = 5;
		anims[11020].duration[12] = 5;
		anims[11020].primary = new int[13];
		anims[11020].primary[0] = 123666634;
		anims[11020].primary[1] = 123666626;
		anims[11020].primary[2] = 123666530;
		anims[11020].primary[3] = 123666516;
		anims[11020].primary[4] = 123666478;
		anims[11020].primary[5] = 123666522;
		anims[11020].primary[6] = 123666630;
		anims[11020].primary[7] = 123666594;
		anims[11020].primary[8] = 123666563;
		anims[11020].primary[9] = 123666541;
		anims[11020].primary[10] = 123666629;
		anims[11020].primary[11] = 123666568;
		anims[11020].primary[12] = 123666634;

		// -----Animation id: 7413, file: 1893 ork block animation
		anims[11019] = new Sequences();
		anims[11019].allowsRotation = false;
		anims[11019].delayType = 2;
		anims[11019].length = 13;
		anims[11019].padding = -1;
		anims[11019].priority1 = 6;
		anims[11019].resetCycle = 99;
		anims[11019].runFlag = 0;
		anims[11019].shield = -1;
		anims[11019].walkFlag = 0;
		anims[11019].weapon = -1;
		anims[11019].duration = new int[13];
		anims[11019].duration[0] = 3;
		anims[11019].duration[1] = 3;
		anims[11019].duration[2] = 3;
		anims[11019].duration[3] = 3;
		anims[11019].duration[4] = 3;
		anims[11019].duration[5] = 3;
		anims[11019].duration[6] = 3;
		anims[11019].duration[7] = 4;
		anims[11019].duration[8] = 3;
		anims[11019].duration[9] = 3;
		anims[11019].duration[10] = 3;
		anims[11019].duration[11] = 3;
		anims[11019].duration[12] = 3;
		anims[11019].primary = new int[13];
		anims[11019].primary[0] = 124059674;
		anims[11019].primary[1] = 124059745;
		anims[11019].primary[2] = 124059756;
		anims[11019].primary[3] = 124059718;
		anims[11019].primary[4] = 124059671;
		anims[11019].primary[5] = 124059743;
		anims[11019].primary[6] = 124059675;
		anims[11019].primary[7] = 124059655;
		anims[11019].primary[8] = 124059731;
		anims[11019].primary[9] = 124059665;
		anims[11019].primary[10] = 124059723;
		anims[11019].primary[11] = 124059734;
		anims[11019].primary[12] = 124059662;

		// -----Animation id: 7473, file: 1887 dark beast walk animation
		anims[11018] = new Sequences();
		anims[11018].allowsRotation = false;
		anims[11018].delayType = 2;
		anims[11018].length = 8;
		anims[11018].padding = -1;
		anims[11018].priority1 = 5;
		anims[11018].resetCycle = 99;
		anims[11018].runFlag = 0;
		anims[11018].shield = -1;
		anims[11018].walkFlag = 0;
		anims[11018].weapon = -1;
		anims[11018].duration = new int[8];
		anims[11018].duration[0] = 5;
		anims[11018].duration[1] = 5;
		anims[11018].duration[2] = 5;
		anims[11018].duration[3] = 5;
		anims[11018].duration[4] = 5;
		anims[11018].duration[5] = 5;
		anims[11018].duration[6] = 5;
		anims[11018].duration[7] = 5;
		anims[11018].primary = new int[8];
		anims[11018].primary[0] = 123666641;
		anims[11018].primary[1] = 123666612;
		anims[11018].primary[2] = 123666443;
		anims[11018].primary[3] = 123666577;
		anims[11018].primary[4] = 123666543;
		anims[11018].primary[5] = 123666620;
		anims[11018].primary[6] = 123666605;
		anims[11018].primary[7] = 123666574;

		// -----Animation id: 7472, file: 1887 dark beast stand animation
		anims[11017] = new Sequences();
		anims[11017].allowsRotation = false;
		anims[11017].delayType = 2;
		anims[11017].length = 16;
		anims[11017].padding = -1;
		anims[11017].priority1 = 5;
		anims[11017].resetCycle = 99;
		anims[11017].runFlag = 0;
		anims[11017].shield = -1;
		anims[11017].walkFlag = 0;
		anims[11017].weapon = -1;
		anims[11017].duration = new int[16];
		anims[11017].duration[0] = 5;
		anims[11017].duration[1] = 5;
		anims[11017].duration[2] = 5;
		anims[11017].duration[3] = 5;
		anims[11017].duration[4] = 5;
		anims[11017].duration[5] = 5;
		anims[11017].duration[6] = 5;
		anims[11017].duration[7] = 5;
		anims[11017].duration[8] = 5;
		anims[11017].duration[9] = 5;
		anims[11017].duration[10] = 5;
		anims[11017].duration[11] = 5;
		anims[11017].duration[12] = 5;
		anims[11017].duration[13] = 5;
		anims[11017].duration[14] = 5;
		anims[11017].duration[15] = 5;
		anims[11017].primary = new int[16];
		anims[11017].primary[0] = 123666587;
		anims[11017].primary[1] = 123666511;
		anims[11017].primary[2] = 123666444;
		anims[11017].primary[3] = 123666611;
		anims[11017].primary[4] = 123666481;
		anims[11017].primary[5] = 123666500;
		anims[11017].primary[6] = 123666473;
		anims[11017].primary[7] = 123666647;
		anims[11017].primary[8] = 123666441;
		anims[11017].primary[9] = 123666434;
		anims[11017].primary[10] = 123666637;
		anims[11017].primary[11] = 123666627;
		anims[11017].primary[12] = 123666450;
		anims[11017].primary[13] = 123666564;
		anims[11017].primary[14] = 123666592;
		anims[11017].primary[15] = 123666544;

		//Td magic projectile animation
		anims[11016] = new Sequences();
		anims[11016].allowsRotation = false;
		anims[11016].delayType = 2;
		anims[11016].length = 15;
		anims[11016].padding = -1;
		anims[11016].priority1 = 5;
		anims[11016].resetCycle = 99;
		anims[11016].runFlag = 0;
		anims[11016].shield = -1;
		anims[11016].walkFlag = 0;
		anims[11016].weapon = -1;
		anims[11016].duration = new int[15];
		anims[11016].duration[0] = 1;
		anims[11016].duration[1] = 1;
		anims[11016].duration[2] = 1;
		anims[11016].duration[3] = 1;
		anims[11016].duration[4] = 1;
		anims[11016].duration[5] = 1;
		anims[11016].duration[6] = 1;
		anims[11016].duration[7] = 1;
		anims[11016].duration[8] = 1;
		anims[11016].duration[9] = 1;
		anims[11016].duration[10] = 1;
		anims[11016].duration[11] = 1;
		anims[11016].duration[12] = 1;
		anims[11016].duration[13] = 1;
		anims[11016].duration[14] = 1;
		anims[11016].primary = new int[15];
		anims[11016].primary[0] = 174915594;
		anims[11016].primary[1] = 174915592;
		anims[11016].primary[2] = 174915585;
		anims[11016].primary[3] = 174915586;
		anims[11016].primary[4] = 174915596;
		anims[11016].primary[5] = 174915590;
		anims[11016].primary[6] = 174915598;
		anims[11016].primary[7] = 174915591;
		anims[11016].primary[8] = 174915593;
		anims[11016].primary[9] = 174915589;
		anims[11016].primary[10] = 174915584;
		anims[11016].primary[11] = 174915597;
		anims[11016].primary[12] = 174915588;
		anims[11016].primary[13] = 174915595;
		anims[11016].primary[14] = 174915587;

		// Td melee gfx animation
		anims[11015] = new Sequences();
		anims[11015].allowsRotation = false;
		anims[11015].delayType = 2;
		anims[11015].length = 12;
		anims[11015].padding = -1;
		anims[11015].priority1 = 5;
		anims[11015].resetCycle = 99;
		anims[11015].runFlag = 0;
		anims[11015].shield = -1;
		anims[11015].walkFlag = 0;
		anims[11015].weapon = -1;
		anims[11015].duration = new int[12];
		anims[11015].duration[0] = 30;
		anims[11015].duration[1] = 5;
		anims[11015].duration[2] = 3;
		anims[11015].duration[3] = 3;
		anims[11015].duration[4] = 2;
		anims[11015].duration[5] = 2;
		anims[11015].duration[6] = 2;
		anims[11015].duration[7] = 2;
		anims[11015].duration[8] = 2;
		anims[11015].duration[9] = 2;
		anims[11015].duration[10] = 2;
		anims[11015].duration[11] = 2;
		anims[11015].primary = new int[12];
		anims[11015].primary[0] = 173408267;
		anims[11015].primary[1] = 173408259;
		anims[11015].primary[2] = 173408260;
		anims[11015].primary[3] = 173408265;
		anims[11015].primary[4] = 173408256;
		anims[11015].primary[5] = 173408263;
		anims[11015].primary[6] = 173408264;
		anims[11015].primary[7] = 173408262;
		anims[11015].primary[8] = 173408258;
		anims[11015].primary[9] = 173408257;
		anims[11015].primary[10] = 173408266;
		anims[11015].primary[11] = 173408261;

		// Td ranged projectile animation
		anims[11014] = new Sequences();
		anims[11014].allowsRotation = false;
		anims[11014].delayType = 2;
		anims[11014].length = 8;
		anims[11014].padding = -1;
		anims[11014].priority1 = 5;
		anims[11014].resetCycle = 99;
		anims[11014].runFlag = 0;
		anims[11014].shield = -1;
		anims[11014].walkFlag = 0;
		anims[11014].weapon = -1;
		anims[11014].duration = new int[8];
		anims[11014].duration[0] = 3;
		anims[11014].duration[1] = 3;
		anims[11014].duration[2] = 3;
		anims[11014].duration[3] = 3;
		anims[11014].duration[4] = 3;
		anims[11014].duration[5] = 3;
		anims[11014].duration[6] = 3;
		anims[11014].duration[7] = 3;
		anims[11014].primary = new int[8];
		anims[11014].primary[0] = 174325762;
		anims[11014].primary[1] = 174325761;
		anims[11014].primary[2] = 174325765;
		anims[11014].primary[3] = 174325766;
		anims[11014].primary[4] = 174325763;
		anims[11014].primary[5] = 174325760;
		anims[11014].primary[6] = 174325767;
		anims[11014].primary[7] = 174325764;

		// Td melee
		anims[11013] = new Sequences();
		anims[11013].allowsRotation = false;
		anims[11013].delayType = 2;
		anims[11013].length = 16;
		anims[11013].padding = -1;
		anims[11013].priority1 = 6;
		anims[11013].resetCycle = 99;
		anims[11013].runFlag = 0;
		anims[11013].shield = -1;
		anims[11013].walkFlag = 0;
		anims[11013].weapon = -1;
		anims[11013].duration = new int[16];
		anims[11013].duration[0] = 3;
		anims[11013].duration[1] = 3;
		anims[11013].duration[2] = 3;
		anims[11013].duration[3] = 3;
		anims[11013].duration[4] = 3;
		anims[11013].duration[5] = 3;
		anims[11013].duration[6] = 3;
		anims[11013].duration[7] = 3;
		anims[11013].duration[8] = 3;
		anims[11013].duration[9] = 3;
		anims[11013].duration[10] = 5;
		anims[11013].duration[11] = 3;
		anims[11013].duration[12] = 3;
		anims[11013].duration[13] = 3;
		anims[11013].duration[14] = 3;
		anims[11013].duration[15] = 3;
		anims[11013].primary = new int[16];
		anims[11013].primary[0] = 175767831;
		anims[11013].primary[1] = 175767806;
		anims[11013].primary[2] = 175767786;
		anims[11013].primary[3] = 175767597;
		anims[11013].primary[4] = 175767579;
		anims[11013].primary[5] = 175767809;
		anims[11013].primary[6] = 175767741;
		anims[11013].primary[7] = 175767822;
		anims[11013].primary[8] = 175767765;
		anims[11013].primary[9] = 175767762;
		anims[11013].primary[10] = 175767775;
		anims[11013].primary[11] = 175767810;
		anims[11013].primary[12] = 175767647;
		anims[11013].primary[13] = 175767779;
		anims[11013].primary[14] = 175767714;
		anims[11013].primary[15] = 175767831;

		// Td ranged
		anims[11012] = new Sequences();
		anims[11012].allowsRotation = false;
		anims[11012].delayType = 2;
		anims[11012].length = 13;
		anims[11012].padding = -1;
		anims[11012].priority1 = 5;
		anims[11012].resetCycle = 99;
		anims[11012].runFlag = 0;
		anims[11012].shield = -1;
		anims[11012].walkFlag = 0;
		anims[11012].weapon = -1;
		anims[11012].duration = new int[13];
		anims[11012].duration[0] = 3;
		anims[11012].duration[1] = 3;
		anims[11012].duration[2] = 3;
		anims[11012].duration[3] = 3;
		anims[11012].duration[4] = 3;
		anims[11012].duration[5] = 3;
		anims[11012].duration[6] = 3;
		anims[11012].duration[7] = 3;
		anims[11012].duration[8] = 3;
		anims[11012].duration[9] = 3;
		anims[11012].duration[10] = 3;
		anims[11012].duration[11] = 3;
		anims[11012].duration[12] = 3;
		anims[11012].primary = new int[13];
		anims[11012].primary[0] = 175767584;
		anims[11012].primary[1] = 175767678;
		anims[11012].primary[2] = 175767911;
		anims[11012].primary[3] = 175767705;
		anims[11012].primary[4] = 175767667;
		anims[11012].primary[5] = 175767728;
		anims[11012].primary[6] = 175767558;
		anims[11012].primary[7] = 175767871;
		anims[11012].primary[8] = 175767674;
		anims[11012].primary[9] = 175767877;
		anims[11012].primary[10] = 175767884;
		anims[11012].primary[11] = 175767766;
		anims[11012].primary[12] = 175767584;

		// Td magic
		anims[11011] = new Sequences();
		anims[11011].allowsRotation = false;
		anims[11011].delayType = 2;
		anims[11011].length = 28;
		anims[11011].padding = -1;
		anims[11011].priority1 = 5;
		anims[11011].resetCycle = 99;
		anims[11011].runFlag = 0;
		anims[11011].shield = -1;
		anims[11011].walkFlag = 0;
		anims[11011].weapon = -1;
		anims[11011].duration = new int[28];
		anims[11011].duration[0] = 3;
		anims[11011].duration[1] = 3;
		anims[11011].duration[2] = 3;
		anims[11011].duration[3] = 3;
		anims[11011].duration[4] = 3;
		anims[11011].duration[5] = 3;
		anims[11011].duration[6] = 3;
		anims[11011].duration[7] = 3;
		anims[11011].duration[8] = 3;
		anims[11011].duration[9] = 3;
		anims[11011].duration[10] = 3;
		anims[11011].duration[11] = 3;
		anims[11011].duration[12] = 3;
		anims[11011].duration[13] = 3;
		anims[11011].duration[14] = 3;
		anims[11011].duration[15] = 3;
		anims[11011].duration[16] = 3;
		anims[11011].duration[17] = 3;
		anims[11011].duration[18] = 3;
		anims[11011].duration[19] = 3;
		anims[11011].duration[20] = 3;
		anims[11011].duration[21] = 3;
		anims[11011].duration[22] = 3;
		anims[11011].duration[23] = 3;
		anims[11011].duration[24] = 3;
		anims[11011].duration[25] = 3;
		anims[11011].duration[26] = 3;
		anims[11011].duration[27] = 3;
		anims[11011].primary = new int[28];
		anims[11011].primary[0] = 175767864;
		anims[11011].primary[1] = 175767639;
		anims[11011].primary[2] = 175767750;
		anims[11011].primary[3] = 175767659;
		anims[11011].primary[4] = 175767751;
		anims[11011].primary[5] = 175767716;
		anims[11011].primary[6] = 175767839;
		anims[11011].primary[7] = 175767880;
		anims[11011].primary[8] = 175767675;
		anims[11011].primary[9] = 175767900;
		anims[11011].primary[10] = 175767573;
		anims[11011].primary[11] = 175767592;
		anims[11011].primary[12] = 175767760;
		anims[11011].primary[13] = 175767863;
		anims[11011].primary[14] = 175767671;
		anims[11011].primary[15] = 175767643;
		anims[11011].primary[16] = 175767858;
		anims[11011].primary[17] = 175767563;
		anims[11011].primary[18] = 175767702;
		anims[11011].primary[19] = 175767790;
		anims[11011].primary[20] = 175767850;
		anims[11011].primary[21] = 175767620;
		anims[11011].primary[22] = 175767888;
		anims[11011].primary[23] = 175767560;
		anims[11011].primary[24] = 175767695;
		anims[11011].primary[25] = 175767569;
		anims[11011].primary[26] = 175767736;
		anims[11011].primary[27] = 175767604;

		// Td death
		anims[11010] = new Sequences();
		anims[11010].allowsRotation = false;
		anims[11010].delayType = 2;
		anims[11010].length = 44;
		anims[11010].padding = -1;
		anims[11010].priority1 = 10;
		anims[11010].resetCycle = 99;
		anims[11010].runFlag = 0;
		anims[11010].shield = -1;
		anims[11010].walkFlag = 0;
		anims[11010].weapon = -1;
		anims[11010].duration = new int[44];
		anims[11010].duration[0] = 3;
		anims[11010].duration[1] = 3;
		anims[11010].duration[2] = 3;
		anims[11010].duration[3] = 3;
		anims[11010].duration[4] = 3;
		anims[11010].duration[5] = 3;
		anims[11010].duration[6] = 3;
		anims[11010].duration[7] = 3;
		anims[11010].duration[8] = 3;
		anims[11010].duration[9] = 3;
		anims[11010].duration[10] = 3;
		anims[11010].duration[11] = 3;
		anims[11010].duration[12] = 3;
		anims[11010].duration[13] = 3;
		anims[11010].duration[14] = 3;
		anims[11010].duration[15] = 3;
		anims[11010].duration[16] = 3;
		anims[11010].duration[17] = 3;
		anims[11010].duration[18] = 3;
		anims[11010].duration[19] = 3;
		anims[11010].duration[20] = 3;
		anims[11010].duration[21] = 3;
		anims[11010].duration[22] = 3;
		anims[11010].duration[23] = 3;
		anims[11010].duration[24] = 3;
		anims[11010].duration[25] = 3;
		anims[11010].duration[26] = 3;
		anims[11010].duration[27] = 3;
		anims[11010].duration[28] = 3;
		anims[11010].duration[29] = 3;
		anims[11010].duration[30] = 3;
		anims[11010].duration[31] = 3;
		anims[11010].duration[32] = 3;
		anims[11010].duration[33] = 3;
		anims[11010].duration[34] = 3;
		anims[11010].duration[35] = 3;
		anims[11010].duration[36] = 3;
		anims[11010].duration[37] = 3;
		anims[11010].duration[38] = 3;
		anims[11010].duration[39] = 3;
		anims[11010].duration[40] = 40;
		anims[11010].duration[41] = 40;
		anims[11010].duration[42] = 40;
		anims[11010].duration[43] = 24;
		anims[11010].primary = new int[44];
		anims[11010].primary[0] = 175767656;
		anims[11010].primary[1] = 175767819;
		anims[11010].primary[2] = 175767590;
		anims[11010].primary[3] = 175767684;
		anims[11010].primary[4] = 175767593;
		anims[11010].primary[5] = 175767773;
		anims[11010].primary[6] = 175767583;
		anims[11010].primary[7] = 175767625;
		anims[11010].primary[8] = 175767587;
		anims[11010].primary[9] = 175767696;
		anims[11010].primary[10] = 175767783;
		anims[11010].primary[11] = 175767745;
		anims[11010].primary[12] = 175767799;
		anims[11010].primary[13] = 175767623;
		anims[11010].primary[14] = 175767849;
		anims[11010].primary[15] = 175767759;
		anims[11010].primary[16] = 175767672;
		anims[11010].primary[17] = 175767870;
		anims[11010].primary[18] = 175767904;
		anims[11010].primary[19] = 175767577;
		anims[11010].primary[20] = 175767624;
		anims[11010].primary[21] = 175767910;
		anims[11010].primary[22] = 175767611;
		anims[11010].primary[23] = 175767832;
		anims[11010].primary[24] = 175767886;
		anims[11010].primary[25] = 175767651;
		anims[11010].primary[26] = 175767730;
		anims[11010].primary[27] = 175767856;
		anims[11010].primary[28] = 175767785;
		anims[11010].primary[29] = 175767721;
		anims[11010].primary[30] = 175767627;
		anims[11010].primary[31] = 175767694;
		anims[11010].primary[32] = 175767701;
		anims[11010].primary[33] = 175767652;
		anims[11010].primary[34] = 175767683;
		anims[11010].primary[35] = 175767869;
		anims[11010].primary[36] = 175767896;
		anims[11010].primary[37] = 175767662;
		anims[11010].primary[38] = 175767812;
		anims[11010].primary[39] = 175767820;
		anims[11010].primary[40] = 175767638;
		anims[11010].primary[41] = 175767905;
		anims[11010].primary[42] = 175767905;
		anims[11010].primary[43] = 175767905;

		// Td block
		anims[11009] = new Sequences();
		anims[11009].allowsRotation = false;
		anims[11009].delayType = 2;
		anims[11009].length = 30;
		anims[11009].padding = -1;
		anims[11009].priority1 = 5;
		anims[11009].resetCycle = 99;
		anims[11009].runFlag = 0;
		anims[11009].shield = -1;
		anims[11009].walkFlag = 0;
		anims[11009].weapon = -1;
		anims[11009].duration = new int[30];
		anims[11009].duration[0] = 3;
		anims[11009].duration[1] = 3;
		anims[11009].duration[2] = 3;
		anims[11009].duration[3] = 3;
		anims[11009].duration[4] = 3;
		anims[11009].duration[5] = 3;
		anims[11009].duration[6] = 3;
		anims[11009].duration[7] = 3;
		anims[11009].duration[8] = 3;
		anims[11009].duration[9] = 3;
		anims[11009].duration[10] = 3;
		anims[11009].duration[11] = 3;
		anims[11009].duration[12] = 3;
		anims[11009].duration[13] = 3;
		anims[11009].duration[14] = 3;
		anims[11009].duration[15] = 3;
		anims[11009].duration[16] = 3;
		anims[11009].duration[17] = 3;
		anims[11009].duration[18] = 3;
		anims[11009].duration[19] = 3;
		anims[11009].duration[20] = 3;
		anims[11009].duration[21] = 3;
		anims[11009].duration[22] = 3;
		anims[11009].duration[23] = 3;
		anims[11009].duration[24] = 3;
		anims[11009].duration[25] = 3;
		anims[11009].duration[26] = 3;
		anims[11009].duration[27] = 3;
		anims[11009].duration[28] = 3;
		anims[11009].duration[29] = 3;
		anims[11009].primary = new int[30];
		anims[11009].primary[0] = 175767690;
		anims[11009].primary[1] = 175767847;
		anims[11009].primary[2] = 175767908;
		anims[11009].primary[3] = 175767668;
		anims[11009].primary[4] = 175767855;
		anims[11009].primary[5] = 175767570;
		anims[11009].primary[6] = 175767657;
		anims[11009].primary[7] = 175767692;
		anims[11009].primary[8] = 175767637;
		anims[11009].primary[9] = 175767615;
		anims[11009].primary[10] = 175767588;
		anims[11009].primary[11] = 175767851;
		anims[11009].primary[12] = 175767752;
		anims[11009].primary[13] = 175767853;
		anims[11009].primary[14] = 175767571;
		anims[11009].primary[15] = 175767614;
		anims[11009].primary[16] = 175767732;
		anims[11009].primary[17] = 175767553;
		anims[11009].primary[18] = 175767557;
		anims[11009].primary[19] = 175767898;
		anims[11009].primary[20] = 175767720;
		anims[11009].primary[21] = 175767740;
		anims[11009].primary[22] = 175767648;
		anims[11009].primary[23] = 175767866;
		anims[11009].primary[24] = 175767661;
		anims[11009].primary[25] = 175767645;
		anims[11009].primary[26] = 175767691;
		anims[11009].primary[27] = 175767626;
		anims[11009].primary[28] = 175767690;
		anims[11009].primary[29] = 175767748;

		// Td walk animation
		anims[11008] = new Sequences();
		anims[11008].allowsRotation = false;
		anims[11008].delayType = 2;
		anims[11008].length = 32;
		anims[11008].padding = -1;
		anims[11008].priority1 = 5;
		anims[11008].resetCycle = 99;
		anims[11008].runFlag = 0;
		anims[11008].shield = -1;
		anims[11008].walkFlag = 0;
		anims[11008].weapon = -1;
		anims[11008].duration = new int[32];
		anims[11008].duration[0] = 3;
		anims[11008].duration[1] = 3;
		anims[11008].duration[2] = 3;
		anims[11008].duration[3] = 3;
		anims[11008].duration[4] = 3;
		anims[11008].duration[5] = 3;
		anims[11008].duration[6] = 3;
		anims[11008].duration[7] = 3;
		anims[11008].duration[8] = 3;
		anims[11008].duration[9] = 3;
		anims[11008].duration[10] = 3;
		anims[11008].duration[11] = 3;
		anims[11008].duration[12] = 3;
		anims[11008].duration[13] = 3;
		anims[11008].duration[14] = 3;
		anims[11008].duration[15] = 3;
		anims[11008].duration[16] = 3;
		anims[11008].duration[17] = 3;
		anims[11008].duration[18] = 3;
		anims[11008].duration[19] = 3;
		anims[11008].duration[20] = 3;
		anims[11008].duration[21] = 3;
		anims[11008].duration[22] = 3;
		anims[11008].duration[23] = 3;
		anims[11008].duration[24] = 3;
		anims[11008].duration[25] = 3;
		anims[11008].duration[26] = 3;
		anims[11008].duration[27] = 3;
		anims[11008].duration[28] = 3;
		anims[11008].duration[29] = 3;
		anims[11008].duration[30] = 3;
		anims[11008].duration[31] = 3;
		anims[11008].primary = new int[32];
		anims[11008].primary[0] = 175767889;
		anims[11008].primary[1] = 175767621;
		anims[11008].primary[2] = 175767724;
		anims[11008].primary[3] = 175767788;
		anims[11008].primary[4] = 175767787;
		anims[11008].primary[5] = 175767682;
		anims[11008].primary[6] = 175767677;
		anims[11008].primary[7] = 175767605;
		anims[11008].primary[8] = 175767795;
		anims[11008].primary[9] = 175767706;
		anims[11008].primary[10] = 175767738;
		anims[11008].primary[11] = 175767891;
		anims[11008].primary[12] = 175767622;
		anims[11008].primary[13] = 175767833;
		anims[11008].primary[14] = 175767893;
		anims[11008].primary[15] = 175767777;
		anims[11008].primary[16] = 175767554;
		anims[11008].primary[17] = 175767895;
		anims[11008].primary[18] = 175767669;
		anims[11008].primary[19] = 175767883;
		anims[11008].primary[20] = 175767565;
		anims[11008].primary[21] = 175767804;
		anims[11008].primary[22] = 175767798;
		anims[11008].primary[23] = 175767649;
		anims[11008].primary[24] = 175767841;
		anims[11008].primary[25] = 175767641;
		anims[11008].primary[26] = 175767807;
		anims[11008].primary[27] = 175767868;
		anims[11008].primary[28] = 175767756;
		anims[11008].primary[29] = 175767830;
		anims[11008].primary[30] = 175767794;
		anims[11008].primary[31] = 175767664;

		// Td stand animation
		anims[11007] = new Sequences();
		anims[11007].allowsRotation = false;
		anims[11007].delayType = 2;
		anims[11007].length = 32;
		anims[11007].padding = -1;
		anims[11007].priority1 = 5;
		anims[11007].resetCycle = 99;
		anims[11007].runFlag = 0;
		anims[11007].shield = -1;
		anims[11007].walkFlag = 0;
		anims[11007].weapon = -1;
		anims[11007].duration = new int[32];
		anims[11007].duration[0] = 4;
		anims[11007].duration[1] = 4;
		anims[11007].duration[2] = 4;
		anims[11007].duration[3] = 4;
		anims[11007].duration[4] = 4;
		anims[11007].duration[5] = 4;
		anims[11007].duration[6] = 4;
		anims[11007].duration[7] = 4;
		anims[11007].duration[8] = 4;
		anims[11007].duration[9] = 4;
		anims[11007].duration[10] = 4;
		anims[11007].duration[11] = 4;
		anims[11007].duration[12] = 4;
		anims[11007].duration[13] = 4;
		anims[11007].duration[14] = 4;
		anims[11007].duration[15] = 4;
		anims[11007].duration[16] = 4;
		anims[11007].duration[17] = 4;
		anims[11007].duration[18] = 4;
		anims[11007].duration[19] = 4;
		anims[11007].duration[20] = 4;
		anims[11007].duration[21] = 4;
		anims[11007].duration[22] = 4;
		anims[11007].duration[23] = 4;
		anims[11007].duration[24] = 4;
		anims[11007].duration[25] = 4;
		anims[11007].duration[26] = 4;
		anims[11007].duration[27] = 4;
		anims[11007].duration[28] = 4;
		anims[11007].duration[29] = 4;
		anims[11007].duration[30] = 4;
		anims[11007].duration[31] = 4;
		anims[11007].primary = new int[32];
		anims[11007].primary[0] = 175767610;
		anims[11007].primary[1] = 175767660;
		anims[11007].primary[2] = 175767903;
		anims[11007].primary[3] = 175767601;
		anims[11007].primary[4] = 175767816;
		anims[11007].primary[5] = 175767901;
		anims[11007].primary[6] = 175767838;
		anims[11007].primary[7] = 175767578;
		anims[11007].primary[8] = 175767596;
		anims[11007].primary[9] = 175767616;
		anims[11007].primary[10] = 175767774;
		anims[11007].primary[11] = 175767808;
		anims[11007].primary[12] = 175767715;
		anims[11007].primary[13] = 175767782;
		anims[11007].primary[14] = 175767600;
		anims[11007].primary[15] = 175767679;
		anims[11007].primary[16] = 175767610;
		anims[11007].primary[17] = 175767660;
		anims[11007].primary[18] = 175767903;
		anims[11007].primary[19] = 175767601;
		anims[11007].primary[20] = 175767816;
		anims[11007].primary[21] = 175767901;
		anims[11007].primary[22] = 175767838;
		anims[11007].primary[23] = 175767595;
		anims[11007].primary[24] = 175767608;
		anims[11007].primary[25] = 175767612;
		anims[11007].primary[26] = 175767609;
		anims[11007].primary[27] = 175767808;
		anims[11007].primary[28] = 175767715;
		anims[11007].primary[29] = 175767782;
		anims[11007].primary[30] = 175767600;
		anims[11007].primary[31] = 175767679;

		//Ice stryke block
		anims[11006] = new Sequences();
		anims[11006].allowsRotation = false;
		anims[11006].delayType = 2;
		anims[11006].length = 24;
		anims[11006].padding = -1;
		anims[11006].priority1 = 5;
		anims[11006].resetCycle = 99;
		anims[11006].runFlag = 0;
		anims[11006].shield = -1;
		anims[11006].walkFlag = 0;
		anims[11006].weapon = -1;
		anims[11006].duration = new int[24];
		anims[11006].duration[0] = 2;
		anims[11006].duration[1] = 2;
		anims[11006].duration[2] = 2;
		anims[11006].duration[3] = 2;
		anims[11006].duration[4] = 2;
		anims[11006].duration[5] = 2;
		anims[11006].duration[6] = 2;
		anims[11006].duration[7] = 2;
		anims[11006].duration[8] = 2;
		anims[11006].duration[9] = 2;
		anims[11006].duration[10] = 2;
		anims[11006].duration[11] = 2;
		anims[11006].duration[12] = 2;
		anims[11006].duration[13] = 2;
		anims[11006].duration[14] = 2;
		anims[11006].duration[15] = 2;
		anims[11006].duration[16] = 2;
		anims[11006].duration[17] = 2;
		anims[11006].duration[18] = 2;
		anims[11006].duration[19] = 2;
		anims[11006].duration[20] = 2;
		anims[11006].duration[21] = 2;
		anims[11006].duration[22] = 2;
		anims[11006].duration[23] = 1;
		anims[11006].primary = new int[24];
		anims[11006].primary[0] = 201392246;
		anims[11006].primary[1] = 201392355;
		anims[11006].primary[2] = 201392243;
		anims[11006].primary[3] = 201392304;
		anims[11006].primary[4] = 201392275;
		anims[11006].primary[5] = 201392280;
		anims[11006].primary[6] = 201392258;
		anims[11006].primary[7] = 201392238;
		anims[11006].primary[8] = 201392162;
		anims[11006].primary[9] = 201392172;
		anims[11006].primary[10] = 201392279;
		anims[11006].primary[11] = 201392137;
		anims[11006].primary[12] = 201392194;
		anims[11006].primary[13] = 201392333;
		anims[11006].primary[14] = 201392265;
		anims[11006].primary[15] = 201392225;
		anims[11006].primary[16] = 201392283;
		anims[11006].primary[17] = 201392300;
		anims[11006].primary[18] = 201392285;
		anims[11006].primary[19] = 201392354;
		anims[11006].primary[20] = 201392206;
		anims[11006].primary[21] = 201392190;
		anims[11006].primary[22] = 201392294;
		anims[11006].primary[23] = 201392246;

		//Ice stryke death
		anims[11005] = new Sequences();
		anims[11005].allowsRotation = false;
		anims[11005].delayType = 2;
		anims[11005].length = 23;
		anims[11005].padding = -1;
		anims[11005].priority1 = 10;
		anims[11005].resetCycle = 99;
		anims[11005].runFlag = 0;
		anims[11005].shield = -1;
		anims[11005].walkFlag = 0;
		anims[11005].weapon = -1;
		anims[11005].duration = new int[23];
		anims[11005].duration[0] = 8;
		anims[11005].duration[1] = 8;
		anims[11005].duration[2] = 8;
		anims[11005].duration[3] = 8;
		anims[11005].duration[4] = 8;
		anims[11005].duration[5] = 8;
		anims[11005].duration[6] = 8;
		anims[11005].duration[7] = 5;
		anims[11005].duration[8] = 5;
		anims[11005].duration[9] = 5;
		anims[11005].duration[10] = 5;
		anims[11005].duration[11] = 3;
		anims[11005].duration[12] = 3;
		anims[11005].duration[13] = 3;
		anims[11005].duration[14] = 3;
		anims[11005].duration[15] = 3;
		anims[11005].duration[16] = 3;
		anims[11005].duration[17] = 4;
		anims[11005].duration[18] = 4;
		anims[11005].duration[19] = 4;
		anims[11005].duration[20] = 4;
		anims[11005].duration[21] = 4;
		anims[11005].duration[22] = 220;
		anims[11005].primary = new int[23];
		anims[11005].primary[0] = 201392310;
		anims[11005].primary[1] = 201392336;
		anims[11005].primary[2] = 201392139;
		anims[11005].primary[3] = 201392315;
		anims[11005].primary[4] = 201392322;
		anims[11005].primary[5] = 201392311;
		anims[11005].primary[6] = 201392229;
		anims[11005].primary[7] = 201392273;
		anims[11005].primary[8] = 201392245;
		anims[11005].primary[9] = 201392228;
		anims[11005].primary[10] = 201392165;
		anims[11005].primary[11] = 201392235;
		anims[11005].primary[12] = 201392193;
		anims[11005].primary[13] = 201392323;
		anims[11005].primary[14] = 201392170;
		anims[11005].primary[15] = 201392316;
		anims[11005].primary[16] = 201392357;
		anims[11005].primary[17] = 201392262;
		anims[11005].primary[18] = 201392189;
		anims[11005].primary[19] = 201392351;
		anims[11005].primary[20] = 201392151;
		anims[11005].primary[21] = 201392201;
		anims[11005].primary[22] = 201392222;

		// Ice stryke attack
		anims[11004] = new Sequences();
		anims[11004].allowsRotation = false;
		anims[11004].delayType = 2;
		anims[11004].length = 23;
		anims[11004].padding = -1;
		anims[11004].priority1 = 6;
		anims[11004].resetCycle = 99;
		anims[11004].runFlag = 0;
		anims[11004].shield = -1;
		anims[11004].walkFlag = 0;
		anims[11004].weapon = -1;
		anims[11004].duration = new int[23];
		anims[11004].duration[0] = 2;
		anims[11004].duration[1] = 2;
		anims[11004].duration[2] = 2;
		anims[11004].duration[3] = 2;
		anims[11004].duration[4] = 2;
		anims[11004].duration[5] = 2;
		anims[11004].duration[6] = 2;
		anims[11004].duration[7] = 2;
		anims[11004].duration[8] = 2;
		anims[11004].duration[9] = 2;
		anims[11004].duration[10] = 2;
		anims[11004].duration[11] = 2;
		anims[11004].duration[12] = 1;
		anims[11004].duration[13] = 1;
		anims[11004].duration[14] = 1;
		anims[11004].duration[15] = 1;
		anims[11004].duration[16] = 1;
		anims[11004].duration[17] = 3;
		anims[11004].duration[18] = 3;
		anims[11004].duration[19] = 3;
		anims[11004].duration[20] = 3;
		anims[11004].duration[21] = 3;
		anims[11004].duration[22] = 1;
		anims[11004].primary = new int[23];
		anims[11004].primary[0] = 201392353;
		anims[11004].primary[1] = 201392307;
		anims[11004].primary[2] = 201392232;
		anims[11004].primary[3] = 201392249;
		anims[11004].primary[4] = 201392282;
		anims[11004].primary[5] = 201392349;
		anims[11004].primary[6] = 201392134;
		anims[11004].primary[7] = 201392320;
		anims[11004].primary[8] = 201392271;
		anims[11004].primary[9] = 201392293;
		anims[11004].primary[10] = 201392287;
		anims[11004].primary[11] = 201392260;
		anims[11004].primary[12] = 201392330;
		anims[11004].primary[13] = 201392233;
		anims[11004].primary[14] = 201392208;
		anims[11004].primary[15] = 201392191;
		anims[11004].primary[16] = 201392319;
		anims[11004].primary[17] = 201392142;
		anims[11004].primary[18] = 201392220;
		anims[11004].primary[19] = 201392197;
		anims[11004].primary[20] = 201392199;
		anims[11004].primary[21] = 201392140;
		anims[11004].primary[22] = 201392353;

		// Ice strykewyrm stand animation
		anims[11003] = new Sequences();
		anims[11003].allowsRotation = false;
		anims[11003].delayType = 2;
		anims[11003].length = 20;
		anims[11003].padding = 20;
		anims[11003].priority1 = 5;
		anims[11003].resetCycle = 99;
		anims[11003].runFlag = 0;
		anims[11003].shield = -1;
		anims[11003].walkFlag = 0;
		anims[11003].weapon = -1;
		anims[11003].duration = new int[20];
		anims[11003].duration[0] = 6;
		anims[11003].duration[1] = 6;
		anims[11003].duration[2] = 6;
		anims[11003].duration[3] = 6;
		anims[11003].duration[4] = 6;
		anims[11003].duration[5] = 6;
		anims[11003].duration[6] = 6;
		anims[11003].duration[7] = 6;
		anims[11003].duration[8] = 6;
		anims[11003].duration[9] = 6;
		anims[11003].duration[10] = 6;
		anims[11003].duration[11] = 6;
		anims[11003].duration[12] = 6;
		anims[11003].duration[13] = 6;
		anims[11003].duration[14] = 6;
		anims[11003].duration[15] = 6;
		anims[11003].duration[16] = 6;
		anims[11003].duration[17] = 6;
		anims[11003].duration[18] = 6;
		anims[11003].duration[19] = 6;
		anims[11003].primary = new int[20];
		anims[11003].primary[0] = 201392301;
		anims[11003].primary[1] = 201392215;
		anims[11003].primary[2] = 201392350;
		anims[11003].primary[3] = 201392324;
		anims[11003].primary[4] = 201392130;
		anims[11003].primary[5] = 201392146;
		anims[11003].primary[6] = 201392309;
		anims[11003].primary[7] = 201392224;
		anims[11003].primary[8] = 201392342;
		anims[11003].primary[9] = 201392288;
		anims[11003].primary[10] = 201392184;
		anims[11003].primary[11] = 201392156;
		anims[11003].primary[12] = 201392150;
		anims[11003].primary[13] = 201392198;
		anims[11003].primary[14] = 201392152;
		anims[11003].primary[15] = 201392329;
		anims[11003].primary[16] = 201392261;
		anims[11003].primary[17] = 201392136;
		anims[11003].primary[18] = 201392267;
		anims[11003].primary[19] = 201392163;

		// Dice roll animation, 2873 is file id
		anims[11000] = new Sequences();
		anims[11000].allowsRotation = false;
		anims[11000].delayType = 2;
		anims[11000].length = 14;
		anims[11000].padding = -1;
		anims[11000].priority1 = 5;
		anims[11000].resetCycle = 99;
		anims[11000].runFlag = 3;
		anims[11000].shield = 0;
		anims[11000].walkFlag = 1;
		anims[11000].weapon = 0;
		anims[11000].duration = new int[14];
		anims[11000].duration[0] = 3;
		anims[11000].duration[1] = 3;
		anims[11000].duration[2] = 3;
		anims[11000].duration[3] = 3;
		anims[11000].duration[4] = 3;
		anims[11000].duration[5] = 3;
		anims[11000].duration[6] = 3;
		anims[11000].duration[7] = 3;
		anims[11000].duration[8] = 3;
		anims[11000].duration[9] = 3;
		anims[11000].duration[10] = 3;
		anims[11000].duration[11] = 3;
		anims[11000].duration[12] = 3;
		anims[11000].duration[13] = 3;
		anims[11000].primary = new int[14];
		anims[11000].primary[0] = 188285009;
		anims[11000].primary[1] = 188284950;
		anims[11000].primary[2] = 188284989;
		anims[11000].primary[3] = 188285162;
		anims[11000].primary[4] = 188284987;
		anims[11000].primary[5] = 188285107;
		anims[11000].primary[6] = 188285131;
		anims[11000].primary[7] = 188285085;
		anims[11000].primary[8] = 188285159;
		anims[11000].primary[9] = 188285041;
		anims[11000].primary[10] = 188285071;
		anims[11000].primary[11] = 188285204;
		anims[11000].primary[12] = 188285174;
		anims[11000].primary[13] = 188285152;

		// Resting animation 2842 is file id
		anims[11001] = new Sequences();
		anims[11001].allowsRotation = false;
		anims[11001].delayType = 2;
		anims[11001].length = 23;
		anims[11001].padding = 11;
		anims[11001].priority1 = 1;
		anims[11001].resetCycle = 99;
		anims[11001].runFlag = 1;
		anims[11001].shield = 0;
		anims[11001].walkFlag = 1;
		anims[11001].weapon = 0;
		anims[11001].duration = new int[23];
		anims[11001].duration[0] = 5;
		anims[11001].duration[1] = 5;
		anims[11001].duration[2] = 5;
		anims[11001].duration[3] = 5;
		anims[11001].duration[4] = 5;
		anims[11001].duration[5] = 5;
		anims[11001].duration[6] = 5;
		anims[11001].duration[7] = 5;
		anims[11001].duration[8] = 5;
		anims[11001].duration[9] = 5;
		anims[11001].duration[10] = 5;
		anims[11001].duration[11] = 5;
		anims[11001].duration[12] = 5;
		anims[11001].duration[13] = 5;
		anims[11001].duration[14] = 5;
		anims[11001].duration[15] = 5;
		anims[11001].duration[16] = 5;
		anims[11001].duration[17] = 5;
		anims[11001].duration[18] = 5;
		anims[11001].duration[19] = 5;
		anims[11001].duration[20] = 5;
		anims[11001].duration[21] = 5;
		anims[11001].duration[22] = 5;
		anims[11001].primary = new int[23];
		anims[11001].primary[0] = 186253913;
		anims[11001].primary[1] = 186253417;
		anims[11001].primary[2] = 186254038;
		anims[11001].primary[3] = 186253485;
		anims[11001].primary[4] = 186253745;
		anims[11001].primary[5] = 186254192;
		anims[11001].primary[6] = 186254266;
		anims[11001].primary[7] = 186253323;
		anims[11001].primary[8] = 186254406;
		anims[11001].primary[9] = 186253618;
		anims[11001].primary[10] = 186254283;
		anims[11001].primary[11] = 186254261;
		anims[11001].primary[12] = 186253757;
		anims[11001].primary[13] = 186253598;
		anims[11001].primary[14] = 186254459;
		anims[11001].primary[15] = 186254413;
		anims[11001].primary[16] = 186253568;
		anims[11001].primary[17] = 186253449;
		anims[11001].primary[18] = 186253459;
		anims[11001].primary[19] = 186254418;
		anims[11001].primary[20] = 186253582;
		anims[11001].primary[21] = 186253515;
		anims[11001].primary[22] = 186253741;

		// Dice gfx animation 2875 is file id
		anims[11002] = new Sequences();
		anims[11002].allowsRotation = false;
		anims[11002].delayType = 2;
		anims[11002].length = 17;
		anims[11002].padding = -1;
		anims[11002].priority1 = 5;
		anims[11002].resetCycle = 99;
		anims[11002].runFlag = 0;
		anims[11002].shield = -1;
		anims[11002].walkFlag = 0;
		anims[11002].weapon = -1;
		anims[11002].duration = new int[17];
		anims[11002].duration[0] = 27;
		anims[11002].duration[1] = 3;
		anims[11002].duration[2] = 3;
		anims[11002].duration[3] = 3;
		anims[11002].duration[4] = 3;
		anims[11002].duration[5] = 3;
		anims[11002].duration[6] = 3;
		anims[11002].duration[7] = 3;
		anims[11002].duration[8] = 3;
		anims[11002].duration[9] = 4;
		anims[11002].duration[10] = 5;
		anims[11002].duration[11] = 3;
		anims[11002].duration[12] = 3;
		anims[11002].duration[13] = 4;
		anims[11002].duration[14] = 35;
		anims[11002].duration[15] = 9;
		anims[11002].duration[16] = 6;
		anims[11002].primary = new int[17];
		anims[11002].primary[0] = 188416062;
		anims[11002].primary[1] = 188416056;
		anims[11002].primary[2] = 188416016;
		anims[11002].primary[3] = 188416040;
		anims[11002].primary[4] = 188416036;
		anims[11002].primary[5] = 188416054;
		anims[11002].primary[6] = 188416006;
		anims[11002].primary[7] = 188416037;
		anims[11002].primary[8] = 188416048;
		anims[11002].primary[9] = 188416045;
		anims[11002].primary[10] = 188416018;
		anims[11002].primary[11] = 188416020;
		anims[11002].primary[12] = 188416028;
		anims[11002].primary[13] = 188416012;
		anims[11002].primary[14] = 188416012;
		anims[11002].primary[15] = 188416007;
		anims[11002].primary[16] = 188416021;

		// Death animation fix.
		anims[836].delayType = 1;
		anims[836].duration[9] = 20000;
		anims[836].priority1 = 10;

		anims[11973] = new Sequences();
		anims[11973].length = 24;
		anims[11973].duration = new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
		anims[11973].primary = new int[]{
				262341406, 262341431, 262341510, 262341488, 262341442, 262341507, 262341432,
				262341418, 262341469, 262341502, 262341443, 262341463, 262341476, 262341424,
				262341503, 262341459, 262341885, 262341835, 262341896, 262341867, 262341872,
				262341902, 262341845, 262341900
		};

	}

	public int getDuration(int i) {
		int j = duration[i];
		if (j == 0) {
			Frames class36 = Frames.get(primary[i]);
			if (class36 != null) {
				j = duration[i] = 0;
			}
		}
		if (j == 0) {
			j = 1;
		}
		return j;
	}

	private Sequences() {
			padding = -1;
			allowsRotation = false;
			priority1 = 5;
			shield = -1;
			weapon = -1;
			resetCycle = 99;
			runFlag = -1;
			walkFlag = -1;
			delayType = 2;
	}

	public static Sequences get(int id) {
		return id >= 0 && id < anims.length ? anims[id] : null;
	}

	public int getFrame(int id) {
		return id >= 0 && primary != null && id < primary.length ? primary[id] : -1;
	}

	static int loaded = 0;

	public void readValuesOsrs(Stream buffer) {
		while (true) {
			final int opcode = buffer.readUnsignedByte();

			if (opcode == 0) {
				break;
			}
			else if (opcode == 1) {
				length = buffer.readUnsignedWord();

				primary = new int[length];

				secondary = new int[length];

				duration = new int[length];

				files = new int[length];

				indexInFiles = new int[length];

				for (int i = 0; i < length; ++i) {
					duration[i] = buffer.readUnsignedWord();
				}

				for (int i = 0; i < length; ++i) {
					primary[i] = buffer.readUnsignedWord();
					//TODO jason - cant find any usage of this in the OSRS decode function, not sure if we need this, might need
					//TODO jason - to be grandfathered in.
					secondary[i] = -1;
				}

				for (int i = 0; i < length; i++) {
					primary[i] += buffer.readUnsignedWord() << 16;
					files[i] = getFileId(primary[i]);
					indexInFiles[i] = getFileIndex(primary[i]);
					//debugFileId(primary[i]);
				}

			}
			else if (opcode == 2) {
				padding = buffer.readUnsignedWord();
			}
			else if (opcode == 3) {
				int len = buffer.readUnsignedByte();
				vertices = new int[len + 1];
				for (int i = 0; i < len; i++) {
					vertices[i] = buffer.readUnsignedByte();
				}
				vertices[len] = 9999999;
			}
			else if (opcode == 4) {
				allowsRotation = true;
			}
			else if (opcode == 5) {
				priority1 = buffer.readUnsignedByte();
			}
			else if (opcode == 6) {
				shield = buffer.readUnsignedWord();
			}
			else if (opcode == 7) {
				weapon = buffer.readUnsignedWord();
			}
			else if (opcode == 8) {
				resetCycle = buffer.readUnsignedByte();
			}
			else if (opcode == 9) {
				runFlag = buffer.readUnsignedByte();
			}
			else if (opcode == 10) {
				walkFlag = buffer.readUnsignedByte();
			}
			else if (opcode == 11) {
				delayType = buffer.readUnsignedByte();
			}
			else if (opcode == 12) {
				int len = buffer.readUnsignedByte();

				opcode12Array = new int[len];

				for (int i = 0; i < len; i++) {
					opcode12Array[i] = buffer.readUnsignedWord();
				}

				for (int i = 0; i < len; i++) {
					opcode12Array[i] += buffer.readUnsignedWord() << 16;
				}
			}
			else if (opcode == 13) {
				int len = buffer.readUnsignedByte();

				opcode13Array = new int[len];

				for (int i = 0; i < len; i++) {
					opcode13Array[i] = buffer.read3Bytes();
				}
			}
		}
		loaded++;

		if (length == 0) {
			length = 1;
			primary = new int[1];
			primary[0] = -1;
			secondary = new int[1];
			secondary[0] = -1;
			duration = new int[1];
			duration[0] = -1;
		}

		if (runFlag == -1) {
			runFlag = (vertices == null) ? 0 : 2;
		}

		if (walkFlag == -1) {
			walkFlag = (vertices == null) ? 0 : 2;
		}
	}

	public static void dumpToTxt() {
		for (int id = 0; id < 15_000; id++) {
			get(id); // store in memory
		}
		List<String> lines = new ArrayList<>();

		for (int index = 0; index < Sequences.anims.length; index++) {
			Sequences sequences = anims[index];

			if (sequences == null) {
				continue;
			}

			lines.add(String.format("id=%s", index));
			lines.add(String.format("files=%s", Arrays.toString(sequences.files)));
			lines.add(String.format("fileIndexes=%s", Arrays.toString(sequences.indexInFiles)));
			lines.add("\n");
		}
		try {
			Files.write(Paths.get("animation_file_dump.txt"), lines, StandardOpenOption.CREATE,
					StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Finished dumping to txt.");
	}

	@Override
	public String toString() {
		return "Sequences{" +
				"length=" + length +
				", primary=" + Arrays.toString(primary) +
				", secondary=" + Arrays.toString(secondary) +
				", duration=" + Arrays.toString(duration) +
				", padding=" + padding +
				", vertices=" + Arrays.toString(vertices) +
				", allowsRotation=" + allowsRotation +
				", priority1=" + priority1 +
				", shield=" + shield +
				", weapon=" + weapon +
				", resetCycle=" + resetCycle +
				", runFlag=" + runFlag +
				", walkFlag=" + walkFlag +
				", delayType=" + delayType +
				", opcode12Array=" + Arrays.toString(opcode12Array) +
				", opcode13Array=" + Arrays.toString(opcode13Array) +
				'}';
	}

	public void readValuesPreEoc(Stream stream) {
		int i;
		while ((i = stream.readUnsignedByte()) != 0) {

			if (i == 1) {
				length = stream.readUnsignedWord();
				primary = new int[length];
				secondary = new int[length];
				duration = new int[length];
				files = new int[length];
				indexInFiles = new int[length];

				for (int j = 0; j < length; j++) {
					primary[j] = stream.readDWord();
					files[j] = getFileId(primary[j]);
					indexInFiles[j] = getFileIndex(primary[j]);
					secondary[j] = -1;
				}
				for (int j = 0; j < length; j++) {
					duration[j] = stream.readUnsignedByte();
				}
			}
			else if (i == 2) {
				padding = stream.readUnsignedWord();
			}
			else if (i == 3) {
				int length = stream.readUnsignedByte();
				vertices = new int[length + 1];
				for (int k = 0; k < length; k++) {
					vertices[k] = stream.readUnsignedByte();
				}
				vertices[length] = 9999999;
			}
			else if (i == 4) {
				allowsRotation = true;
			}
			else if (i == 5) {
				priority1 = stream.readUnsignedByte();
			}
			else if (i == 6) {
				shield = stream.readUnsignedWord();
			}
			else if (i == 7) {
				weapon = stream.readUnsignedWord();
			}
			else if (i == 8) {
				resetCycle = stream.readUnsignedByte();
			}
			else if (i == 9) {
				runFlag = stream.readUnsignedByte();
			}
			else if (i == 10) {
				walkFlag = stream.readUnsignedByte();
			}
			else if (i == 11) {
				delayType = stream.readUnsignedByte();
			}
			else if (i == 13) {
				int amount = stream.readUnsignedByte();

				for (int i4 = 0; i4 < amount; i4++) {
					stream.read3Bytes();
				}
			}
			else {
				Utility.print("Error unrecognised seq config code: " + i);
			}
		}
		if (length == 0) {
			length = 1;
			primary = new int[1];
			primary[0] = -1;
			secondary = new int[1];
			secondary[0] = -1;
			duration = new int[1];
			duration[0] = -1;
		}
		if (runFlag == -1)
			if (vertices != null)
				runFlag = 2;
			else
				runFlag = 0;
		if (walkFlag == -1) {
			if (vertices != null) {
				walkFlag = 2;
				return;
			}
			walkFlag = 0;
		}
	}

	public int[] files;

	public int[] indexInFiles;

	public static Sequences anims[];

	public int length;

	public int primary[];

	public int secondary[];

	int[] duration;

	public int padding = -1;

	public int vertices[];

	public boolean allowsRotation;

	public int priority1 = 5;

	/**
	 * Shield item, this value will be the item id needed + 512.
	 */
	public int shield = -1;

	/**
	 * Weapon item, this value will be the item id needed + 512.
	 */
	public int weapon = -1;

	public int resetCycle = 99;

	public int runFlag;

	public int walkFlag;

	public int delayType;

	private int[] opcode12Array;

	private int[] opcode13Array;
}