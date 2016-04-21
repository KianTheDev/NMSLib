package me.thekian.data;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager.Profession;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Mobs 
{

	//All abstract classes
	
	abstract public static class CMob
	{
		protected String name;
		protected int health, damage, level;
		protected boolean hostile;
		protected EntityType mobType;
		
		public void setName(String s)
		{
			name = s;
		}
		
		public String getName()
		{
			return name;
		}
		
		public void setHealth(int i)
		{
			health = i;
		}
		
		public int getHealth()
		{
			return health;
		}
		
		public int getDamage()
		{
			return damage;
		}
	}
	
	abstract public static class CNPC extends CMob
	{
		protected boolean shopkeeper;
		protected boolean fights;
		
		public CNPC()
		{
			hostile = false;
		}
		
		abstract public void Greet(Player p);
	}
	
	abstract public static class CVillager extends CNPC
	{
		protected Profession profession;
		
		public CVillager()
		{
			fights = false;
		}
	}
	
	abstract public static class CShopkeeper extends CVillager
	{
		protected int invSize;
		
		public CShopkeeper()
		{
			shopkeeper = true;
		}
		
		public int getInvSize()
		{
			return invSize;
		}
	}
	
	abstract public static class CMonster extends CMob
	{
		protected boolean boss;
		protected int xp;
		
		public CMonster()
		{
			hostile = true;
		}
		
		public int getXP()
		{
			return xp;
		}
	}
	
	//All non-hostile NPC mobs
	
	public class CBattleShop extends CShopkeeper
	{
		
		public CBattleShop()
		{
			name = "Shopkeeper";
			level = 20;
			health = 1000;
			damage = 0;
			invSize = 54;
			profession = Profession.BLACKSMITH;
		}
		
		public void Greet(Player p)
		{
			p.sendMessage(ChatColor.GREEN + "Shopkeeper: " + ( ChatColor.GRAY + "Welcome to my shop! Feel free to look around."));
		}
	}	
	
	public class CChemShop extends CShopkeeper
	{
		
		public CChemShop()
		{
			name = "Chemist";
			level = 20;
			health = 1000;
			damage = 0;
			invSize = 27;
			profession = Profession.PRIEST;
		}
		
		public void Greet(Player p)
		{
			String greetString = (ChatColor.GREEN + "Chemist: " + ChatColor.GRAY + "Welcome to my humble bazaar, " + p.getName() + ". You may look around, but touch nothing.");
			p.sendMessage(greetString);
		}
	}
	
	public class CCitizen extends CVillager
	{
		
		public CCitizen()
		{
			name = "Citizen";
			level = 20;
			health = 500;
			damage = 0;
			profession = Profession.FARMER;
		}
		
		public void Greet(Player p)
		{
			int i = 1 + ((int) (Math.random() * 4));
			if(i == 1)
			{
				p.sendMessage(ChatColor.GREEN + "Citizen: " + ChatColor.GRAY + "Hi there!");
			}
			if(i == 2)
			{
				p.sendMessage(ChatColor.GREEN + "Citizen: " + ChatColor.GRAY + "Hello. Who are you?");
			}
			if(i == 3)
			{
				p.sendMessage(ChatColor.GREEN + "Citizen: " + ChatColor.GRAY + "Pardon me.");
			}
			if(i == 4)
			{
				p.sendMessage(ChatColor.GREEN + "Citizen: " + ChatColor.GRAY + "How are you?");
			}
		}
	}
	
	//All hostile monster mobs
	public class CThug extends CMonster
	{
		
		public CThug()
		{
			name = "Thug";
			health = 5;
			damage = 2;
			level = 1;
			xp = 10;
			mobType = EntityType.ZOMBIE;
			boss = false;
		}
		
		public void OutfitEntity(Zombie z)
		{
		   	z.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET));
			z.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
			z.getEquipment().setItemInHand(new ItemStack(Material.WOOD_SWORD));
			z.setCanPickupItems(false); 
			z.setCustomName(name);
			z.setCustomNameVisible(true);
		}
		
	}
}
