package pl.adrian_komuda.manipulate_volume_object.commands.player;

import org.bukkit.entity.Player;
import pl.adrian_komuda.manipulate_volume_object.commands.PlayerCommandsPerformers;
import pl.adrian_komuda.manipulate_volume_object.commands.player.particular_commands.GetMarker;

public enum AllPlayerCommands {
    GET_MARKER("get_marker", new GetMarker());
//    RESET_COPY_LOCATION(""),
//    PRINT_LOCATIONS,
//    START_COPYING,
//    STOP_COPYING,
//    START_PASTING,
//    STOP_PASTING,
//    PRINT_OBJECT_FROM_MEMORY,
//    PRINT_SWITCH_OPTION,
//    CHANGE_SWITCH_OPTION,
//    RELOAD_CONFIG_FILE,
//    UNDO,
//    CHECK_HISTORY,
//    DELETE_MARKED_VOLUME,
//    RESET_DELETE_LOCATIONS, // ?
//    STOP_DELETING; // ?

    private final String commandMinecraftName;
    private final PlayerCommandsPerformers commandPerformer;

    AllPlayerCommands(String commandMinecraftName, PlayerCommandsPerformers commandPerformer) {
        this.commandMinecraftName = commandMinecraftName;
        this.commandPerformer = commandPerformer;
    }

    public String getName() {
        return commandMinecraftName;
    }

    public void perform(Player player, String commandFromConsole, String[] args) {
        commandPerformer.perform(player, commandFromConsole, args);
    }
}
