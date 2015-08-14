package info.mgone.survie.gui.marchant;

import info.mgone.survie.Glow;
import info.mgone.survie.gui.armurier.Fct;

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
import org.bukkit.inventory.meta.ItemMeta;

public class Rush implements org.bukkit.event.Listener {
	
	
	public static Inventory GUIrush = null;
	static ItemStack currentrushItem = null;
	static List<String> lores = new ArrayList<String>();
	Player p = null;
	String invetaryname = null;
	
	
	public static Inventory displayRush()
	 {
		
		
		
		currentrushItem = new ItemStack(Material.STICK,1);
	    ItemMeta meta0 = currentrushItem.getItemMeta();
	    meta0.setDisplayName("§b\u25C6 Stick d'inspection \u25C6");
	    lores.add("§fPrix: §a5$");
	    lores.add("§aCe stick vous sert a inspecter");
		lores.add("§avos claim, et rechercher");
		lores.add("§ad'autres claims sur la map.");
	    meta0.setLore(lores);
	    currentrushItem.setItemMeta(meta0);
	    GUIrush.setItem(0,currentrushItem);
	    lores.clear();

	    
	    currentrushItem = new ItemStack(Material.TNT,1);
	    ItemMeta meta1 = currentrushItem.getItemMeta();
	    lores.add("§fPrix: §a10$ + 1 Skill + 1 Exp");
	    lores.add("§cOu");
	    lores.add("§fPrix: §a2 SuperCoins");
	    lores.add("§7Clic gauche: payer avec des $,Skill...");
	    lores.add("§7Clic droit: payer avec des SuperCoins");
	    meta1.setLore(lores);
	    currentrushItem.setItemMeta(meta1);
	    GUIrush.setItem(1,currentrushItem);
	    lores.clear();
	    
	    

	    currentrushItem = new ItemStack(Material.GOLDEN_APPLE,1, (short) 1);
	    ItemMeta meta2 = currentrushItem.getItemMeta();
	    lores.add("§fPrix: §a1000$ + 10 Skill + 10 Exp");
	    lores.add("§cOu");
	    lores.add("§fPrix: §a10 SuperCoins");
	    lores.add("§7Clic gauche: payer avec des $,Skill...");
	    lores.add("§7Clic droit: payer avec des SuperCoins");
	    meta2.setLore(lores);
	    currentrushItem.setItemMeta(meta2);
	    GUIrush.setItem(2,currentrushItem);
	    lores.clear();
	    
	    
	    
	    currentrushItem = new ItemStack(Material.IRON_BARDING,1);
	    ItemMeta meta3 = currentrushItem.getItemMeta();
	    meta3.setDisplayName("§c\u25C6 TNTGun \u25C6");
	    lores.add("§bUtilisations: §225");
	    lores.add(" ");
	    lores.add("§fPrix: §a1000$ + 50 Skill + 30 Exp");
	    lores.add("§cOu");
	    lores.add("§fPrix: §a25 SuperCoins");
	    lores.add("§7Clic gauche: payer avec des $,Skill...");
	    lores.add("§7Clic droit: payer avec des SuperCoins");
	    meta3.setLore(lores);
	    currentrushItem.setItemMeta(meta3);
	    GUIrush.setItem(3,currentrushItem);
	    lores.clear();
	    
	    
	    currentrushItem = new ItemStack(Material.MONSTER_EGG,1, (short) 50);
	    ItemMeta meta4 = currentrushItem.getItemMeta();
	    lores.add("§fPrix: §a1500$ + 25 Skill + 25 Exp");
	    lores.add("§cOu");
	    lores.add("§fPrix: §a30 SuperCoins");
	    lores.add("§7Clic gauche: payer avec des $,Skill...");
	    lores.add("§7Clic droit: payer avec des SuperCoins");
	    meta4.setLore(lores);
	    currentrushItem.setItemMeta(meta4);
	    GUIrush.setItem(4,currentrushItem);
	    lores.clear();
	    
	    
	    /////////////////////////////////compasse//////////////////////////
	    
	    currentrushItem = new ItemStack(Material.COMPASS,1);
	    ItemMeta meta9 = currentrushItem.getItemMeta();
	    meta9.setDisplayName("§6\u25C6 Boussole de Rush \u25C6");
	    lores.add("§7Pointe vers le joueur le plus proche");
	    lores.add("§7dans la zone pvp. ne pointe ni vers les");
	    lores.add("§7alliés, ni ceux qui ont pvp protection.");
	    lores.add("§bDistance: §d200 Blocks");
	    lores.add("§bUtilisations: §220");
	    lores.add(" ");
	    lores.add("§fPrix: §a1000$ + 10 Skill + 10 Exp");
	    lores.add("§cOu");
	    lores.add("§fPrix: §a10 SuperCoins");
	    lores.add("§7Clic gauche: payer avec des $,Skill...");
	    lores.add("§7Clic droit: payer avec des SuperCoins");
	    meta9.setLore(lores);
	    currentrushItem.setItemMeta(meta9);
	    GUIrush.setItem(9,currentrushItem);
	    lores.clear();
	    
	    ///////2
	    currentrushItem = new ItemStack(Material.COMPASS,1);
	    ItemMeta meta10 = currentrushItem.getItemMeta();
	    meta10.setDisplayName("§6\u25C6 Boussole de Rush \u25C6");
	    lores.add("§7Pointe vers le joueur le plus proche");
	    lores.add("§7dans la zone pvp. ne pointe ni vers les");
	    lores.add("§7alliés, ni ceux qui ont pvp protection.");
	    lores.add("§bDistance: §d400 Blocks");
	    lores.add("§bUtilisations: §225");
	    lores.add(" ");
	    lores.add("§fPrix: §a1000$ + 20 Skill + 20 Exp");
	    lores.add("§cOu");
	    lores.add("§fPrix: §a15 SuperCoins");
	    lores.add("§7Clic gauche: payer avec des $,Skill...");
	    lores.add("§7Clic droit: payer avec des SuperCoins");
	    meta10.setLore(lores);
	    currentrushItem.setItemMeta(meta10);
	    GUIrush.setItem(10,currentrushItem);
	    lores.clear();
	    
	    ///////////3
	    currentrushItem = new ItemStack(Material.COMPASS,1);
	    ItemMeta meta11 = currentrushItem.getItemMeta();
	    meta11.setDisplayName("§6\u25C6 Boussole de Rush \u25C6");
	    lores.add("§7Pointe vers le joueur le plus proche");
	    lores.add("§7dans la zone pvp. ne pointe ni vers les");
	    lores.add("§7alliés, ni ceux qui ont pvp protection.");
	    lores.add("§bDistance: §d600 Blocks");
	    lores.add("§bUtilisations: §230");
	    lores.add(" ");
	    lores.add("§fPrix: §a1100$ + 30 Skill + 20 Exp");
	    lores.add("§cOu");
	    lores.add("§fPrix: §a20 SuperCoins");
	    lores.add("§7Clic gauche: payer avec des $,Skill...");
	    lores.add("§7Clic droit: payer avec des SuperCoins");
	    meta11.setLore(lores);
	    currentrushItem.setItemMeta(meta11);
	    GUIrush.setItem(11,currentrushItem);
	    lores.clear();
	    
	    ////////////4
	    currentrushItem = new ItemStack(Material.COMPASS,1);
	    ItemMeta meta12 = currentrushItem.getItemMeta();
	    meta12.setDisplayName("§6\u25C6 Boussole de Rush \u25C6");
	    meta12.addEnchant(Glow.glow, 1, false);
	    lores.add("§7Pointe vers le joueur le plus proche");
	    lores.add("§7dans la zone pvp. ne pointe ni vers les");
	    lores.add("§7alliés, ni ceux qui ont pvp protection.");
	    lores.add("§bDistance: §d800 Blocks");
	    lores.add("§bUtilisations: §235");
	    lores.add("§4Grade Guerrier et +");
	    lores.add(" ");
	    lores.add("§fPrix: §a1000$ + 40 Skill + 20 Exp");
	    lores.add("§cOu");
	    lores.add("§fPrix: §a30 SuperCoins");
	    lores.add("§7Clic gauche: payer avec des $,Skill...");
	    lores.add("§7Clic droit: payer avec des SuperCoins");
	    meta12.setLore(lores);
	    currentrushItem.setItemMeta(meta12);
	    GUIrush.setItem(12,currentrushItem);
	    lores.clear();
	    
	    
	    ///////////5
	    currentrushItem = new ItemStack(Material.COMPASS,1);
	    ItemMeta meta13 = currentrushItem.getItemMeta();
	    meta13.setDisplayName("§6\u25C6 Boussole de Rush \u25C6");
	    meta13.addEnchant(Glow.glow, 1, false);
	    lores.add("§7Pointe vers le joueur le plus proche");
	    lores.add("§7dans la zone pvp. ne pointe ni vers les");
	    lores.add("§7alliés, ni ceux qui ont pvp protection.");
	    lores.add("§bDistance: §d1000 Blocks");
	    lores.add("§bUtilisations: §240");
	    lores.add("§4Grade Chevalier et +");
	    lores.add(" ");
	    lores.add("§fPrix: §a1000$ + 50 Skill + 20 Exp");
	    lores.add("§cOu");
	    lores.add("§fPrix: §a35 SuperCoins");
	    lores.add("§7Clic gauche: payer avec des $,Skill...");
	    lores.add("§7Clic droit: payer avec des SuperCoins");
	    meta13.setLore(lores);
	    currentrushItem.setItemMeta(meta13);
	    GUIrush.setItem(13,currentrushItem);
	    lores.clear();
	    


		
		return GUIrush;
	 }
	
	
	@EventHandler(priority=EventPriority.MONITOR)
	  public void guiClick(InventoryClickEvent e) {
		
		
		invetaryname = e.getInventory().getName();
		p = ((Player)e.getWhoClicked());
		   
		   if (!invetaryname.contains("§5\u2663 Rush Items \u2663")) return;
		   if ((e.getSlot() < 0) || (e.getSlot() > 53)) return;
		   e.setCancelled(true); 
		   if(e.getSlotType() != InventoryType.SlotType.CONTAINER) { p.closeInventory(); return;}
		
		   
		   if (e.getSlot() == 0)
		   {
			   
				   if(Fct.CheckMoneyArmes(p, 5, e)) {
					   currentrushItem = new ItemStack(Material.STICK);
					   ItemMeta meta12 = currentrushItem.getItemMeta();
					    meta12.setDisplayName("§b\u25C6 Stick d'inspection \u25C6");
					    lores.add("§aCe stick vous sert a inspecter");
						lores.add("§avos claim, et rechercher");
						lores.add("§ad'autres claims sur la map.");
					   meta12.setLore(lores);
					   currentrushItem.setItemMeta(meta12);
					   p.getInventory().addItem(currentrushItem);
					   lores.clear();
					   p.closeInventory();
				   } else Fct.closeNo(p);

		   }
		   
		   
		   if (e.getSlot() == 1)
		   {
			   
			   if(e.getClick().isLeftClick()) {
				   if(Fct.CheckAll(p,10,1,1)) {
					   currentrushItem = new ItemStack(Material.TNT);
					   p.getInventory().addItem(currentrushItem);
					   p.closeInventory();
				   } else Fct.closeNo(p);
				 } 
				 
				 
				 if(e.getClick().isRightClick()) { 
					   if(Fct.CheckSuperCoins(p,2)) {
						   currentrushItem = new ItemStack(Material.TNT);
						   p.getInventory().addItem(currentrushItem);
						   p.closeInventory();
					   } else Fct.closeNo(p);
				}
			   
			   
		   }
		   
		   
		   
		   if (e.getSlot() == 2)
		   {
			   
			   if(e.getClick().isLeftClick()) {
				   if(Fct.CheckAll(p,1000,10,10)) {
					   currentrushItem = new ItemStack(Material.GOLDEN_APPLE,1, (short) 1);
					   p.getInventory().addItem(currentrushItem);
					   p.closeInventory();
				   } else Fct.closeNo(p);
				 } 
				 
				 
				 if(e.getClick().isRightClick()) { 
					   if(Fct.CheckSuperCoins(p,10)) {
						   currentrushItem = new ItemStack(Material.GOLDEN_APPLE,1, (short) 1);
						   p.getInventory().addItem(currentrushItem);
						   p.closeInventory();
					   } else Fct.closeNo(p);
				}
			   
			   
		   }
		   
		   
		   
		   if (e.getSlot() == 3)
		   {
			   
			   if(e.getClick().isLeftClick()) {
				   if(Fct.CheckAll(p,1000,50,30)) {
					   currentrushItem = new ItemStack(Material.IRON_BARDING);
					   ItemMeta meta3 = currentrushItem.getItemMeta();
					    meta3.setDisplayName("§c\u25C6 TNTGun \u25C6");
					    meta3.addEnchant(Glow.glow, 1, false);
					    lores.add("§bUtilisations: §225");
					    meta3.setLore(lores);
					    currentrushItem.setItemMeta(meta3);
					   p.getInventory().addItem(currentrushItem);
					   p.closeInventory();
					   lores.clear();
				   } else Fct.closeNo(p);
				 } 
				 
				 
				 if(e.getClick().isRightClick()) { 
					   if(Fct.CheckSuperCoins(p,25)) {
						   currentrushItem = new ItemStack(Material.IRON_BARDING);
						   ItemMeta meta3 = currentrushItem.getItemMeta();
						    meta3.setDisplayName("§c\u25C6 TNTGun \u25C6");
						    meta3.addEnchant(Glow.glow, 1, false);
						    lores.add("§bUtilisations: §225");
						    meta3.setLore(lores);
						    currentrushItem.setItemMeta(meta3);
						   p.getInventory().addItem(currentrushItem);
						   p.closeInventory();
						   lores.clear();
					   } else Fct.closeNo(p);
				}
			   
			   
		   }
		   
		   
		   
		   
		   if (e.getSlot() == 4)
		   {
			   
			   if(e.getClick().isLeftClick()) {
				   if(Fct.CheckAll(p,1500,25,25)) {
					   currentrushItem = new ItemStack(Material.MONSTER_EGG, 1 , (short) 50);
					   p.getInventory().addItem(currentrushItem);
					   p.closeInventory();
					   lores.clear();
				   } else Fct.closeNo(p);
				 } 
				 
				 
				 if(e.getClick().isRightClick()) { 
					   if(Fct.CheckSuperCoins(p,30)) {
						   currentrushItem = new ItemStack(Material.MONSTER_EGG, 1 , (short) 50);
						   p.getInventory().addItem(currentrushItem);
						   p.closeInventory();
					   } else Fct.closeNo(p);
				}
			   
			   
		   }
		   
		   
		   
                  /////////////////////////////////compasse//////////////////////////
		   
		   
		   
		   if (e.getSlot() == 9)
		   {
			   
			   if(e.getClick().isLeftClick()) {
				   if(Fct.CheckAll(p,1000,10,10)) {
					   currentrushItem = new ItemStack(Material.COMPASS,1);
					   ItemMeta meta3 = currentrushItem.getItemMeta();
					    meta3.setDisplayName("§6\u25C6 Boussole de Rush \u25C6");
					    meta3.addEnchant(Glow.glow, 1, false);
					    lores.add("§bDistance: §d200 Blocks");
					    lores.add("§bUtilisations: §220");
					    meta3.setLore(lores);
					    currentrushItem.setItemMeta(meta3);
					   p.getInventory().addItem(currentrushItem);
					   p.closeInventory();
					   lores.clear();
				   } else Fct.closeNo(p);
				 } 
				 
				 
				 if(e.getClick().isRightClick()) { 
					   if(Fct.CheckSuperCoins(p,10)) {
						   currentrushItem = new ItemStack(Material.COMPASS,1);
						   ItemMeta meta3 = currentrushItem.getItemMeta();
						   meta3.setDisplayName("§6\u25C6 Boussole de Rush \u25C6");
						    meta3.addEnchant(Glow.glow, 1, false);
						    lores.add("§bDistance: §d200 Blocks");
						    lores.add("§bUtilisations: §220");
						    meta3.setLore(lores);
						    currentrushItem.setItemMeta(meta3);
						   p.getInventory().addItem(currentrushItem);
						   p.closeInventory();
						   lores.clear();
					   } else Fct.closeNo(p);
				}
			   
			   
		   }
		   
		   //////////////////2
		   
		   
		   if (e.getSlot() == 10)
		   {
			   
			   if(e.getClick().isLeftClick()) {
				   if(Fct.CheckAll(p,1000,20,20)) {
					   currentrushItem = new ItemStack(Material.COMPASS,1);
					   ItemMeta meta3 = currentrushItem.getItemMeta();
					    meta3.setDisplayName("§6\u25C6 Boussole de Rush \u25C6");
					    meta3.addEnchant(Glow.glow, 1, false);
					    lores.add("§bDistance: §d400 Blocks");
					    lores.add("§bUtilisations: §225");
					    meta3.setLore(lores);
					    currentrushItem.setItemMeta(meta3);
					   p.getInventory().addItem(currentrushItem);
					   p.closeInventory();
					   lores.clear();
				   } else Fct.closeNo(p);
				 } 
				 
				 
				 if(e.getClick().isRightClick()) { 
					   if(Fct.CheckSuperCoins(p,15)) {
						   currentrushItem = new ItemStack(Material.COMPASS,1);
						   ItemMeta meta3 = currentrushItem.getItemMeta();
						   meta3.setDisplayName("§6\u25C6 Boussole de Rush \u25C6");
						    meta3.addEnchant(Glow.glow, 1, false);
						    lores.add("§bDistance: §d400 Blocks");
						    lores.add("§bUtilisations: §225");
						    meta3.setLore(lores);
						    currentrushItem.setItemMeta(meta3);
						   p.getInventory().addItem(currentrushItem);
						   p.closeInventory();
						   lores.clear();
					   } else Fct.closeNo(p);
				}
			   
			   
		   }
		   
		   
		   //////////////////////3
		   
		   
		   if (e.getSlot() == 11)
		   {
			   
			   if(e.getClick().isLeftClick()) {
				   if(Fct.CheckAll(p,1100,30,20)) {
					   currentrushItem = new ItemStack(Material.COMPASS,1);
					   ItemMeta meta3 = currentrushItem.getItemMeta();
					    meta3.setDisplayName("§6\u25C6 Boussole de Rush \u25C6");
					    meta3.addEnchant(Glow.glow, 1, false);
					    lores.add("§bDistance: §d600 Blocks");
					    lores.add("§bUtilisations: §230");
					    meta3.setLore(lores);
					    currentrushItem.setItemMeta(meta3);
					   p.getInventory().addItem(currentrushItem);
					   p.closeInventory();
					   lores.clear();
				   } else Fct.closeNo(p);
				 } 
				 
				 
				 if(e.getClick().isRightClick()) { 
					   if(Fct.CheckSuperCoins(p,20)) {
						   currentrushItem = new ItemStack(Material.COMPASS,1);
						   ItemMeta meta3 = currentrushItem.getItemMeta();
						   meta3.setDisplayName("§6\u25C6 Boussole de Rush \u25C6");
						    meta3.addEnchant(Glow.glow, 1, false);
						    lores.add("§bDistance: §d600 Blocks");
						    lores.add("§bUtilisations: §230");
						    meta3.setLore(lores);
						    currentrushItem.setItemMeta(meta3);
						   p.getInventory().addItem(currentrushItem);
						   p.closeInventory();
						   lores.clear();
					   } else Fct.closeNo(p);
				}
			   
			   
		   }
		   
		   
		   ////////////////4
		   
		   
		   if (e.getSlot() == 12)
		   {
			   if(!p.hasPermission("boussole.guerrier")) { p.sendMessage("§cVous n'avez la permission d'utiliser cette Boussole qu'à partir du grade Guerrier et+!"); Fct.closeNo(p); return; }
			   
			   if(e.getClick().isLeftClick()) {
				   
				   if(Fct.CheckAll(p,1000,40,20)) {
					   currentrushItem = new ItemStack(Material.COMPASS,1);
					   ItemMeta meta3 = currentrushItem.getItemMeta();
					    meta3.setDisplayName("§6\u25C6 Boussole de Rush \u25C6");
					    meta3.addEnchant(Glow.glow, 1, false);
					    lores.add("§bDistance: §d800 Blocks");
					    lores.add("§bUtilisations: §235");
					    meta3.setLore(lores);
					    currentrushItem.setItemMeta(meta3);
					   p.getInventory().addItem(currentrushItem);
					   p.closeInventory();
					   lores.clear();
				   } else Fct.closeNo(p);
				 } 
				 
				 
				 if(e.getClick().isRightClick()) { 
					   if(Fct.CheckSuperCoins(p,30)) {
						   currentrushItem = new ItemStack(Material.COMPASS,1);
						   ItemMeta meta3 = currentrushItem.getItemMeta();
						   meta3.setDisplayName("§6\u25C6 Boussole de Rush \u25C6");
						    meta3.addEnchant(Glow.glow, 1, false);
						    lores.add("§bDistance: §d800 Blocks");
						    lores.add("§bUtilisations: §235");
						    meta3.setLore(lores);
						    currentrushItem.setItemMeta(meta3);
						   p.getInventory().addItem(currentrushItem);
						   p.closeInventory();
						   lores.clear();
					   } else Fct.closeNo(p);
				}
			   
			   
		   }
		   
		   
		   /////////////////////////5
		   
		   
		   if (e.getSlot() == 13)
		   {
			   if(!p.hasPermission("boussole.chevalier")) { p.sendMessage("§cVous n'avez la permission d'utiliser cette Boussole qu'à partir du grade Chevalier et+!"); Fct.closeNo(p); return; }
			   
			   if(e.getClick().isLeftClick()) {
				   
				   if(Fct.CheckAll(p,1000,50,20)) {
					   currentrushItem = new ItemStack(Material.COMPASS,1);
					   ItemMeta meta3 = currentrushItem.getItemMeta();
					    meta3.setDisplayName("§6\u25C6 Boussole de Rush \u25C6");
					    meta3.addEnchant(Glow.glow, 1, false);
					    lores.add("§bDistance: §d1000 Blocks");
					    lores.add("§bUtilisations: §240");
					    meta3.setLore(lores);
					    currentrushItem.setItemMeta(meta3);
					   p.getInventory().addItem(currentrushItem);
					   p.closeInventory();
					   lores.clear();
				   } else Fct.closeNo(p);
				 } 
				 
				 
				 if(e.getClick().isRightClick()) { 
					   if(Fct.CheckSuperCoins(p,35)) {
						   currentrushItem = new ItemStack(Material.COMPASS,1);
						   ItemMeta meta3 = currentrushItem.getItemMeta();
						   meta3.setDisplayName("§6\u25C6 Boussole de Rush \u25C6");
						    meta3.addEnchant(Glow.glow, 1, false);
						    lores.add("§bDistance: §d1000 Blocks");
						    lores.add("§bUtilisations: §240");
						    meta3.setLore(lores);
						    currentrushItem.setItemMeta(meta3);
						   p.getInventory().addItem(currentrushItem);
						   p.closeInventory();
						   lores.clear();
					   } else Fct.closeNo(p);
				}
			   
			   
		   }
		   
		
		
	}

}
