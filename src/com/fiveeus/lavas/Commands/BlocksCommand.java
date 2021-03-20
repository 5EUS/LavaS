package com.fiveeus.lavas.Commands;

import com.fiveeus.lavas.Inventories.Blocks;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BlocksCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (command.getName().equalsIgnoreCase("blocks")) {
                Blocks gui = new Blocks();
                player.openInventory(gui.getInventory());
            }
        }
        return true;
    }
}
