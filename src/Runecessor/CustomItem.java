package Runecessor;

/**
 * Custom items.
 * 
 * @author Lava, created on 21-03-2015.
 */
public class CustomItem {

	// 35161 is highest model id used by 167 data.
	// 22361 is the highest item id used by 167 data.
	public static void applyCustomItems(ItemDefinition itemDefinition, int itemId) {
		boolean debug = false;
		if (itemId == 21015 && debug) {
			Model model = Model.getModel(itemDefinition.maleModel);
			if (model != null) {
				model.printAllColours(0);
			}
			Utility.print("Name: " + itemDefinition.name);
			Utility.print("Female model: " + itemDefinition.femaleModel);
			Utility.print("Male model: " + itemDefinition.maleModel);
			Utility.print("Inventory model: " + itemDefinition.inventoryModel);
			Utility.print("X: " + itemDefinition.inventoryX);
			Utility.print("Y: " + itemDefinition.inventoryY);
		}
		/*
		Model model = Model.getModel(itemDefinition.maleModel);
		if (model != null) {
			model.printAllColours(0);
		}
		*/

		applyCustomItemsSecondMethodFirstExceeds64KBOsrs(itemDefinition, itemId);
		applyCustomItemsOsrs(itemDefinition, itemId);

	}

	private static void applyCustomItemsOsrs(ItemDefinition itemDefinition, int itemId) {
		if (Config.PRE_EOC) {
			return;
		}
		ItemDefinition itemInstance = null;
		EntityDefinition npcInstance = null;
		ObjectDefinition objectInstance = null;
		int colour = -1;
		int green = -1;
		int red = -1;
		int yellow = -1;
		int blue = -1;
		switch (itemId) {
			
		/* case 10548:
			itemDefinition.name = "Meh Hat";
			itemDefinition.inventoryModel = 55486;
			itemDefinition.zoom = 789;
			itemDefinition.rotationY = 96;
			itemDefinition.rotationX = 2039;
			itemDefinition.inventoryX = 2;
			itemDefinition.inventoryY = -7;
			itemDefinition.maleModel = 55487;
			itemDefinition.femaleModel = 55487;
			itemDefinition.manHead0 = 35976;
			itemDefinition.manHead1 = 63;
			itemDefinition.womanHead0 = 35976;
			itemDefinition.womanHead1 = 120;
			itemDefinition.groundOptions = new String[]
			{null, null, "Take", null, null};
			itemDefinition.inventoryOptions = new String[]
			{null, "Wear", null, null, "Destroy"};
			break;
			*/
		
			case 16437 :
				itemDefinition.unNotedId = itemDefinition.itemId - 1;
				itemDefinition.notedItemTemplate = 799;
				break;
			case 13190:
				itemDefinition.name = "$10 Bond";
				break;
			case 1464:
				itemDefinition.name = "Boss Ticket";
				break;
			case 16488:
				itemDefinition.name = "Spin Ticket";
				itemDefinition.inventoryModel = 1464;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = "Open";
				itemDefinition.inventoryOptions[1] = null;
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				break;
			case 13161:
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = "Open";
				itemDefinition.inventoryOptions[1] = null;
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				break;
			case 16436:
				itemDefinition.name = "Mega Mystery box";
				itemDefinition.inventoryModel = 2426;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 1180;
				itemDefinition.rotationX = 172;
				itemDefinition.rotationY = 160;
				itemDefinition.inventoryY = -14;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = "Open";
				itemDefinition.inventoryOptions[1] = null;
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[2];
				itemDefinition.modelColourToEdit[0] = 2999;
				itemDefinition.modelColourToEdit[1] = 22410;
				itemDefinition.newModelColourProduced = new int[2];
				itemDefinition.newModelColourProduced[0] = 935;
				itemDefinition.newModelColourProduced[1] = 2;
				break;
			case 16500:
				itemDefinition.name = "Blood Money Box";
				itemDefinition.inventoryModel = 2426;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 1180;
				itemDefinition.rotationX = 172;
				itemDefinition.rotationY = 160;
				itemDefinition.inventoryY = -14;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = "Open";
				itemDefinition.inventoryOptions[1] = null;
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[2];
				itemDefinition.modelColourToEdit[0] = 2999;
				itemDefinition.modelColourToEdit[1] = 22410;
				itemDefinition.newModelColourProduced = new int[2];
				itemDefinition.newModelColourProduced[0] = 92770;
				itemDefinition.newModelColourProduced[1] = 926;
				break;
				
			case 16501:
				itemDefinition.name = "Event Key";
				itemInstance = ItemDefinition.forId(20767); //ruby key
				itemDefinition.inventoryModel = itemInstance.inventoryModel;
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Destroy"};
				itemDefinition.zoom = itemInstance.zoom;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.modelColourToEdit = new int[]
				{8128};
				itemDefinition.newModelColourProduced = new int[]
				{347770};
				break;
			
			case 16502:
				itemDefinition.name = "Easter Key";
				itemInstance = ItemDefinition.forId(20767); //ruby key
				itemDefinition.inventoryModel = itemInstance.inventoryModel;
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Destroy"};
				itemDefinition.zoom = itemInstance.zoom;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.modelColourToEdit = new int[]
				{8128};
				itemDefinition.newModelColourProduced = new int[]
				{296770};
				break;
			case 16429 :
				itemDefinition.name = "Vespula";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 8000;
				itemDefinition.rotationY = 100;
				itemDefinition.rotationX = 200;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = -30;
				npcInstance = EntityDefinition.forId(7531);
				itemDefinition.inventoryModel = npcInstance.models[0];

				itemDefinition.modelColourToEdit = new int[25];
				itemDefinition.newModelColourProduced = new int[25];

				// Originally red.
				colour = ItemColours.PURPLE + 2;
				itemDefinition.modelColourToEdit[3] = 920;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 920 : colour;

				colour = ItemColours.PURPLE + 4;
				itemDefinition.modelColourToEdit[23] = 922;
				itemDefinition.newModelColourProduced[23] = colour == -1 ? 922 : colour;

				colour = ItemColours.PURPLE + 6;
				itemDefinition.modelColourToEdit[14] = 924;
				itemDefinition.newModelColourProduced[14] = colour == -1 ? 924 : colour;

				colour = ItemColours.PURPLE + 8;
				itemDefinition.modelColourToEdit[1] = 926;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 926 : colour;

				colour = ItemColours.PURPLE + 10;
				itemDefinition.modelColourToEdit[7] = 929;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 929 : colour;

				colour = ItemColours.PURPLE + 12;
				itemDefinition.modelColourToEdit[19] = 931;
				itemDefinition.newModelColourProduced[19] = colour == -1 ? 931 : colour;

				colour = ItemColours.PURPLE + 14;
				itemDefinition.modelColourToEdit[20] = 933;
				itemDefinition.newModelColourProduced[20] = colour == -1 ? 933 : colour;

				// Originally black

				colour = -1;
				itemDefinition.modelColourToEdit[4] = 0;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 0 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[22] = 8;
				itemDefinition.newModelColourProduced[22] = colour == -1 ? 8 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[24] = 16;
				itemDefinition.newModelColourProduced[24] = colour == -1 ? 16 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[13] = 24;
				itemDefinition.newModelColourProduced[13] = colour == -1 ? 24 : colour;

				// Originally green/yellow

				colour = ItemColours.GOLD + 1;
				itemDefinition.modelColourToEdit[0] = 14292;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 14292 : colour;

				colour = ItemColours.GOLD + 2;
				itemDefinition.modelColourToEdit[2] = 798;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 798 : colour;

				colour = ItemColours.GOLD + 4;
				itemDefinition.modelColourToEdit[5] = 794;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 794 : colour;

				colour = ItemColours.GOLD + 6;
				itemDefinition.modelColourToEdit[6] = 15273;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 15273 : colour;

				colour = ItemColours.GOLD + 8;
				itemDefinition.modelColourToEdit[8] = 14284;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? 14284 : colour;

				colour = ItemColours.GOLD + 10;
				itemDefinition.modelColourToEdit[9] = 16270;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? 16270 : colour;

				colour = ItemColours.GOLD + 13;
				itemDefinition.modelColourToEdit[10] = 11216;
				itemDefinition.newModelColourProduced[10] = colour == -1 ? 11216 : colour;

				colour = ItemColours.GOLD + 15;
				itemDefinition.modelColourToEdit[11] = 11187;
				itemDefinition.newModelColourProduced[11] = colour == -1 ? 11187 : colour;

				colour = ItemColours.GOLD + 18;
				itemDefinition.modelColourToEdit[12] = 22424;
				itemDefinition.newModelColourProduced[12] = colour == -1 ? 22424 : colour;

				colour = ItemColours.GOLD + 20;
				itemDefinition.modelColourToEdit[15] = 15250;
				itemDefinition.newModelColourProduced[15] = colour == -1 ? 15250 : colour;

				colour = ItemColours.GOLD + 24;
				itemDefinition.modelColourToEdit[16] = 14259;
				itemDefinition.newModelColourProduced[16] = colour == -1 ? 14259 : colour;

				colour = ItemColours.GOLD + 26;
				itemDefinition.modelColourToEdit[17] = 14230;
				itemDefinition.newModelColourProduced[17] = colour == -1 ? 14230 : colour;

				colour = ItemColours.GOLD + 28;
				itemDefinition.modelColourToEdit[18] = 7068;
				itemDefinition.newModelColourProduced[18] = colour == -1 ? 7068 : colour;

				colour = ItemColours.GOLD + 30;
				itemDefinition.modelColourToEdit[21] = 18314;
				itemDefinition.newModelColourProduced[21] = colour == -1 ? 18314 : colour;
				break;
			case 16414:
				itemDefinition.name = "Noon (red)";
				itemDefinition.inventoryModel = 34184;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 8978;
				itemDefinition.rotationX = 66;
				itemDefinition.rotationY = 1995;
				itemDefinition.inventoryX = 36;
				itemDefinition.inventoryY = 16;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = null;
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = "Drop";
				itemDefinition.modelColourToEdit = new int[14];
				itemDefinition.newModelColourProduced = new int[14];
				colour = 127;
				itemDefinition.modelColourToEdit[0] = -19498;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -19498 : colour;

				colour = 934;
				itemDefinition.modelColourToEdit[1] = -19500;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -19500 : colour;

				colour = 124;
				itemDefinition.modelColourToEdit[2] = 22464;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 22464 : colour;

				colour = 120;
				itemDefinition.modelColourToEdit[3] = -21568;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -21568 : colour;

				colour = 115;
				itemDefinition.modelColourToEdit[4] = 960;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 960 : colour;

				colour = 110;
				itemDefinition.modelColourToEdit[5] = 21526;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 21526 : colour;

				itemDefinition.modelColourToEdit[6] = 21530;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 21530 : colour;

				itemDefinition.modelColourToEdit[7] = 21522;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 21522 : colour;

				itemDefinition.modelColourToEdit[8] = 21534;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? 21534 : colour;

				colour = 926;
				itemDefinition.modelColourToEdit[9] = -20037;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? -20037 : colour;

				colour = 920;
				itemDefinition.modelColourToEdit[10] = -21046;
				itemDefinition.newModelColourProduced[10] = colour == -1 ? -21046 : colour;

				colour = 105;
				itemDefinition.modelColourToEdit[11] = 0;
				itemDefinition.newModelColourProduced[11] = colour == -1 ? 0 : colour;

				colour = 120;
				itemDefinition.modelColourToEdit[12] = -19520;
				itemDefinition.newModelColourProduced[12] = colour == -1 ? -19520 : colour;

				colour = 127;
				itemDefinition.modelColourToEdit[13] = -17454;
				itemDefinition.newModelColourProduced[13] = colour == -1 ? -17454 : colour;
				break;
			case 16402:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Sigil colour
				colour = 947;
				itemDefinition.modelColourToEdit[1] = 127;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 127 : colour;

				// Shield colour
				colour = 127;
				itemDefinition.modelColourToEdit[0] = -28716;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -28716 : colour;

				// Trim colour
				colour = 947;
				itemDefinition.modelColourToEdit[2] = -29116;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -29116 : colour;

				itemDefinition.modelColourToEdit[3] = -29019;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -29019 : colour;

				itemDefinition.modelColourToEdit[4] = -29125;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -29125 : colour;

				itemDefinition.modelColourToEdit[5] = -29110;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -29110 : colour;
				break;
			case 16401:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", "Dismantle", null, null};
				itemDefinition.name = "Armadyl godsword";
				itemDefinition.inventoryModel = 28075;
				itemDefinition.zoom = 1957;
				itemDefinition.rotationY = 498;
				itemDefinition.rotationX = 484;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = -1;
				itemDefinition.maleModel = 27649;
				itemDefinition.femaleModel = 27649;

				itemDefinition.modelColourToEdit = new int[10];
				itemDefinition.newModelColourProduced = new int[10];

				// Hilt section where the hands are wrapped around
				colour = 0;
				itemDefinition.modelColourToEdit[0] = -22208;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -22208 : colour;

				// Hilt top section
				itemDefinition.modelColourToEdit[1] = -22477;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22477 : colour;

				// Hilt section various sides
				itemDefinition.modelColourToEdit[2] = -22464;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22464 : colour;

				// Hilt section, the bottom part, half of the furs
				itemDefinition.modelColourToEdit[3] = -24279;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -24279 : colour;

				// Hilt section, the bottom part, rest of the furs
				itemDefinition.modelColourToEdit[4] = -24271;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -24271 : colour;

				// Blade, left side
				colour = 461770;
				itemDefinition.modelColourToEdit[5] = -22444;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22444 : colour;

				colour = 461770;
				// Blade, right side
				itemDefinition.modelColourToEdit[6] = -22423;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -22423 : colour;

				colour = 461770;
				// Blade decoration on the right
				itemDefinition.modelColourToEdit[7] = -22415;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -22415 : colour;

				// Blade tip on the right
				itemDefinition.modelColourToEdit[8] = -22419;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -22419 : colour;

				// Blade at the tip, inventory model only.
				itemDefinition.modelColourToEdit[9] = -22440;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? -22440 : colour;
				break;
			case 16400:
				itemDefinition.name = "Ghrazi rapier";
				itemDefinition.inventoryModel = 35739;
				itemDefinition.maleModel = 35374;
				itemDefinition.femaleModel = 35369;
				itemDefinition.zoom = 2064;
				itemDefinition.rotationX = 1603;
				itemDefinition.rotationZ = 552;
				itemDefinition.inventoryX = 5;
				itemDefinition.inventoryY = -18;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = "Drop";

				itemDefinition.modelColourToEdit = new int[8];
				itemDefinition.newModelColourProduced = new int[8];

				// Grey
				colour = 17350;
				itemDefinition.modelColourToEdit[2] = -22446;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22446 : colour;

				// White
				colour = 17350;
				itemDefinition.modelColourToEdit[4] = -22423;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -22423 : colour;

				// Dark grey
				colour = 380760;
				itemDefinition.modelColourToEdit[1] = -22386;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22386 : colour;

				// Red
				colour = 380770;
				itemDefinition.modelColourToEdit[0] = -1122;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -1122 : colour;

				// Dark grey
				itemDefinition.modelColourToEdit[3] = -22502;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -22502 : colour;

				// Grey
				itemDefinition.modelColourToEdit[6] = -22477;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -22477 : colour;

				// Light grey
				itemDefinition.modelColourToEdit[7] = -22506;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -22506 : colour;

				// Dark grey
				colour = 380780;
				itemDefinition.modelColourToEdit[5] = -22489;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22489 : colour;
				break;
			case 16399:
				itemDefinition.name = "Nocturnal Yoshi pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 750;
				itemDefinition.rotationY = 100;
				itemDefinition.rotationX = 250;
				itemDefinition.inventoryX = 10;
				itemDefinition.inventoryY = 100;
				npcInstance = EntityDefinition.forId(11212);
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16398 :
				itemDefinition.name = "Death pet";
				itemDefinition.inventoryOptions = new String[]{
						null,
						null,
						null,
						null,
						"Drop"
				};
				itemDefinition.zoom = 650;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 80;
				npcInstance = EntityDefinition.forId(5567);
				itemDefinition.inventoryModel = npcInstance.models[0];
				itemDefinition.modelColourToEdit = new int[13];
				itemDefinition.newModelColourProduced = new int[13];

				// Black
				colour = 127;
				itemDefinition.modelColourToEdit[0] = 0;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 0 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[1] = 5231;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 5231 : colour;

				// White
				colour = 58325;
				itemDefinition.modelColourToEdit[2] = 5353;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 5353 : colour;

				colour = 58350;
				itemDefinition.modelColourToEdit[3] = 8741;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 8741 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[4] = 4550;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 4550 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[5] = 8741;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 8741 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[6] = 10004;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 10004 : colour;

				colour = 127;
				itemDefinition.modelColourToEdit[7] = 25238;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 25238 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[8] = 0;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? 0 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[9] = 908;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? 908 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[10] = 5541;
				itemDefinition.newModelColourProduced[10] = colour == -1 ? 5541 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[11] = 7073;
				itemDefinition.newModelColourProduced[11] = colour == -1 ? 7073 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[12] = 61;
				itemDefinition.newModelColourProduced[12] = colour == -1 ? 61 : colour;
				break;
		
			case 16397 :
				itemDefinition.inventoryOptions = new String[]{
						null,
						"Wield",
						null,
						null,
						null
				};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Sigil colour
				colour = 302800;
				itemDefinition.modelColourToEdit[1] = 127;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 127 : colour;

				// Shield colour
				colour = 127;
				itemDefinition.modelColourToEdit[0] = -28716;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -28716 : colour;

				// Trim colour
				colour = 127;
				itemDefinition.modelColourToEdit[2] = -29116;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -29116 : colour;

				itemDefinition.modelColourToEdit[3] = -29019;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -29019 : colour;

				itemDefinition.modelColourToEdit[4] = -29125;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -29125 : colour;

				itemDefinition.modelColourToEdit[5] = -29110;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -29110 : colour;
				break;
			case 16379 :
				itemDefinition.inventoryOptions = new String[]{
						null,
						"Wield",
						null,
						null,
						null
				};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Sigil colour
				colour = 927;
				itemDefinition.modelColourToEdit[1] = 127;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 127 : colour;

				// Shield colour
				colour = 302770;
				itemDefinition.modelColourToEdit[0] = -28716;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -28716 : colour;

				// Trim colour
				colour = 127;
				itemDefinition.modelColourToEdit[2] = -29116;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -29116 : colour;

				itemDefinition.modelColourToEdit[3] = -29019;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -29019 : colour;

				itemDefinition.modelColourToEdit[4] = -29125;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -29125 : colour;

				itemDefinition.modelColourToEdit[5] = -29110;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -29110 : colour;
				break;
			case 16380:
				itemDefinition.inventoryOptions = new String[]
						{null, "Wield", "Dismantle", null, null};
				itemDefinition.name = "Armadyl godsword";
				itemDefinition.inventoryModel = 28075;
				itemDefinition.zoom = 1957;
				itemDefinition.rotationY = 498;
				itemDefinition.rotationX = 484;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = -1;
				itemDefinition.maleModel = 27649;
				itemDefinition.femaleModel = 27649;

				itemDefinition.modelColourToEdit = new int[10];
				itemDefinition.newModelColourProduced = new int[10];

				// Hilt section where the hands are wrapped around
				colour = 927;
				itemDefinition.modelColourToEdit[0] = -22208;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -22208 : colour;

				// Hilt top section
				itemDefinition.modelColourToEdit[1] = -22477;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22477 : colour;

				// Hilt section various sides
				itemDefinition.modelColourToEdit[2] = -22464;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22464 : colour;

				// Hilt section, the bottom part, half of the furs
				itemDefinition.modelColourToEdit[3] = -24279;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -24279 : colour;

				// Hilt section, the bottom part, rest of the furs
				itemDefinition.modelColourToEdit[4] = -24271;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -24271 : colour;

				// Blade, left side
				colour = 127;
				itemDefinition.modelColourToEdit[5] = -22444;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22444 : colour;

				colour = 302800;
				// Blade, right side
				itemDefinition.modelColourToEdit[6] = -22423;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -22423 : colour;

				colour = 127;
				// Blade decoration on the right
				itemDefinition.modelColourToEdit[7] = -22415;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -22415 : colour;

				// Blade tip on the right
				itemDefinition.modelColourToEdit[8] = -22419;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -22419 : colour;

				// Blade at the tip, inventory model only.
				itemDefinition.modelColourToEdit[9] = -22440;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? -22440 : colour;
				break;
			case 16381:
				itemDefinition.name = "Primordial boots";
				itemDefinition.inventoryModel = 29397;
				itemDefinition.maleModel = 29250;
				itemDefinition.femaleModel = 29255;
				itemDefinition.zoom = 976;
				itemDefinition.rotationX = 279;
				itemDefinition.rotationY = 147;
				itemDefinition.inventoryX = 5;
				itemDefinition.inventoryY = -5;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[8];
				itemDefinition.newModelColourProduced = new int[8];

				// Dark red
				colour = 302770;
				itemDefinition.modelColourToEdit[0] = 280;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 280 : colour;

				// Red
				colour = 302790;
				itemDefinition.modelColourToEdit[1] = 924;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 924 : colour;

				// Red
				colour = 302790;
				itemDefinition.modelColourToEdit[2] = 920;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 920 : colour;

				// Very dark grey
				colour = -1;
				itemDefinition.modelColourToEdit[6] = 520;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 520 : colour;

				// Dark grey
				colour = -1;
				itemDefinition.modelColourToEdit[5] = -22380;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22380 : colour;


				// Grey
				colour = -1;
				itemDefinition.modelColourToEdit[3] = -22370;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -22370 : colour;

				// Red
				colour = 302790;
				itemDefinition.modelColourToEdit[4] = 538;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 538 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[7] = 127;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 127 : colour;
				break;

			case 16382 :
				itemDefinition.name = "Amulet of torture";
				itemDefinition.inventoryModel = 31524;
				itemDefinition.maleModel = 31227;
				itemDefinition.maleEquip2 = -1;
				itemDefinition.femaleModel = 31233;
				itemDefinition.femaleEquip2 = -1;
				itemDefinition.zoom = 620;
				itemDefinition.rotationX = 68;
				itemDefinition.rotationY = 424;
				itemDefinition.inventoryX = 1;
				itemDefinition.inventoryY = 16;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[7];
				itemDefinition.newModelColourProduced = new int[7];
				
				// Grey
				colour = 302790;
				itemDefinition.modelColourToEdit[0] = -22372;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -22372 : colour;

				// Light grey
				colour = 927;
				itemDefinition.modelColourToEdit[1] = -22483;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22483 : colour;

				// Light grey
				colour = 927;
				itemDefinition.modelColourToEdit[2] = -22475;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22475 : colour;

				// Shade over the orange
				colour = 927;
				itemDefinition.modelColourToEdit[3] = 5056;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 5056 : colour;

				// Light grey
				colour = 927;
				itemDefinition.modelColourToEdit[4] = -22506;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -22506 : colour;

				// Black
				colour = -1;
				itemDefinition.modelColourToEdit[5] = 0;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 0 : colour;

				// Orange
				colour = -1;
				itemDefinition.modelColourToEdit[6] = 3008;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 3008 : colour;
				break;

			case 16383 :
				itemDefinition.name = "Ghrazi rapier";
				itemDefinition.inventoryModel = 35739;
				itemDefinition.maleModel = 35374;
				itemDefinition.femaleModel = 35369;
				itemDefinition.zoom = 2064;
				itemDefinition.rotationX = 1603;
				itemDefinition.rotationZ = 552;
				itemDefinition.inventoryX = 5;
				itemDefinition.inventoryY = -18;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = "Drop";

				itemDefinition.modelColourToEdit = new int[8];
				itemDefinition.newModelColourProduced = new int[8];

				// Grey
				colour = 302790;
				itemDefinition.modelColourToEdit[2] = -22446;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22446 : colour;

				// White
				colour = 302790;
				itemDefinition.modelColourToEdit[4] = -22423;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -22423 : colour;

				// Dark grey
				colour = 910;
				itemDefinition.modelColourToEdit[1] = -22386;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22386 : colour;

				// Red
				colour = 927;
				itemDefinition.modelColourToEdit[0] = -1122;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -1122 : colour;

				// Dark grey
				itemDefinition.modelColourToEdit[3] = -22502;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -22502 : colour;

				// Grey
				itemDefinition.modelColourToEdit[6] = -22477;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -22477 : colour;

				// Light grey
				itemDefinition.modelColourToEdit[7] = -22506;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -22506 : colour;

				// Dark grey
				colour = 935;
				itemDefinition.modelColourToEdit[5] = -22489;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22489 : colour;
				break;

			case 16384 :
				itemDefinition.name = "Ghrazi rapier";
				itemDefinition.inventoryModel = 35739;
				itemDefinition.maleModel = 35374;
				itemDefinition.femaleModel = 35369;
				itemDefinition.zoom = 2064;
				itemDefinition.rotationX = 1603;
				itemDefinition.rotationZ = 552;
				itemDefinition.inventoryX = 5;
				itemDefinition.inventoryY = -18;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = "Drop";

				itemDefinition.modelColourToEdit = new int[8];
				itemDefinition.newModelColourProduced = new int[8];

				// Grey
				colour = 127;
				itemDefinition.modelColourToEdit[2] = -22446;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22446 : colour;

				// White
				colour = 127;
				itemDefinition.modelColourToEdit[4] = -22423;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -22423 : colour;

				// Red
				colour = 0;
				itemDefinition.modelColourToEdit[0] = -1122;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -1122 : colour;

				// Dark grey
				colour = 51136;
				itemDefinition.modelColourToEdit[3] = -22502;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -22502 : colour;

				// Grey
				colour = 51136;
				itemDefinition.modelColourToEdit[6] = -22477;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -22477 : colour;

				// Light grey
				colour = 51130;
				itemDefinition.modelColourToEdit[7] = -22506;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -22506 : colour;

				// Dark grey
				colour = 51150;
				itemDefinition.modelColourToEdit[5] = -22489;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22489 : colour;

				// Dark grey
				colour = 51136;
				itemDefinition.modelColourToEdit[1] = -22386;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22386 : colour;
				break;

			case 16385 :
				itemDefinition.name = "Ghrazi rapier";
				itemDefinition.inventoryModel = 35739;
				itemDefinition.maleModel = 35374;
				itemDefinition.femaleModel = 35369;
				itemDefinition.zoom = 2064;
				itemDefinition.rotationX = 1603;
				itemDefinition.rotationZ = 552;
				itemDefinition.inventoryX = 5;
				itemDefinition.inventoryY = -18;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = "Drop";

				itemDefinition.modelColourToEdit = new int[8];
				itemDefinition.newModelColourProduced = new int[8];

				// Grey
				colour = 34770;
				itemDefinition.modelColourToEdit[2] = -22446;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22446 : colour;

				// White
				colour = 34770;
				itemDefinition.modelColourToEdit[4] = -22423;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -22423 : colour;

				// Red
				colour = 100;
				itemDefinition.modelColourToEdit[0] = -1122;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -1122 : colour;

				// Dark grey
				colour = 127;
				itemDefinition.modelColourToEdit[3] = -22502;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -22502 : colour;

				// Grey
				colour = 127;
				itemDefinition.modelColourToEdit[6] = -22477;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -22477 : colour;

				// Light grey
				colour = 120;
				itemDefinition.modelColourToEdit[7] = -22506;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -22506 : colour;

				// Dark grey
				colour = 115;
				itemDefinition.modelColourToEdit[5] = -22489;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22489 : colour;

				// Dark grey
				colour = 115;
				itemDefinition.modelColourToEdit[1] = -22386;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22386 : colour;
				break;
			case 13116:
                itemInstance = ItemDefinition.forId(13116);
                itemDefinition.inventoryOptions = new String[]
                        {"Check", null, null, null, null};
                itemDefinition.name = itemInstance.name;
                itemDefinition.zoom = itemInstance.zoom;
                itemDefinition.maleEquip2 = itemInstance.maleEquip2;
                itemDefinition.femaleEquip2 = itemInstance.femaleEquip2;
                itemDefinition.rotationY = itemInstance.rotationY;
                itemDefinition.rotationX = itemInstance.rotationX;
                itemDefinition.inventoryY = itemInstance.inventoryY;
                itemDefinition.maleModel = itemInstance.maleModel;
                itemDefinition.femaleModel = itemInstance.femaleModel;
                itemDefinition.inventoryOptions = new String[5];
                itemDefinition.inventoryOptions[0] = "Check";
                itemDefinition.inventoryOptions[1] = null;
                itemDefinition.inventoryOptions[2] = null;
                itemDefinition.inventoryOptions[3] = null;
                itemDefinition.inventoryOptions[4] = null;
                itemDefinition.inventoryModel = itemInstance.inventoryModel;
                break;
			case 22114:
                itemInstance = ItemDefinition.forId(22114);
                itemDefinition.name = itemInstance.name;
                itemDefinition.zoom = itemInstance.zoom;
                itemDefinition.maleEquip2 = itemInstance.maleEquip2;
                itemDefinition.femaleEquip2 = itemInstance.femaleEquip2;
                itemDefinition.rotationY = itemInstance.rotationY;
                itemDefinition.rotationX = itemInstance.rotationX;
                itemDefinition.inventoryY = itemInstance.inventoryY;
                itemDefinition.maleModel = itemInstance.maleModel;
                itemDefinition.femaleModel = itemInstance.femaleModel;
                itemDefinition.inventoryOptions = new String[5];
                itemDefinition.inventoryOptions[0] = null;
                itemDefinition.inventoryOptions[1] = "Wear";
                itemDefinition.inventoryOptions[2] = "Check-Charges";
                itemDefinition.inventoryOptions[3] = null;
                itemDefinition.inventoryOptions[4] = null;
                itemDefinition.inventoryModel = itemInstance.inventoryModel;
                break;
			case 16386 :
				itemDefinition.name = "Ghrazi rapier";
				itemDefinition.inventoryModel = 35739;
				itemDefinition.maleModel = 35374;
				itemDefinition.femaleModel = 35369;
				itemDefinition.zoom = 2064;
				itemDefinition.rotationX = 1603;
				itemDefinition.rotationZ = 552;
				itemDefinition.inventoryX = 5;
				itemDefinition.inventoryY = -18;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = "Drop";

				itemDefinition.modelColourToEdit = new int[8];
				itemDefinition.newModelColourProduced = new int[8];

				// Grey
				colour = 58325;
				itemDefinition.modelColourToEdit[2] = -22446;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22446 : colour;

				// White
				colour = 58325;
				itemDefinition.modelColourToEdit[4] = -22423;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -22423 : colour;

				// Red
				colour = 34770;
				itemDefinition.modelColourToEdit[0] = -1122;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -1122 : colour;

				// Dark grey
				colour = 34780;
				itemDefinition.modelColourToEdit[3] = -22502;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -22502 : colour;

				// Grey
				colour = 34790;
				itemDefinition.modelColourToEdit[6] = -22477;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -22477 : colour;

				// Light grey
				colour = 34790;
				itemDefinition.modelColourToEdit[7] = -22506;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -22506 : colour;

				// Dark grey
				colour = 34790;
				itemDefinition.modelColourToEdit[5] = -22489;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22489 : colour;

				// Dark grey
				colour = 34780;
				itemDefinition.modelColourToEdit[1] = -22386;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22386 : colour;
				break;

			case 16387 :
				itemDefinition.name = "Ghrazi rapier";
				itemDefinition.inventoryModel = 35739;
				itemDefinition.maleModel = 35374;
				itemDefinition.femaleModel = 35369;
				itemDefinition.zoom = 2064;
				itemDefinition.rotationX = 1603;
				itemDefinition.rotationZ = 552;
				itemDefinition.inventoryX = 5;
				itemDefinition.inventoryY = -18;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = "Drop";

				itemDefinition.modelColourToEdit = new int[8];
				itemDefinition.newModelColourProduced = new int[8];

				// Grey
				colour = 0;
				itemDefinition.modelColourToEdit[2] = -22446;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22446 : colour;

				// White
				colour = 0;
				itemDefinition.modelColourToEdit[4] = -22423;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -22423 : colour;

				// Red
				colour = 3;
				itemDefinition.modelColourToEdit[0] = -1122;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -1122 : colour;

				// Dark grey
				colour = 461785;
				itemDefinition.modelColourToEdit[3] = -22502;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -22502 : colour;

				// Grey
				colour = 461785;
				itemDefinition.modelColourToEdit[6] = -22477;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -22477 : colour;

				// Light grey
				colour = 461765;
				itemDefinition.modelColourToEdit[7] = -22506;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -22506 : colour;

				// Dark grey
				colour = 461775;
				itemDefinition.modelColourToEdit[5] = -22489;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22489 : colour;

				// Dark grey
				colour = 461795;
				itemDefinition.modelColourToEdit[1] = -22386;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22386 : colour;
				break;

			case 16388 :
				itemDefinition.name = "Dragon rapier";
				itemDefinition.inventoryModel = 35739;
				itemDefinition.maleModel = 35374;
				itemDefinition.femaleModel = 35369;
				itemDefinition.zoom = 2064;
				itemDefinition.rotationX = 1603;
				itemDefinition.rotationZ = 552;
				itemDefinition.inventoryX = 5;
				itemDefinition.inventoryY = -18;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = "Drop";

				itemDefinition.modelColourToEdit = new int[8];
				itemDefinition.newModelColourProduced = new int[8];

				// Grey
				colour = 927;
				itemDefinition.modelColourToEdit[2] = -22446;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22446 : colour;

				// White
				itemDefinition.modelColourToEdit[4] = -22423;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -22423 : colour;

				// Red
				colour = -1;
				itemDefinition.modelColourToEdit[0] = -1122;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -1122 : colour;

				// Dark grey
				itemDefinition.modelColourToEdit[3] = -22502;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -22502 : colour;

				// Grey
				itemDefinition.modelColourToEdit[6] = -22477;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -22477 : colour;

				// Light grey
				itemDefinition.modelColourToEdit[7] = -22506;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -22506 : colour;

				// Dark grey
				itemDefinition.modelColourToEdit[5] = -22489;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22489 : colour;

				// Dark grey
				itemDefinition.modelColourToEdit[1] = -22386;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22386 : colour;
				break;
		
			case 16390 :
				itemDefinition.name = "Heavy ballista";
				itemDefinition.inventoryModel = 31523;
				itemDefinition.maleModel = 31236;
				itemDefinition.femaleModel = 31236;
				itemDefinition.femaleEquipOffset = 6;
				itemDefinition.zoom = 1284;
				itemDefinition.rotationX = 148;
				itemDefinition.rotationY = 189;
				itemDefinition.inventoryX = 8;
				itemDefinition.inventoryY = -18;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = "Drop";
				itemDefinition.modelColourToEdit = new int[22];
				itemDefinition.newModelColourProduced = new int[22];

				colour = 90;
				itemDefinition.modelColourToEdit[7] = 16;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 16 : colour;

				colour = 97;
				itemDefinition.modelColourToEdit[4] = 20;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 20 : colour;

				colour = 107;
				itemDefinition.modelColourToEdit[2] = 24;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 24 : colour;

				colour = 115;
				itemDefinition.modelColourToEdit[3] = 28;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 28 : colour;

				colour = 122;
				itemDefinition.modelColourToEdit[1] = 33;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 33 : colour;

				colour = 125;
				itemDefinition.modelColourToEdit[0] = 37;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 37 : colour;

				colour = 127;
				itemDefinition.modelColourToEdit[12] = 41;
				itemDefinition.newModelColourProduced[12] = colour == -1 ? 41 : colour;

				colour = 0;
				itemDefinition.modelColourToEdit[5] = 10283;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 10283 : colour;

				colour = 5;
				itemDefinition.modelColourToEdit[6] = 10275;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 10275 : colour;

				colour = 10;
				itemDefinition.modelColourToEdit[8] = 5289;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? 5289 : colour;

				colour = 15;
				itemDefinition.modelColourToEdit[9] = 5409;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? 5409 : colour;

				colour = 20;
				itemDefinition.modelColourToEdit[10] = 10266;
				itemDefinition.newModelColourProduced[10] = colour == -1 ? 10266 : colour;

				colour = 6;
				itemDefinition.modelColourToEdit[11] = 5524;
				itemDefinition.newModelColourProduced[11] = colour == -1 ? 5524 : colour;

				colour = 10;
				itemDefinition.modelColourToEdit[13] = 5772;
				itemDefinition.newModelColourProduced[13] = colour == -1 ? 5772 : colour;

				colour = 15;
				itemDefinition.modelColourToEdit[14] = 5400;
				itemDefinition.newModelColourProduced[14] = colour == -1 ? 5400 : colour;

				colour = 0;
				itemDefinition.modelColourToEdit[15] = 5404;
				itemDefinition.newModelColourProduced[15] = colour == -1 ? 5404 : colour;

				colour = 3;
				itemDefinition.modelColourToEdit[16] = 5285;
				itemDefinition.newModelColourProduced[16] = colour == -1 ? 5285 : colour;

				colour = 4;
				itemDefinition.modelColourToEdit[17] = 1556;
				itemDefinition.newModelColourProduced[17] = colour == -1 ? 1556 : colour;

				colour = 0;
				itemDefinition.modelColourToEdit[18] = 1560;
				itemDefinition.newModelColourProduced[18] = colour == -1 ? 1560 : colour;

				colour = 12;
				itemDefinition.modelColourToEdit[19] = 3594;
				itemDefinition.newModelColourProduced[19] = colour == -1 ? 3594 : colour;

				colour = 14;
				itemDefinition.modelColourToEdit[20] = 1808;
				itemDefinition.newModelColourProduced[20] = colour == -1 ? 1808 : colour;

				colour = 22;
				itemDefinition.modelColourToEdit[21] = 1932;
				itemDefinition.newModelColourProduced[21] = colour == -1 ? 1932 : colour;

				break;

			case 16391 :
				itemDefinition.name = "Amulet of torture";
				itemDefinition.inventoryModel = 31524;
				itemDefinition.maleModel = 31227;
				itemDefinition.femaleModel = 31233;
				itemDefinition.zoom = 620;
				itemDefinition.rotationX = 68;
				itemDefinition.rotationY = 424;
				itemDefinition.inventoryX = 1;
				itemDefinition.inventoryY = 16;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = "Drop";
				itemDefinition.modelColourToEdit = new int[7];
				itemDefinition.newModelColourProduced = new int[7];

				// Grey
				colour = 0;
				itemDefinition.modelColourToEdit[0] = -22372;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -22372 : colour;

				// Light grey
				colour = -1;
				itemDefinition.modelColourToEdit[1] = -22483;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22483 : colour;

				// Light grey
				colour = -1;
				itemDefinition.modelColourToEdit[2] = -22475;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22475 : colour;

				// Shade over the orange
				colour = 30;
				itemDefinition.modelColourToEdit[3] = 5056;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 5056 : colour;

				// Light grey
				colour = -1;
				itemDefinition.modelColourToEdit[4] = -22506;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -22506 : colour;

				// Black
				colour = -1;
				itemDefinition.modelColourToEdit[5] = 0;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 0 : colour;

				// Orange
				colour = -1;
				itemDefinition.modelColourToEdit[6] = 3008;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 3008 : colour;
				break;

			case 16392:
				itemDefinition.name = "Defender icon";
				itemDefinition.inventoryModel = 20578;
				itemDefinition.maleModel = 19261;
				itemDefinition.femaleModel = 20519;
				itemDefinition.zoom = 1049;
				itemDefinition.rotationX = 1010;
				itemDefinition.rotationY = 526;
				itemDefinition.inventoryX = 35;
				itemDefinition.inventoryY = -30;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[5];
				itemDefinition.modelColourToEdit[0] = 22439;
				itemDefinition.newModelColourProduced = new int[5];
				itemDefinition.newModelColourProduced[0] = 34770;

				colour = 34775;
				itemDefinition.modelColourToEdit[1] = 947;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 947 : colour;

				colour = 34780;
				itemDefinition.modelColourToEdit[2] = 11200;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 11200 : colour;

				colour = 34785;
				itemDefinition.modelColourToEdit[3] = -21581;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -21581 : colour;

				colour = 34790;
				itemDefinition.modelColourToEdit[4] = 22451;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 22451 : colour;
				break;

			case 16393 :
				itemDefinition.name = "Justiciar faceguard";
				itemDefinition.inventoryModel = 35751;
				itemDefinition.maleModel = 35349;
				itemDefinition.femaleModel = 35361;
				itemDefinition.zoom = 777;
				itemDefinition.rotationX = 1972;
				itemDefinition.rotationY = 22;
				itemDefinition.inventoryX = 1;
				itemDefinition.inventoryY = -1;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = "Drop";
				itemDefinition.modelColourToEdit = new int[9];
				itemDefinition.newModelColourProduced = new int[9];

				// Black
				colour = 0;
				itemDefinition.modelColourToEdit[4] = 0;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 0 : colour;

				// Very Dark grey
				colour = 3;
				itemDefinition.modelColourToEdit[0] = -22242;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -22242 : colour;

				// Dark grey
				colour = 5;
				itemDefinition.modelColourToEdit[5] = -6083;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -6083 : colour;

				// Grey
				colour = 8;
				itemDefinition.modelColourToEdit[1] = -6095;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -6095 : colour;

				// Grey
				colour = 10;
				itemDefinition.modelColourToEdit[2] = 6709;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 6709 : colour;

				// Grey
				colour = 10;
				itemDefinition.modelColourToEdit[7] = -6070;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -6070 : colour;

				// Light yellow
				colour = 6083;
				itemDefinition.modelColourToEdit[3] = 6736;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 6736 : colour;

				// Yellow
				colour = 6073;
				itemDefinition.modelColourToEdit[6] = 6602;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 6602 : colour;

				// Nothing
				colour = -1;
				itemDefinition.modelColourToEdit[8] = 4550;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? 4550 : colour;
				break;

			case 16394 :
				itemDefinition.name = "Justiciar chestguard";
				itemDefinition.inventoryModel = 35750;
				itemDefinition.maleModel = 35359;
				itemDefinition.femaleModel = 35368;
				itemDefinition.zoom = 1310;
				itemDefinition.rotationY = 432;
				itemDefinition.inventoryX = 1;
				itemDefinition.inventoryY = 4;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = "Drop";
				itemDefinition.modelColourToEdit = new int[15];
				itemDefinition.newModelColourProduced = new int[15];
				
				
				// Very very Dark grey
				colour = 0;
				itemDefinition.modelColourToEdit[0] = 12;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 12 : colour;

				// Very dark grey
				colour = 2;
				itemDefinition.modelColourToEdit[13] = 268;
				itemDefinition.newModelColourProduced[13] = colour == -1 ? 268 : colour;

				// Very dark grey
				colour = 4;
				itemDefinition.modelColourToEdit[14] = 278;
				itemDefinition.newModelColourProduced[14] = colour == -1 ? 278 : colour;

				// Dark grey
				colour = 6;
				itemDefinition.modelColourToEdit[12] = 3346;
				itemDefinition.newModelColourProduced[12] = colour == -1 ? 3346 : colour;

				// Grey
				colour = 8;
				itemDefinition.modelColourToEdit[1] = -6070;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -6070 : colour;

				// Grey
				colour = 10;
				itemDefinition.modelColourToEdit[2] = -6083;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -6083 : colour;

				// Grey
				colour = 12;
				itemDefinition.modelColourToEdit[4] = -6095;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -6095 : colour;

				// Light grey
				colour = 14;
				itemDefinition.modelColourToEdit[8] = 6699;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? 6699 : colour;

				// Light grey
				colour = 14;
				itemDefinition.modelColourToEdit[11] = -6062;
				itemDefinition.newModelColourProduced[11] = colour == -1 ? -6062 : colour;

				// Yellow
				colour = 6083;
				itemDefinition.modelColourToEdit[3] = 6602;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 6602 : colour;

				// Darker yellow
				colour = 6078;
				itemDefinition.modelColourToEdit[7] = 6709;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 6709 : colour;

				// Darker yellow
				colour = 6073;
				itemDefinition.modelColourToEdit[9] = 6736;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? 6736 : colour;

				// Blue
				colour = 16;
				itemDefinition.modelColourToEdit[5] = -22242;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22242 : colour;

				// Blue
				colour = 16;
				itemDefinition.modelColourToEdit[6] = -22122;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -22122 : colour;

				// Blue
				colour = 18;
				itemDefinition.modelColourToEdit[10] = -22237;
				itemDefinition.newModelColourProduced[10] = colour == -1 ? -22237 : colour;
				break;

			case 16395 :
				itemDefinition.name = "Justiciar legguards";
				itemDefinition.inventoryModel = 35752;
				itemDefinition.maleModel = 35356;
				itemDefinition.femaleModel = 35367;
				itemDefinition.zoom = 1720;
				itemDefinition.rotationY = 468;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = "Drop";
				itemDefinition.modelColourToEdit = new int[16];
				itemDefinition.newModelColourProduced = new int[16];
				
				// Very dark grey
				colour = 0;
				itemDefinition.modelColourToEdit[0] = 12;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 12 : colour;

				// Dark grey
				colour = 2;
				itemDefinition.modelColourToEdit[1] = 268;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 268 : colour;

				// Dark grey
				colour = 4;
				itemDefinition.modelColourToEdit[10] = 16;
				itemDefinition.newModelColourProduced[10] = colour == -1 ? 16 : colour;

				// Grey
				colour = 6;
				itemDefinition.modelColourToEdit[9] = 22;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? 22 : colour;

				// Grey
				colour = 8;
				itemDefinition.modelColourToEdit[12] = -11229;
				itemDefinition.newModelColourProduced[12] = colour == -1 ? -11229 : colour;

				// Light grey
				colour = 9;
				itemDefinition.modelColourToEdit[2] = -6070;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -6070 : colour;

				// Light grey
				colour = 10;
				itemDefinition.modelColourToEdit[14] = -6083;
				itemDefinition.newModelColourProduced[14] = colour == -1 ? -6083 : colour;

				// Light grey
				colour = 11;
				itemDefinition.modelColourToEdit[13] = -6091;
				itemDefinition.newModelColourProduced[13] = colour == -1 ? -6091 : colour;

				// Light grey
				colour = 12;
				itemDefinition.modelColourToEdit[3] = -6095;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -6095 : colour;

				// Blue
				colour = 13;
				itemDefinition.modelColourToEdit[4] = -22242;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -22242 : colour;

				// Blue
				colour = 15;
				itemDefinition.modelColourToEdit[5] = -22237;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22237 : colour;

				// Blue
				colour = 17;
				itemDefinition.modelColourToEdit[6] = -22233;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -22233 : colour;

				// Yellow
				colour = 6082;
				itemDefinition.modelColourToEdit[7] = 6602;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 6602 : colour;

				// Dark yellow
				colour = 6077;
				itemDefinition.modelColourToEdit[11] = 6699;
				itemDefinition.newModelColourProduced[11] = colour == -1 ? 6699 : colour;

				// Dark Yellow
				colour = 6074;
				itemDefinition.modelColourToEdit[15] = 6709;
				itemDefinition.newModelColourProduced[15] = colour == -1 ? 6709 : colour;

				// Dark yellow
				colour = 6070;
				itemDefinition.modelColourToEdit[8] = 6736;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? 6736 : colour;
				break;
			case 16396:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", "Dismantle", null, null};
				itemDefinition.name = "Armadyl godsword";
				itemDefinition.inventoryModel = 28075;
				itemDefinition.zoom = 1957;
				itemDefinition.rotationY = 498;
				itemDefinition.rotationX = 484;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = -1;
				itemDefinition.maleModel = 27649;
				itemDefinition.femaleModel = 27649;

				itemDefinition.modelColourToEdit = new int[10];
				itemDefinition.newModelColourProduced = new int[10];

				// Hilt section where the hands are wrapped around
				colour = 926;
				itemDefinition.modelColourToEdit[0] = -22208;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -22208 : colour;

				// Hilt top section
				itemDefinition.modelColourToEdit[1] = -22477;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22477 : colour;

				// Hilt section various sides
				itemDefinition.modelColourToEdit[2] = -22464;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22464 : colour;

				colour = 930;
				// Hilt section, the bottom part, half of the furs
				itemDefinition.modelColourToEdit[3] = -24279;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -24279 : colour;

				// Hilt section, the bottom part, rest of the furs
				itemDefinition.modelColourToEdit[4] = -24271;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -24271 : colour;

				// Blade, left side
				colour = 920;
				itemDefinition.modelColourToEdit[5] = -22444;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22444 : colour;

				colour = 923;
				// Blade, right side
				itemDefinition.modelColourToEdit[6] = -22423;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -22423 : colour;

				// Blade decoration on the right
				itemDefinition.modelColourToEdit[7] = -22415;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -22415 : colour;

				// Blade tip on the right
				itemDefinition.modelColourToEdit[8] = -22419;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -22419 : colour;

				colour = 922;
				// Blade at the tip, inventory model only.
				itemDefinition.modelColourToEdit[9] = -22440;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? -22440 : colour;
				break;
			case 13764:
				itemInstance = ItemDefinition.forId(3121); //ruby key
				itemDefinition.name = "Rune claws";
				itemDefinition.femaleModel = itemInstance.femaleModel;
				itemDefinition.femaleEquipOffset = itemInstance.femaleEquipOffset;
				itemDefinition.inventoryOptions = new String[]
				{null, "Wear", null, null, null};
				itemDefinition.inventoryModel = itemInstance.inventoryModel;
				itemDefinition.maleModel = itemInstance.maleModel;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.zoom = itemInstance.zoom;
				break;
			case 16378:
				itemDefinition.name = "Dragon claws";
				itemDefinition.femaleModel = 29191;
				itemDefinition.femaleEquipOffset = 6;
				itemDefinition.inventoryOptions = new String[]
				{null, "Wear", null, null, null};
				itemDefinition.inventoryModel = 32784;
				itemDefinition.maleModel = 29191;
				itemDefinition.rotationY = 349;
				itemDefinition.inventoryX = 0;
				itemDefinition.rotationX = 15;
				itemDefinition.inventoryY = 8;
				itemDefinition.zoom = 886;

				itemDefinition.modelColourToEdit = new int[4];
				itemDefinition.newModelColourProduced = new int[4];

				colour = 127;
				itemDefinition.modelColourToEdit[0] = 929;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 929 : colour;

				itemDefinition.modelColourToEdit[2] = 918;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 918 : colour;

				colour = 51130;
				itemDefinition.modelColourToEdit[1] = 922;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 922 : colour;

				itemDefinition.modelColourToEdit[3] = 914;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 914 : colour;
				break;
			case 16377:
				itemDefinition.name = "Bandos chestplate";
				itemDefinition.inventoryModel = 28042;
				itemDefinition.maleModel = 27636;
				itemDefinition.maleEquip2 = 28826;
				itemDefinition.femaleModel = 27644;
				itemDefinition.femaleEquip2 = 28827;
				itemDefinition.zoom = 984;
				itemDefinition.rotationX = 6;
				itemDefinition.rotationY = 501;
				itemDefinition.inventoryX = 1;
				itemDefinition.inventoryY = 4;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[24];
				itemDefinition.newModelColourProduced = new int[24];

				// Very Light brown
				colour = 120;
				itemDefinition.modelColourToEdit[0] = 8367;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 8367 : colour;

				itemDefinition.modelColourToEdit[1] = 8384;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 8384 : colour;

				itemDefinition.modelColourToEdit[2] = 8375;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 8375 : colour;

				itemDefinition.modelColourToEdit[4] = 9523;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 9523 : colour;

				itemDefinition.modelColourToEdit[6] = 9515;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 9515 : colour;

				// Light brown
				colour = 51130;
				itemDefinition.modelColourToEdit[9] = 163;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? 163 : colour;

				itemDefinition.modelColourToEdit[18] = 10291;
				itemDefinition.newModelColourProduced[18] = colour == -1 ? 10291 : colour;

				itemDefinition.modelColourToEdit[19] = 10283;
				itemDefinition.newModelColourProduced[19] = colour == -1 ? 10283 : colour;

				itemDefinition.modelColourToEdit[20] = 10287;
				itemDefinition.newModelColourProduced[20] = colour == -1 ? 10287 : colour;

				// Brown
				colour = 51110;
				itemDefinition.modelColourToEdit[3] = 10266;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 10266 : colour;

				// Brown
				itemDefinition.modelColourToEdit[10] = 22;
				itemDefinition.newModelColourProduced[10] = colour == -1 ? 22 : colour;

				// Brown
				itemDefinition.modelColourToEdit[13] = 10275;
				itemDefinition.newModelColourProduced[13] = colour == -1 ? 10275 : colour;

				// Brown
				itemDefinition.modelColourToEdit[14] = 8379;
				itemDefinition.newModelColourProduced[14] = colour == -1 ? 8379 : colour;

				// Dark brown
				colour = 51100;
				itemDefinition.modelColourToEdit[8] = 142;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? 142 : colour;

				// Dark brown
				itemDefinition.modelColourToEdit[12] = 8076;
				itemDefinition.newModelColourProduced[12] = colour == -1 ? 8076 : colour;

				// Unknown
				colour = -1;
				itemDefinition.modelColourToEdit[5] = 10502;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 10502 : colour;

				// Unknown
				colour = -1;
				itemDefinition.modelColourToEdit[7] = 4550;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 4550 : colour;

				// Unknown
				colour = -1;
				itemDefinition.modelColourToEdit[11] = 9403;
				itemDefinition.newModelColourProduced[11] = colour == -1 ? 9403 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[15] = 10266;
				itemDefinition.newModelColourProduced[15] = colour == -1 ? 10266 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[16] = 10275;
				itemDefinition.newModelColourProduced[16] = colour == -1 ? 10275 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[17] = 4550;
				itemDefinition.newModelColourProduced[17] = colour == -1 ? 4550 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[21] = 8367;
				itemDefinition.newModelColourProduced[21] = colour == -1 ? 8367 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[22] = 8384;
				itemDefinition.newModelColourProduced[22] = colour == -1 ? 8384 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[23] = 8375;
				itemDefinition.newModelColourProduced[23] = colour == -1 ? 8375 : colour;
				break;
			case 16376:
				itemDefinition.name = "Bandos tassets";
				itemDefinition.inventoryModel = 28047;
				itemDefinition.maleModel = 27625;
				itemDefinition.femaleModel = 27640;
				itemDefinition.zoom = 854;
				itemDefinition.rotationX = 2039;
				itemDefinition.rotationY = 540;
				itemDefinition.inventoryX = 3;
				itemDefinition.inventoryY = 3;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[7];
				itemDefinition.newModelColourProduced = new int[7];

				colour = -1;
				itemDefinition.modelColourToEdit[0] = 4550;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 4550 : colour;

				colour = 51105;
				itemDefinition.modelColourToEdit[1] = 22;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 22 : colour;

				colour = 51100;
				itemDefinition.modelColourToEdit[2] = 163;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 163 : colour;

				colour = 51100;
				itemDefinition.modelColourToEdit[3] = 154;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 154 : colour;

				colour = 51130;
				itemDefinition.modelColourToEdit[4] = 39;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 39 : colour;

				colour = 90;
				itemDefinition.modelColourToEdit[5] = 9523;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 9523 : colour;

				colour = 127;
				itemDefinition.modelColourToEdit[6] = 8390;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 8390 : colour;
				break;
			case 16375:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Sigil colour
				colour = 5056;
				itemDefinition.modelColourToEdit[1] = 127;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 127 : colour;

				// Shield colour
				colour = 0;
				itemDefinition.modelColourToEdit[0] = -28716;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -28716 : colour;

				// Trim colour
				colour = 5056;
				itemDefinition.modelColourToEdit[2] = -29116;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -29116 : colour;

				itemDefinition.modelColourToEdit[3] = -29019;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -29019 : colour;

				itemDefinition.modelColourToEdit[4] = -29125;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -29125 : colour;

				itemDefinition.modelColourToEdit[5] = -29110;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -29110 : colour;
				break;
			case 16374:
				itemDefinition.name = "Elder maul";
				itemDefinition.inventoryModel = 32792;
				itemDefinition.maleModel = 32678;
				itemDefinition.femaleModel = 32678;
				itemDefinition.zoom = 1744;
				itemDefinition.rotationX = 429;
				itemDefinition.rotationY = 237;
				itemDefinition.inventoryX = -3;
				itemDefinition.inventoryY = -58;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Orange dark
				colour = 0;
				itemDefinition.modelColourToEdit[0] = 5056;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 5056 : colour;

				// Orange dark
				colour = 0;
				itemDefinition.modelColourToEdit[1] = 8125;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 8125 : colour;

				// Dark grey
				colour = 5056;
				itemDefinition.modelColourToEdit[2] = 16;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 16 : colour;

				// Dark grey
				colour = 5056;
				itemDefinition.modelColourToEdit[5] = 20;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 20 : colour;

				// It was black
				colour = 5065;
				itemDefinition.modelColourToEdit[3] = 0;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 0 : colour;

				// Grey
				colour = 5045;
				itemDefinition.modelColourToEdit[4] = 33;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 33 : colour;
				break;
			case 16373:
				itemDefinition.name = "Ancestral hat";
				itemDefinition.inventoryModel = 32794;
				itemDefinition.maleModel = 32655;
				itemDefinition.maleEquip2 = -1;
				itemDefinition.femaleModel = 32663;
				itemDefinition.femaleEquip2 = -1;
				itemDefinition.zoom = 1236;
				itemDefinition.rotationX = 10;
				itemDefinition.rotationY = 118;
				itemDefinition.inventoryY = -12;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[13];
				itemDefinition.newModelColourProduced = new int[13];

				// Orange
				colour = 8128;
				itemDefinition.modelColourToEdit[0] = 6973;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 6973 : colour;

				// Dark grey
				colour = 51125;
				itemDefinition.modelColourToEdit[1] = -21992;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -21992 : colour;

				// Dark blue
				colour = 127;
				itemDefinition.modelColourToEdit[2] = -22235;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22235 : colour;

				// Brown
				colour = 51130;
				itemDefinition.modelColourToEdit[5] = 5268;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 5268 : colour;

				// Dark biege
				colour = 51105;
				itemDefinition.modelColourToEdit[3] = 6323;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 6323 : colour;

				// Biege
				colour = 127;
				itemDefinition.modelColourToEdit[4] = 6331;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 6331 : colour;

				// Biege
				colour = 127;
				itemDefinition.modelColourToEdit[6] = 6340;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 6340 : colour;

				// Biege
				colour = 127;
				itemDefinition.modelColourToEdit[7] = 6348;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 6348 : colour;

				// Biege
				colour = 127;
				itemDefinition.modelColourToEdit[8] = 6356;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? 6356 : colour;

				// Biege
				colour = 127;
				itemDefinition.modelColourToEdit[9] = 6364;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? 6364 : colour;

				// Biege
				colour = 51105;
				itemDefinition.modelColourToEdit[10] = 6798;
				itemDefinition.newModelColourProduced[10] = colour == -1 ? 6798 : colour;

				// Unknown
				colour = -1;
				itemDefinition.modelColourToEdit[11] = 4550;
				itemDefinition.newModelColourProduced[11] = colour == -1 ? 4550 : colour;

				// Unknown
				colour = -1;
				itemDefinition.modelColourToEdit[12] = 0;
				itemDefinition.newModelColourProduced[12] = colour == -1 ? 0 : colour;
				break;
			case 16372:
				itemDefinition.name = "Ancestral robe bottom";
				itemDefinition.inventoryModel = 32787;
				itemDefinition.maleModel = 32653;
				itemDefinition.maleEquip2 = -1;
				itemDefinition.femaleModel = 32662;
				itemDefinition.femaleEquip2 = -1;
				itemDefinition.zoom = 1690;
				itemDefinition.rotationX = 9;
				itemDefinition.rotationY = 435;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = 7;
				itemDefinition.brightness = 30;
				itemDefinition.contrast = 100;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[10];
				itemDefinition.newModelColourProduced = new int[10];

				// Dark grey
				colour = 55977;
				itemDefinition.modelColourToEdit[6] = -16327;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -16327 : colour;

				// Dark grey
				colour = 55977;
				itemDefinition.modelColourToEdit[8] = -16339;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -16327 : colour;

				// Grey
				colour = 55977;
				itemDefinition.modelColourToEdit[1] = -16318;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -16318 : colour;

				// Grey
				colour = 55977;
				itemDefinition.modelColourToEdit[9] = 6323;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? -16327 : colour;

				// Biege
				colour = 30656;
				itemDefinition.modelColourToEdit[2] = 6331;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 6331 : colour;

				// Light biege
				colour = 30656;
				itemDefinition.modelColourToEdit[0] = 6348;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 6348 : colour;

				// Orange
				colour = 30656;
				itemDefinition.modelColourToEdit[4] = 7108;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 7108 : colour;

				// Dark purple
				colour = 3;
				itemDefinition.modelColourToEdit[5] = -22235;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22235 : colour;

				// Dark purple
				colour = 5;
				itemDefinition.modelColourToEdit[7] = -22231;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -16327 : colour;

				// Purple
				colour = 7;
				itemDefinition.modelColourToEdit[3] = -22225;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -22225 : colour;
				break;
			case 16371:
				itemDefinition.name = "Ancestral robe top";
				itemDefinition.inventoryModel = 32790;
				itemDefinition.maleModel = 32657;
				itemDefinition.maleEquip2 = 32658;
				itemDefinition.femaleModel = 32664;
				itemDefinition.femaleEquip2 = 32665;
				itemDefinition.femaleModel = 32664;
				itemDefinition.zoom = 1358;
				itemDefinition.rotationX = 2041;
				itemDefinition.rotationY = 514;
				itemDefinition.inventoryY = -3;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[12];
				itemDefinition.newModelColourProduced = new int[12];

				// Light biege
				colour = 55977;
				itemDefinition.modelColourToEdit[0] = 6348;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 6348 : colour;

				// Grey
				colour = 55977;
				itemDefinition.modelColourToEdit[1] = -16318;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -16318 : colour;

				// Biege
				colour = 55977;
				itemDefinition.modelColourToEdit[2] = 6331;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 6331 : colour;

				// Biege stripe across chest from shoulders to waist
				colour = 55977;
				itemDefinition.modelColourToEdit[9] = 6323;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? -16327 : colour;

				// Dark grey
				colour = 55977;
				itemDefinition.modelColourToEdit[6] = -16327;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -16327 : colour;

				// Dark grey
				colour = 55977;
				itemDefinition.modelColourToEdit[8] = -16339;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -16327 : colour;

				// Very dark purple
				colour = 3;
				itemDefinition.modelColourToEdit[10] = 5268;
				itemDefinition.newModelColourProduced[10] = colour == -1 ? -16327 : colour;

				// Dark purple
				colour = 5;
				itemDefinition.modelColourToEdit[7] = -22231;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -16327 : colour;

				// Dark purple
				colour = 7;
				itemDefinition.modelColourToEdit[5] = -22235;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22235 : colour;

				// Purple
				colour = 10;
				itemDefinition.modelColourToEdit[3] = -22225;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -22225 : colour;

				// Orange
				colour = 30656;
				itemDefinition.modelColourToEdit[4] = 7108;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 7108 : colour;

				// Orange
				colour = 30656;
				itemDefinition.modelColourToEdit[11] = 6973;
				itemDefinition.newModelColourProduced[11] = colour == -1 ? 6973 : colour;

				break;
			case 16370:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Sigil colour
				colour = 34770;
				itemDefinition.modelColourToEdit[1] = 127;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 127 : colour;

				// Shield colour
				colour = 100;
				itemDefinition.modelColourToEdit[0] = -28716;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -28716 : colour;

				// Trim colour
				colour = 933;
				itemDefinition.modelColourToEdit[2] = -29116;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -29116 : colour;

				itemDefinition.modelColourToEdit[3] = -29019;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -29019 : colour;

				itemDefinition.modelColourToEdit[4] = -29125;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -29125 : colour;

				itemDefinition.modelColourToEdit[5] = -29110;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -29110 : colour;
				break;
			case 16369:
				itemDefinition.name = "Primordial boots";
				itemDefinition.inventoryModel = 29397;
				itemDefinition.maleModel = 29250;
				itemDefinition.femaleModel = 29255;
				itemDefinition.zoom = 976;
				itemDefinition.rotationX = 279;
				itemDefinition.rotationY = 147;
				itemDefinition.inventoryX = 5;
				itemDefinition.inventoryY = -5;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[8];
				itemDefinition.newModelColourProduced = new int[8];

				// Dark red
				colour = 4;
				itemDefinition.modelColourToEdit[0] = 280;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 280 : colour;

				// Red
				colour = 15;
				itemDefinition.modelColourToEdit[1] = 924;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 924 : colour;

				// Red
				colour = 10;
				itemDefinition.modelColourToEdit[2] = 920;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 920 : colour;

				// Very dark grey
				colour = 6073;
				itemDefinition.modelColourToEdit[6] = 520;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 520 : colour;

				// Dark grey
				colour = 6073;
				itemDefinition.modelColourToEdit[5] = -22380;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22380 : colour;


				// Grey
				colour = 6073;
				itemDefinition.modelColourToEdit[3] = -22370;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -22370 : colour;

				// Red
				colour = 10;
				itemDefinition.modelColourToEdit[4] = 538;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 538 : colour;

				colour = 6073;
				itemDefinition.modelColourToEdit[7] = 127;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 127 : colour;
				break;
			case 16368:
				itemDefinition.name = "Ancestral robe bottom";
				itemDefinition.inventoryModel = 32787;
				itemDefinition.maleModel = 32653;
				itemDefinition.maleEquip2 = -1;
				itemDefinition.femaleModel = 32662;
				itemDefinition.femaleEquip2 = -1;
				itemDefinition.zoom = 1690;
				itemDefinition.rotationX = 9;
				itemDefinition.rotationY = 435;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = 7;
				itemDefinition.brightness = 30;
				itemDefinition.contrast = 100;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[3];
				itemDefinition.newModelColourProduced = new int[3];

				// Dark purple --> dark green
				colour = 19860;
				itemDefinition.modelColourToEdit[0] = -22235;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -22235 : colour;

				// Dark purple --> dark green
				colour = 19860;
				itemDefinition.modelColourToEdit[1] = -22231;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -16327 : colour;

				// Purple --> green
				colour = 86933;
				itemDefinition.modelColourToEdit[2] = -22225;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22225 : colour;
				break;
			case 16367:
				itemDefinition.name = "Ancestral robe top";
				itemDefinition.inventoryModel = 32790;
				itemDefinition.maleModel = 32657;
				itemDefinition.maleEquip2 = 32658;
				itemDefinition.femaleModel = 32664;
				itemDefinition.femaleEquip2 = 32665;
				itemDefinition.femaleModel = 32664;
				itemDefinition.zoom = 1358;
				itemDefinition.rotationX = 2041;
				itemDefinition.rotationY = 514;
				itemDefinition.inventoryY = -3;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[3];
				itemDefinition.newModelColourProduced = new int[3];

				// Dark purple --> dark green
				colour = 19860;
				itemDefinition.modelColourToEdit[0] = -22231;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -16327 : colour;

				// Dark purple --> dark green
				colour = 19860;
				itemDefinition.modelColourToEdit[1] = -22235;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22235 : colour;

				// Purple --> green
				colour = 86933;
				itemDefinition.modelColourToEdit[2] = -22225;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22225 : colour;

				break;
			case 16366:
				itemInstance = ItemDefinition.forId(299);
				itemDefinition.name = "Anti death-dot device";
				itemDefinition.inventoryModel = itemInstance.inventoryModel;
				itemDefinition.zoom = itemInstance.zoom;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.inventoryOptions = new String[] {"Activate", null, null, null, null};
				break;
			case 16363:
				itemDefinition.inventoryOptions = new String[] {null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Sigil colour
				colour = 0;
				itemDefinition.modelColourToEdit[1] = 127;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 127 : colour;

				// Shield colour
				colour = 374770;
				itemDefinition.modelColourToEdit[0] = -28716;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -28716 : colour;

				// Trim colour
				colour = 127;
				itemDefinition.modelColourToEdit[2] = -29116;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -29116 : colour;

				itemDefinition.modelColourToEdit[3] = -29019;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -29019 : colour;

				itemDefinition.modelColourToEdit[4] = -29125;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -29125 : colour;

				itemDefinition.modelColourToEdit[5] = -29110;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -29110 : colour;
				break;

			case 16364:
				itemDefinition.name = "Ancestral robe top";
				itemDefinition.inventoryModel = 32790;
				itemDefinition.maleModel = 32657;
				itemDefinition.maleEquip2 = 32658;
				itemDefinition.femaleModel = 32664;
				itemDefinition.femaleEquip2 = 32665;
				itemDefinition.femaleModel = 32664;
				itemDefinition.zoom = 1358;
				itemDefinition.rotationX = 2041;
				itemDefinition.rotationY = 514;
				itemDefinition.inventoryY = -3;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[12];
				itemDefinition.newModelColourProduced = new int[12];
				
				// Light biege
				colour = 51143;
				itemDefinition.modelColourToEdit[0] = 6348;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 6348 : colour;

				// Grey
				colour = 51140;
				itemDefinition.modelColourToEdit[1] = -16318;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -16318 : colour;

				// Biege
				colour = 51135;
				itemDefinition.modelColourToEdit[2] = 6331;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 6331 : colour;

				// Biege stripe across chest from shoulders to waist
				colour = 51130;
				itemDefinition.modelColourToEdit[9] = 6323;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? -16327 : colour;

				// Dark grey
				colour = 51125;
				itemDefinition.modelColourToEdit[6] = -16327;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -16327 : colour;

				// Dark grey
				colour = 51120;
				itemDefinition.modelColourToEdit[8] = -16339;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -16327 : colour;

				// Very dark purple
				colour = 3;
				itemDefinition.modelColourToEdit[10] = 5268;
				itemDefinition.newModelColourProduced[10] = colour == -1 ? -16327 : colour;

				// Dark purple
				colour = 5;
				itemDefinition.modelColourToEdit[7] = -22231;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -16327 : colour;

				// Dark purple
				colour = 7;
				itemDefinition.modelColourToEdit[5] = -22235;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22235 : colour;

				// Purple
				colour = 10;
				itemDefinition.modelColourToEdit[3] = -22225;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -22225 : colour;

				// Orange
				colour = 127;
				itemDefinition.modelColourToEdit[4] = 7108;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 7108 : colour;

				// Orange
				colour = 127;
				itemDefinition.modelColourToEdit[11] = 6973;
				itemDefinition.newModelColourProduced[11] = colour == -1 ? 6973 : colour;

				break;
			case 16365:
				itemDefinition.name = "Ancestral robe bottom";
				itemDefinition.inventoryModel = 32787;
				itemDefinition.maleModel = 32653;
				itemDefinition.maleEquip2 = -1;
				itemDefinition.femaleModel = 32662;
				itemDefinition.femaleEquip2 = -1;
				itemDefinition.zoom = 1690;
				itemDefinition.rotationX = 9;
				itemDefinition.rotationY = 435;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = 7;
				itemDefinition.brightness = 30;
				itemDefinition.contrast = 100;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[10];
				itemDefinition.newModelColourProduced = new int[10];

				// Dark grey
				colour = 51120;
				itemDefinition.modelColourToEdit[6] = -16327;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -16327 : colour;

				// Dark grey
				colour = 51125;
				itemDefinition.modelColourToEdit[8] = -16339;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -16327 : colour;

				// Grey
				colour = 51130;
				itemDefinition.modelColourToEdit[1] = -16318;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -16318 : colour;

				// Grey
				colour = 51130;
				itemDefinition.modelColourToEdit[9] = 6323;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? -16327 : colour;

				// Biege
				colour = 51135;
				itemDefinition.modelColourToEdit[2] = 6331;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 6331 : colour;

				// Light biege
				colour = 51140;
				itemDefinition.modelColourToEdit[0] = 6348;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 6348 : colour;

				// Orange
				colour = 127;
				itemDefinition.modelColourToEdit[4] = 7108;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 7108 : colour;

				// Dark purple
				colour = 3;
				itemDefinition.modelColourToEdit[5] = -22235;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22235 : colour;

				// Dark purple
				colour = 5;
				itemDefinition.modelColourToEdit[7] = -22231;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -16327 : colour;

				// Purple
				colour = 7;
				itemDefinition.modelColourToEdit[3] = -22225;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -22225 : colour;
				break;
			case 16351:
				itemDefinition.name = "Bandos chestplate";
				itemDefinition.inventoryModel = 28042;
				itemDefinition.maleModel = 27636;
				itemDefinition.maleEquip2 = 28826;
				itemDefinition.femaleModel = 27644;
				itemDefinition.femaleEquip2 = 28827;
				itemDefinition.zoom = 984;
				itemDefinition.rotationX = 6;
				itemDefinition.rotationY = 501;
				itemDefinition.inventoryX = 1;
				itemDefinition.inventoryY = 4;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[24];
				itemDefinition.newModelColourProduced = new int[24];

				// Very Light brown
				colour = 120;
				itemDefinition.modelColourToEdit[0] = 8367;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 8367 : colour;

				itemDefinition.modelColourToEdit[1] = 8384;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 8384 : colour;

				itemDefinition.modelColourToEdit[2] = 8375;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 8375 : colour;

				itemDefinition.modelColourToEdit[4] = 9523;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 9523 : colour;

				itemDefinition.modelColourToEdit[6] = 9515;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 9515 : colour;

				// Light brown
				colour = 15;
				itemDefinition.modelColourToEdit[9] = 163;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? 163 : colour;

				itemDefinition.modelColourToEdit[18] = 10291;
				itemDefinition.newModelColourProduced[18] = colour == -1 ? 10291 : colour;

				itemDefinition.modelColourToEdit[19] = 10283;
				itemDefinition.newModelColourProduced[19] = colour == -1 ? 10283 : colour;

				itemDefinition.modelColourToEdit[20] = 10287;
				itemDefinition.newModelColourProduced[20] = colour == -1 ? 10287 : colour;

				// Brown
				colour = 10;
				itemDefinition.modelColourToEdit[3] = 10266;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 10266 : colour;

				// Brown
				itemDefinition.modelColourToEdit[10] = 22;
				itemDefinition.newModelColourProduced[10] = colour == -1 ? 22 : colour;

				// Brown
				itemDefinition.modelColourToEdit[13] = 10275;
				itemDefinition.newModelColourProduced[13] = colour == -1 ? 10275 : colour;

				// Brown
				itemDefinition.modelColourToEdit[14] = 8379;
				itemDefinition.newModelColourProduced[14] = colour == -1 ? 8379 : colour;

				// Dark brown
				colour = 4;
				itemDefinition.modelColourToEdit[8] = 142;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? 142 : colour;

				// Dark brown
				itemDefinition.modelColourToEdit[12] = 8076;
				itemDefinition.newModelColourProduced[12] = colour == -1 ? 8076 : colour;

				// Unknown
				colour = -1;
				itemDefinition.modelColourToEdit[5] = 10502;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 10502 : colour;

				// Unknown
				colour = -1;
				itemDefinition.modelColourToEdit[7] = 4550;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 4550 : colour;

				// Unknown
				colour = -1;
				itemDefinition.modelColourToEdit[11] = 9403;
				itemDefinition.newModelColourProduced[11] = colour == -1 ? 9403 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[15] = 10266;
				itemDefinition.newModelColourProduced[15] = colour == -1 ? 10266 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[16] = 10275;
				itemDefinition.newModelColourProduced[16] = colour == -1 ? 10275 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[17] = 4550;
				itemDefinition.newModelColourProduced[17] = colour == -1 ? 4550 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[21] = 8367;
				itemDefinition.newModelColourProduced[21] = colour == -1 ? 8367 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[22] = 8384;
				itemDefinition.newModelColourProduced[22] = colour == -1 ? 8384 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[23] = 8375;
				itemDefinition.newModelColourProduced[23] = colour == -1 ? 8375 : colour;
				break;
			case 16352:
				itemDefinition.name = "Bandos tassets";
				itemDefinition.inventoryModel = 28047;
				itemDefinition.maleModel = 27625;
				itemDefinition.femaleModel = 27640;
				itemDefinition.zoom = 854;
				itemDefinition.rotationX = 2039;
				itemDefinition.rotationY = 540;
				itemDefinition.inventoryX = 3;
				itemDefinition.inventoryY = 3;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[7];
				itemDefinition.newModelColourProduced = new int[7];
				green = 120;
				red = 15;
				yellow = 90;
				blue = 15;

				colour = -1;
				itemDefinition.modelColourToEdit[0] = 4550;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 4550 : colour;

				colour = red;
				itemDefinition.modelColourToEdit[1] = 22;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 22 : colour;

				colour = red;
				itemDefinition.modelColourToEdit[2] = 163;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 163 : colour;

				colour = red;
				itemDefinition.modelColourToEdit[3] = 154;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 154 : colour;

				colour = blue;
				itemDefinition.modelColourToEdit[4] = 39;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 39 : colour;

				colour = yellow;
				itemDefinition.modelColourToEdit[5] = 9523;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 9523 : colour;

				colour = green;
				itemDefinition.modelColourToEdit[6] = 8390;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 8390 : colour;
				break;
			case 16353:
				itemDefinition.name = "Primordial boots";
				itemDefinition.inventoryModel = 29397;
				itemDefinition.maleModel = 29250;
				itemDefinition.femaleModel = 29255;
				itemDefinition.zoom = 976;
				itemDefinition.rotationX = 279;
				itemDefinition.rotationY = 147;
				itemDefinition.inventoryX = 5;
				itemDefinition.inventoryY = -5;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[8];
				itemDefinition.newModelColourProduced = new int[8];

				// Dark red
				colour = 4;
				itemDefinition.modelColourToEdit[0] = 280;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 280 : colour;

				// Red
				colour = 15;
				itemDefinition.modelColourToEdit[1] = 924;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 924 : colour;

				// Red
				itemDefinition.modelColourToEdit[2] = 920;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 920 : colour;

				// Very dark grey
				colour = 90;
				itemDefinition.modelColourToEdit[6] = 520;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 520 : colour;

				// Dark grey
				colour = 120;
				itemDefinition.modelColourToEdit[5] = -22380;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22380 : colour;


				// Grey
				colour = 15;
				itemDefinition.modelColourToEdit[3] = -22370;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -22370 : colour;

				// Red
				colour = -1;
				itemDefinition.modelColourToEdit[4] = 538;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 538 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[7] = 127;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 127 : colour;
				break;
			case 16354:
				itemDefinition.name = "Abyssal tentacle";
				itemDefinition.inventoryModel = 28439;
				itemDefinition.maleModel = 28446;
				itemDefinition.femaleModel = 28446;
				itemDefinition.zoom = 840;
				itemDefinition.rotationX = 121;
				itemDefinition.rotationY = 280;
				itemDefinition.inventoryY = 56;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = "Check";
				itemDefinition.inventoryOptions[4] = "Dissolve";

				itemDefinition.modelColourToEdit = new int[3];
				itemDefinition.newModelColourProduced = new int[3];

				// Stripe colour
				colour = 926;
				itemDefinition.modelColourToEdit[0] = 11150;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -22208 : colour;

				// Not used
				itemDefinition.modelColourToEdit[1] = 9108;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22477 : colour;

				// Spikes colour
				colour = 0;
				itemDefinition.modelColourToEdit[2] = 10355;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22464 : colour;
				break;
			case 16355:
				itemDefinition.inventoryOptions = new String[] {null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Sigil colour
				colour = 0;
				itemDefinition.modelColourToEdit[1] = 127;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 127 : colour;

				// Shield colour
				colour = 7114;
				itemDefinition.modelColourToEdit[0] = -28716;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -28716 : colour;

				colour = 0;
				itemDefinition.modelColourToEdit[2] = -29116;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -29116 : colour;

				itemDefinition.modelColourToEdit[3] = -29019;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -29019 : colour;

				itemDefinition.modelColourToEdit[4] = -29125;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -29125 : colour;

				itemDefinition.modelColourToEdit[5] = -29110;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -29110 : colour;
				break;
			case 16356:
				itemDefinition.name = "Vorkath crossbow";
				itemDefinition.inventoryModel = 19967;
				itemDefinition.maleModel = 19839;
				itemDefinition.maleEquip2 = -1;
				itemDefinition.femaleModel = 19839;
				itemDefinition.femaleEquip2 = -1;
				itemDefinition.femaleEquipOffset = 6;
				itemDefinition.zoom = 1325;
				itemDefinition.rotationX = 110;
				itemDefinition.rotationY = 240;
				itemDefinition.inventoryX = -6;
				itemDefinition.inventoryY = -40;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[5];
				itemDefinition.modelColourToEdit[0] = 5409;
				itemDefinition.modelColourToEdit[1] = 5404;
				itemDefinition.modelColourToEdit[2] = 6449;
				itemDefinition.modelColourToEdit[3] = 7390;
				itemDefinition.newModelColourProduced = new int[5];
				itemDefinition.newModelColourProduced[0] = 4; // Was white
				itemDefinition.newModelColourProduced[1] = 15; // Was white
				itemDefinition.newModelColourProduced[2] = 34770; // Was yellow
				itemDefinition.newModelColourProduced[3] = 34760; // Was yellow

				// String colour, was grey
				colour = 4;
				itemDefinition.modelColourToEdit[4] = 8530;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 8530 : colour;
				break;
			case 16357:
				itemDefinition.name = "Armadyl chestplate";
				itemDefinition.inventoryModel = 28039;
				itemDefinition.maleModel = 27633;
				itemDefinition.maleEquip2 = 27629;
				itemDefinition.femaleModel = 27645;
				itemDefinition.femaleEquip2 = 28828;
				itemDefinition.zoom = 854;
				itemDefinition.rotationY = 453;
				itemDefinition.inventoryX = 1;
				itemDefinition.inventoryY = -5;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[12];
				itemDefinition.newModelColourProduced = new int[12];

				// White
				colour = 4;
				itemDefinition.modelColourToEdit[1] = -22440;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22440 : colour;

				// Darker white
				colour = 15;
				itemDefinition.modelColourToEdit[3] = -22448;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -22448 : colour;

				// Grey
				colour = 34750;
				itemDefinition.modelColourToEdit[2] = -22489;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22489 : colour;

				colour = 34770;
				itemDefinition.modelColourToEdit[9] = -22460;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? -22460 : colour;

				itemDefinition.modelColourToEdit[10] = -22452;
				itemDefinition.newModelColourProduced[10] = colour == -1 ? -22452 : colour;

				itemDefinition.modelColourToEdit[11] = -22464;
				itemDefinition.newModelColourProduced[11] = colour == -1 ? -22464 : colour;

				// Yellow
				colour = 15;
				itemDefinition.modelColourToEdit[4] = 8658;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 8658 : colour;

				// Darker yellow
				colour = 4;
				itemDefinition.modelColourToEdit[5] = 8650;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 8650 : colour;
				
				// Skin colour
				colour = -1;
				itemDefinition.modelColourToEdit[0] = 4550;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 4550 : colour;
				
				colour = -1;
				itemDefinition.modelColourToEdit[6] = 4550;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 4550 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[7] = 8650;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 8650 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[8] = 8658;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? 8658 : colour;

				break;
			case 16358:
				itemDefinition.name = "Bandos tassets";
				itemDefinition.inventoryModel = 28047;
				itemDefinition.maleModel = 27625;
				itemDefinition.femaleModel = 27640;
				itemDefinition.zoom = 854;
				itemDefinition.rotationX = 2039;
				itemDefinition.rotationY = 540;
				itemDefinition.inventoryX = 3;
				itemDefinition.inventoryY = 3;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[7];
				itemDefinition.newModelColourProduced = new int[7];


				green = 4;
				red = 34770;
				yellow = 34770;
				blue = 4;

				colour = -1;
				itemDefinition.modelColourToEdit[0] = 4550;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 4550 : colour;

				colour = red;
				itemDefinition.modelColourToEdit[1] = 22;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 22 : colour;

				colour = red;
				itemDefinition.modelColourToEdit[2] = 163;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 163 : colour;

				colour = red;
				itemDefinition.modelColourToEdit[3] = 154;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 154 : colour;

				colour = blue;
				itemDefinition.modelColourToEdit[4] = 39;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 39 : colour;

				colour = yellow;
				itemDefinition.modelColourToEdit[5] = 9523;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 9523 : colour;

				colour = green;
				itemDefinition.modelColourToEdit[6] = 8390;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 8390 : colour;
				break;
			case 16359:
				itemDefinition.name = "Attacker icon";
				itemDefinition.inventoryModel = 20578;
				itemDefinition.maleModel = 19260;
				itemDefinition.maleEquip2 = -1;
				itemDefinition.femaleModel = 20517;
				itemDefinition.zoom = 919;
				itemDefinition.rotationX = 1024;
				itemDefinition.rotationY = 567;
				itemDefinition.inventoryX = 35;
				itemDefinition.inventoryY = 30;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[5];
				itemDefinition.newModelColourProduced = new int[5];
				colour = 0;
				itemDefinition.modelColourToEdit[0] = 947;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 947 : colour;
				itemDefinition.modelColourToEdit[1] = 11200;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 11200 : colour;
				itemDefinition.modelColourToEdit[2] = -21581;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -21581 : colour;
				itemDefinition.modelColourToEdit[3] = 22451;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 22451 : colour;
				itemDefinition.modelColourToEdit[4] = 22439;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 22439 : colour;
				break;
			case 16360:
				itemDefinition.name = "Attacker icon";
				itemDefinition.inventoryModel = 20578;
				itemDefinition.maleModel = 19260;
				itemDefinition.maleEquip2 = -1;
				itemDefinition.femaleModel = 20517;
				itemDefinition.femaleEquip2 = -1;
				itemDefinition.zoom = 919;
				itemDefinition.rotationX = 1024;
				itemDefinition.rotationY = 567;
				itemDefinition.inventoryX = 35;
				itemDefinition.inventoryY = 30;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[5];
				itemDefinition.newModelColourProduced = new int[5];
				colour = 34770;
				itemDefinition.modelColourToEdit[0] = 947;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 947 : colour;
				itemDefinition.modelColourToEdit[1] = 11200;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 11200 : colour;
				itemDefinition.modelColourToEdit[2] = -21581;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -21581 : colour;
				itemDefinition.modelColourToEdit[3] = 22451;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 22451 : colour;
				itemDefinition.modelColourToEdit[4] = 22439;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 22439 : colour;
				break;
			case 16361:
				itemDefinition.inventoryOptions = new String[] {null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Sigil colour
				colour = 58325;
				itemDefinition.modelColourToEdit[1] = 127;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 127 : colour;

				// Shield colour
				colour = 34770;
				itemDefinition.modelColourToEdit[0] = -28716;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -28716 : colour;

				// Trim colour
				colour = 58325;
				itemDefinition.modelColourToEdit[2] = -29116;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -29116 : colour;

				itemDefinition.modelColourToEdit[3] = -29019;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -29019 : colour;

				itemDefinition.modelColourToEdit[4] = -29125;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -29125 : colour;

				itemDefinition.modelColourToEdit[5] = -29110;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -29110 : colour;
				break;
			case 16362:
				itemDefinition.name = "Schoolgirl pet";
				itemDefinition.inventoryOptions = new String[] {null, null, null, null, "Drop"};
				itemDefinition.zoom = 1000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				npcInstance = EntityDefinition.forId(1915);
				itemDefinition.inventoryModel = npcInstance.models[1];

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.modelColourToEdit[0] = 206;
				itemDefinition.modelColourToEdit[1] = 41145;
				itemDefinition.modelColourToEdit[2] = 6550;
				itemDefinition.modelColourToEdit[3] = 189;
				itemDefinition.modelColourToEdit[4] = 933;
				itemDefinition.newModelColourProduced = new int[6];
				itemDefinition.newModelColourProduced[0] = 6967;
				itemDefinition.newModelColourProduced[1] = 23843;
				itemDefinition.newModelColourProduced[2] = 0;
				itemDefinition.newModelColourProduced[3] = 7083;
				itemDefinition.newModelColourProduced[4] = 9152;

				colour = 405;
				itemDefinition.modelColourToEdit[5] = 4550;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 4550 : colour;
				break;
			case 16347:
				itemDefinition.inventoryOptions = new String[] {null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Sigil colour
				colour = 58325;
				itemDefinition.modelColourToEdit[1] = 127;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 127 : colour;

				// Shield colour
				colour = 58325;
				itemDefinition.modelColourToEdit[0] = -28716;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -28716 : colour;

				// Trim colour
				colour = 305770;
				itemDefinition.modelColourToEdit[2] = -29116;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -29116 : colour;

				itemDefinition.modelColourToEdit[3] = -29019;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -29019 : colour;

				itemDefinition.modelColourToEdit[4] = -29125;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -29125 : colour;

				itemDefinition.modelColourToEdit[5] = -29110;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -29110 : colour;
				break;

			case 16348:
				itemDefinition.name = "Ancestral robe top";
				itemDefinition.inventoryModel = 32790;
				itemDefinition.maleModel = 32657;
				itemDefinition.maleEquip2 = 32658;
				itemDefinition.femaleModel = 32664;
				itemDefinition.femaleEquip2 = 32665;
				itemDefinition.femaleModel = 32664;
				itemDefinition.zoom = 1358;
				itemDefinition.rotationX = 2041;
				itemDefinition.rotationY = 514;
				itemDefinition.inventoryY = -3;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[12];
				itemDefinition.newModelColourProduced = new int[12];

				// Light biege
				colour = 5;
				itemDefinition.modelColourToEdit[0] = 6348;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 6348 : colour;

				// Grey
				colour = 4;
				itemDefinition.modelColourToEdit[1] = -16318;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -16318 : colour;

				// Biege
				colour = 3;
				itemDefinition.modelColourToEdit[2] = 6331;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 6331 : colour;

				// Biege stripe across chest from shoulders to waist
				colour = 2;
				itemDefinition.modelColourToEdit[9] = 6323;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? -16327 : colour;

				// Dark grey
				colour = 1;
				itemDefinition.modelColourToEdit[6] = -16327;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -16327 : colour;

				// Dark grey
				colour = 0;
				itemDefinition.modelColourToEdit[8] = -16339;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -16327 : colour;

				// Very dark purple
				colour = 5;
				itemDefinition.modelColourToEdit[10] = 5268;
				itemDefinition.newModelColourProduced[10] = colour == -1 ? -16327 : colour;

				// Dark purple
				colour = 296760;
				itemDefinition.modelColourToEdit[7] = -22231;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -16327 : colour;

				// Dark purple
				colour = 296750;
				itemDefinition.modelColourToEdit[5] = -22235;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22235 : colour;

				// Purple
				colour = 296770;
				itemDefinition.modelColourToEdit[3] = -22225;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -22225 : colour;

				// Orange
				colour = 0;
				itemDefinition.modelColourToEdit[4] = 7108;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 7108 : colour;

				// Orange
				colour = 296770;
				itemDefinition.modelColourToEdit[11] = 6973;
				itemDefinition.newModelColourProduced[11] = colour == -1 ? 6973 : colour;

				break;
			case 16349:
				itemDefinition.name = "Ancestral robe bottom";
				itemDefinition.inventoryModel = 32787;
				itemDefinition.maleModel = 32653;
				itemDefinition.maleEquip2 = -1;
				itemDefinition.femaleModel = 32662;
				itemDefinition.femaleEquip2 = -1;
				itemDefinition.zoom = 1690;
				itemDefinition.rotationX = 9;
				itemDefinition.rotationY = 435;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = 7;
				itemDefinition.brightness = 30;
				itemDefinition.contrast = 100;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[10];
				itemDefinition.newModelColourProduced = new int[10];

				// Dark grey
				colour = 0;
				itemDefinition.modelColourToEdit[6] = -16327;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -16327 : colour;

				// Dark grey
				colour = 1;
				itemDefinition.modelColourToEdit[8] = -16339;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -16327 : colour;

				// Grey
				colour = 2;
				itemDefinition.modelColourToEdit[1] = -16318;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -16318 : colour;

				// Grey
				colour = 3;
				itemDefinition.modelColourToEdit[9] = 6323;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? -16327 : colour;

				// Biege
				colour = 4;
				itemDefinition.modelColourToEdit[2] = 6331;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 6331 : colour;

				// Light biege
				colour = 5;
				itemDefinition.modelColourToEdit[0] = 6348;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 6348 : colour;

				// Orange
				colour = -1;
				itemDefinition.modelColourToEdit[4] = 7108;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 7108 : colour;

				// Dark purple
				colour = 296740;
				itemDefinition.modelColourToEdit[5] = -22235;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22235 : colour;

				// Dark purple
				colour = 296750;
				itemDefinition.modelColourToEdit[7] = -22231;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -16327 : colour;

				// Purple
				colour = 296760;
				itemDefinition.modelColourToEdit[3] = -22225;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -22225 : colour;
				break;
			case 16350:
				itemDefinition.name = "Corporeal beast pet";
				itemDefinition.inventoryOptions = new String[] {null, null, null, null, "Drop"};
				itemDefinition.zoom = 3700;
				itemDefinition.rotationY = 100;
				itemDefinition.rotationX = 100;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				npcInstance = EntityDefinition.forId(319);
				itemDefinition.inventoryModel = npcInstance.models[0];
				itemDefinition.modelColourToEdit = new int[11];
				itemDefinition.newModelColourProduced = new int[11];

				// Black
				colour = -1;
				itemDefinition.modelColourToEdit[0] = 0;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 0 : colour;

				// White
				colour = 296770;
				itemDefinition.modelColourToEdit[6] = 103;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 103 : colour;

				// Dark Grey
				colour = 296770;
				itemDefinition.modelColourToEdit[7] = 16;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 16 : colour;

				// Dark grey
				colour = 296730;
				itemDefinition.modelColourToEdit[10] = 18;
				itemDefinition.newModelColourProduced[10] = colour == -1 ? 18 : colour;

				// Brown
				colour = 10;
				itemDefinition.modelColourToEdit[1] = 6340;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 6340 : colour;

				// Brown
				colour = 8;
				itemDefinition.modelColourToEdit[5] = 6336;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 6336 : colour;

				// Dark brown
				colour = 7;
				itemDefinition.modelColourToEdit[2] = 6315;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 6315 : colour;

				// Dark brown
				colour = 6;
				itemDefinition.modelColourToEdit[9] = 6323;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? 6323 : colour;

				// Very dark brown
				colour = 3;
				itemDefinition.modelColourToEdit[3] = 5281;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 5281 : colour;

				// Very very dark brown
				colour = 0;
				itemDefinition.modelColourToEdit[4] = 2332;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 2332 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[8] = -21608;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -21608 : colour;
				break;
			case 16345:
				itemDefinition.name = "Ancestral robe top";
				itemDefinition.inventoryModel = 32790;
				itemDefinition.maleModel = 32657;
				itemDefinition.maleEquip2 = 32658;
				itemDefinition.femaleModel = 32664;
				itemDefinition.femaleEquip2 = 32665;
				itemDefinition.femaleModel = 32664;
				itemDefinition.zoom = 1358;
				itemDefinition.rotationX = 2041;
				itemDefinition.rotationY = 514;
				itemDefinition.inventoryY = -3;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[11];
				itemDefinition.newModelColourProduced = new int[11];

				// Light biege
				colour = 51105;
				itemDefinition.modelColourToEdit[0] = 6348;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 6348 : colour;

				// Grey
				colour = 51130;
				itemDefinition.modelColourToEdit[1] = -16318;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -16318 : colour;

				// Biege
				colour = 51125;
				itemDefinition.modelColourToEdit[2] = 6331;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 6331 : colour;

				// Very dark purple
				colour = 127;
				itemDefinition.modelColourToEdit[10] = 5268;
				itemDefinition.newModelColourProduced[10] = colour == -1 ? -16327 : colour;

				// Dark purple
				colour = 115;
				itemDefinition.modelColourToEdit[5] = -22235;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22235 : colour;

				// Purple
				colour = 100;
				itemDefinition.modelColourToEdit[3] = -22225;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -22225 : colour;

				// Orange
				colour = -1;
				itemDefinition.modelColourToEdit[4] = 7108;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 7108 : colour;

				// Dark grey
				colour = 51125;
				itemDefinition.modelColourToEdit[6] = -16327;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -16327 : colour;

				// Dark purple
				colour = 51110;
				itemDefinition.modelColourToEdit[7] = -22231;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -16327 : colour;

				// Dark grey
				colour = 51100;
				itemDefinition.modelColourToEdit[8] = -16339;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -16327 : colour;

				// Biege stripe across chest from shoulders to waist
				colour = 51095;
				itemDefinition.modelColourToEdit[9] = 6323;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? -16327 : colour;
				break;
			case 16346:
				itemDefinition.name = "Ancestral robe bottom";
				itemDefinition.inventoryModel = 32787;
				itemDefinition.maleModel = 32653;
				itemDefinition.maleEquip2 = -1;
				itemDefinition.femaleModel = 32662;
				itemDefinition.femaleEquip2 = -1;
				itemDefinition.zoom = 1690;
				itemDefinition.rotationX = 9;
				itemDefinition.rotationY = 435;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = 7;
				itemDefinition.brightness = 30;
				itemDefinition.contrast = 100;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[10];
				itemDefinition.newModelColourProduced = new int[10];

				// Dark grey
				colour = 51095;
				itemDefinition.modelColourToEdit[6] = -16327;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -16327 : colour;

				// Dark grey
				colour = 51105;
				itemDefinition.modelColourToEdit[8] = -16339;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -16327 : colour;

				// Grey
				colour = 51115;
				itemDefinition.modelColourToEdit[1] = -16318;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -16318 : colour;

				// Grey
				colour = 51115;
				itemDefinition.modelColourToEdit[9] = 6323;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? -16327 : colour;

				// Biege
				colour = 51125;
				itemDefinition.modelColourToEdit[2] = 6331;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 6331 : colour;

				// Light biege
				colour = 51136;
				itemDefinition.modelColourToEdit[0] = 6348;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 6348 : colour;

				// Orange
				colour = -1;
				itemDefinition.modelColourToEdit[4] = 7108;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 7108 : colour;

				// Dark purple
				colour = 115;
				itemDefinition.modelColourToEdit[5] = -22235;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22235 : colour;

				// Dark purple
				colour = 110;
				itemDefinition.modelColourToEdit[7] = -22231;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -16327 : colour;

				// Purple
				colour = 100;
				itemDefinition.modelColourToEdit[3] = -22225;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -22225 : colour;
				break;
			case 16344:
				itemDefinition.name = "TzKal-Zuk pet";
				itemDefinition.inventoryOptions = new String[] {null, null, null, null, "Drop"};
				itemDefinition.inventoryModel = 30536;
				itemDefinition.zoom = 905;
				itemDefinition.rotationY = 673;
				itemDefinition.rotationX = 427;
				itemDefinition.inventoryX = 3;
				itemDefinition.inventoryY = 3;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.brightness = -30;
				EntityDefinition data = EntityDefinition.forId(7706);
				itemDefinition.modelColourToEdit = new int[21];
				itemDefinition.newModelColourProduced = new int[21];
				colour = -1;
				itemDefinition.modelColourToEdit[1] = 12;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 12 : colour;

				itemDefinition.modelColourToEdit[2] = 8;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 8 : colour;

				itemDefinition.modelColourToEdit[3] = 4;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 4 : colour;

				itemDefinition.modelColourToEdit[4] = 272;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 272 : colour;

				itemDefinition.modelColourToEdit[5] = 16;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 16 : colour;

				itemDefinition.modelColourToEdit[9] = 20;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? 20 : colour;

				itemDefinition.modelColourToEdit[11] = 268;
				itemDefinition.newModelColourProduced[11] = colour == -1 ? 268 : colour;

				itemDefinition.modelColourToEdit[14] = 662;
				itemDefinition.newModelColourProduced[14] = colour == -1 ? 662 : colour;

				itemDefinition.modelColourToEdit[15] = 3008;
				itemDefinition.newModelColourProduced[15] = colour == -1 ? 3008 : colour;

				colour = 51096;

				itemDefinition.modelColourToEdit[10] = 398;
				itemDefinition.newModelColourProduced[10] = colour == -1 ? 398 : colour;

				itemDefinition.modelColourToEdit[12] = 530;
				itemDefinition.newModelColourProduced[12] = colour == -1 ? 530 : colour;

				colour = 51105;
				itemDefinition.modelColourToEdit[13] = 528;
				itemDefinition.newModelColourProduced[13] = colour == -1 ? 528 : colour;

				itemDefinition.modelColourToEdit[16] = 916;
				itemDefinition.newModelColourProduced[16] = colour == -1 ? 916 : colour;

				itemDefinition.modelColourToEdit[17] = 920;
				itemDefinition.newModelColourProduced[17] = colour == -1 ? 920 : colour;

				colour = 51100;
				itemDefinition.modelColourToEdit[18] = 968;
				itemDefinition.newModelColourProduced[18] = colour == -1 ? 968 : colour;

				itemDefinition.modelColourToEdit[19] = 962;
				itemDefinition.newModelColourProduced[19] = colour == -1 ? 962 : colour;

				colour = 51130;
				itemDefinition.modelColourToEdit[20] = 926;
				itemDefinition.newModelColourProduced[20] = colour == -1 ? 926 : colour;

				colour = 51120;
				itemDefinition.modelColourToEdit[0] = 18368;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 18368 : colour;

				colour = 51110;
				itemDefinition.modelColourToEdit[6] = 278;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 278 : colour;

				itemDefinition.modelColourToEdit[7] = 280;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 280 : colour;

				itemDefinition.modelColourToEdit[8] = 274;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? 274 : colour;
				break;
			case 16333:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Sigil colour
				colour = 34770;
				itemDefinition.modelColourToEdit[1] = 127;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 127 : colour;

				// Shield colour
				colour = 0;
				itemDefinition.modelColourToEdit[0] = -28716;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -28716 : colour;

				// Trim colour
				colour = 34770;
				itemDefinition.modelColourToEdit[2] = -29116;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -29116 : colour;

				itemDefinition.modelColourToEdit[3] = -29019;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -29019 : colour;

				itemDefinition.modelColourToEdit[4] = -29125;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -29125 : colour;

				itemDefinition.modelColourToEdit[5] = -29110;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -29110 : colour;
				break;
			case 16334:
				itemDefinition.name = "Abyssal tentacle";
				itemDefinition.inventoryModel = 28439;
				itemDefinition.maleModel = 28446;
				itemDefinition.femaleModel = 28446;
				itemDefinition.zoom = 840;
				itemDefinition.rotationX = 121;
				itemDefinition.rotationY = 280;
				itemDefinition.inventoryY = 56;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = "Check";
				itemDefinition.inventoryOptions[4] = "Dissolve";

				itemDefinition.modelColourToEdit = new int[3];
				itemDefinition.newModelColourProduced = new int[3];

				// Stripe colour
				colour = 34770;
				itemDefinition.modelColourToEdit[0] = 11150;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -22208 : colour;

				// Not used
				itemDefinition.modelColourToEdit[1] = 9108;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22477 : colour;

				// Spikes colour
				colour = 58325;
				itemDefinition.modelColourToEdit[2] = 10355;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22464 : colour;
				break;
			case 16335:
				itemDefinition.name = "Granite maul";
				itemDefinition.inventoryModel = 5413;
				itemDefinition.maleModel = 5410;
				itemDefinition.femaleModel = 5410;
				itemDefinition.zoom = 2000;
				itemDefinition.rotationX = 36;
				itemDefinition.rotationY = 308;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = 17;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[4];
				itemDefinition.newModelColourProduced = new int[4];
				colour = 110;
				itemDefinition.modelColourToEdit[0] = 8481;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 8481 : colour;

				colour = 120;
				itemDefinition.modelColourToEdit[1] = 8361;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 8361 : colour;

				colour = 17350;
				itemDefinition.modelColourToEdit[2] = 10295;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 10295 : colour;

				colour = 17340;
				itemDefinition.modelColourToEdit[3] = 10287;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 10287 : colour;
				break;
			case 16336:
				itemDefinition.name = "Berserker ring (i)";
				itemDefinition.inventoryModel = 21847;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 600;
				itemDefinition.rotationX = 1916;
				itemDefinition.rotationY = 324;
				itemDefinition.inventoryX = 3;
				itemDefinition.inventoryY = -15;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = "Uncharge";
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[]
				{-22407, -23323, -22308, -21269, 9158, 9009, 11212};
				itemDefinition.newModelColourProduced = new int[]
				{17340, 58325, 17340, 461770, 461770, 461770, 461770};
				break;
			case 16337:
				itemDefinition.inventoryOptions = new String[]
						{null, "Wield", "Dismantle", null, null};
				itemDefinition.name = "Armadyl godsword";
				itemDefinition.inventoryModel = 28075;
				itemDefinition.zoom = 1957;
				itemDefinition.rotationY = 498;
				itemDefinition.rotationX = 484;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = -1;
				itemDefinition.maleModel = 27649;
				itemDefinition.femaleModel = 27649;

				itemDefinition.modelColourToEdit = new int[10];
				itemDefinition.newModelColourProduced = new int[10];

				// Hilt section where the hands are wrapped around
				colour = 8;
				itemDefinition.modelColourToEdit[0] = -22208;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -22208 : colour;

				// Hilt top section
				itemDefinition.modelColourToEdit[1] = -22477;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22477 : colour;

				// Hilt section various sides
				itemDefinition.modelColourToEdit[2] = -22464;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22464 : colour;

				// Hilt section, the bottom part, half of the furs
				itemDefinition.modelColourToEdit[3] = -24279;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -24279 : colour;

				// Hilt section, the bottom part, rest of the furs
				itemDefinition.modelColourToEdit[4] = -24271;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -24271 : colour;

				// Blade, left side
				colour = 127;
				itemDefinition.modelColourToEdit[5] = -22444;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22444 : colour;

				colour = 17350;
				// Blade, right side
				itemDefinition.modelColourToEdit[6] = -22423;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -22423 : colour;

				colour = 127;
				// Blade decoration on the right
				itemDefinition.modelColourToEdit[7] = -22415;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -22415 : colour;

				// Blade tip on the right
				itemDefinition.modelColourToEdit[8] = -22419;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -22419 : colour;

				// Blade at the tip, inventory model only.
				itemDefinition.modelColourToEdit[9] = -22440;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? -22440 : colour;
				break;
			case 16338:
				itemDefinition.name = "White h'ween mask";
				itemDefinition.inventoryModel = 2438;
				itemDefinition.maleModel = 3188;
				itemDefinition.femaleModel = 3192;
				itemDefinition.zoom = 730;
				itemDefinition.rotationY = 516;
				itemDefinition.inventoryY = -10;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = "Destroy";
				itemDefinition.modelColourToEdit = new int[2];
				itemDefinition.modelColourToEdit[0] = 926;
				itemDefinition.modelColourToEdit[1] = 0;
				itemDefinition.newModelColourProduced = new int[2];
				itemDefinition.newModelColourProduced[0] = 124; // Background colour
				itemDefinition.newModelColourProduced[1] = 933; // Eyes colour
				break;
			case 16339:
				itemDefinition.name = "Elder maul";
				itemDefinition.inventoryModel = 32792;
				itemDefinition.maleModel = 32678;
				itemDefinition.femaleModel = 32678;
				itemDefinition.zoom = 1744;
				itemDefinition.rotationX = 429;
				itemDefinition.rotationY = 237;
				itemDefinition.inventoryX = -3;
				itemDefinition.inventoryY = -58;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Orange dark
				colour = 4;
				itemDefinition.modelColourToEdit[0] = 5056;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 5056 : colour;

				// Orange dark
				colour = 10;
				itemDefinition.modelColourToEdit[1] = 8125;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 8125 : colour;

				// Dark grey
				colour = 933;
				itemDefinition.modelColourToEdit[2] = 16;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 16 : colour;

				// Dark grey
				colour = 933;
				itemDefinition.modelColourToEdit[5] = 20;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 20 : colour;

				// It was black
				colour = 925;
				itemDefinition.modelColourToEdit[3] = 0;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 0 : colour;

				// Grey
				colour = 937;
				itemDefinition.modelColourToEdit[4] = 33;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 33 : colour;
				break;
			case 16340:
				itemDefinition.name = "H'Ween D-Claws";
				itemDefinition.femaleModel = 29191;
				itemDefinition.femaleEquipOffset = 6;
				itemDefinition.inventoryOptions = new String[] {null, "Wear", null, null, null};
				itemDefinition.inventoryModel = 32784;
				itemDefinition.maleModel = 29191;
				itemDefinition.rotationY = 349;
				itemDefinition.inventoryX = 0;
				itemDefinition.rotationX = 15;
				itemDefinition.inventoryY = 8;
				itemDefinition.zoom = 886;

				itemDefinition.modelColourToEdit = new int[4];
				itemDefinition.newModelColourProduced = new int[4];
				colour = 461785;
				itemDefinition.modelColourToEdit[0] = 929;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 929 : colour;

				itemDefinition.modelColourToEdit[2] = 918;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 918 : colour;

				colour = 461785;
				itemDefinition.modelColourToEdit[1] = 922;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 922 : colour;

				itemDefinition.modelColourToEdit[3] = 914;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 914 : colour;
				break;
			case 16341:
				itemDefinition.name = "Abyssal tentacle";
				itemDefinition.inventoryModel = 28439;
				itemDefinition.maleModel = 28446;
				itemDefinition.femaleModel = 28446;
				itemDefinition.zoom = 840;
				itemDefinition.rotationX = 121;
				itemDefinition.rotationY = 280;
				itemDefinition.inventoryY = 56;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = "Check";
				itemDefinition.inventoryOptions[4] = "Dissolve";

				itemDefinition.modelColourToEdit = new int[3];
				itemDefinition.newModelColourProduced = new int[3];

				// Stripe colour
				colour = 933;
				itemDefinition.modelColourToEdit[0] = 11150;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -22208 : colour;

				// Not used
				itemDefinition.modelColourToEdit[1] = 9108;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22477 : colour;

				// Spikes colour
				colour = 0;
				itemDefinition.modelColourToEdit[2] = 10355;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22464 : colour;
				break;

			case 16342:
				itemDefinition.name = "Purple Defender";
				itemDefinition.inventoryModel = 20578;
				itemDefinition.maleModel = 19261;
				itemDefinition.femaleModel = 20519;
				itemDefinition.zoom = 1049;
				itemDefinition.rotationX = 1010;
				itemDefinition.rotationY = 526;
				itemDefinition.inventoryX = 35;
				itemDefinition.inventoryY = -30;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[5];
				itemDefinition.modelColourToEdit[0] = 22439;
				itemDefinition.newModelColourProduced = new int[5];
				itemDefinition.newModelColourProduced[0] = 51136;

				colour = 51136;
				itemDefinition.modelColourToEdit[1] = 947;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 947 : colour;

				colour = 51130;
				itemDefinition.modelColourToEdit[2] = 11200;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 11200 : colour;

				colour = 51125;
				itemDefinition.modelColourToEdit[3] = -21581;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -21581 : colour;

				colour = 51120;
				itemDefinition.modelColourToEdit[4] = 22451;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 22451 : colour;
				break;
			case 16343:
				itemDefinition.name = "Purple h'ween mask";
				itemDefinition.inventoryModel = 2438;
				itemDefinition.maleModel = 3188;
				itemDefinition.femaleModel = 3192;
				itemDefinition.zoom = 730;
				itemDefinition.rotationY = 516;
				itemDefinition.inventoryY = -10;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = "Destroy";
				itemDefinition.modelColourToEdit = new int[2];
				itemDefinition.modelColourToEdit[0] = 926;
				itemDefinition.modelColourToEdit[1] = 0;
				itemDefinition.newModelColourProduced = new int[2];
				itemDefinition.newModelColourProduced[0] = 51136; // Background colour
				itemDefinition.newModelColourProduced[1] = 0; // Eyes colour
				break;

			// Slayer helms
			case 11864:
			case 11865:
			case 19639:
			case 19641:
			case 19643:
			case 19645:
			case 19647:
			case 19649:
			case 21264:
			case 21266:
				itemDefinition.operateOptions = new String[] {"Check"};
				break;
			case 16329:
				itemDefinition.name = "Elder maul";
				itemDefinition.inventoryModel = 32792;
				itemDefinition.maleModel = 32678;
				itemDefinition.femaleModel = 32678;
				itemDefinition.zoom = 1744;
				itemDefinition.rotationX = 429;
				itemDefinition.rotationY = 237;
				itemDefinition.inventoryX = -3;
				itemDefinition.inventoryY = -58;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Orange dark
				colour = 58300;
				itemDefinition.modelColourToEdit[0] = 5056;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 5056 : colour;

				// Orange dark
				colour = 58300;
				itemDefinition.modelColourToEdit[1] = 8125;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 8125 : colour;

				// Dark grey
				colour = 58315;
				itemDefinition.modelColourToEdit[2] = 16;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 16 : colour;

				// Dark grey
				colour = 58315;
				itemDefinition.modelColourToEdit[5] = 20;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 20 : colour;

				// It was black
				colour = 58325;
				itemDefinition.modelColourToEdit[3] = 0;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 0 : colour;

				// Grey
				colour = 58300;
				itemDefinition.modelColourToEdit[4] = 33;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 33 : colour;
				break;
			case 16330:
				itemDefinition.name = "Dragon claws";
				itemDefinition.femaleModel = 29191;
				itemDefinition.femaleEquipOffset = 6;
				itemDefinition.inventoryOptions = new String[] {null, "Wear", null, null, null};
				itemDefinition.inventoryModel = 32784;
				itemDefinition.maleModel = 29191;
				itemDefinition.rotationY = 349;
				itemDefinition.inventoryX = 0;
				itemDefinition.rotationX = 15;
				itemDefinition.inventoryY = 8;
				itemDefinition.zoom = 886;

				itemDefinition.modelColourToEdit = new int[4];
				itemDefinition.newModelColourProduced = new int[4];
				colour = 17350;
				itemDefinition.modelColourToEdit[0] = 929;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 929 : colour;

				itemDefinition.modelColourToEdit[2] = 918;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 918 : colour;

				colour = 17340;
				itemDefinition.modelColourToEdit[1] = 922;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 922 : colour;

				itemDefinition.modelColourToEdit[3] = 914;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 914 : colour;
				break;
			case 16331:
				itemDefinition.name = "Lime green h'ween mask";
				itemDefinition.inventoryModel = 2438;
				itemDefinition.maleModel = 3188;
				itemDefinition.femaleModel = 3192;
				itemDefinition.zoom = 730;
				itemDefinition.rotationY = 516;
				itemDefinition.inventoryY = -10;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = "Destroy";
				itemDefinition.modelColourToEdit = new int[2];
				itemDefinition.modelColourToEdit[0] = 926;
				itemDefinition.modelColourToEdit[1] = 0;
				itemDefinition.newModelColourProduced = new int[2];
				itemDefinition.newModelColourProduced[0] = 17350; // Background colour
				itemDefinition.newModelColourProduced[1] = 0; // Eyes colour
				break;
			case 16332:
				npcInstance = EntityDefinition.forId(2592);
				itemDefinition.name = "Pink Mogre pet";
				itemDefinition.inventoryOptions = new String[] {null, null, null, null, "Drop"};
				itemDefinition.zoom = 500;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 120;
				itemDefinition.inventoryModel = npcInstance.models[1];
				break;
			case 16320:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Sigil colour
				colour = 302790;
				itemDefinition.modelColourToEdit[1] = 127;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 127 : colour;

				// Shield colour
				colour = 6073;
				itemDefinition.modelColourToEdit[0] = -28716;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -28716 : colour;

				// Trim colour
				itemDefinition.modelColourToEdit[2] = -29116;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -29116 : colour;

				itemDefinition.modelColourToEdit[3] = -29019;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -29019 : colour;

				itemDefinition.modelColourToEdit[4] = -29125;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -29125 : colour;

				itemDefinition.modelColourToEdit[5] = -29110;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -29110 : colour;
				break;


			case 16321:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Sigil colour
				colour = 332770;
				itemDefinition.modelColourToEdit[1] = 127;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 127 : colour;

				// Shield colour
				colour = 0;
				itemDefinition.modelColourToEdit[0] = -28716;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -28716 : colour;

				// Trim colour
				itemDefinition.modelColourToEdit[2] = -29116;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -29116 : colour;

				itemDefinition.modelColourToEdit[3] = -29019;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -29019 : colour;

				itemDefinition.modelColourToEdit[4] = -29125;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -29125 : colour;

				itemDefinition.modelColourToEdit[5] = -29110;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -29110 : colour;
				break;
			case 16322:
				itemDefinition.name = "Neon Green Santa hat";
				itemDefinition.inventoryModel = 2537;
				itemDefinition.maleModel = 189;
				itemDefinition.femaleModel = 366;
				itemDefinition.zoom = 540;
				itemDefinition.rotationX = 136;
				itemDefinition.rotationY = 72;
				itemDefinition.inventoryY = -3;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;

				itemDefinition.modelColourToEdit = new int[2];
				itemDefinition.newModelColourProduced = new int[2];
				colour = 17350;
				itemDefinition.modelColourToEdit[0] = 933;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 933 : colour;

				colour = 127;
				itemDefinition.modelColourToEdit[1] = 10351;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 10351 : colour;
				break;
			case 16323:
				itemDefinition.name = "Abyssal tentacle";
				itemDefinition.inventoryModel = 28439;
				itemDefinition.maleModel = 28446;
				itemDefinition.femaleModel = 28446;
				itemDefinition.zoom = 840;
				itemDefinition.rotationX = 121;
				itemDefinition.rotationY = 280;
				itemDefinition.inventoryY = 56;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = "Check";
				itemDefinition.inventoryOptions[4] = "Dissolve";

				itemDefinition.modelColourToEdit = new int[3];
				itemDefinition.newModelColourProduced = new int[3];

				// Stripe colour
				colour = 17350;
				itemDefinition.modelColourToEdit[0] = 11150;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -22208 : colour;

				// Not used
				itemDefinition.modelColourToEdit[1] = 9108;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22477 : colour;

				// Spikes colour
				colour = 127;
				itemDefinition.modelColourToEdit[2] = 10355;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22464 : colour;
				break;
			case 16324:
				itemDefinition.name = "Dragon claws";
				itemDefinition.femaleModel = 29191;
				itemDefinition.femaleEquipOffset = 6;
				itemDefinition.inventoryOptions = new String[]
				{null, "Wear", null, null, null};
				itemDefinition.inventoryModel = 32784;
				itemDefinition.maleModel = 29191;
				itemDefinition.rotationY = 349;
				itemDefinition.inventoryX = 0;
				itemDefinition.rotationX = 15;
				itemDefinition.inventoryY = 8;
				itemDefinition.zoom = 886;

				itemDefinition.modelColourToEdit = new int[4];
				itemDefinition.newModelColourProduced = new int[4];
				colour = 51136;
				itemDefinition.modelColourToEdit[0] = 929;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 929 : colour;

				itemDefinition.modelColourToEdit[2] = 918;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 918 : colour;

				colour = 127;
				itemDefinition.modelColourToEdit[1] = 922;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 922 : colour;

				itemDefinition.modelColourToEdit[3] = 914;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 914 : colour;
				break;
			case 16325:
				itemDefinition.name = "Elder maul";
				itemDefinition.inventoryModel = 32792;
				itemDefinition.maleModel = 32678;
				itemDefinition.femaleModel = 32678;
				itemDefinition.zoom = 1744;
				itemDefinition.rotationX = 429;
				itemDefinition.rotationY = 237;
				itemDefinition.inventoryX = -3;
				itemDefinition.inventoryY = -58;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				break;

			case 16326:
				itemDefinition.name = "Kodai wand";
				itemDefinition.inventoryModel = 32789;
				itemDefinition.maleModel = 32669;
				itemDefinition.maleEquip2 = -1;
				itemDefinition.femaleModel = 32669;
				itemDefinition.femaleEquip2 = -1;
				itemDefinition.zoom = 668;
				itemDefinition.rotationX = 1416;
				itemDefinition.rotationY = 140;
				itemDefinition.inventoryX = 2;
				itemDefinition.inventoryY = -4;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				
				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];
				
				// Dark grey
				colour = 100;
				itemDefinition.modelColourToEdit[0] = -19153;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -19153 : colour;

				// Dark grey
				itemDefinition.modelColourToEdit[2] = -19145;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -19145 : colour;

				// Grey
				colour = 127;
				itemDefinition.modelColourToEdit[3] = 37;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 37 : colour;

				// Grey
				colour = 124;
				itemDefinition.modelColourToEdit[4] = -16339;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -16339 : colour;

				// Grey
				colour = -1;
				itemDefinition.modelColourToEdit[5] = -16331;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -16331 : colour;

				// Purple
				colour = 30;
				itemDefinition.modelColourToEdit[1] = -19500;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -19500 : colour;
				break;
			case 16327:
				itemDefinition.name = "Ce﻿lestial﻿ Yoshi pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 750;
				itemDefinition.rotationY = 100;
				itemDefinition.rotationX = 250;
				itemDefinition.inventoryX = 10;
				itemDefinition.inventoryY = 100;
				npcInstance = EntityDefinition.forId(1873);
				itemDefinition.inventoryModel = npcInstance.models[0];

				itemDefinition.modelColourToEdit = new int[14];
				itemDefinition.newModelColourProduced = new int[14];

				// Dark green
				colour = 120;
				itemDefinition.modelColourToEdit[0] = 29976;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 29976 : colour;

				colour = 120;
				itemDefinition.modelColourToEdit[2] = 27819;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 27819 : colour;

				colour = 115;
				itemDefinition.modelColourToEdit[4] = 29980;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 29980 : colour;

				colour = 127;
				itemDefinition.modelColourToEdit[5] = 28302;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 28302 : colour;

				// Very dark green
				colour = 80;
				itemDefinition.modelColourToEdit[6] = 29980;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 29980 : colour;

				// Cream
				colour = 51150;
				itemDefinition.modelColourToEdit[7] = 27934;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 27934 : colour;

				colour = 51140;
				itemDefinition.modelColourToEdit[1] = 7502;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 7502 : colour;

				colour = 51130;
				itemDefinition.modelColourToEdit[3] = 0;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 0 : colour;

				// Blue and dark blue
				// Circle on the ground, most inner first circle
				colour = 51155;
				itemDefinition.modelColourToEdit[8] = -26214;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -26214 : colour;

				// Second circle
				colour = 51150;
				itemDefinition.modelColourToEdit[9] = -26218;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? -26218 : colour;

				// Third circle
				colour = 51145;
				itemDefinition.modelColourToEdit[10] = -26094;
				itemDefinition.newModelColourProduced[10] = colour == -1 ? -26094 : colour;

				// Fourth circle
				colour = 51140;
				itemDefinition.modelColourToEdit[11] = -25970;
				itemDefinition.newModelColourProduced[11] = colour == -1 ? -25970 : colour;

				// Fifth circle
				colour = 51136;
				itemDefinition.modelColourToEdit[12] = -25718;
				itemDefinition.newModelColourProduced[12] = colour == -1 ? -25718 : colour;

				// Sixth circle
				colour = 51133;
				itemDefinition.modelColourToEdit[13] = -23672;
				itemDefinition.newModelColourProduced[13] = colour == -1 ? -23672 : colour;
				break;
			case 16892:
				itemDefinition.name = "Mace Windu's Lightsaber";
				itemDefinition.inventoryModel = 65324;
				itemDefinition.maleModel = 65324;
				itemDefinition.maleEquip2 = -1;
				itemDefinition.femaleModel = 65324;
				itemDefinition.femaleEquip2 = -1;
				itemDefinition.femaleEquipOffset = 6;
				itemDefinition.zoom = 1700;
				itemDefinition.rotationX = 350;
				itemDefinition.rotationY = 120;
				itemDefinition.inventoryX = 15;
				itemDefinition.inventoryY = -1;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				break;
			case 16894:
				itemDefinition.name = "Darth Vader's Lightsaber";
				itemDefinition.inventoryModel = 65326;
				itemDefinition.maleModel = 65326;
				itemDefinition.maleEquip2 = -1;
				itemDefinition.femaleModel = 65326;
				itemDefinition.femaleEquip2 = -1;
				itemDefinition.femaleEquipOffset = 6;
				itemDefinition.zoom = 1700;
				itemDefinition.rotationX = 350;
				itemDefinition.rotationY = 120;
				itemDefinition.inventoryX = 15;
				itemDefinition.inventoryY = -1;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				break;
			case 16895:
				itemDefinition.name = "Luke's 1st Lightsaber";
				itemDefinition.inventoryModel = 65327;
				itemDefinition.maleModel = 65327;
				itemDefinition.maleEquip2 = -1;
				itemDefinition.femaleModel = 65327;
				itemDefinition.femaleEquip2 = -1;
				itemDefinition.femaleEquipOffset = 6;
				itemDefinition.zoom = 1700;
				itemDefinition.rotationX = 350;
				itemDefinition.rotationY = 120;
				itemDefinition.inventoryX = 15;
				itemDefinition.inventoryY = -1;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				break;
			case 16897:
				itemDefinition.name = "Crystal's Lightsaber";
				itemDefinition.inventoryModel = 65329;
				itemDefinition.maleModel = 65329;
				itemDefinition.maleEquip2 = -1;
				itemDefinition.femaleModel = 65329;
				itemDefinition.femaleEquip2 = -1;
				itemDefinition.femaleEquipOffset = 6;
				itemDefinition.zoom = 1700;
				itemDefinition.rotationX = 350;
				itemDefinition.rotationY = 120;
				itemDefinition.inventoryX = 15;
				itemDefinition.inventoryY = -1;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				break;
			case 16898:
				itemDefinition.name = "Halloween Dual Scimtar";
				itemDefinition.inventoryModel = 65338;
				itemDefinition.maleModel = 65330;
				itemDefinition.maleEquip2 = -1;
				itemDefinition.femaleModel = 65330;
				itemDefinition.femaleEquip2 = -1;
				itemDefinition.femaleEquipOffset = 6;
				itemDefinition.zoom = 1750;
				itemDefinition.rotationX = 0;
				itemDefinition.rotationY = 600;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 5;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				break;
			case 16899:
				itemDefinition.name = "Web Cloak";
				itemDefinition.inventoryModel = 24090;
				itemDefinition.maleModel = 24088;
				itemDefinition.femaleModel = 24089;
				itemDefinition.zoom = 2610;
				itemDefinition.inventoryY = 5;
				itemDefinition.inventoryX = 0;
				itemDefinition.rotationY= 500;
				itemDefinition.rotationX = 1000;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				break;
			case 16900:
				itemDefinition.name = "Blood Wings";
				itemDefinition.inventoryModel = 65332;
				itemDefinition.maleModel = 65333;
				itemDefinition.femaleModel = 65333;
				itemDefinition.zoom = 2610;
				itemDefinition.inventoryY = 5;
				itemDefinition.inventoryX = 0;
				itemDefinition.rotationY= 500;
				itemDefinition.rotationX = 1000;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				break;
			case 16901:
				itemDefinition.name = "Target Practice";
				itemDefinition.inventoryModel = 65334;
				itemDefinition.maleModel = 65334;
				itemDefinition.femaleModel = 65334;
				itemDefinition.zoom = 2610;
				itemDefinition.inventoryY = 5;
				itemDefinition.inventoryX = 0;
				itemDefinition.rotationY= 500;
				itemDefinition.rotationX = 1000;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.description = "Uhhhh... Wered my body go?!?!?".getBytes();
				break;
			case 16902:
				itemDefinition.name = "Monkey On Your Shoulder";
				itemDefinition.inventoryModel = 65335;
				itemDefinition.maleModel = 65335;
				itemDefinition.femaleModel = 65335;
				itemDefinition.zoom = 1220;
				itemDefinition.inventoryY = 56;
				itemDefinition.inventoryX = -4;
				itemDefinition.rotationY= 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = "Fondle";
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.description = "I hope this isn't the only way to get Monkey Nuts..".getBytes();
				break;
			case 16903:
				itemDefinition.name = "H'Ween Dye";
				itemDefinition.inventoryModel = 65336;
				itemDefinition.zoom = 890;
				itemDefinition.groundOptions = new String[]
				{null, null, "Take", null, null};
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.description = "A Black & Orange Dye.".getBytes();
				break;
			case 16904:
				itemDefinition.name = "H'Ween Battlestaff";
				itemDefinition.inventoryModel = 65337;
				itemDefinition.maleModel = 65337;
				itemDefinition.femaleModel = 65337;
				itemDefinition.zoom = 2400;
				itemDefinition.rotationX = 1150;
				itemDefinition.rotationY = 0;
				itemDefinition.inventoryY = 20;
				itemDefinition.inventoryX = -30;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Weild";
				itemDefinition.description = "Looks like I may have smashed it's face a few too many times.".getBytes();
				break;
			case 16905:
				itemDefinition.name = "R2";
				itemDefinition.inventoryModel = 65340;
				itemDefinition.zoom = 2128;
				itemDefinition.rotationX = 0;
				itemDefinition.rotationY = 504;
				itemDefinition.inventoryY = 1;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				break;
			case 6075:
                itemDefinition.name = "Magma blowpipe";
                itemDefinition.zoom = 1158;
                itemDefinition.rotationY = 768;
                itemDefinition.rotationX = 189;
                itemDefinition.inventoryX = -7;
                itemDefinition.inventoryY = 4;
                itemDefinition.inventoryOptions = new String[5];
                itemDefinition.inventoryOptions[0] = null;
                itemDefinition.inventoryOptions[1] = "Wield";
                itemDefinition.inventoryOptions[2] = null;
                itemDefinition.inventoryOptions[3] = null;
                itemDefinition.inventoryOptions[4] = null;
                itemDefinition.inventoryModel = 19219;
                itemDefinition.maleModel = 14403;
                itemDefinition.femaleModel = 14403;
                break;
			case 6077:
                itemDefinition.name = "Craw's Op";
                itemInstance = ItemDefinition.forId(22550);
                itemDefinition.inventoryModel = itemInstance.inventoryModel;
                itemDefinition.maleEquip2 = itemInstance.maleEquip2;
                itemDefinition.femaleEquip2 = itemInstance.femaleEquip2;
                itemDefinition.maleModel = itemInstance.maleModel;
                itemDefinition.femaleModel = itemInstance.femaleModel;
                itemDefinition.zoom = itemInstance.zoom;
                itemDefinition.rotationY = 768;
                itemDefinition.rotationX = 189;
                itemDefinition.inventoryX = itemInstance.inventoryX;
                itemDefinition.inventoryY =itemInstance.inventoryY;
                itemDefinition.inventoryOptions = new String[5];
                itemDefinition.inventoryOptions[0] = null;
                itemDefinition.inventoryOptions[1] = "Wield";
                itemDefinition.inventoryOptions[2] = null;
                itemDefinition.inventoryOptions[3] = null;
                itemDefinition.inventoryOptions[4] = null;
                break;
			case 16906:
				itemDefinition.name = "*!* GAMBLE *!* D-Tokens M-Box";
				itemDefinition.description = "Payout Ranges From 175-5,000 Donator Tokens".getBytes();
				itemDefinition.inventoryModel = 2426;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 1180;
				itemDefinition.rotationX = 172;
				itemDefinition.rotationY = 160;
				itemDefinition.inventoryY = -14;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = "Open";
				itemDefinition.inventoryOptions[1] = null;
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[2];
				itemDefinition.modelColourToEdit[0] = 2999;
				itemDefinition.modelColourToEdit[1] = 22410;
				itemDefinition.newModelColourProduced = new int[2];
				itemDefinition.newModelColourProduced[0] = 7445;
				itemDefinition.newModelColourProduced[1] = 5548;
				break;
				case 7121:
	                itemDefinition.name = "Slayer Ring (eternal)";
	                itemInstance = ItemDefinition.forId(11866);
	                itemDefinition.inventoryModel = itemInstance.inventoryModel;
	                itemDefinition.maleEquip2 = itemInstance.maleEquip2;
	                itemDefinition.femaleEquip2 = itemInstance.femaleEquip2;
	                itemDefinition.maleModel = itemInstance.maleModel;
	                itemDefinition.femaleModel = itemInstance.femaleModel;
	                itemDefinition.zoom = itemInstance.zoom;
	                itemDefinition.rotationX = itemInstance.rotationX;
	                itemDefinition.rotationY = itemInstance.rotationY;
	                itemDefinition.inventoryX = itemInstance.inventoryX;
	                itemDefinition.inventoryY =itemInstance.inventoryY;
	                itemDefinition.inventoryOptions = new String[5];
	                itemDefinition.inventoryOptions[0] = null;
	                itemDefinition.inventoryOptions[1] = "Wear";
	                itemDefinition.inventoryOptions[2] = "Teleport";
	                itemDefinition.inventoryOptions[3] = null;
	                itemDefinition.inventoryOptions[4] = "Drop";
	                break;
			 case 7788:
	                itemDefinition.name = itemDefinition.name + " 20k XP";
	                break;
	            case 7789:
	                itemDefinition.name = itemDefinition.name + " 50k XP";
	                break;
	            case 7790:
	                itemDefinition.name = itemDefinition.name + " 100k XP";
	                break;
			case 5562:
                itemInstance = ItemDefinition.forId(13072);
                itemDefinition.name = itemInstance.name + " (i)";
                itemDefinition.inventoryModel = itemInstance.inventoryModel;
                itemDefinition.maleEquip2 = itemInstance.maleEquip2;
                itemDefinition.femaleEquip2 = itemInstance.femaleEquip2;
                itemDefinition.maleModel = itemInstance.maleModel;
                itemDefinition.femaleModel = itemInstance.femaleModel;
                itemDefinition.zoom = itemInstance.zoom;
                itemDefinition.rotationX = itemInstance.rotationX;
                itemDefinition.rotationY = itemInstance.rotationY;
                itemDefinition.inventoryX = itemInstance.inventoryX;
                itemDefinition.inventoryY =itemInstance.inventoryY;
                itemDefinition.inventoryOptions = new String[5];
                itemDefinition.inventoryOptions[0] = null;
                itemDefinition.inventoryOptions[1] = "Wear";
                itemDefinition.inventoryOptions[2] = null;
                itemDefinition.inventoryOptions[3] = null;
                itemDefinition.inventoryOptions[4] = "Drop";
                break;
			case 5563:
                itemInstance = ItemDefinition.forId(13073);
                itemDefinition.inventoryOptions = new String[]
                        {null, "Wear", null, null, null};
                itemDefinition.name = itemInstance.name + " (i)";
                itemDefinition.zoom = itemInstance.zoom;
                itemDefinition.maleEquip2 = itemInstance.maleEquip2;
                itemDefinition.femaleEquip2 = itemInstance.femaleEquip2;
                itemDefinition.rotationY = itemInstance.rotationY;
                itemDefinition.rotationX = itemInstance.rotationX;
                itemDefinition.inventoryY = itemInstance.inventoryY;
                itemDefinition.maleModel = itemInstance.maleModel;
                itemDefinition.femaleModel = itemInstance.femaleModel;
                itemDefinition.inventoryOptions = new String[5];
                itemDefinition.inventoryOptions[0] = null;
                itemDefinition.inventoryOptions[1] = "Wear";
                itemDefinition.inventoryOptions[2] = null;
                itemDefinition.inventoryOptions[3] = null;
                itemDefinition.inventoryOptions[4] = null;
                itemDefinition.inventoryModel = itemInstance.inventoryModel;
                break;
			case 5065:
				itemDefinition.name = "Book Of Wonder";
				itemDefinition.newModelColourProduced = new int[]
						{-25664, -21568, 8128};
				itemDefinition.modelColourToEdit = new int[]
						{5018, 61, 11177};
				itemDefinition.groundOptions = new String[]
						{null, null, "Take", null, null};
				itemDefinition.inventoryOptions = new String[]
						{"Claim", null, null, null, "Drop"};
				itemDefinition.description = "A reward from voting.".getBytes();
				break;
			case 16328:
				itemDefinition.name = "Death pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 650;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 80;
				npcInstance = EntityDefinition.forId(5567);
				itemDefinition.inventoryModel = npcInstance.models[0];
				itemDefinition.modelColourToEdit = new int[13];
				itemDefinition.newModelColourProduced = new int[13];

				// Black
				colour = 127;
				itemDefinition.modelColourToEdit[0] = 0;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 0 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[1] = 5231;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 5231 : colour;

				// White
				colour = 50;
				itemDefinition.modelColourToEdit[2] = 5353;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 5353 : colour;

				colour = 127;
				itemDefinition.modelColourToEdit[3] = 8741;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 8741 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[4] = 4550;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 4550 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[5] = 8741;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 8741 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[6] = 10004;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 10004 : colour;

				colour = 127;
				itemDefinition.modelColourToEdit[7] = 25238;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 25238 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[8] = 0;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? 0 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[9] = 908;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? 908 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[10] = 5541;
				itemDefinition.newModelColourProduced[10] = colour == -1 ? 5541 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[11] = 7073;
				itemDefinition.newModelColourProduced[11] = colour == -1 ? 7073 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[12] = 61;
				itemDefinition.newModelColourProduced[12] = colour == -1 ? 61 : colour;
				break;

			// Chicken outfits that were released on holiday event, but now many players have it and it's unwearable.
			case 11018:
			case 11017:
			case 11015:
			case 11016:
				itemDefinition.groundOptions = new String[]
						{null, null, "Take", null, null};
						itemDefinition.inventoryOptions = new String[]
						{null, "Wear", null, null, "Destroy"};
				break;
			case 12817:
				if (Client.toggleItems) {
					itemDefinition.inventoryOptions = new String[]
					{null, "Wield", null, null, null};
					itemDefinition.name = "Divine spirit shield";
					itemDefinition.inventoryModel = 11072;
					itemDefinition.zoom = 1789;
					itemDefinition.rotationY = 431;
					itemDefinition.rotationX = 27;
					itemDefinition.inventoryX = 0;
					itemDefinition.inventoryY = 11;
					itemDefinition.maleModel = 11048;
					itemDefinition.femaleModel = 11048;

					itemDefinition.modelColourToEdit = new int[6];
					itemDefinition.newModelColourProduced = new int[6];

					// Sigil colour
					colour = -1;
					itemDefinition.modelColourToEdit[1] = 127;
					itemDefinition.newModelColourProduced[1] = colour == -1 ? 127 : colour;

					// Shield colour
					colour = 350753;
					itemDefinition.modelColourToEdit[0] = -28716;
					itemDefinition.newModelColourProduced[0] = colour == -1 ? -28716 : colour;

					// Trim colour
					itemDefinition.modelColourToEdit[2] = -29116;
					itemDefinition.newModelColourProduced[2] = colour == -1 ? -29116 : colour;

					itemDefinition.modelColourToEdit[3] = -29019;
					itemDefinition.newModelColourProduced[3] = colour == -1 ? -29019 : colour;

					itemDefinition.modelColourToEdit[4] = -29125;
					itemDefinition.newModelColourProduced[4] = colour == -1 ? -29125 : colour;

					itemDefinition.modelColourToEdit[5] = -29110;
					itemDefinition.newModelColourProduced[5] = colour == -1 ? -29110 : colour;
				}
				break;

			case 4736:
				if (Client.toggleItems) {
					itemDefinition.name = "Morrigan's leather body";
					itemDefinition.inventoryModel = 42578;
					itemDefinition.zoom = 1440;
					itemDefinition.rotationY = 545;
					itemDefinition.rotationX = 2;
					itemDefinition.inventoryX = -2;
					itemDefinition.inventoryY = 5;
					itemDefinition.maleModel = 42626;
					itemDefinition.femaleModel = 42643;
					itemDefinition.groundOptions = new String[]
					{null, null, "Take", null, null};
					itemDefinition.inventoryOptions = new String[]
					{null, "Wear", null, null, "Destroy"};
				}
				break;
			case 4738:
				if (Client.toggleItems) {
					itemDefinition.name = "Morrigan's leather chaps";
					itemDefinition.inventoryModel = 42603;
					itemDefinition.zoom = 1753;
					itemDefinition.rotationY = 482;
					itemDefinition.rotationX = 1;
					itemDefinition.inventoryX = -3;
					itemDefinition.inventoryY = 11;
					itemDefinition.maleModel = 42631;
					itemDefinition.femaleModel = 42646;
					itemDefinition.groundOptions = new String[]
					{null, null, "Take", null, null};
					itemDefinition.inventoryOptions = new String[]
					{null, "Wear", null, null, "Destroy"};
				}
				break;
			case 4732:
				if (Client.toggleItems) {
					itemDefinition.name = "Morrigan's coif";
					itemDefinition.inventoryModel = 42583;
					itemDefinition.zoom = 592;
					itemDefinition.rotationY = 537;
					itemDefinition.rotationX = 5;
					itemDefinition.inventoryX = -3;
					itemDefinition.inventoryY = 6;
					itemDefinition.maleModel = 42636;
					itemDefinition.femaleModel = 42652;
					itemDefinition.groundOptions = new String[]
					{null, null, "Take", null, null};
					itemDefinition.inventoryOptions = new String[]
					{null, "Wear", null, null, "Destroy"};
				}
				break;

			case 4712:
				if (Client.toggleItems) {
					itemDefinition.name = "Zuriel's robe top";
					itemDefinition.inventoryModel = 42591;
					itemDefinition.zoom = 1373;
					itemDefinition.rotationY = 373;
					itemDefinition.rotationX = 0;
					itemDefinition.inventoryX = 0;
					itemDefinition.inventoryY = -7;
					itemDefinition.maleModel = 42627;
					itemDefinition.femaleModel = 42642;
					itemDefinition.groundOptions = new String[]
					{null, null, "Take", null, null};
					itemDefinition.inventoryOptions = new String[]
					{null, "Wear", null, null, "Destroy"};
				}
				break;
			case 4714:
				if (Client.toggleItems) {
					itemDefinition.name = "Zuriel's robe bottom";
					itemDefinition.inventoryModel = 42588;
					itemDefinition.zoom = 1697;
					itemDefinition.rotationY = 512;
					itemDefinition.rotationX = 0;
					itemDefinition.inventoryX = 2;
					itemDefinition.inventoryY = -9;
					itemDefinition.maleModel = 42634;
					itemDefinition.femaleModel = 42645;
					itemDefinition.groundOptions = new String[]
					{null, null, "Take", null, null};
					itemDefinition.inventoryOptions = new String[]
					{null, "Wear", null, null, "Destroy"};
				}
				break;
			case 4708:
				if (Client.toggleItems) {
					itemDefinition.name = "Zuriel's hood";
					itemDefinition.inventoryModel = 42604;
					itemDefinition.zoom = 720;
					itemDefinition.rotationY = 28;
					itemDefinition.rotationX = 0;
					itemDefinition.inventoryX = 1;
					itemDefinition.inventoryY = 1;
					itemDefinition.maleModel = 42638;
					itemDefinition.femaleModel = 42653;
					itemDefinition.groundOptions = new String[]
					{null, null, "Take", null, null};
					itemDefinition.inventoryOptions = new String[]
					{null, "Wear", null, null, "Destroy"};
				}
				break;
			case 11832:
				if (Client.toggleItems) {
					itemDefinition.name = "Vesta's chainbody";
					itemDefinition.inventoryModel = 42593;
					itemDefinition.zoom = 1440;
					itemDefinition.rotationY = 545;
					itemDefinition.rotationX = 2;
					itemDefinition.inventoryX = 4;
					itemDefinition.inventoryY = 5;
					itemDefinition.maleModel = 42624;
					itemDefinition.femaleModel = 42644;
					itemDefinition.groundOptions = new String[]
					{null, null, "Take", null, null};
					itemDefinition.inventoryOptions = new String[]
					{null, "Wear", null, null, "Destroy"};
				}
				break;
			case 11834:
				if (Client.toggleItems) {
					itemDefinition.name = "Vesta's plateskirt";
					itemDefinition.inventoryModel = 42581;
					itemDefinition.zoom = 1753;
					itemDefinition.rotationY = 562;
					itemDefinition.rotationX = 1;
					itemDefinition.inventoryX = -3;
					itemDefinition.inventoryY = 11;
					itemDefinition.maleModel = 42633;
					itemDefinition.femaleModel = 42649;
					itemDefinition.groundOptions = new String[]
					{null, null, "Take", null, null};
					itemDefinition.inventoryOptions = new String[]
					{null, "Wear", null, null, "Destroy"};
				}
				break;
			case 16308:
				itemDefinition.name = "Arcane spirit shield";
				itemDefinition.inventoryModel = 11310;
				itemDefinition.maleModel = 11050;
				itemDefinition.femaleModel = 11050;
				itemDefinition.zoom = 1600;
				itemDefinition.rotationX = 27;
				itemDefinition.rotationY = 396;
				itemDefinition.inventoryX = 4;
				itemDefinition.inventoryY = 13;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];
				colour = 50000;
				itemDefinition.modelColourToEdit[0] = 5594;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 5594 : colour;

				itemDefinition.modelColourToEdit[1] = 7101;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 7101 : colour;

				itemDefinition.modelColourToEdit[2] = 7079;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 7079 : colour;

				itemDefinition.modelColourToEdit[3] = 7104;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 7104 : colour;

				itemDefinition.modelColourToEdit[4] = 7056;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 7056 : colour;

				colour = 61093;
				itemDefinition.modelColourToEdit[5] = 111;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 111 : colour;
				break;
			case 16307:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Sigil colour
				colour = 0;
				itemDefinition.modelColourToEdit[1] = 127;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 127 : colour;

				// Shield colour
				colour = 58325;
				itemDefinition.modelColourToEdit[0] = -28716;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -28716 : colour;

				// Trim colour
				itemDefinition.modelColourToEdit[2] = -29116;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -29116 : colour;

				itemDefinition.modelColourToEdit[3] = -29019;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -29019 : colour;

				itemDefinition.modelColourToEdit[4] = -29125;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -29125 : colour;

				itemDefinition.modelColourToEdit[5] = -29110;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -29110 : colour;
				break;
			case 16306:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Sigil colour
				colour = 305770;
				itemDefinition.modelColourToEdit[1] = 127;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 127 : colour;

				// Shield colour
				colour = 100;
				itemDefinition.modelColourToEdit[0] = -28716;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -28716 : colour;

				// Trim colour
				itemDefinition.modelColourToEdit[2] = -29116;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -29116 : colour;

				itemDefinition.modelColourToEdit[3] = -29019;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -29019 : colour;

				itemDefinition.modelColourToEdit[4] = -29125;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -29125 : colour;

				itemDefinition.modelColourToEdit[5] = -29110;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -29110 : colour;
				break;
			case 16305:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Sigil colour
				colour = 51136;
				itemDefinition.modelColourToEdit[1] = 127;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 127 : colour;

				// Shield colour
				colour = 100;
				itemDefinition.modelColourToEdit[0] = -28716;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -28716 : colour;

				// Trim colour
				colour = 51136;
				itemDefinition.modelColourToEdit[2] = -29116;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -29116 : colour;

				itemDefinition.modelColourToEdit[3] = -29019;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -29019 : colour;

				itemDefinition.modelColourToEdit[4] = -29125;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -29125 : colour;

				itemDefinition.modelColourToEdit[5] = -29110;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -29110 : colour;
				break;
			case 16314:
				itemDefinition.name = "Skotos";
				itemDefinition.inventoryModel = 65016;
				itemDefinition.maleModel = -1;
				itemDefinition.maleEquip2 = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.femaleEquip2 = -1;
				itemDefinition.zoom = 1168;
				itemDefinition.rotationY = 2012;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = null;
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = "Drop";

				itemDefinition.modelColourToEdit = new int[21];
				itemDefinition.newModelColourProduced = new int[21];
				colour = -1;
				itemDefinition.modelColourToEdit[0] = 8;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 8 : colour;

				itemDefinition.modelColourToEdit[1] = 16;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 16 : colour;

				itemDefinition.modelColourToEdit[2] = 20;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 20 : colour;

				itemDefinition.modelColourToEdit[4] = 28;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 28 : colour;

				itemDefinition.modelColourToEdit[5] = 33;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 33 : colour;

				itemDefinition.modelColourToEdit[6] = 24;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 24 : colour;

				itemDefinition.modelColourToEdit[7] = 37;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 37 : colour;

				itemDefinition.modelColourToEdit[9] = 0;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? 0 : colour;

				itemDefinition.modelColourToEdit[14] = 12;
				itemDefinition.newModelColourProduced[14] = colour == -1 ? 12 : colour;

				colour = 927;
				itemDefinition.modelColourToEdit[8] = -15590;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -15590 : colour;

				itemDefinition.modelColourToEdit[3] = -15470;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -15470 : colour;

				itemDefinition.modelColourToEdit[10] = -15829;
				itemDefinition.newModelColourProduced[10] = colour == -1 ? -15829 : colour;

				itemDefinition.modelColourToEdit[11] = -16448;
				itemDefinition.newModelColourProduced[11] = colour == -1 ? -16448 : colour;

				itemDefinition.modelColourToEdit[12] = -18154;
				itemDefinition.newModelColourProduced[12] = colour == -1 ? -18154 : colour;

				itemDefinition.modelColourToEdit[13] = -15930;
				itemDefinition.newModelColourProduced[13] = colour == -1 ? -15930 : colour;

				itemDefinition.modelColourToEdit[15] = -15846;
				itemDefinition.newModelColourProduced[15] = colour == -1 ? -15846 : colour;

				itemDefinition.modelColourToEdit[16] = -15709;
				itemDefinition.newModelColourProduced[16] = colour == -1 ? -15709 : colour;

				itemDefinition.modelColourToEdit[17] = -15821;
				itemDefinition.newModelColourProduced[17] = colour == -1 ? -15821 : colour;

				itemDefinition.modelColourToEdit[18] = -15936;
				itemDefinition.newModelColourProduced[18] = colour == -1 ? -15936 : colour;

				itemDefinition.modelColourToEdit[19] = -15424;
				itemDefinition.newModelColourProduced[19] = colour == -1 ? -15424 : colour;

				itemDefinition.modelColourToEdit[20] = -15949;
				itemDefinition.newModelColourProduced[20] = colour == -1 ? -15949 : colour;
				break;
			case 16309:
				itemDefinition.name = "Bandos tassets";
				itemDefinition.inventoryModel = 28047;
				itemDefinition.maleModel = 27625;
				itemDefinition.femaleModel = 27640;
				itemDefinition.zoom = 854;
				itemDefinition.rotationX = 2039;
				itemDefinition.rotationY = 540;
				itemDefinition.inventoryX = 3;
				itemDefinition.inventoryY = 3;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[7];
				itemDefinition.newModelColourProduced = new int[7];


				green = 926;
				red = 926;
				yellow = 940;
				blue = 915;

				colour = -1;
				itemDefinition.modelColourToEdit[0] = 4550;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 4550 : colour;

				colour = red;
				itemDefinition.modelColourToEdit[1] = 22;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 22 : colour;

				colour = red;
				itemDefinition.modelColourToEdit[2] = 163;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 163 : colour;

				colour = red;
				itemDefinition.modelColourToEdit[3] = 154;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 154 : colour;

				colour = blue;
				itemDefinition.modelColourToEdit[4] = 39;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 39 : colour;

				colour = yellow;
				itemDefinition.modelColourToEdit[5] = 9523;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 9523 : colour;

				colour = green;
				itemDefinition.modelColourToEdit[6] = 8390;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 8390 : colour;
				break;

			case 16310:
				itemDefinition.name = "Berserker ring (i)";
				itemDefinition.inventoryModel = 21847;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 600;
				itemDefinition.rotationX = 1916;
				itemDefinition.rotationY = 324;
				itemDefinition.inventoryX = 3;
				itemDefinition.inventoryY = -15;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = "Uncharge";
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[13];
				itemDefinition.newModelColourProduced = new int[13];
				colour = 10;
				itemDefinition.modelColourToEdit[0] = 127;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 127 : colour;

				colour = 10;
				itemDefinition.modelColourToEdit[1] = -22407;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22407 : colour;

				itemDefinition.modelColourToEdit[2] = -23323;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -23323 : colour;

				itemDefinition.modelColourToEdit[3] = -22308;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -22308 : colour;

				colour = 10;
				itemDefinition.modelColourToEdit[4] = -22190;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -22190 : colour;

				itemDefinition.modelColourToEdit[5] = -21269;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -21269 : colour;

				itemDefinition.modelColourToEdit[6] = -22417;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -22417 : colour;

				colour = 12;
				itemDefinition.modelColourToEdit[7] = 11224;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 11224 : colour;

				itemDefinition.modelColourToEdit[8] = 11212;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? 11212 : colour;

				itemDefinition.modelColourToEdit[9] = 9009;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? 9009 : colour;

				itemDefinition.modelColourToEdit[10] = 9158;
				itemDefinition.newModelColourProduced[10] = colour == -1 ? 9158 : colour;

				itemDefinition.modelColourToEdit[11] = -25487;
				itemDefinition.newModelColourProduced[11] = colour == -1 ? -25487 : colour;

				itemDefinition.modelColourToEdit[12] = 7502;
				itemDefinition.newModelColourProduced[12] = colour == -1 ? 7502 : colour;
				break;
			case 16311:
				itemDefinition.name = "Dragon claws";
				itemDefinition.femaleModel = 29191;
				itemDefinition.femaleEquipOffset = 6;
				itemDefinition.inventoryOptions = new String[]
				{null, "Wear", null, null, null};
				itemDefinition.inventoryModel = 32784;
				itemDefinition.maleModel = 29191;
				itemDefinition.rotationY = 349;
				itemDefinition.inventoryX = 0;
				itemDefinition.rotationX = 15;
				itemDefinition.inventoryY = 8;
				itemDefinition.zoom = 886;

				itemDefinition.modelColourToEdit = new int[4];
				itemDefinition.newModelColourProduced = new int[4];
				colour = 36680;
				itemDefinition.modelColourToEdit[0] = 929;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 929 : colour;

				itemDefinition.modelColourToEdit[2] = 918;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 918 : colour;

				colour = 127;
				itemDefinition.modelColourToEdit[1] = 922;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 922 : colour;

				itemDefinition.modelColourToEdit[3] = 914;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 914 : colour;
				break;

			case 16312:
				itemDefinition.name = "Dragon claws";
				itemDefinition.femaleModel = 29191;
				itemDefinition.femaleEquipOffset = 6;
				itemDefinition.inventoryOptions = new String[]
				{null, "Wear", null, null, null};
				itemDefinition.inventoryModel = 32784;
				itemDefinition.maleModel = 29191;
				itemDefinition.rotationY = 349;
				itemDefinition.inventoryX = 0;
				itemDefinition.rotationX = 15;
				itemDefinition.inventoryY = 8;
				itemDefinition.zoom = 886;

				itemDefinition.modelColourToEdit = new int[4];
				itemDefinition.newModelColourProduced = new int[4];
				colour = 51120;
				itemDefinition.modelColourToEdit[0] = 929;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 929 : colour;

				itemDefinition.modelColourToEdit[1] = 922;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 922 : colour;

				itemDefinition.modelColourToEdit[2] = 918;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 918 : colour;

				itemDefinition.modelColourToEdit[3] = 914;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 914 : colour;
				break;

			case 16313:
				itemDefinition.name = "Arcane spirit shield";
				itemDefinition.inventoryModel = 11310;
				itemDefinition.maleModel = 11050;
				itemDefinition.femaleModel = 11050;
				itemDefinition.zoom = 1600;
				itemDefinition.rotationX = 27;
				itemDefinition.rotationY = 396;
				itemDefinition.inventoryX = 4;
				itemDefinition.inventoryY = 13;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];
				colour = 36680;
				itemDefinition.modelColourToEdit[0] = 5594;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 5594 : colour;

				itemDefinition.modelColourToEdit[1] = 7101;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 7101 : colour;

				itemDefinition.modelColourToEdit[2] = 7079;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 7079 : colour;

				itemDefinition.modelColourToEdit[3] = 7104;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 7104 : colour;

				itemDefinition.modelColourToEdit[4] = 7056;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 7056 : colour;

				colour = 127;
				itemDefinition.modelColourToEdit[5] = 111;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 111 : colour;
				break;


			case 4687:
				itemDefinition.name = "Bucket of chocolate";
				itemDefinition.description = "A bucket of warm, melted chocolate.".getBytes();
				break;

			case 16297:
				itemDefinition.name = "Elder maul";
				itemDefinition.inventoryModel = 32792;
				itemDefinition.maleModel = 32678;
				itemDefinition.femaleModel = 32678;
				itemDefinition.zoom = 1744;
				itemDefinition.rotationX = 429;
				itemDefinition.rotationY = 237;
				itemDefinition.inventoryX = -3;
				itemDefinition.inventoryY = -58;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				break;
			case 16889:
				itemDefinition.name = "Smoker Pipe";
				itemDefinition.inventoryModel = 50115;
				itemDefinition.maleModel = 18489;
				itemDefinition.femaleModel = 18489;
				itemDefinition.zoom = 2500;
				itemDefinition.rotationX = 200;
				itemDefinition.rotationY = 0;
				itemDefinition.inventoryX = 15;
				itemDefinition.inventoryY = -0;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.description = "You detect the smell of Marijuana... Oh no! I hope the Guards don't see...".getBytes();
				break;
			case 16890:
				npcInstance = EntityDefinition.forId(114);
				itemDefinition.name = "Ajax Pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Leash"};
				itemDefinition.zoom = 2400;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 200;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16298:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Sigil colour
				colour = 926;
				itemDefinition.modelColourToEdit[1] = 127;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 127 : colour;

				// Shield colour
				colour = 302770;
				itemDefinition.modelColourToEdit[0] = -28716;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -28716 : colour;

				// Trim colour
				colour = 347770;
				itemDefinition.modelColourToEdit[2] = -29116;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -29116 : colour;

				itemDefinition.modelColourToEdit[3] = -29019;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -29019 : colour;

				itemDefinition.modelColourToEdit[4] = -29125;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -29125 : colour;

				itemDefinition.modelColourToEdit[5] = -29110;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -29110 : colour;
				break;

			case 16299:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Sigil colour
				colour = 51136;
				itemDefinition.modelColourToEdit[1] = 127;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 127 : colour;

				// Shield colour
				colour = 127;
				itemDefinition.modelColourToEdit[0] = -28716;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -28716 : colour;

				// Trim colour
				colour = 127;
				itemDefinition.modelColourToEdit[2] = -29116;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -29116 : colour;

				itemDefinition.modelColourToEdit[3] = -29019;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -29019 : colour;

				itemDefinition.modelColourToEdit[4] = -29125;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -29125 : colour;

				itemDefinition.modelColourToEdit[5] = -29110;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -29110 : colour;
				break;
			case 16300:
				itemDefinition.name = "Ancestral robe top";
				itemDefinition.inventoryModel = 32790;
				itemDefinition.maleModel = 32657;
				itemDefinition.maleEquip2 = 32658;
				itemDefinition.femaleModel = 32664;
				itemDefinition.femaleEquip2 = 32665;
				itemDefinition.femaleModel = 32664;
				itemDefinition.zoom = 1358;
				itemDefinition.rotationX = 2041;
				itemDefinition.rotationY = 514;
				itemDefinition.inventoryY = -3;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[11];
				itemDefinition.newModelColourProduced = new int[11];

				// Light biege
				colour = 87750;
				itemDefinition.modelColourToEdit[0] = 6348;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 6348 : colour;

				// Grey
				colour = 87760;
				itemDefinition.modelColourToEdit[1] = -16318;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -16318 : colour;

				// Biege
				colour = 87760;
				itemDefinition.modelColourToEdit[2] = 6331;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 6331 : colour;

				// Purple
				colour = 51136;
				itemDefinition.modelColourToEdit[3] = -22225;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -22225 : colour;

				// Orange
				colour = 926;
				itemDefinition.modelColourToEdit[4] = 7108;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 7108 : colour;

				// Dark purple
				colour = 51136;
				itemDefinition.modelColourToEdit[5] = -22235;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22235 : colour;

				// Dark grey
				colour = 87760;
				itemDefinition.modelColourToEdit[6] = -16327;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -16327 : colour;

				// Dark purple
				colour = 51136;
				itemDefinition.modelColourToEdit[7] = -22231;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -16327 : colour;

				// Dark grey
				colour = 87760;
				itemDefinition.modelColourToEdit[8] = -16339;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -16327 : colour;

				// Biege stripe across chest from shoulders to waist
				colour = 926;
				itemDefinition.modelColourToEdit[9] = 6323;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? -16327 : colour;

				// Belt rope colour
				colour = 20;
				itemDefinition.modelColourToEdit[10] = 5268;
				itemDefinition.newModelColourProduced[10] = colour == -1 ? -16327 : colour;
				break;
			case 16389:
				itemDefinition.name = "Blood Rapier";
				itemDefinition.inventoryModel = 35739;
				itemDefinition.maleModel = 35374;
				itemDefinition.femaleModel = 35369;
				itemDefinition.zoom = 2064;
				itemDefinition.rotationX = 1603;
				itemDefinition.rotationZ = 552;
				itemDefinition.inventoryX = 5;
				itemDefinition.inventoryY = -18;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = "Drop";

				itemDefinition.modelColourToEdit = new int[8];
				itemDefinition.newModelColourProduced = new int[8];

				colour = -1;
				itemDefinition.modelColourToEdit[2] = -22446;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22446 : colour;

				itemDefinition.modelColourToEdit[4] = -22423;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -22423 : colour;

				colour = 927;
				itemDefinition.modelColourToEdit[0] = -1122;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -1122 : colour;

				itemDefinition.modelColourToEdit[3] = -22502;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -22502 : colour;

				itemDefinition.modelColourToEdit[6] = -22477;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -22477 : colour;

				itemDefinition.modelColourToEdit[7] = -22506;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -22506 : colour;

				itemDefinition.modelColourToEdit[5] = -22489;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22489 : colour;

				itemDefinition.modelColourToEdit[1] = -22386;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22386 : colour;
				break;
			case 19515:
				itemInstance = ItemDefinition.forId(6607);
				itemDefinition.inventoryOptions = new String[]
						{null, "Wield", null, null, null};
				itemDefinition.name = "Blood Longsword";
				itemDefinition.zoom = itemInstance.zoom;
				itemDefinition.maleEquip2 = itemInstance.maleEquip2;
				itemDefinition.femaleEquip2 = itemInstance.femaleEquip2;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.maleModel = itemInstance.maleModel;
				itemDefinition.femaleModel = itemInstance.femaleModel;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.inventoryModel = itemInstance.inventoryModel;
				break;
			case 19517:
				itemInstance = ItemDefinition.forId(6609);
				itemDefinition.inventoryOptions = new String[]
						{null, "Wield", null, null, null};
				itemDefinition.name = "Blood Maul";
				itemDefinition.zoom = itemInstance.zoom;
				itemDefinition.maleEquip2 = itemInstance.maleEquip2;
				itemDefinition.femaleEquip2 = itemInstance.femaleEquip2;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.maleModel = itemInstance.maleModel;
				itemDefinition.femaleModel = itemInstance.femaleModel;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.inventoryModel = itemInstance.inventoryModel;
				break;
			case 16907:
				itemDefinition.name = "Volatile Nightmare Staff";
				itemDefinition.femaleModel = 39066;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.inventoryModel = 65339;
				itemDefinition.maleModel = 65340;
				itemDefinition.zoom = 2064;
				itemDefinition.rotationX = 1050;
				itemDefinition.rotationY = 404;
				itemDefinition.inventoryY = 13;
				itemDefinition.inventoryX = -5;
				break;
			case 16908:
				itemDefinition.name = "24-Carat Sword";
				itemDefinition.femaleModel = 65342;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.inventoryModel = 65344;
				itemDefinition.maleModel = 65343;
				itemDefinition.zoom = 1894;
				itemDefinition.rotationX = 989;
				itemDefinition.rotationY = 323;
				itemDefinition.inventoryY = 33;
				itemDefinition.inventoryX = 6;
				itemDefinition.modelColourToEdit = new int[]
						{5838, 5830, 5821};
				itemDefinition.newModelColourProduced = new int[]
						{9143, 9139, 9133};
				break;
			
			case 16909:
				itemDefinition.name = "Carrot Sword";
				itemDefinition.femaleModel = 65342;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.inventoryModel = 65344;
				itemDefinition.maleModel = 65343;
				itemDefinition.zoom = 1894;
				itemDefinition.rotationX = 989;
				itemDefinition.rotationY = 323;
				itemDefinition.inventoryY = 33;
				itemDefinition.inventoryX = 6;
				break;
			
			case 16910:
				itemDefinition.name = "Bunnyman Mask";
				itemDefinition.femaleModel = 65345;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.inventoryModel = 65346;
				itemDefinition.maleModel = 65347;
				itemDefinition.zoom = 1621;
				itemDefinition.rotationX = 202;
				itemDefinition.rotationY = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryX = 5;
				break;
				
			case 16911:
				itemDefinition.name = "Painted Fake Magic Egg";
				itemDefinition.inventoryModel = 65348;
				itemDefinition.zoom = 1080;
				itemDefinition.rotationX = 20;
				itemDefinition.rotationY = 2044;
				break;
				
			case 16912:
				itemDefinition.name = "Unainted Fake Magic Egg";
				itemDefinition.inventoryModel = 65348;
				itemDefinition.zoom = 1080;
				itemDefinition.rotationX = 20;
				itemDefinition.rotationY = 2044;
				itemDefinition.modelColourToEdit = new int[]
						{7859, 7874, 7876, 7878, 7872};
				itemDefinition.newModelColourProduced = new int[]
						{10343, 10345, 111, 115, 10345};
				break;
			
			case 16913:
				itemDefinition.name = "Bunnyman Mask (w)";
				itemDefinition.femaleModel = 65345;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.inventoryModel = 65346;
				itemDefinition.maleModel = 65347;
				itemDefinition.zoom = 1621;
				itemDefinition.rotationX = 202;
				itemDefinition.rotationY = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryX = 5;
				itemDefinition.modelColourToEdit = new int[]
						{2378};
				itemDefinition.newModelColourProduced = new int[]
						{90};
				break;
				
			case 16914:
				itemDefinition.name = "Bunnyman Mask (b)";
				itemDefinition.femaleModel = 65345;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.inventoryModel = 65346;
				itemDefinition.maleModel = 65347;
				itemDefinition.zoom = 1621;
				itemDefinition.rotationX = 202;
				itemDefinition.rotationY = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryX = 5;
				itemDefinition.modelColourToEdit = new int[]
						{2378};
				itemDefinition.newModelColourProduced = new int[]
						{900};
				break;
				
			case 16915:
				itemDefinition.name = "Bunnyman Mask (r)";
				itemDefinition.femaleModel = 65345;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.inventoryModel = 65346;
				itemDefinition.maleModel = 65347;
				itemDefinition.zoom = 1621;
				itemDefinition.rotationX = 202;
				itemDefinition.rotationY = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryX = 5;
				itemDefinition.modelColourToEdit = new int[]
						{2378};
				itemDefinition.newModelColourProduced = new int[]
						{800};
				break;
				
			case 16916:
				itemDefinition.name = "Bunnyman Mask (y)";
				itemDefinition.femaleModel = 65345;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.inventoryModel = 65346;
				itemDefinition.maleModel = 65347;
				itemDefinition.zoom = 1621;
				itemDefinition.rotationX = 202;
				itemDefinition.rotationY = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryX = 5;
				itemDefinition.modelColourToEdit = new int[]
						{2378};
				itemDefinition.newModelColourProduced = new int[]
						{9139};
				break;	
			case 16917:
				npcInstance = EntityDefinition.forId(762);
				itemDefinition.name = "Yveltal Pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Choose"};
				itemDefinition.zoom = 3320;
				itemDefinition.rotationY = 160;
				itemDefinition.rotationX = 350;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = -8;
				itemDefinition.inventoryModel = 65349;
				break;
			case 16918:
				npcInstance = EntityDefinition.forId(762);
				itemDefinition.name = "Yveltal Pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Choose"};
				itemDefinition.zoom = 3320;
				itemDefinition.rotationY = 160;
				itemDefinition.rotationX = 350;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = 65349;
				break;
			case 16919:
				npcInstance = EntityDefinition.forId(3665);
				itemDefinition.name = "Pet Rabbit";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 950;
				itemDefinition.rotationY = 160;
				itemDefinition.rotationX = 350;
				itemDefinition.inventoryX = -5;
				itemDefinition.inventoryY = -9;
				itemDefinition.inventoryModel = 23901;
				itemDefinition.modelColourToEdit = new int[]
						{5413, 5417, 5421};
				itemDefinition.newModelColourProduced = new int[]
						{5210, 5330, 5322};
				break;
			
				case 16210:
				itemDefinition.name = "Vampyre claws";
				itemDefinition.femaleModel = 29191;
				itemDefinition.femaleEquipOffset = 6;
				itemDefinition.inventoryOptions = new String[]
						{null, "Wear", null, null, null};
				itemDefinition.inventoryModel = 32784;
				itemDefinition.maleModel = 29191;
				itemDefinition.rotationY = 349;
				itemDefinition.inventoryX = 0;
				itemDefinition.rotationX = 15;
				itemDefinition.inventoryY = 8;
				itemDefinition.zoom = 886;
				itemDefinition.modelColourToEdit = new int[]
						{929, 922, 918, 914};
				itemDefinition.newModelColourProduced = new int[]
						{5, 5, 5, 5};
				break;
			
			case 16301:
				itemDefinition.name = "Ancestral robe bottom";
				itemDefinition.inventoryModel = 32787;
				itemDefinition.maleModel = 32653;
				itemDefinition.maleEquip2 = -1;
				itemDefinition.femaleModel = 32662;
				itemDefinition.femaleEquip2 = -1;
				itemDefinition.zoom = 1690;
				itemDefinition.rotationX = 9;
				itemDefinition.rotationY = 435;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = 7;
				itemDefinition.brightness = 30;
				itemDefinition.contrast = 100;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[10];
				itemDefinition.newModelColourProduced = new int[10];

				// Light biege
				colour = 87760;
				itemDefinition.modelColourToEdit[0] = 6348;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 6348 : colour;

				// Grey
				colour = 87760;
				itemDefinition.modelColourToEdit[1] = -16318;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -16318 : colour;

				// Biege
				colour = 87760;
				itemDefinition.modelColourToEdit[2] = 6331;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 6331 : colour;

				// Purple
				colour = 51136;
				itemDefinition.modelColourToEdit[3] = -22225;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -22225 : colour;

				// Orange
				colour = 926;
				itemDefinition.modelColourToEdit[4] = 7108;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 7108 : colour;

				// Dark purple
				colour = 51136;
				itemDefinition.modelColourToEdit[5] = -22235;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22235 : colour;

				// Dark grey
				colour = 87760;
				itemDefinition.modelColourToEdit[6] = -16327;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -16327 : colour;

				// Dark purple
				colour = 51136;
				itemDefinition.modelColourToEdit[7] = -22231;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -16327 : colour;

				// Dark grey
				colour = 87760;
				itemDefinition.modelColourToEdit[8] = -16339;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -16327 : colour;

				// Biege stripe across chest from shoulders to waist
				colour = 926;
				itemDefinition.modelColourToEdit[9] = 6323;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? -16327 : colour;
				break;
			case 16302:
				itemDefinition.name = "Bandos tassets";
				itemDefinition.inventoryModel = 28047;
				itemDefinition.maleModel = 27625;
				itemDefinition.femaleModel = 27640;
				itemDefinition.zoom = 854;
				itemDefinition.rotationX = 2039;
				itemDefinition.rotationY = 540;
				itemDefinition.inventoryX = 3;
				itemDefinition.inventoryY = 3;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[7];
				itemDefinition.newModelColourProduced = new int[7];


				green = 10;
				red = 10;
				yellow = 933;
				blue = 51136;

				colour = -1;
				itemDefinition.modelColourToEdit[0] = 4550;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 4550 : colour;

				colour = red;
				itemDefinition.modelColourToEdit[1] = 22;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 22 : colour;

				colour = red;
				itemDefinition.modelColourToEdit[2] = 163;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 163 : colour;

				colour = red;
				itemDefinition.modelColourToEdit[3] = 154;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 154 : colour;

				colour = blue;
				itemDefinition.modelColourToEdit[4] = 39;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 39 : colour;

				colour = yellow;
				itemDefinition.modelColourToEdit[5] = 9523;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 9523 : colour;

				colour = green;
				itemDefinition.modelColourToEdit[6] = 8390;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 8390 : colour;
				break;

			case 16303:
				itemDefinition.name = "Abyssal tentacle";
				itemDefinition.inventoryModel = 28439;
				itemDefinition.maleModel = 28446;
				itemDefinition.femaleModel = 28446;
				itemDefinition.zoom = 840;
				itemDefinition.rotationX = 121;
				itemDefinition.rotationY = 280;
				itemDefinition.inventoryY = 56;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = "Check";
				itemDefinition.inventoryOptions[4] = "Dissolve";

				itemDefinition.modelColourToEdit = new int[3];
				itemDefinition.newModelColourProduced = new int[3];

				// Stripe colour
				colour = 51136;
				itemDefinition.modelColourToEdit[0] = 11150;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -22208 : colour;

				// Not used
				itemDefinition.modelColourToEdit[1] = 9108;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22477 : colour;

				// Spikes colour
				colour = 0;
				itemDefinition.modelColourToEdit[2] = 10355;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22464 : colour;
				break;
			case 16304:
				itemDefinition.name = "Elder maul";
				itemDefinition.inventoryModel = 32792;
				itemDefinition.maleModel = 32678;
				itemDefinition.femaleModel = 32678;
				itemDefinition.zoom = 1744;
				itemDefinition.rotationX = 429;
				itemDefinition.rotationY = 237;
				itemDefinition.inventoryX = -3;
				itemDefinition.inventoryY = -58;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				break;

			// Dark purple Elysian shield
			case 16296:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Sigil colour
				colour = 51136;
				itemDefinition.modelColourToEdit[1] = 127;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 127 : colour;

				// Shield colour
				itemDefinition.modelColourToEdit[0] = -28716;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -28716 : colour;

				itemDefinition.modelColourToEdit[2] = -29116;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -29116 : colour;

				itemDefinition.modelColourToEdit[3] = -29019;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -29019 : colour;

				itemDefinition.modelColourToEdit[4] = -29125;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -29125 : colour;

				itemDefinition.modelColourToEdit[5] = -29110;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -29110 : colour;
				break;
			// Red Elysian spirit shield with white sigil and yellow trim
			case 16295:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Sigil colour
				colour = 127;
				itemDefinition.modelColourToEdit[1] = 127;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 127 : colour;

				// Shield colour
				colour = 927;
				itemDefinition.modelColourToEdit[0] = -28716;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -28716 : colour;

				// Trim colour
				colour = 8128;
				itemDefinition.modelColourToEdit[2] = -29116;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -29116 : colour;

				itemDefinition.modelColourToEdit[3] = -29019;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -29019 : colour;

				itemDefinition.modelColourToEdit[4] = -29125;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -29125 : colour;

				itemDefinition.modelColourToEdit[5] = -29110;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -29110 : colour;
				break;


			// Dark Blue Elysian Spirit Shield with Red sigal
			case 16294:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Sigil colour
				colour = 927;
				itemDefinition.modelColourToEdit[1] = 127;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 127 : colour;

				// Shield colour
				colour = 302770;
				itemDefinition.modelColourToEdit[0] = -28716;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -28716 : colour;

				itemDefinition.modelColourToEdit[2] = -29116;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -29116 : colour;

				itemDefinition.modelColourToEdit[3] = -29019;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -29019 : colour;

				itemDefinition.modelColourToEdit[4] = -29125;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -29125 : colour;

				itemDefinition.modelColourToEdit[5] = -29110;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -29110 : colour;
				break;

			case 16293:
				itemDefinition.name = "Bandos tassets";
				itemDefinition.inventoryModel = 28047;
				itemDefinition.maleModel = 27625;
				itemDefinition.femaleModel = 27640;
				itemDefinition.zoom = 854;
				itemDefinition.rotationX = 2039;
				itemDefinition.rotationY = 540;
				itemDefinition.inventoryX = 3;
				itemDefinition.inventoryY = 3;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[7];
				itemDefinition.newModelColourProduced = new int[7];
				green = 34770;
				red = 302770;
				yellow = 8128;
				blue = 927;

				colour = -1;
				itemDefinition.modelColourToEdit[0] = 4550;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 4550 : colour;

				colour = red;
				itemDefinition.modelColourToEdit[1] = 22;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 22 : colour;

				colour = red;
				itemDefinition.modelColourToEdit[2] = 163;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 163 : colour;

				colour = red;
				itemDefinition.modelColourToEdit[3] = 154;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 154 : colour;

				colour = blue;
				itemDefinition.modelColourToEdit[4] = 39;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 39 : colour;

				colour = yellow;
				itemDefinition.modelColourToEdit[5] = 9523;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 9523 : colour;

				colour = green;
				itemDefinition.modelColourToEdit[6] = 8390;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 8390 : colour;
				break;

			case 16292:
				itemDefinition.name = "Bandos chestplate";
				itemDefinition.inventoryModel = 28042;
				itemDefinition.maleModel = 27636;
				itemDefinition.femaleModel = 27644;
				itemDefinition.zoom = 984;
				itemDefinition.rotationX = 6;
				itemDefinition.rotationY = 501;
				itemDefinition.inventoryX = 1;
				itemDefinition.inventoryY = 4;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[15];
				itemDefinition.newModelColourProduced = new int[15];

				//Red yellow green blue

				green = 34770;
				red = 302770;
				yellow = 8128;
				blue = 927;
				// Light brown
				colour = green;
				itemDefinition.modelColourToEdit[0] = 8367;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 8367 : colour;

				// Light brown
				colour = green;
				itemDefinition.modelColourToEdit[1] = 8384;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 8384 : colour;

				// Light brown
				colour = green;
				itemDefinition.modelColourToEdit[2] = 8375;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 8375 : colour;

				// Brown
				colour = blue;
				itemDefinition.modelColourToEdit[3] = 10266;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 10266 : colour;

				// Light brown
				colour = green;
				itemDefinition.modelColourToEdit[4] = 9523;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 9523 : colour;

				// Unknown
				colour = -1;
				itemDefinition.modelColourToEdit[5] = 10502;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 10502 : colour;

				// Light brown
				colour = green;
				itemDefinition.modelColourToEdit[6] = 9515;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 9515 : colour;

				// Unknown
				colour = -1;
				itemDefinition.modelColourToEdit[7] = 4550;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 4550 : colour;

				// Dark brown
				colour = yellow;
				itemDefinition.modelColourToEdit[8] = 142;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? 142 : colour;

				// Brown
				colour = yellow;
				itemDefinition.modelColourToEdit[9] = 163;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? 163 : colour;

				// Brown
				colour = red;
				itemDefinition.modelColourToEdit[10] = 22;
				itemDefinition.newModelColourProduced[10] = colour == -1 ? 22 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[11] = 9403;
				itemDefinition.newModelColourProduced[11] = colour == -1 ? 9403 : colour;

				// Dark brown
				colour = yellow;
				itemDefinition.modelColourToEdit[12] = 8076;
				itemDefinition.newModelColourProduced[12] = colour == -1 ? 8076 : colour;

				// Brown
				colour = green;
				itemDefinition.modelColourToEdit[13] = 10275;
				itemDefinition.newModelColourProduced[13] = colour == -1 ? 10275 : colour;

				// Brown
				colour = green;
				itemDefinition.modelColourToEdit[14] = 8379;
				itemDefinition.newModelColourProduced[14] = colour == -1 ? 8379 : colour;
				break;
			case 16291:
				itemDefinition.name = "Dragon claws";
				itemDefinition.femaleModel = 29191;
				itemDefinition.femaleEquipOffset = 6;
				itemDefinition.inventoryOptions = new String[]
				{null, "Wear", null, null, null};
				itemDefinition.inventoryModel = 32784;
				itemDefinition.maleModel = 29191;
				itemDefinition.rotationY = 349;
				itemDefinition.inventoryX = 0;
				itemDefinition.rotationX = 15;
				itemDefinition.inventoryY = 8;
				itemDefinition.zoom = 886;

				itemDefinition.modelColourToEdit = new int[4];
				itemDefinition.newModelColourProduced = new int[4];
				colour = 34770;
				itemDefinition.modelColourToEdit[0] = 929;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 929 : colour;

				colour = 0;
				itemDefinition.modelColourToEdit[1] = 922;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 922 : colour;

				colour = 34770;
				itemDefinition.modelColourToEdit[2] = 918;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 918 : colour;

				colour = 0;
				itemDefinition.modelColourToEdit[3] = 914;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 914 : colour;
				break;
			case 16290:
				itemDefinition.name = "Primordial boots";
				itemDefinition.inventoryModel = 29397;
				itemDefinition.maleModel = 29250;
				itemDefinition.maleEquip2 = -1;
				itemDefinition.femaleModel = 29255;
				itemDefinition.femaleEquip2 = -1;
				itemDefinition.zoom = 976;
				itemDefinition.rotationX = 279;
				itemDefinition.rotationY = 147;
				itemDefinition.inventoryX = 5;
				itemDefinition.inventoryY = -5;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[8];
				itemDefinition.newModelColourProduced = new int[8];

				// Dark red
				colour = 34750;
				itemDefinition.modelColourToEdit[0] = 280;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 280 : colour;

				// Red
				colour = 34760;
				itemDefinition.modelColourToEdit[1] = 924;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 924 : colour;

				// Red
				colour = 34770;
				itemDefinition.modelColourToEdit[2] = 920;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 920 : colour;

				// Very dark grey
				colour = 5;
				itemDefinition.modelColourToEdit[6] = 520;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 520 : colour;

				// Dark grey
				colour = 10;
				itemDefinition.modelColourToEdit[5] = -22380;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22380 : colour;


				// Grey
				colour = 15;
				itemDefinition.modelColourToEdit[3] = -22370;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -22370 : colour;

				// Red
				colour = -1;
				itemDefinition.modelColourToEdit[4] = 538;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 538 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[7] = 127;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 127 : colour;
				break;
			case 16289:
				itemDefinition.name = "Ancestral hat";
				itemDefinition.inventoryModel = 32794;
				itemDefinition.maleModel = 32655;
				itemDefinition.maleEquip2 = -1;
				itemDefinition.femaleModel = 32663;
				itemDefinition.femaleEquip2 = -1;
				itemDefinition.zoom = 1236;
				itemDefinition.rotationX = 10;
				itemDefinition.rotationY = 118;
				itemDefinition.inventoryY = -12;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[13];
				itemDefinition.newModelColourProduced = new int[13];

				// Orange
				colour = 8128;
				itemDefinition.modelColourToEdit[0] = 6973;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 6973 : colour;

				// Dark grey
				colour = -1;
				itemDefinition.modelColourToEdit[1] = -21992;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -21992 : colour;

				// Dark blue
				colour = -1;
				itemDefinition.modelColourToEdit[2] = -22235;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22235 : colour;

				// Brown
				colour = 0;
				itemDefinition.modelColourToEdit[5] = 5268;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 5268 : colour;

				// Dark biege
				colour = 34750;
				itemDefinition.modelColourToEdit[3] = 6323;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 6323 : colour;

				// Biege
				colour = 34760;
				itemDefinition.modelColourToEdit[4] = 6331;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 6331 : colour;

				// Biege
				colour = 34765;
				itemDefinition.modelColourToEdit[6] = 6340;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 6340 : colour;

				// Biege
				colour = 34770;
				itemDefinition.modelColourToEdit[7] = 6348;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 6348 : colour;

				// Biege
				colour = 34775;
				itemDefinition.modelColourToEdit[8] = 6356;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? 6356 : colour;

				// Biege
				colour = 34780;
				itemDefinition.modelColourToEdit[9] = 6364;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? 6364 : colour;

				// Biege
				colour = 34780;
				itemDefinition.modelColourToEdit[10] = 6798;
				itemDefinition.newModelColourProduced[10] = colour == -1 ? 6798 : colour;

				// Unknown
				colour = -1;
				itemDefinition.modelColourToEdit[11] = 4550;
				itemDefinition.newModelColourProduced[11] = colour == -1 ? 4550 : colour;

				// Unknown
				colour = -1;
				itemDefinition.modelColourToEdit[12] = 0;
				itemDefinition.newModelColourProduced[12] = colour == -1 ? 0 : colour;
				break;
				case 16288:
				itemDefinition.name = "Ancestral robe bottom";
				itemDefinition.inventoryModel = 32787;
				itemDefinition.maleModel = 32653;
				itemDefinition.maleEquip2 = -1;
				itemDefinition.femaleModel = 32662;
				itemDefinition.femaleEquip2 = -1;
				itemDefinition.zoom = 1690;
				itemDefinition.rotationX = 9;
				itemDefinition.rotationY = 435;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = 7;
				itemDefinition.brightness = 30;
				itemDefinition.contrast = 100;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[10];
				itemDefinition.newModelColourProduced = new int[10];

				// Light biege
				colour = 30;
				itemDefinition.modelColourToEdit[0] = 6348;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 6348 : colour;

				// Grey
				colour = 20;
				itemDefinition.modelColourToEdit[1] = -16318;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -16318 : colour;

				// Biege
				colour = 5;
				itemDefinition.modelColourToEdit[2] = 6331;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 6331 : colour;

				// Purple
				colour = 34770;
				itemDefinition.modelColourToEdit[3] = -22225;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -22225 : colour;

				// Orange
				colour = 7114;
				itemDefinition.modelColourToEdit[4] = 7108;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 7108 : colour;

				// Dark purple
				colour = 34770;
				itemDefinition.modelColourToEdit[5] = -22235;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22235 : colour;

				// Dark grey
				colour = 5;
				itemDefinition.modelColourToEdit[6] = -16327;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -16327 : colour;

				// Dark purple
				colour = 34770;
				itemDefinition.modelColourToEdit[7] = -22231;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -16327 : colour;

				// Dark grey
				colour = 5;
				itemDefinition.modelColourToEdit[8] = -16339;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -16327 : colour;

				// Biege stripe across chest from shoulders to waist
				colour = 7114;
				itemDefinition.modelColourToEdit[9] = 6323;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? -16327 : colour;
				break;
			case 16287:
				itemDefinition.name = "Ancestral robe top";
				itemDefinition.inventoryModel = 32790;
				itemDefinition.maleModel = 32657;
				itemDefinition.maleEquip2 = 32658;
				itemDefinition.femaleModel = 32664;
				itemDefinition.femaleEquip2 = 32665;
				itemDefinition.femaleModel = 32664;
				itemDefinition.zoom = 1358;
				itemDefinition.rotationX = 2041;
				itemDefinition.rotationY = 514;
				itemDefinition.inventoryY = -3;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[11];
				itemDefinition.newModelColourProduced = new int[11];

				// Light biege
				colour = 10;
				itemDefinition.modelColourToEdit[0] = 6348;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 6348 : colour;

				// Grey
				colour = 0;
				itemDefinition.modelColourToEdit[1] = -16318;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -16318 : colour;

				// Biege
				colour = 0;
				itemDefinition.modelColourToEdit[2] = 6331;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 6331 : colour;

				// Purple
				colour = 34770;
				itemDefinition.modelColourToEdit[3] = -22225;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -22225 : colour;

				// Orange
				colour = 7114;
				itemDefinition.modelColourToEdit[4] = 7108;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 7108 : colour;

				// Dark purple
				colour = 34770;
				itemDefinition.modelColourToEdit[5] = -22235;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22235 : colour;

				// Dark grey
				colour = 0;
				itemDefinition.modelColourToEdit[6] = -16327;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -16327 : colour;

				// Dark purple
				colour = 34770;
				itemDefinition.modelColourToEdit[7] = -22231;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -16327 : colour;

				// Dark grey
				colour = 0;
				itemDefinition.modelColourToEdit[8] = -16339;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -16327 : colour;

				// Biege stripe across chest from shoulders to waist
				colour = 7114;
				itemDefinition.modelColourToEdit[9] = 6323;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? -16327 : colour;

				// Belt rope colour
				colour = 20;
				itemDefinition.modelColourToEdit[10] = 5268;
				itemDefinition.newModelColourProduced[10] = colour == -1 ? -16327 : colour;
				break;
			case 16286:
				itemDefinition.name = "Mythical cape";
				itemDefinition.inventoryModel = 34418;
				itemDefinition.maleModel = 34271;
				itemDefinition.maleEquip2 = -1;
				itemDefinition.femaleModel = 34288;
				itemDefinition.femaleEquip2 = -1;
				itemDefinition.zoom = 1960;
				itemDefinition.rotationX = 1583;
				itemDefinition.rotationY = 528;
				itemDefinition.inventoryY = 2;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = "Teleport";
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[5];
				itemDefinition.newModelColourProduced = new int[5];
				colour = 5;
				itemDefinition.modelColourToEdit[0] = 929;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 929 : colour;

				colour = 127;
				itemDefinition.modelColourToEdit[1] = -918;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -918 : colour;

				colour = 15;
				itemDefinition.modelColourToEdit[2] = 922;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 922 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[3] = 914;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 914 : colour;

				colour = 10;
				itemDefinition.modelColourToEdit[4] = 914;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 914 : colour;
				break;
			// Cyan Abyssal tentacle
			case 16285:
				itemDefinition.name = "Abyssal tentacle";
				itemDefinition.inventoryModel = 28439;
				itemDefinition.maleModel = 28446;
				itemDefinition.femaleModel = 28446;
				itemDefinition.zoom = 840;
				itemDefinition.rotationX = 121;
				itemDefinition.rotationY = 280;
				itemDefinition.inventoryY = 56;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = "Check";
				itemDefinition.inventoryOptions[4] = "Dissolve";

				itemDefinition.modelColourToEdit = new int[3];
				itemDefinition.newModelColourProduced = new int[3];

				// Stripe colour
				colour = 34770;
				itemDefinition.modelColourToEdit[0] = 11150;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -22208 : colour;

				// Not used
				itemDefinition.modelColourToEdit[1] = 9108;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22477 : colour;

				// Spikes colour
				colour = 0;
				itemDefinition.modelColourToEdit[2] = 10355;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22464 : colour;
				break;

			// Black Elysian spirit shield with cyan sigil
			case 16284:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Sigil colour
				colour = 34770;
				itemDefinition.modelColourToEdit[1] = 127;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 127 : colour;

				// Shield colour
				colour = 0;
				itemDefinition.modelColourToEdit[0] = -28716;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -28716 : colour;

				colour = 127;
				itemDefinition.modelColourToEdit[2] = -29116;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -29116 : colour;

				colour = 127;
				itemDefinition.modelColourToEdit[3] = -29019;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -29019 : colour;

				colour = 127;
				itemDefinition.modelColourToEdit[4] = -29125;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -29125 : colour;

				colour = 127;
				itemDefinition.modelColourToEdit[5] = -29110;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -29110 : colour;
				break;

			// Purple shield and red sigil
			case 16283:
				itemDefinition.name = "Arcane spirit shield";
				itemDefinition.inventoryModel = 11310;
				itemDefinition.maleModel = 11050;
				itemDefinition.femaleModel = 11050;
				itemDefinition.zoom = 1600;
				itemDefinition.rotationX = 27;
				itemDefinition.rotationY = 396;
				itemDefinition.inventoryX = 4;
				itemDefinition.inventoryY = 13;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];
				colour = 51166;
				itemDefinition.modelColourToEdit[0] = 5594;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 5594 : colour;

				itemDefinition.modelColourToEdit[1] = 7101;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 7101 : colour;

				itemDefinition.modelColourToEdit[2] = 7079;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 7079 : colour;

				itemDefinition.modelColourToEdit[3] = 7104;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 7104 : colour;

				itemDefinition.modelColourToEdit[4] = 7056;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 7056 : colour;

				colour = 926;
				itemDefinition.modelColourToEdit[5] = 111;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 111 : colour;
				break;
			// White
			case 16282:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", "Dismantle", null, null};
				itemDefinition.name = "Twisted bow";
				itemDefinition.inventoryModel = 32799;
				itemDefinition.maleModel = 32674;
				itemDefinition.femaleModel = 32674;
				itemDefinition.zoom = 2000;
				itemDefinition.rotationX = 1500;
				itemDefinition.rotationY = 720;
				itemDefinition.inventoryX = -3;
				itemDefinition.inventoryY = 1;
				itemDefinition.scaleX = 128;
				itemDefinition.scaleY = 128;
				itemDefinition.scaleZ = 128;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;

				itemDefinition.modelColourToEdit = new int[10];
				itemDefinition.newModelColourProduced = new int[10];

				// Green
				colour = -1;
				itemDefinition.modelColourToEdit[9] = 13223;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? 13223 : colour;

				// Black
				colour = 127;
				itemDefinition.modelColourToEdit[1] = 8;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 8 : colour;

				// Black
				itemDefinition.modelColourToEdit[7] = 0;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 0 : colour;

				// Very dark grey
				colour = 100;
				itemDefinition.modelColourToEdit[0] = 16;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 16 : colour;

				// Dark grey
				colour = 115;
				itemDefinition.modelColourToEdit[2] = 24;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 24 : colour;

				// Grey
				colour = 100;
				itemDefinition.modelColourToEdit[3] = 33;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 33 : colour;

				// Grey
				itemDefinition.modelColourToEdit[5] = 41;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 41 : colour;

				// Grey
				itemDefinition.modelColourToEdit[8] = 14236;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? 14236 : colour;

				// Light grey
				colour = 15;
				itemDefinition.modelColourToEdit[4] = 10318;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 10318 : colour;

				// Light grey
				itemDefinition.modelColourToEdit[6] = 10334;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 10334 : colour;


				break;
			case 16281:
				itemDefinition.name = "Dragon claws";
				itemDefinition.femaleModel = 29191;
				itemDefinition.femaleEquipOffset = 6;
				itemDefinition.inventoryOptions = new String[]
				{null, "Wear", null, null, null};
				itemDefinition.inventoryModel = 32784;
				itemDefinition.maleModel = 29191;
				itemDefinition.rotationY = 349;
				itemDefinition.inventoryX = 0;
				itemDefinition.rotationX = 15;
				itemDefinition.inventoryY = 8;
				itemDefinition.zoom = 886;
				itemDefinition.modelColourToEdit = new int[]
				{929, 922, 918, 914};
				itemDefinition.newModelColourProduced = new int[]
				{127, 127, 127, 127};
				break;
			// Gold
			case 16280:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Sigil colour
				colour = 58325;
				itemDefinition.modelColourToEdit[1] = 127;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 127 : colour;

				colour = 7114;
				itemDefinition.modelColourToEdit[0] = -28716;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -28716 : colour;

				itemDefinition.modelColourToEdit[2] = -29116;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -29116 : colour;

				itemDefinition.modelColourToEdit[3] = -29019;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -29019 : colour;

				itemDefinition.modelColourToEdit[4] = -29125;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -29125 : colour;

				itemDefinition.modelColourToEdit[5] = -29110;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -29110 : colour;
				break;

			// White
			case 16279:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Sigil colour
				colour = 933;
				itemDefinition.modelColourToEdit[1] = 127;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 127 : colour;

				colour = 127;
				itemDefinition.modelColourToEdit[0] = -28716;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -28716 : colour;

				itemDefinition.modelColourToEdit[2] = -29116;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -29116 : colour;

				itemDefinition.modelColourToEdit[3] = -29019;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -29019 : colour;

				itemDefinition.modelColourToEdit[4] = -29125;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -29125 : colour;

				itemDefinition.modelColourToEdit[5] = -29110;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -29110 : colour;
				break;

			// Black
			case 16278:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Sigil colour
				colour = 58325;
				itemDefinition.modelColourToEdit[1] = 127;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 127 : colour;

				colour = 8;
				itemDefinition.modelColourToEdit[0] = -28716;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -28716 : colour;

				itemDefinition.modelColourToEdit[2] = -29116;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -29116 : colour;

				itemDefinition.modelColourToEdit[3] = -29019;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -29019 : colour;

				itemDefinition.modelColourToEdit[4] = -29125;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -29125 : colour;

				itemDefinition.modelColourToEdit[5] = -29110;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -29110 : colour;
				break;

			// Purple
			case 16277:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Sigil colour
				colour = 8128;
				itemDefinition.modelColourToEdit[1] = 127;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 127 : colour;

				colour = 51136;
				itemDefinition.modelColourToEdit[0] = -28716;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -28716 : colour;

				itemDefinition.modelColourToEdit[2] = -29116;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -29116 : colour;

				itemDefinition.modelColourToEdit[3] = -29019;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -29019 : colour;

				itemDefinition.modelColourToEdit[4] = -29125;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -29125 : colour;

				itemDefinition.modelColourToEdit[5] = -29110;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -29110 : colour;
				break;
			case 20527:
				itemDefinition.name = "Skilling token";
				itemDefinition.description = "Tokens gained while skilling.".getBytes();
				break;
			case 16276:
				itemDefinition.name = "Ancestral robe bottom";
				itemDefinition.inventoryModel = 32787;
				itemDefinition.maleModel = 32653;
				itemDefinition.maleEquip2 = -1;
				itemDefinition.femaleModel = 32662;
				itemDefinition.femaleEquip2 = -1;
				itemDefinition.zoom = 1690;
				itemDefinition.rotationX = 9;
				itemDefinition.rotationY = 435;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = 7;
				itemDefinition.brightness = 30;
				itemDefinition.contrast = 100;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[10];
				itemDefinition.newModelColourProduced = new int[10];

				// Light biege
				colour = 90;
				itemDefinition.modelColourToEdit[0] = 6348;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 6348 : colour;

				// Grey
				colour = 60;
				itemDefinition.modelColourToEdit[1] = -16318;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -16318 : colour;

				// Biege
				colour = 127;
				itemDefinition.modelColourToEdit[2] = 6331;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 6331 : colour;

				// Purple
				colour = 5;
				itemDefinition.modelColourToEdit[3] = -22225;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -22225 : colour;

				// Orange
				colour = 7114;
				itemDefinition.modelColourToEdit[4] = 7108;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 7108 : colour;

				// Dark purple
				colour = 5;
				itemDefinition.modelColourToEdit[5] = -22235;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22235 : colour;

				// Dark grey
				colour = 127;
				itemDefinition.modelColourToEdit[6] = -16327;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -16327 : colour;

				// Dark purple
				colour = 5;
				itemDefinition.modelColourToEdit[7] = -22231;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -16327 : colour;

				// Dark grey
				colour = 127;
				itemDefinition.modelColourToEdit[8] = -16339;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -16327 : colour;

				// Biege stripe across chest from shoulders to waist
				colour = 7114;
				itemDefinition.modelColourToEdit[9] = 6323;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? -16327 : colour;
				break;
			case 16275:
				itemDefinition.name = "Ancestral robe top";
				itemDefinition.inventoryModel = 32790;
				itemDefinition.maleModel = 32657;
				itemDefinition.maleEquip2 = 32658;
				itemDefinition.femaleModel = 32664;
				itemDefinition.femaleEquip2 = 32665;
				itemDefinition.femaleModel = 32664;
				itemDefinition.zoom = 1358;
				itemDefinition.rotationX = 2041;
				itemDefinition.rotationY = 514;
				itemDefinition.inventoryY = -3;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[11];
				itemDefinition.newModelColourProduced = new int[11];

				// Light biege
				colour = 90;
				itemDefinition.modelColourToEdit[0] = 6348;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 6348 : colour;

				// Grey
				colour = 127;
				itemDefinition.modelColourToEdit[1] = -16318;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -16318 : colour;

				// Biege
				colour = 127;
				itemDefinition.modelColourToEdit[2] = 6331;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 6331 : colour;

				// Purple
				colour = 5;
				itemDefinition.modelColourToEdit[3] = -22225;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -22225 : colour;

				// Orange
				colour = 7114;
				itemDefinition.modelColourToEdit[4] = 7108;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 7108 : colour;

				// Dark purple
				colour = 5;
				itemDefinition.modelColourToEdit[5] = -22235;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22235 : colour;

				// Dark grey
				colour = 127;
				itemDefinition.modelColourToEdit[6] = -16327;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -16327 : colour;

				// Dark purple
				colour = 5;
				itemDefinition.modelColourToEdit[7] = -22231;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -16327 : colour;

				// Dark grey
				colour = 127;
				itemDefinition.modelColourToEdit[8] = -16339;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -16327 : colour;

				// Biege stripe across chest from shoulders to waist
				colour = 7114;
				itemDefinition.modelColourToEdit[9] = 6323;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? -16327 : colour;

				// Belt rope colour
				colour = 80;
				itemDefinition.modelColourToEdit[10] = 5268;
				itemDefinition.newModelColourProduced[10] = colour == -1 ? -16327 : colour;
				break;
		}
		if (itemId >= 14876 && itemId <= 14892) {
			itemDefinition.inventoryOptions = new String[]
			{"Redeem", null, null, null, "Drop"};
		}
		if (itemId >= 6865 && itemId <= 6867) {
			itemDefinition.inventoryOptions = new String[]
			{"Jump", null, "Bow", "Dance", "Destroy"};
		}
		if (itemId >= 6822 && itemId <= 6827) {
			itemDefinition.inventoryOptions = new String[]
			{"Smash", null, null, null, null};
		}
	}

	public static void applyCustomItemsSecondMethodFirstExceeds64KBOsrs(ItemDefinition itemDefinition, int itemId) {
		if (Config.PRE_EOC) {
			return;
		}
		ItemDefinition itemInstance = null;
		EntityDefinition npcInstance = null;
		ObjectDefinition objectInstance = null;
		int colour = -1;
		int green = -1;
		int red = -1;
		int yellow = -1;
		int blue = -1;

		switch (itemId) {
			case 22653:
				itemDefinition.name = "Zuriel's robe top";
				itemDefinition.inventoryModel = 42591;
				itemDefinition.zoom = 1373;
				itemDefinition.rotationY = 373;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = -7;
				itemDefinition.inventoryOptions = new String[]
				{null, "Wear", null, null, "Destroy"};
				break;
			case 13860:
				itemDefinition.name = "Zuriel's robe top (deg)";
				itemDefinition.inventoryModel = 42591;
				itemDefinition.zoom = 1373;
				itemDefinition.rotationY = 373;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = -7;
				itemDefinition.maleModel = 35952;
				itemDefinition.femaleModel = 35966;
				itemDefinition.groundOptions = new String[]
				{null, null, "Take", null, null};
				itemDefinition.inventoryOptions = new String[]
				{null, "Wear", null, null, "Destroy"};
				break;
			case 22656:
				itemDefinition.name = "Zuriel's robe bottom";
				itemDefinition.inventoryModel = 42588;
				itemDefinition.zoom = 1697;
				itemDefinition.rotationY = 512;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 2;
				itemDefinition.inventoryY = -9;
				itemDefinition.inventoryOptions = new String[]
				{null, "Wear", null, null, "Destroy"};
				break;
			case 13863:
				itemDefinition.name = "Zuriel's robe bottom (deg)";
				itemDefinition.inventoryModel = 42588;
				itemDefinition.zoom = 1697;
				itemDefinition.rotationY = 512;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 2;
				itemDefinition.inventoryY = -9;
				itemDefinition.maleModel = 35949;
				itemDefinition.femaleModel = 35962;
				itemDefinition.groundOptions = new String[]
				{null, null, "Take", null, null};
				itemDefinition.inventoryOptions = new String[]
				{null, "Wear", null, null, "Destroy"};
				break;
			case 22650:
				itemDefinition.name = "Zuriel's hood";
				itemDefinition.inventoryModel = 42604;
				itemDefinition.zoom = 720;
				itemDefinition.rotationY = 28;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 1;
				itemDefinition.inventoryY = 1;
				itemDefinition.inventoryOptions = new String[]
				{null, "Wear", null, null, "Destroy"};
				break;
			case 13866:
				itemDefinition.name = "Zuriel's hood (deg)";
				itemDefinition.inventoryModel = 42604;
				itemDefinition.zoom = 720;
				itemDefinition.rotationY = 28;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 1;
				itemDefinition.inventoryY = 1;
				itemDefinition.maleModel = 35944;
				itemDefinition.femaleModel = 35957;
				itemDefinition.manHead0 = 35975;
				itemDefinition.manHead1 = 63;
				itemDefinition.womanHead0 = 35975;
				itemDefinition.womanHead1 = 120;
				itemDefinition.groundOptions = new String[]
				{null, null, "Take", null, null};
				itemDefinition.inventoryOptions = new String[]
				{null, "Wear", null, null, "Destroy"};
				break;

			case 22641:
				itemDefinition.name = "Morrigan's leather body";
				itemDefinition.inventoryModel = 42578;
				itemDefinition.zoom = 1440;
				itemDefinition.rotationY = 545;
				itemDefinition.rotationX = 2;
				itemDefinition.inventoryX = -2;
				itemDefinition.inventoryY = 5;
				itemDefinition.inventoryOptions = new String[]
				{null, "Wear", null, null, "Destroy"};
				break;
			case 13872:
				itemDefinition.name = "Morrigan's leather body (deg)";
				itemDefinition.inventoryModel = 42578;
				itemDefinition.zoom = 1440;
				itemDefinition.rotationY = 545;
				itemDefinition.rotationX = 2;
				itemDefinition.inventoryX = -2;
				itemDefinition.inventoryY = 5;
				itemDefinition.maleModel = 35954;
				itemDefinition.femaleModel = 35963;
				itemDefinition.groundOptions = new String[]
				{null, null, "Take", null, null};
				itemDefinition.inventoryOptions = new String[]
				{null, "Wear", null, null, "Destroy"};
				break;
			case 22644:
				itemDefinition.name = "Morrigan's leather chaps";
				itemDefinition.inventoryModel = 42603;
				itemDefinition.zoom = 1753;
				itemDefinition.rotationY = 482;
				itemDefinition.rotationX = 1;
				itemDefinition.inventoryX = -3;
				itemDefinition.inventoryY = 11;

				// Pre-eoc version
				//itemDefinition.maleModel = 42631;
				//itemDefinition.femaleModel = 42646;
				itemDefinition.inventoryOptions = new String[]
				{null, "Wear", null, null, "Destroy"};
				break;
			case 13875:
				itemDefinition.name = "Morrigan's leather chaps (deg)";
				itemDefinition.inventoryModel = 42603;
				itemDefinition.zoom = 1753;
				itemDefinition.rotationY = 482;
				itemDefinition.rotationX = 1;
				itemDefinition.inventoryX = -3;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 42631;
				itemDefinition.femaleModel = 42646;
				itemDefinition.groundOptions = new String[]
				{null, null, "Take", null, null};
				itemDefinition.inventoryOptions = new String[]
				{null, "Wear", null, null, "Destroy"};
				break;
			case 22638:
				itemDefinition.name = "Morrigan's coif";
				itemDefinition.inventoryModel = 42583;
				itemDefinition.zoom = 592;
				itemDefinition.rotationY = 537;
				itemDefinition.rotationX = 5;
				itemDefinition.inventoryX = -3;
				itemDefinition.inventoryY = 6;
				itemDefinition.inventoryOptions = new String[]
				{null, "Wear", null, null, "Destroy"};
				break;
			case 13878:
				itemDefinition.name = "Morrigan's coif (deg)";
				itemDefinition.inventoryModel = 42583;
				itemDefinition.zoom = 592;
				itemDefinition.rotationY = 537;
				itemDefinition.rotationX = 5;
				itemDefinition.inventoryX = -3;
				itemDefinition.inventoryY = 6;
				itemDefinition.maleModel = 35945;
				itemDefinition.femaleModel = 35956;
				itemDefinition.manHead0 = 35974;
				itemDefinition.manHead1 = 63;
				itemDefinition.womanHead0 = 35974;
				itemDefinition.womanHead1 = 120;
				itemDefinition.groundOptions = new String[]
				{null, null, "Take", null, null};
				itemDefinition.inventoryOptions = new String[]
				{null, "Wear", null, null, "Destroy"};
				break;

			case 22628:
				itemDefinition.name = "Statius's platebody";
				itemDefinition.inventoryModel = 42602;
				itemDefinition.zoom = 1312;
				itemDefinition.rotationY = 272;
				itemDefinition.rotationX = 2047;
				itemDefinition.inventoryX = -2;
				itemDefinition.inventoryY = 39;
				itemDefinition.inventoryOptions = new String[]
				{null, "Wear", null, null, "Destroy"};
				break;
			case 13886:
				itemDefinition.name = "Statius's platebody (deg)";
				itemDefinition.inventoryModel = 42602;
				itemDefinition.zoom = 1312;
				itemDefinition.rotationY = 272;
				itemDefinition.rotationX = 2047;
				itemDefinition.inventoryX = -2;
				itemDefinition.inventoryY = 39;
				itemDefinition.maleModel = 35951;
				itemDefinition.femaleModel = 35964;
				itemDefinition.groundOptions = new String[]
				{null, null, "Take", null, null};
				itemDefinition.inventoryOptions = new String[]
				{null, "Wear", null, null, "Destroy"};
				break;
			case 22616:
				itemDefinition.name = "Vesta's chainbody";
				itemDefinition.inventoryModel = 42593;
				itemDefinition.zoom = 1440;
				itemDefinition.rotationY = 545;
				itemDefinition.rotationX = 2;
				itemDefinition.inventoryX = 4;
				itemDefinition.inventoryY = 5;
				itemDefinition.inventoryOptions = new String[]
				{null, "Wear", null, null, "Destroy"};
				break;
			case 13889:
				itemDefinition.name = "Vesta's chainbody (deg)";
				itemDefinition.inventoryModel = 42593;
				itemDefinition.zoom = 1440;
				itemDefinition.rotationY = 545;
				itemDefinition.rotationX = 2;
				itemDefinition.inventoryX = 4;
				itemDefinition.inventoryY = 5;
				itemDefinition.maleModel = 35953;
				itemDefinition.femaleModel = 35965;
				itemDefinition.groundOptions = new String[]
				{null, null, "Take", null, null};
				itemDefinition.inventoryOptions = new String[]
				{null, "Wear", null, null, "Destroy"};
				break;
			case 22631:
				itemDefinition.name = "Statius's platelegs";
				itemDefinition.inventoryModel = 42590;
				itemDefinition.zoom = 1625;
				itemDefinition.rotationY = 355;
				itemDefinition.rotationX = 2046;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = -11;
				itemDefinition.inventoryOptions = new String[]
				{null, "Wear", null, null, "Destroy"};
				break;
			case 13892:
				itemDefinition.name = "Statius's platelegs (deg)";
				itemDefinition.inventoryModel = 42590;
				itemDefinition.zoom = 1625;
				itemDefinition.rotationY = 355;
				itemDefinition.rotationX = 2046;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = -11;
				itemDefinition.maleModel = 35947;
				itemDefinition.femaleModel = 35961;
				itemDefinition.groundOptions = new String[]
				{null, null, "Take", null, null};
				itemDefinition.inventoryOptions = new String[]
				{null, "Wear", null, null, "Destroy"};
				break;
			case 22619:
				itemDefinition.name = "Vesta's plateskirt";
				itemDefinition.inventoryModel = 42581;
				itemDefinition.zoom = 1753;
				itemDefinition.rotationY = 562;
				itemDefinition.rotationX = 1;
				itemDefinition.inventoryX = -3;
				itemDefinition.inventoryY = 11;
				itemDefinition.inventoryOptions = new String[]
				{null, "Wear", null, null, "Destroy"};
				// Pre-eoc version
				itemDefinition.maleModel = 42633;
				itemDefinition.femaleModel = 42649;
				break;
			case 13895:
				itemDefinition.name = "Vesta's plateskirt (deg)";
				itemDefinition.inventoryModel = 42581;
				itemDefinition.zoom = 1753;
				itemDefinition.rotationY = 562;
				itemDefinition.rotationX = 1;
				itemDefinition.inventoryX = -3;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 35950;
				itemDefinition.femaleModel = 35960;
				itemDefinition.groundOptions = new String[]
				{null, null, "Take", null, null};
				itemDefinition.inventoryOptions = new String[]
				{null, "Wear", null, null, "Destroy"};
				break;
			case 22625:
				itemDefinition.name = "Statius's full helm";
				itemDefinition.inventoryModel = 42596;
				itemDefinition.zoom = 789;
				itemDefinition.rotationY = 96;
				itemDefinition.rotationX = 2039;
				itemDefinition.inventoryX = 2;
				itemDefinition.inventoryY = -7;
				itemDefinition.inventoryOptions = new String[]
				{null, "Wear", null, null, "Destroy"};
				break;
			case 13898:
				itemDefinition.name = "Statius' full helm (deg)";
				itemDefinition.inventoryModel = 42596;
				itemDefinition.zoom = 789;
				itemDefinition.rotationY = 96;
				itemDefinition.rotationX = 2039;
				itemDefinition.inventoryX = 2;
				itemDefinition.inventoryY = -7;
				itemDefinition.maleModel = 35943;
				itemDefinition.femaleModel = 35958;
				itemDefinition.manHead0 = 35976;
				itemDefinition.manHead1 = 63;
				itemDefinition.womanHead0 = 35976;
				itemDefinition.womanHead1 = 120;
				itemDefinition.groundOptions = new String[]
				{null, null, "Take", null, null};
				itemDefinition.inventoryOptions = new String[]
				{null, "Wear", null, null, "Destroy"};
				break;
			case 22622:
				itemDefinition.name = "Statius's warhammer";
				itemDefinition.inventoryModel = 42577;
				itemDefinition.zoom = 1360;
				itemDefinition.rotationX = 27;
				itemDefinition.rotationY = 507;
				itemDefinition.inventoryX = 7;
				itemDefinition.inventoryY = 6;
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, "Destroy"};
				break;
			case 13904:
				itemDefinition.name = "Statius's warhammer (deg)";
				itemDefinition.inventoryModel = 42577;
				itemDefinition.zoom = 1360;
				itemDefinition.rotationX = 27;
				itemDefinition.rotationY = 507;
				itemDefinition.inventoryX = 7;
				itemDefinition.inventoryY = 6;
				itemDefinition.maleModel = 35968;
				itemDefinition.femaleModel = 35968;
				itemDefinition.groundOptions = new String[]
				{null, null, "Take", null, null};
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, "Destroy"};
				break;
			case 22610:
				itemDefinition.name = "Vesta's spear";
				itemDefinition.inventoryModel = 42599;
				itemDefinition.zoom = 2022;
				itemDefinition.rotationX = 15;
				itemDefinition.rotationY = 480;
				itemDefinition.inventoryY = 5;
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, "Destroy"};
				break;
			case 13907:
				itemDefinition.name = "Vesta's spear (deg)";
				itemDefinition.inventoryModel = 42599;
				itemDefinition.zoom = 2022;
				itemDefinition.rotationX = 15;
				itemDefinition.rotationY = 480;
				itemDefinition.inventoryY = 5;
				itemDefinition.maleModel = 35973;
				itemDefinition.femaleModel = 35973;
				itemDefinition.groundOptions = new String[]
				{null, null, "Take", null, null};
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, "Destroy"};
				break;
			case 22613:
				itemDefinition.name = "Vesta's longsword";
				itemDefinition.inventoryModel = 42597;
				itemDefinition.zoom = 1744;
				itemDefinition.rotationX = 1985;
				itemDefinition.rotationY = 738;
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, "Destroy"};
				break;
			case 9083:
				itemDefinition.name = "Mace Windu's Lightsaber";
				itemDefinition.inventoryModel = 50560;
				itemDefinition.zoom = 1744;
				itemDefinition.rotationX = 1985;
				itemDefinition.rotationY = 738;
				itemDefinition.maleModel = 50561;
				itemDefinition.femaleModel = 50561;
				itemDefinition.groundOptions = new String[]
				{null, null, "Take", null, null};
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, "Destroy"};
				break; 
			/*case 9087:
                itemDef.actions = new String[5];
                itemDef.actions[1] = "Wear";
                itemDef.name = "Red LightSaber";
                itemDef.description = "A red lightsabre.";
                itemDef.modelID = 50568;//Inv & Ground
                itemDef.modelZoom = 1350;
                itemDef.modelRotation1 = 424;
                itemDef.modelRotation2 = 0;
                itemDef.anInt204 = 0;
                itemDef.modelOffset1 = -1;
                itemDef.maleEquip2 = 3;
                itemDef.maleEquip1 = 50569;//Male Wield View
                itemDef.femaleEquip1 = 50569;//Female Wield View
        break;*/
			case 13901:
				itemDefinition.name = "Vesta's longsword (deg)";
				itemDefinition.inventoryModel = 42597;
				itemDefinition.zoom = 1744;
				itemDefinition.rotationX = 1985;
				itemDefinition.rotationY = 738;
				itemDefinition.maleModel = 35969;
				itemDefinition.femaleModel = 35969;
				itemDefinition.groundOptions = new String[]
				{null, null, "Take", null, null};
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, "Destroy"};
				break;
			case 22647:
				itemDefinition.name = "Zuriel's staff";
				itemDefinition.inventoryModel = 42595;
				itemDefinition.zoom = 2000;
				itemDefinition.rotationX = 3;
				itemDefinition.rotationY = 366;
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, "Destroy"};
				break;
			case 13869:
				itemDefinition.name = "Zuriel's staff (deg)";
				itemDefinition.inventoryModel = 42595;
				itemDefinition.zoom = 2000;
				itemDefinition.rotationX = 3;
				itemDefinition.rotationY = 366;
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, "Destroy"};
				itemDefinition.maleModel = 35971;
				itemDefinition.femaleModel = 35971;
				itemDefinition.groundOptions = new String[]
				{null, null, "Take", null, null};
				break;
			case 22634:
				itemDefinition.name = "Morrigan's throwing axe";
				itemDefinition.inventoryModel = 42582;
				itemDefinition.zoom = 976;
				itemDefinition.rotationX = 2024;
				itemDefinition.rotationY = 672;
				itemDefinition.inventoryX = -5;
				itemDefinition.inventoryY = 4;
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, "Destroy"};
				break;
			case 22636:
				itemDefinition.name = "Morrigan's javelin";
				itemDefinition.inventoryModel = 42592;
				itemDefinition.zoom = 1872;
				itemDefinition.rotationX = 2009;
				itemDefinition.rotationY = 282;
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, "Destroy"};
				break;
			case 16435:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", "Dismantle", null, null};
				itemDefinition.name = "Armadyl godsword";
				itemDefinition.inventoryModel = 28075;
				itemDefinition.zoom = 1957;
				itemDefinition.rotationY = 498;
				itemDefinition.rotationX = 484;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = -1;
				itemDefinition.maleModel = 27649;
				itemDefinition.femaleModel = 27649;

				itemDefinition.modelColourToEdit = new int[10];
				itemDefinition.newModelColourProduced = new int[10];

				// Hilt section where the hands are wrapped around
				colour = ItemColours.RED - 15;
				itemDefinition.modelColourToEdit[0] = -22208;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -22208 : colour;

				// Hilt top section
				itemDefinition.modelColourToEdit[1] = -22477;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22477 : colour;

				// Hilt section various sides
				itemDefinition.modelColourToEdit[2] = -22464;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22464 : colour;

				// Hilt section, the bottom part, half of the furs
				itemDefinition.modelColourToEdit[3] = -24279;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -24279 : colour;

				// Hilt section, the bottom part, rest of the furs
				itemDefinition.modelColourToEdit[4] = -24271;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -24271 : colour;

				// Blade, left side
				colour = ItemColours.RED;
				itemDefinition.modelColourToEdit[5] = -22444;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22444 : colour;

				colour = ItemColours.RED - 15;
				// Blade, right side
				itemDefinition.modelColourToEdit[6] = -22423;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -22423 : colour;

				colour = ItemColours.RED;
				// Blade decoration on the right
				itemDefinition.modelColourToEdit[7] = -22415;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -22415 : colour;

				// Blade tip on the right
				itemDefinition.modelColourToEdit[8] = -22419;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -22419 : colour;

				// Blade at the tip, inventory model only.
				itemDefinition.modelColourToEdit[9] = -22440;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? -22440 : colour;
				break;
			case 16434:
				itemDefinition.name = "Santa hat (g)";
				itemDefinition.inventoryModel = 2537;
				itemDefinition.maleModel = 189;
				itemDefinition.femaleModel = 366;
				itemDefinition.zoom = 540;
				itemDefinition.rotationX = 136;
				itemDefinition.rotationY = 72;
				itemDefinition.inventoryY = -3;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;

				itemDefinition.modelColourToEdit = new int[2];
				itemDefinition.newModelColourProduced = new int[2];
				colour = -1;
				itemDefinition.modelColourToEdit[0] = 933;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 933 : colour;

				colour = ItemColours.GILDED;
				itemDefinition.modelColourToEdit[1] = 10351;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 10351 : colour;
				break;
			case 16433:
				itemDefinition.name = "Dragon claws";
				itemDefinition.femaleModel = 29191;
				itemDefinition.femaleEquipOffset = 6;
				itemDefinition.inventoryOptions = new String[]
				{null, "Wear", null, null, null};
				itemDefinition.inventoryModel = 32784;
				itemDefinition.maleModel = 29191;
				itemDefinition.rotationY = 349;
				itemDefinition.inventoryX = 0;
				itemDefinition.rotationX = 15;
				itemDefinition.inventoryY = 8;
				itemDefinition.zoom = 886;

				itemDefinition.modelColourToEdit = new int[4];
				itemDefinition.newModelColourProduced = new int[4];

				colour = ItemColours.WHITE;
				itemDefinition.modelColourToEdit[0] = 929;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 929 : colour;

				itemDefinition.modelColourToEdit[2] = 918;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 918 : colour;

				colour = ItemColours.BLACK;
				itemDefinition.modelColourToEdit[1] = 922;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 922 : colour;

				itemDefinition.modelColourToEdit[3] = 914;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 914 : colour;
				break;
			case 16432:
				itemDefinition.name = "Elder maul";
				itemDefinition.inventoryModel = 32792;
				itemDefinition.maleModel = 32678;
				itemDefinition.femaleModel = 32678;
				itemDefinition.zoom = 1744;
				itemDefinition.rotationX = 429;
				itemDefinition.rotationY = 237;
				itemDefinition.inventoryX = -3;
				itemDefinition.inventoryY = -58;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Orange dark
				colour = ItemColours.BLACK;
				itemDefinition.modelColourToEdit[0] = 5056;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 5056 : colour;

				// Orange dark
				colour = ItemColours.BLACK;
				itemDefinition.modelColourToEdit[1] = 8125;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 8125 : colour;

				// Dark grey
				colour = ItemColours.WHITE - 8;
				itemDefinition.modelColourToEdit[2] = 16;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 16 : colour;

				// Dark grey
				colour = ItemColours.WHITE - 10;
				itemDefinition.modelColourToEdit[5] = 20;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 20 : colour;

				// It was black
				colour = ItemColours.WHITE - 30;
				itemDefinition.modelColourToEdit[3] = 0;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 0 : colour;

				// Grey
				colour = ItemColours.WHITE - 14;
				itemDefinition.modelColourToEdit[4] = 33;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 33 : colour;
				break;
			case 16431:
				itemDefinition.name = "Bandos tassets";
				itemDefinition.inventoryModel = 28047;
				itemDefinition.maleModel = 27625;
				itemDefinition.femaleModel = 27640;
				itemDefinition.zoom = 854;
				itemDefinition.rotationX = 2039;
				itemDefinition.rotationY = 540;
				itemDefinition.inventoryX = 3;
				itemDefinition.inventoryY = 3;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[7];
				itemDefinition.newModelColourProduced = new int[7];

				colour = -1;
				itemDefinition.modelColourToEdit[0] = 4550;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 4550 : colour;

				colour = ItemColours.STRONG_PINK;
				itemDefinition.modelColourToEdit[1] = 22;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 22 : colour;

				colour = ItemColours.STRONG_PINK - 20;
				itemDefinition.modelColourToEdit[2] = 163;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 163 : colour;

				colour = ItemColours.STRONG_PINK - 20;
				itemDefinition.modelColourToEdit[3] = 154;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 154 : colour;

				colour = ItemColours.STRONG_PINK;
				itemDefinition.modelColourToEdit[4] = 39;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 39 : colour;

				colour = ItemColours.CYAN - 20;
				itemDefinition.modelColourToEdit[5] = 9523;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 9523 : colour;

				colour = ItemColours.CYAN;
				itemDefinition.modelColourToEdit[6] = 8390;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 8390 : colour;
				break;
			case 16430:
				itemDefinition.name = "Amulet of torture";
				itemDefinition.inventoryModel = 31524;
				itemDefinition.maleModel = 31227;
				itemDefinition.maleEquip2 = -1;
				itemDefinition.femaleModel = 31233;
				itemDefinition.femaleEquip2 = -1;
				itemDefinition.zoom = 620;
				itemDefinition.rotationX = 68;
				itemDefinition.rotationY = 424;
				itemDefinition.inventoryX = 1;
				itemDefinition.inventoryY = 16;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[7];
				itemDefinition.newModelColourProduced = new int[7];

				// Grey
				colour = ItemColours.PINK;
				itemDefinition.modelColourToEdit[0] = -22372;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -22372 : colour;

				// Light grey
				colour = 927;
				itemDefinition.modelColourToEdit[1] = -22483;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22483 : colour;

				// Light grey
				colour = 927;
				itemDefinition.modelColourToEdit[2] = -22475;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22475 : colour;

				// Shade over the orange
				colour = ItemColours.STRONG_PINK - 20;
				itemDefinition.modelColourToEdit[3] = 5056;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 5056 : colour;

				// Light grey
				colour = 927;
				itemDefinition.modelColourToEdit[4] = -22506;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -22506 : colour;

				// Black
				colour = -1;
				itemDefinition.modelColourToEdit[5] = 0;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 0 : colour;

				// Orange
				colour = ItemColours.STRONG_PINK;
				itemDefinition.modelColourToEdit[6] = 3008;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 3008 : colour;
				break;
			case 16428:
				itemDefinition.name = "Primordial boots";
				itemDefinition.inventoryModel = 29397;
				itemDefinition.maleModel = 29250;
				itemDefinition.maleEquip2 = -1;
				itemDefinition.femaleModel = 29255;
				itemDefinition.femaleEquip2 = -1;
				itemDefinition.zoom = 976;
				itemDefinition.rotationX = 279;
				itemDefinition.rotationY = 147;
				itemDefinition.inventoryX = 5;
				itemDefinition.inventoryY = -5;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[8];
				itemDefinition.newModelColourProduced = new int[8];
				// Dark red
				colour = ItemColours.CYAN;
				itemDefinition.modelColourToEdit[0] = 280;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 280 : colour;

				// Red
				colour = ItemColours.CYAN;
				itemDefinition.modelColourToEdit[1] = 924;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 924 : colour;

				// Red
				colour = ItemColours.CYAN;
				itemDefinition.modelColourToEdit[2] = 920;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 920 : colour;

				// Very dark grey
				colour = ItemColours.STRONG_PINK;
				itemDefinition.modelColourToEdit[6] = 520;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 520 : colour;

				// Dark grey
				colour = ItemColours.STRONG_PINK;
				itemDefinition.modelColourToEdit[5] = -22380;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22380 : colour;


				// Grey
				colour = ItemColours.STRONG_PINK;
				itemDefinition.modelColourToEdit[3] = -22370;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -22370 : colour;

				// Red
				colour = -1;
				itemDefinition.modelColourToEdit[4] = 538;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 538 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[7] = 127;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 127 : colour;
				break;
			case 21794:
				itemDefinition.name = "Jack O Lantern Boots";
				itemDefinition.inventoryModel = 65322;
				itemDefinition.maleModel = 65322;
				itemDefinition.maleEquip2 = -1;
				itemDefinition.femaleModel = 65322;
				itemDefinition.femaleEquip2 = -1;
				itemDefinition.zoom = 780;
				itemDefinition.rotationX = 279;
				itemDefinition.rotationY = 147;
				itemDefinition.inventoryX = 5;
				itemDefinition.inventoryY = -5;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				break;
			case 16891:
				itemDefinition.name = "Jack O Lantern Whip";
				itemDefinition.inventoryModel = 65323;
				itemDefinition.maleModel = 65323;
				itemDefinition.maleEquip2 = -1;
				itemDefinition.femaleModel = 65323;
				itemDefinition.femaleEquip2 = -1;
				itemDefinition.femaleEquipOffset = 6;
				itemDefinition.zoom = 1900;
				itemDefinition.rotationX = 350;
				itemDefinition.rotationY = 120;
				itemDefinition.inventoryX = 15;
				itemDefinition.inventoryY = 10;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				break;
				case 16427:
				itemDefinition.name = "Armadyl crossbow";
				itemDefinition.inventoryModel = 19967;
				itemDefinition.maleModel = 19839;
				itemDefinition.maleEquip2 = -1;
				itemDefinition.femaleModel = 19839;
				itemDefinition.femaleEquip2 = -1;
				itemDefinition.femaleEquipOffset = 6;
				itemDefinition.zoom = 1325;
				itemDefinition.rotationX = 110;
				itemDefinition.rotationY = 240;
				itemDefinition.inventoryX = -6;
				itemDefinition.inventoryY = -40;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[5];
				itemDefinition.modelColourToEdit[0] = 5409;
				itemDefinition.modelColourToEdit[1] = 5404;
				itemDefinition.modelColourToEdit[2] = 6449;
				itemDefinition.modelColourToEdit[3] = 7390;
				itemDefinition.newModelColourProduced = new int[5];
				itemDefinition.newModelColourProduced[0] = ItemColours.STRONG_PINK; // Was white
				itemDefinition.newModelColourProduced[1] = ItemColours.STRONG_PINK; // Was white
				itemDefinition.newModelColourProduced[2] = ItemColours.CYAN; // Was yellow
				itemDefinition.newModelColourProduced[3] = ItemColours.CYAN; // Was yellow

				// String colour, was grey
				colour = -1;
				itemDefinition.modelColourToEdit[4] = 8530;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 8530 : colour;
				break;
			case 16426:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", "Dismantle", null, null};
				itemDefinition.name = "Armadyl godsword";
				itemDefinition.inventoryModel = 28075;
				itemDefinition.zoom = 1957;
				itemDefinition.rotationY = 498;
				itemDefinition.rotationX = 484;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = -1;
				itemDefinition.maleModel = 27649;
				itemDefinition.femaleModel = 27649;

				itemDefinition.modelColourToEdit = new int[10];
				itemDefinition.newModelColourProduced = new int[10];

				// Hilt section where the hands are wrapped around
				colour = ItemColours.CYAN;
				itemDefinition.modelColourToEdit[0] = -22208;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -22208 : colour;

				// Hilt top section
				itemDefinition.modelColourToEdit[1] = -22477;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22477 : colour;

				// Hilt section various sides
				itemDefinition.modelColourToEdit[2] = -22464;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22464 : colour;

				// Hilt section, the bottom part, half of the furs
				itemDefinition.modelColourToEdit[3] = -24279;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -24279 : colour;

				// Hilt section, the bottom part, rest of the furs
				itemDefinition.modelColourToEdit[4] = -24271;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -24271 : colour;

				// Blade, left side
				colour = ItemColours.STRONG_PINK;
				itemDefinition.modelColourToEdit[5] = -22444;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22444 : colour;

				colour = ItemColours.STRONG_PINK + 15;
				// Blade, right side
				itemDefinition.modelColourToEdit[6] = -22423;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -22423 : colour;

				colour = ItemColours.STRONG_PINK - 15;
				// Blade decoration on the right
				itemDefinition.modelColourToEdit[7] = -22415;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -22415 : colour;

				// Blade tip on the right
				itemDefinition.modelColourToEdit[8] = -22419;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -22419 : colour;

				// Blade at the tip, inventory model only.
				itemDefinition.modelColourToEdit[9] = -22440;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? -22440 : colour;
				break;
			case 16425:
				itemDefinition.name = "Dragon claws";
				itemDefinition.femaleModel = 29191;
				itemDefinition.femaleEquipOffset = 6;
				itemDefinition.inventoryOptions = new String[]
				{null, "Wear", null, null, null};
				itemDefinition.inventoryModel = 32784;
				itemDefinition.maleModel = 29191;
				itemDefinition.rotationY = 349;
				itemDefinition.inventoryX = 0;
				itemDefinition.rotationX = 15;
				itemDefinition.inventoryY = 8;
				itemDefinition.zoom = 886;

				itemDefinition.modelColourToEdit = new int[4];
				itemDefinition.newModelColourProduced = new int[4];

				colour = ItemColours.PARTYHAT_BLUE - 20;
				itemDefinition.modelColourToEdit[0] = 929;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 929 : colour;

				itemDefinition.modelColourToEdit[2] = 918;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 918 : colour;

				colour = ItemColours.PARTYHAT_BLUE + 15;
				itemDefinition.modelColourToEdit[1] = 922;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 922 : colour;

				itemDefinition.modelColourToEdit[3] = 914;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 914 : colour;
				break;
			case 16424:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", "Dismantle", null, null};
				itemDefinition.name = "Armadyl godsword";
				itemDefinition.inventoryModel = 28075;
				itemDefinition.zoom = 1957;
				itemDefinition.rotationY = 498;
				itemDefinition.rotationX = 484;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = -1;
				itemDefinition.maleModel = 27649;
				itemDefinition.femaleModel = 27649;

				itemDefinition.modelColourToEdit = new int[10];
				itemDefinition.newModelColourProduced = new int[10];

				// Hilt section where the hands are wrapped around
				colour = ItemColours.WHITE;
				itemDefinition.modelColourToEdit[0] = -22208;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -22208 : colour;

				// Hilt top section
				itemDefinition.modelColourToEdit[1] = -22477;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22477 : colour;

				// Hilt section various sides
				itemDefinition.modelColourToEdit[2] = -22464;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22464 : colour;

				// Hilt section, the bottom part, half of the furs
				itemDefinition.modelColourToEdit[3] = -24279;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -24279 : colour;

				// Hilt section, the bottom part, rest of the furs
				itemDefinition.modelColourToEdit[4] = -24271;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -24271 : colour;

				// Blade, left side
				colour = ItemColours.PARTYHAT_BLUE;
				itemDefinition.modelColourToEdit[5] = -22444;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22444 : colour;

				colour = ItemColours.PARTYHAT_BLUE + 15;
				// Blade, right side
				itemDefinition.modelColourToEdit[6] = -22423;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -22423 : colour;

				colour = ItemColours.PARTYHAT_BLUE - 15;
				// Blade decoration on the right
				itemDefinition.modelColourToEdit[7] = -22415;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -22415 : colour;

				// Blade tip on the right
				itemDefinition.modelColourToEdit[8] = -22419;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -22419 : colour;

				// Blade at the tip, inventory model only.
				itemDefinition.modelColourToEdit[9] = -22440;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? -22440 : colour;
				break;
			case 16423:
				itemDefinition.name = "Elder maul";
				itemDefinition.inventoryModel = 32792;
				itemDefinition.maleModel = 32678;
				itemDefinition.femaleModel = 32678;
				itemDefinition.zoom = 1744;
				itemDefinition.rotationX = 429;
				itemDefinition.rotationY = 237;
				itemDefinition.inventoryX = -3;
				itemDefinition.inventoryY = -58;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Orange dark
				colour = ItemColours.BLACK;
				itemDefinition.modelColourToEdit[0] = 5056;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 5056 : colour;

				// Orange dark
				colour = ItemColours.BLACK;
				itemDefinition.modelColourToEdit[1] = 8125;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 8125 : colour;

				// Dark grey
				colour = ItemColours.BLACK;
				itemDefinition.modelColourToEdit[2] = 16;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 16 : colour;

				// Dark grey
				colour = ItemColours.BLACK;
				itemDefinition.modelColourToEdit[5] = 20;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 20 : colour;

				// It was black
				colour = -1;
				itemDefinition.modelColourToEdit[3] = 0;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 0 : colour;

				// Grey
				colour = ItemColours.BLACK;
				itemDefinition.modelColourToEdit[4] = 33;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 33 : colour;
				break;
			case 16422:
				itemDefinition.name = "Elder maul";
				itemDefinition.inventoryModel = 32792;
				itemDefinition.maleModel = 32678;
				itemDefinition.femaleModel = 32678;
				itemDefinition.zoom = 1744;
				itemDefinition.rotationX = 429;
				itemDefinition.rotationY = 237;
				itemDefinition.inventoryX = -3;
				itemDefinition.inventoryY = -58;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Orange dark
				colour = ItemColours.PURPLE;
				itemDefinition.modelColourToEdit[0] = 5056;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 5056 : colour;

				// Orange dark
				colour = ItemColours.PURPLE;
				itemDefinition.modelColourToEdit[1] = 8125;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 8125 : colour;

				// Dark grey
				colour = ItemColours.WHITE;
				itemDefinition.modelColourToEdit[2] = 16;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 16 : colour;

				// Dark grey
				colour = ItemColours.WHITE;
				itemDefinition.modelColourToEdit[5] = 20;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 20 : colour;

				// It was black
				colour = ItemColours.WHITE;
				itemDefinition.modelColourToEdit[3] = 0;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 0 : colour;

				// Grey
				colour = ItemColours.WHITE;
				itemDefinition.modelColourToEdit[4] = 33;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 33 : colour;
				break;
			case 16421:
				itemDefinition.name = "Dragon claws";
				itemDefinition.femaleModel = 29191;
				itemDefinition.femaleEquipOffset = 6;
				itemDefinition.inventoryOptions = new String[]
				{null, "Wear", null, null, null};
				itemDefinition.inventoryModel = 32784;
				itemDefinition.maleModel = 29191;
				itemDefinition.rotationY = 349;
				itemDefinition.inventoryX = 0;
				itemDefinition.rotationX = 15;
				itemDefinition.inventoryY = 8;
				itemDefinition.zoom = 886;

				itemDefinition.modelColourToEdit = new int[4];
				itemDefinition.newModelColourProduced = new int[4];

				colour = ItemColours.STRONG_PINK - 20;
				itemDefinition.modelColourToEdit[0] = 929;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 929 : colour;

				itemDefinition.modelColourToEdit[2] = 918;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 918 : colour;

				colour = ItemColours.STRONG_PINK;
				itemDefinition.modelColourToEdit[1] = 922;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 922 : colour;

				itemDefinition.modelColourToEdit[3] = 914;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 914 : colour;
				break;
			case 16420:
				itemDefinition.name = "R&b partyhat";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.inventoryModel = 16252;
				itemDefinition.zoom = 440;
				itemDefinition.rotationX = 1852;
				itemDefinition.rotationY = 76;
				itemDefinition.inventoryX = 1;
				itemDefinition.inventoryY = 1;
				itemDefinition.maleModel = 16246;
				itemDefinition.femaleModel = 16248;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.modelColourToEdit = new int[10];
				itemDefinition.newModelColourProduced = new int[10];

				// was red
				colour = ItemColours.RED;
				itemDefinition.modelColourToEdit[0] = 947;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 947 : colour;

				// was orange
				colour = ItemColours.BLACK;
				itemDefinition.modelColourToEdit[1] = 6067;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 6067 : colour;

				// was yellow
				colour = ItemColours.RED;
				itemDefinition.modelColourToEdit[2] = 11187;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 11187 : colour;

				// was green
				colour = ItemColours.BLACK;
				itemDefinition.modelColourToEdit[3] = 17331;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 17331 : colour;

				// was turqoise
				colour = ItemColours.RED;
				itemDefinition.modelColourToEdit[4] = 27571;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 27571 : colour;

				// was light blue
				colour = ItemColours.BLACK;
				itemDefinition.modelColourToEdit[5] = 38835;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 38835 : colour;

				// was blue
				colour = ItemColours.RED;
				itemDefinition.modelColourToEdit[6] = 43955;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 43955 : colour;

				// was purple
				colour = ItemColours.BLACK;
				itemDefinition.modelColourToEdit[7] = 55196;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 55196 : colour;
				itemDefinition.modelColourToEdit[8] = 55186;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? 55186 : colour;
				itemDefinition.modelColourToEdit[9] = 55217;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? 55217 : colour;

				break;
			case 16511:
				itemDefinition.name = "Strong Pink partyhat";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.inventoryModel = 16252;
				itemDefinition.zoom = 440;
				itemDefinition.rotationX = 1852;
				itemDefinition.rotationY = 76;
				itemDefinition.inventoryX = 1;
				itemDefinition.inventoryY = 1;
				itemDefinition.maleModel = 16246;
				itemDefinition.femaleModel = 16248;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.modelColourToEdit = new int[10];
				itemDefinition.newModelColourProduced = new int[10];

				// was red
				colour = ItemColours.STRONG_PINK;
				itemDefinition.modelColourToEdit[0] = 947;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 947 : colour;

				// was orange
				colour = ItemColours.BLACK;
				itemDefinition.modelColourToEdit[1] = 6067;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 6067 : colour;

				// was yellow
				colour = ItemColours.STRONG_PINK;
				itemDefinition.modelColourToEdit[2] = 11187;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 11187 : colour;

				// was green
				colour = ItemColours.BLACK;
				itemDefinition.modelColourToEdit[3] = 17331;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 17331 : colour;

				// was turqoise
				colour = ItemColours.STRONG_PINK;
				itemDefinition.modelColourToEdit[4] = 27571;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 27571 : colour;

				// was light blue
				colour = ItemColours.BLACK;
				itemDefinition.modelColourToEdit[5] = 38835;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 38835 : colour;

				// was blue
				colour = ItemColours.STRONG_PINK;
				itemDefinition.modelColourToEdit[6] = 43955;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 43955 : colour;

				// was purple
				colour = ItemColours.BLACK;
				itemDefinition.modelColourToEdit[7] = 55196;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 55196 : colour;
				itemDefinition.modelColourToEdit[8] = 55186;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? 55186 : colour;
				itemDefinition.modelColourToEdit[9] = 55217;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? 55217 : colour;

				break;
			case 16513:
				itemDefinition.name = "Gilded partyhat";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.inventoryModel = 16252;
				itemDefinition.zoom = 440;
				itemDefinition.rotationX = 1852;
				itemDefinition.rotationY = 76;
				itemDefinition.inventoryX = 1;
				itemDefinition.inventoryY = 1;
				itemDefinition.maleModel = 16246;
				itemDefinition.femaleModel = 16248;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.modelColourToEdit = new int[10];
				itemDefinition.newModelColourProduced = new int[10];

				// was red
				colour = ItemColours.GILDED;
				itemDefinition.modelColourToEdit[0] = 947;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 947 : colour;

				// was orange
				colour = ItemColours.BLACK;
				itemDefinition.modelColourToEdit[1] = 6067;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 6067 : colour;

				// was yellow
				colour = ItemColours.GILDED;
				itemDefinition.modelColourToEdit[2] = 11187;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 11187 : colour;

				// was green
				colour = ItemColours.BLACK;
				itemDefinition.modelColourToEdit[3] = 17331;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 17331 : colour;

				// was turqoise
				colour = ItemColours.GILDED;
				itemDefinition.modelColourToEdit[4] = 27571;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 27571 : colour;

				// was light blue
				colour = ItemColours.BLACK;
				itemDefinition.modelColourToEdit[5] = 38835;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 38835 : colour;

				// was blue
				colour = ItemColours.GILDED;
				itemDefinition.modelColourToEdit[6] = 43955;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 43955 : colour;

				// was purple
				colour = ItemColours.BLACK;
				itemDefinition.modelColourToEdit[7] = 55196;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 55196 : colour;
				itemDefinition.modelColourToEdit[8] = 55186;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? 55186 : colour;
				itemDefinition.modelColourToEdit[9] = 55217;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? 55217 : colour;

				break;
			case 16512:
				itemDefinition.name = "Forest partyhat";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.inventoryModel = 16252;
				itemDefinition.zoom = 440;
				itemDefinition.rotationX = 1852;
				itemDefinition.rotationY = 76;
				itemDefinition.inventoryX = 1;
				itemDefinition.inventoryY = 1;
				itemDefinition.maleModel = 16246;
				itemDefinition.femaleModel = 16248;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.modelColourToEdit = new int[10];
				itemDefinition.newModelColourProduced = new int[10];

				// was red
				colour = ItemColours.FOREST_GREEN;
				itemDefinition.modelColourToEdit[0] = 947;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 947 : colour;

				// was orange
				colour = ItemColours.BLACK;
				itemDefinition.modelColourToEdit[1] = 6067;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 6067 : colour;

				// was yellow
				colour = ItemColours.FOREST_GREEN;
				itemDefinition.modelColourToEdit[2] = 11187;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 11187 : colour;

				// was green
				colour = ItemColours.BLACK;
				itemDefinition.modelColourToEdit[3] = 17331;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 17331 : colour;

				// was turqoise
				colour = ItemColours.FOREST_GREEN;
				itemDefinition.modelColourToEdit[4] = 27571;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 27571 : colour;

				// was light blue
				colour = ItemColours.BLACK;
				itemDefinition.modelColourToEdit[5] = 38835;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 38835 : colour;

				// was blue
				colour = ItemColours.FOREST_GREEN;
				itemDefinition.modelColourToEdit[6] = 43955;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 43955 : colour;

				// was purple
				colour = ItemColours.BLACK;
				itemDefinition.modelColourToEdit[7] = 55196;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 55196 : colour;
				itemDefinition.modelColourToEdit[8] = 55186;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? 55186 : colour;
				itemDefinition.modelColourToEdit[9] = 55217;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? 55217 : colour;

				break;
			case 16419:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Sigil colour
				colour = ItemColours.YELLOW;
				itemDefinition.modelColourToEdit[1] = 127;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 127 : colour;

				// Shield colour
				colour = ItemColours.BLACK;
				itemDefinition.modelColourToEdit[0] = -28716;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -28716 : colour;

				// Trim colour
				colour = ItemColours.BLACK;
				itemDefinition.modelColourToEdit[2] = -29116;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -29116 : colour;

				itemDefinition.modelColourToEdit[3] = -29019;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -29019 : colour;

				itemDefinition.modelColourToEdit[4] = -29125;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -29125 : colour;

				itemDefinition.modelColourToEdit[5] = -29110;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -29110 : colour;
				break;
			case 16418:
				itemDefinition.name = "Justiciar legguards";
				itemDefinition.inventoryModel = 35752;
				itemDefinition.maleModel = 35356;
				itemDefinition.femaleModel = 35367;
				itemDefinition.zoom = 1720;
				itemDefinition.rotationY = 468;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = "Drop";
				itemDefinition.modelColourToEdit = new int[16];
				itemDefinition.newModelColourProduced = new int[16];

				// Very dark grey
				colour = 0;
				itemDefinition.modelColourToEdit[0] = 12;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 12 : colour;

				// Dark grey
				colour = 2;
				itemDefinition.modelColourToEdit[1] = 268;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 268 : colour;

				// Dark grey
				colour = 4;
				itemDefinition.modelColourToEdit[10] = 16;
				itemDefinition.newModelColourProduced[10] = colour == -1 ? 16 : colour;

				// Grey
				colour = 6;
				itemDefinition.modelColourToEdit[9] = 22;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? 22 : colour;

				// Grey
				colour = 8;
				itemDefinition.modelColourToEdit[12] = -11229;
				itemDefinition.newModelColourProduced[12] = colour == -1 ? -11229 : colour;

				// Light grey
				colour = 9;
				itemDefinition.modelColourToEdit[2] = -6070;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -6070 : colour;

				// Light grey
				colour = 10;
				itemDefinition.modelColourToEdit[14] = -6083;
				itemDefinition.newModelColourProduced[14] = colour == -1 ? -6083 : colour;

				// Light grey
				colour = 11;
				itemDefinition.modelColourToEdit[13] = -6091;
				itemDefinition.newModelColourProduced[13] = colour == -1 ? -6091 : colour;

				// Light grey
				colour = 12;
				itemDefinition.modelColourToEdit[3] = -6095;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -6095 : colour;

				// Blue
				colour = 13;
				itemDefinition.modelColourToEdit[4] = -22242;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -22242 : colour;

				// Blue
				colour = 15;
				itemDefinition.modelColourToEdit[5] = -22237;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22237 : colour;

				// Blue
				colour = 17;
				itemDefinition.modelColourToEdit[6] = -22233;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -22233 : colour;

				// Yellow
				colour = 940;
				itemDefinition.modelColourToEdit[7] = 6602;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 6602 : colour;

				// Dark yellow
				colour = 950;
				itemDefinition.modelColourToEdit[11] = 6699;
				itemDefinition.newModelColourProduced[11] = colour == -1 ? 6699 : colour;

				// Dark Yellow
				colour = 950;
				itemDefinition.modelColourToEdit[15] = 6709;
				itemDefinition.newModelColourProduced[15] = colour == -1 ? 6709 : colour;

				// Dark yellow
				colour = 950;
				itemDefinition.modelColourToEdit[8] = 6736;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? 6736 : colour;
				break;
			case 16417:
				itemDefinition.name = "Justiciar chestguard";
				itemDefinition.inventoryModel = 35750;
				itemDefinition.maleModel = 35359;
				itemDefinition.femaleModel = 35368;
				itemDefinition.zoom = 1310;
				itemDefinition.rotationY = 432;
				itemDefinition.inventoryX = 1;
				itemDefinition.inventoryY = 4;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = "Drop";
				itemDefinition.modelColourToEdit = new int[15];
				itemDefinition.newModelColourProduced = new int[15];


				// Very very Dark grey
				colour = 0;
				itemDefinition.modelColourToEdit[0] = 12;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 12 : colour;

				// Very dark grey
				colour = 2;
				itemDefinition.modelColourToEdit[13] = 268;
				itemDefinition.newModelColourProduced[13] = colour == -1 ? 268 : colour;

				// Very dark grey
				colour = 4;
				itemDefinition.modelColourToEdit[14] = 278;
				itemDefinition.newModelColourProduced[14] = colour == -1 ? 278 : colour;

				// Dark grey
				colour = 6;
				itemDefinition.modelColourToEdit[12] = 3346;
				itemDefinition.newModelColourProduced[12] = colour == -1 ? 3346 : colour;

				// Grey
				colour = 8;
				itemDefinition.modelColourToEdit[1] = -6070;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -6070 : colour;

				// Grey
				colour = 10;
				itemDefinition.modelColourToEdit[2] = -6083;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -6083 : colour;

				// Grey
				colour = 12;
				itemDefinition.modelColourToEdit[4] = -6095;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -6095 : colour;

				// Light grey
				colour = 14;
				itemDefinition.modelColourToEdit[8] = 6699;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? 6699 : colour;

				// Light grey
				colour = 14;
				itemDefinition.modelColourToEdit[11] = -6062;
				itemDefinition.newModelColourProduced[11] = colour == -1 ? -6062 : colour;

				// Yellow
				colour = 940;
				itemDefinition.modelColourToEdit[3] = 6602;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 6602 : colour;

				// Darker yellow
				colour = 950;
				itemDefinition.modelColourToEdit[7] = 6709;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 6709 : colour;

				// Darker yellow
				colour = 950;
				itemDefinition.modelColourToEdit[9] = 6736;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? 6736 : colour;

				// Blue
				colour = 16;
				itemDefinition.modelColourToEdit[5] = -22242;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22242 : colour;

				// Blue
				colour = 16;
				itemDefinition.modelColourToEdit[6] = -22122;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -22122 : colour;

				// Blue
				colour = 18;
				itemDefinition.modelColourToEdit[10] = -22237;
				itemDefinition.newModelColourProduced[10] = colour == -1 ? -22237 : colour;
				break;
			case 16416:
				itemDefinition.name = "Armadyl crossbow";
				itemDefinition.inventoryModel = 19967;
				itemDefinition.maleModel = 19839;
				itemDefinition.maleEquip2 = -1;
				itemDefinition.femaleModel = 19839;
				itemDefinition.femaleEquip2 = -1;
				itemDefinition.femaleEquipOffset = 6;
				itemDefinition.zoom = 1325;
				itemDefinition.rotationX = 110;
				itemDefinition.rotationY = 240;
				itemDefinition.inventoryX = -6;
				itemDefinition.inventoryY = -40;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[5];
				itemDefinition.modelColourToEdit[0] = 5409;
				itemDefinition.modelColourToEdit[1] = 5404;
				itemDefinition.modelColourToEdit[2] = 6449;
				itemDefinition.modelColourToEdit[3] = 7390;
				itemDefinition.newModelColourProduced = new int[5];
				itemDefinition.newModelColourProduced[0] = 4; // Was white
				itemDefinition.newModelColourProduced[1] = 15; // Was white
				itemDefinition.newModelColourProduced[2] = 933; // Was yellow
				itemDefinition.newModelColourProduced[3] = 927; // Was yellow

				// String colour, was grey
				colour = 4;
				itemDefinition.modelColourToEdit[4] = 8530;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 8530 : colour;
				break;
			case 16415:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", "Dismantle", null, null};
				itemDefinition.name = "Armadyl godsword";
				itemDefinition.inventoryModel = 28075;
				itemDefinition.zoom = 1957;
				itemDefinition.rotationY = 498;
				itemDefinition.rotationX = 484;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = -1;
				itemDefinition.maleModel = 27649;
				itemDefinition.femaleModel = 27649;

				itemDefinition.modelColourToEdit = new int[10];
				itemDefinition.newModelColourProduced = new int[10];

				// Hilt section where the hands are wrapped around
				colour = 933;
				itemDefinition.modelColourToEdit[0] = -22208;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -22208 : colour;

				// Hilt top section
				itemDefinition.modelColourToEdit[1] = -22477;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22477 : colour;

				// Hilt section various sides
				itemDefinition.modelColourToEdit[2] = -22464;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22464 : colour;

				// Hilt section, the bottom part, half of the furs
				itemDefinition.modelColourToEdit[3] = -24279;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -24279 : colour;

				// Hilt section, the bottom part, rest of the furs
				itemDefinition.modelColourToEdit[4] = -24271;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -24271 : colour;

				// Blade, left side
				colour = 7;
				itemDefinition.modelColourToEdit[5] = -22444;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22444 : colour;

				colour = 0;
				// Blade, right side
				itemDefinition.modelColourToEdit[6] = -22423;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -22423 : colour;

				colour = 0;
				// Blade decoration on the right
				itemDefinition.modelColourToEdit[7] = -22415;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -22415 : colour;

				// Blade tip on the right
				itemDefinition.modelColourToEdit[8] = -22419;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -22419 : colour;

				// Blade at the tip, inventory model only.
				itemDefinition.modelColourToEdit[9] = -22440;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? -22440 : colour;
				break;
			case 16413:
				itemDefinition.name = "Ghrazi rapier";
				itemDefinition.inventoryModel = 35739;
				itemDefinition.maleModel = 35374;
				itemDefinition.femaleModel = 35369;
				itemDefinition.zoom = 2064;
				itemDefinition.rotationX = 1603;
				itemDefinition.rotationZ = 552;
				itemDefinition.inventoryX = 5;
				itemDefinition.inventoryY = -18;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = "Drop";

				itemDefinition.modelColourToEdit = new int[8];
				itemDefinition.newModelColourProduced = new int[8];

				// Grey
				colour = 8128;
				itemDefinition.modelColourToEdit[2] = -22446;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22446 : colour;

				// White
				colour = 8135;
				itemDefinition.modelColourToEdit[4] = -22423;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -22423 : colour;

				// Dark grey
				colour = 17350;
				itemDefinition.modelColourToEdit[1] = -22386;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22386 : colour;

				// Red
				colour = 17350;
				itemDefinition.modelColourToEdit[0] = -1122;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -1122 : colour;

				// Dark grey
				itemDefinition.modelColourToEdit[3] = -22502;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -22502 : colour;

				// Grey
				itemDefinition.modelColourToEdit[6] = -22477;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -22477 : colour;

				// Light grey
				itemDefinition.modelColourToEdit[7] = -22506;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -22506 : colour;

				// Dark grey
				colour = 17350;
				itemDefinition.modelColourToEdit[5] = -22489;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22489 : colour;
				break;
			case 16412:
				itemDefinition.name = "Abyssal tentacle";
				itemDefinition.inventoryModel = 28439;
				itemDefinition.maleModel = 28446;
				itemDefinition.femaleModel = 28446;
				itemDefinition.zoom = 840;
				itemDefinition.rotationX = 121;
				itemDefinition.rotationY = 280;
				itemDefinition.inventoryY = 56;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = "Check";
				itemDefinition.inventoryOptions[4] = "Dissolve";

				itemDefinition.modelColourToEdit = new int[3];
				itemDefinition.newModelColourProduced = new int[3];

				// Stripe colour
				colour = 933;
				itemDefinition.modelColourToEdit[0] = 11150;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -22208 : colour;

				// Not used
				itemDefinition.modelColourToEdit[1] = 9108;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22477 : colour;

				// Spikes colour
				colour = 127;
				itemDefinition.modelColourToEdit[2] = 10355;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22464 : colour;
				break;
			case 16411:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", "Dismantle", null, null};
				itemDefinition.name = "Armadyl godsword";
				itemDefinition.inventoryModel = 28075;
				itemDefinition.zoom = 1957;
				itemDefinition.rotationY = 498;
				itemDefinition.rotationX = 484;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = -1;
				itemDefinition.maleModel = 27649;
				itemDefinition.femaleModel = 27649;

				itemDefinition.modelColourToEdit = new int[10];
				itemDefinition.newModelColourProduced = new int[10];

				// Hilt section where the hands are wrapped around
				colour = 933;
				itemDefinition.modelColourToEdit[0] = -22208;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -22208 : colour;

				// Hilt top section
				itemDefinition.modelColourToEdit[1] = -22477;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22477 : colour;

				// Hilt section various sides
				itemDefinition.modelColourToEdit[2] = -22464;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22464 : colour;

				// Hilt section, the bottom part, half of the furs
				itemDefinition.modelColourToEdit[3] = -24279;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -24279 : colour;

				// Hilt section, the bottom part, rest of the furs
				itemDefinition.modelColourToEdit[4] = -24271;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -24271 : colour;

				// Blade, left side
				colour = 35321;
				itemDefinition.modelColourToEdit[5] = -22444;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22444 : colour;

				colour = 127;
				// Blade, right side
				itemDefinition.modelColourToEdit[6] = -22423;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -22423 : colour;

				colour = 127;
				// Blade decoration on the right
				itemDefinition.modelColourToEdit[7] = -22415;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -22415 : colour;

				// Blade tip on the right
				itemDefinition.modelColourToEdit[8] = -22419;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -22419 : colour;

				// Blade at the tip, inventory model only.
				itemDefinition.modelColourToEdit[9] = -22440;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? -22440 : colour;
				break;
			case 419:
				itemDefinition.name = "Magic Note Paper";
				break;
			case 16410:
				itemDefinition.name = "Elder maul";
				itemDefinition.inventoryModel = 32792;
				itemDefinition.maleModel = 32678;
				itemDefinition.femaleModel = 32678;
				itemDefinition.zoom = 1744;
				itemDefinition.rotationX = 429;
				itemDefinition.rotationY = 237;
				itemDefinition.inventoryX = -3;
				itemDefinition.inventoryY = -58;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Orange dark
				colour = 0;
				itemDefinition.modelColourToEdit[0] = 5056;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 5056 : colour;

				// Orange dark
				colour = 0;
				itemDefinition.modelColourToEdit[1] = 8125;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 8125 : colour;

				// Dark grey
				colour = 16;
				itemDefinition.modelColourToEdit[2] = 16;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 16 : colour;

				// Dark grey
				colour = 20;
				itemDefinition.modelColourToEdit[5] = 20;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 20 : colour;

				// It was black
				colour = 0;
				itemDefinition.modelColourToEdit[3] = 0;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 0 : colour;

				// Grey
				colour = 33;
				itemDefinition.modelColourToEdit[4] = 33;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 33 : colour;
				break;
			case 16409:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", "Dismantle", null, null};
				itemDefinition.name = "Armadyl godsword";
				itemDefinition.inventoryModel = 28075;
				itemDefinition.zoom = 1957;
				itemDefinition.rotationY = 498;
				itemDefinition.rotationX = 484;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = -1;
				itemDefinition.maleModel = 27649;
				itemDefinition.femaleModel = 27649;

				itemDefinition.modelColourToEdit = new int[10];
				itemDefinition.newModelColourProduced = new int[10];

				// Hilt section where the hands are wrapped around
				colour = 461770;
				itemDefinition.modelColourToEdit[0] = -22208;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -22208 : colour;

				// Hilt top section
				itemDefinition.modelColourToEdit[1] = -22477;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22477 : colour;

				// Hilt section various sides
				itemDefinition.modelColourToEdit[2] = -22464;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22464 : colour;

				// Hilt section, the bottom part, half of the furs
				itemDefinition.modelColourToEdit[3] = -24279;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -24279 : colour;

				// Hilt section, the bottom part, rest of the furs
				itemDefinition.modelColourToEdit[4] = -24271;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -24271 : colour;

				// Blade, left side
				colour = 7114;
				itemDefinition.modelColourToEdit[5] = -22444;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22444 : colour;

				colour = 127;
				// Blade, right side
				itemDefinition.modelColourToEdit[6] = -22423;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -22423 : colour;

				colour = 127;
				// Blade decoration on the right
				itemDefinition.modelColourToEdit[7] = -22415;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -22415 : colour;

				// Blade tip on the right
				itemDefinition.modelColourToEdit[8] = -22419;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -22419 : colour;

				// Blade at the tip, inventory model only.
				itemDefinition.modelColourToEdit[9] = -22440;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? -22440 : colour;
				break;
			case 16408:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Sigil colour
				colour = -21568;
				itemDefinition.modelColourToEdit[1] = 127;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 127 : colour;

				// Shield colour
				colour = 22464;
				itemDefinition.modelColourToEdit[0] = -28716;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -28716 : colour;

				// Trim colour
				colour = 0;
				itemDefinition.modelColourToEdit[2] = -29116;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -29116 : colour;

				itemDefinition.modelColourToEdit[3] = -29019;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -29019 : colour;

				itemDefinition.modelColourToEdit[4] = -29125;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -29125 : colour;

				itemDefinition.modelColourToEdit[5] = -29110;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -29110 : colour;
				break;
			case 16407:
				itemDefinition.name = "Ghrazi rapier";
				itemDefinition.inventoryModel = 35739;
				itemDefinition.maleModel = 35374;
				itemDefinition.femaleModel = 35369;
				itemDefinition.zoom = 2064;
				itemDefinition.rotationX = 1603;
				itemDefinition.rotationZ = 552;
				itemDefinition.inventoryX = 5;
				itemDefinition.inventoryY = -18;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = "Drop";

				itemDefinition.modelColourToEdit = new int[8];
				itemDefinition.newModelColourProduced = new int[8];

				// Grey
				colour = 0;
				itemDefinition.modelColourToEdit[2] = -22446;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22446 : colour;

				// White
				colour = 10;
				itemDefinition.modelColourToEdit[4] = -22423;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -22423 : colour;

				// Dark grey
				colour = 51130;
				itemDefinition.modelColourToEdit[1] = -22386;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22386 : colour;

				// Red
				colour = 51130;
				itemDefinition.modelColourToEdit[0] = -1122;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -1122 : colour;

				// Dark grey
				itemDefinition.modelColourToEdit[3] = -22502;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -22502 : colour;

				// Grey
				itemDefinition.modelColourToEdit[6] = -22477;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -22477 : colour;

				// Light grey
				itemDefinition.modelColourToEdit[7] = -22506;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -22506 : colour;

				// Dark grey
				colour = 51130;
				itemDefinition.modelColourToEdit[5] = -22489;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22489 : colour;
				break;
			
		
			case 16406:
				itemDefinition.name = "Bandos chestplate";
				itemDefinition.inventoryModel = 28042;
				itemDefinition.maleModel = 27636;
				itemDefinition.maleEquip2 = 28826;
				itemDefinition.femaleModel = 27644;
				itemDefinition.femaleEquip2 = 28827;
				itemDefinition.zoom = 984;
				itemDefinition.rotationX = 6;
				itemDefinition.rotationY = 501;
				itemDefinition.inventoryX = 1;
				itemDefinition.inventoryY = 4;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[24];
				itemDefinition.newModelColourProduced = new int[24];

				// Very Light brown
				colour = 0;
				itemDefinition.modelColourToEdit[0] = 8367;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 8367 : colour;

				itemDefinition.modelColourToEdit[1] = 8384;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 8384 : colour;

				itemDefinition.modelColourToEdit[2] = 8375;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 8375 : colour;

				itemDefinition.modelColourToEdit[4] = 9523;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 9523 : colour;

				itemDefinition.modelColourToEdit[6] = 9515;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 9515 : colour;

				// Light brown
				colour = 51130;
				itemDefinition.modelColourToEdit[9] = 163;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? 163 : colour;

				itemDefinition.modelColourToEdit[18] = 10291;
				itemDefinition.newModelColourProduced[18] = colour == -1 ? 10291 : colour;

				itemDefinition.modelColourToEdit[19] = 10283;
				itemDefinition.newModelColourProduced[19] = colour == -1 ? 10283 : colour;

				itemDefinition.modelColourToEdit[20] = 10287;
				itemDefinition.newModelColourProduced[20] = colour == -1 ? 10287 : colour;

				// Brown
				colour = 51110;
				itemDefinition.modelColourToEdit[3] = 10266;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 10266 : colour;

				// Brown
				itemDefinition.modelColourToEdit[10] = 22;
				itemDefinition.newModelColourProduced[10] = colour == -1 ? 22 : colour;

				// Brown
				itemDefinition.modelColourToEdit[13] = 10275;
				itemDefinition.newModelColourProduced[13] = colour == -1 ? 10275 : colour;

				// Brown
				itemDefinition.modelColourToEdit[14] = 8379;
				itemDefinition.newModelColourProduced[14] = colour == -1 ? 8379 : colour;

				// Dark brown
				colour = 127;
				itemDefinition.modelColourToEdit[8] = 142;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? 142 : colour;

				// Dark brown
				itemDefinition.modelColourToEdit[12] = 8076;
				itemDefinition.newModelColourProduced[12] = colour == -1 ? 8076 : colour;

				// Unknown
				colour = -1;
				itemDefinition.modelColourToEdit[5] = 10502;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 10502 : colour;

				// Unknown
				colour = -1;
				itemDefinition.modelColourToEdit[7] = 4550;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 4550 : colour;

				// Unknown
				colour = -1;
				itemDefinition.modelColourToEdit[11] = 9403;
				itemDefinition.newModelColourProduced[11] = colour == -1 ? 9403 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[15] = 10266;
				itemDefinition.newModelColourProduced[15] = colour == -1 ? 10266 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[16] = 10275;
				itemDefinition.newModelColourProduced[16] = colour == -1 ? 10275 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[17] = 4550;
				itemDefinition.newModelColourProduced[17] = colour == -1 ? 4550 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[21] = 8367;
				itemDefinition.newModelColourProduced[21] = colour == -1 ? 8367 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[22] = 8384;
				itemDefinition.newModelColourProduced[22] = colour == -1 ? 8384 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[23] = 8375;
				itemDefinition.newModelColourProduced[23] = colour == -1 ? 8375 : colour;
				break;
			case 16405:
				itemDefinition.name = "Bandos tassets";
				itemDefinition.inventoryModel = 28047;
				itemDefinition.maleModel = 27625;
				itemDefinition.femaleModel = 27640;
				itemDefinition.zoom = 854;
				itemDefinition.rotationX = 2039;
				itemDefinition.rotationY = 540;
				itemDefinition.inventoryX = 3;
				itemDefinition.inventoryY = 3;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[7];
				itemDefinition.newModelColourProduced = new int[7];

				colour = -1;
				itemDefinition.modelColourToEdit[0] = 4550;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 4550 : colour;

				colour = 51105;
				itemDefinition.modelColourToEdit[1] = 22;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 22 : colour;

				colour = 51100;
				itemDefinition.modelColourToEdit[2] = 163;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 163 : colour;

				colour = 51100;
				itemDefinition.modelColourToEdit[3] = 154;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 154 : colour;

				colour = 51130;
				itemDefinition.modelColourToEdit[4] = 39;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 39 : colour;

				colour = 127;
				itemDefinition.modelColourToEdit[5] = 9523;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 9523 : colour;

				colour = 0;
				itemDefinition.modelColourToEdit[6] = 8390;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 8390 : colour;
				break;
			case 16404:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", "Dismantle", null, null};
				itemDefinition.name = "Armadyl godsword";
				itemDefinition.inventoryModel = 28075;
				itemDefinition.zoom = 1957;
				itemDefinition.rotationY = 498;
				itemDefinition.rotationX = 484;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = -1;
				itemDefinition.maleModel = 27649;
				itemDefinition.femaleModel = 27649;

				itemDefinition.modelColourToEdit = new int[10];
				itemDefinition.newModelColourProduced = new int[10];

				// Hilt section where the hands are wrapped around
				colour = 51136;
				itemDefinition.modelColourToEdit[0] = -22208;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -22208 : colour;

				// Hilt top section
				itemDefinition.modelColourToEdit[1] = -22477;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22477 : colour;

				// Hilt section various sides
				itemDefinition.modelColourToEdit[2] = -22464;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22464 : colour;

				// Hilt section, the bottom part, half of the furs
				itemDefinition.modelColourToEdit[3] = -24279;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -24279 : colour;

				// Hilt section, the bottom part, rest of the furs
				itemDefinition.modelColourToEdit[4] = -24271;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -24271 : colour;

				// Blade, left side
				colour = 0;
				itemDefinition.modelColourToEdit[5] = -22444;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22444 : colour;

				colour = 127;
				// Blade, right side
				itemDefinition.modelColourToEdit[6] = -22423;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -22423 : colour;

				colour = 127;
				// Blade decoration on the right
				itemDefinition.modelColourToEdit[7] = -22415;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -22415 : colour;

				// Blade tip on the right
				itemDefinition.modelColourToEdit[8] = -22419;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -22419 : colour;

				// Blade at the tip, inventory model only.
				itemDefinition.modelColourToEdit[9] = -22440;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? -22440 : colour;
				break;
			case 16403:
				itemDefinition.name = "Dragon claws";
				itemDefinition.femaleModel = 29191;
				itemDefinition.femaleEquipOffset = 6;
				itemDefinition.inventoryOptions = new String[]
				{null, "Wear", null, null, null};
				itemDefinition.inventoryModel = 32784;
				itemDefinition.maleModel = 29191;
				itemDefinition.rotationY = 349;
				itemDefinition.inventoryX = 0;
				itemDefinition.rotationX = 15;
				itemDefinition.inventoryY = 8;
				itemDefinition.zoom = 886;

				itemDefinition.modelColourToEdit = new int[4];
				itemDefinition.newModelColourProduced = new int[4];

				colour = 51130;
				itemDefinition.modelColourToEdit[0] = 929;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 929 : colour;

				itemDefinition.modelColourToEdit[2] = 918;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 918 : colour;

				colour = 0;
				itemDefinition.modelColourToEdit[1] = 922;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 922 : colour;

				itemDefinition.modelColourToEdit[3] = 914;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 914 : colour;
				break;
			case 16274:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Sigil colour
				colour = 10;
				itemDefinition.modelColourToEdit[1] = 127;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 127 : colour;

				colour = 8128;
				itemDefinition.modelColourToEdit[0] = -28716;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -28716 : colour;

				itemDefinition.modelColourToEdit[2] = -29116;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -29116 : colour;

				itemDefinition.modelColourToEdit[3] = -29019;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -29019 : colour;

				itemDefinition.modelColourToEdit[4] = -29125;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -29125 : colour;

				itemDefinition.modelColourToEdit[5] = -29110;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -29110 : colour;
				break;
			case 16273:
				itemDefinition.name = "Wise old man's santa hat";
				itemDefinition.inventoryModel = 34601;
				itemDefinition.maleModel = 34426;
				itemDefinition.femaleModel = 34434;
				itemDefinition.zoom = 540;
				itemDefinition.rotationX = 136;
				itemDefinition.rotationY = 72;
				itemDefinition.inventoryY = -3;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = "Destroy";
				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Partyhat colour
				colour = 127;
				itemDefinition.modelColourToEdit[0] = -21573;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -21573 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[1] = 929;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 929 : colour;

				// Santa hat colour
				colour = 0;
				itemDefinition.modelColourToEdit[2] = 931;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 931 : colour;
				itemDefinition.modelColourToEdit[3] = 935;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 935 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[4] = 7401;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 7401 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[5] = 7518;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 7518 : colour;
				break;
			case 16272:
				itemDefinition.name = "Toxic staff of the dead";
				itemDefinition.inventoryModel = 19224;
				itemDefinition.maleModel = 14402;
				itemDefinition.femaleModel = 14402;
				itemDefinition.zoom = 2150;
				itemDefinition.rotationX = 1010;
				itemDefinition.rotationY = 512;
				itemDefinition.rotationZ = 229;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = "Check";
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = "Uncharge";

				itemDefinition.modelColourToEdit = new int[15];
				itemDefinition.newModelColourProduced = new int[15];

				// Long handle stick
				colour = 34770;
				itemDefinition.modelColourToEdit[0] = -15842;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -15842 : colour;

				// Top and bottom part of the staff colour
				colour = 935;
				itemDefinition.modelColourToEdit[1] = 16578;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 16578 : colour;

				colour = 476770;
				itemDefinition.modelColourToEdit[2] = 16309;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 16309 : colour;

				colour = 21662;
				itemDefinition.modelColourToEdit[3] = 10462;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 10462 : colour;

				colour = 51136;
				itemDefinition.modelColourToEdit[4] = 10448;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 10448 : colour;

				colour = 428770;
				// Part of orb colour
				itemDefinition.modelColourToEdit[5] = 127;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 127 : colour;

				colour = 419770;
				// Orb skull colour
				itemDefinition.modelColourToEdit[6] = 10475;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 10475 : colour;

				colour = 359770;
				// Back of tip colour
				itemDefinition.modelColourToEdit[7] = -10963;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -10963 : colour;

				colour = 338770;
				// Back of tip colour
				itemDefinition.modelColourToEdit[8] = -10951;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -10951 : colour;

				colour = 290770;
				// Back of tip colour
				itemDefinition.modelColourToEdit[9] = -10821;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? -10821 : colour;

				colour = 226770;
				// Inside of orb skull colour
				itemDefinition.modelColourToEdit[10] = -10329;
				itemDefinition.newModelColourProduced[10] = colour == -1 ? -10329 : colour;

				colour = 76770;
				// Inside of orb at the back of it
				itemDefinition.modelColourToEdit[11] = -10594;
				itemDefinition.newModelColourProduced[11] = colour == -1 ? -10594 : colour;

				colour = 92770;
				// Inside of orb, tiny strip colour
				itemDefinition.modelColourToEdit[12] = -10317;
				itemDefinition.newModelColourProduced[12] = colour == -1 ? -10317 : colour;

				colour = 123770;
				// Inside of orb, tiny strip colour
				itemDefinition.modelColourToEdit[13] = -10311;
				itemDefinition.newModelColourProduced[13] = colour == -1 ? -10311 : colour;

				colour = 933;
				// Inside of orb, at the back colour
				itemDefinition.modelColourToEdit[14] = 24;
				itemDefinition.newModelColourProduced[14] = colour == -1 ? 24 : colour;
				break;
			case 16271:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", "Dismantle", null, null};
				itemDefinition.name = "Armadyl godsword";
				itemDefinition.inventoryModel = 28075;
				itemDefinition.zoom = 1957;
				itemDefinition.rotationY = 498;
				itemDefinition.rotationX = 484;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = -1;
				itemDefinition.maleModel = 27649;
				itemDefinition.femaleModel = 27649;

				itemDefinition.modelColourToEdit = new int[10];
				itemDefinition.newModelColourProduced = new int[10];

				// Hilt section where the hands are wrapped around
				colour = 38693;
				itemDefinition.modelColourToEdit[0] = -22208;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -22208 : colour;

				// Hilt top section
				itemDefinition.modelColourToEdit[1] = -22477;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22477 : colour;

				// Hilt section various sides
				itemDefinition.modelColourToEdit[2] = -22464;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22464 : colour;

				colour = 120;
				// Hilt section, the bottom part, half of the furs
				itemDefinition.modelColourToEdit[3] = -24279;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -24279 : colour;

				// Hilt section, the bottom part, rest of the furs
				itemDefinition.modelColourToEdit[4] = -24271;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -24271 : colour;

				// Blade, left side
				colour = 675;
				itemDefinition.modelColourToEdit[5] = -22444;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22444 : colour;

				colour = 120;
				// Blade, right side
				itemDefinition.modelColourToEdit[6] = -22423;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -22423 : colour;

				// Blade decoration on the right
				itemDefinition.modelColourToEdit[7] = -22415;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -22415 : colour;

				// Blade tip on the right
				itemDefinition.modelColourToEdit[8] = -22419;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -22419 : colour;

				colour = 675;
				// Blade at the tip, inventory model only.
				itemDefinition.modelColourToEdit[9] = -22440;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? -22440 : colour;
				break;
			case 16270:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Sigil colour
				colour = 311770;
				itemDefinition.modelColourToEdit[1] = 127;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 127 : colour;

				colour = 374770;
				itemDefinition.modelColourToEdit[0] = -28716;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -28716 : colour;

				itemDefinition.modelColourToEdit[2] = -29116;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -29116 : colour;

				itemDefinition.modelColourToEdit[3] = -29019;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -29019 : colour;

				itemDefinition.modelColourToEdit[4] = -29125;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -29125 : colour;

				itemDefinition.modelColourToEdit[5] = -29110;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -29110 : colour;
				break;
			case 16269:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Sigil colour
				colour = 70;
				itemDefinition.modelColourToEdit[1] = 127;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 127 : colour;

				colour = 937;
				itemDefinition.modelColourToEdit[0] = -28716;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -28716 : colour;

				itemDefinition.modelColourToEdit[2] = -29116;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -29116 : colour;

				itemDefinition.modelColourToEdit[3] = -29019;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -29019 : colour;

				itemDefinition.modelColourToEdit[4] = -29125;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -29125 : colour;

				itemDefinition.modelColourToEdit[5] = -29110;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -29110 : colour;
				break;
			case 16268:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Sigil colour
				colour = 58325;
				itemDefinition.modelColourToEdit[1] = 127;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 127 : colour;

				colour = 58325;
				itemDefinition.modelColourToEdit[0] = -28716;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -28716 : colour;

				itemDefinition.modelColourToEdit[2] = -29116;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -29116 : colour;

				itemDefinition.modelColourToEdit[3] = -29019;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -29019 : colour;

				itemDefinition.modelColourToEdit[4] = -29125;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -29125 : colour;

				itemDefinition.modelColourToEdit[5] = -29110;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -29110 : colour;
				break;
			case 16267:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Sigil colour
				colour = 51136;
				itemDefinition.modelColourToEdit[1] = 127;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 127 : colour;

				colour = 10;
				itemDefinition.modelColourToEdit[0] = -28716;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -28716 : colour;

				itemDefinition.modelColourToEdit[2] = -29116;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -29116 : colour;

				itemDefinition.modelColourToEdit[3] = -29019;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -29019 : colour;

				itemDefinition.modelColourToEdit[4] = -29125;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -29125 : colour;

				itemDefinition.modelColourToEdit[5] = -29110;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -29110 : colour;
				break;
			case 16266:
				itemDefinition.name = "Unlock Infernal, Max capes & Imbued capes scroll";
				itemDefinition.inventoryModel = 2600;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 1040;
				itemDefinition.rotationX = 120;
				itemDefinition.rotationY = 380;
				itemDefinition.inventoryX = 1;
				itemDefinition.inventoryY = 7;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = "Read";
				itemDefinition.inventoryOptions[1] = null;
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[1];
				itemDefinition.modelColourToEdit[0] = 10351;
				itemDefinition.newModelColourProduced = new int[1];
				itemDefinition.newModelColourProduced[0] = 926;
				itemDefinition.description = "Consume scroll to wear Infernal, Max capes, Imbued God capes and 99 capes.".getBytes();
				break;
			case 16265:
				itemDefinition.name = "Veteran cape (broken)";
				itemDefinition.inventoryModel = 65261;
				itemDefinition.zoom = 1513;
				itemDefinition.rotationY = 279;
				itemDefinition.rotationX = 948;
				itemDefinition.inventoryX = -3;
				itemDefinition.inventoryY = 24;
				itemDefinition.maleModel = 65305;
				itemDefinition.femaleModel = 65318;
				itemDefinition.brightness = -45;
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				break;

			case 16264:
				itemDefinition.inventoryModel = 65270;
				itemDefinition.name = "Comp. cape (broken)";
				itemDefinition.zoom = 1513;
				itemDefinition.rotationY = 279;
				itemDefinition.rotationX = 948;
				itemDefinition.inventoryX = -3;
				itemDefinition.inventoryY = 24;
				itemDefinition.maleModel = 65297;
				itemDefinition.femaleModel = 65316;
				itemDefinition.brightness = -45;
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				break;
			case 16263:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Sigil colour
				colour = 7114;
				itemDefinition.modelColourToEdit[1] = 127;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 127 : colour;

				colour = 10;
				itemDefinition.modelColourToEdit[0] = -28716;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -28716 : colour;

				itemDefinition.modelColourToEdit[2] = -29116;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -29116 : colour;

				itemDefinition.modelColourToEdit[3] = -29019;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -29019 : colour;

				itemDefinition.modelColourToEdit[4] = -29125;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -29125 : colour;

				itemDefinition.modelColourToEdit[5] = -29110;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -29110 : colour;
				break;
			case 16262:
				itemDefinition.name = "Nocturnal Yoshi";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 750;
				itemDefinition.rotationY = 100;
				itemDefinition.rotationX = 250;
				itemDefinition.inventoryX = 10;
				itemDefinition.inventoryY = 100;
				npcInstance = EntityDefinition.forId(1873);
				itemDefinition.inventoryModel = npcInstance.models[0];

				itemDefinition.modelColourToEdit = new int[8];
				itemDefinition.newModelColourProduced = new int[8];
				colour = 51136;
				itemDefinition.modelColourToEdit[0] = 29976;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 29976 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[1] = 7502;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 7502 : colour;

				colour = 50000;
				itemDefinition.modelColourToEdit[2] = 27819;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 27819 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[3] = 0;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 0 : colour;

				colour = 51136;
				itemDefinition.modelColourToEdit[4] = 29980;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 29980 : colour;

				colour = 51136;
				itemDefinition.modelColourToEdit[5] = 28302;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 28302 : colour;

				colour = 51136;
				itemDefinition.modelColourToEdit[6] = 29980;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 29980 : colour;

				colour = 50000;
				itemDefinition.modelColourToEdit[7] = 27934;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 27934 : colour;
				break;

			case 16261:
				npcInstance = EntityDefinition.forId(6768);
				itemDefinition.name = npcInstance.name + " pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 2400;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;

			case 16260:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", "Dismantle", null, null};
				itemDefinition.name = "Armadyl godsword";
				itemDefinition.inventoryModel = 28075;
				itemDefinition.zoom = 1957;
				itemDefinition.rotationY = 498;
				itemDefinition.rotationX = 484;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = -1;
				itemDefinition.maleModel = 27649;
				itemDefinition.femaleModel = 27649;

				itemDefinition.modelColourToEdit = new int[10];
				itemDefinition.newModelColourProduced = new int[10];

				// Hilt section where the hands are wrapped around
				colour = 49863;
				itemDefinition.modelColourToEdit[0] = -22208;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -22208 : colour;

				// Hilt top section
				itemDefinition.modelColourToEdit[1] = -22477;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22477 : colour;

				// Hilt section various sides
				itemDefinition.modelColourToEdit[2] = -22464;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22464 : colour;

				// Hilt section, the bottom part, half of the furs
				itemDefinition.modelColourToEdit[3] = -24279;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -24279 : colour;

				// Hilt section, the bottom part, rest of the furs
				itemDefinition.modelColourToEdit[4] = -24271;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -24271 : colour;

				// Blade, left side
				colour = 49863;
				itemDefinition.modelColourToEdit[5] = -22444;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22444 : colour;

				// Blade, right side
				itemDefinition.modelColourToEdit[6] = -22423;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -22423 : colour;

				// Blade decoration on the right
				itemDefinition.modelColourToEdit[7] = -22415;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -22415 : colour;

				// Blade tip on the right
				itemDefinition.modelColourToEdit[8] = -22419;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -22419 : colour;

				// Blade at the tip, inventory model only.
				itemDefinition.modelColourToEdit[9] = -22440;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? -22440 : colour;
				break;

			case 7001:
				itemDefinition.name = "Bearded camel pet";
				break;
			case 16259:
				itemDefinition.name = "Dinh's bulwark";
				itemDefinition.inventoryModel = 32801;
				itemDefinition.maleModel = 32671;
				itemDefinition.femaleModel = 32671;
				itemDefinition.zoom = 2276;
				itemDefinition.rotationX = 1409;
				itemDefinition.rotationY = 402;
				itemDefinition.inventoryY = 4;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[13];
				itemDefinition.newModelColourProduced = new int[13];

				// Grey
				colour = 356770;
				itemDefinition.modelColourToEdit[0] = -32721;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -32721 : colour;

				// Grey
				itemDefinition.modelColourToEdit[1] = -32713;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -32713 : colour;

				// Grey
				itemDefinition.modelColourToEdit[2] = -32729;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -32729 : colour;

				// Grey
				itemDefinition.modelColourToEdit[7] = 19742;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 19742 : colour;

				// Grey
				itemDefinition.modelColourToEdit[11] = -32723;
				itemDefinition.newModelColourProduced[11] = colour == -1 ? -32723 : colour;

				// Grey
				itemDefinition.modelColourToEdit[12] = -32704;
				itemDefinition.newModelColourProduced[12] = colour == -1 ? -32704 : colour;

				// Very dark grey
				colour = 7114;
				itemDefinition.modelColourToEdit[4] = -32750;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -32750 : colour;

				// Very very dark grey
				colour = -1;
				itemDefinition.modelColourToEdit[6] = -32626;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -32626 : colour;

				// Dark grey
				colour = 933;
				itemDefinition.modelColourToEdit[8] = -32738;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -32738 : colour;

				// Dark grey
				itemDefinition.modelColourToEdit[10] = 17682;
				itemDefinition.newModelColourProduced[10] = colour == -1 ? 17682 : colour;

				// Dark grey
				itemDefinition.modelColourToEdit[3] = -32742;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -32742 : colour;

				// Dark grey
				itemDefinition.modelColourToEdit[5] = -32733;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -32733 : colour;

				// Green
				colour = 338770;
				itemDefinition.modelColourToEdit[9] = 16687;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? 16687 : colour;
				break;
			case 16258:
				itemDefinition.name = "Dragon claws";
				itemDefinition.femaleModel = 29191;
				itemDefinition.femaleEquipOffset = 6;
				itemDefinition.inventoryOptions = new String[]
				{null, "Wear", null, null, null};
				itemDefinition.inventoryModel = 32784;
				itemDefinition.maleModel = 29191;
				itemDefinition.rotationY = 349;
				itemDefinition.inventoryX = 0;
				itemDefinition.rotationX = 15;
				itemDefinition.inventoryY = 8;
				itemDefinition.zoom = 886;
				itemDefinition.modelColourToEdit = new int[]
				{929, 922, 918, 914};
				itemDefinition.newModelColourProduced = new int[]
				{34770, 34770, 34770, 34770};
				break;
			case 16257:
				itemDefinition.name = "Abyssal tentacle";
				itemDefinition.inventoryModel = 28439;
				itemDefinition.maleModel = 28446;
				itemDefinition.femaleModel = 28446;
				itemDefinition.zoom = 840;
				itemDefinition.rotationX = 121;
				itemDefinition.rotationY = 280;
				itemDefinition.inventoryY = 56;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = "Check";
				itemDefinition.inventoryOptions[4] = "Dissolve";

				itemDefinition.modelColourToEdit = new int[3];
				itemDefinition.newModelColourProduced = new int[3];

				// Stripe colour
				colour = 332770;
				itemDefinition.modelColourToEdit[0] = 11150;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -22208 : colour;

				// Not used
				itemDefinition.modelColourToEdit[1] = 9108;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22477 : colour;

				// Spikes colour
				itemDefinition.modelColourToEdit[2] = 10355;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22464 : colour;
				break;
			case 16256:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Sigil colour
				colour = -1;
				itemDefinition.modelColourToEdit[1] = 127;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 127 : colour;

				colour = 332770;
				itemDefinition.modelColourToEdit[0] = -28716;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -28716 : colour;

				itemDefinition.modelColourToEdit[2] = -29116;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -29116 : colour;

				itemDefinition.modelColourToEdit[3] = -29019;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -29019 : colour;

				itemDefinition.modelColourToEdit[4] = -29125;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -29125 : colour;

				itemDefinition.modelColourToEdit[5] = -29110;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -29110 : colour;
				break;
			case 16255:
				itemDefinition.name = "Elder maul";
				itemDefinition.inventoryModel = 32792;
				itemDefinition.maleModel = 32678;
				itemDefinition.femaleModel = 32678;
				itemDefinition.zoom = 1744;
				itemDefinition.rotationX = 429;
				itemDefinition.rotationY = 237;
				itemDefinition.inventoryX = -3;
				itemDefinition.inventoryY = -58;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				break;
			case 16254:
				itemDefinition.name = "X1 Custom pet point scroll";
				itemDefinition.inventoryModel = 2600;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 1040;
				itemDefinition.rotationX = 120;
				itemDefinition.rotationY = 380;
				itemDefinition.inventoryX = 1;
				itemDefinition.inventoryY = 7;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = "Read";
				itemDefinition.inventoryOptions[1] = null;
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[1];
				itemDefinition.modelColourToEdit[0] = 10351;
				itemDefinition.newModelColourProduced = new int[1];
				itemDefinition.newModelColourProduced[0] = 49863;
				itemDefinition.description = "Redeem this scroll to earn gain x1 custom pet point.".getBytes();
				break;

			case 16253:
				itemInstance = ItemDefinition.forId(13316);
				itemDefinition.inventoryModel = itemInstance.inventoryModel;
				itemDefinition.newModelColourProduced = itemInstance.newModelColourProduced;
				itemDefinition.modelColourToEdit = itemInstance.modelColourToEdit;
				itemDefinition.zoom = itemInstance.zoom;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.name = "Blood money x1";
				break;
			case 16252:
				itemDefinition.name = "Xp lamp 350k";
				itemDefinition.inventoryModel = 3348;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 840;
				itemDefinition.rotationX = 228;
				itemDefinition.rotationY = 28;
				itemDefinition.inventoryX = 2;
				itemDefinition.inventoryY = -2;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = "Rub";
				itemDefinition.inventoryOptions[1] = null;
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = "Destroy";
				itemDefinition.modelColourToEdit = new int[2];
				itemDefinition.modelColourToEdit[0] = 11191;
				itemDefinition.modelColourToEdit[1] = 11183;
				itemDefinition.newModelColourProduced = new int[2];
				itemDefinition.newModelColourProduced[0] = 8008;
				itemDefinition.newModelColourProduced[1] = 8755;
				break;
			case 16251:
				itemDefinition.name = "Xp lamp 2 million";
				itemDefinition.inventoryModel = 3348;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 840;
				itemDefinition.rotationX = 228;
				itemDefinition.rotationY = 28;
				itemDefinition.inventoryX = 2;
				itemDefinition.inventoryY = -2;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = "Rub";
				itemDefinition.inventoryOptions[1] = null;
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = "Destroy";
				itemDefinition.modelColourToEdit = new int[2];
				itemDefinition.modelColourToEdit[0] = 11191;
				itemDefinition.modelColourToEdit[1] = 11183;
				itemDefinition.newModelColourProduced = new int[2];
				itemDefinition.newModelColourProduced[0] = 8008;
				itemDefinition.newModelColourProduced[1] = 8755;
				break;
			case 16250:
				npcInstance = EntityDefinition.forId(2510);
				itemDefinition.name = npcInstance.name + " pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 1500;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 10;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16249:
				itemInstance = ItemDefinition.forId(1004);
				itemDefinition.inventoryModel = itemInstance.inventoryModel;
				itemDefinition.newModelColourProduced = itemInstance.newModelColourProduced;
				itemDefinition.modelColourToEdit = itemInstance.modelColourToEdit;
				itemDefinition.zoom = itemInstance.zoom;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.name = "Coins 10,000";
				break;
			case 16248:
				itemDefinition.unNotedId = 16249;
				itemDefinition.notedItemTemplate = 799;
				break;
			case 16246:
				itemInstance = ItemDefinition.forId(1004);
				itemDefinition.inventoryModel = itemInstance.inventoryModel;
				itemDefinition.newModelColourProduced = itemInstance.newModelColourProduced;
				itemDefinition.modelColourToEdit = itemInstance.modelColourToEdit;
				itemDefinition.zoom = itemInstance.zoom;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.name = "Coins " + WebsiteRead.voteReward;
				break;
			case 16247:
				itemInstance = ItemDefinition.forId(1004);
				itemDefinition.inventoryModel = itemInstance.inventoryModel;
				itemDefinition.newModelColourProduced = itemInstance.newModelColourProduced;
				itemDefinition.modelColourToEdit = itemInstance.modelColourToEdit;
				itemDefinition.zoom = itemInstance.zoom;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.name = "Coins 5m";
				break;
			case 16244:
				itemDefinition.unNotedId = 16246;
				itemDefinition.notedItemTemplate = 799;
				break;
			case 16245:
				itemDefinition.unNotedId = 16247;
				itemDefinition.notedItemTemplate = 799;
				break;
			case 16243:
				npcInstance = EntityDefinition.forId(6636);
				itemDefinition.name = "White prince black dragon pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 2000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = 28872;

				itemDefinition.modelColourToEdit = new int[19];
				itemDefinition.newModelColourProduced = new int[19];

				colour = 127;
				itemDefinition.modelColourToEdit[1] = 10502;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 10502 : colour;

				itemDefinition.modelColourToEdit[3] = 11140;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 11140 : colour;

				itemDefinition.modelColourToEdit[4] = 10378;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 10378 : colour;

				itemDefinition.modelColourToEdit[9] = 33;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? 33 : colour;

				itemDefinition.modelColourToEdit[12] = 24;
				itemDefinition.newModelColourProduced[12] = colour == -1 ? 24 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[0] = -14400;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -14400 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[2] = -21630;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -21630 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[5] = 0;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 0 : colour;

				colour = 0;
				itemDefinition.modelColourToEdit[6] = 809;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 809 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[7] = 5198;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 5198 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[8] = 5206;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? 5206 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[10] = 5214;
				itemDefinition.newModelColourProduced[10] = colour == -1 ? 5214 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[11] = 5219;
				itemDefinition.newModelColourProduced[11] = colour == -1 ? 5219 : colour;


				colour = 127;
				itemDefinition.modelColourToEdit[12] = 10378;
				itemDefinition.newModelColourProduced[12] = colour == -1 ? 10378 : colour;

				itemDefinition.modelColourToEdit[13] = 10502;
				itemDefinition.newModelColourProduced[13] = colour == -1 ? 10502 : colour;

				itemDefinition.modelColourToEdit[14] = 11140;
				itemDefinition.newModelColourProduced[14] = colour == -1 ? 11140 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[15] = 33;
				itemDefinition.newModelColourProduced[15] = colour == -1 ? 33 : colour;

				itemDefinition.modelColourToEdit[16] = 24;
				itemDefinition.newModelColourProduced[16] = colour == -1 ? 24 : colour;

				itemDefinition.modelColourToEdit[18] = 5206;
				itemDefinition.newModelColourProduced[18] = colour == -1 ? 5206 : colour;

				colour = 127;
				itemDefinition.modelColourToEdit[17] = 11138;
				itemDefinition.newModelColourProduced[17] = colour == -1 ? 11138 : colour;
				break;
			case 16242:
				npcInstance = EntityDefinition.forId(762);
				itemDefinition.name = npcInstance.name + " pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 2000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 200;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16241:
				npcInstance = EntityDefinition.forId(548);
				itemDefinition.name = npcInstance.name + " pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 1300;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16240:
				objectInstance = ObjectDefinition.forId(8091);
				itemDefinition.name = objectInstance.name + " pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 5000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = objectInstance.models[0];
				break;
			case 16239:
				objectInstance = ObjectDefinition.forId(29146);
				itemDefinition.name = objectInstance.name + " pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 2000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 200;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = objectInstance.models[0];
				break;
			case 16238:
				npcInstance = EntityDefinition.forId(404);
				itemDefinition.name = npcInstance.name + " pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 1750;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 45;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16237:
				npcInstance = EntityDefinition.forId(3837);
				itemDefinition.name = npcInstance.name + " pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 1000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 76;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16236:
				npcInstance = EntityDefinition.forId(1241);
				itemDefinition.name = npcInstance.name + " pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 1000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 20;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16235:
				npcInstance = EntityDefinition.forId(2474);
				itemDefinition.name = npcInstance.name + " pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 2000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16234:
				npcInstance = EntityDefinition.forId(7039);
				itemDefinition.name = npcInstance.name + " pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 3000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 213;
				itemDefinition.inventoryX = 110;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16233:
				itemDefinition.name = "Blue Tekton pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 8000;
				itemDefinition.rotationY = 100;
				itemDefinition.rotationX = 100;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				npcInstance = EntityDefinition.forId(7544);
				itemDefinition.inventoryModel = npcInstance.models[0];

				itemDefinition.modelColourToEdit = new int[20];
				itemDefinition.newModelColourProduced = new int[20];
				colour = -1;
				itemDefinition.modelColourToEdit[0] = 24;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 24 : colour;

				itemDefinition.modelColourToEdit[1] = 8;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 8 : colour;

				colour = 302770;
				itemDefinition.modelColourToEdit[2] = 5056;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 5056 : colour;

				itemDefinition.modelColourToEdit[3] = 7101;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 7101 : colour;

				itemDefinition.modelColourToEdit[4] = 4382;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 4382 : colour;

				itemDefinition.modelColourToEdit[5] = 3005;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 3005 : colour;

				itemDefinition.modelColourToEdit[6] = 4029;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 4029 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[7] = 33;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 33 : colour;

				itemDefinition.modelColourToEdit[8] = 28;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? 28 : colour;

				colour = 302770;
				itemDefinition.modelColourToEdit[9] = 8125;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? 8125 : colour;

				itemDefinition.modelColourToEdit[10] = 9152;
				itemDefinition.newModelColourProduced[10] = colour == -1 ? 9152 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[11] = 16;
				itemDefinition.newModelColourProduced[11] = colour == -1 ? 16 : colour;

				itemDefinition.modelColourToEdit[12] = 20;
				itemDefinition.newModelColourProduced[12] = colour == -1 ? 20 : colour;

				colour = 302770;
				itemDefinition.modelColourToEdit[13] = 3778;
				itemDefinition.newModelColourProduced[13] = colour == -1 ? 3778 : colour;

				itemDefinition.modelColourToEdit[14] = 4641;
				itemDefinition.newModelColourProduced[14] = colour == -1 ? 4641 : colour;

				itemDefinition.modelColourToEdit[15] = 3520;
				itemDefinition.newModelColourProduced[15] = colour == -1 ? 3520 : colour;

				itemDefinition.modelColourToEdit[16] = 4409;
				itemDefinition.newModelColourProduced[16] = colour == -1 ? 4409 : colour;

				itemDefinition.modelColourToEdit[17] = 4271;
				itemDefinition.newModelColourProduced[17] = colour == -1 ? 4271 : colour;

				itemDefinition.modelColourToEdit[18] = 5157;
				itemDefinition.newModelColourProduced[18] = colour == -1 ? 5157 : colour;

				itemDefinition.modelColourToEdit[19] = 957;
				itemDefinition.newModelColourProduced[19] = colour == -1 ? 957 : colour;
				break;
			case 16232:
				itemDefinition.name = "Bandos tassets";
				itemDefinition.inventoryModel = 28047;
				itemDefinition.maleModel = 27625;
				itemDefinition.femaleModel = 27640;
				itemDefinition.zoom = 854;
				itemDefinition.rotationX = 2039;
				itemDefinition.rotationY = 540;
				itemDefinition.inventoryX = 3;
				itemDefinition.inventoryY = 3;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[7];
				itemDefinition.newModelColourProduced = new int[7];


				green = 100;
				red = 302770;
				yellow = 127;
				blue = 302770;

				colour = -1;
				itemDefinition.modelColourToEdit[0] = 4550;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 4550 : colour;

				colour = red;
				itemDefinition.modelColourToEdit[1] = 22;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 22 : colour;

				colour = red;
				itemDefinition.modelColourToEdit[2] = 163;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 163 : colour;

				colour = red;
				itemDefinition.modelColourToEdit[3] = 154;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 154 : colour;

				colour = blue;
				itemDefinition.modelColourToEdit[4] = 39;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 39 : colour;

				colour = yellow;
				itemDefinition.modelColourToEdit[5] = 9523;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 9523 : colour;

				colour = green;
				itemDefinition.modelColourToEdit[6] = 8390;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 8390 : colour;
				break;

			case 16231:
				itemDefinition.name = "Bandos chestplate";
				itemDefinition.inventoryModel = 28042;
				itemDefinition.maleModel = 27636;
				itemDefinition.femaleModel = 27644;
				itemDefinition.zoom = 984;
				itemDefinition.rotationX = 6;
				itemDefinition.rotationY = 501;
				itemDefinition.inventoryX = 1;
				itemDefinition.inventoryY = 4;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[15];
				itemDefinition.newModelColourProduced = new int[15];

				//Red yellow green blue

				green = 100;
				red = 302770;
				yellow = 127;
				blue = 302770;
				// Light brown
				colour = green;
				itemDefinition.modelColourToEdit[0] = 8367;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 8367 : colour;

				// Light brown
				colour = green;
				itemDefinition.modelColourToEdit[1] = 8384;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 8384 : colour;

				// Light brown
				colour = green;
				itemDefinition.modelColourToEdit[2] = 8375;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 8375 : colour;

				// Brown
				colour = blue;
				itemDefinition.modelColourToEdit[3] = 10266;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 10266 : colour;

				// Light brown
				colour = green;
				itemDefinition.modelColourToEdit[4] = 9523;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 9523 : colour;

				// Unknown
				colour = -1;
				itemDefinition.modelColourToEdit[5] = 10502;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 10502 : colour;

				// Light brown
				colour = green;
				itemDefinition.modelColourToEdit[6] = 9515;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 9515 : colour;

				// Unknown
				colour = -1;
				itemDefinition.modelColourToEdit[7] = 4550;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 4550 : colour;

				// Dark brown
				colour = yellow;
				itemDefinition.modelColourToEdit[8] = 142;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? 142 : colour;

				// Brown
				colour = yellow;
				itemDefinition.modelColourToEdit[9] = 163;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? 163 : colour;

				// Brown
				colour = red;
				itemDefinition.modelColourToEdit[10] = 22;
				itemDefinition.newModelColourProduced[10] = colour == -1 ? 22 : colour;

				colour = -1;
				itemDefinition.modelColourToEdit[11] = 9403;
				itemDefinition.newModelColourProduced[11] = colour == -1 ? 9403 : colour;

				// Dark brown
				colour = yellow;
				itemDefinition.modelColourToEdit[12] = 8076;
				itemDefinition.newModelColourProduced[12] = colour == -1 ? 8076 : colour;

				// Brown
				colour = green;
				itemDefinition.modelColourToEdit[13] = 10275;
				itemDefinition.newModelColourProduced[13] = colour == -1 ? 10275 : colour;

				// Brown
				colour = green;
				itemDefinition.modelColourToEdit[14] = 8379;
				itemDefinition.newModelColourProduced[14] = colour == -1 ? 8379 : colour;
				break;
			case 16230:
				itemDefinition.name = "Granite maul";
				itemDefinition.inventoryModel = 5413;
				itemDefinition.maleModel = 5410;
				itemDefinition.femaleModel = 5410;
				itemDefinition.zoom = 2000;
				itemDefinition.rotationX = 36;
				itemDefinition.rotationY = 308;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = 17;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[4];
				itemDefinition.newModelColourProduced = new int[4];
				colour = 90;
				itemDefinition.modelColourToEdit[0] = 8481;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 8481 : colour;

				colour = 90;
				itemDefinition.modelColourToEdit[1] = 8361;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 8361 : colour;

				colour = 0;
				itemDefinition.modelColourToEdit[2] = 10295;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 10295 : colour;

				colour = 0;
				itemDefinition.modelColourToEdit[3] = 10287;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 10287 : colour;
				break;
			case 16229:
				itemDefinition.name = "White h'ween mask";
				itemDefinition.inventoryModel = 2438;
				itemDefinition.maleModel = 3188;
				itemDefinition.femaleModel = 3192;
				itemDefinition.zoom = 730;
				itemDefinition.rotationY = 516;
				itemDefinition.inventoryY = -10;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = "Destroy";
				itemDefinition.modelColourToEdit = new int[2];
				itemDefinition.modelColourToEdit[0] = 926;
				itemDefinition.modelColourToEdit[1] = 0;
				itemDefinition.newModelColourProduced = new int[2];
				itemDefinition.newModelColourProduced[0] = 127; // Background colour
				itemDefinition.newModelColourProduced[1] = 0; // Eyes colour
				break;
			case 16228:
				itemDefinition.name = "Arcane spirit shield";
				itemDefinition.inventoryModel = 11310;
				itemDefinition.maleModel = 11050;
				itemDefinition.femaleModel = 11050;
				itemDefinition.zoom = 1600;
				itemDefinition.rotationX = 27;
				itemDefinition.rotationY = 396;
				itemDefinition.inventoryX = 4;
				itemDefinition.inventoryY = 13;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];
				yellow = 350770;
				colour = yellow;
				itemDefinition.modelColourToEdit[0] = 5594;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 5594 : colour;

				colour = yellow;
				itemDefinition.modelColourToEdit[1] = 7101;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 7101 : colour;

				colour = yellow;
				itemDefinition.modelColourToEdit[2] = 7079;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 7079 : colour;

				colour = yellow;
				itemDefinition.modelColourToEdit[3] = 7104;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 7104 : colour;

				colour = yellow;
				itemDefinition.modelColourToEdit[4] = 7056;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 7056 : colour;

				colour = 111;
				itemDefinition.modelColourToEdit[5] = 111;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 111 : colour;
				break;
			case 16227:
				itemDefinition.name = "Berserker ring (i)";
				itemDefinition.inventoryModel = 21847;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 600;
				itemDefinition.rotationX = 1916;
				itemDefinition.rotationY = 324;
				itemDefinition.inventoryX = 3;
				itemDefinition.inventoryY = -15;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = "Uncharge";
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[]
				{-22407, -23323, -22308, -21269, 9158, 9009, 11212};
				itemDefinition.newModelColourProduced = new int[]
				{17350, 17350, 17350, 17350, 17350, 17350, 17350};
				break;
			case 16226:
				itemDefinition.name = "Abyssal tentacle";
				itemDefinition.inventoryModel = 28439;
				itemDefinition.maleModel = 28446;
				itemDefinition.femaleModel = 28446;
				itemDefinition.zoom = 840;
				itemDefinition.rotationX = 121;
				itemDefinition.rotationY = 280;
				itemDefinition.inventoryY = 56;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = "Check";
				itemDefinition.inventoryOptions[4] = "Dissolve";

				itemDefinition.modelColourToEdit = new int[3];
				itemDefinition.newModelColourProduced = new int[3];

				// Stripe colour
				colour = 17350;
				itemDefinition.modelColourToEdit[0] = 11150;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -22208 : colour;

				// Not used
				colour = 17350;
				itemDefinition.modelColourToEdit[1] = 9108;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22477 : colour;

				// Spikes colour
				colour = 17350;
				itemDefinition.modelColourToEdit[2] = 10355;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22464 : colour;
				break;
			case 16225:
				itemDefinition.name = "Elder maul";
				itemDefinition.inventoryModel = 32792;
				itemDefinition.maleModel = 32678;
				itemDefinition.femaleModel = 32678;
				itemDefinition.zoom = 1744;
				itemDefinition.rotationX = 429;
				itemDefinition.rotationY = 237;
				itemDefinition.inventoryX = -3;
				itemDefinition.inventoryY = -58;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				break;

			case 16224:
				itemDefinition.name = "Elder maul";
				itemDefinition.inventoryModel = 32792;
				itemDefinition.maleModel = 32678;
				itemDefinition.femaleModel = 32678;
				itemDefinition.zoom = 1744;
				itemDefinition.rotationX = 429;
				itemDefinition.rotationY = 237;
				itemDefinition.inventoryX = -3;
				itemDefinition.inventoryY = -58;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				break;

			case 19564:
				itemDefinition.inventoryOptions = new String[]
				{"Commune", null, "Toggle", null, "Destroy"};
				break;
			case 16319:
				objectInstance = ObjectDefinition.forId(8091);
				itemDefinition.name = objectInstance.name + " pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 5000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = objectInstance.models[0];
				itemDefinition.modelColourToEdit = new int[4];
				itemDefinition.newModelColourProduced = new int[4];
				colour = 58335;
				itemDefinition.modelColourToEdit[0] = 7845;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 7845 : colour;

				colour = 58330;
				itemDefinition.modelColourToEdit[1] = 9110;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 9110 : colour;

				colour = 58325;
				itemDefinition.modelColourToEdit[2] = 21696;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 21696 : colour;

				colour = 58320;
				itemDefinition.modelColourToEdit[3] = 21815;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 21815 : colour;
				break;
			case 16318:
				itemDefinition.name = "Plank pet";
				itemDefinition.inventoryModel = 15048;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 2000;
				itemDefinition.rotationX = 148;
				itemDefinition.rotationY = 356;
				itemDefinition.inventoryY = 18;
				itemDefinition.brightness = 25;
				itemDefinition.modelColourToEdit = new int[]
				{6806, 6439, 6558};
				itemDefinition.newModelColourProduced = new int[]
				{7114, 7110, 7120};
				break;
			case 16315:
				itemDefinition.name = "Armadyl godsword (or)";
				itemDefinition.inventoryModel = 32049;
				itemDefinition.maleModel = 31893;
				itemDefinition.maleEquip2 = -1;
				itemDefinition.maleEquipOffset = 2;
				itemDefinition.femaleModel = 31893;
				itemDefinition.femaleEquip2 = -1;
				itemDefinition.femaleEquipOffset = 5;
				itemDefinition.zoom = 1957;
				itemDefinition.rotationX = 484;
				itemDefinition.rotationY = 498;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = -1;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = "Dismantle";

				itemDefinition.modelColourToEdit = new int[8];
				itemDefinition.newModelColourProduced = new int[8];

				// Light pale blue
				colour = 15;
				itemDefinition.modelColourToEdit[0] = -22208;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -22208 : colour;

				itemDefinition.modelColourToEdit[5] = -24271;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -24271 : colour;

				// Pale blue
				colour = 5;
				itemDefinition.modelColourToEdit[1] = -24164;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -24164 : colour;

				itemDefinition.modelColourToEdit[4] = -24279;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -24279 : colour;

				// Grey
				colour = 115;
				itemDefinition.modelColourToEdit[2] = -22444;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22444 : colour;

				// Very light grey
				colour = 127;
				itemDefinition.modelColourToEdit[3] = -22423;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -22423 : colour;

				itemDefinition.modelColourToEdit[6] = -22415;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -22415 : colour;

				itemDefinition.modelColourToEdit[7] = -22419;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -22419 : colour;
				break;
			case 16316:
				itemDefinition.name = "Armadyl godsword (or)";
				itemDefinition.inventoryModel = 32049;
				itemDefinition.maleModel = 31893;
				itemDefinition.maleEquip2 = -1;
				itemDefinition.maleEquipOffset = 2;
				itemDefinition.femaleModel = 31893;
				itemDefinition.femaleEquip2 = -1;
				itemDefinition.femaleEquipOffset = 5;
				itemDefinition.zoom = 1957;
				itemDefinition.rotationX = 484;
				itemDefinition.rotationY = 498;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = -1;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = "Dismantle";

				itemDefinition.modelColourToEdit = new int[8];
				itemDefinition.newModelColourProduced = new int[8];

				// Light pale blue
				colour = 58335;
				itemDefinition.modelColourToEdit[0] = -22208;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -22208 : colour;

				itemDefinition.modelColourToEdit[5] = -24271;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -24271 : colour;

				// Pale blue
				colour = 58325;
				itemDefinition.modelColourToEdit[1] = -24164;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -24164 : colour;

				itemDefinition.modelColourToEdit[4] = -24279;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -24279 : colour;

				// Grey
				colour = 115;
				itemDefinition.modelColourToEdit[2] = -22444;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22444 : colour;

				// Very light grey
				colour = 127;
				itemDefinition.modelColourToEdit[3] = -22423;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -22423 : colour;

				itemDefinition.modelColourToEdit[6] = -22415;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -22415 : colour;

				itemDefinition.modelColourToEdit[7] = -22419;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -22419 : colour;
				break;
			case 16317:
				itemDefinition.name = "Ancestral hat";
				itemDefinition.inventoryModel = 32794;
				itemDefinition.maleModel = 32655;
				itemDefinition.maleEquip2 = -1;
				itemDefinition.femaleModel = 32663;
				itemDefinition.femaleEquip2 = -1;
				itemDefinition.zoom = 1236;
				itemDefinition.rotationX = 10;
				itemDefinition.rotationY = 118;
				itemDefinition.inventoryY = -12;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[13];
				itemDefinition.newModelColourProduced = new int[13];

				// Orange
				colour = 127;
				itemDefinition.modelColourToEdit[0] = 6973;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 6973 : colour;

				// Dark grey
				colour = -1;
				itemDefinition.modelColourToEdit[1] = -21992;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -21992 : colour;

				// Dark blue
				colour = 58305;
				itemDefinition.modelColourToEdit[2] = -22235;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22235 : colour;

				// Brown
				colour = 58305;
				itemDefinition.modelColourToEdit[5] = 5268;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 5268 : colour;

				// Dark biege
				colour = 58324;
				itemDefinition.modelColourToEdit[3] = 6323;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 6323 : colour;

				// Biege
				colour = 58327;
				itemDefinition.modelColourToEdit[4] = 6331;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 6331 : colour;

				// Biege
				colour = 58330;
				itemDefinition.modelColourToEdit[6] = 6340;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 6340 : colour;

				// Biege
				colour = 58334;
				itemDefinition.modelColourToEdit[7] = 6348;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? 6348 : colour;

				// Biege
				colour = 58336;
				itemDefinition.modelColourToEdit[8] = 6356;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? 6356 : colour;

				// Biege
				colour = 58338;
				itemDefinition.modelColourToEdit[9] = 6364;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? 6364 : colour;

				// Biege
				colour = 58340;
				itemDefinition.modelColourToEdit[10] = 6798;
				itemDefinition.newModelColourProduced[10] = colour == -1 ? 6798 : colour;

				// Unknown
				colour = -1;
				itemDefinition.modelColourToEdit[11] = 4550;
				itemDefinition.newModelColourProduced[11] = colour == -1 ? 4550 : colour;

				// Unknown
				colour = -1;
				itemDefinition.modelColourToEdit[12] = 0;
				itemDefinition.newModelColourProduced[12] = colour == -1 ? 0 : colour;
				break;
			case 16223:
				npcInstance = EntityDefinition.forId(1277);
				itemDefinition.name = npcInstance.name + " pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 3000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16222:
				npcInstance = EntityDefinition.forId(1835);
				itemDefinition.name = npcInstance.name + " pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 4000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16221:
				npcInstance = EntityDefinition.forId(2108);
				itemDefinition.name = npcInstance.name + " pet";
				itemDefinition.inventoryModel = 2635;
				itemDefinition.zoom = 440;
				itemDefinition.rotationX = 1852;
				itemDefinition.rotationY = 76;
				itemDefinition.inventoryX = 1;
				itemDefinition.inventoryY = 1;
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.modelColourToEdit = new int[1];
				itemDefinition.modelColourToEdit[0] = 926;
				itemDefinition.newModelColourProduced = new int[1];
				itemDefinition.newModelColourProduced[0] = 43968;
				itemDefinition.brightness = -30;
				break;
			case 16220:
				npcInstance = EntityDefinition.forId(5796);
				itemDefinition.name = npcInstance.name + " pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 4000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16219:
				npcInstance = EntityDefinition.forId(108);
				itemDefinition.name = npcInstance.name + " pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 2000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16218:
				npcInstance = EntityDefinition.forId(7792);
				itemDefinition.name = npcInstance.name + " pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 4000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 200;
				itemDefinition.inventoryX = 20;
				itemDefinition.inventoryY = 30;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16217:
				npcInstance = EntityDefinition.forId(7371);
				itemDefinition.name = npcInstance.name + " pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 1000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 70;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16216:
				npcInstance = EntityDefinition.forId(5816);
				itemDefinition.name = npcInstance.name + " pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 3000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16215:
				npcInstance = EntityDefinition.forId(2830);
				itemDefinition.name = npcInstance.name + " pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 1400;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 20;
				itemDefinition.inventoryModel = npcInstance.models[1];
				break;
			case 16214:
				npcInstance = EntityDefinition.forId(2643);
				itemDefinition.name = npcInstance.name + " pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 1750;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 20;
				itemDefinition.inventoryY = 10;
				itemDefinition.inventoryModel = npcInstance.models[2];
				break;
			case 16213:
				npcInstance = EntityDefinition.forId(4362);
				itemDefinition.name = npcInstance.name + " pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 4000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 30;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = npcInstance.models[1];
				break;
			case 16212:
				itemDefinition.name = "Yellow partyhat";
				itemDefinition.inventoryModel = 2635;
				itemDefinition.maleModel = 187;
				itemDefinition.femaleModel = 363;
				itemDefinition.zoom = 440;
				itemDefinition.rotationX = 1852;
				itemDefinition.rotationY = 76;
				itemDefinition.inventoryX = 1;
				itemDefinition.inventoryY = 1;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[1];
				itemDefinition.modelColourToEdit[0] = 926;
				itemDefinition.newModelColourProduced = new int[1];
				itemDefinition.newModelColourProduced[0] = 11200;
				itemDefinition.brightness = -35;
				break;
			case 16211:
				itemDefinition.name = "Green partyhat pet";
				itemDefinition.inventoryModel = 2635;
				itemDefinition.maleModel = 187;
				itemDefinition.femaleModel = 363;
				itemDefinition.zoom = 440;
				itemDefinition.rotationX = 1852;
				itemDefinition.rotationY = 76;
				itemDefinition.inventoryX = 1;
				itemDefinition.inventoryY = 1;
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.modelColourToEdit = new int[1];
				itemDefinition.modelColourToEdit[0] = 926;
				itemDefinition.newModelColourProduced = new int[1];
				itemDefinition.newModelColourProduced[0] = 22464;
				itemDefinition.brightness = -35;
				break;
			case 16210:
				itemDefinition.name = "Black Dragon claws";
				itemDefinition.femaleModel = 29191;
				itemDefinition.femaleEquipOffset = 6;
				itemDefinition.inventoryOptions = new String[]
				{null, "Wear", null, null, null};
				itemDefinition.inventoryModel = 32784;
				itemDefinition.maleModel = 29191;
				itemDefinition.rotationY = 349;
				itemDefinition.inventoryX = 0;
				itemDefinition.rotationX = 15;
				itemDefinition.inventoryY = 8;
				itemDefinition.zoom = 886;
				itemDefinition.modelColourToEdit = new int[]
				{929, 922, 918, 914};
				itemDefinition.newModelColourProduced = new int[]
				{5, 5, 5, 5};
				break;
			case 16209:
				itemDefinition.name = "Cyan Toxic staff of the dead";
				itemDefinition.inventoryModel = 19224;
				itemDefinition.maleModel = 14402;
				itemDefinition.femaleModel = 14402;
				itemDefinition.zoom = 2150;
				itemDefinition.rotationX = 1010;
				itemDefinition.rotationY = 512;
				itemDefinition.rotationZ = 229;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = "Check";
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = "Uncharge";

				itemDefinition.modelColourToEdit = new int[15];
				itemDefinition.newModelColourProduced = new int[15];

				// Long handle stick
				colour = 34770;
				itemDefinition.modelColourToEdit[0] = -15842;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -15842 : colour;

				// Top and bottom part of the staff colour
				colour = 380770;
				itemDefinition.modelColourToEdit[1] = 16578;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 16578 : colour;

				itemDefinition.modelColourToEdit[2] = 16309;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? 16309 : colour;

				itemDefinition.modelColourToEdit[3] = 10462;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 10462 : colour;

				itemDefinition.modelColourToEdit[4] = 10448;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? 10448 : colour;

				// Part of orb colour
				itemDefinition.modelColourToEdit[5] = 127;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? 127 : colour;

				// Orb skull colour
				itemDefinition.modelColourToEdit[6] = 10475;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? 10475 : colour;

				// Back of tip colour
				itemDefinition.modelColourToEdit[7] = -10963;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -10963 : colour;

				// Back of tip colour
				itemDefinition.modelColourToEdit[8] = -10951;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -10951 : colour;

				// Back of tip colour
				itemDefinition.modelColourToEdit[9] = -10821;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? -10821 : colour;

				// Inside of orb skull colour
				itemDefinition.modelColourToEdit[10] = -10329;
				itemDefinition.newModelColourProduced[10] = colour == -1 ? -10329 : colour;

				// Inside of orb at the back of it
				itemDefinition.modelColourToEdit[11] = -10594;
				itemDefinition.newModelColourProduced[11] = colour == -1 ? -10594 : colour;

				// Inside of orb, tiny strip colour
				itemDefinition.modelColourToEdit[12] = -10317;
				itemDefinition.newModelColourProduced[12] = colour == -1 ? -10317 : colour;

				// Inside of orb, tiny strip colour
				itemDefinition.modelColourToEdit[13] = -10311;
				itemDefinition.newModelColourProduced[13] = colour == -1 ? -10311 : colour;

				// Inside of orb, at the back colour
				itemDefinition.modelColourToEdit[14] = 24;
				itemDefinition.newModelColourProduced[14] = colour == -1 ? 24 : colour;
				break;
			case 16208:
				itemDefinition.name = "Abyssal tentacle";
				itemDefinition.inventoryModel = 28439;
				itemDefinition.maleModel = 28446;
				itemDefinition.femaleModel = 28446;
				itemDefinition.zoom = 840;
				itemDefinition.rotationX = 121;
				itemDefinition.rotationY = 280;
				itemDefinition.inventoryY = 56;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = "Check";
				itemDefinition.inventoryOptions[4] = "Dissolve";

				itemDefinition.modelColourToEdit = new int[3];
				itemDefinition.newModelColourProduced = new int[3];

				// Stripe colour
				colour = 380770;
				itemDefinition.modelColourToEdit[0] = 11150;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -22208 : colour;

				// Not used
				colour = 34770;
				itemDefinition.modelColourToEdit[1] = 9108;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22477 : colour;

				// Spikes colour
				colour = 34770;
				itemDefinition.modelColourToEdit[2] = 10355;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22464 : colour;
				break;
			case 16207:
				itemDefinition.inventoryOptions = new String[]
						{null, "Wield", "Dismantle", null, null};
				itemDefinition.name = "Armadyl godsword";
				itemDefinition.inventoryModel = 28075;
				itemDefinition.zoom = 1957;
				itemDefinition.rotationY = 498;
				itemDefinition.rotationX = 484;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = -1;
				itemDefinition.maleModel = 27649;
				itemDefinition.femaleModel = 27649;

				itemDefinition.modelColourToEdit = new int[10];
				itemDefinition.newModelColourProduced = new int[10];

				// Hilt section where the hands are wrapped around
				colour = 380770;
				itemDefinition.modelColourToEdit[0] = -22208;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -22208 : colour;

				// Hilt top section
				itemDefinition.modelColourToEdit[1] = -22477;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22477 : colour;

				// Hilt section various sides
				itemDefinition.modelColourToEdit[2] = -22464;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22464 : colour;

				// Hilt section, the bottom part, half of the furs
				itemDefinition.modelColourToEdit[3] = -24279;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -24279 : colour;

				// Hilt section, the bottom part, rest of the furs
				itemDefinition.modelColourToEdit[4] = -24271;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -24271 : colour;

				// Blade, left side
				colour = 0;
				itemDefinition.modelColourToEdit[5] = -22444;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22444 : colour;

				// Blade, right side
				itemDefinition.modelColourToEdit[6] = -22423;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -22423 : colour;

				// Blade decoration on the right
				itemDefinition.modelColourToEdit[7] = -22415;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -22415 : colour;

				// Blade tip on the right
				itemDefinition.modelColourToEdit[8] = -22419;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -22419 : colour;

				// Blade at the tip, inventory model only.
				itemDefinition.modelColourToEdit[9] = -22440;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? -22440 : colour;
				break;

			case 16206:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", "Dismantle", null, null};
				itemDefinition.name = "Armadyl godsword";
				itemDefinition.inventoryModel = 28075;
				itemDefinition.zoom = 1957;
				itemDefinition.rotationY = 498;
				itemDefinition.rotationX = 484;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = -1;
				itemDefinition.maleModel = 27649;
				itemDefinition.femaleModel = 27649;

				itemDefinition.modelColourToEdit = new int[9];
				itemDefinition.newModelColourProduced = new int[9];

				// Hilt section where the hands are wrapped around
				colour = 419770;
				itemDefinition.modelColourToEdit[0] = -22208;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -22208 : colour;

				// Hilt top section
				itemDefinition.modelColourToEdit[1] = -22477;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22477 : colour;

				// Hilt section various sides
				itemDefinition.modelColourToEdit[2] = -22464;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22464 : colour;

				// Hilt section, the bottom part, half of the furs
				itemDefinition.modelColourToEdit[3] = -24279;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -24279 : colour;

				// Hilt section, the bottom part, rest of the furs
				itemDefinition.modelColourToEdit[4] = -24271;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -24271 : colour;

				// Blade, left side
				colour = -1;
				itemDefinition.modelColourToEdit[5] = -22444;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22444 : colour;

				// Blade, right side
				colour = -1;
				itemDefinition.modelColourToEdit[6] = -22423;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -22423 : colour;

				// Blade decoration on the right
				colour = -1;
				itemDefinition.modelColourToEdit[7] = -22415;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -22415 : colour;

				// Blade tip on the right
				colour = 933;
				itemDefinition.modelColourToEdit[8] = -22419;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -22419 : colour;
				break;

			case 16205:
				npcInstance = EntityDefinition.forId(2902);
				itemDefinition.name = npcInstance.name + " pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 1000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 300;
				itemDefinition.inventoryX = 30;
				itemDefinition.inventoryY = 20;
				itemDefinition.brightness = 20;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16204:
				npcInstance = EntityDefinition.forId(7936);
				itemDefinition.name = npcInstance.name + " pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 4000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 150;
				itemDefinition.brightness = 50;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16203:
				npcInstance = EntityDefinition.forId(7939);
				itemDefinition.name = npcInstance.name + " pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 4000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 200;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 10;
				itemDefinition.brightness = 50;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16202:
				npcInstance = EntityDefinition.forId(6379);
				itemDefinition.name = "Nezikchened pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 3000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 150;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16201:
				npcInstance = EntityDefinition.forId(7374);
				itemDefinition.name = "Ignisia pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 650;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 80;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;

			case 16200:
				npcInstance = EntityDefinition.forId(1037);
				itemDefinition.name = "Zambo pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 650;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 80;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16199:
				itemDefinition.name = "Pink h'ween mask";
				itemDefinition.inventoryModel = 2438;
				itemDefinition.maleModel = 3188;
				itemDefinition.femaleModel = 3192;
				itemDefinition.zoom = 730;
				itemDefinition.rotationY = 516;
				itemDefinition.inventoryY = -10;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = "Destroy";
				itemDefinition.modelColourToEdit = new int[2];
				itemDefinition.modelColourToEdit[0] = 926;
				itemDefinition.modelColourToEdit[1] = 0;
				itemDefinition.newModelColourProduced = new int[2];
				itemDefinition.newModelColourProduced[0] = 58325; // Background colour
				itemDefinition.newModelColourProduced[1] = 34770; // Eyes colour
				break;
			case 21864:
				itemDefinition.inventoryOptions = new String[]
				{"Absorb-energy", null, null, null, "Drop"};
				break;
			case 16198:
				npcInstance = EntityDefinition.forId(11167);
				itemDefinition.name = "Revenant dragon pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 3000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 200;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 10;
				itemDefinition.brightness = 50;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16197:
				npcInstance = EntityDefinition.forId(11166);
				itemDefinition.name = "Revenant dark beast pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 4400;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 300;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.brightness = 50;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16196:
				npcInstance = EntityDefinition.forId(11165);
				itemDefinition.name = "Revenant hellhound pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 4400;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 300;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.brightness = 50;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16195:
				npcInstance = EntityDefinition.forId(11164);
				itemDefinition.name = "Revenant ork pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 4400;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 300;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.brightness = 50;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16194:
				npcInstance = EntityDefinition.forId(4927);
				itemDefinition.name = "Entrana firebird pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 2400;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 300;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16193:
				npcInstance = EntityDefinition.forId(2696);
				itemDefinition.name = "Lamb pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 2000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 300;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16192:
				npcInstance = EntityDefinition.forId(2002);
				itemDefinition.name = "Ducklings pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 1600;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 300;
				itemDefinition.inventoryX = 10;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16191:
				npcInstance = EntityDefinition.forId(6474);
				itemDefinition.name = "Terror dog pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 4000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 300;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16190:
				npcInstance = EntityDefinition.forId(7795);
				itemDefinition.name = "Ancient Wyvern pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 4000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 200;
				itemDefinition.inventoryX = 20;
				itemDefinition.inventoryY = 30;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16189:
				itemDefinition.name = "Kodai wand pet";
				itemDefinition.inventoryModel = 32789;
				itemDefinition.maleModel = 32669;
				itemDefinition.femaleModel = 32669;
				itemDefinition.zoom = 668;
				itemDefinition.rotationX = 1416;
				itemDefinition.rotationY = 140;
				itemDefinition.inventoryX = 2;
				itemDefinition.inventoryY = -4;
				itemDefinition.brightness = -30;
				break;
			case 16188:
				itemDefinition.name = "Blue partyhat pet";
				itemDefinition.inventoryModel = 2635;
				itemDefinition.zoom = 440;
				itemDefinition.rotationX = 1852;
				itemDefinition.rotationY = 76;
				itemDefinition.inventoryX = 1;
				itemDefinition.inventoryY = 1;
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.modelColourToEdit = new int[1];
				itemDefinition.modelColourToEdit[0] = 926;
				itemDefinition.newModelColourProduced = new int[1];
				itemDefinition.newModelColourProduced[0] = 43968;
				itemDefinition.brightness = -30;
				break;
			case 16187:
				itemDefinition.inventoryOptions = new String[]
						{null, "Wield", "Dismantle", null, null};
				itemDefinition.name = "Armadyl godsword";
				itemDefinition.inventoryModel = 28075;
				itemDefinition.zoom = 1957;
				itemDefinition.rotationY = 498;
				itemDefinition.rotationX = 484;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = -1;
				itemDefinition.maleModel = 27649;
				itemDefinition.femaleModel = 27649;

				itemDefinition.modelColourToEdit = new int[9];
				itemDefinition.newModelColourProduced = new int[9];

				// Hilt section where the hands are wrapped around
				colour = 36680;
				itemDefinition.modelColourToEdit[0] = -22208;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -22208 : colour;

				// Hilt top section
				colour = 36680;
				itemDefinition.modelColourToEdit[1] = -22477;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22477 : colour;

				// Hilt section various sides
				colour = 36680;
				itemDefinition.modelColourToEdit[2] = -22464;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22464 : colour;

				// Hilt section, the bottom part, half of the furs
				colour = 36680;
				itemDefinition.modelColourToEdit[3] = -24279;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -24279 : colour;

				// Hilt section, the bottom part, rest of the furs
				colour = 36680;
				itemDefinition.modelColourToEdit[4] = -24271;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -24271 : colour;

				// Blade, left side
				colour = 36680;
				itemDefinition.modelColourToEdit[5] = -22444;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22444 : colour;

				// Blade, right side
				colour = 36680;
				itemDefinition.modelColourToEdit[6] = -22423;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -22423 : colour;

				// Blade decoration on the right
				colour = 36680;
				itemDefinition.modelColourToEdit[7] = -22415;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -22415 : colour;

				// Blade tip on the right
				colour = 36680;
				itemDefinition.modelColourToEdit[8] = -22419;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -22419 : colour;
				break;
			case 16186:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.newModelColourProduced = new int[6];

				// Sigil colour
				colour = 0;
				itemDefinition.modelColourToEdit[1] = 127;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 127 : colour;

				colour = 350770;
				itemDefinition.modelColourToEdit[0] = -28716;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -28716 : colour;

				colour = 350770;
				itemDefinition.modelColourToEdit[2] = -29116;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -29116 : colour;

				colour = 350770;
				itemDefinition.modelColourToEdit[3] = -29019;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -29019 : colour;

				colour = 350770;
				itemDefinition.modelColourToEdit[4] = -29125;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -29125 : colour;

				colour = 350770;
				itemDefinition.modelColourToEdit[5] = -29110;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -29110 : colour;
				break;
			case 16185:
				npcInstance = EntityDefinition.forId(2592);
				itemDefinition.name = "Mogre pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 500;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 120;
				itemDefinition.inventoryModel = npcInstance.models[1];
				break;
			case 16184:
				npcInstance = EntityDefinition.forId(403);
				itemDefinition.name = "Vannaka pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 750;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 80;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16183:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", "Dismantle", null, null};
				itemDefinition.name = "Armadyl godsword";
				itemDefinition.inventoryModel = 28075;
				itemDefinition.zoom = 1957;
				itemDefinition.rotationY = 498;
				itemDefinition.rotationX = 484;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = -1;
				itemDefinition.maleModel = 27649;
				itemDefinition.femaleModel = 27649;
				break;
			case 16182:
				npcInstance = EntityDefinition.forId(3588);
				itemDefinition.name = "Homunculus pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 5500;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 20;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16181:
				itemDefinition.name = "Gnosi pet";
				npcInstance = EntityDefinition.forId(7596);
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 4000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 10;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16180:
				itemDefinition.name = "Bear pet";
				npcInstance = EntityDefinition.forId(2838);
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 3000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16179:
				itemDefinition.name = "Pauline Polaris pet";
				npcInstance = EntityDefinition.forId(3838);
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 750;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 80;
				itemDefinition.inventoryModel = npcInstance.models[1];
				break;
			case 16178:
				itemDefinition.name = "Dairy cow pet";
				itemDefinition.inventoryModel = 23891;
				itemDefinition.zoom = 2700;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 13;
				break;
			case 16177:
				itemDefinition.name = "Aviansie pet";
				npcInstance = EntityDefinition.forId(7037);
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 3000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 80;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16176:
				itemDefinition.name = "Orange h'ween mask";
				itemDefinition.inventoryModel = 2438;
				itemDefinition.maleModel = 3188;
				itemDefinition.femaleModel = 3192;
				itemDefinition.zoom = 730;
				itemDefinition.rotationY = 516;
				itemDefinition.inventoryY = -10;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = "Destroy";
				itemDefinition.modelColourToEdit = new int[2];
				itemDefinition.modelColourToEdit[0] = 926;
				itemDefinition.modelColourToEdit[1] = 0;
				itemDefinition.newModelColourProduced = new int[2];
				itemDefinition.newModelColourProduced[0] = 461770; // Background colour
				itemDefinition.newModelColourProduced[1] = 302770; // Eyes colour
				break;
			case 16175:
				itemDefinition.name = "Twisted bow pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.inventoryModel = 32799;
				itemDefinition.maleModel = 32674;
				itemDefinition.femaleModel = 32674;
				itemDefinition.zoom = 2000;
				itemDefinition.rotationX = 1500;
				itemDefinition.rotationY = 720;
				itemDefinition.inventoryX = -3;
				itemDefinition.inventoryY = 1;
				itemDefinition.brightness = -40;
				break;
			case 16174:
				itemDefinition.name = "Barbarian guard pet";
				npcInstance = EntityDefinition.forId(7285);
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 1000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 80;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16173:
				itemDefinition.name = "Summoned Soul pet";
				npcInstance = EntityDefinition.forId(5869);
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 3000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16171:
				itemDefinition.name = "Witch's experiment pet";
				npcInstance = EntityDefinition.forId(3996);
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 3000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = npcInstance.models[0];
				itemDefinition.modelColourToEdit = npcInstance.modelColourToEdit;
				itemDefinition.newModelColourProduced = npcInstance.newModelColourProduced;
				break;
			case 16170:
				itemDefinition.name = "Zombie protester pet";
				npcInstance = EntityDefinition.forId(610);
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 1000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 90;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16169:
				itemDefinition.name = "Novice pet";
				npcInstance = EntityDefinition.forId(7055);
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 4000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16168:
				itemDefinition.name = "Steve pet";
				npcInstance = EntityDefinition.forId(6798);
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 700;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 80;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16167:
				itemDefinition.name = "Army Commander pet";
				npcInstance = EntityDefinition.forId(848);
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 3000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16166:
				itemDefinition.name = "Ali the Snake Charmer pet";
				npcInstance = EntityDefinition.forId(3542);
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 800;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 80;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16165:
				itemDefinition.name = "Zanaris choir pet";
				npcInstance = EntityDefinition.forId(5847);
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 4000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = npcInstance.models[0];
				itemDefinition.modelColourToEdit = npcInstance.modelColourToEdit;
				itemDefinition.newModelColourProduced = npcInstance.newModelColourProduced;
				break;
			case 16164:
				itemDefinition.name = "Dragonkin pet";
				npcInstance = EntityDefinition.forId(11126);
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 5000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 4083:
				itemDefinition.name = "Broken sled";
				break;
			case 16163:
				itemDefinition.inventoryOptions = new String[]
				{null, "Wield", "Dismantle", null, null};
				itemDefinition.name = "Deaths Godsword";
				itemDefinition.inventoryModel = 28075;
				itemDefinition.zoom = 1957;
				itemDefinition.rotationY = 498;
				itemDefinition.rotationX = 484;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = -1;
				itemDefinition.maleModel = 27649;
				itemDefinition.femaleModel = 27649;
				break;
			case 16162:
				itemDefinition.name = "Abyssal Sire pet";
				npcInstance = EntityDefinition.forId(5889);
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 12000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16161:
				itemDefinition.name = "Ping pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 3000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				npcInstance = EntityDefinition.forId(835);
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 4880://arlo
				itemInstance = ItemDefinition.forId(20792);
				itemDefinition.zoom = 800;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.name = "Torva full helm";
				itemDefinition.inventoryModel = 40000;
			itemDefinition.maleModel = 40001;
			itemDefinition.femaleModel = 40001;
			break;
			case 2023://arlo
				itemInstance = ItemDefinition.forId(20794);
				itemDefinition.zoom = itemInstance.zoom;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.name = "Torva platebody";
				itemDefinition.inventoryModel = 40002;
			itemDefinition.maleModel = 40003;
			itemDefinition.femaleModel = 40003;
			itemDefinition.inventoryOptions = new String[]
			{null, "Wear", null, null, "Drop"};
			break;
			case 4898://arlo
				itemInstance = ItemDefinition.forId(20796);
				itemDefinition.zoom = 1800;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.name = "Torva platelegs";
				itemDefinition.inventoryModel = 40004;
			itemDefinition.maleModel = 40005;
			itemDefinition.femaleModel = 40005;
			break;
			case 20920://arlo
				itemInstance = ItemDefinition.forId(2577);
				itemDefinition.zoom = 400;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.name = "Primal boot";
				itemDefinition.inventoryModel = 40046;
			itemDefinition.maleModel = 40046;
			itemDefinition.femaleModel = 40046;
			itemDefinition.inventoryOptions = new String[]
					{null, "Wear", null, null, "Drop"};
			break;
			case 20921://arlo
				itemInstance = ItemDefinition.forId(7459);
				itemDefinition.zoom = 400;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = 1;
				itemDefinition.name = "Primal gauntlets";
				itemDefinition.inventoryModel = 40047;
			itemDefinition.maleModel = 40048;
			itemDefinition.femaleModel = 40048;
			itemDefinition.inventoryOptions = new String[]
					{null, "Wear", null, null, "Drop"};
			break;
			case 20917://arlo
				itemInstance = ItemDefinition.forId(20792);
				itemDefinition.zoom = 400;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				//itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.name = "Primal full helm";
				itemDefinition.inventoryModel = 40037;
			itemDefinition.maleModel = 40038;
			itemDefinition.femaleModel = 40038;
			itemDefinition.inventoryY = 1;
			itemDefinition.inventoryOptions = new String[]
					{null, "Wear", null, null, "Drop"};
			break;
			case 20918://arlo
				itemInstance = ItemDefinition.forId(20794);
				itemDefinition.zoom = 700;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.name = "Primal platebody";
				itemDefinition.inventoryModel = 40039;
			itemDefinition.maleModel = 40040;
			itemDefinition.femaleModel = 40040;
			itemDefinition.inventoryOptions = new String[]
			{null, "Wear", null, null, "Drop"};
			break;
			case 20919://arlo
				itemInstance = ItemDefinition.forId(20796);
				itemDefinition.zoom = 780;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.name = "Primal platelegs";
				itemDefinition.inventoryModel = 40041;
			itemDefinition.maleModel = 40042;
			itemDefinition.femaleModel = 40042;
			itemDefinition.inventoryOptions = new String[]
					{null, "Wear", null, null, "Drop"};
			break;
			
			case 10859://arlo
				itemInstance = ItemDefinition.forId(20792);
				itemDefinition.zoom = 400;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				//itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.name = "Primal full helm";
				itemDefinition.inventoryModel = 40049;
			itemDefinition.maleModel = 40050;
			itemDefinition.femaleModel = 40050;
			itemDefinition.inventoryY = 1;
			itemDefinition.inventoryOptions = new String[]
					{null, "Wear", null, null, "Drop"};
			break;
			case 10860://arlo
				itemInstance = ItemDefinition.forId(20794);
				itemDefinition.zoom = 700;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.name = "Primal platebody";
				itemDefinition.inventoryModel = 40051;
			itemDefinition.maleModel = 40052;
			itemDefinition.femaleModel = 40052;
			itemDefinition.inventoryOptions = new String[]
			{null, "Wear", null, null, "Drop"};
			break;
			case 10861://arlo
				itemInstance = ItemDefinition.forId(20796);
				itemDefinition.zoom = 780;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.name = "Primal platelegs";
				itemDefinition.inventoryModel = 40053;
			itemDefinition.maleModel = 40054;
			itemDefinition.femaleModel = 40054;
			itemDefinition.inventoryOptions = new String[]
					{null, "Wear", null, null, "Drop"};
			break;
			case 1905://arlo
				itemInstance = ItemDefinition.forId(20792);
				itemDefinition.zoom = 400;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				//itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.name = "Fire torva gloves";
				itemDefinition.inventoryModel = 40055;
			itemDefinition.maleModel = 40056;
			itemDefinition.femaleModel = 40056;
			itemDefinition.inventoryY = 1;
			itemDefinition.inventoryOptions = new String[]
					{null, "Wear", null, null, "Drop"};
			break;
			case 4616://arlo
				itemInstance = ItemDefinition.forId(20794);
				itemDefinition.zoom = 700;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.name = "Fire torva boots";
				itemDefinition.inventoryModel = 40057;
			itemDefinition.maleModel = 40057;
			itemDefinition.femaleModel = 40057;
			itemDefinition.inventoryOptions = new String[]
			{null, "Wear", null, null, "Drop"};
			break;
			case 5066://arlo
				itemInstance = ItemDefinition.forId(20796);
				itemDefinition.zoom = 780;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.name = "Fire torva whip";
				itemDefinition.inventoryModel = 40058;
			itemDefinition.maleModel = 40059;
			itemDefinition.femaleModel = 40059;
			itemDefinition.inventoryOptions = new String[]
					{null, "Wear", null, null, "Drop"};
			break;
			case 4857://arlo
				itemInstance = ItemDefinition.forId(20792);
				itemDefinition.zoom = 800;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.name = "Ganodermic visor";
				itemDefinition.inventoryModel = 40006;
			itemDefinition.maleModel = 40007;
			itemDefinition.femaleModel = 40007;
			break;
			case 2026://arlo
				itemDefinition.name = "Ganodermic poncho";
				itemDefinition.inventoryModel = 40008;
			itemDefinition.maleModel = 40009;
			itemDefinition.femaleModel = 40009;
			itemInstance = ItemDefinition.forId(20794);
			itemDefinition.zoom = itemInstance.zoom;
			itemDefinition.rotationY = itemInstance.rotationY;
			itemDefinition.rotationX = itemInstance.rotationX;
			itemDefinition.inventoryX = itemInstance.inventoryX;
			itemDefinition.inventoryY = itemInstance.inventoryY;
			itemDefinition.inventoryOptions = new String[]
			{null, "Wear", null, null, "Drop"};
			break;
			case 4875://arlo
				itemInstance = ItemDefinition.forId(20796);
				itemDefinition.zoom = 1800;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.name = "Ganodermic leggings";
				itemDefinition.inventoryModel = 40010;
			itemDefinition.maleModel = 40011;
			itemDefinition.femaleModel = 40011;
			break;
			case 4858://arlo
				itemInstance = ItemDefinition.forId(20792);
				itemDefinition.zoom = 800;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.name = "Virtus mask";
				itemDefinition.inventoryModel = 40012;
			itemDefinition.maleModel = 40013;
			itemDefinition.femaleModel = 40013;
			break;
			case 2028://arlo
				itemDefinition.name = "Virtus robe top";
				itemDefinition.inventoryModel = 40014;
			itemDefinition.maleModel = 40015;
			itemDefinition.femaleModel = 40015;
			itemInstance = ItemDefinition.forId(20794);
			itemDefinition.zoom = itemInstance.zoom;
			itemDefinition.rotationY = itemInstance.rotationY;
			itemDefinition.rotationX = itemInstance.rotationX;
			itemDefinition.inventoryX = itemInstance.inventoryX;
			itemDefinition.inventoryY = itemInstance.inventoryY;
			itemDefinition.inventoryOptions = new String[]
			{null, "Wear", null, null, "Drop"};
			break;
			case 4877://arlo
				itemInstance = ItemDefinition.forId(20796);
				itemDefinition.zoom = 1800;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.name = "Virtus robe legs";
				itemDefinition.inventoryModel = 40016;
			itemDefinition.maleModel = 40017;
			itemDefinition.femaleModel = 40017;
			break;
			case 4928://arlo
				itemInstance = ItemDefinition.forId(20792);
				itemDefinition.zoom = 800;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.name = "Pernix cowl";
				itemDefinition.inventoryModel = 40018;
			itemDefinition.maleModel = 40019;
			itemDefinition.femaleModel = 40019;
			break;
			case 2030://arlo
				itemDefinition.name = "Pernix body";
				itemDefinition.inventoryModel = 40020;
			itemDefinition.maleModel = 40021;
			itemDefinition.femaleModel = 40021;
			itemInstance = ItemDefinition.forId(20794);
			itemDefinition.zoom = itemInstance.zoom;
			itemDefinition.rotationY = itemInstance.rotationY;
			itemDefinition.rotationX = itemInstance.rotationX;
			itemDefinition.inventoryX = itemInstance.inventoryX;
			itemDefinition.inventoryY = itemInstance.inventoryY;
			itemDefinition.inventoryOptions = new String[]
			{null, "Wear", null, null, "Drop"};
			break;
			case 4946://arlo
				itemInstance = ItemDefinition.forId(20796);
				itemDefinition.zoom = 1800;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.name = "Pernix chaps";
				itemDefinition.inventoryModel = 40022;
			itemDefinition.maleModel = 40023;
			itemDefinition.femaleModel = 40023;
			break;
			case 6605://arlo
				itemDefinition.name = "Chaotic rapier";
				itemDefinition.inventoryModel = 40032;
			itemDefinition.maleModel = 40033;
			itemDefinition.femaleModel = 40033;
			itemDefinition.zoom = 1425;
			itemDefinition.rotationY = 700;
			itemDefinition.rotationX = 1300;
			break;
			case 6607://arlo
				itemDefinition.name = "Chaotic longsword";
				itemDefinition.inventoryModel = 40028;
			itemDefinition.maleModel = 40029;
			itemDefinition.femaleModel = 40029;
			itemDefinition.zoom = 1650;
			itemDefinition.rotationY = 498;
			itemDefinition.rotationX = 1300;
			break;
			case 6609://arlo
				itemDefinition.name = "Chaotic maul";
				itemDefinition.inventoryModel = 40030;
			itemDefinition.maleModel = 40031;
			itemDefinition.femaleModel = 40031;
			itemDefinition.zoom = 1360;
			itemDefinition.rotationY = 498;
			itemDefinition.rotationX = 354;
			break;
			case 9084://arlo
				itemDefinition.name = "Chaotic staff";
				itemDefinition.inventoryModel = 40034;
			itemDefinition.maleModel = 40035;
			itemDefinition.femaleModel = 40035;
			itemDefinition.zoom = 1711;
			itemDefinition.rotationY = 350;
			itemDefinition.rotationX = 365;
			break;
			case 11165://arlo
				itemDefinition.name = "Chaotic crossbow";
				itemDefinition.inventoryModel = 40024;
			itemDefinition.maleModel = 40025;
			itemDefinition.femaleModel = 40025;
			itemDefinition.zoom = 1650;
			itemDefinition.rotationY = 498;
			itemDefinition.rotationX = 700;
			break;
			case 6593://arlo
				itemDefinition.name = "Korasi sword";
				itemDefinition.inventoryModel = 40026;
			itemDefinition.maleModel = 40027;
			itemDefinition.femaleModel = 40027;
			itemDefinition.zoom = 1650;
			itemDefinition.rotationY = 498;
			itemDefinition.rotationX = 500;
			break;
			case 16160:
				itemDefinition.name = "Pig pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 1500;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 250;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				npcInstance = EntityDefinition.forId(2812);
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16159:
				itemDefinition.name = "Nurse Tafani pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 750;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 80;
				npcInstance = EntityDefinition.forId(3343);
				itemDefinition.inventoryModel = npcInstance.models[0];
				itemDefinition.modelColourToEdit = new int[4];
				itemDefinition.modelColourToEdit[0] = 8741;
				itemDefinition.modelColourToEdit[1] = 25238;
				itemDefinition.modelColourToEdit[2] = 6798;
				itemDefinition.modelColourToEdit[3] = 4550;
				itemDefinition.newModelColourProduced = new int[4];
				itemDefinition.newModelColourProduced[0] = 43228;
				itemDefinition.newModelColourProduced[1] = 43228;
				itemDefinition.newModelColourProduced[2] = 138;
				itemDefinition.newModelColourProduced[3] = 6705;

				break;
			case 16158:
				itemDefinition.name = "Ankou pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 3500;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				npcInstance = EntityDefinition.forId(2514);
				itemDefinition.inventoryModel = npcInstance.models[0];
				itemDefinition.modelColourToEdit = new int[4];
				itemDefinition.modelColourToEdit[0] = 27955;
				itemDefinition.modelColourToEdit[1] = 29113;
				itemDefinition.modelColourToEdit[2] = 20715;
				itemDefinition.modelColourToEdit[3] = 22488;
				itemDefinition.newModelColourProduced = new int[4];
				itemDefinition.newModelColourProduced[0] = 61099;
				itemDefinition.newModelColourProduced[1] = 819;
				itemDefinition.newModelColourProduced[2] = 8394;
				itemDefinition.newModelColourProduced[3] = 960;

				break;
			case 21295:
				itemDefinition.name = "Infernal cape";
				break;
			case 16157:
				itemDefinition.name = "Pet white chaos elemental";
				itemDefinition.inventoryModel = 28256;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 1284;
				itemDefinition.rotationX = 175;
				itemDefinition.rotationZ = 1939;
				itemDefinition.inventoryX = -66;
				itemDefinition.inventoryY = 75;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = null;
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = "Drop";
				itemDefinition.modelColourToEdit = new int[5];
				itemDefinition.newModelColourProduced = new int[5];

				// Purple
				colour = 100;
				itemDefinition.modelColourToEdit[0] = -17879;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -17879 : colour;

				// Pink
				colour = -1;
				itemDefinition.modelColourToEdit[1] = 466;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 466 : colour;

				// Purple
				colour = 100;
				itemDefinition.modelColourToEdit[2] = -17875;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -17875 : colour;

				// Black
				colour = -1;
				itemDefinition.modelColourToEdit[3] = 0;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? 0 : colour;

				// Pale purple
				colour = 9583;
				itemDefinition.modelColourToEdit[4] = -18261;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -18261 : colour;
				break;
			case 16156:
				itemDefinition.name = "Skeletal hellhound pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 3500;
				itemDefinition.rotationY = 100;
				itemDefinition.rotationX = 300;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				npcInstance = EntityDefinition.forId(11116);
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16155:
				itemDefinition.name = "Pink partyhat";
				itemDefinition.inventoryModel = 2635;
				itemDefinition.maleModel = 187;
				itemDefinition.femaleModel = 363;
				itemDefinition.zoom = 440;
				itemDefinition.rotationX = 1852;
				itemDefinition.rotationY = 76;
				itemDefinition.inventoryX = 1;
				itemDefinition.inventoryY = 1;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[1];
				itemDefinition.modelColourToEdit[0] = 926;
				itemDefinition.newModelColourProduced = new int[1];
				itemDefinition.newModelColourProduced[0] = 58325;
				break;
			case 16154:
				itemDefinition.name = "Troll child pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 3500;
				itemDefinition.rotationY = 100;
				itemDefinition.rotationX = 300;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				npcInstance = EntityDefinition.forId(11115);
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16153:
				itemDefinition.name = "Pet dragon claws";
				itemInstance = ItemDefinition.forId(20784);
				itemDefinition.inventoryModel = itemInstance.inventoryModel;
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = itemInstance.zoom;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				break;
			case 16152:
				itemDefinition.name = "Sea snake pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 11000;
				itemDefinition.rotationY = 250;
				itemDefinition.rotationX = 100;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				npcInstance = EntityDefinition.forId(11111);
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16151:
				itemDefinition.name = "Abyssal tentacle";
				itemDefinition.inventoryModel = 28439;
				itemDefinition.maleModel = 28446;
				itemDefinition.femaleModel = 28446;
				itemDefinition.zoom = 840;
				itemDefinition.rotationX = 121;
				itemDefinition.rotationY = 280;
				itemDefinition.inventoryY = 56;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = "Check";
				itemDefinition.inventoryOptions[4] = "Dissolve";
				break;
			case 16150:
				itemDefinition.name = "Light Blue Santa hat";
				itemDefinition.inventoryModel = 2537;
				itemDefinition.maleModel = 189;
				itemDefinition.femaleModel = 366;
				itemDefinition.zoom = 540;
				itemDefinition.rotationX = 136;
				itemDefinition.rotationY = 72;
				itemDefinition.inventoryY = -3;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;

				itemDefinition.modelColourToEdit = new int[2];
				itemDefinition.newModelColourProduced = new int[2];
				colour = 36680;
				itemDefinition.modelColourToEdit[0] = 933;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? 933 : colour;

				colour = 127;
				itemDefinition.modelColourToEdit[1] = 10351;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? 10351 : colour;
				break;

			case 16149:
				itemDefinition.name = "Tree spirit pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 2500;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 20;
				npcInstance = EntityDefinition.forId(1163);
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16148:
				itemDefinition.name = "Clerris pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 3500;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				npcInstance = EntityDefinition.forId(7040);
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16147:
				itemDefinition.name = "Fairy Godfather pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 2000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 40;
				npcInstance = EntityDefinition.forId(1840);
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16146:
				itemDefinition.name = "Nieve pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 750;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 70;
				npcInstance = EntityDefinition.forId(6797);
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16140:
			case 16141:
			case 16142:
			case 16143:
			case 16144:
				itemDefinition.name = "Loot key";
				itemInstance = ItemDefinition.forId(20767); //ruby key
				itemDefinition.inventoryModel = itemInstance.inventoryModel;
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Destroy"};
				itemDefinition.zoom = itemInstance.zoom;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.modelColourToEdit = new int[]
				{8128};
				itemDefinition.newModelColourProduced = new int[]
				{560};
				break;
			case 4273:
				itemDefinition.name = "Key of Tokens";
				itemInstance = ItemDefinition.forId(20767); //ruby key
				itemDefinition.inventoryModel = itemInstance.inventoryModel;
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Destroy"};
				itemDefinition.zoom = itemInstance.zoom;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.modelColourToEdit = new int[]
				{8128};
				itemDefinition.newModelColourProduced = new int[]
				{123770};
				break;

			case 16145:
				itemDefinition.name = "Loot key scroll";
				itemInstance = ItemDefinition.forId(21079); //ruby key
				itemDefinition.inventoryModel = itemInstance.inventoryModel;
				itemDefinition.inventoryOptions = new String[]
				{"Read", null, null, null, "Drop"};
				itemDefinition.zoom = itemInstance.zoom;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.modelColourToEdit = new int[]
				{5563};
				itemDefinition.newModelColourProduced = new int[]
				{560};
				break;

			case 16139:
				itemDefinition.name = "Pet chair";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 2500;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 340;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				npcInstance = EntityDefinition.forId(3567);
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16138:
				itemDefinition.name = "Golden claws";
				itemDefinition.femaleModel = 29191;
				itemDefinition.femaleEquipOffset = 6;
				itemDefinition.inventoryOptions = new String[]
				{null, "Wear", null, null, null};
				itemDefinition.inventoryModel = 32784;
				itemDefinition.maleModel = 29191;
				itemDefinition.rotationY = 349;
				itemDefinition.inventoryX = 0;
				itemDefinition.rotationX = 15;
				itemDefinition.inventoryY = 8;
				itemDefinition.zoom = 886;
				itemDefinition.modelColourToEdit = new int[]
				{929, 922, 918, 914};
				itemDefinition.newModelColourProduced = new int[]
				{8128, 8128, 8128, 8128};
				break;

			case 16137:
				itemInstance = ItemDefinition.forId(20269);
				itemDefinition.name = "Hopleez pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = itemInstance.zoom;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.inventoryModel = itemInstance.inventoryModel;
				break;
			case 16136:
				itemDefinition.name = "Abyssal tentacle";
				itemDefinition.inventoryModel = 28439;
				itemDefinition.maleModel = 28446;
				itemDefinition.femaleModel = 28446;
				itemDefinition.zoom = 840;
				itemDefinition.rotationX = 121;
				itemDefinition.rotationY = 280;
				itemDefinition.inventoryY = 56;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = "Check";
				itemDefinition.inventoryOptions[4] = "Dissolve";
				break;
			case 16135:
				itemDefinition.name = "Mcribb pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 2200;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = -10;
				itemDefinition.inventoryY = 110;
				npcInstance = EntityDefinition.forId(763);
				itemDefinition.inventoryModel = npcInstance.models[0];

				itemDefinition.modelColourToEdit = new int[18];
				itemDefinition.modelColourToEdit[0] = -28134;// Dark blue
				itemDefinition.modelColourToEdit[1] = -26864; // Very dark blue
				itemDefinition.modelColourToEdit[2] = -27231; // Dark blue
				itemDefinition.modelColourToEdit[3] = -27223; // Dark blue
				itemDefinition.modelColourToEdit[4] = -27227; // Dark blue
				itemDefinition.modelColourToEdit[5] = -27112; // Dark blue
				itemDefinition.modelColourToEdit[6] = -27236; // Dark blue
				itemDefinition.modelColourToEdit[7] = -28010; // Dark blue
				itemDefinition.modelColourToEdit[8] = -3165;
				itemDefinition.modelColourToEdit[9] = -3161;
				itemDefinition.modelColourToEdit[10] = 9;
				itemDefinition.modelColourToEdit[11] = 9;
				itemDefinition.modelColourToEdit[12] = -3409;
				itemDefinition.modelColourToEdit[13] = -3405;
				itemDefinition.modelColourToEdit[14] = -2249;
				itemDefinition.modelColourToEdit[15] = -2245;
				itemDefinition.modelColourToEdit[16] = -2125;
				itemDefinition.modelColourToEdit[17] = -2131;
				itemDefinition.newModelColourProduced = new int[18];
				itemDefinition.newModelColourProduced[0] = 0;
				itemDefinition.newModelColourProduced[1] = 7;
				itemDefinition.newModelColourProduced[2] = 0;
				itemDefinition.newModelColourProduced[3] = 0;
				itemDefinition.newModelColourProduced[4] = 0;
				itemDefinition.newModelColourProduced[5] = 0;
				itemDefinition.newModelColourProduced[6] = 0;
				itemDefinition.newModelColourProduced[7] = 0;
				itemDefinition.newModelColourProduced[8] = 0;
				itemDefinition.newModelColourProduced[9] = 0;
				itemDefinition.newModelColourProduced[10] = 127; // Wing design at the front spike
				itemDefinition.newModelColourProduced[11] = 127; // Wing design at the front spike also affect beak
				itemDefinition.newModelColourProduced[12] = 127;
				itemDefinition.newModelColourProduced[13] = 127;
				itemDefinition.newModelColourProduced[14] = 127;
				itemDefinition.newModelColourProduced[15] = 127;
				itemDefinition.newModelColourProduced[16] = 127;
				itemDefinition.newModelColourProduced[17] = 127;
				break;
			case 16134:
				itemDefinition.name = "Berserker ring (i)";
				itemDefinition.inventoryModel = 21847;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 600;
				itemDefinition.rotationX = 1916;
				itemDefinition.rotationY = 324;
				itemDefinition.inventoryX = 3;
				itemDefinition.inventoryY = -15;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = "Uncharge";
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[]
				{-22407, -23323, -22308, -21269, 9158, 9009, 11212};
				itemDefinition.newModelColourProduced = new int[]
				{34770, 34770, 34770, 34770, 34770, 34770, 34770};
				break;
			case 16133:
				itemDefinition.name = "Cyan h'ween mask";
				itemDefinition.inventoryModel = 2438;
				itemDefinition.maleModel = 3188;
				itemDefinition.femaleModel = 3192;
				itemDefinition.zoom = 730;
				itemDefinition.rotationY = 516;
				itemDefinition.inventoryY = -10;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = "Destroy";
				itemDefinition.modelColourToEdit = new int[2];
				itemDefinition.modelColourToEdit[0] = 926;
				itemDefinition.modelColourToEdit[1] = 0;
				itemDefinition.newModelColourProduced = new int[2];
				itemDefinition.newModelColourProduced[0] = 34770; // Background colour
				itemDefinition.newModelColourProduced[1] = 0; // Eyes colour
				break;

			case 16132:
				npcInstance = EntityDefinition.forId(412);
				itemDefinition.name = "Gargoyle pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 6400;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16131:
				npcInstance = EntityDefinition.forId(2041);
				itemDefinition.name = "Broken Handz pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 1500;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 50;
				itemDefinition.inventoryModel = npcInstance.models[1];
				break;
			case 16130:
				npcInstance = EntityDefinition.forId(7668);
				itemDefinition.name = "Voice of Yama pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 4000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 15;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16129:
				npcInstance = EntityDefinition.forId(6077);
				itemDefinition.name = "Gnome child pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 700;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 300;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 50;
				itemDefinition.inventoryModel = npcInstance.models[1];
				break;
			case 16128:
				npcInstance = EntityDefinition.forId(998);
				itemDefinition.name = "Guard pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 900;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 150;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 80;
				itemDefinition.inventoryModel = npcInstance.models[0];
				itemDefinition.modelColourToEdit = new int[3];
				itemDefinition.modelColourToEdit[0] = 25238;
				itemDefinition.modelColourToEdit[1] = 8741;
				itemDefinition.modelColourToEdit[2] = 61;
				itemDefinition.newModelColourProduced = new int[3];
				itemDefinition.newModelColourProduced[0] = 10508;
				itemDefinition.newModelColourProduced[1] = 6930;
				itemDefinition.newModelColourProduced[2] = 5652;
				break;
			case 16127:
				npcInstance = EntityDefinition.forId(2207);
				itemDefinition.name = "Growler pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 3700;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 300;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = -10;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;

			case 16126:
				npcInstance = EntityDefinition.forId(465);
				itemDefinition.name = "Skeletal wyvern pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 3000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 300;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 30;
				itemDefinition.inventoryModel = npcInstance.models[0];
				itemDefinition.modelColourToEdit = new int[5];
				itemDefinition.modelColourToEdit[0] = 103;
				itemDefinition.modelColourToEdit[1] = 82;
				itemDefinition.modelColourToEdit[2] = 61;
				itemDefinition.modelColourToEdit[3] = 41;
				itemDefinition.modelColourToEdit[4] = 0;
				itemDefinition.newModelColourProduced = new int[5];
				itemDefinition.newModelColourProduced[0] = 127;
				itemDefinition.newModelColourProduced[1] = 127;
				itemDefinition.newModelColourProduced[2] = 127;
				itemDefinition.newModelColourProduced[3] = 127;
				itemDefinition.newModelColourProduced[4] = 127;

				break;
			case 16125:
				itemDefinition.name = "Glod pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 9000;
				itemDefinition.rotationY = 100;
				itemDefinition.rotationX = 100;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 30;
				npcInstance = EntityDefinition.forId(6358);
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;

			case 16124:
				itemDefinition.name = "Primordial boots";
				itemDefinition.inventoryModel = 29397;
				itemDefinition.maleModel = 29250;
				itemDefinition.femaleModel = 29255;
				itemDefinition.zoom = 976;
				itemDefinition.rotationX = 279;
				itemDefinition.rotationY = 147;
				itemDefinition.inventoryX = 5;
				itemDefinition.inventoryY = -5;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				break;
			case 16123:
				itemDefinition.name = "Karil pet";
				itemDefinition.inventoryOptions = new String[]
				{null, null, null, null, "Drop"};
				itemDefinition.zoom = 2500;
				itemDefinition.rotationY = 100;
				itemDefinition.rotationX = 100;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 30;
				npcInstance = EntityDefinition.forId(1675);
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16122:
				itemDefinition.name = "Elder maul";
				itemDefinition.inventoryModel = 32792;
				itemDefinition.maleModel = 32678;
				itemDefinition.femaleModel = 32678;
				itemDefinition.zoom = 1744;
				itemDefinition.rotationX = 429;
				itemDefinition.rotationY = 237;
				itemDefinition.inventoryX = -3;
				itemDefinition.inventoryY = -58;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				break;
			case 16121:
				itemDefinition.name = "Corporeal beast pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 3700;
				itemDefinition.rotationY = 100;
				itemDefinition.rotationX = 100;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				npcInstance = EntityDefinition.forId(319);
				itemDefinition.inventoryModel = npcInstance.models[0];
				//@formatter:off
				itemDefinition.modelColourToEdit = new int[]
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
				itemDefinition.newModelColourProduced = new int[]
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
			case 16120:
				npcInstance = EntityDefinition.forId(7697);
				itemDefinition.inventoryModel = npcInstance.models[0];
				itemDefinition.name = "Jal-ImKot pet";
				itemDefinition.zoom = 2900;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = -40;
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				break;
			case 16119:
				npcInstance = EntityDefinition.forId(6076);
				itemDefinition.inventoryModel = npcInstance.models[0];
				itemDefinition.name = "Tortoise pet";
				itemDefinition.zoom = 3500;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				break;
			case 16118:
				itemDefinition.inventoryModel = 6580;
				itemDefinition.name = "Cow31337Killer pet";
				itemDefinition.inventoryModel = 6580;
				itemDefinition.zoom = 660;
				itemDefinition.rotationX = 128;
				itemDefinition.rotationY = 96;
				itemDefinition.inventoryX = 5;
				itemDefinition.inventoryY = -8;
				itemDefinition.brightness = -30;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = "Check";
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[2];
				itemDefinition.modelColourToEdit[0] = 10394;
				itemDefinition.modelColourToEdit[1] = 10388;
				itemDefinition.newModelColourProduced = new int[2];
				itemDefinition.newModelColourProduced[0] = 10388;
				itemDefinition.newModelColourProduced[1] = 10508;
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				break;
			case 16117:
				npcInstance = EntityDefinition.forId(4922);
				itemDefinition.inventoryModel = npcInstance.models[0];
				itemDefinition.name = "Ice Queen pet";
				itemDefinition.zoom = 700;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 80;
				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.modelColourToEdit[0] = 41;
				itemDefinition.modelColourToEdit[1] = 61;
				itemDefinition.modelColourToEdit[2] = 4550;
				itemDefinition.modelColourToEdit[3] = 12224;
				itemDefinition.modelColourToEdit[4] = 25238;
				itemDefinition.modelColourToEdit[5] = 6798;
				itemDefinition.newModelColourProduced = new int[6];
				itemDefinition.newModelColourProduced[0] = 43484;
				itemDefinition.newModelColourProduced[1] = 39386;
				itemDefinition.newModelColourProduced[2] = 41193;
				itemDefinition.newModelColourProduced[3] = 43484;
				itemDefinition.newModelColourProduced[4] = 43484;
				itemDefinition.newModelColourProduced[5] = 42209;
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				break;
			case 16116:
				itemDefinition.name = "Elder maul pet";
				itemDefinition.inventoryModel = 32792;
				itemDefinition.zoom = 1744;
				itemDefinition.rotationX = 429;
				itemDefinition.rotationY = 237;
				itemDefinition.inventoryX = -3;
				itemDefinition.inventoryY = -58;
				itemDefinition.brightness = -30;
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				break;
			case 16115:
				npcInstance = EntityDefinition.forId(547);
				itemDefinition.inventoryModel = npcInstance.models[0];
				itemDefinition.name = "Mi-Gor pet";
				itemDefinition.zoom = 2600;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				break;
			case 16114:
				itemDefinition.inventoryModel = 28469;
				itemDefinition.name = "Prospector Percy pet";
				itemDefinition.zoom = 2400;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				break;
			case 11996:
				itemDefinition.inventoryOptions = new String[]
				{"Spawn Item", null, "Check Uses", null, "Destroy"};
				break;
			case 16113:
				itemDefinition.inventoryOptions = new String[]
						{null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;
				break;
			case 16112:
				itemDefinition.inventoryOptions = new String[]
						{null, "Wield", "Dismantle", null, null};
				itemDefinition.name = "Armadyl godsword";
				itemDefinition.inventoryModel = 28075;
				itemDefinition.zoom = 1957;
				itemDefinition.rotationY = 498;
				itemDefinition.rotationX = 484;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = -1;
				itemDefinition.maleModel = 27649;
				itemDefinition.femaleModel = 27649;

				itemDefinition.modelColourToEdit = new int[10];
				itemDefinition.newModelColourProduced = new int[10];

				// Hilt section where the hands are wrapped around
				colour = ItemColours.BLACK + 6;
				itemDefinition.modelColourToEdit[0] = -22208;
				itemDefinition.newModelColourProduced[0] = colour == -1 ? -22208 : colour;

				// Hilt top section
				itemDefinition.modelColourToEdit[1] = -22477;
				itemDefinition.newModelColourProduced[1] = colour == -1 ? -22477 : colour;

				// Hilt section various sides
				itemDefinition.modelColourToEdit[2] = -22464;
				itemDefinition.newModelColourProduced[2] = colour == -1 ? -22464 : colour;

				// Hilt section, the bottom part, half of the furs
				itemDefinition.modelColourToEdit[3] = -24279;
				itemDefinition.newModelColourProduced[3] = colour == -1 ? -24279 : colour;

				// Hilt section, the bottom part, rest of the furs
				itemDefinition.modelColourToEdit[4] = -24271;
				itemDefinition.newModelColourProduced[4] = colour == -1 ? -24271 : colour;

				// Blade, left side
				colour = ItemColours.YELLOW_STRONG;
				itemDefinition.modelColourToEdit[5] = -22444;
				itemDefinition.newModelColourProduced[5] = colour == -1 ? -22444 : colour;

				colour = ItemColours.BLACK;
				// Blade, right side
				itemDefinition.modelColourToEdit[6] = -22423;
				itemDefinition.newModelColourProduced[6] = colour == -1 ? -22423 : colour;

				colour = 461770;
				// Blade decoration on the right
				itemDefinition.modelColourToEdit[7] = -22415;
				itemDefinition.newModelColourProduced[7] = colour == -1 ? -22415 : colour;

				// Blade tip on the right
				itemDefinition.modelColourToEdit[8] = -22419;
				itemDefinition.newModelColourProduced[8] = colour == -1 ? -22419 : colour;

				// Blade at the tip, inventory model only.
				itemDefinition.modelColourToEdit[9] = -22440;
				itemDefinition.newModelColourProduced[9] = colour == -1 ? -22440 : colour;
				break;
			case 16111:
				itemDefinition.name = "Plank pet";
				itemDefinition.inventoryModel = 15048;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 2000;
				itemDefinition.rotationX = 148;
				itemDefinition.rotationY = 356;
				itemDefinition.inventoryY = 18;
				itemDefinition.brightness = 25;
				itemDefinition.modelColourToEdit = new int[]
						{6806, 6439, 6558};
				itemDefinition.newModelColourProduced = new int[]
						{6796, 6802, 6796};
				break;
			case 16110:
				npcInstance = EntityDefinition.forId(5079);
				itemDefinition.name = "Delrith pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 2400;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 170;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16109:
				itemDefinition.name = "Cyan partyhat";
				itemDefinition.inventoryModel = 2635;
				itemDefinition.maleModel = 187;
				itemDefinition.femaleModel = 363;
				itemDefinition.zoom = 440;
				itemDefinition.rotationX = 1852;
				itemDefinition.rotationY = 76;
				itemDefinition.inventoryX = 1;
				itemDefinition.inventoryY = 1;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[1];
				itemDefinition.modelColourToEdit[0] = 926;
				itemDefinition.newModelColourProduced = new int[1];
				itemDefinition.newModelColourProduced[0] = 34770;
				break;
			case 589:
				itemDefinition.name = "Collector Amulet @whi@+@gr2@30% DP";
				break;
			case 20786:
				itemDefinition.name = "Collector Ring @whi@+@gr2@30% DP";
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.inventoryModel = 31519;
				itemDefinition.modelColourToEdit = new int[2];
				itemDefinition.modelColourToEdit[0] = 3008;
				itemDefinition.modelColourToEdit[1] = 5056;
				itemDefinition.newModelColourProduced = new int[2];
				itemDefinition.newModelColourProduced[0] = 17866;
				itemDefinition.newModelColourProduced[1] = 17866;
				break;
			case 16108:
				npcInstance = EntityDefinition.forId(465);
				itemDefinition.name = "Black Skeletal wyvern pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 3000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 300;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 30;
				itemDefinition.inventoryModel = npcInstance.models[0];
				itemDefinition.modelColourToEdit = new int[3];
				itemDefinition.modelColourToEdit[0] = 16920;
				itemDefinition.modelColourToEdit[1] = 16796;
				itemDefinition.modelColourToEdit[2] = 2838;
				itemDefinition.newModelColourProduced = new int[3];
				itemDefinition.newModelColourProduced[0] = 43156;
				itemDefinition.newModelColourProduced[1] = 43270;
				itemDefinition.newModelColourProduced[2] = 794;
				break;
			case 16107:
				npcInstance = EntityDefinition.forId(3968);
				itemDefinition.name = "Echned Zekin pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 3200;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 50;
				itemDefinition.inventoryX = 5;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = npcInstance.models[0];
				itemDefinition.modelColourToEdit = new int[3];
				itemDefinition.modelColourToEdit[0] = 16920;
				itemDefinition.modelColourToEdit[1] = 16796;
				itemDefinition.modelColourToEdit[2] = 2838;
				itemDefinition.newModelColourProduced = new int[3];
				itemDefinition.newModelColourProduced[0] = 43156;
				itemDefinition.newModelColourProduced[1] = 43270;
				itemDefinition.newModelColourProduced[2] = 794;
				break;
			case 16106:
				itemDefinition.name = "Shifter pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 2400;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 50;
				itemDefinition.inventoryX = 5;
				itemDefinition.inventoryY = 0;
				npcInstance = EntityDefinition.forId(1699);
				itemDefinition.inventoryModel = npcInstance.models[0];
				itemDefinition.modelColourToEdit = new int[3];
				itemDefinition.modelColourToEdit[0] = 16920;
				itemDefinition.modelColourToEdit[1] = 16796;
				itemDefinition.modelColourToEdit[2] = 2838;
				itemDefinition.newModelColourProduced = new int[3];
				itemDefinition.newModelColourProduced[0] = 43156;
				itemDefinition.newModelColourProduced[1] = 43270;
				itemDefinition.newModelColourProduced[2] = 794;
				break;
			case 16105:
				itemDefinition.name = "Cave abomination pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 4700;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				npcInstance = EntityDefinition.forId(7401);
				itemDefinition.inventoryModel = npcInstance.models[0];
				itemDefinition.modelColourToEdit = new int[3];
				itemDefinition.modelColourToEdit[0] = 16920;
				itemDefinition.modelColourToEdit[1] = 16796;
				itemDefinition.modelColourToEdit[2] = 2838;
				itemDefinition.newModelColourProduced = new int[3];
				itemDefinition.newModelColourProduced[0] = 43156;
				itemDefinition.newModelColourProduced[1] = 43270;
				itemDefinition.newModelColourProduced[2] = 794;
				break;
			case 16104:
				itemDefinition.name = "Quest point cape (b)";
				itemDefinition.inventoryModel = 19062;
				itemDefinition.maleModel = 18946;
				itemDefinition.femaleModel = 18984;
				itemDefinition.zoom = 2128;
				itemDefinition.rotationY = 504;
				itemDefinition.inventoryY = 1;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				break;
			
			case 3761:
				itemDefinition.name = "Zulrah's Wings";
				itemDefinition.inventoryModel = 50113;
				itemDefinition.maleModel = 50112;
				itemDefinition.femaleModel = 50112;
				itemDefinition.zoom = 1550;
				itemDefinition.rotationX = 800;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				break;
			/*case 3777:
				itemDefinition.name = "Donor Cape";
				itemDefinition.inventoryModel = 50114;
				itemDefinition.maleModel = 50114;
				itemDefinition.femaleModel = 50114;
				itemDefinition.zoom = 2128;
				itemDefinition.rotationX = 0;
				itemDefinition.rotationY = 504;
				itemDefinition.inventoryY = 1;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				break;
			*/
			case 4042:
				itemDefinition.name = "Mod Cape";
				itemDefinition.inventoryModel = 14125;
				itemDefinition.maleModel = 14126;
				itemDefinition.femaleModel = 14126;
				itemDefinition.zoom = 2128;
				itemDefinition.rotationX = 0;
				itemDefinition.rotationY = 504;
				itemDefinition.inventoryY = 1;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				break;
			case 6070:
				itemDefinition.name = "Admin Cape";
				itemDefinition.inventoryModel = 18957;
				itemDefinition.maleModel = 18957;
				itemDefinition.femaleModel = 18957;
				itemDefinition.zoom = 2128;
				itemDefinition.rotationX = 0;
				itemDefinition.rotationY = 504;
				itemDefinition.inventoryY = 1;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				break;
			case 4041:
				itemDefinition.name = "Admin Cape";
				itemDefinition.inventoryModel = 14127;
				itemDefinition.maleModel = 14128;
				itemDefinition.femaleModel = 14128;
				itemDefinition.zoom = 2128;
				itemDefinition.rotationX = 0;
				itemDefinition.rotationY = 504;
				itemDefinition.inventoryY = 1;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				break;
			case 3759:
				itemDefinition.name = "Owner Cape";
				itemDefinition.inventoryModel = 14129;
				itemDefinition.maleModel = 14130;
				itemDefinition.femaleModel = 14130;
				itemDefinition.zoom = 2128;
				itemDefinition.rotationX = 0;
				itemDefinition.rotationY = 504;
				itemDefinition.inventoryY = 1;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				break;
			case 20779:
				itemDefinition.name = "Hunting blade";
				break;

			case 16103:
				itemDefinition.name = "B & W Partyhat";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.inventoryModel = 16252;
				itemDefinition.zoom = 440;
				itemDefinition.rotationY = 76;
				itemDefinition.rotationX = 1852;
				itemDefinition.inventoryX = 1;
				itemDefinition.inventoryY = 1;
				itemDefinition.maleModel = 16246;
				itemDefinition.femaleModel = 16248;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.modelColourToEdit = new int[]
						{-10319};
				itemDefinition.newModelColourProduced = new int[]
						{127};
				break;
			case 16102:
				itemDefinition.name = "Ent pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 4100;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 110;
				npcInstance = EntityDefinition.forId(6594);
				itemDefinition.inventoryModel = npcInstance.models[0];
				itemDefinition.modelColourToEdit = new int[3];
				itemDefinition.modelColourToEdit[0] = 16920;
				itemDefinition.modelColourToEdit[1] = 16796;
				itemDefinition.modelColourToEdit[2] = 2838;
				itemDefinition.newModelColourProduced = new int[3];
				itemDefinition.newModelColourProduced[0] = 43156;
				itemDefinition.newModelColourProduced[1] = 43270;
				itemDefinition.newModelColourProduced[2] = 794;
				break;
			case 16101:
				itemDefinition.name = "Fareed pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 900;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 77;
				npcInstance = EntityDefinition.forId(3456);
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;

			case 16100:
				itemDefinition.name = "Abyssal tentacle";
				itemDefinition.inventoryModel = 28439;
				itemDefinition.maleModel = 28446;
				itemDefinition.femaleModel = 28446;
				itemDefinition.zoom = 840;
				itemDefinition.rotationX = 121;
				itemDefinition.rotationY = 280;
				itemDefinition.inventoryY = 56;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = "Check";
				itemDefinition.inventoryOptions[4] = "Dissolve";
				break;

			// Cavalier mask
			case 11277:
				itemDefinition.inventoryOptions = new String[]
						{null, "Wear", null, null, "Drop"};
				break;
			case 16099:
				itemInstance = ItemDefinition.forId(952);
				itemDefinition.name = "Spade";
				itemDefinition.inventoryOptions = new String[]
						{"Dig", null, null, null, "Drop"};
				itemDefinition.zoom = itemInstance.zoom;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.inventoryModel = itemInstance.inventoryModel;
				break;
			case 16098:
				itemDefinition.name = "Elder maul";
				itemDefinition.inventoryModel = 32792;
				itemDefinition.maleModel = 32678;
				itemDefinition.femaleModel = 32678;
				itemDefinition.zoom = 1744;
				itemDefinition.rotationX = 429;
				itemDefinition.rotationY = 237;
				itemDefinition.inventoryX = -3;
				itemDefinition.inventoryY = -58;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				break;
			case 16097:
				itemDefinition.inventoryOptions = new String[]
						{null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;
				break;
			case 16096:
				itemDefinition.name = "Bone bracelet";
				itemInstance = ItemDefinition.forId(11133);
				itemDefinition.inventoryOptions = new String[]
						{null, "Wear", null, null, "Drop"};
				itemDefinition.zoom = itemInstance.zoom;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.inventoryModel = itemInstance.inventoryModel;
				itemDefinition.maleModel = itemInstance.maleModel;
				itemDefinition.femaleModel = itemInstance.femaleModel;
				itemDefinition.newModelColourProduced = new int[]
						{75, 75, 75};
				itemDefinition.modelColourToEdit = new int[]
						{-22464, 9152, 8119};
				itemDefinition.description = "A reward from the 2017 Dawntained H'ween event.".getBytes();
				break;
			case 16095:
				itemDefinition.name = "Oversized bones";
				itemInstance = ItemDefinition.forId(536);
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 1700;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.inventoryModel = itemInstance.inventoryModel;
				itemDefinition.newModelColourProduced = new int[]
						{75};
				itemDefinition.modelColourToEdit = new int[]
						{127};
				itemDefinition.description = "I should take these back to the Shady figure.".getBytes();

				break;
			case 16094:
				itemDefinition.name = "50% Luke pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 2600;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				npcInstance = EntityDefinition.forId(604);
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;

			case 16093:
				itemDefinition.name = "Black Defender";
				itemDefinition.inventoryModel = 20578;
				itemDefinition.maleModel = 19261;
				itemDefinition.femaleModel = 20519;
				itemDefinition.zoom = 1049;
				itemDefinition.rotationX = 1010;
				itemDefinition.rotationY = 526;
				itemDefinition.inventoryX = 35;
				itemDefinition.inventoryY = -30;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[1];
				itemDefinition.modelColourToEdit[0] = 22439;
				itemDefinition.newModelColourProduced = new int[1];
				itemDefinition.newModelColourProduced[0] = 0;
				break;
			case 16092:
				itemDefinition.name = "Durial321 pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.inventoryModel = 2635;
				itemDefinition.maleModel = 187;
				itemDefinition.femaleModel = 363;
				itemDefinition.zoom = 440;
				itemDefinition.rotationX = 1852;
				itemDefinition.rotationY = 76;
				itemDefinition.inventoryX = 1;
				itemDefinition.inventoryY = 1;
				itemDefinition.brightness = -35;
				itemDefinition.modelColourToEdit = new int[1];
				itemDefinition.modelColourToEdit[0] = 926;
				itemDefinition.newModelColourProduced = new int[1];
				itemDefinition.newModelColourProduced[0] = 22464;
				break;

			case 16091:
				itemDefinition.inventoryOptions = new String[]
						{null, "Wield", "Dismantle", null, null};
				itemDefinition.name = "Armadyl godsword";
				itemDefinition.inventoryModel = 28075;
				itemDefinition.zoom = 1957;
				itemDefinition.rotationY = 498;
				itemDefinition.rotationX = 484;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = -1;
				itemDefinition.maleModel = 27649;
				itemDefinition.femaleModel = 27649;
				break;
			case 16090:
				itemDefinition.inventoryOptions = new String[]
						{null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;
				break;
			case 16089:
				itemDefinition.unNotedId = itemDefinition.itemId - 1;
				itemDefinition.notedItemTemplate = 799;
				break;
			case 16507:
				itemDefinition.name = "Customs Pet";
				itemDefinition.inventoryModel = 2426;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 1180;
				itemDefinition.rotationX = 172;
				itemDefinition.rotationY = 160;
				itemDefinition.inventoryY = -14;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = "Open";
				itemDefinition.inventoryOptions[1] = null;
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[2];
				itemDefinition.modelColourToEdit[0] = 2999;
				itemDefinition.modelColourToEdit[1] = 22410;
				itemDefinition.newModelColourProduced = new int[2];
				itemDefinition.newModelColourProduced[0] = 0;
				itemDefinition.newModelColourProduced[1] = 130770;
				break;
			    case 16088:
				itemDefinition.name = "Legendary Mystery box";
				itemDefinition.inventoryModel = 2426;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 1180;
				itemDefinition.rotationX = 172;
				itemDefinition.rotationY = 160;
				itemDefinition.inventoryY = -14;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = "Open";
				itemDefinition.inventoryOptions[1] = null;
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[2];
				itemDefinition.modelColourToEdit[0] = 2999;
				itemDefinition.modelColourToEdit[1] = 22410;
				itemDefinition.newModelColourProduced = new int[2];
				itemDefinition.newModelColourProduced[0] = 0;
				itemDefinition.newModelColourProduced[1] = 7114;
				break;
			case 16087:
				itemDefinition.unNotedId = itemDefinition.itemId - 1;
				itemDefinition.notedItemTemplate = 799;
				break;
			case 16086:
				itemDefinition.name = "Super Mystery box";
				itemDefinition.inventoryModel = 2426;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 1180;
				itemDefinition.rotationX = 172;
				itemDefinition.rotationY = 160;
				itemDefinition.inventoryY = -14;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = "Open";
				itemDefinition.inventoryOptions[1] = null;
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[2];
				itemDefinition.modelColourToEdit[0] = 2999;
				itemDefinition.modelColourToEdit[1] = 22410;
				itemDefinition.newModelColourProduced = new int[2];
				itemDefinition.newModelColourProduced[0] = 127;
				itemDefinition.newModelColourProduced[1] = 302770;
				break;
			case 16085:
				itemDefinition.unNotedId = itemDefinition.itemId - 1;
				itemDefinition.notedItemTemplate = 799;
				break;
			case 16084:
				itemDefinition.name = "Mystery box";
				itemDefinition.inventoryModel = 2426;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 1180;
				itemDefinition.rotationX = 172;
				itemDefinition.rotationY = 160;
				itemDefinition.inventoryY = -14;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = "Open";
				itemDefinition.inventoryOptions[1] = null;
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[2];
				itemDefinition.modelColourToEdit[0] = 2999;
				itemDefinition.modelColourToEdit[1] = 22410;
				itemDefinition.newModelColourProduced = new int[2];
				itemDefinition.newModelColourProduced[0] = 127;
				itemDefinition.newModelColourProduced[1] = 926;
				break;
			case 16083:
				itemDefinition.name = "Black demon pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 2250;
				itemDefinition.rotationY = 50;
				itemDefinition.rotationX = 1950;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 170;
				npcInstance = EntityDefinition.forId(7242);
				itemDefinition.inventoryModel = npcInstance.models[0];
				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.modelColourToEdit[0] = 910;
				itemDefinition.modelColourToEdit[1] = 912;
				itemDefinition.modelColourToEdit[2] = 1938;
				itemDefinition.modelColourToEdit[3] = 1814;
				itemDefinition.modelColourToEdit[4] = 1690;
				itemDefinition.modelColourToEdit[5] = 0;
				itemDefinition.newModelColourProduced = new int[6];
				itemDefinition.newModelColourProduced[0] = 898;
				itemDefinition.newModelColourProduced[1] = 4;
				itemDefinition.newModelColourProduced[2] = 8;
				itemDefinition.newModelColourProduced[3] = 12;
				itemDefinition.newModelColourProduced[4] = 16;
				itemDefinition.newModelColourProduced[5] = 5206;
				break;
			case 22315:
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemInstance = ItemDefinition.forId(13233);
				itemDefinition.zoom = itemInstance.zoom;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.inventoryModel = itemInstance.inventoryModel;
				itemDefinition.name = "Infernal Stone";
			
				break;
			case 16082:
				itemDefinition.name = "Fear reaper pet";
				itemInstance = ItemDefinition.forId(20773);
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = itemInstance.zoom;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.inventoryModel = itemInstance.inventoryModel;
				
				break;
			case 16081:
				itemDefinition.name = "Anti-santa pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 3000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 50;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = -10;
				itemDefinition.inventoryModel = 29015;
				break;
			case 13147:
				itemDefinition.name = "Small XP lamp";
				break;
			case 2528:
				itemDefinition.name = "Medium XP lamp";
				itemDefinition.newModelColourProduced = new int[]
						{8008, 8755};
				itemDefinition.modelColourToEdit = new int[]
						{11191, 11183};
				break;
			case 13145:
				itemDefinition.name = "Large XP lamp";
				break;
			case 4447:
				itemDefinition.name = "Huge XP lamp";
				break;
			case 784:
				itemDefinition.name = "Voting reward";
				itemDefinition.newModelColourProduced = new int[]
						{-25664, -21568, 8128};
				itemDefinition.modelColourToEdit = new int[]
						{5018, 61, 11177};
				itemDefinition.groundOptions = new String[]
						{null, null, "Take", null, null};
				itemDefinition.inventoryOptions = new String[]
						{"Claim", null, null, null, "Drop"};
				itemDefinition.description = "A reward from voting.".getBytes();
				break;
			case 5065:
				itemDefinition.name = "Book Of Wonder";
				itemDefinition.newModelColourProduced = new int[]
						{-25664, -21568, 8128};
				itemDefinition.modelColourToEdit = new int[]
						{5018, 61, 11177};
				itemDefinition.groundOptions = new String[]
						{null, null, "Take", null, null};
				itemDefinition.inventoryOptions = new String[]
						{"Claim", null, null, null, "Drop"};
				itemDefinition.description = "A reward from voting.".getBytes();
				break;
			case 16080:
				itemDefinition.name = "Penguin pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 2600;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				npcInstance = EntityDefinition.forId(2063);
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16079:
				itemDefinition.name = "Demon butler pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 550;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 80;
				npcInstance = EntityDefinition.forId(229);
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16078:
				itemDefinition.name = "Dessourt pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 3500;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				npcInstance = EntityDefinition.forId(6372);
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16077:
				itemDefinition.name = "Lava dragon pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 2500;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 350;
				itemDefinition.inventoryX = 180;
				itemDefinition.inventoryY = 50;
				npcInstance = EntityDefinition.forId(6593);
				itemDefinition.inventoryModel = npcInstance.models[1];
				break;
			case 16075:
				itemDefinition.name = "Jal-xil pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 8200;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 20;
				itemDefinition.inventoryX = -10;
				itemDefinition.inventoryY = 20;
				npcInstance = EntityDefinition.forId(7698);
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16073:
				itemDefinition.name = "Genie pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 400;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 20;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 82;
				npcInstance = EntityDefinition.forId(326);
				itemDefinition.inventoryModel = npcInstance.models[0];

				itemDefinition.modelColourToEdit = new int[6];
				itemDefinition.modelColourToEdit[0] = 4550;
				itemDefinition.modelColourToEdit[1] = 6798;
				itemDefinition.modelColourToEdit[2] = 926;
				itemDefinition.modelColourToEdit[3] = 43072;
				itemDefinition.modelColourToEdit[4] = 0;
				itemDefinition.modelColourToEdit[5] = 25238;
				itemDefinition.newModelColourProduced = new int[6];
				itemDefinition.newModelColourProduced[0] = 39888;
				itemDefinition.newModelColourProduced[1] = 40627;
				itemDefinition.newModelColourProduced[2] = 43924;
				itemDefinition.newModelColourProduced[3] = 13243;
				itemDefinition.newModelColourProduced[4] = 957;
				itemDefinition.newModelColourProduced[5] = 54177;
				break;
			case 16076:
				itemDefinition.name = "Ring of planking";
				itemDefinition.zoom = 830;
				itemDefinition.rotationY = 268;
				itemDefinition.rotationX = 180;
				itemDefinition.inventoryX = 3;
				itemDefinition.inventoryY = -35;
				itemDefinition.newModelColourProduced = new int[]
						{100, 8128};
				itemDefinition.modelColourToEdit = new int[]
						{9152, 127};
				itemDefinition.groundOptions = new String[]
						{null, null, "Take", null, null};
				itemDefinition.inventoryOptions = new String[]
						{null, "Wear", null, null, "Drop"};
				itemDefinition.inventoryModel = 2677;
				itemDefinition.description = "A ring that turns its wearer into a plank.".getBytes();
				break;

			case 16063:
				itemDefinition.inventoryOptions = new String[]
						{null, "Wield", "Dismantle", null, null};
				itemDefinition.name = "Armadyl godsword";
				itemDefinition.inventoryModel = 28075;
				itemDefinition.zoom = 1957;
				itemDefinition.rotationY = 498;
				itemDefinition.rotationX = 484;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = -1;
				itemDefinition.maleModel = 27649;
				itemDefinition.femaleModel = 27649;
				break;
			case 16062:
				itemDefinition.name = "Mcribb pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 2200;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 20;
				itemDefinition.inventoryX = -10;
				itemDefinition.inventoryY = 110;
				npcInstance = EntityDefinition.forId(763);
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 977: //item fix for cooking interface
				itemDefinition.newModelColourProduced = new int[]
						{7093};
				itemDefinition.modelColourToEdit = new int[]
						{22435};
				itemDefinition.rotationY = 140;
				//itemDefinition.inventory3dRotationX = 1920;
				break;
			case 16067:
				itemDefinition.name = "Purple graceful dye";
				itemDefinition.zoom = 760;
				itemDefinition.rotationY = 124;
				itemDefinition.rotationX = 1920;
				itemDefinition.inventoryY = -2;
				itemDefinition.newModelColourProduced = new int[]
						{-18003};
				itemDefinition.modelColourToEdit = new int[]
						{61};
				itemDefinition.groundOptions = new String[]
						{null, null, "Take", null, null};
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.inventoryModel = 2705;
				break;

			case 16064:
				itemDefinition.name = "Light blue graceful dye";
				itemDefinition.zoom = 760;
				itemDefinition.rotationY = 124;
				itemDefinition.rotationX = 1920;
				itemDefinition.inventoryY = -2;
				itemDefinition.newModelColourProduced = new int[]
						{-27314};
				itemDefinition.modelColourToEdit = new int[]
						{61};
				itemDefinition.groundOptions = new String[]
						{null, null, "Take", null, null};
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.inventoryModel = 2705;
				break;

			case 16066:
				itemDefinition.name = "Mustard graceful dye";
				itemDefinition.zoom = 760;
				itemDefinition.rotationY = 124;
				itemDefinition.rotationX = 1920;
				itemDefinition.inventoryY = -2;
				itemDefinition.newModelColourProduced = new int[]
						{7093};
				itemDefinition.modelColourToEdit = new int[]
						{61};
				itemDefinition.groundOptions = new String[]
						{null, null, "Take", null, null};
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.inventoryModel = 2705;
				break;

			case 7782:
				itemDefinition.name = "Agility XP [25k]";
				itemDefinition.inventoryOptions = new String[]
						{"Claim", null, null, null, "Drop"};
				break;
			case 7783:
				itemDefinition.name = "Agility XP [50k]";
				itemDefinition.inventoryOptions = new String[]
						{"Claim", null, null, null, "Drop"};
				break;
			case 7784:
				itemDefinition.name = "Agility XP [100k]";
				itemDefinition.inventoryOptions = new String[]
						{"Claim", null, null, null, "Drop"};
				break;

			case 16068:
				itemDefinition.name = "Red graceful dye";
				itemDefinition.zoom = 760;
				itemDefinition.rotationY = 124;
				itemDefinition.rotationX = 1920;
				itemDefinition.inventoryY = -2;
				itemDefinition.newModelColourProduced = new int[]
						{687};
				itemDefinition.modelColourToEdit = new int[]
						{61};
				itemDefinition.groundOptions = new String[]
						{null, null, "Take", null, null};
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.inventoryModel = 2705;
				break;

			case 16070:
				itemDefinition.name = "Green graceful dye";
				itemDefinition.zoom = 760;
				itemDefinition.rotationY = 124;
				itemDefinition.rotationX = 1920;
				itemDefinition.inventoryY = -2;
				itemDefinition.newModelColourProduced = new int[]
						{21916};
				itemDefinition.modelColourToEdit = new int[]
						{61};
				itemDefinition.groundOptions = new String[]
						{null, null, "Take", null, null};
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.inventoryModel = 2705;
				break;

			case 16072:
				itemDefinition.name = "White graceful dye";
				itemDefinition.zoom = 760;
				itemDefinition.rotationY = 124;
				itemDefinition.rotationX = 1920;
				itemDefinition.inventoryY = -2;
				itemDefinition.newModelColourProduced = new int[]
						{100};
				itemDefinition.modelColourToEdit = new int[]
						{61};
				itemDefinition.groundOptions = new String[]
						{null, null, "Take", null, null};
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.inventoryModel = 2705;
				break;

			case 16074:
				itemDefinition.name = "Blue graceful dye";
				itemDefinition.zoom = 760;
				itemDefinition.rotationY = 124;
				itemDefinition.rotationX = 1920;
				itemDefinition.inventoryY = -2;
				itemDefinition.newModelColourProduced = new int[]
						{-22105};
				itemDefinition.modelColourToEdit = new int[]
						{61};
				itemDefinition.groundOptions = new String[]
						{null, null, "Take", null, null};
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.inventoryModel = 2705;
				break;

			case 9594:
				itemDefinition.name = "Ground mud rune";
				break;
			case 20546:
				itemDefinition.name = "Reward casket (small)";
				break;
			case 20545:
				itemDefinition.name = "Reward casket (medium)";
				break;
			case 20544:
				itemDefinition.name = "Reward casket (large)";
				break;
			case 20543:
				itemDefinition.name = "Reward casket (huge)";
				break;
			case 16061:
				itemDefinition.name = "Eve pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 650;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 80;
				npcInstance = EntityDefinition.forId(7672);
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16060:
				itemDefinition.inventoryOptions = new String[]
						{null, "Wield", "Dismantle", null, null};
				itemDefinition.name = "Armadyl godsword"; // Black Ags
				itemDefinition.inventoryModel = 28075;
				itemDefinition.zoom = 1957;
				itemDefinition.rotationY = 498;
				itemDefinition.rotationX = 484;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = -1;
				itemDefinition.maleModel = 27649;
				itemDefinition.femaleModel = 27649;
				break;
			case 16059:
				npcInstance = EntityDefinition.forId(3475);
				itemDefinition.name = "The Untouchable pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 5000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 1700;
				itemDefinition.inventoryX = 35;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16058:
				itemDefinition.name = "Treus Dayth pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 3000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 20;
				npcInstance = EntityDefinition.forId(3616);
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16057:
				itemDefinition.name = "Hans pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 650;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 80;
				npcInstance = EntityDefinition.forId(3077);
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;

			case 16056:
				itemDefinition.inventoryOptions = new String[]
						{null, "Wield", "Dismantle", null, null};
				itemDefinition.name = "Twisted bow (Thuggahhh)";
				itemDefinition.inventoryModel = 32799;
				itemDefinition.maleModel = 32674;
				itemDefinition.femaleModel = 32674;
				itemDefinition.zoom = 2000;
				itemDefinition.rotationX = 1500;
				itemDefinition.rotationY = 720;
				itemDefinition.inventoryX = -3;
				itemDefinition.inventoryY = 1;
				itemDefinition.scaleX = 128;
				itemDefinition.scaleY = 128;
				itemDefinition.scaleZ = 128;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				break;

			case 16055:
				itemDefinition.name = "Abyssal tentacle";
				itemDefinition.inventoryModel = 28439;
				itemDefinition.maleModel = 28446;
				itemDefinition.femaleModel = 28446;
				itemDefinition.zoom = 840;
				itemDefinition.rotationX = 121;
				itemDefinition.rotationY = 280;
				itemDefinition.inventoryY = 56;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = "Check";
				itemDefinition.inventoryOptions[4] = "Dissolve";
				break;
			case 16054:
				npcInstance = EntityDefinition.forId(3028);
				itemDefinition.name = "Goblin pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 750;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 1400;
				itemDefinition.inventoryX = -15;
				itemDefinition.inventoryY = 63;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16053:
				npcInstance = EntityDefinition.forId(2807);
				itemDefinition.name = "Cow calf pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 4000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 1400;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16503:
				itemDefinition.name = "Easter Blood Money Box";
				itemDefinition.inventoryModel = 2426;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 1180;
				itemDefinition.rotationX = 172;
				itemDefinition.rotationY = 160;
				itemDefinition.inventoryY = -14;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = "Open";
				itemDefinition.inventoryOptions[1] = null;
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				itemDefinition.modelColourToEdit = new int[2];
				itemDefinition.modelColourToEdit[0] = 359770;
				itemDefinition.modelColourToEdit[1] = 22410;
				itemDefinition.newModelColourProduced = new int[2];
				itemDefinition.newModelColourProduced[0] = 92770;
				itemDefinition.newModelColourProduced[1] = 359770;
				break;
			case 16052:
				itemDefinition.inventoryOptions = new String[]
						{null, "Wield", "Dismantle", null, null};
				itemDefinition.name = "Twisted bow (Easter)";
				itemDefinition.inventoryModel = 32799;
				itemDefinition.maleModel = 32674;
				itemDefinition.femaleModel = 32674;
				itemDefinition.zoom = 2000;
				itemDefinition.rotationX = 1500;
				itemDefinition.rotationY = 720;
				itemDefinition.inventoryX = -3;
				itemDefinition.inventoryY = 1;
				itemDefinition.scaleX = 128;
				itemDefinition.scaleY = 128;
				itemDefinition.scaleZ = 128;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = "Wield";
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = null;
				break;
			case 16051:
				itemDefinition.name = "TzKal-Zuk pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.inventoryModel = 30536;
				itemDefinition.zoom = 905;
				itemDefinition.rotationY = 673;
				itemDefinition.rotationX = 427;
				itemDefinition.inventoryX = 3;
				itemDefinition.inventoryY = 3;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.brightness = -30;
				break;
			case 16050:
				itemDefinition.name = "Elysian spirit shield pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;
				itemDefinition.brightness = -30;
				break;
			case 16049:
				npcInstance = EntityDefinition.forId(4912);
				itemDefinition.name = "War tortoise pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 6000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 1400;
				itemDefinition.inventoryX = -30;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16048:
				npcInstance = EntityDefinition.forId(7561);
				itemDefinition.name = "Muttadile pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 3000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 100;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16047:
				itemDefinition.inventoryOptions = new String[]
						{null, "Wield", "Dismantle", null, null};
				itemDefinition.name = "Armadyl godsword";
				itemDefinition.inventoryModel = 28075;
				itemDefinition.zoom = 1957;
				itemDefinition.rotationY = 498;
				itemDefinition.rotationX = 484;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = -1;
				itemDefinition.maleModel = 27649;
				itemDefinition.femaleModel = 27649;
				break;
			case 16046:
				npcInstance = EntityDefinition.forId(7233);
				itemDefinition.name = "Lucky impling pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 700;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 1700;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 90;
				itemDefinition.inventoryModel = 31741;
				break;
			case 16045:
				npcInstance = EntityDefinition.forId(3474);
				itemDefinition.name = "The Everlasting pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 5000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 1700;
				itemDefinition.inventoryX = 35;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16044:
				npcInstance = EntityDefinition.forId(7102);
				itemDefinition.name = "Mutated Glough pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 1000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 150;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16043:
				npcInstance = EntityDefinition.forId(6637);
				itemDefinition.name = "Kalphite Princess pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 2900;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 40;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16042:
				itemDefinition.inventoryOptions = new String[]
						{null, "Wield", "Dismantle", null, null};
				itemDefinition.name = "Armadyl godsword";
				itemDefinition.inventoryModel = 28075;
				itemDefinition.zoom = 1957;
				itemDefinition.rotationY = 498;
				itemDefinition.rotationX = 484;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = -1;
				itemDefinition.maleModel = 27649;
				itemDefinition.femaleModel = 27649;
				break;
			case 16041:
				itemDefinition.inventoryOptions = new String[]
						{null, "Wield", null, null, null};
				itemDefinition.name = "Elysian spirit shield";
				itemDefinition.inventoryModel = 11072;
				itemDefinition.zoom = 1789;
				itemDefinition.rotationY = 431;
				itemDefinition.rotationX = 27;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 11;
				itemDefinition.maleModel = 11048;
				itemDefinition.femaleModel = 11048;
				break;
			case 6199:
				itemDefinition.name = "Pet mystery box";
				itemDefinition.description = "Open it to obtain a rare pet! 25 to collect! Includes 4 exclusive pets!".getBytes();
				itemDefinition.modelColourToEdit = new int[2];
				itemDefinition.modelColourToEdit[0] = 2999;
				itemDefinition.modelColourToEdit[1] = 22410;
				itemDefinition.newModelColourProduced = new int[2];
				itemDefinition.newModelColourProduced[0] = 127;
				itemDefinition.newModelColourProduced[1] = 356770;
				break;

			case 16040:
				npcInstance = EntityDefinition.forId(5504);
				itemDefinition.name = "Mr. Mordaut pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 1750;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 50;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;

			case 16039:
				npcInstance = EntityDefinition.forId(7277);
				itemDefinition.name = "Warped Jelly pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 2000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.brightness = 500;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;

			case 16038:
				npcInstance = EntityDefinition.forId(5523);
				itemDefinition.name = "Donator pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 600;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 100;
				itemDefinition.modelColourToEdit = npcInstance.modelColourToEdit;
				itemDefinition.newModelColourProduced = npcInstance.newModelColourProduced;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;

			case 16037:
				npcInstance = EntityDefinition.forId(3473);
				itemDefinition.name = "The Inadequacy pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 7000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 50;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;

			case 16036:
				npcInstance = EntityDefinition.forId(3140);
				itemDefinition.name = "Icefiend pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 1000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 50;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;

			case 16035:
				npcInstance = EntityDefinition.forId(1378);
				itemDefinition.name = "The Kendal pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 3000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 50;
				itemDefinition.inventoryModel = npcInstance.models[1];
				break;

			case 16034:
				itemDefinition.name = "Armadyl godsword pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.inventoryModel = 28075;
				itemDefinition.zoom = 1957;
				itemDefinition.rotationY = 498;
				itemDefinition.rotationX = 484;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = -1;
				itemDefinition.brightness = -35;
				break;

			case 16033:
				npcInstance = EntityDefinition.forId(6477);
				itemDefinition.name = "Mutant tarn pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 5750;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 150;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;

			case 16032:
				npcInstance = EntityDefinition.forId(2067);
				itemDefinition.name = "Mounted terrorbird pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 3000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 150;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;

			case 16031:
				itemDefinition.name = "Dad pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 1000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 100;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 80;
				npcInstance = EntityDefinition.forId(4130);
				itemDefinition.inventoryModel = npcInstance.models[1];
				break;

			case 16030:
				itemDefinition.name = "Rainbow partyhat pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.inventoryModel = 16252;
				itemDefinition.zoom = 440;
				itemDefinition.rotationY = 76;
				itemDefinition.rotationX = 1852;
				itemDefinition.inventoryX = 1;
				itemDefinition.inventoryY = 1;
				itemDefinition.maleModel = 16246;
				itemDefinition.femaleModel = 16248;
				itemDefinition.brightness = -50;
				break;

			case 16029:
				itemDefinition.name = "Party Pete pet";
				itemDefinition.inventoryOptions = new String[]
						{null, "Wear", null, null, null};
				itemDefinition.inventoryModel = 2635;
				itemDefinition.zoom = 440;
				itemDefinition.rotationY = 76;
				itemDefinition.rotationX = 1852;
				itemDefinition.inventoryX = 1;
				itemDefinition.inventoryY = 1;
				itemDefinition.maleModel = 187;
				itemDefinition.femaleModel = 363;
				itemDefinition.brightness = -50;
				break;

			case 16028:
				itemDefinition.name = "Demonic gorilla pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 8000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 1000;
				itemDefinition.zoom = 4000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 1000;
				itemDefinition.inventoryX = 0;
				itemDefinition.brightness = 35;
				itemDefinition.inventoryY = 300;
				npcInstance = EntityDefinition.forId(7144);
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;

			case 16027:
				itemDefinition.name = "JalTok-Jad pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 9000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 150;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 10;
				npcInstance = EntityDefinition.forId(7700);
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16026:
				itemDefinition.name = "Flaming pyrelord pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 2000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 150;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 80;
				npcInstance = EntityDefinition.forId(7394);
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16025:
				itemDefinition.name = "Wise Old Man pet";
				itemInstance = ItemDefinition.forId(1042);
				itemDefinition.inventoryModel = itemInstance.inventoryModel;
				itemDefinition.newModelColourProduced = itemInstance.newModelColourProduced;
				itemDefinition.modelColourToEdit = itemInstance.modelColourToEdit;
				itemDefinition.zoom = itemInstance.zoom;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.rotationY = itemInstance.rotationY;
				break;
			case 16024:
				itemDefinition.name = "Smoke devil pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 4000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 60;
				npcInstance = EntityDefinition.forId(7406);
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16023:
				itemDefinition.name = "Death pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 650;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 80;
				npcInstance = EntityDefinition.forId(5567);
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16021:
				itemDefinition.name = "Schoolgirl pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 1000;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				npcInstance = EntityDefinition.forId(1915);
				itemDefinition.inventoryModel = npcInstance.models[1];
				break;
			case 16022:
				itemDefinition.name = "Banker pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 650;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 80;
				npcInstance = EntityDefinition.forId(397);
				itemDefinition.inventoryModel = npcInstance.models[0];
				itemDefinition.modelColourToEdit = new int[5];
				itemDefinition.newModelColourProduced = new int[5];
				itemDefinition.modelColourToEdit[0] = 25238;
				itemDefinition.modelColourToEdit[1] = 8741;
				itemDefinition.modelColourToEdit[2] = 6798;
				itemDefinition.modelColourToEdit[3] = 8741;
				itemDefinition.modelColourToEdit[4] = 4550;
				itemDefinition.newModelColourProduced[0] = 45;
				itemDefinition.newModelColourProduced[1] = 45;
				itemDefinition.newModelColourProduced[2] = 41;
				itemDefinition.newModelColourProduced[3] = 45;
				itemDefinition.newModelColourProduced[4] = 4647;
				break;

			// Name change scroll.
			case 1505:
				itemDefinition.name = "Name change scroll";
				itemDefinition.inventoryOptions[0] = "Change name";
				break;
			case 20017:
				if (Config.PVP) {
					itemDefinition.name = "Ring of blood money";
					itemDefinition.newModelColourProduced = new int[]
							{940, 947};
					itemDefinition.modelColourToEdit = new int[]
							{9152, 9158};
				}
				break;
			// Zamorak halo
			case 12638:
				itemDefinition.inventoryX -= 3;
				break;
			case 1704:
			case 1706:
			case 1708:
			case 1710:
			case 1712:
				itemDefinition.operateOptions = new String[]
						{"Al Kharid", "Draynor", "Karamja", "Edgeville"};
				break;

			case 21166:
			case 21169:
			case 21171:
			case 21173:
			case 21175:
				itemDefinition.operateOptions = new String[]
						{"Lava Maze", "Bandit Camp", "Chaos Temple", null, null};
				break;

			case 11238:
			case 11240:
			case 11242:
			case 11244:
			case 11246:
			case 11248:
			case 11250:
			case 11252:
			case 11254:
			case 11256:
				itemDefinition.inventoryOptions = new String[]
						{"Loot", null, null, null, "Drop"};
				break;

			case 4079:
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				break;


			case 11941:
				itemDefinition.inventoryOptions[2] = "Withdraw";
				break;
			case 2740:
				itemDefinition.name = "Clue casket (1st release)";
				itemDefinition.inventoryOptions = new String[]
						{"Open", null, null, null, "Drop"};
				itemDefinition.modelColourToEdit = new int[1];
				itemDefinition.modelColourToEdit[0] = -22477;
				itemDefinition.newModelColourProduced = new int[1];
				itemDefinition.newModelColourProduced[0] = 123456;
				break;
			case 2742:
				itemDefinition.name = "Clue casket (2nd release)";
				itemDefinition.inventoryOptions = new String[]
						{"Open", null, null, null, "Drop"};
				itemDefinition.modelColourToEdit = new int[1];
				itemDefinition.modelColourToEdit[0] = -22477;
				itemDefinition.newModelColourProduced = new int[1];
				itemDefinition.newModelColourProduced[0] = 461770;
				break;
			case 2744:
				itemDefinition.name = "Clue casket (3rd release)";
				itemDefinition.inventoryOptions = new String[]
						{"Open", null, null, null, "Drop"};
				itemDefinition.modelColourToEdit = new int[1];
				itemDefinition.modelColourToEdit[0] = -22477;
				itemDefinition.newModelColourProduced = new int[1];
				itemDefinition.newModelColourProduced[0] = 127;
				break;

			case 14011:
				itemDefinition.inventoryModel = 65270;
				itemDefinition.name = "Completionist cape";
				itemDefinition.zoom = 1513;
				itemDefinition.maleEquipOffset = 5;
				itemDefinition.femaleEquipOffset = 9;
				itemDefinition.femaleEquipOffsetOther = -2;
				itemDefinition.rotationY = 279;
				itemDefinition.rotationX = 948;
				itemDefinition.inventoryX = -3;
				itemDefinition.inventoryY = 24;
				itemDefinition.maleModel = 65297;
				itemDefinition.femaleModel = 65316;
				itemDefinition.inventoryOptions = new String[]
						{null, "Wear", "Customise", null, "Drop"};
				break;

			case 14012:
				itemDefinition.name = "Completionist hood";
				itemDefinition.inventoryModel = 29629;
				itemDefinition.zoom = 760;
				itemDefinition.rotationY = 11;
				itemDefinition.rotationX = 81;
				itemDefinition.inventoryX = 1;
				itemDefinition.inventoryY = -3;
				itemDefinition.maleModel = 65292;
				itemDefinition.femaleModel = 65310;
				itemDefinition.inventoryOptions = new String[]
						{null, "Wear", null, null, "Drop"};
				break;

			case 14013:
				itemDefinition.name = "Veteran cape";
				itemDefinition.inventoryModel = 65261;
				itemDefinition.zoom = 1513;
				itemDefinition.rotationY = 279;
				itemDefinition.rotationX = 948;
				itemDefinition.inventoryX = -3;
				itemDefinition.inventoryY = 24;
				itemDefinition.maleModel = 65305;
				itemDefinition.femaleModel = 65318;
				itemDefinition.inventoryOptions = new String[]
						{null, "Wear", null, null, "Drop"};
				break;

			case 14014:
				itemDefinition.name = "Veteran hood";
				itemDefinition.zoom = 760;
				itemDefinition.rotationY = 11;
				itemDefinition.rotationX = 81;
				itemDefinition.inventoryX = 1;
				itemDefinition.inventoryY = -3;
				itemDefinition.inventoryModel = 29629;
				itemDefinition.maleModel = 29614;
				itemDefinition.femaleModel = 29623;
				itemDefinition.modelColourToEdit = new int[]
						{668, 675, 784, 815, 673, 685};
				itemDefinition.newModelColourProduced = new int[]
						{115, 107, 7093, -22105, 0, 979};
				itemDefinition.inventoryOptions = new String[]
						{null, "Wear", null, null, "Drop"};
				break;

			case 16013:
				itemDefinition.name = "Camel";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemInstance = ItemDefinition.forId(7003);
				itemDefinition.zoom = itemInstance.zoom;
				itemDefinition.rotationY = itemInstance.rotationX;
				itemDefinition.rotationX = itemInstance.rotationY;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.inventoryModel = itemInstance.inventoryModel;
				break;
			case 16014:
				itemDefinition.name = "Skotos";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.inventoryModel = 65016;
				itemDefinition.zoom = 1168;
				itemDefinition.rotationY = 2012;
				itemDefinition.rotationX = 0;
				break;
			case 16017:
				itemDefinition.name = "Cerberus pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 6500;
				itemDefinition.rotationY = 100;
				itemDefinition.rotationX = 100;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 50;
				npcInstance = EntityDefinition.forId(5866);
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16018:
				itemDefinition.name = "Blood money pet";
				itemInstance = ItemDefinition.forId(13316);
				itemDefinition.inventoryModel = itemInstance.inventoryModel;
				itemDefinition.newModelColourProduced = itemInstance.newModelColourProduced;
				itemDefinition.modelColourToEdit = itemInstance.modelColourToEdit;
				itemDefinition.zoom = itemInstance.zoom;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.rotationY = itemInstance.rotationY;
				break;
			case 16504:
				itemDefinition.inventoryModel = 3288;
				itemDefinition.name = "Death Cape";
				itemDefinition.description = "A cape worn by the Masters.".getBytes();
				itemDefinition.zoom = 1579;
				itemDefinition.inventoryY = -6;
				itemDefinition.inventoryX = 0;
				itemDefinition.rotationY= 500;
				itemDefinition.rotationX = 0;
				itemDefinition.maleModel = 3287;
				itemDefinition.femaleModel = 3287;
				itemDefinition.groundOptions = new String[5];
				itemDefinition.groundOptions[2] = "Take";
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[1] = "Wear";
				break;
			case 16506:
				itemDefinition.inventoryModel = 65321;
				itemDefinition.name = "Woodcutting 120 Cape";
				itemDefinition.description = "A cape worn by the Masters of Masters.".getBytes();
				itemDefinition.zoom = 2610;
				itemDefinition.inventoryY = 5;
				itemDefinition.inventoryX = 0;
				itemDefinition.rotationY= 500;
				itemDefinition.rotationX = 1000;
				itemDefinition.maleModel = 65320;
				itemDefinition.femaleModel = 65320;
				itemDefinition.groundOptions = new String[5];
				itemDefinition.groundOptions[2] = "Take";
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[1] = "Wear";
				break;
			case 16508:
				itemDefinition.inventoryModel = 50611;
				itemDefinition.name = "Runecessor Cape";
				itemDefinition.description = "A cape worn by the avid player.".getBytes();
				itemDefinition.zoom = 2610;
				itemDefinition.inventoryY = 5;
				itemDefinition.inventoryX = 0;
				itemDefinition.rotationY= 500;
				itemDefinition.rotationX = 1000;
				itemDefinition.maleModel = 50610;
				itemDefinition.femaleModel = 50610;
				itemDefinition.groundOptions = new String[5];
				itemDefinition.groundOptions[2] = "Take";
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[1] = "Wear";
				break;
			case 16505:
				itemDefinition.name = "Tekton Ring";
				itemInstance = ItemDefinition.forId(16076);
				itemDefinition.newModelColourProduced = new int[]
						{461770, 76770};
				itemDefinition.modelColourToEdit = new int[]
						{9152, 127};
				itemDefinition.zoom = itemInstance.zoom;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.inventoryModel = itemInstance.inventoryModel;
				itemDefinition.maleModel = itemInstance.maleModel;
				itemDefinition.femaleModel = itemInstance.maleModel;
				itemDefinition.description = "A Ring droped by Tekton give 7% droprate.".getBytes();
				itemDefinition.groundOptions = new String[5];
				itemDefinition.groundOptions[2] = "Take";
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[1] = "Wear";
                break;
			case 16019:
				itemDefinition.name = "Tekton pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 8000;
				itemDefinition.rotationY = 100;
				itemDefinition.rotationX = 100;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				npcInstance = EntityDefinition.forId(7544);
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16020:
				itemDefinition.name = "Yoshi pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 750;
				itemDefinition.rotationY = 100;
				itemDefinition.rotationX = 250;
				itemDefinition.inventoryX = 10;
				itemDefinition.inventoryY = 100;
				npcInstance = EntityDefinition.forId(1873);
				itemDefinition.inventoryModel = npcInstance.models[0];
				itemDefinition.modelColourToEdit = new int[1];
				itemDefinition.newModelColourProduced = new int[1];

				itemDefinition.modelColourToEdit= new int[14];
				itemDefinition.newModelColourProduced = new int[14];
				colour = 51136;
				itemDefinition.modelColourToEdit[0] = 29976;
				itemDefinition.newModelColourProduced[0] = 419770;

				colour = 419770;
				itemDefinition.modelColourToEdit[1] = 7502;
				itemDefinition.newModelColourProduced[1] = 356770 ;

				colour = 419770;
				itemDefinition.modelColourToEdit[2] = 27819;
				itemDefinition.newModelColourProduced[2] = 356770 ;

				colour = 419770;
				itemDefinition.modelColourToEdit[3] = 0;
				itemDefinition.newModelColourProduced[3] =   0 ;

				colour = 419770;
				itemDefinition.modelColourToEdit[4] = 29980;
				itemDefinition.newModelColourProduced[4] =419770;

				colour = 419770;
				itemDefinition.modelColourToEdit[5] = 28302;
				itemDefinition.newModelColourProduced[5] =  419770;

				colour = 419770;
				itemDefinition.modelColourToEdit[6] = 29980;
				itemDefinition.newModelColourProduced[6] = 419770;

				colour = 419770;
				itemDefinition.modelColourToEdit[7] = 27934;
				itemDefinition.newModelColourProduced[7] = 419770;
				
				// Circle on the ground, most inner first circle
				colour = 419770;
				itemDefinition.modelColourToEdit[8] = -26214;
				itemDefinition.newModelColourProduced[8] = 419770;

				// Second circle
				colour = 419770;
				itemDefinition.modelColourToEdit[9] = -26218;
				itemDefinition.newModelColourProduced[9] = 419770;

				// Third circle
				colour = 419770;
				itemDefinition.modelColourToEdit[10] = -26094;
				itemDefinition.newModelColourProduced[10] = 356770 ;

				// Fourth circle
				colour = 419770;
				itemDefinition.modelColourToEdit[11] = -25970;
				itemDefinition.newModelColourProduced[11] = 356770 ;

				// Fifth circle
				colour = 419770;
				itemDefinition.modelColourToEdit[12] = -25718;
				itemDefinition.newModelColourProduced[12] = 356770 ;

				// Sixth circle
				colour = 419770;
				itemDefinition.modelColourToEdit[13] = -23672;
				itemDefinition.newModelColourProduced[13] = 356770 ;


			
				break;
			case 13302:
				itemDefinition.name = "Mini blood key";
				break;
			case 20526:
				itemDefinition.name = "Blood key";
				break;
			case 16016:
				itemDefinition.name = "Corporeal beast pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 3700;
				itemDefinition.rotationY = 100;
				itemDefinition.rotationX = 100;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				npcInstance = EntityDefinition.forId(319);
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16015:
				itemDefinition.name = "Dharok pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 1000;
				itemDefinition.rotationY = 100;
				itemDefinition.rotationX = 100;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 100;
				npcInstance = EntityDefinition.forId(1673);
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16012:
				itemDefinition.name = "Vespula";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 8000;
				itemDefinition.rotationY = 100;
				itemDefinition.rotationX = 200;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = -30;
				npcInstance = EntityDefinition.forId(7531);
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16011:
				itemDefinition.name = "Vasa Nistirio";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 11500;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = -30;
				npcInstance = EntityDefinition.forId(7566);
				itemDefinition.inventoryModel = npcInstance.models[0];
				break;
			case 16010:
				itemDefinition.name = "The Night Beast";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 6500;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = -30;
				itemDefinition.inventoryModel = 32933;
				break;
			// This item id is used to fix herblore animation.
			case 3:
				itemDefinition.maleModel = 506;
				itemDefinition.femaleModel = 506;
				break;

			case 16007:
				itemDefinition.name = "Tormented demon pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 7300;
				itemDefinition.rotationY = 0;
				itemDefinition.rotationX = 0;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = -140;
				itemDefinition.inventoryModel = 44733;
				break;
			case 16008:
				itemDefinition.name = "Ice strykewyrm pet";
				itemDefinition.inventoryOptions = new String[]
						{null, null, null, null, "Drop"};
				itemDefinition.zoom = 7500;
				itemDefinition.rotationY = 30;
				itemDefinition.rotationX = 70;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				itemDefinition.inventoryModel = 51847;
				break;

			case 7478:
				itemDefinition.name = "Donator tokens";
				itemDefinition.inventoryOptions = new String[5];
				break;
	
			case 11863:
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[1] = "Wear";
				itemDefinition.inventoryOptions[2] = "Dismantle";
				break;

			// Monkey greegree.
			case 4024:
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = "Transform into...";
				itemDefinition.inventoryOptions[1] = null;
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				break;
			// Christmas cracker.
			case 962:
				itemDefinition.inventoryOptions = new String[]
						{"Open", null, null, null, "Drop"};
				break;
			case 4067:
				itemDefinition.name = "Vote ticket";
				break;
			case 13146:
				itemDefinition.name = "Xp lamp 1 million";
				break;
			case 16005:
				itemDefinition.name = "Soul talisman";
				itemDefinition.inventoryModel = 2496;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 1160;
				itemDefinition.rotationX = 160;
				itemDefinition.rotationY = 352;
				itemDefinition.inventoryX = 2;
				itemDefinition.inventoryY = 20;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = null;
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = "Locate";
				itemDefinition.inventoryOptions[4] = null;
				break;

			case 16006:
				itemDefinition.name = "Blood talisman";
				itemDefinition.inventoryModel = 2475;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 1160;
				itemDefinition.rotationX = 160;
				itemDefinition.rotationY = 352;
				itemDefinition.inventoryX = 2;
				itemDefinition.inventoryY = 20;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = null;
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = "Locate";
				itemDefinition.inventoryOptions[4] = null;
				break;

			case 16004:
				itemDefinition.name = "Dice (up to 100)";
				itemDefinition.inventoryOptions = new String[]
						{"Roll", null, "Withdraw seeds", null, null};
				itemDefinition.inventoryModel = 65004;
				itemDefinition.rotationX = 94;
				itemDefinition.rotationY = 215;
				itemDefinition.zoom = 1104;
				itemDefinition.inventoryX = 1;
				itemDefinition.inventoryY = 0;
				break;
			case 16002:
				itemInstance = ItemDefinition.forId(13316);
				itemDefinition.inventoryModel = itemInstance.inventoryModel;
				itemDefinition.newModelColourProduced = itemInstance.newModelColourProduced;
				itemDefinition.modelColourToEdit = itemInstance.modelColourToEdit;
				itemDefinition.zoom = itemInstance.zoom;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.name = "Blood money " + WebsiteRead.voteReward;
				break;
			case 16003:
				itemInstance = ItemDefinition.forId(13316);
				itemDefinition.inventoryModel = itemInstance.inventoryModel;
				itemDefinition.newModelColourProduced = itemInstance.newModelColourProduced;
				itemDefinition.modelColourToEdit = itemInstance.modelColourToEdit;
				itemDefinition.zoom = itemInstance.zoom;
				itemDefinition.inventoryX = itemInstance.inventoryX;
				itemDefinition.inventoryY = itemInstance.inventoryY;
				itemDefinition.rotationX = itemInstance.rotationX;
				itemDefinition.rotationY = itemInstance.rotationY;
				itemDefinition.name = "Blood money 10k";
				break;
			case 16000:
				itemDefinition.unNotedId = 16002;
				itemDefinition.notedItemTemplate = 799;
				break;
			case 16001:
				itemDefinition.unNotedId = 16003;
				itemDefinition.notedItemTemplate = 799;
				break;
			// Dark crabs cooked, burnt, raw.
			case 11936:
			case 11938:
			case 11934:
				itemDefinition.inventoryX = 10;
				break;
			case 14876:
				itemDefinition.name = "Ancient statuette";
				itemDefinition.inventoryModel = 47258;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 1513;
				itemDefinition.rotationX = 202;
				itemDefinition.rotationY = 0;
				itemDefinition.inventoryX = 43;
				itemDefinition.inventoryY = -1;
				break;
			case 14877:
				itemDefinition.name = "Seren statuette";
				itemDefinition.inventoryModel = 47257;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 1360;
				itemDefinition.rotationX = 337;
				itemDefinition.rotationY = 81;
				itemDefinition.inventoryX = 8;
				itemDefinition.inventoryY = -22;
				itemDefinition.inventoryOptions = new String[5];
				itemDefinition.inventoryOptions[0] = null;
				itemDefinition.inventoryOptions[1] = null;
				itemDefinition.inventoryOptions[2] = null;
				itemDefinition.inventoryOptions[3] = null;
				itemDefinition.inventoryOptions[4] = "Drop";
				break;
			case 14878:
				itemDefinition.name = "Armadyl statuette";
				itemDefinition.inventoryModel = 47256;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 1360;
				itemDefinition.rotationX = 148;
				itemDefinition.rotationY = 0;
				itemDefinition.inventoryX = -30;
				itemDefinition.inventoryY = 0;
				break;
			case 14879:
				itemDefinition.name = "Zamorak statuette";
				itemDefinition.inventoryModel = 47250;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 976;
				itemDefinition.rotationX = 75;
				itemDefinition.rotationY = 0;
				itemDefinition.inventoryX = 33;
				itemDefinition.inventoryY = 0;
				break;
			case 14880:
				itemDefinition.name = "Saradomin statuette";
				itemDefinition.inventoryModel = 47248;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 1488;
				itemDefinition.rotationX = 94;
				itemDefinition.rotationY = 75;
				itemDefinition.inventoryX = 37;
				itemDefinition.inventoryY = -14;
				break;
			case 14881:
				itemDefinition.name = "Bandos statuette";
				itemDefinition.inventoryModel = 47244;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 1360;
				itemDefinition.rotationX = 1841;
				itemDefinition.rotationY = 153;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = -47;
				break;
			case 14882:
				itemDefinition.name = "Ruby chalice";
				itemDefinition.inventoryModel = 47247;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 720;
				itemDefinition.rotationX = 1653;
				itemDefinition.rotationY = 105;
				itemDefinition.inventoryX = 57;
				itemDefinition.inventoryY = -4;
				break;
			case 14883:
				itemDefinition.name = "Guthixian brazier";
				itemDefinition.inventoryModel = 47252;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 1300;
				itemDefinition.rotationX = 1949;
				itemDefinition.rotationY = 141;
				itemDefinition.inventoryX = 0;
				itemDefinition.inventoryY = 0;
				break;
			case 14884:
				itemDefinition.name = "Armadyl totem";
				itemDefinition.inventoryModel = 47251;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 1032;
				itemDefinition.rotationX = 1872;
				itemDefinition.rotationY = 364;
				itemDefinition.inventoryX = 5;
				itemDefinition.inventoryY = 3;
				break;
			case 14885:
				itemDefinition.name = "Zamorak medallion";
				itemDefinition.inventoryModel = 47259;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 724;
				itemDefinition.rotationX = 916;
				itemDefinition.rotationY = 377;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = 0;
				break;
			case 14886:
				itemDefinition.name = "Saradomin carving";
				itemDefinition.inventoryModel = 47246;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 1744;
				itemDefinition.rotationX = 0;
				itemDefinition.rotationY = 0;
				itemDefinition.inventoryX = -25;
				itemDefinition.inventoryY = 2;
				break;
			case 14887:
				itemDefinition.name = "Bandos scrimshaw";
				itemDefinition.inventoryModel = 47245;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 921;
				itemDefinition.rotationX = 94;
				itemDefinition.rotationY = 552;
				itemDefinition.inventoryX = 1;
				itemDefinition.inventoryY = 0;
				break;
			case 14888:
				itemDefinition.name = "Saradomin amphora";
				itemDefinition.inventoryModel = 47254;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 1347;
				itemDefinition.rotationX = 1670;
				itemDefinition.rotationY = 81;
				itemDefinition.inventoryX = 12;
				itemDefinition.inventoryY = 21;
				break;
			case 14889:
				itemDefinition.name = "Ancient psaltery bridge";
				itemDefinition.inventoryModel = 47249;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 848;
				itemDefinition.rotationX = 1347;
				itemDefinition.rotationY = 111;
				itemDefinition.inventoryX = -5;
				itemDefinition.inventoryY = 0;
				break;
			case 14890:
				itemDefinition.name = "Bronzed dragon claw";
				itemDefinition.inventoryModel = 47255;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 835;
				itemDefinition.rotationX = 13;
				itemDefinition.rotationY = 512;
				itemDefinition.inventoryX = -1;
				itemDefinition.inventoryY = -1;
				break;
			case 14891:
				itemDefinition.name = "Third age carafe";
				itemDefinition.inventoryModel = 47243;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 1104;
				itemDefinition.rotationX = 1820;
				itemDefinition.rotationY = 130;
				itemDefinition.inventoryX = -9;
				itemDefinition.inventoryY = 29;
				break;
			case 14892:
				itemDefinition.name = "Broken statue headdress";
				itemDefinition.inventoryModel = 47253;
				itemDefinition.maleModel = -1;
				itemDefinition.femaleModel = -1;
				itemDefinition.zoom = 1360;
				itemDefinition.rotationX = 417;
				itemDefinition.rotationY = 512;
				itemDefinition.inventoryX = -9;
				itemDefinition.inventoryY = 0;
				break;

			case 14893:
				itemDefinition.unNotedId = 14876;
				itemDefinition.notedItemTemplate = 799;
				break;
			case 14894:
				itemDefinition.unNotedId = 14877;
				itemDefinition.notedItemTemplate = 799;
				break;
			case 14895:
				itemDefinition.unNotedId = 14878;
				itemDefinition.notedItemTemplate = 799;
				break;
			case 14896:
				itemDefinition.unNotedId = 14879;
				itemDefinition.notedItemTemplate = 799;
				break;
			case 14897:
				itemDefinition.unNotedId = 14880;
				itemDefinition.notedItemTemplate = 799;
				break;
			case 14898:
				itemDefinition.unNotedId = 14881;
				itemDefinition.notedItemTemplate = 799;
				break;
			case 14899:
				itemDefinition.unNotedId = 14882;
				itemDefinition.notedItemTemplate = 799;
				break;
			case 14900:
				itemDefinition.unNotedId = 14883;
				itemDefinition.notedItemTemplate = 799;
				break;
			case 14901:
				itemDefinition.unNotedId = 14884;
				itemDefinition.notedItemTemplate = 799;
				break;
			case 14902:
				itemDefinition.unNotedId = 14885;
				itemDefinition.notedItemTemplate = 799;
				break;
			case 14903:
				itemDefinition.unNotedId = 14886;
				itemDefinition.notedItemTemplate = 799;
				break;
			case 14904:
				itemDefinition.unNotedId = 14887;
				itemDefinition.notedItemTemplate = 799;
				break;
			case 14905:
				itemDefinition.unNotedId = 14888;
				itemDefinition.notedItemTemplate = 799;
				break;
			case 14906:
				itemDefinition.unNotedId = 14889;
				itemDefinition.notedItemTemplate = 799;
				break;
			case 14907:
				itemDefinition.unNotedId = 14890;
				itemDefinition.notedItemTemplate = 799;
				break;
			case 14908:
				itemDefinition.unNotedId = 14891;
				itemDefinition.notedItemTemplate = 799;
				break;
			case 14909:
				itemDefinition.unNotedId = 14892;
				itemDefinition.notedItemTemplate = 799;
				break;
		}
	}


}