package com.fiveeus.lavas.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;


public class Explosion implements Listener {


    @EventHandler
    public static void onExplode(BlockExplodeEvent e) {
        PlayerBreak.locations.add(e.getBlock().getLocation());
        PlayerBreak.materials.add(e.getBlock().getType());

    }
}