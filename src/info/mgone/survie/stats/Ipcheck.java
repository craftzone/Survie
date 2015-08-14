package info.mgone.survie.stats;

import info.mgone.survie.MySQL;

import java.sql.ResultSet;
import java.sql.SQLException;




import me.confuser.banmanager.BmAPI;

import org.bukkit.entity.Player;

public class Ipcheck {
	
	public static boolean CheckIP(Player p) {
		
		String puuid = p.getUniqueId().toString();
		String pname = p.getName();
		if(BmAPI.isBanned(pname)) return false;
		String ip = p.getAddress().getHostString();
		if(p.isOp() || p.hasPermission("ip.nocheck") || p.hasPermission("ip.nocheck.1")|| p.hasPermission("ip.nocheck.2")) return false;
		
	    ResultSet rs = MySQL.querySQL("SELECT * FROM ipcheck WHERE ip = '" + ip + "';");
	    try {
	      if (rs.next()) {
	    	  
	    	  String pname1 = rs.getString("player");
	    	  String puuid1 = rs.getString("uuid");
	    	  
	    	if(!puuid.equals(puuid1)) {
	    	if(BmAPI.isBanned(pname1)) { p.kickPlayer("§c§lVous utiliser la même adresse que le joueur §6§l"+ pname1 + " §c§lbanni, "
	    				+ "en essayant de se connecter avec un double compte, vous risquez ne plus avoir une autre chance, §b§lfaite une demande de pardon sur le forum!"); 
	    		return true;
	    		} else {
	    			p.kickPlayer("§c§lLe joueur §6§l"+ pname1 + " §c§lutilise déja cette adresse ip, "
		    				+ "§b§lles doubles comptes sont interdits! §a§lpour les membres de la même famille demandez un déblocage sur le forum.");
		    		return true;
	    			
	    		}
	    				
	    			
	    	} 

	      } else {
	    	  
	    	  MySQL.createStatement("INSERT INTO ipcheck (player, uuid, ip) VALUES ('" + pname + "', '" + puuid + "', '" + ip + "')");
	    	  
	    	  return false;
	      }
	      
	      
	      
	    } catch (SQLException e) {
	      System.out.println("MySQL-Error: " + e.getMessage()); return false;
	    }
	    
	    
	    return false;
	  }

}
