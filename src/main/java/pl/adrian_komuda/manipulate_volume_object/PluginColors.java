package pl.adrian_komuda.manipulate_volume_object;

import org.bukkit.ChatColor;

public enum PluginColors {
    DESCRIPTIONS(ChatColor.GRAY),
    ITEM_HEADERS(ChatColor.GREEN),
    INFO_MESSAGES(ChatColor.GOLD),
    SUCCESS_MESSAGES(ChatColor.GREEN),
    FAIL_MESSAGES(ChatColor.RED);

    private final ChatColor color;

    PluginColors(ChatColor color) {
        this.color = color;
    }

    public ChatColor getColor() {
        return color;
    }
}
