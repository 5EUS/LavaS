package com.fiveeus.lavas;

import com.fiveeus.lavas.Commands.BlocksCommand;
import com.fiveeus.lavas.Commands.LavaS;
import com.fiveeus.lavas.Commands.Shop;
import com.fiveeus.lavas.Events.*;
import com.fiveeus.lavas.Inventories.InventoryEvents;
import com.fiveeus.lavas.Physics.*;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.plugin.RegisteredServiceProvider;


import java.io.File;
import java.io.IOException;

public class Main extends JavaPlugin {

    private static final Logger log = Logger.getLogger("Minecraft");
    private static Economy econ = null;
    private static Permission perms = null;
    private static Chat chat = null;

    private static Plugin plugin;
    public static File customConfigFile;
    private static FileConfiguration customConfig;

    @Override
    public void onEnable() {

        if (!setupEconomy() ) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }


        plugin = this;
        createCustomConfig();
        getServer().getConsoleSender().sendMessage("§c[LavaS] " + "§7Enabled LavaS v0.1");
        this.getServer().getPluginManager().registerEvents(new Lava(), this);
        this.getServer().getPluginManager().registerEvents(new Water(), this);
        this.getServer().getPluginManager().registerEvents(new InventoryEvents(), this);
        this.getServer().getPluginManager().registerEvents(new TNT(), this);
        this.getServer().getPluginManager().registerEvents(new IronDoor(), this);
        this.getServer().getPluginManager().registerEvents(new Gravel(), this);
        this.getServer().getPluginManager().registerEvents(new Sand(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerPlace(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerBreak(), this);
        this.getServer().getPluginManager().registerEvents(new Craft(), this);
        this.getServer().getPluginManager().registerEvents(new FormBlock(), this);
        this.getServer().getPluginManager().registerEvents(new Explosion(), this);
        this.getServer().getPluginManager().registerEvents(new PlaceOnMushroom(), this);
        this.getServer().getPluginManager().registerEvents(new MushroomBreak(), this);
        this.getCommand("lavas").setExecutor(new LavaS());
        this.getCommand("blocks").setExecutor(new BlocksCommand());
        this.getCommand("shop").setExecutor(new Shop());

    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("§c[LavaS] " + "§7Disabled LavaS v0.1");

    }

    public FileConfiguration getCustomConfig() {
        return customConfig;
    }


    private void createCustomConfig() {
        customConfigFile = new File(getDataFolder(), "config.yml");
        if (!(customConfigFile.exists())) {
            customConfigFile.getParentFile().mkdirs();
            saveResource("config.yml", false);
        }

        customConfig = new YamlConfiguration();
        try {
            customConfig.load(customConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static void resetPluginConfig() {
        // nuclear
        customConfig = new YamlConfiguration();
        try {
            customConfig.load(customConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

    }

    public static Plugin getPluginInstance() {
        return plugin;
    }


    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }


    public static Economy getEconomy() {
        return econ;
    }

    public static Permission getPermissions() {
        return perms;
    }

    public static Chat getChat() {
        return chat;
    }

}
