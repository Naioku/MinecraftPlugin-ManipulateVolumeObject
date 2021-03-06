package pl.adrian_komuda.manipulate_volume_object.messages;

import pl.adrian_komuda.manipulate_volume_object.PluginColors;

public enum MessagesWith0Params {
    ITEM_DROPPED_NEAR_PLAYER(PluginColors.INFO_MESSAGES.getColor() + "Item has been dropped near You, because Your inventory is full."),
    ITEM_ADDED_TO_INVENTORY(PluginColors.INFO_MESSAGES.getColor() + "Item has been added to Your inventory."),
    ALREADY_HAVE_ITEM_IN_INVENTORY(PluginColors.INFO_MESSAGES.getColor() + "You already have that item in Your inventory."),
    LOCATION1_SET(PluginColors.SUCCESS_MESSAGES.getColor() + "Location1 is set. Mark the last one, if You want to copy, or delete an object."),
    LOCATION2_SET(PluginColors.SUCCESS_MESSAGES.getColor() + "Location2 is set. Good job!"),
    FUNCTIONAL_TESTS_ENABLED(PluginColors.INFO_MESSAGES.getColor() + "Functional tests enabled."),
    FUNCTIONAL_TESTS_DISABLED(PluginColors.INFO_MESSAGES.getColor() + "Functional tests disabled.");

    private final String message;

    MessagesWith0Params(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
