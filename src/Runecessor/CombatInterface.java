package Runecessor;

/**
 * Combat interface tooltips.
 * @author Lava, created on 05-03-2016.
 */
public class CombatInterface {
	//@formatter:off
	static int[] interfaceId =
	{
		// Runecessoral whip.
		12296, 12297, 12298,
		// Scimitar.
		2429, 2432, 2431, 2430,
		// Dagger.
		2282, 2285, 2284, 2283,
		// Bow.
		1772, 1771, 1770,
		// Staff.
		336, 335, 334,
		// Halberd.
		8468, 8467, 8466,
		// Hatchet/Axe.
		1704, 1707, 1706, 1705,
		// Knife.
		4454, 4453, 4452,
		// Mace.
		3802, 3805, 3804, 3803,
		// Unarmed.
		5862, 5861, 5860,
		// Pickaxe.
		5576, 5579, 5578, 5577,
		// Claws.
		7768, 7771, 7770, 7769,
		// Spear.
		4685, 4688, 4687, 4686,
		// Spear.
		433, 432, 431,
		// Godsword and 2h.
		4711, 4714, 4713, 4712,

		// chinchompa
		27506, 27507, 27508
	};

	static String[] text =
	{
		"(Defensive)\\n(Slash)\\n(Defence XP)", 
		"(Controlled)\\n(Slash)\\n(Shared XP)", 
		"(Accurate)\\n(Slash)\\n(Attack XP)",
		
		"(Accurate)\\n(Slash)\\n(Attack XP)", 
		"(Aggressive)\\n(Slash)\\n(Strength XP)", 
		"(Controlled)\\n(Stab)\\n(Shared XP)", 
		"(Defensive)\\n(Slash)\\n(Defence XP)",
		
		"(Accurate)\\n(Stab)\\n(Attack XP)", 
		"(Aggressive)\\n(Stab)\\n(Strength XP)", 
		"(Aggressive)\\n(Slash)\\n(Strength XP)", 
		"(Defensive)\\n(Stab)\\n(Defence XP)",
		
		"(Accurate)\\n(Ranged XP)", 
		"(Rapid)\\n(Ranged XP)", 
		"(Longrange)\\n(Ranged XP)\\n(Defence XP)",
		
		"(Accurate)\\n(Crush)\\n(Attack XP)", 
		"(Aggressive)\\n(Crush)\\n(Strength XP)", 
		"(Defensive)\\n(Crush)\\n(Defence XP)",
		
		"(Controlled)\\n(Stab)\\n(Shared XP)", 
		"(Aggressive)\\n(Slash)\\n(Strength XP)", 
		"(Defensive)\\n(Stab)\\n(Defence XP)",
		
		"(Accurate)\\n(Slash)\\n(Attack XP)", 
		"(Aggressive)\\n(Slash)\\n(Strength XP)", 
		"(Aggressive)\\n(Crush)\\n(Strength XP)", 
		"(Defensive)\\n(Slash)\\n(Defence XP)",
		
		"(Accurate)\\n(Ranged XP)", 
		"(Rapid)\\n(Ranged XP)", 
		"(Longrange)\\n(Ranged XP)\\n(Defence XP)",
		
		"(Accurate)\\n(Crush)\\n(Attack XP)", 
		"(Aggressive)\\n(Crush)\\n(Strength XP)", 
		"(Controlled)\\n(Stab)\\n(Shared XP)", 
		"(Defensive)\\n(Crush)\\n(Defence XP)",
		
		"(Accurate)\\n(Crush)\\n(Attack XP)", 
		"(Aggressive)\\n(Crush)\\n(Strength XP)", 
		"(Defensive)\\n(Crush)\\n(Defence XP)",
		
		"(Accurate)\\n(Stab)\\n(Attack XP)", 
		"(Aggressive)\\n(Stab)\\n(Strength XP)", 
		"(Aggressive)\\n(Crush)\\n(Strength XP)", 
		"(Defensive)\\n(Stab)\\n(Defence XP)",
		
		"(Accurate)\\n(Slash)\\n(Attack XP)", 
		"(Aggressive)\\n(Slash)\\n(Strength XP)", 
		"(Controlled)\\n(Stab)\\n(Shared XP)", 
		"(Defensive)\\n(Slash)\\n(Defence XP)",
		
		"(Controlled)\\n(Stab)\\n(Shared XP)", 
		"(Controlled)\\n(Slash)\\n(Shared XP)", 
		"(Controlled)\\n(Crush)\\n(Shared XP)", 
		"(Defensive)\\n(Stab)\\n(Defence XP)",
		
		"(Accurate)\\n(Crush)\\n(Attack XP)", 
		"(Aggressive)\\n(Crush)\\n(Strength XP)", 
		"(Defensive)\\n(Crush)\\n(Defence XP)",
		
		"(Accurate)\\n(Slash)\\n(Attack XP)", 
		"(Aggressive)\\n(Slash)\\n(Strength XP)", 
		"(Aggressive)\\n(Crush)\\n(Strength XP)",
		"(Defensive)\\n(Slash)\\n(Defence XP)",

		"(Longrange)\\n(Ranged XP)\\n(Defence XP)",
		"(Accurate)\\n(Short fuse)\\n(Ranged XP)",
		"(Rapid)\\n(Medium fuse)\\n(Ranged XP)",
		
		
	};
	//@formatter:on
	static int[][] position =
	{
		// Whip.
		{49, 184},
		{135, 131},
		{53, 131},

		// Scimitar.
		{53, 131},
		{135, 131},
		{49, 184},
		{131, 184},

		// Dagger.
		{53, 131},
		{135, 131},
		{49, 184},
		{131, 184},

		//Bow.
		{53, 131},
		{135, 131},
		{49, 184},

		// Staff.
		{54, 123},
		{54, 158},
		{54, 194},

		//Halberd.
		{53, 131},
		{135, 131},
		{49, 184},

		// Hatchet/Axe.
		{53, 131},
		{135, 131},
		{49, 184},
		{131, 184},

		//Knife.
		{53, 131},
		{135, 131},
		{49, 184},

		// Mace.
		{53, 131},
		{135, 131},
		{49, 184},
		{131, 184},

		// Unarmed.
		{53, 131},
		{135, 131},
		{49, 184},

		// Pickaxe.
		{53, 131},
		{135, 131},
		{49, 184},
		{131, 184},

		// Claws.
		{53, 131},
		{135, 131},
		{49, 184},
		{131, 184},

		// Spear.
		{53, 131},
		{135, 131},
		{49, 184},
		{131, 184},

		//Maul.
		{53, 131},
		{135, 131},
		{49, 184},

		// Godsword and 2h.
		{53, 131},
		{135, 131},
		{49, 184},
		{131, 184},

		// Chinchompa.
		{53, 184},
		{135, 131},
		{53, 131},

	};

	private final static String[][] miscText =
	{
		{"Auto Retaliate", "When active your player\\nwill automatically fight\\nback if attacked."},
		{"Special Attack", "Select to perform\\na special attack"},
		{"Select Spell", "(Attack with\\na spell)\\n(Magic XP)"}};

	private final static int[][] miscTextPosition =
	{
		{58, 237},
		{78, 263},
		{134, 190},};

	public static void applyCombatInterfaceTooltips() {
		if (Client.getTabId() != 0) {
			if (Client.toolTipOtherTimer > 0 && !Client.isShowSettingTicks()) {
				Client.toolTipOtherTimer--;
			}
			return;
		}
		if (Client.instance.menuActionRow == 0) {
			return;
		}

		int delay = 90;
		boolean hovered = false;

		if (Client.instance.menuActionName[Client.instance.menuActionRow - 1].contains("Select")) {
			boolean hovered1 = false;
			int indexSaved = -1;
			for (int index = 0; index < interfaceId.length; index++) {
				if (Client.combatInterfaceHoverString == interfaceId[index]) {
					hovered1 = true;
					indexSaved = index;
					break;
				}
			}
			if (!hovered1) {
				if (Client.toolTipOtherTimer > 0) {
					Client.toolTipOtherTimer--;
				}
			}
			else {
				if (Client.toolTipOtherTimer < delay) {
					Client.toolTipOtherTimer++;
				}
				else if (Client.toolTipOtherTimer >= delay) {
					Settings.drawToolTipOther(text[indexSaved], position[indexSaved][0], position[indexSaved][1]);
				}
			}
		}
		else {
			int textIndex = -1;
			if (Client.autoCastSpellTooltip) {
				textIndex = 2;
				hovered = true;
			}
			else {
				for (int index = 0; index < miscText.length; index++) {
					if (Client.instance.menuActionName[Client.instance.menuActionRow - 1].contains(miscText[index][0])) {
						textIndex = index;
						break;
					}
				}
			}
			if (textIndex != -1) {
				hovered = true;
			}
			if (!hovered) {
				if (Client.toolTipOtherTimer > 0) {
					Client.toolTipOtherTimer--;
				}
			}
			else {
				if (Client.toolTipOtherTimer < delay) {
					Client.toolTipOtherTimer++;
				}
				else if (Client.toolTipOtherTimer >= delay) {
					Settings.drawToolTipOther(miscText[textIndex][1], miscTextPosition[textIndex][0], miscTextPosition[textIndex][1]);
				}
			}
		}

	}
}
