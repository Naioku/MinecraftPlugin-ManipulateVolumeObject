package pl.adrian_komuda.manipulate_volume_object.commands.player.particular_commands;

import org.bukkit.entity.Player;
import pl.adrian_komuda.manipulate_volume_object.commands.PlayerCommandsPerformers;
import pl.adrian_komuda.manipulate_volume_object.items.ItemStackItems;
import pl.adrian_komuda.manipulate_volume_object.items.Marker;
import pl.adrian_komuda.manipulate_volume_object.services.LocationService;

import java.util.List;

public class PrintLocations implements PlayerCommandsPerformers {

    @Override
    public void perform(Player player, String command, List<String> args) {
        var locationService = LocationService.getInstance();
        player.sendMessage(locationService.getLocationsAsMessage());
    }
}
