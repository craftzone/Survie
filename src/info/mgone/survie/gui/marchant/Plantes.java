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

public class Plantes implements org.bukkit.event.Listener {
	
	public static Inventory GUIplantes = null;
	static ItemStack currentplantesItem = null;
	static List<String> lores = new ArrayList<String>();
	Player p = null;
	String invetaryname = null;
	
	
	public static Inventory displayPlantes()
	 {
		
		
		GUIplantes.setItem(0, GiveM.Lore64(Material.SAPLING, 0, "0.5"));
		GUIplantes.setItem(1, GiveM.Lore64(Material.SAPLING, 1, "0.5"));
		GUIplantes.setItem(2, GiveM.Lore64(Material.SAPLING, 2, "0.5"));
		GUIplantes.setItem(3, GiveM.Lore64(Material.SAPLING, 3, "0.5"));
		GUIplantes.setItem(4, GiveM.Lore64(Material.SAPLING, 4, "0.5"));
		GUIplantes.setItem(5, GiveM.Lore64(Material.SAPLING, 5, "0.5"));
		GUIplantes.setItem(6, GiveM.Lore64(Material.LONG_GRASS, 2, "0.5"));
		GUIplantes.setItem(7, GiveM.Lore64(Material.DEAD_BUSH, 0, "0.5"));
		GUIplantes.setItem(8, GiveM.Lore64(Material.VINE, 2, "0.5"));
		
		GUIplantes.setItem(9, GiveM.Lore64(Material.LEAVES, 0, "0.5"));
		GUIplantes.setItem(10, GiveM.Lore64(Material.LEAVES, 1, "0.5"));
		GUIplantes.setItem(11, GiveM.Lore64(Material.LEAVES, 2, "0.5"));
		GUIplantes.setItem(12, GiveM.Lore64(Material.LEAVES, 3, "0.5"));
		GUIplantes.setItem(13, GiveM.Lore64(Material.LEAVES_2, 0, "0.5"));
		GUIplantes.setItem(14, GiveM.Lore64(Material.LEAVES_2, 1, "0.5"));
		GUIplantes.setItem(15, GiveM.Lore64(Material.LONG_GRASS, 1, "0.5"));
		GUIplantes.setItem(16, GiveM.Lore64(Material.DOUBLE_PLANT, 2, "0.5"));
		GUIplantes.setItem(17, GiveM.Lore64(Material.WATER_LILY, 0, "0.5"));
		
		GUIplantes.setItem(18, GiveM.Lore64(Material.RED_ROSE, 1, "0.5"));
		GUIplantes.setItem(19, GiveM.Lore64(Material.RED_ROSE, 2, "0.5"));
		GUIplantes.setItem(20, GiveM.Lore64(Material.RED_ROSE, 3, "0.5"));
		GUIplantes.setItem(21, GiveM.Lore64(Material.RED_ROSE, 4, "0.5"));
		GUIplantes.setItem(22, GiveM.Lore64(Material.RED_ROSE, 5, "0.5"));
		GUIplantes.setItem(23, GiveM.Lore64(Material.RED_ROSE, 6, "0.5"));
		GUIplantes.setItem(24, GiveM.Lore64(Material.RED_ROSE, 7, "0.5"));
		GUIplantes.setItem(25, GiveM.Lore64(Material.RED_ROSE, 8, "0.5"));
		GUIplantes.setItem(26, GiveM.Lore64(Material.DOUBLE_PLANT, 0, "0.5"));
		
		GUIplantes.setItem(27, GiveM.Lore64(Material.YELLOW_FLOWER, 0, "0.5"));
		GUIplantes.setItem(28, GiveM.Lore64(Material.RED_ROSE, 0, "0.5"));
		GUIplantes.setItem(29, GiveM.Lore64(Material.DOUBLE_PLANT, 5, "0.5"));
		GUIplantes.setItem(30, GiveM.Lore64(Material.DOUBLE_PLANT, 1, "0.5"));
		GUIplantes.setItem(31, GiveM.Lore64(Material.DOUBLE_PLANT, 4, "0.5"));
		GUIplantes.setItem(32, GiveM.Lore64(Material.BROWN_MUSHROOM, 0, "0.5"));
		GUIplantes.setItem(33, GiveM.Lore64(Material.RED_MUSHROOM, 0, "0.5"));
		GUIplantes.setItem(34, GiveM.Lore64(Material.DOUBLE_PLANT, 3, "0.5"));
		GUIplantes.setItem(35, GiveM.Lore64(Material.FLOWER_POT, 0, "0.5"));
		
		
		
		return GUIplantes;

	 }
	
	
	@EventHandler(priority=EventPriority.MONITOR)
	  public void guiClick(InventoryClickEvent e) {
		
		
		invetaryname = e.getInventory().getName();
		p = ((Player)e.getWhoClicked());
		   
		   if (!invetaryname.contains("§6\u2663 Plantes \u2663")) return;
		   if ((e.getSlot() < 0) || (e.getSlot() > 53)) return;
		   e.setCancelled(true); 
		   if(e.getSlotType() != InventoryType.SlotType.CONTAINER) { p.closeInventory(); return;}
		   
		   
		   if (e.getSlot() == 0)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.SAPLING,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 1)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.SAPLING,1,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 2)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.SAPLING,2,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 3)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.SAPLING,3,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 4)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.SAPLING,4,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 5)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.SAPLING,5,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 6)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.LONG_GRASS,2,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 7)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.DEAD_BUSH,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 8)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.VINE,2,e); else closeNo(p);
		   }
		   
		   //ligne2
		   
		   if (e.getSlot() == 9)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.LEAVES,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 10)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.LEAVES,1,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 11)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.LEAVES,2,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 12)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.LEAVES,3,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 13)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.LEAVES_2,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 14)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.LEAVES_2,1,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 15)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.LONG_GRASS,1,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 16)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.DOUBLE_PLANT,2,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 17)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.WATER_LILY,0,e); else closeNo(p);
		   }
		   
		   //ligne3
		   
		   if (e.getSlot() == 18)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.RED_ROSE,1,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 19)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.RED_ROSE,2,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 20)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.RED_ROSE,3,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 21)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.RED_ROSE,4,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 22)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.RED_ROSE,5,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 23)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.RED_ROSE,6,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 24)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.RED_ROSE,7,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 25)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.RED_ROSE,8,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 26)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.DOUBLE_PLANT,0,e); else closeNo(p);
		   }
		   
		   //ligne4
		   
		   if (e.getSlot() == 27)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.YELLOW_FLOWER,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 28)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.RED_ROSE,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 29)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.DOUBLE_PLANT,5,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 30)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.DOUBLE_PLANT,1,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 31)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.DOUBLE_PLANT,4,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 32)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.BROWN_MUSHROOM,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 33)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.RED_MUSHROOM,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 34)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.DOUBLE_PLANT,3,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 35)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.FLOWER_POT,0,e); else closeNo(p);
		   }
		   

	}
	
	public void closeNo(Player p) {
		p.closeInventory();
		p.getWorld().playSound(p.getLocation(), Sound.VILLAGER_NO, 2.0F, 13.0F);
	}

}
