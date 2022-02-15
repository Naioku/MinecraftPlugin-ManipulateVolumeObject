package pl.adrian_komuda.manipulate_volume_object.messages;

import pl.adrian_komuda.manipulate_volume_object.PluginColors;

public enum TitleMessages {
    PROCESSING(
            PluginColors.PROCESSING_TITLE.getColor() + "Processing...",
            1,
            20,
            1
    ),
    ONLY_PERCENT(
            PluginColors.PERCENT_TITLE.getColor() + "",
            1,
            20,
            1
    ),
    DONE(
            PluginColors.DONE_TITLE.getColor() + "Done!",
            1,
            20,
            1
    );

    private String message;
    private int fadeInTicks;
    private int stayPeriodTicks;
    private int fadeOutTicks;

    TitleMessages(String message, int fadeInTicks, int stayPeriodTicks, int fadeOutTicks) {
        this.message = message;
        this.fadeInTicks = fadeInTicks;
        this.stayPeriodTicks = stayPeriodTicks;
        this.fadeOutTicks = fadeOutTicks;
    }

    public String getMessage() {
        return message;
    }

    public int getFadeInTicks() {
        return fadeInTicks;
    }

    public int getStayPeriodTicks() {
        return stayPeriodTicks;
    }

    public int getFadeOutTicks() {
        return fadeOutTicks;
    }
}
