package com.fiveeus.lavas.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;


public class Craft implements Listener {


    @EventHandler
    public static void onCraft(CraftItemEvent e) {
        e.setCancelled(true);
    }
}
