package pl.adrian_komuda.manipulate_volume_object.commands.player.particular_commands;

import org.bukkit.entity.Player;
import pl.adrian_komuda.manipulate_volume_object.services.change_option_service.ChangeOptionService;
import pl.adrian_komuda.manipulate_volume_object.commands.PlayerCommandsPerformers;

import java.util.List;

public class PrintOption implements PlayerCommandsPerformers {

    @Override
    public void perform(Player player, String command, List<String> args) {
        var changeOptionService = ChangeOptionService.getInstance();
        player.sendMessage(changeOptionService.getActiveOptionAsMessage());
    }
}
