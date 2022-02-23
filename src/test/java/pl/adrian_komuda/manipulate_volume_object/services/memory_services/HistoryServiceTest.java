package pl.adrian_komuda.manipulate_volume_object.services.memory_services;

import org.bukkit.Material;
import org.bukkit.util.Vector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.adrian_komuda.manipulate_volume_object.TestTemplate;
import pl.adrian_komuda.manipulate_volume_object.messages.ErrorMessages;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HistoryServiceTest extends TestTemplate {

    private HistoryService historyService;

    @BeforeEach
    void setUp() {
        historyService = new HistoryService();
    }

    @Test
    void afterAddBlockToSavingSlotCallBlockShouldBeAddedToSavingSlot() {
        // given
        var vector = new Vector(0, 0, 0);
        var material = Material.AIR;

        // when
        historyService.addBlockToSavingSlot(vector, material);

        // then
        assertThat(historyService.savingSlot.size()).isEqualTo(1);
    }

    @Test
    void afterSaveObjectInHistoryCallWhenSavingSlotIsNotEmptyObjectShouldBeAddedToHistory() {
        // given
        var vector = new Vector(0, 0, 0);
        var material = Material.AIR;
        LinkedHashMap<Vector, Material> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(vector, material);

        // when
        historyService.addBlockToSavingSlot(vector, material);
        historyService.saveObjectInHistory();

        // then
        assertThat(historyService.history.size()).isEqualTo(1);
        assertThat(historyService.history.pop()).isEqualTo(linkedHashMap);
    }

    @Test
    void afterSaveObjectInHistoryCallWhenSavingSlotIsEmptyIllegalArgumentExceptionShouldBeThrownWithProperMessage() {
        // given
        // when
        // then
        String message = assertThrows(IllegalArgumentException.class, () -> historyService.saveObjectInHistory()).getMessage();
        assertThat(message).isEqualTo(ErrorMessages.SAVING_SLOT_EMPTY.getMessage());
    }

    @Test
    void afterLoadLastObjectFromHistoryCallWhenHistoryIsNotEmptyLoadingSlotShouldHaveLastlyAddedObject() {
        // given
        var vector1 = new Vector(0, 0, 0);
        var material1 = Material.AIR;

        var vector2 = new Vector(1, 0, 0);
        var material2 = Material.BRICK;
        LinkedHashMap<Vector, Material> properLastAddedLinkedHashMap = new LinkedHashMap<>();
        properLastAddedLinkedHashMap.put(vector2, material2);


        // when
        historyService.addBlockToSavingSlot(vector1, material1);
        historyService.saveObjectInHistory();
        historyService.addBlockToSavingSlot(vector2, material2);
        historyService.saveObjectInHistory();
        historyService.loadLastObjectFromHistory();

        // then
        LinkedHashMap<Vector, Material> resultLastAddedLinkedHashMap = historyService.loadingSlot;
        assertThat(resultLastAddedLinkedHashMap).isEqualTo(properLastAddedLinkedHashMap);
    }

    @Test
    void afterLoadLastObjectFromHistoryCallWhenHistoryIsEmptyIllegalStateExceptionShouldBeThrownWithProperMessage() {
        // given
        // when
        // then
        String message = assertThrows(IllegalStateException.class, () -> historyService.loadLastObjectFromHistory()).getMessage();
        assertThat(message).isEqualTo(ErrorMessages.HISTORY_EMPTY.getMessage());
    }

    @Test
    void afterGetEntryFromLoadingSlotCallWhenLoadingSlotIsNotNullProperEntrySetShouldBeReturned() {
        // given
        var vector = new Vector(0, 0, 0);
        var material = Material.AIR;

        // when
        historyService.addBlockToSavingSlot(vector, material);
        historyService.saveObjectInHistory();
        historyService.loadLastObjectFromHistory();
        Map.Entry<Vector, Material> resultEntry = historyService.getEntryFromLoadingSlot(0);

        // then
        assertThat(resultEntry.getKey()).isEqualTo(vector);
        assertThat(resultEntry.getValue()).isEqualTo(material);
    }

    @Test
    void afterGetEntryFromLoadingSlotCallWhenLoadingSlotIsNullIllegalStateExceptionShouldBeThrownWithProperMessage() {
        // given
        // when
        // then
        String message = assertThrows(IllegalStateException.class, () -> historyService.getEntryFromLoadingSlot(0)).getMessage();
        assertThat(message).isEqualTo(ErrorMessages.LOADING_SLOT_EMPTY.getMessage());
    }
}