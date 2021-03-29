package com.fiveeus.lavas.Commands;

import com.fiveeus.lavas.Main;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class Shop implements CommandExecutor {


    private final Plugin plugin = Main.getPluginInstance();
    private final String prefix = plugin.getConfig().getString("prefix");
    private final Economy eco = Main.getEconomy();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("player cool");
            return true;
        }
        Player player = (Player) sender;

        if(command.getName().equalsIgnoreCase("shop")) {
            if (args.length == 1) {
                Inventory inv = player.getInventory();
                try {
                    Material mat = Material.valueOf(args[0]);
                    if (!(mat.equals(Material.BROWN_MUSHROOM))
                            && !(mat.equals(Material.RED_MUSHROOM))
                            && !(mat.equals(Material.BOOKSHELF))
                            && !(mat.equals(Material.TNT))
                            && !(mat.equals(Material.OBSIDIAN))
                            && !(mat.equals(Material.WATER_BUCKET))
                            && !(mat.equals(Material.LAVA_BUCKET))
                            && !(mat.equals(Material.GOLDEN_HELMET))
                            && !(mat.equals(Material.IRON_BLOCK))) {

                        player.getInventory().addItem(new ItemStack(mat, 1));

                    } else {
                        if (mat.equals(Material.BROWN_MUSHROOM)) {
                            buyItem(player, mat, 50.0, 5);
                        } else if (mat.equals(Material.BROWN_MUSHROOM)) {
                            buyItem(player, mat, 50.0, 5);
                        } else if (mat.equals(Material.BOOKSHELF)) {
                            buyItem(player, mat, 100.0, 5);
                        } else if (mat.equals(Material.TNT)) {
                            buyItem(player, mat, 100.0, 5);
                        } else if (mat.equals(Material.OBSIDIAN)) {
                            buyItem(player, mat, 100.0, 5);
                        } else if (mat.equals(Material.WATER_BUCKET)) {
                            buyItem(player, mat, 100.0, 1);
                        } else if (mat.equals(Material.LAVA_BUCKET)) {
                            buyItem(player, mat, 10000.0, 1);
                        } else if (mat.equals(Material.GOLDEN_HELMET)) {
                            buyItem(player, mat, 10000.0, 1);
                        } else if (mat.equals(Material.IRON_BLOCK)) {
                            buyItem(player, mat, 10.0, 3);
                        }

                    }

                } catch (Exception exception) {
                    player.sendMessage(prefix + " §7Something went wrong.");
                }
            } else {
                player.sendMessage(prefix + " §7Please enter a subcommand.");
            }
        }
        return true;
    }

    public void buyItem(Player player, Material mat, double price, int amount) {
        if (eco.has(player, price)) {
            eco.withdrawPlayer(player, price);
            player.sendMessage("§c-$" + price);
            player.getInventory().addItem(new ItemStack(mat, amount));

        } else {
            player.sendMessage(prefix + " §7You don't have enough money!");
            player.closeInventory();

        }

    }
}
