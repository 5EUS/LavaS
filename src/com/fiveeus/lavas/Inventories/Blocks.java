package com.fiveeus.lavas.Inventories;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;
import java.util.List;

public class Blocks implements InventoryHolder {

    public final Inventory inv;

    public Blocks() {
        inv = Bukkit.createInventory(this, 45, "§aBlocks");
        setItems();

    }

    private void setItems() {
        formatItem("§7Stone", Material.STONE, Collections.singletonList("§aFREE"), 0);
        formatItem("§7Cobblestone", Material.COBBLESTONE, Collections.singletonList("§aFREE"), 1);
        formatItem("§7Bricks", Material.BRICKS, Collections.singletonList("§aFREE"), 2);
        formatItem("§7Dirt", Material.DIRT, Collections.singletonList("§aFREE"), 3);
        formatItem("§7Oak Planks", Material.OAK_PLANKS, Collections.singletonList("§aFREE"), 4);
        formatItem("§7Oak Log", Material.OAK_LOG, Collections.singletonList("§aFREE"), 5);
        formatItem("§7Oak Leaves", Material.OAK_LEAVES, Collections.singletonList("§aFREE"), 6);
        formatItem("§7Glass", Material.GLASS, Collections.singletonList("§aFREE"), 7);
        formatItem("§7Smooth Stone Slab", Material.SMOOTH_STONE_SLAB, Collections.singletonList("§aFREE"), 8);
        formatItem("§7Mossy Cobblestone", Material.MOSSY_COBBLESTONE, Collections.singletonList("§aFREE"), 9);
        formatItem("§7Oak Sappling", Material.OAK_SAPLING, Collections.singletonList("§aFREE"), 10);
        formatItem("§7Dandelion", Material.DANDELION, Collections.singletonList("§aFREE"), 11);
        formatItem("§7Poppy", Material.POPPY, Collections.singletonList("§aFREE"), 12);
        formatItem("§7Brown Mushroom", Material.BROWN_MUSHROOM, Collections.singletonList("§a$50/5"), 13);
        formatItem("§7Red Mushroom", Material.RED_MUSHROOM, Collections.singletonList("§a$50/5"), 14);
        formatItem("§7Sand", Material.SAND, Collections.singletonList("§aFREE"), 15);
        formatItem("§7Gravel", Material.GRAVEL, Collections.singletonList("§aFREE"), 16);
        formatItem("§7Sponge", Material.SPONGE, Collections.singletonList("§aFREE"), 17);
        formatItem("§7Red Wool", Material.RED_WOOL, Collections.singletonList("§aFREE"), 18);
        formatItem("§7Orange Wool", Material.ORANGE_WOOL, Collections.singletonList("§aFREE"), 19);
        formatItem("§7Yellow Wool", Material.YELLOW_WOOL, Collections.singletonList("§aFREE"), 20);
        formatItem("§7Lime Wool", Material.LIME_WOOL, Collections.singletonList("§aFREE"), 21);
        formatItem("§7Green Wool", Material.GREEN_WOOL, Collections.singletonList("§aFREE"), 22);
        formatItem("§7Green Concrete", Material.GREEN_CONCRETE, Collections.singletonList("§aFREE"), 23);
        formatItem("§7Light Blue Wool", Material.LIGHT_BLUE_WOOL, Collections.singletonList("§aFREE"), 24);
        formatItem("§7Cyan Wool", Material.CYAN_WOOL, Collections.singletonList("§aFREE"), 25);
        formatItem("§7Blue Wool", Material.BLUE_WOOL, Collections.singletonList("§aFREE"), 26);
        formatItem("§7Purple Wool", Material.PURPLE_WOOL, Collections.singletonList("§aFREE"), 27);
        formatItem("§7Magenta Wool", Material.MAGENTA_WOOL, Collections.singletonList("§aFREE"), 28);
        formatItem("§7Pink Wool", Material.PINK_WOOL, Collections.singletonList("§aFREE"), 29);
        formatItem("§7Pink Terracotta", Material.PINK_TERRACOTTA, Collections.singletonList("§aFREE"), 30);
        formatItem("§7Gray Wool", Material.GRAY_WOOL, Collections.singletonList("§aFREE"), 31);
        formatItem("§7Light Gray Wool", Material.LIGHT_GRAY_WOOL, Collections.singletonList("§aFREE"), 32);
        formatItem("§7White Wool", Material.WHITE_WOOL, Collections.singletonList("§aFREE"), 33);
        formatItem("§7Coal Ore", Material.COAL_ORE, Collections.singletonList("§aFREE"), 34);
        formatItem("§7Iron Ore", Material.IRON_ORE, Collections.singletonList("§aFREE"), 35);
        formatItem("§7Gold Ore", Material.GOLD_ORE, Collections.singletonList("§aFREE"), 36);
        formatItem("§7Iron Block (Door)", Material.IRON_BLOCK, Collections.singletonList("§a$10/3"), 37);
        formatItem("§7Gold Block", Material.GOLD_BLOCK, Collections.singletonList("§aFREE"), 38);
        formatItem("§7Bookshelf", Material.BOOKSHELF, Collections.singletonList("§a$100/5"), 39);
        formatItem("§7TNT", Material.TNT, Collections.singletonList("§a$100/5"), 40);
        formatItem("§7Obsidian", Material.OBSIDIAN, Collections.singletonList("§a$100/5"), 41);
        formatItem("§7Water Bucket", Material.WATER_BUCKET, Collections.singletonList("§a$100/1"), 42);
        formatItem("§7Lava Bucket", Material.LAVA_BUCKET, Collections.singletonList("§a$10000/1"), 43);
        formatItem("§7Brain Holder", Material.GOLDEN_HELMET, Collections.singletonList("§a$10000/1"), 44);



    }

    public void formatItem(String name, Material mat, List<String> lore, int slot) {
        ItemStack item;
        item = createItem(name, mat, lore);
        inv.setItem(slot, item);

    }

    private ItemStack createItem(String name, Material mat, List<String> lore) {
        ItemStack item = new ItemStack(mat,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }
}
