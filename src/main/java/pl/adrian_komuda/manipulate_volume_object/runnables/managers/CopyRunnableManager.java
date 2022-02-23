package pl.adrian_komuda.manipulate_volume_object.runnables.managers;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import pl.adrian_komuda.manipulate_volume_object.messages.ErrorMessages;

public class CopyRunnableManager extends OperationRunnableManager {

    private Vector absoluteStartingVector;
    private Vector absoluteEndingVector;

    public CopyRunnableManager(Player player) throws IllegalArgumentException {
        super(player);
        setUpVectors();
        deleteObjectInMemory();
    }

    @Override
    public void preparationToOneCircuit() {
        countOneBlock();

        if (isIterationDone) {
            stopPreparation();
            startExactProcess();
        }
    }

    @Override
    public void exactProcessToOneCircuit() {
        copyOneBlock();

        if (isIterationDone) {
            stopExactProcess();
        }
    }

    private void countOneBlock() {
        maxCounter++;
        moveCoordinates();
    }

    private void copyOneBlock() {
        counter++;

        var relativeVector = new Vector(x, y, z);
        Material copiedBlockMat = getMaterial(relativeVector);
        objectInMemoryService.addBlockToCopiedObject(relativeVector, copiedBlockMat);

        moveCoordinates();
    }

    private Material getMaterial(Vector relativeVector) {
        Vector pointingBlockVector = absoluteStartingVector.clone();
        pointingBlockVector.add(relativeVector);
        Location copiedBlockLoc = new Location(world, pointingBlockVector.getX(), pointingBlockVector.getY(), pointingBlockVector.getZ());
        return world.getBlockAt(copiedBlockLoc).getType();
    }

    private void moveCoordinates() {
        x++;

        if (x + absoluteStartingVector.getX() > absoluteEndingVector.getX()) {
            y++;
            x = 0;
            if (y + absoluteStartingVector.getY() > absoluteEndingVector.getY()) {
                z++;
                y = 0;
                if (z + absoluteStartingVector.getZ() > absoluteEndingVector.getZ()) {
                    z = 0;
                    isIterationDone = true;
                }
            }
        }
    }

    private void setUpVectors() throws IllegalArgumentException {
        if (!locationService.areLocationsSet()) {
            throw new IllegalArgumentException(ErrorMessages.LOCATIONS_NOT_SET.getMessage());
        }
        Location location1 = locationService.getLocation1();
        Location location2 = locationService.getLocation2();
        this.absoluteStartingVector = Vector.getMinimum(location1.toVector(), location2.toVector());
        this.absoluteEndingVector = Vector.getMaximum(location1.toVector(), location2.toVector());
    }

    private void deleteObjectInMemory() {
        objectInMemoryService.clearObject();
    }
}
