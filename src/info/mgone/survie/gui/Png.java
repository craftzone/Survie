package info.mgone.survie.gui;

import info.mgone.survie.Survie;
import info.mgone.survie.agent.Agent;
import info.mgone.survie.banquier.Banquier;
import info.mgone.survie.gui.armurier.Armurier;
import info.mgone.survie.gui.armurier.job.Recruteur;
import info.mgone.survie.gui.marchant.Marchant;
import info.mgone.survie.hdv.Troqueur;
import info.mgone.survie.instructeur.Instructeur;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Witch;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.DefaultFlag;
import com.sk89q.worldguard.protection.managers.RegionManager;


public class Png implements Listener {
	
	
	
	    	
	    	
	public static void SpawnVillager() {
		
		for(Entity e : Bukkit.getWorld("world").getEntities()){
		    if(e instanceof Villager) {
		    Villager v0 = (Villager) e;
		    if(v0.getCustomName() != null) {
		    	if(v0.getCustomName().equalsIgnoreCase("§7Barbe Noire")) e.remove();
		    	if(v0.getCustomName().equalsIgnoreCase("§7Achille")) e.remove();
		    	if(v0.getCustomName().equalsIgnoreCase("§7Bill Gates")) e.remove();
		        if(v0.getCustomName().equalsIgnoreCase("§7Instructeur")) e.remove();
		        if(v0.getCustomName().equalsIgnoreCase("§7Claims")) e.remove();
		        if(v0.getCustomName().equalsIgnoreCase("§7Coffre privé")) e.remove();
		        if(v0.getCustomName().equalsIgnoreCase("§7Troque/Enchères")) e.remove(); }
		    }
		    
		    if(e instanceof Witch) {
		    	Witch sc0 = (Witch) e;
		    	if(sc0.getCustomName() != null)
			    	if(sc0.getCustomName().equalsIgnoreCase("§7Reine des Neiges")) e.remove();
			    }
		}
		
		
		
	final Location locvmarchant = new Location(Bukkit.getWorld("world"),Survie.getPluginInstance().getConfig().getDouble("LocMarchand.X"),
			Survie.getPluginInstance().getConfig().getDouble("LocMarchand.Y"), Survie.getPluginInstance().getConfig().getDouble("LocMarchand.Z"), 0, 0);	
	final Villager v = (Villager) Bukkit.getWorld("world").spawnEntity(locvmarchant, EntityType.VILLAGER);
	v.setCustomName("§7Barbe Noire");
	v.setCustomNameVisible(true);
	v.setRemoveWhenFarAway(false);
	v.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 90000*20, 7));

	Hologram h1 = HologramsAPI.createHologram(Survie.plugin, v.getLocation().add(0, 2.6, 0));
	h1.appendTextLine("§6§lMarchand");
	
	final Location locvarmurier = new Location(Bukkit.getWorld("world"),Survie.getPluginInstance().getConfig().getDouble("LocArmurier.X"),
			Survie.getPluginInstance().getConfig().getDouble("LocArmurier.Y"), Survie.getPluginInstance().getConfig().getDouble("LocArmurier.Z"), 0, 0);	
	final Villager varm = (Villager) Bukkit.getWorld("world").spawnEntity(locvarmurier, EntityType.VILLAGER);
	varm.setCustomName("§7Achille");
	varm.setCustomNameVisible(true);
	varm.setRemoveWhenFarAway(false);
	varm.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 90000*20, 7));

	Hologram h2 = HologramsAPI.createHologram(Survie.plugin,  varm.getLocation().add(0, 2.6, 0));
	h2.appendTextLine("§c§lArmurier");
	
	
	final Location locvrecru = new Location(Bukkit.getWorld("world"),Survie.getPluginInstance().getConfig().getDouble("LocRecruteur.X"),
			Survie.getPluginInstance().getConfig().getDouble("LocRecruteur.Y"), Survie.getPluginInstance().getConfig().getDouble("LocRecruteur.Z"), 0, 0);	
	final Villager vrecru = (Villager) Bukkit.getWorld("world").spawnEntity(locvrecru, EntityType.VILLAGER);
	vrecru.setCustomName("§7Bill Gates");
	vrecru.setCustomNameVisible(true);
	vrecru.setRemoveWhenFarAway(false);
	vrecru.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 90000*20, 7));
	
	Hologram h3 = HologramsAPI.createHologram(Survie.plugin,  vrecru.getLocation().add(0, 2.6, 0));
	h3.appendTextLine("§d§lRecruteur");
	
	
	final Location locInstructeur = new Location(Bukkit.getWorld("world"),Survie.getPluginInstance().getConfig().getDouble("LocInstructeur.X"),
			Survie.getPluginInstance().getConfig().getDouble("LocInstructeur.Y"), Survie.getPluginInstance().getConfig().getDouble("LocInstructeur.Z"), 0, 0);	
	final Villager vInstructeur = (Villager) Bukkit.getWorld("world").spawnEntity(locInstructeur, EntityType.VILLAGER);
	vInstructeur.setCustomName("§7Instructeur");
	vInstructeur.setCustomNameVisible(true);
	vInstructeur.setRemoveWhenFarAway(false);
	vInstructeur.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 90000*20, 7));

	Hologram h4 = HologramsAPI.createHologram(Survie.plugin,  vInstructeur.getLocation().add(0, 2.6, 0));
	h4.appendTextLine("§a§lInstructeur");
	
	
	final Location locagent = new Location(Bukkit.getWorld("world"),Survie.getPluginInstance().getConfig().getDouble("LocAgent.X"),
			Survie.getPluginInstance().getConfig().getDouble("LocAgent.Y"), Survie.getPluginInstance().getConfig().getDouble("LocAgent.Z"), 0, 0);	
	final Villager vagent = (Villager) Bukkit.getWorld("world").spawnEntity(locagent, EntityType.VILLAGER);
	vagent.setCustomName("§7Claims");
	vagent.setCustomNameVisible(true);
	vagent.setRemoveWhenFarAway(false);
	vagent.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 90000*20, 7));

	Hologram h5 = HologramsAPI.createHologram(Survie.plugin,  vagent.getLocation().add(0, 2.6, 0));
	h5.appendTextLine("§d§lAgent Immobilier");
	
	final Location locbanque = new Location(Bukkit.getWorld("world"),Survie.getPluginInstance().getConfig().getDouble("LocBanque.X"),
			Survie.getPluginInstance().getConfig().getDouble("LocBanque.Y"), Survie.getPluginInstance().getConfig().getDouble("LocBanque.Z"), 0, 0);	
	final Villager vbanque = (Villager) Bukkit.getWorld("world").spawnEntity(locbanque, EntityType.VILLAGER);
	vbanque.setCustomName("§7Coffre privé");
	vbanque.setCustomNameVisible(true);
	vbanque.setRemoveWhenFarAway(false);
	vbanque.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 90000*20, 7));

	Hologram h6 = HologramsAPI.createHologram(Survie.plugin,  vbanque.getLocation().add(0, 2.6, 0));
	h6.appendTextLine("§4§lBanquier");
	
	
	
	final Location loctroque = new Location(Bukkit.getWorld("world"),Survie.getPluginInstance().getConfig().getDouble("LocTroque.X"),
			Survie.getPluginInstance().getConfig().getDouble("LocTroque.Y"), Survie.getPluginInstance().getConfig().getDouble("LocTroque.Z"), 0, 0);	
	final Villager vtroque = (Villager) Bukkit.getWorld("world").spawnEntity(loctroque, EntityType.VILLAGER);
	vtroque.setCustomName("§7Troque/Enchères");
	vtroque.setCustomNameVisible(true);
	vtroque.setRemoveWhenFarAway(false);
	vtroque.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 90000*20, 7));

	Hologram h7 = HologramsAPI.createHologram(Survie.plugin,  vtroque.getLocation().add(0, 2.6, 0));
	h7.appendTextLine("§b§lTroqueur");
	
	
	final Location locSorciere= new Location(Bukkit.getWorld("world"),Survie.getPluginInstance().getConfig().getDouble("LocSorciere.X"),
			Survie.getPluginInstance().getConfig().getDouble("LocSorciere.Y"), Survie.getPluginInstance().getConfig().getDouble("LocSorciere.Z"), 0, 0);
	final Witch sc = (Witch) Bukkit.getWorld("world").spawnEntity(locSorciere, EntityType.WITCH);
	((Creature)sc).setTarget(null);
	sc.setCustomName("§7Reine des Neiges");
	sc.setCustomNameVisible(true);
	sc.setRemoveWhenFarAway(false);
	sc.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 90000*20, 7));

	Hologram hsc = HologramsAPI.createHologram(Survie.plugin,  sc.getLocation().add(0, 2.6, 0));
	hsc.appendTextLine("§5§lSorcière");
	
	

	Bukkit.getScheduler().scheduleSyncRepeatingTask(Survie.plugin,
			new Runnable() {
				public void run() {
					v.teleport(locvmarchant);
					varm.teleport(locvarmurier);
					vrecru.teleport(locvrecru);
					vInstructeur.teleport(locInstructeur);
					vagent.teleport(vagent);
					vbanque.teleport(locbanque);
					vtroque.teleport(loctroque);
					sc.teleport(locSorciere);
				}
			}, 20, 5 * 20);
		
		
	}
	
	
	
	@EventHandler
	public void onEntercatvillager(PlayerInteractEntityEvent e){
		
		Player p = e.getPlayer();
		String w = p.getWorld().getName();
		
		if (!w.equals("world")) return;
		
       if(e.getRightClicked() instanceof Villager) {
			
			Villager v = (Villager) e.getRightClicked();
			if(v.getCustomName() == null) return;
			e.setCancelled(true);
			
			if (v.getCustomName().equalsIgnoreCase("§7Barbe Noire")) {
				p.openInventory(Marchant.displayMarchant());
			}
			
			if (v.getCustomName().equalsIgnoreCase("§7Achille")) {
				p.openInventory(Armurier.displayArmurier());
			}
			
			if (v.getCustomName().equalsIgnoreCase("§7Bill Gates")) {
				p.openInventory(Recruteur.displayRecruteur(p));
			}
			
			if (v.getCustomName().equalsIgnoreCase("§7Instructeur")) {
				p.openInventory(Instructeur.displayInstructeur());
			}
			
			if (v.getCustomName().equalsIgnoreCase("§7Claims")) {
				p.openInventory(Agent.displayAgent(p));
			}
			
			if (v.getCustomName().equalsIgnoreCase("§7Coffre privé")) {
				p.openInventory(Banquier.displayBanque(p));
			}
			
			if (v.getCustomName().equalsIgnoreCase("§7Troque/Enchères")) {
				p.openInventory(Troqueur.displayTroqueur());
			}
			
		}
       
       if(e.getRightClicked() instanceof Witch) {
			
			
			Witch sc = (Witch) e.getRightClicked();
			if(sc.getCustomName() == null) return;
			e.setCancelled(true);
			
			if (sc.getCustomName().equalsIgnoreCase("§7Reine des Neiges")) {
				p.sendMessage("§aBientôt disponible!");
			}
			
		}
		
	}
		
		
		
	
	
	
	
	@EventHandler
	public void onDamagepng(EntityDamageEvent event){
		
		Entity e = event.getEntity();
		String w = e.getWorld().getName();
		
		if (!w.equals("world")) return;
		
		if(e instanceof Villager) {
		Villager v = (Villager) e;
		if(v.getCustomName() == null) return;
			if(v.getCustomName().equalsIgnoreCase("§7Barbe Noire")) event.setCancelled(true);
			if(v.getCustomName().equalsIgnoreCase("§7Achille")) event.setCancelled(true);
			if(v.getCustomName().equalsIgnoreCase("§7Bill Gates")) event.setCancelled(true);
			if(v.getCustomName().equalsIgnoreCase("§7Instructeur")) event.setCancelled(true);
			if(v.getCustomName().equalsIgnoreCase("§7Claims")) event.setCancelled(true);
			if(v.getCustomName().equalsIgnoreCase("§7Coffre privé")) event.setCancelled(true);
			if(v.getCustomName().equalsIgnoreCase("§7Troque/Enchères")) event.setCancelled(true);
		}
		
		
		if(e instanceof Witch) {
	    	Witch sc = (Witch) e;
	    	if(sc.getCustomName() == null) return;
		    	if(sc.getCustomName().equalsIgnoreCase("§7Reine des Neiges")) event.setCancelled(true);
		    }
		
	}
	
	@EventHandler
	public void TargetEventpng(EntityTargetEvent event) {
		Entity e = event.getEntity();
		String w = e.getWorld().getName();
		
		if (!w.equals("world")) return;

		if(event.getEntity() instanceof Witch) {
			Witch sc = (Witch) e;
			if(sc.getCustomName() == null) return;
		if(sc.getCustomName().equalsIgnoreCase("§7Reine des Neiges")) event.setCancelled(true);
		}
		
	}
	
	
	
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onSpawn(CreatureSpawnEvent event)
	{
		if (event.getEntity().getType() == EntityType.WITHER) { event.setCancelled(true); return;}
		
		if(event.getSpawnReason() == SpawnReason.CUSTOM) return;
		if (event.getSpawnReason() == SpawnReason.SPAWNER) return;
		Location loc = event.getLocation();
		
		RegionManager regionManager = Survie.getWorldGuard().getRegionManager(loc.getWorld());
	    ApplicableRegionSet set = regionManager.getApplicableRegions(loc);
		
	    if(!set.allows(DefaultFlag.PVP) || !set.allows(DefaultFlag.SLEEP) || !set.allows(DefaultFlag.TNT)) event.setCancelled(true);
		
	}
	
	
	@EventHandler
	  public void mobBlockBreak(EntityChangeBlockEvent event)
	  {
		if(event.getEntityType() == EntityType.WITHER || event.getEntityType() == EntityType.ENDER_DRAGON)
		{
			event.setCancelled(true);
		} 
	  }

	

}
