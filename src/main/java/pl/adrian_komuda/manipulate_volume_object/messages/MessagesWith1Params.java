package pl.adrian_komuda.manipulate_volume_object.messages;

import org.bukkit.ChatColor;
import pl.adrian_komuda.manipulate_volume_object.PluginColors;

public enum MessagesWith1Params {
    GET_ACTIVE_OPTION("Active option: " + PluginColors.HIGHLIGHT_INFO.getColor() + "%s");

    private final String message;

    MessagesWith1Params(String message) {
        this.message = message;
    }

    public String getMessage(String param1) {
        return String.format(message, param1);
    }
}
