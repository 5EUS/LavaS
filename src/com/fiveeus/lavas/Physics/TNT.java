package com.fiveeus.lavas.Physics;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockExplodeEvent;

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
    public static void onExplode(BlockExplodeEvent e) {

        Bukkit.broadcastMessage("dsfhfdgsh");
        e.setCancelled(true);
    }

}
