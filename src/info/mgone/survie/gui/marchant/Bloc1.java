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

public class Bloc1 implements org.bukkit.event.Listener {
	
	
	public static Inventory GUIblock1 = null;
	static ItemStack currentblock1Item = null;
	static List<String> lores = new ArrayList<String>();
	Player p = null;
	String invetaryname = null;
	
	
	@SuppressWarnings("deprecation")
	public static Inventory displayBlock1()
	 {
		    
		GUIblock1.setItem(0, GiveM.Lore64(Material.STONE, 0, "0.5"));
		GUIblock1.setItem(1, GiveM.Lore64(Material.STONE, 1, "0.5"));
		GUIblock1.setItem(2, GiveM.Lore64(Material.STONE, 2, "0.5"));
		GUIblock1.setItem(3, GiveM.Lore64(Material.STONE, 3, "0.5"));
		GUIblock1.setItem(4, GiveM.Lore64(Material.STONE, 4, "0.5"));
		GUIblock1.setItem(5, GiveM.Lore64(Material.STONE, 5, "0.5"));
		GUIblock1.setItem(6, GiveM.Lore64(Material.STONE, 6, "0.5"));
		GUIblock1.setItem(7, GiveM.Lore64(Material.COBBLESTONE, 0, "0.3"));
		GUIblock1.setItem(8, GiveM.Lore64(Material.SMOOTH_BRICK, 0, "0.5"));
		
		GUIblock1.setItem(9, GiveM.Lore64(Material.GRAVEL, 0, "0.5"));
		GUIblock1.setItem(10, GiveM.Lore64(Material.MOSSY_COBBLESTONE, 0, "1"));
		GUIblock1.setItem(11, GiveM.Lore64(Material.SMOOTH_BRICK, 1, "1"));
		GUIblock1.setItem(12, GiveM.Lore64(Material.SMOOTH_BRICK, 2, "1"));
		GUIblock1.setItem(13, GiveM.Lore64(Material.SMOOTH_BRICK, 3, "1"));
		GUIblock1.setItem(14, GiveM.Lore64(Material.BRICK, 0, "1"));
		
		GUIblock1.setItem(18, GiveM.Lore64(Material.DIRT, 0, "0.2"));
		GUIblock1.setItem(19, GiveM.Lore64(Material.DIRT, 1, "0.4"));
		GUIblock1.setItem(20, GiveM.Lore64(Material.GRASS, 0, "2.5"));
		GUIblock1.setItem(21, GiveM.Lore64(Material.DIRT, 2, "3.5"));
		GUIblock1.setItem(22, GiveM.Lore64(Material.MYCEL, 0, "3.5"));
		
		GUIblock1.setItem(27, GiveM.Lore64(Material.SAND, 0, "0.4"));
		GUIblock1.setItem(28, GiveM.Lore64(Material.SANDSTONE, 0, "1.5"));
		GUIblock1.setItem(29, GiveM.Lore64(Material.SANDSTONE, 1, "1.5"));
		GUIblock1.setItem(30, GiveM.Lore64(Material.SANDSTONE, 2, "1.5"));
		GUIblock1.setItem(31, GiveM.Lore64(Material.SAND, 1, "1"));
		GUIblock1.setItem(32, GiveM.Lore64(Material.getMaterial(179), 0, "4"));
		GUIblock1.setItem(33, GiveM.Lore64(Material.getMaterial(179), 1, "4"));
		GUIblock1.setItem(34, GiveM.Lore64(Material.getMaterial(179), 2, "4"));
		
		GUIblock1.setItem(36, GiveM.Lore64(Material.getMaterial(17), 0, "1"));
		GUIblock1.setItem(37, GiveM.Lore64(Material.getMaterial(17), 1, "1"));
		GUIblock1.setItem(38, GiveM.Lore64(Material.getMaterial(17), 2, "1"));
		GUIblock1.setItem(39, GiveM.Lore64(Material.getMaterial(17), 3, "1"));
		GUIblock1.setItem(40, GiveM.Lore64(Material.getMaterial(162), 0, "1"));
		GUIblock1.setItem(41, GiveM.Lore64(Material.getMaterial(162), 1, "1"));
		
		
		return GUIblock1;

	 }
	
	
	@SuppressWarnings("deprecation")
	@EventHandler(priority=EventPriority.MONITOR)
	  public void guiClick(InventoryClickEvent e) {
		
		invetaryname = e.getInventory().getName();
		p = ((Player)e.getWhoClicked());
		   
		   if (!invetaryname.contains("§6\u2663 Blocks de construction \u2663")) return;
		   if ((e.getSlot() < 0) || (e.getSlot() > 53)) return;
		   e.setCancelled(true); 
		   if(e.getSlotType() != InventoryType.SlotType.CONTAINER) { p.closeInventory(); return;}
		   
		   
		   if (e.getSlot() == 0)
		   {
			   if(GiveM.CheckMoney(p,0.5,e)) GiveM.GiveP(p,Material.STONE,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 1)
		   {
			   if(GiveM.CheckMoney(p,0.5,e))GiveM.GiveP(p,Material.STONE,1,e); else closeNo(p);
		   }
		   
		   
		   if (e.getSlot() == 2)
		   {
			   if(GiveM.CheckMoney(p,0.5,e))GiveM.GiveP(p,Material.STONE,2,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 3)
		   {
			   if(GiveM.CheckMoney(p,0.5,e))GiveM.GiveP(p,Material.STONE,3,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 4)
		   {
			   if(GiveM.CheckMoney(p,0.5,e))GiveM.GiveP(p,Material.STONE,4,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 5)
		   {
			   if(GiveM.CheckMoney(p,0.5,e))GiveM.GiveP(p,Material.STONE,5,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 6)
		   {
			   if(GiveM.CheckMoney(p,0.5,e))GiveM.GiveP(p,Material.STONE,6,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 7)
		   {
			   if(GiveM.CheckMoney(p,0.3,e))GiveM.GiveP(p,Material.COBBLESTONE,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 8)
		   {
			   if(GiveM.CheckMoney(p,0.5,e))GiveM.GiveP(p,Material.SMOOTH_BRICK,0,e); else closeNo(p);
		   }
		   
		   //ligne 2
		   
		   if (e.getSlot() == 9)
		   {
			   if(GiveM.CheckMoney(p,0.5,e))GiveM.GiveP(p,Material.GRAVEL,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 10)
		   {
			   if(GiveM.CheckMoney(p,1,e))GiveM.GiveP(p,Material.MOSSY_COBBLESTONE,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 11)
		   {
			   if(GiveM.CheckMoney(p,1,e))GiveM.GiveP(p,Material.SMOOTH_BRICK,1,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 12)
		   {
			   if(GiveM.CheckMoney(p,1,e))GiveM.GiveP(p,Material.SMOOTH_BRICK,2,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 13)
		   {
			   if(GiveM.CheckMoney(p,1,e))GiveM.GiveP(p,Material.SMOOTH_BRICK,3,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 14)
		   {
			   if(GiveM.CheckMoney(p,1,e))GiveM.GiveP(p,Material.BRICK,0,e); else closeNo(p);
		   }
		   
		   //ligne 3
		   
		   
		   if (e.getSlot() == 18)
		   {
			   if(GiveM.CheckMoney(p,0.2,e))GiveM.GiveP(p,Material.DIRT,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 19)
		   {
			   if(GiveM.CheckMoney(p,0.4,e))GiveM.GiveP(p,Material.DIRT,1,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 20)
		   {
			   if(GiveM.CheckMoney(p,2.5,e))GiveM.GiveP(p,Material.GRASS,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 21)
		   {
			   if(GiveM.CheckMoney(p,3.5,e))GiveM.GiveP(p,Material.DIRT,2,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 22)
		   {
			   if(GiveM.CheckMoney(p,3.5,e))GiveM.GiveP(p,Material.MYCEL,0,e); else closeNo(p);
		   }
		   
		   
		   //ligne4

		   if (e.getSlot() == 27)
		   {
			   if(GiveM.CheckMoney(p,0.4,e))GiveM.GiveP(p,Material.SAND,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 28)
		   {
			   if(GiveM.CheckMoney(p,1.5,e))GiveM.GiveP(p,Material.SANDSTONE,0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 29)
		   {
			   if(GiveM.CheckMoney(p,1.5,e))GiveM.GiveP(p,Material.SANDSTONE,1,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 30)
		   {
			   if(GiveM.CheckMoney(p,1.5,e))GiveM.GiveP(p,Material.SANDSTONE,2,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 31)
		   {
			   if(GiveM.CheckMoney(p,1,e))GiveM.GiveP(p,Material.SAND,1,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 32)
		   {
			   if(GiveM.CheckMoney(p,3,e))GiveM.GiveP(p,Material.getMaterial(179),0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 33)
		   {
			   if(GiveM.CheckMoney(p,3,e))GiveM.GiveP(p,Material.getMaterial(179),1,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 34)
		   {
			   if(GiveM.CheckMoney(p,3,e))GiveM.GiveP(p,Material.getMaterial(179),2,e); else closeNo(p);
		   }
		   
		   //ligne5
		   
		   
		   if (e.getSlot() == 36)
		   {
			   if(GiveM.CheckMoney(p,1,e))GiveM.GiveP(p,Material.getMaterial(17),0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 37)
		   {
			   if(GiveM.CheckMoney(p,1,e))GiveM.GiveP(p,Material.getMaterial(17),1,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 38)
		   {
			   if(GiveM.CheckMoney(p,1,e))GiveM.GiveP(p,Material.getMaterial(17),2,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 39)
		   {
			   if(GiveM.CheckMoney(p,1,e))GiveM.GiveP(p,Material.getMaterial(17),3,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 40)
		   {
			   if(GiveM.CheckMoney(p,1,e))GiveM.GiveP(p,Material.getMaterial(162),0,e); else closeNo(p);
		   }
		   
		   if (e.getSlot() == 41)
		   {
			   if(GiveM.CheckMoney(p,1,e))GiveM.GiveP(p,Material.getMaterial(162),1,e); else closeNo(p);
		   }
		   

		   
	
		   e.setCancelled(true); 
	}
	
	
	public void closeNo(Player p) {
		p.closeInventory();
		p.getWorld().playSound(p.getLocation(), Sound.VILLAGER_NO, 2.0F, 13.0F);
	}
	
	
	

	

}
