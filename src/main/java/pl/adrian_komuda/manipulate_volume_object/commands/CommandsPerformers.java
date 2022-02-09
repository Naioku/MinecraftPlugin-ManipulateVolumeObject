package pl.adrian_komuda.manipulate_volume_object.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public interface CommandsPerformers {
    void perform(CommandSender commandSender, String commandFromConsole, String[] args);
}
