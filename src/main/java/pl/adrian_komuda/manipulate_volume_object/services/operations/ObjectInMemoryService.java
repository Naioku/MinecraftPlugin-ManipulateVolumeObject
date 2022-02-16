package pl.adrian_komuda.manipulate_volume_object.services.operations;

import org.bukkit.Material;
import org.bukkit.util.Vector;

import java.util.LinkedHashMap;

public class ObjectInMemoryService {

    private static ObjectInMemoryService instance;
    private final LinkedHashMap<Vector, Material> objectInMemory = new LinkedHashMap<>();

    private ObjectInMemoryService() {}

    public static ObjectInMemoryService getInstance() {
        if (instance == null) {
            instance = new ObjectInMemoryService();
        }
        return instance;
    }

    public void addBlock(Vector vector, Material material) {
        objectInMemory.put(vector, material);
    }

    public void clearObject() {
        objectInMemory.clear();
    }

    public String getObjectAsString() {
        return objectInMemory.toString();
    }
}
