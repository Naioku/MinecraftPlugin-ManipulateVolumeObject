package pl.adrian_komuda.manipulate_volume_object.services.change_option_service;

import pl.adrian_komuda.manipulate_volume_object.messages.MessagesWith1Params;

import java.util.Arrays;
import java.util.List;

public class ChangeOptionService {

    private static ChangeOptionService changeOptionService;

    private Options activeOption = Options.COPY;

    ChangeOptionService() {}

    public void setActiveOption(String optionString) {
        for (Options optionEnum : Options.values()) {
            if (optionEnum.getName().equals(optionString)) {
                this.activeOption = optionEnum;
            }
        }
    }

    public void setNext() {
        List<Options> options = Arrays.stream(Options.values()).toList();
        int index = options.indexOf(this.activeOption) + 1;
        if (index == 3) {
            index = 0;
        }
        this.activeOption = options.get(index);
    }

    public static ChangeOptionService getInstance() {
        if (changeOptionService == null) {
            changeOptionService = new ChangeOptionService();
        }
        return changeOptionService;
    }

    public Options getActiveOption() {
        return activeOption;
    }

    public String getActiveOptionAsMessage() {
        return MessagesWith1Params.GET_ACTIVE_OPTION.getMessage(activeOption.getName());
    }
}
