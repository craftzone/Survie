package info.mgone.survie.skill;


import info.mgone.survie.MySQL;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class Skill {
	
	public static boolean HaveSkill(Player p) {
   	    ResultSet rs = MySQL.querySQL("SELECT * FROM skills WHERE uuid = '" + p.getUniqueId().toString() + "';");
   	    try {
   	      if (rs.next()) {
   	        return true;
   	      }
   	    } catch (SQLException e) {
   	      System.out.println("MySQL-Error: " + e.getMessage());
   	    }
   	    return false;
   	  }
	
	public static boolean HaveSkillOffline(OfflinePlayer p) {
   	    ResultSet rs = MySQL.querySQL("SELECT * FROM skills WHERE uuid = '" + p.getUniqueId().toString() + "';");
   	    try {
   	      if (rs.next()) {
   	        return true;
   	      }
   	    } catch (SQLException e) {
   	      System.out.println("MySQL-Error: " + e.getMessage());
   	    }
   	    return false;
   	  }
	
	
	
	public static Integer getSkill(Player p) {
		
		  String uuid = p.getUniqueId().toString();
		
		ResultSet rs = MySQL.querySQL("SELECT * FROM skills WHERE uuid = '" + uuid + "';");
		
		try {
		      while (rs.next()) {
				  int skill = rs.getInt("skill");
				  return skill;
		      }
		    } catch (SQLException e) {
		      System.out.println("MySQL-Error: " + e.getMessage());
		    }
		
		
		return 0;
	}
	
	
	public static Integer getSkillOffline(OfflinePlayer p) {

       String uuid = p.getUniqueId().toString();
		
		ResultSet rs = MySQL.querySQL("SELECT * FROM skills WHERE uuid = '" + uuid + "';");
		
		try {
		      while (rs.next()) {
				  int skill = rs.getInt("skill");
				  return skill;
		      }
		    } catch (SQLException e) {
		      System.out.println("MySQL-Error: " + e.getMessage());
		    }
		
		
		return 0;
		
	}

	
	
         public static void addSkill(Player p, Integer i) {
		
		String uuid = p.getUniqueId().toString();
		ResultSet rs = MySQL.querySQL("SELECT * FROM skills WHERE uuid = '" + uuid + "';");
		
		
		try {
		      while (rs.next()) {
				  int skill = rs.getInt("skill");
				  
				  MySQL.createStatement("UPDATE skills SET skill = '" + (skill+i) + "' WHERE uuid = '" + uuid + " ';");	  
				  
		      }
		    } catch (SQLException e) {
		      System.out.println("MySQL-Error: " + e.getMessage());
		    }
		
		
	     }
         
         
         public static void addSkillOffline(OfflinePlayer p, Integer i) {
        	 
        	 String uuid = p.getUniqueId().toString();
     		ResultSet rs = MySQL.querySQL("SELECT * FROM skills WHERE uuid = '" + uuid + "';");
     		
     		
     		try {
     		      while (rs.next()) {
     				  int skill = rs.getInt("skill");
     				  
     				  MySQL.createStatement("UPDATE skills SET skill = '" + (skill+i) + "' WHERE uuid = '" + uuid + " ';");	  
     				  
     		      }
     		    } catch (SQLException e) {
     		      System.out.println("MySQL-Error: " + e.getMessage());
     		    }
     		
     		
     	     }

               
         
         public static void takeSkill(Player p, Integer i) {
        		
        		String uuid = p.getUniqueId().toString();
        		ResultSet rs = MySQL.querySQL("SELECT * FROM skills WHERE uuid = '" + uuid + "';");
        		
        		
        		try {
        		      while (rs.next()) {
        				  int skill = rs.getInt("skill");
        				  
        				if(skill >= i)  MySQL.createStatement("UPDATE skills SET skill = '" + (skill-i) + "' WHERE uuid = '" + uuid + " ';");	  
        				  
        		      }
        		    } catch (SQLException e) {
        		      System.out.println("MySQL-Error: " + e.getMessage());
        	        }
         }
         
         
         
         public static void takeSkillOffline(OfflinePlayer p, Integer i) {
        	 
        	 
        	 String uuid = p.getUniqueId().toString();
     		 ResultSet rs = MySQL.querySQL("SELECT * FROM skills WHERE uuid = '" + uuid + "';");
     		
     		
     		try {
     		      while (rs.next()) {
     				  int skill = rs.getInt("skill");
     				  
     				if(skill >= i)  MySQL.createStatement("UPDATE skills SET skill = '" + (skill-i) + "' WHERE uuid = '" + uuid + " ';");	  
     				  
     		      }
     		    } catch (SQLException e) {
     		      System.out.println("MySQL-Error: " + e.getMessage());
     	        }

         }
         
         
         public static void setSkill(Player p, Integer i) {
     		
     		String uuid = p.getUniqueId().toString();
     		MySQL.createStatement("UPDATE skills SET skill = '" + i + "' WHERE uuid = '" + uuid + " ';");
     		
     	     }
         
         public static void setSkillOffline(OfflinePlayer p, Integer i) {
      		
      		String uuid = p.getUniqueId().toString();
      		MySQL.createStatement("UPDATE skills SET skill = '" + i + "' WHERE uuid = '" + uuid + " ';");
      		
      	     }
         
         
         
         
         public static void resetSkill(Player p) {
     		
     		String uuid = p.getUniqueId().toString();
     		ResultSet rs = MySQL.querySQL("SELECT * FROM skills WHERE uuid = '" + uuid + "';");
     		
     		try {
     		      while (rs.next()) {
     				  int skill = 0;
     				  
     				  MySQL.createStatement("UPDATE skills SET skill = '" + skill + "' WHERE uuid = '" + uuid + " ';");	  
     				  
     		      }
     		    } catch (SQLException e) {
     		      System.out.println("MySQL-Error: " + e.getMessage());
     		    }

     	}
         
         
         public static void resetSkillOffline(OfflinePlayer p) {
        	 
        	 String uuid = p.getUniqueId().toString();
      		ResultSet rs = MySQL.querySQL("SELECT * FROM skills WHERE uuid = '" + uuid + "';");
      		
      		try {
      		      while (rs.next()) {
      				  int skill = 0;
      				  
      				  MySQL.createStatement("UPDATE skills SET skill = '" + skill + "' WHERE uuid = '" + uuid + " ';");	  
      				  
      		      }
      		    } catch (SQLException e) {
      		      System.out.println("MySQL-Error: " + e.getMessage());
      		    }
        	 
         }

}
