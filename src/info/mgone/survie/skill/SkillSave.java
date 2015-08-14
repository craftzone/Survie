package info.mgone.survie.skill;

import info.mgone.survie.LoginPlayer;
import info.mgone.survie.Survie;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;


public class SkillSave {
	
	public static void SkillTask(){
		  
		 //incrementationn chaque 30 secondes du temps
		 Bukkit.getScheduler().scheduleSyncRepeatingTask(Survie.getPluginInstance(),
					new Runnable() {
						public void run() {
							
							for (Player pe : Bukkit.getOnlinePlayers()) {
								int skillp = LoginPlayer.skills.get(pe.getName());
								Skill.setSkill(pe, skillp);
							}
							
							
						}
             }, 600, 900 * 20);
		 
      }
	
	public static void SkillSaveReboot(){
		
		for (Player pe : Bukkit.getOnlinePlayers()) {
			int skillp = LoginPlayer.skills.get(pe.getName());
			Skill.setSkill(pe, skillp);
		}
		
	}

}
