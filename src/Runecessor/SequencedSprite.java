package Runecessor;

/**
 * Handles drawing a sequence of sprites
 * 
 * @author 2012
 *
 */
public class SequencedSprite {

	private boolean active;
	private boolean decreasing;

	private int sprite;

	private int speed;
	private int rate;
	private int multiplier;

	private int cyclesCompleted;
	private int cyclesToComplete;

	private int x;
	private int y;

	public void prepare() {
		reset();
		cyclesCompleted = 0;
	}

	public void drawCycleSequence() {
		if (active) {
			if (rate == multiplier) {
				rate = 0;
			}
			Client.cacheSprite[(int) (sprite)].drawAdvancedSprite(x, y);
			rate++;
		}
	}

	public void drawAlternatingSequence() {
		if (active) {
			if (decreasing) {
				rate--;
				if (rate == 0) {
					decreasing = false;
					cyclesCompleted++;
					if (cyclesCompleted == cyclesToComplete) {
						reset();
					}
				}
			} else {
				rate++;
				if (rate == speed * multiplier) {
					decreasing = true;
				}
			}
			Client.cacheSprite[(int) (sprite + Math.floor(rate / speed))].drawAdvancedSprite(x, y);
		}
	}

	public void reset() {
		active = false;
		rate = 0;
		decreasing = false;
	}
}