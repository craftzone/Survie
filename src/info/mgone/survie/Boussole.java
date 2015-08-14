package info.mgone.survie;

import java.util.ArrayList;
import java.util.List;

import info.mgone.survie.noob.NoobPvP;
import net.sacredlabyrinth.phaed.simpleclans.Clan;
import net.sacredlabyrinth.phaed.simpleclans.ClanPlayer;
import net.sacredlabyrinth.phaed.simpleclans.SimpleClans;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.DefaultFlag;
import com.sk89q.worldguard.protection.managers.RegionManager;

public class Boussole implements Listener {
	
	ArrayList<String> CompassOnCoolDown = new ArrayList<String>();
	static List<String> lores = new ArrayList<String>();
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent ev) {
		if ((ev.getAction() == Action.RIGHT_CLICK_AIR || ev.getAction() == Action.RIGHT_CLICK_BLOCK) && ev.getPlayer().getItemInHand().getType() == Material.COMPASS) {
			
			Player pl = ev.getPlayer();
			String pname = pl.getName();
			
			ItemStack itemStack = ev.getItem();
		    ItemMeta meta = itemStack.getItemMeta();
		    if(!meta.hasLore()) return;
		    

		    if(!pl.getWorld().getName().equals("world")) {
		    	pl.sendMessage("§cla boussole ne fonctionne que dans le monde PVP!");
		    	return; 
		    }
			
			if(NoobPvP.IsNoobNow(pl)) {
		    	pl.sendMessage("§cVous avez une PVP-protection pour les nouveaux.\n"+
		        "§6Vous n'avez la permission d'utiliser la boussole!\n"+
		    	"§aPour plus de détails tapez §b/pvp");
		    	return;
		    }
			
			
			RegionManager regionManager0 = Survie.getWorldGuard().getRegionManager(pl.getLocation().getWorld());
		    ApplicableRegionSet set0 = regionManager0.getApplicableRegions(pl.getLocation());
		    if(!set0.allows(DefaultFlag.PVP) || !set0.allows(DefaultFlag.SLEEP)) { pl.sendMessage("§cVous n'avez la permission d'utiliser la boussole ici!"); return; }
		    
		    if (CompassOnCoolDown.contains(pname)) { utility.sendActionBar(pl,"§5§l\u2622 Le rechargement de la boussole est de 5 secondes... \u2622"); return;   } 
		    
		    
		    Player nearest = null;
			Double distance = 100D;
			
			List<String> loretlist = meta.getLore();
		    String dt1 = loretlist.get(0);
		    String[] dt2 = dt1.split(": §d");
		    String dt3 = dt2[1].replace(" Blocks", "").trim();
		    int dt = Integer.valueOf(dt3);
		    distance = (double) dt;
		    
		    if(!pl.hasPermission("boussole.guerrier") && dt >= 800) { pl.sendMessage("§cVous n'avez la permission d'utiliser cette Boussole qu'à partir du grade Guerrier et+!"); return; }
		    if(!pl.hasPermission("boussole.chevalier") && dt >= 1000) { pl.sendMessage("§cVous n'avez la permission d'utiliser cette Boussole qu'à partir du grade Chevalier et+!"); return; }
  
		    String usage = loretlist.get(1);
		    String[] nbtab = usage.split(": §2");
		    int nb = Integer.valueOf(nbtab[1]);
			
			ClanPlayer cp = SimpleClans.getInstance().getClanManager().getClanPlayer(pl);
			
			for (Player pl2 : Survie.plugin.getServer().getOnlinePlayers()) {
				
				if(!pl2.getWorld().getName().equals("world")) continue;
					
					Double calc = pl.getLocation().distance(pl2.getLocation());
					if (calc > 1 && calc < distance) {
						distance = calc;
						if (pl2 != pl && !pl2.isOp()) {
							
							if(NoobPvP.IsNoobNow(pl2)) continue;
							
							RegionManager regionManager = Survie.getWorldGuard().getRegionManager(pl2.getLocation().getWorld());
						    ApplicableRegionSet set = regionManager.getApplicableRegions(pl2.getLocation());
						    
							    if(!set.allows(DefaultFlag.PVP) || !set.allows(DefaultFlag.SLEEP)) continue;
							    
							    
								if(cp == null) { nearest = pl2.getPlayer(); continue;}
								
								ClanPlayer cp2 = SimpleClans.getInstance().getClanManager().getClanPlayer(pl2);
								if(cp2 == null) { nearest = pl2.getPlayer();  continue; }
								
								Clan vcp = cp.getClan();
								Clan vcp2 = cp2.getClan();
								if(vcp.equals(vcp2)) continue; 
								if(cp.isAlly(pl2)) continue; 
								nearest = pl2.getPlayer();
						}
						
						 
					}
				//} catch (Exception e) {}
			}
			
			CompassOnCoolDown.add(pname);
			XpLoad(pl);
			
			if (nearest == null) {
				pl.sendMessage("§cAucun joueur dans les environs de " + dt + " §cBlocks!");
				pl.playSound(pl.getLocation(),Sound.VILLAGER_NO, 30.0F, 10.0F);
				return;
			}
			pl.sendMessage("§aLa boussole pointe sur le joueur le plus proche.");
			pl.sendMessage("§fjoueur: §6" + nearest.getName() + " §f("+   Math.round(pl.getLocation().distance(nearest.getLocation())) +")");
			pl.setCompassTarget(nearest.getLocation());
			pl.playSound(pl.getLocation(),Sound.NOTE_PLING, 30.0F, 10.0F);
			
			nb--;
	    	if(nb <= 0) {
	    		pl.playSound(pl.getLocation(),Sound.ANVIL_BREAK, 30.0F, 10.0F);
	    		pl.setItemInHand(null);
	    	} else {
	    		lores.add(dt1);
	    		lores.add("§bUtilisations: §2" + nb);
	    		meta.setLore(lores);
	    		pl.getItemInHand().setItemMeta(meta);
	    		lores.clear();
	    	}
			
		}
	}
	
	
	
   public void XpLoad(final Player p) {
		
		final String pname = p.getName();
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Survie.plugin, new Runnable()
	    {
	      public void run()
	      {
	    	  utility.sendActionBar(p,"§f§lRechargement : §a\u2588§c\u2588\u2588\u2588\u2588");
	      }
	    }, 1 * 20L);
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Survie.plugin, new Runnable()
	    {
	      public void run()
	      {
	    	  utility.sendActionBar(p,"§f§lRechargement : §a\u2588\u2588§c\u2588\u2588\u2588");
	      }
	    }, 2 * 20L);
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Survie.plugin, new Runnable()
	    {
	      public void run()
	      {
	    	  utility.sendActionBar(p,"§f§lRechargement : §a\u2588\u2588\u2588§c\u2588\u2588");
	      }
	    }, 3 * 20L);
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Survie.plugin, new Runnable()
	    {
	      public void run()
	      {
	    	  utility.sendActionBar(p,"§f§lRechargement : §a\u2588\u2588\u2588\u2588§c\u2588");
	      }
	    }, 4 * 20L);
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Survie.plugin, new Runnable()
	    {
	      public void run()
	      {
	    	  utility.sendActionBar(p,"§f§lRechargement : §a\u2588\u2588\u2588\u2588\u2588");
	    	  p.playSound(p.getLocation(), Sound.NOTE_PLING, 30.0F, 10.0F);
	    	  CompassOnCoolDown.remove(pname);
	      }
	    }, 5 * 20L);
		
	} 

}
