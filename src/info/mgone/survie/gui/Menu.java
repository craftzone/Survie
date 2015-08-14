package info.mgone.survie.gui;

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

public class Menu implements org.bukkit.event.Listener {
	
	
	public static Inventory GUImenu = null;
	static ItemStack currentmenuItem = null;
	static List<String> lores = new ArrayList<String>();
	Player p = null;
	String invetaryname = null;
	
	
	public static Inventory displayMenu()
	 {
		
	
		
	//spawn		    
	 GUImenu.setItem(0, ItemLores.addGlow(ItemLores.FreeLore(Material.COMPASS, 1, 0, "§6\u27A1 Spawn", "§fRetour au Spawn")));
	 
	 //marchant general
	 GUImenu.setItem(2, ItemLores.FreeLore(Material.CHEST, 1, 0, "§6\u27A1 Marchant général", "§fAchat d'items de tout genres"));
	 
	 
	//job
	 GUImenu.setItem(3, ItemLores.FreeLore(Material.IRON_PICKAXE, 1, 0, "§6\u27A1 Recruteur", "§fRejoindre un job pour", "§fgagner de l'argent et des skills"));
	 
	 
	//armurier
	GUImenu.setItem(4, ItemLores.FreeLore(Material.DIAMOND_CHESTPLATE, 1, 0, "§6\u27A1 Armurier", "§fEquipement et outils"));
	
	
	//Instructeur
    GUImenu.setItem(5, ItemLores.FreeLore(Material.ENCHANTED_BOOK, 1, 0, "§6\u27A1 Instructeur", "§fAméliorez votre personnage"));
    
    
   //Banque
    GUImenu.setItem(6, ItemLores.FreeLore(Material.ENDER_CHEST, 1, 0, "§6\u27A1 Banquier", "§fDéposer vos items en lieu sûr"));
    
    
  //Sorcier
    GUImenu.setItem(7, ItemLores.FreeLore(Material.EYE_OF_ENDER, 1, 0, "§6\u27A1 Sorcière", "§fDe puissants sorts magiques!"));
	
    
  //Hotel des ventes
    GUImenu.setItem(8, ItemLores.FreeLore(Material.GOLD_INGOT, 1, 0, "§6\u27A1 Troqueur (Hotel des ventes)", "§fCommercez avec", "§fles autres joueurs!"));
	
    
    
  //xp
    GUImenu.setItem(14, ItemLores.FreeLore(Material.EXP_BOTTLE, 1, 0, "§6\u27A1 Banque d'EXP", "§fConserver votre EXP."));
    
  //agant
    GUImenu.setItem(15, ItemLores.FreeLore(Material.GOLD_SPADE, 1, 0, "§6\u27A1 Agent Immobilier", "§fAcheter des blocks/kits claims."));
    
    
	//Bibliothéque
    GUImenu.setItem(16, ItemLores.FreeLore(Material.BOOKSHELF, 1, 0, "§6\u27A1 Bibliothéque", "§fEnchantements."));
    
    
    //ferme
    GUImenu.setItem(17, ItemLores.FreeLore(Material.HAY_BLOCK, 1, 0, "§6\u27A1 Ferme", "§fSpawner a animaux"));
   
    
   
    //Alchimiste
    //GUImenu.setItem(14, ItemLores.FreeLore(Material.POTION, 1, 0, "§6\u27A1 Alchimiste", "§fAchetez et créez de puissantes potions"));
   
   
    
   
   
   
    //arene
    GUImenu.setItem(30, ItemLores.FreeLore(Material.IRON_SWORD, 1, 0, "§6\u27A1 Arène PVP", "§fAttention perte de stuff")); 
   
   
    //minage
    GUImenu.setItem(31, ItemLores.FreeLore(Material.DIAMOND_PICKAXE, 1, 0, "§6\u27A1 Monde Minage", "§fRégén: §aOui §7(Chaque dimanche)", "§fPVP: §cNon", "§fAnimaux: §aOui", "§fMontres: §aOui"));
  
  
    //nether
    GUImenu.setItem(32, ItemLores.FreeLore(Material.NETHERRACK, 1, 0, "§6\u27A1 Monde Nether", "§fRégén: §aOui §7(Chaque dimanche)", "§fPVP: §aOui", "§fAnimaux: §cnon", "§fMontres: §aOui"));
  
  
     //end
     GUImenu.setItem(33, ItemLores.FreeLore(Material.ENDER_STONE, 1, 0, "§6\u27A1 Monde End", "§fRégén: §cNon", "§fPVP: §aOui", "§fAnimaux: §cnon", "§fMontres: §aOui"));
     
     
     currentmenuItem = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
     SkullMeta meta42 = (SkullMeta) currentmenuItem.getItemMeta();
     meta42.setDisplayName("§b§l\u2720 Mes Infos/Team... \u2720");
     meta42.setOwner("Dinnerbone");
     lores.add("§7Vous pouvez accéder à ce menu");
     lores.add("§7aussi avec la commande /p");
     meta42.setLore(lores);
     currentmenuItem.setItemMeta(meta42);
     GUImenu.setItem(27,currentmenuItem);
     lores.clear();
     
     

     
     currentmenuItem = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
     SkullMeta meta00 = (SkullMeta) currentmenuItem.getItemMeta();
     meta00.setOwner("MHF_Question");
	 meta00.setDisplayName("§aMenu Aide");
	 currentmenuItem.setItemMeta(meta00);
	 GUImenu.setItem(35,currentmenuItem);
     lores.clear();
		
		return GUImenu;
		
	 }
	
	@EventHandler(priority=EventPriority.MONITOR)
	  public void guiClick(InventoryClickEvent event) {
		
		invetaryname = event.getInventory().getName();
		p = ((Player)event.getWhoClicked());
		   
		   if (!invetaryname.contains("§5\u2663 Navigateur \u2663")) return;
		   if ((event.getSlot() < 0) || (event.getSlot() > 53)) return;
		   event.setCancelled(true); 
		   if(event.getClick().isShiftClick()) { event.setCancelled(true); return;}
		   if(event.getSlotType() != InventoryType.SlotType.CONTAINER) { p.closeInventory(); return;}
		   
		   if (event.getCurrentItem().getType() == Material.COMPASS)
		     {
			   p.performCommand("spawn");
			   p.closeInventory();
			   event.setCancelled(true);
			   return;
		     }
		   
		   if (event.getCurrentItem().getType() == Material.CHEST)
		     {
			   p.performCommand("warp shop");
			   p.closeInventory();
			   event.setCancelled(true);
			   return;
		     }
		   
		   
		   if (event.getCurrentItem().getType() == Material.IRON_PICKAXE)
		     {
			   p.performCommand("warp job");
			   p.closeInventory();
			   event.setCancelled(true);
			   return;
		     }
		   
		   
		   
		   if (event.getCurrentItem().getType() == Material.DIAMOND_CHESTPLATE)
		     {
			   p.performCommand("warp armurier");
			   p.closeInventory();
			   event.setCancelled(true);
			   return;
		     }
		   
		   
		   
		   
		   if (event.getCurrentItem().getType() == Material.EMERALD)
		     {
			   p.performCommand("warp instructeur");
			   p.closeInventory();
			   event.setCancelled(true);
			   return;
		     }
		   
		   
		   
		   if (event.getCurrentItem().getType() == Material.ENDER_CHEST)
		     {
			   p.performCommand("warp banquier");
			   p.closeInventory();
			   event.setCancelled(true);
			   return;
		     }

		   
		   if (event.getCurrentItem().getType() == Material.EYE_OF_ENDER)
		     {
			   p.performCommand("warp sorcier");
			   p.closeInventory();
			   event.setCancelled(true);
			   return;
		     }
		   
		   
		   if (event.getCurrentItem().getType() == Material.GOLD_INGOT)
		     {
			   p.performCommand("warp hdv");
			   p.closeInventory();
			   event.setCancelled(true);
			   return;
		     }
		   
		   

		   
		   
		   if (event.getCurrentItem().getType() == Material.ENCHANTED_BOOK)
		     {
			   p.performCommand("warp instructeur");
			   p.closeInventory();
			   event.setCancelled(true);
			   return;
		     }
		   
		   if (event.getCurrentItem().getType() == Material.EXP_BOTTLE)
		     {
			   p.performCommand("warp banquexp");
			   p.closeInventory();
			   event.setCancelled(true);
			   return;
		     }
		   
		   
		   if (event.getCurrentItem().getType() == Material.GOLD_SPADE)
		     {
			   p.performCommand("warp agent");
			   p.closeInventory();
			   event.setCancelled(true);
			   return;
		     }
		   
		   
		   
		   
		   if (event.getCurrentItem().getType() == Material.BOOKSHELF)
		     {
			   p.performCommand("warp biblio");
			   p.closeInventory();
			   event.setCancelled(true);
			   return;
		     }
		   
		   
		   
		   if (event.getCurrentItem().getType() == Material.HAY_BLOCK)
		     {
			   p.performCommand("warp ferme");
			   p.closeInventory();
			   event.setCancelled(true);
			   return;
		     }
		   
		   
		   if (event.getCurrentItem().getType() == Material.IRON_SWORD)
		     {
			   p.performCommand("warp arene");
			   p.closeInventory();
			   event.setCancelled(true);
			   return;
		     }
		   
		   
		   if (event.getCurrentItem().getType() == Material.DIAMOND_PICKAXE)
		     {
			   p.performCommand("warp minage");
			   p.closeInventory();
			   event.setCancelled(true);
			   return;
		     }
		   
		   
		   if (event.getCurrentItem().getType() == Material.NETHERRACK)
		     {
			   p.performCommand("warp nether");
			   p.closeInventory();
			   event.setCancelled(true);
			   return;
		     }
		   
		   
		   if (event.getCurrentItem().getType() == Material.ENDER_STONE)
		     {
			   p.performCommand("warp end");
			   p.closeInventory();
			   event.setCancelled(true);
			   return;
		     }
		   
		   if (event.getSlot() == 27)
		     {
			   p.closeInventory();
			   p.openInventory(Pmenu.displayPmenu(p, true));
			   event.setCancelled(true);
			   return;
		     }
		   
		   
		   if (event.getSlot() == 35)
		     {
			   p.closeInventory();
			   p.openInventory(Aide.displayAide(true));
			   event.setCancelled(true);
			   return;
		     }

		   event.setCancelled(true);
		   p.closeInventory();
	}
	
	
	

}
