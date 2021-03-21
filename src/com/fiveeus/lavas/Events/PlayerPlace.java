package com.fiveeus.lavas.Events;


import com.fiveeus.lavas.Commands.LavaS;
import com.fiveeus.lavas.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class PlayerPlace implements Listener {


    @EventHandler
    public static void onPlace(BlockPlaceEvent e) {
        List<Location> locations = PlayerBreak.locations;
        List<Material> materials = PlayerBreak.materials;

        Plugin plugin = Main.getPluginInstance();
        String permission = plugin.getConfig().getString("base-permission");

        Player player = e.getPlayer();


        if (!(player.hasPermission(permission))) {
            if (!(locations.contains(e.getBlock().getLocation()))) {
                locations.add(e.getBlock().getLocation());
                materials.add(Material.AIR);
            }

        } else if (!(LavaS.build)) {
            locations.add(e.getBlock().getLocation());
            materials.add(e.getBlock().getType());
        }


    }

}
