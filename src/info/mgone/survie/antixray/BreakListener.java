package info.mgone.survie.antixray;

import info.mgone.survie.MySQL;
import info.mgone.survie.Survie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakListener implements Listener {
	
	public static HashMap<String, Integer> stone = new HashMap<String, Integer>();
	public static HashMap<String, Integer> gold = new HashMap<String, Integer>();
	public static HashMap<String, Integer> iron = new HashMap<String, Integer>();
	public static HashMap<String, Integer> coal = new HashMap<String, Integer>();
	public static HashMap<String, Integer> lapis = new HashMap<String, Integer>();
	public static HashMap<String, Integer> diamond = new HashMap<String, Integer>();
	public static HashMap<String, Integer> redstone = new HashMap<String, Integer>();
	public static HashMap<String, Integer> emerald = new HashMap<String, Integer>();
	public static HashMap<String, Integer> gravel = new HashMap<String, Integer>();
	public static HashMap<String, Integer> quartz = new HashMap<String, Integer>();
	public static HashMap<String, Integer> nether = new HashMap<String, Integer>();


    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){
    	
    	if(e.isCancelled()) return;
    	
        Block bl = e.getBlock();
        Player p =e.getPlayer();
        String pn = p.getName();
       
        
        switch(bl.getType()){
            case STONE:  stone.put(pn, stone.get(pn)+1);  break;
            case GOLD_ORE: gold.put(pn, gold.get(pn)+1);  break;
            case IRON_ORE:  iron.put(pn, iron.get(pn)+1);  break;
            case COAL_ORE:  coal.put(pn, coal.get(pn)+1); break;
            case LAPIS_ORE:  lapis.put(pn, lapis.get(pn)+1);  break;
            case DIAMOND_ORE:  diamond.put(pn, diamond.get(pn)+1);  break;
            case REDSTONE_ORE: redstone.put(pn, redstone.get(pn)+1);  break;
            case GLOWING_REDSTONE_ORE:  redstone.put(pn, redstone.get(pn)+1); break;
            case EMERALD_ORE:  emerald.put(pn, emerald.get(pn)+1);  break;
            case GRAVEL:  gravel.put(pn, gravel.get(pn)+1); break;
            case QUARTZ_ORE:  quartz.put(pn, quartz.get(pn)+1); break;
            case NETHERRACK:  nether.put(pn, nether.get(pn)+1); break;
            default: break;
        }

    }
    
    
    public static void playerlogin(Player p){
    	
    	String pn = p.getName(); 
		String uuid = p.getUniqueId().toString();
    	
    	if(!HaveStats(p)) {
    		MySQL.createStatement("INSERT INTO blocstats (player, uuid, stone, gold, iron, coal, lapis, diamond, redstone, emerald, gravel, quartz, nether) VALUES ('" + pn + "', '" + uuid + "', 0,0,0,0,0,0,0,0,0,0,0)");
    	}
    	
    	PutPlayerStats(pn);
    	
    }
    
    
    public static void StatsTaskBlocks() {
    	
    	
    	Bukkit.getScheduler().scheduleSyncRepeatingTask(Survie.getPluginInstance(),
				new Runnable() {
					public void run() {
						for (Player pe : Bukkit.getOnlinePlayers()) {
							String pn = pe.getName(); 
							SavePlayerStats(pe);
							PutPlayerStats(pn);
						}
					}
    }, 2 *20, 600 * 20);
    	
    	
    }
    
    
    
    public static void PutPlayerStats(String pn) {
    	stone.put(pn,0);
    	gold.put(pn,0);
    	iron.put(pn,0);
    	coal.put(pn,0);
    	lapis.put(pn,0);
    	diamond.put(pn,0);
    	redstone.put(pn,0);
    	emerald.put(pn,0);
    	gravel.put(pn,0);
    	quartz.put(pn,0);
    	nether.put(pn,0);
    }
    
    
    public static void RemovePlayerStats(String pn) {
    	stone.remove(pn);
    	gold.remove(pn);
    	iron.remove(pn);
    	coal.remove(pn);
    	lapis.remove(pn);
    	diamond.remove(pn);
    	redstone.remove(pn);
    	emerald.remove(pn);
    	gravel.remove(pn);
    	quartz.remove(pn);
    	nether.remove(pn);
    }
    
    
    public static void SavePlayerStats(Player p) {
    	
    	String pn = p.getName(); 
    	String uuid = p.getUniqueId().toString();
    	
    MySQL.createStatement("UPDATE blocstats SET stone = stone + '" + stone.get(pn) + "', gold = gold + '" + gold.get(pn) + "',"
    		+ "iron = iron + '" + iron.get(pn) + "', coal = coal + '" + coal.get(pn) + "', lapis = lapis + '" + lapis.get(pn) + "',"
    		+ "diamond = diamond + '" + diamond.get(pn) + "', redstone = redstone + '" + redstone.get(pn) + "', emerald = emerald + '" + emerald.get(pn) + "',"
    		+ "gravel = gravel + '" + gravel.get(pn) + "', quartz = quartz + '" + quartz.get(pn) + "', nether = nether + '" + nether.get(pn) + "'"
    		+ " WHERE uuid = '" + uuid + " ';");
    }
    
    
    public static boolean HaveStats(Player p) {
   	    ResultSet rs = MySQL.querySQL("SELECT * FROM blocstats WHERE uuid = '" + p.getUniqueId().toString() + "';");
   	    try {
   	      if (rs.next()) {
   	        return true;
   	      }
   	    } catch (SQLException e) {
   	      System.out.println("MySQL-Error: " + e.getMessage());
   	    }
   	    return false;
   	  }
    
    
    @SuppressWarnings("deprecation")
	public static void SendStats(Player sender, String pn) {
    	
    	OfflinePlayer p = Bukkit.getOfflinePlayer(pn);
    	if(p == null) return;
    	
    	int stonei = 0;
    	int goldi = 0;
    	int ironi = 0;
    	int coali = 0;
    	int lapisi = 0;
    	int diamondi = 0;
    	int redstonei = 0;
    	int emeraldi = 0;
    	int graveli = 0;
    	int quartzi = 0;
    	int netheri = 0;
    	
    	if(p.isOnline()) {
    		
    		stonei = stone.get(pn);
        	goldi = gold.get(pn);
        	ironi = iron.get(pn);
        	coali = coal.get(pn);
            lapisi = lapis.get(pn);
        	diamondi = diamond.get(pn);
        	redstonei = redstone.get(pn);
        	emeraldi = emerald.get(pn);
        	graveli = gravel.get(pn);
        	quartzi = quartz.get(pn);
        	netheri = nether.get(pn);

   	     }
    	
    	String uuid = p.getUniqueId().toString();
    	
    	
    	ResultSet rs = MySQL.querySQL("SELECT * FROM blocstats WHERE uuid = '" + uuid + "';");
		 try {
		      while (rs.next()) {
		    	  
		    	  stonei = stonei + rs.getInt("stone");
		    	  goldi = goldi + rs.getInt("gold");
		          ironi = ironi + rs.getInt("iron");
		          coali = coali + rs.getInt("coal");
		          lapisi = lapisi + rs.getInt("lapis");
		          diamondi = diamondi + rs.getInt("diamond");
		          redstonei = redstonei + rs.getInt("redstone");
		          emeraldi = emeraldi + rs.getInt("emerald");
		          graveli = graveli + rs.getInt("gravel");
		          quartzi = quartzi + rs.getInt("quartz");
		          netheri = netheri + rs.getInt("nether");
		    	  
		      }
       } catch (SQLException e) {
         System.out.println("MySQL-Error: " + e.getMessage());
       }  
    	
    	sender.sendMessage("§7Stone: " + stonei + "\n"
    			+ "§6Gold: " + goldi + "\n"
    	        + "§fIron: " + ironi + "\n"
    	        + "§0Coal: " + coali + "\n"
    	        + "§1lapis: " + lapisi + "\n"
    	        + "§bDiamond: " + diamondi + "\n"
    	        + "§4Redstone: " + redstonei + "\n"
    	        + "§aEmerald: " + emeraldi + "\n"
    	        + "§8Gravel: " + graveli + "\n"
    	        + "§cnetherRack: " + netheri + "\n"
    	        + "§fQuartz: " + quartzi + "\n"
    	        + "§f================================\n"
    			);
    	
    }
    
    
    
    
}

