package info.mgone.survie.stats;

import info.mgone.survie.LoginPlayer;
import info.mgone.survie.MySQL;
import info.mgone.survie.Survie;
import info.mgone.survie.noob.NoobPvP;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class Stats {

	
	public static boolean HaveStats(Player p) {
	    ResultSet rs = MySQL.querySQL("SELECT * FROM playerstats WHERE uuid = '" + p.getUniqueId().toString() + "';");
	    try {
	      if (rs.next()) {
	        return true;
	      }
	    } catch (SQLException e) {
	      System.out.println("MySQL-Error: " + e.getMessage());
	    }
	    return false;
	  }
	
	
	public static void NewStats(Player p) {
		
		String pname = p.getName(); 
		String uuid = p.getUniqueId().toString();
		double timep = 0;
		int joinp = 1;
		double firsjoin = System.currentTimeMillis();
		double lastjoin = System.currentTimeMillis();
		double lastleave = 0;
		MySQL.createStatement("INSERT INTO playerstats (player, uuid, timep, joinp, firsjoin, lastjoin, lastleave)"
				+ " VALUES ('" + pname + "', '" + uuid + "', '" + timep + "', '" + joinp + "', '" + firsjoin + "', '" + lastjoin + "', '" + lastleave + "')");
		
	}
	
   public static double GetUpstatsJoin(Player p) {
		
	    String pname = p.getName();
		String uuid = p.getUniqueId().toString();
		double lastjoin = System.currentTimeMillis();
		
		ResultSet rs = MySQL.querySQL("SELECT * FROM playerstats WHERE uuid = '" + uuid + "';");
		 try {
		      while (rs.next()) {
		    	  String pname1 = rs.getString("player"); 
				  int joinp1 = rs.getInt("joinp") +1;
				  double timep = rs.getDouble("timep");
				  
				  
				  if (!pname.equals(pname1)) {
					  MySQL.createStatement("UPDATE playerstats SET player = '" + pname + "' WHERE uuid = '" + uuid + " ';");
					  MySQL.createStatement("UPDATE ipcheck SET player = '" + pname + "' WHERE uuid = '" + uuid + " ';");
					  MySQL.createStatement("UPDATE blocstats SET player = '" + pname + "' WHERE uuid = '" + uuid + " ';");
					  MySQL.createStatement("UPDATE perm SET player = '" + pname + "' WHERE uuid = '" + uuid + " ';");
					  MySQL.createStatement("UPDATE skills SET player = '" + pname + "' WHERE uuid = '" + uuid + " ';");
					  MySQL.createStatement("UPDATE noobprotect SET player = '" + pname + "' WHERE uuid = '" + uuid + " ';");
					  //clan
					  MySQL.createStatement("UPDATE sc_players SET name = '" + pname + "' WHERE uuid = '" + uuid + " ';");
					  MySQL.createStatement("UPDATE sc_kills SET attacker = '" + pname + "' WHERE attacker_uuid = '" + uuid + " ';");
					  MySQL.createStatement("UPDATE sc_kills SET victim = '" + pname + "' WHERE victim_uuid = '" + uuid + " ';");
					  //HDV
					  MySQL.createStatement("UPDATE history SET player = '" + pname + "' WHERE player = '" + pname1 + " ';");
					  MySQL.createStatement("UPDATE history SET who = '" + pname + "' WHERE who = '" + pname1 + " ';");
					  MySQL.createStatement("UPDATE listings SET seller = '" + pname + "' WHERE seller = '" + pname1 + " ';");
					  MySQL.createStatement("UPDATE mail SET owner = '" + pname + "' WHERE owner = '" + pname1 + " ';");
					  MySQL.createStatement("UPDATE mail SET sender = '" + pname + "' WHERE sender = '" + pname1 + " ';");
					  MySQL.createStatement("UPDATE users SET name = '" + pname + "' WHERE name = '" + pname1 + " ';");
					  
				  p.sendMessage("§cVous avez changé votre pseudo, mise-à-jour de vos données...");
				  }
				  
				  MySQL.createStatement("UPDATE playerstats SET joinp = '" + joinp1 + "', lastjoin = '" + lastjoin + "' WHERE uuid = '" + uuid + " ';");
				  return timep;
				  
		      }
		    } catch (SQLException e) {
		      System.out.println("MySQL-Error: " + e.getMessage());
		    } 
		 return 0;
	 }
	

   public static void UpstatsLogout(Player p, double timenow) {
		
		String uuid = p.getUniqueId().toString();
		double lastleave= System.currentTimeMillis();
		MySQL.createStatement("UPDATE playerstats SET timep = timep + '" + timenow + "', lastleave = '" + lastleave + "' WHERE uuid = '" + uuid + " ';");	  
		
	 }
	
    public static void UpstatsTime(Player p, double timenow) {
		
		String uuid = p.getUniqueId().toString();
		MySQL.createStatement("UPDATE playerstats SET timep = timep + '" + timenow + "' WHERE uuid = '" + uuid + " ';");	  
		
	 }
    
    
     public static double GetstatsTime(Player p) {
		
		String uuid = p.getUniqueId().toString();
		ResultSet rs = MySQL.querySQL("SELECT * FROM playerstats WHERE uuid = '" + uuid + "';");
		
		try {
		      while (rs.next()) {
				  double timep1 = rs.getDouble("timep");
				  return timep1;
		      }
		    } catch (SQLException e) {
		      System.out.println("MySQL-Error: " + e.getMessage());
		    }
		return 0;
		
	 }
     
     static int i = 0;
     public static void StatsTask() {
    	 
    /*	 Bukkit.getScheduler().scheduleSyncRepeatingTask(Survie.getPluginInstance(),
					new Runnable() {
						public void run() {
                       Bukkit.broadcastMessage("Cp:" + i + "-----" + Lag.getTPS());
                       i++;
						}
   }, 2 *20, 1 * 20); */
    	 
    	 Bukkit.getScheduler().scheduleSyncRepeatingTask(Survie.getPluginInstance(),
					new Runnable() {
						public void run() {
							for (Player pe : Bukkit.getOnlinePlayers()) {
								String pename = pe.getName();
								LoginPlayer.timep.put(pename, LoginPlayer.timep.get(pename)+30);
								NoobPvP.DecompteNoob(pe);
							}
						}
      }, 2 *20, 30 * 20);
    	 
    		 Bukkit.getScheduler().scheduleSyncRepeatingTask(Survie.getPluginInstance(),
    					new Runnable() {
    						public void run() {
    							for (Player pe : Bukkit.getOnlinePlayers()) {
    								String pename = pe.getName();
    								UpstatsTime(pe, LoginPlayer.timep.get(pename));
    								LoginPlayer.timep.put(pename, (double) 0);
    							}
    						}
             }, 300, 600 * 20);
    	 
     }
     
     
	public static void StatsRebbot() {
    	 for (Player pe : Bukkit.getOnlinePlayers()) {
    		 String pename = pe.getName();
    		UpstatsLogout(pe, LoginPlayer.timep.get(pename));
    		LoginPlayer.timep.put(pename, (double) 0);
    	 } 
     }
     
     
     
     @SuppressWarnings("deprecation")
	public static String GetStats(String playername) {
    	 
    	 SimpleDateFormat formater = null;
    	 formater = new SimpleDateFormat("dd/MM/yy HH:mm");
    	 OfflinePlayer player = Bukkit.getOfflinePlayer(playername);  
    	 if(player == null) return "§cJoueur invalide!";
    	 double timeplus = 0;
    	 String pname = player.getName();
    	 
    	 if(player.isOnline()) {
    		 timeplus = LoginPlayer.timep.get(pname);
    	 }
    	 
 		 String uuid = player.getUniqueId().toString();
 		 
 		ResultSet rs = MySQL.querySQL("SELECT * FROM playerstats WHERE uuid = '" + uuid + "';");
		 try {
		      while (rs.next()) {
		    	  String pname1 = rs.getString("player"); 
				  Double timep1 = rs.getDouble("timep");
				  int joinp1 = rs.getInt("joinp");
				  Double firsjoin1 = rs.getDouble("firsjoin");
				  Double lastjoin1 = rs.getDouble("lastjoin");
				  Double lastleave1 = rs.getDouble("lastleave");
				  
				  
				  return "§f================================\n"
					+ "          §fStats de §d" + pname1 + "\n"
					+ "§bTemps de jeux: §6" + calculateTimeStats(timep1+timeplus) + "\n"
					+ "§f================================\n"
					+ "§3Première connection: §e" + formater.format(firsjoin1) + "\n"
					+ "§3Nombre de connections: §e" + joinp1 + "\n"
					+ "§3Dérnière connection: §e" + formater.format(lastjoin1) + "\n"
					+ "§3Dérnière déconnection: §e" + formater.format(lastleave1) + "\n"
					+ "§f================================\n";
				  
				  
		      }
		    } catch (SQLException e) {
		      System.out.println("MySQL-Error: " + e.getMessage());
		    }  
 		 
    	 
		return "§cJoueur introuvable!";
     }
     
     
     public static String calculateTimeStats(double secondss) {
		  
		  long seconds = Math.round(secondss);
		  //int day = (int)TimeUnit.SECONDS.toDays(seconds);        
		  long hours = TimeUnit.SECONDS.toHours(seconds);
		  long minute = TimeUnit.SECONDS.toMinutes(seconds) - (TimeUnit.SECONDS.toHours(seconds)* 60);
		  //long second = TimeUnit.SECONDS.toSeconds(seconds) - (TimeUnit.SECONDS.toMinutes(seconds) *60);

	      String restant = hours +  " heures " + minute + " minutes ";
	      
	      return restant;

	  }

}
