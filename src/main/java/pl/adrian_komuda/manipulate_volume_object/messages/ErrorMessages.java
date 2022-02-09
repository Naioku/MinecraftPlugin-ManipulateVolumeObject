package pl.adrian_komuda.manipulate_volume_object.messages;

import java.util.UUID;

public enum ErrorMessages {
    COMMAND_ONLY_FOR_PLAYERS("That command is designed only for players.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
