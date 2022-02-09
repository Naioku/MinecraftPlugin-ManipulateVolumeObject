package pl.adrian_komuda.manipulate_volume_object.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import pl.adrian_komuda.manipulate_volume_object.commands.command_and_players.AllPlayerAndConsoleCommands;
import pl.adrian_komuda.manipulate_volume_object.commands.player.AllPlayerCommands;

import java.util.ArrayList;
import java.util.List;

public class MinecraftCommandsReceiver implements CommandExecutor, TabCompleter {

    Plugin plugin;

    public MinecraftCommandsReceiver(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command prefixFromConsole, String label, String[] commandAndArgs) {

        if (prefixFromConsole.getName().equals(AllCommandsData.commandPrefix)) {
            if (commandAndArgs.length == 1) {
                String commandFromConsole = commandAndArgs[0];

                for (AllPlayerAndConsoleCommands command : AllPlayerAndConsoleCommands.values()) {
                    if (command.getName().equals(commandFromConsole)) {
                        command.perform(commandSender, commandFromConsole, commandAndArgs);
                    }
                }

                if (commandSender instanceof Player player) {
                    for (AllPlayerCommands command : AllPlayerCommands.values()) {
                        if (command.getName().equals(commandFromConsole)) {
                            command.perform(player, commandFromConsole, commandAndArgs);
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
