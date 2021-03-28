package com.fiveeus.lavas.Physics;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

public class Sand implements Listener {

    @EventHandler
    public static void onFall(EntityChangeBlockEvent e) {
        if (e.getBlock().getType().equals(Material.SAND)) {
            e.setCancelled(true);
            e.getBlock().getState().update(false, false);
        }
    }
}
