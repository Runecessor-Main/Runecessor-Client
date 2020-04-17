package Runecessor.phantasye;

import org.phantasye.AbstractJsonRepository;

public class CustomItemRepository extends AbstractJsonRepository<CustomItem> {
    @Override
    public void create(CustomItem customItem) {
        entries.putIfAbsent(String.valueOf(customItem.getId()), customItem);
    }

    @Override
    public CustomItem read(CustomItem customItem) {
        return entries.get(String.valueOf(customItem.getId()));
    }

    @Override
    public void delete(CustomItem customItem) {
        entries.remove(String.valueOf(customItem.getId()));
    }
}
