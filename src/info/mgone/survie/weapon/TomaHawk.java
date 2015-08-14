package info.mgone.survie.weapon;

import info.mgone.survie.Survie;
import info.mgone.survie.utility;
import info.mgone.survie.noob.NoobPvP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.WeakHashMap;

import mkremins.fanciful.FancyMessage;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.Vector;

import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.DefaultFlag;
import com.sk89q.worldguard.protection.managers.RegionManager;



public class TomaHawk implements Listener {
	
	public static HashMap<String, ItemStack> tomahawkitem = new HashMap<String, ItemStack>();
	ArrayList<String> TomahawkOnCoolDown = new ArrayList<String>();
	//ArrayList<String> EffectOnCoolDown = new ArrayList<String>();
	
	public final static WeakHashMap<Entity, EntityData> shotprojectiledata = new WeakHashMap<Entity, EntityData>();
	

	@EventHandler
	public void onInteract(PlayerInteractEvent event){
		if(event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			if(event.getMaterial().equals(Material.DIAMOND_AXE)){
				
				final Player p = event.getPlayer();
				String pname = p.getName();
				
				if(event.getItem().getItemMeta().hasLore()){
					
					ItemStack itemStack = event.getItem();
					ItemMeta meta = itemStack.getItemMeta();
				    if(!meta.getLore().get(0).contains("TomaHawk")) return;;
				    
				    
				    if(NoobPvP.IsNoobNow(p)) {
				    	p.sendMessage("§cVous avez une PVP-protection pour les nouveaux.\n"+
				        "§6Vous n'avez la permission d'utiliser le TomaHawk!\n"+
				    	"§aPour plus de détails tapez §b/pvp");
				    	return;
				    }
				    
				    
					RegionManager regionManager = Survie.getWorldGuard().getRegionManager(p.getLocation().getWorld());
					ApplicableRegionSet set = regionManager.getApplicableRegions(p.getLocation());

					if (!set.allows(DefaultFlag.PVP)) {
						p.sendMessage("§cVous n'avez pas la permission d'utiliser le TomaHawk dans cette Zone!");
						return;
					}

					//if (TomahawkOnCoolDown.contains(pname)) { utility.sendActionBar(p,"§5§l\u2622 Le rechargement du TomaHawk est de 5 secondes... \u2622"); return;   } 
					tomahawkitem.put(pname,itemStack);
					
					//ParticleEffect.WITCH_MAGIC.display(0, 0, 0, 0.2F, 200, p.getLocation(), 20.0D);
					//var
					World worldp = p.getWorld();
					Location eloc = p.getEyeLocation();
					Location ploc = p.getLocation();

					//throw
					eloc.setY(eloc.getY() - 0.5D);
					Item item_thrown = worldp.dropItem(eloc, p.getItemInHand());
					Vector v = event.getPlayer().getEyeLocation().getDirection().multiply(2.5F);
					item_thrown.setVelocity(v);
					p.setItemInHand(null);
					p.updateInventory();;
					//TomahawkOnCoolDown.add(pname);
					
					
					  //effect and sound
					  p.playSound(ploc, Sound.SHOOT_ARROW, 30.0F, 10.0F);
                      BlockIterator blocksToAdd = new BlockIterator(eloc, 0D, 15);
                      Location blockToAdd;
                      EntityData data = new EntityData(item_thrown.getLocation(), 15, 5D);
                      shotprojectiledata.put(item_thrown, data);
                      while(blocksToAdd.hasNext()) {
                          blockToAdd = blocksToAdd.next().getLocation();
                          if (blockToAdd.getBlock().getType() != Material.AIR || !shotprojectiledata.containsKey(item_thrown)) {
                          break;
                          }
                          worldp.playEffect(blockToAdd, Effect.MOBSPAWNER_FLAMES, 1);

                      }
					 
					
                        onHit(p,item_thrown);
				        //XpLoad(p);
						event.setCancelled(true);

	
				 }
			}

		}

	} 
	
	
	public void onHit(final Player p,final Item item_thrown) {
    
		new BukkitRunnable() {
			public void run() {
				if (!item_thrown.isDead()) {
					boolean tape = false;
					for (org.bukkit.entity.Entity ent : item_thrown.getNearbyEntities(1D, 1D, 1D)) {
						if(tape == true) continue;
							if ((ent instanceof LivingEntity)) {
								LivingEntity living = (LivingEntity) ent;
								if(ent != p){ 
								TmEffect(p,item_thrown, living); item_thrown.remove(); tape =true;  cancel(); return;}
							}

					} 
					
					if(item_thrown.isOnGround()) { retunOnHit(p,item_thrown.getLocation(),false); item_thrown.remove(); cancel(); return; }
					
					
				} else 
					try {
						cancel();
						
					} catch (Throwable e) {
						e.printStackTrace();
					}
			}
		}.runTaskTimer(Survie.plugin, 0L, 2L);

	}
	
	
	
	public void TmEffect(Player p, Item item_thrown, LivingEntity entity) {
		
		ItemStack itemStack = item_thrown.getItemStack();
		ItemMeta meta = itemStack.getItemMeta();
		List<String> loretlist = meta.getLore();
		String pname = p.getName();
		World worldp = p.getWorld();
		Location eloc = entity.getLocation();
		
		String dega0 = loretlist.get(2);
		String[] dega1 = dega0.split(": §2");
		double dega = Double.valueOf(dega1[1].trim().replace(",", "."));
		
		String magic0 = loretlist.get(5);
		double d = 0.3;
		
		
		if(magic0.contains("Aveuglement")) {
			if (d < 0.4) { entity.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 10*20, 1));
			worldp.playEffect(eloc, Effect.STEP_SOUND, Material.FIRE);
               //EffectOnCoolDown.add(pname);
               //RemoveEffect(pname);
             }
       }
		
		
		if(magic0.contains("Poison")) {
			if (d < 0.4) { entity.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 8*20, 0));
			worldp.playEffect(eloc, Effect.STEP_SOUND, Material.FIRE);
			   //EffectOnCoolDown.add(pname);
               //RemoveEffect(pname);
             }
       }
		
			if(magic0.contains("Faiblesse")) {
			if (d < 0.4) { entity.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 15*20, 1));
			worldp.playEffect(eloc, Effect.STEP_SOUND, Material.FIRE);
			               //EffectOnCoolDown.add(pname);
			               //RemoveEffect(pname);
			             }
			}
			
			
			//ligne2

			if(magic0.contains("Feu")) {
				if (d < 0.4) { entity.setFireTicks(8*20);
				worldp.playEffect(eloc, Effect.STEP_SOUND, Material.FIRE);
				   //EffectOnCoolDown.add(pname);
	               //RemoveEffect(pname);
	             }
	       }
			
			
			
			
			if(magic0.contains("Freeze")) {
				if (d < 0.4) { entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 8*20, 3));
				worldp.playEffect(eloc, Effect.STEP_SOUND, Material.FIRE);
				   //EffectOnCoolDown.add(pname);
	               //RemoveEffect(pname);
	             }
	       }
			
			
			if(magic0.contains("Wither")) {
				if (d < 0.4) { entity.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 7*20, 1));
				worldp.playEffect(eloc, Effect.STEP_SOUND, Material.FIRE);
				   //EffectOnCoolDown.add(pname);
	               //RemoveEffect(pname);
	             }
	       }
			
			
			entity.damage(dega, p);
			if(entity.isDead()) {
				if(entity instanceof Player) {
					Player pmort = (Player) entity;
					String pmortname = pmort.getName();
					String Desc = meta.getDisplayName() + "\n";
					for( String s : loretlist ) {
				    	Desc = Desc + s + "\n";
						}
					for (Player pe : Bukkit.getOnlinePlayers()) new FancyMessage("§7*" + pname + " §c§l\u2694 §7" + pmortname).then(" §f\u2620 §7[" + meta.getDisplayName() + "§7]").tooltip(Desc).send(pe);
				}
				
			}
			p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 30, 1);
			retunOnHit(p,eloc,true);
	}
	
	
	
	public void retunOnHit(final Player p,Location eloc,final boolean durab) {
		
		final String pname = p.getName();
		final ItemStack itemStack = tomahawkitem.get(pname);
		Vector v = p.getLocation().getDirection().multiply(-1);
		final Item item_thrown = p.getWorld().dropItem(eloc, itemStack);
		item_thrown.setPickupDelay(10);
		item_thrown.setVelocity(v);
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Survie.plugin, new Runnable()
	    {

		public void run()
	      {
	    	 if(itemStack.getDurability() < 1560) {
	    		 if(durab) itemStack.setDurability((short) (itemStack.getDurability()+50));
	    		 p.getInventory().addItem(itemStack);
	    		 p.updateInventory();
	    	 } else {
	    		 p.playSound(p.getLocation(),Sound.ANVIL_BREAK, 30.0F, 10.0F);
	    	 }
			 tomahawkitem.remove(pname);
	    	 item_thrown.remove();
	    	 
	      }
	    }, 10L);
		
	}
	
	
	
	/*@EventHandler
	public void onHit(CustomProjectileHitEvent event){
		
		if(!(event.getProjectile().getShooter() instanceof Player)) return;
		final Player p = (Player) event.getProjectile().getShooter();
		final String pname = p.getName();
		Location loce = event.getProjectile().getEntity().getLocation();
		World worlde = event.getProjectile().getEntity().getWorld();
		final ItemStack itemprojectile = tomahawkitem.get(pname);
		
			if(event.getHitType() == CustomProjectileHitEvent.HitType.ENTITY){
				
					
					ItemMeta meta = itemprojectile.getItemMeta();
					List<String> loretlist = meta.getLore();
					
					String dega0 = loretlist.get(2);
					String[] dega1 = dega0.split(": §2");
					double dega = Double.valueOf(dega1[1].trim().replace(",", "."));
					
					String magic0 = loretlist.get(5);
					double d = Math.random();


					if(magic0.contains("Aveuglement") && !EffectOnCoolDown.contains(pname)) {
						if (d < 0.6) { event.getHitEntity().addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 10*20, 1));
						   Particles.WITCH_MAGIC.display(event.getProjectile().getEntity().getLocation(), 0, 0, 0, 0.2F, 200);
			               EffectOnCoolDown.add(pname);
			               RemoveEffect(pname);
			             }
			       }
					
					
					if(magic0.contains("Poison") && !EffectOnCoolDown.contains(pname)) {
						if (d < 0.6) { event.getHitEntity().addPotionEffect(new PotionEffect(PotionEffectType.POISON, 8*20, 0));
						   Particles.WITCH_MAGIC.display(event.getProjectile().getEntity().getLocation(), 0, 0, 0, 0.2F, 200);
			               EffectOnCoolDown.add(pname);
			               RemoveEffect(pname);
			             }
			       }
					
						if(magic0.contains("Faiblesse") && !EffectOnCoolDown.contains(pname)) {
						if (d < 0.6) { event.getHitEntity().addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 15*20, 1));
						               Particles.WITCH_MAGIC.display(event.getProjectile().getEntity().getLocation(), 0, 0, 0, 0.2F, 200);
						               EffectOnCoolDown.add(pname);
						               RemoveEffect(pname);
						             }
						}
						
						
						//ligne2
	
						if(magic0.contains("Feu") && !EffectOnCoolDown.contains(pname)) {
							if (d < 0.6) { event.getHitEntity().setFireTicks(8*20);
							   Particles.WITCH_MAGIC.display(event.getProjectile().getEntity().getLocation(), 0, 0, 0, 0.2F, 200);
				               EffectOnCoolDown.add(pname);
				               RemoveEffect(pname);
				             }
				       }
						
						
						
						
						if(magic0.contains("Freeze") && !EffectOnCoolDown.contains(pname)) {
							if (d < 0.6) { event.getHitEntity().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 8*20, 3));
							   Particles.WITCH_MAGIC.display(event.getProjectile().getEntity().getLocation(), 0, 0, 0, 0.2F, 200);
				               EffectOnCoolDown.add(pname);
				               RemoveEffect(pname);
				             }
				       }
						
						
						if(magic0.contains("Wither") && !EffectOnCoolDown.contains(pname)) {
							if (d < 0.6) { event.getHitEntity().addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 7*20, 1));
							   Particles.WITCH_MAGIC.display(event.getProjectile().getEntity().getLocation(), 0, 0, 0, 0.2F, 200);
				               EffectOnCoolDown.add(pname);
				               RemoveEffect(pname);
				             }
				       }
						
						
						
						
						
						

				
				event.getHitEntity().damage(dega, p);

				p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 30, 1);
				final Item drop = worlde.dropItem(loce, itemprojectile);
				Vector v = p.getLocation().getDirection().multiply(-1);
				drop.setPickupDelay(15);
				drop.setVelocity(v);
				
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Survie.plugin, new Runnable()
			    {
			      public void run()
			      {
			    	 if(itemprojectile.getDurability() < 1560) {
			    		 itemprojectile.setDurability((short) (itemprojectile.getDurability()+50));
			    		 p.getInventory().addItem(itemprojectile);
			    		 p.updateInventory();
			    	 } else {
			    		 p.playSound(p.getLocation(),Sound.ANVIL_BREAK, 30.0F, 10.0F);
			    	 }
						tomahawkitem.remove(pname);
						drop.remove();
			      }
			    }, 10L);
				
				
				
			} else {
	
				worlde.dropItemNaturally(loce, itemprojectile);
				tomahawkitem.remove(pname);
				
			}

			
			

	} */
	
	
	/*public void RemoveEffect(final String pname){
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Survie.plugin, new Runnable()
	    {
	      public void run()
	      {
	    	  EffectOnCoolDown.remove(pname);
	      }
	    }, 30 * 20L);
	} */
	
	
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
	    	  TomahawkOnCoolDown.remove(pname);
	      }
	    }, 5 * 20L);
		
	} 
	
	public class EntityData {
        private Location firedfrom;
        private Integer range;
        private Double damage;
 
        //constructor
        public EntityData(Location loc, Integer range, Double damage) {
            this.firedfrom = loc;
            this.range = range;
            this.damage = damage;
        }
        public Location getFiredFrom() {
            return firedfrom;
        }
        public Integer getRange() {
            return range;
        }
        public Double getDamage() {
            return damage;
        }
    }
	


}
