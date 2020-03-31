package me.alexisevelyn.bugreport5650;

import org.bukkit.plugin.java.JavaPlugin;

public final class Bugreport5650 extends JavaPlugin {
    PlayerInteraction playerInteraction;

    @Override
    public void onEnable() {
        // Plugin startup logic
        playerInteraction = new PlayerInteraction(this);

        getServer().getPluginManager().registerEvents(playerInteraction, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
