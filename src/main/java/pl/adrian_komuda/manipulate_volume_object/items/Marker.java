package pl.adrian_komuda.manipulate_volume_object.items;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.adrian_komuda.manipulate_volume_object.TestFlags;
import pl.adrian_komuda.manipulate_volume_object.messages.MessagesWith0Params;

import java.util.List;
import java.util.Objects;

public class Marker {

    private final Material itemMaterial = MarkerObjectData.itemMaterial;
    private final String itemName = MarkerObjectData.itemName;
    private ItemStack item;
    private final List<String> itemLore = MarkerObjectData.itemLore;

    Marker() {
        createItemStack();
    }

    public void dropItemNearPlayer(Player player) {
        World world = player.getWorld();
        Location location = player.getLocation();
        world.dropItemNaturally(location, item);
        player.sendMessage(MessagesWith0Params.ITEM_DROPPED_NEAR_PLAYER.getMessage());
    }

    public void addItemToInventory(Player player) {
        player.getInventory().addItem(item);
        player.sendMessage(MessagesWith0Params.ITEM_ADDED_TO_INVENTORY.getMessage());
    }

    public boolean doesItMarker(ItemStack item) {
        return item.getType().equals(itemMaterial) &&
                Objects.requireNonNull(item.getItemMeta()).getDisplayName().contains(itemName) &&
                item.getItemMeta().hasLore() &&
                Objects.equals(item.getItemMeta().getLore(), itemLore);
    }

    public ItemStack getItem() {
        return item;
    }

    private void createItemStack() {

        if (!TestFlags.UNIT_TEST_FLAG) {
            item = new ItemStack(itemMaterial);
            ItemMeta meta = Objects.requireNonNull(item.getItemMeta());
            meta.setDisplayName(itemName);
            meta.setLore(itemLore);
            meta.setUnbreakable(true);
            item.setItemMeta(meta);
        }
    }
}
