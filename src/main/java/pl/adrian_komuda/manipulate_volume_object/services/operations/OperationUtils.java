package pl.adrian_komuda.manipulate_volume_object.services.operations;

import org.bukkit.entity.Player;
import pl.adrian_komuda.manipulate_volume_object.messages.TitleMessages;

public class OperationUtils {

    private static OperationUtils instance;

    private OperationUtils() {}

    public static OperationUtils getInstance() {
        if (instance == null) {
            instance = new OperationUtils();
        }
        return instance;
    }

    public String getCompletionPercent(int numerator, int denominator) {
        int completionPercent = (int) Math.floor((float) numerator/denominator * 100);
        return completionPercent + "%";
    }

    public void printCompletionPercentOnScreen(Player player, int counter, int maxCounter) {
        String percent = getCompletionPercent(counter, maxCounter);

        var onlyPercentMessage = TitleMessages.ONLY_PERCENT;
        player.sendTitle(
                onlyPercentMessage.getMessage(),
                percent,
                onlyPercentMessage.getFadeInTicks(),
                onlyPercentMessage.getStayPeriodTicks(),
                onlyPercentMessage.getFadeOutTicks()
        );
    }

    public void printDoneOnScreen(Player player, int counter, int maxCounter) {
        String percent = getCompletionPercent(counter, maxCounter);

        var doneMessage = TitleMessages.DONE;
        player.sendTitle(
                doneMessage.getMessage(),
                percent,
                doneMessage.getFadeInTicks(),
                doneMessage.getStayPeriodTicks(),
                doneMessage.getFadeOutTicks());
    }

    public void printProcessingOnScreen(Player player) {
        var message = TitleMessages.PROCESSING;
        player.sendTitle(
                " ",
                message.getMessage(),
                message.getFadeInTicks(),
                message.getStayPeriodTicks(),
                message.getFadeOutTicks()
        );
    }

    public void printAbortedOnScreen(Player player) {
        var doneMessage = TitleMessages.ABORTED;
        player.sendTitle(
                doneMessage.getMessage(),
                " ",
                doneMessage.getFadeInTicks(),
                doneMessage.getStayPeriodTicks(),
                doneMessage.getFadeOutTicks());
    }
}
