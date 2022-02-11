package pl.adrian_komuda.manipulate_volume_object.items;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.adrian_komuda.manipulate_volume_object.MarkerObjectData;
import pl.adrian_komuda.manipulate_volume_object.messages.MessagesWith0Params;
import pl.adrian_komuda.manipulate_volume_object.messages.MessagesWith2Params;

import java.util.List;
import java.util.Objects;

public class Marker {

    private final Material itemMaterial = MarkerObjectData.itemMaterial;
    private final String itemName = MarkerObjectData.itemName;
    private ItemStack item;
    private final List<String> itemLore = MarkerObjectData.itemLore;

    private Location location1;
    private Location location2;

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

    public String markLocation(Location location) {
        if (location1 == null || location2 != null) {
            location2 = null;
            location1 = location;
            return MessagesWith0Params.LOCATION1_SET.getMessage();
        } else {
            location2 = location;
            return MessagesWith0Params.LOCATION2_SET.getMessage();
        }
    }

    public ItemStack getItem() {
        return item;
    }

    public String getLocations() {
        return MessagesWith2Params.LOCATIONS.getMessage(String.valueOf(location1), String.valueOf(location2));
    }

    private void createItemStack() {

        item = new ItemStack(itemMaterial);
        ItemMeta meta = Objects.requireNonNull(item.getItemMeta());
        meta.setDisplayName(itemName);
        meta.setLore(itemLore);
        meta.setUnbreakable(true);
        item.setItemMeta(meta);
    }
}
