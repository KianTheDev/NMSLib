package me.thekian.data;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.thekian.items.CItem;
import org.bukkit.Material;

public class Players 
{
	public class CAccount
	{
		private int characterNumber;
		private ArrayList<CCharacter> charList;
		private UUID owner;
		
		public CAccount(int c, ArrayList<CCharacter> list, UUID u)
		{
			characterNumber = c;
			charList = list;
			owner = u;
		}
		
		public int getCharNumber()
		{
			return characterNumber;
		}
		
		public ArrayList<CCharacter> getChars()
		{
			return charList;
		}
		
		public UUID getOwner()
		{
			return owner;
		}
		
		public void setCharNumber(int i)
		{
			characterNumber = i;
		}
	}
	
	public class CCharacter
	{
		private CPlayer playerDat;
		private ArrayList<CItem> items, armor;
		private double[] coords = new double[3];
		private int characterNumber;
		
		public CCharacter(CPlayer pd, ArrayList<CItem> i, ArrayList<CItem> a, int cn)
		{
			playerDat = pd;
			items = i;
			armor = a;
			characterNumber = cn;
		}
		
		public void loadData(Player p, CPlayer cp)
		{
			System.out.println("?-2");
			cp.setMaxHealth(playerDat.getMaxHealth());
			cp.setHealth(playerDat.getHealth());
			cp.setCredits(playerDat.getCredits());
			cp.setUUID(playerDat.getUUID());
			cp.setClass(playerDat.getPlayerClass());
			cp.setRace(playerDat.getRace());
			cp.setXPLevel(playerDat.getLevel(), playerDat.getXP());
			p.getInventory().setArmorContents(null);
			p.getInventory().clear();
			new BukkitRunnable(){
				
				public void run()
				{
					if(armor.get(0).getItem() != null)
						if(!armor.get(0).getItem().getType().equals(Material.AIR))
							p.getInventory().setBoots(armor.get(0).makeCopy().getItem());
					if(armor.get(1).getItem() != null)
						if(!armor.get(1).getItem().getType().equals(Material.AIR))
							p.getInventory().setLeggings(armor.get(1).makeCopy().getItem());
					if(armor.get(2).getItem() != null)
						if(!armor.get(2).getItem().getType().equals(Material.AIR))
							p.getInventory().setChestplate(armor.get(2).makeCopy().getItem());
					if(armor.get(3).getItem() != null)
						if(!armor.get(3).getItem().getType().equals(Material.AIR))
							p.getInventory().setHelmet(armor.get(3).makeCopy().getItem());
					for(int i = 0; i < 36; i++)
					{
						if(items.get(i).getItem() != null)
								p.getInventory().setItem(i, items.get(i).makeCopy().getItem());
					}
				}
			}.run();
			Location loc = new Location(p.getWorld(), coords[0], coords[1], coords[2]);
			p.teleport(loc);
		}
		
		public void loadData(Player p, CPlayer cp, Plugin plugin)
		{
			cp.setMaxHealth(playerDat.getMaxHealth());
			cp.setHealth(playerDat.getHealth());
			cp.setCredits(playerDat.getCredits());
			cp.setUUID(playerDat.getUUID());
			cp.setClass(playerDat.getPlayerClass());
			cp.setRace(playerDat.getRace());
			cp.setXPLevel(playerDat.getLevel(), playerDat.getXP());
			p.getInventory().setArmorContents(null);
			p.getInventory().clear();
			final Player player = p; 
			new BukkitRunnable(){
				
				public void run()
				{
					if(armor.get(0).getItem() != null)
						if(!armor.get(0).getItem().getType().equals(Material.AIR))
							player.getInventory().setBoots(armor.get(0).makeCopy().getItem());
					if(armor.get(1).getItem() != null)
						if(!armor.get(1).getItem().getType().equals(Material.AIR))
							player.getInventory().setLeggings(armor.get(1).makeCopy().getItem());
					if(armor.get(2).getItem() != null)
						if(!armor.get(2).getItem().getType().equals(Material.AIR))
							player.getInventory().setChestplate(armor.get(2).makeCopy().getItem());
					if(armor.get(3).getItem() != null)
						if(!armor.get(3).getItem().getType().equals(Material.AIR))
							player.getInventory().setHelmet(armor.get(3).makeCopy().getItem());
					for(int i = 0; i < 36; i++)
					{
						if(items.get(i).getItem() != null)
								player.getInventory().setItem(i, items.get(i).makeCopy().getItem());
					}
					System.out.println(coords[0] + " " + coords[1] + " " + coords[2]);
					Location loc = new Location(player.getWorld(), coords[0], coords[1], coords[2]);
					player.teleport(loc);
				}
			}.runTaskLater(plugin, 2);
		}
		
		public void setCoords(double x, double y, double z)
		{
			coords[0] = x;
			coords[1] = y;
			coords[2] = z;
		}
		
		public int getCharNum()
		{
			return characterNumber;
		}
		
		public CPlayer getPlayerData()
		{
			return playerDat;
		}
		
		public ArrayList<ArrayList<CItem>> getInventory()
		{
			ArrayList<ArrayList<CItem>> list = new ArrayList<ArrayList<CItem>>();
			list.add(items);
			list.add(armor);
			return list;
		}
		
		public double[] getCoords()
		{
			return coords;
		}
	}
	
	public class CPlayer
	{
		private UUID uuid;
		private PlayerClass playerClass;
		private Race race;
		private int health, maxHealth, xp, level, xproof, credits, statpoints;
		//Stats
		private int luck, logic, strength, agility, intelligence, vitality;
		
		public CPlayer(UUID uniqueID)
		{
			strength = 0;
			luck = 0;
			logic = 0;
			intelligence = 0;
			agility = 0;
			vitality = 0;
			uuid = uniqueID;
			health = 10;
			maxHealth = 10;
			xp = 0;
			level = 1;
			xproof = 100;
			playerClass = PlayerClass.FIGHTER;
			credits = 100;
			race = Race.HUMAN;
		}
		
		private void LevelUp()
		{
			if(race.equals(Race.PIG))
			{
				statpoints += 3;
			} else
			{
				statpoints += 2;
			}
			level = level + 1;
			xproof = (int) (level * (200 * Math.pow(1.2, level - 1)) + (1000 * Math.pow(1.2, level - 6)));
			if(xp >= xproof)
			{
				LevelUp();
			}
			if(Bukkit.getPlayer(uuid) != null)
			{
				Bukkit.getPlayer(uuid).sendMessage(ChatColor.BLUE + "RPG> " + ChatColor.GRAY + "You have leveled up!");
			}
			if(playerClass.equals(PlayerClass.FIGHTER) || playerClass.equals(PlayerClass.MARINE))
			{
				if(race.equals(Race.COW))
				{
					maxHealth = maxHealth + 12;
					health = health + 12;
				} else
				{
					maxHealth = maxHealth + 10;
					health = health + 10;
				}
			}
			if(playerClass.equals(PlayerClass.TINKERER) || playerClass.equals(PlayerClass.ENGINEER) || playerClass.equals(PlayerClass.SNIPER) || playerClass.equals(PlayerClass.RANGER))
			{
				if(race.equals(Race.COW))
				{
					maxHealth = maxHealth + 10;
					health = health + 10;
				} else
				{
					maxHealth = maxHealth + 8;
					health = health + 8;
				}
			}
			if(playerClass.equals(PlayerClass.MAGICIAN) || playerClass.equals(PlayerClass.TECHNOMANCER))
			{
				if(race.equals(Race.COW))
				{
					maxHealth = maxHealth + 8;
					health = health + 8;
				} else
				{
					maxHealth = maxHealth + 6;
					health = health + 6;
				}
			}
		}
		
		public void AddXP(int i)
		{
			int i2 = i;
			if(i2 < 0)
			{
				i2 = 0;
			}
			/*if(race.equals(Race.HUMAN))
			{
				double d = i2;
				d *= 1.02;
				i2 = (int) d;
			}*/
			xp = xp + i2;
			if(xp >= xproof)
			{
				LevelUp();
			}
		}
		
		public void setClass(PlayerClass pc)
		{
			playerClass = pc;
		}
		
		public PlayerClass getPlayerClass()
		{
			return playerClass;
		}
		
		public void setHealth(int i)
		{
			health = i;
		}
		
		public int getHealth()
		{
			return health;
		}
		
		public void setUUID(UUID u)
		{
			uuid = u;
		}
		
		public UUID getUUID()
		{
			return uuid;
		}
		
		public void setMaxHealth(int i)
		{
			maxHealth = i;
		}
		
		public int getMaxHealth()
		{
			return maxHealth;
		}
		
		public int getLevel()
		{
			return level;
		}
		
		public int getXP()
		{
			return xp;
		}
		
		public int getXPRoof()
		{
			return xproof;
		}
		
		public void setCredits(int i)
		{
			credits = i;
		}
		
		public int getCredits()
		{
			return credits;
		}
		
		public void setXPLevel(int l, int x)
		{
			xp = x;
			level = l;
			xproof = (int) (l * (200 * Math.pow(1.2, l - 1)) + (1000 * Math.pow(1.2, l - 6)));
		}
		
		public Race getRace()
		{
			return race;
		}
			
		public void setRace(Race r)
		{
			race = r;
		}
		
		public int getStrength()
		{
			return strength;
		}
		
		public int getLuck()
		{
			return luck;
		}
		
		public int getLogic()
		{
			return logic;
		}
		
		public int getAgility()
		{
			return agility;
		}
		
		public int getIntelligence()
		{
			return intelligence;
		}
		
		public int getVitality()
		{
			return vitality;
		}
		
		public int getStatPoints()
		{
			return statpoints;
		}
		
		public void setStrength(int i)
		{
			strength = i;
		}
		
		public void setLuck(int i)
		{
			luck = i;
		}
		
		public void setLogic(int i)
		{
			logic = i;
		}
		
		public void setAgility(int i)
		{
			agility = i;
		}
		
		public void setIntelligence(int i)
		{
			intelligence = i;
		}
		
		public void changeVitality(int i)
		{
			health += i * 2;
			maxHealth += i * 2;
			vitality += i;
		}
		
		public void setStatPoints(int i)
		{
			statpoints = i;
		}
	}
}
