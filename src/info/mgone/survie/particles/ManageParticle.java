package info.mgone.survie.particles;

import java.util.HashMap;

import org.bukkit.entity.Player;

import info.mgone.survie.particles.ParticleEffect.ParticleType;

public class ManageParticle {
	
	private static HashMap<String, String> config = new HashMap<String, String>();
	
	private static ManageParticle instance = new ManageParticle();
	public static ManageParticle getInstance() {
		return instance;
	}
	
	
	public void setParticle(ParticleType type, Player player){
		config.put(player.getName(), type.toString().toLowerCase().replace("_", ""));

	}
	
	public void resetParticle(Player player){
		config.remove(player.getName());
	}
	
	public ParticleType getParticle(Player player){
		String effectToLowerCase = (String) config.get(player.getName());
		return ParticleCreator.particleFromString(effectToLowerCase);
	}
	
	public static boolean HaveParticle(Player p) {
		
		if(config.containsKey(p)) return true;
	
		return false;
	}

}
