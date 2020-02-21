package Runecessor;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ItemPrice {

	private static final ItemPrice[] DEFINITIONS = new ItemPrice[25000];

	public final int itemId;

	public final int itemPrice;

	public final int bloodMoneyPrice;


	public ItemPrice(int itemId, int itemPrice, int bloodMoneyPrice) {
		this.itemId = itemId;
		this.itemPrice = itemPrice;
		this.bloodMoneyPrice = bloodMoneyPrice;
	}

	private static ItemPrice[] getDefinitions() {
		return DEFINITIONS;
	}

	public static long getNormalValue(int itemId, long amount) {
		ItemPrice item = getDefinitions()[itemId];
		if (item == null) {
			return 0;
		}
		long price = Config.PVP ? item.bloodMoneyPrice : item.itemPrice;
		return price * amount;
	}

	/**
	 * If on Pvp, add +x blood money to the value.
	 * Always put bones at value 0.
	 */
	public static long getValueDropsOnly(int itemId, long amount) {
		ItemPrice itemPrice = ItemPrice.getDefinitions()[itemId];

		if (itemPrice == null) {
			return 1;
		}
		long value = itemPrice.itemPrice;

		long bloodMoneyPrice = itemPrice.bloodMoneyPrice;
		ItemDefinition itemDef = ItemDefinition.forId(itemId);

		if (itemDef == null) {
			return 1;
		}
		if (bloodMoneyPrice > 0 && Config.PVP) {
			value = 0;
			value += (long) Integer.MAX_VALUE;
			value += bloodMoneyPrice;
		}
		if (itemDef.stackable) {
			if (value > Integer.MAX_VALUE) {
				long price = value - Integer.MAX_VALUE;
				value = Integer.MAX_VALUE + (price * (amount + 1));
			}
			else {
				// Prevent 200 million arrows being ontop of pile.
				value *= (amount + 1);
				if (value > Integer.MAX_VALUE) {
					value = Integer.MAX_VALUE;
				}
			}
		}

		// Bones.
		if (itemId == 536 || itemId == 526 || itemId == 530 || itemId == 532 || itemId == 534 || itemId == 2859 || itemId == 6729) {
			value = 0;
		}
		return value;
	}

	public static void loadItemPrices() {
		try (Scanner s = new Scanner(new File(ClientConstants.getCacheLocation() + "prices.txt"))) {
			while (s.hasNextLine()) {
				String[] line = s.nextLine().split(" ");
	
				if (line.length < 3) {
					throw new IllegalStateException(String.format("line; %s", Arrays.toString(line)));
				}
				int itemId = Integer.parseInt(line[0]);
	
				int value = Integer.parseInt(line[1]);
	
				int bloodMoneyPrice = Integer.parseInt(line[2]);
	
				DEFINITIONS[itemId] = new ItemPrice(itemId, value, bloodMoneyPrice);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
