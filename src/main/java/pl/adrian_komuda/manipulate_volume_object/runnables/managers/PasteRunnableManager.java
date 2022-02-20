package pl.adrian_komuda.manipulate_volume_object.runnables.managers;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import pl.adrian_komuda.manipulate_volume_object.messages.ErrorMessages;

import java.util.Map;

public class PasteRunnableManager extends GeneralRunnableManager {

    protected Vector absoluteStartingVector;

    public PasteRunnableManager(Player player) throws IllegalArgumentException {
        super(player);
        setUpVector();
    }

    @Override
    public void preparationToOneCircuit() {
        maxCounter = objectInMemoryService.getSize() - 1;
        stopPreparation();
        startExactProcess();
    }

    @Override
    public void exactProcessToOneCircuit() {
        pasteOneBlock();
    }

    private void pasteOneBlock() {
        Map.Entry<Vector, Material> entry = objectInMemoryService.getEntry(counter);
        Vector relativeVector = entry.getKey();
        relativeVector.add(new Vector(0, 1, 0)); // To paste block one level up from the marked block.
        Material material = entry.getValue();

        Location location = getLocationOfPastedBlock(relativeVector);
        pasteBlockInWorld(material, location);

        counter++;

        if (counter > maxCounter) {
            stopExactProcess();
        }
    }

    private Location getLocationOfPastedBlock(Vector relativeVector) {
        return absoluteStartingVector.clone().add(relativeVector).toLocation(world);
    }

    private void pasteBlockInWorld(Material material, Location location) {
        world.getBlockAt(location).setType(material);
    }

    private void setUpVector() throws IllegalArgumentException {
        if (!locationService.isLocation1Set()) {
            throw new IllegalArgumentException(ErrorMessages.LOCATION1_NOT_SET.getMessage());
        }
        this.absoluteStartingVector = locationService.getLocation1().toVector();
    }
}
