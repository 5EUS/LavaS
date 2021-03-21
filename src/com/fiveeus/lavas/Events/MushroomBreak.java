package com.fiveeus.lavas.Events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;

import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPhysicsEvent;

public class MushroomBreak implements Listener {

    @EventHandler
    public static void onBreak(BlockPhysicsEvent e) { // laggy
        if (e.getBlock().getType().equals(Material.RED_MUSHROOM) || e.getBlock().getType().equals(Material.BROWN_MUSHROOM)) {
            e.setCancelled(true);

        }
    }
}