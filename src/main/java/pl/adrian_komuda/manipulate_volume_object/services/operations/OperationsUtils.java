package pl.adrian_komuda.manipulate_volume_object.services.operations;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import pl.adrian_komuda.manipulate_volume_object.messages.TitleMessages;

import java.util.LinkedHashMap;

public class OperationsUtils {

    private static OperationsUtils instance;
    private final LinkedHashMap<Vector, Material> copiedObj = new LinkedHashMap<>();

    private OperationsUtils() {}

    public static OperationsUtils getInstance() {
        if (instance == null) {
            instance = new OperationsUtils();
        }
        return instance;
    }

    public String getCompletionPercent(int numerator, int denominator) {
        int completionPercent = (int) Math.floor((float) numerator/denominator * 100);
        return String.valueOf(completionPercent) + "%";
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
                "",
                message.getMessage(),
                message.getFadeInTicks(),
                message.getStayPeriodTicks(),
                message.getFadeOutTicks());
    }

    public LinkedHashMap<Vector, Material> getCopiedObj() {
        return copiedObj;
    }
}
