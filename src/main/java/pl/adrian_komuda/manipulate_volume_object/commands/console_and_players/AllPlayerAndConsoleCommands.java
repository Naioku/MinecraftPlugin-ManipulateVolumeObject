package pl.adrian_komuda.manipulate_volume_object.commands.console_and_players;

import org.bukkit.command.CommandSender;
import pl.adrian_komuda.manipulate_volume_object.commands.CommandsPerformers;
import pl.adrian_komuda.manipulate_volume_object.commands.console_and_players.particular_commands.DisableFunctionalTests;
import pl.adrian_komuda.manipulate_volume_object.commands.console_and_players.particular_commands.EnableFunctionalTests;
import pl.adrian_komuda.manipulate_volume_object.commands.console_and_players.particular_commands.Help;

import java.util.List;

public enum AllPlayerAndConsoleCommands {
    HELP("help", new Help()),
    ENABLE_FUNCTIONAL_TESTS("enable_functional_tests", new EnableFunctionalTests()),
    DISABLE_FUNCTIONAL_TESTS("disable_functional_tests", new DisableFunctionalTests());

    private final String commandName;
    private final CommandsPerformers commandPerformer;

    AllPlayerAndConsoleCommands(String commandName, CommandsPerformers commandPerformer) {
        this.commandName = commandName;
        this.commandPerformer = commandPerformer;
    }

    public String getName() {
        return commandName;
    }

    public void perform(CommandSender commandSender, String command, List<String> args) {
        commandPerformer.perform(commandSender, command, args);
    }

    public CommandsPerformers getCommandPerformer() {
        return commandPerformer;
    }
}
