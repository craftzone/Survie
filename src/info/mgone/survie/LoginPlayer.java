package info.mgone.survie;


import info.mgone.survie.antixray.BreakListener;
import info.mgone.survie.instructeur.Perm;
import info.mgone.survie.noob.NoobPvP;
import info.mgone.survie.skill.Skill;
import info.mgone.survie.stats.Ipcheck;
import info.mgone.survie.stats.Stats;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import me.dpohvar.powernbt.api.NBTCompound;
import me.dpohvar.powernbt.api.NBTList;
import me.dpohvar.powernbt.api.NBTManager;
import net.minecraft.server.v1_8_R1.AttributeInstance;
import net.minecraft.server.v1_8_R1.EntityPlayer;
import net.minecraft.server.v1_8_R1.GenericAttributes;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class LoginPlayer implements Listener {
	
	public static HashMap<String, Integer> skills = new HashMap<String, Integer>();
	public static HashMap<String, Double> timep = new HashMap<String, Double>();
	public static HashMap<String, Double> noob = new HashMap<String, Double>();
	public static HashMap<String, Integer> ki = new HashMap<String, Integer>();
	boolean HaveSkill;
	static int j = 0;
	NBTManager manager = NBTManager.getInstance();

	@EventHandler(priority=EventPriority.MONITOR)
	  public void onJoin(PlayerJoinEvent event)
	  {
		
		
		final Player p = event.getPlayer();
		final String pname = p.getName(); 
		String uuid = p.getUniqueId().toString();
		p.resetMaxHealth();
		p.setMaxHealth(30);
		p.setWalkSpeed(0.2F);
		int skill = 10;
		
		try {
			if(Skill.HaveSkill(p)) HaveSkill = true; else HaveSkill = false;
		} catch(Exception o) {
			p.kickPlayer("§4§lUne erreur s'est produite. Patientez 5 secondes et réessayez!");
			utility.logToFile("Erreur: LoginPlayer,onJoin,Con null,"+pname);
			return;
		}
		
		if(Ipcheck.CheckIP(p)) return;
		
		if(!p.hasPlayedBefore()) {
			
		   if(HaveSkill == false) {	MySQL.createStatement("INSERT INTO skills (player, uuid, skill) VALUES ('" + pname + "', '" + uuid + "', '" + skill + "')");
		   skills.put(pname, 10); } else skills.put(pname, Skill.getSkill(p));
		
		   if(!Stats.HaveStats(p)) { Stats.NewStats(p);  timep.put(pname,(double) 0); }
		   else { timep.put(pname,(double) 0); }
		   
		   if(!NoobPvP.IsNoob(p)) { NoobPvP.NewNoob(p); noob.put(pname, (double) 0); }
		   
		   if(!Perm.HavePerm(p)) Perm.AddNewPerm(p);
		   
		   BreakListener.playerlogin(p);
		
		} 
		else {
			if(HaveSkill == false) { p.kickPlayer("§4§lUne erreur s'est produite. Veuillez contacter un administrateur pour résoudre votre soucis!"); return;}
			skills.put(pname, Skill.getSkill(p));
			timep.put(pname,(double) 0);
			double timeplayed = Stats.GetUpstatsJoin(p);
			if(timeplayed < 3600) { if(NoobPvP.IsNoob(p)) noob.put(pname, timeplayed); }
			Perm.SetPerm(p);
			
			
			

			BreakListener.playerlogin(p);
			

			
			EntityPlayer ph = ((CraftPlayer) p).getHandle();
			AttributeInstance attdamage = ph.getAttributeInstance(GenericAttributes.e);
			if(attdamage.getValue() != 1) {
				
				utility.logToFile("BUG ATTRIBUTE: "+ pname + " ," + attdamage.getValue());
				
				 
				NBTCompound playerdata = manager.read(p);
				NBTList atkey = playerdata.getList("Attributes");
				if(atkey != null) {
					 for(Object subnbt : atkey) {
						  NBTCompound sub = (NBTCompound) subnbt;
						  
						 if (sub.containsKey("Modifiers")){
							 
							 NBTList atmodifer = sub.getList("Modifiers");
							 
							 for(Object sub2 : atmodifer) {
								 NBTCompound sub22 = (NBTCompound) sub2;
								 sub22.put("Amount", (float)0);
							 }

						 }
						 
						 
				    }
					 
					manager.write(p, playerdata); }
			}
			
			
			
			UpdateClan(p);
			
			
		}
		

		
		/*for (String string : playerMOTD()) {
		    sendRawMsg(p, string);
		  } */
		
		utility.sendTitle(p, "§dCRAFT§6ZONE §c§lSURVIE", "§c\u2764 §5Bienvenue §6" + pname + " §c\u2764", 10, 120, 10);
		ki.put(pname, 0);
		
		new BukkitRunnable() {
			public void run() {
			String text ="Regarder la video tuto pour bien débuter";
			switch (j) {
			case 0:text= "§5 ✖ §d§l" + text + " §5✖"; j++;break;
			case 1:text= "§" + "e ✔ §6§l" + text + " §" + "e✔"; j++;break;
			case 2:text= "§2 ✖ §a§l" + text + " §2✖"; j++;break;
			case 3:text= "§4 ✔ §c§l" + text + " §4✔"; j++;break;
			case 4:text= "§3 ✖ §b§l" + text + " §3✖"; j++;break;
			case 5:text= "§1 ✔ §9§l" + text + " §1✔"; j=0;break;
			}
			if(!p.isOnline()) { cancel(); return;}
			if(!ki.containsKey(pname)) { cancel(); return;}
			utility.sendActionBar(p,text);
			ki.put(pname,ki.get(pname)+1);
			if(ki.get(pname)==120)
			{ ki.remove(pname); j=0;
			try {
				cancel();
				
			} catch (Throwable e) {
				e.printStackTrace(); ki.remove(pname); cancel(); 
			}
			
			}
			
			
			}
		}.runTaskTimer(Survie.plugin, 120L, 3L);
		
		
	  }
	
	

	

	
	@EventHandler
	  public void onleave(PlayerQuitEvent event)
	  {
		Player p = event.getPlayer();
		String pname = p.getName();
		if(skills.containsKey(pname)){
		int skillp = skills.get(pname);
		Skill.setSkill(p, skillp);
		skills.remove(pname);}
		if(timep.containsKey(pname)) {
		Stats.UpstatsLogout(p, timep.get(pname));
		timep.remove(pname); }
		if(noob.containsKey(pname)) noob.remove(pname);
		ki.remove(pname);
		BreakListener.SavePlayerStats(p);
		BreakListener.RemovePlayerStats(pname);
	  }
	
	@EventHandler
	  public void onkick(PlayerKickEvent event)
	  {
		Player p = event.getPlayer();
		String pname = p.getName();
		if(!skills.containsKey(pname)){
			if(!p.hasPlayedBefore()) {
		String file = "world/playerdata/" + p.getUniqueId() + ".dat";
		String file1 = "world/stats/" + p.getUniqueId() + ".json";
		String file2 = "plugins/Essentials/userdata/" + p.getUniqueId() + ".yml";
		final File f = new File(file);
		final File f1 = new File(file1);
		final File f2 = new File(file2);
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Survie.plugin, new Runnable() {
		      public void run() {
		f.delete(); f1.delete(); f2.delete();
		                  }
	                      }, 5L);
		}
		}
	  }
	
	
	
	
	public static List<String> playerMOTD() {
	    List<String> chatbypass = getmessagesList("Server.PlayerMotd");
	    return chatbypass;
	  }

	public static List<String> getmessagesList(String path)
	{
	  return Survie.plugin.getConfig().getStringList(path);
	}

	public static void sendRawMsg(Player p, String msg) {
	    p.sendMessage(color(replaceUnicode(msg)));
	  }

	public static String replaceUnicode(String string) {
	    return 
	      string.replace("<3", "\u2764").replace("[*]", "\u2605").replace("[**]", "\u2739").replace("[p]", "\u25CF").replace("[v]", "\u2714").replace("[+]", "\u25C6").replace("[++]", "\u2726").replace("[/]", "\u2588").replace("[cross]", "\u2720").replace("[arrow_right]", "\u27A1").replace("[arrow_down]", "\u2B07").replace("[arrow_left]", "\u2B05").replace("[small_line_up]", "\u258F").replace("%enabled%", "ENABLED").replace("%disabled%", "DISABLED");
	  }

	public static String color(String msg)
	{
	  return msg.replaceAll("(&([a-fk-or0-9]))", "\u00A7$2");
	}
	
	
	
	
	
	@EventHandler
	  public void pkick(PlayerKickEvent e)
	  {
		 Player p = e.getPlayer();
		 
		 if(p.isInsideVehicle()) return ; 
		 
		 if(e.getReason().equalsIgnoreCase("Flying is not enabled on this server")) {
			 Survie.cheateurkickforfly.put(p.getName(),p.getLocation());
			 double pX = p.getLocation().getBlockX();
			 double pY = p.getLocation().getBlockY();
			 double pZ = p.getLocation().getBlockZ();
			 utility.logToFile("KickFly: " + p.getName() + " Loc: " + pX + "," + pY + "," + pZ);
			 
			 for (Player pe : Bukkit.getOnlinePlayers()) {
		        	if(pe.hasPermission("warn.cheat")) { 
		        		pe.sendMessage("§4§lSuspect de cheat: " + "§6" + p.getName() + " §fkick pour Flying is not enabled on this server");
		        		pe.playSound(pe.getLocation(), Sound.GHAST_SCREAM, 30.0F, 10.0F);}
		        	}
			 
			 
		 }
		 
		 
	  }
	
	
	
	
	   public static void UpdateClan(Player p) {
			
		    String pname = p.getName();
			String uuid = p.getUniqueId().toString();
			
			ResultSet rs = MySQL.querySQL("SELECT * FROM sc_players WHERE uuid = '" + uuid + "';");
			 try {
			      while (rs.next()) {
			    	  String pname1 = rs.getString("name"); 
					  
					  if (!pname.equals(pname1)) {
						  MySQL.createStatement("UPDATE sc_players SET name = '" + pname + "' WHERE uuid = '" + uuid + " ';");
						  
					  p.sendMessage("§b§lVous avez changé votre pseudo, mise-à-jour de vos données pour résoudre le soucis de Team...");
					  
					  
					  }
					  
					  
			      }
			    } catch (SQLException e) {
			      System.out.println("MySQL-Error: " + e.getMessage());
			    } 
		 }
	
	
	
	

}
