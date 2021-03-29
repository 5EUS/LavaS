package com.fiveeus.lavas.Events;

import com.fiveeus.lavas.Commands.LavaS;
import com.fiveeus.lavas.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class PlayerBreak implements Listener {

    public static List<Location> locations = new ArrayList<>();
    public static List<Material> materials = new ArrayList<>();

    @EventHandler
    public static void onPlace(BlockBreakEvent e) {
        Plugin plugin = Main.getPluginInstance();
        String permission = plugin.getConfig().getString("admin-permission");

        Player player = e.getPlayer();

        e.setDropItems(false);

        if (!(player.hasPermission(permission))) {
            if (!(locations.contains(e.getBlock().getLocation()))) {
                locations.add(e.getBlock().getLocation());
                materials.add(e.getBlock().getType());
            }

        } else if (!(LavaS.build)) {
            if (!(locations.contains(e.getBlock().getLocation()))) {
                locations.add(e.getBlock().getLocation());
                materials.add(e.getBlock().getType());
            }
        }

    }
}
