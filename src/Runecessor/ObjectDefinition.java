package Runecessor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class ObjectDefinition {

	public static ObjectDefinition forId(int objectId) {
		if (objectId > streamIndices.length - 1) {
			return null;
		}
		if (!Config.PRE_EOC)
		objectId = objectIdFixes(objectId);

		if (objectId > streamIndices.length) {
			objectId = streamIndices.length - 1;
		}
		for (int j = 0; j < 20; j++) {
			if (cache[j].type == objectId) {
				return cache[j];
			}
		}
		if (!Config.PRE_EOC) {
			if (objectId == 25913)
				objectId = 15552;
			if (objectId == 25916 || objectId == 25926)
				objectId = 15553;
			if (objectId == 25917)
				objectId = 15554; // Seers village roofs fix for osrs data
		}
		cacheIndex = (cacheIndex + 1) % 20;
		ObjectDefinition objectDef = cache[cacheIndex];
		stream.currentOffset = streamIndices[objectId];
		objectDef.type = objectId;
		objectDef.setDefaults();
		if (!Config.PRE_EOC) {
			if (objectId <= 32738) {
				objectDef.readValuesOsrs(stream);
			}
		}
		else {
			objectDef.readValues634(stream);
		}
		// 32738 is highest object id used by #170 osrs data.

		boolean debug = false;
		int objectToDebug = 444;
		if (debug) {
			if (objectId == objectToDebug) {
				Utility.print("Name: " + objectDef.name);
				Utility.print("Animation: " + objectDef.animationID);

				if (objectDef.models != null) {
					for (int index = 0; index < objectDef.models.length; index++) {
						Utility.print("objectDef.models[" + index + "] = " + objectDef.models[index] + ";");
					}
				}
			}
		}
		debug(objectDef);
		if(!Config.PRE_EOC)
		customObjectsOsrs(objectDef, objectId);
		return objectDef;
	}
	public static void unpackConfig634(StreamLoader streamLoader)
	{

		stream = new Stream(DataToolkit.readFile(ClientConstants.getMainCacheLocation() + "/718_cache/loc.dat"));
		Stream buffer = new Stream(DataToolkit.readFile(ClientConstants.getMainCacheLocation() + "/718_cache/loc.idx"));
		int totalObjects = buffer.readUnsignedWord();
		System.out.println("634 Object Amount: " + totalObjects);
		streamIndices = new int[totalObjects + 40000];
		int i = 2;
		for(int j = 0; j < totalObjects; j++)
		{
			streamIndices[j] = i;
			i += buffer.readUnsignedWord();
		}
		cache = new ObjectDefinition[20];
		for(int k = 0; k < 20; k++)
			cache[k] = new ObjectDefinition();
	}
	private void readValues634(Stream buffer) {
		int flag = -1;
		label0: do {
			int opcode;
			do {
				opcode = buffer.readUnsignedByte();
				if (opcode == 0)
					break label0;
				if (opcode == 1) {
					int k = buffer.readUnsignedByte();
					if (k > 0)
						if (models == null || lowMem) {
							modelTypes = new int[k];
							models = new int[k];
							for (int k1 = 0; k1 < k; k1++) {
								models[k1] = buffer.readUnsignedWord();
								modelTypes[k1] = buffer.readUnsignedByte();
							}
						} else {
							buffer.currentOffset += k * 3;
						}
				} else if (opcode == 2)
					name = buffer.readString();
				else if (opcode == 3)
					description = buffer.readBytes();
				else if (opcode == 5) {
					int l = buffer.readUnsignedByte();
					if (l > 0)
						if (models == null || lowMem) {
							modelTypes = null;
							models = new int[l];
							for (int l1 = 0; l1 < l; l1++)
								models[l1] = buffer.readUnsignedWord();
						} else {
							;//buffer.currentOffset += l * 2;
						}
				} else if (opcode == 14)
					sizeX = buffer.readUnsignedByte();
				else if (opcode == 15)
					sizeY = buffer.readUnsignedByte();
				else if (opcode == 17)
					blocksWalk = false;
				else if (opcode == 18)
					blocksProjectiles = false;
				else if (opcode == 19) {
					flag = buffer.readUnsignedByte();
					if (flag == 1)
						hasActions = true;
				} else if (opcode == 21)
					adjustsToTerrain = true;
				else if (opcode == 22)
					isFlatShaded = false;//
				else if (opcode == 23)
					isSolid= true;
				else if (opcode == 24) {
					animationID = buffer.readUnsignedWord();
					if (animationID == 65535)
						animationID = -1;
				} else if (opcode == 28)
					wallWidth = buffer.readUnsignedByte();
				else if (opcode == 29)
					brightness = buffer.readSignedByte();
				else if (opcode == 39)
					contrast= buffer.readSignedByte();
				else if (opcode >= 30 && opcode < 39) {
					if (actions == null)
						actions = new String[10];
					actions[opcode - 30] = buffer.readString();
					if (actions[opcode - 30].equalsIgnoreCase("hidden"))
						actions[opcode - 30] = null;
				} else if (opcode == 40) {
					int i1 = buffer.readUnsignedByte();
					modelColourToEdit= new int[i1];
					newModelColourProduced = new int[i1];
					for (int i2 = 0; i2 < i1; i2++) {
						modelColourToEdit[i2] = buffer.readUnsignedWord();
						newModelColourProduced[i2] = buffer.readUnsignedWord();
					}
				} else if (opcode == 60)
					icon = buffer.readUnsignedWord();
				else if (opcode == 62)
					rotateLeft = true;
				else if (opcode == 64)
					castsShadow = false;
				else if (opcode == 65)
					scaleX = buffer.readUnsignedWord();
				else if (opcode == 66)
					scaleY = buffer.readUnsignedWord();
				else if (opcode == 67)
					scaleZ = buffer.readUnsignedWord();
				else if (opcode == 68)
					mapscene = buffer.readUnsignedWord();
				else if (opcode == 69)
					rotationFlags = buffer.readUnsignedByte();
				else if (opcode == 70)
					offsetX = buffer.readSignedWord();
				else if (opcode == 71)
					offsetY = buffer.readSignedWord();
				else if (opcode == 72)
					offsetY = buffer.readSignedWord();
				else if (opcode == 73)
					isDecoration = true;
				else if (opcode == 74) {
					ghost = true;
				} else {
					if (opcode != 75)
						continue;
					holdsItemPiles = buffer.readUnsignedByte();
				}
				continue label0;
			} while (opcode != 77);
			varbit = buffer.readUnsignedWord();
			if (varbit == 65535)
				varbit = -1;
			varbit = buffer.readUnsignedWord();
			if (varbit == 65535)
				varbit = -1;
			int j1 = buffer.readUnsignedByte();
			childrenIDs = new int[j1 + 1];
			for (int j2 = 0; j2 <= j1; j2++) {
				childrenIDs[j2] = buffer.readUnsignedWord();
				if (childrenIDs[j2] == 65535)
					childrenIDs[j2] = -1;
			}

		} while (true);
		if (flag == -1) {
			hasActions = models != null && (modelTypes == null || modelTypes[0] == 10);
			if (actions != null)
				hasActions = true;
		}
		if (ghost) {
			blocksWalk = false;
			blocksProjectiles = false;
		}
		if (holdsItemPiles == -1)
			holdsItemPiles = blocksWalk ? 1 : 0;
	}

	private static void customObjectsOsrs(ObjectDefinition objectDef, int objectId) {
		if (Config.PRE_EOC) {
			return;
		}
		int colour = -1;

		// 32557 is highest object id used by 167 data.
		switch (objectId) {
			case 26278:
				objectDef.name = "Sanfew serum";
				objectDef.actions = new String[]
				{"Fill-vials", null, null, null, null};
				break;
			case 26279:
				objectDef.name = "Super combat potion";
				objectDef.actions = new String[]
				{"Fill-vials", null, null, null, null};
				break;
			case 16466:
				objectDef.mapscene = -1;
				break;

			// Altar of the occult.
			case 31858:
				objectDef.actions = new String[] {"Switch", "Modern", "Ancient magicks", "Lunar", null};
				break;

			case 11700:
				objectDef.models = new int[] { 4086 };
				objectDef.name = "Venom";
				objectDef.sizeX = 3;
				objectDef.sizeY = 3;
				objectDef.blocksWalk = false;
				objectDef.adjustsToTerrain = true;
				objectDef.animationID = 1261;
				objectDef.newModelColourProduced = new int[] { 31636 };
				objectDef.modelColourToEdit = new int[] { 10543 };
				objectDef.scaleX = 160;
				objectDef.scaleY = 160;
				objectDef.scaleZ = 160;
				objectDef.actions = new String[5];
				objectDef.description = new String("It's a cloud of venomous smoke that is extremely toxic.").getBytes();
			break;
			case 14017:
				objectDef.name = "Statue of " + Config.serverNames[Config.currentServer];
				objectDef.models[0]= Config.statueModels[Config.currentServer];
				break;
			case 15301:
				objectDef.name = "Chocolate deposits";
				objectDef.models = new int[]
				{1391};
				objectDef.modelColourToEdit = new int[]
				{24};
				objectDef.actions = new String[]
				{"Mine", null, null, null, null};
				objectDef.newModelColourProduced = new int[]
				{5027};
				objectDef.scaleX = 266;
				objectDef.scaleY = 266;
				objectDef.scaleZ = 266;
				objectDef.sizeX = 2;
				objectDef.sizeY = 2;
				break;
			case 13576:
				objectDef.name = "";
				objectDef.actions = new String[]
			{null, null, null, null, null};
			break;
			case 15299:
				objectDef.name = "Chocolate deposits";
				objectDef.models = new int[]
				{1391};
				objectDef.modelColourToEdit = new int[]
				{24};
				objectDef.actions = new String[]
				{"Mine", null, null, null, null};
				objectDef.newModelColourProduced = new int[]
				{5027};
				break;
			case 9083:
				objectDef.actions = new String[]
				{"Take-dye", null, null, null, null};
				objectDef.name = "Food dye pots";
				break;
			case 9758:
			    ObjectDefinition eventchest = ObjectDefinition.forId(27290);
			    objectDef.actions = new String[5];
				objectDef.actions[0] = "Unlock";
				objectDef.name = "Event chest";
				objectDef.models = eventchest.models;
				objectDef.modelColourToEdit = new int[]
				{14499, 12698, 12818};
				objectDef.newModelColourProduced = new int[]
				{296770, 359770, 296770};
				break;
			case 15300:
				objectDef.name = "Chocolate crater";
				objectDef.models = new int[]
				{20655};
				objectDef.isSolid = true;
				objectDef.actions = new String[5];
				objectDef.scaleX = 266;
				objectDef.scaleY = 266;
				objectDef.scaleZ = 266;
				objectDef.sizeX = 2;
				objectDef.sizeY = 2;
				objectDef.animationID = 5415;
				objectDef.modelColourToEdit = new int[]
				{5819, 5964};
				objectDef.newModelColourProduced = new int[]
				{5027, 5027};
				objectDef.ghost = false;
				objectDef.description = "A crater full of what looks like bubbling chocolate.".getBytes();
				break;
			case 29111:
				objectDef.name = "Deposit vault";
				objectDef.actions = new String[5];
				objectDef.actions[1] = Config.PVP ? "Deposit blood money" : "Deposit coins";
				objectDef.actions[2] = Config.PVP ? "Withdraw blood money" : "Withdraw coins";
				objectDef.actions[0] = "Check vault";
				objectDef.models = new int[]
				{10518};
				objectDef.sizeX = 2;
				objectDef.sizeY = 2;

				objectDef.modelColourToEdit = new int[7];
				objectDef.newModelColourProduced = new int[7];
				colour = 20;
				objectDef.modelColourToEdit[0] = 7370;
				objectDef.newModelColourProduced[0] = colour == -1 ? 7370 : colour;

				objectDef.modelColourToEdit[1] = 8388;
				objectDef.newModelColourProduced[1] = colour == -1 ? 8388 : colour;

				objectDef.modelColourToEdit[2] = 8384;
				objectDef.newModelColourProduced[2] = colour == -1 ? 8384 : colour;

				colour = 8128;
				objectDef.modelColourToEdit[3] = 10378;
				objectDef.newModelColourProduced[3] = colour == -1 ? 10378 : colour;

				colour = 8138;
				objectDef.modelColourToEdit[4] = 10502;
				objectDef.newModelColourProduced[4] = colour == -1 ? 10502 : colour;

				colour = 8148;
				objectDef.modelColourToEdit[5] = 10382;
				objectDef.newModelColourProduced[5] = colour == -1 ? 10382 : colour;

				colour = 8158;
				objectDef.modelColourToEdit[6] = 0;
				objectDef.newModelColourProduced[6] = colour == -1 ? 0 : colour;
				break;
			case 26756:
				objectDef.actions = new String[]
				{null, null, null, null, null};
				break;

			// Information booth
			case 24452:
				objectDef.name = "Staff activity booth";
				objectDef.actions = new String[]
				{"Check", null, null, null, null};
				break;
			case 19038:
				objectDef.actions = new String[5];
				objectDef.scaleX = 400;
				objectDef.scaleY = 400;
				objectDef.scaleZ = 400;
				objectDef.sizeX = 3;
				objectDef.sizeY = 3;
				break;
			case 27290:
				objectDef.name = "Loot chest";
				objectDef.actions = new String[5];
				objectDef.actions[0] = "Unlock";
				objectDef.modelColourToEdit = new int[]
				{14499, 12698, 12818};
				objectDef.newModelColourProduced = new int[]
				{8128, 6817, 6812};
				break;
			case 19030:
			case 19031:
			case 19033:
			case 19034:
				objectDef.scaleX = 430;
				objectDef.scaleY = 200;
				objectDef.scaleZ = 420;
				objectDef.sizeX = 3;
				objectDef.sizeY = 3;
				objectDef.adjustsToTerrain = false;
				objectDef.actions = new String[]
				{"Take", null, null, null, null};
				break;

			case 19035:
				objectDef.scaleX = 430;
				objectDef.scaleY = 200;
				objectDef.scaleZ = 420;
				objectDef.sizeX = 3;
				objectDef.sizeY = 3;
				objectDef.adjustsToTerrain = false;
				objectDef.actions = new String[]
				{"Search", null, null, null, null};
				break;

			case 1276: //christmas prep
			case 1278:
			case 1279:
				if (Client.toggleTrees) {
					objectDef.models = new int[]
					{20491, 20492, 20493, 20494};
					objectDef.animationID = 5058;
					objectDef.brightness = 30;
					objectDef.contrast = 30;
				}
				break;
			//wilderness loot chest
			case 13291:
				objectDef.name = "Loot Chest";
				objectDef.actions = new String[]
				{"Open", null, null, null, null};
				break;
			//boss instance portal
			case 13633:
				objectDef.name = "Boss Isntance Portal";
				objectDef.actions = new String[]
				{"Enter", "Info", null, null, null};
				break;
			case 23709:
				objectDef.actions = new String[]
				{"Restore", null, null, null, null};
				break;
			
			case 30255:
				objectDef.name = "Trading post";
				objectDef.actions = new String[]
				{"View", "Sets", "Help", null, null};
				objectDef.models = new int[]
				{44444};
				objectDef.hasActions = true;
				objectDef.sizeX = 3;
				objectDef.sizeY = 1;
				break;
			case 29149:
				objectDef.name = "Dark altar";
				objectDef.actions = new String[]
				{"Switch-spellbook", null, null, null, null};
				objectDef.offsetY = -30;
				break;
			case 23727:
			case 23728:
				objectDef.name = "Death Portal";
				objectDef.actions = new String[]
				{"Enter", null, null, null, null};
				objectDef.offsetY = -30;
				break;
			case 26204:
				objectDef.name = "Community Gift";
				objectDef.actions = new String[]
				{"Open", null, null, null, null};
				break;
			case 6943:
				objectDef.actions = new String[]
				{null, "Bank", null, null, null};
				break;
			case 29210:
			case 29217:
			case 29216:
			case 29215:
			case 29214:
			case 29213:
			case 29212:
			case 29218:
			case 29211:
				objectDef.name = "Skillcape shop";
				objectDef.actions = new String[]
				{"View", null, null, null, null};
				break;
			
			case 30252:
				objectDef.models = new int[]
				{1214};
				objectDef.modelColourToEdit = new int[]
				{70, 61, 41, 49, 28, 10153};
				objectDef.newModelColourProduced = new int[]
				{-29403, -29403, -28266, -29279, -29284, 926};
				break;
			case 10061:
			case 10060:
				objectDef.actions = new String[]
				{null, null, null, null, null};
				objectDef.name = "Wall";
				break;
			case 17119:
				objectDef.actions = new String[]
				{"Fill-bucket", null, null, null, null};
				break;
			case 16105:
				objectDef.actions = new String[]
				{"Pass", null, null, null, null};
				break;
			case 30253:
				objectDef.name = "Altar";
				objectDef.models = new int[]
				{12373, 12378};
				objectDef.actions = new String[]
				{"Pray-at", null, null, null, null};
				objectDef.sizeX = 2;
				objectDef.hasActions = true;
				break;
			case 30251:
				objectDef.actions = new String[]
				{"Check", "Donate", null, null, null};
				objectDef.name = "Well of Goodwill";
				objectDef.models = new int[]
				{10460};
				objectDef.sizeX = 3;
				objectDef.sizeY = 3;
				objectDef.newModelColourProduced = new int[]
				{-22105};
				objectDef.modelColourToEdit = new int[]
				{21522};
				objectDef.hasActions = true;
				break;

			case 13212:
				objectDef.actions = new String[]
				{"Light", null, null, null, null};
				break;

			case 13213:
				objectDef.actions = new String[]
				{null, null, null, null, null};
				break;

			case 20946:
				objectDef.name = "Deposit vault";
				objectDef.actions = new String[5];
				objectDef.actions[1] = "Deposit blood money";
				objectDef.actions[2] = "Withdraw blood money";
				objectDef.actions[0] = "Check vault";
				break;
			case 14826:
			case 14827:
			case 14828:
			case 14829:
			case 14830:
			case 14831:
				objectDef.actions = new String[]
				{"Activate", "Teleport to Destination", null, null, null};
				break;
			case 29165:
				objectDef.name = Config.PVP ? "Blood money offering" : "Coins offering";
				objectDef.actions = new String[]
				{"Steal from", null, null, null, null};
				if (Config.PVP) {
					objectDef.newModelColourProduced = new int[]
					{947};
					objectDef.modelColourToEdit = new int[]
					{8128};
				}
				break;
			case 18242:
				objectDef.name = "Max hit dummy";
				objectDef.actions = new String[]
				{"Test hit", null, null, null, null};
				break;
			case 7142:
				objectDef.name = "Donator dungeon";
				objectDef.actions = new String[]
				{"Enter", null, null, null, null};
				break;

			case 2152:
				objectDef.name = "Obelisk";
				objectDef.actions = new String[]
				{"Charge orb", "Note", null, null, null};
				break;

			case 6758:
				objectDef.actions = new String[]
				{"Sit-on", null, null, null, null};
				break;
			case 15267:
				objectDef.models = new int[1];
				objectDef.models[0] = 65014;
				objectDef.name = "Arab Revolution flag";
				objectDef.type = 10;
				objectDef.hasActions = false;
				break;
			case 15268:
				objectDef.models = new int[]
				{27052};
				objectDef.name = "Molten glass";
				objectDef.hasActions = true;
				objectDef.actions = new String[]
				{"Take", null, null, null, null};
				break;

			case 15269:
				objectDef.models = new int[]
				{2570};
				objectDef.name = "Glassblowing pipe";
				objectDef.hasActions = true;
				objectDef.actions = new String[]
				{"Take", null, null, null, null};
				break;

			case 15270:
				objectDef.models = new int[]
				{21519};
				objectDef.name = "Ladder";
				objectDef.hasActions = true;
				objectDef.actions = new String[]
				{"Climb-down", null, null, null, null};
				break;

			case 15271:
				objectDef.models = new int[]
				{1208};
				objectDef.name = "Ladder";
				objectDef.hasActions = true;
				objectDef.actions = new String[]
				{"Climb-up", null, null, null, null};
				break;

			case 15275:
				objectDef.models = new int[]
				{2648};
				objectDef.name = "Battlestaff";
				objectDef.hasActions = true;
				objectDef.actions = new String[]
				{"Take", null, null, null, null};
				break;

				// Chairs (the ones Donators use)
			case 13665:
			case 13666:
			case 13667:
			case 13668:
			case 13671:
			case 1097:
			case 1098:
			case 1099:
				objectDef.name = null;
				objectDef.hasActions = false;
				objectDef.ghost = true;
				objectDef.description = null;
				objectDef.holdsItemPiles = 0; //Fixes items appearing on top of the object
				objectDef.actions = new String[5];
				break;

			// Altar of the occult.
			case 29150:
				objectDef.actions = new String[5];
				objectDef.actions[0] = "Spellbook-swap";
				objectDef.actions[1] = "Modern";
				objectDef.actions[2] = "Ancient magicks";
				objectDef.actions[3] = "Lunar";
				break;
			case 31625:
				objectDef.name = "Fountain of Uhld";
				objectDef.actions = new String[5];
				objectDef.actions[0] = "Inspect";
				break;
			case 27277:
				objectDef.name = "Blood key chest";
				objectDef.actions = new String[5];
				break;
			// Max cape stand
			case 29170:
				objectDef.actions = new String[5];
				objectDef.actions[0] = "Inspect";
				objectDef.name = "Mounted cape stand";
				break;
			// Abyssal Rift
			case 26149:
				objectDef.name = "Rift";
				objectDef.actions = new String[5];
				objectDef.actions[0] = "Teleport";
				break;
			// Highscores statue
			case 14507:
				objectDef.name = "Highscores statue";
				objectDef.actions = new String[5];
				objectDef.actions[0] = "View";
				break;
			case 563:
				objectDef.name = "Highscores statue";
				objectDef.actions = new String[5];
				objectDef.actions[0] = "View";
				break;
			case 444:
			case 445:
			case 446:
			case 1281:
				objectDef.blocksWalk = false;
				objectDef.blocksProjectiles = false;
				break;
			case 26492:
				objectDef.actions = new String[]
				{"View", null, null, null, null};
				objectDef.name = "Game Updates (Opens Browser)";
				break;
		}
		
		if (objectId >= 26796 && objectId <= 26812) {
			objectDef.actions = new String[]
			{null, null, null, null, null};
			objectDef.name = "Game updates list";
		}
	}

	private static int objectIdFixes(int objectId) {
		// Farming patch fix at Entrana, so weird.
		// the object is 8174, but all the data it grabs is from object 8210, other clients have this sorted out except mine..
		if (objectId == 30479) {
			return 8133;
		}
		if (objectId == 8174) {
			return 8210;
		}
		if (objectId >= 2570 && objectId <= 2574) {
			objectId = 1;
		}

		return objectId;
	}

	public static void writeToFile() throws IOException {
		Path path = Paths.get("object_list.txt");

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()))) {
			for (int id = 0; id < totalObjects; id++) {
				ObjectDefinition definition = forId(id);

				if (definition == null) {
					continue;
				}
				writer.write(String.format("id=%s, name=%s, type=%s", id, definition.name, definition.type));
				writer.newLine();
			}
		}
	}

	private static void debug(ObjectDefinition objectDef) {
	}

	public void setDefaults() {
		models = null;
		modelTypes = null;
		name = null;
		description = null;
		modelColourToEdit = null;
		newModelColourProduced = null;
		sizeX = 1;
		sizeY = 1;
		blocksWalk = true;
		blocksProjectiles = true;
		hasActions = false;
		adjustsToTerrain = false;
		isFlatShaded = false;
		isSolid = false;
		animationID = -1;
		wallWidth = 16;
		brightness = 0;
		contrast = 0;
		actions = null;
		icon = -1;
		mapscene = -1;
		rotateLeft = false;
		castsShadow = true;
		scaleX = 128;
		scaleY = 128;
		scaleZ = 128;
		rotationFlags = 0;
		offsetX = 0;
		offsetY = 0;
		offsetZ = 0;
		isDecoration = false;
		ghost = false;
		holdsItemPiles = -1;
		varbit = -1;
		setting = -1;
		childrenIDs = null;
	}

	public void requestModels(OnDemandFetcher class42_sub1) {
		if (models == null)
			return;
		for (int j = 0; j < models.length; j++)
			class42_sub1.sendPassively(models[j] & 0xffff, 0);
	}

	public static void nullLoader() {
		mruNodes1 = null;
		mruNodes2 = null;
		streamIndices = null;
		cache = null;
		stream = null;
	}

	public static int totalObjects;

	public static void unpackConfig(StreamLoader streamLoader) {
		stream = new Stream(streamLoader.getDataForName("loc.dat"));
		Stream stream = new Stream(streamLoader.getDataForName("loc.idx"));
		totalObjects = stream.readUnsignedWord();

		streamIndices = new int[totalObjects];
		if (ClientDebugConfiguration.DEBUG_MODE) {
			Utility.print(String.format("Loaded %d objects", totalObjects));
		}
		int i = 2;
		for (int j = 0; j < totalObjects; j++) {
			streamIndices[j] = i;
			i += stream.readUnsignedWord();
		}
		cache = new ObjectDefinition[20];
		for (int k = 0; k < 20; k++)
			cache[k] = new ObjectDefinition();
	}

	public boolean modelIsValid(int i) {
		if (modelTypes == null) {
			if (models == null)
				return true;
			if (i != 10)
				return true;
			boolean flag1 = true;
			for (int k = 0; k < models.length; k++) {
				flag1 &= Model.isCached(models[k] & 0xffff);
			}
			return flag1;
		}
		for (int j = 0; j < modelTypes.length; j++) {
			if (modelTypes[j] == i) {
				return Model.isCached(models[j] & 0xffff);
			}
		}
		return true;
	}

	public Model getAdjustedModel(int i, int j, int k, int l, int i1, int j1, int k1) {
		Model model = getModel(i, k1, j);
		if (model == null)
			return null;
		if (adjustsToTerrain || isFlatShaded)
			model = new Model(adjustsToTerrain, isFlatShaded, model);
		if (adjustsToTerrain) {
			int l1 = (k + l + i1 + j1) / 4;
			for (int i2 = 0; i2 < model.vertexCount; i2++) {
				int j2 = model.anIntArray1627[i2];
				int k2 = model.anIntArray1629[i2];
				int l2 = k + ((l - k) * (j2 + 64)) / 128;
				int i3 = j1 + ((i1 - j1) * (j2 + 64)) / 128;
				int j3 = l2 + ((i3 - l2) * (k2 + 64)) / 128;
				model.anIntArray1628[i2] += j3 - l1;
			}

			model.method467();
		}
		return model;
	}

	public boolean modelIsValid() {
		if (models == null)
			return true;
		boolean flag1 = true;
		for (int i = 0; i < models.length; i++)
			flag1 &= Model.isCached(models[i] & 0xffff);
		return flag1;
	}

	public ObjectDefinition getOverride() {
		int i = -1;
		if (varbit != -1) {
			VarBit varBit = VarBit.cache[varbit];
			int j = varBit.setting;
			int k = varBit.startbit;
			int l = varBit.endbit;
			int i1 = Client.BIT_MASK[l - k];
			i = clientInstance.variousSettings[j] >> k & i1;
		}
		else if (setting != -1)
			i = clientInstance.variousSettings[setting];
		if (i < 0 || i >= childrenIDs.length || childrenIDs[i] == -1)
			return null;
		else
			return forId(childrenIDs[i]);
	}

	public Model getModel(int j, int k, int l) {
		Model model = null;
		long l1;
		if (modelTypes == null) {
			if (j != 10)
				return null;
			l1 = (long) ((type << 6) + l) + ((long) (k + 1) << 32);
			Model model_1 = (Model) mruNodes2.insertFromCache(l1);
			if (model_1 != null)
				return model_1;
			if (models == null)
				return null;
			boolean flag1 = rotateLeft ^ (l > 3);
			int k1 = models.length;
			for (int i2 = 0; i2 < k1; i2++) {
				int l2 = models[i2];
				if (flag1) {
					l2 += 0x10000;
				}
				model = (Model) mruNodes1.insertFromCache(l2);
				if (model == null) {
					model = Model.getModel(l2 & 0xffff);
					if (model == null)
						return null;
					if (flag1)
						model.method477();
					mruNodes1.removeFromCache(model, l2);
				}
				if (k1 > 1)
					aModelArray741s[i2] = model;
			}

			if (k1 > 1)
				model = new Model(k1, aModelArray741s);
		}
		else {
			int i1 = -1;
			for (int j1 = 0; j1 < modelTypes.length; j1++) {
				if (modelTypes[j1] != j)
					continue;
				i1 = j1;
				break;
			}

			if (i1 == -1)
				return null;
			l1 = (long) ((type << 8) + (i1 << 3) + l) + ((long) (k + 1) << 32);
			Model model_2 = (Model) mruNodes2.insertFromCache(l1);
			if (model_2 != null)
				return model_2;
			int j2 = models[i1];
			boolean flag3 = rotateLeft ^ (l > 3);
			if (flag3)
				j2 += 0x10000;
			model = (Model) mruNodes1.insertFromCache(j2);
			if (model == null) {
				model = Model.getModel(j2 & 0xffff);
				if (model == null)
					return null;
				if (flag3)
					model.method477();
				mruNodes1.removeFromCache(model, j2);
			}
		}
		boolean flag;
		flag = scaleX != 128 || scaleY != 128 || scaleZ != 128;
		boolean flag2;
		flag2 = offsetX != 0 || offsetY != 0 || offsetZ != 0;
		Model model_3 = new Model(modelColourToEdit == null, Frames.isNegativeZero(k), l == 0 && k == -1 && !flag && !flag2, model);
		if (k != -1) {
			model_3.method469();
			model_3.method470(k);
			model_3.anIntArrayArray1658 = null;
			model_3.anIntArrayArray1657 = null;
		}
		while (l-- > 0)
			model_3.method473();
		if (modelColourToEdit != null) {
			for (int k2 = 0; k2 < modelColourToEdit.length; k2++)
				model_3.setColour(modelColourToEdit[k2], newModelColourProduced[k2]);

		}
		if (flag)
			model_3.scaleModel(scaleX, scaleZ, scaleY);
		if (flag2)
			model_3.method475(offsetX, offsetY, offsetZ);

		model_3.method479(60 + this.brightness, 768 + this.contrast, -50, -10, -50, !this.isFlatShaded); // LocoPk
		//model_3.method479(60 + ObjectDefinition.forId(type).brightness, 1500 + ObjectDefinition.forId(type).contrast, -50, -10, -50, !ObjectDefinition.forId(type).isFlatShaded); // LocoPk
		//model_3.method479(84 + ObjectDefinition.forId(type).brightness, 1500, -90, -280, -70, !isFlatShaded); // Original.
		//model_3.method479(60 + ObjectDefinition.forId(type).brightness, 768 + this.contrast, -50, -280, -70, !isFlatShaded); // Original.
		//  model_3.method479(60 + this.ambientLightning, 768 + this.lightDiffusion, -50, -10, -50, !this.delayShading);
		if (holdsItemPiles == 1)

		{
			model_3.anInt1654 = model_3.modelHeight;
		}
		mruNodes2.removeFromCache(model_3, l1);
		return model_3;

	}

	public void readValuesOsrs(Stream stream) {
		while (true) {
			int type = stream.readUnsignedByte();
			if (type == 0) {
				break;
			}
			if (type == 1) {
				int len = stream.readUnsignedByte();
				if (len > 0) {
					if (models == null || lowMem) {
						modelTypes = new int[len];
						models = new int[len];
						for (int k1 = 0; k1 < len; k1++) {
							models[k1] = stream.readUnsignedWord();
							modelTypes[k1] = stream.readUnsignedByte();
						}
					}
					else {
						stream.currentOffset += len * 3;
					}
				}
			}
			else if (type == 2) {
				name = stream.readString();
			}
			else if (type == 5) {
				int len = stream.readUnsignedByte();
				if (len > 0) {
					if (models == null || lowMem) {
						modelTypes = null;
						models = new int[len];
						for (int i = 0; i < len; i++)
							models[i] = stream.readUnsignedWord();
					}
					else {
						stream.currentOffset += len * 2;
					}
				}
			}
			else if (type == 14) {
				sizeX = stream.readUnsignedByte();
			}
			else if (type == 15) {
				sizeY = stream.readUnsignedByte();
			}
			else if (type == 17) {
				blocksWalk = false;
			}
			else if (type == 18) {
				blocksProjectiles = false;
			}
			else if (type == 19) {
				hasActions = (stream.readUnsignedByte() == 1);
			}
			else if (type == 21) {
				adjustsToTerrain = true;
			}
			else if (type == 22) {
				isFlatShaded = true;
			}
			else if (type == 23) {
				isSolid = true;
			}
			else if (type == 24) {
				animationID = stream.readUnsignedWord();
				if (animationID == 65535)
					animationID = -1;
			}
			else if (type == 27) {
				clipType = 1;
			}
			else if (type == 28) {
				wallWidth = stream.readUnsignedByte();
			}
			else if (type == 29) {
				brightness = stream.readSignedByte();
			}
			else if (type == 39) {
				contrastOsrs = stream.readSignedByte() * 25;
			}
			else if (type >= 30 && type < 35) {
				if (actions == null)
					actions = new String[5];
				actions[type - 30] = stream.readString();
				if (actions[type - 30].equalsIgnoreCase("hidden"))
					actions[type - 30] = null;
			}
			else if (type == 40) {
				int length = stream.readUnsignedByte();
				modelColourToEdit = new int[length];
				newModelColourProduced = new int[length];
				for (int i = 0; i < length; i++) {
					modelColourToEdit[i] = stream.readUnsignedWord();
					newModelColourProduced[i] = stream.readUnsignedWord();
				}

			}
			else if (type == 41) {
				int length = stream.readUnsignedByte();
				modifiedTexture = new short[length];
				originalTexture = new short[length];
				for (int i = 0; i < length; i++) {
					modifiedTexture[i] = (short) stream.readUnsignedWord();
					originalTexture[i] = (short) stream.readUnsignedWord();
				}

			}
			else if (type == 62) {
				rotateLeft = true;
			}
			else if (type == 64) {
				castsShadow = false;
			}
			else if (type == 65) {
				scaleX = stream.readUnsignedWord();
			}
			else if (type == 66) {
				scaleY = stream.readUnsignedWord();
			}
			else if (type == 67) {
				scaleZ = stream.readUnsignedWord();
			}
			else if (type == 68) {
				mapscene = stream.readUnsignedWord();
			}
			else if (type == 69) {
				rotationFlags = stream.readUnsignedByte();
			}
			else if (type == 70) {
				offsetX = stream.readSignedWord();
			}
			else if (type == 71) {
				offsetY = stream.readSignedWord();
			}
			else if (type == 72) {
				offsetZ = stream.readSignedWord();
			}
			else if (type == 73) {
				isDecoration = true;
			}
			else if (type == 74) {
				ghost = true;
			}
			else if (type == 75) {
				holdsItemPiles = stream.readUnsignedByte();
			}
			else if (type == 78) {
				stream.readUnsignedWord();
				stream.readUnsignedByte();
			}
			else if (type == 79) {
				stream.readUnsignedWord();
				stream.readUnsignedWord();
				stream.readUnsignedByte();
				int length = stream.readUnsignedByte();

				for (int i = 0; i < length; i++) {
					stream.readUnsignedWord();
				}
			}
			else if (type == 81) {
				stream.readUnsignedByte();
			}
			else if (type == 82) {
				icon = stream.readUnsignedWord();
				if (icon == 65535) {
					icon = -1;
				}
			}
			else if (type == 77 || type == 92) {
				setting = stream.readUnsignedWord();
				if (setting == 65535) {
					setting = -1;
				}
				varbit = stream.readUnsignedWord();
				if (varbit == 65535) {
					varbit = -1;
				}
				int value = -1;
				if (type == 92) {
					value = stream.readUnsignedWord();
					if (value == 65535) {
						value = -1;
					}
				}
				int length = stream.readUnsignedByte();
				childrenIDs = new int[length + 2];
				for (int i = 0; i <= length; i++) {
					childrenIDs[i] = stream.readUnsignedWord();
					if (childrenIDs[i] == 65535) {
						childrenIDs[i] = -1;
					}
				}
				childrenIDs[length + 1] = value;
			}
		}
		if (name != null && !name.equals("null")) {
			hasActions = models != null && (modelTypes == null || modelTypes[0] == 10);
			if (actions != null)
				hasActions = true;
		}
		if (ghost) {
			blocksWalk = false;
			blocksProjectiles = false;
		}
		if (holdsItemPiles == -1) {
			holdsItemPiles = blocksWalk ? 1 : 0;
		}
	}

	public void readValues(Stream stream) {
		int flag = -1;
		do {
			int type = stream.readUnsignedByte();
			if (type == 0)
				break;
			if (type == 1) {
				int len = stream.readUnsignedByte();
				if (len > 0) {
					if (models == null || lowMem) {
						modelTypes = new int[len];
						models = new int[len];
						for (int k1 = 0; k1 < len; k1++) {
							models[k1] = stream.readUnsignedWord();
							modelTypes[k1] = stream.readUnsignedByte();
						}
					}
					else {
						stream.currentOffset += len * 3;
					}
				}
			}
			else if (type == 2)
				name = stream.readString();
			else if (type == 3)
				description = stream.readBytes();
			else if (type == 5) {
				int len = stream.readUnsignedByte();
				if (len > 0) {
					if (models == null || lowMem) {
						modelTypes = null;
						models = new int[len];
						for (int l1 = 0; l1 < len; l1++)
							models[l1] = stream.readUnsignedWord();
					}
					else {
						stream.currentOffset += len * 2;
					}
				}
			}
			else if (type == 14)
				sizeX = stream.readUnsignedByte();
			else if (type == 15)
				sizeY = stream.readUnsignedByte();
			else if (type == 17)
				blocksWalk = false;
			else if (type == 18)
				blocksProjectiles = false;
			else if (type == 19) {
				flag = stream.readUnsignedByte();
				if (flag == 1)
					hasActions = true;
			}
			else if (type == 21)
				adjustsToTerrain = true;
			else if (type == 22)
				isFlatShaded = true;
			else if (type == 23)
				isSolid = true;
			else if (type == 24) {
				animationID = stream.readUnsignedWord();
				if (animationID == 65535)
					animationID = -1;
			}
			else if (type == 28)
				wallWidth = stream.readUnsignedByte();
			else if (type == 29)
				brightness = stream.readSignedByte();
			else if (type == 39)
				contrast = stream.readSignedByte();
			else if (type >= 30 && type < 39) {
				if (actions == null)
					actions = new String[5];
				actions[type - 30] = stream.readString();
				if (actions[type - 30].equalsIgnoreCase("hidden"))
					actions[type - 30] = null;
			}
			else if (type == 40) {
				int i1 = stream.readUnsignedByte();
				modelColourToEdit = new int[i1];
				newModelColourProduced = new int[i1];
				for (int i2 = 0; i2 < i1; i2++) {
					modelColourToEdit[i2] = stream.readUnsignedWord();
					newModelColourProduced[i2] = stream.readUnsignedWord();
				}

			}
			else if (type == 41) {
				int j2 = stream.readUnsignedByte();
				modifiedTexture = new short[j2];
				originalTexture = new short[j2];
				for (int k = 0; k < j2; k++) {
					modifiedTexture[k] = (short) stream.readUnsignedWord();
					originalTexture[k] = (short) stream.readUnsignedWord();
				}

			}
			else if (type == 82)
				icon = stream.readUnsignedWord();
			else if (type == 62)
				rotateLeft = true;
			else if (type == 64)
				castsShadow = false;
			else if (type == 65)
				scaleX = stream.readUnsignedWord();
			else if (type == 66)
				scaleY = stream.readUnsignedWord();
			else if (type == 67)
				scaleZ = stream.readUnsignedWord();
			else if (type == 68)
				mapscene = stream.readUnsignedWord();
			else if (type == 69)
				rotationFlags = stream.readUnsignedByte();
			else if (type == 70)
				offsetX = stream.readSignedWord();
			else if (type == 71)
				offsetY = stream.readSignedWord();
			else if (type == 72)
				offsetZ = stream.readSignedWord();
			else if (type == 73)
				isDecoration = true;
			else if (type == 74)
				ghost = true;
			else if (type == 75)
				holdsItemPiles = stream.readUnsignedByte();
			else if (type == 77) {
				varbit = stream.readUnsignedWord();
				if (varbit == 65535)
					varbit = -1;
				setting = stream.readUnsignedWord();
				if (setting == 65535)
					setting = -1;
				int j1 = stream.readUnsignedByte();
				childrenIDs = new int[j1 + 1];
				for (int j2 = 0; j2 <= j1; j2++) {
					childrenIDs[j2] = stream.readUnsignedWord();
					if (childrenIDs[j2] == 65535)
						childrenIDs[j2] = -1;
				}
			}
		}
		while (true);
		if (flag == -1 && name != "null" && name != null) {
			hasActions = models != null && (modelTypes == null || modelTypes[0] == 10);
			if (actions != null)
				hasActions = true;
		}
		if (ghost) {
			blocksWalk = false;
			blocksProjectiles = false;
		}
		if (holdsItemPiles == -1)
			holdsItemPiles = blocksWalk ? 1 : 0;
	}

	public ObjectDefinition() {
		type = -1;
	}

	public boolean isDecoration;

	public byte brightness;

	public int offsetX;

	public String name;

	public int scaleZ;

	public static final Model[] aModelArray741s = new Model[4];

	public byte contrast;

	public int contrastOsrs;

	public int sizeX;

	public int offsetY;

	public int icon;

	public int[] newModelColourProduced;

	public int scaleX;

	public int setting;

	public boolean rotateLeft;

	public static boolean lowMem;

	public static Stream stream;

	public int type;

	public static int[] streamIndices;

	public boolean blocksProjectiles;

	public int mapscene;

	public int childrenIDs[];

	public int holdsItemPiles;

	public int sizeY;

	public boolean adjustsToTerrain;

	public boolean isSolid;

	public static Client clientInstance;

	public boolean ghost;

	public boolean blocksWalk;

	public int rotationFlags;

	public boolean isFlatShaded;

	public static int cacheIndex;

	public int scaleY;

	public int[] models;

	public int varbit;

	public int wallWidth;

	public int[] modelTypes;

	public byte description[];

	public boolean hasActions;

	public boolean castsShadow;

	public static ReferenceCache mruNodes2 = new ReferenceCache(30);

	public int animationID;

	public static ObjectDefinition[] cache;

	public int offsetZ;

	public int[] modelColourToEdit;

	public static ReferenceCache mruNodes1 = new ReferenceCache(500);

	public String actions[];

	public int clipType = 2;

	private short[] originalTexture;

	private short[] modifiedTexture;

}