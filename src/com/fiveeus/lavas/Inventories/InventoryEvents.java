package com.fiveeus.lavas.Inventories;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryEvents implements Listener {

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equals("§aBlocks")) {
            Player player = (Player) e.getWhoClicked();
            ItemMeta meta  = e.getCurrentItem().getItemMeta();
            if (meta.hasDisplayName()) {
                e.setCancelled(true);
                Material mat = e.getCurrentItem().getType();
                player.performCommand("shop " + mat);
            }
        }
    }
}
