package pl.adrian_komuda.manipulate_volume_object.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public interface CommandsPerformers {
    void perform(CommandSender commandSender, String command, List<String> args);
}
