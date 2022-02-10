package pl.adrian_komuda.manipulate_volume_object.commands.command_and_players;

import org.bukkit.command.CommandSender;
import pl.adrian_komuda.manipulate_volume_object.commands.CommandsPerformers;
import pl.adrian_komuda.manipulate_volume_object.commands.command_and_players.particular_commands.Help;

import java.util.List;

public enum AllPlayerAndConsoleCommands {
    HELP("help", new Help());

    private final String commandMinecraftName;
    private final CommandsPerformers commandPerformer;

    AllPlayerAndConsoleCommands(String commandMinecraftName, CommandsPerformers commandPerformer) {
        this.commandMinecraftName = commandMinecraftName;
        this.commandPerformer = commandPerformer;
    }

    public String getName() {
        return commandMinecraftName;
    }

    public void perform(CommandSender commandSender, String command, List<String> args) {
        commandPerformer.perform(commandSender, command, args);
    }
}