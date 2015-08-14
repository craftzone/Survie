package info.mgone.survie.gui.armurier;

import info.mgone.survie.gui.AttributesLore.ItemLores;

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

public class Armurier implements org.bukkit.event.Listener {
	
	
	public static Inventory GUIarmurier = null;
	static ItemStack currentarmurierItem = null;
	static List<String> lores = new ArrayList<String>();
	Player p = null;
	String invetaryname = null;
	
	public static Inventory displayArmurier()
	 {
		
		
	GUIarmurier.setItem(0, ItemLores.addGlow(ItemLores.FreeName(Material.DIAMOND_SWORD, 1, 0, "§c\u2714 Épée \u2714")));
	GUIarmurier.setItem(1, ItemLores.addGlow(ItemLores.FreeName(Material.DIAMOND_AXE, 1, 0, "§c\u2714 TomaHawk \u2714")));
	GUIarmurier.setItem(2, ItemLores.addGlow(ItemLores.FreeName(Material.DIAMOND_CHESTPLATE, 1, 0, "§c\u2714 Armures \u2714")));
	//GUIarmurier.setItem(3, ItemLores.addGlow(ItemLores.FreeName(Material.DIAMOND_PICKAXE, 1, 0, "§c\u2714 Outils \u2714")));
		
		return GUIarmurier;
	 }
	
	@EventHandler(priority=EventPriority.MONITOR)
	  public void guiClick(InventoryClickEvent e) {
		
		invetaryname = e.getInventory().getName();
		p = ((Player)e.getWhoClicked());
		
		
		if (!invetaryname.contains("§6\u2663 Armurier \u2663")) return;
		   if ((e.getSlot() < 0) || (e.getSlot() > 53)) return;
		   e.setCancelled(true); 
		   if(e.getSlotType() != InventoryType.SlotType.CONTAINER) { p.closeInventory(); return;}
		
		   
		   if (e.getSlot() == 0)
		   {
			   p.closeInventory();
			   p.openInventory(Armes.displayArmes());
		   }
		   
		   if (e.getSlot() == 1)
		   {
			   p.closeInventory();
			   p.openInventory(Haches.displayHache());
		   }
		   
		   if (e.getSlot() == 2)
		   {
			   p.closeInventory();
			   p.openInventory(Armures.displayArmures());
		   }
		   
		   if (e.getSlot() == 3)
		   {
			   p.closeInventory();
			   p.sendMessage("§aBientôt disponible!");
		   }
		
		
	}


}
