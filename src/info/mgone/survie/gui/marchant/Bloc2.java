package info.mgone.survie.gui.marchant;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Bloc2 implements org.bukkit.event.Listener {
	
	public static Inventory GUIblock2 = null;
	static ItemStack currentblock2Item = null;
	static List<String> lores = new ArrayList<String>();
	Player p = null;
	String invetaryname = null;
	
	
	@SuppressWarnings("deprecation")
	public static Inventory displayBlock2()
	 {
		
		GUIblock2.setItem(0, GiveM.Lore64(Material.OBSIDIAN, 0, "5"));
		GUIblock2.setItem(1, GiveM.Lore64(Material.ENDER_STONE, 0, "5"));
		GUIblock2.setItem(2, GiveM.Lore64(Material.NETHERRACK, 0, "0.2"));
		GUIblock2.setItem(3, GiveM.Lore64(Material.QUARTZ_ORE, 0, "2"));
		GUIblock2.setItem(4, GiveM.Lore64(Material.SOUL_SAND, 0, "1"));
		GUIblock2.setItem(5, GiveM.Lore64(Material.NETHER_BRICK, 0, "1"));
		GUIblock2.setItem(6, GiveM.Lore64(Material.GLOWSTONE, 0, "6"));
		GUIblock2.setItem(7, GiveM.Lore64(Material.QUARTZ_BLOCK, 0, "4"));
		
		GUIblock2.setItem(9, GiveM.Lore64(Material.WOOL, 0, "0.5"));
		GUIblock2.setItem(10, GiveM.Lore64(Material.HARD_CLAY, 0, "0.5"));
		GUIblock2.setItem(11, GiveM.Lore64(Material.GLASS, 0, "0.5"));
		GUIblock2.setItem(12, GiveM.Lore64(Material.PUMPKIN, 0, "0.5"));
		GUIblock2.setItem(13, GiveM.Lore64(Material.MELON_BLOCK, 0, "5"));
		GUIblock2.setItem(14, GiveM.Lore64(Material.SNOW_BLOCK, 0, "1"));
		GUIblock2.setItem(15, GiveM.Lore64(Material.ICE, 0, "3"));
		GUIblock2.setItem(16, GiveM.Lore64(Material.PACKED_ICE, 0, "5"));
		
		GUIblock2.setItem(18, GiveM.Lore64(Material.getMaterial(168), 0, "3"));
		GUIblock2.setItem(19, GiveM.Lore64(Material.getMaterial(168), 1, "5"));
		GUIblock2.setItem(20, GiveM.Lore64(Material.getMaterial(168), 2, "5"));
		GUIblock2.setItem(21, GiveM.Lore64(Material.getMaterial(169), 0, "5"));
		
		GUIblock2.setItem(27, GiveM.Lore64(Material.PAINTING, 0, "1"));
		GUIblock2.setItem(28, GiveM.Lore64(Material.ITEM_FRAME, 0, "1"));
		GUIblock2.setItem(29, GiveM.Lore16(Material.getMaterial(416), 0, "1"));
		GUIblock2.setItem(30, GiveM.Lore16(Material.getMaterial(425), 15, "2"));
		
		GUIblock2.setItem(36, GiveM.Lore64(Material.WEB, 0, "20"));
		GUIblock2.setItem(37, GiveM.Lore64(Material.JUKEBOX, 0, "20"));
		GUIblock2.setItem(38, GiveM.Lore64(Material.NOTE_BLOCK, 0, "5"));
		GUIblock2.setItem(39, GiveM.Lore64(Material.getMaterial(165), 0, "15"));
		
		
		
		
		return GUIblock2;
		
	 }
	
	
	

	@SuppressWarnings("deprecation")
	@EventHandler(priority=EventPriority.MONITOR)
	  public void guiClick(InventoryClickEvent e) {
		
		
		invetaryname = e.getInventory().getName();
		p = ((Player)e.getWhoClicked());
		   
		   if (!invetaryname.contains("§6\u2663 Blocks de décoration \u2663")) return;
		   if ((e.getSlot() < 0) || (e.getSlot() > 53)) return;
		   e.setCancelled(true); 
		   if(e.getSlotType() != InventoryType.SlotType.CONTAINER) { p.closeInventory(); return;}
		   
		   
		   if (e.getSlot() == 0)
		   {
			   if(GiveM.CheckMoney(p,5,e)) GiveM.GiveP(p,Material.OBSIDIAN,0,e); else closeNo(p);
		   }
		
		   if (e.getSlot() == 1)
		   {
			   if(GiveM.CheckMoney(p,5,e)) GiveM.GiveP(p,Material.ENDER_STONE,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 2)
		   {
			   if(GiveM.CheckMoney(p,0.2,e)) GiveM.GiveP(p,Material.NETHERRACK,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 3)
		   {
			   if(GiveM.CheckMoney(p,2,e)) GiveM.GiveP(p,Material.QUARTZ_ORE,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 4)
		   {
			   if(GiveM.CheckMoney(p,1,e)) GiveM.GiveP(p,Material.SOUL_SAND,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 5)
		   {
			   if(GiveM.CheckMoney(p,1,e)) GiveM.GiveP(p,Material.NETHER_BRICK,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 6)
		   {
			   if(GiveM.CheckMoney(p,6,e)) GiveM.GiveP(p,Material.GLOWSTONE,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 7)
		   {
			   if(GiveM.CheckMoney(p,4,e)) GiveM.GiveP(p,Material.QUARTZ_BLOCK,0,e); else closeNo(p);
		   }
		   
		   //ligne 2
		
		   if (e.getSlot() == 9)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.WOOL,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 10)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.HARD_CLAY,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 11)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.GLASS,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 12)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.PUMPKIN,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 13)
		   {
			   if(GiveM.CheckMoney(p,5,e)) GiveM.GiveP(p,Material.MELON_BLOCK,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 14)
		   {
			   if(GiveM.CheckMoney(p,1,e)) GiveM.GiveP(p,Material.SNOW_BLOCK,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 15)
		   {
			   if(GiveM.CheckMoney(p,3,e)) GiveM.GiveP(p,Material.ICE,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 16)
		   {
			   if(GiveM.CheckMoney(p,5,e)) GiveM.GiveP(p,Material.PACKED_ICE,0,e); else closeNo(p);
		   }
		   
		   //ligne3
		   
		   if (e.getSlot() == 18)
		   {
			   if(GiveM.CheckMoney(p,3,e)) GiveM.GiveP(p,Material.getMaterial(168),0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 19)
		   {
			   if(GiveM.CheckMoney(p,5,e)) GiveM.GiveP(p,Material.getMaterial(168),1,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 20)
		   {
			   if(GiveM.CheckMoney(p,5,e)) GiveM.GiveP(p,Material.getMaterial(168),2,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 21)
		   {
			   if(GiveM.CheckMoney(p,5,e)) GiveM.GiveP(p,Material.getMaterial(169),0,e); else closeNo(p);
		   }
		   
		   //ligne4
		   
		   if (e.getSlot() == 27)
		   {
			   if(GiveM.CheckMoney(p,1,e)) GiveM.GiveP(p,Material.PAINTING,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 28)
		   {
			   if(GiveM.CheckMoney(p,1,e)) GiveM.GiveP(p,Material.ITEM_FRAME,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 29)
		   {
			   if(GiveM.CheckMoney16(p,1,e)) GiveM.GiveP16(p,Material.getMaterial(416),0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 30)
		   {
			   if(GiveM.CheckMoney16(p,2,e)) GiveM.GiveP16(p,Material.getMaterial(425),15,e); else closeNo(p);
		   }
		   
		   //ligne5
		   
		   if (e.getSlot() == 36)
		   {
			   if(GiveM.CheckMoney(p,20,e)) GiveM.GiveP(p,Material.WEB,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 37)
		   {
			   if(GiveM.CheckMoney(p,20,e)) GiveM.GiveP(p,Material.JUKEBOX,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 38)
		   {
			   if(GiveM.CheckMoney(p,5,e)) GiveM.GiveP(p,Material.NOTE_BLOCK,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 39)
		   {
			   if(GiveM.CheckMoney(p,15,e)) GiveM.GiveP(p,Material.getMaterial(165),0,e); else closeNo(p);
		   }



		
	}
	
	
	public void closeNo(Player p) {
		p.closeInventory();
		p.getWorld().playSound(p.getLocation(), Sound.VILLAGER_NO, 2.0F, 13.0F);
	}
	

}
