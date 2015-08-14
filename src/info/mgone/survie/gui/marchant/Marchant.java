package info.mgone.survie.gui.marchant;

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

public class Marchant implements org.bukkit.event.Listener {
	
	
	public static Inventory GUImarchant = null;
	static ItemStack currentmarchantItem = null;
	static List<String> lores = new ArrayList<String>();
	Player p = null;
	String invetaryname = null;
	
	
	public static Inventory displayMarchant()
	 {
		    
		GUImarchant.setItem(0, ItemLores.FreeLore(Material.STONE, 1, 0, "§aBlocks généraux", "§fBlocks de constructions"));
		GUImarchant.setItem(1, ItemLores.FreeLore(Material.GLOWSTONE, 1, 0, "§aBlocks généraux", "§fBlocks de décorations..."));
		GUImarchant.setItem(2, ItemLores.FreeLore(Material.RED_ROSE, 1, 0, "§aPlantes", "§fBlocks de décorations..."));
		GUImarchant.setItem(3, ItemLores.FreeLore(Material.REDSTONE, 1, 0, "§aRedstone", "§fBlocks de redstones..."));
		GUImarchant.setItem(4, ItemLores.FreeLore(Material.GLOWSTONE_DUST, 1, 0, "§aMinerais et Potions", "§fMinerais, Ingrédients Potions et autres"));
		
		GUImarchant.setItem(7, ItemLores.FreeLore(Material.GOLDEN_APPLE, 1, 1, "§aRush Items", "§fItems pour le PVP et le rush..."));
		GUImarchant.setItem(8, ItemLores.FreeLore(Material.MOB_SPAWNER, 1, 1, "§aMob Spawner", "§fAcheter des mobspawner..."));
		
		
		return GUImarchant;

	 }
	
	@EventHandler(priority=EventPriority.MONITOR)
	  public void guiClick(InventoryClickEvent event) {
		
		invetaryname = event.getInventory().getName();
		p = ((Player)event.getWhoClicked());
		   
		   if (!invetaryname.contains("§5\u2663 Marchand général \u2663")) return;
		   if ((event.getSlot() < 0) || (event.getSlot() > 53)) return;
		   event.setCancelled(true); 
		   if(event.getClick().isShiftClick()) { event.setCancelled(true); return;}
		   if(event.getSlotType() != InventoryType.SlotType.CONTAINER) { p.closeInventory(); return;}
		   
		   if (event.getCurrentItem().getType() == Material.STONE)
		     {
			   p.closeInventory();
			   p.openInventory(Bloc1.displayBlock1());
		     }
		   
		   
		   if (event.getCurrentItem().getType() == Material.GLOWSTONE)
		     {
			   p.closeInventory();
			   p.openInventory(Bloc2.displayBlock2());
		     }
		   
		   
		   if (event.getCurrentItem().getType() == Material.RED_ROSE)
		     {
			   p.closeInventory();
			   p.openInventory(Plantes.displayPlantes());
		     }
		   
		   if (event.getCurrentItem().getType() == Material.REDSTONE)
		     {
			   p.closeInventory();
			   p.openInventory(RedstoneShop.displayRedstone());
		     }
		   
		   if (event.getCurrentItem().getType() == Material.GLOWSTONE_DUST)
		     {
			   p.closeInventory();
			   p.openInventory(Minerais.displayMinerais());
		     }
		   
		   
		   if (event.getCurrentItem().getType() == Material.GOLDEN_APPLE)
		     {
			   p.closeInventory();
			   p.openInventory(Rush.displayRush());
		     }
		   
		   
		   if (event.getCurrentItem().getType() == Material.MOB_SPAWNER)
		     {
			   p.closeInventory();
			   p.sendMessage("§aBientôt!");
		     }
	
		   event.setCancelled(true); 
	}

}
