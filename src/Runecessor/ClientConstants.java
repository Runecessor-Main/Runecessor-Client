package Runecessor;

public class ClientConstants {

	/**
	 * The slot identity of the head in the equipment tab.
	 */
	public static final int PLAYER_HEAD_SLOT = 0;

	/**
	 * The slot identity of the cape in the equipment tab.
	 */
	public static final int PLAYER_CAPE_SLOT = 1;

	/**
	 * The slot identity of the amulet in the equipment tab.
	 */
	public static final int PLAYER_AMULET_SLOT = 2;

	/**
	 * The slot identity of the weapon in the equipment tab.
	 */
	public static final int PLAYER_WEAPON_SLOT = 3;

	/**
	 * The slot identity of the torso in the equipment tab.
	 */
	public static final int PLAYER_BODY_SLOT = 4;

	/**
	 * The slot identity of the shield in the equipment tab.
	 */
	public static final int PLAYER_SHIELD_SLOT = 5;

	/**
	 * The slot identity of the leg in the equipment tab.
	 */
	public static final int PLAYER_LEG_SLOT = 7;

	/**
	 * The slot identity of the hand in the equipment tab.
	 */
	public static final int PLAYER_HAND_SLOT = 9;

	/**
	 * The slot identity of the feet in the equipment tab.
	 */
	public static final int PLAYER_FEET_SLOT = 10;

	/**
	 * The slot identity of the ring in the equipment tab.
	 */
	public static final int PLAYER_RING_SLOT = 12;

	/**
	 * The slot identity of the arrow in the equipment tab.
	 */
	public static final int PLAYER_ARROW_SLOT = 13;

	public final static int WILDERNESS_INTERFACE_OSRS = 197;

	public final static int WILDERNESS_INTERFACE_PRE_EOC_TOP_RIGHT = 24390;

	public final static int WILDERNESS_INTERFACE_PRE_EOC_BOTTOM_RIGHT = 24395;

	public final static int GOD_WARS_DUNGEON_INTERFACE = 25957;

	public final static int ZOMBIE_READY_INTERFACE = 20240;

	public final static int ZOMBIE_INTERFACE = 20230;

	public final static int CITY_PKING_SAFE_ZONE_INTERFACE = 26005;

	public final static int CITY_PKING_DANGEROUS_ZONE_INTERFACE = 26000;

	public final static int BARROWS_INTERFACE = 22045;

	public final static int DUEL_ARENA_INTERFACE = 201;

	public final static int YELL_MODE_ON = 0;

	public final static int YELL_MODE_FRIENDS = 1;

	public final static int YELL_MODE_OFF = 2;

	public final static int CHAT_TYPE_GAME_MESSAGE = 0;

	public final static int CHAT_TYPE_OTHER_PLAYERS = 1;

	public final static int CHAT_TYPE_MY_PLAYER = 2;

	public final static int CHAT_TYPE_PRIVATE_MESSAGE_RECEIVED_NORMAL = 3;

	public final static int CHAT_TYPE_TRADE = 4;

	public final static int CHAT_TYPE_PRIVATE_MESSAGE_LOGGED_IN_OR_OUT = 5;

	public final static int CHAT_TYPE_PRIVATE_MESSAGE_SENT = 6;

	public final static int CHAT_TYPE_PRIVATE_MESSAGE_RECEIVED_MOD = 7;

	public final static int CHAT_TYPE_DUEL = 8;

	public final static int CHAT_TYPE_YELL = 9;

	public final static int CHAT_TYPE_AUTOCHAT = 10;

	public final static int CHAT_TYPE_CLAN = 16;

	public final static int PUBLIC_ON = 0;

	public final static int PUBLIC_FRIENDS = 1;

	public final static int PUBLIC_OFF = 2;

	public final static int PUBLIC_HIDE = 3;

	public final static int PUBLIC_AUTOCHAT = 4;

	public final static int YELLOW = 0xffff01;

	public final static int BLUE = 0x005aff;

	public final static int GOLD = 0xffc600;

	public final static int SKILL_TAB_YELLOW = 0xf2eb5e;

	public final static int WHITE = 0xffffff;

	public final static int ORANGE = 0xff981f;

	public final static int BLACK = 0x000000;

	public final static int PALE_ORANGE = 0xc8aa64;

	public final static int RED = 0xfe3200;

	public final static int BURGUNDY = 0x800000;

	public final static int DARK_BLUE = 0x000080;

	public final static int GREEN = 0x09FF00;

	public final static int PALE_GREEN = 0x46b556;

	public final static String WEBSITE_DATA_LOCATION = "http://www.Runecessor.net/game/data.txt";

	public final static String WEBSITE_DATA_LOCATION_DROPBOX_VERSION = "http://www.dropbox.com/s/69hrr0pgwdl2si6/data.txt?dl=1";

	public static boolean isModeratorOrAbove(int rights) {
		if (rights == 1 || rights == 2 || rights == 31 || rights == 33) {
			return true;
		}
		return false;
	}

	public static String getLocalBackgroundImageLocation() {
		if (Config.PRE_EOC) {
			return "/image/background_pre_eoc.png";
		}
		return Config.ECO ?
				"/image/background_rf.png" : "/image/background.jpg";
	}

	public static String getLocalIconImageLocation() {
		return Config.ECO ? "/image/rf_icon.png" : "/image/rf_icon.png";
	}
	

	/**
	 * v17
	 */
	public static String getSpritesCacheVersion() {
		return ClientLiveConfiguration.LIVE_GAME ? ClientLiveConfiguration.SPRITES_CACHE_VERSION : "v17";
	}

	/**
	 * @return
	 * 	The server name.
	 */
	public static String getServerName() {
		return Config.serverNames[Config.currentServer];
	}
	public static String getcachenamelink() {
		return Config.CacheName[Config.currentServer];
	}

	/**
	 * Runecessor
	 */
	public static String getCacheName() {
		return Config.CacheName[Config.currentServer];
	}

	/**
	 * Runecessor/
	 */
	public static String getRunecessorFolderLocation() {
		return ClientDebugConfiguration.LOCAL_CACHE ? ClientConstants.getCacheName() + "/" : System.getProperty("user.home") + "/" + ClientConstants.getCacheName() + "/";
	}

	/**
	 * Runecessor/v8/
	 */
	public static String getMainCacheLocation() {
		return getRunecessorFolderLocation() + ClientConstants.getMainCacheVersion() + "/";
	}


	/**
	 * This is mainly the sprites directory.
	 * Runecessor/v8/cache_31/
	 */
	public static String getCacheLocation() {
		return getMainCacheLocation() + "cache_" + ClientConstants.getSpritesCacheVersion() + "/";
	}

	/**
	 * v8
	 */
	public static String getMainCacheVersion() {
		if (!ClientLiveConfiguration.LIVE_GAME) {
			return "v8";
		}
		return ClientLiveConfiguration.MAIN_CACHE_VERSION;
	}

	/**
	 * Runecessor/v8/cache_31/sprites/
	 */
	public static String getSpritesLocation() {
		return getCacheLocation() + "sprites/";
	}

	public static String getScreenShotLocation() {
		return getRunecessorFolderLocation() + "settings/screenshot.txt";
	}

	/**
	 * Runecessor/v8/474_cache
	 */
	public static String getCacheRevisionLocation() {
		if (ClientDebugConfiguration.TEST_474_CACHE) {
			return getMainCacheLocation() + "474_cache_test";
		}
		String revision = Config.PRE_EOC ? "718" : "474";

		return getMainCacheLocation() + revision + "_cache";
	}

	public final static int FIRST_LOG_IN_BOX_MOUSE_X_BEGIN = 289;

	public final static int FIRST_LOG_IN_BOX_MOUSE_X_END = 475;

	public final static int FIRST_LOG_IN_BOX_MOUSE_Y_BEGIN = 160;

	public final static int FIRST_LOG_IN_BOX_MOUSE_Y_END = 185;

	public final static int STANDARD_DETAIL_MOUSE_X_BEGIN = 293;

	public final static int STANDARD_DETAIL_MOUSE_X_END = 373;

	public final static int STANDARD_DETAIL_MOUSE_Y_BEGIN = 280;

	public final static int STANDARD_DETAIL_MOUSE_Y_END = 326;

	public final static int HIGH_DETAIL_MOUSE_X_BEGIN = 402;

	public final static int HIGH_DETAIL_MOUSE_X_END = 457;

	public final static int HIGH_DETAIL_MOUSE_Y_BEGIN = 280;

	public final static int HIGH_DETAIL_MOUSE_Y_END = 326;


	public final static int USERNAME_BOX_MOUSE_X_BEGIN = 278;

	public final static int USERNAME_BOX_MOUSE_X_END = 493;

	public final static int USERNAME_BOX_MOUSE_Y_BEGIN = 207;

	public final static int USERNAME_BOX_MOUSE_Y_END = 235;

	public final static int PASSWORD_BOX_MOUSE_X_BEGIN = 278;

	public final static int PASSWORD_BOX_MOUSE_X_END = 493;

	public final static int PASSWORD_BOX_MOUSE_Y_BEGIN = 261;

	public final static int PASSWORD_BOX_MOUSE_Y_END = 288;

	public final static int LOG_IN_BOX_MOUSE_X_BEGIN = 296;

	public final static int LOG_IN_BOX_MOUSE_X_END = 473;

	public final static int LOG_IN_BOX_MOUSE_Y_BEGIN = 310;

	public final static int LOG_IN_BOX_MOUSE_Y_END = 338;

	public final static int[] anIntArray1177 =
			// Cannot find refactor.
			{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};

	public final static int[] IDs =
	{
		1196,
		1199,
		1206,
		1215,
		1224,
		1231,
		1240,
		1249,
		1258,
		1267,
		1274,
		1283,
		1573,
		1290,
		1299,
		1308,
		1315,
		1324,
		1333,
		1340,
		1349,
		1358,
		1367,
		1374,
		1381,
		1388,
		1397,
		1404,
		1583,
		12038,
		1414,
		1421,
		1430,
		1437,
		1446,
		1453,
		1460,
		1469,
		15878,
		1602,
		1613,
		1624,
		7456,
		1478,
		1485,
		1494,
		1503,
		1512,
		1521,
		1530,
		1544,
		1553,
		1563,
		1593,
		1635,
		12426,
		12436,
		12446,
		12456,
		6004,
		18471, /* Ancients */
		12940,
		12988,
		13036,
		12902,
		12862,
		13046,
		12964,
		13012,
		13054,
		12920,
		12882,
		13062,
		12952,
		13000,
		13070,
		12912,
		12872,
		13080,
		12976,
		13024,
		13088,
		12930,
		12892,
		13096};

	public final static int[] runeChildren =
	{
		1202,
		1203,
		1209,
		1210,
		1211,
		1218,
		1219,
		1220,
		1227,
		1228,
		1234,
		1235,
		1236,
		1243,
		1244,
		1245,
		1252,
		1253,
		1254,
		1261,
		1262,
		1263,
		1270,
		1271,
		1277,
		1278,
		1279,
		1286,
		1287,
		1293,
		1294,
		1295,
		1302,
		1303,
		1304,
		1311,
		1312,
		1318,
		1319,
		1320,
		1327,
		1328,
		1329,
		1336,
		1337,
		1343,
		1344,
		1345,
		1352,
		1353,
		1354,
		1361,
		1362,
		1363,
		1370,
		1371,
		1377,
		1378,
		1384,
		1385,
		1391,
		1392,
		1393,
		1400,
		1401,
		1407,
		1408,
		1410,
		1417,
		1418,
		1424,
		1425,
		1426,
		1433,
		1434,
		1440,
		1441,
		1442,
		1449,
		1450,
		1456,
		1457,
		1463,
		1464,
		1465,
		1472,
		1473,
		1474,
		1481,
		1482,
		1488,
		1489,
		1490,
		1497,
		1498,
		1499,
		1506,
		1507,
		1508,
		1515,
		1516,
		1517,
		1524,
		1525,
		1526,
		1533,
		1534,
		1535,
		1547,
		1548,
		1549,
		1556,
		1557,
		1558,
		1566,
		1567,
		1568,
		1576,
		1577,
		1578,
		1586,
		1587,
		1588,
		1596,
		1597,
		1598,
		1605,
		1606,
		1607,
		1616,
		1617,
		1618,
		1627,
		1628,
		1629,
		1638,
		1639,
		1640,
		6007,
		6008,
		6011,
		8673,
		8674,
		12041,
		12042,
		12429,
		12430,
		12431,
		12439,
		12440,
		12441,
		12449,
		12450,
		12451,
		12459,
		12460,
		15881,
		15882,
		15885,
		18474,
		18475,
		18478};

	public final static int[] SPOKEN_PALETTE =
	{0xffff00, 0xff0000, 65280, 65535, 0xff00ff, 0xffffff};

	/**
	 * Colour of the second colour of certain torsos, for example, the black one: http://prntscr.com/6ds7ke
	 */
	public final static int[] anIntArray1204 =
	{9104, 10275, 7595, 3610, 7975, 8526, 918, 24466, 10145, 58654, 5027, 1457, 16565, 34991, 25486, 20, 95, -15801, 38820, 38733, 38808, 38802};

	// Make-over-mage clothes outfit colour.
	public final static int[][] CLOTHES_COLOUR =
	{
		// @formatter:off
			// Hair.
			{6798, 107, 10283, 16, 4797, 7744, 5799, 4634, 33697, 22433, 2983, 54193, 1, 35003, -15701}, 
			// Torso.
			{8741, 12, 64030, 43162, 7735, 8404, 1701, 24094, 10153, 56621, 4783, 1341, 16578, 35003, 25239, 1, 107, -15701, 38802, 38750, 38820, 38430}, 
			// Legs.
			{25238, 8742, 12, 64030, 43162, 7735, 8404, 1701, 24094, 10153, 56621, 4783, 1341, 16578, 35003, 1, 107, -15701, 38802, 38750, 38820, 38430},
			// Feet.
			{4626, 11146, 6439, 12, 4758, 10270, 1, 107}, 
			// Skin. 1 is black
			{4550, 4537, 5681, 5673, 5790, 6806, 8076, 1,4574, 8128, 51136, 86933, 675, 428770, 302770}
							//@formatter:on
	};

	public final static int[] SKILL_ID_TO_SPRITE =
	{576, 580, 595, 586, 591, 590, 588, 578, 598, 584, 583, 582, 579, 594, 589, 585, 575, 597, 593, 581, 592, 577, 587};

	public final static int BRIGHTNESS_VERY_DARK = 1;

	public final static int BRIGHTNESS_DARK = 2;

	public final static int BRIGHTNESS_NORMAL = 3;

	public final static int BRIGHTNESS_BRIGHT = 4;

	public static final String LOADING_BAR_COLOUR = "8c0b01";

	public static int getQuestTabInterfaceId() {
		return Config.ECO ? 22980 : 19500;
	}

}