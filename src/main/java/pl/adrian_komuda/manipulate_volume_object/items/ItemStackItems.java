package pl.adrian_komuda.manipulate_volume_object.items;

public class ItemStackItems {

    private static ItemStackItems itemStackItems;

    private final Marker marker = new Marker();

    private ItemStackItems() {}

    public static ItemStackItems getItemStackItems() {
        if (ItemStackItems.itemStackItems == null) {
            ItemStackItems.itemStackItems = new ItemStackItems();
        }
        return itemStackItems;
    }

    public Marker getMarker() {
        return marker;
    }
}
