package Runecessor;

/**
 * Handles the combat box
 * 
 * @author 2012
 *
 */
public class CombatBox {

	/**
	 * The display time
	 */
	public static final int DISPLAY_TIME = 10;

	/**
	 * The timer
	 */
	private static SecondsTimer combatBoxTimer = new SecondsTimer();

	/**
	 * The percentage
	 */
	public static double combatBoxPercent;

	public static void stopTime() {
		combatBoxTimer.stop();
	}

	/**
	 * Starts the timer
	 */
	public static void startTime() {
		combatBoxTimer.start(DISPLAY_TIME);
	}

	/**
	 * Whether should be drawn
	 * 
	 * @return should be drawn
	 */
	private static boolean shouldDrawCombatBox() {
		if (!Client.hpOverlayOn) {
			return false;
		}
		return Client.instance.currentInteract != null && !combatBoxTimer.finished();
	}

	/**
	 * Drawing combat box
	 * 
	 * @param client the client
	 */
	public static void drawCombatBox(Client client) {
		if (!shouldDrawCombatBox()) {
			return;
		}
		int currentHp = Client.x10Damage ? client.currentInteract.currentHealth * 10 : client.currentInteract.currentHealth;
		int maxHp = Client.x10Damage ? client.currentInteract.maxHealth * 10 : client.currentInteract.maxHealth;

		// Make sure the mob isn't dead
		if (currentHp == 0) {
			return;
		}

		// Get name
		String name = null;
		if (client.currentInteract instanceof Player) {
			name = ((Player) client.currentInteract).getName();
		} else if (client.currentInteract instanceof Npc) {
			if (((Npc) client.currentInteract).desc != null) {
				name = ((Npc) client.currentInteract).desc.name;
			}
		}

		// Make sure the mob has a name
		if (name == null) {
			return;
		}

		// Positioning
		int height = 37;
		int width = 126;
		int xPos = 2;
		int yPos = 18;

		// Draw box
		DrawingArea.fillRectangle(xPos, yPos, width, height, 0x504a41, 180); //Main box
		DrawingArea.fillPixels(xPos, width, height, ClientConstants.BLACK, yPos); //Outline


		// Draw name
		if (name != null) {
			Client.instance.newRegularFont.drawCenteredString(name, xPos + (width / 2), yPos + 14,
					16777215, 0);
		}

		int percent = (int) (((double) currentHp / (double) maxHp) * (width - 9));
		if (percent > (width - 9)) {
			percent = (width - 9);
		}
		// Draw missing health
		DrawingArea.fillRectangle(xPos + 4, yPos + 17, width - 9, 16, 11740160, 150); //red

		// start + i * (end - start) / count;

		double difference = (combatBoxPercent - percent);

		// Draw existing health
		DrawingArea.fillRectangle(xPos + 4, yPos + 17, percent, 16, 0x17770e); //green

		for (double i = difference; i > 0; i -= 0.1) {
			DrawingArea.fillRectangle(xPos + 4, yPos + 17, percent, 16, 31744, 200); //green
		}
		combatBoxPercent = percent;
		Client.instance.newSmallFont.drawCenteredString(currentHp + " / " + maxHp, xPos + (width / 2),
				yPos + 30, 16777215, 0);
	}
}
