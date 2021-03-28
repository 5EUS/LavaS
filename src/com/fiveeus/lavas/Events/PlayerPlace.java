package com.fiveeus.lavas.Events;


import com.fiveeus.lavas.Commands.LavaS;
import com.fiveeus.lavas.GameMode.GameStartCountdownTask;
import com.fiveeus.lavas.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.Plugin;

import java.util.List;


public class PlayerPlace implements Listener {


    @EventHandler
    public static void onPlace(BlockPlaceEvent e) {


        Plugin plugin = Main.getPluginInstance();
        String permission = plugin.getConfig().getString("admin-permission");
        String prefix = plugin.getConfig().getString("prefix");

        Player player = e.getPlayer();
        String map = GameStartCountdownTask.selectedMap;
        try {
            World world = plugin.getServer().getWorld(plugin.getConfig().getString("world"));
            List<Double> spawn = plugin.getConfig().getDoubleList(map + ".lava");


            double X = spawn.get(0);
            double Y = spawn.get(1);
            double Z = spawn.get(2);

            double x = e.getBlock().getX();
            double y = e.getBlock().getY();
            double z = e.getBlock().getZ();

            if (x <= X + 3 && y <= Y + 3 && z <= Z + 3
                    && x >= X - 3 && y >= Y - 3 && z >= Z - 3) {
                if (!(player.hasPermission(permission))) {
                    e.setCancelled(true);
                    e.getPlayer().sendMessage(prefix + " §7You can't build here!");
                }

            }



        } catch (Exception exception) { }

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
