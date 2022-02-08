package pl.adrian_komuda.manipulate_volume_object;

import org.bukkit.plugin.java.JavaPlugin;
import pl.adrian_komuda.manipulate_volume_object.commands.Commands;

public class Main extends JavaPlugin {
    Commands commander;

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
        commander = new Commands(this);
        getCommand("command1").setExecutor(commander);
    }
}
