package pl.adrian_komuda.manipulate_volume_object;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import pl.adrian_komuda.manipulate_volume_object.commands.AllCommandsData;
import pl.adrian_komuda.manipulate_volume_object.commands.MinecraftCommandsReceiver;
import pl.adrian_komuda.manipulate_volume_object.listeners.MarkLocationListener;

public class Main extends JavaPlugin {
    MinecraftCommandsReceiver commander;

    public static Plugin getInstance() {
        return Bukkit.getPluginManager().getPlugin("ManipulateVolumeObject");
    }

    @Override
    public void onEnable() {
        super.onEnable();
        setUpCommands();
        setUpListeners();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    private void setUpCommands() {
        commander = new MinecraftCommandsReceiver(this);
        getCommand(AllCommandsData.commandPrefix).setExecutor(commander);
    }

    private void setUpListeners() {
        this.getServer().getPluginManager().registerEvents(new MarkLocationListener(), this);
    }
}
