package pl.adrian_komuda.manipulate_volume_object.commands.player.particular_commands;

import org.bukkit.entity.Player;
import pl.adrian_komuda.manipulate_volume_object.change_option.ChangeOptionService;
import pl.adrian_komuda.manipulate_volume_object.commands.PlayerCommandsPerformers;

import java.util.List;

public class ChangeOption implements PlayerCommandsPerformers {

    private final ChangeOptionService changeOptionService = ChangeOptionService.getInstance();

    @Override
    public void perform(Player player, String command, List<String> args) {
        switch (args.size()) {
            case 0 -> changeOptionService.setNext();
            case 1 -> changeOptionService.setActiveOption(args.get(0));
        }
        player.sendMessage(changeOptionService.getActiveOptionAsMessage());
    }
}
