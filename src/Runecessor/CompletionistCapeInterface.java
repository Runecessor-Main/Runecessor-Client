package Runecessor;

/**
 * Completionist cape interface.
 * @author Lava, created on 10-02-2016.
 */
public class CompletionistCapeInterface {

	public static void drawMainClicked() {
		if (Client.getInterfaceDisplayed() != 22060) {
			return;
		}
		int x = Client.isFixedScreen() ? 0 : (Client.getClientWidth() / 2) - 256;
		int y = Client.isFixedScreen() ? 0 : (Client.getClientHeight() / 2) - 267;
		switch (Client.completionistCapePartEdited) {
			case "TOP":
				Client.cacheSprite[523].drawSprite(94 + x, 51 + y);
				break;
			case "TOP DETAIL":
				Client.cacheSprite[523].drawSprite(173 + x, 51 + y);
				break;
			case "BOTTOM":
				Client.cacheSprite[523].drawSprite(94 + x, 126 + y);
				break;
			case "BOTTOM DETAIL":
				Client.cacheSprite[523].drawSprite(173 + x, 126 + y);
				break;
		}
	}

	private static void applyTopColour(String position, int spriteId) {
		if (Client.getInterfaceDisplayed() != 22060) {
			return;
		}
		int x = Client.isFixedScreen() ? 0 : (Client.getClientWidth() / 2) - 256;
		int y = Client.isFixedScreen() ? 0 : (Client.getClientHeight() / 2) - 267;
		Client.cacheSprite[spriteId].drawSprite(position.contains("DETAIL") ? 174 + x : 95 + x, position.contains("BOTTOM") ? 127 + y : 52 + y);
	}

	// Enum, name, main sprite id, small sprite id
	public static enum ColoursData {
		RED_1(545, 549),
		RED_2(546, 550),
		RED_3(547, 551),
		RED_4(548, 552),
		BLUE(519, 527),
		LIGHT_BLUE(553, 559),
		RED(520, 528),
		BLACK(529, 538),
		WHITE(530, 537),
		ORANGE(532, 544),
		YELLOW(531, 543),
		PURPLE(533, 542),
		PINK(554, 560),
		DARK_GREEN(557, 563),
		GREEN(556, 562),
		LIGHT_GREEN(558, 564);

		private int mainSpriteId;

		private int buttonSpriteId;

		private ColoursData(int mainSpriteId, int buttonSpriteId) {
			this.mainSpriteId = mainSpriteId;
			this.buttonSpriteId = buttonSpriteId;
		}

		public int getMainSpriteId() {
			return mainSpriteId;
		}

		public int getButtonSpriteId() {
			return buttonSpriteId;
		}

	}

	public static void drawMainColours() {
		if (Client.getInterfaceDisplayed() != 22060) {
			return;
		}
		for (ColoursData data : ColoursData.values()) {
			if (data.name().equals(Client.completionistCapeTopColour)) {
				applyTopColour("TOP", data.getMainSpriteId());
			}
		}
		for (ColoursData data : ColoursData.values()) {
			if (data.name().equals(Client.completionistCapeTopDetailColour)) {
				applyTopColour("TOP DETAIL", data.getMainSpriteId());
			}
		}
		for (ColoursData data : ColoursData.values()) {
			if (data.name().equals(Client.completionistCapeBottomColour)) {
				applyTopColour("BOTTOM", data.getMainSpriteId());
			}
		}
		for (ColoursData data : ColoursData.values()) {
			if (data.name().equals(Client.completionistCapeBottomDetailColour)) {
				applyTopColour("BOTTOM DETAIL", data.getMainSpriteId());
			}
		}
	}

	public static void drawSubColours() {
		if (Client.getInterfaceDisplayed() != 22060) {
			return;
		}
		int x1 = Client.isFixedScreen() ? 0 : (Client.getClientWidth() / 2) - 256;
		int y1 = Client.isFixedScreen() ? 0 : (Client.getClientHeight() / 2) - 267;
		// this one is symmetrical
		int y = 233;
		int xOriginal = 81;
		int x = 81;
		for (ColoursData data : ColoursData.values()) {
			Client.cacheSprite[data.getButtonSpriteId()].drawSprite(x + x1, y + y1);
			x += 25;
			if (data.ordinal() == 6 || data.ordinal() == 13) {
				y += 23;
				x = xOriginal;
			}
		}
	}

	public static void drawSubClicked() {
		if (Client.getInterfaceDisplayed() != 22060) {
			return;
		}
		int x1 = Client.isFixedScreen() ? 0 : (Client.getClientWidth() / 2) - 256;
		int y1 = Client.isFixedScreen() ? 0 : (Client.getClientHeight() / 2) - 267;
		int x = 80;
		int xOriginal = 80;
		int y = 233;
		for (ColoursData data : ColoursData.values()) {
			if (data.name().equals(Client.completionistCapeColourClicked)) {
				Client.cacheSprite[524].drawSprite(x + x1, y + y1);
			}
			x += 25;
			if (data.ordinal() == 6 || data.ordinal() == 13) {
				y += 22;
				x = xOriginal;
			}
		}

	}

}
