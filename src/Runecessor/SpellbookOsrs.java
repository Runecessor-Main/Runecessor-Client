package Runecessor;

public class SpellbookOsrs extends RSInterface {

	//Missing getScript method? Also, couldn't find a rename for contentType

	public final static boolean SPELLBOOK_ACTIVE = false;

	public static void build(StreamLoader archive, TextDrawingArea[] font) {
		setupMagicTab(archive, font);
		modifySpellLayer(archive, font);
		setupRunes(archive, font);
	}
	
	public static void setupMagicTab(StreamLoader archive, TextDrawingArea[] font) {
		RSInterface spellbook = RSInterface.addTabInterface(40000);
		
		int[] spell_hovers = {
			40101, 40111, 40121, 40201, 40211, 40221, 40231, 40241, 40251, 40261, 40271, 40281, 40291, 40301, 40311,
			40321, 40331, 40341, 40351, 40361, 40371, 40381, 40391, 40401, 40411, 40421, 40431, 40441,
			40451, 40461, 40471, 40481, 40491, 40501, 40511, 40521, 40531, 40541, 40551, 40561, 40571,
			40581, 40591, 40601, 40611, 40621, 40631, 40641, 40651, 40661, 40671, 40681, 40691, 40701,
			40711, 40721, 40731, 40741, 40751, 40761, 40771, 40781, 40791, 40131, 40141, 40151,
			40161, 40171, 40181, 40191
		};
		
		RSInterface.setChildren(1 + spell_hovers.length, spellbook);

		RSInterface.setBounds(12424, 1, 11, 0, spellbook);

		for(int i = 1, index = 0; i < spell_hovers.length + 1; i++, index++) {
			int y = index >= 35 ? 8 : 178;
			if(spell_hovers[index] == 40111)
				y = 211;
			else if(spell_hovers[index] == 40211 || spell_hovers[index] == 40251 || spell_hovers[index] == 40271 || spell_hovers[index] == 40291 || spell_hovers[index] == 40301 || spell_hovers[index] == 40401 || spell_hovers[index] == 40471 || spell_hovers[index] == 40371 || spell_hovers[index] == 40541)
				y -= 13;
			RSInterface.setBounds(spell_hovers[index], 5, y, i, spellbook);
		}
	}
	
	public static void modifySpellLayer(StreamLoader archive, TextDrawingArea[] font) {
		
		RSInterface spells_widget = RSInterface.interfaceCache[12424];
		spells_widget.scrollMax = 0;
		spells_widget.height = 245;
		spells_widget.width = 190;
		
		addBoxWithText(archive, 40100, -1, "Lumbridge Home Teleport", "Lumbridge Home\\nTeleport", "Requires no runes - recharge time\\n30 mins. Warning: This spell takes a\\nlong time to cast an will be\\ninterrupted by combat.", font, 0, 0, 5);
		addBoxWithText(archive, 40110, 3, "Enchant Crossbow Bolt", "Enchant Crossbow Bolt", "Minimum level 4 Magic Multiple\\nother requirements", font, 3, 0, 5);
		
		add3RunesSmallBox(archive, 40120, new int[][] {{563, 0, LAW}, {556, 0, AIR}, {557, 0, EARTH}}, 39, "Teleport to House", "Teleports you to your house", font, 23, 0, 5);
		add4RunesSmallBox(archive, 40130, new int[][] {{563, 1, LAW}, {566, 1, SOUL}, {557, 3, WATER}, {554, 4, FIRE}}, 68, "Teleport to Kourend", "Teleports you to Kourend", font, 52, 0, 5);
		add2RunesSmallBox(archive, 40140, new int[][] {{556, 6, AIR}, {560, 0, WRATH}}, 81, "Wind Surge", "Wind Surge", "A very high level Air missile", font, 60, 10, 2);
		add3RunesSmallBox(archive, 40150, new int[][] {{555, 9, WATER}, {556, 6, AIR}, {560, 0, WRATH}}, 84, "Water Surge", "A very high level Water missile", font, 62, 10, 2);
		add3RunesSmallBox(archive, 40160, new int[][] {{563, 0, LAW}, {560, 0, DEATH}, {562, 0, CHAOS}}, 84, "Teleport to Bounty\\nTarget", "Teleports you near your Bounty\\nHunter target", font, 64, 0, 5);
		add3RunesSmallBox(archive, 40170, new int[][] {{557, 9, EARTH}, {556, 6, AIR}, {560, 0, WRATH}}, 90, "Earth Surge", "A very high level Earth missile", font, 67, 10, 2);
		add3RunesSmallBox(archive, 40180, new int[][] {{565, 19, BLOOD}, {566, 19, SOUL}, {564, 0, COSMIC}}, 92, "Lvl-7 Enchant", "For use on zenyte jewellery", font, 68, 16, 5);
		add3RunesSmallBox(archive, 40190, new int[][] {{554, 9, FIRE}, {556, 6, AIR}, {560, 0, WRATH}}, 95, "Fire Surge", "A very high level Fire missile", font, 69, 10, 2);
		
		int new_boxes_index = 40200;
		for(SpellData spells : SpellData.values()) {
			if(spells.runes_data.length == 2 && spells.description.contains("\\n"))
				build2RunesBoxLarge(archive, new_boxes_index, spells.runes_data, spells.level, spells.spellName, spells.description, font);
			else if(spells.runes_data.length == 2)
				build2RunesBoxSmall(archive, new_boxes_index, spells.runes_data, spells.level, spells.spellName, spells.description, font);
			else if(spells.runes_data.length == 3 && spells.description.contains("\\n"))
				build3RunesBoxLarge(archive, new_boxes_index, spells.runes_data, spells.level, spells.spellName, spells.description, font);
			else if(spells.runes_data.length == 3)
				build3RunesBoxSmall(archive, new_boxes_index, spells.runes_data, spells.level, spells.spellName, spells.description, font);
			else if(spells.runes_data.length == 4)
				build4RunesBoxSmall(archive, new_boxes_index, spells.runes_data, spells.level, spells.spellName, spells.description, font);
			new_boxes_index += 10;
		}
		
		int[] spells = {
			40100, 1152, 1153, 40110, 1154, 1155, 1156, 1157, 1158, 1159, 1160, 1161, 1572, 1162,
			1163, 1164, 1165, 1166, 1167, 1168, 1169, 1170, 1171, 40120, 1172, 1173, 1174,
			1175, 1176, 1539, 1582, 12037, 1540, 1177, 1178, 1179, 1180, 1541, 1181, 1182, 15877,
			1190, 1191, 1192, 7455, 1183, 1184, 18470, 1185, 1186, 1542, 1187, 40130, 1188,
			1543, 12425, 1189, 1592, 1562, 1193, 40140, 12435, 40150, 12445, 40160, 6003,
			12455, 40170, 40180, 40190
		};
		
		int[] old_spells = {
			1152, 1153, 1154, 1155, 1156, 1157, 1158, 1159, 1160, 1161, 1572, 1162,
			1163, 1164, 1165, 1166, 1167, 1168, 1169, 1170, 1171, 1172, 1173, 1174,
			1175, 1176, 1539, 1582, 12037, 1540, 1177, 1178, 1179, 1180, 1541, 1181, 1182, 15877,
			1190, 1191, 1192, 7455, 1183, 1184, 18470, 1185, 1186, 1542, 1187, 1188,
			1543, 12425, 1189, 1592, 1562, 1193, 12435, 12445, 6003, 12455
		};
		
		RSInterface.setChildren(spells.length, spells_widget);
		
		for(int index = 0, startX = 10, startY = 4; index < spells.length;) {
			RSInterface spell = RSInterface.interfaceCache[spells[index]];
			spell.sprite1 = method207(index, archive, "normaloff");
			spell.sprite2 = method207(index, archive, "normalon");
			spell.parentId = 40000;
			for(int i = 0, sI = 40201; i < old_spells.length; i++) {
				if(spell.id == old_spells[i]) {
					spell.hoverType = sI;
					break;
				}
				sI += 10;
			}
			RSInterface.setBounds(spells[index], startX, startY, index, spells_widget);
			startX += 24;
			index++;
			if(index % 7 == 0) {
				startX = 10;
				startY += 24;
			}
		}
	}
	
	public static void setupRunes(StreamLoader archive, TextDrawingArea[] font) {
		drawSprite(archive, 43000, 0);
		drawSprite(archive, 43001, 1);
		drawSprite(archive, 43002, 2);
		drawSprite(archive, 43003, 3);
		drawSprite(archive, 43004, 4);
		drawSprite(archive, 43005, 5);
		drawSprite(archive, 43006, 6);
		drawSprite(archive, 43007, 7);
		drawSprite(archive, 43008, 8);
		drawSprite(archive, 43009, 9);
		drawSprite(archive, 43010, 10);
		drawSprite(archive, 43011, 11);
		drawSprite(archive, 43012, 12);
		drawSprite(archive, 43013, 13);
		drawSprite(archive, 43014, 14);
	}
	
	public static void addTextBox(StreamLoader archive, int id, int spellLevel, String spellName, String description, TextDrawingArea[] TDA) {
		RSInterface black_box = RSInterface.addInterface(id + 1);
		black_box.isMouseoverTriggereds = true;
		black_box.hoverType = -1;
		black_box.width = 182;
		black_box.height = id == 40110 ? 47 : 80;
		
		addBox(archive, id+2, id == 40110 ? 1 : 0, "boxes_1");
		RSInterface.addText(id + 3, "Level " + (spellLevel + 1) + ": " + spellName, 0xFF981F, true, true, 52, TDA, 1);
		RSInterface.addText(id + 4, description, 0xAF6A1A, true, true, 52, TDA, 0);
		
		RSInterface.setChildren(3, black_box);
		RSInterface.setBounds(id + 2, 0, 0, 0, black_box);
		RSInterface.setBounds(id + 3, 90, 4, 1, black_box);
		RSInterface.setBounds(id + 4, 90, id == 40110 ? 20 : 34, 2, black_box);
	}
	
	public static void addBoxWithText(StreamLoader archive, int id, int spellLevel, String top, String spellName, String description, TextDrawingArea[] TDA, int spriteId, int spellUsable, int actionType){
		RSInterface widget = RSInterface.addInterface(id);
		widget.id = id;
		widget.parentId = 40000;
		widget.hoverType = 5;
		widget.atActionType = actionType;
		//widget.contentType = 0;
		widget.hoverType = id + 1;
		widget.spellUsableOn = spellUsable;
		widget.selectedActionName = "Cast on";
		
		widget.width = 24; //How big the hover of the sprite is
		widget.height = 24; //How big the hover of the sprite is
		
		widget.tooltip = "Cast @gre@" + top;
		widget.spellName = spellName;
		widget.sprite1 = method207(spriteId, archive, "normalon");
		
		addTextBox(archive, id, spellLevel, spellName, description, TDA);
	}
	
	public static void addBox(StreamLoader archive, int id, int spriteId, String name) {
		RSInterface widget = RSInterface.addInterface(id);
		widget.id = id;
		widget.type = 5;
		widget.sprite1 = method207(spriteId, archive, name);
	}
	
	public static void drawSprite(StreamLoader archive, int id, int spriteId) {
		RSInterface widget = RSInterface.addInterface(id);
		widget.id = id;
		widget.type = 5;
		widget.sprite1 = method207(spriteId, archive, "runes");
	}
	
	public static void build2RunesBoxSmall(StreamLoader archive, int id, int[][] rune_data, int spellLevel, String spellName, String description, TextDrawingArea[] font) {
		RSInterface black_box = RSInterface.addInterface(id + 1);
		
		black_box.isMouseoverTriggereds = true;
		black_box.hoverType = -1;
		black_box.width = 182;
		black_box.height = 80;
		
		addBox(archive, id+2, 0, "boxes_1");
		RSInterface.addText(id + 3, "Level " + (spellLevel + 1) + ": " + spellName, 0xFF981F, true, true, 52, font, 1);
		RSInterface.addText(id + 4, description, 0xAF6A1A, true, true, 52, font, 0);
		addRuneText(id+5, rune_data[0][1]+1, rune_data[0][0], font);
		addRuneText(id+6, rune_data[1][1]+1, rune_data[1][0], font);
		
		RSInterface.setChildren(7, black_box);
		RSInterface.setBounds(id + 2, 0, 0, 0, black_box);
		RSInterface.setBounds(id + 3, 90, 4, 1, black_box);
		RSInterface.setBounds(id + 4, 90, 19, 2, black_box);
		RSInterface.setBounds(rune_data[0][2], 37, 35, 3, black_box);//Rune
		RSInterface.setBounds(rune_data[1][2], 112, 35, 4, black_box);//Rune
		RSInterface.setBounds(id + 5, 50, 66, 5, black_box);
		RSInterface.setBounds(id + 6, 123, 66, 6, black_box);
	}
	
	public static void build2RunesBoxLarge(StreamLoader archive, int id, int[][] rune_data, int spellLevel, String spellName, String description, TextDrawingArea[] font) {
		RSInterface black_box = RSInterface.addInterface(id + 1);
		
		black_box.isMouseoverTriggereds = true;
		black_box.hoverType = -1;
		black_box.width = 182;
		black_box.height = 93;
		
		addBox(archive, id+2, 2, "boxes_1");
		RSInterface.addText(id + 3, "Level " + (spellLevel + 1) + ": " + spellName, 0xFF981F, true, true, 52, font, 1);
		RSInterface.addText(id + 4, description, 0xAF6A1A, true, true, 52, font, 0);
		addRuneText(id+5, rune_data[0][1]+1, rune_data[0][0], font);
		addRuneText(id+6, rune_data[1][1]+1, rune_data[1][0], font);
		
		RSInterface.setChildren(7, black_box);
		RSInterface.setBounds(id + 2, 0, 0, 0, black_box);
		RSInterface.setBounds(id + 3, 90, 4, 1, black_box);
		RSInterface.setBounds(id + 4, 90, 20, 2, black_box);
		RSInterface.setBounds(rune_data[0][2], 37, 48, 3, black_box);//Rune
		RSInterface.setBounds(rune_data[1][2], 112, 48, 4, black_box);//Rune
		RSInterface.setBounds(id + 5, 50, 78, 5, black_box);
		RSInterface.setBounds(id + 6, 123, 78, 6, black_box);
	}
	
	public static void build3RunesBoxSmall(StreamLoader archive, int id, int[][] rune_data, int spellLevel, String spellName, String description, TextDrawingArea[] font) {
		RSInterface black_box = addInterface(id+1);
		black_box.isMouseoverTriggereds = true;
		black_box.hoverType = -1;
		black_box.width = 182;
		black_box.height = 80;
		
		addBox(archive, id+2, 0, "boxes_1");
		RSInterface.addText(id + 3, "Level " + (spellLevel + 1) + ": " + spellName, 0xFF981F, true, true, 52, font, 1);
		RSInterface.addText(id + 4, description, 0xAF6A1A, true, true, 52, font, 0);
		addRuneText(id+5, rune_data[0][1]+1, rune_data[0][0], font);
		addRuneText(id+6, rune_data[1][1]+1, rune_data[1][0], font);
		addRuneText(id+7, rune_data[2][1]+1, rune_data[2][0], font);
		
		RSInterface.setChildren(9, black_box);
		RSInterface.setBounds(id + 2, 0, 0, 0, black_box);
		RSInterface.setBounds(id + 3, 90, 4, 1, black_box);
		RSInterface.setBounds(id + 4, 90, 21, 2, black_box);
		RSInterface.setBounds(rune_data[0][2], 14, 35, 3, black_box);
		RSInterface.setBounds(rune_data[1][2], 74, 35, 4, black_box);
		RSInterface.setBounds(rune_data[2][2], 130, 35, 5, black_box);
		RSInterface.setBounds(id + 5, 26, 66, 6, black_box);
		RSInterface.setBounds(id + 6, 87, 66, 7, black_box);
		RSInterface.setBounds(id + 7, 142, 66, 8, black_box);
	}
	
	public static void build3RunesBoxLarge(StreamLoader archive, int id, int[][] rune_data, int spellLevel, String spellName, String description, TextDrawingArea[] font) {
		RSInterface black_box = RSInterface.addInterface(id + 1);
		
		black_box.isMouseoverTriggereds = true;
		black_box.hoverType = -1;
		black_box.width = 182;
		black_box.height = 93;
		
		addBox(archive, id+2, 2, "boxes_1");
		RSInterface.addText(id + 3, "Level " + (spellLevel + 1) + ": " + spellName, 0xFF981F, true, true, 52, font, 1);
		RSInterface.addText(id + 4, description, 0xAF6A1A, true, true, 52, font, 0);
		addRuneText(id+5, rune_data[0][1]+1, rune_data[0][0], font);
		addRuneText(id+6, rune_data[1][1]+1, rune_data[1][0], font);
		addRuneText(id+7, rune_data[2][1]+1, rune_data[2][0], font);
		
		RSInterface.setChildren(9, black_box);
		RSInterface.setBounds(id + 2, 0, 0, 0, black_box);
		RSInterface.setBounds(id + 3, 90, 4, 1, black_box);
		RSInterface.setBounds(id + 4, 90, 21, 2, black_box);
		RSInterface.setBounds(rune_data[0][2], 14, 48, 3, black_box);
		RSInterface.setBounds(rune_data[1][2], 74, 48, 4, black_box);
		RSInterface.setBounds(rune_data[2][2], 130, 48, 5, black_box);
		RSInterface.setBounds(id + 5, 26, 79, 6, black_box);
		RSInterface.setBounds(id + 6, 87, 79, 7, black_box);
		RSInterface.setBounds(id + 7, 142, 79, 8, black_box);
	}
	
	public static void build3RunesBoxLargest(StreamLoader archive, int id, int[][] rune_data, int spellLevel, String spellName, String description, TextDrawingArea[] font) {
		RSInterface black_box = RSInterface.addInterface(id + 1);
		
		black_box.isMouseoverTriggereds = true;
		black_box.hoverType = -1;
		black_box.width = 182;
		black_box.height = 106;
		
		addBox(archive, id+2, 3, "boxes_1");
		RSInterface.addText(id + 3, "Level " + (spellLevel + 1) + ": " + spellName, 0xFF981F, true, true, 52, font, 1);
		RSInterface.addText(id + 4, description, 0xAF6A1A, true, true, 52, font, 0);
		addRuneText(id+5, rune_data[0][1]+1, rune_data[0][0], font);
		addRuneText(id+6, rune_data[1][1]+1, rune_data[1][0], font);
		addRuneText(id+7, rune_data[2][1]+1, rune_data[2][0], font);
		
		RSInterface.setChildren(9, black_box);
		RSInterface.setBounds(id + 2, 0, 0, 0, black_box);
		RSInterface.setBounds(id + 3, 90, 2, 1, black_box);
		RSInterface.setBounds(id + 4, 90, 33, 2, black_box);
		RSInterface.setBounds(rune_data[0][2], 14, 61, 3, black_box);
		RSInterface.setBounds(rune_data[1][2], 74, 61, 4, black_box);
		RSInterface.setBounds(rune_data[2][2], 130, 61, 5, black_box);
		RSInterface.setBounds(id + 5, 26, 91, 6, black_box);
		RSInterface.setBounds(id + 6, 87, 91, 7, black_box);
		RSInterface.setBounds(id + 7, 142, 91, 8, black_box);
	}
	
	public static void build4RunesBoxSmall(StreamLoader archive, int id, int[][] rune_data, int spellLevel, String spellName, String description, TextDrawingArea[] font) {
		RSInterface black_box = RSInterface.addInterface(id + 1);
		black_box.isMouseoverTriggereds = true;
		black_box.hoverType = -1;
		black_box.width = 182;
		black_box.height = 80;
		
		addBox(archive, id+2, 0, "boxes_1");
		RSInterface.addText(id + 3, "Level " + (spellLevel + 1) + ": " + spellName, 0xFF981F, true, true, 52, font, 1);
		RSInterface.addText(id + 4, description, 0xAF6A1A, true, true, 52, font, 0);
		addRuneText(id+5, rune_data[0][1]+1, rune_data[0][0], font);
		addRuneText(id+6, rune_data[1][1]+1, rune_data[1][0], font);
		addRuneText(id+7, rune_data[2][1]+1, rune_data[2][0], font);
		addRuneText(id+8, rune_data[3][1]+1, rune_data[3][0], font);
		
		RSInterface.setChildren(11, black_box);
		RSInterface.setBounds(id + 2, 0, 0, 0, black_box);
		RSInterface.setBounds(id + 3, 90, 4, 1, black_box);
		RSInterface.setBounds(id + 4, 90, 21, 2, black_box);
		RSInterface.setBounds(rune_data[0][2], 7, 35, 3, black_box);
		RSInterface.setBounds(rune_data[1][2], 52, 35, 4, black_box);
		RSInterface.setBounds(rune_data[2][2], 97, 35, 5, black_box);
		RSInterface.setBounds(rune_data[3][2], 142, 35, 6, black_box);
		RSInterface.setBounds(id + 5, 22, 65, 7, black_box);
		RSInterface.setBounds(id + 6, 67, 65, 8, black_box);
		RSInterface.setBounds(id + 7, 112, 65, 9, black_box);
		RSInterface.setBounds(id + 8, 157, 65, 10, black_box);
	}
	
	public static void add2RunesSmallBox(StreamLoader archive, int id, int[][] rune_data, int spellLevel, String top, String spellName, String description, TextDrawingArea[] font, int spriteId, int spellUsable, int actionType) {
		RSInterface widget = RSInterface.addInterface(id);
		widget.id = id;
		widget.parentId = 40000;
		widget.type = 5;
		widget.atActionType = actionType;
		//widget.contentType = 0;
		widget.hoverType = id+1;
		widget.spellUsableOn = spellUsable;
		widget.selectedActionName = "Cast On";
		widget.width = 24;
		widget.height = 24;
		widget.tooltip = "Cast @gre@"+spellName;
		widget.spellName = spellName;
		
		widget.scriptCompareType = new int[3];
		widget.scriptCompareValue = new int[3];
		widget.scriptCompareType[0] = 3;
		widget.scriptCompareValue[0] = rune_data[0][1];
		widget.scriptCompareType[1] = 3;
		
		widget.scriptCompareValue[1] = rune_data[1][1];
		widget.scriptCompareType[2] = 3;
		widget.scriptCompareValue[2] = spellLevel;

		int runes_amount = 2;
		widget.valueIndexArray = new int[runes_amount+1][];
		for(int i = 0; i < runes_amount; i++) // the amount of runes this spell requires
			//widget.valueIndexArray[i] = getScript(rune_data[i][0]);
		
		widget.valueIndexArray[runes_amount] = new int[3];
		widget.valueIndexArray[runes_amount][0] = 1;
		widget.valueIndexArray[runes_amount][1] = 6;
		widget.valueIndexArray[runes_amount][2] = 0;
		
		widget.sprite1 = method207(spriteId, archive, "normaloff");
		widget.sprite2 = method207(spriteId, archive, "normalon");
		
		build2RunesBoxSmall(archive, id, rune_data, spellLevel, spellName, description, font);

	}

	public static void add3RunesSmallBox(StreamLoader archive, int id, int[][] rune_data, int spellLevel, String spellName, String description,TextDrawingArea[] font, int sid,int suo,int type){
		RSInterface widget = RSInterface.addInterface(id);
		widget.id = id;
		widget.parentId = 40000;
		widget.type = 5;
		widget.atActionType = type;
		//widget.contentType = 0;
		widget.hoverType = id+1;
		widget.spellUsableOn = suo;
		widget.selectedActionName = "Cast on";
		widget.width = 20;
		widget.height = 20;
		widget.tooltip = "Cast @gre@"+spellName;
		widget.spellName = spellName;
		
		widget.scriptCompareType = new int[4];
		widget.scriptCompareValue = new int[4];
		widget.scriptCompareType[0] = 3;
		widget.scriptCompareValue[0] = rune_data[0][1];
		widget.scriptCompareType[1] = 3;
		widget.scriptCompareValue[1] = rune_data[1][1];
		widget.scriptCompareType[2] = 3;
		widget.scriptCompareValue[2] = rune_data[2][1];
		widget.scriptCompareType[3] = 3;
		widget.scriptCompareValue[3] = spellLevel;
		
		int runes_amount = 3;
		widget.valueIndexArray = new int[runes_amount+1][];
		for(int i = 0; i < runes_amount; i++) // the amount of runes this spell requires
			//widget.valueIndexArray[i] = getScript(rune_data[i][0]);
		
		widget.valueIndexArray[runes_amount] = new int[3];
		widget.valueIndexArray[runes_amount][0] = 1;
		widget.valueIndexArray[runes_amount][1] = 6;
		widget.valueIndexArray[runes_amount][2] = 0;
		
		widget.valueIndexArray[3] = new int[3];
		widget.valueIndexArray[3][0] = 1;
		widget.valueIndexArray[3][1] = 6;
		widget.valueIndexArray[3][2] = 0;
		
		widget.sprite1 = method207(sid, archive, "normaloff");
		widget.sprite2 = method207(sid, archive, "normalon");
		
		if(id == 40160)
			build3RunesBoxLargest(archive, id, rune_data, spellLevel, spellName, description, font);
		else
			build3RunesBoxSmall(archive, id, rune_data, spellLevel, spellName, description, font);
	}

	public static void add4RunesSmallBox(StreamLoader archive, int id, int[][] rune_data, int spellLevel, String spellName, String description, TextDrawingArea[] font, int sid, int suo, int type){
		RSInterface widget = RSInterface.addInterface(id);
		widget.id = id;
		widget.parentId = 40000;
		widget.type = 5;
		widget.atActionType = type;
		//widget.contentType = 0;
		widget.hoverType = id+1;
		widget.spellUsableOn = suo;
		widget.selectedActionName = "Cast on";
		widget.width = 20;
		widget.height = 20;
		widget.tooltip = "Cast @gre@"+spellName;
		widget.spellName = spellName;
		
		widget.scriptCompareType = new int[5];
		widget.scriptCompareValue = new int[5];
		widget.scriptCompareType[0] = 3;
		widget.scriptCompareValue[0] = rune_data[0][1];
		widget.scriptCompareType[1] = 3;
		widget.scriptCompareValue[1] = rune_data[1][1];
		widget.scriptCompareType[2] = 3;
		widget.scriptCompareValue[2] = rune_data[2][1];
		widget.scriptCompareType[3] = 3;
		widget.scriptCompareValue[3] = rune_data[3][1];
		widget.scriptCompareType[4] = 3;
		widget.scriptCompareValue[4] = spellLevel;
		
		int runes_amount = 4;
		widget.valueIndexArray = new int[runes_amount+1][];
		for(int i = 0; i < runes_amount; i++) // the amount of runes this spell requires
			//widget.valueIndexArray[i] = getScript(rune_data[i][0]);
		
		widget.valueIndexArray[runes_amount] = new int[3];
		widget.valueIndexArray[runes_amount][0] = 1;
		widget.valueIndexArray[runes_amount][1] = 6;
		widget.valueIndexArray[runes_amount][2] = 0;
		
		widget.valueIndexArray[3] = new int[3];
		widget.valueIndexArray[3][0] = 1;
		widget.valueIndexArray[3][1] = 6;
		widget.valueIndexArray[3][2] = 0;
		
		widget.sprite1 = method207(sid, archive, "normaloff");
		widget.sprite2 = method207(sid, archive, "normalon");
		
		build4RunesBoxSmall(archive, id, rune_data, spellLevel, spellName, description, font);
		
	}
	
	public static void addRuneText(int id, int runeAmount, int runeId, TextDrawingArea[] font) {
		RSInterface widget = RSInterface.addTabInterface(id);
		widget.id = id;
		widget.parentId = 40000;
		widget.type = 4;
		widget.atActionType = 0;
		//widget.contentType = 0;
		widget.width = 0;
		widget.height = 14;
		widget.opacity = 0;
		widget.hoverType = -1;
		widget.scriptCompareType = new int[1];
		widget.scriptCompareValue = new int[1];
		widget.scriptCompareType[0] = 3;
		widget.scriptCompareValue[0] = runeAmount - 1;
		widget.valueIndexArray = new int[1][4];
		//widget.valueIndexArray[0] = getScript(runeId);
		widget.centerText = true;
		widget.textDrawingAreas = font[0];
		widget.textShadow = true;
		widget.message = "%1/"+runeAmount;
		widget.messageEnabled = "";
		widget.textColour = 12582912;
		widget.colourEnabled = 49152;
	}

	private static int FIRE = 43000, WATER = 43001, AIR = 43002, EARTH = 43003,
	MIND = 43004, BODY = 43005, DEATH = 43006, NATURE = 43007, CHAOS = 43008,
	LAW = 43009, COSMIC = 43010, BLOOD = 43011, SOUL = 43012, ASTRAL = 43013,
	WRATH = 43014, IBAN = 1410, DART = 12041, ORB = 1508, SARA = 1611, GUTHIX = 1622,
	ZAMORAK = 1633, BANANA = 18480;
	
	private enum SpellData {
		//554, 9, FIRE
		WIND_STRIKE("Wind Strike", "A basic Air missile", 0, new int[][] {{556, 0, AIR}, {558, 0, MIND}}, 10, 2),
		CONFUSE("Confuse", "Reduces your opponent's\\nattack by 5%", 2, new int[][] {{555, 0, WATER}, {557, 0, EARTH}, {559, 0, BODY}}, 10, 2),
		WATER_STRIKE("Water Strike", "A basic Water missile", 4, new int[][] {{555, 0, WATER}, {556, 0, AIR}, {558, 0, MIND}}, 10, 2),
		LVL_1_ENCHANT("Lvl-1 Enchant", "For use on sapphire jewellery", 6, new int[][] {{555, 0, WATER}, {564, 0, COSMIC}}, 16, 5),
		EARTH_STRIKE("Earth Strike", "A basic Earth missile", 8, new int[][] {{557, 1, EARTH}, {556, 0, AIR}, {558, 0, MIND}}, 10, 2),
		WEAKEN("Weaken", "Reduces your opponent's\\nstrength by 5%", 10, new int[][] {{555, 2, WATER}, {557, 1, EARTH}, {559, 0, BODY}}, 10, 2),
		FIRE_STRIKE("Fire Strike", "A basic Fire missile", 12, new int[][] {{554, 2, FIRE}, {556, 1, AIR}, {558, 0, MIND}}, 10, 2),
		BONES_2_BANANA("Bones to Bananas", "Changes all held bones into\\nbananas", 14, new int[][] {{557, 1, EARTH}, {555, 1, WATER}, {561, 0, NATURE}}, 10, 2),
		WIND_BOLT("Wind Bolt", "A low level Air missile", 16, new int[][] {{556, 1, AIR}, {562, 0, CHAOS}}, 10, 2),
		CURSE("Curse", "Reduces your opponent's\\ndefence by 5%", 18, new int[][] {{555, 1, WATER}, {557, 2, EARTH}, {559, 0, BODY}}, 10, 2),
		BIND("Bind", "Holds your opponent\\nfor 5 seconds", 19, new int[][] {{557, 2, EARTH}, {555, 2, WATER}, {561, 1, NATURE}}, 10, 2),
		LOW_ALCH("Low Level Alchemy", "Converts an item into gold", 20, new int[][] {{554, 2, FIRE}, {561, 0, NATURE}}, 16, 5),
		WATER_BOLT("Water Bolt", "A low level Water missile", 22, new int[][] {{555, 0, WATER}, {556, 2, AIR}, {562, 0, CHAOS}}, 10, 2),
		VARROCK_TELEPORT("Varrock Teleport", "Teleports you to Varrock", 24, new int[][] {{554, 0, FIRE}, {556, 2, AIR}, {563, 0, LAW}}, 0, 5),
		LVL_2_ENCHANT("Lvl-2 Enchant", "For use on emerald jewellery", 26, new int[][] {{556, 2, AIR}, {564, 0, COSMIC}}, 16, 5),
		EARTH_BOLT("Earth Bolt", "A low level Earth missile", 28, new int[][] {{557, 2, EARTH}, {556, 1, AIR}, {562, 0, CHAOS}}, 10, 2),
		LUMBRIDGE("Lumbridge Teleport", "Teleports you to Lumbridge", 30, new int[][] {{557, 0, EARTH}, {556, 2, AIR}, {563, 0, LAW}}, 0, 5),
		TELEGRAB("Telekinetic Grab", "Take an item you can see\\nbut can't reach", 32, new int[][] {{556, 0, AIR}, {563, 0, LAW}}, 10, 2),
		FIRE_BOLT("Fire Bolt", "A low level Fire missile", 34, new int[][] {{554, 3, FIRE}, {556, 2, AIR}, {562, 0, CHAOS}}, 10, 2),
		FALADOR_TELEPORT("Falador Teleport", "Teleports you to Falador", 36, new int[][] {{555, 0, WATER}, {556, 2, AIR}, {563, 0, LAW}}, 0, 5),
		CRUMBLE_UNDEAD("Crumble Undead", "Hits skeletons, ghosts,\\nshades & zombies hard", 38, new int[][] {{557, 1, EARTH}, {556, 1, AIR}, {562, 0, CHAOS}}, 10, 2),
		WIND_BLAST("Wind Blast", "A medium level Air missile", 40, new int[][] {{556, 2, AIR}, {560, 0, DEATH}}, 10, 2),
		SUPERHEAT("Superheat Item", "Smelt ore without a furnace", 42, new int[][]
		{
			{554, 3, FIRE},
			{561, 0, NATURE}}, 10, 2),
		CAMELOT_TELEPORT("Camelot Teleport", "Teleports you to Camelot", 44, new int[][] {{556, 4, AIR}, {563, 0, LAW}}, 0, 5),
		WATER_BLAST("Water Blast", "A medium level Water missile", 46, new int[][] {{555, 2, WATER}, {556, 2, AIR}, {560, 0, DEATH}}, 10, 2),
		LVL_3_ENCHANT("Lvl-3 Enchant", "For use on ruby jewellery", 48, new int[][] {{556, 4, FIRE}, {564, 0, COSMIC}}, 16, 5),
		IBAN_BLAST("Iban Blast", "Summons the wrath of Iban", 49, new int[][] {{554, 4, FIRE}, {560, 0, DEATH}, {1409, 0, IBAN}}, 10, 2),
		SNARE("Snare", "Holds your opponent\\nfor 10 seconds", 49, new int[][] {{557, 3, EARTH}, {555, 3, WATER}, {561, 2, NATURE}}, 10, 2),
		MAGIC_DART("Magic Dart", "A magic dart of slaying", 49, new int[][] {{4170, 0, DART}, {560, 0, DEATH}, {558, 3, MIND}}, 10, 2),
		ARDOUGNE_TELEPORT("Ardougne Teleport", "Teleports you to Ardougne", 50, new int[][] {{555, 1, WATER}, {563, 1, LAW}}, 0, 5),
		EARTH_BLAST("Earth Blast", "A medium level Earth missile", 52, new int[][] {{557, 3, EARTH}, {556, 2, AIR}, {560, 0, DEATH}}, 10, 2),
		HIGH_ALCH("High Level Alchemy", "Converts an item into\\nmore gold", 54, new int[][] {{554, 4, FIRE}, {561, 0, NATURE}}, 16, 5),
		CHARGE_WATER("Charge Water Orb", "Needs to be cast on\\na water obelisk", 55, new int[][] {{555, 29, WATER}, {564, 2, COSMIC}, {567, 0, ORB}}, 10, 2),
		LVL_4_ENCHANT("Lvl-4 Enchant", "For use on diamond jewellery", 56, new int[][] {{557, 9, EARTH}, {564, 0, COSMIC}}, 16, 5),
		WATCHTOWER_TELEPORT("Watertower Teleport", "Teleports you to the\\nWatchtower", 57, new int[][] {{557, 1, EARTH}, {563, 1, LAW}}, 0, 5),
		FIRE_BLAST("Fire Blast", "A medium level Fire missile", 58, new int[][] {{554, 4, FIRE}, {556, 3, AIR}, {560, 0, DEATH}}, 10, 2),
		CHARGE_EARTH("Charge Earth Orb", "Needs to be cast on\\nan earth obelisk", 59, new int[][] {{557, 29, EARTH}, {564, 2, COSMIC}, {567, 0, ORB}}, 10, 2),
		BONES_2_PEACHES("Bones to Peaches", "Turns Bones into Peaches", 59, new int[][] {{561, 1, NATURE}, {555, 3, WATER}, {557, 3, EARTH}}, 10, 2),
		SARA_STRIKE("Saradomin strike", "Summons the power of Saradomin", 59, new int[][] {{554, 1, FIRE}, {565, 1, BLOOD}, {556, 3, AIR}, {2415, 0, SARA}}, 10, 2),
		GUTHIX_CLAWS("Claws of Guthix", "Summons the power of Guthix", 59, new int[][] {{554, 0, FIRE}, {565, 1, BLOOD}, {556, 3, AIR}, {2416, 0, GUTHIX}}, 10, 2),
		ZAMORAK_FLAMES("Flames of Zamorak", "Summons the power of Zamorak", 59, new int[][] {{554, 3, FIRE}, {565, 1, BLOOD}, {556, 0, AIR}, {2417, 0, ZAMORAK}}, 10, 2),
		TROLLHEIM_TELEPORT("Trollheim Teleport", "Teleports you to Trollheim", 60, new int[][] {{554, 1, FIRE}, {563, 1, LAW}}, 0, 5),
		WIND_WAVE("Wind Wave", "A high level Air missile", 61, new int[][]
		{
			{556, 4, AIR},
			{565, 0, BLOOD}}, 10, 2),
		CHARGE_FIRE("Charge Fire Orb", "Needs to be cast on\\na fire obelisk", 62, new int[][] {{554, 29, FIRE}, {564, 2, COSMIC}, {567, 0, ORB}}, 10, 2),
		APE_ATOLL_TELEPORT("Teleport to Ape Atoll", "teleports you to Ape Atoll", 63, new int[][] {{554, 1, FIRE}, {555, 1, WATER}, {562, 1, LAW}, {1963, 0, BANANA}}, 0, 5),
		WATER_WAVE("Water Wave", "A high level Water missile", 64, new int[][] {{555, 6, WATER}, {554, 4, AIR}, {565, 0, BLOOD}}, 10, 2),
		CHARGE_AIR("Charge Air Orb", "Needs to be cast on\\nan air obelisk", 65, new int[][] {{556, 29, AIR}, {564, 3, COSMIC}, {567, 0, ORB}}, 10, 2),
		VULNERABILITY("Vulnerability", "Reduces your opponent's\\ndefence by 10%", 65, new int[][] {{557, 4, EARTH}, {555, 4, WATER}, {566, 0, SOUL}}, 10, 2),
		LVL_5_ENCHANT("Lvl-5 Enchant", "For use on dragonstone jewellery", 67, new int[][] {{555, 14, WATER}, {557, 14, EARTH}, {564, 0, COSMIC}}, 16, 5),
		EARTH_WAVE("Earth Wave", "A high level Earth missile", 69, new int[][] {{557, 6, EARTH}, {556, 4, AIR}, {565, 0, BLOOD}}, 10, 2),
		ENFEEBLE("Enfeeble", "Reduces your opponent's\\nstrength by 10%", 72, new int[][] {{557, 7, EARTH}, {555, 7, WATER}, {566, 0, SOUL}}, 10, 2),
		TELEOTHER_LUMBRIDGE("Teleother Lumbridge", "Teleports target to Lumbridge", 73, new int[][] {{566, 0, SOUL}, {563, 0, LAW}, {557, 0, EARTH}}, 10, 2),
		FIRE_WAVE("Fire Wave", "A high level Fire missile", 74, new int[][]
		{
			{554, 6, FIRE},
			{554, 4, AIR},
			{565, 0, BLOOD}}, 10, 2),
		ENTANGLE("Entangle", "Holds your opponent\\nfor 15 seconds", 78, new int[][] {{557, 4, EARTH}, {555, 4, WATER}, {561, 3, NATURE}}, 10, 2),
		STUN("Stun", "Reduces your opponent's\\nattack by 10%", 79, new int[][] {{557, 11, EARTH}, {555, 11, WATER}, {566, 0, SOUL}}, 10, 2),
		CHARGE("Charge", "Temporarily increases the power\\nof the three arena spells", 79, new int[][] {{554, 2, FIRE}, {565, 2, BLOOD}, {556, 2, AIR}}, 10, 2),
		WIND_SURGE("Wind Surge", "A very high level Air missile", 80, new int[][]
		{
			{556, 6, AIR},
			{21880, 0, WRATH}}, 10, 2),
		TELEOTHER_FALADOR("Teleother Falador", "Teleports target to Falador", 81, new int[][] {{566, 0, SOUL}, {563, 0, LAW}, {555, 0, WATER}}, 10, 2),
		WATER_SURGE("Water Surge", "A very high level Water missile", 84, new int[][]
		{
			{555, 9, WATER},
			{554, 6, AIR},
			{21880, 0, WRATH}}, 10, 2),
		TELEBLOCK("Tele Block", "Stops your target from teleporting", 84, new int[][] {{563, 0, LAW}, {562, 0, CHAOS}, {560, 0, DEATH}}, 10, 2),
		LVL_6_ENCHANT("Lvl-6 Enchant", "For use on onyx jewellery", 86, new int[][] {{557, 19, EARTH}, {554, 19, FIRE}, {564, 0, COSMIC}}, 16, 5),
		TELEOTHER_CAMELOT("Teleother Camelot", "Teleports target to Camelot", 89, new int[][] {{566, 1, SOUL}, {563, 0, LAW}}, 10, 2),
		EARTH_SURGE("Earth Surge", "A very high level Earth missile", 89, new int[][]
		{
			{557, 9, EARTH},
			{556, 6, AIR},
			{21880, 0, WRATH}}, 10, 2),
		LVL_7_ENCHANT("Lvl-7 Enchant", "For use on zenyte jewellery", 92, new int[][]
		{
			{565, 19, BLOOD},
			{566, 19, SOUL},
			{564, 0, COSMIC}}, 16, 5),
		FIRE_SURGE("Fire Surge", "A high very level Fire missile", 94, new int[][]
		{
			{554, 9, FIRE},
			{554, 6, AIR},
			{21880, 0, WRATH}}, 10, 2),

		;
		
		private String spellName, description;
		private int level, spellUseable, actionType;
		private int[][] runes_data;
		
		private SpellData(String spellName, String description, int level, int[][] runes_data, int spellUseable, int actionType) {
			this.spellName = spellName;
			this.description = description;
			this.level = level;
			this.runes_data = runes_data;
			this.spellUseable = spellUseable;
			this.actionType = actionType;
		}
	}
}
