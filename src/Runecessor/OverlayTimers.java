package Runecessor;

import java.util.ArrayList;
import java.util.List;

/**
 * List of active timers stored in an object instance.
 * @author Lava, created on 09-09-2017.
 */
public class OverlayTimers {

	/**
	 * List of overlays.
	 */
	public static List<OverlayTimers> overlayTimers = new ArrayList<OverlayTimers>();

	/**
	 * Sprite id to display.
	 */
	private int spriteId;

	/**
	 * The time the timer was started.
	 */
	private long timeStarted;

	/**
	 * The time to end the timer.
	 */
	private long timeToEnd;

	public OverlayTimers(int spriteId, long timeStarted, long timeToEnd) {
		this.spriteId = spriteId;
		this.timeStarted = timeStarted;
		this.timeToEnd = timeToEnd;
	}

	/**
	 * Remove a specific timer that is using the requested sprite id.
	 */
	public static void remove(int spriteIdToRemove) {
		for (int index = 0; index < overlayTimers.size(); index++) {
			OverlayTimers data = overlayTimers.get(index);
			if (data.spriteId == spriteIdToRemove) {
				overlayTimers.remove(index);
				break;
			}
		}
	}

	/**
	 * Remove all timers.
	 */
	public static void clearAllTimers() {
		overlayTimers.clear();
	}



	/**
	 * Draw the vengeance, freeze timers etc..
	 */
	public static void drawOverlayTimers() {
		if (!Client.overlayTimers) {
			return;
		}
		int xOffset = 0; // Increases depending on amount of timers displayed.
		for (int index = 0; index < overlayTimers.size(); index++) {
			OverlayTimers data = overlayTimers.get(index);

			long currentTime = System.currentTimeMillis();
			if (currentTime > data.timeToEnd) {
				remove(data.spriteId);
				continue;
			}
			int duration = (int) ((data.timeToEnd - data.timeStarted) / 1000);
			if (duration == 0) {
				remove(data.spriteId);
				continue;
			}
			int seconds = (int) (duration - ((currentTime - data.timeStarted) / 1000));
			int x = Client.isFixedScreen() ? 463 : Client.getClientWidth() - Client.getFullscreenModeMinimapX(300);
			int y = Client.isFixedScreen() ? 303 : Client.getClientHeight() - Client.getFullscreenModeChatAreaY(225);
			Client.cacheSprite[944].drawSprite3(x + xOffset + 10, y - 15, 100);//Semi transparent background sprite
			Client.cacheSprite[data.spriteId].drawSprite(x + xOffset + 22, y - 10);
			Client.instance.newSmallFont.drawBasicString1(Utility.getTimeLeft(seconds), x + 29 + xOffset, y + 26, true, ClientConstants.WHITE, true);
			xOffset -= 39;
		}
	}

	/**
	 * Add a new overlay.
	 */
	public static void addNewOverlay(int spriteId, int secondsDuration) {
		for (int index = 0; index < overlayTimers.size(); index++) {
			OverlayTimers data = overlayTimers.get(index);
			if (data.spriteId == spriteId) {
				data.timeStarted = System.currentTimeMillis();
				data.timeToEnd = System.currentTimeMillis() + (secondsDuration * 1000);
				return;
			}
		}
		OverlayTimers.overlayTimers.add(new OverlayTimers(spriteId, System.currentTimeMillis(), System.currentTimeMillis() + (secondsDuration * 1000)));
	}
}