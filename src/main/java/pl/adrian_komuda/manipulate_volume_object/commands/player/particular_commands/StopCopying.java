package pl.adrian_komuda.manipulate_volume_object.commands.player.particular_commands;

import org.bukkit.entity.Player;
import pl.adrian_komuda.manipulate_volume_object.commands.PlayerCommandsPerformers;
import pl.adrian_komuda.manipulate_volume_object.messages.ErrorMessages;
import pl.adrian_komuda.manipulate_volume_object.services.operations.CopyService;

import java.util.List;

public class StopCopying implements PlayerCommandsPerformers {
    @Override
    public void perform(Player player, String command, List<String> args) {
        player.sendMessage("Performing " + this.getClass().getSimpleName()); // all logic
//
//        try {
//            CopyService copyService = new CopyService(player);
//            copyService.abortProcess();
//        } catch (IllegalArgumentException e) {
//            player.sendMessage(ErrorMessages.NOTHING_TO_ABORT.getMessage());
//        }
    }
}
