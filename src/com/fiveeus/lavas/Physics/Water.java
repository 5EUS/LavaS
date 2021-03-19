package com.fiveeus.lavas.Physics;

import com.fiveeus.lavas.Main;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.plugin.Plugin;

public class Water implements Listener {

    @EventHandler
    public static void onFlow(BlockFromToEvent e) {
        Plugin plugin = Main.getPluginInstance();
        World world = e.getBlock().getWorld();
        Block block = e.getBlock();
        if (block.getType().equals(Material.WATER)) {
            if (!(plugin.getConfig().getBoolean("physics.water-physics"))) {
                e.setCancelled(true);
            }
        }
    }
}
