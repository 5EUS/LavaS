package com.fiveeus.lavas.Physics;

import com.fiveeus.lavas.GameMode.ResetBlocks;
import com.fiveeus.lavas.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.Bukkit.getServer;


public class Lava implements Listener {

    public static List<Location> locations = new ArrayList<>();
    public static List<Material> materials = new ArrayList<>();
    public static Plugin plugin = Main.getPluginInstance();



    @EventHandler
    public static void onFlow(BlockFromToEvent e) {
        Plugin plugin = Main.getPluginInstance();
        Block block = e.getBlock();
        if (plugin.getConfig().getBoolean("physics.lava-physics")) {
            if (block.getType().equals(Material.LAVA)) {
                if (!(ResetBlocks.resetting)) {
                    Block tar;

                    if (locations.size() == 0) {
                        locations.add(block.getLocation());
                        materials.add(Material.AIR);
                    }

                    BlockFace[] blockFaces = {
                            BlockFace.NORTH,
                            BlockFace.SOUTH,
                            BlockFace.EAST,
                            BlockFace.WEST,
                            BlockFace.DOWN
                    };

                    for (int i = 0; i < blockFaces.length; i++) {
                        if (!(block.getRelative(blockFaces[i]).getType().equals(Material.LAVA))
                                && !(block.getRelative(blockFaces[i]).getType().equals(Material.BEDROCK))
                                && !(block.getRelative(blockFaces[i]).getType().equals(Material.BARRIER))) {

                            tar = block.getRelative(blockFaces[i]);
                            if (!(locations.contains(tar.getLocation()))) {
                                locations.add(tar.getLocation());
                                materials.add(tar.getType());
                            }
                            getFlowCollisions(tar);


                        }

                    }

                }
            }
        }
        e.setCancelled(true);
    }

    private static void getFlowCollisions(Block block) {
        Material mat = block.getType();

        String caseString = mat.toString();

        Long coalDelay = 240L;

        switch (caseString) {
            case "AIR":
                block.setType(Material.LAVA);
                break;
            case "SAND":
                getServer().getScheduler().runTaskLater(plugin, new Runnable() {
                    @Override
                    public void run() {
                        block.setType(Material.GLASS);
                        getServer().getScheduler().runTaskLater(plugin, new Runnable() {
                            @Override
                            public void run() {
                                block.setType(Material.AIR);
                            }
                        }, 240);
                    }
                }, 240);

                break;
            case "STONE":
            case "COBBLESTONE":
            case "BRICK":
            case "SMOOTH_STONE_SLAB":
            case "MOSSY_COBBLESTONE":
                getServer().getScheduler().runTaskLater(plugin, new Runnable() {
                    @Override
                    public void run() {
                        block.setType(Material.COAL_ORE);
                        getServer().getScheduler().runTaskLater(plugin, new Runnable() {
                            @Override
                            public void run() {
                                block.setType(Material.AIR);
                            }
                        }, coalDelay);
                    }
                }, 2400);
                break;

            case "OAK_SAPPLING":
            case "DANDELION":
            case "POPPY":
            case "OAK_LEAVES":
            case "DIRT":
                getServer().getScheduler().runTaskLater(plugin, new Runnable() {
                    @Override
                    public void run() {
                        block.setType(Material.AIR);
                    }
                }, 60);
                break;

            case "OAK_PLANKS":
            case "OAK_LOG":
            case "RED_WOOL":
            case "ORANGE_WOOL":
            case "YELLOW_WOOL":
            case "LIME_WOOL":
            case "GREEN_WOOL":
            case "GREEN_CONCRETE":
            case "LIGHT_BLUE_WOOL":
            case "CYAN_WOOL":
            case "BLUE_WOOL":
            case "PURPLE_WOOL":
            case "MAGENTA_WOOL":
            case "PINK_WOOL":
            case "PINK_TERRACOTTA":
            case "GRAY_WOOL":
            case "LIGHT_GRAY_WOOL":
            case "WHITE_WOOL":
            case "GLASS":
                getServer().getScheduler().runTaskLater(plugin, new Runnable() {
                    @Override
                    public void run() {
                        block.setType(Material.COAL_ORE);
                        getServer().getScheduler().runTaskLater(plugin, new Runnable() {
                            @Override
                            public void run() {
                                block.setType(Material.AIR);
                            }
                        }, coalDelay);
                    }
                }, 120);
                break;

            case "COAL_ORE":
            case "IRON_ORE":
            case "GOLD_ORE":
                getServer().getScheduler().runTaskLater(plugin, new Runnable() {
                    @Override
                    public void run() {
                        block.setType(Material.AIR);
                    }
                }, coalDelay);
                break;

            case "IRON_BLOCK":
            case "GOLD_BLOCK":
                getServer().getScheduler().runTaskLater(plugin, new Runnable() {
                    @Override
                    public void run() {
                        block.setType(Material.COAL_ORE);
                        getServer().getScheduler().runTaskLater(plugin, new Runnable() {
                            @Override
                            public void run() {
                                block.setType(Material.AIR);

                            }
                        }, coalDelay);
                    }
                }, 4800);
               break;
            case "GRAVEL":
            case "SPONGE":
                getServer().getScheduler().runTaskLater(plugin, new Runnable() {
                    @Override
                    public void run() {
                        block.setType(Material.COAL_ORE);
                        getServer().getScheduler().runTaskLater(plugin, new Runnable() {
                            @Override
                            public void run() {
                                block.setType(Material.AIR);

                            }
                        }, coalDelay);
                    }
                }, 90);
                break;

            case "TNT":
                block.setType(Material.AIR);
                block.getWorld().spawnEntity(block.getLocation(), EntityType.PRIMED_TNT);
                break;

        }
    }
}
