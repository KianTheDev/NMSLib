package me.thekian.rpg;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import me.thekian.util.Util;

import me.thekian.data.Mobs.CMob;

public class Shops 
{
	Util util = new Util();
	
	public void createShopOne(Inventory inv, Player p)
	{
		util.storeAddItem(new ItemStack(Material.LEATHER_CHESTPLATE), ChatColor.GRAY + "Flak Jacket", new String[] {"20 credits.", "5% defense.", "Level 1"}, inv, 10);
		util.storeAddItem(new ItemStack(Material.WOOD_HOE), ChatColor.GRAY + ".20 Pistol", new String[] {"20 credits.", "2 damage.", "Level 1"}, inv, 12);
		util.storeAddItem(new ItemStack(Material.LEATHER_HELMET), ChatColor.GRAY + "Gas Mask", new String[] {"20 credits.", "1% defense.", "Level 1"}, inv, 14);
		util.storeAddItem(new ItemStack(Material.STONE_SWORD), ChatColor.GRAY + "Combat Knife", new String[] {"20 credits.", "2 damage.", "Level 1"}, inv, 16);
		util.storeAddItem(new ItemStack(Material.GOLD_HOE), ChatColor.GRAY + "Laspistol", new String[] {"40 credits.", "3 damage.", "Level 2"}, inv, 28);
		util.storeAddItem(new ItemStack(Material.WOOD_AXE), ChatColor.GRAY + "Rifle", new String[] {"60 credits.", "4 damage.", "Level 2"}, inv, 30);
		util.storeAddItem(new ItemStack(Material.DIAMOND_HOE), ChatColor.GRAY + ".50 Rifle", new String[] {"80 credits.", "8 damage.", "Level 3"}, inv, 32);
		util.storeAddItem(new ItemStack(Material.GOLD_HOE), ChatColor.GRAY + "Plasma Pistol", new String[] {"120 credits.", "10 damage.", "Level 5"}, inv, 34);
		util.storeAddItem(new ItemStack(Material.GOLD_HOE), ChatColor.GRAY + "Particle Pistol", new String[] {"150 credits.", "8 damage.", "Level 6"}, inv, 47);
		util.storeAddItem(new ItemStack(Material.GOLD_AXE), ChatColor.GRAY + "Plasma Rifle", new String[] {"200 credits.", "22 damage.", "Level 8"}, inv, 49);
		util.storeAddItem(new ItemStack(Material.DIAMOND_AXE), ChatColor.GRAY + "Particle Rifle", new String[] {"300 credits.", "18 damage.", "Level 9"}, inv, 51);
		p.openInventory(inv);
	}
	
	public void createShopTwo(Inventory inv, Player p)
	{
		util.storeAddItem(new ItemStack(Material.FIREBALL), ChatColor.BLUE + "Radial Bomb", new String[] {"50 credits.", "6 block range.", "Ignites and damages enemies.", "Level 1"}, inv, 10);
		util.storeAddItem(new ItemStack(Material.EXP_BOTTLE), ChatColor.BLUE + "Regenerative Enzymes", new String[] {"100 credits.", "Removes harmful effects.", "Level 1"}, inv, 12);
		util.storeAddItem(new ItemStack(Material.EYE_OF_ENDER), ChatColor.BLUE + "Explosive Grenade", new String[] {"30 credits.", "5 damage.", "Level 1"}, inv, 14);
		util.storeAddItem(new ItemStack(Material.EXP_BOTTLE), ChatColor.BLUE + "Knockout Gas", new String[] {"20 credits.", "Applies slow for 3 seconds.", "Level 1"}, inv, 16);
		p.openInventory(inv);
	}
}
