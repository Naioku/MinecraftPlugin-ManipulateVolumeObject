package pl.adrian_komuda.manipulate_volume_object.runnables.managers;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import pl.adrian_komuda.manipulate_volume_object.messages.ErrorMessages;

public class DeleteRunnableManager extends OperationRunnableManager {

    protected Vector absoluteStartingVector;
    private Vector absoluteEndingVector;

    public DeleteRunnableManager(Player player) throws IllegalArgumentException {
        super(player);
        setUpVectors();
    }

    @Override
    public void preparationToOneCircuit() {
        countOneBlock();
    }

    @Override
    public void exactProcessToOneCircuit() {
        deleteOneBlock();
    }

    private void countOneBlock() {
        maxCounter++;
        moveCoordinates();
        if (isIterationDone) {
            stopPreparation();
            startExactProcess();
        }
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

    private void deleteOneBlock() {
        counter++;

        Vector relativeVector = new Vector(x, y, z);
        deleteBlockAtLocationPointedByRelativeVector(relativeVector);

        moveCoordinates();
        if (isIterationDone) {
            stopExactProcess();
        }
    }

    private void deleteBlockAtLocationPointedByRelativeVector(Vector relativeVector) {
        Location location =  absoluteStartingVector.clone().add(relativeVector).toLocation(world);
        world.getBlockAt(location).setType(Material.AIR);
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
}
