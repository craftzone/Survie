package info.mgone.survie.gui.armurier;

import info.mgone.survie.gui.AttributesLore.ItemLores;

import java.util.ArrayList;
import java.util.List;

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

public class Haches implements Listener {
	
	public static Inventory GUIhache = null;
	static ItemStack currenthacheItem = null;
	static List<String> lores = new ArrayList<String>();
	Player p = null;
	String invetaryname = null;
	
	public static Inventory displayHache()
	 {
		
		
		currenthacheItem = new ItemStack(Material.DIAMOND_AXE);
	    ItemMeta meta0 = currenthacheItem.getItemMeta();
	    meta0.setDisplayName("§eHache de guerre");
	    lores.add("§dTomaHawk");
	    lores.add("§bDégât Corps à corps: §215,5");
	    lores.add("§bDégât Lancer: §27,5");
	    lores.add("§bPV Max: §c-2");
	    lores.add("§bVitesse: §c-20%");
	    lores.add("§eAveuglement: §250%");
	    lores.add(" ");
	    lores.add("§fPrix: §a300 $");
	    meta0.setLore(lores);
	    currenthacheItem.setItemMeta(meta0);
	    GUIhache.setItem(0,ItemLores.addGlow(currenthacheItem));
	    lores.clear();
		
		
	  
	    currenthacheItem = new ItemStack(Material.DIAMOND_AXE);
	    ItemMeta meta1 = currenthacheItem.getItemMeta();
	    meta1.setDisplayName("§eHache Vénéneuse");
	    lores.add("§dTomaHawk");
	    lores.add("§bDégât Corps à corps: §215,5");
	    lores.add("§bDégât Lancer: §211,5");
	    lores.add("§bPV Max: §c-4");
	    lores.add("§bVitesse: §c-30%");
	    lores.add("§ePoison: §250%");
	    lores.add(" ");
	    lores.add("§fPrix: §a300 $");
	    meta1.setLore(lores);
	    currenthacheItem.setItemMeta(meta1);
	    GUIhache.setItem(1,ItemLores.addGlow(currenthacheItem));
	    lores.clear();
	    
	    
	    currenthacheItem = new ItemStack(Material.DIAMOND_AXE);
	    ItemMeta meta2 = currenthacheItem.getItemMeta();
	    meta2.setDisplayName("§eHache écrasante");
	    lores.add("§dTomaHawk");
	    lores.add("§bDégât Corps à corps: §215,5");
	    lores.add("§bDégât Lancer: §219,5");
	    lores.add("§bPV Max: §c-6");
	    lores.add("§bVitesse: §c-70%");
	    lores.add("§eFaiblesse: §250%");
	    lores.add(" ");
	    lores.add("§fPrix: §a500 $");
	    meta2.setLore(lores);
	    currenthacheItem.setItemMeta(meta2);
	    GUIhache.setItem(2,ItemLores.addGlow(currenthacheItem));
	    lores.clear();
	    
	    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////ligne2
	    
	    currenthacheItem = new ItemStack(Material.DIAMOND_AXE);
	    ItemMeta meta9 = currenthacheItem.getItemMeta();
	    meta9.setDisplayName("§eHache de Cupidon");
	    lores.add("§dTomaHawk");
	    lores.add("§bDégât Corps à corps: §215,5");
	    lores.add("§bDégât Lancer: §215,5");
	    lores.add("§bPV Max: §c-3");
	    lores.add("§bVitesse: §c-35%");
	    lores.add("§eFeu: §250%");
	    lores.add(" ");
	    lores.add("§fPrix: §a800$ + 5 Skill + 10 Exp");
	    lores.add("§cOu");
	    lores.add("§fPrix: §a8 SuperCoins");
	    lores.add("§7Clic gauche: payer avec des $,Skill...");
	    lores.add("§7Clic droit: payer avec des SuperCoins ");
	    meta9.setLore(lores);
	    currenthacheItem.setItemMeta(meta9);
	    GUIhache.setItem(9,ItemLores.addGlow(currenthacheItem));
	    lores.clear();
	    
	    
	    currenthacheItem = new ItemStack(Material.DIAMOND_AXE);
	    ItemMeta meta10 = currenthacheItem.getItemMeta();
	    meta10.setDisplayName("§eTranchante d'Hercule");
	    lores.add("§dTomaHawk");
	    lores.add("§bDégât Corps à corps: §215,5");
	    lores.add("§bDégât Lancer: §218,5");
	    lores.add("§bPV Max: §c-2");
	    lores.add("§bVitesse: §c-25%");
	    lores.add("§eFreeze: §250%");
	    lores.add(" ");
	    lores.add("§fPrix: §a1000$ + 10 Skill + 20 Exp");
	    lores.add("§cOu");
	    lores.add("§fPrix: §a10 SuperCoins");
	    lores.add("§7Clic gauche: payer avec des $,Skill...");
	    lores.add("§7Clic droit: payer avec des SuperCoins ");
	    meta10.setLore(lores);
	    currenthacheItem.setItemMeta(meta10);
	    GUIhache.setItem(10,ItemLores.addGlow(currenthacheItem));
	    lores.clear();
	    
	    
	    
	    currenthacheItem = new ItemStack(Material.DIAMOND_AXE);
	    ItemMeta meta11 = currenthacheItem.getItemMeta();
	    meta11.setDisplayName("§eHache de Lochaber");
	    lores.add("§dTomaHawk");
	    lores.add("§bDégât Corps à corps: §215,5");
	    lores.add("§bDégât Lancer: §218,5");
	    lores.add("§bPV Max: §c-3");
	    lores.add("§bVitesse: §c-20%");
	    lores.add("§eWither: §250%");
	    lores.add(" ");
	    lores.add("§fPrix: §a1000$ + 10 Skill + 20 Exp");
	    lores.add("§cOu");
	    lores.add("§fPrix: §a10 SuperCoins");
	    lores.add("§7Clic gauche: payer avec des $,Skill...");
	    lores.add("§7Clic droit: payer avec des SuperCoins ");
	    meta11.setLore(lores);
	    currenthacheItem.setItemMeta(meta11);
	    GUIhache.setItem(11,ItemLores.addGlow(currenthacheItem));
	    lores.clear();
	    
	    
	    
	    
		
		
		
		return GUIhache;
	 }
	
	
	@EventHandler(priority=EventPriority.MONITOR)
	  public void guiClick(InventoryClickEvent e) {
		
		
		invetaryname = e.getInventory().getName();
		p = ((Player)e.getWhoClicked());
		   
		   if (!invetaryname.contains("§6\u2663 Hache TomaHawk \u2663")) return;
		   if ((e.getSlot() < 0) || (e.getSlot() > 53)) return;
		   e.setCancelled(true); 
		   if(e.getSlotType() != InventoryType.SlotType.CONTAINER) { p.closeInventory(); return;}
		
		   
		   if (e.getSlot() == 0)
		   {
			   if(Fct.CheckMoneyArmes(p,300,e)) {
				   currenthacheItem = new ItemStack(Material.DIAMOND_AXE);
				   ItemStack attributes = Fct.AddAtrib(currenthacheItem,14.5,-2,-0.2,0);
				   ItemMeta meta0 = attributes.getItemMeta();
				   meta0.setDisplayName("§eHache de guerre");
				    lores.add("§dTomaHawk");
				    lores.add("§bDégât Corps à corps: §215,5");
				    lores.add("§bDégât Lancer: §27,5");
				    lores.add("§bPV Max: §c-2");
				    lores.add("§bVitesse: §c-20%");
				    lores.add("§eAveuglement: §250%");
				   meta0.setLore(lores);
				   attributes.setItemMeta(meta0);
				   p.getInventory().addItem(ItemLores.addGlow(attributes));
				   lores.clear();
				   p.closeInventory();
			   } else Fct.closeNo(p);
		   }
		   
		   
		   if (e.getSlot() == 1)
		   {
			   if(Fct.CheckMoneyArmes(p,300,e)) {
				   currenthacheItem = new ItemStack(Material.DIAMOND_AXE);
				   ItemStack attributes = Fct.AddAtrib(currenthacheItem,14.5,-4,-0.3,0);
				   ItemMeta meta1 = attributes.getItemMeta();
				   meta1.setDisplayName("§eHache Vénéneuse");
				   lores.add("§dTomaHawk");
				    lores.add("§bDégât Corps à corps: §215,5");
				    lores.add("§bDégât Lancer: §211,5");
				    lores.add("§bPV Max: §c-4");
				    lores.add("§bVitesse: §c-30%");
				    lores.add("§ePoison: §250%");
				   meta1.setLore(lores);
				   attributes.setItemMeta(meta1);
				   p.getInventory().addItem(ItemLores.addGlow(attributes));
				   lores.clear();
				   p.closeInventory();
			   } else Fct.closeNo(p);
		   }
		   
		   
		   if (e.getSlot() == 2)
		   {
			   if(Fct.CheckMoneyArmes(p,500,e)) {
				   currenthacheItem = new ItemStack(Material.DIAMOND_AXE);
				   ItemStack attributes = Fct.AddAtrib(currenthacheItem,14.5,-6,-0.7,0);
				   ItemMeta meta2 = attributes.getItemMeta();
				   meta2.setDisplayName("§eHache écrasante");
				    lores.add("§dTomaHawk");
				    lores.add("§bDégât Corps à corps: §215,5");
				    lores.add("§bDégât Lancer: §219,5");
				    lores.add("§bPV Max: §c-6");
				    lores.add("§bVitesse: §c-70%");
				    lores.add("§eFaiblesse: §250%");
				   meta2.setLore(lores);
				   attributes.setItemMeta(meta2);
				   p.getInventory().addItem(ItemLores.addGlow(attributes));
				   lores.clear();
				   p.closeInventory();
			   } else Fct.closeNo(p);
		   }
		   
		   //ligne2///////////////////////////////////////////////////////////////////
		   
		   
		   
		   if (e.getSlot() == 9)
		   {
			  if(e.getClick().isLeftClick()) {
			   if(Fct.CheckAll(p,800,5,10)) {
				   currenthacheItem = new ItemStack(Material.DIAMOND_AXE);
				   ItemStack attributes = Fct.AddAtrib(currenthacheItem,14.5,-3,-0.35,0);
				   ItemMeta meta9 = attributes.getItemMeta();
				   meta9.setDisplayName("§eHache de Cupidon");
				    lores.add("§dTomaHawk");
				    lores.add("§bDégât Corps à corps: §215,5");
				    lores.add("§bDégât Lancer: §215,5");
				    lores.add("§bPV Max: §c-3");
				    lores.add("§bVitesse: §c-35%");
				    lores.add("§eFeu: §250%");
				   meta9.setLore(lores);
				   attributes.setItemMeta(meta9);
				   p.getInventory().addItem(ItemLores.addGlow(attributes));
				   lores.clear();
				   p.closeInventory();
			   } else Fct.closeNo(p);
			  }
			  
			  
			  if(e.getClick().isRightClick()) {
				   if(Fct.CheckSuperCoins(p, 8)) {
					   currenthacheItem = new ItemStack(Material.DIAMOND_AXE);
					   ItemStack attributes = Fct.AddAtrib(currenthacheItem,14.5,-3,-0.35,0);
					   ItemMeta meta9 = attributes.getItemMeta();
					   meta9.setDisplayName("§eHache de Cupidon");
					    lores.add("§dTomaHawk");
					    lores.add("§bDégât Corps à corps: §215,5");
					    lores.add("§bDégât Lancer: §215,5");
					    lores.add("§bPV Max: §c-3");
					    lores.add("§bVitesse: §c-35%");
					    lores.add("§eFeu: §250%");
					   meta9.setLore(lores);
					   attributes.setItemMeta(meta9);
					   p.getInventory().addItem(ItemLores.addGlow(attributes));
					   lores.clear();
					   p.closeInventory();
				   } else Fct.closeNo(p);
				  }
			  
		   }
		   
		   
		   
		   if (e.getSlot() == 10)
		   {
			   if(e.getClick().isLeftClick()) { 
				   if(Fct.CheckAll(p,1000,10,20)) {
				   currenthacheItem = new ItemStack(Material.DIAMOND_AXE);
				   ItemStack attributes = Fct.AddAtrib(currenthacheItem,14.5,-2,-0.25,0);
				   ItemMeta meta10 = attributes.getItemMeta();
				   meta10.setDisplayName("§eTranchante d'Hercule");
				    lores.add("§dTomaHawk");
				    lores.add("§bDégât Corps à corps: §215,5");
				    lores.add("§bDégât Lancer: §218,5");
				    lores.add("§bPV Max: §c-2");
				    lores.add("§bVitesse: §c-25%");
				    lores.add("§eFreeze: §250%");
				   meta10.setLore(lores);
				   attributes.setItemMeta(meta10);
				   p.getInventory().addItem(ItemLores.addGlow(attributes));
				   lores.clear();
				   p.closeInventory();
			   } else Fct.closeNo(p);
			  }
			   
			   
			   if(e.getClick().isRightClick()) { 
				   if(Fct.CheckSuperCoins(p,10)) {
				   currenthacheItem = new ItemStack(Material.DIAMOND_AXE);
				   ItemStack attributes = Fct.AddAtrib(currenthacheItem,14.5,-2,-0.25,0);
				   ItemMeta meta10 = attributes.getItemMeta();
				   meta10.setDisplayName("§eTranchante d'Hercule");
				    lores.add("§dTomaHawk");
				    lores.add("§bDégât Corps à corps: §215,5");
				    lores.add("§bDégât Lancer: §218,5");
				    lores.add("§bPV Max: §c-2");
				    lores.add("§bVitesse: §c-25%");
				    lores.add("§eFreeze: §250%");
				   meta10.setLore(lores);
				   attributes.setItemMeta(meta10);
				   p.getInventory().addItem(ItemLores.addGlow(attributes));
				   lores.clear();
				   p.closeInventory();
			   } else Fct.closeNo(p);
			  }
			   
		   }


		   if (e.getSlot() == 11)
		   {
			   if(e.getClick().isLeftClick()) { 
				   if(Fct.CheckAll(p,1000,10,20)) {
				   currenthacheItem = new ItemStack(Material.DIAMOND_AXE);
				   ItemStack attributes = Fct.AddAtrib(currenthacheItem,14.5,-3,-0.20,0);
				   ItemMeta meta11 = attributes.getItemMeta();
				   meta11.setDisplayName("§eHache de Lochaber");
				    lores.add("§dTomaHawk");
				    lores.add("§bDégât Corps à corps: §215,5");
				    lores.add("§bDégât Lancer: §218,5");
				    lores.add("§bPV Max: §c-3");
				    lores.add("§bVitesse: §c-20%");
				    lores.add("§eWither: §250%");
				   meta11.setLore(lores);
				   attributes.setItemMeta(meta11);
				   p.getInventory().addItem(ItemLores.addGlow(attributes));
				   lores.clear();
				   p.closeInventory();
			   } else Fct.closeNo(p);
			  }
			   
			   if(e.getClick().isRightClick()) { 
				   if(Fct.CheckSuperCoins(p,10)) {
				   currenthacheItem = new ItemStack(Material.DIAMOND_AXE);
				   ItemStack attributes = Fct.AddAtrib(currenthacheItem,14.5,-3,-0.20,0);
				   ItemMeta meta11 = attributes.getItemMeta();
				   meta11.setDisplayName("§eHache de Lochaber");
				    lores.add("§dTomaHawk");
				    lores.add("§bDégât Corps à corps: §215,5");
				    lores.add("§bDégât Lancer: §218,5");
				    lores.add("§bPV Max: §c-3");
				    lores.add("§bVitesse: §c-20%");
				    lores.add("§eWither: §250%");
				   meta11.setLore(lores);
				   attributes.setItemMeta(meta11);
				   p.getInventory().addItem(ItemLores.addGlow(attributes));
				   lores.clear();
				   p.closeInventory();
			   } else Fct.closeNo(p);
			  }
			   
		   }
		
	}
	

	
	
	
	
	

}
