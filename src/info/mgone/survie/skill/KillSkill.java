package info.mgone.survie.skill;

import java.util.HashMap;

import info.mgone.survie.LoginPlayer;
import info.mgone.survie.Survie;
import net.sacredlabyrinth.phaed.simpleclans.ClanPlayer;
import net.sacredlabyrinth.phaed.simpleclans.SimpleClans;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;


public class KillSkill implements Listener {
	
	public static HashMap<String, String> tuers = new HashMap<String, String>();
	
	@EventHandler
	  public void ondeath(PlayerDeathEvent e)
	  {   
		Player pmort =  e.getEntity().getPlayer();
		String pmortname = pmort.getName();
		
		if(!(pmort.getKiller() instanceof Player)) return;
		if(pmort.hasMetadata("NPC")) return;
		
		Player pkiller = e.getEntity().getPlayer().getKiller();
		final String pkillername = pkiller.getName();

        ClanPlayer mortcp;
        mortcp = SimpleClans.getInstance().getClanManager().getClanPlayer(pmort);
        
        ClanPlayer killercp;
		killercp = SimpleClans.getInstance().getClanManager().getClanPlayer(pkiller);
        
		
		if(killercp == null) {
        	pkiller.sendMessage("§4ATTENTION:§fVous n'avez pas de team donc vous ne gagner rien en tuant des joueurs!");
        	return;
        }
		
        
        if(mortcp == null) {
        	pkiller.sendMessage("§4ATTENTION:§fNe tuez pas des civiles ça diminue votre KDR!");
        	return;
        }
		
        
		
		if(pmortname.contentEquals(pkillername)) return;


        int win = 2;
        float kdr = killercp.getKDR();
        double rkdr = Math.round(kdr * 100D)/100D ;
        if(rkdr <=0) return;
        double multi = 5;
        if(rkdr<=5) multi = 4;
        else if(rkdr>5 && rkdr <=10) multi = 3;
        else if(rkdr>10 && rkdr <=20) multi = 2.1;
        else if(rkdr>20 && rkdr <=30) multi = 1.9;
        else if(rkdr>30 && rkdr <=40) multi = 1.5;
        else if(rkdr>40 && rkdr <=50) multi = 1.1;
        else if(rkdr>50 && rkdr <=100) multi = 0.9;
        else if(rkdr>100 && rkdr <=200) multi = 0.5;
        else if(rkdr>200) multi = 0.1;
        
        
        
        if(killercp.getClan().isRival(mortcp.getClan().getTag())) win = 3;
		

			if(tuers.containsKey(pkillername)) {
				if(tuers.get(pkillername).contains(pmortname)) return;
			}
			
			
			
				
			    int skillkiller = LoginPlayer.skills.get(pkillername);
				tuers.remove(pkillername);
				
				LoginPlayer.skills.put(pkillername, skillkiller+win);
				Survie.eco.depositPlayer(pkillername, multi*rkdr);
				tuers.put(pkillername, pmortname);
				pkiller.sendMessage("§6\u2693 +" + multi*rkdr + " $" + " §e(KDR: " + rkdr + ")");
				pkiller.sendMessage("§b\u2622 +" + win + " Skill");
				

		
		
	  }

}
