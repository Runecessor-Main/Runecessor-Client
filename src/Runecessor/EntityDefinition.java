package Runecessor;

public final class EntityDefinition {

	public static EntityDefinition forId(int i) {
		if (i > streamIndices.length - 1) {
			if (Config.PRE_EOC) {
				i = 0;
			}
			else {
				return null;
			}
		}
		if (!Client.itemUpdate) {
			for (int j = 0; j < 20; j++) {
				if (cache[j].type == (long) i) {
					if (!Config.PRE_EOC) {
						return cache[j];
					}
				}
			}
		}

		cachePosition = (cachePosition + 1) % 20;
		EntityDefinition npc = cache[cachePosition] = new EntityDefinition();
		if (!Config.PRE_EOC) {
			if (i == 65535) {
				i = 0;
			}
		}
		npc.type = i;
		stream.currentOffset = streamIndices[i];
		if (Config.PRE_EOC) {
			npc.readValuesPreEoc(i, stream);
		}
		else {
			npc.readValuesOsrs(i, stream);
		}
		boolean debug = false;
		int npcId = 6637;
		if (debug) {
			if (npcId == i) {
				Utility.print("NPC: " + i + ", stand: " + npc.standAnim + ", " + npc.walkAnim);
				if (npc.models != null) {
					for (int index = 0; index < npc.models.length; index++) {
						Utility.print("NPC: " + i + ", model[" + index + "]: " + npc.models[index]);
					}
				}

			}
		}

		if (i == 7544) {
			if (npc.modelColourToEdit != null) {
				Utility.print("npc.modelColourToEdit = new int[" + npc.modelColourToEdit.length + "];");
				for (int a = 0; a < npc.modelColourToEdit.length; a++) {
					Utility.print("npc.modelColourToEdit[" + a + "] = " + npc.modelColourToEdit[a] + ";");
				}
			}
			if (npc.newModelColourProduced != null) {
				Utility.print("npc.newModelColourProduced = new int[" + npc.newModelColourProduced.length + "];");
				for (int a = 0; a < npc.newModelColourProduced.length; a++) {
					Utility.print("npc.newModelColourProduced[" + a + "] = " + npc.newModelColourProduced[a] + ";");
				}
			}
		}
		boolean stop = false;
		if (stop) {
			return npc;
		}

		// 35338 is highest model id used by 167 data.
		// 667 data highest model id is 66k.
		// 8336 is the highest npc id used for 170 data
		customNpcsOsrs(npc, i);

		return npc;
	}

	private static void customNpcsOsrs(EntityDefinition npc, int i) {
		if (Config.PRE_EOC) {
			return;
		}
		EntityDefinition data = null;
		ItemDefinition itemData = null;
		ObjectDefinition objectInstance = null;
		int colour = -1;
		/*
		 * 
				Model model = Model.getModel(data.models[0]);
				if (model != null) {
					Utility.print("Models length: " + data.models.length);
					model.printAllColours(0);
				}
		 */
		switch (i) {
		
		
		case 2912:
		case 2911:
			npc.actions = new String[5];
			npc.actions[0] = null;
		
			break;
		case 11215:
			
			data = forId(762);
			npc.name = "Yveltal";
			npc.size = 3;
			npc.actions = new String[5];
			npc.actions[0] = null;
			npc.actions[1] = "Attack";
			npc.actions[2] = null;
			npc.actions[3] = null;
			npc.actions[4] = null;
			npc.models = new int[1];
			npc.models[0] = 40043;
			npc.standAnim = data.standAnim;
			npc.walkAnim = data.walkAnim;
			npc.turn180Sequence = data.walkAnim;
			npc.turnLeftSequence = data.walkAnim;
			npc.turnRightSequence = data.walkAnim;
			npc.showOnMinimap = true;
			npc.scaleZ = 70;
			npc.scaleX = 70;
			npc.combatLevel = 999;
			break;
case 11216:
			
			data = forId(762);
			npc.name = "Yveltal's Offspring";
			npc.size = 1;
			npc.actions = new String[5];
			npc.actions[0] = "Return";
			npc.actions[1] = null;
			npc.actions[2] = null;
			npc.actions[3] = null;
			npc.actions[4] = null;
			npc.models = new int[1];
			npc.models[0] = 40043;
			npc.standAnim = data.standAnim;
			npc.walkAnim = data.walkAnim;
			npc.turn180Sequence = data.walkAnim;
			npc.turnLeftSequence = data.walkAnim;
			npc.turnRightSequence = data.walkAnim;
			npc.showOnMinimap = true;
			npc.scaleZ = 25;
			npc.scaleX = 25;
			npc.combatLevel = 999;
			break;
case 11217:
	
	data = forId(762);
	npc.name = "Yveltal's Offspring";
	npc.size = 1;
	npc.actions = new String[5];
	npc.actions[0] = "Return";
	npc.actions[1] = null;
	npc.actions[2] = null;
	npc.actions[3] = null;
	npc.actions[4] = null;
	npc.models = new int[1];
	npc.models[0] = 65351;
	npc.standAnim = data.standAnim;
	npc.walkAnim = data.walkAnim;
	npc.turn180Sequence = data.walkAnim;
	npc.turnLeftSequence = data.walkAnim;
	npc.turnRightSequence = data.walkAnim;
	npc.showOnMinimap = true;
	npc.scaleZ = 25;
	npc.scaleX = 25;
	npc.combatLevel = 999;
	break;
case 385:
	npc.name = "Bad Bunny";
	npc.walkAnim = 1660;
	npc.standAnim = 11973;
	npc.models = new int[9];
	npc.models[0] = 65347; //HEAD
	npc.models[1] = 246; //JAW
	npc.models[2] = 31188; //CHEST
	npc.models[3] = 29316; //CAPE
	npc.models[4] = 31187; //ARM
	npc.models[5] = 31185; //HAND
	npc.models[6] = 65343; //WEP
	npc.models[7] = 31186; //LEG
	npc.models[8] = 29189; //BOOT
	npc.actions = new String[5];
	npc.actions[0] = null;
	npc.actions[1] = "Attack";
	npc.actions[2] = null;
	npc.actions[3] = null;
	npc.actions[4] = null;
	npc.combatLevel = 420;
	npc.scaleZ = 350;
	npc.scaleX = 350;
	break;
case 539:
	npc.name = "Bunny Slayer";
	npc.walkAnim = 1660;
	npc.standAnim = 11973;
	npc.models = new int[9];
	npc.models[0] = 65345; //HEAD
	npc.models[1] = 246; //JAW
	npc.models[2] = 27644; //CHEST
	npc.models[3] = 31234; //CAPE
	npc.models[4] = 28827; //ARM
	npc.models[5] = 356; //HAND
	npc.models[6] = 26281; //WEP
	npc.models[7] = 27640; //LEG
	npc.models[8] = 19951; //BOOT
	npc.actions = new String[5];
	npc.actions[0] = "Speak With";
	npc.actions[1] = null;
	npc.actions[2] = "Trade";
	npc.actions[3] = null;
	npc.actions[4] = null;
	npc.combatLevel = 126;
	npc.scaleZ = 130;
	npc.scaleX = 130;
	break;
case 300:
	npc.name = "Eggcelent Guardian";
	npc.walkAnim = 1660;
	npc.standAnim = 11973;
	npc.models = new int[9];
	npc.models[0] = 6695; //HEAD
	npc.models[1] = 246; //JAW
	npc.models[2] = 28534; //CHEST
	npc.models[3] = 3189; //CAPE
	npc.models[4] = 28532; //ARM
	npc.models[5] = 179; //HAND
	npc.models[6] = 65343; //WEP
	npc.models[7] = 28531; //LEG
	npc.models[8] = 16009; //BOOT
	npc.actions = new String[5];
	npc.actions[0] = null;
	npc.actions[1] = "Whoop";
	npc.actions[2] = null;
	npc.actions[3] = null;
	npc.actions[4] = null;
	npc.combatLevel = 95;
	npc.scaleZ = 130;
	npc.scaleX = 130;
	break;
			case 11214 :
				data = forId(7531);
				npc.name = "Vespula";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;
				npc.scaleZ = 31;
				npc.scaleX = 31;

				npc.modelColourToEdit = new int[25];
				npc.newModelColourProduced = new int[25];

				// Originally red.
				colour = ItemColours.PURPLE + 2;
				npc.modelColourToEdit[3] = 920;
				npc.newModelColourProduced[3] = colour == -1 ? 920 : colour;

				colour = ItemColours.PURPLE + 4;
				npc.modelColourToEdit[23] = 922;
				npc.newModelColourProduced[23] = colour == -1 ? 922 : colour;

				colour = ItemColours.PURPLE + 6;
				npc.modelColourToEdit[14] = 924;
				npc.newModelColourProduced[14] = colour == -1 ? 924 : colour;

				colour = ItemColours.PURPLE + 8;
				npc.modelColourToEdit[1] = 926;
				npc.newModelColourProduced[1] = colour == -1 ? 926 : colour;

				colour = ItemColours.PURPLE + 10;
				npc.modelColourToEdit[7] = 929;
				npc.newModelColourProduced[7] = colour == -1 ? 929 : colour;

				colour = ItemColours.PURPLE + 12;
				npc.modelColourToEdit[19] = 931;
				npc.newModelColourProduced[19] = colour == -1 ? 931 : colour;

				colour = ItemColours.PURPLE + 14;
				npc.modelColourToEdit[20] = 933;
				npc.newModelColourProduced[20] = colour == -1 ? 933 : colour;
				
				// Originally black

				colour = -1;
				npc.modelColourToEdit[4] = 0;
				npc.newModelColourProduced[4] = colour == -1 ? 0 : colour;

				colour = -1;
				npc.modelColourToEdit[22] = 8;
				npc.newModelColourProduced[22] = colour == -1 ? 8 : colour;

				colour = -1;
				npc.modelColourToEdit[24] = 16;
				npc.newModelColourProduced[24] = colour == -1 ? 16 : colour;

				colour = -1;
				npc.modelColourToEdit[13] = 24;
				npc.newModelColourProduced[13] = colour == -1 ? 24 : colour;
				
				// Originally green/yellow
				
				colour = ItemColours.GOLD + 1;
				npc.modelColourToEdit[0] = 14292;
				npc.newModelColourProduced[0] = colour == -1 ? 14292 : colour;

				colour = ItemColours.GOLD + 2;
				npc.modelColourToEdit[2] = 798;
				npc.newModelColourProduced[2] = colour == -1 ? 798 : colour;

				colour = ItemColours.GOLD + 4;
				npc.modelColourToEdit[5] = 794;
				npc.newModelColourProduced[5] = colour == -1 ? 794 : colour;

				colour = ItemColours.GOLD + 6;
				npc.modelColourToEdit[6] = 15273;
				npc.newModelColourProduced[6] = colour == -1 ? 15273 : colour;

				colour = ItemColours.GOLD + 8;
				npc.modelColourToEdit[8] = 14284;
				npc.newModelColourProduced[8] = colour == -1 ? 14284 : colour;

				colour = ItemColours.GOLD + 10;
				npc.modelColourToEdit[9] = 16270;
				npc.newModelColourProduced[9] = colour == -1 ? 16270 : colour;

				colour = ItemColours.GOLD + 13;
				npc.modelColourToEdit[10] = 11216;
				npc.newModelColourProduced[10] = colour == -1 ? 11216 : colour;

				colour = ItemColours.GOLD + 15;
				npc.modelColourToEdit[11] = 11187;
				npc.newModelColourProduced[11] = colour == -1 ? 11187 : colour;

				colour = ItemColours.GOLD + 18;
				npc.modelColourToEdit[12] = 22424;
				npc.newModelColourProduced[12] = colour == -1 ? 22424 : colour;

				colour = ItemColours.GOLD + 20;
				npc.modelColourToEdit[15] = 15250;
				npc.newModelColourProduced[15] = colour == -1 ? 15250 : colour;

				colour = ItemColours.GOLD + 24;
				npc.modelColourToEdit[16] = 14259;
				npc.newModelColourProduced[16] = colour == -1 ? 14259 : colour;

				colour = ItemColours.GOLD + 26;
				npc.modelColourToEdit[17] = 14230;
				npc.newModelColourProduced[17] = colour == -1 ? 14230 : colour;

				colour = ItemColours.GOLD + 28;
				npc.modelColourToEdit[18] = 7068;
				npc.newModelColourProduced[18] = colour == -1 ? 7068 : colour;

				colour = ItemColours.GOLD + 30;
				npc.modelColourToEdit[21] = 18314;
				npc.newModelColourProduced[21] = colour == -1 ? 18314 : colour;
				break;
			case 3902:
				npc.name = "@gre@Easter EvENT]";
				npc.actions = new String[5];
				npc.actions[0] = "Talk-to";
				npc.actions[1] = null;
				break;
			case 5417 :
				npc.name = "@whi@Gambler @yel@[Double items]";
				npc.actions = new String[5];
				npc.actions[0] = "Talk-to";
				npc.actions[1] = null;
				npc.actions[2] = "Quick-gamble";
				break;
			case 11213 :
				data = forId(7891);
				npc.name = "Noon";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;
				npc.scaleZ = 35;
				npc.scaleX = 35;
				npc.modelColourToEdit = new int[14];
				npc.newModelColourProduced = new int[14];
				colour = 127;
				npc.modelColourToEdit[0] = -19498;
				npc.newModelColourProduced[0] = colour == -1 ? -19498 : colour;

				colour = 934;
				npc.modelColourToEdit[1] = -19500;
				npc.newModelColourProduced[1] = colour == -1 ? -19500 : colour;

				colour = 124;
				npc.modelColourToEdit[2] = 22464;
				npc.newModelColourProduced[2] = colour == -1 ? 22464 : colour;

				colour = 120;
				npc.modelColourToEdit[3] = -21568;
				npc.newModelColourProduced[3] = colour == -1 ? -21568 : colour;

				colour = 115;
				npc.modelColourToEdit[4] = 960;
				npc.newModelColourProduced[4] = colour == -1 ? 960 : colour;

				colour = 110;
				npc.modelColourToEdit[5] = 21526;
				npc.newModelColourProduced[5] = colour == -1 ? 21526 : colour;

				npc.modelColourToEdit[6] = 21530;
				npc.newModelColourProduced[6] = colour == -1 ? 21530 : colour;

				npc.modelColourToEdit[7] = 21522;
				npc.newModelColourProduced[7] = colour == -1 ? 21522 : colour;

				npc.modelColourToEdit[8] = 21534;
				npc.newModelColourProduced[8] = colour == -1 ? 21534 : colour;

				colour = 926;
				npc.modelColourToEdit[9] = -20037;
				npc.newModelColourProduced[9] = colour == -1 ? -20037 : colour;

				colour = 920;
				npc.modelColourToEdit[10] = -21046;
				npc.newModelColourProduced[10] = colour == -1 ? -21046 : colour;

				colour = 105;
				npc.modelColourToEdit[11] = 0;
				npc.newModelColourProduced[11] = colour == -1 ? 0 : colour;

				colour = 120;
				npc.modelColourToEdit[12] = -19520;
				npc.newModelColourProduced[12] = colour == -1 ? -19520 : colour;

				colour = 127;
				npc.modelColourToEdit[13] = -17454;
				npc.newModelColourProduced[13] = colour == -1 ? -17454 : colour;
				break;
			case 11212:
				data = forId(1873);
				npc.name = "Nocturnal Yoshi";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;

				npc.modelColourToEdit = new int[14];
				npc.newModelColourProduced = new int[14];

				// Dark green
				colour = 49863;
				npc.modelColourToEdit[0] = 29976;
				npc.newModelColourProduced[0] = colour == -1 ? 29976 : colour;

				colour = 49863;
				npc.modelColourToEdit[2] = 27819;
				npc.newModelColourProduced[2] = colour == -1 ? 27819 : colour;

				colour = 0;
				npc.modelColourToEdit[4] = 29980;
				npc.newModelColourProduced[4] = colour == -1 ? 29980 : colour;

				colour = 0;
				npc.modelColourToEdit[5] = 28302;
				npc.newModelColourProduced[5] = colour == -1 ? 28302 : colour;

				// Very dark green
				colour = 0;
				npc.modelColourToEdit[6] = 29980;
				npc.newModelColourProduced[6] = colour == -1 ? 29980 : colour;

				// Cream
				colour = 127;
				npc.modelColourToEdit[7] = 27934;
				npc.newModelColourProduced[7] = colour == -1 ? 27934 : colour;

				colour = 127;
				npc.modelColourToEdit[1] = 7502;
				npc.newModelColourProduced[1] = colour == -1 ? 7502 : colour;

				colour = 127;
				npc.modelColourToEdit[3] = 0;
				npc.newModelColourProduced[3] = colour == -1 ? 0 : colour;

				// Blue and dark blue
				// Circle on the ground, most inner first circle
				colour = 51155;
				npc.modelColourToEdit[8] = -26214;
				npc.newModelColourProduced[8] = colour == -1 ? -26214 : colour;

				// Second circle
				colour = 51150;
				npc.modelColourToEdit[9] = -26218;
				npc.newModelColourProduced[9] = colour == -1 ? -26218 : colour;

				// Third circle
				colour = 51145;
				npc.modelColourToEdit[10] = -26094;
				npc.newModelColourProduced[10] = colour == -1 ? -26094 : colour;

				// Fourth circle
				colour = 51140;
				npc.modelColourToEdit[11] = -25970;
				npc.newModelColourProduced[11] = colour == -1 ? -25970 : colour;

				// Fifth circle
				colour = 51136;
				npc.modelColourToEdit[12] = -25718;
				npc.newModelColourProduced[12] = colour == -1 ? -25718 : colour;

				// Sixth circle
				colour = 51133;
				npc.modelColourToEdit[13] = -23672;
				npc.newModelColourProduced[13] = colour == -1 ? -23672 : colour;
				break;

			case 11211 :
				data = forId(5567);
				npc.name = "Death pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 100;
				npc.scaleX = 100;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				npc.modelColourToEdit = new int[13];
				npc.newModelColourProduced = new int[13];
				npc.models[5] = 35371;

				// Black
				colour = 58325;
				npc.modelColourToEdit[0] = 0;
				npc.newModelColourProduced[0] = colour == -1 ? 0 : colour;

				colour = 58325;
				npc.modelColourToEdit[3] = 8741;
				npc.newModelColourProduced[3] = colour == -1 ? 8741 : colour;

				colour = 58325;
				npc.modelColourToEdit[7] = 25238;
				npc.newModelColourProduced[7] = colour == -1 ? 25238 : colour;

				colour = -1;
				npc.modelColourToEdit[1] = 5231;
				npc.newModelColourProduced[1] = colour == -1 ? 5231 : colour;

				// White
				colour = 80;
				npc.modelColourToEdit[2] = 5353;
				npc.newModelColourProduced[2] = colour == -1 ? 5353 : colour;

				colour = -1;
				npc.modelColourToEdit[4] = 4550;
				npc.newModelColourProduced[4] = colour == -1 ? 4550 : colour;

				colour = -1;
				npc.modelColourToEdit[5] = 8741;
				npc.newModelColourProduced[5] = colour == -1 ? 8741 : colour;

				colour = -1;
				npc.modelColourToEdit[6] = 10004;
				npc.newModelColourProduced[6] = colour == -1 ? 10004 : colour;

				colour = -1;
				npc.modelColourToEdit[8] = 0;
				npc.newModelColourProduced[8] = colour == -1 ? 0 : colour;

				colour = -1;
				npc.modelColourToEdit[9] = 908;
				npc.newModelColourProduced[9] = colour == -1 ? 908 : colour;

				colour = -1;
				npc.modelColourToEdit[10] = 5541;
				npc.newModelColourProduced[10] = colour == -1 ? 5541 : colour;

				colour = -1;
				npc.modelColourToEdit[11] = 7073;
				npc.newModelColourProduced[11] = colour == -1 ? 7073 : colour;

				colour = -1;
				npc.modelColourToEdit[12] = 61;
				npc.newModelColourProduced[12] = colour == -1 ? 61 : colour;
				break;
			
			case 8193:
				npc.name = "Fiona";
				npc.actions = new String[]
				{"View-shop", null, null, null, null};
				npc.models = new int[]
				{31834, 456, 332, 353, 428, 16011, 10745, 34288};
				npc.modelColourToEdit = new int[]
				{25238, 8741, 6798};
				npc.newModelColourProduced = new int[]
				{127, 127, 127};
				break;

			case 4712:
				npc.name = "Fishing spot";
				npc.actions = new String[5];
				npc.actions[0] = "Fish-karambwan";
				npc.actions[1] = null;
				npc.actions[4] = null;
				npc.actions[4] = null;
				npc.actions[4] = null;
				npc.description = "Karambwan can be caught here.";
				break;

			case 7285:
				npc.standAnim = 808;
				npc.walkAnim = 819;
				break;

			// Schoolgirl pet (brown skin)
			case 11210:
				npc.name = "Schoolgirl";
				npc.size = 1;
				npc.standAnim = 6472;
				npc.walkAnim = 6471;
				npc.turnLeftSequence = 6471;
				npc.turnRightSequence = 6471;
				npc.turn180Sequence = 6471;
				npc.turnSpeed = 32;
				npc.varbit = -1;
				npc.setting = -1;
				npc.headicons = -1;
				npc.scaleZ = 128;
				npc.scaleX = 128;
				npc.interactable = true;
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.actions[1] = null;
				npc.actions[2] = null;
				npc.actions[3] = null;
				npc.actions[4] = null;
				npc.models = new int[3];
				npc.models[0] = 25847;
				npc.models[1] = 25845;
				npc.models[2] = 25844;
				npc.modelColourToEdit = new int[6];
				npc.modelColourToEdit[0] = 206;
				npc.modelColourToEdit[1] = 41145;
				npc.modelColourToEdit[2] = 6550;
				npc.modelColourToEdit[3] = 189;
				npc.modelColourToEdit[4] = 933;
				npc.newModelColourProduced = new int[6];
				npc.newModelColourProduced[0] = 6967;
				npc.newModelColourProduced[1] = 23843;
				npc.newModelColourProduced[2] = 0;
				npc.newModelColourProduced[3] = 7083;
				npc.newModelColourProduced[4] = 9152;

				colour = 405;
				npc.modelColourToEdit[5] = 4550;
				npc.newModelColourProduced[5] = colour == -1 ? 4550 : colour;
				npc.showOnMinimap = false;
				break;
			// Gnosi
			case 7596:
				npc.name = "Gnosi";
				npc.size = 1;
				npc.standAnim = 7203;
				npc.walkAnim = 7203;
				npc.turnLeftSequence = 7203;
				npc.turnRightSequence = 7203;
				npc.turn180Sequence = 7203;
				npc.turnSpeed = 32;
				npc.varbit = -1;
				npc.setting = -1;
				npc.headicons = -1;
				npc.scaleZ = 128;
				npc.scaleX = 128;
				npc.interactable = true;
				npc.showOnMinimap = true;
				npc.hasRenderPriority = true;
				npc.actions = new String[5];
				npc.actions[0] = "Talk-to";
				npc.actions[1] = null;
				npc.actions[2] = null;
				npc.actions[3] = null;
				npc.actions[4] = null;
				npc.models = new int[1];
				npc.models[0] = 30557;
				npc.modelColourToEdit = new int[4];
				npc.modelColourToEdit[0] = 43282;
				npc.modelColourToEdit[1] = 43286;
				npc.modelColourToEdit[2] = 43662;
				npc.modelColourToEdit[3] = 43406;
				npc.newModelColourProduced = new int[4];
				npc.newModelColourProduced[0] = 24;
				npc.newModelColourProduced[1] = 28;
				npc.newModelColourProduced[2] = 20;
				npc.newModelColourProduced[3] = 12;
				break;

			case 7860:
				npc.scaleZ = 150;
				npc.scaleX = 150;
				npc.name = "Zinferno";
				npc.combatLevel = 999;
				break;

			case 11209:
				data = forId(319);
				npc.name = "Corporeal beast pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 64;
				npc.scaleX = 64;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;
				npc.modelColourToEdit = new int[11];
				npc.newModelColourProduced = new int[11];
				
				// Black
				colour = -1;
				npc.modelColourToEdit[0] = 0;
				npc.newModelColourProduced[0] = colour == -1 ? 0 : colour;

				// White
				colour = 296770;
				npc.modelColourToEdit[6] = 103;
				npc.newModelColourProduced[6] = colour == -1 ? 103 : colour;

				// Dark Grey
				colour = 296770;
				npc.modelColourToEdit[7] = 16;
				npc.newModelColourProduced[7] = colour == -1 ? 16 : colour;

				// Dark grey
				colour = 296730;
				npc.modelColourToEdit[10] = 18;
				npc.newModelColourProduced[10] = colour == -1 ? 18 : colour;

				// Brown
				colour = 10;
				npc.modelColourToEdit[1] = 6340;
				npc.newModelColourProduced[1] = colour == -1 ? 6340 : colour;

				// Brown
				colour = 8;
				npc.modelColourToEdit[5] = 6336;
				npc.newModelColourProduced[5] = colour == -1 ? 6336 : colour;

				// Dark brown
				colour = 7;
				npc.modelColourToEdit[2] = 6315;
				npc.newModelColourProduced[2] = colour == -1 ? 6315 : colour;

				// Dark brown
				colour = 6;
				npc.modelColourToEdit[9] = 6323;
				npc.newModelColourProduced[9] = colour == -1 ? 6323 : colour;

				// Very dark brown
				colour = 3;
				npc.modelColourToEdit[3] = 5281;
				npc.newModelColourProduced[3] = colour == -1 ? 5281 : colour;

				// Very very dark brown
				colour = 0;
				npc.modelColourToEdit[4] = 2332;
				npc.newModelColourProduced[4] = colour == -1 ? 2332 : colour;

				colour = -1;
				npc.modelColourToEdit[8] = -21608;
				npc.newModelColourProduced[8] = colour == -1 ? -21608 : colour;
				break;
			case 11208:
				data = forId(7706);
				npc.name = "TzKal-Zuk pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.standAnim;
				npc.turnLeftSequence = data.standAnim;
				npc.turnRightSequence = data.standAnim;
				npc.scaleZ = 25;
				npc.scaleX = 25;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.standAnim;
				npc.combatLevel = 0;
				npc.modelColourToEdit = new int[21];
				npc.newModelColourProduced = new int[21];
				colour = -1;
				npc.modelColourToEdit[1] = 12;
				npc.newModelColourProduced[1] = colour == -1 ? 12 : colour;

				npc.modelColourToEdit[2] = 8;
				npc.newModelColourProduced[2] = colour == -1 ? 8 : colour;

				npc.modelColourToEdit[3] = 4;
				npc.newModelColourProduced[3] = colour == -1 ? 4 : colour;

				npc.modelColourToEdit[4] = 272;
				npc.newModelColourProduced[4] = colour == -1 ? 272 : colour;

				npc.modelColourToEdit[5] = 16;
				npc.newModelColourProduced[5] = colour == -1 ? 16 : colour;

				npc.modelColourToEdit[9] = 20;
				npc.newModelColourProduced[9] = colour == -1 ? 20 : colour;

				npc.modelColourToEdit[11] = 268;
				npc.newModelColourProduced[11] = colour == -1 ? 268 : colour;

				npc.modelColourToEdit[14] = 662;
				npc.newModelColourProduced[14] = colour == -1 ? 662 : colour;

				npc.modelColourToEdit[15] = 3008;
				npc.newModelColourProduced[15] = colour == -1 ? 3008 : colour;

				colour = 51096;

				npc.modelColourToEdit[10] = 398;
				npc.newModelColourProduced[10] = colour == -1 ? 398 : colour;

				npc.modelColourToEdit[12] = 530;
				npc.newModelColourProduced[12] = colour == -1 ? 530 : colour;

				colour = 51105;
				npc.modelColourToEdit[13] = 528;
				npc.newModelColourProduced[13] = colour == -1 ? 528 : colour;

				npc.modelColourToEdit[16] = 916;
				npc.newModelColourProduced[16] = colour == -1 ? 916 : colour;

				npc.modelColourToEdit[17] = 920;
				npc.newModelColourProduced[17] = colour == -1 ? 920 : colour;

				colour = 51100;
				npc.modelColourToEdit[18] = 968;
				npc.newModelColourProduced[18] = colour == -1 ? 968 : colour;

				npc.modelColourToEdit[19] = 962;
				npc.newModelColourProduced[19] = colour == -1 ? 962 : colour;

				colour = 51130;
				npc.modelColourToEdit[20] = 926;
				npc.newModelColourProduced[20] = colour == -1 ? 926 : colour;

				colour = 51120;
				npc.modelColourToEdit[0] = 18368;
				npc.newModelColourProduced[0] = colour == -1 ? 18368 : colour;

				colour = 51110;
				npc.modelColourToEdit[6] = 278;
				npc.newModelColourProduced[6] = colour == -1 ? 278 : colour;

				npc.modelColourToEdit[7] = 280;
				npc.newModelColourProduced[7] = colour == -1 ? 280 : colour;

				npc.modelColourToEdit[8] = 274;
				npc.newModelColourProduced[8] = colour == -1 ? 274 : colour;
				break;
			// Pet dark core
			case 318:
				npc.standAnim = 1688;
				break;
			case 11207:
				data = forId(2592);
				npc.name = "Pink Mogre pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 70;
				npc.scaleX = 70;
				npc.combatLevel = 0;
				npc.modelColourToEdit = new int[15];
				npc.newModelColourProduced = new int[15];
				colour = -1;
				npc.modelColourToEdit[0] = 24;
				npc.newModelColourProduced[0] = colour == -1 ? 24 : colour;

				// Light brown
				colour = -1;
				npc.modelColourToEdit[1] = 6482;
				npc.newModelColourProduced[1] = colour == -1 ? 6482 : colour;

				colour = -1;
				npc.modelColourToEdit[2] = 99;
				npc.newModelColourProduced[2] = colour == -1 ? 99 : colour;

				// Brown
				colour = -1;
				npc.modelColourToEdit[3] = 7073;
				npc.newModelColourProduced[3] = colour == -1 ? 7073 : colour;

				// Grey
				colour = -1;
				npc.modelColourToEdit[4] = 61;
				npc.newModelColourProduced[4] = colour == -1 ? 61 : colour;

				colour = 58325;
				npc.modelColourToEdit[5] = 11175;
				npc.newModelColourProduced[5] = colour == -1 ? 11175 : colour;

				colour = 58315;
				npc.modelColourToEdit[6] = 11171;
				npc.newModelColourProduced[6] = colour == -1 ? 11171 : colour;

				colour = 58305;
				npc.modelColourToEdit[7] = 11169;
				npc.newModelColourProduced[7] = colour == -1 ? 11169 : colour;

				colour = 58325;
				npc.modelColourToEdit[8] = 10927;
				npc.newModelColourProduced[8] = colour == -1 ? 10927 : colour;

				colour = 58335;
				npc.modelColourToEdit[9] = 11051;
				npc.newModelColourProduced[9] = colour == -1 ? 11051 : colour;

				// Black
				colour = -1;
				npc.modelColourToEdit[10] = -21581;
				npc.newModelColourProduced[10] = colour == -1 ? -21581 : colour;

				colour = 58345;
				npc.modelColourToEdit[11] = 10142;
				npc.newModelColourProduced[11] = colour == -1 ? 10142 : colour;

				colour = 58305;
				npc.modelColourToEdit[12] = 11164;
				npc.newModelColourProduced[12] = colour == -1 ? 11164 : colour;

				colour = 58280;
				npc.modelColourToEdit[13] = 10803;
				npc.newModelColourProduced[13] = colour == -1 ? 10803 : colour;

				colour = 58275;
				npc.modelColourToEdit[14] = 12184;
				npc.newModelColourProduced[14] = colour == -1 ? 12184 : colour;
				break;

			case 11206:
				data = forId(5567);
				npc.name = "Death pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 100;
				npc.scaleX = 100;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				npc.modelColourToEdit = new int[13];
				npc.newModelColourProduced = new int[13];

				// Black
				colour = 127;
				npc.modelColourToEdit[0] = 0;
				npc.newModelColourProduced[0] = colour == -1 ? 0 : colour;

				colour = -1;
				npc.modelColourToEdit[1] = 5231;
				npc.newModelColourProduced[1] = colour == -1 ? 5231 : colour;

				// White
				colour = 80;
				npc.modelColourToEdit[2] = 5353;
				npc.newModelColourProduced[2] = colour == -1 ? 5353 : colour;

				colour = 127;
				npc.modelColourToEdit[3] = 8741;
				npc.newModelColourProduced[3] = colour == -1 ? 8741 : colour;

				colour = -1;
				npc.modelColourToEdit[4] = 4550;
				npc.newModelColourProduced[4] = colour == -1 ? 4550 : colour;

				colour = -1;
				npc.modelColourToEdit[5] = 8741;
				npc.newModelColourProduced[5] = colour == -1 ? 8741 : colour;

				colour = -1;
				npc.modelColourToEdit[6] = 10004;
				npc.newModelColourProduced[6] = colour == -1 ? 10004 : colour;

				colour = 127;
				npc.modelColourToEdit[7] = 25238;
				npc.newModelColourProduced[7] = colour == -1 ? 25238 : colour;

				colour = -1;
				npc.modelColourToEdit[8] = 0;
				npc.newModelColourProduced[8] = colour == -1 ? 0 : colour;

				colour = -1;
				npc.modelColourToEdit[9] = 908;
				npc.newModelColourProduced[9] = colour == -1 ? 908 : colour;

				colour = -1;
				npc.modelColourToEdit[10] = 5541;
				npc.newModelColourProduced[10] = colour == -1 ? 5541 : colour;

				colour = -1;
				npc.modelColourToEdit[11] = 7073;
				npc.newModelColourProduced[11] = colour == -1 ? 7073 : colour;

				colour = -1;
				npc.modelColourToEdit[12] = 61;
				npc.newModelColourProduced[12] = colour == -1 ? 61 : colour;
				break;
				
			case 11205:
				data = forId(1873);
				npc.name = "Celestial Yoshi pet ";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;

				npc.modelColourToEdit = new int[14];
				npc.newModelColourProduced = new int[14];

				// Dark green
				colour = 120;
				npc.modelColourToEdit[0] = 29976;
				npc.newModelColourProduced[0] = colour == -1 ? 29976 : colour;

				colour = 120;
				npc.modelColourToEdit[2] = 27819;
				npc.newModelColourProduced[2] = colour == -1 ? 27819 : colour;

				colour = 115;
				npc.modelColourToEdit[4] = 29980;
				npc.newModelColourProduced[4] = colour == -1 ? 29980 : colour;

				colour = 127;
				npc.modelColourToEdit[5] = 28302;
				npc.newModelColourProduced[5] = colour == -1 ? 28302 : colour;

				// Very dark green
				colour = 80;
				npc.modelColourToEdit[6] = 29980;
				npc.newModelColourProduced[6] = colour == -1 ? 29980 : colour;

				// Cream
				colour = 51150;
				npc.modelColourToEdit[7] = 27934;
				npc.newModelColourProduced[7] = colour == -1 ? 27934 : colour;

				colour = 51140;
				npc.modelColourToEdit[1] = 7502;
				npc.newModelColourProduced[1] = colour == -1 ? 7502 : colour;

				colour = 51130;
				npc.modelColourToEdit[3] = 0;
				npc.newModelColourProduced[3] = colour == -1 ? 0 : colour;

				// Blue and dark blue
				// Circle on the ground, most inner first circle
				colour = 51155;
				npc.modelColourToEdit[8] = -26214;
				npc.newModelColourProduced[8] = colour == -1 ? -26214 : colour;

				// Second circle
				colour = 51150;
				npc.modelColourToEdit[9] = -26218;
				npc.newModelColourProduced[9] = colour == -1 ? -26218 : colour;

				// Third circle
				colour = 51145;
				npc.modelColourToEdit[10] = -26094;
				npc.newModelColourProduced[10] = colour == -1 ? -26094 : colour;

				// Fourth circle
				colour = 51140;
				npc.modelColourToEdit[11] = -25970;
				npc.newModelColourProduced[11] = colour == -1 ? -25970 : colour;

				// Fifth circle
				colour = 51136;
				npc.modelColourToEdit[12] = -25718;
				npc.newModelColourProduced[12] = colour == -1 ? -25718 : colour;

				// Sixth circle
				colour = 51133;
				npc.modelColourToEdit[13] = -23672;
				npc.newModelColourProduced[13] = colour == -1 ? -23672 : colour;
				break;
			case 11204:
				objectInstance = ObjectDefinition.forId(8091);
				npc.name = objectInstance.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = objectInstance.models;
				npc.showOnMinimap = false;
				npc.scaleZ = 60;
				npc.scaleX = 60;
				npc.combatLevel = 0;
				npc.modelColourToEdit = new int[4];
				npc.newModelColourProduced = new int[4];
				colour = 58335;
				npc.modelColourToEdit[0] = 7845;
				npc.newModelColourProduced[0] = colour == -1 ? 7845 : colour;

				colour = 58330;
				npc.modelColourToEdit[1] = 9110;
				npc.newModelColourProduced[1] = colour == -1 ? 9110 : colour;

				colour = 58325;
				npc.modelColourToEdit[2] = 21696;
				npc.newModelColourProduced[2] = colour == -1 ? 21696 : colour;

				colour = 58320;
				npc.modelColourToEdit[3] = 21815;
				npc.newModelColourProduced[3] = colour == -1 ? 21815 : colour;
				break;
			case 11203:
				npc.name = "Golden Plank pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.showOnMinimap = false;
				npc.models = new int[]
				{15048};
				npc.modelColourToEdit = new int[]
				{6806, 6439, 6558};
				npc.newModelColourProduced = new int[]
				{7114, 7110, 7120};
				npc.combatLevel = 0;
				break;
			//Skotizo pet for Red, red coloured
			case 11202:
				data = forId(7286);
				npc.name = "Skotos";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 23;
				npc.scaleX = 23;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;

				npc.modelColourToEdit = new int[21];
				npc.newModelColourProduced = new int[21];
				colour = -1;
				npc.modelColourToEdit[0] = 8;
				npc.newModelColourProduced[0] = colour == -1 ? 8 : colour;

				npc.modelColourToEdit[1] = 16;
				npc.newModelColourProduced[1] = colour == -1 ? 16 : colour;

				npc.modelColourToEdit[2] = 20;
				npc.newModelColourProduced[2] = colour == -1 ? 20 : colour;

				npc.modelColourToEdit[4] = 28;
				npc.newModelColourProduced[4] = colour == -1 ? 28 : colour;

				npc.modelColourToEdit[5] = 33;
				npc.newModelColourProduced[5] = colour == -1 ? 33 : colour;

				npc.modelColourToEdit[6] = 24;
				npc.newModelColourProduced[6] = colour == -1 ? 24 : colour;

				npc.modelColourToEdit[7] = 37;
				npc.newModelColourProduced[7] = colour == -1 ? 37 : colour;

				npc.modelColourToEdit[9] = 0;
				npc.newModelColourProduced[9] = colour == -1 ? 0 : colour;

				npc.modelColourToEdit[14] = 12;
				npc.newModelColourProduced[14] = colour == -1 ? 12 : colour;

				colour = 927;
				npc.modelColourToEdit[8] = -15590;
				npc.newModelColourProduced[8] = colour == -1 ? -15590 : colour;

				npc.modelColourToEdit[3] = -15470;
				npc.newModelColourProduced[3] = colour == -1 ? -15470 : colour;

				npc.modelColourToEdit[10] = -15829;
				npc.newModelColourProduced[10] = colour == -1 ? -15829 : colour;

				npc.modelColourToEdit[11] = -16448;
				npc.newModelColourProduced[11] = colour == -1 ? -16448 : colour;

				npc.modelColourToEdit[12] = -18154;
				npc.newModelColourProduced[12] = colour == -1 ? -18154 : colour;

				npc.modelColourToEdit[13] = -15930;
				npc.newModelColourProduced[13] = colour == -1 ? -15930 : colour;

				npc.modelColourToEdit[15] = -15846;
				npc.newModelColourProduced[15] = colour == -1 ? -15846 : colour;

				npc.modelColourToEdit[16] = -15709;
				npc.newModelColourProduced[16] = colour == -1 ? -15709 : colour;

				npc.modelColourToEdit[17] = -15821;
				npc.newModelColourProduced[17] = colour == -1 ? -15821 : colour;

				npc.modelColourToEdit[18] = -15936;
				npc.newModelColourProduced[18] = colour == -1 ? -15936 : colour;

				npc.modelColourToEdit[19] = -15424;
				npc.newModelColourProduced[19] = colour == -1 ? -15424 : colour;

				npc.modelColourToEdit[20] = -15949;
				npc.newModelColourProduced[20] = colour == -1 ? -15949 : colour;
				break;
			case 6939:
			case 6940:
			case 6941:
			case 6942:
				npc.standAnim = 7536;
				npc.turn180Sequence = 7536;
				npc.turnLeftSequence = 7536;
				npc.turnRightSequence = 7536;
				break;
			case 11201:
				npc.modelColourToEdit = new int[]
				{8741, 9104, 25238, 926};
				npc.name = "Party Pete";
				npc.newModelColourProduced = new int[]
				{-23443, -23854, -22374, -21568};
				npc.models = new int[]
				{230, 246, 244, 187, 167, 176, 297, 267, 181};
				npc.faceModels = new int[]
				{63, 77, 29};
				npc.standAnim = 7537;
				npc.size = 1;
				npc.walkAnim = 819;
				npc.actions = new String[]
				{"Talk-to", null, null, null, null};
				npc.combatLevel = 0;
				npc.turn180Sequence = 7537;
				npc.turnLeftSequence = 7537;
				npc.turnRightSequence = 7537;
				break;
			case 7941:
				npc.actions = new String[]
				{"Talk-to", null, null, null, null};
				break;
			case 6637:
				npc.actions = new String[]
				{"Pick-up", null, "Metamorphosis", null, null};
				break;
			case 6638:
				npc.actions = new String[]
				{"Pick-up", null, "Metamorphosis", null, null};
				npc.size = 1;
				npc.scaleZ = 35;
				npc.scaleX = 35;
				break;
			case 963:
				npc.name = "Kalphite Queen";
				npc.combatLevel = 333;
				npc.size = 5;
				npc.standAnim = 6239;
				npc.walkAnim = 6238;
				npc.turnLeftSequence = 6238;
				npc.turnRightSequence = 6238;
				npc.turn180Sequence = 6238;
				npc.turnSpeed = 32;
				npc.varbit = -1;
				npc.setting = -1;
				npc.headicons = 6;
				npc.scaleZ = 128;
				npc.scaleX = 128;
				npc.interactable = true;
				npc.showOnMinimap = true;
				npc.actions = new String[5];
				npc.actions[0] = null;
				npc.actions[1] = "Attack";
				npc.actions[2] = null;
				npc.actions[3] = null;
				npc.actions[4] = null;
				npc.models = new int[2];
				npc.models[0] = 24597;
				npc.models[1] = 24598;
				break;

			case 965:
				npc.name = "Kalphite Queen";
				npc.combatLevel = 333;
				npc.size = 5;
				npc.standAnim = 6236;
				npc.walkAnim = 6236;
				npc.turnLeftSequence = 6236;
				npc.turnRightSequence = 6236;
				npc.turn180Sequence = 6236;
				npc.turnSpeed = 32;
				npc.varbit = -1;
				npc.setting = -1;
				npc.scaleZ = 128;
				npc.scaleX = 128;
				npc.interactable = true;
				npc.showOnMinimap = true;
				npc.actions = new String[5];
				npc.actions[0] = null;
				npc.actions[1] = "Attack";
				npc.actions[2] = null;
				npc.actions[3] = null;
				npc.actions[4] = null;
				npc.models = new int[3];
				npc.models[0] = 24602;
				npc.models[1] = 24605;
				npc.models[2] = 24606;
				break;
			case 1443:
				npc.modelColourToEdit = new int[]
				{910, 912, 1938, 1814, 1690, 0};
				npc.turnSpeed = 16;
				npc.name = "Jungle Demon";
				npc.newModelColourProduced = new int[]
				{14990, 14866, 14742, 14746, 14622, 9127};
				npc.models = new int[]
				{17375, 17391, 17384, 17399};
				npc.standAnim = 66;
				npc.size = 3;
				npc.walkAnim = 63;
				npc.actions = new String[]
				{null, "Attack", null, null, null};
				npc.combatLevel = 195;
				break;
			case 7144:
				npc.name = "Demonic gorilla";
				npc.combatLevel = 275;
				npc.size = 2;
				npc.standAnim = 7230;
				npc.walkAnim = 7233;
				npc.turnLeftSequence = 7233;
				npc.turnRightSequence = 7233;
				npc.turn180Sequence = 7233;
				npc.turnSpeed = 32;
				npc.varbit = -1;
				npc.setting = -1;
				npc.brightness = 10;
				npc.brightness = 10;
				npc.headicons = 0;
				npc.scaleZ = 64;
				npc.scaleX = 64;
				npc.interactable = true;
				npc.showOnMinimap = true;
				npc.actions = new String[5];
				npc.actions[0] = null;
				npc.actions[1] = "Attack";
				npc.actions[2] = null;
				npc.actions[3] = null;
				npc.actions[4] = null;
				npc.models = new int[1];
				npc.models[0] = 31241;
				break;

			case 7145:
				npc.name = "Demonic gorilla";
				npc.combatLevel = 275;
				npc.size = 2;
				npc.standAnim = 7230;
				npc.walkAnim = 7233;
				npc.turnLeftSequence = 7233;
				npc.turnRightSequence = 7233;
				npc.turn180Sequence = 7233;
				npc.turnSpeed = 32;
				npc.varbit = -1;
				npc.setting = -1;
				npc.headicons = 1;
				npc.brightness = 10;
				npc.brightness = 10;
				npc.scaleZ = 64;
				npc.scaleX = 64;
				npc.interactable = true;
				npc.showOnMinimap = true;
				npc.actions = new String[5];
				npc.actions[0] = null;
				npc.actions[1] = "Attack";
				npc.actions[2] = null;
				npc.actions[3] = null;
				npc.actions[4] = null;
				npc.models = new int[1];
				npc.models[0] = 31241;
				break;

			case 7146:
				npc.name = "Demonic gorilla";
				npc.combatLevel = 275;
				npc.size = 2;
				npc.standAnim = 7230;
				npc.walkAnim = 7233;
				npc.turnLeftSequence = 7233;
				npc.turnRightSequence = 7233;
				npc.turn180Sequence = 7233;
				npc.turnSpeed = 32;
				npc.varbit = -1;
				npc.setting = -1;
				npc.headicons = 2;
				npc.brightness = 10;
				npc.brightness = 10;
				npc.scaleZ = 64;
				npc.scaleX = 64;
				npc.interactable = true;
				npc.showOnMinimap = true;
				npc.actions = new String[5];
				npc.actions[0] = null;
				npc.actions[1] = "Attack";
				npc.actions[2] = null;
				npc.actions[3] = null;
				npc.actions[4] = null;
				npc.models = new int[1];
				npc.models[0] = 31241;
				break;

			// Guide npc model fix.
			case 306:
				npc.name = Config.serverNames[Config.currentServer] + "Guide";
				npc.models[6] = 7123;
				break;
			case 11200:
				data = forId(1873);
				npc.name = "Nocturnal Yoshi pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;

				npc.modelColourToEdit = new int[14];
				npc.newModelColourProduced = new int[14];
				colour = 51136;
				npc.modelColourToEdit[0] = 29976;
				npc.newModelColourProduced[0] = colour == -1 ? 29976 : colour;

				colour = -1;
				npc.modelColourToEdit[1] = 7502;
				npc.newModelColourProduced[1] = colour == -1 ? 7502 : colour;

				colour = 50000;
				npc.modelColourToEdit[2] = 27819;
				npc.newModelColourProduced[2] = colour == -1 ? 27819 : colour;

				colour = -1;
				npc.modelColourToEdit[3] = 0;
				npc.newModelColourProduced[3] = colour == -1 ? 0 : colour;

				colour = 51136;
				npc.modelColourToEdit[4] = 29980;
				npc.newModelColourProduced[4] = colour == -1 ? 29980 : colour;

				colour = 51136;
				npc.modelColourToEdit[5] = 28302;
				npc.newModelColourProduced[5] = colour == -1 ? 28302 : colour;

				colour = 51136;
				npc.modelColourToEdit[6] = 29980;
				npc.newModelColourProduced[6] = colour == -1 ? 29980 : colour;

				colour = 50000;
				npc.modelColourToEdit[7] = 27934;
				npc.newModelColourProduced[7] = colour == -1 ? 27934 : colour;
				
				// Circle on the ground, most inner first circle
				colour = 51155;
				npc.modelColourToEdit[8] = -26214;
				npc.newModelColourProduced[8] = colour == -1 ? -26214 : colour;

				// Second circle
				colour = 51150;
				npc.modelColourToEdit[9] = -26218;
				npc.newModelColourProduced[9] = colour == -1 ? -26218 : colour;

				// Third circle
				colour = 51145;
				npc.modelColourToEdit[10] = -26094;
				npc.newModelColourProduced[10] = colour == -1 ? -26094 : colour;

				// Fourth circle
				colour = 51140;
				npc.modelColourToEdit[11] = -25970;
				npc.newModelColourProduced[11] = colour == -1 ? -25970 : colour;

				// Fifth circle
				colour = 51136;
				npc.modelColourToEdit[12] = -25718;
				npc.newModelColourProduced[12] = colour == -1 ? -25718 : colour;

				// Sixth circle
				colour = 51133;
				npc.modelColourToEdit[13] = -23672;
				npc.newModelColourProduced[13] = colour == -1 ? -23672 : colour;
				break;
			case 11199:
				data = forId(6768);
				npc.name = data.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 100;
				npc.scaleX = 100;
				npc.combatLevel = 0;
				break;
			case 2835:
				npc.name = "Bearded camel";
				npc.size = 1;
				npc.standAnim = 51;
				npc.walkAnim = 45;
				npc.turnLeftSequence = 45;
				npc.turnRightSequence = 45;
				npc.turn180Sequence = 45;
				npc.turnSpeed = 32;
				npc.varbit = -1;
				npc.setting = -1;
				npc.headicons = -1;
				npc.scaleZ = 81;
				npc.scaleX = 81;
				npc.interactable = true;
				npc.showOnMinimap = false;
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[3];
				npc.models[0] = 9846;
				npc.models[1] = 9844;
				npc.models[2] = 9849;
				break;



			// Adam, the Ironman npc
			case 311:
				npc.actions = new String[5];
				npc.actions[0] = "Talk-to";
				break;

			// Scorpia's offspring, this is to fix the visual follow bug
			case 5561:
				npc.scaleX = 200;
				npc.scaleZ = 200;
				npc.size = 1;
				break;
			case 11198:
				data = forId(2510);
				npc.name = data.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 100;
				npc.scaleX = 100;
				npc.combatLevel = 0;
				break;
			case 11197:
				data = forId(6636);
				npc.name = "White prince black dragon pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 40;
				npc.scaleX = 40;
				npc.combatLevel = 0;

				npc.modelColourToEdit = new int[19];
				npc.newModelColourProduced = new int[19];

				colour = 127;
				npc.modelColourToEdit[1] = 10502;
				npc.newModelColourProduced[1] = colour == -1 ? 10502 : colour;

				npc.modelColourToEdit[3] = 11140;
				npc.newModelColourProduced[3] = colour == -1 ? 11140 : colour;

				npc.modelColourToEdit[4] = 10378;
				npc.newModelColourProduced[4] = colour == -1 ? 10378 : colour;

				npc.modelColourToEdit[9] = 33;
				npc.newModelColourProduced[9] = colour == -1 ? 33 : colour;

				npc.modelColourToEdit[12] = 24;
				npc.newModelColourProduced[12] = colour == -1 ? 24 : colour;

				colour = -1;
				npc.modelColourToEdit[0] = -14400;
				npc.newModelColourProduced[0] = colour == -1 ? -14400 : colour;

				colour = -1;
				npc.modelColourToEdit[2] = -21630;
				npc.newModelColourProduced[2] = colour == -1 ? -21630 : colour;

				colour = -1;
				npc.modelColourToEdit[5] = 0;
				npc.newModelColourProduced[5] = colour == -1 ? 0 : colour;

				colour = -1;
				npc.modelColourToEdit[6] = 809;
				npc.newModelColourProduced[6] = colour == -1 ? 809 : colour;

				colour = -1;
				npc.modelColourToEdit[7] = 5198;
				npc.newModelColourProduced[7] = colour == -1 ? 5198 : colour;

				colour = -1;
				npc.modelColourToEdit[8] = 5206;
				npc.newModelColourProduced[8] = colour == -1 ? 5206 : colour;

				colour = -1;
				npc.modelColourToEdit[10] = 5214;
				npc.newModelColourProduced[10] = colour == -1 ? 5214 : colour;

				colour = -1;
				npc.modelColourToEdit[11] = 5219;
				npc.newModelColourProduced[11] = colour == -1 ? 5219 : colour;


				colour = 127;
				npc.modelColourToEdit[12] = 10378;
				npc.newModelColourProduced[12] = colour == -1 ? 10378 : colour;

				npc.modelColourToEdit[13] = 10502;
				npc.newModelColourProduced[13] = colour == -1 ? 10502 : colour;

				npc.modelColourToEdit[14] = 11140;
				npc.newModelColourProduced[14] = colour == -1 ? 11140 : colour;

				colour = -1;
				npc.modelColourToEdit[15] = 33;
				npc.newModelColourProduced[15] = colour == -1 ? 33 : colour;

				colour = 127;
				npc.modelColourToEdit[16] = 24;
				npc.newModelColourProduced[16] = colour == -1 ? 24 : colour;

				colour = -1;
				npc.modelColourToEdit[18] = 5206;
				npc.newModelColourProduced[18] = colour == -1 ? 5206 : colour;

				colour = 127;
				npc.modelColourToEdit[17] = 11138;
				npc.newModelColourProduced[17] = colour == -1 ? 11138 : colour;
				break;
			case 11196:
				data = forId(762);
				npc.name = data.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 100;
				npc.scaleX = 100;
				npc.combatLevel = 0;
				break;
			case 11195:
				data = forId(548);
				npc.name = data.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 100;
				npc.scaleX = 100;
				npc.combatLevel = 0;
				break;
			case 11194:
				objectInstance = ObjectDefinition.forId(8091);
				npc.name = objectInstance.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = objectInstance.models;
				npc.showOnMinimap = false;
				npc.scaleZ = 60;
				npc.scaleX = 60;
				npc.combatLevel = 0;
				break;
			case 11193:
				objectInstance = ObjectDefinition.forId(29146);
				npc.name = objectInstance.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = objectInstance.models;
				npc.showOnMinimap = false;
				npc.scaleZ = 100;
				npc.scaleX = 100;
				npc.combatLevel = 0;
				break;
			case 11192:
				data = forId(404);
				npc.name = data.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 100;
				npc.scaleX = 100;
				npc.combatLevel = 0;
				break;
			case 11191:
				data = forId(3837);
				npc.name = data.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 85;
				npc.scaleX = 85;
				npc.combatLevel = 0;
				break;
			case 11190:
				data = forId(1241);
				npc.name = data.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 100;
				npc.scaleX = 100;
				npc.combatLevel = 0;
				break;
			case 11189:
				data = forId(2474);
				npc.name = data.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 80;
				npc.scaleX = 80;
				npc.combatLevel = 0;
				break;
			case 11188:
				data = forId(7039);
				npc.name = data.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 40;
				npc.scaleX = 40;
				npc.combatLevel = 0;
				break;
			// Perdu
			case 7456:
				npc.actions = new String[]
				{"Talk-to", null, "View-list", null, null};
				break;
			case 11187:
				data = forId(7544);
				npc.name = "Tekton pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 30;
				npc.scaleX = 30;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;

				npc.modelColourToEdit = new int[20];
				npc.newModelColourProduced = new int[20];
				colour = -1;
				npc.modelColourToEdit[0] = 24;
				npc.newModelColourProduced[0] = colour == -1 ? 24 : colour;

				npc.modelColourToEdit[1] = 8;
				npc.newModelColourProduced[1] = colour == -1 ? 8 : colour;

				colour = 302770;
				npc.modelColourToEdit[2] = 5056;
				npc.newModelColourProduced[2] = colour == -1 ? 5056 : colour;

				npc.modelColourToEdit[3] = 7101;
				npc.newModelColourProduced[3] = colour == -1 ? 7101 : colour;

				npc.modelColourToEdit[4] = 4382;
				npc.newModelColourProduced[4] = colour == -1 ? 4382 : colour;

				npc.modelColourToEdit[5] = 3005;
				npc.newModelColourProduced[5] = colour == -1 ? 3005 : colour;

				npc.modelColourToEdit[6] = 4029;
				npc.newModelColourProduced[6] = colour == -1 ? 4029 : colour;

				colour = -1;
				npc.modelColourToEdit[7] = 33;
				npc.newModelColourProduced[7] = colour == -1 ? 33 : colour;

				npc.modelColourToEdit[8] = 28;
				npc.newModelColourProduced[8] = colour == -1 ? 28 : colour;

				colour = 302770;
				npc.modelColourToEdit[9] = 8125;
				npc.newModelColourProduced[9] = colour == -1 ? 8125 : colour;

				npc.modelColourToEdit[10] = 9152;
				npc.newModelColourProduced[10] = colour == -1 ? 9152 : colour;

				colour = -1;
				npc.modelColourToEdit[11] = 16;
				npc.newModelColourProduced[11] = colour == -1 ? 16 : colour;

				npc.modelColourToEdit[12] = 20;
				npc.newModelColourProduced[12] = colour == -1 ? 20 : colour;

				colour = 302770;
				npc.modelColourToEdit[13] = 3778;
				npc.newModelColourProduced[13] = colour == -1 ? 3778 : colour;

				npc.modelColourToEdit[14] = 4641;
				npc.newModelColourProduced[14] = colour == -1 ? 4641 : colour;

				npc.modelColourToEdit[15] = 3520;
				npc.newModelColourProduced[15] = colour == -1 ? 3520 : colour;

				npc.modelColourToEdit[16] = 4409;
				npc.newModelColourProduced[16] = colour == -1 ? 4409 : colour;

				npc.modelColourToEdit[17] = 4271;
				npc.newModelColourProduced[17] = colour == -1 ? 4271 : colour;

				npc.modelColourToEdit[18] = 5157;
				npc.newModelColourProduced[18] = colour == -1 ? 5157 : colour;

				npc.modelColourToEdit[19] = 957;
				npc.newModelColourProduced[19] = colour == -1 ? 957 : colour;
				break;
			case 11186:
				data = forId(1277);
				npc.name = data.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 100;
				npc.scaleX = 100;
				npc.combatLevel = 0;
				break;
			case 11185:
				data = forId(1835);
				npc.name = data.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 70;
				npc.scaleX = 70;
				npc.combatLevel = 0;
				break;
			case 11184:
				data = forId(2108);
				npc.name = data.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 100;
				npc.scaleX = 100;
				npc.combatLevel = 0;
				break;
			case 11183:
				data = forId(5796);
				npc.name = data.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.standAnim = 5801;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 70;
				npc.scaleX = 70;
				npc.combatLevel = 0;
				break;
			case 11182:
				data = forId(108);
				npc.name = data.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 100;
				npc.scaleX = 100;
				npc.combatLevel = 0;
				break;
			case 11181:
				data = forId(7792);
				npc.name = data.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 50;
				npc.scaleX = 50;
				npc.combatLevel = 0;
				break;
			case 11180:
				data = forId(7371);
				npc.name = data.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 85;
				npc.scaleX = 85;
				npc.combatLevel = 0;
				break;

			case 11179:
				data = forId(5816);
				npc.name = data.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 70;
				npc.scaleX = 70;
				npc.combatLevel = 0;
				break;

			case 11178:
				data = forId(2830);
				npc.name = data.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 100;
				npc.scaleX = 100;
				npc.combatLevel = 0;
				break;
			case 11177:
				data = forId(2643);
				npc.name = data.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 85;
				npc.scaleX = 85;
				npc.combatLevel = 0;
				break;

			case 11176:
				data = forId(4362);
				npc.name = data.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 70;
				npc.scaleX = 70;
				npc.combatLevel = 0;
				break;
			case 11175:
				itemData = ItemDefinition.forId(1040);
				npc.name = itemData.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models[0] = itemData.inventoryModel;
				npc.modelColourToEdit = itemData.modelColourToEdit;
				npc.newModelColourProduced = itemData.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;
				break;
			case 11174:
				itemData = ItemDefinition.forId(1044);
				npc.name = itemData.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models[0] = itemData.inventoryModel;
				npc.modelColourToEdit = itemData.modelColourToEdit;
				npc.newModelColourProduced = itemData.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;
				break;
			case 11173:
				data = forId(2902);
				npc.name = data.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 100;
				npc.scaleX = 100;
				npc.combatLevel = 0;
				break;
			case 11172:
				data = forId(7936);
				npc.name = data.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 36;
				npc.scaleX = 36;
				npc.combatLevel = 0;
				break;
			case 11171:
				data = forId(7939);
				npc.name = data.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 80;
				npc.scaleX = 80;
				npc.combatLevel = 0;
				break;
			case 11170:
				data = forId(6379);
				npc.name = data.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 36;
				npc.scaleX = 36;
				npc.combatLevel = 0;
				break;
			case 11169:
				data = forId(7374);
				npc.name = data.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 100;
				npc.scaleX = 100;
				npc.combatLevel = 0;
				break;
			case 11168:
				data = forId(1037);
				npc.name = data.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 90;
				npc.scaleX = 90;
				npc.combatLevel = 0;
				break;
			case 11167:
				data = forId(11124);
				npc.name = "Revenant dragon pet";
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.size = 1;
				npc.models = new int[1];
				npc.models[0] = data.models[0];
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.showOnMinimap = false;
				npc.scaleZ = 70;
				npc.scaleX = 70;
				npc.combatLevel = 0;
				break;

			case 11144:
				npc.name = "Revenant dark beast";
				npc.combatLevel = 120;
				npc.standAnim = 11017;
				npc.walkAnim = 11018;
				npc.turn180Sequence = 11018;
				npc.turnLeftSequence = 11018;
				npc.turnRightSequence = 11018;
				npc.size = 3;
				npc.actions = new String[5];
				npc.actions[0] = null;
				npc.actions[1] = "Attack";
				npc.actions[2] = null;
				npc.actions[3] = null;
				npc.actions[4] = null;
				npc.models = new int[1];
				npc.models[0] = 65000;
				break;

			case 11166:
				data = forId(11144);
				npc.name = "Revenant dark beast pet";
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.size = 1;
				npc.models = new int[1];
				npc.models[0] = data.models[0];
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.showOnMinimap = false;
				npc.scaleZ = 60;
				npc.scaleX = 60;
				npc.combatLevel = 0;
				break;


			case 11145:
				npc.name = "Revenant hellhound";
				npc.combatLevel = 90;
				npc.standAnim = 11030;
				npc.walkAnim = 11031;
				npc.turn180Sequence = 11031;
				npc.turnLeftSequence = 11031;
				npc.turnRightSequence = 11031;
				npc.size = 2;
				npc.actions = new String[5];
				npc.actions[0] = null;
				npc.actions[1] = "Attack";
				npc.actions[2] = null;
				npc.actions[3] = null;
				npc.actions[4] = null;
				npc.models = new int[1];
				npc.models[0] = 65002;
				break;
			case 11165:
				data = forId(11145);
				npc.name = "Revenant hellhound pet";
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.size = 1;
				npc.models = new int[1];
				npc.models[0] = data.models[0];
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.showOnMinimap = false;
				npc.scaleZ = 60;
				npc.scaleX = 60;
				npc.combatLevel = 0;
				break;

			case 11146:
				npc.name = "Revenant ork";
				npc.combatLevel = 105;
				npc.standAnim = 11024;
				npc.walkAnim = 11025;
				npc.turn180Sequence = 11025;
				npc.turnLeftSequence = 11025;
				npc.turnRightSequence = 11025;
				npc.size = 1;
				npc.actions = new String[5];
				npc.actions[0] = null;
				npc.actions[1] = "Attack";
				npc.actions[2] = null;
				npc.actions[3] = null;
				npc.actions[4] = null;
				npc.models = new int[1];
				npc.models[0] = 65003;
				break;

			case 11164:
				data = forId(11146);
				npc.name = "Revenant ork pet";
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.size = 1;
				npc.models = new int[1];
				npc.models[0] = data.models[0];
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.showOnMinimap = false;
				npc.scaleZ = 70;
				npc.scaleX = 70;
				npc.combatLevel = 0;
				break;
			case 11163:
				data = forId(4927);
				npc.name = data.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 90;
				npc.scaleX = 90;
				npc.combatLevel = 0;
				break;
			case 11162:
				data = forId(2696);
				npc.name = data.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 70;
				npc.scaleX = 70;
				npc.combatLevel = 0;
				break;
			case 11161:
				data = forId(2002);
				npc.name = data.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 100;
				npc.scaleX = 100;
				npc.combatLevel = 0;
				break;
			case 11160:
				data = forId(6474);
				npc.name = data.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 60;
				npc.scaleX = 60;
				npc.combatLevel = 0;
				break;
			case 11159:
				data = forId(7795);
				npc.name = data.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 50;
				npc.scaleX = 50;
				npc.combatLevel = 0;
				break;
			case 11158:
				itemData = ItemDefinition.forId(21006);
				npc.name = itemData.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models[0] = itemData.inventoryModel;
				npc.modelColourToEdit = itemData.modelColourToEdit;
				npc.newModelColourProduced = itemData.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.brightness = -55;
				npc.combatLevel = 0;
				break;
			case 11157:
				itemData = ItemDefinition.forId(2422);
				npc.name = itemData.name + " pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models[0] = itemData.inventoryModel;
				npc.modelColourToEdit = itemData.modelColourToEdit;
				npc.newModelColourProduced = itemData.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.brightness = -55;
				npc.combatLevel = 0;
				break;
			case 11156:
				data = forId(2592);
				npc.name = "Mogre pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 70;
				npc.scaleX = 70;
				npc.combatLevel = 0;
				break;
			case 11155:
				data = forId(403);
				npc.name = "Vannaka pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 90;
				npc.scaleX = 90;
				npc.combatLevel = 0;
				break;

			case 11154:
				npc.name = "Barbarian snowman pet";
				npc.models = new int[]
				{65005};
				//npc.standAnim = 11051;
				//npc.walkAnim = 11050;
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.hasRenderPriority = true;
				npc.scaleZ = 70;
				npc.scaleX = 70;
				break;
			case 11153:
				npc.name = "Dragon snowman pet";
				npc.models = new int[]
				{65009};
				//npc.standAnim = 11051;
				//npc.walkAnim = 11050;
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.hasRenderPriority = true;
				npc.scaleZ = 70;
				npc.scaleX = 70;
				break;
			case 11152:
				npc.name = "Dwarf snowman pet";
				npc.models = new int[]
				{65004};
				//npc.standAnim = 11051;
				//npc.walkAnim = 11050;
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.hasRenderPriority = true;
				npc.scaleZ = 70;
				npc.scaleX = 70;
				break;
			case 11151:
				npc.name = "Pirate snowman pet";
				npc.models = new int[]
				{65007};
				//npc.standAnim = 11051;
				//npc.walkAnim = 11050;
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.hasRenderPriority = true;
				npc.scaleZ = 70;
				npc.scaleX = 70;
				break;
			case 11150:
				npc.name = "Snowman pet";
				npc.models = new int[]
				{65006};
				//npc.standAnim = 11051;
				//npc.walkAnim = 11050;
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.hasRenderPriority = true;
				npc.scaleZ = 70;
				npc.scaleX = 70;
				break;
			case 11149:
				npc.name = "Snow ranger pet";
				npc.models = new int[]
				{65010};
				//npc.standAnim = 11051;
				//npc.walkAnim = 11050;
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.hasRenderPriority = true;
				npc.scaleZ = 70;
				npc.scaleX = 70;
				break;
			case 11148:
				npc.name = "Snow warrior pet";
				npc.models = new int[]
				{65011};
				//npc.standAnim = 11051;
				//npc.walkAnim = 11050;
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.hasRenderPriority = true;
				npc.scaleZ = 70;
				npc.scaleX = 70;
				break;
			case 11147:
				npc.name = "Snow mage pet";
				npc.models = new int[]
				{65008};
				//npc.standAnim = 11051;
				//npc.walkAnim = 11050;
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.hasRenderPriority = true;
				npc.scaleZ = 70;
				npc.scaleX = 70;
				break;
			case 11143:
				data = forId(3588);
				npc.name = "Homunculus pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 50;
				npc.scaleX = 50;
				npc.combatLevel = 0;
				break;
			case 11142:
				data = forId(7596);
				npc.name = "Gnosi pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 85;
				npc.scaleX = 85;
				npc.combatLevel = 0;
				break;
			case 11141:
				data = forId(2838);
				npc.name = "Bear pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 60;
				npc.scaleX = 60;
				npc.combatLevel = 0;
				break;
			case 11140:
				data = forId(3838);
				npc.name = "Pauline Polaris pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 85;
				npc.scaleX = 85;
				npc.combatLevel = 0;
				break;
			case 11139:
				npc.name = "Dairy cow pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models[0] = 23891;
				npc.standAnim = 5855;
				npc.walkAnim = 5848;
				npc.turn180Sequence = 5848;
				npc.turnLeftSequence = 5848;
				npc.turnRightSequence = 5848;
				npc.showOnMinimap = false;
				npc.scaleZ = 60;
				npc.scaleX = 60;
				npc.combatLevel = 0;
				break;
			case 11138:
				data = forId(7037);
				npc.name = "Aviansie pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 70;
				npc.scaleX = 70;
				npc.combatLevel = 0;
				break;
			case 11137:
				itemData = ItemDefinition.forId(20997);
				npc.name = "Twisted bow pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models[0] = itemData.inventoryModel;
				npc.modelColourToEdit = itemData.modelColourToEdit;
				npc.newModelColourProduced = itemData.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;
				break;
			case 11136:
				data = forId(3055);
				npc.name = "Barbarian guard pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 90;
				npc.scaleX = 90;
				npc.combatLevel = 0;
				break;
			case 11135:
				data = forId(5869);
				npc.name = "Summoned Soul pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 85;
				npc.scaleX = 85;
				npc.combatLevel = 0;
				break;
			case 11133:
				data = forId(3996);
				npc.name = "Witch's experiment pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.showOnMinimap = false;
				npc.scaleZ = 90;
				npc.scaleX = 90;
				npc.combatLevel = 0;
				break;
			case 11132:
				data = forId(610);
				npc.name = "Zombie protester pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 60;
				npc.scaleX = 60;
				npc.combatLevel = 0;
				break;
			case 11131:
				data = forId(7055);
				npc.name = "Novice pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 82;
				npc.scaleX = 82;
				npc.combatLevel = 0;
				break;
			case 11130:
				data = forId(6798);
				npc.name = "Steve pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 95;
				npc.scaleX = 95;
				npc.combatLevel = 0;
				break;
			case 11129:
				data = forId(848);
				npc.name = "Army commander pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 77;
				npc.scaleX = 77;
				npc.combatLevel = 0;
				break;
			case 11128:
				data = forId(3542);
				npc.name = "Ali the Snake charmer pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.standAnim;
				npc.turn180Sequence = data.standAnim;
				npc.turnLeftSequence = data.standAnim;
				npc.turnRightSequence = data.standAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 85;
				npc.scaleX = 85;
				npc.combatLevel = 0;
				break;
			case 11127:
				data = forId(5847);
				npc.name = "Zanaris choir pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 75;
				npc.scaleX = 75;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.combatLevel = 0;
				break;
			case 11126:
				data = forId(2641);
				npc.name = "Dragonkin pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 60;
				npc.scaleX = 60;
				npc.combatLevel = 0;
				break;

			// A'abla
			case 3341:
				npc.actions = new String[5];
				npc.actions[0] = "Gambling-ban";
				break;

			case 11124:
				npc.name = "Revenant dragon";
				npc.models = new int[]
				{44450};
				npc.size = 3;
				npc.standAnim = 11046;
				npc.walkAnim = 11047;
				npc.turn180Sequence = 11047;
				npc.turnLeftSequence = 11047;
				npc.turnRightSequence = 11047;
				npc.actions = new String[]
				{null, "Attack", null, null, null};
				npc.combatLevel = 135;
				npc.hasRenderPriority = true;
				npc.scaleZ = 125;
				npc.scaleX = 125;
				break;

			case 11123:
				data = forId(5889);
				npc.name = "Runecessoral Sire pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 23;
				npc.scaleX = 23;
				npc.combatLevel = 0;
				break;
			case 11122:
				data = forId(835);
				EntityDefinition data2 = forId(830);
				npc.name = "Ping pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data2.walkAnim;
				npc.turn180Sequence = data2.walkAnim;
				npc.turnLeftSequence = data2.walkAnim;
				npc.turnRightSequence = data2.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 80;
				npc.scaleX = 80;
				npc.combatLevel = 0;
				break;
			case 11121:
				data = forId(2812);
				npc.name = "Pig pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 120;
				npc.scaleX = 120;
				npc.combatLevel = 0;
				break;
			case 11120:
				data = forId(3343);
				npc.name = "Nurse Tafani pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 100;
				npc.scaleX = 100;
				npc.modelColourToEdit = new int[4];
				npc.modelColourToEdit[0] = 8741;
				npc.modelColourToEdit[1] = 25238;
				npc.modelColourToEdit[2] = 6798;
				npc.modelColourToEdit[3] = 4550;
				npc.newModelColourProduced = new int[4];
				npc.newModelColourProduced[0] = 43228;
				npc.newModelColourProduced[1] = 43228;
				npc.newModelColourProduced[2] = 138;
				npc.newModelColourProduced[3] = 6705;
				npc.combatLevel = 0;
				break;

			case 11119:
				data = forId(2514);
				npc.name = "Ankou pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 90;
				npc.scaleX = 90;
				npc.modelColourToEdit = new int[4];
				npc.modelColourToEdit[0] = 27955;
				npc.modelColourToEdit[1] = 29113;
				npc.modelColourToEdit[2] = 20715;
				npc.modelColourToEdit[3] = 22488;
				npc.newModelColourProduced = new int[4];
				npc.newModelColourProduced[0] = 61099;
				npc.newModelColourProduced[1] = 819;
				npc.newModelColourProduced[2] = 8394;
				npc.newModelColourProduced[3] = 960;
				npc.combatLevel = 0;
				break;
			case 11118:
				data = forId(2055);
				npc.name = "White Chaos Elemental Jr.";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.modelColourToEdit = new int[5];
				npc.newModelColourProduced = new int[5];
				npc.combatLevel = 0;

				// Purple
				colour = 100;
				npc.modelColourToEdit[0] = -17879;
				npc.newModelColourProduced[0] = colour == -1 ? -17879 : colour;

				// Pink
				colour = -1;
				npc.modelColourToEdit[1] = 466;
				npc.newModelColourProduced[1] = colour == -1 ? 466 : colour;

				// Purple
				colour = 100;
				npc.modelColourToEdit[2] = -17875;
				npc.newModelColourProduced[2] = colour == -1 ? -17875 : colour;

				// Black
				colour = -1;
				npc.modelColourToEdit[3] = 0;
				npc.newModelColourProduced[3] = colour == -1 ? 0 : colour;

				// Pale purple
				colour = 9583;
				npc.modelColourToEdit[4] = -18261;
				npc.newModelColourProduced[4] = colour == -1 ? -18261 : colour;
				break;
			case 11117:
				data = forId(2055);
				npc.name = "White Chaos Elemental Jr.";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.modelColourToEdit = new int[5];
				npc.newModelColourProduced = new int[5];
				npc.combatLevel = 0;

				// Purple
				colour = 100;
				npc.modelColourToEdit[0] = -17879;
				npc.newModelColourProduced[0] = colour == -1 ? -17879 : colour;

				// Pink
				colour = -1;
				npc.modelColourToEdit[1] = 466;
				npc.newModelColourProduced[1] = colour == -1 ? 466 : colour;

				// Purple
				colour = 100;
				npc.modelColourToEdit[2] = -17875;
				npc.newModelColourProduced[2] = colour == -1 ? -17875 : colour;

				// Black
				colour = -1;
				npc.modelColourToEdit[3] = 0;
				npc.newModelColourProduced[3] = colour == -1 ? 0 : colour;

				// Pale purple
				colour = 9583;
				npc.modelColourToEdit[4] = -18261;
				npc.newModelColourProduced[4] = colour == -1 ? -18261 : colour;
				break;

			case 11116:
				data = forId(5054);
				npc.name = "Skeletal hellhound pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 80;
				npc.scaleX = 80;
				npc.combatLevel = 0;
				break;
			case 11115:
				data = forId(696);
				npc.name = "Troll child pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 80;
				npc.scaleX = 80;
				npc.combatLevel = 0;
				break;
			case 11114:
				itemData = ItemDefinition.forId(20784);
				npc.name = "Pet dragon claws";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models[0] = itemData.inventoryModel;
				npc.modelColourToEdit = itemData.modelColourToEdit;
				npc.newModelColourProduced = itemData.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;
				break;
			case 114:
				npc.name = "Ajax";
				npc.combatLevel = 147;
				npc.size = 2;
				npc.actions = new String[5];
				npc.actions[0] = "Pickup";
				npc.actions[1] = null;
				npc.actions[2] = null;
				npc.actions[3] = null;
				npc.actions[4] = null;
				break;
			case 3665:
				npc.name = "Rabbit Pet";
				npc.combatLevel = 1;
				npc.size = 2;
				npc.actions = new String[5];
				npc.actions[0] = "Pickup";
				npc.actions[1] = null;
				npc.actions[2] = null;
				npc.actions[3] = null;
				npc.actions[4] = null;
				break;
			case 11113: // Santa on sledge
				npc.name = "Santa";
				//npc.models = new int[] {28983, 28981, 28979, 28978, 28976, 28989};
				npc.models = new int[]
				{235, 189, 299, 4226, 4218, 162, 4924, 4925, 4926, 4946};
				npc.actions = new String[]
				{"Talk-to", null, null, null, null};
				npc.faceModels = new int[]
				{7380, 69, 53};//Beard, santa hat, head
				npc.description = "He's lightning fast.";
				npc.walkAnim = 1467;
				npc.turnLeftSequence = 1468;
				npc.turnRightSequence = 1468;
				npc.turn180Sequence = 1468;
				npc.standAnim = 1461;
				npc.modelColourToEdit = new int[]
				{6798, 8078, 8741, 25238, 6587, 5400};
				npc.newModelColourProduced = new int[]
				{86, 10351, 933, 933, 10351, 0};
				break;
			case 11112:
				npc.name = "Santa";
				//npc.models = new int[] {28983, 28981, 28979, 28978, 28976, 28989};
				npc.models = new int[]
				{235, 189, 299, 4226, 4218, 162, 4924, 4925, 4926};
				npc.actions = new String[]
				{"Talk-to", null, null, null, null};
				npc.faceModels = new int[]
				{7380, 69, 53};//Beard, santa hat, head
				npc.description = "Also known as Father christmas.";
				npc.walkAnim = 819;
				npc.turnLeftSequence = 819;
				npc.turnRightSequence = 819;
				npc.turn180Sequence = 819;
				npc.standAnim = 808;
				npc.modelColourToEdit = new int[]
				{6798, 8078, 8741, 25238, 6587, 5400};
				npc.newModelColourProduced = new int[]
				{86, 10351, 933, 933, 10351, 0};
				break;
			case 11111:
				data = forId(1101);
				npc.name = "Sea snake pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 30;
				npc.scaleX = 30;
				npc.combatLevel = 0;
				break;
			case 11110:
				data = forId(1163);
				npc.name = "Tree spirit pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 110;
				npc.scaleX = 110;
				npc.combatLevel = 0;
				break;
			case 11109:
				data = forId(7040);
				npc.scaleZ = 90;
				npc.scaleX = 90;
				npc.name = "Clerris pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;
				break;
			case 11108:
				data = forId(1840);
				npc.name = "Fairy Godfather pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = 112;
				npc.walkAnim = 106;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;
				break;
			case 11107:
				data = forId(6797);
				npc.name = "Nieve pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.scaleZ = 100;
				npc.scaleX = 100;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;
				break;
			case 11106:
				data = forId(3567);
				npc.name = "Pet chair";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;
				break;
			case 11105:
				data = forId(7481);
				npc.name = "Hopleez pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.scaleZ = 75;
				npc.scaleX = 75;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;
				break;
			case 11104:
				data = forId(763);
				npc.name = "Mcribb pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 35;
				npc.scaleX = 35;
				npc.modelColourToEdit = new int[18];
				npc.modelColourToEdit[0] = -28134;// Dark blue
				npc.modelColourToEdit[1] = -26864; // Very dark blue
				npc.modelColourToEdit[2] = -27231; // Dark blue
				npc.modelColourToEdit[3] = -27223; // Dark blue
				npc.modelColourToEdit[4] = -27227; // Dark blue
				npc.modelColourToEdit[5] = -27112; // Dark blue
				npc.modelColourToEdit[6] = -27236; // Dark blue
				npc.modelColourToEdit[7] = -28010; // Dark blue
				npc.modelColourToEdit[8] = -3165;
				npc.modelColourToEdit[9] = -3161;
				npc.modelColourToEdit[10] = 9;
				npc.modelColourToEdit[11] = 9;
				npc.modelColourToEdit[12] = -3409;
				npc.modelColourToEdit[13] = -3405;
				npc.modelColourToEdit[14] = -2249;
				npc.modelColourToEdit[15] = -2245;
				npc.modelColourToEdit[16] = -2125;
				npc.modelColourToEdit[17] = -2131;
				npc.newModelColourProduced = new int[18];
				npc.newModelColourProduced[0] = 0;
				npc.newModelColourProduced[1] = 7;
				npc.newModelColourProduced[2] = 0;
				npc.newModelColourProduced[3] = 0;
				npc.newModelColourProduced[4] = 0;
				npc.newModelColourProduced[5] = 0;
				npc.newModelColourProduced[6] = 0;
				npc.newModelColourProduced[7] = 0;
				npc.newModelColourProduced[8] = 0;
				npc.newModelColourProduced[9] = 0;
				npc.newModelColourProduced[10] = 127; // Wing design at the front spike
				npc.newModelColourProduced[11] = 127; // Wing design at the front spike also affect beak
				npc.newModelColourProduced[12] = 127;
				npc.newModelColourProduced[13] = 127;
				npc.newModelColourProduced[14] = 127;
				npc.newModelColourProduced[15] = 127;
				npc.newModelColourProduced[16] = 127;
				npc.newModelColourProduced[17] = 127;
				npc.combatLevel = 0;
				/*
				 * -28134 // Wing outline stripe
				8004 // Nose
				8136
				-26864
				-27231
				-27223
				-27227
				-27112
				-27236
				-28010
				-3165
				-3161
				7872
				7995
				6978
				7991
				7110
				12
				-2131
				-2125
				-31833
				-31846
				-31842
				-2249
				-2245
				8119
				7446
				-5224
				-3409
				-3405
				 */
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				break;
			case 11103:
				data = forId(412);
				npc.name = "Gargoyle pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.scaleZ = 60;
				npc.scaleX = 60;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;
				break;
			case 11102:
				data = forId(2041);
				npc.name = "Broken Handz pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.scaleZ = 90;
				npc.scaleX = 90;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;
				break;
			case 11101:
				data = forId(7668);
				npc.name = "Voice of Yama pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.scaleZ = 70;
				npc.scaleX = 70;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;
				break;
			case 11100:
				data = forId(6077);
				npc.name = "Gnome child pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.scaleZ = 79;
				npc.scaleX = 79;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;
				break;
			case 11099:
				data = forId(998);
				npc.name = "Guard pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.scaleZ = 79;
				npc.scaleX = 79;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.modelColourToEdit = new int[3];
				npc.modelColourToEdit[0] = 25238;
				npc.modelColourToEdit[1] = 8741;
				npc.modelColourToEdit[2] = 61;
				npc.newModelColourProduced = new int[3];
				npc.newModelColourProduced[0] = 10508;
				npc.newModelColourProduced[1] = 6930;
				npc.newModelColourProduced[2] = 5652;
				npc.combatLevel = 0;
				break;
			case 11098:
				data = forId(2207);
				npc.name = "Growler pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.scaleZ = 70;
				npc.scaleX = 70;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;
				break;
			case 11097:
				data = forId(465);
				npc.name = "Skeletal wyvern pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 50;
				npc.scaleX = 50;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = 2989;
				npc.combatLevel = 0;
				break;
			case 11096:
				data = forId(6358);
				npc.name = "Glod pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.scaleZ = 25;
				npc.scaleX = 25;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;
				break;
			case 11095:
				data = forId(1675);
				npc.name = "Karil pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = 2074;
				npc.walkAnim = 2076;
				npc.turn180Sequence = 2076;
				npc.turnLeftSequence = 2076;
				npc.turnRightSequence = 2076;
				npc.scaleZ = 80;
				npc.scaleX = 80;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;
				break;
			case 11094:
				data = forId(319);
				npc.name = "Corporeal beast pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 64;
				npc.scaleX = 64;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;
				//@formatter:off
				npc.modelColourToEdit = new int[] 
					{
					0,
					6340,
					6315,
					5281,
					2332,
					6336,
					103,
					16,
					-21608,
					6323,
					18,
					};
				npc.newModelColourProduced = new int[] 
						{
						0,
						34770,
						34770,
						296770,
						296880,
						34770,
						103,
						16,
						-21608,
						296770,
						18,
						};
				//@formatter:on
				break;
			case 11093:
				data = forId(7697);
				npc.name = "Jal-ImKot pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 45;
				npc.scaleX = 45;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 11092:
				data = forId(6076);
				npc.name = "Tortoise pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 40;
				npc.scaleX = 40;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 6076:
				npc.name = "Tortoise";
				npc.combatLevel = 92;
				npc.size = 3;
				npc.standAnim = 3952;
				npc.walkAnim = 3953;
				npc.turnLeftSequence = 3953;
				npc.turnRightSequence = 3953;
				npc.turn180Sequence = 3953;
				npc.turnSpeed = 15;
				npc.varbit = -1;
				npc.setting = -1;
				npc.headicons = -1;
				npc.brightness = 10;
				npc.brightness = 10;
				npc.scaleZ = 128;
				npc.scaleX = 128;
				npc.contrast = 75;
				npc.interactable = true;
				npc.showOnMinimap = true;
				npc.hasRenderPriority = true;
				npc.actions = new String[5];
				npc.actions[0] = null;
				npc.actions[1] = "Attack";
				npc.actions[2] = null;
				npc.actions[3] = null;
				npc.actions[4] = null;
				npc.models = new int[6];
				npc.models[0] = 14801;
				npc.models[1] = 14803;
				npc.models[2] = 14799;
				npc.models[3] = 14795;
				npc.models[4] = 14797;
				npc.models[5] = 14796;
				break;
			case 16219:
				data = forId(1852);
				npc.size = 3;
				npc.name = "Guard Rabbit";
				npc.actions = new String[5];
				npc.actions[0] = null;
				npc.actions[1] = "Attack";
				npc.actions[2] = null;
				npc.actions[3] = null;
				npc.actions[4] = null;
				npc.models = new int[1];
				npc.models[0] = 65351;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 75;
				npc.scaleX = 75;
				npc.showOnMinimap = true;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 3542:
				npc.name = "Ali the Snake Charmer";
				npc.size = 1;
				npc.standAnim = 1879;
				npc.walkAnim = -1;
				npc.turnLeftSequence = -1;
				npc.turnRightSequence = -1;
				npc.turn180Sequence = -1;
				npc.varbit = -1;
				npc.setting = -1;
				npc.headicons = -1;
				npc.scaleZ = 128;
				npc.scaleX = 128;
				npc.interactable = true;
				npc.showOnMinimap = true;
				npc.hasRenderPriority = true;
				npc.actions = new String[5];
				npc.actions[0] = "Talk-to";
				npc.actions[1] = null;
				npc.actions[2] = null;
				npc.actions[3] = null;
				npc.actions[4] = null;
				npc.models = new int[7];
				npc.models[0] = 6085;
				npc.models[1] = 315;
				npc.models[2] = 173;
				npc.models[3] = 264;
				npc.models[4] = 6100;
				npc.models[5] = 246;
				npc.models[6] = 176;
				npc.modelColourToEdit = new int[3];
				npc.modelColourToEdit[0] = 25238;
				npc.modelColourToEdit[1] = 4663;
				npc.modelColourToEdit[2] = 4550;
				npc.newModelColourProduced = new int[3];
				npc.newModelColourProduced[0] = 10351;
				npc.newModelColourProduced[1] = 10351;
				npc.newModelColourProduced[2] = 5555;
				break;
			case 11091:
				data = forId(4420);
				npc.name = "Cow31337Killer pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 86;
				npc.scaleX = 86;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 11090:
				data = forId(4922);
				npc.name = "Ice Queen pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 90;
				npc.scaleX = 90;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 11089:
				itemData = ItemDefinition.forId(21003);
				npc.name = "Elder maul pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models[0] = itemData.inventoryModel;
				npc.modelColourToEdit = itemData.modelColourToEdit;
				npc.newModelColourProduced = itemData.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.brightness = -55;
				npc.combatLevel = 0;
				break;
			case 5567:
				npc.actions = new String[]
				{"Talk-to", null, null, null, null};
				break;
			case 5536:
			case 5537:
				npc.actions = new String[]
				{"Talk-to", null, "Pick-up", "Metamorphosis", null};
				break;
			case 11088:
				data = forId(547);
				npc.name = "Mi-Gor pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 100;
				npc.scaleX = 100;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 401:
            case 402:
            case 403:
            case 404:
            case 405:
            case 6797:
                npc.actions = new String[5];
                npc.actions[0] = "Talk-to";
                npc.actions[1] = null;
                npc.actions[2] = "Get Task";
                npc.actions[3] = "Reset-task";
                break;
			case 11087:
				data = forId(6562);
				npc.name = "Prospector Percy pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 90;
				npc.scaleX = 90;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 6595:
				npc.name = "<col=00ffff>Ent trunk</col>";
				npc.models = new int[]
				{28261};
				npc.size = 2;
				npc.actions = new String[]
				{"Chop", null, null, null, null};
				npc.showOnMinimap = false;
				npc.combatLevel = 0;
				npc.contrast = 25;
				break;

			case 11086:
				data = forId(7632);
				npc.name = "Halloween dealer";
				npc.actions = new String[5];
				npc.actions[0] = "Open-shop";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = data.scaleZ;
				npc.scaleX = data.scaleX;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				break;
			case 11085:
				npc.name = "Plank pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.showOnMinimap = false;
				npc.models = new int[]
				{15048};
				npc.modelColourToEdit = new int[]
				{6806, 6439, 6558};
				npc.newModelColourProduced = new int[]
				{6796, 6802, 6796};
				npc.combatLevel = 0;
				break;
			case 11084:
				data = forId(5079);
				npc.name = "Delrith pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 40;
				npc.scaleX = 40;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 11083:
				data = forId(465);
				npc.name = "Black Skeletal wyvern pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 50;
				npc.scaleX = 50;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = 2989;
				npc.modelColourToEdit = new int[5];
				npc.modelColourToEdit[0] = 103;
				npc.modelColourToEdit[1] = 82;
				npc.modelColourToEdit[2] = 61;
				npc.modelColourToEdit[3] = 41;
				npc.modelColourToEdit[4] = 0;
				npc.newModelColourProduced = new int[5];
				npc.newModelColourProduced[0] = 20;
				npc.newModelColourProduced[1] = 0;
				npc.newModelColourProduced[2] = 0;
				npc.newModelColourProduced[3] = 0;
				npc.newModelColourProduced[4] = 10;
				npc.combatLevel = 0;
				break;
			case 2585:
				data = forId(2585);
				npc.name = "Abyssal Guardian";
				break;
			case 2586:
				data = forId(2586);
				npc.name = "Abyssal Walker";
				break;
			case 2584:
				data = forId(2584);
				npc.name = "Abyssal Leech";
				break;
			case 11082:
				data = forId(3968);
				npc.name = "Echned Zekin pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 90;
				npc.scaleX = 90;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 11081:
				data = forId(1699);
				npc.name = "Shifter pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 100;
				npc.scaleX = 100;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 11080:
				data = forId(7401);
				npc.name = "Cave abomination pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 50;
				npc.scaleX = 50;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 11079:
				data = forId(6594);
				npc.name = "Ent pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 40;
				npc.scaleX = 40;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 11078:
				data = forId(3456);
				npc.name = "Fareed";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 95;
				npc.scaleX = 95;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 5270:
				npc.name = "The Monkey's Nan";
				break;
			case 7638:
				npc.showOnMinimap = true;
				npc.actions = new String[]
				{"Talk-to", null, null, null, null};
				break;
			case 7632:
				npc.name = "Shady figure";
				break;
			case 680: //giant skeleton for h'ween event
				npc.scaleZ = 200;
				npc.scaleX = 200;
				npc.combatLevel = 173;
				npc.standAnim = 5496;
				npc.walkAnim = 5498;
				npc.name = "Oversized skeleton";
				break;
			case 11073:
				npc.name = "Oversized bones";
				itemData = ItemDefinition.forId(16095);
				npc.models = new int[1];
				npc.models[0] = itemData.inventoryModel;
				npc.modelColourToEdit = itemData.modelColourToEdit;
				npc.newModelColourProduced = itemData.newModelColourProduced;
				npc.showOnMinimap = false;
				break;
			case 11074:
				npc.name = "Dragon bones";
				itemData = ItemDefinition.forId(536);
				npc.models = new int[1];
				npc.models[0] = itemData.inventoryModel;
				npc.modelColourToEdit = itemData.modelColourToEdit;
				npc.newModelColourProduced = itemData.newModelColourProduced;
				npc.showOnMinimap = false;
				break;
			case 11075:
				npc.name = "Lava dragon bones";
				itemData = ItemDefinition.forId(11943);
				npc.models = new int[1];
				npc.models[0] = itemData.inventoryModel;
				npc.modelColourToEdit = itemData.modelColourToEdit;
				npc.newModelColourProduced = itemData.newModelColourProduced;
				npc.showOnMinimap = false;
				break;
			case 11076:
				npc.name = "Fayrg bones";
				itemData = ItemDefinition.forId(4830);
				npc.models = new int[1];
				npc.models[0] = itemData.inventoryModel;
				npc.modelColourToEdit = itemData.modelColourToEdit;
				npc.newModelColourProduced = itemData.newModelColourProduced;
				npc.showOnMinimap = false;
				break;
			case 11077:
				npc.name = "Dagannoth bones";
				itemData = ItemDefinition.forId(6729);
				npc.models = new int[1];
				npc.models[0] = itemData.inventoryModel;
				npc.modelColourToEdit = itemData.modelColourToEdit;
				npc.newModelColourProduced = itemData.newModelColourProduced;
				npc.showOnMinimap = false;
				break;

			case 11072:
				data = forId(604);
				npc.name = "50% Luke pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 105;
				npc.scaleX = 105;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 11071:
				npc.name = "Durial321 pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.newModelColourProduced = new int[]
				{22464, 10512, 10512, 28, 127}; // Colour you want to change to
				npc.modelColourToEdit = new int[]
				{926, 8741, 14490, 4626, 6798}; // Original colour
				npc.standAnim = 808; // Npc's Stand Emote
				npc.walkAnim = 819;
				npc.faceModels = new int[]
				{113, 29};
				npc.showOnMinimap = false;
				npc.scaleX = 105;
				npc.scaleZ = 105;
				npc.models = new int[]
				{6669, 6659, 13307, 170, 3704, 5409, 363, 9347, 9638, 390}; // Models
				npc.combatLevel = 0;
				break;
			case 679:
				npc.name = "Tradesman";
				npc.actions = new String[]
				{"View-shops", null, null, null, null};
				break;
			case 5449:
				npc.actions = new String[]
				{"Talk-to", null, "Decant", null, null};
				break;
			case 1177:
				npc.name = "Thief";
				npc.actions = new String[]
				{"Talk-to", null, null, null, null};
				break;
			case 11070:
				data = forId(4693);
				npc.name = "Fear reaper pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 60;
				npc.scaleX = 60;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 11069:
				data = forId(7242);
				npc.name = "Black demon pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 37;
				npc.scaleX = 37;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 11068:
				data = forId(1118);
				npc.name = "Anti-santa pet";
				npc.models = new int[]
				{28975, 28977, 28980, 28982, 28984, 28988}; // Models
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.standAnim = data.standAnim; // Npc's Stand Emote
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.scaleZ = 90;
				npc.scaleX = 90;
				npc.combatLevel = 0;
				break;
			case 11067:
				data = forId(2063);
				npc.name = "Penguin pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 100;
				npc.scaleX = 100;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 11066:
				data = forId(229);
				npc.name = "Demon butler pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 100;
				npc.scaleX = 100;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 11065:
				data = forId(6372);
				npc.name = "Dessourt pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 93;
				npc.scaleX = 93;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;

			case 11064:
				data = forId(6593);
				npc.name = "Lava dragon pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 40;
				npc.scaleX = 40;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;

			case 11063:
				data = forId(7698);
				npc.name = "Jal-xil pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 35;
				npc.scaleX = 35;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;

			case 11062:
				data = forId(326);
				npc.name = "Genie pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 90;
				npc.scaleX = 90;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 11061:
				npc.name = "Planker";
				npc.showOnMinimap = false;
				npc.models = new int[]
				{12306};
				npc.modelColourToEdit = new int[]
				{6707, 7952};
				npc.newModelColourProduced = new int[]
				{4510, 4502};
				break;

			case 11060:
				data = forId(763);
				npc.name = "Mcribb pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 35;
				npc.scaleX = 35;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 517:
				npc.name = "General store";
				npc.actions = new String[]
				{"View", null, null, null, null};
				break;
			case 100:
			case 7206:
				npc.showOnMinimap = true; //rock crabs and sand crabs
				break;
			case 11059:
				data = forId(7672);
				npc.name = "Eve pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 100;
				npc.scaleX = 100;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 11058:
				data = forId(3475);
				npc.name = "The Untouchable pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 57;
				npc.scaleX = 57;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 11056:
				data = forId(3616);
				npc.name = "Treus Dayth pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 80;
				npc.scaleX = 80;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 11055:
				data = forId(3077);
				npc.name = "Hans pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 100;
				npc.scaleX = 100;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 5083:
				npc.name = "Achievement rewards";
				npc.actions = new String[]
				{"View", null, null, null, null};
				break;
			case 11057:
				npc.name = "@whi@Durial321 @yel@[Lottery]";
				npc.actions = new String[]
				{"Talk-to", null, "Enter-lottery", "Check-pot", null};
				npc.newModelColourProduced = new int[]
				{22464, 10512, 10512, 28, 127}; // Colour you want to change to
				npc.modelColourToEdit = new int[]
				{926, 8741, 14490, 4626, 6798}; // Original colour
				npc.standAnim = 808; // Npc's Stand Emote
				npc.walkAnim = 819;
				npc.combatLevel = 115;//Combat Level
				npc.description = "Ur fault";
				npc.faceModels = new int[]
				{31569};
				npc.models = new int[]
				{6669, 6659, 13307, 170, 3704, 5409, 363, 9347, 9638, 390}; // Models
				break;

			case 11054:
				data = forId(3028);
				npc.name = "Goblin pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 95;
				npc.scaleX = 95;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 11053:
				data = forId(2807);
				npc.name = "Cow calf pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 60;
				npc.scaleX = 60;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 11052:
				data = forId(7706);
				npc.name = "TzKal-Zuk pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.standAnim;
				npc.turnLeftSequence = data.standAnim;
				npc.turnRightSequence = data.standAnim;
				npc.scaleZ = 25;
				npc.scaleX = 25;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.standAnim;
				npc.combatLevel = 0;
				break;
			case 11051:
				itemData = ItemDefinition.forId(12817);
				npc.name = "Elysian spirit shield pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models[0] = itemData.inventoryModel;
				npc.modelColourToEdit = itemData.modelColourToEdit;
				npc.newModelColourProduced = itemData.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.brightness = -55;
				npc.combatLevel = 0;
				break;
			case 11050:
				data = forId(4912);
				npc.name = "War tortoise pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.standAnim;
				npc.turnLeftSequence = data.standAnim;
				npc.turnRightSequence = data.standAnim;
				npc.scaleZ = 37;
				npc.scaleX = 37;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.standAnim;
				npc.combatLevel = 0;
				break;
			case 11049:
				data = forId(7562);
				npc.name = "Muttadile pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 50;
				npc.scaleX = 50;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 11048:
				data = forId(7233);
				npc.name = "Lucky impling pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = data.scaleZ + 50;
				npc.scaleX = data.scaleX + 50;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 11047:
				data = forId(3474);
				npc.name = "The Everlasting pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 57;
				npc.scaleX = 57;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 11046:
				data = forId(7102);
				npc.name = "Mutated Glough pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 57;
				npc.scaleX = 57;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 11045:
				data = forId(6637);
				npc.name = "Kalphite Princess pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 35;
				npc.scaleX = 35;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;

			case 11044:
				data = forId(5504);
				npc.name = "Mr. Mordaut pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = npc.standAnim;
				npc.turnLeftSequence = npc.standAnim;
				npc.turnRightSequence = npc.standAnim;
				npc.walkAnim = npc.standAnim;
				npc.scaleZ = 40;
				npc.scaleX = 40;
				npc.size = 2;
				npc.combatLevel = 0;
				break;

			case 11043:
				data = forId(7277);
				npc.name = "Warped Jelly pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 80;
				npc.scaleX = 80;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 11042:
				data = forId(5523);
				npc.name = "Donator pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 100;
				npc.scaleX = 100;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 11041:
				data = forId(3473);
				npc.name = "The Inadequacy pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 26;
				npc.scaleX = 26;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 11040:
				data = forId(3140);
				npc.name = "Icefiend pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 110;
				npc.scaleX = 110;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;

			case 5523:
				npc.name = "Donator (virtual) assistant";
				npc.actions = new String[]
						{"Talk-to", null, "Trade", null, null};
				break;
			case 3463:
				npc.name = "Scalper";
				npc.actions = new String[]
						{"Trade", null, null, null, null};
				break;
			case 2713:
				npc.name = "Doc Holiday";
				npc.actions = new String[]
						{"Talk-to", null, null, null, null};
				break;
			case 11039:
				data = forId(1378);
				npc.name = "The Kendal pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 67;
				npc.scaleX = 67;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;

			case 11038:
				itemData = ItemDefinition.forId(11802);
				npc.name = "Armadyl godsword pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models[0] = itemData.inventoryModel;
				npc.modelColourToEdit = itemData.modelColourToEdit;
				npc.newModelColourProduced = itemData.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.brightness = -55;
				npc.combatLevel = 0;
				break;

			case 11037:
				data = forId(6477);
				npc.name = "Mutant tarn pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 40;
				npc.scaleX = 40;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;

			case 11036:
				data = forId(2067);
				npc.name = "Mounted terrorbird pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 75;
				npc.scaleX = 75;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;

			case 11035:
				data = forId(4130);
				npc.name = "Dad pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 70;
				npc.scaleX = 70;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;

			case 11034:
				itemData = ItemDefinition.forId(11863);
				npc.name = "Rainbow partyhat pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models[0] = itemData.inventoryModel;
				npc.modelColourToEdit = itemData.modelColourToEdit;
				npc.newModelColourProduced = itemData.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;
				break;

			case 11033:
				data = forId(5792);
				npc.name = "Party Pete pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 100;
				npc.scaleX = 100;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;

			case 11032:
				data = forId(7152);
				npc.name = "Demonic gorilla pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 37;
				npc.scaleX = 37;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;

			case 11031:
				data = forId(7700);
				npc.name = "JalTok-Jad pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 21;
				npc.scaleX = 21;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 11030:
				data = forId(7394);
				npc.name = "Flaming pyrelord pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 60;
				npc.scaleX = 60;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 11029:
				data = forId(2108);
				npc.name = "Wise Old Man pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 100;
				npc.scaleX = 100;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 11028:
				data = forId(7406);
				npc.name = "Nuclear smoke devil pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 50;
				npc.scaleX = 50;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;

			case 11027:
				data = forId(5567);
				npc.name = "Death pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 100;
				npc.scaleX = 100;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				//data = forId(3078); // Man npc id
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 1915:
				npc.actions[0] = "Pick-up";
				npc.showOnMinimap = false;
				break;

			case 11025:
				data = forId(6593);
				npc.name = "Empowered Lava dragon";
				npc.combatLevel = 286;
				npc.actions = data.actions;
				npc.brightness = data.brightness;
				npc.contrast = data.contrast;
				npc.faceModels = data.faceModels;
				npc.models = data.models;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.setting = data.setting;
				npc.size = data.size;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.turn180Sequence;
				npc.turnLeftSequence = data.turnLeftSequence;
				npc.turnRightSequence = data.turnRightSequence;
				npc.varbit = data.varbit;
				npc.type = data.type;
				break;

			case 11026:
				data = forId(397);
				npc.name = "Banker pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 100;
				npc.scaleX = 100;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.description = null;
				npc.showOnMinimap = false;
				data = forId(3078); // Man npc id
				npc.walkAnim = data.walkAnim;
				npc.combatLevel = 0;
				break;
			case 7315:
				
					npc.name = "Blood money pet";
					npc.actions = new String[5];
					npc.interactable = true;
					npc.actions[0] = "Pick-up";
					npc.modelColourToEdit = new int[1];
					npc.modelColourToEdit[0] = 8128;
					npc.newModelColourProduced = new int[1];
					npc.newModelColourProduced[0] = 940;
					npc.showOnMinimap = false;
				
				/*npc.actions = new String[5];
				npc.interactable = true;
				npc.actions[0] = "Pick-up";
				npc.showOnMinimap = false;
				npc.combatLevel = 0;*/
				break;

			case 2188:
				npc.standAnim = -1;
				npc.walkAnim = -1;
				break;

			case 3343:
				npc.name = "Nurse Tafani";
				npc.actions = new String[5];
				npc.actions[0] = "Heal";
				npc.actions[2] = "Blood money shop";
				npc.actions[3] = "Buy-back untradeables";
				npc.actions[4] = "Call Hybrids";
				break;

			// Party pete
			case 5792:
				npc.actions = new String[5];
				npc.actions[0] = "Talk-to";
				npc.actions[2] = "Clue casket shop";
				npc.actions[3] = "High-risk shop";
				break;
			// Vote manager/penguin.
			case 7283:
				npc.name = "Vote manager";
				
				break;
			// ZMI
			case 7422:
			case 7425:
			case 7423:
				npc.name = "Zamorak Mage";
				break;
			case 7418:
			case 7419:
				npc.name = "Zamorak Warrior";
				break;
			case 7426:
				npc.name = "Zamorak Crafter";
				break;
			case 7420:
			case 7421:
				npc.name = "Zamorak Ranger";
				break;
			// Cleaner npc at resource wilderness area.
			case 2901:
				npc.actions = new String[5];
				npc.actions[0] = "Note-items";
				npc.actions[2] = "Take 10 coal";
				break;
			case 11024:
				data = forId(1873);
				npc.name = "Yoshi pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.standAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;
				npc.modelColourToEdit = new int[14];
				npc.newModelColourProduced = new int[14];
				colour = 51136;
				npc.modelColourToEdit[0] = 29976;
				npc.newModelColourProduced[0] = 419770;

				colour = 419770;
				npc.modelColourToEdit[1] = 7502;
				npc.newModelColourProduced[1] = 356770 ;

				colour = 419770;
				npc.modelColourToEdit[2] = 27819;
				npc.newModelColourProduced[2] = 356770 ;

				colour = 419770;
				npc.modelColourToEdit[3] = 0;
				npc.newModelColourProduced[3] =   0 ;

				colour = 419770;
				npc.modelColourToEdit[4] = 29980;
				npc.newModelColourProduced[4] =419770;

				colour = 419770;
				npc.modelColourToEdit[5] = 28302;
				npc.newModelColourProduced[5] =  419770;

				colour = 419770;
				npc.modelColourToEdit[6] = 29980;
				npc.newModelColourProduced[6] = 419770;

				colour = 419770;
				npc.modelColourToEdit[7] = 27934;
				npc.newModelColourProduced[7] = 419770;
				
				// Circle on the ground, most inner first circle
				colour = 419770;
				npc.modelColourToEdit[8] = -26214;
				npc.newModelColourProduced[8] = 419770;

				// Second circle
				colour = 419770;
				npc.modelColourToEdit[9] = -26218;
				npc.newModelColourProduced[9] = 419770;

				// Third circle
				colour = 419770;
				npc.modelColourToEdit[10] = -26094;
				npc.newModelColourProduced[10] = 356770 ;

				// Fourth circle
				colour = 419770;
				npc.modelColourToEdit[11] = -25970;
				npc.newModelColourProduced[11] = 356770 ;

				// Fifth circle
				colour = 419770;
				npc.modelColourToEdit[12] = -25718;
				npc.newModelColourProduced[12] = 356770 ;

				// Sixth circle
				colour = 419770;
				npc.modelColourToEdit[13] = -23672;
				npc.newModelColourProduced[13] = 356770 ;
				
				break;
			case 11023:
				data = forId(7544);
				npc.name = "Tekton pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 30;
				npc.scaleX = 30;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;
				break;
			
			case 11022:
				data = forId(5866);
				npc.name = "Cerberus pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 26;
				npc.scaleX = 26;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;
				break;
			case 11021:
				data = forId(319);
				npc.name = "Corporeal beast pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 64;
				npc.scaleX = 64;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;
				break;
			case 11020:
				data = forId(1673);
				npc.name = "Dharok pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 80;
				npc.scaleX = 80;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;
				break;
			case 11019:
				data = forId(7286);
				npc.name = "Skotos";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 23;
				npc.scaleX = 23;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;
				break;
			case 11018:
				data = forId(5951);
				npc.name = "Camel pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 81;
				npc.scaleX = 81;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;
				break;
			case 11017:
				data = forId(7531);
				npc.name = "Vespula";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 31;
				npc.scaleX = 31;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;
				break;
			case 11016:
				data = forId(7566);
				npc.name = "Vasa Nistirio";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 25;
				npc.scaleX = 25;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;
				break;
			case 11015:
				data = forId(4005);
				npc.name = "The Night Beast";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models[0] = 32933;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.scaleZ = 42;
				npc.scaleX = 42;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;
				break;
			case 11013:
				EntityDefinition td = forId(11011);
				npc.name = "Tormented demon pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = new int[1];
				npc.models = td.models;
				npc.standAnim = td.standAnim;
				npc.walkAnim = td.walkAnim;
				npc.turn180Sequence = td.turn180Sequence;
				npc.turnLeftSequence = td.turnLeftSequence;
				npc.turnRightSequence = td.turnRightSequence;
				npc.scaleZ = 40;
				npc.scaleX = 40;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;
				break;

			case 11012:
				EntityDefinition ice = forId(11006);
				npc.name = "Ice strykewyrm pet";
				npc.actions = new String[5];
				npc.actions[0] = "Pick-up";
				npc.models = ice.models;
				npc.standAnim = ice.standAnim;
				npc.walkAnim = ice.walkAnim;
				npc.turn180Sequence = ice.turn180Sequence;
				npc.turnLeftSequence = ice.turnLeftSequence;
				npc.turnRightSequence = ice.turnRightSequence;
				npc.scaleZ = 33;
				npc.scaleX = 33;
				npc.description = null;
				npc.showOnMinimap = false;
				npc.combatLevel = 0;
				break;
			case 11007:
				npc.name = "Revenant dark beast";
				npc.combatLevel = 120;
				npc.standAnim = 11017;
				npc.walkAnim = 11018;
				npc.turn180Sequence = 11018;
				npc.turnLeftSequence = 11018;
				npc.turnRightSequence = 11018;
				npc.size = 3;
				npc.actions = new String[5];
				npc.actions[0] = null;
				npc.actions[1] = "Attack";
				npc.actions[2] = null;
				npc.actions[3] = null;
				npc.actions[4] = null;
				npc.models = new int[1];
				npc.models[0] = 65000;
				break;
			case 5090:
				data = forId(7544);
				npc.name = "Tekton";
				npc.actions = new String[5];
				npc.actions[0] = null;
				npc.actions[1] = "Attack";
				npc.actions[2] = null;
				npc.actions[3] = null;
				npc.actions[4] = null;
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.size = 7;
				npc.combatLevel = 750;
				break;
			case 5091:
				data = forId(7544);
				npc.name = "Tekton";
				npc.actions = new String[5];
				npc.actions[0] = null;
				npc.actions[1] = "Attack";
				npc.actions[2] = null;
				npc.actions[3] = null;
				npc.actions[4] = null;
				npc.models = new int[1];
				npc.models = data.models;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.size = 7;
				npc.combatLevel = 750;
				break;
			case 11008:
				npc.name = "Revenant demon";
				npc.combatLevel = 98;
				npc.standAnim = 7479;
				npc.walkAnim = 7480;
				npc.turn180Sequence = 7480;
				npc.turnLeftSequence = 7480;
				npc.turnRightSequence = 7480;
				npc.size = 2;
				npc.actions = new String[5];
				npc.actions[0] = null;
				npc.actions[1] = "Attack";
				npc.actions[2] = null;
				npc.actions[3] = null;
				npc.actions[4] = null;
				npc.models = new int[1];
				npc.models[0] = 65001;
				break;

			case 11009:
				npc.name = "Revenant hellhound";
				npc.combatLevel = 90;
				npc.standAnim = 11030;
				npc.walkAnim = 11031;
				npc.turn180Sequence = 11031;
				npc.turnLeftSequence = 11031;
				npc.turnRightSequence = 11031;
				npc.size = 2;
				npc.actions = new String[5];
				npc.actions[0] = null;
				npc.actions[1] = "Attack";
				npc.actions[2] = null;
				npc.actions[3] = null;
				npc.actions[4] = null;
				npc.models = new int[1];
				npc.models[0] = 65002;
				break;

			case 11010:
				npc.name = "Revenant ork";
				npc.combatLevel = 105;
				npc.standAnim = 11024;
				npc.walkAnim = 11025;
				npc.turn180Sequence = 11025;
				npc.turnLeftSequence = 11025;
				npc.turnRightSequence = 11025;
				npc.size = 1;
				npc.actions = new String[5];
				npc.actions[0] = null;
				npc.actions[1] = "Attack";
				npc.actions[2] = null;
				npc.actions[3] = null;
				npc.actions[4] = null;
				npc.models = new int[1];
				npc.models[0] = 65003;
				break;

			case 11011:
				npc.name = "Tormented demon";
				npc.combatLevel = 450;
				npc.standAnim = 11007;
				npc.walkAnim = 11008;
				npc.turn180Sequence = 11008;
				npc.turnLeftSequence = 11008;
				npc.turnRightSequence = 11008;
				npc.size = 3;
				npc.actions = new String[5];
				npc.actions[0] = null;
				npc.actions[1] = "Attack";
				npc.actions[2] = null;
				npc.actions[3] = null;
				npc.actions[4] = null;
				npc.models = new int[1];
				npc.models[0] = 44733;
				npc.headicons = 0;
				break;
			case 11006:
				npc.name = "Ice strykewyrm";
				npc.combatLevel = 210;
				npc.standAnim = 11003;
				npc.walkAnim = 11003;
				npc.turn180Sequence = 11003;
				npc.turnLeftSequence = 11003;
				npc.turnRightSequence = 11003;
				npc.size = 3;
				npc.actions = new String[5];
				npc.actions[0] = null;
				npc.actions[1] = "Attack";
				npc.actions[2] = null;
				npc.actions[3] = null;
				npc.actions[4] = null;
				npc.models = new int[2];
				npc.models[0] = 51847;
				npc.models[1] = 51849;
				break;
			// Kree'arra
			case 3162:
				npc.scaleZ = 100;
				npc.scaleX = 100;
				break;
			// Gome shop keeper.
			case 6083:
				npc.actions = new String[5];
				npc.actions[0] = "Talk-to";
				break;

			case 315:
				npc.name = "Pvp task master";
				npc.actions = new String[5];
				npc.actions[0] = "Talk-to";
				npc.actions[2] = "Obtain task";
				npc.actions[3] = "Claim reward";
				npc.actions[4] = "Kills left";
				break;
			case 11000: //dh tournament
				npc.actions = new String[]
				{"Information", "Enter", null, null, null}; // Actions for the npc
				npc.models = new int[]
				{6651, 6702, 6670, 6639, 6660, 290, 13307, 9638, 27638, 247}; // Models
				npc.modelColourToEdit = new int[]
				{10394, 10388, 10394, 10388, 127, 5916, 4882}; // Colour you want to change to
				npc.newModelColourProduced = new int[]
				{10388, 10508, 10512, 10760, 960, 127, 127}; // Original colour
				npc.standAnim = 2065; // Npc's Stand Emote
				npc.walkAnim = 1146;
				npc.name = "Dharok's tournament";
				npc.combatLevel = 1337; //Combat Level
				break;

			case 11001: //pure hybrid tournament
				npc.actions = new String[]
				{"Information", "Enter", null, null, null}; // Actions for the npc
				npc.models = new int[]
				{8383, 8382, 202, 6232, 13307, 556, 323, 3704, 235, 290, 247}; // Models
				npc.modelColourToEdit = new int[]
				{38814, 10394, 8656, 5018, 61, 10351, 926, 7700, 11200, 6032, 4626, 127, 5916, 4882}; // Colour you want to change to
				npc.newModelColourProduced = new int[]
				{22428, 21662, 21776, 22428, 11177, 61, 22426, 22426, -31846, -31846, 28, -14425, 127, 127}; // Original colour
				npc.standAnim = 809; // Npc's Stand Emote
				npc.walkAnim = 1146;
				npc.name = "Pure Hybrid tournament";
				npc.combatLevel = 1337; //Combat Level
				break;

			case 11002: //zerk hybrid tournament
				npc.actions = new String[]
				{"Information", "Enter", null, null, null}; // Actions for the npc
				npc.models = new int[]
				{6232, 4952, 4953, 5028, 4844, 323, 3704, 290, 556, 5027, 210, 247}; // Models
				npc.modelColourToEdit = new int[]
				{40045, 40918, 40384, 119, 5018, 61, 10351, 926, 7700, 11200, 6032, 40384, 40918, 127, 5916, 4882}; // Colour you want to change to
				npc.newModelColourProduced = new int[]
				{924, 148, 0, 924, 937, 11177, 61, 0, 0, 926, 926, 924, 0, -14425, 127, 127}; // Original
				npc.standAnim = 809; // Npc's Stand Emote
				npc.walkAnim = 1146;
				npc.name = "Zerk Hybrid tournament";
				npc.combatLevel = 1337; //Combat Level
				break;

			case 11003: //main welf hybrid tournament
				npc.actions = new String[]
				{"Information", "Enter", null, null, null}; // Actions for the npc
				npc.models = new int[]
				{6232, 21873, 4952, 4953, 5028, 4844, 323, 3704, 290, 556, 247}; // Models
				npc.newModelColourProduced = new int[]
				{127, -21593, 10714, 127, 28, -14425, 127, 127, 937, 11177, 61}; // Colour you want to change to
				npc.modelColourToEdit = new int[]
				{926, 7700, 11200, 6032, 4628, 127, 5916, 4882, 5018, 61, 10351}; // Original colour
				npc.standAnim = 809; // Npc's Stand Emote
				npc.walkAnim = 1146;
				npc.name = "Main Welfare Brid tournament";
				npc.combatLevel = 1337; //Combat Level
				break;

			case 11005: //main welf hybrid tournament
				npc.actions = new String[]
				{"Information", "Enter", null, null, null}; // Actions for the npc
				npc.models = new int[]
				{6232, 21873, 4952, 4953, 5028, 4844, 323, 3704, 290, 556, 247}; // Models
				npc.newModelColourProduced = new int[]
				{127, -21593, 10714, 127, 28, -14425, 127, 127, 937, 11177, 61}; // Colour you want to change to
				npc.modelColourToEdit = new int[]
				{926, 7700, 11200, 6032, 4628, 127, 5916, 4882, 5018, 61, 10351}; // Original colour
				npc.standAnim = 809; // Npc's Stand Emote
				npc.walkAnim = 1146;
				npc.name = "Main Barrows Brid tournament";
				npc.combatLevel = 1337; //Combat Level
				break;

			case 11004: //max main hybrid tournament
				npc.actions = new String[]
				{"Information", "Enter", null, null, null}; // Actions for the npc
				npc.models = new int[10]; //Number of models it uses
				npc.models[0] = 6669; //Ahrims body
				npc.models[1] = 6659; //Ahrims skirt
				npc.models[2] = 13307; //Barrows gloves
				npc.models[3] = 170; //Ahrims (arms)
				npc.models[4] = 29249; //Eternal Boots
				npc.models[5] = 14402; //Toxic staff of the dead
				npc.models[6] = 14395; //Serp helm
				npc.models[7] = 11050; //Arcane spirit shield
				npc.models[8] = 28480; // Fury (or)
				npc.models[9] = 28201; //Ardy cloak
				npc.models[10] = 247;
				npc.newModelColourProduced = new int[]
				{10512, 10512, 21947}; // Colour you want to change to
				npc.modelColourToEdit = new int[]
				{8741, 14490, 17467}; // Original colour
				npc.standAnim = 809; // Npc's Stand Emote
				npc.walkAnim = 1146;
				npc.name = "Max Main Brid tournament";
				npc.combatLevel = 1337;//Combat Level
				break;
			case 11250: //pure hybrid tournament
				npc.actions = new String[]
				{"Talk-to", null, null, null, null}; // Actions for the npc
				npc.models = new int[]
				{8383, 8382, 202, 6232, 13307, 556, 323, 3704, 235, 290, 247}; // Models
				npc.modelColourToEdit = new int[]
				{38814, 10394, 8656, 5018, 61, 10351, 926, 7700, 11200, 6032, 4626, 127, 5916, 4882}; // Colour you want to change to
				npc.newModelColourProduced = new int[]
				{22428, 21662, 21776, 22428, 11177, 61, 22426, 22426, -31846, -31846, 28, -14425, 127, 127}; // Original colour
				npc.standAnim = 809; // Npc's Stand Emote
				npc.walkAnim = 1146;
				npc.name = "@whi@Zezima @yel@[Events]";
				npc.combatLevel = 64; //Combat Level
				break;
			case 11252: //Nexicus
				npc.actions = new String[]
				{"Talk-to", null, null, null, null}; // Actions for the npc
				npc.models = new int[]//torso,legs,hat,gloves,shield,boots,x,290
				{40003, 40005, 40001, 6232, 26423, 556, 323, 3704, 235, 31227, 247}; // Models
				npc.modelColourToEdit = new int[]
				{38814, 10394, 8656, 5018, 61, 10351, 926, 7700, 11200, 6032, 4626, 127, 5916, 4882}; // Colour you want to change to
				npc.newModelColourProduced = new int[]
				{22428, 21662, 21776, 22428, 11177, 61, 22426, 22426, -31846, -31846, 28, -14425, 127, 127}; // Original colour
				npc.standAnim = 809; // Npc's Stand Emote
				npc.walkAnim = 1146;
				npc.name = "Nexicus";
				npc.combatLevel = 138; //Combat Level
				break;
			case 520:
				npc.name = "Fairy";
				npc.actions = new String[5];
				npc.actions[0] = "Change title";
				break;

			// Cow1337killr.
			case 4420:
				npc.actions = new String[5];
				npc.actions[0] = "Join tournament";
				break;

			case 4421:
				data = forId(4420);
				npc.name = "Player Pet";
				npc.actions = new String[5];
				npc.actions[0] = "None";
				npc.models = data.models;
				npc.modelColourToEdit = data.modelColourToEdit;
				npc.newModelColourProduced = data.newModelColourProduced;
				npc.standAnim = data.standAnim;
				npc.walkAnim = data.walkAnim;
				npc.turn180Sequence = data.walkAnim;
				npc.turnLeftSequence = data.walkAnim;
				npc.turnRightSequence = data.walkAnim;
				npc.showOnMinimap = false;
				npc.scaleZ = 100;
				npc.scaleX = 100;
				npc.combatLevel = 0;
				break;

			
			// Ajjat.
			case 4288:
				npc.actions = new String[]
				{"Talk-to", null, "Trade", null, null};
				break;

			// King Arthur.
			case 251:
				npc.actions = new String[]
				{"Talk-to", null, "Restore stats", null, null};
				break;

				// Aubury.
				case 637:
					npc.actions = new String[]
					{"Teleport", null, null, null, null};
					break;
			// Aubury.
			case 553:
				npc.actions = new String[]
				{"Talk-to", null, "Teleport", null, null};
				break;

			case 1337: //max hit dummy
				npc.actions = new String[]
				{null, "Test-max hit", null, null, null}; // Actions for the npc
				npc.models = new int[1]; //Number of models it uses
				npc.models[0] = 1286; //
				npc.standAnim = -1; // Npc's Stand Emote
				npc.name = "<col=00ffff>Max hit dummy</col>";
				npc.newModelColourProduced = new int[]
				{7954}; // Colour you want to change to
				npc.modelColourToEdit = new int[]
				{6044}; // Original colour
				npc.description = "Attack this dummy to see your current max hit.";
				npc.combatLevel = 0;
				npc.showOnMinimap = false;
				break;

			// Void knight.
			case 1758:
				if (Config.ECO) {
					npc.name = "Blood money merchant";
					npc.actions[0] = "Talk-to";
					npc.actions[1] = null;
					npc.actions[2] = "Blood money";
				}
				else {
					npc.name = "Blood money merchant";
					npc.actions[0] = "Talk-to";
					npc.actions[1] = null;
					npc.actions[2] = "Blood money";
					npc.actions[3] = "Untradeables";
					npc.actions[4] = "Buy-back untradeables";
				}
				break;

			case 1174: // Jatix
			case 1048: // Drogo dwarf.
				npc.actions[0] = "Trade";
				npc.actions[1] = null;
				npc.actions[2] = null;
				break;
			case 2580: // Mage of Zamorak
				npc.actions[0] = "Speak To";
				npc.actions[1] = null;
				npc.actions[2] = null;
				break;
			case 512: // Shopkeeper
				if (Config.ECO) {
					npc.name = "Skilling & Supplies shop";
					npc.actions[0] = "View";
					npc.actions[1] = null;
					npc.actions[2] = "Decant";
				}
				else {
					npc.actions[0] = "More-shops";
					npc.actions[1] = null;
					npc.actions[2] = "Cape shop";
					npc.actions[3] = "Supplies";
					npc.actions[4] = "Decant";
				}
				break;

			// Martin the master gardener.
			case 5832:
				npc.actions[0] = "View-shop";
				npc.actions[1] = null;
				npc.actions[2] = "Note-items";
				break;

			// Runecessoral sire, remove the attack option from first click.
			case 5886:
				npc.actions[0] = null;
				break;

			// Ellis.
			case 3231:
				npc.actions = new String[5];
				npc.actions[0] = "Talk-to";
				npc.actions[2] = null;
				break;

			// Kolodion.
			case 905:
				npc.actions[0] = "Trade";
				break;

			// Farmer.
			case 7:
				npc.actions[1] = null;
				break;

			// Paladin.
			case 2256:
				npc.actions[1] = null;
				break;

			// Hero.
			case 21:
			case 20: // Paladin
			case 23: // Knight of ardougne
				npc.actions[1] = null;
				break;

			// Sigmund the Merchant.
			case 1282:
				npc.actions[0] = null;
				break;

			case 505: // Bob
				npc.actions = new String[]
				{"Talk-to", null, "Repair-barrows", null, null}; // Actions for the npc
				break;


			// Gundai at Mage-bank.
			case 902:
				npc.actions[3] = null;
				break;
			case 3913:
				npc.name = "Fishing spot";
				npc.actions[0] = "Fish-shrimp";
				npc.actions[1] = null;
				npc.actions[2] = "Fish-trout/salmon";
				npc.actions[3] = null;
				npc.actions[4] = null;
				npc.description = "Shrimp can be found here.";
				break;
			case 3914:
				npc.name = "Fishing spot";
				npc.actions = new String[5];
				npc.actions[0] = "Fish-lobster";
				npc.actions[1] = null;
				npc.actions[2] = "Fish-tuna/swordfish";
				npc.actions[3] = null;
				npc.actions[4] = null;
				npc.description = "Lobsters can be found here.";
				break;
			case 3915:
				npc.name = "Fishing spot";
				npc.actions = new String[5];
				npc.actions[0] = "Fish-dark crab";
				npc.actions[1] = null;
				npc.actions[2] = null;
				npc.actions[3] = null;
				npc.actions[4] = null;
				npc.description = "Dark crabs can be fished here.";
				break;
			case 4082:
				npc.name = "Fishing spot";
				npc.actions = new String[5];
				npc.actions[0] = "Fish-anglerfish";
				npc.actions[1] = null;
				npc.actions[2] = null;
				npc.actions[3] = null;
				npc.actions[4] = null;
				npc.description = "Anglerfish can be fished here.";
				break;
			case 635:
				npc.name = "Fishing spot";
				npc.actions = new String[5];
				npc.actions[0] = "Fish-monkfish";
				npc.actions[1] = null;
				npc.actions[2] = null;
				npc.actions[3] = null;
				npc.actions[4] = null;
				npc.description = "Monkfish can be found here.";
				break;
			case 1506:
				npc.name = "Fishing spot";
				npc.actions = new String[5];
				npc.actions[0] = "Fish-shark";
				npc.actions[1] = null;
				npc.actions[2] = null;
				npc.actions[3] = null;
				npc.actions[4] = null;
				npc.description = "Sharks can be found here.";
				break;
			case 6:
				npc.actions[0] = "Pickpocket";
				npc.actions[1] = null;
				npc.actions[2] = null;
				npc.actions[3] = null;
				npc.actions[4] = null;
				break;
			case 527:
				npc.name = "Zeke";
				npc.actions = new String[]
						{"Talk-to", null, null, null, null};
				//npc.combatLevel = 0;
				break;
			case 6066:
				npc.name = "Lowe";
				npc.actions = new String[]
						{"Talk-to", null, null, null, null};
				npc.combatLevel = 0;
				break;
			case 3246:
				npc.name = "Aubury";
				npc.actions = new String[]
						{"Talk-to", null, null, null, null};
			//	npc.combatLevel = 0;
				break;
			case 5438:
				npc.name = "Gile supplies";
				npc.actions = new String[]
						{"Talk-to", null, null, null, null};
				//npc.combatLevel = 0;
				break;
			case 3312:
				npc.name = "Guide";
				npc.actions = new String[]
						{"Talk-to", null, null, null, null};
				//npc.combatLevel = 0;
				break;
			case 4414:
				npc.name = "Pure";
				npc.actions = new String[]
						{"Talk-to", null, null, null, null};
				npc.combatLevel = 0;
				break;
			case 1504:
				npc.name = "Skilling";
				npc.actions = new String[]
						{"Talk-to", null, null, null, null};
				npc.combatLevel = 0;
				break;
			// Horvik.
			case 535:
				
					npc.name = "Horvik";
					npc.actions = new String[]
							{"Talk-to", null, null, null, null};
					npc.combatLevel = 0;
			
				break;

			case 513: // Shopkeeper at Entrana.
				npc.actions[0] = "Skilling";
				npc.actions[1] = null;
				npc.actions[2] = "Decant";
				break;


			// Bob
			case 519:
				npc.actions[2] = null;
				break;

			case 4397:
			case 1559:
				npc.name = "Tele-Wizard";
				npc.actions[1] = null;
				npc.actions[2] = "Last-teleport";
				npc.actions[3] = null;
				npc.actions[4] = null;
				npc.description = "A teleporter.";
				break;

			// Thessalia
			case 534:
				npc.actions = new String[5];
				npc.actions[0] = "Talk-to";
				npc.actions[1] = null;
				npc.actions[2] = null;
				npc.actions[3] = null;
				npc.actions[4] = null;
				npc.description = "The mother of clothing.";
				break;

			case 596:
				npc.name = "Merchant";
				npc.actions[0] = "Open shop-of";
				npc.actions[1] = null;
				npc.actions[2] = null;
				npc.actions[3] = null;
				npc.actions[4] = null;
				npc.description = "A merchant.";
				break;

			// Ajjat
			case 2460:
				npc.actions[0] = "Open store";
				npc.actions[1] = null;
				npc.actions[2] = null;
				npc.actions[3] = null;
				npc.actions[4] = null;
				break;

			// TzHaar-Mej-Jal
			case 2180:
				npc.actions[0] = "Exchange fire cape";
				npc.actions[1] = null;
				npc.actions[2] = null;
				npc.actions[3] = null;
				npc.actions[4] = null;
				break;

		}
	}

	public Model getHead() {
		if (childrenIDs != null) {
			EntityDefinition entityDef = getOverride();
			if (entityDef == null)
				return null;
			else
				return entityDef.getHead();
		}
		if (faceModels == null)
			return null;
		boolean flag1 = false;
		for (int i = 0; i < faceModels.length; i++)
			if (!Model.isCached(faceModels[i]))
				flag1 = true;

		if (flag1)
			return null;
		Model aclass30_sub2_sub4_sub6s[] = new Model[faceModels.length];
		for (int j = 0; j < faceModels.length; j++)
			aclass30_sub2_sub4_sub6s[j] = Model.getModel(faceModels[j]);

		Model model;
		if (aclass30_sub2_sub4_sub6s.length == 1)
			model = aclass30_sub2_sub4_sub6s[0];
		else
			model = new Model(aclass30_sub2_sub4_sub6s.length, aclass30_sub2_sub4_sub6s);

		if (modelColourToEdit != null) {
			for (int k = 0; k < modelColourToEdit.length; k++) {
				model.setColour(modelColourToEdit[k], newModelColourProduced[k]);
			}

		}
		return model;
	}

	public EntityDefinition getOverride() {
		int j = -1;
		if (varbit != -1) {
			VarBit varBit = VarBit.cache[varbit];
			int k = varBit.setting;
			int l = varBit.startbit;
			int i1 = varBit.endbit;
			int j1 = Client.BIT_MASK[i1 - l];
			j = clientInstance.variousSettings[k] >> l & j1;
		}
		else {
			if (setting != -1) {
				j = clientInstance.variousSettings[setting];
			}
		}
		if (j < 0 || j >= childrenIDs.length || childrenIDs[j] == -1) {
			return null;
		}
		else {
			return forId(childrenIDs[j]);
		}
	}

	public static int total;

	public static void unpackConfig(StreamLoader streamLoader) {
		Stream stream = null;
		if (Config.PRE_EOC) {
			EntityDefinition.stream = new Stream(FileOperations.ReadFile(ClientConstants.getMainCacheLocation() + "718_cache/npc.dat"));
			stream = new Stream(FileOperations.ReadFile(ClientConstants.getMainCacheLocation() + "718_cache/npc.idx"));
		}
		else {
			EntityDefinition.stream = new Stream(streamLoader.getDataForName("npc.dat"));
			stream = new Stream(streamLoader.getDataForName("npc.idx"));
		}
		total = stream.readUnsignedWord();
		streamIndices = new int[total + 5000];
		if (ClientDebugConfiguration.DEBUG_MODE) {
			Utility.print(String.format("Loaded %d npcs", total));
		}
		int i = 2;
		for (int j = 0; j < total; j++) {
			streamIndices[j] = i;
			i += stream.readUnsignedWord();
		}

		cache = new EntityDefinition[20];
		for (int k = 0; k < 20; k++) {
			cache[k] = new EntityDefinition();
		}

	}

	public static void nullLoader() {
		mruNodes = null;
		streamIndices = null;
		cache = null;
		stream = null;
	}

	public Model method164(int j, int frame, int ai[], int nextFrame, int idk, int idk2) {
		if (childrenIDs != null) {
			EntityDefinition entityDef = getOverride();
			if (entityDef == null)
				return null;
			else
				return entityDef.method164(j, frame, ai, nextFrame, idk, idk2);
		}
		Model model = (Model) mruNodes.insertFromCache(type);
		if (model == null) {
			boolean flag = false;
			for (int i1 = 0; i1 < models.length; i1++)
				if (!Model.isCached(models[i1]))
					flag = true;

			if (flag)
				return null;
			Model aclass30_sub2_sub4_sub6s[] = new Model[models.length];
			for (int j1 = 0; j1 < models.length; j1++)
				aclass30_sub2_sub4_sub6s[j1] = Model.getModel(models[j1]);

			if (aclass30_sub2_sub4_sub6s.length == 1)
				model = aclass30_sub2_sub4_sub6s[0];
			else
				model = new Model(aclass30_sub2_sub4_sub6s.length, aclass30_sub2_sub4_sub6s);
			if (modelColourToEdit != null) {
				for (int k1 = 0; k1 < modelColourToEdit.length; k1++)
					model.setColour(modelColourToEdit[k1], newModelColourProduced[k1]);

			}
			model.method469();
			model.scaleModel(132, 132, 132);
			model.method479(84 + brightness, 1000 + contrast, -90, -580, -90, true);
			mruNodes.removeFromCache(model, type);
		}
		Model model_1 = Model.aModel_1621;
		model_1.method464(model, Frames.isNegativeZero(frame) & Frames.isNegativeZero(j) & Frames.isNegativeZero(nextFrame));
		if (frame != -1 && j != -1)
			model_1.method471(ai, j, frame);
		else if (frame != -1 && nextFrame != -1)
			model_1.method470(frame, nextFrame, idk, idk2);
		else if (frame != -1)
			model_1.method470(frame);
		if (scaleX != 128 || scaleZ != 128)
			model_1.scaleModel(scaleX, scaleX, scaleZ);
		model_1.method466();
		model_1.anIntArrayArray1658 = null;
		model_1.anIntArrayArray1657 = null;
		if (size == 1)
			model_1.aBoolean1659 = true;
		return model_1;
	}


	private void readValuesPreEoc(int npcType, Stream stream) {
		do {
			int i = stream.readUnsignedByte();
			if (i == 0)
				return;
			if (i == 1) {
				int j = stream.readUnsignedByte();
				models = new int[j];
				for (int j1 = 0; j1 < j; j1++) {
					models[j1] = stream.readDWord();
				}

			}
			else if (i == 2) {
				name = stream.readString();
			}
			else if (i == 3) {
				description = stream.readString();
			}
			else if (i == 12)
				size = stream.readSignedByte();
			else if (i == 13)
				standAnim = stream.readUnsignedWord();
			else if (i == 14)
				walkAnim = stream.readUnsignedWord();
			else if (i == 17) {
				walkAnim = stream.readUnsignedWord();
				turn180Sequence = stream.readUnsignedWord();
				turnRightSequence = stream.readUnsignedWord();
				turnLeftSequence = stream.readUnsignedWord();
				turn180Sequence = walkAnim;
				turnRightSequence = walkAnim;
				turnLeftSequence = walkAnim;
			}
			else if (i >= 30 && i < 35) {
				if (actions == null)
					actions = new String[5];
				actions[i - 30] = stream.readString();
				if (actions[i - 30].equalsIgnoreCase("hidden"))
					actions[i - 30] = null;
			}
			else if (i == 40) {
				int k = stream.readUnsignedByte();
				modelColourToEdit = new int[k];
				newModelColourProduced = new int[k];
				for (int k1 = 0; k1 < k; k1++) {
					modelColourToEdit[k1] = stream.readUnsignedWord();
					newModelColourProduced[k1] = stream.readUnsignedWord();
				}


			}
			else if (i == 60) {
				int l = stream.readUnsignedByte();
				faceModels = new int[l];
				for (int l1 = 0; l1 < l; l1++)
					faceModels[l1] = stream.readDWord();

			}
			else if (i == 93)
				showOnMinimap = false;
			else if (i == 95)
				combatLevel = stream.readUnsignedWord();
			else if (i == 97)
				scaleX = stream.readUnsignedWord();
			else if (i == 98)
				scaleZ = stream.readUnsignedWord();
			else if (i == 99)
				hasRenderPriority = true;
			else if (i == 100)
				brightness = stream.readSignedByte();
			else if (i == 101)
				contrast = stream.readSignedByte() * 5;
			else if (i == 102)
				headicons = stream.readUnsignedWord();
			else if (i == 103)
				turnSpeed = stream.readUnsignedWord();
			else if (i == 106 || i == 118) {
				varbit = stream.readUnsignedWord();
				if (varbit == 65535)
					varbit = -1;
				setting = stream.readUnsignedWord();
				if (setting == 65535)
					setting = -1;
				int child = -1;
				if (i == 118) {
					child = stream.readUnsignedWord();
					if (child == 65535) {
						child = -1;
					}
				}
				int amount = stream.readUnsignedByte();
				childrenIDs = new int[amount + 2];
				for (int i2 = 0; i2 <= amount; i2++) {
					childrenIDs[i2] = stream.readUnsignedWord();
					if (childrenIDs[i2] == 65535)
						childrenIDs[i2] = -1;
				}
				childrenIDs[amount + 1] = child;

			}
			else if (i == 107)
				interactable = false;
			else {
				Utility.print("[Npcs]Missing decode: " + i);
			}
		}
		while (true);
	}
	private void readValuesOsrs(int npcType, Stream stream) {
		if (npcType > 8479) {
				return;
		}
		do {
			int i = stream.readUnsignedByte();
			if (i == 0)
				return;
			if (i == 1) {
				int j = stream.readUnsignedByte();
				models = new int[j];
				for (int j1 = 0; j1 < j; j1++)
					models[j1] = stream.readUnsignedWord();

			}
			else if (i == 2)
				name = stream.readString();
			else if (i == 3) {
				description = stream.readString();
			}
			else if (i == 12)
				size = stream.readSignedByte();
			else if (i == 13)
				standAnim = stream.readUnsignedWord();
			else if (i == 14)
				walkAnim = stream.readUnsignedWord();
			else if (i == 17) {
				walkAnim = stream.readUnsignedWord();
				turn180Sequence = stream.readUnsignedWord();
				turnRightSequence = stream.readUnsignedWord();
				turnLeftSequence = stream.readUnsignedWord();
				turn180Sequence = walkAnim;
				turnRightSequence = walkAnim;
				turnLeftSequence = walkAnim;
			}
			else if (i >= 30 && i < 40) {
				if (actions == null)
					actions = new String[5];
				actions[i - 30] = stream.readString();
				if (actions[i - 30].equalsIgnoreCase("hidden"))
					actions[i - 30] = null;
			}
			else if (i == 40) {
				int k = stream.readUnsignedByte();
				modelColourToEdit = new int[k];
				newModelColourProduced = new int[k];
				for (int k1 = 0; k1 < k; k1++) {
					modelColourToEdit[k1] = stream.readUnsignedWord();
					newModelColourProduced[k1] = stream.readUnsignedWord();
				}


			}
			else if (i == 60) {
				int l = stream.readUnsignedByte();
				faceModels = new int[l];
				for (int l1 = 0; l1 < l; l1++)
					faceModels[l1] = stream.readUnsignedWord();

			}
			else if (i == 90)
				stream.readUnsignedWord();
			else if (i == 91)
				stream.readUnsignedWord();
			else if (i == 92)
				stream.readUnsignedWord();
			else if (i == 93)
				showOnMinimap = false;
			else if (i == 95)
				combatLevel = stream.readUnsignedWord();
			else if (i == 97)
				scaleX = stream.readUnsignedWord();
			else if (i == 98)
				scaleZ = stream.readUnsignedWord();
			else if (i == 99)
				hasRenderPriority = true;
			else if (i == 100)
				brightness = stream.readSignedByte();
			else if (i == 101)
				contrast = stream.readSignedByte() * 5;
			else if (i == 102)
				headicons = stream.readUnsignedWord();
			else if (i == 103)
				turnSpeed = stream.readUnsignedWord();
			else if (i == 106) {
				varbit = stream.readUnsignedWord();
				if (varbit == 65535)
					varbit = -1;
				setting = stream.readUnsignedWord();
				if (setting == 65535)
					setting = -1;
				int i1 = stream.readUnsignedByte();
				childrenIDs = new int[i1 + 1];
				for (int i2 = 0; i2 <= i1; i2++) {
					childrenIDs[i2] = stream.readUnsignedWord();
					if (childrenIDs[i2] == 65535)
						childrenIDs[i2] = -1;
				}

			}
			else if (i == 107)
				interactable = false;
		}
		while (true);
	}


	private EntityDefinition() {
		turnLeftSequence = -1;
		varbit = -1;
		turn180Sequence = -1;
		setting = -1;
		combatLevel = -1;
		walkAnim = -1;
		size = 1;
		headicons = -1;
		standAnim = -1;
		type = -1L;
		turnSpeed = 32;
		turnRightSequence = -1;
		interactable = true;
		scaleZ = 128;
		showOnMinimap = true;
		scaleX = 128;
		hasRenderPriority = false;
	}

	public int turnLeftSequence;

	private static int cachePosition;

	public int varbit;

	public int turn180Sequence;

	public int setting;

	private static Stream stream;

	public int combatLevel;

	public String name;

	public String actions[];

	public int walkAnim;

	public byte size;

	public int[] newModelColourProduced;

	private static int[] streamIndices;

	private int[] faceModels;

	public int headicons;

	public int[] modelColourToEdit;

	public int standAnim;

	public long type;

	public int turnSpeed;

	private static EntityDefinition[] cache;

	public static Client clientInstance;

	public int turnRightSequence;

	public boolean interactable;

	public int brightness;

	public int scaleZ;

	public boolean showOnMinimap;

	public int childrenIDs[];

	public String description;

	public int scaleX;

	public int contrast;

	public boolean hasRenderPriority; // Cannot find refactor.

	public int[] models;

	public static ReferenceCache mruNodes = new ReferenceCache(30);

}