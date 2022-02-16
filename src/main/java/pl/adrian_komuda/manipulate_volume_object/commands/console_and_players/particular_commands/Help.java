package pl.adrian_komuda.manipulate_volume_object.commands.console_and_players.particular_commands;

import org.bukkit.command.CommandSender;
import pl.adrian_komuda.manipulate_volume_object.commands.CommandsPerformers;

import java.util.List;

public class Help implements CommandsPerformers {
    @Override
    public void perform(CommandSender commandSender, String command, List<String> args) {
        commandSender.sendMessage("Performing " + this.getClass().getSimpleName()); // all logic
    }
}
