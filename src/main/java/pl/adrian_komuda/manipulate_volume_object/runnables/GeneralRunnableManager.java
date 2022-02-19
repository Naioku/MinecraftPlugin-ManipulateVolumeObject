package pl.adrian_komuda.manipulate_volume_object.runnables;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import pl.adrian_komuda.manipulate_volume_object.messages.ErrorMessages;
import pl.adrian_komuda.manipulate_volume_object.services.LocationService;
import pl.adrian_komuda.manipulate_volume_object.services.operations.ObjectInMemoryService;
import pl.adrian_komuda.manipulate_volume_object.services.operations.OperationUtils;

public abstract class GeneralRunnableManager {

    protected final LocationService locationService = LocationService.getInstance();
    protected final ObjectInMemoryService objectInMemoryService = ObjectInMemoryService.getInstance();
    protected final OperationUtils operationUtils = OperationUtils.getInstance();

    protected Player player;
    protected World world;
    protected Vector absoluteStartingVector;
    protected Vector absoluteEndingVector;
    protected Vector pointingBlockVector;

    protected Vector relativeVector;
    protected double x = 0;
    protected double y = 0;
    protected double z = 0;
    protected int counter = 0;
    protected int maxCounter = 0;
    protected boolean isPreparationRunning = false;
    protected boolean isExactProcessRunning = false;

    // make that value would be read from the config file
    protected final int callsQuantityForOneTick = 1;

    public GeneralRunnableManager(Player player) throws IllegalArgumentException {
        setPlayerAndWorld(player);
        setUpVectors();
        deleteObjectInMemory();
    }

    public abstract void exactProcessToOneBlock();

    public void startWholeProcess() {
        startPreparation();
    }

    public void endWholeProcess(BukkitRunnable runnable) {
        locationService.resetLocations();
        runnable.cancel();
    }

    public void countOneBlock() {
        maxCounter++;

        pointingBlockVector = absoluteStartingVector.clone();
        relativeVector = new Vector(x, y, z);
        pointingBlockVector.add(relativeVector);

        x++;

        if (x + absoluteStartingVector.getX() > absoluteEndingVector.getX()) {
            y++;
            x = 0;
            if (y + absoluteStartingVector.getY() > absoluteEndingVector.getY()) {
                z++;
                y = 0;
                if (z + absoluteStartingVector.getZ() > absoluteEndingVector.getZ()) {
                    z = 0;
                    stopPreparation();
                    startExactProcess();
                }
            }
        }
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
        isPreparationRunning = true;
    }

    private void startExactProcess() {
        isExactProcessRunning = true;
    }

    private void stopPreparation() {
        isPreparationRunning = false;
    }

    private void setPlayerAndWorld(Player player) {
        this.player = player;
        this.world = player.getWorld();
    }

    private void setUpVectors() throws IllegalArgumentException {
        if (!locationService.areLocationsSet()) {
            throw new IllegalArgumentException(ErrorMessages.LOCATIONS_NOT_SET.getMessage());
        }
        Location location1 = locationService.getLocation1();
        Location location2 = locationService.getLocation2();
        this.absoluteStartingVector = Vector.getMinimum(location1.toVector(), location2.toVector());
        this.absoluteEndingVector = Vector.getMaximum(location1.toVector(), location2.toVector());
        this.pointingBlockVector = absoluteStartingVector.clone();
    }

    private void deleteObjectInMemory() {
        objectInMemoryService.clearObject();
    }
}
