package info.mgone.survie.gui.marchant;

import java.util.ArrayList;
import java.util.List;

import info.mgone.survie.Survie;
import info.mgone.survie.utility;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GiveM {
	
	static List<String> lores = new ArrayList<String>();
	
public static boolean CheckMoney(Player p, double price, InventoryClickEvent e) {
		
		if(p.getInventory().firstEmpty() == -1){ p.sendMessage("§cVotre inventaire est full! §aVous devez avoir au moins un slot vide par sécurité!"); return false;}
		
		double balance = Survie.eco.getBalance(p.getName());
		if(balance <= 0) { p.sendMessage("§cVous n'avez pas assez de $"); return false; }
		
		if(e.getClick().isLeftClick() && e.getClick().isShiftClick()) {
			if(balance >= price*32) { Survie.eco.withdrawPlayer(p.getName(), price*32); p.sendMessage("§6" + (price*32)  + "$ §cont été retirés de votre compte" ); utility.TransLog(p.getName() + " -" + price*32); return true; }
			else { p.sendMessage("§cVous n'avez pas assez de $"); return false; }
		}
		
		else if(e.getClick().isRightClick() && e.getClick().isShiftClick()) {
			if(balance >= price*64) { Survie.eco.withdrawPlayer(p.getName(), price*64); p.sendMessage("§6" + (price*64)  + "$ §cont été retirés de votre compte"); utility.TransLog(p.getName() + " -" + price*64); return true; }
			else { p.sendMessage("§cVous n'avez pas assez de $"); return false; }
		}
		
		
		else if(e.getClick().isRightClick()) {
			if(balance >= price*16) { Survie.eco.withdrawPlayer(p.getName(), price*16); p.sendMessage("§6" + (price*16)  + "$ §cont été retirés de votre compte"); utility.TransLog(p.getName() + " -" + price*16); return true; }
			else { p.sendMessage("§cVous n'avez pas assez de $"); return false; }
		}	
		
		
		else {
		   if(balance >= price) { Survie.eco.withdrawPlayer(p.getName(), price); p.sendMessage("§6" + price  + "$ §cont été retirés de votre compte"); utility.TransLog(p.getName() + " -" + price); return true; }
		   else { p.sendMessage("§cVous n'avez pas assez de $"); return false; }
		}

	}



public static boolean CheckMoney16(Player p, double price, InventoryClickEvent e) {
	
	if(p.getInventory().firstEmpty() == -1){ p.sendMessage("§cVotre inventaire est full! §aVous devez avoir au moins un slot vide par sécurité!"); return false;}
	
	double balance = Survie.eco.getBalance(p.getName());
	if(balance <= 0) { p.sendMessage("§cVous n'avez pas assez de $"); return false; }
	
	if(e.getClick().isShiftClick()) return false;
	
	if(e.getClick().isRightClick()) {
		if(balance >= price*16) { Survie.eco.withdrawPlayer(p.getName(), price*16); p.sendMessage("§6" + (price*16)  + "$ §cont été retirés de votre compte"); utility.TransLog(p.getName() + " -" + price*16); return true; }
		else { p.sendMessage("§cVous n'avez pas assez de $"); return false; }
	}	
	
	else {
	   if(balance >= price) { Survie.eco.withdrawPlayer(p.getName(), price); p.sendMessage("§6" + price  + "$ §cont été retirés de votre compte"); utility.TransLog(p.getName() + " -" + price); return true; }
	   else { p.sendMessage("§cVous n'avez pas assez de $"); return false; }
	}
	
}



public static boolean CheckMoney1(Player p, double price, InventoryClickEvent e) {
	
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


@SuppressWarnings("deprecation")
public static void GiveP16(Player p, Material mat, int shrt, InventoryClickEvent e) {
	int amount = 0;
	
	if(e.getClick().isShiftClick()) return;
	
	if(e.getClick().isRightClick()) {
		amount= 16;
	}	
	
	
	else {
		amount= 1;
	}
	
	
	    ItemStack item = new ItemStack(mat, amount, (short)shrt);
	    p.getInventory().addItem(item);
	    utility.TransLog(p.getName() + " Give " + item.getTypeId());
}


@SuppressWarnings("deprecation")
public static void GiveP1(Player p, Material mat, int shrt, InventoryClickEvent e) {
	
	if(e.getClick().isShiftClick()) return;
	if(e.getClick().isRightClick()) return;
	
	int amount = 1;
	    ItemStack item = new ItemStack(mat, amount, (short)shrt);
	    p.getInventory().addItem(item);
	    utility.TransLog(p.getName() + " Give " + item.getTypeId());
}

	
	@SuppressWarnings("deprecation")
	public static void GiveP(Player p, Material mat, int shrt, InventoryClickEvent e) {
		int amount = 0;
		
		if(e.getClick().isLeftClick() && e.getClick().isShiftClick()) {
			amount= 32;
		}
		
		else if(e.getClick().isRightClick() && e.getClick().isShiftClick()) {
			amount= 64;
		}
		
		else if(e.getClick().isRightClick()) {
			amount= 16;
		}	
		
		
		else {
			amount= 1;
		}
		
		
		    ItemStack item = new ItemStack(mat, amount, (short)shrt);
		    p.getInventory().addItem(item);
		    utility.TransLog(p.getName() + " Give " + item.getTypeId());
	}
	
	
	
	
	public static ItemStack Lore64(Material material, int shrt, String prix) {
	    ItemStack item = new ItemStack(material, 1, (short)shrt);
	    ItemMeta meta = item.getItemMeta();
	    lores.add("§fPrix unité: §a" + prix + "$");
	    lores.add("§7Clic gauche: acheter 1 item");
	    lores.add("§7Clic droit: acheter 16 item");
	    lores.add("§7Clic gauche + shift: acheter 32 item");
	    lores.add("§7Clic droit + shift: acheter 64 item");
	    meta.setLore(lores);
	    item.setItemMeta(meta);
	    lores.clear();
	    return item;
	  }
	
	public static ItemStack Lore16(Material material, int shrt, String prix) {
	    ItemStack item = new ItemStack(material, 1, (short)shrt);
	    ItemMeta meta = item.getItemMeta();
	    lores.add("§fPrix unité: §a" + prix + "$");
	    lores.add("§7Clic gauche: acheter 1 item");
	    lores.add("§7Clic droit: acheter 16 item");
	    meta.setLore(lores);
	    item.setItemMeta(meta);
	    lores.clear();
	    return item;
	  }
	
	public static ItemStack Lore1(Material material, int shrt, String prix) {
	    ItemStack item = new ItemStack(material, 1, (short)shrt);
	    ItemMeta meta = item.getItemMeta();
	    lores.add("§fPrix unité: §a" + prix + "$");
	    lores.add("§7Clic gauche: acheter 1 item");
	    meta.setLore(lores);
	    item.setItemMeta(meta);
	    lores.clear();
	    return item;
	  }
	
	
	

}
