package pl.adrian_komuda.manipulate_volume_object.commands.player.particular_commands;

import org.bukkit.entity.Player;
import pl.adrian_komuda.manipulate_volume_object.commands.PlayerCommandsPerformers;

import java.util.List;

public class PrintLocations implements PlayerCommandsPerformers {
    @Override
    public void perform(Player player, String command, List<String> args) {
        player.sendMessage("Performing " + this.getClass().getSimpleName()); // all logic
    }
}
