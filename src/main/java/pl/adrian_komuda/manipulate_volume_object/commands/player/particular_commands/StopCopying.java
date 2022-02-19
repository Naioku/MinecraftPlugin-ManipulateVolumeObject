package pl.adrian_komuda.manipulate_volume_object.commands.player.particular_commands;

import org.bukkit.entity.Player;
import pl.adrian_komuda.manipulate_volume_object.commands.PlayerCommandsPerformers;
import pl.adrian_komuda.manipulate_volume_object.messages.ErrorMessages;
import pl.adrian_komuda.manipulate_volume_object.services.operations.OperationService;

import java.util.List;

public class StopCopying implements PlayerCommandsPerformers {
    @Override
    public void perform(Player player, String command, List<String> args) {
        try {
            OperationService operationService = new OperationService(player);
            operationService.abortProcess();
        } catch (IllegalArgumentException e) {
            player.sendMessage(ErrorMessages.NOTHING_TO_ABORT.getMessage());
        }
    }
}
