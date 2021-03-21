package com.fiveeus.lavas.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;

public class FormBlock implements Listener {


    @EventHandler
    public static void onStoneForm(BlockFormEvent e) {
        e.setCancelled(true);
    }
}

