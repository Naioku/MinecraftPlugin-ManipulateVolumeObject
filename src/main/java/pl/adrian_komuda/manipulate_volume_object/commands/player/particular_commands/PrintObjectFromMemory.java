package pl.adrian_komuda.manipulate_volume_object.commands.player.particular_commands;

import org.bukkit.entity.Player;
import pl.adrian_komuda.manipulate_volume_object.commands.PlayerCommandsPerformers;
import pl.adrian_komuda.manipulate_volume_object.services.operations.OperationsUtils;

import java.util.List;

public class PrintObjectFromMemory implements PlayerCommandsPerformers {
    @Override
    public void perform(Player player, String command, List<String> args) {
        var operationUtils = OperationsUtils.getInstance();
        player.sendMessage(operationUtils.getCopiedObj().toString());
    }
}
