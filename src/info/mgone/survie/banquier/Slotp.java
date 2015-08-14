package info.mgone.survie.banquier;

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

public class Slotp implements org.bukkit.event.Listener {
	
	
	public static Inventory GUIslot = null;
	static ItemStack currentslotItem = null;
	static List<String> lores = new ArrayList<String>();
	Player p = null;
	String invetaryname = null;
	
	public static Inventory displaySlotp(Player p)
	 {
		GUIslot = Bukkit.createInventory(null, 9, "§5\u2663 Slots \u2663");
		
		if(Perm.GetPermChestslot(p) >= 1) GUIslot.setItem(0, ItemLores.addGlow(ItemLores.FreeLore(Material.BEACON, 1, 0, "§b18 Slots", "§cPrix: §aDéjà acheté")));
		else GUIslot.setItem(0, ItemLores.FreeLore(Material.BEACON, 1, 0, "§b18 Slots", "§fPrix: §a1000$ + 10 Skill + 15 Exp", "§cOu", "§fPrix: §a20 SuperCoins", "§7Clic gauche: payer avec des $,Skill...", "§7Clic droit: payer avec des SuperCoins"));
		
		if(Perm.GetPermChestslot(p) >= 2) GUIslot.setItem(1, ItemLores.addGlow(ItemLores.FreeLore(Material.BEACON, 2, 0, "§b27 Slots", "§cPrix: §aDéjà acheté")));
		else GUIslot.setItem(1, ItemLores.FreeLore(Material.BEACON, 2, 0, "§b27 Slots", "§fPrix: §a2500$ + 25 Skill + 25 Exp", "§cOu", "§fPrix: §a40 SuperCoins", "§7Clic gauche: payer avec des $,Skill...", "§7Clic droit: payer avec des SuperCoins"));
		
		if(Perm.GetPermChestslot(p) >= 3) GUIslot.setItem(2, ItemLores.addGlow(ItemLores.FreeLore(Material.BEACON, 3, 0, "§b36 Slots", "§cPrix: §aDéjà acheté")));
		else GUIslot.setItem(2, ItemLores.FreeLore(Material.BEACON, 3, 0, "§b36 Slots", "§fPrix: §a5000$ + 50 Skill + 30 Exp", "§cOu", "§fPrix: §a65 SuperCoins", "§7Clic gauche: payer avec des $,Skill...", "§7Clic droit: payer avec des SuperCoins", "§4Grade Guerrier et +"));
		
		if(Perm.GetPermChestslot(p) >= 4) GUIslot.setItem(3, ItemLores.addGlow(ItemLores.FreeLore(Material.BEACON, 4, 0, "§b45 Slots", "§cPrix: §aDéjà acheté")));
		else GUIslot.setItem(3, ItemLores.FreeLore(Material.BEACON, 4, 0, "§b45 Slots", "§fPrix: §a10000$ + 100 Skill + 40 Exp", "§cOu", "§fPrix: §a100 SuperCoins", "§7Clic gauche: payer avec des $,Skill...", "§7Clic droit: payer avec des SuperCoins", "§4Grade Chevalier et +"));
		
		if(Perm.GetPermChestslot(p) >= 5) GUIslot.setItem(4, ItemLores.addGlow(ItemLores.FreeLore(Material.BEACON, 5, 0, "§b54 Slots", "§cPrix: §aDéjà acheté")));
		else GUIslot.setItem(4, ItemLores.FreeLore(Material.BEACON, 5, 0, "§b54 Slots", "§fPrix: §a15000$ + 150 Skill + 50 Exp", "§cOu", "§fPrix: §a165 SuperCoins", "§7Clic gauche: payer avec des $,Skill...", "§7Clic droit: payer avec des SuperCoins", "§4Grade Héros et +"));
		
		
		return GUIslot;
	 }
		
	
	@EventHandler(priority=EventPriority.MONITOR)
	  public void guiClick(InventoryClickEvent event) {
		
		invetaryname = event.getInventory().getName();
		p = ((Player)event.getWhoClicked());
		
		
		if (!invetaryname.contains("§5\u2663 Slots \u2663")) return;
		   if ((event.getSlot() < 0) || (event.getSlot() > 53)) return;
		   event.setCancelled(true); 
		   if(event.getClick().isShiftClick()) { event.setCancelled(true); return;}
		   if(event.getSlotType() != InventoryType.SlotType.CONTAINER) { p.closeInventory(); return;}
		   
		   ////////////////////////////////////////// 0 /////////////////////////////////
		   
		   if (event.getSlot() == 0)
		     {
			   
			  if(event.getClick().isLeftClick()) {
			   
			   if(Perm.GetPermChestslot(p) >= 1) {
				   p.sendMessage("§cVous avez déjà acheter cette option!");
				   Checkm.closeNo(p);
				   return;
			   } else {
				   if(Checkm.CheckAll(p,1000,10,15,false)) {
					   if(Perm.SetPermChestslot(p, 1)) { Checkm.CheckAll(p,1000,10,15,true); p.sendMessage("§aVous avez maintenant 18 slots dans votre coffre privé!"); Checkm.closeYes(p); }
					   else { p.sendMessage("§cUne erreur est survenue, patientez 5 secondes et réessayez!"); Checkm.closeNo(p);}
				   } else Checkm.closeNo(p);
				   
			   }
			   
			  } 
			  
			  
			  if(event.getClick().isRightClick()) {
				   
				   if(Perm.GetPermChestslot(p) >= 1) {
					   p.sendMessage("§cVous avez déjà acheter cette option!");
					   Checkm.closeNo(p);
					   return;
				   } else {
					   if(Checkm.CheckSuperCoins(p, 20, false)) {
						   if(Perm.SetPermChestslot(p, 1)) { Checkm.CheckSuperCoins(p, 20, true); p.sendMessage("§aVous avez maintenant 18 slots dans votre coffre privé!"); Checkm.closeYes(p); }
						   else { p.sendMessage("§cUne erreur est survenue, patientez 5 secondes et réessayez!"); Checkm.closeNo(p);}
					   } else Checkm.closeNo(p);
					   
				   }
				   
				  }
			  
			   
			   
		     }
		   
		   
             //////////////////////////////////////////1 /////////////////////////////////
		   
		   
		   if (event.getSlot() == 1)
		     {
			   
			 
			if(event.getClick().isLeftClick()) {	 
			
			   if(Perm.GetPermChestslot(p) >= 2) {
				   p.sendMessage("§cVous avez déjà acheter cette option!");
				   Checkm.closeNo(p);
				   return;
			   } else if(Perm.GetPermChestslot(p) == 1) {
				   if(Checkm.CheckAll(p,2500,25,25,false)) {
					   if(Perm.SetPermChestslot(p, 2)) { Checkm.CheckAll(p,2500,25,25,true); p.sendMessage("§aVous avez maintenant 27 slots dans votre coffre privé!"); Checkm.closeYes(p); }
					   else { p.sendMessage("§cUne erreur est survenue, patientez 5 secondes et réessayez!"); Checkm.closeNo(p);}
				   } else Checkm.closeNo(p);
				   
			   } else {
				   p.sendMessage("§cVous devez acheter l'option §618 §cslots avant pour pouvoir acheter cette option!"); 
				   Checkm.closeNo(p);
				   return;
			   }   
			   
			}
			
			
			if(event.getClick().isRightClick()) { 
				
				   if(Perm.GetPermChestslot(p) >= 2) {
					   p.sendMessage("§cVous avez déjà acheter cette option!");
					   Checkm.closeNo(p);
					   return;
				   } else if(Perm.GetPermChestslot(p) == 1) {
					   if(Checkm.CheckSuperCoins(p, 40, false)) {
						   if(Perm.SetPermChestslot(p, 2)) { Checkm.CheckSuperCoins(p, 40, true); p.sendMessage("§aVous avez maintenant 27 slots dans votre coffre privé!"); Checkm.closeYes(p); }
						   else { p.sendMessage("§cUne erreur est survenue, patientez 5 secondes et réessayez!"); Checkm.closeNo(p);}
					   } else Checkm.closeNo(p);
					   
				   } else {
					   p.sendMessage("§cVous devez acheter l'option §618 §cslots avant pour pouvoir acheter cette option!"); 
					   Checkm.closeNo(p);
					   return;
				   }   
				   
				}
			   
			   
		     }
		   
		   
              //////////////////////////////////////////2 /////////////////////////////////
		   
		   
		   if (event.getSlot() == 2)
		     {
			   
		if(!p.hasPermission("slots.guerrier")) { p.sendMessage("§cVous n'avez la permission d'acheter ceci qu'à partir du grade §6Guerrier et+!"); Checkm.closeNo(p); return; }
			   
			 if(event.getClick().isLeftClick()) {
				   
			   if(Perm.GetPermChestslot(p) >= 3) {
				   p.sendMessage("§cVous avez déjà acheter cette option!");
				   Checkm.closeNo(p);
				   return;
			   } else if(Perm.GetPermChestslot(p) == 2) {
				   if(Checkm.CheckAll(p,5000,50,30,false)) {
					   if(Perm.SetPermChestslot(p, 3)) { Checkm.CheckAll(p,5000,50,30,true); p.sendMessage("§aVous avez maintenant 36 slots dans votre coffre privé!"); Checkm.closeYes(p); }
					   else { p.sendMessage("§cUne erreur est survenue, patientez 5 secondes et réessayez!"); Checkm.closeNo(p);}
				   } else Checkm.closeNo(p);
				   
			   } else {
				   p.sendMessage("§cVous devez acheter l'option §627 §cslots avant pour pouvoir acheter cette option!"); 
				   Checkm.closeNo(p);
				   return;
			   }  
			   
			 }
			 
			 
			 if(event.getClick().isRightClick()) {
				   
				   if(Perm.GetPermChestslot(p) >= 3) {
					   p.sendMessage("§cVous avez déjà acheter cette option!");
					   Checkm.closeNo(p);
					   return;
				   } else if(Perm.GetPermChestslot(p) == 2) {
					   if(Checkm.CheckSuperCoins(p, 65, false)) {
						   if(Perm.SetPermChestslot(p, 3)) { Checkm.CheckSuperCoins(p, 65, true); p.sendMessage("§aVous avez maintenant 36 slots dans votre coffre privé!"); Checkm.closeYes(p); }
						   else { p.sendMessage("§cUne erreur est survenue, patientez 5 secondes et réessayez!"); Checkm.closeNo(p);}
					   } else Checkm.closeNo(p);
					   
				   } else {
					   p.sendMessage("§cVous devez acheter l'option §627 §cslots avant pour pouvoir acheter cette option!"); 
					   Checkm.closeNo(p);
					   return;
				   }  
				   
				 }
			 
			   
		     }
		   
		   
           //////////////////////////////////////////3 /////////////////////////////////
		   
		   
		   if (event.getSlot() == 3)
		     {
			   
			   if(!p.hasPermission("slots.chevalier")) { p.sendMessage("§cVous n'avez la permission d'acheter ceci qu'à partir du grade §6Chevalier et+!"); Checkm.closeNo(p); return; }
			   
			 if(event.getClick().isLeftClick()) {

			   if(Perm.GetPermChestslot(p) >= 4) {
				   p.sendMessage("§cVous avez déjà acheter cette option!");
				   Checkm.closeNo(p);
				   return;
			   } else if(Perm.GetPermChestslot(p) == 3) {
				   if(Checkm.CheckAll(p,10000,100,40,false)) {
					   if(Perm.SetPermChestslot(p, 4)) { Checkm.CheckAll(p,10000,100,40,true); p.sendMessage("§aVous avez maintenant 45 slots dans votre coffre privé!"); Checkm.closeYes(p); }
					   else { p.sendMessage("§cUne erreur est survenue, patientez 5 secondes et réessayez!"); Checkm.closeNo(p);}
				   } else Checkm.closeNo(p);
				   
			   } else {
				   p.sendMessage("§cVous devez acheter l'option §636 §cslots avant pour pouvoir acheter cette option!"); 
				   Checkm.closeNo(p);
				   return;
			   } 
			   
			 }
			 
			 
			 if(event.getClick().isRightClick()) {

				   if(Perm.GetPermChestslot(p) >= 4) {
					   p.sendMessage("§cVous avez déjà acheter cette option!");
					   Checkm.closeNo(p);
					   return;
				   } else if(Perm.GetPermChestslot(p) == 3) {
					   if(Checkm.CheckSuperCoins(p, 100, false)) {
						   if(Perm.SetPermChestslot(p, 4)) { Checkm.CheckSuperCoins(p, 100, true); p.sendMessage("§aVous avez maintenant 45 slots dans votre coffre privé!"); Checkm.closeYes(p); }
						   else { p.sendMessage("§cUne erreur est survenue, patientez 5 secondes et réessayez!"); Checkm.closeNo(p);}
					   } else Checkm.closeNo(p);
					   
				   } else {
					   p.sendMessage("§cVous devez acheter l'option §636 §cslots avant pour pouvoir acheter cette option!"); 
					   Checkm.closeNo(p);
					   return;
				   } 
				   
				 }
			 
			   
		     }
		   
		   
           //////////////////////////////////////////4 /////////////////////////////////
		   
		   
		   if (event.getSlot() == 4)
		     {
			   
			if(!p.hasPermission("slots.heros")) { p.sendMessage("§cVous n'avez la permission d'acheter ceci qu'à partir du grade §6Héros et+!"); Checkm.closeNo(p); return; }
			   
			if(event.getClick().isLeftClick()) {

			   if(Perm.GetPermChestslot(p) >= 5) {
				   p.sendMessage("§cVous avez déjà acheter cette option!");
				   Checkm.closeNo(p);
				   return;
			   } else if(Perm.GetPermChestslot(p) == 4) {
				   if(Checkm.CheckAll(p,15000,150,50,false)) {
					   if(Perm.SetPermChestslot(p, 5)) { Checkm.CheckAll(p,15000,150,50,true); p.sendMessage("§aVous avez maintenant 54 slots dans votre coffre privé!"); Checkm.closeYes(p); }
					   else { p.sendMessage("§cUne erreur est survenue, patientez 5 secondes et réessayez!"); Checkm.closeNo(p);}
				   } else Checkm.closeNo(p);
				   
			   } else {
				   p.sendMessage("§cVous devez acheter l'option §645 §cslots avant pour pouvoir acheter cette option!"); 
				   Checkm.closeNo(p);
				   return;
			   } 
			}
			
			
			if(event.getClick().isRightClick()) {

				   if(Perm.GetPermChestslot(p) >= 5) {
					   p.sendMessage("§cVous avez déjà acheter cette option!");
					   Checkm.closeNo(p);
					   return;
				   } else if(Perm.GetPermChestslot(p) == 4) {
					   if(Checkm.CheckSuperCoins(p, 165, false)) {
						   if(Perm.SetPermChestslot(p, 5)) { Checkm.CheckSuperCoins(p, 165, true); p.sendMessage("§aVous avez maintenant 54 slots dans votre coffre privé!"); Checkm.closeYes(p); }
						   else { p.sendMessage("§cUne erreur est survenue, patientez 5 secondes et réessayez!"); Checkm.closeNo(p);}
					   } else Checkm.closeNo(p);
					   
				   } else {
					   p.sendMessage("§cVous devez acheter l'option §645 §cslots avant pour pouvoir acheter cette option!"); 
					   Checkm.closeNo(p);
					   return;
				   } 
				}
			   
		     }
		   
		
		
	}

}
