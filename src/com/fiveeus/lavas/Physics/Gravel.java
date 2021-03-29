package com.fiveeus.lavas.Physics;

import com.fiveeus.lavas.Events.PlayerBreak;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

public class Gravel implements Listener {

    @EventHandler
    public static void onFall(EntityChangeBlockEvent e) {
        if (e.getBlock().getType().equals(Material.GRAVEL)) {
            e.setCancelled(true);
            e.getBlock().getState().update(false, false);

            if (!(PlayerBreak.locations.contains(e.getBlock().getLocation()))) {
                PlayerBreak.locations.add(e.getBlock().getLocation());
                PlayerBreak.materials.add(Material.AIR);
            }
        }
    }
}
