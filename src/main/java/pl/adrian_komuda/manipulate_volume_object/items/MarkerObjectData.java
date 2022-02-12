package pl.adrian_komuda.manipulate_volume_object.items;

import org.bukkit.Material;
import pl.adrian_komuda.manipulate_volume_object.PluginColors;

import java.util.Arrays;
import java.util.List;

public class MarkerObjectData {

    public static Material itemMaterial = Material.GOLDEN_AXE;
    public static String itemName = PluginColors.ITEM_HEADERS.getColor() + "Manipulate Volume Obj Marker";
    public static List<String> itemLore = Arrays.asList(
            PluginColors.DESCRIPTIONS.getColor() + "Mark first block and last",
            PluginColors.DESCRIPTIONS.getColor() + "of the diagonal of Your object."
    );
}
