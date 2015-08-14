package info.mgone.survie.instructeur;

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

public class Instructeur implements org.bukkit.event.Listener {
	
	
	public static Inventory GUIinstruc = null;
	static ItemStack currentinstrucItem = null;
	static List<String> lores = new ArrayList<String>();
	Player p = null;
	String invetaryname = null;
	
	
	public static Inventory displayInstructeur()
	 {
		
		GUIinstruc.setItem(0, ItemLores.addGlow(ItemLores.FreeLore(Material.EMERALD, 1, 0, "§aGrades", "§7Achetez les Grades ici.")));
		GUIinstruc.setItem(1, ItemLores.FreeLore(Material.CHAINMAIL_CHESTPLATE, 1, 0, "§aDétermination", "§7Augmente vos points de vie."));
		GUIinstruc.setItem(2, ItemLores.FreeLore(Material.DIAMOND_BOOTS, 1, 0, "§aSpeed", "§7Augmente votre vitesse de déplacement."));
		//GUIinstruc.setItem(3, ItemLores.FreeLore(Material.OBSIDIAN, 1, 0, "§aBaston", "§7Vous perdez moins de skill quand", "§7quelqu'un vous tue. et vous gagner plus", "§7quand vous tuer quelqu'un."));
		//GUIinstruc.setItem(4, ItemLores.FreeLore(Material.POTION, 1, 0, "§aAfflux de mana", "§7Recharge de mana plus rapide."));
		
		GUIinstruc.setItem(8, ItemLores.addGlow(ItemLores.FreeName(Material.GOLD_INGOT, 1, 0, "§6Acheter des SuperCoins")));
		
		return GUIinstruc;
	 }
	
	@EventHandler(priority=EventPriority.MONITOR)
	  public void guiClick(InventoryClickEvent event) {
		
		invetaryname = event.getInventory().getName();
		p = ((Player)event.getWhoClicked());
		   
		   if (!invetaryname.contains("§5\u2663 Instructeur \u2663")) return;
		   if ((event.getSlot() < 0) || (event.getSlot() > 53)) return;
		   event.setCancelled(true); 
		   if(event.getClick().isShiftClick()) { event.setCancelled(true); return;}
		   if(event.getSlotType() != InventoryType.SlotType.CONTAINER) { p.closeInventory(); return;}
		   
		   if (event.getCurrentItem().getType() == Material.EMERALD)
		     {
			   p.closeInventory();
			   p.openInventory(Grades.displayGrades(p));
		     }
		   
		   if (event.getCurrentItem().getType() == Material.CHAINMAIL_CHESTPLATE)
		     {
			   p.closeInventory();
			   p.openInventory(PvMax.displayPvMax(p));
		     }
		   
		   if (event.getCurrentItem().getType() == Material.DIAMOND_BOOTS)
		     {
			   p.closeInventory();
			   p.openInventory(Speed.displaySpeed(p));
		     }
		   
		   if (event.getCurrentItem().getType() == Material.OBSIDIAN)
		     {
			   p.closeInventory();
			   p.openInventory(Baston.displayBaston(p));
		     }
		   
		   if (event.getCurrentItem().getType() == Material.POTION)
		     {
			   p.closeInventory();
			   p.openInventory(Mana.displayMana(p));
		     }
		   
		   
		   if (event.getCurrentItem().getType() == Material.GOLD_INGOT)
		     {
			   p.closeInventory();
			   p.sendMessage("§6http://shop.craftzone.fr/");
		     }
		
		
	}

}
