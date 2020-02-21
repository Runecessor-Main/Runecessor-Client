package Runecessor;

/**
 * Achievements.
 * @author Lava, created on 10-03-2015.
 */
public class Achievements {

	/**
	 * Achievement interface.
	 * @param over
	 * 			True, to draw over the achievement interface.
	 */
	public static void achievementInterface() {

		if (Client.getInterfaceDisplayed() != 22260) {
			return;
		}
		//TODO #FULLSCREEN ADJUST interface, achievement interface progress bar
		int x = Client.isFixedScreen() ? 0 : (Client.getClientWidth() / 2) - 256;
		int y = Client.isFixedScreen() ? 0 : (Client.getClientHeight() / 2) - 267;
		Client.cacheSprite[395].drawSprite(205 + x, 271 + y); // Red progress bar.
		if (Client.achievementPercentage > 0 && Client.achievementPercentage <= 4) {
			achievementProgress(197);
		}
		if (Client.achievementPercentage >= 5) {
			achievementProgress(206);
		}
		if (Client.achievementPercentage >= 10) {
			achievementProgress(220);
		}
		if (Client.achievementPercentage >= 15) {
			achievementProgress(234);
		}
		if (Client.achievementPercentage >= 20) {
			achievementProgress(248);
		}
		if (Client.achievementPercentage >= 25) {
			achievementProgress(262);
		}
		if (Client.achievementPercentage >= 30) {
			achievementProgress(276);
		}
		if (Client.achievementPercentage >= 35) {
			achievementProgress(290);
		}
		if (Client.achievementPercentage >= 40) {
			achievementProgress(304);
		}
		if (Client.achievementPercentage >= 45) {
			achievementProgress(318);
		}
		if (Client.achievementPercentage >= 50) {
			achievementProgress(332);
		}
		if (Client.achievementPercentage >= 55) {
			achievementProgress(346);
		}
		if (Client.achievementPercentage >= 60) {
			achievementProgress(360);
		}
		if (Client.achievementPercentage >= 65) {
			achievementProgress(374);
		}
		if (Client.achievementPercentage >= 70) {
			achievementProgress(388);
		}
		if (Client.achievementPercentage >= 75) {
			achievementProgress(402);
		}
		if (Client.achievementPercentage >= 80) {
			achievementProgress(416);
		}
		if (Client.achievementPercentage >= 85) {
			achievementProgress(430);
		}
		if (Client.achievementPercentage >= 90) {
			achievementProgress(444);
		}
		if (Client.achievementPercentage >= 95) {
			achievementProgress(458);
		}
		if (Client.achievementPercentage >= 100) {
			achievementProgress(472);
			achievementProgress(475); // Needed to fill up the last edge.
		}
	}

	/**
	 * Apply the green progress onto the screen.
	 * @param x
	 * 			X-coordinate of the image.
	 */
	private static void achievementProgress(int x) {
		//TODO #FULLSCREEN ADJUST interface, achievement interface progress bar
		x += Client.isFixedScreen() ? 0 : (Client.getClientWidth() / 2) - 256;
		int y = Client.isFixedScreen() ? 0 : (Client.getClientHeight() / 2) - 267;
		Client.cacheSprite[394].drawSprite(x, 271 + y);
	}

	public static boolean clickAchievementPopUp(boolean mouseClick) {

		if (!Client.achievementPopUp) {
			return false;
		}
		if (Client.instance.getClickMode3() != 1 && mouseClick) {
			return false;
		}
		int x1 = Client.isFixedScreen() ? 0 : (Client.getClientWidth() / 2) - 256;
		int y1 = Client.isFixedScreen() ? 0 : -5;
		if (Client.instance.mouseX >= 158 + x1 && Client.instance.mouseX <= 383 + x1 && Client.instance.mouseY >= 9 + y1 && Client.instance.mouseY <= 72 + y1) {
			if (mouseClick) {
				Client.achievementPopUp = false;
			}
			return true;
		}
		return false;
	}

	public static void drawAchievementPopUp() {
		if (!Client.achievementPopUp) {
			return;
		}
		if (System.currentTimeMillis() - Client.achievementPopUpTime > 5000) {
			Client.achievementPopUp = false;
			return;
		}

		//TODO #FULLSCREEN ADJUST interface, achievement interface pop up
		int x = Client.isFixedScreen() ? 0 : (Client.getClientWidth() / 2) - 256;
		int y = 0;
		Client.cacheSprite[399].drawSprite(155 + x, 5 + y);
		Client.instance.newRegularFont.drawBasicString1(Client.achievementTitlePopup, 267 + x, 20 + y, true, 0xffff00, true);
		Client.instance.newRegularFont.drawBasicString1(Client.achievementDifficultyPopUp, 267 + x, 41 + y, false, 0xffff00, true);
		Client.instance.newRegularFont.drawBasicString1(Client.achievementTaskPopUp, 267 + x, 60 + y, false, 0xffff00, true);

	}

}