package info.mgone.survie.instructeur;

import fr.mgone.supercoins.API;
import info.mgone.survie.LoginPlayer;
import info.mgone.survie.Survie;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Checkm {
	
public static boolean CheckMoney(Player p, int price, boolean retirer) {
		
		
		double balance = Survie.eco.getBalance(p.getName());
		if(balance <= 0) { p.sendMessage("§cVous n'avez pas assez de $"); return false; }
		
		if(balance >= price) { if(retirer) {Survie.eco.withdrawPlayer(p.getName(), price); p.sendMessage("§6" + price  + "$ §cont été retirés de votre compte"); } return true; }
		else { p.sendMessage("§cVous n'avez pas assez de $"); return false; }
		
	}
	
	
	
	public static void closeNo(Player p) {
		p.closeInventory();
		p.getWorld().playSound(p.getLocation(), Sound.VILLAGER_NO, 2.0F, 13.0F);
	}
	
	public static void closeYes(Player p) {
		p.closeInventory();
		p.getWorld().playSound(p.getLocation(), Sound.VILLAGER_YES, 2.0F, 13.0F);
	}
	
	
	
	
	
	public static boolean CheckSuperCoins(Player p, int price, boolean retirer) {
		if(p.getInventory().firstEmpty() == -1){ p.sendMessage("§cVotre inventaire est full! §aVous devez avoir au moins un slot vide par sécurité!"); return false;}
		
		if(API.getCoins(p) >= price) {
			   if(retirer) {
			   API.takeCoins(p, price);
			   p.sendMessage("§6"+ price  +" SuperCoins §cont été retirés de votre compte."); }
			   return true;
			}
		else {
			p.sendMessage("§cVous n'avez pas assez de SuperCoins");
			return false; 
		}
			
	}
	
	
	public static boolean CheckSkill(Player p,int price, boolean retirer) {
		String pname = p.getName();
		int skillp= LoginPlayer.skills.get(pname);
		
		if(skillp >= price) {
			   if(retirer) {
			   LoginPlayer.skills.put(pname, skillp-price);
			   p.sendMessage("§6"+ price  +" Skill §cont été retirés de votre compte."); }
			   return true;
			}
		else {
			p.sendMessage("§cVous n'avez pas assez de points de compétence (/Skill).");
			return false; 
		}
		
	}
	
	
	
	public static boolean CheckXP(Player p,int price, boolean retirer) {
		int exp= p.getLevel();
		
		if(exp >= price) {
			   if(retirer) {
			   p.setLevel(exp-price);
			   p.sendMessage("§6"+ price  +" Level(EXP) §cont été retirés de votre compte."); }
			   return true;
			}
		else {
			p.sendMessage("§cVous n'avez pas assez de Level (EXP).");
			return false; 
		}
		
	}
	
	
	public static boolean CheckAll(Player p,int price, int skill, int xp, boolean retirer) {
		
		String pname = p.getName();
		double balance = Survie.eco.getBalance(pname);
		int skillp = LoginPlayer.skills.get(pname);
		int exp= p.getLevel();
		
		if(balance < price || skillp < skill || exp < xp) {
		
		if(balance < price) p.sendMessage("§cVous n'avez pas assez de $");
		if(skillp < skill)  p.sendMessage("§cVous n'avez pas assez de points de compétence (/Skill).");
		if(exp < xp) p.sendMessage("§cVous n'avez pas assez de Level (EXP).");
		
		return false; 
		}
		
		if(balance>=price && skillp>=skill && exp>=xp) {
			
			if(retirer) {
			Survie.eco.withdrawPlayer(pname, price); p.sendMessage("§6" + price  + "$ §cont été retirés de votre compte");
			LoginPlayer.skills.put(pname, skillp-skill); p.sendMessage("§6"+ skill  +" Skill §cont été retirés de votre compte.");
			p.setLevel(exp-xp);  p.sendMessage("§6"+ xp  +" Level(EXP) §cont été retirés de votre compte."); }
			
			return true;
		}
		
		
		
		return false; 
	}
	
	
	

}
