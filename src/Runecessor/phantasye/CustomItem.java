package Runecessor.phantasye;

import Runecessor.ItemDefinition;

public class CustomItem {

    private final int id;
    private final ItemDefinition definition;

    public CustomItem(int id, ItemDefinition definition) {
        this.id = id;
        this.definition = definition;
    }

    public int getId() {
        return id;
    }

    public ItemDefinition getDefinition() {
        return definition;
    }
}
