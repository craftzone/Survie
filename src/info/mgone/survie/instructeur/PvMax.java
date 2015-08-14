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

public class PvMax implements org.bukkit.event.Listener {
	
	
	public static Inventory GUIpvmax = null;
	static ItemStack currentpvmaxItem = null;
	static List<String> lores = new ArrayList<String>();
	Player p = null;
	String invetaryname = null;
	
	public static Inventory displayPvMax(Player p)
	 {
		GUIpvmax = Bukkit.createInventory(null, 9, "§5\u2663 Détermination \u2663");
		
		currentpvmaxItem = new ItemStack(Material.CHAINMAIL_CHESTPLATE,1);
	    ItemMeta meta0 = currentpvmaxItem.getItemMeta();
	    meta0.setDisplayName("§dPVMAX1");
	    lores.add("§bPV: §2+1");
	    lores.add(" ");
	    if(Perm.GetPermPv(p) >= 1) { meta0.addEnchant(Glow.glow, 1, false); lores.add("§fPrix: §adéjà acheté"); }
	    else { lores.add("§fPrix: §a5000$ + 50 Skill + 30 Exp");
	    lores.add("§cOu");
	    lores.add("§fPrix: §a100 SuperCoins");
	    lores.add("§7Clic gauche: payer avec des $,Skill...");
	    lores.add("§7Clic droit: payer avec des SuperCoins"); }
	    meta0.setLore(lores);
	    currentpvmaxItem.setItemMeta(meta0);
	    GUIpvmax.setItem(0,currentpvmaxItem);
	    lores.clear();
	    
	    currentpvmaxItem = new ItemStack(Material.CHAINMAIL_CHESTPLATE,2);
	    ItemMeta meta1 = currentpvmaxItem.getItemMeta();
	    meta1.setDisplayName("§dPVMAX2");
	    lores.add("§bPV: §2+2");
	    lores.add(" ");
	    if(Perm.GetPermPv(p) >= 2) { meta1.addEnchant(Glow.glow, 1, false); lores.add("§fPrix: §adéjà acheté"); }
	    else { lores.add("§fPrix: §a10000$ + 100 Skill + 40 Exp");
	    lores.add("§cOu");
	    lores.add("§fPrix: §a200 SuperCoins");
	    lores.add("§7Clic gauche: payer avec des $,Skill...");
	    lores.add("§7Clic droit: payer avec des SuperCoins"); }
	    meta1.setLore(lores);
	    currentpvmaxItem.setItemMeta(meta1);
	    GUIpvmax.setItem(1,currentpvmaxItem);
	    lores.clear();
	    
	    
	    currentpvmaxItem = new ItemStack(Material.CHAINMAIL_CHESTPLATE,3);
	    ItemMeta meta2 = currentpvmaxItem.getItemMeta();
	    meta2.setDisplayName("§dPVMAX3");
	    lores.add("§bPV: §2+3");
	    lores.add("§4Grade Guerrier et +");
	    lores.add(" ");
	    if(Perm.GetPermPv(p) >= 3) { meta2.addEnchant(Glow.glow, 1, false); lores.add("§fPrix: §adéjà acheté");  if(!p.hasPermission("pv.guerrier")) lores.add("§4Vous devez renouveler votre Grade!"); }
	    else { lores.add("§fPrix: §a20000$ + 150 Skill + 50 Exp");
	    lores.add("§cOu");
	    lores.add("§fPrix: §a300 SuperCoins");
	    lores.add("§7Clic gauche: payer avec des $,Skill...");
	    lores.add("§7Clic droit: payer avec des SuperCoins"); }
	    meta2.setLore(lores);
	    currentpvmaxItem.setItemMeta(meta2);
	    GUIpvmax.setItem(2,currentpvmaxItem);
	    lores.clear();
	    
	    
	    currentpvmaxItem = new ItemStack(Material.CHAINMAIL_CHESTPLATE,4);
	    ItemMeta meta3 = currentpvmaxItem.getItemMeta();
	    meta3.setDisplayName("§dPVMAX4");
	    lores.add("§bPV: §2+4");
	    lores.add("§4Grade Chevalier et +");
	    lores.add(" ");
	    if(Perm.GetPermPv(p) >= 4) { meta3.addEnchant(Glow.glow, 1, false); lores.add("§fPrix: §adéjà acheté");  if(!p.hasPermission("pv.chevalier")) lores.add("§4Vous devez renouveler votre Grade!"); }
	    else { lores.add("§fPrix: §a25000$ + 200 Skill + 50 Exp");
	    lores.add("§cOu");
	    lores.add("§fPrix: §a400 SuperCoins");
	    lores.add("§7Clic gauche: payer avec des $,Skill...");
	    lores.add("§7Clic droit: payer avec des SuperCoins"); }
	    meta3.setLore(lores);
	    currentpvmaxItem.setItemMeta(meta3);
	    GUIpvmax.setItem(3,currentpvmaxItem);
	    lores.clear();
	    
	    
	    
	    currentpvmaxItem = new ItemStack(Material.CHAINMAIL_CHESTPLATE,5);
	    ItemMeta meta4 = currentpvmaxItem.getItemMeta();
	    meta4.setDisplayName("§dPVMAX5");
	    lores.add("§bPV: §2+5");
	    lores.add("§4Grade Héros et +");
	    lores.add(" ");
	    if(Perm.GetPermPv(p) >= 5) { meta4.addEnchant(Glow.glow, 1, false); lores.add("§fPrix: §adéjà acheté");  if(!p.hasPermission("pv.heros")) lores.add("§4Vous devez renouveler votre Grade!");  }
	    else { lores.add("§fPrix: §a15000$ + 250 Skill + 50 Exp");
	    lores.add("§cOu");
	    lores.add("§fPrix: §a500 SuperCoins");
	    lores.add("§7Clic gauche: payer avec des $,Skill...");
	    lores.add("§7Clic droit: payer avec des SuperCoins"); }
	    meta4.setLore(lores);
	    currentpvmaxItem.setItemMeta(meta4);
	    GUIpvmax.setItem(4,currentpvmaxItem);
	    lores.clear();
		
		
		return GUIpvmax;
	 }
	
	@EventHandler(priority=EventPriority.MONITOR)
	  public void guiClick(InventoryClickEvent e) {
		
		invetaryname = e.getInventory().getName();
		p = ((Player)e.getWhoClicked());
		   
		   if (!invetaryname.contains("§5\u2663 Détermination \u2663")) return;
		   if ((e.getSlot() < 0) || (e.getSlot() > 53)) return;
		   e.setCancelled(true); 
		   if(e.getSlotType() != InventoryType.SlotType.CONTAINER) { p.closeInventory(); return;}
		
		   
		   if (e.getSlot() == 0)
		     {
			  if(e.getClick().isLeftClick()) { 
			   if(Perm.GetPermPv(p) >= 1) {
				   p.sendMessage("§cVous avez déjà acheter cette option!");
				   Checkm.closeNo(p);
				   return;
			   } else {
				   if(Checkm.CheckAll(p, 5000, 50, 30, false)) {
					   if(Perm.SetPermPv(p, 1)) { Checkm.CheckAll(p, 5000, 50, 30, true); p.sendMessage("§aVous avez maintenant 31 PV!"); Checkm.closeYes(p); }
					   else { p.sendMessage("§cUne erreur est survenue, patientez 5 secondes et réessayez!"); Checkm.closeNo(p);}
				   } else Checkm.closeNo(p);
				   
			   }
			  }
			  
			  if(e.getClick().isRightClick()) { 
				   if(Perm.GetPermPv(p) >= 1) {
					   p.sendMessage("§cVous avez déjà acheter cette option!");
					   Checkm.closeNo(p);
					   return;
				   } else {
					   if(Checkm.CheckSuperCoins(p, 100, false)) {
						   if(Perm.SetPermPv(p, 1)) { Checkm.CheckSuperCoins(p, 100, true); p.sendMessage("§aVous avez maintenant 31 PV!"); Checkm.closeYes(p); }
						   else { p.sendMessage("§cUne erreur est survenue, patientez 5 secondes et réessayez!"); Checkm.closeNo(p);}
					   } else Checkm.closeNo(p);
					   
				   }
				  }
			  
		     }
		   
		   if (e.getSlot() == 1)
		     {
			   
			   
			   if(e.getClick().isLeftClick()) {
				   if(Perm.GetPermPv(p) >= 2) {
					   p.sendMessage("§cVous avez déjà acheter cette option!");
					   Checkm.closeNo(p);
					   return;
				   } else if(Perm.GetPermPv(p) == 1) {
					   if(Checkm.CheckAll(p, 10000, 100, 40, false)) {
						   if(Perm.SetPermPv(p, 2)) { Checkm.CheckAll(p, 10000, 100, 40, true); p.sendMessage("§aVous avez maintenant 32 PV!"); Checkm.closeYes(p); }
						   else { p.sendMessage("§cUne erreur est survenue, patientez 5 secondes et réessayez!"); Checkm.closeNo(p);}
					   } else Checkm.closeNo(p); 
				   } else {
					   p.sendMessage("§cVous devez acheter l'option §6PVMAX1 §cavant pour pouvoir acheter cette option!"); 
					   Checkm.closeNo(p);
					   return;
				   }
				   
				  }
			   
			   
			   if(e.getClick().isRightClick()) {
				   if(Perm.GetPermPv(p) >= 2) {
					   p.sendMessage("§cVous avez déjà acheter cette option!");
					   Checkm.closeNo(p);
					   return;
				   } else if(Perm.GetPermPv(p) == 1) {
					   if(Checkm.CheckSuperCoins(p,200, false)) {
						   if(Perm.SetPermPv(p, 2)) { Checkm.CheckSuperCoins(p,200, true); p.sendMessage("§aVous avez maintenant 32 PV!"); Checkm.closeYes(p); }
						   else { p.sendMessage("§cUne erreur est survenue, patientez 5 secondes et réessayez!"); Checkm.closeNo(p);}
					   } else Checkm.closeNo(p); 
				   } else {
					   p.sendMessage("§cVous devez acheter l'option §6PVMAX1 §cavant pour pouvoir acheter cette option!"); 
					   Checkm.closeNo(p);
					   return;
				   }
				   
				  }

			   
		     }
		
		   
		   if (e.getSlot() == 2)
		     {
			   
			   if(!p.hasPermission("pv.guerrier")) { p.sendMessage("§cVous n'avez la permission d'acheter ceci qu'à partir du grade §6Guerrier et+!"); Checkm.closeNo(p); return; }
			   
			   if(e.getClick().isLeftClick()) {
				   if(Perm.GetPermPv(p) >= 3) {
					   p.sendMessage("§cVous avez déjà acheter cette option!");
					   Checkm.closeNo(p);
					   return;
				   } else if(Perm.GetPermPv(p) == 2) {
					   if(Checkm.CheckAll(p, 15000, 150, 50, false)) {
						   if(Perm.SetPermPv(p, 3)) { Checkm.CheckAll(p, 15000, 150, 50, true); p.sendMessage("§aVous avez maintenant 33 PV!"); Checkm.closeYes(p); }
						   else { p.sendMessage("§cUne erreur est survenue, patientez 5 secondes et réessayez!"); Checkm.closeNo(p);}
					   } else Checkm.closeNo(p); 
				   } else {
					   p.sendMessage("§cVous devez acheter l'option §6PVMAX2 §cavant pour pouvoir acheter cette option!"); 
					   Checkm.closeNo(p);
					   return;
				   }
				   
				  }
			   
			   
			   if(e.getClick().isRightClick()) {
				   if(Perm.GetPermPv(p) >= 3) {
					   p.sendMessage("§cVous avez déjà acheter cette option!");
					   Checkm.closeNo(p);
					   return;
				   } else if(Perm.GetPermPv(p) == 2) {
					   if(Checkm.CheckSuperCoins(p,300, false)) {
						   if(Perm.SetPermPv(p, 3)) { Checkm.CheckSuperCoins(p,300, true); p.sendMessage("§aVous avez maintenant 33 PV!"); Checkm.closeYes(p); }
						   else { p.sendMessage("§cUne erreur est survenue, patientez 5 secondes et réessayez!"); Checkm.closeNo(p);}
					   } else Checkm.closeNo(p); 
				   } else {
					   p.sendMessage("§cVous devez acheter l'option §6PVMAX2 §cavant pour pouvoir acheter cette option!"); 
					   Checkm.closeNo(p);
					   return;
				   }
				   
				  }

			   
		     }
		   
		   
		   
		   if (e.getSlot() == 3)
		     {
			   
			   if(!p.hasPermission("pv.chevalier")) { p.sendMessage("§cVous n'avez la permission d'acheter ceci qu'à partir du grade §6Chevalier et+!"); Checkm.closeNo(p); return; }
			   
			   if(e.getClick().isLeftClick()) {
				   if(Perm.GetPermPv(p) >= 4) {
					   p.sendMessage("§cVous avez déjà acheter cette option!");
					   Checkm.closeNo(p);
					   return;
				   } else if(Perm.GetPermPv(p) == 3) {
					   if(Checkm.CheckAll(p, 20000, 200, 50, false)) {
						   if(Perm.SetPermPv(p, 4)) { Checkm.CheckAll(p, 20000, 200, 50, true); p.sendMessage("§aVous avez maintenant 34 PV!"); Checkm.closeYes(p); }
						   else { p.sendMessage("§cUne erreur est survenue, patientez 5 secondes et réessayez!"); Checkm.closeNo(p);}
					   } else Checkm.closeNo(p); 
				   } else {
					   p.sendMessage("§cVous devez acheter l'option §6PVMAX3 §cavant pour pouvoir acheter cette option!"); 
					   Checkm.closeNo(p);
					   return;
				   }
				   
				  }
			   
			   
			   if(e.getClick().isRightClick()) {
				   if(Perm.GetPermPv(p) >= 4) {
					   p.sendMessage("§cVous avez déjà acheter cette option!");
					   Checkm.closeNo(p);
					   return;
				   } else if(Perm.GetPermPv(p) == 3) {
					   if(Checkm.CheckSuperCoins(p,400, false)) {
						   if(Perm.SetPermPv(p, 4)) { Checkm.CheckSuperCoins(p,400, true); p.sendMessage("§aVous avez maintenant 34 PV!"); Checkm.closeYes(p); }
						   else { p.sendMessage("§cUne erreur est survenue, patientez 5 secondes et réessayez!"); Checkm.closeNo(p);}
					   } else Checkm.closeNo(p); 
				   } else {
					   p.sendMessage("§cVous devez acheter l'option §6PVMAX3 §cavant pour pouvoir acheter cette option!"); 
					   Checkm.closeNo(p);
					   return;
				   }
				   
				  }

			   
		     }
		   
		   
		   
		   
		   if (e.getSlot() == 4)
		     {
			   
			   if(!p.hasPermission("pv.heros")) { p.sendMessage("§cVous n'avez la permission d'acheter ceci qu'à partir du grade §6Héros et+!"); Checkm.closeNo(p); return; }
			   
			   if(e.getClick().isLeftClick()) {
				   if(Perm.GetPermPv(p) >= 5) {
					   p.sendMessage("§cVous avez déjà acheter cette option!");
					   Checkm.closeNo(p);
					   return;
				   } else if(Perm.GetPermPv(p) == 4) {
					   if(Checkm.CheckAll(p, 25000, 250, 50, false)) {
						   if(Perm.SetPermPv(p, 5)) { Checkm.CheckAll(p, 25000, 250, 50, true); p.sendMessage("§aVous avez maintenant 35 PV!"); Checkm.closeYes(p); }
						   else { p.sendMessage("§cUne erreur est survenue, patientez 5 secondes et réessayez!"); Checkm.closeNo(p);}
					   } else Checkm.closeNo(p); 
				   } else {
					   p.sendMessage("§cVous devez acheter l'option §6PVMAX4 §cavant pour pouvoir acheter cette option!"); 
					   Checkm.closeNo(p);
					   return;
				   }
				   
				  }
			   
			   
			   if(e.getClick().isRightClick()) {
				   if(Perm.GetPermPv(p) >= 5) {
					   p.sendMessage("§cVous avez déjà acheter cette option!");
					   Checkm.closeNo(p);
					   return;
				   } else if(Perm.GetPermPv(p) == 4) {
					   if(Checkm.CheckSuperCoins(p,500, false)) {
						   if(Perm.SetPermPv(p, 5)) { Checkm.CheckSuperCoins(p,500, true); p.sendMessage("§aVous avez maintenant 35 PV!"); Checkm.closeYes(p); }
						   else { p.sendMessage("§cUne erreur est survenue, patientez 5 secondes et réessayez!"); Checkm.closeNo(p);}
					   } else Checkm.closeNo(p); 
				   } else {
					   p.sendMessage("§cVous devez acheter l'option §6PVMAX4 §cavant pour pouvoir acheter cette option!"); 
					   Checkm.closeNo(p);
					   return;
				   }
				   
				  }

			   
		     }
		   
		   
		   
	}
	

}
