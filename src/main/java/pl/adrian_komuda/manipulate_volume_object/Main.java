package pl.adrian_komuda.manipulate_volume_object;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import pl.adrian_komuda.manipulate_volume_object.commands.AllCommandsData;
import pl.adrian_komuda.manipulate_volume_object.commands.command_and_players.AllPlayerAndConsoleCommands;
import pl.adrian_komuda.manipulate_volume_object.commands.player.AllPlayerCommands;
import pl.adrian_komuda.manipulate_volume_object.commands.MinecraftCommandsReceiver;

public class Main extends JavaPlugin {
    MinecraftCommandsReceiver commander;

    public static Plugin getMain() {
        return Bukkit.getPluginManager().getPlugin("ManipulateVolumeObject");
    }

    @Override
    public void onEnable() {
        super.onEnable();
        setUpCommands();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    private void setUpCommands() {
        commander = new MinecraftCommandsReceiver(this);
        getCommand(AllCommandsData.commandPrefix).setExecutor(commander);
    }
}
