package pl.adrian_komuda.manipulate_volume_object.commands.player;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

class AllPlayerCommandsTest {

    @ParameterizedTest
    @EnumSource(AllPlayerCommands.class)
    void everyCommandShouldBeProperlyAssignedToProperCommandClass(AllPlayerCommands playerCommand) {
        // given
        String commandName = playerCommand.getName();
        String className = playerCommand.getCommandPerformer().getClass().getSimpleName();

        // when
        String resultClassName = changeSnakeCaseToCamelCase(commandName);

        // then
        assertThat(resultClassName).isEqualTo(className);
    }

    private static String changeSnakeCaseToCamelCase(String string) {
        String[] words = string.split("_");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(word.substring(0, 1).toUpperCase(Locale.ROOT))
                    .append(word.substring(1));
        }
        return result.toString();
    }

    @ParameterizedTest
    @EnumSource(AllPlayerCommands.class)
    void everyCommandShouldBeProperlyAssignedToProperEnumValue(AllPlayerCommands playerCommand) {
        // given
        String commandName = playerCommand.getName();
        String enumValue = playerCommand.name();

        // when
        String resultEnumValue = changeSnakeCaseToUpperCase(commandName);

        // then
        assertThat(resultEnumValue).isEqualTo(enumValue);
    }

    private static String changeSnakeCaseToUpperCase(String string) {
        return string.toUpperCase(Locale.ROOT);
    }

}