package info.mgone.survie.noob;

import info.mgone.survie.LoginPlayer;
import info.mgone.survie.MySQL;
import info.mgone.survie.Survie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.DefaultFlag;
import com.sk89q.worldguard.protection.managers.RegionManager;

public class NoobPvP implements Listener {
	
	
	@EventHandler(priority=EventPriority.LOW, ignoreCancelled=true)
	  public void onEntityDamage(EntityDamageEvent event)
	  {
		if ((event.getEntityType() != EntityType.PLAYER) || (!(event instanceof EntityDamageByEntityEvent))) return;
		EntityDamageByEntityEvent dmgev = (EntityDamageByEntityEvent)event;
		if (dmgev.getDamager().getType() != EntityType.PLAYER) return;
		Player p1 = (Player)event.getEntity();
	    Player p2 = (Player)dmgev.getDamager();
	    
	    RegionManager regionManager = Survie.getWorldGuard().getRegionManager(p1.getLocation().getWorld());
	    ApplicableRegionSet set = regionManager.getApplicableRegions(p1.getLocation());
	    RegionManager regionManager2 = Survie.getWorldGuard().getRegionManager(p2.getLocation().getWorld());
	    ApplicableRegionSet set2 = regionManager2.getApplicableRegions(p2.getLocation());
	    
	    
	    if(!set.allows(DefaultFlag.PVP) || !set2.allows(DefaultFlag.PVP)) { event.setCancelled(true); return; }
	    
	    if (IsNoobNow(p1) || IsNoobNow(p2)) {
	        event.setCancelled(true);
	        informFailedAttack(p2, p1);
	      }
		
	  }
	
	

	@EventHandler(priority=EventPriority.LOW, ignoreCancelled=true)
	  public void onProjectileDamage(EntityDamageEvent event) {
		 
	    if (event.getEntityType() != EntityType.PLAYER) return;
	    if (!(event instanceof EntityDamageByEntityEvent)) return;
	    
	    
	    EntityDamageByEntityEvent evdm = (EntityDamageByEntityEvent)event;
	    if (!(evdm.getDamager() instanceof Projectile)) return;
	    Projectile prj = (Projectile)evdm.getDamager();
	    if ((prj.getShooter() == null) || (!(prj.getShooter() instanceof Player))) return;
	    Player p1 = (Player)event.getEntity();
	    Player p2 = (Player)prj.getShooter();
	    
	    RegionManager regionManager = Survie.getWorldGuard().getRegionManager(p1.getLocation().getWorld());
	    ApplicableRegionSet set = regionManager.getApplicableRegions(p1.getLocation());
	    RegionManager regionManager2 = Survie.getWorldGuard().getRegionManager(p2.getLocation().getWorld());
	    ApplicableRegionSet set2 = regionManager2.getApplicableRegions(p2.getLocation());
	    
	    
	    if(!set.allows(DefaultFlag.PVP) || !set2.allows(DefaultFlag.PVP)) { event.setCancelled(true); return; }
	    
	    
	    if (IsNoobNow(p1) || IsNoobNow(p2)) {
	      event.setCancelled(true);
	    }
	    
	  }
	 
	 @org.bukkit.event.EventHandler
	  public void pmovevent(PlayerMoveEvent event)
	  {
		 Player p = event.getPlayer();
		 
		 if(!IsNoobNow(p)) return;
		 
		 if (event.getFrom().getBlockX() != event.getTo().getBlockX() ||
	                event.getFrom().getBlockY() != event.getTo().getBlockY() ||
	                event.getFrom().getBlockZ() != event.getTo().getBlockZ()) {
		 
		 RegionManager regionManager = Survie.getWorldGuard().getRegionManager(p.getLocation().getWorld());
		 ApplicableRegionSet set = regionManager.getApplicableRegions(p.getLocation());
		  if(!set.allows(DefaultFlag.SLEEP)) {
			  Location loc = new Location(Bukkit.getWorld("world"), 43, 86, -45, 270, 0);
			  p.teleport(loc);
			  p.sendMessage("§cVous avez une PVP-protection pour les nouveaux.\n"+
						"§fVous n'avez pas la permissions d'aller dans l'arène!\n"+
						"§aPour plus de détails tapez §b/pvp");
		  }
		  
		 }
		 
	  }
	 
	
	
	
	public void informFailedAttack(Player atacker, Player defender)
	  {
		if(IsNoobNow(atacker)) { atacker.sendMessage("§cVous avez une PVP-protection pour les nouveaux.\n"+
		 "§aPour plus de détails tapez §b/pvp");
		  atacker.damage(1);
		} else {
			atacker.sendMessage("§6" + defender.getName() + " §aa une PVP-protection pour les nouveaux!");
			atacker.damage(1);
		}
		
		if(IsNoobNow(defender)){ defender.sendMessage("§cVous avez une PVP-protection pour les nouveaux.\n"+
		"§6" + atacker.getName() + " §fessaye de vous frapper!\n"+
		"§aPour plus de détails tapez §b/pvp");
		} else {
			defender.sendMessage("§6" + atacker.getName() + " §aa une PVP-protection pour les nouveaux!\n"+
			"§fet essaye de vous frapper!");
		}
	  }
	
	
	public static boolean IsNoobNow(Player p) {
		
		String pname = p.getName();
		if(LoginPlayer.noob.containsKey(pname)) return true;
		return false;
	}
	
	
	public static boolean IsNoob(Player p) {
   	    ResultSet rs = MySQL.querySQL("SELECT * FROM noobprotect WHERE uuid = '" + p.getUniqueId().toString() + "';");
   	    try {
   	      if (rs.next()) {
   	        return true;
   	      }
   	    } catch (SQLException e) {
   	      System.out.println("MySQL-Error: " + e.getMessage());
   	    }
   	    return false;
   	  }
	

public static void NewNoob(Player p) {
		
		String pname = p.getName(); 
		String uuid = p.getUniqueId().toString();
		MySQL.createStatement("INSERT INTO noobprotect (player, uuid)"
				+ " VALUES ('" + pname + "', '" + uuid + "')");
		
	}

  public static void RemoveNoob(Player p) {
	
	String uuid = p.getUniqueId().toString();
	MySQL.createStatement("DELETE FROM noobprotect WHERE uuid = '" + uuid + "';");
	
  }
  
  public static void NoobTask() {
 	 
 	 Bukkit.getScheduler().scheduleSyncRepeatingTask(Survie.getPluginInstance(),
					new Runnable() {
						public void run() {
							for (Player pe : Bukkit.getOnlinePlayers()) {
								
								String pename = pe.getName();
								
								if(LoginPlayer.noob.containsKey(pename)){
									double tempr = 3600 - LoginPlayer.noob.get(pename);
									pe.sendMessage("§4Votre PVP-protection expire dans §6" + calculateTimeNoob(tempr) + "\n" +
									"§aPour plus de détails tapez §b/pvp");
									pe.playSound(pe.getLocation(), Sound.ORB_PICKUP, 30.0F, 10.0F);	
								}
								
  
							}
						}
      }, 3 *20, 300 * 20);
  }
  
  
  public static void DecompteNoob(Player p){
	  
	  String pname = p.getName();

	  if(LoginPlayer.noob.containsKey(pname)){
			double timeplayed = LoginPlayer.noob.get(pname);
			if(timeplayed <3600) LoginPlayer.noob.put(pname, timeplayed+30);
			else { 
				LoginPlayer.noob.remove(pname); RemoveNoob(p); 
				p.sendMessage("§c§lAttention: §aVotre PVP-protection a expiré, Bonne chance!");
				p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 30.0F, 10.0F);	
				}
		}
	  
  }
  
  
  public static void CommandNoob(Player p){
	  
	  String pname = p.getName();
	  
	  if(LoginPlayer.noob.containsKey(pname)){ 
		  double tempr = 3600 - LoginPlayer.noob.get(pname);
		  p.sendMessage("§f========================================\n" +
		   "§4Votre PVP-protection expire dans §6" + calculateTimeNoob(tempr) + "\n" +
		  "§aPour désactiver cette protection tapez §b/pvpon\n" +
		  "§c§lAttention: §6Cette action est irréversible!\n" +
		  "§f========================================");
		  
	  } else p.sendMessage("§cVous n'avez plus de PVP-protection!");
	  
  }
  
  
   public static void CommandPVPon(Player p){
	   
	   String pname = p.getName();
	  
	  if(LoginPlayer.noob.containsKey(pname)){ 
		  RemoveNoob(p);
		  LoginPlayer.noob.remove(pname);
		  p.sendMessage("§aVotre PVP-protection a été désactivé, Bonne chance!");
	  } else p.sendMessage("§cPVP-protection déja désactivé!");
	  
   }
  
  
  
  public static String calculateTimeNoob(double secondss) {
	  
	  long seconds = Math.round(secondss);
	  //int day = (int)TimeUnit.SECONDS.toDays(seconds);        
	  //long hours = TimeUnit.SECONDS.toHours(seconds);
	  long minute = TimeUnit.SECONDS.toMinutes(seconds) - (TimeUnit.SECONDS.toHours(seconds)* 60);
	  //long second = TimeUnit.SECONDS.toSeconds(seconds) - (TimeUnit.SECONDS.toMinutes(seconds) *60);

      String restant =  minute + " minutes ";
      
      return restant;

  }
  
  
}
