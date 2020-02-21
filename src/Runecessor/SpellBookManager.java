package Runecessor;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Handles the filtering for all spell books
 * 
 * @author 2012
 *
 */
public class SpellBookManager {

	/**
	 * The order
	 */
	public enum SpellBookOrder {
		ORIGINAL(38_415),

		COMBAT(38_414),

		TELEPORT(38_413),

		;

		/**
		 * The component id
		 */
		private int id;

		/**
		 * Represents a spell book order
		 * 
		 * @param id
		 *            the id
		 */
		SpellBookOrder(int id) {
			this.id = id;
		}

		/**
		 * Gets the id
		 *
		 * @return the id
		 */
		public int getId() {
			return id;
		}
	}

	/**
	 * Handles the magic spell book
	 */
	public enum SpellBook {

		ANCIENT(
				/*
				 * Teleport
				 */
				new int[] { 12856, 13035, 13045, 13053, 13061, 13069, 13079, 13087, 13095, },
				/*
				 * Combat
				 */
				new int[] { 12939, 12987, 12901, 12861, 32600, 12963, 13011, 12919, 12881, 32620, 12951, 12999, 12911,
						12871, 32640, 12975, 13023, 12929, 12891, 32660 },
				/*
				 * Original
				 */
				new int[] { 12856, 12939, 12987, 13035, 12901, 12861, 32600, 13045, 12963, 13011, 13053, 12919, 12881,
						32620, 13061, 12951, 12999, 13069, 12911, 12871, 32640, 13079, 12975, 13023, 13087, 12929,
						12891, 32660, 13095, 1196, 12940, 12988, 13036, 12902, 12862, 13046, 12964, 13012, 13054, 12920,
						12882, 13062, 12952, 13000, 13070, 12912, 12872, 13080, 12976, 13024, 13088, 12930, 12892,
						13096 },
				null, null, 37_493, 38_404, 7),
		MODERN(
				/*
				 * Teleport
				 */
				new int[] { 1195, 1164, 1167, 1170, 1174, 1540, 1541, 7455, 18470 },
				/*
				 * Combat
				 */
				new int[] { 1152, 1153, 1154, 1156, 1157, 1158, 1160, 1161, 1572, 1163, 1166, 1169, 1171, 1172, 1175,
						1539, 1582, 12037, 1177, 1181, 1190, 1191, 1192, 1183, 1185, 1542, 1188, 1543, 1189, 1592, 1562,
						1193, 41_239, 12445, 41_242, 41_245, 41_248},
				/*
				 * Normal
				 */
				new int[] {1195, 1152, 1153, 1154, 1155, 1156, 1157, 1158, 1159, 1160, 1161,
						1572, 1162, 1163, 1164,
						1165, 1166, 1167, 1168, 1169, 1170, 1171, 1172, 1173, 1174, 1175, 1176, 1539, 1582, 12037, 1540,
						1177, 1178, 1179, 1180, 1541, 1181, 1182, 15877, 1190, 1191, 1192, 7455, 1183, 1184, 18470,
						1185, 1186, 1542, 1187, 1188, 1543, 12425, 1189, 1592, 1562, 1193, 41_239, 12435,
						12445, 41_242, 6003, 41_245, 12455, 41_248},
				/*
				 * Misc
				 */
				new int[] { 1168, 1162, 1178, 12425, 12435, 12455, },
				/*
				 * Skills
				 */
				new int[] { 1155, 1159, 1165, 1173, 1176, 1179, 1180, 1182, 15877, 1184, 1186, 1187, 6003 },
				1151, 34_933, 11),
		LUNAR(
				/*
				 * Teleport
				 */
				new int[] { 30000, 30064, 30075, 30083, 30106, 30114, 30138, 30146, 30162, 30170, 30226, 30234, 30250,
						30258, 30266, 30274 },
				/*
				 * Combat
				 */
				new int[] { 30032, 30048, 30091, 30130, 30218, 30290, 30298, 30306, 30314, 30322 },
				/*
				 * Original
				 */
				new int[] { 30000, 30017, 30025, 30032, 30040, 30048, 30056, 30064, 30075, 30083, 30091, 30099, 30106,
						30114, 30122, 30130, 30138, 30146, 30154, 30162, 30170, 30178, 30186, 30194, 30202, 30210,
						30218, 30226, 30234, 30242, 30250, 30258, 30266, 30274, 30282, 30290, 30298, 30306, 30314,
						30322, },
				/*
				 * Misc
				 */
				new int[] { 30017, 30025, 30040, 30056, 30099, 30122, 30154, 30178, 30186, 30194, 30202, 30210, 30242,
						30282,

				}, null, 29_999, 38_292, 9),

		;

		/**
		 * The teleport ids
		 */
		private int[] teleport;

		/**
		 * The combat ids
		 */
		private int[] combat;

		/**
		 * The normal ids
		 */
		private int[] normal;

		/**
		 * The misc ids
		 */
		private int[] misc;

		/**
		 * The skill ids
		 */
		private int[] skill;

		/**
		 * The interface id
		 */
		private int interfaceId;

		/**
		 * The sorter interface id
		 */
		private int sorter;

		/**
		 * The slot
		 */
		private int slot;

		/**
		 * Represents a spell book
		 * 
		 * @param teleport
		 *            the teleport
		 * @param combat
		 *            the combat
		 * @param normal
		 *            the normal
		 * @param misc
		 *            the misc
		 * @param skill
		 *            the skill
		 * @param interfaceId
		 *            the interface id
		 * @param sorter
		 *            the sorter
		 * @param slot
		 *            the slot
		 */
		SpellBook(int[] teleport, int[] combat, int[] normal, int[] misc, int[] skill, int interfaceId, int sorter,
				int slot) {
			this.teleport = teleport;
			this.combat = combat;
			this.normal = normal;
			this.interfaceId = interfaceId;
			this.misc = misc;
			this.skill = skill;
			this.sorter = sorter;
			this.slot = slot;
		}

		/**
		 * Gets the teleport
		 *
		 * @return the teleport
		 */
		public int[] getTeleport() {
			return teleport;
		}

		/**
		 * Gets the combat
		 *
		 * @return the combat
		 */
		public int[] getCombat() {
			return combat;
		}

		/**
		 * Gets the normal
		 *
		 * @return the normal
		 */
		public int[] getNormal() {
			return normal;
		}

		/**
		 * Gets the interfaceId
		 *
		 * @return the interfaceId
		 */
		public int getInterfaceId() {
			return interfaceId;
		}

		/**
		 * Sets the misc
		 *
		 * @return the misc
		 */
		public int[] getMisc() {
			return misc;
		}

		/**
		 * Sets the skill
		 *
		 * @return the skill
		 */
		public int[] getSkill() {
			return skill;
		}

		/**
		 * Sets the sorter
		 *
		 * @return the sorter
		 */
		public int getSorter() {
			return sorter;
		}

		/**
		 * Sets the slot
		 *
		 * @return the slot
		 */
		public int getSlot() {
			return slot;
		}

		/**
		 * Gets the spell book based on side bar
		 * 
		 * @return the spell book
		 */
		public static SpellBook get() {
			return Arrays.stream(SpellBook.values()).filter(t -> t.getInterfaceId() == Client.tabInterfaceId[6])
					.findFirst().orElse(null);
		}
	}

	/**
	 * The spell book order
	 */
	public static SpellBookOrder spellBookOrder = SpellBookOrder.ORIGINAL;

	/**
	 * Whether hiding combat spells
	 */
	public static boolean hideCombatSpells;

	/**
	 * Whether hiding teleport spells
	 */
	private static boolean hideTeleportSpells;

	/**
	 * Whether hiding misc spells
	 */
	private static boolean hideMiscSpells;

	/**
	 * Whether hiding skill spells
	 */
	private static boolean hideSkillSpells;

	/**
	 * Whether to update
	 */
	public static boolean updateRequired = true;

	/**
	 * Draws the tab
	 */
	public static void drawSpellBook() {
		/*
		 * Non pre eoc
		 */
		if (!Config.PRE_EOC) {
			return;
		}
		/*
		 * No update required
		 */
		if (!updateRequired) {
			return;
		}
		/*
		 * The spell book
		 */
		SpellBook spellBook = SpellBook.get();
		/*
		 * No book
		 */
		if (spellBook == null) {
			return;
		}
		/*
		 * No order
		 */
		if (spellBookOrder == null) {
			return;
		}
		/*
		 * The tab
		 */
		RSInterface tab = RSInterface.interfaceCache[spellBook.getInterfaceId() == 1151 ? 37_333
				: spellBook.getInterfaceId()];
		/*
		 * The spells to show
		 */
		ArrayList<Integer> spells = new ArrayList<Integer>();
		/*
		 * The copy of the child interfaces
		 */
		int[] copy = tab.children.clone();
		/*
		 * Clears the interface
		 */
		tab.children = new int[tab.children.length];
		/*
		 * The slot
		 */
		int slot = 0;
		/*
		 * Show combat spells
		 */
		if (spellBookOrder.equals(SpellBookOrder.TELEPORT)) {
			/*
			 * Shows teleport spells
			 */
			if (!hideTeleportSpells) {
				Arrays.stream(spellBook.getTeleport()).forEach(t -> {
					spells.add(t);
				});
			}
			/*
			 * Shows skill spells
			 */
			if (!hideSkillSpells && spellBook.getSkill() != null) {
				Arrays.stream(spellBook.getSkill()).forEach(t -> {
					spells.add(t);
				});
			}
			/*
			 * Shows misc spells
			 */
			if (!hideMiscSpells && spellBook.getMisc() != null) {
				Arrays.stream(spellBook.getMisc()).forEach(t -> {
					spells.add(t);
				});
			}
			/*
			 * Show combat spells
			 */
			if (!hideCombatSpells) {
				Arrays.stream(spellBook.getCombat()).forEach(t -> {
					spells.add(t);
				});
			}
		} else if (spellBookOrder.equals(SpellBookOrder.COMBAT)) {
			/*
			 * Show combat spells
			 */
			if (!hideCombatSpells) {
				Arrays.stream(spellBook.getCombat()).forEach(t -> {
					spells.add(t);
				});
			}
			/*
			 * Shows skill spells
			 */
			if (!hideSkillSpells && spellBook.getSkill() != null) {
				Arrays.stream(spellBook.getSkill()).forEach(t -> {
					spells.add(t);
				});
			}
			/*
			 * Shows misc spells
			 */
			if (!hideMiscSpells && spellBook.getMisc() != null) {
				Arrays.stream(spellBook.getMisc()).forEach(t -> {
					spells.add(t);
				});
			}
			/*
			 * Shows teleport spells
			 */
			if (!hideTeleportSpells) {
				Arrays.stream(spellBook.getTeleport()).forEach(t -> {
					spells.add(t);
				});
			}
		} else if (spellBookOrder.equals(SpellBookOrder.ORIGINAL)) {
			normal: for (int original : spellBook.getNormal()) {
				/*
				 * Hide combat spells
				 */
				if (hideCombatSpells) {
					for (int combat : spellBook.getCombat()) {
						if (original == combat) {
							continue normal;
						}
					}
				}
				/*
				 * Hide skill spells
				 */
				if (hideSkillSpells) {
					for (int skill : spellBook.getSkill()) {
						if (original == skill) {
							continue normal;
						}
					}
				}
				/*
				 * Hide misc spells
				 */
				if (hideMiscSpells) {
					for (int misc : spellBook.getMisc()) {
						if (original == misc) {
							continue normal;
						}
					}
				}
				/*
				 * Hide teleport spells
				 */
				if (hideTeleportSpells) {
					for (int teleport : spellBook.getTeleport()) {
						if (original == teleport) {
							continue normal;
						}
					}
				}
				spells.add(original);
			}
		}
		/*
		 * Modern spell
		 */
		if (spellBook.getInterfaceId() == 1151) {
			/*
			 * The frame
			 */
			int frame = 0;
			/*
			 * Whether to showless
			 */
			boolean showLess = spells.size() < 50;
			/*
			 * The x
			 */
			int x = showLess ? -15 : -10;
			/*
			 * The y
			 */
			int y = 10;
			/*
			 * The scroll max
			 */
			tab.scrollMax = (int) (spells.size() * 4.9);
			/*
			 * The width
			 */
			tab.width = showLess ? 250 : 173;
			/*
			 * Display spells
			 */
			for (int spell : spells) {
				/*
				 * Next line
				 */
				if (x >= 23 * (showLess ? 7 : 6) - 10) {
					x = showLess ? -15 : -10;
					y += 25;
				}
				/*
				 * Draw spell
				 */
				x += 25;
				RSInterface sprite = RSInterface.interfaceCache[spell];
				/*
				 * The extra
				 */
				int spriteY = 0;
				int spriteX = 0;
				/*
				 * Valid
				 */
				if (sprite != null) {
					/*
					 * Set axis by name
					 */
					if (sprite.spellName != null) {
						if (sprite.spellName.toLowerCase().contains("vulnerability")
								|| sprite.spellName.toLowerCase().contains("teleother lumbridge")) {
							spriteY += 3;
						} else if (sprite.spellName.toLowerCase().contains("wave")) {
							spriteY -= 3;
							spriteX -= 2;
						} else if (sprite.spellName.toLowerCase().contains("orb")) {
							spriteY += 3;
							spriteX += 2;
						} else if (sprite.spellName.toLowerCase().contains("enfeeble")) {
							spriteX -= 3;
						}
					}
				}
				tab.child(frame, spell, x + spriteX, y + spriteY);
				frame++;
			}
		} else {
			/*
			 * Display spells
			 */
			for (int spell : spells) {
				tab.children[slot++] = spell;
			}
		}
		/*
		 * Hovers
		 */
		for (int i = spellBook.getNormal().length; i < copy.length; i++) {
			tab.children[i] = copy[i];
		}
		/*
		 * Reset update
		 */
		updateRequired = false;
	}

	/**
	 * Switching order
	 * 
	 * @param order
	 *            the order
	 */
	private static void switchSorting(SpellBookOrder order) {
		/*
		 * The spellbook
		 */
		SpellBook spellBook = SpellBook.get();
		/*
		 * No spellbook
		 */
		if (spellBook == null) {
			return;
		}
		/*
		 * The new spell book
		 */
		spellBookOrder = order;
		/*
		 * Sets book
		 */
		RSInterface.interfaceCache[spellBook.getSorter()].children[spellBook.getSlot()] = order.getId();
	}
	
	/**
	 * Handles buttons
	 * 
	 * @param buttonId
	 *            the button id
	 * @return the button
	 */
	public static boolean handleButton(int buttonId) {
		/*
		 * Not pre eoc
		 */
		if (!Config.PRE_EOC) {
			return false;
		}
		switch (buttonId) {
		/*
		 * Ancient spellbook
		 */
		case 38_407:
			hideCombatSpells = !hideCombatSpells;
			RSInterface.interfaceCache[buttonId].sprite1 = Client.cacheSprite[hideCombatSpells ? 291 : 290];
			RSInterface.interfaceCache[38_404].childX[2] = hideCombatSpells ? 48 : 47;
			return true;
		case 38_408: 
			hideTeleportSpells = !hideTeleportSpells;
			RSInterface.interfaceCache[buttonId].sprite1 = Client.cacheSprite[hideTeleportSpells ? 291 : 290];
			RSInterface.interfaceCache[38_404].childX[3] = hideTeleportSpells ? 83 : 82;
			return true;
		/*
		 * Modern spellbook
		 */
		case 34_937:
			hideCombatSpells = !hideCombatSpells;
			RSInterface.interfaceCache[buttonId].sprite1 = Client.cacheSprite[hideCombatSpells ? 291 : 290];
			RSInterface.interfaceCache[34_933].childX[3] = hideCombatSpells ? 34 : 33;
			RSInterface.interfaceCache[34_933].childY[3] = hideCombatSpells ? 237 : 236;
			return true;
		case 34_939:
			hideTeleportSpells = !hideTeleportSpells;
			RSInterface.interfaceCache[buttonId].sprite1 = Client.cacheSprite[hideTeleportSpells ? 291 : 290];
			RSInterface.interfaceCache[34_933].childX[5] = hideTeleportSpells ? 55 : 54;
			RSInterface.interfaceCache[34_933].childY[5] = hideTeleportSpells ? 237 : 236;
			return true;
		case 34_941:
			hideMiscSpells = !hideMiscSpells;
			RSInterface.interfaceCache[buttonId].sprite1 = Client.cacheSprite[hideMiscSpells ? 291 : 290];
			RSInterface.interfaceCache[34_933].childX[7] = hideMiscSpells ? 76 : 75;
			RSInterface.interfaceCache[34_933].childY[7] = hideMiscSpells ? 237 : 236;
			return true;
		case 34_943:
			hideSkillSpells = !hideSkillSpells;
			RSInterface.interfaceCache[buttonId].sprite1 = Client.cacheSprite[hideSkillSpells ? 291 : 290];
			RSInterface.interfaceCache[34_933].childX[9] = hideSkillSpells ? 97 : 96;
			RSInterface.interfaceCache[34_933].childY[9] = hideSkillSpells ? 237 : 236;
			return true;
		/*
		 * Lunar spellbook
		 */
		case 38_296:
			hideCombatSpells = !hideCombatSpells;
			RSInterface.interfaceCache[buttonId].sprite1 = Client.cacheSprite[hideCombatSpells ? 291 : 290];
			RSInterface.interfaceCache[38_292].childX[3] = hideCombatSpells ? 39 : 38;
			RSInterface.interfaceCache[38_292].childY[3] = hideCombatSpells ? 237 : 236;
			return true;
		case 38_298:
			hideTeleportSpells = !hideTeleportSpells;
			RSInterface.interfaceCache[buttonId].sprite1 = Client.cacheSprite[hideTeleportSpells ? 291 : 290];
			RSInterface.interfaceCache[38_292].childX[5] = hideTeleportSpells ? 65 : 64;
			RSInterface.interfaceCache[38_292].childY[5] = hideTeleportSpells ? 237 : 236;
			return true;
		case 38_300:
			hideMiscSpells = !hideMiscSpells;
			RSInterface.interfaceCache[buttonId].sprite1 = Client.cacheSprite[hideMiscSpells ? 291 : 290];
			RSInterface.interfaceCache[38_292].childX[7] = hideMiscSpells ? 91 : 90;
			RSInterface.interfaceCache[38_292].childY[7] = hideMiscSpells ? 237 : 236;
			return true;
		case 24_833:
			switchSorting(SpellBookOrder.ORIGINAL);
			return true;
		case 24_815:
			switchSorting(SpellBookOrder.COMBAT);
			return true;
		case 24_830:
			switchSorting(SpellBookOrder.TELEPORT);
			return true;
		}
		return false;
	}
}