package pl.adrian_komuda.manipulate_volume_object;

import org.bukkit.ChatColor;

public enum PluginColors {
    DESCRIPTIONS(ChatColor.GRAY),
    ITEM_HEADERS(ChatColor.GREEN),
    INFO_MESSAGES(ChatColor.GOLD),
    SUCCESS_MESSAGES(ChatColor.GREEN),
    FAIL_MESSAGES(ChatColor.RED),
    HIGHLIGHT_INFO(ChatColor.AQUA),
    PROCESSING_TITLE(ChatColor.WHITE),
    PERCENT_TITLE(ChatColor.WHITE),
    DONE_TITLE(ChatColor.GOLD),
    ABORTED_TITLE(ChatColor.GOLD);

    private final ChatColor color;

    PluginColors(ChatColor color) {
        this.color = color;
    }

    public ChatColor getColor() {
        return color;
    }
}
