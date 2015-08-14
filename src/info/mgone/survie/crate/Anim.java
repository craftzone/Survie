package info.mgone.survie.crate;

import info.mgone.survie.Survie;
import info.mgone.survie.particles.ParticleEffect;
import info.mgone.survie.particles.ParticleEffect.ParticleType;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class Anim {
	
	public static void AnimChest() {
		
		//block particles
		final World worldc = Bukkit.getWorld("world");
		final Location locc1 = new Location(worldc,0.5,77.1,-6.5,0,0);
		final ParticleEffect particle = new ParticleEffect(ParticleType.FIREWORKS_SPARK, 0.3F, 0.3F, 0.3F, 0.0F, 10);
		
		final Location lochelp = new Location(worldc,0,76,-19,0,0).add(0.5, 0.5, 0.5);
		final ParticleEffect particlehelp = new ParticleEffect(ParticleType.WITCH_MAGIC, 0.3F, 0.3F, 0.3F, 0.0F, 10);
		
		final Location locsd = new Location(worldc,-6,76,-7,0,0).add(0.5, 1.1, 0.5);
		final Location locor = new Location(worldc,-9,76,-7,0,0).add(0.5, 1.1, 0.5);
		final ParticleEffect particlesd = new ParticleEffect(ParticleType.SMOKE, 0.3F, 0.3F, 0.3F, 0.0F, 10);
		final ParticleEffect particleor = new ParticleEffect(ParticleType.FLAME, 0.3F, 0.3F, 0.3F, 0.0F, 10);
		
		final Location locdm = new Location(worldc,6,76,-7,0,0).add(0.5, 0.7, 0.5);
		final Location locem = new Location(worldc,9,76,-7,0,0).add(0.5, 0.5, 0.5);
		final ParticleEffect particledm = new ParticleEffect(ParticleType.DRIP_WATER, 0.3F, 0.3F, 0.3F, 0.0F, 10);
		final ParticleEffect particleem = new ParticleEffect(ParticleType.HAPPY_VILLAGER, 0.3F, 0.3F, 0.3F, 0.0F, 10);
		
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Survie.plugin, new Runnable(){

			public void run(){
				particle.display(locc1, "world");
				
				particlehelp.display(lochelp, "world");
				
				particlesd.display(locsd, "world");
				particleor.display(locor, "world");
				
				particledm.display(locdm, "world");
				particleem.display(locem, "world");
			}
		}, 0, 20);
				
		
		
	}

}
