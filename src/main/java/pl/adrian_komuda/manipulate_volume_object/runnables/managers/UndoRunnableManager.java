package pl.adrian_komuda.manipulate_volume_object.runnables.managers;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import pl.adrian_komuda.manipulate_volume_object.messages.ErrorMessages;
import pl.adrian_komuda.manipulate_volume_object.services.memory_services.HistoryService;

import java.util.Map;

public class UndoRunnableManager extends OperationRunnableManager {

    private final HistoryService historyService = HistoryService.getInstance();

    public UndoRunnableManager(Player player) throws IllegalArgumentException {
        super(player);
    }

    @Override
    public void preparationToOneCircuit() {
        maxCounter = historyService.getSizeOfLastLoadedObjectFromHistory();
        stopPreparation();
        startExactProcess();
    }

    @Override
    public void exactProcessToOneCircuit() {
        undoOneBlock();
        counter++;
    }

    private void undoOneBlock() {
        Map.Entry<Vector, Material> entry = historyService.getEntryFromLoadingSlot(counter);
        Vector absoluteVector = entry.getKey().clone();
        Location location = absoluteVector.toLocation(world);
        Material material = entry.getValue();

        pasteBlockInWorld(material, location);

        if (counter == maxCounter - 1) {
            stopExactProcess();
        }
    }

    private void pasteBlockInWorld(Material material, Location location) {
        world.getBlockAt(location).setType(material);
    }
}
