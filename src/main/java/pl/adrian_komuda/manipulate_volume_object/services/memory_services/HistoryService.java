package pl.adrian_komuda.manipulate_volume_object.services.memory_services;

import org.bukkit.Material;
import org.bukkit.util.Vector;
import pl.adrian_komuda.manipulate_volume_object.messages.ErrorMessages;

import java.util.EmptyStackException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class HistoryService {

    private static HistoryService instance;

    final Stack<LinkedHashMap<Vector, Material>> history = new Stack<>();
    LinkedHashMap<Vector, Material> savingSlot = new LinkedHashMap<>();
    LinkedHashMap<Vector, Material> loadingSlot;

    HistoryService() {}

    public static HistoryService getInstance() {
        if (instance == null) {
            instance = new HistoryService();
        }
        return instance;
    }

    public void addBlockToSavingSlot(Vector vector, Material material) {
        savingSlot.put(vector, material);
    }

    public void saveObjectInHistory() {
        if (savingSlot.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.SAVING_SLOT_EMPTY.getMessage());
        }
        history.push(savingSlot);
        savingSlot = new LinkedHashMap<>();
    }

    public void loadLastObjectFromHistory() throws IllegalStateException {
        try {
            loadingSlot = history.pop();
        } catch (EmptyStackException e) {
            throw new IllegalStateException(ErrorMessages.HISTORY_EMPTY.getMessage());
        }
    }

    public Map.Entry<Vector, Material> getEntryFromLoadingSlot(int index) {
        if (loadingSlot == null) {
            throw new IllegalStateException(ErrorMessages.LOADING_SLOT_EMPTY.getMessage());
        }
        return loadingSlot.entrySet().stream().toList().get(index);
    }

    public int getSizeOfLastLoadedObjectFromHistory() {
        if (loadingSlot == null) {
            throw new IllegalStateException(ErrorMessages.LOADING_SLOT_EMPTY.getMessage());
        }
        return loadingSlot.size();
    }

    public Stack<LinkedHashMap<Vector, Material>> getHistory() {
        return history;
    }

    public LinkedHashMap<Vector, Material> getSavingSlot() {
        return savingSlot;
    }

    public LinkedHashMap<Vector, Material> getLoadingSlot() {
        return loadingSlot;
    }
}
