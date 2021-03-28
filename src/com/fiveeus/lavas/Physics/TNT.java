package com.fiveeus.lavas.Physics;

import com.fiveeus.lavas.Events.PlayerBreak;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

public class TNT implements Listener {

    @EventHandler
    public static void onBreak(BlockBreakEvent e) {
        if (e.getBlock().getType().equals(Material.TNT)) {
            e.setCancelled(true);
            e.getBlock().setType(Material.AIR);
            e.getBlock().getWorld().spawnEntity(e.getBlock().getLocation(), EntityType.PRIMED_TNT);

        }
    }

    @EventHandler
    public static void onExplode(EntityExplodeEvent e) {
        for (Block block : e.blockList()) {
            if (!(PlayerBreak.locations.contains(block.getLocation()))) {
                PlayerBreak.locations.add(block.getLocation());
                PlayerBreak.materials.add(block.getType());
            }
        }
    }

}
