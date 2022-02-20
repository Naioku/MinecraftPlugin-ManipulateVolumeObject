package pl.adrian_komuda.manipulate_volume_object.runnables.managers;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import pl.adrian_komuda.manipulate_volume_object.services.LocationService;
import pl.adrian_komuda.manipulate_volume_object.services.object_in_memory_service.ObjectInMemoryService;
import pl.adrian_komuda.manipulate_volume_object.services.operations.OperationUtils;

public abstract class OperationRunnableManager {

    protected final LocationService locationService = LocationService.getInstance();
    protected final ObjectInMemoryService objectInMemoryService = ObjectInMemoryService.getInstance();
    protected final OperationUtils operationUtils = OperationUtils.getInstance();

    protected Player player;
    protected World world;

    protected double x = 0;
    protected double y = 0;
    protected double z = 0;
    protected int counter = 0;
    protected int maxCounter = 0;
    protected boolean isPreparationRunning = false;
    protected boolean isExactProcessRunning = false;
    protected boolean isIterationDone = false;

    // make that value would be read from the config file
    protected final int callsQuantityForOneTick = 1;

    public OperationRunnableManager(Player player) throws IllegalArgumentException {
        setPlayerAndWorld(player);
    }

    public abstract void preparationToOneCircuit();
    public abstract void exactProcessToOneCircuit();

    public void startWholeProcess() {
        startPreparation();
    }

    public void endWholeProcess(BukkitRunnable runnable) {
        locationService.resetLocations();
        runnable.cancel();
    }

    public void printCompletionPercentOnScreen() {
        operationUtils.printCompletionPercentOnScreen(player, counter, maxCounter);
    }

    public void printDoneOnScreen() {
        operationUtils.printDoneOnScreen(player, counter, maxCounter);
    }

    public void printProcessingOnScreen() {
        operationUtils.printProcessingOnScreen(player);
    }

    public int getCallsQuantityForOneTick() {
        return callsQuantityForOneTick;
    }

    public boolean isPreparationRunning() {
        return isPreparationRunning;
    }

    public boolean isExactProcessRunning() {
        return isExactProcessRunning;
    }

    protected void stopExactProcess() {
        isExactProcessRunning = false;
    }

    private void startPreparation() {
        isIterationDone = false;
        isPreparationRunning = true;
    }

    protected void startExactProcess() {
        isIterationDone = false;
        isExactProcessRunning = true;
    }

    protected void stopPreparation() {
        isPreparationRunning = false;
    }

    private void setPlayerAndWorld(Player player) {
        this.player = player;
        this.world = player.getWorld();
    }
}
