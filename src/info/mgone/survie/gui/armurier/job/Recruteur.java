package info.mgone.survie.gui.armurier.job;

import info.mgone.survie.gui.AttributesLore.ItemLores;
import info.mgone.survie.noob.NoobPvP;

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

import com.gamingmesh.jobs.Jobs;
import com.gamingmesh.jobs.container.Job;
import com.gamingmesh.jobs.container.JobsPlayer;

public class Recruteur implements org.bukkit.event.Listener {
	
	
	public static Inventory GUIrecruteur = null;
	static ItemStack currentrecruteur1Item = null;
	static List<String> lores = new ArrayList<String>();
	Player p = null;
	String invetaryname = null;
	
	
	public static Inventory displayRecruteur(Player p)
	 {
		GUIrecruteur = Bukkit.createInventory(p, 18, "§6\u2663 Jobs \u2663");
		JobsPlayer jPlayer = Jobs.getPlayerManager().getJobsPlayer(p);
		

	    Job bucheron = Jobs.getJob("Bucheron");
	    Job mineur = Jobs.getJob("Mineur");
	    Job fermier = Jobs.getJob("Fermier");
	    Job chasseur = Jobs.getJob("Chasseur");
	    Job pecheur = Jobs.getJob("Pecheur");
	    Job forgeron = Jobs.getJob("Forgeron");
	    Job menuisier = Jobs.getJob("Menuisier");
	    Job redstoneur = Jobs.getJob("Redstoneur");
	    Job alchimiste = Jobs.getJob("Alchimiste");
	    Job enchanteur = Jobs.getJob("Enchanteur");
	    Job assassin = Jobs.getJob("Assassin");
	    
	    
	    if (jPlayer.isInJob(bucheron)) 
		GUIrecruteur.setItem(0, ItemLores.addGlow(ItemLores.FreeLore(Material.IRON_AXE, 1, 0, "§a\u2606 Bucheron",
				"§7Niveau: §f" + jPlayer.getJobProgression(bucheron).getLevel(),
				"§7EXP: §f" + Math.round(jPlayer.getJobProgression(bucheron).getExperience()* 100D)/100D + "/" + jPlayer.getJobProgression(bucheron).getMaxExperience(),
				" ",
				"§7Clic Gauche: §c\u2612 Quitter ce job",
	    		"§7Clic Droit: §e\u2600 Détails sur le job")));
	    else
	    GUIrecruteur.setItem(0,ItemLores.FreeLore(Material.IRON_AXE, 1, 0,"§a\u2606 Bucheron",
	    		"§fVous gagnez de l'argent en", "§fcoupant et en replantant des arbres.",
	    		"",
	    		"§7Clic Gauche: §2\u2611 Rejoindre ce job",
	    		"§7Clic Droit: §e\u2600 Détails sur le job"));
	    
	    
	    
	    
	    if (jPlayer.isInJob(mineur)) 
			GUIrecruteur.setItem(1, ItemLores.addGlow(ItemLores.FreeLore(Material.IRON_PICKAXE, 1, 0, "§6\u2606 Mineur",
					"§7Niveau: §f" + jPlayer.getJobProgression(mineur).getLevel(),
					"§7EXP: §f" + Math.round(jPlayer.getJobProgression(mineur).getExperience()* 100D)/100D + "/" + jPlayer.getJobProgression(mineur).getMaxExperience(),
					" ",
					"§7Clic Gauche: §c\u2612 Quitter ce job",
		    		"§7Clic Droit: §e\u2600 Détails sur le job")));
		    else
		    GUIrecruteur.setItem(1,ItemLores.FreeLore(Material.IRON_PICKAXE, 1, 0,"§6\u2606 Mineur",
		    		"§fVous gagnez de l'argent en minant", "§fdes mineraux et des filons de minerais.",
		    		"",
		    		"§7Clic Gauche: §2\u2611 Rejoindre ce job",
		    		"§7Clic Droit: §e\u2600 Détails sur le job"));
	    
	    
	    
	    if (jPlayer.isInJob(fermier)) 
			GUIrecruteur.setItem(2, ItemLores.addGlow(ItemLores.FreeLore(Material.WHEAT, 1, 0, "§9\u2606 Fermier",
					"§7Niveau: §f" + jPlayer.getJobProgression(fermier).getLevel(),
					"§7EXP: §f" + Math.round(jPlayer.getJobProgression(fermier).getExperience()* 100D)/100D + "/" + jPlayer.getJobProgression(fermier).getMaxExperience(),
					" ",
					"§7Clic Gauche: §c\u2612 Quitter ce job",
		    		"§7Clic Droit: §e\u2600 Détails sur le job")));
		    else
		    GUIrecruteur.setItem(2,ItemLores.FreeLore(Material.WHEAT, 1, 0,"§9\u2606 Fermier",
		    		"§fVous gagnez de l'argent", "§fen cultivant.",
		    		"",
		    		"§7Clic Gauche: §2\u2611 Rejoindre ce job",
		    		"§7Clic Droit: §e\u2600 Détails sur le job"));
	    
	    
	    
	    
	    if (jPlayer.isInJob(chasseur)) 
			GUIrecruteur.setItem(3, ItemLores.addGlow(ItemLores.FreeLore(Material.BOW, 1, 0, "§c\u2606 Chasseur",
					"§7Niveau: §f" + jPlayer.getJobProgression(chasseur).getLevel(),
					"§7EXP: §f" + Math.round(jPlayer.getJobProgression(chasseur).getExperience()* 100D)/100D + "/" + jPlayer.getJobProgression(chasseur).getMaxExperience(),
					" ",
					"§7Clic Gauche: §c\u2612 Quitter ce job",
		    		"§7Clic Droit: §e\u2600 Détails sur le job")));
		    else
		    GUIrecruteur.setItem(3,ItemLores.FreeLore(Material.BOW, 1, 0,"§c\u2606 Chasseur",
		    		"§fVous gagnez de l'argent en", "§ftuant des animaux et des monstres.",
		    		"",
		    		"§7Clic Gauche: §2\u2611 Rejoindre ce job",
		    		"§7Clic Droit: §e\u2600 Détails sur le job"));
	    
	    
	    
	    
	    if (jPlayer.isInJob(pecheur)) 
			GUIrecruteur.setItem(4, ItemLores.addGlow(ItemLores.FreeLore(Material.RAW_FISH, 1, 0, "§b\u2606 Pêcheur",
					"§7Niveau: §f" + jPlayer.getJobProgression(pecheur).getLevel(),
					"§7EXP: §f" + Math.round(jPlayer.getJobProgression(pecheur).getExperience()* 100D)/100D + "/" + jPlayer.getJobProgression(pecheur).getMaxExperience(),
					" ",
					"§7Clic Gauche: §c\u2612 Quitter ce job",
		    		"§7Clic Droit: §e\u2600 Détails sur le job")));
		    else
		    GUIrecruteur.setItem(4,ItemLores.FreeLore(Material.RAW_FISH, 1, 0,"§b\u2606 Pêcheur",
		    		"§fVous gagnez de l'argent", "§fen pechant.",
		    		"",
		    		"§7Clic Gauche: §2\u2611 Rejoindre ce job",
		    		"§7Clic Droit: §e\u2600 Détails sur le job"));
	    
	    
	    
	    
	    if (jPlayer.isInJob(forgeron)) 
			GUIrecruteur.setItem(5, ItemLores.addGlow(ItemLores.FreeLore(Material.ANVIL, 1, 0, "§5\u2606 Forgeron",
					"§7Niveau: §f" + jPlayer.getJobProgression(forgeron).getLevel(),
					"§7EXP: §f" + Math.round(jPlayer.getJobProgression(forgeron).getExperience()* 100D)/100D + "/" + jPlayer.getJobProgression(forgeron).getMaxExperience(),
					" ",
					"§7Clic Gauche: §c\u2612 Quitter ce job",
		    		"§7Clic Droit: §e\u2600 Détails sur le job")));
		    else
		    GUIrecruteur.setItem(5,ItemLores.FreeLore(Material.ANVIL, 1, 0,"§5\u2606 Forgeron",
		    		"§fVous gagnez de l'argent en forgeant", "§fet en reparant des armes et des armures.",
		    		"",
		    		"§7Clic Gauche: §2\u2611 Rejoindre ce job",
		    		"§7Clic Droit: §e\u2600 Détails sur le job"));
	    
	    
	    
	    if (jPlayer.isInJob(menuisier)) 
			GUIrecruteur.setItem(6, ItemLores.addGlow(ItemLores.FreeLore(Material.WORKBENCH, 1, 0, "§f\u2606 Menuisier",
					"§7Niveau: §f" + jPlayer.getJobProgression(menuisier).getLevel(),
					"§7EXP: §f" + Math.round(jPlayer.getJobProgression(menuisier).getExperience()* 100D)/100D + "/" + jPlayer.getJobProgression(menuisier).getMaxExperience(),
					" ",
					"§7Clic Gauche: §c\u2612 Quitter ce job",
		    		"§7Clic Droit: §e\u2600 Détails sur le job")));
		    else
		    GUIrecruteur.setItem(6,ItemLores.FreeLore(Material.WORKBENCH, 1, 0,"§f\u2606 Menuisier",
		    		"§fVous gagnez de l'argent en", "§fcraftant des items en bois.",
		    		"",
		    		"§7Clic Gauche: §2\u2611 Rejoindre ce job",
		    		"§7Clic Droit: §e\u2600 Détails sur le job"));
	    
	    
	    
	    
	    if (jPlayer.isInJob(redstoneur)) 
			GUIrecruteur.setItem(7, ItemLores.addGlow(ItemLores.FreeLore(Material.REDSTONE, 1, 0, "§7\u2606 Redstoneur",
					"§7Niveau: §f" + jPlayer.getJobProgression(redstoneur).getLevel(),
					"§7EXP: §f" + Math.round(jPlayer.getJobProgression(redstoneur).getExperience()* 100D)/100D + "/" + jPlayer.getJobProgression(redstoneur).getMaxExperience(),
					" ",
					"§7Clic Gauche: §c\u2612 Quitter ce job",
		    		"§7Clic Droit: §e\u2600 Détails sur le job")));
		    else
		    GUIrecruteur.setItem(7,ItemLores.FreeLore(Material.REDSTONE, 1, 0,"§7\u2606 Redstoneur",
		    		"§fVous gagnez de l'argent en", "§fcreant des circuits de redstone.",
		    		"",
		    		"§7Clic Gauche: §2\u2611 Rejoindre ce job",
		    		"§7Clic Droit: §e\u2600 Détails sur le job"));
	    
	    
	    
	    
	    
	    if (jPlayer.isInJob(alchimiste)) 
			GUIrecruteur.setItem(8, ItemLores.addGlow(ItemLores.FreeLore(Material.POTION, 1, 0, "§d\u2606 Alchimiste",
					"§7Niveau: §f" + jPlayer.getJobProgression(alchimiste).getLevel(),
					"§7EXP: §f" + Math.round(jPlayer.getJobProgression(alchimiste).getExperience()* 100D)/100D + "/" + jPlayer.getJobProgression(alchimiste).getMaxExperience(),
					" ",
					"§7Clic Gauche: §c\u2612 Quitter ce job",
		    		"§7Clic Droit: §e\u2600 Détails sur le job")));
		    else
		    GUIrecruteur.setItem(8,ItemLores.FreeLore(Material.POTION, 1, 0,"§d\u2606 Alchimiste",
		    		"§fVous gagnez de l'argent en", "§ffabriquant des potions.",
		    		"",
		    		"§7Clic Gauche: §2\u2611 Rejoindre ce job",
		    		"§7Clic Droit: §e\u2600 Détails sur le job"));
	    
	    
	    
	    
	    if (jPlayer.isInJob(enchanteur)) 
			GUIrecruteur.setItem(9, ItemLores.addGlow(ItemLores.FreeLore(Material.ENCHANTMENT_TABLE, 1, 0, "§1\u2606 Enchanteur",
					"§7Niveau: §f" + jPlayer.getJobProgression(enchanteur).getLevel(),
					"§7EXP: §f" + Math.round(jPlayer.getJobProgression(enchanteur).getExperience()* 100D)/100D + "/" + jPlayer.getJobProgression(enchanteur).getMaxExperience(),
					" ",
					"§7Clic Gauche: §c\u2612 Quitter ce job",
		    		"§7Clic Droit: §e\u2600 Détails sur le job")));
		    else
		    GUIrecruteur.setItem(9,ItemLores.FreeLore(Material.ENCHANTMENT_TABLE, 1, 0,"§1\u2606 Enchanteur",
		    		"§fVous gagnez de l'argent en", "§fenchantant des armes et des armures.",
		    		"",
		    		"§7Clic Gauche: §2\u2611 Rejoindre ce job",
		    		"§7Clic Droit: §e\u2600 Détails sur le job"));
	    
	    
	    
	    
	    
	    if (jPlayer.isInJob(assassin)) 
			GUIrecruteur.setItem(10, ItemLores.addGlow(ItemLores.FreeLore(Material.DIAMOND_SWORD, 1, 0, "§e\u2606 Assassin",
					"§7Niveau: §f" + jPlayer.getJobProgression(assassin).getLevel(),
					"§7EXP: §f" + Math.round(jPlayer.getJobProgression(assassin).getExperience()* 100D)/100D + "/" + jPlayer.getJobProgression(assassin).getMaxExperience(),
					" ",
					"§7Clic Gauche: §c\u2612 Quitter ce job",
		    		"§7Clic Droit: §e\u2600 Détails sur le job")));
		    else
		    GUIrecruteur.setItem(10,ItemLores.FreeLore(Material.DIAMOND_SWORD, 1, 0,"§e\u2606 Assassin",
		    		"§fVous gagnez de l'argent en", "§ftuant des joueurs.",
		    		"",
		    		"§7Clic Gauche: §2\u2611 Rejoindre ce job",
		    		"§7Clic Droit: §e\u2600 Détails sur le job"));
	    
	    
	    
	    GUIrecruteur.setItem(17,ItemLores.FreeLore(Material.PAPER, 1, 0,"§b\u2606 Infos Jobs",
	    		"§c-§fLorsque vous exercez un métier",
	    		"§fvous gagnez de l'argent mais aussi",
	    		"§fde l'xp métier qui vous permet de",
	    		"§fmonter vos niveaux de métier.",
	    		"§c-§7En augmentant vos niveaux vous",
	    		"§7gagnerez ainsi plus d'argent que",
	    		"§7si vous étiez au niveau précédent.",
	    		"§c-§fIl vous est possible d'avoir",
	    		" §fjusqu'à 2 jobs simultanément",
	    		"§c-§7Lorsque vous abandonner un job",
	    		"§7vous perdez tout vos niveaux.",
	    		"§c/p ou /s: §fpour voir vos stats"));
	    
	    
	    
		return GUIrecruteur;
	 }
	
	
	
	@EventHandler(priority=EventPriority.MONITOR)
	  public void guiClick(InventoryClickEvent e) {
		
		invetaryname = e.getInventory().getName();
		p = ((Player)e.getWhoClicked());
		   
		   if (!invetaryname.contains("§6\u2663 Jobs \u2663")) return;
		   if ((e.getSlot() < 0) || (e.getSlot() > 53)) return;
		   e.setCancelled(true); 
		   if(e.getSlotType() != InventoryType.SlotType.CONTAINER) { p.closeInventory(); return;}
		   
		   JobsPlayer jPlayer = Jobs.getPlayerManager().getJobsPlayer(p);
		    Job bucheron = Jobs.getJob("Bucheron");
		    Job mineur = Jobs.getJob("Mineur");
		    Job fermier = Jobs.getJob("Fermier");
		    Job chasseur = Jobs.getJob("Chasseur");
		    Job pecheur = Jobs.getJob("Pecheur");
		    Job forgeron = Jobs.getJob("Forgeron");
		    Job menuisier = Jobs.getJob("Menuisier");
		    Job redstoneur = Jobs.getJob("Redstoneur");
		    Job alchimiste = Jobs.getJob("Alchimiste");
		    Job enchanteur = Jobs.getJob("Enchanteur");
		    Job assassin = Jobs.getJob("Assassin");
		
		
		   if (e.getSlot() == 0)
		   {
               if(e.getClick().isLeftClick()) {
            	   if (jPlayer.isInJob(bucheron)) p.performCommand("jobs leave Bucheron");
            	   else p.performCommand("jobs join Bucheron");
            	   p.closeInventory();
			   }
			   
			   if(e.getClick().isRightClick()) {
				   p.performCommand("jobs info Bucheron");
				   p.closeInventory();
			   }
		   }
		   
		   
		   if (e.getSlot() == 1)
		   {
               if(e.getClick().isLeftClick()) {
            	   if (jPlayer.isInJob(mineur)) p.performCommand("jobs leave Mineur");
            	   else p.performCommand("jobs join Mineur");
            	   p.closeInventory();
			   }
			   
			   if(e.getClick().isRightClick()) {
				   p.performCommand("jobs info Mineur");
				   p.closeInventory();
			   }
		   }
		   
		   
		   
		   if (e.getSlot() == 2)
		   {
               if(e.getClick().isLeftClick()) {
            	   if (jPlayer.isInJob(fermier)) p.performCommand("jobs leave Fermier");
            	   else p.performCommand("jobs join Fermier");
            	   p.closeInventory();
			   }
			   
			   if(e.getClick().isRightClick()) {
				   p.performCommand("jobs info Fermier");
				   p.closeInventory();
			   }
		   }
		   
		   
		   if (e.getSlot() == 3)
		   {
               if(e.getClick().isLeftClick()) {
            	   if (jPlayer.isInJob(chasseur)) p.performCommand("jobs leave Chasseur");
            	   else p.performCommand("jobs join Chasseur");
            	   p.closeInventory();
			   }
			   
			   if(e.getClick().isRightClick()) {
				   p.performCommand("jobs info Chasseur");
				   p.closeInventory();
			   }
		   }
		   
		   
		   if (e.getSlot() == 4)
		   {
               if(e.getClick().isLeftClick()) {
            	   if (jPlayer.isInJob(pecheur)) p.performCommand("jobs leave Pecheur");
            	   else p.performCommand("jobs join Pecheur");
            	   p.closeInventory();
			   }
			   
			   if(e.getClick().isRightClick()) {
				   p.performCommand("jobs info Pecheur");
				   p.closeInventory();
			   }
		   }
		   
		   
		   if (e.getSlot() == 5)
		   {
               if(e.getClick().isLeftClick()) {
            	   if (jPlayer.isInJob(forgeron)) p.performCommand("jobs leave Forgeron");
            	   else p.performCommand("jobs join Forgeron");
            	   p.closeInventory();
			   }
			   
			   if(e.getClick().isRightClick()) {
				   p.performCommand("jobs info Forgeron");
				   p.closeInventory();
			   }
		   }
		   
		   
		   if (e.getSlot() == 6)
		   {
               if(e.getClick().isLeftClick()) {
            	   if (jPlayer.isInJob(menuisier)) p.performCommand("jobs leave Menuisier");
            	   else p.performCommand("jobs join Menuisier");
            	   p.closeInventory();
			   }
			   
			   if(e.getClick().isRightClick()) {
				   p.performCommand("jobs info Menuisier");
				   p.closeInventory();
			   }
		   }
		   
		   
		   
		   if (e.getSlot() == 7)
		   {
               if(e.getClick().isLeftClick()) {
            	   if (jPlayer.isInJob(redstoneur)) p.performCommand("jobs leave Redstoneur");
            	   else p.performCommand("jobs join Redstoneur");
            	   p.closeInventory();
			   }
			   
			   if(e.getClick().isRightClick()) {
				   p.performCommand("jobs info Redstoneur");
				   p.closeInventory();
			   }
		   }
		
		   
		   
		   if (e.getSlot() == 8)
		   {
               if(e.getClick().isLeftClick()) {
            	   if (jPlayer.isInJob(alchimiste)) p.performCommand("jobs leave Alchimiste");
            	   else p.performCommand("jobs join Alchimiste");
            	   p.closeInventory();
			   }
			   
			   if(e.getClick().isRightClick()) {
				   p.performCommand("jobs info Alchimiste");
				   p.closeInventory();
			   }
		   }
		   
		   
		   
		   if (e.getSlot() == 9)
		   {
               if(e.getClick().isLeftClick()) {
            	   if (jPlayer.isInJob(enchanteur)) p.performCommand("jobs leave Enchanteur");
            	   else p.performCommand("jobs join Enchanteur");
            	   p.closeInventory();
			   }
			   
			   if(e.getClick().isRightClick()) {
				   p.performCommand("jobs info Enchanteur");
				   p.closeInventory();
			   }
		   }
		   
		   
		   if (e.getSlot() == 10)
		   {
               if(e.getClick().isLeftClick()) {
            	   if (jPlayer.isInJob(assassin)) p.performCommand("jobs leave Assassin");
            	   else { 
            		   if(NoobPvP.IsNoobNow(p)) p.sendMessage("§cVous avez une PVP-protection pour les nouveaux.\n"+
            	       "§aVous ne puvez pas rejoindre ce job pour l'instant!\n"+
            		   "§aPour plus de détails tapez §b/pvp");
            		   else p.performCommand("jobs join Assassin");
            	   }
            	   p.closeInventory();
			   }
			   
			   if(e.getClick().isRightClick()) {
				   p.performCommand("jobs info Assassin");
				   p.closeInventory();
			   }
		   }
		   
		
	}
		
		
	

}
