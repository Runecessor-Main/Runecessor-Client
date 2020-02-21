package Runecessor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class IdentityKit {

	public static void unpackConfig(StreamLoader streamLoader) {
		Path path = null;
		if (Config.PRE_EOC) {
			path = Paths.get(ClientConstants.getMainCacheLocation() + "718_cache/idk.dat");
		}
		else {
			path = Paths.get(ClientConstants.getCacheLocation() + "identity_kit.dat");
		}
		byte[] data = null;
		try {
			data = Files.readAllBytes(path);
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		Stream stream = new Stream(data);
		length = stream.readUnsignedWord();
		if (cache == null)
			cache = new IdentityKit[length];
		for (int j = 0; j < length; j++) {
			if (cache[j] == null)
				cache[j] = new IdentityKit();
			cache[j].readValues(stream);
		}
	}

	private void readValues(Stream stream) {
		do {
			int i = stream.readUnsignedByte();
			if (i == 0)
				return;
			if (i == 1)
				partId = stream.readUnsignedByte();
			else if (i == 2) {
				int j = stream.readUnsignedByte();
				modelArray = new int[j];
				for (int k = 0; k < j; k++)
				{
					if (Config.PRE_EOC) {
						modelArray[k] = stream.readDWord();
					}
					else {
						modelArray[k] = stream.readUnsignedWord();
					}
				}

			}
			else if (i == 3)
				disableDisplay = true;
			else if (i >= 40 && i < 50)
				oldColour[i - 40] = stream.readUnsignedWord();
			else if (i >= 50 && i < 60)
				newColour[i - 50] = stream.readUnsignedWord();
			else if (i >= 60 && i < 70)
			{
				if (Config.PRE_EOC) {
					dialogueModel[i - 60] = stream.readDWord();
				}
				else {
					dialogueModel[i - 60] = stream.readUnsignedWord();
				}
			}
			else
				Utility.print("Error unrecognised config code: " + i);
		}
		while (true);
	}

	public boolean modelIsValid() {
		if (modelArray == null)
			return true;
		boolean flag = true;
		for (int j = 0; j < modelArray.length; j++)
			if (!Model.isCached(modelArray[j]))
				flag = false;

		return flag;
	}

	public Model getModel() {
		if (modelArray == null)
			return null;
		Model aclass30_sub2_sub4_sub6s[] = new Model[modelArray.length];
		for (int i = 0; i < modelArray.length; i++)
			aclass30_sub2_sub4_sub6s[i] = Model.getModel(modelArray[i]);

		Model model;
		if (aclass30_sub2_sub4_sub6s.length == 1)
			model = aclass30_sub2_sub4_sub6s[0];
		else
			model = new Model(aclass30_sub2_sub4_sub6s.length, aclass30_sub2_sub4_sub6s);
		for (int j = 0; j < 6; j++) {
			if (oldColour[j] == 0)
				break;
			model.setColour(oldColour[j], newColour[j]);
		}

		return model;
	}

	public boolean faceIsValid() {
		boolean flag1 = true;
		for (int i = 0; i < 5; i++)
			if (dialogueModel[i] != -1 && !Model.isCached(dialogueModel[i]))
				flag1 = false;

		return flag1;
	}

	public Model getHead() {
		Model aclass30_sub2_sub4_sub6s[] = new Model[5];
		int j = 0;
		for (int k = 0; k < 5; k++)
			if (dialogueModel[k] != -1)
				aclass30_sub2_sub4_sub6s[j++] = Model.getModel(dialogueModel[k]);

		Model model = new Model(j, aclass30_sub2_sub4_sub6s);
		for (int l = 0; l < 6; l++) {
			if (oldColour[l] == 0)
				break;
			model.setColour(oldColour[l], newColour[l]);
		}

		return model;
	}

	private IdentityKit() {
		partId = -1;
		oldColour = new int[6];
		newColour = new int[6];
		disableDisplay = false;
	}

	public static int length;

	public static IdentityKit cache[];

	public int partId;

	private int[] modelArray;

	private final int[] oldColour;

	private final int[] newColour;

	private final int[] dialogueModel =
	{-1, -1, -1, -1, -1};

	public boolean disableDisplay;
}