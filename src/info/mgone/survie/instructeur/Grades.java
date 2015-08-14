package info.mgone.survie.instructeur;

import info.mgone.survie.Glow;
import info.mgone.survie.Survie;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Grades implements org.bukkit.event.Listener {

	public static Inventory GUIgrades = null;
	static ItemStack currentgradesItem = null;
	static List<String> lores = new ArrayList<String>();
	Player p = null;
	String invetaryname = null;

	public static Inventory displayGrades(Player p) {
		GUIgrades = Bukkit.createInventory(null, 18, "§5\u2663 Grades \u2663");

		String grade = Survie.permission.getPrimaryGroup(p);
		Date expir = null;
		if (grade.contains("guerrier") || grade.contains("chevalier")
				|| grade.contains("heros")) {
			expir = Perm.GetGrade(p);
		}

		//guerrier
		currentgradesItem = new ItemStack(Material.GOLD_SWORD);
		ItemMeta meta0 = currentgradesItem.getItemMeta();
		meta0.setDisplayName("§9Guerrier");
		lores.add("§bDurée: §21mois");
		lores.add(" ");
		if (expir != null && grade.contains("guerrier")) {
			String[] parts = expir.toString().split("-");
			meta0.addEnchant(Glow.glow, 1, false);
			lores.add("§fExpiration: §d" + parts[2] + "/" + parts[1] + "/"
					+ parts[0]);
		} else {
			lores.add("§fPrix: §a10000$ + 200 Skill + 40 Exp");
			lores.add("§cOu");
			lores.add("§fPrix: §a300 SuperCoins");
			lores.add("§7Clic gauche: payer avec des $,Skill...");
			lores.add("§7Clic droit: payer avec des SuperCoins");
		}
		meta0.setLore(lores);
		currentgradesItem.setItemMeta(meta0);
		GUIgrades.setItem(0, currentgradesItem);
		lores.clear();

		//chevalier
		currentgradesItem = new ItemStack(Material.IRON_SWORD);
		ItemMeta meta1 = currentgradesItem.getItemMeta();
		meta1.setDisplayName("§3Chevalier");
		lores.add("§bDurée: §21mois");
		lores.add(" ");
		if (expir != null && grade.contains("chevalier")) {
			String[] parts = expir.toString().split("-");
			meta1.addEnchant(Glow.glow, 1, false);
			lores.add("§fExpiration: §d" + parts[2] + "/" + parts[1] + "/"
					+ parts[0]);
		} else {
			lores.add("§fPrix: §a15000$ + 300 Skill + 50 Exp");
			lores.add("§cOu");
			lores.add("§fPrix: §a400 SuperCoins");
			lores.add("§7Clic gauche: payer avec des $,Skill...");
			lores.add("§7Clic droit: payer avec des SuperCoins");
		}
		meta1.setLore(lores);
		currentgradesItem.setItemMeta(meta1);
		GUIgrades.setItem(1, currentgradesItem);
		lores.clear();

		//heros
		currentgradesItem = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta meta2 = currentgradesItem.getItemMeta();
		meta2.setDisplayName("§1Héros");
		lores.add("§bDurée: §21mois");
		lores.add(" ");
		if (expir != null && grade.contains("heros")) {
			String[] parts = expir.toString().split("-");
			meta2.addEnchant(Glow.glow, 1, false);
			lores.add("§fExpiration: §d" + parts[2] + "/" + parts[1] + "/"
					+ parts[0]);
		} else {
			lores.add("§fPrix: §a20000$ + 400 Skill + 60 Exp");
			lores.add("§cOu");
			lores.add("§fPrix: §a500 SuperCoins");
			lores.add("§7Clic gauche: payer avec des $,Skill...");
			lores.add("§7Clic droit: payer avec des SuperCoins");
		}
		meta2.setLore(lores);
		currentgradesItem.setItemMeta(meta2);
		GUIgrades.setItem(2, currentgradesItem);
		lores.clear();

		
        ///////////////////////////////////////////////// 3 MOIS ///////////////////////////////////////////////////////
		
		
        //guerrier
		currentgradesItem = new ItemStack(Material.GOLD_SWORD, 3);
		ItemMeta meta9 = currentgradesItem.getItemMeta();
		meta9.setDisplayName("§9Guerrier");
		lores.add("§bDurée: §23mois");
		lores.add(" ");
		if (expir != null && grade.contains("guerrier")) {
			String[] parts = expir.toString().split("-");
			meta9.addEnchant(Glow.glow, 1, false);
			lores.add("§fExpiration: §d" + parts[2] + "/" + parts[1] + "/"
					+ parts[0]);
		} else {
			lores.add("§fPrix: §a25000$ + 500 Skill + 40 Exp");
			lores.add("§cOu");
			lores.add("§fPrix: §a800 SuperCoins");
			lores.add("§7Clic gauche: payer avec des $,Skill...");
			lores.add("§7Clic droit: payer avec des SuperCoins");
		}
		meta9.setLore(lores);
		currentgradesItem.setItemMeta(meta9);
		GUIgrades.setItem(9, currentgradesItem);
		lores.clear();

		
		//chevalier
		currentgradesItem = new ItemStack(Material.IRON_SWORD, 3);
		ItemMeta meta10 = currentgradesItem.getItemMeta();
		meta10.setDisplayName("§3Chevalier");
		lores.add("§bDurée: §23mois");
		lores.add(" ");
		if (expir != null && grade.contains("chevalier")) {
			String[] parts = expir.toString().split("-");
			meta10.addEnchant(Glow.glow, 1, false);
			lores.add("§fExpiration: §d" + parts[2] + "/" + parts[1] + "/"
					+ parts[0]);
		} else {
			lores.add("§fPrix: §a40000$ + 800 Skill + 50 Exp");
			lores.add("§cOu");
			lores.add("§fPrix: §a1100 SuperCoins");
			lores.add("§7Clic gauche: payer avec des $,Skill...");
			lores.add("§7Clic droit: payer avec des SuperCoins");
		}
		meta10.setLore(lores);
		currentgradesItem.setItemMeta(meta10);
		GUIgrades.setItem(10, currentgradesItem);
		lores.clear();

		
		//heros
		currentgradesItem = new ItemStack(Material.DIAMOND_SWORD, 3);
		ItemMeta meta11 = currentgradesItem.getItemMeta();
		meta11.setDisplayName("§1Héros");
		lores.add("§bDurée: §23mois");
		lores.add(" ");
		if (expir != null && grade.contains("heros")) {
			String[] parts = expir.toString().split("-");
			meta11.addEnchant(Glow.glow, 1, false);
			lores.add("§fExpiration: §d" + parts[2] + "/" + parts[1] + "/"
					+ parts[0]);
		} else {
			lores.add("§fPrix: §a50000$ + 1100 Skill + 60 Exp");
			lores.add("§cOu");
			lores.add("§fPrix: §a1400 SuperCoins");
			lores.add("§7Clic gauche: payer avec des $,Skill...");
			lores.add("§7Clic droit: payer avec des SuperCoins");
		}
		meta11.setLore(lores);
		currentgradesItem.setItemMeta(meta11);
		GUIgrades.setItem(11, currentgradesItem);
		lores.clear();
		
		
		
		////////////papier//////////////
		
		currentgradesItem = new ItemStack(Material.PAPER);
		ItemMeta meta6 = currentgradesItem.getItemMeta();
		meta6.setDisplayName("§9Guerrier");
		lores.add("§fNombre de homes: §63");
		lores.add("§fCoffre mystère: §6OR(Bientôt)");
		lores.add("§fSlots de banque: §6Accés N3");
		lores.add("§fDétermination: §6Accés PVMAX3");
		lores.add("§fVitesse: §6Accés Speed3");
		lores.add("§fBoussole de Rush: §6800 Blocks");
		lores.add("§fTroque: §610 ventes simultanées.");
		lores.add("§fEffet: §6Disco(Bientôt)");
		lores.add("§f/seen: §6Dernière connexion");
		lores.add("§f/hat: §6Chapeau");
		lores.add("§f/wb: §6Table de craft mobile");
		meta6.setLore(lores);
		currentgradesItem.setItemMeta(meta6);
		GUIgrades.setItem(6, currentgradesItem);
		lores.clear();
		
		
		currentgradesItem = new ItemStack(Material.PAPER);
		ItemMeta meta7 = currentgradesItem.getItemMeta();
		meta7.setDisplayName("§3Chevalier");
		lores.add("§fNombre de homes: §66");
		lores.add("§fCoffre mystère: §6DIAMANT(Bientôt)");
		lores.add("§fSlots de banque: §6Accés N4");
		lores.add("§fDétermination: §6Accés PVMAX4");
		lores.add("§fVitesse: §6Accés Speed4");
		lores.add("§fBoussole de Rush: §61000 Blocks");
		lores.add("§fTroque: §615 ventes simultanées.");
		lores.add("§fEffet: §6Disco+Coeurs(Bientôt)");
		lores.add("§f/seen: §6Dernière connexion d'un joueur");
		lores.add("§f/hat: §6Chapeau");
		lores.add("§f/wb: §6Table de craft mobile");
		lores.add("§f/openinv: §6Voir l'inventaire d'un joueur");
		lores.add("§f/back: §6Retour au point de mort");
		meta7.setLore(lores);
		currentgradesItem.setItemMeta(meta7);
		GUIgrades.setItem(7, currentgradesItem);
		lores.clear();
		
		
		currentgradesItem = new ItemStack(Material.PAPER);
		ItemMeta meta8 = currentgradesItem.getItemMeta();
		meta8.setDisplayName("§1Héros");
		lores.add("§fNombre de homes: §69");
		lores.add("§fCoffre mystère: §6EMERAUDE(Bientôt)");
		lores.add("§fSlots de banque: §6Accés N5");
		lores.add("§fDétermination: §6Accés PVMAX5");
		lores.add("§fVitesse: §6Accés Speed5");
		lores.add("§fBoussole de Rush: §61000 Blocks");
		lores.add("§fTroque: §620 ventes simultanées");
		lores.add("§fEffet: §6Disco+Coeurs+Magma(Bientôt)");
		lores.add("§f/seen: §6Dernière connexion d'un joueur");
		lores.add("§f/hat: §6Chapeau");
		lores.add("§f/wb: §6Table de craft mobile");
		lores.add("§f/openinv: §6Voir l'inventaire d'un joueur");
		lores.add("§f/back: §6Retour au point de mort");
		lores.add("§f/feed: §6Remplir la jauge de faim");
		lores.add("§f/near 5000: §6Position des joueurs");
		meta8.setLore(lores);
		currentgradesItem.setItemMeta(meta8);
		GUIgrades.setItem(8, currentgradesItem);
		lores.clear();
		
		
		

		return GUIgrades;
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void guiClick(InventoryClickEvent e) {

		invetaryname = e.getInventory().getName();
		p = ((Player) e.getWhoClicked());

		if (!invetaryname.contains("§5\u2663 Grades \u2663"))
			return;
		if ((e.getSlot() < 0) || (e.getSlot() > 53))
			return;
		e.setCancelled(true);
		if (e.getSlotType() != InventoryType.SlotType.CONTAINER) {
			p.closeInventory();
			return;
		}
		String grade = Survie.permission.getPrimaryGroup(p);
		String pname = p.getName();
		
		//1 mois

		//guerrier
		if (e.getSlot() == 0) {

			if (e.getClick().isLeftClick()) {

				if (grade.contains("guerrier") || grade.contains("chevalier") || grade.contains("heros")) {
					if(grade.contains("guerrier")) p.sendMessage("§cVous avez déjà ce grade! Attendez son expiration pour renouveler.");
					if(grade.contains("chevalier") || grade.contains("heros")) p.sendMessage("§cVous avez déjà un grade supérieur! Attendez son expiration pour renouveler.");
					Checkm.closeNo(p);
					return;
				} else {
					if (Checkm.CheckAll(p, 10000, 200, 40, true)) {
						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(),"perm player " + pname + " setgroup guerrier 30d");
						Bukkit.broadcastMessage("§4F§6é§2l§bi§1c§di§ft§8a§ct§ei§a§3o§9n: §6\u265B " + pname + " \u265B §fest maintenant Guerrier!");
						Perm.SetPerm(p);
						Checkm.closeYes(p);
						return;
					} else Checkm.closeNo(p);

				}

			}

			if (e.getClick().isRightClick()) {

				if (grade.contains("guerrier") || grade.contains("chevalier") || grade.contains("heros")) {
					if(grade.contains("guerrier")) p.sendMessage("§cVous avez déjà ce grade! Attendez son expiration pour renouveler.");
					if(grade.contains("chevalier") || grade.contains("heros")) p.sendMessage("§cVous avez déjà un grade supérieur! Attendez son expiration pour renouveler.");
					Checkm.closeNo(p);
					return;
				} else {
					if (Checkm.CheckSuperCoins(p, 300, true)) {
						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(),"perm player " + pname + " setgroup guerrier 30d");
						Bukkit.broadcastMessage("§4F§6é§2l§bi§1c§di§ft§8a§ct§ei§a§3o§9n: §6\u265B " + pname + " \u265B §fest maintenant Guerrier!");
						Perm.SetPerm(p);
						Checkm.closeYes(p);
						return;
					} else Checkm.closeNo(p);

				}

			}
			

		}
		
		
		//chevalier
				if (e.getSlot() == 1) {

					if (e.getClick().isLeftClick()) {

						if (grade.contains("chevalier") || grade.contains("heros")) {
							if(grade.contains("chevalier")) p.sendMessage("§cVous avez déjà ce grade! Attendez son expiration pour renouveler.");
							if(grade.contains("heros")) p.sendMessage("§cVous avez déjà un grade supérieur! Attendez son expiration pour renouveler.");
							Checkm.closeNo(p);
							return;
						} else {
							if (Checkm.CheckAll(p, 15000, 300, 50, true)) {
								Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(),"perm player " + pname + " setgroup chevalier 30d");
								Bukkit.broadcastMessage("§4F§6é§2l§bi§1c§di§ft§8a§ct§ei§a§3o§9n: §6\u265B " + pname + " \u265B §fest maintenant Chevalier!");
								Perm.SetPerm(p);
								Checkm.closeYes(p);
								return;
							} else Checkm.closeNo(p);

						}

					}

					if (e.getClick().isRightClick()) {

						if (grade.contains("chevalier") || grade.contains("heros")) {
							if(grade.contains("chevalier")) p.sendMessage("§cVous avez déjà ce grade! Attendez son expiration pour renouveler.");
							if(grade.contains("heros")) p.sendMessage("§cVous avez déjà un grade supérieur! Attendez son expiration pour renouveler.");
							Checkm.closeNo(p);
							return;
						} else {
							if (Checkm.CheckSuperCoins(p, 1100, true)) {
								Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(),"perm player " + pname + " setgroup chevalier 30d");
								Bukkit.broadcastMessage("§4F§6é§2l§bi§1c§di§ft§8a§ct§ei§a§3o§9n: §6\u265B " + pname + " \u265B §fest maintenant Chevalier!");
								Perm.SetPerm(p);
								Checkm.closeYes(p);
								return;
							} else Checkm.closeNo(p);

						}

					}
					

				}
				
				
				
				
				
				//heros
				if (e.getSlot() == 2) {

					if (e.getClick().isLeftClick()) {

						if (grade.contains("heros")) {
							p.sendMessage("§cVous avez déjà ce grade! Attendez son expiration pour renouveler.");
							Checkm.closeNo(p);
							return;
						} else {
							if (Checkm.CheckAll(p, 20000, 400, 60, true)) {
								Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(),"perm player " + pname + " setgroup heros 30d");
								Bukkit.broadcastMessage("§4F§6é§2l§bi§1c§di§ft§8a§ct§ei§a§3o§9n: §6\u265B " + pname + " \u265B §fest maintenant Heros!");
								Perm.SetPerm(p);
								Checkm.closeYes(p);
								return;
							} else Checkm.closeNo(p);

						}

					}

					if (e.getClick().isRightClick()) {

						if (grade.contains("heros")) {
							p.sendMessage("§cVous avez déjà ce grade! Attendez son expiration pour renouveler.");
							Checkm.closeNo(p);
							return;
						} else {
							if (Checkm.CheckSuperCoins(p, 500, true)) {
								Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(),"perm player " + pname + " setgroup heros 30d");
								Bukkit.broadcastMessage("§4F§6é§2l§bi§1c§di§ft§8a§ct§ei§a§3o§9n: §6\u265B " + pname + " \u265B §fest maintenant Heros!");
								Perm.SetPerm(p);
								Checkm.closeYes(p);
								return;
							} else Checkm.closeNo(p);

						}

					}
					

				}
				
				
				
				///////////////////////////////////////////////// 3 MOIS ///////////////////////////////////////////////////////

				
				
				
				//guerrier
				if (e.getSlot() == 9) {

					if (e.getClick().isLeftClick()) {

						if (grade.contains("guerrier")) {
							p.sendMessage("§cVous avez déjà ce grade! Attendez son expiration pour renouveler.");
							Checkm.closeNo(p);
							return;
						} else {
							if (Checkm.CheckAll(p, 25000, 500, 40, true)) {
								Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(),"perm player " + pname + " setgroup guerrier 90d");
								Bukkit.broadcastMessage("§4F§6é§2l§bi§1c§di§ft§8a§ct§ei§a§3o§9n: §6\u265B " + pname + " \u265B §fest maintenant Guerrier!");
								Perm.SetPerm(p);
								Checkm.closeYes(p);
								return;
							} else Checkm.closeNo(p);

						}

					}

					if (e.getClick().isRightClick()) {

						if (grade.contains("guerrier")) {
							p.sendMessage("§cVous avez déjà ce grade! Attendez son expiration pour renouveler.");
							Checkm.closeNo(p);
							return;
						} else {
							if (Checkm.CheckSuperCoins(p, 800, true)) {
								Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(),"perm player " + pname + " setgroup guerrier 90d");
								Bukkit.broadcastMessage("§4F§6é§2l§bi§1c§di§ft§8a§ct§ei§a§3o§9n: §6\u265B " + pname + " \u265B §fest maintenant Guerrier!");
								Perm.SetPerm(p);
								Checkm.closeYes(p);
								return;
							} else Checkm.closeNo(p);

						}

					}
					

				}
				
				
				//chevalier
						if (e.getSlot() == 10) {

							if (e.getClick().isLeftClick()) {

								if (grade.contains("chevalier")) {
									p.sendMessage("§cVous avez déjà ce grade! Attendez son expiration pour renouveler.");
									Checkm.closeNo(p);
									return;
								} else {
									if (Checkm.CheckAll(p, 40000, 800, 50, true)) {
										Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(),"perm player " + pname + " setgroup chevalier 90d");
										Bukkit.broadcastMessage("§4F§6é§2l§bi§1c§di§ft§8a§ct§ei§a§3o§9n: §6\u265B " + pname + " \u265B §fest maintenant Chevalier!");
										Perm.SetPerm(p);
										Checkm.closeYes(p);
										return;
									} else Checkm.closeNo(p);

								}

							}

							if (e.getClick().isRightClick()) {

								if (grade.contains("chevalier")) {
									p.sendMessage("§cVous avez déjà ce grade! Attendez son expiration pour renouveler.");
									Checkm.closeNo(p);
									return;
								} else {
									if (Checkm.CheckSuperCoins(p, 400, true)) {
										Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(),"perm player " + pname + " setgroup chevalier 90d");
										Bukkit.broadcastMessage("§4F§6é§2l§bi§1c§di§ft§8a§ct§ei§a§3o§9n: §6\u265B " + pname + " \u265B §fest maintenant Chevalier!");
										Perm.SetPerm(p);
										Checkm.closeYes(p);
										return;
									} else Checkm.closeNo(p);

								}

							}
							

						}
						
						
						
						
						
						//heros
						if (e.getSlot() == 11) {

							if (e.getClick().isLeftClick()) {

								if (grade.contains("heros")) {
									p.sendMessage("§cVous avez déjà ce grade! Attendez son expiration pour renouveler.");
									Checkm.closeNo(p);
									return;
								} else {
									if (Checkm.CheckAll(p, 50000, 1100, 60, true)) {
										Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(),"perm player " + pname + " setgroup heros 90d");
										Bukkit.broadcastMessage("§4F§6é§2l§bi§1c§di§ft§8a§ct§ei§a§3o§9n: §6\u265B " + pname + " \u265B §fest maintenant Heros!");
										Perm.SetPerm(p);
										Checkm.closeYes(p);
										return;
									} else Checkm.closeNo(p);

								}

							}

							if (e.getClick().isRightClick()) {

								if (grade.contains("heros")) {
									p.sendMessage("§cVous avez déjà ce grade! Attendez son expiration pour renouveler.");
									Checkm.closeNo(p);
									return;
								} else {
									if (Checkm.CheckSuperCoins(p, 1400, true)) {
										Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(),"perm player " + pname + " setgroup heros 90d");
										Bukkit.broadcastMessage("§4F§6é§2l§bi§1c§di§ft§8a§ct§ei§a§3o§9n: §6\u265B " + pname + " \u265B §fest maintenant Heros!");
										Perm.SetPerm(p);
										Checkm.closeYes(p);
										return;
									} else Checkm.closeNo(p);

								}

							}
							

						}
		

	}

}
