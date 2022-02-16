package pl.adrian_komuda.manipulate_volume_object.services.operations;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import pl.adrian_komuda.manipulate_volume_object.messages.ErrorMessages;
import pl.adrian_komuda.manipulate_volume_object.services.LocationService;

public class CopyService {

    private final LocationService locationService = LocationService.getInstance();
    private final OperationUtils operationUtils = OperationUtils.getInstance();
    private final ObjectInMemoryService objectInMemoryService = ObjectInMemoryService.getInstance();
    private final CopyRunnableManager copyRunnableManager = CopyRunnableManager.getInstance();

    private Player player;
    private World world;
    private Vector absoluteStartingVector;
    private Vector absoluteEndingVector;
    private Vector pointingBlockVector;

    private Vector relativeVector;
    private double x = 0;
    private double y = 0;
    private double z = 0;
    private int counter = 0;
    private int maxCounter = 0;
    private boolean isProcessingRunning = false;
    private boolean isCopyingRunning = false;

    private final int callsQuantityForOneTick = 1;

    public CopyService(Player player) throws IllegalArgumentException {
        setPlayerAndWorld(player);
        setUpVectors();
        deleteObjectInMemory();
    }

    private void deleteObjectInMemory() {
        objectInMemoryService.clearObject();
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
                    stopProcessing();
                    startCopying();
                }
            }
        }
    }

    public void copyOneBlock() {
        counter++;

        pointingBlockVector = absoluteStartingVector.clone();
        relativeVector = new Vector(x, y, z);
        pointingBlockVector.add(relativeVector);

        Location tracedBlockLoc = new Location(world, pointingBlockVector.getX(), pointingBlockVector.getY(), pointingBlockVector.getZ());
        Material tracedBlockMat = world.getBlockAt(tracedBlockLoc).getType();

        objectInMemoryService.addBlock(relativeVector, tracedBlockMat);

        x++;

        if (x + absoluteStartingVector.getX() > absoluteEndingVector.getX()) {
            y++;
            x = 0;
            if (y + absoluteStartingVector.getY() > absoluteEndingVector.getY()) {
                z++;
                y = 0;
                if (z + absoluteStartingVector.getZ() > absoluteEndingVector.getZ()) {
                    z = 0;
                    stopCopying();
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

    public void setReady() {
        startProcessing();
    }

    public boolean isProcessingRunning() {
        return isProcessingRunning;
    }

    public boolean isCopyingRunning() {
        return isCopyingRunning;
    }

    private void startProcessing() {
        isProcessingRunning = true;
    }

    private void startCopying() {
        isCopyingRunning = true;
    }

    private void stopProcessing() {
        isProcessingRunning = false;
    }

    private void stopCopying() {
        isCopyingRunning = false;
    }

    public int getCallsQuantityForOneTick() {
        return callsQuantityForOneTick;
    }

    public void startCopyRunnable() {
        copyRunnableManager.startCopyRunnable(this);
    }

    public void endProcess() {
        locationService.resetLocations();
    }

    public void abortProcess() {
        printAbortedOnScreen();
        copyRunnableManager.abortProcess();
    }

    private void printAbortedOnScreen() {
        operationUtils.printAbortedOnScreen(player);
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
}