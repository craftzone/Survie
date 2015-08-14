package info.mgone.survie.gui.armurier;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Armures implements org.bukkit.event.Listener {
	
	public static Inventory GUIarmure = null;
	static ItemStack currentarmureItem = null;
	static List<String> lores = new ArrayList<String>();
	Player p = null;
	String invetaryname = null;
	
	public static Inventory displayArmures()
	 {
		
		//armure d'aventurier
		currentarmureItem = new ItemStack(Material.DIAMOND_HELMET);
	    ItemMeta meta0 = currentarmureItem.getItemMeta();
	    meta0.setDisplayName("§eCasque d'aventurier");
	    meta0.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
	    meta0.addEnchant(Enchantment.OXYGEN, 1, true);
	    lores.add("§bDégât bonus: §2+1");
	    lores.add("§bVitesse: §c-10%");
	    lores.add(" ");
	    lores.add("§fPrix: §a250 $");
	    meta0.setLore(lores);
	    currentarmureItem.setItemMeta(meta0);
	    GUIarmure.setItem(0,currentarmureItem);
	    lores.clear();
	    
	    
	    currentarmureItem = new ItemStack(Material.DIAMOND_CHESTPLATE);
	    ItemMeta meta1 = currentarmureItem.getItemMeta();
	    meta1.setDisplayName("§ePlastron d'aventurier");
	    meta1.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
	    meta1.addEnchant(Enchantment.THORNS, 2, true);
	    lores.add("§bPV Max: §c-1");
	    lores.add("§bknockback Resistance: §2+25%");
	    lores.add(" ");
	    lores.add("§fPrix: §a250 $");
	    meta1.setLore(lores);
	    currentarmureItem.setItemMeta(meta1);
	    GUIarmure.setItem(1,currentarmureItem);
	    lores.clear();
	    
	    
	    currentarmureItem = new ItemStack(Material.DIAMOND_LEGGINGS);
	    ItemMeta meta2 = currentarmureItem.getItemMeta();
	    meta2.setDisplayName("§ePantalon d'aventurier");
	    meta2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
	    lores.add("§bDégât bonus: §2+0.5");
	    lores.add("§bPV Max: §2+2");
	    lores.add("§bVitesse: §c-10%");
	    lores.add(" ");
	    lores.add("§fPrix: §a250 $");
	    meta2.setLore(lores);
	    currentarmureItem.setItemMeta(meta2);
	    GUIarmure.setItem(2,currentarmureItem);
	    lores.clear();
	    
	    
	    currentarmureItem = new ItemStack(Material.DIAMOND_BOOTS);
	    ItemMeta meta3 = currentarmureItem.getItemMeta();
	    meta3.setDisplayName("§eBottes d'aventurier");
	    meta3.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
	    meta3.addEnchant(Enchantment.PROTECTION_FALL, 1, true);
	    lores.add("§bPV Max: §c-1");
	    lores.add("§bVitesse: §2+15%");
	    lores.add(" ");
	    lores.add("§fPrix: §a250 $");
	    meta3.setLore(lores);
	    currentarmureItem.setItemMeta(meta3);
	    GUIarmure.setItem(3,currentarmureItem);
	    lores.clear();
	    
	    
	    ////////////////////////////////////////////////////////////////////
	    
	  //armure d'Achille
	  		currentarmureItem = new ItemStack(Material.DIAMOND_HELMET);
	  	    ItemMeta meta9 = currentarmureItem.getItemMeta();
	  	    meta9.setDisplayName("§6Casque d'Achille");
	  	    meta9.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
	  	    meta9.addEnchant(Enchantment.WATER_WORKER, 1, true);
	  	    lores.add("§bDégât bonus: §2+2");
	  	    lores.add("§bPV Max: §2+3");
	  	    lores.add(" ");
	  	    lores.add("§fPrix: §a500$ + 10 Skill + 20 Exp");
		    lores.add("§cOu");
		    lores.add("§fPrix: §a10 SuperCoins");
		    lores.add("§7Clic gauche: payer avec des $,Skill...");
		    lores.add("§7Clic droit: payer avec des SuperCoins");
	  	    meta9.setLore(lores);
	  	    currentarmureItem.setItemMeta(meta9);
	  	    GUIarmure.setItem(9,currentarmureItem);
	  	    lores.clear();
	  	    
	  	    
	  	    currentarmureItem = new ItemStack(Material.DIAMOND_CHESTPLATE);
	  	    ItemMeta meta10 = currentarmureItem.getItemMeta();
	  	    meta10.setDisplayName("§6Plastron d'Achille");
	  	    meta10.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
	  	    meta10.addEnchant(Enchantment.THORNS, 3, true);
	  	    lores.add("§bDégât bonus: §2+0.5");
	  	    lores.add("§bPV Max: §2+2");
	  	    lores.add("§bknockback Resistance: §2+30%");
	  	    lores.add(" ");
	  	    lores.add("§fPrix: §a500$ + 10 Skill + 20 Exp");
		    lores.add("§cOu");
		    lores.add("§fPrix: §a10 SuperCoins");
		    lores.add("§7Clic gauche: payer avec des $,Skill...");
		    lores.add("§7Clic droit: payer avec des SuperCoins");
	  	    meta10.setLore(lores);
	  	    currentarmureItem.setItemMeta(meta10);
	  	    GUIarmure.setItem(10,currentarmureItem);
	  	    lores.clear();
	  	    
	  	    
	  	    currentarmureItem = new ItemStack(Material.DIAMOND_LEGGINGS);
	  	    ItemMeta meta11 = currentarmureItem.getItemMeta();
	  	    meta11.setDisplayName("§6Pantalon d'Achille");
	  	    meta11.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
	  	    lores.add("§bDégât bonus: §2+0.5");
	  	    lores.add("§bPV Max: §2+1");
	  	    lores.add(" ");
	  	    lores.add("§fPrix: §a500$ + 10 Skill + 20 Exp");
		    lores.add("§cOu");
		    lores.add("§fPrix: §a10 SuperCoins");
		    lores.add("§7Clic gauche: payer avec des $,Skill...");
		    lores.add("§7Clic droit: payer avec des SuperCoins");
	  	    meta11.setLore(lores);
	  	    currentarmureItem.setItemMeta(meta11);
	  	    GUIarmure.setItem(11,currentarmureItem);
	  	    lores.clear();
	  	    
	  	    
	  	    currentarmureItem = new ItemStack(Material.DIAMOND_BOOTS);
	  	    ItemMeta meta12 = currentarmureItem.getItemMeta();
	  	    meta12.setDisplayName("§6Bottes d'Achille");
	  	    meta12.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
	  	    meta12.addEnchant(Enchantment.PROTECTION_FALL, 1, true);
	  	    lores.add("§bDégât bonus: §2+0.5");
	  	    lores.add("§bVitesse: §2+25%");
	  	    lores.add(" ");
	  	    lores.add("§fPrix: §a500$ + 10 Skill + 20 Exp");
		    lores.add("§cOu");
		    lores.add("§fPrix: §a10 SuperCoins");
		    lores.add("§7Clic gauche: payer avec des $,Skill...");
		    lores.add("§7Clic droit: payer avec des SuperCoins");
	  	    meta12.setLore(lores);
	  	    currentarmureItem.setItemMeta(meta12);
	  	    GUIarmure.setItem(12,currentarmureItem);
	  	    lores.clear();
		
		
		
		return GUIarmure;
	 }
	
	@EventHandler(priority=EventPriority.MONITOR)
	  public void guiClick(InventoryClickEvent e) {
		
		
		invetaryname = e.getInventory().getName();
		p = ((Player)e.getWhoClicked());
		   
		   if (!invetaryname.contains("§6\u2663 Armures \u2663")) return;
		   if ((e.getSlot() < 0) || (e.getSlot() > 53)) return;
		   e.setCancelled(true); 
		   if(e.getSlotType() != InventoryType.SlotType.CONTAINER) { p.closeInventory(); return;}
		
		   
		   if (e.getSlot() == 0)
		   {
			   if(Fct.CheckMoneyArmes(p,250,e)) {
				   currentarmureItem = new ItemStack(Material.DIAMOND_HELMET);
				   ItemStack attributes = Fct.AddAtrib(currentarmureItem,1,0,-0.1,0);
				   ItemMeta meta0 = attributes.getItemMeta();
				    meta0.setDisplayName("§eCasque d'aventurier");
				    meta0.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
				    meta0.addEnchant(Enchantment.OXYGEN, 1, true);
				    lores.add("§bDégât bonus: §2+1");
				    lores.add("§bVitesse: §c-10%");
				   meta0.setLore(lores);
				   attributes.setItemMeta(meta0);
				   p.getInventory().addItem(attributes);
				   lores.clear();
				   p.closeInventory();
			   } else Fct.closeNo(p);
		   }
		   
		   
		   if (e.getSlot() == 1)
		   {
			   if(Fct.CheckMoneyArmes(p,250,e)) {
				   currentarmureItem = new ItemStack(Material.DIAMOND_CHESTPLATE);
				   ItemStack attributes = Fct.AddAtrib(currentarmureItem,0,-1,0,0.25);
				   ItemMeta meta1 = attributes.getItemMeta();
				    meta1.setDisplayName("§ePlastron d'aventurier");
				    meta1.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
				    meta1.addEnchant(Enchantment.THORNS, 2, true);
				    lores.add("§bPV Max: §c-1");
				    lores.add("§bknockback Resistance: §2+25%");
				   meta1.setLore(lores);
				   attributes.setItemMeta(meta1);
				   p.getInventory().addItem(attributes);
				   lores.clear();
				   p.closeInventory();
			   } else Fct.closeNo(p);
		   }
		   
		   
		   if (e.getSlot() == 2)
		   {
			   if(Fct.CheckMoneyArmes(p,250,e)) {
				   currentarmureItem = new ItemStack(Material.DIAMOND_LEGGINGS);
				   ItemStack attributes = Fct.AddAtrib(currentarmureItem,0.5,2,-0.1,0);
				   ItemMeta meta2 = attributes.getItemMeta();
				    meta2.setDisplayName("§ePantalon d'aventurier");
				    meta2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
				    lores.add("§bDégât bonus: §2+0.5");
				    lores.add("§bPV Max: §2+2");
				    lores.add("§bVitesse: §c-10%");
				   meta2.setLore(lores);
				   attributes.setItemMeta(meta2);
				   p.getInventory().addItem(attributes);
				   lores.clear();
				   p.closeInventory();
			   } else Fct.closeNo(p);
		   }
		   
		   
		   if (e.getSlot() == 3)
		   {
			   if(Fct.CheckMoneyArmes(p,250,e)) {
				   currentarmureItem = new ItemStack(Material.DIAMOND_BOOTS);
				   ItemStack attributes = Fct.AddAtrib(currentarmureItem,0,-1,0.15,0);
				   ItemMeta meta3 = attributes.getItemMeta();
				    meta3.setDisplayName("§eBottes d'aventurier");
				    meta3.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
				    meta3.addEnchant(Enchantment.PROTECTION_FALL, 1, true);
				    lores.add("§bPV Max: §c-1");
				    lores.add("§bVitesse: §2+15%");
				   meta3.setLore(lores);
				   attributes.setItemMeta(meta3);
				   p.getInventory().addItem(attributes);
				   lores.clear();
				   p.closeInventory();
			   } else Fct.closeNo(p);
		   }
		   
		   ////////////////////////////////////////////////////////////////////armure 2
		
		   
		   if (e.getSlot() == 9)
		   {
			  if(e.getClick().isLeftClick()) {
			   if(Fct.CheckAll(p,500,10,20)) {
				   currentarmureItem = new ItemStack(Material.DIAMOND_HELMET);
				   ItemStack attributes = Fct.AddAtrib(currentarmureItem,2,3,0,0);
				   ItemMeta meta9 = attributes.getItemMeta();
				    meta9.setDisplayName("§6Casque d'Achille");
			  	    meta9.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
			  	    meta9.addEnchant(Enchantment.WATER_WORKER, 1, true);
			  	    lores.add("§bDégât bonus: §2+2");
			  	    lores.add("§bPV Max: §2+3");
				   meta9.setLore(lores);
				   attributes.setItemMeta(meta9);
				   p.getInventory().addItem(attributes);
				   lores.clear();
				   p.closeInventory();
			   } else Fct.closeNo(p);
			  }
			  
			  if(e.getClick().isRightClick()) {
				   if(Fct.CheckSuperCoins(p,10)) {
					   currentarmureItem = new ItemStack(Material.DIAMOND_HELMET);
					   ItemStack attributes = Fct.AddAtrib(currentarmureItem,2,3,0,0);
					   ItemMeta meta9 = attributes.getItemMeta();
					    meta9.setDisplayName("§6Casque d'Achille");
				  	    meta9.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
				  	    meta9.addEnchant(Enchantment.WATER_WORKER, 1, true);
				  	    lores.add("§bDégât bonus: §2+2");
				  	    lores.add("§bPV Max: §2+3");
					   meta9.setLore(lores);
					   attributes.setItemMeta(meta9);
					   p.getInventory().addItem(attributes);
					   lores.clear();
					   p.closeInventory();
				   } else Fct.closeNo(p);
				  }
			  
		   }
		   
		   if (e.getSlot() == 10)
		   {
			  if(e.getClick().isLeftClick()) { 
			   if(Fct.CheckAll(p,500,10,20)) {
				   currentarmureItem = new ItemStack(Material.DIAMOND_CHESTPLATE);
				   ItemStack attributes = Fct.AddAtrib(currentarmureItem,0.5,2,0,0.3);
				   ItemMeta meta10 = attributes.getItemMeta();
				    meta10.setDisplayName("§6Plastron d'Achille");
			  	    meta10.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
			  	    meta10.addEnchant(Enchantment.THORNS, 3, true);
			  	    lores.add("§bDégât bonus: §2+0.5");
			  	    lores.add("§bPV Max: §2+2");
			  	    lores.add("§bknockback Resistance: §2+30%");
				   meta10.setLore(lores);
				   attributes.setItemMeta(meta10);
				   p.getInventory().addItem(attributes);
				   lores.clear();
				   p.closeInventory();
			   } else Fct.closeNo(p);
			  }
			  
			  if(e.getClick().isRightClick()) { 
				   if(Fct.CheckSuperCoins(p,10)) {
					   currentarmureItem = new ItemStack(Material.DIAMOND_CHESTPLATE);
					   ItemStack attributes = Fct.AddAtrib(currentarmureItem,0.5,2,0,0.3);
					   ItemMeta meta10 = attributes.getItemMeta();
					    meta10.setDisplayName("§6Plastron d'Achille");
				  	    meta10.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
				  	    meta10.addEnchant(Enchantment.THORNS, 3, true);
				  	    lores.add("§bDégât bonus: §2+0.5");
				  	    lores.add("§bPV Max: §2+2");
				  	    lores.add("§bknockback Resistance: §2+30%");
					   meta10.setLore(lores);
					   attributes.setItemMeta(meta10);
					   p.getInventory().addItem(attributes);
					   lores.clear();
					   p.closeInventory();
				   } else Fct.closeNo(p);
				  }
	
		   }
		   
		   
		   if (e.getSlot() == 11)
		   {
			  if(e.getClick().isLeftClick()) { 
			   if(Fct.CheckAll(p,500,10,20)) {
				   currentarmureItem = new ItemStack(Material.DIAMOND_LEGGINGS);
				   ItemStack attributes = Fct.AddAtrib(currentarmureItem,0.5,1,0,0);
				   ItemMeta meta11 = attributes.getItemMeta();
				    meta11.setDisplayName("§6Pantalon d'Achille");
			  	    meta11.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
			  	    lores.add("§bDégât bonus: §2+0.5");
			  	    lores.add("§bPV Max: §2+1");
				   meta11.setLore(lores);
				   attributes.setItemMeta(meta11);
				   p.getInventory().addItem(attributes);
				   lores.clear();
				   p.closeInventory();
			   } else Fct.closeNo(p);
			  }
			  
			  
			  if(e.getClick().isRightClick()) { 
				   if(Fct.CheckSuperCoins(p,10)) {
					   currentarmureItem = new ItemStack(Material.DIAMOND_LEGGINGS);
					   ItemStack attributes = Fct.AddAtrib(currentarmureItem,0.5,1,0,0);
					   ItemMeta meta11 = attributes.getItemMeta();
					    meta11.setDisplayName("§6Pantalon d'Achille");
				  	    meta11.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
				  	    lores.add("§bDégât bonus: §2+0.5");
				  	    lores.add("§bPV Max: §2+1");
					   meta11.setLore(lores);
					   attributes.setItemMeta(meta11);
					   p.getInventory().addItem(attributes);
					   lores.clear();
					   p.closeInventory();
				   } else Fct.closeNo(p);
				  }
			  
			  
			  
		   }
		   
		   
		   if (e.getSlot() == 12)
		   {
			   
			 if(e.getClick().isLeftClick()) { 
			   if(Fct.CheckAll(p,500,10,20)) {
				   currentarmureItem = new ItemStack(Material.DIAMOND_BOOTS);
				   ItemStack attributes = Fct.AddAtrib(currentarmureItem,0.5,0,0.25,0);
				   ItemMeta meta12 = attributes.getItemMeta();
				    meta12.setDisplayName("§6Bottes d'Achille");
			  	    meta12.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
			  	    meta12.addEnchant(Enchantment.PROTECTION_FALL, 1, true);
			  	    lores.add("§bPV Max: §2+0.5");
			  	    lores.add("§bVitesse: §2+25%");
				   meta12.setLore(lores);
				   attributes.setItemMeta(meta12);
				   p.getInventory().addItem(attributes);
				   lores.clear();
				   p.closeInventory();
			   } else Fct.closeNo(p);
			 } 
			 
			 
			 if(e.getClick().isRightClick()) { 
				   if(Fct.CheckSuperCoins(p,10)) {
					   currentarmureItem = new ItemStack(Material.DIAMOND_BOOTS);
					   ItemStack attributes = Fct.AddAtrib(currentarmureItem,0.5,0,0.25,0);
					   ItemMeta meta12 = attributes.getItemMeta();
					    meta12.setDisplayName("§6Bottes d'Achille");
				  	    meta12.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
				  	    meta12.addEnchant(Enchantment.PROTECTION_FALL, 1, true);
				  	    lores.add("§bDégât bonus: §2+0.5");
				  	    lores.add("§bVitesse: §2+25%");
					   meta12.setLore(lores);
					   attributes.setItemMeta(meta12);
					   p.getInventory().addItem(attributes);
					   lores.clear();
					   p.closeInventory();
				   } else Fct.closeNo(p);
			}
			   
			   
			   
			   
			   
		   }
		
		
	}
	
	
	

}
