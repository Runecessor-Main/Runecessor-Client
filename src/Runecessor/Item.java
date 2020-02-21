package Runecessor;

final class Item extends SceneNode {

    public int itemId;
    public int x;
    public int y;
	public long amount;
    public long value;

    private int localX;

    private int localY;

    public Item() {
    }

    public final Model getRotatedModel() {
        ItemDefinition itemDef = ItemDefinition.forId(itemId);
        return itemDef.getModel(amount);
    }

    public Item copy() {
        Item copy = new Item();

        copy.itemId = itemId;
        copy.x = x;
        copy.y = y;
        copy.amount = amount;
        copy.value = value;
        copy.localX = localX;
        copy.localY = localY;

        return copy;
    }

    public void setLocal(int localX, int localY) {
        this.localX = localX;
        this.localY = localY;
    }

    public void setLocalX(int localX) {
        this.localX = localX;
    }

    public int getLocalX() {
        return localX;
    }

    public void setLocalY(int localY) {
        this.localY = localY;
    }

    public int getLocalY() {
        return localY;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId + '}';
    }
}
