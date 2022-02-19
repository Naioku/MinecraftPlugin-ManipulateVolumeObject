package pl.adrian_komuda.manipulate_volume_object.commands.player.particular_commands;

import org.bukkit.entity.Player;
import pl.adrian_komuda.manipulate_volume_object.commands.PlayerCommandsPerformers;
import pl.adrian_komuda.manipulate_volume_object.messages.ErrorMessages;
import pl.adrian_komuda.manipulate_volume_object.services.operations.OperationService;

import java.util.List;

public class StartCopying implements PlayerCommandsPerformers {

    @Override
    public void perform(Player player, String command, List<String> args) {
        OperationService operationService = new OperationService(player);

        try {
            operationService.startCopyRunnable();
        } catch (IllegalArgumentException e) {
            player.sendMessage(ErrorMessages.LOCATIONS_NOT_SET.getMessage());
        }
    }
}
