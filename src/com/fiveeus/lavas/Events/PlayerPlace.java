package com.fiveeus.lavas.Events;


import com.fiveeus.lavas.Commands.LavaS;
import com.fiveeus.lavas.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.Plugin;


public class PlayerPlace implements Listener {


    @EventHandler
    public static void onPlace(BlockPlaceEvent e) {



        Plugin plugin = Main.getPluginInstance();
        String permission = plugin.getConfig().getString("admin-permission");

        Player player = e.getPlayer();


        if (!(player.hasPermission(permission))) {
            if (!(PlayerBreak.locations.contains(e.getBlock().getLocation()))) {
                PlayerBreak.locations.add(e.getBlock().getLocation());
                PlayerBreak.materials.add(Material.AIR);
            }

        } else if (!(LavaS.build)) {
            if (!(PlayerBreak.locations.contains(e.getBlock().getLocation()))) {
                PlayerBreak.locations.add(e.getBlock().getLocation());
                PlayerBreak.materials.add(Material.AIR);
            }
        }


    }

}
