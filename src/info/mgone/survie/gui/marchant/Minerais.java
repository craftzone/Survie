package info.mgone.survie.gui.marchant;

import info.mgone.survie.instructeur.Checkm;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Minerais implements org.bukkit.event.Listener {
	
	public static Inventory GUImin = null;
	static ItemStack currentminItem = null;
	static List<String> lores = new ArrayList<String>();
	Player p = null;
	String invetaryname = null;
	


	public static Inventory displayMinerais()
	 {
		
		GUImin.setItem(0, GiveM.Lore64(Material.COAL, 0, "2"));
		GUImin.setItem(1, GiveM.Lore64(Material.IRON_INGOT, 0, "5"));
		GUImin.setItem(2, GiveM.Lore64(Material.GOLD_INGOT, 0, "20"));
		GUImin.setItem(3, GiveM.Lore64(Material.INK_SACK, 4, "3"));
		GUImin.setItem(4, GiveM.Lore64(Material.GLOWSTONE_DUST, 0, "2"));
		GUImin.setItem(5, GiveM.Lore64(Material.QUARTZ, 0, "1.9"));
		GUImin.setItem(6, GiveM.Lore64(Material.DIAMOND, 0, "30"));
		GUImin.setItem(7, GiveM.Lore64(Material.EMERALD, 0, "40"));
		
		
		GUImin.setItem(9, GiveM.Lore64(Material.NETHER_STALK, 0, "1"));
		GUImin.setItem(10, GiveM.Lore64(Material.BLAZE_ROD, 0, "2"));
		
		
		return GUImin;
	 }
	
	
	@EventHandler(priority=EventPriority.MONITOR)
	  public void guiClick(InventoryClickEvent e) {
		
		
		invetaryname = e.getInventory().getName();
		p = ((Player)e.getWhoClicked());
		   
		   if (!invetaryname.contains("§6\u2663 Minerais et Potions \u2663")) return;
		   if ((e.getSlot() < 0) || (e.getSlot() > 53)) return;
		   e.setCancelled(true); 
		   if(e.getSlotType() != InventoryType.SlotType.CONTAINER) { p.closeInventory(); return;}
		
		   if (e.getSlot() == 0)
		   {
			   if(GiveM.CheckMoney(p,2,e)) GiveM.GiveP(p,Material.COAL,0,e); else Checkm.closeNo(p);
		   }
		   
		   if (e.getSlot() == 1)
		   {
			   if(GiveM.CheckMoney(p,5,e)) GiveM.GiveP(p,Material.IRON_INGOT,0,e); else Checkm.closeNo(p);
		   }
		   
		   if (e.getSlot() == 2)
		   {
			   if(GiveM.CheckMoney(p,20,e)) GiveM.GiveP(p,Material.GOLD_INGOT,0,e); else Checkm.closeNo(p);
		   }
		   
		   if (e.getSlot() == 3)
		   {
			   if(GiveM.CheckMoney(p,3,e)) GiveM.GiveP(p,Material.INK_SACK,4,e); else Checkm.closeNo(p);
		   }
		   
		   if (e.getSlot() == 4)
		   {
			   if(GiveM.CheckMoney(p,2,e)) GiveM.GiveP(p,Material.GLOWSTONE_DUST,0,e); else Checkm.closeNo(p);
		   }
		   
		   if (e.getSlot() == 5)
		   {
			   if(GiveM.CheckMoney(p,1.9,e)) GiveM.GiveP(p,Material.QUARTZ,0,e); else Checkm.closeNo(p);
		   }
		   
		   if (e.getSlot() == 6)
		   {
			   if(GiveM.CheckMoney(p,30,e)) GiveM.GiveP(p,Material.DIAMOND,0,e); else Checkm.closeNo(p);
		   }
		   
		   if (e.getSlot() == 7)
		   {
			   if(GiveM.CheckMoney(p,40,e)) GiveM.GiveP(p,Material.EMERALD,0,e); else Checkm.closeNo(p);
		   }
		   
		   
		   
		   if (e.getSlot() == 9)
		   {
			   if(GiveM.CheckMoney(p,1,e)) GiveM.GiveP(p,Material.NETHER_STALK,0,e); else Checkm.closeNo(p);
		   }
		   
		   if (e.getSlot() == 10)
		   {
			   if(GiveM.CheckMoney(p,2,e)) GiveM.GiveP(p,Material.BLAZE_ROD,0,e); else Checkm.closeNo(p);
		   }
		
		
	}
	
	
	
}
