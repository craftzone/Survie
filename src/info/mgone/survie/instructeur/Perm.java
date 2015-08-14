package info.mgone.survie.instructeur;

import info.mgone.survie.MySQL;
import info.mgone.survie.Survie;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.entity.Player;

public class Perm {
	
	
	public static boolean HavePerm(Player p) {
   	    ResultSet rs = MySQL.querySQL("SELECT * FROM perm WHERE uuid = '" + p.getUniqueId().toString() + "';");
   	    try {
   	      if (rs.next()) {
   	        return true;
   	      }
   	    } catch (SQLException e) {
   	      System.out.println("MySQL-Error: " + e.getMessage());
   	    }
   	    return false;
   	  }
	
	
	public static void AddNewPerm(Player p) {
		String pname = p.getName(); 
		String uuid = p.getUniqueId().toString();
		int chestslot = 0, chestender = 0, chestcmd = 0, pv = 0, speed = 0, baston = 0;
		MySQL.createStatement("INSERT INTO perm (player, uuid, chestslot, chestender, chestcmd, pv, speed, baston) VALUES "
		   		+ "('" + pname + "', '" + uuid + "', '" + chestslot + "', '" + chestender + "', '" + chestcmd + "', '" + pv + "', '" + speed + "', '" + baston + "')");
		
		
   	  }
	
	
	
	public static void SetPerm(Player p) {
		String uuid = p.getUniqueId().toString();
		
		ResultSet rs = MySQL.querySQL("SELECT * FROM perm WHERE uuid = '" + uuid + "';");
		
		try {
		      while (rs.next()) {
				  int chestslot = rs.getInt("chestslot");
				  int chestender = rs.getInt("chestender");
				  int chestcmd = rs.getInt("chestcmd");
				  int pv = rs.getInt("pv");
				  int speed = rs.getInt("speed");
				  //int baston = rs.getInt("baston");
				  
				  
				  if(chestslot == 1) Survie.permission.playerAddTransient(p, "betterenderchest.slots.upgrade1");
				  else if(chestslot == 2) Survie.permission.playerAddTransient(p, "betterenderchest.slots.upgrade2");
				  
				  else if(chestslot == 5 && p.hasPermission("slots.heros")) Survie.permission.playerAddTransient(p, "betterenderchest.slots.upgrade5");
				  else if(chestslot >= 4 && p.hasPermission("slots.chevalier")) Survie.permission.playerAddTransient(p, "betterenderchest.slots.upgrade4");
				  else if(chestslot >= 3 && p.hasPermission("slots.guerrier")) Survie.permission.playerAddTransient(p, "betterenderchest.slots.upgrade3");

				  else if(chestslot >= 3 && !p.hasPermission("slots.guerrier")) Survie.permission.playerAddTransient(p, "betterenderchest.slots.upgrade2");
				  
				  if(chestender == 1) Survie.permission.playerAddTransient(p, "betterenderchest.user");
				  
				  if(chestcmd == 1) Survie.permission.playerAddTransient(p, "betterenderchest.command.openinv");
				  
				  if(pv == 1) p.setMaxHealth(31);
				  else if(pv == 2) p.setMaxHealth(32);
				  
				  else if(pv == 5 && p.hasPermission("pv.heros")) p.setMaxHealth(35);
				  else if(pv >= 4 && p.hasPermission("pv.chevalier")) p.setMaxHealth(34);
				  else if(pv >= 3 && p.hasPermission("pv.guerrier")) p.setMaxHealth(33);

				  else if(pv >= 3 && !p.hasPermission("pv.guerrier")) p.setMaxHealth(32);
				  
				  
				  if(speed == 1) p.setWalkSpeed(0.206F);
				  else if(speed == 2) p.setWalkSpeed(0.21F);
				  
				  else if(speed == 5 && p.hasPermission("speed.heros")) p.setWalkSpeed(0.222F);
				  else if(speed >= 4 && p.hasPermission("speed.chevalier")) p.setWalkSpeed(0.218F);
				  else if(speed >= 3 && p.hasPermission("speed.guerrier")) p.setWalkSpeed(0.214F);
				  
				  else if(speed >= 3 && !p.hasPermission("speed.guerrier")) p.setWalkSpeed(0.21F);
				  
		      }
		    } catch (SQLException e) {
		      System.out.println("MySQL-Error: " + e.getMessage());
	}
		
		
	}
	
	
	public static int GetPermChestslot(Player p) {

		String uuid = p.getUniqueId().toString();

		ResultSet rs = MySQL.querySQL("SELECT chestslot FROM perm WHERE uuid = '"
				+ uuid + "';");

		try {
			while (rs.next()) {
				int chestslot = rs.getInt("chestslot");
				return chestslot;
			}
		} catch (SQLException e) {
			System.out.println("MySQL-Error: " + e.getMessage());
		}
		return 0;
	}
	
	
	public static int GetPermChestender(Player p) {

		String uuid = p.getUniqueId().toString();

		ResultSet rs = MySQL.querySQL("SELECT chestender FROM perm WHERE uuid = '"
				+ uuid + "';");

		try {
			while (rs.next()) {
				int chestender = rs.getInt("chestender");
				return chestender;
			}
		} catch (SQLException e) {
			System.out.println("MySQL-Error: " + e.getMessage());
		}
		return 0;
	}

	
	public static int GetPermChestcmd(Player p) {

		String uuid = p.getUniqueId().toString();

		ResultSet rs = MySQL.querySQL("SELECT chestcmd FROM perm WHERE uuid = '"
				+ uuid + "';");

		try {
			while (rs.next()) {
				int chestcmd = rs.getInt("chestcmd");
				return chestcmd;
			}
		} catch (SQLException e) {
			System.out.println("MySQL-Error: " + e.getMessage());
		}
		return 0;
	}
	
	
	public static int GetPermPv(Player p) {

		String uuid = p.getUniqueId().toString();

		ResultSet rs = MySQL.querySQL("SELECT pv FROM perm WHERE uuid = '"
				+ uuid + "';");

		try {
			while (rs.next()) {
				int pv = rs.getInt("pv");
				return pv;
			}
		} catch (SQLException e) {
			System.out.println("MySQL-Error: " + e.getMessage());
		}
		return 0;
	}
	
	
	public static int GetPermSpeed(Player p) {

		String uuid = p.getUniqueId().toString();

		ResultSet rs = MySQL.querySQL("SELECT speed FROM perm WHERE uuid = '"
				+ uuid + "';");

		try {
			while (rs.next()) {
				int speed = rs.getInt("speed");
				return speed;
			}
		} catch (SQLException e) {
			System.out.println("MySQL-Error: " + e.getMessage());
		}
		return 0;
	}
	
	
	
	public static boolean SetPermChestslot(Player p, int slot) {

		String uuid = p.getUniqueId().toString();

		try {
			MySQL.createStatement("UPDATE perm SET chestslot = '" + slot + "' WHERE uuid = '" + uuid + " ';");
			Survie.permission.playerAddTransient(p, "betterenderchest.slots.upgrade" + slot);
			return true;
		} catch (Exception o) {
			return false;
		}
	}
	
	
	public static boolean SetPermChestender(Player p) {

		String uuid = p.getUniqueId().toString();
		int ok = 1;

		try {
			MySQL.createStatement("UPDATE perm SET chestender = '" + ok + "' WHERE uuid = '" + uuid + " ';");
			Survie.permission.playerAddTransient(p, "betterenderchest.user");
			return true;
		} catch (Exception o) {
			return false;
		}
	}
	
	
	
	public static boolean SetPermChestcmd(Player p) {

		String uuid = p.getUniqueId().toString();
		int ok = 1;

		try {
			MySQL.createStatement("UPDATE perm SET chestcmd = '" + ok + "' WHERE uuid = '" + uuid + " ';");
			Survie.permission.playerAddTransient(p, "betterenderchest.command.openinv");
			return true;
		} catch (Exception o) {
			return false;
		}
	}
	
	
	public static boolean SetPermPv(Player p, int pv) {

		String uuid = p.getUniqueId().toString();

		try {
			MySQL.createStatement("UPDATE perm SET pv = '" + pv + "' WHERE uuid = '" + uuid + " ';");
			  if(pv == 1) p.setMaxHealth(31);
			  else if(pv == 2) p.setMaxHealth(32);
			  else if(pv == 3) p.setMaxHealth(33);
			  else if(pv == 4) p.setMaxHealth(34);
			  else if(pv == 5) p.setMaxHealth(35);
			return true;
		} catch (Exception o) {
			return false;
		}
	}
	
	
	public static boolean SetPermSpeed(Player p, int speed) {

		String uuid = p.getUniqueId().toString();

		try {
			MySQL.createStatement("UPDATE perm SET speed = '" + speed + "' WHERE uuid = '" + uuid + " ';");
			  if(speed == 1) p.setWalkSpeed(0.206F);
			  else if(speed == 2) p.setWalkSpeed(0.21F);
			  else if(speed == 3) p.setWalkSpeed(0.214F);
			  else if(speed == 4) p.setWalkSpeed(0.218F);
			  else if(speed == 5) p.setWalkSpeed(0.222F);
			return true;
		} catch (Exception o) {
			return false;
		}
	}
	
	
	public static Date GetGrade(Player p) {

		//String uuid = p.getUniqueId().toString();

		ResultSet rs = MySQL.querySQL("SELECT * FROM memberships WHERE display_name = '"
				+ p.getName() + "';");

		try {
			while (rs.next()) {
				Date expiration = rs.getDate("expiration");
				return expiration;
			}
		} catch (SQLException e) {
			System.out.println("MySQL-Error: " + e.getMessage());
		}
		return null;
	}
	
	
}
