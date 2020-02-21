package Runecessor;
/**
 * Main client configurations. Ignored by gitignore
 * @author Lava Created on: 11-11-2013
 */
public class ClientDebugConfiguration
{

    public static final boolean TEST_474_CACHE = false;
    /**
	 * True, to load the sprites from an external folder instead of cache packed.
	 */
	public static boolean DEBUG_SPRITES = false;

	/**
	 * True, to use cache beside the client.
	 * <p>
	 * False, to use the cache in the user folder, for the live server.
	 */
	public static boolean LOCAL_CACHE = false;

	/**
	 * True for the noclip command to work.
	 */
	public static boolean NO_CLIP_COMMAND = true;

	/**
	 * True, to use CacheDownloader class.
	 */
	public static boolean DOWNLOAD_LATEST_CACHE = false;

	/**
	 * True, to log-in as Lava automatically.
	 */
	public static boolean FORCE_LOG_IN = false;

	/**
	 * True, to show in-depth debugging information.
	 */
	public static boolean DEBUG_MODE = false;

	/**
	 * True, to debug interface IDs used. 21030-22000 is highscores. 22260-22450 is achievements. (with extra space counted for expansion)
	 */
	public static boolean DEBUG_INTERFACES = false;

	/**
	 * Force open an interface on log-in. 0 for none.
	 */
	public static int FORCE_OPEN_INTERFACE = 0;

	/**
	 * True to dump sprites.
	 */
	public static boolean DUMP_SPRITES = false;

	/**
	 * The interface id definitions to print out. 0 to disable.
	 */
	public static int INTERFACE_DEFINITION_TO_DEBUG = 0;

	public static boolean PRINT_ALL_EXCEPTION = false;

	public static boolean RELOAD_INTERFACE_DISABLED = false;
}
