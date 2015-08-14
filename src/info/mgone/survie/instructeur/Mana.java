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

public class Mana implements org.bukkit.event.Listener {
	
	
	public static Inventory GUImana = null;
	static ItemStack currentmanaItem = null;
	static List<String> lores = new ArrayList<String>();
	Player p = null;
	String invetaryname = null;
	
	public static Inventory displayMana(Player p)
	 {
		GUImana = Bukkit.createInventory(null, 9, "§5\u2663 Afflux de mana \u2663");
		
		currentmanaItem = new ItemStack(Material.POTION,1);
	    ItemMeta meta0 = currentmanaItem.getItemMeta();
	    meta0.setDisplayName("§7Mana1");
	    lores.add("§b: §2Bientôt!");
	    meta0.setLore(lores);
	    currentmanaItem.setItemMeta(meta0);
	    GUImana.setItem(0,currentmanaItem);
	    lores.clear();
		
	    
	    currentmanaItem = new ItemStack(Material.POTION,2);
	    ItemMeta meta1 = currentmanaItem.getItemMeta();
	    meta1.setDisplayName("§7Mana2");
	    lores.add("§b: §2Bientôt!");
	    meta1.setLore(lores);
	    currentmanaItem.setItemMeta(meta1);
	    GUImana.setItem(1,currentmanaItem);
	    lores.clear();
	    
	    
	    currentmanaItem = new ItemStack(Material.POTION,3);
	    ItemMeta meta2 = currentmanaItem.getItemMeta();
	    meta2.setDisplayName("§7Mana3");
	    lores.add("§b: §2Bientôt!");
	    meta2.setLore(lores);
	    currentmanaItem.setItemMeta(meta2);
	    GUImana.setItem(2,currentmanaItem);
	    lores.clear();
	    
		
		return GUImana;
	 }
	
	
	@EventHandler(priority=EventPriority.MONITOR)
	  public void guiClick(InventoryClickEvent e) {
		
		invetaryname = e.getInventory().getName();
		p = ((Player)e.getWhoClicked());
		   
		   if (!invetaryname.contains("§5\u2663 Afflux de mana \u2663")) return;
		   if ((e.getSlot() < 0) || (e.getSlot() > 53)) return;
		   e.setCancelled(true); 
		   if(e.getSlotType() != InventoryType.SlotType.CONTAINER) { p.closeInventory(); return;}
		
		   
		   p.sendMessage("§2Bientôt disponible!");
		   p.closeInventory();
		
	}

}
