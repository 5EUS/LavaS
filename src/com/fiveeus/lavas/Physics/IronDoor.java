package com.fiveeus.lavas.Physics;

import com.fiveeus.lavas.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;

import java.util.Arrays;

import static org.bukkit.Bukkit.getServer;

public class IronDoor implements Listener {

    @EventHandler
    public static void onDamage(BlockDamageEvent e) {
        if (e.getBlock().getType().equals(Material.IRON_BLOCK)) {
            Block block = e.getBlock();
            World world = e.getBlock().getWorld();


            // Implement owner system here


            getBlocks(block);


        }

        if (!(e.getBlock().getType().equals(Material.BEDROCK))
                && !(e.getBlock().getType().equals(Material.BARRIER))) {

            e.setInstaBreak(true);
        }





    }
    private static void getBlocks(Block block) {

        if (block.getRelative(BlockFace.NORTH).getType().equals(Material.IRON_BLOCK)) {
            block.setType(Material.AIR);
            getServer().getScheduler().scheduleSyncDelayedTask(Main.getPluginInstance(), new Runnable() {
                public void run() {
                    block.setType(Material.IRON_BLOCK);
                }
            }, 20L);
            getBlocks(block.getRelative(BlockFace.NORTH));
        }
        if (block.getType().equals(Material.IRON_BLOCK)) {
            block.setType(Material.AIR);
            getServer().getScheduler().scheduleSyncDelayedTask(Main.getPluginInstance(), new Runnable() {
                public void run() {
                    block.setType(Material.IRON_BLOCK);
                }
            }, 20L);
        }

        if (block.getRelative(BlockFace.SOUTH).getType().equals(Material.IRON_BLOCK)) {
            block.setType(Material.AIR);
            getServer().getScheduler().scheduleSyncDelayedTask(Main.getPluginInstance(), new Runnable() {
                public void run() {
                    block.setType(Material.IRON_BLOCK);
                }
            }, 20L);
            getBlocks(block.getRelative(BlockFace.SOUTH));
        }
        if (block.getType().equals(Material.IRON_BLOCK)) {
            block.setType(Material.AIR);
            getServer().getScheduler().scheduleSyncDelayedTask(Main.getPluginInstance(), new Runnable() {
                public void run() {
                    block.setType(Material.IRON_BLOCK);
                }
            }, 20L);
        }

        if (block.getRelative(BlockFace.EAST).getType().equals(Material.IRON_BLOCK)) {
            block.setType(Material.AIR);
            getServer().getScheduler().scheduleSyncDelayedTask(Main.getPluginInstance(), new Runnable() {
                public void run() {
                    block.setType(Material.IRON_BLOCK);
                }
            }, 20L);
            getBlocks(block.getRelative(BlockFace.EAST));
        }
        if (block.getType().equals(Material.IRON_BLOCK)) {
            block.setType(Material.AIR);
            getServer().getScheduler().scheduleSyncDelayedTask(Main.getPluginInstance(), new Runnable() {
                public void run() {
                    block.setType(Material.IRON_BLOCK);
                }
            }, 20L);
        }

        if (block.getRelative(BlockFace.WEST).getType().equals(Material.IRON_BLOCK)) {
            block.setType(Material.AIR);
            getServer().getScheduler().scheduleSyncDelayedTask(Main.getPluginInstance(), new Runnable() {
                public void run() {
                    block.setType(Material.IRON_BLOCK);
                }
            }, 20L);
            getBlocks(block.getRelative(BlockFace.WEST));
        }
        if (block.getType().equals(Material.IRON_BLOCK)) {
            block.setType(Material.AIR);
            getServer().getScheduler().scheduleSyncDelayedTask(Main.getPluginInstance(), new Runnable() {
                public void run() {
                    block.setType(Material.IRON_BLOCK);
                }
            }, 20L);
        }

        if (block.getRelative(BlockFace.UP).getType().equals(Material.IRON_BLOCK)) {
            block.setType(Material.AIR);
            getServer().getScheduler().scheduleSyncDelayedTask(Main.getPluginInstance(), new Runnable() {
                public void run() {
                    block.setType(Material.IRON_BLOCK);
                }
            }, 20L);
            getBlocks(block.getRelative(BlockFace.UP));
        }
        if (block.getType().equals(Material.IRON_BLOCK)) {
            block.setType(Material.AIR);
            getServer().getScheduler().scheduleSyncDelayedTask(Main.getPluginInstance(), new Runnable() {
                public void run() {
                    block.setType(Material.IRON_BLOCK);
                }
            }, 20L);
        }

        if (block.getRelative(BlockFace.DOWN).getType().equals(Material.IRON_BLOCK)) {
            block.setType(Material.AIR);
            getServer().getScheduler().scheduleSyncDelayedTask(Main.getPluginInstance(), new Runnable() {
                public void run() {
                    block.setType(Material.IRON_BLOCK);
                }
            }, 20L);
            getBlocks(block.getRelative(BlockFace.DOWN));
        }
        if (block.getType().equals(Material.IRON_BLOCK)) {
            block.setType(Material.AIR);
            getServer().getScheduler().scheduleSyncDelayedTask(Main.getPluginInstance(), new Runnable() {
                public void run() {
                    block.setType(Material.IRON_BLOCK);
                }
            }, 20L);
        }
    }

}
