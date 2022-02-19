package pl.adrian_komuda.manipulate_volume_object.runnables;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import pl.adrian_komuda.manipulate_volume_object.messages.ErrorMessages;
import pl.adrian_komuda.manipulate_volume_object.services.LocationService;
import pl.adrian_komuda.manipulate_volume_object.services.operations.ObjectInMemoryService;
import pl.adrian_komuda.manipulate_volume_object.services.operations.OperationUtils;

public class PasteRunnableManager extends GeneralRunnableManager {

    public PasteRunnableManager(Player player) throws IllegalArgumentException {
        super(player);
    }

    public void exactProcessToOneBlock() {
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
                    stopExactProcess();
                }
            }
        }
    }
}
