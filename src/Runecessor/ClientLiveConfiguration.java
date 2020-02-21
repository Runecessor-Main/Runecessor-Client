package Runecessor;

/**
 * Settings not ignored by GitHub which is important for players.
 * @author Lava, created on 14-07-2017
 */
public class ClientLiveConfiguration {

	/**
	 * True if live game for player, this will force set all settings for player mode.
	 */
	public static boolean LIVE_GAME = true;

	/**
	 * Used to know this client's version.
	 */
	public final static int CLIENT_VERSION = 342;

	/**
	 * Used to locate the version folder of the sprites location.
	 */
	public final static String SPRITES_CACHE_VERSION = "v32";

	/**
	 * The cache folder name. This will be the folder name inside the Runecessor folder.
	 */
	public final static String MAIN_CACHE_VERSION = "v11";

	/**
	 * main_file_cache.dat size
	 */
	public final static int MAIN_CACHE_SIZE = 63029998;

	/**
	 * sprites.dat size
	 */
	public static final long SPRITES_SIZE = 3299185;
}
