package me.alexisevelyn.bugreport5650;

import org.bukkit.block.BlockState;
import org.bukkit.block.Lectern;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;

public class PlayerInteraction implements Listener {
    Bugreport5650 main;

    public PlayerInteraction(Bugreport5650 main) {
        this.main = main;
    }

    @EventHandler
    public void interactWithLectern(PlayerInteractEvent event) {
        // TODO: Make Tracker Register If Book Is Put in Lectern In Same Event
        // Register Lectern With Plugin if Special Lectern

        if (event.getAction() != Action.RIGHT_CLICK_BLOCK)
            return;

        BlockState snapshot;

        try {
            snapshot = Objects.requireNonNull(event.getClickedBlock()).getState();
        } catch (NullPointerException exception) {
            main.getLogger().warning("InteractWithLectern: No Block Was Clicked!!!");
            return;
        }

        if (snapshot instanceof Lectern) {
            Lectern lectern = (Lectern) snapshot;

            main.getLogger().info("Current Page: " + lectern.getPage());

            main.getLogger().info("Setting Page: 3");

            try {
                // This is the problematic code!!!
                // NOTE: Make sure you have a book in the lectern first. This code doesn't validate that as it's a simple reproduction project!!!
                lectern.setPage(3);
            } catch (NullPointerException exception) {
                main.getLogger().severe("setPage(int) NullPointerException: " + exception.getMessage());

                exception.printStackTrace();
            }
        }
    }
}
