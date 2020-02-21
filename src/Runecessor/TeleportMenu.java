package Runecessor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Handles the teleport menu
 * 
 * @author Alien
 *
 */
public class TeleportMenu extends RSInterface {

	/**
	 * The subframe
	 */
	private static final int SUB_FRAME = 61321;

	/**
	 * The searching content type
	 */
	public static final int SEARCH_CONTENT_TYPE = 38_394;

	/**
	 * The sprites location
	 */
	public static final String SPRITES = "Teleporting/sprite";

	/**
	 * The navigation buttons
	 */
	private static final String[] NAVIGATION = { "Monster", "Minigame", "Bosses", "Wildy", "City", "Skills",
			"@red@Donator", };
	
	/**
	 * The icons
	 */
	private static final int[] ICONS = {
			6, 5, 4, 3, 9, 7, 8
	};

	/**
	 * The monster teleports
	 */
	private static final String[] MONSTERS = { "Rock Crabs", "Cows", "Yaks", "Bob's Island", "Desert Bandits",
			"Elf Warriors", "Dagannoths", "Chickens", "Slayer Tower", "Brimhaven Dungeon", "Taverley Dungeon",
			"Stronghold Cave", "Relleka Dungeon", "Mithril Dragons", "Asgarnian Ice Cave", "Catacombs", "Cave Kraken",
			"Smoke Devils"};

	/**
	 * The minigame teleports
	 */
	private static final String[] MINIGAMES = { "Raids", "Warriors Guild", "Pest Control", "Fight Caves", "Barrows",
			"Clan Wars", "Shayzien Assault", "Mage Arena", "Duel Arena", "Inferno" };

	/**
	 * The boss teleports
	 */
	private static final String[] BOSSES = { "Barrelchest", "Dagannoth Kings", "King Black Dragon", "Giant Mole",
			"Kalphite Queen", "God Wars Dungeon", "Corporeal Beast", "Dagannoth Mother", "Kraken", "Zulrah", "Cerberus",
			"Smoke Devil", "Abyssal Sire", "Demonic Gorillas", "Lizardman Shaman"};

	/**
	 * The wildy teleports
	 */
	private static final String[] WILDY = { "Mage Bank", "Green Dragons @red@(10)", "Dark Castle @red@(15)",
			"Rev Caves @red@(40)", "Wildy Agility Course @red@(52)", "Vet'ion @red@(40)", "Callisto @red@(43)",
			"Scorpia @red@(54)", "Venenatis @red@(28)", "Chaos Elemental @red@(50)", "Chaos Fanatic @red@(41)",
			"Crazy Archaeologist @red@(23)", "Skeletal Wyverns @red@(48)", "East Dragons @red@(18)",
			"Wildy Volcano @red@(53)", "Chaos Altar @red@(15)", "Lava Dragons @red@(43)" };

	/**
	 * The city teleports
	 */
	private static final String[] CITY = { "Varrock", "Yanille", "Edgeville", "Lumbridge", "Ardougne", "Neitiznot",
			"Karamja", "Falador", "Taverly", "Camelot", "Catherby", "Al Kharid", "Morytania", "Grand Exchange",
			"Waterbirth", "Lletya", "Burthorpe", "Entrana", "Draynor", "Trollheim" };

	/**
	 * The donator teleports
	 */
	private static final String[] DONATOR = { "@red@Donator Zone", "@gre@Extreme Zone", "@yel@Uber Zone",
			"@cya@Diamond Zone", "Coming Soon", "Coming Soon", };

	/**
	 * The skill teleports
	 */
	private static final String[] SKILLS = { "Slayer Masters", "Lands End", "Skillers Cove", "Woodcutting Guild",
			"Falador Skilling Zone", "Agility Training", "Hunter", "Puro Puro", "Mining Guild", };

	/**
	 * All the teleports
	 */
	private static final List<String[]> TELEPORTS = Arrays.asList(MONSTERS, MINIGAMES, BOSSES, WILDY, CITY, SKILLS,
			DONATOR);
	
	/**
	 * The teleports
	 */
	public static final ArrayList<Teleport> teleports = new ArrayList<Teleport>();

	/**
	 * Whether searching
	 */
	public static boolean searching;

	/**
	 * The teleport search input
	 */
	public static String teleportSearchInput = "";

	/**
	 * Searching the teleports
	 * 
	 * @param string
	 *            the string
	 */
	public static void search() {
		/*
		 * Nothing
		 */
		if (teleportSearchInput == null) {
			return;
		}

		/*
		 * The found list
		 */
		ArrayList<Teleport> found = new ArrayList<Teleport>();
		
		/*
		 * Finding teleports
		 */
		teleports.stream().forEach(t -> {
			if (t.getDescription().toLowerCase().contains(teleportSearchInput.toLowerCase())) {
				if (found.size() < 20) {
					found.add(t);
				}
			}
		});
		
		/*
		 * The screen
		 */
		RSInterface rs = RSInterface.interfaceCache[60483];
		
		/*
		 * Set children
		 */
		rs.children = new int[found.size() * 3];
		
		/*
		 * Set scroll
		 */
		rs.scrollMax = found.size() * 21;
		
		/*
		 * The slot
		 */
		int slot = 0;
		
		/*
		 * Displays the teles
		 */
		for (Teleport tele : found) {
			rs.children[slot] = tele.getId();
			rs.children[slot + 1] = tele.getId() + 1;
			rs.children[slot + 2] = tele.getId() + 3;
			slot += 3;
		}
		
		/*
		 * Make sure the search button resets
		 */
		RSInterface.interfaceCache[61327].sprite1 = RSInterface.imageLoader(11, TeleportMenu.SPRITES);
	}

	/**
	 * Initialises the interface
	 * 
	 * @param t
	 *            the drawing area
	 */
	public static void init(TextDrawingArea[] t) {
		/*
		 * Start id
		 */
		int id = 60_000;
		/*
		 * The teleport menus
		 */
		for (String[] s : TELEPORTS) {
			RSInterface monster = addInterface(id);
			monster.totalChildren(2);
			id++;

			setBounds(SUB_FRAME, 0, 0, 0, monster);

			teleportMenu(t, id, s);
			setBounds(id, 0, 106, 1, monster);
			id += s.length * 5;
		}
		/*
		 * Search menu
		 */
		RSInterface search = addInterface(id);
		search.totalChildren(2);
		id++;

		setBounds(SUB_FRAME, 0, 0, 0, search);
		searchMenu(t, id);
		setBounds(id, 0, 106, 1, search);

		/*
		 * The subframe
		 */
		id = SUB_FRAME;
		int frame = 0;

		RSInterface third = addInterface(id);
		third.totalChildren(12 + (NAVIGATION.length * 4));
		id++;

		/*
		 * Background
		 */
		addSprite(id, 0, SPRITES);
		setBounds(id++, 16, 3, frame++, third);

		/*
		 * Title
		 */
		addText(id, "Innova Teleportation Menu", t, 2, 0xDF851B, true, true);
		setBounds(id++, 255, 13, frame++, third);

		/*
		 * Close button
		 */
		addHoverButton(id, "/Interfaces/runepouch/CLOSE", 0, 21, 21, "Close", 0, id + 1, 3);
		setBounds(id, 477, 9, frame++, third);

		addHoveredButton(id + 1, "/Interfaces/runepouch/CLOSE", 1, 21, 21, id + 2);
		setBounds(id + 1, 477, 9, frame++, third);
		id += 3;

		/*
		 * Search
		 */
		addHoverButton(id, SPRITES, 11, 35, 25, "Search " + id, 0, id + 1, 1);
		setBounds(id, 420, 38, frame++, third);

		addHoveredButton(id + 1, SPRITES, 12, 35, 25, id + 2);
		setBounds(id + 1, 420, 38, frame++, third);
		id += 3;

		addText(id, "Search", 0xEE9021, true, true, SEARCH_CONTENT_TYPE, t, 0);
		setBounds(id, 437, 64, frame, third);
		frame++;
		id++;

		int x = 27;

		/*
		 * Navigation
		 */
		for (int i = 0; i < NAVIGATION.length; i++) {

			addHoverButton(id, SPRITES, 1, 48, 38, "Select @gre@" + NAVIGATION[i], 0, id + 1, 1);
			setBounds(id, x, 38, frame++, third);

			addHoveredButton(id + 1, SPRITES, 2, 48, 38, id + 2);
			setBounds(id + 1, x, 38, frame++, third);
			id += 3;

			addText(id, NAVIGATION[i], t, 0, 0xEE9021, true, true);
			setBounds(id, x + 24, 64, frame, third);
			frame++;
			id++;
			
			addHDSprite(id, ICONS[i], SPRITES);
			setBounds(id++, x+7, 35, frame++, third);
			
		
			x += 50;
		}

		id += 10;

		/*
		 * Last teleports
		 */
		addText(id, "Last Teleport", t, 2, 0xEE9021, true, true);
		setBounds(id, 431, 165, frame, third);
		frame++;
		id++;

		int y = 185;

		for (int i = 0; i < 4; i++) {
			addClickableText(id, i + ". Empty", "Teleport to previous location", t, 0, 0xEE9021, true, true, 70);
			third.child(frame++, id, 395, y);
			id++;
			y += 17;
		}
	}

	/**
	 * Adds a teleport menu
	 * 
	 * @param t
	 *            the drawing area
	 * @param id
	 *            the id
	 * @param string
	 *            the menu
	 */
	private static void teleportMenu(TextDrawingArea[] t, int id, String[] string) {
		RSInterface scroll = addInterface(id);
		id++;
		scroll.totalChildren(string.length * 3);
		scroll.height = 198;
		scroll.width = 350;
		scroll.scrollMax = 10+string.length * 21;
		int frame = 0;
		int y = 5;
		int x = 65;
		for (String s : string) {
			teleports.add(new Teleport(id, s));
			addHoverButton(id, SPRITES, 13, 132, 38, "Teleport to @gre@" + s, 0, id + 1, 1);
			setBounds(id, x, y, frame++, scroll);
			addHoveredButton(id + 1, SPRITES, 14, 132, 38, id + 2);
			setBounds(id + 1, x, y, frame++, scroll);
			id += 3;
			addText(id, "" + s, t, 1, 0xEE9021, true, true);
			setBounds(id, 66 + x, y + 8, frame, scroll);
			frame++;
			id++;
			x += 134;
			if (x >= 210) {
				x = 65;
				y += 40;
			}
		}
	}

	/**
	 * Adds the search menu
	 * 
	 * @param t
	 *            the drawing area
	 * @param id
	 *            the id
	 * @param string
	 *            the menu
	 */
	private static void searchMenu(TextDrawingArea[] t, int id) {
		RSInterface scroll = addInterface(id);
		int size = 20;
		id++;
		scroll.totalChildren(size * 3);
		scroll.height = 198;
		scroll.width = 350;
		scroll.scrollMax = size * 21;
		int frame = 0;
		int y = 5;
		int x = 65;
		for (int i = 0; i < size; i++) {

			addHoverButton(id, SPRITES, 13, 132, 38, "Teleport to @gre@", 0, id + 1, 1);
			setBounds(id, x, y, frame++, scroll);

			addHoveredButton(id + 1, SPRITES, 14, 132, 38, id + 2);
			setBounds(id + 1, x, y, frame++, scroll);
			id += 3;

			addText(id, "", t, 1, 0xEE9021, true, true);
			setBounds(id, 66 + x, y + 8, frame, scroll);
			frame++;
			id++;
			x += 134;
			if (x >= 210) {
				x = 65;
				y += 40;
			}
		}
	}

	/**
	 * Represents a teleport
	 */
	public static class Teleport {

		/**
		 * The id
		 */
		private int id;

		/**
		 * The description
		 */
		private String description;

		/**
		 * The teleport
		 * 
		 * @param id
		 *            the id
		 * @param description
		 *            the description
		 */
		Teleport(int id, String description) {
			this.setId(id);
			this.setDescription(description);
		}

		/**
		 * Sets the id
		 *
		 * @return the id
		 */
		public int getId() {
			return id;
		}

		/**
		 * Sets the id
		 * 
		 * @param id
		 *            the id
		 */
		public void setId(int id) {
			this.id = id;
		}

		/**
		 * Sets the description
		 *
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}

		/**
		 * Sets the description
		 * 
		 * @param description
		 *            the description
		 */
		public void setDescription(String description) {
			this.description = description;
		}
	}
}