package pl.adrian_komuda.manipulate_volume_object.commands.console_and_players;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pl.adrian_komuda.manipulate_volume_object.TestFlags;
import pl.adrian_komuda.manipulate_volume_object.TestUtils;

import static org.assertj.core.api.Assertions.assertThat;

class AllPlayerAndConsoleCommandsTest {

    @BeforeAll
    static void setTestFlag() {
        TestFlags.UNIT_TEST_FLAG = true;
    }

    @ParameterizedTest
    @EnumSource(AllPlayerAndConsoleCommands.class)
    void everyCommandShouldBeProperlyAssignedToProperCommandClass(AllPlayerAndConsoleCommands playerCommand) {
        // given
        String commandName = playerCommand.getName();
        String className = playerCommand.getCommandPerformer().getClass().getSimpleName();

        // when
        String resultClassName = TestUtils.changeSnakeCaseToCamelCase(commandName);

        // then
        assertThat(resultClassName).isEqualTo(className);
    }

    @ParameterizedTest
    @EnumSource(AllPlayerAndConsoleCommands.class)
    void everyCommandShouldBeProperlyAssignedToProperEnumValue(AllPlayerAndConsoleCommands playerCommand) {
        // given
        String commandName = playerCommand.getName();
        String enumValue = playerCommand.name();

        // when
        String resultEnumValue = TestUtils.changeSnakeCaseToUpperCase(commandName);

        // then
        assertThat(resultEnumValue).isEqualTo(enumValue);
    }

    @AfterAll
    static void unsetTestFlag() {
        TestFlags.UNIT_TEST_FLAG =  false;
    }

}