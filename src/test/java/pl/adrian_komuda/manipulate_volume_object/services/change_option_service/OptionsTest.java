package pl.adrian_komuda.manipulate_volume_object.services.change_option_service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pl.adrian_komuda.manipulate_volume_object.TestFlags;
import pl.adrian_komuda.manipulate_volume_object.TestTemplate;
import pl.adrian_komuda.manipulate_volume_object.TestUtils;

import static org.assertj.core.api.Assertions.assertThat;

class OptionsTest extends TestTemplate {

    @BeforeAll
    static void setTestFlag() {
        TestFlags.UNIT_TEST_FLAG = true;
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
        TestFlags.UNIT_TEST_FLAG =  false;
    }
}