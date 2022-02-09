package pl.adrian_komuda.manipulate_volume_object.commands.command_and_players.particular_commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import pl.adrian_komuda.manipulate_volume_object.commands.CommandsPerformers;

public class Help implements CommandsPerformers {
    @Override
    public void perform(CommandSender commandSender, String commandFromConsole, String[] args) {
        commandSender.sendMessage("Performing " + this.getClass().getSimpleName()); // all logic
    }
}
