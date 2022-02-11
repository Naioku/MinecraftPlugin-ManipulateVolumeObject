package pl.adrian_komuda.manipulate_volume_object.messages;

import pl.adrian_komuda.manipulate_volume_object.PluginColors;

public enum Messages {
    ITEM_DROPPED_NEAR_PLAYER(PluginColors.INFO_MESSAGES.getColor() + "Item has been dropped near You, because Your inventory is full."),
    ITEM_ADDED_TO_INVENTORY(PluginColors.INFO_MESSAGES.getColor() + "Item has been added to Your inventory."),
    ALREADY_HAVE_ITEM_IN_INVENTORY(PluginColors.INFO_MESSAGES.getColor() + "You already have that item in Your inventory.");


    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
