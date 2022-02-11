package pl.adrian_komuda.manipulate_volume_object.listeners;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import pl.adrian_komuda.manipulate_volume_object.items.ItemStackItems;
import pl.adrian_komuda.manipulate_volume_object.items.Marker;

import java.util.Objects;

public class MarkLocationListener implements Listener {

    private final Marker marker = ItemStackItems.getItemStackItems().getMarker();

    @EventHandler
    public void markLocation(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
        if (event.hasBlock() &&
                event.getAction() == Action.RIGHT_CLICK_BLOCK &&
                event.getHand().equals(EquipmentSlot.HAND) && // If the event is fired by HAND (main hand)
                marker.doesItMarker(itemInMainHand)) {
            Location clickedLocation = Objects.requireNonNull(event.getClickedBlock()).getLocation();

            String answer = marker.markLocation(clickedLocation);
            player.sendMessage(answer);
        }
    }
}
