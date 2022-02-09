package pl.adrian_komuda.manipulate_volume_object.commands;

import org.bukkit.entity.Player;

public interface PlayerCommandsPerformers {
    void perform(Player player, String commandFromConsole, String[] args);
}
