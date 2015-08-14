package info.mgone.survie.instructeur;

import info.mgone.survie.Glow;

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

public class Speed implements org.bukkit.event.Listener {
	
	
	public static Inventory GUIspeed = null;
	static ItemStack currentspeedItem = null;
	static List<String> lores = new ArrayList<String>();
	Player p = null;
	String invetaryname = null;
	
	public static Inventory displaySpeed(Player p)
	 {
		GUIspeed = Bukkit.createInventory(null, 9, "§5\u2663 Speed \u2663");
		
		currentspeedItem = new ItemStack(Material.DIAMOND_BOOTS,1);
	    ItemMeta meta0 = currentspeedItem.getItemMeta();
	    meta0.setDisplayName("§6Speed1");
	    lores.add("§bVitesse: §2+3%");
	    lores.add(" ");
	    if(Perm.GetPermSpeed(p) >= 1) { meta0.addEnchant(Glow.glow, 1, false); lores.add("§fPrix: §aDéjà acheté");  }
	    else { lores.add("§fPrix: §a3000$ + 50 Skill + 30 Exp");
	    lores.add("§cOu");
	    lores.add("§fPrix: §a90 SuperCoins");
	    lores.add("§7Clic gauche: payer avec des $,Skill...");
	    lores.add("§7Clic droit: payer avec des SuperCoins"); }
	    meta0.setLore(lores);
	    currentspeedItem.setItemMeta(meta0);
	    GUIspeed.setItem(0,currentspeedItem);
	    lores.clear();
	    
	    currentspeedItem = new ItemStack(Material.DIAMOND_BOOTS,2);
	    ItemMeta meta1 = currentspeedItem.getItemMeta();
	    meta1.setDisplayName("§6Speed2");
	    lores.add("§bVitesse: §2+5%");
	    lores.add(" ");
	    if(Perm.GetPermSpeed(p) >= 2) { meta1.addEnchant(Glow.glow, 1, false); lores.add("§fPrix: §aDéjà acheté"); }
	    else { lores.add("§fPrix: §a5000$ + 100 Skill + 40 Exp");
	    lores.add("§cOu");
	    lores.add("§fPrix: §a150 SuperCoins");
	    lores.add("§7Clic gauche: payer avec des $,Skill...");
	    lores.add("§7Clic droit: payer avec des SuperCoins"); }
	    meta1.setLore(lores);
	    currentspeedItem.setItemMeta(meta1);
	    GUIspeed.setItem(1,currentspeedItem);
	    lores.clear();
	    
	    
	    currentspeedItem = new ItemStack(Material.DIAMOND_BOOTS,3);
	    ItemMeta meta2 = currentspeedItem.getItemMeta();
	    meta2.setDisplayName("§6Speed3");
	    lores.add("§bVitesse: §2+7%");
	    lores.add("§4Grade Guerrier et +");
	    lores.add(" ");
	    if(Perm.GetPermSpeed(p) >= 3) { meta2.addEnchant(Glow.glow, 1, false); lores.add("§fPrix: §aDéjà acheté");  if(!p.hasPermission("speed.guerrier")) lores.add("§4Vous devez renouveler votre Grade!"); }
	    else { lores.add("§fPrix: §a7000$ + 150 Skill + 50 Exp");
	    lores.add("§cOu");
	    lores.add("§fPrix: §a200 SuperCoins");
	    lores.add("§7Clic gauche: payer avec des $,Skill...");
	    lores.add("§7Clic droit: payer avec des SuperCoins"); }
	    meta2.setLore(lores);
	    currentspeedItem.setItemMeta(meta2);
	    GUIspeed.setItem(2,currentspeedItem);
	    lores.clear();
	    
	    
	    currentspeedItem = new ItemStack(Material.DIAMOND_BOOTS,4);
	    ItemMeta meta3 = currentspeedItem.getItemMeta();
	    meta3.setDisplayName("§6Speed4");
	    lores.add("§bVitesse: §2+9%");
	    lores.add("§4Grade Chevalier et +");
	    lores.add(" ");
	    if(Perm.GetPermSpeed(p) >= 4) { meta3.addEnchant(Glow.glow, 1, false); lores.add("§fPrix: §aDéjà acheté");  if(!p.hasPermission("speed.guerrier")) lores.add("§4Vous devez renouveler votre Grade!"); }
	    else { lores.add("§fPrix: §a9000$ + 200 Skill + 50 Exp");
	    lores.add("§cOu");
	    lores.add("§fPrix: §a250 SuperCoins");
	    lores.add("§7Clic gauche: payer avec des $,Skill...");
	    lores.add("§7Clic droit: payer avec des SuperCoins"); }
	    meta3.setLore(lores);
	    currentspeedItem.setItemMeta(meta3);
	    GUIspeed.setItem(3,currentspeedItem);
	    lores.clear();
	    
	    
	    currentspeedItem = new ItemStack(Material.DIAMOND_BOOTS,5);
	    ItemMeta meta4 = currentspeedItem.getItemMeta();
	    meta4.setDisplayName("§6Speed5");
	    lores.add("§bVitesse: §2+11%");
	    lores.add("§4Grade Héros et +");
	    lores.add(" ");
	    if(Perm.GetPermSpeed(p) >= 5) { meta4.addEnchant(Glow.glow, 1, false); lores.add("§fPrix: §aDéjà acheté");  if(!p.hasPermission("speed.guerrier")) lores.add("§4Vous devez renouveler votre Grade!"); }
	    else { lores.add("§fPrix: §a11000$ + 250 Skill + 50 Exp");
	    lores.add("§cOu");
	    lores.add("§fPrix: §a300 SuperCoins");
	    lores.add("§7Clic gauche: payer avec des $,Skill...");
	    lores.add("§7Clic droit: payer avec des SuperCoins"); }
	    meta4.setLore(lores);
	    currentspeedItem.setItemMeta(meta4);
	    GUIspeed.setItem(4,currentspeedItem);
	    lores.clear();
		
		
		return GUIspeed;
	 }
	
	@EventHandler(priority=EventPriority.MONITOR)
	  public void guiClick(InventoryClickEvent e) {
		
		invetaryname = e.getInventory().getName();
		p = ((Player)e.getWhoClicked());
		   
		   if (!invetaryname.contains("§5\u2663 Speed \u2663")) return;
		   if ((e.getSlot() < 0) || (e.getSlot() > 53)) return;
		   e.setCancelled(true); 
		   if(e.getSlotType() != InventoryType.SlotType.CONTAINER) { p.closeInventory(); return;}
		
		   
		   
		   
		   if (e.getSlot() == 0)
		     {
			  if(e.getClick().isLeftClick()) { 
			   if(Perm.GetPermSpeed(p) >= 1) {
				   p.sendMessage("§cVous avez déjà acheter cette option!");
				   Checkm.closeNo(p);
				   return;
			   } else {
				   if(Checkm.CheckAll(p, 3000, 50, 30, false)) {
					   if(Perm.SetPermSpeed(p, 1)) { Checkm.CheckAll(p, 3000, 50, 30, true); p.sendMessage("§aVous avez maintenant +3% de vitesse!"); Checkm.closeYes(p); }
					   else { p.sendMessage("§cUne erreur est survenue, patientez 5 secondes et réessayez!"); Checkm.closeNo(p);}
				   } else Checkm.closeNo(p);
				   
			   }
			  }
			  
			  if(e.getClick().isRightClick()) { 
				   if(Perm.GetPermSpeed(p) >= 1) {
					   p.sendMessage("§cVous avez déjà acheter cette option!");
					   Checkm.closeNo(p);
					   return;
				   } else {
					   if(Checkm.CheckSuperCoins(p, 90, false)) {
						   if(Perm.SetPermSpeed(p, 1)) { Checkm.CheckSuperCoins(p, 90, true); p.sendMessage("§aVous avez maintenant +3% de vitesse!"); Checkm.closeYes(p); }
						   else { p.sendMessage("§cUne erreur est survenue, patientez 5 secondes et réessayez!"); Checkm.closeNo(p);}
					   } else Checkm.closeNo(p);
					   
				   }
				  }
			  
		     }
		   
		   if (e.getSlot() == 1)
		     {
			   
			   
			   if(e.getClick().isLeftClick()) {
				   if(Perm.GetPermSpeed(p) >= 2) {
					   p.sendMessage("§cVous avez déjà acheter cette option!");
					   Checkm.closeNo(p);
					   return;
				   } else if(Perm.GetPermSpeed(p) == 1) {
					   if(Checkm.CheckAll(p, 5000, 100, 40, false)) {
						   if(Perm.SetPermSpeed(p, 2)) { Checkm.CheckAll(p, 5000, 100, 40, true); p.sendMessage("§aVous avez maintenant +5% de vitesse!"); Checkm.closeYes(p); }
						   else { p.sendMessage("§cUne erreur est survenue, patientez 5 secondes et réessayez!"); Checkm.closeNo(p);}
					   } else Checkm.closeNo(p); 
				   } else {
					   p.sendMessage("§cVous devez acheter l'option §6Speed1 §cavant pour pouvoir acheter cette option!"); 
					   Checkm.closeNo(p);
					   return;
				   }
				   
				  }
			   
			   
			   if(e.getClick().isRightClick()) {
				   if(Perm.GetPermSpeed(p) >= 2) {
					   p.sendMessage("§cVous avez déjà acheter cette option!");
					   Checkm.closeNo(p);
					   return;
				   } else if(Perm.GetPermSpeed(p) == 1) {
					   if(Checkm.CheckSuperCoins(p,150, false)) {
						   if(Perm.SetPermSpeed(p, 2)) { Checkm.CheckSuperCoins(p,150, true); p.sendMessage("§aVous avez maintenant +5% de vitesse!"); Checkm.closeYes(p); }
						   else { p.sendMessage("§cUne erreur est survenue, patientez 5 secondes et réessayez!"); Checkm.closeNo(p);}
					   } else Checkm.closeNo(p); 
				   } else {
					   p.sendMessage("§cVous devez acheter l'option §6Speed1 §cavant pour pouvoir acheter cette option!"); 
					   Checkm.closeNo(p);
					   return;
				   }
				   
				  }

			   
		     }
		
		   
		   if (e.getSlot() == 2)
		     {
			   
			   if(!p.hasPermission("speed.guerrier")) { p.sendMessage("§cVous n'avez la permission d'acheter ceci qu'à partir du grade §6Guerrier et+!"); Checkm.closeNo(p); return; }
			   
			   if(e.getClick().isLeftClick()) {
				   if(Perm.GetPermSpeed(p) >= 3) {
					   p.sendMessage("§cVous avez déjà acheter cette option!");
					   Checkm.closeNo(p);
					   return;
				   } else if(Perm.GetPermSpeed(p) == 2) {
					   if(Checkm.CheckAll(p, 7000, 150, 50, false)) {
						   if(Perm.SetPermSpeed(p, 3)) { Checkm.CheckAll(p, 7000, 150, 50, true); p.sendMessage("§aVous avez maintenant +7% de vitesse!"); Checkm.closeYes(p); }
						   else { p.sendMessage("§cUne erreur est survenue, patientez 5 secondes et réessayez!"); Checkm.closeNo(p);}
					   } else Checkm.closeNo(p); 
				   } else {
					   p.sendMessage("§cVous devez acheter l'option §6Speed2 §cavant pour pouvoir acheter cette option!"); 
					   Checkm.closeNo(p);
					   return;
				   }
				   
				  }
			   
			   
			   if(e.getClick().isRightClick()) {
				   if(Perm.GetPermSpeed(p) >= 3) {
					   p.sendMessage("§cVous avez déjà acheter cette option!");
					   Checkm.closeNo(p);
					   return;
				   } else if(Perm.GetPermSpeed(p) == 2) {
					   if(Checkm.CheckSuperCoins(p,200, false)) {
						   if(Perm.SetPermSpeed(p, 3)) { Checkm.CheckSuperCoins(p,200, true); p.sendMessage("§aVous avez maintenant +7% de vitesse!"); Checkm.closeYes(p); }
						   else { p.sendMessage("§cUne erreur est survenue, patientez 5 secondes et réessayez!"); Checkm.closeNo(p);}
					   } else Checkm.closeNo(p); 
				   } else {
					   p.sendMessage("§cVous devez acheter l'option §6Speed2 §cavant pour pouvoir acheter cette option!"); 
					   Checkm.closeNo(p);
					   return;
				   }
				   
				  }

			   
		     }
		   
		   
		   
		   
		   
		   if (e.getSlot() == 3)
		     {
			   
			   if(!p.hasPermission("speed.chevalier")) { p.sendMessage("§cVous n'avez la permission d'acheter ceci qu'à partir du grade §6Chevalier et+!"); Checkm.closeNo(p); return; }
			   
			   if(e.getClick().isLeftClick()) {
				   if(Perm.GetPermSpeed(p) >= 4) {
					   p.sendMessage("§cVous avez déjà acheter cette option!");
					   Checkm.closeNo(p);
					   return;
				   } else if(Perm.GetPermSpeed(p) == 3) {
					   if(Checkm.CheckAll(p, 9000, 200, 50, false)) {
						   if(Perm.SetPermSpeed(p, 4)) { Checkm.CheckAll(p, 9000, 200, 50, true); p.sendMessage("§aVous avez maintenant +9% de vitesse!"); Checkm.closeYes(p); }
						   else { p.sendMessage("§cUne erreur est survenue, patientez 5 secondes et réessayez!"); Checkm.closeNo(p);}
					   } else Checkm.closeNo(p); 
				   } else {
					   p.sendMessage("§cVous devez acheter l'option §6Speed3 §cavant pour pouvoir acheter cette option!"); 
					   Checkm.closeNo(p);
					   return;
				   }
				   
				  }
			   
			   
			   if(e.getClick().isRightClick()) {
				   if(Perm.GetPermSpeed(p) >= 4) {
					   p.sendMessage("§cVous avez déjà acheter cette option!");
					   Checkm.closeNo(p);
					   return;
				   } else if(Perm.GetPermSpeed(p) == 3) {
					   if(Checkm.CheckSuperCoins(p,250, false)) {
						   if(Perm.SetPermSpeed(p, 4)) { Checkm.CheckSuperCoins(p,250, true); p.sendMessage("§aVous avez maintenant +9% de vitesse!"); Checkm.closeYes(p); }
						   else { p.sendMessage("§cUne erreur est survenue, patientez 5 secondes et réessayez!"); Checkm.closeNo(p);}
					   } else Checkm.closeNo(p); 
				   } else {
					   p.sendMessage("§cVous devez acheter l'option §6Speed3 §cavant pour pouvoir acheter cette option!"); 
					   Checkm.closeNo(p);
					   return;
				   }
				   
				  }
			   
		     }
		   
		   
		   
		   
		   
		   
		   
		   if (e.getSlot() == 4)
		     {
			   
			   if(!p.hasPermission("speed.heros")) { p.sendMessage("§cVous n'avez la permission d'acheter ceci qu'à partir du grade §6Héros et+!"); Checkm.closeNo(p); return; }
			   
			   if(e.getClick().isLeftClick()) {
				   if(Perm.GetPermSpeed(p) >= 5) {
					   p.sendMessage("§cVous avez déjà acheter cette option!");
					   Checkm.closeNo(p);
					   return;
				   } else if(Perm.GetPermSpeed(p) == 4) {
					   if(Checkm.CheckAll(p, 11000, 250, 50, false)) {
						   if(Perm.SetPermSpeed(p, 5)) { Checkm.CheckAll(p, 11000, 250, 50, true); p.sendMessage("§aVous avez maintenant +11% de vitesse!"); Checkm.closeYes(p); }
						   else { p.sendMessage("§cUne erreur est survenue, patientez 5 secondes et réessayez!"); Checkm.closeNo(p);}
					   } else Checkm.closeNo(p); 
				   } else {
					   p.sendMessage("§cVous devez acheter l'option §6Speed4 §cavant pour pouvoir acheter cette option!"); 
					   Checkm.closeNo(p);
					   return;
				   }
				   
				  }
			   
			   
			   if(e.getClick().isRightClick()) {
				   if(Perm.GetPermSpeed(p) >= 5) {
					   p.sendMessage("§cVous avez déjà acheter cette option!");
					   Checkm.closeNo(p);
					   return;
				   } else if(Perm.GetPermSpeed(p) == 4) {
					   if(Checkm.CheckSuperCoins(p,300, false)) {
						   if(Perm.SetPermSpeed(p, 5)) { Checkm.CheckSuperCoins(p,300, true); p.sendMessage("§aVous avez maintenant +11% de vitesse!"); Checkm.closeYes(p); }
						   else { p.sendMessage("§cUne erreur est survenue, patientez 5 secondes et réessayez!"); Checkm.closeNo(p);}
					   } else Checkm.closeNo(p); 
				   } else {
					   p.sendMessage("§cVous devez acheter l'option §6Speed4 §cavant pour pouvoir acheter cette option!"); 
					   Checkm.closeNo(p);
					   return;
				   }
				   
				  }
			   
		     }
		   
		      
		
	}
	
	
	
	
	
	

}
