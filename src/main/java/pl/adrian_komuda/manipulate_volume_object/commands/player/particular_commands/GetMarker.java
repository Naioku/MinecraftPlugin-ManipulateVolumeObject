package pl.adrian_komuda.manipulate_volume_object.commands.player.particular_commands;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pl.adrian_komuda.manipulate_volume_object.Marker;
import pl.adrian_komuda.manipulate_volume_object.commands.PlayerCommandsPerformers;
import pl.adrian_komuda.manipulate_volume_object.messages.Messages;

import java.util.List;

public class GetMarker implements PlayerCommandsPerformers {

    private final Marker marker = new Marker();

    @Override
    public void perform(Player player, String command, List<String> args) {
        player.sendMessage("Performing " + this.getClass().getSimpleName()); // all logic
        if (!doesPlayerAlreadyHaveItem(player, marker.getItem())) {
            if (isInventoryFull(player)) {
                marker.dropItemNearPlayer(player);
            } else {
                marker.addItemToInventory(player);
            }
        } else {
            player.sendMessage(Messages.ALREADY_HAVE_ITEM_IN_INVENTORY.getMessage());
        }
    }

    private boolean isInventoryFull(Player player) {
        return player.getInventory().firstEmpty() == -1;
    }

    private boolean doesPlayerAlreadyHaveItem(Player player, ItemStack item) {
        return player.getInventory().first(item) != -1;
    }
}
