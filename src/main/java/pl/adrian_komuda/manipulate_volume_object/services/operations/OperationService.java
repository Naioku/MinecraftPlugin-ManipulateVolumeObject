package pl.adrian_komuda.manipulate_volume_object.services.operations;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import pl.adrian_komuda.manipulate_volume_object.Main;
import pl.adrian_komuda.manipulate_volume_object.messages.ErrorMessages;
import pl.adrian_komuda.manipulate_volume_object.runnables.managers.CopyRunnableManager;
import pl.adrian_komuda.manipulate_volume_object.runnables.OperationRunnable;
import pl.adrian_komuda.manipulate_volume_object.runnables.managers.PasteRunnableManager;
import pl.adrian_komuda.manipulate_volume_object.services.LocationService;
import pl.adrian_komuda.manipulate_volume_object.services.object_in_memory_service.ObjectInMemoryService;

public class OperationService {

    private final LocationService locationService = LocationService.getInstance();
    private final ObjectInMemoryService objectInMemoryService = ObjectInMemoryService.getInstance();
    private final OperationUtils operationUtils = OperationUtils.getInstance();

    private static BukkitRunnable OPERATION_RUNNABLE;
    private final Player player;

    public OperationService(Player player) {
        this.player = player;
    }

    public void startCopyRunnable() throws IllegalArgumentException {
        if (!isRunnableProcessRunning()) {
            OPERATION_RUNNABLE = new OperationRunnable(new CopyRunnableManager(player));
            OPERATION_RUNNABLE.runTaskTimer(Main.getInstance(), 0, 0);
        }
    }

    public void startPasteRunnable() throws IllegalArgumentException {
        if (!isRunnableProcessRunning() && objectInMemoryService.isObjectInMemory()) {
            OPERATION_RUNNABLE = new OperationRunnable(new PasteRunnableManager(player));
            OPERATION_RUNNABLE.runTaskTimer(Main.getInstance(), 0, 0);
        }
    }

    public void abortProcess() throws IllegalStateException {
        if (!isRunnableProcessRunning()) {
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