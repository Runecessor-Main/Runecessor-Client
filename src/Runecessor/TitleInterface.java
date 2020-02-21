package Runecessor;

/**
 * Title loading bar drawing.
 * @author Lava, created on 29-08-2016.
 */
public class TitleInterface {

	public static void drawTitleInterfaceLoadingBar() {

		if (Client.getInterfaceDisplayed() != 19360) {
			return;
		}

		//TODO #FULLSCREEN ADJUST interface, title interface progress bar
		int x = Client.isFixedScreen() ? 0 : (Client.getClientWidth() / 2) - 256;
		int y = Client.isFixedScreen() ? 0 : (Client.getClientHeight() / 2) - 267;
		Client.cacheSprite[603].drawSprite(265 + x, 224 + y); // Red progress bar.
		for (int index = Client.titleInterfacePercentage; index > 0; index -= 7) {
			Client.cacheSprite[394].drawSprite(248 + ((int) (index * 1.5)) + x, 224 + y); // Green progress
		}
	}

}
