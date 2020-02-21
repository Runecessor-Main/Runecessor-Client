package Runecessor;

import java.util.concurrent.TimeUnit;

public class BlackFadingScreen extends FadingScreen {
	
	private int width, height;

	private int elongation;
	
	public BlackFadingScreen(RSFont font, String text, byte state, byte seconds, int elongation, int x, int y, int width, int height, int characterWrap) {
		super(font, text, state, seconds, x, y, characterWrap);
		this.width = width;
		this.height = height;
		this.elongation = elongation;
	}

	public void draw() {
		if (state == 0) {
			return;
		}
		long end = watch + TimeUnit.SECONDS.toMillis(seconds);

		long increment = ((end - watch) / 100);

		if (increment > 0) {
			long percentile = (System.currentTimeMillis() - watch) / increment;

			int opacity = (int) ((percentile * (Byte.MAX_VALUE / 100)) * 2);

			if (state < 0) {
				opacity = 255 - opacity;
			}
			if (percentile > -1 && percentile <= 100) {
				DrawingArea.setDrawingArea(y + height, x, x + width, y);
				DrawingArea474.drawAlphaFilledPixels(x, y, width, height, 0x000000, opacity);
				if (percentile > 0 && state == 1 || percentile < 100 && state == -1) {
					int textYOffset = 0;
					for (String sentence : wrapped) {
						font.drawCenteredString(sentence, x + width / 2, (y + height / 4) + textYOffset, 0xFFFFFF, 0x000000);
						textYOffset += 20;
					}
				} else if (percentile >= 100) {
					stop();
				}
			} else {
				if (percentile >= 100 && elongation > 0 && System.currentTimeMillis() - watch < TimeUnit.SECONDS.toMillis(seconds + elongation)) {
					DrawingArea.setDrawingArea(y + height, x, x + width, y);
					DrawingArea474.drawAlphaFilledPixels(x, y, width, height, 0x000000, 245);
					return;
				}
				stop();
			}
		}
	}

}
