package pl.adrian_komuda.manipulate_volume_object.messages;

import pl.adrian_komuda.manipulate_volume_object.PluginColors;

import java.util.UUID;

public enum ErrorMessages {
    COMMAND_ONLY_FOR_PLAYERS("That command is designed only for players."),
    LOCATIONS_NOT_SET("Locations are not set.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PluginColors.FAIL_MESSAGES.getColor() + message;
    }
}
