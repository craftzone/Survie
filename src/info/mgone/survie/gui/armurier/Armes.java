package info.mgone.survie.gui.armurier;

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
import org.bukkit.inventory.meta.ItemMeta;

public class Armes implements org.bukkit.event.Listener {
	
	
	public static Inventory GUIarme = null;
	static ItemStack currentarmeItem = null;
	static List<String> lores = new ArrayList<String>();
	Player p = null;
	String invetaryname = null;
	
	public static Inventory displayArmes()
	 {

				currentarmeItem = new ItemStack(Material.IRON_SWORD);
			    ItemMeta meta0 = currentarmeItem.getItemMeta();
			    meta0.setDisplayName("§7Dague d'assassin");
			    lores.add("§bDégât: §214,5");
			    lores.add("§bPV Max: §c-1");
			    lores.add(" ");
			    lores.add("§fPrix: §a100 $");
			    meta0.setLore(lores);
			    currentarmeItem.setItemMeta(meta0);
			    GUIarme.setItem(0,ItemLores.addGlow(currentarmeItem));
			    lores.clear();
			    
			    
			    currentarmeItem = new ItemStack(Material.IRON_SWORD);
			    ItemMeta meta1 = currentarmeItem.getItemMeta();
			    meta1.setDisplayName("§7Couteau de boucher");
			    lores.add("§bDégât: §213,5");
			    lores.add("§bPV Max: §2+1");
			    lores.add(" ");
			    lores.add("§fPrix: §a100 $");
			    meta1.setLore(lores);
			    currentarmeItem.setItemMeta(meta1);
			    GUIarme.setItem(1,ItemLores.addGlow(currentarmeItem));
			    lores.clear();
			    
			    //////////////////////////////////////////ligne2//////////////////////////////////////////////
			    
			    currentarmeItem = new ItemStack(Material.IRON_SWORD);
			    ItemMeta meta9 = currentarmeItem.getItemMeta();
			    meta9.setDisplayName("§1Rapière française");
			    lores.add("§bDégât: §214,5");
			    lores.add("§bVitesse: §c-5%");
			    lores.add(" ");
			    lores.add("§fPrix: §a200 $");
			    meta9.setLore(lores);
			    currentarmeItem.setItemMeta(meta9);
			    GUIarme.setItem(9,ItemLores.addGlow(currentarmeItem));
			    lores.clear();
			    
			    
			    currentarmeItem = new ItemStack(Material.IRON_SWORD);
			    ItemMeta meta10 = currentarmeItem.getItemMeta();
			    meta10.setDisplayName("§1Lame de voleur");
			    lores.add("§bDégât: §212,5");
			    lores.add("§bVitesse: §2+5%");
			    lores.add("§ePickpocket: §250%");
			    lores.add(" ");
			    lores.add("§fPrix: §a200 $");
			    meta10.setLore(lores);
			    currentarmeItem.setItemMeta(meta10);
			    GUIarme.setItem(10,ItemLores.addGlow(currentarmeItem));
			    lores.clear();
			    
			    
			    currentarmeItem = new ItemStack(Material.IRON_SWORD);
			    ItemMeta meta11 = currentarmeItem.getItemMeta();
			    meta11.setDisplayName("§1Sabre Syrien");
			    lores.add("§bDégât: §213,5");
			    lores.add("§bVitesse: §2+5%");
			    lores.add(" ");
			    lores.add("§fPrix: §a200 $");
			    meta11.setLore(lores);
			    currentarmeItem.setItemMeta(meta11);
			    GUIarme.setItem(11,ItemLores.addGlow(currentarmeItem));
			    lores.clear();
			    
			    
			    /////////////////////////////////////ligne 3////////////////////////////////////////////////////

			    
			    currentarmeItem = new ItemStack(Material.DIAMOND_SWORD);
			    ItemMeta meta18 = currentarmeItem.getItemMeta();
			    meta18.setDisplayName("§aLame solaire");
			    lores.add("§bDégât: §214,5");
			    lores.add("§bPV Max: §c-1");
			    lores.add("§eFeu: §250%");
			    lores.add(" ");
			    lores.add("§fPrix: §a500 $");
			    meta18.setLore(lores);
			    currentarmeItem.setItemMeta(meta18);
			    GUIarme.setItem(18,ItemLores.addGlow(currentarmeItem));
			    lores.clear();

			    
			    currentarmeItem = new ItemStack(Material.DIAMOND_SWORD);
			    ItemMeta meta19 = currentarmeItem.getItemMeta();
			    meta19.setDisplayName("§aLame du néant");
			    lores.add("§bDégât: §214,5");
			    lores.add("§bPV Max: §c-1");
			    lores.add("§eInvisibilité: §250%");
			    lores.add(" ");
			    lores.add("§fPrix: §a500 $");
			    meta19.setLore(lores);
			    currentarmeItem.setItemMeta(meta19);
			    GUIarme.setItem(19,ItemLores.addGlow(currentarmeItem));
			    lores.clear();
			    
			    
			    currentarmeItem = new ItemStack(Material.DIAMOND_SWORD);
			    ItemMeta meta20 = currentarmeItem.getItemMeta();
			    meta20.setDisplayName("§aFauchon Vénitien");
			    lores.add("§bDégât: §213,5");
			    lores.add("§bPV Max: §2+2");
			    lores.add("§bknockback Resistance: §2+10%");
			    lores.add(" ");
			    lores.add("§fPrix: §a500 $");
			    meta20.setLore(lores);
			    currentarmeItem.setItemMeta(meta20);
			    GUIarme.setItem(20,ItemLores.addGlow(currentarmeItem));
			    lores.clear();
			    
			    
			    currentarmeItem = new ItemStack(Material.DIAMOND_SWORD);
			    ItemMeta meta21 = currentarmeItem.getItemMeta();
			    meta21.setDisplayName("§aÉpée Milanaise");
			    lores.add("§bDégât: §213,5");
			    lores.add("§bPV Max: §2+2");
			    lores.add("§bVitesse: §2+7%");
			    lores.add(" ");
			    lores.add("§fPrix: §a500 $");
			    meta21.setLore(lores);
			    currentarmeItem.setItemMeta(meta21);
			    GUIarme.setItem(21,ItemLores.addGlow(currentarmeItem));
			    lores.clear();
			    
			    
			    
			    /////////////////////////////////////////////////////////ligne 4/////////////////////////////////////////////
			    
			    
			    currentarmeItem = new ItemStack(Material.DIAMOND_SWORD);
			    ItemMeta meta27 = currentarmeItem.getItemMeta();
			    meta27.setDisplayName("§6Rapière Sicilienne");
			    lores.add("§bDégât: §215,5");
			    lores.add("§bVitesse: §2+7%");
			    lores.add("§eCécité: §250%");
			    lores.add(" ");
			    lores.add("§fPrix: §a700 $");
			    meta27.setLore(lores);
			    currentarmeItem.setItemMeta(meta27);
			    GUIarme.setItem(27,ItemLores.addGlow(currentarmeItem));
			    lores.clear();
			    
			    
			    currentarmeItem = new ItemStack(Material.DIAMOND_SWORD);
			    ItemMeta meta28 = currentarmeItem.getItemMeta();
			    meta28.setDisplayName("§6Coutelas français");
			    lores.add("§bDégât: §216,5");
			    lores.add("§bPV Max: §2+2");
			    lores.add("§eLenteur: §250%");
			    lores.add(" ");
			    lores.add("§fPrix: §a700 $");
			    meta28.setLore(lores);
			    currentarmeItem.setItemMeta(meta28);
			    GUIarme.setItem(28,ItemLores.addGlow(currentarmeItem));
			    lores.clear();
			    
			    
			    currentarmeItem = new ItemStack(Material.DIAMOND_SWORD);
			    ItemMeta meta29 = currentarmeItem.getItemMeta();
			    meta29.setDisplayName("§6Épée d'officier");
			    lores.add("§bDégât: §215");
			    lores.add("§bPV Max: §2+3");
			    lores.add("§eFaiblesse: §250%");
			    lores.add(" ");
			    lores.add("§fPrix: §a700 $");
			    meta29.setLore(lores);
			    currentarmeItem.setItemMeta(meta29);
			    GUIarme.setItem(29,ItemLores.addGlow(currentarmeItem));
			    lores.clear();
			    
			    
			    currentarmeItem = new ItemStack(Material.DIAMOND_SWORD);
			    ItemMeta meta30 = currentarmeItem.getItemMeta();
			    meta30.setDisplayName("§6Épée de capitaine");
			    lores.add("§bDégât: §216");
			    lores.add("§bPV Max: §c-1");
			    lores.add("§eVol de vie: §250%");
			    lores.add(" ");
			    lores.add("§fPrix: §a700 $");
			    meta30.setLore(lores);
			    currentarmeItem.setItemMeta(meta30);
			    GUIarme.setItem(30,ItemLores.addGlow(currentarmeItem));
			    lores.clear();
			    
			    
			    currentarmeItem = new ItemStack(Material.DIAMOND_SWORD);
			    ItemMeta meta31 = currentarmeItem.getItemMeta();
			    meta31.setDisplayName("§6Épée d'Anaklusmos");
			    lores.add("§bDégât: §214");
			    lores.add("§bPV Max: §2+2");
			    lores.add("§eNausée: §250%");
			    lores.add(" ");
			    lores.add("§fPrix: §a700 $");
			    meta31.setLore(lores);
			    currentarmeItem.setItemMeta(meta31);
			    GUIarme.setItem(31,ItemLores.addGlow(currentarmeItem));
			    lores.clear();
			    
			    
			    ///////////////////////////////////////////////////legendaire//////////////////////////////////////////////////////
			    
			    
			    currentarmeItem = new ItemStack(Material.DIAMOND_SWORD, 0);
			    ItemMeta meta36 = currentarmeItem.getItemMeta();
			    meta36.setDisplayName("§cLame fantôme");
			    lores.add("§4Épée légendaire");
			    lores.add("§bDégât: §216");
			    lores.add("§bPV Max: §2+3");
			    lores.add("§bVitesse: §2+8%");
			    lores.add("§eInvisibilité: §260%");
			    lores.add(" ");
			    lores.add("§7rupture de stock!");
			    lores.add("§fPrix: §a1000$ + 5 Skil + 10 Exp");
			    lores.add("§cOu");
			    lores.add("§fPrix: §a10 SuperCoins");
			    lores.add("§7Clic gauche: payer avec des $,Skill...");
			    lores.add("§7Clic droit: payer avec des SuperCoins");
			    meta36.setLore(lores);
			    currentarmeItem.setItemMeta(meta36);
			    GUIarme.setItem(36,ItemLores.addGlow(currentarmeItem));
			    lores.clear();
			    
			    
			    currentarmeItem = new ItemStack(Material.DIAMOND_SWORD, 0);
			    ItemMeta meta37 = currentarmeItem.getItemMeta();
			    meta37.setDisplayName("§cSchiavone");
			    lores.add("§4Épée légendaire");
			    lores.add("§bDégât: §217,5");
			    lores.add("§bPV Max: §c-2");
			    lores.add("§bVitesse: §c-7%");
			    lores.add("§eWither: §250%");
			    lores.add(" ");
			    lores.add("§7rupture de stock!");
			    lores.add("§fPrix: §a1100$ + 10 Skil + 20 Exp");
			    lores.add("§cOu");
			    lores.add("§fPrix: §a15 SuperCoins");
			    lores.add("§7Clic gauche: payer avec des $,Skill...");
			    lores.add("§7Clic droit: payer avec des SuperCoins");
			    meta37.setLore(lores);
			    currentarmeItem.setItemMeta(meta37);
			    GUIarme.setItem(37,ItemLores.addGlow(currentarmeItem));
			    lores.clear();
			    
			    
			    currentarmeItem = new ItemStack(Material.DIAMOND_SWORD, 0);
			    ItemMeta meta38 = currentarmeItem.getItemMeta();
			    meta38.setDisplayName("§cDragon Noir");
			    lores.add("§4Épée légendaire");
			    lores.add("§bDégât: §217");
			    lores.add("§bPV Max: §c-2");
			    lores.add("§bVitesse: §c-7%");
			    lores.add("§ePoison: §250%");
			    lores.add(" ");
			    lores.add("§7rupture de stock!");
			    lores.add("§fPrix: §a1100$ + 10 Skil + 20 Exp");
			    lores.add("§cOu");
			    lores.add("§fPrix: §a15 SuperCoins");
			    lores.add("§7Clic gauche: payer avec des $,Skill...");
			    lores.add("§7Clic droit: payer avec des SuperCoins");
			    meta38.setLore(lores);
			    currentarmeItem.setItemMeta(meta38);
			    GUIarme.setItem(38,ItemLores.addGlow(currentarmeItem));
			    lores.clear();
			    
			    
			    
			    currentarmeItem = new ItemStack(Material.DIAMOND_SWORD, 0);
			    ItemMeta meta39 = currentarmeItem.getItemMeta();
			    meta39.setDisplayName("§cFléau des Dieux");
			    lores.add("§4Épée légendaire");
			    lores.add("§bDégât: §218");
			    lores.add("§bPV Max: §a+3");
			    lores.add("§bVitesse: §a+7%");
			    lores.add("§eNausée: §250%");
			    lores.add(" ");
			    lores.add("§7rupture de stock!");
			    lores.add("§fPrix: §a1200$ + 15 Skil + 25 Exp");
			    lores.add("§cOu");
			    lores.add("§fPrix: §a20 SuperCoins");
			    lores.add("§7Clic gauche: payer avec des $,Skill...");
			    lores.add("§7Clic droit: payer avec des SuperCoins");
			    meta39.setLore(lores);
			    currentarmeItem.setItemMeta(meta39);
			    GUIarme.setItem(39,ItemLores.addGlow(currentarmeItem));
			    lores.clear();
			    
			    
			    currentarmeItem = new ItemStack(Material.DIAMOND_SWORD, 0);
			    ItemMeta meta40 = currentarmeItem.getItemMeta();
			    meta40.setDisplayName("§cYatagan d'Assassin");
			    lores.add("§4Épée légendaire");
			    lores.add("§bDégât: §219");
			    lores.add("§bPV Max: §a+1");
			    lores.add("§bVitesse: §c-5%");
			    lores.add("§eCécité: §250%");
			    lores.add(" ");
			    lores.add("§7rupture de stock!");
			    lores.add("§fPrix: §a1300$ + 15 Skil + 25 Exp");
			    lores.add("§cOu");
			    lores.add("§fPrix: §a22 SuperCoins");
			    lores.add("§7Clic gauche: payer avec des $,Skill...");
			    lores.add("§7Clic droit: payer avec des SuperCoins");
			    meta40.setLore(lores);
			    currentarmeItem.setItemMeta(meta40);
			    GUIarme.setItem(40,ItemLores.addGlow(currentarmeItem));
			    lores.clear();
			    
			    
			    currentarmeItem = new ItemStack(Material.DIAMOND_SWORD, 0);
			    ItemMeta meta41 = currentarmeItem.getItemMeta();
			    meta41.setDisplayName("§cÉpée d'Ulysse");
			    lores.add("§4Épée légendaire");
			    lores.add("§bDégât: §218");
			    lores.add("§bPV Max: §a+4");
			    lores.add("§bVitesse: §a+10%");
			    lores.add("§eFeu: §250%");
			    lores.add(" ");
			    lores.add("§7rupture de stock!");
			    lores.add("§fPrix: §a1300$ + 25 Skil + 30 Exp");
			    lores.add("§cOu");
			    lores.add("§fPrix: §a25 SuperCoins");
			    lores.add("§7Clic gauche: payer avec des $,Skill...");
			    lores.add("§7Clic droit: payer avec des SuperCoins");
			    meta41.setLore(lores);
			    currentarmeItem.setItemMeta(meta41);
			    GUIarme.setItem(41,ItemLores.addGlow(currentarmeItem));
			    lores.clear();

			 
			    
	//GUIarme.setItem(36, ItemLores.addGlow(ItemLores.FreeLore(Material.DIAMOND_SWORD, 0, 0, "§cLame fantôme", "§4Épée légendaire","","§7rupture de stock!")));
	//GUIarme.setItem(37, ItemLores.addGlow(ItemLores.FreeLore(Material.DIAMOND_SWORD, 0, 0, "§cSchiavone", "§4Épée légendaire","","§7rupture de stock!")));
	//GUIarme.setItem(38, ItemLores.addGlow(ItemLores.FreeLore(Material.DIAMOND_SWORD, 0, 0, "§cDragon Noir", "§4Épée légendaire","","§7rupture de stock!")));
	//GUIarme.setItem(39, ItemLores.addGlow(ItemLores.FreeLore(Material.DIAMOND_SWORD, 0, 0, "§cFléau des Dieux", "§4Épée légendaire","","§7rupture de stock!")));
	//GUIarme.setItem(40, ItemLores.addGlow(ItemLores.FreeLore(Material.DIAMOND_SWORD, 0, 0, "§cYatagan d'Assassin", "§4Épée légendaire","","§7rupture de stock!")));
	//GUIarme.setItem(41, ItemLores.addGlow(ItemLores.FreeLore(Material.DIAMOND_SWORD, 0, 0, "§cÉpée d'Ulysse", "§4Épée légendaire","","§7rupture de stock!")));
			    
		
		return GUIarme;
	 }
	
	
	
	@EventHandler(priority=EventPriority.MONITOR)
	  public void guiClick(InventoryClickEvent e) {
		
		
		
		invetaryname = e.getInventory().getName();
		p = ((Player)e.getWhoClicked());
		   
		   if (!invetaryname.contains("§6\u2663 Epées \u2663")) return;
		   if ((e.getSlot() < 0) || (e.getSlot() > 53)) return;
		   e.setCancelled(true); 
		   if(e.getSlotType() != InventoryType.SlotType.CONTAINER) { p.closeInventory(); return;}
		
		   
		   if (e.getSlot() == 0)
		   {
			   if(Fct.CheckMoneyArmes(p,100,e)) {
				   currentarmeItem = new ItemStack(Material.IRON_SWORD);
				   ItemStack attributes = Fct.AddAtrib(currentarmeItem,13.5,-1,0,0);
				   ItemMeta meta0 = attributes.getItemMeta();
				   meta0.setDisplayName("§7Dague d'assassin");
				   lores.add("§bDégât: §214,5");
				   lores.add("§bPV Max: §c-1");
				   meta0.setLore(lores);
				   attributes.setItemMeta(meta0);
				   p.getInventory().addItem(ItemLores.addGlow(attributes));
				   lores.clear();
				   p.closeInventory();
			   } else Fct.closeNo(p);
		   }
		   
		   
		   if (e.getSlot() == 1)
		   {
			   if(Fct.CheckMoneyArmes(p,100,e)) {
				   currentarmeItem = new ItemStack(Material.IRON_SWORD);
				   ItemStack attributes = Fct.AddAtrib(currentarmeItem,12.5,1,0,0);
				   ItemMeta meta1 = attributes.getItemMeta();
				   meta1.setDisplayName("§7Couteau de boucher");
				   lores.add("§bDégât: §213,5");
				   lores.add("§bPV Max: §2+1");
				   meta1.setLore(lores);
				   attributes.setItemMeta(meta1);
				   p.getInventory().addItem(ItemLores.addGlow(attributes));
				   lores.clear();
				   p.closeInventory();
			   } else Fct.closeNo(p);
		   }
		   
		   
		   /////////////////////////////////////////ligne 2////////////////////////////////////////////

		   
		   if (e.getSlot() == 9)
		   {
			   if(Fct.CheckMoneyArmes(p,200,e)) {
				   currentarmeItem = new ItemStack(Material.IRON_SWORD);
				   ItemStack attributes = Fct.AddAtrib(currentarmeItem,13.5,0,-0.05,0);
				   ItemMeta meta9 = attributes.getItemMeta();
				   meta9.setDisplayName("§1Rapière française");
				    lores.add("§bDégât: §214,5");
				    lores.add("§bVitesse: §c-5%");
				   meta9.setLore(lores);
				   attributes.setItemMeta(meta9);
				   p.getInventory().addItem(ItemLores.addGlow(attributes));
				   lores.clear();
				   p.closeInventory();
			   } else Fct.closeNo(p);
		   }
		   
		   
		   
		   if (e.getSlot() == 10)
		   {
			   if(Fct.CheckMoneyArmes(p,200,e)) {
				   currentarmeItem = new ItemStack(Material.IRON_SWORD);
				   ItemStack attributes = Fct.AddAtrib(currentarmeItem,11.5,0,0.05,0);
				   ItemMeta meta10 = attributes.getItemMeta();
				   meta10.setDisplayName("§1Lame de voleur");
				    lores.add("§bDégât: §212,5");
				    lores.add("§bVitesse: §2+5%");
				    lores.add("§bPickpocket: §e50%");
				   meta10.setLore(lores);
				   attributes.setItemMeta(meta10);
				   p.getInventory().addItem(ItemLores.addGlow(attributes));
				   lores.clear();
				   p.closeInventory();
			   } else Fct.closeNo(p);
		   }
		   
		   
		   
		   if (e.getSlot() == 11)
		   {
			   if(Fct.CheckMoneyArmes(p,200,e)) {
				   currentarmeItem = new ItemStack(Material.IRON_SWORD);
				   ItemStack attributes = Fct.AddAtrib(currentarmeItem,12.5,0,0.05,0);
				   ItemMeta meta11 = attributes.getItemMeta();
				   meta11.setDisplayName("§1Sabre Syrien");
				    lores.add("§bDégât: §213,5");
				    lores.add("§bVitesse: §2+5%");
				   meta11.setLore(lores);
				   attributes.setItemMeta(meta11);
				   p.getInventory().addItem(ItemLores.addGlow(attributes));
				   lores.clear();
				   p.closeInventory();
			   } else Fct.closeNo(p);
		   }
		   
		   
		   ////////////////////////////////////////ligne 3 /////////////////////////////////////////////////////////
		   
		   if (e.getSlot() == 18)
		   {
			   if(Fct.CheckMoneyArmes(p,500,e)) {
				   currentarmeItem = new ItemStack(Material.DIAMOND_SWORD);
				   ItemStack attributes = Fct.AddAtrib(currentarmeItem,13.5,-1,0,0);
				   ItemMeta meta18 = attributes.getItemMeta();
				   meta18.setDisplayName("§aLame solaire");
				    lores.add("§bDégât: §214,5");
				    lores.add("§bPV Max: §c-1");
				    lores.add("§eFeu: §250%");
				   meta18.setLore(lores);
				   attributes.setItemMeta(meta18);
				   p.getInventory().addItem(ItemLores.addGlow(attributes));
				   lores.clear();
				   p.closeInventory();
			   } else Fct.closeNo(p);
		   }
		   
		   if (e.getSlot() == 19)
		   {
			   if(Fct.CheckMoneyArmes(p,500,e)) {
				   currentarmeItem = new ItemStack(Material.DIAMOND_SWORD);
				   ItemStack attributes = Fct.AddAtrib(currentarmeItem,13.5,-1,0,0);
				   ItemMeta meta19 = attributes.getItemMeta();
				   meta19.setDisplayName("§aLame du néant");
				    lores.add("§bDégât: §214,5");
				    lores.add("§bPV Max: §c-1");
				    lores.add("§eInvisibilité: §250%");
				   meta19.setLore(lores);
				   attributes.setItemMeta(meta19);
				   p.getInventory().addItem(ItemLores.addGlow(attributes));
				   lores.clear();
				   p.closeInventory();
			   } else Fct.closeNo(p);
		   } 
		   
		   
		   if (e.getSlot() == 20)
		   {
			   if(Fct.CheckMoneyArmes(p,500,e)) {
				   currentarmeItem = new ItemStack(Material.DIAMOND_SWORD);
				   ItemStack attributes = Fct.AddAtrib(currentarmeItem,12.5,2,0,0.1);
				   ItemMeta meta20 = attributes.getItemMeta();
				   meta20.setDisplayName("§aFauchon Vénitien");
				    lores.add("§bDégât: §213,5");
				    lores.add("§bPV Max: §2+2");
				    lores.add("§bknockback Resistance: §2+10%");
				   meta20.setLore(lores);
				   attributes.setItemMeta(meta20);
				   p.getInventory().addItem(ItemLores.addGlow(attributes));
				   lores.clear();
				   p.closeInventory();
			   } else Fct.closeNo(p);
		   }
		   
		   
		   if (e.getSlot() == 21)
		   {
			   if(Fct.CheckMoneyArmes(p,500,e)) {
				   currentarmeItem = new ItemStack(Material.DIAMOND_SWORD);
				   ItemStack attributes = Fct.AddAtrib(currentarmeItem,12.5,2,0.07,0);
				   ItemMeta meta21 = attributes.getItemMeta();
				   meta21.setDisplayName("§aÉpée Milanaise");
				    lores.add("§bDégât: §213,5");
				    lores.add("§bPV Max: §2+2");
				    lores.add("§bVitesse: §2+7%");
				   meta21.setLore(lores);
				   attributes.setItemMeta(meta21);
				   p.getInventory().addItem(ItemLores.addGlow(attributes));
				   lores.clear();
				   p.closeInventory();
			   } else Fct.closeNo(p);
		   } 
		   
		   
		   //////////////////////////////////////////////////////////ligne 4//////////////////////////////////////////////////////
		   
		   if (e.getSlot() == 27)
		   {
			   if(Fct.CheckMoneyArmes(p,700,e)) {
				   currentarmeItem = new ItemStack(Material.DIAMOND_SWORD);
				   ItemStack attributes = Fct.AddAtrib(currentarmeItem,14.5,0,0.07,0);
				   ItemMeta meta27 = attributes.getItemMeta();
				   meta27.setDisplayName("§6Rapière Sicilienne");
				    lores.add("§bDégât: §215,5");
				    lores.add("§bVitesse: §2+7%");
				    lores.add("§eCécité: §250%");
				   meta27.setLore(lores);
				   attributes.setItemMeta(meta27);
				   p.getInventory().addItem(ItemLores.addGlow(attributes));
				   lores.clear();
				   p.closeInventory();
			   } else Fct.closeNo(p);
		   } 
		   
		   
		   if (e.getSlot() == 28)
		   {
			   if(Fct.CheckMoneyArmes(p,700,e)) {
				   currentarmeItem = new ItemStack(Material.DIAMOND_SWORD);
				   ItemStack attributes = Fct.AddAtrib(currentarmeItem,15.5,2,0,0);
				   ItemMeta meta28 = attributes.getItemMeta();
				   meta28.setDisplayName("§6Coutelas français");
				    lores.add("§bDégât: §216,5");
				    lores.add("§bPV Max: §2+2");
				    lores.add("§eLenteur: §250%");
				   meta28.setLore(lores);
				   attributes.setItemMeta(meta28);
				   p.getInventory().addItem(ItemLores.addGlow(attributes));
				   lores.clear();
				   p.closeInventory();
			   } else Fct.closeNo(p);
		   } 
		   
		   
		   if (e.getSlot() == 29)
		   {
			   if(Fct.CheckMoneyArmes(p,700,e)) {
				   currentarmeItem = new ItemStack(Material.DIAMOND_SWORD);
				   ItemStack attributes = Fct.AddAtrib(currentarmeItem,14,3,0,0);
				   ItemMeta meta29 = attributes.getItemMeta();
				   meta29.setDisplayName("§6Épée d'officier");
				    lores.add("§bDégât: §215");
				    lores.add("§bPV Max: §2+3");
				    lores.add("§eFaiblesse: §250%");
				   meta29.setLore(lores);
				   attributes.setItemMeta(meta29);
				   p.getInventory().addItem(ItemLores.addGlow(attributes));
				   lores.clear();
				   p.closeInventory();
			   } else Fct.closeNo(p);
		   } 
		   
		   
		   if (e.getSlot() == 30)
		   {
			   if(Fct.CheckMoneyArmes(p,700,e)) {
				   currentarmeItem = new ItemStack(Material.DIAMOND_SWORD);
				   ItemStack attributes = Fct.AddAtrib(currentarmeItem,15,-1,0,0);
				   ItemMeta meta30 = attributes.getItemMeta();
				   meta30.setDisplayName("§6Épée de capitaine");
				    lores.add("§bDégât: §216");
				    lores.add("§bPV Max: §c-1");
				    lores.add("§eVol de vie: §250%");
				   meta30.setLore(lores);
				   attributes.setItemMeta(meta30);
				   p.getInventory().addItem(ItemLores.addGlow(attributes));
				   lores.clear();
				   p.closeInventory();
			   } else Fct.closeNo(p);
		   } 
		   
		   
		   if (e.getSlot() == 31)
		   {
			   if(Fct.CheckMoneyArmes(p,700,e)) {
				   currentarmeItem = new ItemStack(Material.DIAMOND_SWORD);
				   ItemStack attributes = Fct.AddAtrib(currentarmeItem,14,2,0,0);
				   ItemMeta meta31 = attributes.getItemMeta();
				   meta31.setDisplayName("§6Épée d'Anaklusmos");
				    lores.add("§bDégât: §215");
				    lores.add("§bPV Max: §2+2");
				    lores.add("§eNausée: §250%");
				   meta31.setLore(lores);
				   attributes.setItemMeta(meta31);
				   p.getInventory().addItem(ItemLores.addGlow(attributes));
				   lores.clear();
				   p.closeInventory();
			   } else Fct.closeNo(p);
			   
		   } 
		   
		   
		   if (e.getSlot() == 36 || e.getSlot() == 37 || e.getSlot() == 38 || e.getSlot() == 39 || e.getSlot() == 40 || e.getSlot() == 41) {
			   p.sendMessage("§4rupture de stock!");
			   p.closeInventory(); 
		   }
		   
		   
	}
	

}
