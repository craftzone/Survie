package info.mgone.survie.crate;

import info.mgone.survie.MySQL;
import info.mgone.survie.Survie;
import info.mgone.survie.utility;
import info.mgone.survie.gui.Aide;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;





import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;


public class LootChest implements Listener {
	
	static ArrayList<String> resetok0 = new ArrayList<String>();
	public HashMap<String, Inventory> GUILoot = new HashMap<String, Inventory>();
	static World worldc = Bukkit.getWorld("world");
	
	static Location loc0 = new Location(worldc,0,76,-7,0,0);
	static Location loc0h = new Location(worldc,0,76,-7,0,0);
	
	static Location lochelp = new Location(worldc,0,76,-19,0,0);
	
	
	static Location locsd = new Location(worldc,-6,76,-7,0,0);
	static Location locsdh = new Location(worldc,-6,76,-7,0,0);
	
	static Location locor = new Location(worldc,-9,76,-7,0,0);
	static Location locorh = new Location(worldc,-9,76,-7,0,0);
	
	static Location locdm = new Location(worldc,6,76,-7,0,0);
	static Location locdmh = new Location(worldc,6,76,-7,0,0);
	
	static Location locem = new Location(worldc,9,76,-7,0,0);
	static Location locemh = new Location(worldc,9,76,-7,0,0);
	
	
	public static void ResetTimer() {
		
		Hologram hc0 = HologramsAPI.createHologram(Survie.plugin, loc0h.add(0.5, 1.6,0.5));
		hc0.appendTextLine("§a\u2691 §a§lSurprise Quotidienne §a\u2691");
		
		Hologram hsd = HologramsAPI.createHologram(Survie.plugin, locsdh.add(0.5, 1.6,0.5));
		hsd.appendTextLine("§f§lCoffre Standard");
		hsd.appendItemLine(new ItemStack(Material.IRON_INGOT));
		
		Hologram hor = HologramsAPI.createHologram(Survie.plugin, locorh.add(0.5, 1.6,0.5));
		hor.appendTextLine("§e§lCoffre OR");
		hor.appendItemLine(new ItemStack(Material.GOLD_INGOT));
		
		Hologram hdm = HologramsAPI.createHologram(Survie.plugin, locdmh.add(0.5, 1.6,0.5));
		hdm.appendTextLine("§9§lCoffre Diamant");
		hdm.appendItemLine(new ItemStack(Material.DIAMOND));
		
		
		Hologram hem = HologramsAPI.createHologram(Survie.plugin, locemh.add(0.5, 1.6,0.5));
		hem.appendTextLine("§2§lCoffre Emeraude");
		hem.appendItemLine(new ItemStack(Material.EMERALD));
		
		
		
		
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Survie.plugin, new Runnable(){

			public void run(){
				GregorianCalendar calendar = new GregorianCalendar();
				//int day = calendar.get(Calendar.DAY_OF_WEEK);
				int hour = calendar.get(Calendar.HOUR_OF_DAY);
				//int min = calendar.get(Calendar.MINUTE);
				
			if(hour == 5 && !resetok0.contains("LootChest")) {
				try {
				MySQL.createStatement("TRUNCATE lootchest;");
				resetok0.add("LootChest");
				utility.logToFile("ok: lootchest reset!");
				} catch(Exception o) {
					utility.logToFile("Erreur: loochets reset fail,Con null");
					return;
				}
			}
			
			if(hour == 6 && resetok0.contains("LootChest")) resetok0.remove("LootChest");
				
			}
		}, 10, 300*20);
		
		
	}
	
	
	
	public boolean PlayerChest(Player p) {
		
   	    ResultSet rs = MySQL.querySQL("SELECT * FROM lootchest WHERE uuid = '" + p.getUniqueId().toString() + "';");
   	    try {
   	      if (rs.next()) {
   	        return true;
   	      }
   	    } catch (SQLException e) {
   	      System.out.println("MySQL-Error: " + e.getMessage());
   	      return true;
   	    }
   	    return false;
	}
	
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {

		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) { 
			Block b = e.getClickedBlock();
			Location locb = b.getLocation();
			Player p = e.getPlayer();
			if(b.getType() == Material.CHEST) {
				
				if (locb.equals(lochelp)){
					e.setCancelled(true);
					p.openInventory(Aide.displayAide(false));
				}
				
				else if (locb.equals(loc0)){
					LootInv(p);
					e.setCancelled(true);
				}
			}
		}
	}
	
	
	
	public void LootInv(Player p){
		
		final String pname = p.getName();
		
		if(!PlayerChest(p)){
		GUILoot.put(pname, Bukkit.createInventory(p, 27, "§a§lSurprise " + pname));
		MySQL.createStatement("INSERT INTO lootchest (player, uuid) VALUES ('" + pname + "', '" + p.getUniqueId().toString() + "')");
		SetSurprise(GUILoot.get(pname));
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Survie.plugin, new Runnable()
	    {
	      public void run()
	      {
	    	  GUILoot.get(pname).clear(); GUILoot.remove(pname);
	      }
	    }, 120 * 20L);
		}
		
		if(GUILoot.containsKey(pname)) {
			p.openInventory(GUILoot.get(pname));
		} else {
			utility.sendActionBar(p,"§6\u2615 §5§lLe coffre Surprise se régénére chaque 24 heures ;) §6\u2615");
			pushBack(loc0,p);
		} 

		
	}
	
	
	
	public static void pushBack(Location source, Player player) {
	    Location loc2 = player.getLocation();
	    double deltaX = loc2.getX() - source.getX();
	    double deltaZ = loc2.getZ() - source.getZ();
	    
	    org.bukkit.util.Vector vec = new org.bukkit.util.Vector(deltaX, 0.0D, deltaZ);
	    vec.normalize();
	    
	    player.setVelocity(vec.multiply(5 / Math.sqrt(Math.pow(deltaX, 2.0D) + Math.pow(deltaZ, 2.0D))));
	  }
	
	
	ItemStack a1 = new ItemStack(Material.DIAMOND);
	ItemStack a2 = new ItemStack(Material.EMERALD);
	ItemStack a3 = new ItemStack(Material.GOLD_INGOT);
	
	ItemStack b1 = new ItemStack(Material.ENDER_PEARL, 2);
	ItemStack b2 = new ItemStack(Material.EYE_OF_ENDER);
	ItemStack b3 = new ItemStack(Material.GOLDEN_APPLE);
	
	ItemStack c1 = new ItemStack(Material.GOLDEN_CARROT);
	ItemStack c2 = new ItemStack(Material.PRISMARINE);
	ItemStack c3 = new ItemStack(Material.PRISMARINE_CRYSTALS);
	
	ItemStack d1 = new ItemStack(Material.IRON_INGOT, 4);
	ItemStack d2 = new ItemStack(Material.IRON_PICKAXE);
	ItemStack d3 = new ItemStack(Material.IRON_SWORD);
	
	ItemStack e1 = new ItemStack(Material.TNT);
	ItemStack e2 = new ItemStack(Material.OBSIDIAN, 2);
	ItemStack e3 = new ItemStack(Material.EXP_BOTTLE, 2);
	
	
	
	ItemStack z1 = new ItemStack(Material.STONE, 4 , (short) 1);
	ItemStack z2 = new ItemStack(Material.STONE, 4 , (short) 2);
	ItemStack z3 = new ItemStack(Material.STONE, 4 , (short) 3);
	ItemStack z4 = new ItemStack(Material.STONE, 4 , (short) 4);
	ItemStack z5 = new ItemStack(Material.WOOD, 8);
	ItemStack z6 = new ItemStack(Material.SANDSTONE, 2);
	ItemStack z7 = new ItemStack(Material.WOOL, 2);
	ItemStack z8 = new ItemStack(Material.CHEST);
	ItemStack z9 = new ItemStack(Material.FURNACE);
	ItemStack z10 = new ItemStack(Material.CACTUS , 2);
	ItemStack z11 = new ItemStack(Material.PUMPKIN , 2);
	ItemStack z12 = new ItemStack(Material.SOUL_SAND);
	ItemStack z13 = new ItemStack(Material.GLASS, 5);
	ItemStack z14 = new ItemStack(Material.WATER_LILY);
	ItemStack z15 = new ItemStack(Material.TRIPWIRE_HOOK);
	ItemStack z16 = new ItemStack(Material.CLAY , 4);
	ItemStack z17 = new ItemStack(Material.QUARTZ_BLOCK);
	ItemStack z18 = new ItemStack(Material.WHEAT, 2);
	ItemStack z19 = new ItemStack(Material.CARPET, 2);
	ItemStack z20 = new ItemStack(Material.COAL, 8);
	ItemStack z21 = new ItemStack(Material.RED_ROSE, 2);
	ItemStack z22 = new ItemStack(Material.RED_SANDSTONE, 2);
	ItemStack z23 = new ItemStack(Material.SAND, 3);
	ItemStack z24 = new ItemStack(Material.APPLE, 3);
	ItemStack z25 = new ItemStack(Material.IRON_SWORD);
	ItemStack z26 = new ItemStack(Material.BOW);
	ItemStack z27 = new ItemStack(Material.BOAT);
	ItemStack z28 = new ItemStack(Material.BONE, 6);
	ItemStack z29 = new ItemStack(Material.ARROW, 6);
	ItemStack z30 = new ItemStack(Material.ARMOR_STAND);
	ItemStack z31 = new ItemStack(Material.STRING, 2);
	ItemStack z32 = new ItemStack(Material.FEATHER, 2);
	ItemStack z33 = new ItemStack(Material.BREAD, 2);
	ItemStack z34 = new ItemStack(Material.STICK, 6);
	ItemStack z35 = new ItemStack(Material.SAPLING);
	ItemStack z36 = new ItemStack(Material.BLAZE_ROD);
	ItemStack z37 = new ItemStack(Material.BAKED_POTATO, 2);
	ItemStack z38 = new ItemStack(Material.BANNER, 2);
	ItemStack z39 = new ItemStack(Material.BED);
	ItemStack z40 = new ItemStack(Material.BRICK, 4);
	ItemStack z41 = new ItemStack(Material.BLAZE_POWDER);
	ItemStack z42 = new ItemStack(Material.CARROT_ITEM);
	ItemStack z43 = new ItemStack(Material.REDSTONE, 4);
	ItemStack z44 = new ItemStack(Material.SUGAR_CANE);
	ItemStack z45 = new ItemStack(Material.SLIME_BALL, 2);
	ItemStack z46 = new ItemStack(Material.PAPER);
	ItemStack z47 = new ItemStack(Material.PAINTING);
	ItemStack z48 = new ItemStack(Material.GOLD_NUGGET);
	ItemStack z49 = new ItemStack(Material.MUTTON);
	ItemStack z50 = new ItemStack(Material.BOOK_AND_QUILL);
	ItemStack z51 = new ItemStack(Material.BOOKSHELF);
	ItemStack z52 = new ItemStack(Material.BROWN_MUSHROOM);
	ItemStack z53 = new ItemStack(Material.BUCKET);
	ItemStack z54 = new ItemStack(Material.CAKE);
	ItemStack z55 = new ItemStack(Material.COAL_BLOCK);
	ItemStack z56 = new ItemStack(Material.INK_SACK, 2, (short) 3);
	ItemStack z57 = new ItemStack(Material.COMPASS);
	ItemStack z58 = new ItemStack(Material.COOKED_BEEF, 2);
	ItemStack z59 = new ItemStack(Material.COOKED_CHICKEN, 2);
	ItemStack z60 = new ItemStack(Material.COOKED_FISH, 2);
	ItemStack z61 = new ItemStack(Material.COOKED_RABBIT, 3);
	ItemStack z62 = new ItemStack(Material.COOKIE, 5);
	ItemStack z63 = new ItemStack(Material.DIRT, 5);
	ItemStack z64 = new ItemStack(Material.EMPTY_MAP);
	ItemStack z65 = new ItemStack(Material.FERMENTED_SPIDER_EYE);
	ItemStack z66 = new ItemStack(Material.FLINT, 2);
	ItemStack z67 = new ItemStack(Material.GLOWSTONE_DUST);
	ItemStack z68 = new ItemStack(Material.GRAVEL, 3);
	ItemStack z69 = new ItemStack(Material.GRILLED_PORK);
	ItemStack z70 = new ItemStack(Material.ICE);
	ItemStack z71 = new ItemStack(Material.ITEM_FRAME);
	ItemStack z72 = new ItemStack(Material.JACK_O_LANTERN);
	
	ItemStack AT [] = {a1, a2, a3};
	ItemStack BT [] = {b1, b2, b3};
	ItemStack CT [] = {c1, c2, c3};
	ItemStack DT [] = {d1, d2, d3};
	ItemStack ET [] = {e1, e2, e3};
	ItemStack ZT [] = {z1, z2, z3, z4, z5, z6, z7, z8, z9, z10, z11, z12, z13, z14, z15, z16, z17, z18, z19, z20, z21, z22, z23, z24, z25, z26, z27, z28, z29, z30,
		z31, z32, z33, z34, z35, z36, z37, z38, z40, z41, z42, z43, z44, z45, z46, z47, z48, z49, z50, z51, z52, z53, z54, z55, z56, z57, z58, z59, z60, z61, z62, z63, z64,
		z65, z66, z67, z68, z69, z70, z71, z72};
	
	public void SetSurprise(Inventory inv) {
		
		int xa = ThreadLocalRandom.current().nextInt(0,3);
		inv.setItem(0, AT[xa]);
		
		int xb = ThreadLocalRandom.current().nextInt(0,3);
		inv.setItem(1, BT[xb]);
		
		int xc = ThreadLocalRandom.current().nextInt(0,3);
		inv.setItem(2, CT[xc]);
		
		int xd = ThreadLocalRandom.current().nextInt(0,3);
		inv.setItem(3, DT[xd]);
		
		int xe = ThreadLocalRandom.current().nextInt(0,3);
		inv.setItem(4, ET[xe]);
		
		for (int i = 5; i < 27; i++) {
			int xz = ThreadLocalRandom.current().nextInt(0,71);
			inv.setItem(i, ZT[xz]);
		}
		
		
	}
	
	

}
