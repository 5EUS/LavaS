package com.fiveeus.lavas;

import com.fiveeus.lavas.Commands.LavaS;
import com.fiveeus.lavas.Physics.Lava;
import com.fiveeus.lavas.Physics.Water;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Main extends JavaPlugin {
    private static Plugin plugin;
    public static File customConfigFile;
    private static FileConfiguration customConfig;

    @Override
    public void onEnable() {
        plugin = this;
        createCustomConfig();
        getServer().getConsoleSender().sendMessage("§c[LavaS] " + "§7Enabled LavaS v0.1");
        this.getServer().getPluginManager().registerEvents(new Lava(), this);
        this.getServer().getPluginManager().registerEvents(new Water(), this);
        this.getCommand("lavas").setExecutor(new LavaS());
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("§c[LavaS] " + "§7Disabled LavaS v0.1");

    }

    public FileConfiguration getCustomConfig() {
        return this.customConfig;
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

}
