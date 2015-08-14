package info.mgone.survie.gui.armurier;

import fr.mgone.supercoins.API;
import info.mgone.survie.LoginPlayer;
import info.mgone.survie.Survie;
import info.mgone.survie.utility;
import info.mgone.survie.gui.AttributesLore.Attributes;
import info.mgone.survie.gui.AttributesLore.Attributes.Operation;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class Fct {
	
public static ItemStack AddAtrib(ItemStack item, double damage, double health, double speed, double knowback) {
		
		Attributes attributes = new Attributes(item);
		
		if(damage != 0) attributes.add(Attributes.Attribute.newBuilder().name("Damage")
			       .type(Attributes.AttributeType.GENERIC_ATTACK_DAMAGE).amount(damage).build());
		
		if(health != 0) attributes.add(Attributes.Attribute.newBuilder().name("Health")
                    .type(Attributes.AttributeType.GENERIC_MAX_HEALTH).amount(health).build());
		   
		if(speed != 0) attributes.add(Attributes.Attribute.newBuilder().name("Speed")
				      .type(Attributes.AttributeType.GENERIC_MOVEMENT_SPEED).amount(speed).operation(Operation.ADD_PERCENTAGE).build());
		   
		if(knowback != 0) attributes.add(Attributes.Attribute.newBuilder().name("KnockBack")
			       .type(Attributes.AttributeType.GENERIC_KNOCKBACK_RESISTANCE).amount(knowback).operation(Operation.ADD_NUMBER).build()); 
		   
		   
		   return attributes.stack;
		   
		
	}

public static void closeNo(Player p) {
	p.closeInventory();
	p.getWorld().playSound(p.getLocation(), Sound.VILLAGER_NO, 2.0F, 13.0F);
}

public static boolean CheckMoneyArmes(Player p, int price, InventoryClickEvent e) {
	
	if(p.getInventory().firstEmpty() == -1){ p.sendMessage("§cVotre inventaire est full! §aVous devez avoir au moins un slot vide par sécurité!"); return false;}
	
	double balance = Survie.eco.getBalance(p.getName());
	if(balance <= 0) { p.sendMessage("§cVous n'avez pas assez de $"); return false; }
	
	if(e.getClick().isShiftClick()) return false;
	
	if(e.getClick().isRightClick()) return false;

	if(e.getClick().isLeftClick()) {
	   if(balance >= price) { Survie.eco.withdrawPlayer(p.getName(), price); p.sendMessage("§6" + price  + "$ §cont été retirés de votre compte"); utility.TransLog(p.getName() + " -" + price); return true; }
	   else { p.sendMessage("§cVous n'avez pas assez de $"); return false; }
	}
	
	return false;
}


public static boolean CheckSuperCoins(Player p, int price) {
	if(p.getInventory().firstEmpty() == -1){ p.sendMessage("§cVotre inventaire est full! §aVous devez avoir au moins un slot vide par sécurité!"); return false;}
	
	if(API.getCoins(p) >= price) {
		   API.takeCoins(p, price);
		   p.sendMessage("§6"+ price  +" SuperCoins §cont été retirés de votre compte.");
		   return true;
		}
	else {
		p.sendMessage("§cVous n'avez pas assez de SuperCoins");
		return false; 
	}
		
}

public static boolean CheckSkill(Player p,int price) {
	String pname = p.getName();
	int skillp= LoginPlayer.skills.get(pname);
	
	if(skillp >= price) {
		LoginPlayer.skills.put(pname, skillp-price);
		   p.sendMessage("§6"+ price  +" Skill §cont été retirés de votre compte.");
		   return true;
		}
	else {
		p.sendMessage("§cVous n'avez pas assez de points de compétence (/Skill).");
		return false; 
	}
	
}



public static boolean CheckXP(Player p,int price) {
	int exp= p.getLevel();
	
	if(exp >= price) {
		p.setLevel(exp-price);
		   p.sendMessage("§6"+ price  +" Level(EXP) §cont été retirés de votre compte.");
		   return true;
		}
	else {
		p.sendMessage("§cVous n'avez pas assez de Level (EXP).");
		return false; 
	}
	
}

public static boolean CheckAll(Player p,int price, int skill, int xp) {
	if(p.getInventory().firstEmpty() == -1){ p.sendMessage("§cVotre inventaire est full! §aVous devez avoir au moins un slot vide par sécurité!"); return false;}
	
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
		
		Survie.eco.withdrawPlayer(pname, price); p.sendMessage("§6" + price  + "$ §cont été retirés de votre compte");
		LoginPlayer.skills.put(pname, skillp-skill); p.sendMessage("§6"+ skill  +" Skill §cont été retirés de votre compte.");
		p.setLevel(exp-xp);  p.sendMessage("§6"+ xp  +" Level(EXP) §cont été retirés de votre compte.");
		utility.TransLog(p.getName() + " -m:" + price + " -s:" + skill + " -xp" + xp);
		return true;
	}
	
	
	
	return false; 
}

}
