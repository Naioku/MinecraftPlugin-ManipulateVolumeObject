package pl.adrian_komuda.manipulate_volume_object.services.change_option_service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.adrian_komuda.manipulate_volume_object.TestFlag;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ChangeOptionServiceTest {

    @BeforeAll
    static void setTestFlag() {
        TestFlag.TEST_FLAG = true;
    }

    @Test
    void afterSetOptionCallCurrentOptionFieldShouldBeProperlySet() {
        // given
        var changeOptionService = new ChangeOptionService();
        Options option = Options.DELETE;

        // when
        changeOptionService.setActiveOption(option.getName());

        // then
        assertThat(changeOptionService.getActiveOption()).isEqualTo(option);
    }

    @Test
    void afterSetNextCallCurrentOptionFieldShouldBeProperlySet() {
        // given
        var changeOptionService = new ChangeOptionService();
        Options nextOption = getOptionByIndex(1);

        // when
        changeOptionService.setNext();

        // then
        assertThat(changeOptionService.getActiveOption()).isEqualTo(nextOption);
    }

    @Test
    void afterSetNextCall3TimesCurrentOptionFieldShouldBeProperlySet() {
        // given
        var changeOptionService = new ChangeOptionService();
        Options nextOption = getOptionByIndex(0);

        // when
        changeOptionService.setNext();
        changeOptionService.setNext();
        changeOptionService.setNext();

        // then
        assertThat(changeOptionService.getActiveOption()).isEqualTo(nextOption);
    }

    private Options getOptionByIndex(int index) {
        List<Options> optionsList = Arrays.stream(Options.values()).toList();
        return optionsList.get(index);
    }

    @AfterAll
    static void unsetTestFlag() {
        TestFlag.TEST_FLAG =  false;
    }
}