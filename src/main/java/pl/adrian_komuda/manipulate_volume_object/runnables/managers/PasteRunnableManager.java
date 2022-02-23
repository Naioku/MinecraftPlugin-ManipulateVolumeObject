package pl.adrian_komuda.manipulate_volume_object.runnables.managers;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import pl.adrian_komuda.manipulate_volume_object.messages.ErrorMessages;
import pl.adrian_komuda.manipulate_volume_object.services.memory_services.HistoryService;

import java.util.Map;

public class PasteRunnableManager extends OperationRunnableManager {

    protected Vector absoluteStartingVector;
    private HistoryService historyService = HistoryService.getInstance();

    public PasteRunnableManager(Player player) throws IllegalArgumentException {
        super(player);
        setUpVector();
    }

    @Override
    public void preparationToOneCircuit() {
        maxCounter = objectInMemoryService.getSize();
        stopPreparation();
        startExactProcess();
    }

    @Override
    public void exactProcessToOneCircuit() {
        copyOneBlockToHistory();
        pasteOneBlock();
        counter++;
    }

    private void copyOneBlockToHistory() {
        Map.Entry<Vector, Material> entry = objectInMemoryService.getEntry(counter);
        Vector relativeVector = entry.getKey().clone();
        Vector absoluteVector = absoluteStartingVector.clone().add(relativeVector.add(new Vector (0, 1, 0)));
        Material copiedBlockMat = getMaterial(absoluteVector);

        historyService.addBlockToSavingSlot(absoluteVector, copiedBlockMat);

        if (counter == maxCounter - 1) {
            historyService.saveObjectInHistory();
        }
    }

    private Material getMaterial(Vector vector) {
        Location copiedBlockLoc = new Location(world, vector.getX(), vector.getY(), vector.getZ());
        return world.getBlockAt(copiedBlockLoc).getType();
    }

    private void pasteOneBlock() {
        Map.Entry<Vector, Material> entry = objectInMemoryService.getEntry(counter);
        Vector relativeVector = entry.getKey().clone();
        relativeVector.add(new Vector(0, 1, 0)); // To paste block one level up from the marked block.
        Material material = entry.getValue();

        Location location = getLocationOfPastedBlock(relativeVector);
        pasteBlockInWorld(material, location);

        if (counter == maxCounter - 1) {
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
