package pl.adrian_komuda.manipulate_volume_object.services.object_in_memory_service;

import org.bukkit.Material;
import org.bukkit.util.Vector;

import java.util.LinkedHashMap;
import java.util.Map;

public class ObjectInMemoryService {

    private static ObjectInMemoryService instance;
    private final LinkedHashMap<Vector, Material> objectInMemory = new LinkedHashMap<>();

    ObjectInMemoryService() {}

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

    public boolean isObjectInMemory() {
        return !objectInMemory.isEmpty();
    }

    public int getSize() {
        return objectInMemory.size();
    }

    public Map.Entry<Vector, Material> getEntry(int index) {
        return objectInMemory.entrySet().stream().toList().get(index);
    }
}
