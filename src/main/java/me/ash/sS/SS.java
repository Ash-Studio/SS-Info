package me.ash.sS;

import me.ash.sS.commands.SSCommand;
import me.ash.sS.utils.GUIManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class SS extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register the command and its executor
        Objects.requireNonNull(this.getCommand("ss")).setExecutor(new SSCommand());

        // Register events
        getServer().getPluginManager().registerEvents(new GUIManager(), this);
    }

    @Override
    public void onDisable() {
        // Cleanup when the plugin is disabled (if needed)
    }
}
