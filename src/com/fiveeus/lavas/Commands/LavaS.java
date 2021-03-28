package com.fiveeus.lavas.Commands;

import com.fiveeus.lavas.GameMode.GameManager;
import com.fiveeus.lavas.Main;
import com.fiveeus.lavas.Physics.Lava;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import static com.fiveeus.lavas.GameMode.ResetBlocks.resetBlocks;
import static org.bukkit.Bukkit.getServer;

public class LavaS implements CommandExecutor {

    private final Plugin plugin = Main.getPluginInstance();
    private final String prefix = plugin.getConfig().getString("prefix");
    private final String permission = plugin.getConfig().getString("admin-permission");
    public static boolean build;

    private GameManager gameManager;



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (command.getName().equalsIgnoreCase("lavas")) {
                if (sender.hasPermission(permission)) {
                    if (args.length >= 1) {
                        if (args[0].equals("lava")) {

                            if (plugin.getConfig().getBoolean("physics.lava-physics")) {
                                plugin.getConfig().set("physics.lava-physics", false);
                                sender.sendMessage(prefix + " §7Disabled lava physics.");
                                plugin.saveConfig();

                            } else if (!(plugin.getConfig().getBoolean("physics.lava-physics"))) {
                                plugin.getConfig().set("physics.lava-physics", true);
                                sender.sendMessage(prefix + " §7Enabled lava physics.");
                                plugin.saveConfig();

                            } else {
                                sender.sendMessage("§c§lERROR §8> §7Invalid config.yml file.");

                            }
                        } else if (args[0].equals("water")) {
                            if (plugin.getConfig().getBoolean("physics.water-physics")) {
                                plugin.getConfig().set("physics.water-physics", false);
                                sender.sendMessage(prefix + " §7Disabled water physics.");
                                plugin.saveConfig();

                            } else if (!(plugin.getConfig().getBoolean("physics.water-physics"))) {
                                plugin.getConfig().set("physics.water-physics", true);
                                sender.sendMessage(prefix + " §7Enabled water physics.");
                                plugin.saveConfig();

                            } else {
                                sender.sendMessage("§c§lERROR §8> §7Invalid config.yml file.");
                                Main.resetPluginConfig();

                            }



                        } else if (args[0].equals("reset")) {
                            resetBlocks();

                        } else if (args[0].equals("list")) {

                            for (int i = 0; i < Lava.locations.size(); i++) {
                                Location loc = Lava.locations.get(i);
                                double x = loc.getX();
                                double y = loc.getY();
                                double z = loc.getZ();


                                Material mat = Lava.materials.get(i);
                                sender.sendMessage(x + " " + y + " " + z + " " + ": " + mat);

                                Location loc2 = Lava.locations.get(i);

                                double x2 = loc2.getX();
                                double y2 = loc2.getY();
                                double z2 = loc2.getZ();


                                Material mat2 = Lava.materials.get(i);
                                sender.sendMessage(x2 + " " + y2 + " " + z2 + " " + ": " + mat2);


                            }
                        }  else if (args[0].equals("build")) {
                            if (!(build)) {
                                build = true;
                                getServer().broadcastMessage(prefix + " §7Build mode has been enabled.");

                            } else {
                                build = false;
                                getServer().broadcastMessage(prefix + " §7Build mode has been disabled.");
                            }

                        }

                    }else {
                        sender.sendMessage(prefix + " §c§lLavaS Help Menu");
                        sender.sendMessage("§8/lavas §bDisplays the help menu");
                        sender.sendMessage("§8/lavas lava §bToggles lava physics");
                        sender.sendMessage("§8/lavas water §bToggles water physics");
                        sender.sendMessage("§8/lavas build §bToggles build mode for admins");
                    }

                } else {
                    sender.sendMessage(prefix + " §7You don't have permission.");
                }

            }

        }
        return true;
    }

}
