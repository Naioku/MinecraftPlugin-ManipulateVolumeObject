package pl.adrian_komuda.manipulate_volume_object.commands.player;

import org.bukkit.entity.Player;
import pl.adrian_komuda.manipulate_volume_object.commands.PlayerCommandsPerformers;
import pl.adrian_komuda.manipulate_volume_object.commands.player.particular_test_commands.PrintObjectFromMemory;

import java.util.List;

public enum AllPlayerTestCommands {
    PRINT_OBJECT_FROM_MEMORY("print_object_from_memory", new PrintObjectFromMemory());

    private final String commandName;
    private final PlayerCommandsPerformers commandPerformer;

    AllPlayerTestCommands(String commandName, PlayerCommandsPerformers commandPerformer) {
        this.commandName = commandName;
        this.commandPerformer = commandPerformer;
    }

    public String getName() {
        return commandName;
    }

    public void perform(Player player, String command, List<String> args) {
        commandPerformer.perform(player, command, args);
    }

    public PlayerCommandsPerformers getCommandPerformer() {
        return commandPerformer;
    }
}
