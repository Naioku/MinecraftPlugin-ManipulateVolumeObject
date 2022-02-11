package pl.adrian_komuda.manipulate_volume_object;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.adrian_komuda.manipulate_volume_object.messages.Messages;

import java.util.List;

public class Marker {

    private final Material itemMaterial = MarkerObjectData.itemMaterial;
    private final String itemName = MarkerObjectData.itemName;
    private ItemStack item;
    private final List<String> itemLore = MarkerObjectData.itemLore;

    public Marker() {
        createItemStack();
    }

    public void dropItemNearPlayer(Player player) {
        World world = player.getWorld();
        Location location = player.getLocation();
        world.dropItemNaturally(location, item);
        player.sendMessage(Messages.ITEM_DROPPED_NEAR_PLAYER.getMessage());
    }

    public void addItemToInventory(Player player) {
        player.getInventory().addItem(item);
        player.sendMessage(Messages.ITEM_ADDED_TO_INVENTORY.getMessage());
    }

    public ItemStack getItem() {
        return item;
    }

    private void createItemStack() {

        item = new ItemStack(itemMaterial);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(itemName);

        meta.setLore(itemLore);

        meta.setUnbreakable(true);

        item.setItemMeta(meta);
    }
}
