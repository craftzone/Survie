package info.mgone.survie;

import java.sql.ResultSet;
import java.sql.SQLException;

import me.mgone.bossbarapi.BossbarAPI;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class DifTask {
	
static int bar = 1;
static int car = 1;
	
public static void Astuces(){


	/*Bukkit.getScheduler().scheduleSyncRepeatingTask(Survie.plugin, new Runnable(){
		public void run(){

			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "ne reload");
		    	  
		}
	}, 600 * 20, 1200 * 20); */
	
	Bukkit.getScheduler().scheduleSyncRepeatingTask(Survie.plugin, new Runnable(){
		public void run(){
			GiveVote();
		}
	}, 5 * 20, 5 * 20);
	
	
	
	
	Bukkit.getScheduler().scheduleSyncRepeatingTask(Survie.plugin,
			new Runnable() {
				public void run() {
					
					switch(car){
					case 1:for(Player p : Bukkit.getOnlinePlayers()){
					utility.sendActionBar(p, "§a§lA§6§ls§c§lt§b§lu§d§lc§1§le: §f§lEvitez de construire sous terre, votre claim sera vulnérable a la TNT!", 8);}car++; break;
					
					
					case 2:for(Player p : Bukkit.getOnlinePlayers()){
						utility.sendActionBar(p, "§a§lA§6§ls§c§lt§b§lu§d§lc§1§le: §f§lL'obsidienne et l'eau ne protége contre les explosions.", 8);}car++; break;
					
					
					case 3:for(Player p : Bukkit.getOnlinePlayers()){
						utility.sendActionBar(p, "§a§lA§6§ls§c§lt§b§lu§d§lc§1§le: §f§lEn tuant un joueur en état de siège vous gagner plus de skill.", 8);}car++; break;
					
					
					case 4:for(Player p : Bukkit.getOnlinePlayers()){
						utility.sendActionBar(p, "§a§lA§6§ls§c§lt§b§lu§d§lc§1§le: §f§lVotre claim devient vulnérable aux explosions en état de siège!", 8);}car++; break;
					
					
					case 5:for(Player p : Bukkit.getOnlinePlayers()){
					utility.sendActionBar(p, "§d§lNotre TeamSpeak: §c§lts.CraftZone.fr",6);}car++; break;
					
					
					case 6:for(Player p : Bukkit.getOnlinePlayers()){
						utility.sendActionBar(p, "§5❤ §d/vote §5❤  §3 ✔ §apour soutenir votre serveur préféré   §3 ✔",8);}car++; break;
						
						
					case 7:for(Player p : Bukkit.getOnlinePlayers()){
						utility.sendActionBar(p, "§a§lA§6§ls§c§lt§b§lu§d§lc§1§le: §f§lTuer des civiles diminue votre KDR! et des ennemies le double!", 8);}car++; break;
						
						
					case 8:for(Player p : Bukkit.getOnlinePlayers()){
						utility.sendActionBar(p, "§a§lA§6§ls§c§lt§b§lu§d§lc§1§le: §f§lLe KDR multiplie vos gains de skill et $ quand vous tuer un joueur!", 8);}car++; break;
					
						
					case 9:for(Player p : Bukkit.getOnlinePlayers()){
						utility.sendActionBar(p, "§a§lA§6§ls§c§lt§b§lu§d§lc§1§le: §f§lUtilisez un stick pour rechercher des claims, et la boussole pour rechercher des joueurs.!", 8);}car++; break;
						
						
					case 10:for(Player p : Bukkit.getOnlinePlayers()){
						utility.sendActionBar(p, "§a§lA§6§ls§c§lt§b§lu§d§lc§1§le: §f§lAu dessous de la couche 60, les claims sont protégés mais vulnérable aux explosions!", 8);}car=1; break;
						
					}

		}
				
  }, 100 *20, 600 * 20);
	
	
	
	Bukkit.getScheduler().scheduleSyncRepeatingTask(Survie.plugin,
			new Runnable() {
				public void run() {
					
					switch(bar){
					case 1: for(Player p : Bukkit.getOnlinePlayers()) BossbarAPI.setMessage(p, "§d§lNotre TeamSpeak: §c§lts.CraftZone.fr", 6); bar++; break;
					
					case 2: for(Player p : Bukkit.getOnlinePlayers()) BossbarAPI.setMessage(p, "§5❤ §d§l/vote §5❤  §3 ✔ §apour soutenir votre serveur préféré   §3 ✔ ", 10); bar=1; break;
			
						
					}

		}
				
  }, 400*20, 600 * 20);
  
	
	
	
}



public static void GiveVote(){
	
	   ResultSet rs = MySQL.querySQL("SELECT * FROM votegive;");	

	   try {
				while(rs.next()) {
					String name =  rs.getString("name");
					//OfflinePlayer p = Bukkit.getOfflinePlayer(name);
					//if(p.isOnline()){
						//Player pe = (Player) p;
					Bukkit.dispatchCommand(Survie.plugin.getServer().getConsoleSender(), "eco give "+ name +" 500");
					MySQL.createStatement("DELETE FROM votegive WHERE name = '" + name + "';");
					//pe.sendMessage("§aVous avez reçu 500$!");
					//}
				 }
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	
	

}
