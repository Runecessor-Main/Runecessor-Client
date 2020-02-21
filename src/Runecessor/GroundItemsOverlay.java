package Runecessor;

import java.util.ArrayList;
import java.util.List;

public class GroundItemsOverlay {

	private final static int DISTANCE_FROM_ITEM_VIEW = 16;

	public static void renderGroundItemNames() {
		if (!Client.groundItemOverlay) {
			return;
		}
		List<NodeList> items = new ArrayList<>();

		for (int x = 0; x < 104; x++) {
			for (int y = 0; y < 104; y++) {
				NodeList node = Client.instance.groundArray[Client.instance.plane][x][y];

				if (node != null) {
					items.add(stacked(node));
				}
			}
		}
		int offset = 12;

		for (NodeList itemList : items) {
			for (Node node = itemList.getFirst(); node != null; node = itemList.getNext()) {
				Item item = (Item) node;
				long price = ItemPrice.getNormalValue(item.itemId, item.amount);
				String colourFirst = getDropColour(price, true);
				int colour = -1;
				if (colourFirst.length() > 0) {
					colour = Integer.decode(colourFirst);
				} else {
					colour = 0xff9040;
				}
				String totalValue = Client.displayItemOverlayValue ? "[" + Utility.formatRunescapeStyle(price) + "]" : "";
				if (price == 0) {
					totalValue = "";
				}
				boolean hide = Client.hideNoValueItems && price == 0;

				if (hide) {
					continue;
				}
				int xPos = (item.getLocalX() * 4 + 2) - Client.myPlayer.x / 32;

				int yPos = (item.getLocalY() * 4 + 2) - Client.myPlayer.y / 32;

				xPos = Utility.convertToPositive(xPos);

				yPos = Utility.convertToPositive(yPos);

				if (xPos > 4 * DISTANCE_FROM_ITEM_VIEW || yPos > 4 * DISTANCE_FROM_ITEM_VIEW) {
					continue;
				}
				ItemDefinition itemDef = ItemDefinition.forId(item.itemId);

				Client.instance.calcEntityScreenPos((item.getLocalX() << 7) + 64, 64, (item.getLocalY() << 7) + 64, "");

				RSFont text = null;
				switch (Client.overlayTextSize) {
					case 0:
						offset += 12;
						text = Client.instance.newSmallFont;
						break;
					case 1:
						offset += 14;
						text = Client.instance.newRegularFont;
						break;
					case 2:
						offset += 16;
						text = Client.instance.newBoldFont;
						break;
				}
				text.drawCenteredString(itemDef.name + (item.amount > 1 ? " (x" + Utility.formatRunescapeStyle(item.amount) + ") " + totalValue + "" : " " + totalValue + ""), Client.spriteDrawX, (Client.spriteDrawY - offset) + 30, colour, 0);
			}
			offset = 12;
		}
	}

	private static NodeList stacked(NodeList list) {
		NodeList stacked = new NodeList();

		for (Node node = list.getFirst(); node != null; node = list.getNext()) {
			Item item = (Item) node;

			Item existing = null;

			for (Node stackedNode = stacked.getFirst(); stackedNode != null; stackedNode = stacked.getNext()) {
				Item stackedItem = (Item) stackedNode;

				if (stackedItem.itemId == item.itemId) {
					existing = stackedItem;
					break;
				}
			}
			if (existing == null) {
				stacked.insertTail(item.copy());
				continue;
			}
			existing.amount += item.amount;
		}

		return stacked;
	}


	/**
	 * The value of the items which changes the text colour for the ground items overlay.
	 */
	public static String getDropColour(long value, boolean use0x) {
		String colour = "ffffff";
		if (!Client.itemRarityColour) {
			return "";
		}
		else {
			if (Config.ECO ? value <= 19999 : value <= 999) {
				if (Config.PVP && value > 0) {
					colour = "fc6128"; // very low value
				} else {
					colour = "ffffff";
				}
			}
			else if (Config.PVP ? value >= 20000 && value < 100000 : value >= 1000 && value < 5000) {
				colour = "66B2FF"; // low value
			}
			else if (Config.PVP ? value >= 100000 && value < 1000000 : value >= 5000 && value < 25000) {
				colour = "99FF99"; // med value
			}
			else if (Config.PVP ? value >= 1000000 && value < 10000000 : value >= 25000 && value < 50000) {
				colour = "e0c52a"; // high value
			}
			else if (Config.PVP ? value >= 10000000 : value >= 50000) {
				colour = "FF66B2"; // 'insane' value
			}
			else {
				colour = "ffffff";
			}
		}
		if (use0x) {
			return "0x" + colour;
		}
		else {
			return "<col=" + colour + ">";
		}
	}

}
