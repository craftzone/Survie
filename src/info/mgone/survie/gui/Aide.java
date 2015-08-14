package info.mgone.survie.gui;

import info.mgone.survie.Glow;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Aide implements Listener {
	
	public static Inventory GUIaide = null;
	static ItemStack currentaideItem = null;
	static List<String> lores = new ArrayList<String>();
	Player p = null;
	String invetaryname = null;
	
	public static Inventory displayAide(boolean retour)
	 {
		
		GUIaide = Bukkit.createInventory(null, 9, "§5\u2663 Aide et Commandes \u2663");
		
		 currentaideItem = new ItemStack(Material.COMMAND, 1);
	     ItemMeta meta0 = currentaideItem.getItemMeta();
	     meta0.setDisplayName("§5\u25C6 Commandes générales \u25C6");
	     lores.add("§a/aide: §fCommandes disponibles.");
	     lores.add("§b/sethome: §fPoser votre home.");
	     lores.add("§a/home: §fSe téléporter à votre home.");
	     lores.add("§b/aide tp: §fAide téléportation entre joueurs.");
	     lores.add("§a/pay <joueur> <somme>: §fEnvoyer de l'argent.");
	     lores.add("§b/msg [joueur] message: §fenvoyer un message privé.");
	     lores.add("§a/list: §fPour afficher la liste des joueurs connectés.");
	     lores.add("§b/lobby: §fRetourner au lobby(spawn principal).");
	     meta0.setLore(lores);
	     currentaideItem.setItemMeta(meta0);
	     GUIaide.setItem(2,currentaideItem);
	     lores.clear();
	     
	     
	     currentaideItem = new ItemStack(Material.COMPASS, 1);
	     ItemMeta meta1 = currentaideItem.getItemMeta();
	     meta1.setDisplayName("§6\u25C6 Commandes rapide \u25C6");
	     meta1.addEnchant(Glow.glow, 1, false);
	     lores.add("§b/s: §fNavigateur pour se téléporter.");
	     lores.add("§a/p: §fVoir vos stats, argent...");
	     lores.add("§b/tm: §fGérer votre team.");
	     meta1.setLore(lores);
	     currentaideItem.setItemMeta(meta1);
	     GUIaide.setItem(3,currentaideItem);
	     lores.clear();
	     
	     
	     currentaideItem = new ItemStack(Material.GOLD_SPADE, 1);
	     ItemMeta meta2 = currentaideItem.getItemMeta();
	     meta2.setDisplayName("§b\u25C6 Aide Claim \u25C6");
	     lores.add("§c-Pour Claim votre premier terrain");
	     lores.add("§cutilisez le coffre claim du kit.");
	     lores.add("§fil suffit de le poser sur un terrain");
	     lores.add("§fet la zone qui l'entoure de surface");
	     lores.add("§f9x9 devient votre claim.");
	     lores.add("§e-Pour agrandir un claim utilisez");
	     lores.add("§ela pelle en or du kit.");
	     lores.add("§d-pour plus de details sur les claims");
	     lores.add("§dpassez voir l'agent immobilier.");
	     lores.add("§a/claim: §fGérer vos claims.");
	     meta2.setLore(lores);
	     currentaideItem.setItemMeta(meta2);
	     GUIaide.setItem(4,currentaideItem);
	     lores.clear();
	     
	     
	     currentaideItem = new ItemStack(Material.TNT, 1);
	     ItemMeta meta3 = currentaideItem.getItemMeta();
	     meta3.setDisplayName("§a\u25C6 Protection Terrain \u25C6");
	     lores.add("§d-La TNT et les oeufs de creeper");
	     lores.add("§dsont activé, l'obsidienne est");
	     lores.add("§ddestructible comme n'importe");
	     lores.add("§dquel block et l'eau ne bloque");
	     lores.add("§dpas les explosions.");
	     lores.add("§c-Les Claims sont vulnérables aux");
	     lores.add("§cexplosions seulement en cas,");
	     lores.add("§cd'assiègement §d(voir 'pvp' pour");
	     lores.add("§dplus de détails).");
	     lores.add("§a-Les zones souterraines ne sont");
	     lores.add("§apas protéger de la TNT même si");
	     lores.add("§ale terrain est claim, donc evitez");
	     lores.add("§ade construire au dessous du");
	     lores.add("§aniveau de la mer (couche y= 60)");
	     meta3.setLore(lores);
	     currentaideItem.setItemMeta(meta3);
	     GUIaide.setItem(5,currentaideItem);
	     lores.clear();
	     
	     
	     
	     currentaideItem = new ItemStack(Material.DIAMOND_SWORD, 1);
	     ItemMeta meta4 = currentaideItem.getItemMeta();
	     meta4.setDisplayName("§c\u25C6 PVP \u25C6");
	     lores.add("§6-Pour attaquer un claim d'un");
	     lores.add("§6joueur, il doit être dans son");
	     lores.add("§6claim, avec la commande §c§l/siege");
	     lores.add("§6vous l'assiégé, §ddans ce cas");
	     lores.add("§dson claim devient vulnérable");
	     lores.add("§daux explosions.");
	     lores.add("§fEn état de siège le joueur n'a");
	     lores.add("§fpas le droit de se déconnecter");
	     lores.add("§fni a l'accès a ses coffres.");
	     meta4.setLore(lores);
	     currentaideItem.setItemMeta(meta4);
	     GUIaide.setItem(6,currentaideItem);
	     lores.clear();
	     
	     
	   //wood door
	     if(retour) {
  	     currentaideItem = new ItemStack(Material.WOOD_DOOR, 1);
	     ItemMeta meta44 = currentaideItem.getItemMeta();
	     meta44.setDisplayName("§c§l\u27A1 Retour");
	     currentaideItem.setItemMeta(meta44);
	     GUIaide.setItem(8,currentaideItem);
	     lores.clear(); }
	     
		
		
		return GUIaide;
	 }
	
	
	
	@EventHandler(priority=EventPriority.MONITOR)
	  public void guiClick(InventoryClickEvent event) {
		
		invetaryname = event.getInventory().getName();
		p = ((Player)event.getWhoClicked());
		
		if (!invetaryname.contains("§5\u2663 Aide et Commandes \u2663")) return;
		   if ((event.getSlot() < 0) || (event.getSlot() > 53)) return;
		   event.setCancelled(true); 
		   if(event.getClick().isShiftClick()) { p.closeInventory();  return;}
		   if(event.getSlotType() != InventoryType.SlotType.CONTAINER) { p.closeInventory(); return;}
		   
		   if (event.getSlot() == 8)
		   {
			   p.closeInventory();
			   p.openInventory(Menu.displayMenu());
			   event.setCancelled(true);
			   return;
		   }
		
	}

}
