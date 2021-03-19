package com.fiveeus.lavas.Physics;

import com.fiveeus.lavas.Main;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.plugin.Plugin;

public class Lava implements Listener {

    @EventHandler
    public static void onFlow(BlockFromToEvent e) {
        e.setCancelled(true);
        Plugin plugin = Main.getPluginInstance();
        World world = e.getBlock().getWorld();
        Block block = e.getBlock();

        if (block.getType().equals(Material.LAVA)) {
            if (plugin.getConfig().getBoolean("physics.lava-physics")) {

                int x = block.getX();
                int y = block.getY();
                int z = block.getZ();

                // im so sorry

                Block tar1 = world.getBlockAt(x, y, z - 1);
                Block tar2 = world.getBlockAt(x, y, z + 1);
                Block tar3 = world.getBlockAt(x - 1, y, z);
                Block tar4 = world.getBlockAt(x + 1, y, z);


                //block collision logic
                getBlockCollision(tar1, tar1.getType());
                getBlockCollision(tar2, tar2.getType());
                getBlockCollision(tar3, tar3.getType());
                getBlockCollision(tar4, tar4.getType());
            }
        }
    }

    private static void getBlockCollision(Block block, Material material) {
        if (block.getType() == Material.AIR) {
            block.setType(Material.LAVA);
        }

        if (block.getType() == Material.SAND) {
            block.setType(Material.LAVA);
        }

    }

}
