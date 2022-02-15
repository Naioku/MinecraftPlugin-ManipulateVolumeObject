package pl.adrian_komuda.manipulate_volume_object.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import pl.adrian_komuda.manipulate_volume_object.TestFlags;
import pl.adrian_komuda.manipulate_volume_object.commands.console_and_players.AllPlayerAndConsoleCommands;
import pl.adrian_komuda.manipulate_volume_object.commands.player.AllPlayerCommands;
import pl.adrian_komuda.manipulate_volume_object.commands.player.AllPlayerTestCommands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinecraftCommandsReceiver implements CommandExecutor, TabCompleter {

    Plugin plugin;

    public MinecraftCommandsReceiver(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command prefixReceived, String label, String[] commandAndArgs) {

        if (prefixReceived.getName().equals(AllCommandsData.commandPrefix)) {
            if (commandAndArgs.length >= 1) {

                String commandReceived = commandAndArgs[0];
                List<String> argsReceived = Arrays.stream(commandAndArgs).toList().subList(1, commandAndArgs.length);

                for (AllPlayerAndConsoleCommands command : AllPlayerAndConsoleCommands.values()) {
                    if (command.getName().equals(commandReceived)) {
                        command.perform(commandSender, commandReceived, argsReceived);
                        return true;
                    }
                }

                if (commandSender instanceof Player player) {
                    if (TestFlags.FUNCTIONAL_TEST_FLAG) {
                        for (AllPlayerTestCommands command : AllPlayerTestCommands.values()) {
                            if (command.getName().equals(commandReceived)) {
                                command.perform(player, commandReceived, argsReceived);
                                return true;
                            }
                        }
                    }

                    for (AllPlayerCommands command : AllPlayerCommands.values()) {
                        if (command.getName().equals(commandReceived)) {
                            command.perform(player, commandReceived, argsReceived);
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command prefixFromConsole, String label, String[] commandAndArgs) {

        if (prefixFromConsole.getName().equals(AllCommandsData.commandPrefix)) {
            if (commandAndArgs.length == 1) {
                List<String> tabCompleteCollection = new ArrayList<>();
                for (AllPlayerAndConsoleCommands command : AllPlayerAndConsoleCommands.values()) {
                    tabCompleteCollection.add(command.getName());
                }

                if (commandSender instanceof Player) {
                    if (TestFlags.FUNCTIONAL_TEST_FLAG) {
                        for(AllPlayerTestCommands command : AllPlayerTestCommands.values()) {
                            tabCompleteCollection.add(command.getName());
                        }
                    }
                    for (AllPlayerCommands command : AllPlayerCommands.values()) {
                        tabCompleteCollection.add(command.getName());
                    }
                }
                return tabCompleteCollection;
            }
        }

        return null;
    }
}
