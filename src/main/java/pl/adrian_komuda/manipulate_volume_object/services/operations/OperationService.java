package pl.adrian_komuda.manipulate_volume_object.services.operations;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import pl.adrian_komuda.manipulate_volume_object.Main;
import pl.adrian_komuda.manipulate_volume_object.messages.ErrorMessages;
import pl.adrian_komuda.manipulate_volume_object.runnables.CopyRunnableManager;
import pl.adrian_komuda.manipulate_volume_object.runnables.PasteRunnableManager;
import pl.adrian_komuda.manipulate_volume_object.runnables.OperationRunnable;
import pl.adrian_komuda.manipulate_volume_object.services.LocationService;

public class OperationService {

    private final LocationService locationService = LocationService.getInstance();
    private final ObjectInMemoryService objectInMemoryService = ObjectInMemoryService.getInstance();
    private final OperationUtils operationUtils = OperationUtils.getInstance();

    private static BukkitRunnable OPERATION_RUNNABLE;
    private final Player player;
    private final CopyRunnableManager copyRunnableManager;
    private final PasteRunnableManager pasteRunnableManager;


    public OperationService(Player player) {
        this.player = player;
        copyRunnableManager = new CopyRunnableManager(player);
        pasteRunnableManager = new PasteRunnableManager(player);
    }

    public void startCopyRunnable() {
        if (!isRunnableProcessRunning()) {
            OPERATION_RUNNABLE = new OperationRunnable(copyRunnableManager);
            OPERATION_RUNNABLE.runTaskTimer(Main.getInstance(), 0, 0);
        }
    }

    public void startPasteRunnable() {
        if (!isRunnableProcessRunning()) {
            OPERATION_RUNNABLE = new OperationRunnable(pasteRunnableManager);
            OPERATION_RUNNABLE.runTaskTimer(Main.getInstance(), 0, 0);
        }
    }

    public void abortProcess() {
        if (OPERATION_RUNNABLE.isCancelled()) {
            throw new IllegalStateException(ErrorMessages.NOTHING_TO_ABORT.getMessage());
        }
        OPERATION_RUNNABLE.cancel();
        locationService.resetLocations();
        objectInMemoryService.clearObject();
        operationUtils.printAbortedOnScreen(player);
    }

    private boolean isRunnableProcessRunning() {
        return (OPERATION_RUNNABLE != null && !OPERATION_RUNNABLE.isCancelled());
    }
}