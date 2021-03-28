package com.fiveeus.lavas.Events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.List;

public class PlaceOnMushroom implements Listener {


    @EventHandler
    public static void onPlace(PlayerInteractEvent e) {

        List<Location> locations = PlayerBreak.locations;
        List<Material> materials = PlayerBreak.materials;

        Material block = e.getPlayer().getInventory().getItemInMainHand().getType();
        Block against = e.getClickedBlock();
        boolean b = block.equals(Material.RED_MUSHROOM) || block.equals(Material.BROWN_MUSHROOM);
        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (against.getType().equals(Material.RED_MUSHROOM) || against.getType().equals(Material.BROWN_MUSHROOM)) {
                if (against.getRelative(BlockFace.UP).getType().equals(Material.AIR)) {

                    if (b) {
                        int amount = e.getPlayer().getInventory().getItemInMainHand().getAmount();
                        e.getClickedBlock().setType(against.getType());
                        e.getPlayer().getInventory().getItemInMainHand().setAmount(amount - 1);
                        against.getRelative(BlockFace.UP).setType(block);

                        locations.add(against.getRelative(BlockFace.UP).getLocation());
                        materials.add(Material.AIR);

                    }
                }
            }

            if (e.getClickedBlock().getRelative(BlockFace.UP).getType().equals(Material.AIR)) {
                if (b) {
                    int amount = e.getPlayer().getInventory().getItemInMainHand().getAmount();
                    e.getPlayer().getInventory().getItemInMainHand().setAmount(amount - 1);
                    against.getRelative(BlockFace.UP).setType(block);

                    locations.add(against.getRelative(BlockFace.UP).getLocation());
                    materials.add(Material.AIR);

                }
            }
        }
    }
}
