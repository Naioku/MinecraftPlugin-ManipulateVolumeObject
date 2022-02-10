package pl.adrian_komuda.manipulate_volume_object.commands;

import org.bukkit.entity.Player;

import java.util.List;

public interface PlayerCommandsPerformers {
    void perform(Player player, String command, List<String> args);
}
