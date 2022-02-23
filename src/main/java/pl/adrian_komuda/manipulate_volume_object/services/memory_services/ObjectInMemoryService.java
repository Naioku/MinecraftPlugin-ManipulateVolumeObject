package pl.adrian_komuda.manipulate_volume_object.services.memory_services;

import org.bukkit.Material;
import org.bukkit.util.Vector;

import java.util.LinkedHashMap;
import java.util.Map;

public class ObjectInMemoryService {

    private static ObjectInMemoryService instance;
    final LinkedHashMap<Vector, Material> copiedObjectInMemory = new LinkedHashMap<>();

    ObjectInMemoryService() {}

    public static ObjectInMemoryService getInstance() {
        if (instance == null) {
            instance = new ObjectInMemoryService();
        }
        return instance;
    }

    public void addBlockToCopiedObject(Vector vector, Material material) {
        copiedObjectInMemory.put(vector, material);
    }

    public void clearObject() {
        copiedObjectInMemory.clear();
    }

    public String getObjectAsString() {
        return copiedObjectInMemory.toString();
    }

    public boolean isCopiedObjectNotEmpty() {
        return !copiedObjectInMemory.isEmpty();
    }

    public int getSize() {
        return copiedObjectInMemory.size();
    }

    public Map.Entry<Vector, Material> getEntry(int index) {
        return copiedObjectInMemory.entrySet().stream().toList().get(index);
    }
}
