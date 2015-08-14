package info.mgone.survie.instructeur;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Baston implements org.bukkit.event.Listener {
	
	
	public static Inventory GUIbaston = null;
	static ItemStack currentbastonItem = null;
	static List<String> lores = new ArrayList<String>();
	Player p = null;
	String invetaryname = null;
	
	public static Inventory displayBaston(Player p)
	 {
		GUIbaston = Bukkit.createInventory(null, 9, "§5\u2663 Baston \u2663");
		
		currentbastonItem = new ItemStack(Material.OBSIDIAN,1);
	    ItemMeta meta0 = currentbastonItem.getItemMeta();
	    meta0.setDisplayName("§7Baston1");
	    lores.add("§b: §2Bientôt!");
	    meta0.setLore(lores);
	    currentbastonItem.setItemMeta(meta0);
	    GUIbaston.setItem(0,currentbastonItem);
	    lores.clear();
	    
	    
	    currentbastonItem = new ItemStack(Material.OBSIDIAN,2);
	    ItemMeta meta1 = currentbastonItem.getItemMeta();
	    meta1.setDisplayName("§7Baston2");
	    lores.add("§b: §2Bientôt!");
	    meta1.setLore(lores);
	    currentbastonItem.setItemMeta(meta1);
	    GUIbaston.setItem(1,currentbastonItem);
	    lores.clear();
	    
	    
	    currentbastonItem = new ItemStack(Material.OBSIDIAN,3);
	    ItemMeta meta2 = currentbastonItem.getItemMeta();
	    meta2.setDisplayName("§7Baston3");
	    lores.add("§b: §2Bientôt!");
	    meta2.setLore(lores);
	    currentbastonItem.setItemMeta(meta2);
	    GUIbaston.setItem(2,currentbastonItem);
	    lores.clear();
		
		return GUIbaston;
	 }
	
	
	@EventHandler(priority=EventPriority.MONITOR)
	  public void guiClick(InventoryClickEvent e) {
		
		invetaryname = e.getInventory().getName();
		p = ((Player)e.getWhoClicked());
		   
		   if (!invetaryname.contains("§5\u2663 Baston \u2663")) return;
		   if ((e.getSlot() < 0) || (e.getSlot() > 53)) return;
		   e.setCancelled(true); 
		   if(e.getSlotType() != InventoryType.SlotType.CONTAINER) { p.closeInventory(); return;}
		
		   
		   p.sendMessage("§2Bientôt disponible!");
		   p.closeInventory();
		
	}

}