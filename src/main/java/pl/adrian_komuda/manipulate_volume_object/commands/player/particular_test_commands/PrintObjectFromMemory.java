package pl.adrian_komuda.manipulate_volume_object.commands.player.particular_test_commands;

import org.bukkit.entity.Player;
import pl.adrian_komuda.manipulate_volume_object.commands.PlayerCommandsPerformers;
import pl.adrian_komuda.manipulate_volume_object.services.object_in_memory_service.ObjectInMemoryService;

import java.util.List;

public class PrintObjectFromMemory implements PlayerCommandsPerformers {
    @Override
    public void perform(Player player, String command, List<String> args) {
        var objectInMemory = ObjectInMemoryService.getInstance();
        player.sendMessage(objectInMemory.getObjectAsString());
    }
}
