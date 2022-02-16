package pl.adrian_komuda.manipulate_volume_object.services.operations;

import pl.adrian_komuda.manipulate_volume_object.Main;
import pl.adrian_komuda.manipulate_volume_object.messages.ErrorMessages;
import pl.adrian_komuda.manipulate_volume_object.runnables.CopyRunnable;
import pl.adrian_komuda.manipulate_volume_object.services.LocationService;

public class CopyRunnableManager {

    private static CopyRunnableManager instance;

    private CopyRunnable copyRunnable;

    private final LocationService locationService = LocationService.getInstance();
    private final ObjectInMemoryService objectInMemoryService = ObjectInMemoryService.getInstance();

    private CopyRunnableManager() {}

    public static CopyRunnableManager getInstance() {
        if (instance == null) {
            instance = new CopyRunnableManager();
        }
        return instance;
    }

    public void startCopyRunnable(CopyService copyService) {
        copyRunnable = new CopyRunnable(copyService);
        copyRunnable.runTaskTimer(Main.getInstance(), 0, 0);
    }

    public void abortProcess() {
        if (copyRunnable.isCancelled()) {
            throw new IllegalStateException(ErrorMessages.NOTHING_TO_ABORT.getMessage());
        }
        copyRunnable.cancel();
        locationService.resetLocations();
        objectInMemoryService.clearObject();
    }
}
