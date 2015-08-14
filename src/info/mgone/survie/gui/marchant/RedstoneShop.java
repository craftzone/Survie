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



public class RedstoneShop implements org.bukkit.event.Listener {
	
	public static Inventory GUIredstone = null;
	static ItemStack currentredstoneItem = null;
	static List<String> lores = new ArrayList<String>();
	Player p = null;
	String invetaryname = null;
	
	

	public static Inventory displayRedstone()
	 {
		GUIredstone.setItem(0, GiveM.Lore64(Material.DISPENSER, 0, "4"));
		GUIredstone.setItem(1, GiveM.Lore64(Material.DROPPER, 0, "4"));
		GUIredstone.setItem(2, GiveM.Lore64(Material.PISTON_STICKY_BASE, 11, "6"));
		GUIredstone.setItem(3, GiveM.Lore64(Material.PISTON_BASE, 9, "8"));
		GUIredstone.setItem(4, GiveM.Lore64(Material.REDSTONE, 0, "2"));
		GUIredstone.setItem(5, GiveM.Lore64(Material.DIODE, 0, "8"));
		GUIredstone.setItem(6, GiveM.Lore64(Material.REDSTONE_COMPARATOR, 0, "10"));
		GUIredstone.setItem(7, GiveM.Lore64(Material.TRIPWIRE_HOOK, 0, "3"));
		GUIredstone.setItem(8, GiveM.Lore64(Material.DAYLIGHT_DETECTOR, 0, "10"));
		
		GUIredstone.setItem(9, GiveM.Lore64(Material.POWERED_RAIL, 0, "23"));
		GUIredstone.setItem(10, GiveM.Lore64(Material.DETECTOR_RAIL, 0, "6"));
		GUIredstone.setItem(11, GiveM.Lore64(Material.RAILS, 0, "1.5"));
		GUIredstone.setItem(12, GiveM.Lore64(Material.ACTIVATOR_RAIL, 0, "5"));
		GUIredstone.setItem(13, GiveM.Lore1(Material.MINECART, 0, "23"));
		
		
		return GUIredstone;
	 }
	
	
	
	@EventHandler(priority=EventPriority.MONITOR)
	  public void guiClick(InventoryClickEvent e) {
		
		
		
		invetaryname = e.getInventory().getName();
		p = ((Player)e.getWhoClicked());
		   
		   if (!invetaryname.contains("§6\u2663 Redstone \u2663")) return;
		   if ((e.getSlot() < 0) || (e.getSlot() > 53)) return;
		   e.setCancelled(true); 
		   if(e.getSlotType() != InventoryType.SlotType.CONTAINER) { p.closeInventory(); return;}
		
		
		   if (e.getSlot() == 0)
		   {
			   if(GiveM.CheckMoney(p,4,e)) GiveM.GiveP(p,Material.DISPENSER,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 1)
		   {
			   if(GiveM.CheckMoney(p,4,e)) GiveM.GiveP(p,Material.DROPPER,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 2)
		   {
			   if(GiveM.CheckMoney(p,6,e)) GiveM.GiveP(p,Material.PISTON_STICKY_BASE,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 3)
		   {
			   if(GiveM.CheckMoney(p,8,e)) GiveM.GiveP(p,Material.PISTON_BASE,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 4)
		   {
			   if(GiveM.CheckMoney(p,2,e)) GiveM.GiveP(p,Material.REDSTONE,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 5)
		   {
			   if(GiveM.CheckMoney(p,8,e)) GiveM.GiveP(p,Material.DIODE,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 6)
		   {
			   if(GiveM.CheckMoney(p,10,e)) GiveM.GiveP(p,Material.REDSTONE_COMPARATOR,0,e); else closeNo(p);
		   } 
		   
		   if (e.getSlot() == 7)
		   {
			   if(GiveM.CheckMoney(p,3,e)) GiveM.GiveP(p,Material.TRIPWIRE_HOOK,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 8)
		   {
			   if(GiveM.CheckMoney(p,10,e)) GiveM.GiveP(p,Material.DAYLIGHT_DETECTOR,0,e); else closeNo(p);
		   }
		   
		   //ligne2
		   
		   if (e.getSlot() == 9)
		   {
			   if(GiveM.CheckMoney(p,23,e)) GiveM.GiveP(p,Material.POWERED_RAIL,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 10)
		   {
			   if(GiveM.CheckMoney(p,6,e)) GiveM.GiveP(p,Material.DETECTOR_RAIL,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 11)
		   {
			   if(GiveM.CheckMoney(p,1.5,e)) GiveM.GiveP(p,Material.RAILS,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 12)
		   {
			   if(GiveM.CheckMoney(p,5,e)) GiveM.GiveP(p,Material.ACTIVATOR_RAIL,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 13)
		   {
			   if(GiveM.CheckMoney1(p,23,e)) GiveM.GiveP1(p,Material.MINECART,0,e); else closeNo(p);
		   }
		   

		
	}

	
	public void closeNo(Player p) {
		p.closeInventory();
		p.getWorld().playSound(p.getLocation(), Sound.VILLAGER_NO, 2.0F, 13.0F);
	}

}
