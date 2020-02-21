package Runecessor;

import java.text.NumberFormat;

/**
 * Handles the Money Pouch Orb
 * 
 * @author 2012
 *
 */
public class MoneyPouchOrb {

	/**
	 * The line for money pouch
	 */
	public static final int MONEY_POUCH_LINE = 38_333;

	/**
	 * The flashing cycles to complete
	 */
	private static final int FLASHING_CYCLES_TO_COMPLETE = 2;

	/**
	 * The flashing multiplier
	 */
	private static final int FLASHING_MULTIPLIER_SPEED = 3;

	/**
	 * The flashing orb
	 */
	private static final int MONEY_POUCH_ORB_FLASHING = 1137;

	/**
	 * The money pouch orb
	 */
	private static final int MONEY_POUCH_ORB = 1136;

	/**
	 * The money pouch adding flashing orb
	 */
	private static final int MONEY_POUCH_ADD_FLASHING_ORB = 1151;

	/**
	 * The money pouch deduction flashing orb
	 */
	private static final int MONEY_POUCH_DEDUCT_FLASHING_ORB = 1141;

	/**
	 * The money pouch bar hover
	 */
	private static final int MONEY_POUCH_BAR_HOVER = 1139;

	/**
	 * The money pouch bar
	 */
	private static final int MONEY_POUCH_BAR = 1138;

	/**
	 * Whether the money pouch is hovering
	 */
	public static boolean moneyPouchHover = false;

	/**
	 * Whether the money pouch is open
	 */
	public static boolean moneyPouchOpen = false;

	/**
	 * Whether the pouch is flashing
	 */
	private static boolean moneyPouchFlash = false;

	/**
	 * The pouch flashing rate
	 */
	private static int moneyPouchFlashRate = 0;

	/**
	 * Whether there was a deduction
	 */
	private static boolean deductedFromMoneyPouch = false;

	/**
	 * The flashing state
	 */
	private static boolean interpolating = false;

	/**
	 * The flash cycles
	 */
	private static int flashCyclesCompleted = 0;

	/**
	 * The text y
	 */
	private static int textY = 0;

	/**
	 * The coin amount
	 */
	private static int coinAmount = 0;

	/**
	 * Checking whether can draw the money pouch
	 * 
	 * @return can draw
	 */
	public static boolean canDrawMoneyPouch() {
		/*
		 * Not pre eoc
		 */
		if (!Config.PRE_EOC) {
			return false;
		}
		/*
		 * Low gameframes
		 */
		if (Client.isOSRSGameFrame || Client.is498GameFrame) {
			return false;
		}
		/*
		 * Wrong gameframes
		 */
		if (!Client.is508PlusGameFrame && !Client.is525GameFrame && !Client.is562GameFrame
				&& !Client.is562PlusGameFrame) {
			return false;
		}
		return true;
	}

	/**
	 * Drawing the money pouch orb
	 */
	public static void drawMoneyPouchOrb() {
		/*
		 * Can't draw the money pouch
		 */
		if (!canDrawMoneyPouch()) {
			return;
		}
		/*
		 * The x offset
		 */
		int xOffset = Client.isFixedScreen() ? -2
				: Client.getClientWidth() - Client.getFullscreenModeMinimapX(164);
		/*
		 * The y offset
		 */
		int yOffset = Client.isFixedScreen() ? 0 : 58;
		/*
		 * The mouse x
		 */
		int mouseX = Client.instance.mouseX - (Client.isFixedScreen() ? 0
				: (Client.getClientWidth() - Client.getFullscreenModeMinimapX(782)));
		/*
		 * The mouse y
		 */
		int mouseY = Client.instance.mouseY;
		/*
		 * Set hover
		 */
		moneyPouchHover =
				Client.inCircle(Client.isFixedScreen() ? 512 : 616, 81 + yOffset, mouseX, mouseY, 18);
		/*
		 * Display orb
		 */
		Client.cacheSprite[moneyPouchHover ? MONEY_POUCH_ORB_FLASHING : MONEY_POUCH_ORB]
				.drawSprite(xOffset, 82 + yOffset);
		/*
		 * Flashing orb
		 */
		if (moneyPouchFlash) {
			/*
			 * The sprite
			 */
			int sprite = deductedFromMoneyPouch ? MONEY_POUCH_ADD_FLASHING_ORB
					: MONEY_POUCH_DEDUCT_FLASHING_ORB;
			/*
			 * The flashing
			 */
			if (interpolating) {
				/*
				 * Decrease flashing rate
				 */
				moneyPouchFlashRate--;
				/*
				 * The flash rate
				 */
				if (moneyPouchFlashRate == 0) {
					/*
					 * The flashing rate
					 */
					interpolating = false;
					/*
					 * The cycle completed
					 */
					flashCyclesCompleted++;
					/*
					 * Final cycle
					 */
					if (flashCyclesCompleted == FLASHING_CYCLES_TO_COMPLETE) {
						moneyPouchFlash = false;
					}
				}
			} else {
				/*
				 * Increase flashing rate
				 */
				moneyPouchFlashRate++;
				/*
				 * The flash rate
				 */
				if (moneyPouchFlashRate == FLASHING_MULTIPLIER_SPEED * 9) {
					interpolating = true;
				}
			}
			/*
			 * Draw flashing sprite
			 */
			Client.cacheSprite[(int) (sprite
					+ Math.floor(moneyPouchFlashRate / FLASHING_MULTIPLIER_SPEED))]
							.drawAdvancedSprite(xOffset - 3, 79 + yOffset);
		}
	}

	/**
	 * Drawing the money pouch
	 */
	public static void drawMoneyPouch() {
		/*
		 * Can't draw the money pouch
		 */
		if (!canDrawMoneyPouch()) {
			return;
		}
		/*
		 * Outer bit
		 */
		if (Client.isFixedScreen()) {
			Client.cacheSprite[1140].drawSprite(510, 77);
			flashOuterComponent();
		}
		/*
		 * Not open
		 */
		if (!moneyPouchOpen) {
			return;
		}
		/*
		 * The offset x
		 */
		int xOffset = Client.isFixedScreen() ? 444
				: Client.getClientWidth() - Client.getFullscreenModeMinimapX(230);
		/*
		 * The offset y
		 */
		int yOffset = Client.isFixedScreen() ? 83 : 145;
		/*
		 * The open bit
		 */
		Client.cacheSprite[moneyPouchHover ? MONEY_POUCH_BAR_HOVER : MONEY_POUCH_BAR]
				.drawSprite(xOffset, yOffset);
		/*
		 * The coins
		 */
		int coins = getMoneyPouchCoins();
		/*
		 * The width
		 */
		int width = Client.instance.smallText.getTextWidth(formatMoneyPouch(coins));
		/*
		 * The x
		 */
		int x = Client.isFixedScreen() ? (513 - width)
				: Client.getClientWidth() - Client.getFullscreenModeMinimapX(190);
		/*
		 * Fixes the x
		 */
		if (Client.isFixedScreen() && x > 495) {
			x = 495;
		}
		/*
		 * Display text
		 */
		Client.instance.smallText.method382(getMoneyPouchColour(coins), x, formatMoneyPouch(coins),
				Client.isFixedScreen() ? 99 : 161, true);
		/*
		 * The text
		 */
		if (moneyPouchFlash) {
			/*
			 * Deduction moving text
			 */
			if (deductedFromMoneyPouch) {
				textY++;
			} else {
				textY--;
			}
			/*
			 * Fixing y
			 */
			if (textY < 0) {
				textY = 0;
			}
			if (textY > 15) {
				textY = 15;
			}
			/*
			 * The text
			 */
			Client.instance.smallText.method382(deductedFromMoneyPouch ? 0xFF0000 : 0x008000, x - 5,
					(deductedFromMoneyPouch ? "-" : "+") + formatMoneyPouch(coinAmount),
					(Client.isFixedScreen() ? 120 : 181) + textY, true);
			flashOuterComponent();
		}
	}

	/**
	 * Examining the money pouch
	 */
	public static void sendExamineMoneyPouch() {
		/*
		 * Non pre eoc
		 */
		if (Config.PRE_EOC) {
			return;
		}
		/*
		 * The coins
		 */
		int coins = getMoneyPouchCoins();
		/*
		 * The message
		 */
		Client.instance.pushMessage(
				"You currently have " + formatMoneyPouch(coins) + " ("
						+ NumberFormat.getInstance().format(coins) + ") coins in your Money Pouch",
				ClientConstants.CHAT_TYPE_GAME_MESSAGE, "", "");
	}

	/**
	 * Flashing the outer component
	 */
	private static void flashOuterComponent() {
		/*
		 * Outer bit
		 */
		if (Client.isFixedScreen() && moneyPouchFlash) {
			/*
			 * The sprite
			 */
			int sprite = deductedFromMoneyPouch ? MONEY_POUCH_ADD_FLASHING_ORB
					: MONEY_POUCH_DEDUCT_FLASHING_ORB;
			/*
			 * The drawing
			 */
			Client.cacheSprite[(int) (sprite
					+ Math.floor(moneyPouchFlashRate / FLASHING_MULTIPLIER_SPEED))]
							.drawAdvancedSprite(508, 74);
		}
	}

	/**
	 * Gets the coins
	 * 
	 * @return the coins
	 */
	public static int getMoneyPouchCoins() {
		/*
		 * The coins
		 */
		int coins = 0;
		/*
		 * Gets the coins
		 */
		try {
			coins = Integer.parseInt(RSInterface.interfaceCache[MONEY_POUCH_LINE].message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return coins;
	}

	/**
	 * Sending deduction
	 */
	public static void sendDeduction(int amount) {
		moneyPouchFlash = true;
		moneyPouchFlashRate = 0;
		deductedFromMoneyPouch = true;
		interpolating = false;
		flashCyclesCompleted = 0;
		textY = 0;
		coinAmount = amount;
	}

	/**
	 * Sending addition
	 */
	public static void sendAddition(int amount) {
		moneyPouchFlash = true;
		moneyPouchFlashRate = 0;
		deductedFromMoneyPouch = false;
		interpolating = false;
		flashCyclesCompleted = 0;
		textY = 15;
		coinAmount = amount;
	}

	/**
	 * Gets the colour by coins
	 * 
	 * @param coins the coins
	 * @return the colour
	 */
	private static int getMoneyPouchColour(int coins) {
		if (coins >= 10_000_000) {
			return 0x00FF80;
		}
		if (coins >= 100_000) {
			return 0xFFFFFF;
		}
		if (coins >= 100_000) {
			return 0xFFFFFF;
		}
		return 0xFFFF00;
	}

	/**
	 * Formats the money pouch
	 * 
	 * @param coins the coins
	 * @return formated
	 */
	private static String formatMoneyPouch(int coins) {
		if (coins >= 10_000 && coins < 10_000_000) {
			return NumberFormat.getInstance().format(coins / 1000) + "K";
		}
		if (coins >= 10_000_000) {
			return NumberFormat.getInstance().format(coins / 1_000_000) + "M";
		}
		return NumberFormat.getInstance().format(coins) + " GP";
	}
}
