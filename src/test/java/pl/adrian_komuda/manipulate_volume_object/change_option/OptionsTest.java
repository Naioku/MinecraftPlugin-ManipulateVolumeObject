package pl.adrian_komuda.manipulate_volume_object.change_option;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pl.adrian_komuda.manipulate_volume_object.TestUtils;

import static org.assertj.core.api.Assertions.assertThat;

class OptionsTest {

    @ParameterizedTest
    @EnumSource(Options.class)
    void everyCommandShouldBeProperlyAssignedToProperEnumValue(Options option) {
        // given
        String commandName = option.getName();
        String enumValue = option.name();

        // when
        String resultEnumValue = TestUtils.changeSnakeCaseToUpperCase(commandName);

        // then
        assertThat(resultEnumValue).isEqualTo(enumValue);
    }

}