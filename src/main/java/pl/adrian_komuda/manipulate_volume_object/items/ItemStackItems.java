package pl.adrian_komuda.manipulate_volume_object.items;

public class ItemStackItems {

    private static ItemStackItems instance;

    private final Marker marker = new Marker();

    private ItemStackItems() {}

    public static ItemStackItems getInstance() {
        if (ItemStackItems.instance == null) {
            ItemStackItems.instance = new ItemStackItems();
        }
        return instance;
    }

    public Marker getMarker() {
        return marker;
    }
}
