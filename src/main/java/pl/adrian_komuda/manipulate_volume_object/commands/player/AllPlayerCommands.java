package pl.adrian_komuda.manipulate_volume_object.commands.player;

import org.bukkit.entity.Player;
import pl.adrian_komuda.manipulate_volume_object.commands.PlayerCommandsPerformers;
import pl.adrian_komuda.manipulate_volume_object.commands.player.particular_commands.*;

import java.util.List;

public enum AllPlayerCommands {
    GET_MARKER("get_marker", new GetMarker()),
    START_COPYING("start_copying", new StartCopying()),
    STOP_COPYING("stop_copying", new StopCopying()),
    START_PASTING("start_pasting", new StartPasting()),
    STOP_PASTING("stop_pasting", new StopPasting()),
    // START_DELETING,
    // STOP_DELETING,
//    UNDO("undo", new Undo()),
    CHANGE_OPTION("change_option", new ChangeOption()), // ok
    PRINT_OPTION("print_option", new PrintOption()), // ok
    PRINT_LOCATIONS("print_locations", new PrintLocations()); // ok


//    RELOAD_CONFIG_FILE("reload_config_file", new ReloadConfigFile()),
    //    RESET_COPY_LOCATION("reset_copy_location", new ResetCopyLocation()), // ?


//    CHECK_HISTORY("check_history", new CheckHistory()),
//    DELETE_MARKED_VOLUME("delete_marked_volume", new DeleteMarkedVolume());
//    RESET_DELETE_LOCATIONS, // ?
//    STOP_DELETING; // ?

    private final String commandName;
    private final PlayerCommandsPerformers commandPerformer;

    AllPlayerCommands(String commandName, PlayerCommandsPerformers commandPerformer) {
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
