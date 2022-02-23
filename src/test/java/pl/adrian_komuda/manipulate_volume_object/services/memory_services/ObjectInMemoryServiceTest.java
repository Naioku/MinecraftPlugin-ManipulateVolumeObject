package pl.adrian_komuda.manipulate_volume_object.services.memory_services;

import org.bukkit.Material;
import org.bukkit.util.Vector;
import org.junit.jupiter.api.Test;
import pl.adrian_komuda.manipulate_volume_object.TestTemplate;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ObjectInMemoryServiceTest extends TestTemplate {

    @Test
    void afterAddBlockMethodObjectInMemorySizeShouldBe1() {
        // given
        var objectInMemoryService = new ObjectInMemoryService();
        Vector vector = new Vector(0, 0, 0);
        Material material = Material.BRICK;

        // when
        objectInMemoryService.addBlockToCopiedObject(vector, material);

        // then
        assertThat(objectInMemoryService.getSize()).isEqualTo(1);
    }

    @Test
    void afterAddingSomeDataToMemoryGetEntryShouldReturnProperEntry() {
        // given
        var objectInMemoryService = new ObjectInMemoryService();
        Vector vector = new Vector(0, 0, 0);
        Material material = Material.BRICK;

        objectInMemoryService.addBlockToCopiedObject(vector, material);

        // when
        Map.Entry<Vector, Material> entry = objectInMemoryService.getEntry(0);

        // then
        assertThat(entry.getKey()).isEqualTo(vector);
        assertThat(entry.getValue()).isEqualTo(material);
    }

    @Test
    void blocksFromMemoryShouldBeReturnedInPlacingOrder() {
        // given
        var objectInMemory = new ObjectInMemoryService();
        var vector1 = new Vector(0, 0, 0);
        var vector2 = new Vector(1, 1, 1);
        var vector3 = new Vector(2, 2, 2);
        var material1 = Material.BRICK;
        var material2 = Material.GRASS_BLOCK;
        var material3 = Material.GLOWSTONE;

        objectInMemory.addBlockToCopiedObject(vector1, material1);
        objectInMemory.addBlockToCopiedObject(vector2, material2);
        objectInMemory.addBlockToCopiedObject(vector3, material3);

        // when
        var result1 = objectInMemory.getEntry(0);
        var result2 = objectInMemory.getEntry(1);
        var result3 = objectInMemory.getEntry(2);

        // then
        assertThat(result1.getKey()).isEqualTo(vector1);
        assertThat(result1.getValue()).isEqualTo(material1);

        assertThat(result2.getKey()).isEqualTo(vector2);
        assertThat(result2.getValue()).isEqualTo(material2);

        assertThat(result3.getKey()).isEqualTo(vector3);
        assertThat(result3.getValue()).isEqualTo(material3);
    }
}