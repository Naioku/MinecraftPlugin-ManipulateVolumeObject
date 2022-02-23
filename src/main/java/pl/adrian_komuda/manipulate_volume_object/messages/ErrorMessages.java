package pl.adrian_komuda.manipulate_volume_object.messages;

import pl.adrian_komuda.manipulate_volume_object.PluginColors;

import java.util.UUID;

public enum ErrorMessages {
    COMMAND_ONLY_FOR_PLAYERS("That command is designed only for players."),
    LOCATIONS_NOT_SET("Locations are not set."),
    LOCATION1_NOT_SET("Location1 is not set."),
    NOTHING_TO_ABORT("There is no process to abort."),
    PROCESS_IS_RUNNING("Some process is already running. Wait for end or abort it."),
    NO_OBJECT_IN_MEMORY("There is no object in memory to paste. Copy one before."),

    SAVING_SLOT_EMPTY("Saving slot cannot be empty."),
    HISTORY_EMPTY("History is empty. There is nothing to undo."),
    LOADING_SLOT_EMPTY("Loading slot is empty. Load object from history first.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PluginColors.FAIL_MESSAGES.getColor() + message;
    }
}
