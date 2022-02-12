package pl.adrian_komuda.manipulate_volume_object.messages;

import org.bukkit.ChatColor;
import pl.adrian_komuda.manipulate_volume_object.PluginColors;

public enum MessagesWith2Params {
    GET_LOCATIONS("Locations are:\n" +
            "Location1: " + PluginColors.HIGHLIGHT_INFO.getColor() + "%s" + "\n" + ChatColor.WHITE +
            "Location2: " + PluginColors.HIGHLIGHT_INFO.getColor() + "%s" + "\n" + ChatColor.WHITE +
            "================");

    private final String message;

    MessagesWith2Params(String message) {
        this.message = message;
    }

    public String getMessage(String param1, String param2) {
        return String.format(message, param1, param2);
    }
}
