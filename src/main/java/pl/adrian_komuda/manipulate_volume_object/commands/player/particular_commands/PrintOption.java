package pl.adrian_komuda.manipulate_volume_object.commands.player.particular_commands;

import org.bukkit.entity.Player;
import pl.adrian_komuda.manipulate_volume_object.change_option.ChangeOptionService;
import pl.adrian_komuda.manipulate_volume_object.commands.PlayerCommandsPerformers;

import java.util.List;

public class PrintOption implements PlayerCommandsPerformers {

    ChangeOptionService changeOptionService = ChangeOptionService.getInstance();

    @Override
    public void perform(Player player, String command, List<String> args) {
        player.sendMessage(changeOptionService.getActiveOptionAsMessage());
    }
}
