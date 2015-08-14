package info.mgone.survie.agent;

import info.mgone.survie.Glow;
import info.mgone.survie.gui.marchant.GiveM;

import java.util.ArrayList;
import java.util.List;

import me.ryanhamshire.GriefPrevention.Claim;
import me.ryanhamshire.GriefPrevention.GriefPrevention;
import me.ryanhamshire.GriefPrevention.PlayerData;

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


public class Agent implements org.bukkit.event.Listener {
	
	
	public static Inventory GUIagent = null;
	static ItemStack currentagenItem = null;
	static List<String> lores = new ArrayList<String>();
	Player p = null;
	String invetaryname = null;
	
	
	public static Inventory displayAgent(Player p)
	 {
		GUIagent = Bukkit.createInventory(null, 9, "§5\u2663 Claims \u2663");
		
		
		PlayerData playerData = GriefPrevention.instance.dataStore.getPlayerData(p.getUniqueId());
		int remainingBlocks = playerData.getRemainingClaimBlocks();
		int usedBlocks = playerData.getAccruedClaimBlocks() - remainingBlocks;
		
		 currentagenItem = new ItemStack(Material.GOLD_SPADE, 1);
	     ItemMeta meta0 = currentagenItem.getItemMeta();
	     meta0.setDisplayName("§a\u25C6 Mes Blocks Claim \u25C6");
	     lores.add("§f-Blocks restant: §6"+ remainingBlocks);
	     lores.add("§7C'est le nombres de block qui");
	     lores.add("§7sont disponibles pour vous pour");
	     lores.add("§7claim. §dCe nombre represente la");
	     lores.add("§dsurface, §7par exemple si vous");
	     lores.add("§7avez 100 block, vous pouvez claim");
	     lores.add("§7un terrain de 10x10.");
	     meta0.setLore(lores);
	     currentagenItem.setItemMeta(meta0);
	     GUIagent.setItem(0,currentagenItem);
	     lores.clear();
	     
	     
	     currentagenItem = new ItemStack(Material.STICK, 1);
	     ItemMeta meta1 = currentagenItem.getItemMeta();
	     meta1.setDisplayName("§5\u25C6 Mes Claim \u25C6");
	     lores.add("§f-Blocks utiliser: §6"+ usedBlocks);
	     for(int i = 0; i < playerData.getClaims().size(); i++)
			{
	    	 Claim claim = playerData.getClaims().get(i);
	    	 lores.add("§f-(" + claim.getArea() + ") §b" + GriefPrevention.getfriendlyLocationString(claim.getLesserBoundaryCorner()));
			}
	     meta1.setLore(lores);
	     currentagenItem.setItemMeta(meta1);
	     GUIagent.setItem(1,currentagenItem);
	     lores.clear();
		
		
		
		
		 currentagenItem = new ItemStack(Material.CHEST, 1);
	     ItemMeta meta2 = currentagenItem.getItemMeta();
	     meta2.setDisplayName("§b\u25C6 Kit Claims \u25C6");
	     lores.add("§f-Coffre Claim.");
	     lores.add("§f-Pelle en or.");
	     lores.add("§f-Stick d'inspection.");
	     lores.add("§fPrix: §c20$");
	     meta2.setLore(lores);
	     currentagenItem.setItemMeta(meta2);
	     GUIagent.setItem(2,currentagenItem);
	     lores.clear();
	     
	     
	     
	     currentagenItem = new ItemStack(Material.EMERALD, 1);
	     ItemMeta meta4 = currentagenItem.getItemMeta();
	     meta4.setDisplayName("§a\u25C6 Acheter des Block Claims \u25C6");
	     meta4.addEnchant(Glow.glow, 1, false);
	     lores.add("§7Clic gauche: §fAcheter 10 Block: §c500$");
	     lores.add("§7Clic droit: §fAcheter 100 Block: §c5000$");
	     meta4.setLore(lores);
	     currentagenItem.setItemMeta(meta4);
	     GUIagent.setItem(4,currentagenItem);
	     lores.clear();
	     
	     
	  /*   currentagenItem = new ItemStack(Material.EMERALD, 1);
	     ItemMeta meta5 = currentagenItem.getItemMeta();
	     meta5.setDisplayName("§4\u25C6 Revendre des Block Claims \u25C6");
	     lores.add("§7Clic gauche: §fVendre 10 Block: §c400$");
	     lores.add("§7Clic droit: §fVendre 100 Block: §c4000$");
	     meta5.setLore(lores);
	     currentagenItem.setItemMeta(meta5);
	     GUIagent.setItem(5,currentagenItem);
	     lores.clear(); */
		
		
		
		return GUIagent;
	 }
	
	
	@EventHandler(priority=EventPriority.MONITOR)
	  public void guiClick(InventoryClickEvent event) {
		
		invetaryname = event.getInventory().getName();
		p = ((Player)event.getWhoClicked());
		   
		   if (!invetaryname.contains("§5\u2663 Claims \u2663")) return;
		   if ((event.getSlot() < 0) || (event.getSlot() > 53)) return;
		   event.setCancelled(true); 
		   if(event.getClick().isShiftClick()) { event.setCancelled(true); return;}
		   if(event.getSlotType() != InventoryType.SlotType.CONTAINER) { p.closeInventory(); return;}
		   
		   if (event.getSlot() == 2)
		   {
			   if(GiveM.CheckMoney1(p,20,event)) {
				   
				   currentagenItem = new ItemStack(Material.CHEST, 1);
				   ItemMeta meta1 = currentagenItem.getItemMeta();
				   meta1.setDisplayName("§b\u25C6 Coffre Claim \u25C6");
				   lores.add("§aPosez ce coffre sur un");
				   lores.add("§aterrain libre pour claim.");
				   meta1.setLore(lores);
				   currentagenItem.setItemMeta(meta1);
				   p.getInventory().addItem(currentagenItem);
				   lores.clear();
				   
				   currentagenItem = new ItemStack(Material.GOLD_SPADE, 1);
				   ItemMeta meta2 = currentagenItem.getItemMeta();
				   meta2.setDisplayName("§b\u25C6 Pelle Claim \u25C6");
				   lores.add("§aVous pouvez crée/redimensionner");
				   lores.add("§avotre claim avec cette pelle.");
				   lores.add("§dRedimensionner: §fSelectionner un");
				   lores.add("§fcoin de votre claim avec la pelle");
				   lores.add("§fpuis vous pouvez le deplacer.");
				   lores.add("§dCrée: §fSelectionner un coin puis");
				   lores.add("§fun autre selon la taille du claim");
				   lores.add("§fque vous voulez crée.");
				   meta2.setLore(lores);
				   currentagenItem.setItemMeta(meta2);
				   p.getInventory().addItem(currentagenItem);
				   lores.clear();
				   
				   
				   currentagenItem = new ItemStack(Material.STICK, 1);
				   ItemMeta meta3 = currentagenItem.getItemMeta();
				   meta3.setDisplayName("§b\u25C6 Stick d'inspection \u25C6");
				   lores.add("§aLe stick vous sert a inspecter");
				   lores.add("§avos claim, et rechercher");
				   lores.add("§ad'autres claims sur la map.");
				   meta3.setLore(lores);
				   currentagenItem.setItemMeta(meta3);
				   p.getInventory().addItem(currentagenItem);
				   lores.clear();
				   
				   p.closeInventory();
			   } else p.closeInventory();
			   
		   }
		   
		   
		   if (event.getSlot() == 4)
		   {
			   if(event.getClick().isRightClick()) { 
				   p.performCommand("buyclaimblocks 100");
				   p.closeInventory();
			   }
			   
			   
			   else if(event.getClick().isLeftClick()) {
				   p.performCommand("buyclaimblocks 10");
				   p.closeInventory();
			   }
			   
			   
		   }
		   
		   
		/*   if (event.getSlot() == 5)
		   {
			   if(event.getClick().isRightClick()) { 
				   p.performCommand("sellclaimblocks 100");
				   p.closeInventory();
			   }
			   
			   
			   else if(event.getClick().isLeftClick()) {
				   p.performCommand("sellclaimblocks 10");
				   p.closeInventory();
			   }
			   
			   
		   } */
		
		
	}

}
