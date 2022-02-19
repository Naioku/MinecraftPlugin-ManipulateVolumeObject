package pl.adrian_komuda.manipulate_volume_object.services.operations;

import org.bukkit.entity.Player;
import pl.adrian_komuda.manipulate_volume_object.Main;
import pl.adrian_komuda.manipulate_volume_object.messages.ErrorMessages;
import pl.adrian_komuda.manipulate_volume_object.runnables.CopyRunnable;
import pl.adrian_komuda.manipulate_volume_object.runnables.CopyRunnableManager;
import pl.adrian_komuda.manipulate_volume_object.services.LocationService;

public class CopyService {

    private final LocationService locationService = LocationService.getInstance();
    private final ObjectInMemoryService objectInMemoryService = ObjectInMemoryService.getInstance();
    private final OperationUtils operationUtils = OperationUtils.getInstance();

    private static CopyRunnable COPY_RUNNABLE;
    private final Player player;
    private final CopyRunnableManager copyRunnableManager;


    public CopyService(Player player) {
        this.player = player;
        copyRunnableManager = new CopyRunnableManager(player);
    }

    public void startCopyRunnable() {
        COPY_RUNNABLE = new CopyRunnable(copyRunnableManager);
        COPY_RUNNABLE.runTaskTimer(Main.getInstance(), 0, 0);
    }

    public void abortProcess() {
        if (COPY_RUNNABLE.isCancelled()) {
            throw new IllegalStateException(ErrorMessages.NOTHING_TO_ABORT.getMessage());
        }
        COPY_RUNNABLE.cancel();
        locationService.resetLocations();
        objectInMemoryService.clearObject();
        operationUtils.printAbortedOnScreen(player);
    }
}