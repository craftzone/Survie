package info.mgone.survie.hdv;

import info.mgone.survie.Survie;
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
import org.bukkit.inventory.meta.SkullMeta;

public class Troqueur implements org.bukkit.event.Listener {
	
	
	public static Inventory GUItroque = null;
	static ItemStack currenttroqueItem = null;
	static List<String> lores = new ArrayList<String>();
	Player p = null;
	String invetaryname = null;
	
	public static Inventory displayTroqueur()
	 {
		GUItroque.setItem(10, ItemLores.FreeLore(Material.EMERALD, 1, 0, "§9Toutes les ventes", "§fAcheter ou ventre", "§fdes items ici."));
		
		GUItroque.setItem(12, ItemLores.FreeLore(Material.BOOK, 1, 0, "§bBoite Mail", "§fToutes vos ventes", "§fet vos achats ici."));
		
		GUItroque.setItem(16, ItemLores.FreeLore(Material.QUARTZ, 1, 0, "§cVentes aux enchères", "§fBientôt!"));
		
		
		currenttroqueItem = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
	     SkullMeta meta00 = (SkullMeta) currenttroqueItem.getItemMeta();
	     meta00.setOwner("MHF_Question");
		 meta00.setDisplayName("§aAide");
		 lores.add("§6=================ACHAT==================");
		 lores.add("§fCliquez sur l'émeraude, pour afficher la liste");
		 lores.add("§fdes items en vente.Ensuite vous pouvez changer");
		 lores.add("§fles pages, rechercher.. pour acheter faite un");
		 lores.add("§fdouble clic sur l'item désirer.");
		 lores.add("§b=================VENTE==================");
		 lores.add("§fCliquez sur l'émeraude, puis déposez les items");
		 lores.add("§fque vous voulez vendre sur l'entonnoir. Ensuite");
		 lores.add("§findiquez le prix et la quantité sur le panneau");
		 lores.add("§fqui apparaitra.");
		 lores.add("§9=================MAIL==================");
		 lores.add("§fLorsque vous vendez un item ou vous achetez");
		 lores.add("§fun, il sera placé dans votre boite aux lettres.");
		 lores.add("§fVous pouvez le récuperer en cliquant dessus.");
		 lores.add("§fvous pouvez aussi gérer vos items mis en vente");
		 lores.add("§fdepuis votre boite aux lettres.");
		 
		 meta00.setLore(lores);
		 currenttroqueItem.setItemMeta(meta00);
		 GUItroque.setItem(14,currenttroqueItem);
	     lores.clear();
		
		return GUItroque;
	 }
	
	@EventHandler(priority=EventPriority.MONITOR)
	  public void guiClick(InventoryClickEvent event) {
		
		
		invetaryname = event.getInventory().getName();
		p = ((Player)event.getWhoClicked());
		   
		   if (!invetaryname.contains("§5\u2663 Troque et Enchère \u2663")) return;
		   if ((event.getSlot() < 0) || (event.getSlot() > 53)) return;
		   event.setCancelled(true); 
		   if(event.getClick().isShiftClick()) { event.setCancelled(true); return;}
		   if(event.getSlotType() != InventoryType.SlotType.CONTAINER) { p.closeInventory(); return;}
		
		   if (event.getCurrentItem().getType() == Material.EMERALD)
		     {
			   p.closeInventory();
			   Survie.permission.playerAddTransient(p, "globalmarket.quicklist");
			   p.performCommand("market listings");
			   Survie.permission.playerRemoveTransient(p, "globalmarket.quicklist");
			   return;
		     }
		   
		   if (event.getCurrentItem().getType() == Material.BOOK)
		     {
			   p.closeInventory();
			   Survie.permission.playerAddTransient(p, "globalmarket.quickmail");
			   p.performCommand("market mail");
			   Survie.permission.playerRemoveTransient(p, "globalmarket.quickmail");
			   return;
		     }
		   
		   
		
	}

}
