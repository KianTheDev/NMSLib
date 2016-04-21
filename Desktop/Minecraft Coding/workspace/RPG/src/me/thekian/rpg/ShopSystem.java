package me.thekian.rpg;

import java.util.Arrays;

import me.thekian.data.Players.CPlayer;
import me.thekian.util.Util;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ShopSystem 
{
	
	Util util = new Util();
	
	public void ShopClick(Player p, ItemStack itemStack, Inventory inv, CPlayer cp)
	{
		if(itemStack.getItemMeta().getDisplayName().equals(ChatColor.GRAY + "Flak Jacket"))
		{
			if(cp.getCredits() < 20)
			{
				p.playSound(p.getLocation(), Sound.ENTITY_ITEM_BREAK, 1F, 1F);
			} else
			{
				cp.setCredits(cp.getCredits() - 20);
				p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 1F, 1F);
				util.makeAddItem(new ItemStack(Material.LEATHER_CHESTPLATE), ChatColor.GRAY + "Flak Jacket", new String[] {"5% defense.", "Level 1"}, p.getInventory(), true);
				p.closeInventory();
				p.sendMessage(ChatColor.BLUE + "Shop> " + ChatColor.GRAY + "You purchased Flak Jacket for 20 credits.");
			}
		}
		if(itemStack.getItemMeta().getDisplayName().equals(ChatColor.GRAY + ".20 Pistol"))
		{
			if(cp.getCredits() < 20)
			{
				p.playSound(p.getLocation(), Sound.ENTITY_ITEM_BREAK, 1F, 1F);
			}
			if(cp.getCredits() >= 20)
			{
				cp.setCredits(cp.getCredits() - 20);
				p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 1F, 1F);
				util.makeAddItem(new ItemStack(Material.WOOD_HOE), ChatColor.GRAY + ".20 Pistol", new String[] {"2 damage.", "Level 1"}, p.getInventory(), true);
				p.closeInventory();
				p.sendMessage(ChatColor.BLUE + "Shop> " + ChatColor.GRAY + "You purchased .20 Pistol for 20 credits.");
			}
		}
		if(itemStack.getItemMeta().getDisplayName().equals(ChatColor.GRAY + "Gas Mask"))
		{
			if(cp.getCredits() < 20)
			{
				p.playSound(p.getLocation(), Sound.ENTITY_ITEM_BREAK, 1F, 1F);
			}
			if(cp.getCredits() >= 20)
			{
				cp.setCredits(cp.getCredits() - 20);
				p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 1F, 1F);
				util.makeAddItem(new ItemStack(Material.LEATHER_HELMET), ChatColor.GRAY + "Gas Mask", new String[] {"1% defense.", "Level 1"}, p.getInventory(), true);
				p.closeInventory();
				p.sendMessage(ChatColor.BLUE + "Shop> " + ChatColor.GRAY + "You purchased Gas Mask for 20 credits.");
			}
		}
		if(itemStack.getItemMeta().getDisplayName().equals(ChatColor.GRAY + "Laspistol"))
		{
			if(cp.getCredits() < 40)
			{
				p.playSound(p.getLocation(), Sound.ENTITY_ITEM_BREAK, 1F, 1F);
			}
			if(cp.getCredits() >= 40)
			{
				cp.setCredits(cp.getCredits() - 40);
				p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 1F, 1F);
				util.makeAddItem(new ItemStack(Material.GOLD_HOE), ChatColor.GRAY + "Laspistol", new String[] {"3 damage.", "Level 2"}, p.getInventory(), true);
				p.closeInventory();
				p.sendMessage(ChatColor.BLUE + "Shop> " + ChatColor.GRAY + "You purchased Laspistol for 40 credits.");
			}
		}
		if(itemStack.getItemMeta().getDisplayName().equals(ChatColor.GRAY + "Combat Knife"))
		{
			if(cp.getCredits() < 20)
			{
				p.playSound(p.getLocation(), Sound.ENTITY_ITEM_BREAK, 1F, 1F);
			}
			if(cp.getCredits() >= 20)
			{
				cp.setCredits(cp.getCredits() - 20);
				p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 1F, 1F);
				util.makeAddItem(new ItemStack(Material.STONE_SWORD), ChatColor.GRAY + "Combat Knife", new String[] {"2 damage.", "Level 1"}, p.getInventory(), true);
				p.closeInventory();
				p.sendMessage(ChatColor.BLUE + "Shop> " + ChatColor.GRAY + "You purchased Combat Knife for 20 credits.");
			}
		}
		if(itemStack.getItemMeta().getDisplayName().equals(ChatColor.GRAY + "Rifle"))
		{
			if(cp.getCredits() < 60)
			{
				p.playSound(p.getLocation(), Sound.ENTITY_ITEM_BREAK, 1F, 1F);
			}
			if(cp.getCredits() >= 60)
			{
				cp.setCredits(cp.getCredits() - 60);
				p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 1F, 1F);
				util.makeAddItem(new ItemStack(Material.WOOD_AXE), ChatColor.GRAY + "Rifle", new String[] {"4 damage.", "Level 2"}, p.getInventory(), true);
				p.closeInventory();
				p.sendMessage(ChatColor.BLUE + "Shop> " + ChatColor.GRAY + "You purchased Rifle for 60 credits.");
			}
		}
		if(itemStack.getItemMeta().getDisplayName().equals(ChatColor.GRAY + ".50 Rifle"))
		{
			if(cp.getCredits() < 80)
			{
				p.playSound(p.getLocation(), Sound.ENTITY_ITEM_BREAK, 1F, 1F);
			}
			if(cp.getCredits() >= 80)
			{
				cp.setCredits(cp.getCredits() - 80);
				p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 1F, 1F);
				util.makeAddItem(new ItemStack(Material.DIAMOND_HOE), ChatColor.GRAY + ".50 Rifle", new String[] {"8 damage.", "Level 3"}, p.getInventory(), true);
				p.closeInventory();
				p.sendMessage(ChatColor.BLUE + "Shop> " + ChatColor.GRAY + "You purchased .50 Rifle for 80 credits.");
			}
		}
		if(itemStack.getItemMeta().getDisplayName().equals(ChatColor.GRAY + "Plasma Pistol"))
		{
			if(cp.getCredits() < 120)
			{
				p.playSound(p.getLocation(), Sound.ENTITY_ITEM_BREAK, 1F, 1F);
			}
			if(cp.getCredits() >= 120)
			{
				cp.setCredits(cp.getCredits() - 120);
				p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 1F, 1F);
				util.makeAddItem(new ItemStack(Material.GOLD_HOE), ChatColor.GRAY + "Plasma Pistol", new String[] {"10 damage.", "Level 5"}, p.getInventory(), true);
				p.closeInventory();
				p.sendMessage(ChatColor.BLUE + "Shop> " + ChatColor.GRAY + "You purchased Plasma Pistol for 120 credits.");
			}
		}
		if(itemStack.getItemMeta().getDisplayName().equals(ChatColor.GRAY + "Particle Pistol"))
		{
			if(cp.getCredits() < 150)
			{
				p.playSound(p.getLocation(), Sound.ENTITY_ITEM_BREAK, 1F, 1F);
			}
			if(cp.getCredits() >= 150)
			{
				cp.setCredits(cp.getCredits() - 150);
				p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 1F, 1F);
				util.makeAddItem(new ItemStack(Material.GOLD_HOE), ChatColor.GRAY + "Particle", new String[] {"8 damage.", "Level 6"}, p.getInventory(), true);
				p.closeInventory();
				p.sendMessage(ChatColor.BLUE + "Shop> " + ChatColor.GRAY + "You purchased Particle Pistol for 150 credits.");
			}
		}
		if(itemStack.getItemMeta().getDisplayName().equals(ChatColor.GRAY + "Plasma Rifle"))
		{
			if(cp.getCredits() < 200)
			{
				p.playSound(p.getLocation(), Sound.ENTITY_ITEM_BREAK, 1F, 1F);
			}
			if(cp.getCredits() >= 200)
			{
				cp.setCredits(cp.getCredits() - 200);
				p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 1F, 1F);
				util.makeAddItem(new ItemStack(Material.GOLD_AXE), ChatColor.GRAY + "Plasma Rifle", new String[] {"22 damage.", "Level 8"}, p.getInventory(), true);
				p.closeInventory();
				p.sendMessage(ChatColor.BLUE + "Shop> " + ChatColor.GRAY + "You purchased Plasma Rifle for 200 credits.");
			}
		}
		if(itemStack.getItemMeta().getDisplayName().equals(ChatColor.GRAY + "Particle Rifle"))
		{
			if(cp.getCredits() < 300)
			{
				p.playSound(p.getLocation(), Sound.ENTITY_ITEM_BREAK, 1F, 1F);
			}
			if(cp.getCredits() >= 300)
			{
				cp.setCredits(cp.getCredits() - 300);
				p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 1F, 1F);
				util.makeAddItem(new ItemStack(Material.DIAMOND_AXE), ChatColor.GRAY + "Particle Rifle", new String[] {"18 damage.", "Level 9"}, p.getInventory(), true);
				p.closeInventory();
				p.sendMessage(ChatColor.BLUE + "Shop> " + ChatColor.GRAY + "You purchased Particle Rifle for 300 credits.");
			}
		}

	}
}
