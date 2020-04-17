package Runecessor.phantasye;

import Runecessor.ClientConstants;
import org.phantasye.RepositoryManager;

public class CustomItemManager extends RepositoryManager<CustomItem,CustomItemRepository> {

    private static CustomItemManager instance = null;

    public static CustomItemManager getInstance() {
        if(instance == null)
            instance = new CustomItemManager();
        return instance;
    }

    private CustomItemManager() {
        super(ClientConstants.getRunecessorFolderLocation() + "items.json", CustomItemRepository.class);
    }
}
