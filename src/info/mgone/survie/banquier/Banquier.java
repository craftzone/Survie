package info.mgone.survie.banquier;

import info.mgone.survie.Glow;
import info.mgone.survie.Survie;
import info.mgone.survie.gui.AttributesLore.ItemLores;
import info.mgone.survie.instructeur.Checkm;
import info.mgone.survie.instructeur.Perm;

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

public class Banquier implements org.bukkit.event.Listener {
	
	
	public static Inventory GUIbanque = null;
	static ItemStack currentbanqueItem = null;
	static List<String> lores = new ArrayList<String>();
	Player p = null;
	String invetaryname = null;
	
	public static Inventory displayBanque(Player p)
	 {
		GUIbanque = Bukkit.createInventory(null, 9, "§5\u2663 Banquier \u2663");
		
	GUIbanque.setItem(0, ItemLores.FreeLore(Material.ENDER_CHEST, 1, 0, "§bMa Banque", "§dVotre coffre privé.", "§fVous pouvez socker ici", "§fvos items en toute", "§fsécurité."));
	
	GUIbanque.setItem(6, ItemLores.FreeLore(Material.CHEST, 1, 0, "§dSlots", "§fAcheter plus de slot", "§fpour votre coffre privé."));
	
	
	currentbanqueItem = new ItemStack(Material.ENDER_PORTAL_FRAME,1);
    ItemMeta meta1 = currentbanqueItem.getItemMeta();
    meta1.setDisplayName("§6Enderchest");
    lores.add("§fAcheter cette option pour avoir");
    lores.add("§fl'accès à votre coffre privé");
    lores.add("§fdepuis n'importe quel enderchest,");
    lores.add("§fla permission de le crafter et pose.");
    lores.add(" ");
    if(Perm.GetPermChestender(p) != 0) { meta1.addEnchant(Glow.glow, 1, false); lores.add("§fPrix: §aDéjà acheté"); }
    else { lores.add("§fPrix: §a500$ + 10 Skill + 10 Exp");
    lores.add("§cOu");
    lores.add("§fPrix: §a20 SuperCoins");
    lores.add("§7Clic gauche: payer avec des $,Skill...");
    lores.add("§7Clic droit: payer avec des SuperCoins"); }
    meta1.setLore(lores);
    currentbanqueItem.setItemMeta(meta1);
    GUIbanque.setItem(7,currentbanqueItem);
    lores.clear();
	
	
	currentbanqueItem = new ItemStack(Material.COMMAND,1);
    ItemMeta meta2 = currentbanqueItem.getItemMeta();
    meta2.setDisplayName("§aCommandeChest");
    lores.add("§fAcheter cette option pour avoir");
    lores.add("§fl'accès à votre coffre privé");
    lores.add("§fdepuis la commande §c§l/banque ou /b");
    lores.add(" ");
    if(Perm.GetPermChestcmd(p) != 0) { meta2.addEnchant(Glow.glow, 1, false); lores.add("§fPrix: §aDéjà acheté"); }
    else { lores.add("§fPrix: §a10000$ + 50 Skill + 30 Exp");
    lores.add("§cOu");
    lores.add("§fPrix: §a200 SuperCoins");
    lores.add("§7Clic gauche: payer avec des $,Skill...");
    lores.add("§7Clic droit: payer avec des SuperCoins"); }
    meta2.setLore(lores);
    currentbanqueItem.setItemMeta(meta2);
    GUIbanque.setItem(8,currentbanqueItem);
    lores.clear();
	
	
    
		return GUIbanque;
	 }
	
	@EventHandler(priority=EventPriority.MONITOR)
	  public void guiClick(InventoryClickEvent event) {
		
		
		invetaryname = event.getInventory().getName();
		p = ((Player)event.getWhoClicked());
		   
		   if (!invetaryname.contains("§5\u2663 Banquier \u2663")) return;
		   if ((event.getSlot() < 0) || (event.getSlot() > 53)) return;
		   event.setCancelled(true); 
		   if(event.getClick().isShiftClick()) { event.setCancelled(true); return;}
		   if(event.getSlotType() != InventoryType.SlotType.CONTAINER) { p.closeInventory(); return;}
		   
		   
		   
		   if (event.getCurrentItem().getType() == Material.ENDER_CHEST)
		     {
			   p.closeInventory();
			   Survie.permission.playerAddTransient(p, "betterenderchest.command.openinv");
			   p.performCommand("bec openinv");
			   Survie.permission.playerRemoveTransient(p, "betterenderchest.command.openinv");
			   return;
		     }
		   
		   
		   if (event.getCurrentItem().getType() == Material.CHEST)
		     {
			   p.closeInventory();
			   p.openInventory(Slotp.displaySlotp(p));
			   return;
		     }
		   
		   
		   if (event.getCurrentItem().getType() == Material.ENDER_PORTAL_FRAME)
		     {
			   
			  if(event.getClick().isLeftClick()) { 
			  
			   if(Perm.GetPermChestender(p) != 0) {
			   p.sendMessage("§cVous avez déjà acheter cette option!");
			   Checkm.closeNo(p);
			   return; }
			   
			   else {
				   
				  if(Checkm.CheckAll(p, 500, 10, 10, false)) {
					  if(Perm.SetPermChestender(p)) { Checkm.CheckAll(p, 500, 10, 10, true); p.sendMessage("§aVous pouvez maintenant accéder à votre coffre privé depuis n'importe quel enderchest!"); Checkm.closeYes(p); }
					  else { p.sendMessage("§cUne erreur est survenue, patientez 5 secondes et réessayez!"); Checkm.closeNo(p);}
				  } else Checkm.closeNo(p);
				  
				  return;  
			   }
			   
			  }
			  
			  
			  
			  if(event.getClick().isRightClick()) { 
				  
				   if(Perm.GetPermChestender(p) != 0) {
				   p.sendMessage("§cVous avez dèja acheter cette option!");
				   Checkm.closeNo(p);
				   return; }
				   
				   else {
					   
					  if(Checkm.CheckSuperCoins(p, 20, false)) {
						  if(Perm.SetPermChestender(p)) { Checkm.CheckSuperCoins(p, 20, true); p.sendMessage("§aVous pouvez maintenant accéder à votre coffre privé depuis n'importe quel enderchest!"); Checkm.closeYes(p); }
						  else { p.sendMessage("§cUne erreur est survenue, patientez 5 secondes et réessayez!"); Checkm.closeNo(p);}
					  } else Checkm.closeNo(p);
					  
					  return;  
				   }
				   
				  }
			  
			  
			   
		     }
		   
		   
		   
		   if (event.getCurrentItem().getType() == Material.COMMAND)
		     {
			   
			  if(event.getClick().isLeftClick()) { 
				  
			   if(Perm.GetPermChestcmd(p) != 0) {
				   p.sendMessage("§cVous avez déjà acheter cette option!");
				   Checkm.closeNo(p);
				   return; }
				   
				   else if(p.hasPermission("betterenderchest.user.open")) {
					   
					  if(Checkm.CheckAll(p, 10000, 50, 30, false)) {
						  if(Perm.SetPermChestcmd(p)) { Checkm.CheckAll(p, 5000, 50, 20, true); p.sendMessage("§aVous pouvez maintenant accéder à votre coffre privé depuis la commande §c§l/banque ou /b."); Checkm.closeYes(p); }
						  else { p.sendMessage("§cUne erreur est survenue, patientez 5 secondes et réessayez!"); Checkm.closeNo(p);}
					  } else Checkm.closeNo(p);
					  
					  return;  
				   } else {
					   p.sendMessage("§cVous devez acheter l'option §6Enderchest §cavant pour pouvoir acheter cette option!"); 
					   Checkm.closeNo(p);
					   return;
				   }
		       }
			  
			  
			  if(event.getClick().isRightClick()) { 
				  
				   if(Perm.GetPermChestcmd(p) != 0) {
					   p.sendMessage("§cVous avez déjà acheter cette option!");
					   Checkm.closeNo(p);
					   return; }
					   
					   else if(p.hasPermission("betterenderchest.user.open")) {
						   
						  if(Checkm.CheckSuperCoins(p, 100, false)) {
							  if(Perm.SetPermChestcmd(p)) { Checkm.CheckSuperCoins(p, 100, true); p.sendMessage("§aVous pouvez maintenant accéder à votre coffre privé depuis la commande §c§l/banque ou /b."); Checkm.closeYes(p); }
							  else { p.sendMessage("§cUne erreur est survenue, patientez 5 secondes et réessayez!"); Checkm.closeNo(p);}
						  } else Checkm.closeNo(p);
						  
						  return;  
					   } else {
						   p.sendMessage("§cVous devez acheter l'option §6Enderchest §cavant pour pouvoir acheter cette option!"); 
						   Checkm.closeNo(p);
						   return;
					   }
			       }
			   
			   
			   
		     }
		
	}
	
	
	
	

}
