package pl.adrian_komuda.manipulate_volume_object.commands.player.particular_commands;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pl.adrian_komuda.manipulate_volume_object.items.ItemStackItems;
import pl.adrian_komuda.manipulate_volume_object.commands.PlayerCommandsPerformers;
import pl.adrian_komuda.manipulate_volume_object.items.Marker;
import pl.adrian_komuda.manipulate_volume_object.messages.MessagesWith0Params;

import java.util.List;

public class GetMarker implements PlayerCommandsPerformers {

    private final Marker marker = ItemStackItems.getItemStackItems().getMarker();

    @Override
    public void perform(Player player, String command, List<String> args) {
        if (!doesPlayerAlreadyHaveItem(player, marker.getItem())) {
            if (isInventoryFull(player)) {
                marker.dropItemNearPlayer(player);
            } else {
                marker.addItemToInventory(player);
            }
        } else {
            player.sendMessage(MessagesWith0Params.ALREADY_HAVE_ITEM_IN_INVENTORY.getMessage());
        }
    }

    private boolean isInventoryFull(Player player) {
        return player.getInventory().firstEmpty() == -1;
    }

    private boolean doesPlayerAlreadyHaveItem(Player player, ItemStack item) {
        return player.getInventory().first(item) != -1;
    }
}
