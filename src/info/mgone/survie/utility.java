package info.mgone.survie;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;

import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.EnumTitleAction;
import net.minecraft.server.v1_8_R1.IChatBaseComponent;
import net.minecraft.server.v1_8_R1.PacketPlayOutChat;
import net.minecraft.server.v1_8_R1.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R1.PlayerConnection;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class utility {
	
	
	 public static boolean McVersion(Player p) {
		/*	CraftPlayer p1 = (CraftPlayer) p;
			if (p1.getHandle().playerConnection.networkManager.getVersion() >= 47) return true;
			else return false; */
		 return true;
		}
	
	    
	    
	    
	    public static void logToFile(String message)
	    
	    { 
	    	
	    	DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT);
			Date mnt = new Date();

	        try
	        {
	            File dataFolder = Survie.plugin.getDataFolder();
	            if(!dataFolder.exists())
	            {
	                dataFolder.mkdir();
	            }

	            File saveTo = new File(Survie.plugin.getDataFolder(), "log.txt");
	            if (!saveTo.exists())
	            {
	                saveTo.createNewFile();
	            }


	            FileWriter fw = new FileWriter(saveTo, true);

	            PrintWriter pw = new PrintWriter(fw);

	            pw.println("[" + shortDateFormat.format(mnt) + "] " + message);

	            pw.flush();

	            pw.close();

	        } catch (IOException e)
	        {

	            e.printStackTrace();

	        }

	    }
	    
	
	
	
	
	    public static void sendActionBar(Player p, String msg){
		        //only 1.8 clients
		        IChatBaseComponent cbc = ChatSerializer.a("{\"text\": \""+msg+"\"}");
		        PacketPlayOutChat ppoc = new PacketPlayOutChat(cbc,(byte) 2);
		        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(ppoc);
		}
	    
	
	    public static void sendActionBar(final Player p, String msg, int timer){
		        IChatBaseComponent cbc = ChatSerializer.a("{\"text\": \""+msg+"\"}");
		        final PacketPlayOutChat ppoc = new PacketPlayOutChat(cbc,(byte) 2);
		        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(ppoc);
		        
		        
		        
		        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Survie.plugin, new Runnable()
		        {
		          public void run()
		          {
		        	  ((CraftPlayer) p).getHandle().playerConnection.sendPacket(ppoc);
		        	  
		          }
		          }, 1*20);
		        
		        
		        for(int i=2; i <= timer; i=i+2) {
		        
		        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Survie.plugin, new Runnable()
		        {
		          public void run()
		          {
		        	  ((CraftPlayer) p).getHandle().playerConnection.sendPacket(ppoc);
		        	  
		          }
		          }, i*20);
		        
		        }

		}
	    

 public static void sendTitle(Player player ,String title , String subtitle, Integer fadeIn, Integer time, Integer fadeOut) {
	    PlayerConnection connection = ((CraftPlayer) player).getHandle().playerConnection;

	    PacketPlayOutTitle packetPlayOutTimes = new PacketPlayOutTitle(EnumTitleAction.TIMES, null, fadeIn, time, fadeOut);
	    connection.sendPacket(packetPlayOutTimes);

	    if (subtitle != null) {
	    	subtitle = ChatColor.translateAlternateColorCodes('&', subtitle);
	        IChatBaseComponent titleSub = ChatSerializer.a("{\"text\": \"" + subtitle + "\"}");
	        PacketPlayOutTitle packetPlayOutSubTitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, titleSub);
	        connection.sendPacket(packetPlayOutSubTitle);
	    }

	    if (title != null) {
	    	title = ChatColor.translateAlternateColorCodes('&', title);
	        IChatBaseComponent titleMain = ChatSerializer.a("{\"text\": \"" + title + "\"}");
	        PacketPlayOutTitle packetPlayOutTitle = new PacketPlayOutTitle(EnumTitleAction.TITLE, titleMain);
	        connection.sendPacket(packetPlayOutTitle);
	    }
	}
 
 
 


	public static void TransLog(String message)

	{

		DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
				DateFormat.SHORT, DateFormat.SHORT);
		Date mnt = new Date();

		try {
			File dataFolder = Survie.plugin.getDataFolder();
			if (!dataFolder.exists()) {
				dataFolder.mkdir();
			}

			File saveTo = new File(Survie.plugin.getDataFolder(), "translog.txt");
			if (!saveTo.exists()) {
				saveTo.createNewFile();
			}

			FileWriter fw = new FileWriter(saveTo, true);

			PrintWriter pw = new PrintWriter(fw);

			pw.println("[" + shortDateFormat.format(mnt) + "] " + message);

			pw.flush();

			pw.close();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}


	
	   public static void ForceUpdate(String NewName, String OldName) {
		   
			  //clan
			  MySQL.createStatement("UPDATE sc_players SET name = '" + NewName + "' WHERE name = '" + OldName + " ';");
			  MySQL.createStatement("UPDATE sc_kills SET attacker = '" + NewName + "' WHERE attacker = '" + OldName + " ';");
			  MySQL.createStatement("UPDATE sc_kills SET victim = '" + NewName + "' WHERE victim = '" + OldName + " ';");
			  //HDV
			  MySQL.createStatement("UPDATE history SET player = '" + NewName + "' WHERE player = '" + OldName + " ';");
			  MySQL.createStatement("UPDATE history SET who = '" + NewName + "' WHERE who = '" + OldName + " ';");
			  MySQL.createStatement("UPDATE listings SET seller = '" + NewName + "' WHERE seller = '" + OldName + " ';");
			  MySQL.createStatement("UPDATE mail SET owner = '" + NewName + "' WHERE owner = '" + OldName + " ';");
			  MySQL.createStatement("UPDATE mail SET sender = '" + NewName + "' WHERE sender = '" + OldName + " ';");
			  MySQL.createStatement("UPDATE users SET name = '" + NewName + "' WHERE name = '" + OldName + " ';");
		 }
	 


}
