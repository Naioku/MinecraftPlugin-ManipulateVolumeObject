package pl.adrian_komuda.manipulate_volume_object.services.change_option_service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pl.adrian_komuda.manipulate_volume_object.TestFlag;
import pl.adrian_komuda.manipulate_volume_object.TestUtils;

import static org.assertj.core.api.Assertions.assertThat;

class OptionsTest {

    @BeforeAll
    static void setTestFlag() {
        TestFlag.TEST_FLAG = true;
    }

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

    @AfterAll
    static void unsetTestFlag() {
        TestFlag.TEST_FLAG =  false;
    }
}