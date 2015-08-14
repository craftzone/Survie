package info.mgone.survie;

import info.mgone.survie.noob.NoobPvP;

import java.util.ArrayList;
import java.util.List;

import me.ryanhamshire.GriefPrevention.GriefPrevention;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.DefaultFlag;
import com.sk89q.worldguard.protection.managers.RegionManager;

public class TntPistol implements org.bukkit.event.Listener {
	
	ArrayList<String> PistolOnCoolDown = new ArrayList<String>();
	static List<String> lores = new ArrayList<String>();
	

	@EventHandler
	  public void onPlayerInteractEvent(PlayerInteractEvent event) {
	    Player player = event.getPlayer();
	    String pname = player.getName();
	    
	    if(event.getAction().equals(Action.RIGHT_CLICK_AIR) && event.getMaterial().equals(Material.IRON_BARDING)) {
	    
	    ItemStack itemStack = event.getItem();
	    ItemMeta meta = itemStack.getItemMeta();
	    if(!meta.hasLore()) return;
	    
	    if(NoobPvP.IsNoobNow(player)) {
	    	player.sendMessage("§cVous avez une PVP-protection pour les nouveaux.\n"+
	        "§6Vous n'avez la permission d'utiliser le TNTGun!\n"+
	    	"§aPour plus de détails tapez §b/pvp");
	    	return;
	    }
	    
	    RegionManager regionManager = Survie.getWorldGuard().getRegionManager(player.getLocation().getWorld());
	    ApplicableRegionSet set = regionManager.getApplicableRegions(player.getLocation());
	    
	    if(!set.allows(DefaultFlag.PVP) || !set.allows(DefaultFlag.SLEEP)) { player.sendMessage("§cVous n'avez la permission d'utiliser le TNTGun ici!"); return; }
	    
	    String noBuildReason = GriefPrevention.instance.allowBuild(player, player.getLocation(), Material.ARMOR_STAND); 
	    if(noBuildReason != null) { player.sendMessage("§cVous n'avez la permission d'utiliser le TNTGun depuis l'intérieur des claims!"); return; }
	    
	    List<String> loretlist = meta.getLore();
	    String usage = loretlist.get(0);
	    String[] nbtab = usage.split(": §2");
	    int nb = Integer.valueOf(nbtab[1]);
	    
	    if (PistolOnCoolDown.contains(pname)) { utility.sendActionBar(player,"§5§l\u2622 Le rechargement du TNTGun est de 5 secondes... \u2622"); return;   } 
	    
	    
	    ItemStack item = new ItemStack(Material.TNT, 1);
	    
	    if(player.getInventory().contains(Material.TNT)){
	    	TNTPrimed tnt = (TNTPrimed)player.getWorld().spawn(player.getEyeLocation(), TNTPrimed.class);
	    	tnt.setVelocity(player.getEyeLocation().getDirection().multiply(2));
	    	tnt.setFuseTicks(40);
	    	player.getInventory().removeItem(item);
	    	player.updateInventory();
	    	nb--;
	    	if(nb <= 0) {
	    		player.playSound(player.getLocation(),Sound.ANVIL_BREAK, 30.0F, 10.0F);
	    		player.setItemInHand(null);
	    	} else {
	    		lores.add("§bUtilisations: §2" + nb);
	    		meta.setLore(lores);
	    		player.getItemInHand().setItemMeta(meta);
	    		lores.clear();
	    	}
	    	
	    	PistolOnCoolDown.add(pname);
	    	XpLoad(player);
	    } else player.sendMessage("§cVous n'avez pas de TNT!");
	    

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
	    	  PistolOnCoolDown.remove(pname);
	      }
	    }, 5 * 20L);
		
	} 

}
