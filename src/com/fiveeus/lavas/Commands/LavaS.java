package com.fiveeus.lavas.Commands;

import com.fiveeus.lavas.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;


public class LavaS implements CommandExecutor {

    private Plugin plugin = Main.getPluginInstance();
    private String prefix = plugin.getConfig().getString("prefix");
    private String permission = plugin.getConfig().getString("base-permission");

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

                        } else {
                            sender.sendMessage(prefix + " §c§lLavaS Help Menu");
                            sender.sendMessage("§8/lavas §bDisplays the help menu");
                            sender.sendMessage("§8/lavas lava §bToggles lava physics");
                            sender.sendMessage("§8/lavas water §bToggles water physics");
                        }
                    }

                } else {
                    sender.sendMessage(prefix + " §7You don't have permission.");
                }

            }

        }
        return true;
    }
}
