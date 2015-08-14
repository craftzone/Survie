package info.mgone.survie.gui;

import fr.mgone.supercoins.API;
import info.mgone.survie.LoginPlayer;
import info.mgone.survie.Survie;
import info.mgone.survie.instructeur.Perm;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import me.ryanhamshire.GriefPrevention.Claim;
import me.ryanhamshire.GriefPrevention.GriefPrevention;
import me.ryanhamshire.GriefPrevention.PlayerData;
import net.sacredlabyrinth.phaed.simpleclans.ClanPlayer;
import net.sacredlabyrinth.phaed.simpleclans.SimpleClans;

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
import org.bukkit.inventory.meta.SkullMeta;

import com.gamingmesh.jobs.Jobs;
import com.gamingmesh.jobs.container.JobProgression;



public class Pmenu implements org.bukkit.event.Listener {
	
	public static Inventory GUIpmenu = null;
	static ItemStack currentpmenuItem = null;
	static List<String> lores = new ArrayList<String>();
	Player p = null;
	String invetaryname = null;
	
	
	
	public static Inventory displayPmenu(Player p, boolean retour)
	 {
		int slotp = 9;
		if(retour) slotp = 18;
		GUIpmenu = Bukkit.createInventory(null, slotp, "§5\u2663 Menu Joueur \u2663");
		
		//eco
		double balance0 = Survie.eco.getBalance(p.getName());
		double balance = Math.round(balance0 * 100D)/100D ;
		//grade
		String grade = Survie.permission.getPrimaryGroup(p);
		String prefixg = Survie.chat.getPlayerPrefix(p).replace("&", "§");
		Date expir = null;
		if(grade.contains("guerrier") || grade.contains("chevalier") || grade.contains("heros")) {
			expir = Perm.GetGrade(p);
		}
		
		
		
		//job
		List<JobProgression> jpprogress = Jobs.getPlayerManager().getJobsPlayer(p).getJobProgression();
		
		//clan
		 String mykdr;
		 ClanPlayer cp = SimpleClans.getInstance().getClanManager().getClanPlayer(p);
		 String team = "Civile";
		 if(cp != null) {
		 float kdr	= cp.getKDR();
		 double rkdr = Math.round(kdr * 100D)/100D ;
		 mykdr = String.valueOf(rkdr);
		 team = cp.getClan().getName();
		 } else mykdr = "§cVous devez rejoindre une Team d'abord"; 
		 
		 
		 
		
		 currentpmenuItem = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
	     SkullMeta meta0 = (SkullMeta) currentpmenuItem.getItemMeta();
	     meta0.setDisplayName("§6\u25C6 Grade \u25C6");
	     meta0.setOwner(p.getName());
	     lores.add(prefixg);
	     if(expir != null && grade.contains("guerrier")) {
	 	    String[] parts = expir.toString().split("-");
	 	    	lores.add("§fExpiration: §d" + parts[2] + "/" + parts[1] + "/" + parts[0]);
	 	    } else lores.add("§7Expiration: §fjamais");
	     lores.add("§7Pour voir les détails des grades");
	     lores.add("§7passez voir l'instructeur!");
	     meta0.setLore(lores);
	     currentpmenuItem.setItemMeta(meta0);
	     GUIpmenu.setItem(0,currentpmenuItem);
	     lores.clear();
		
		
	     currentpmenuItem = new ItemStack(Material.IRON_PICKAXE, 1);
	     ItemMeta meta1 = currentpmenuItem.getItemMeta();
	     meta1.setDisplayName("§5\u25C6 Jobs \u25C6");
	     if(jpprogress.size() == 0) lores.add("§cvous n'avez pas rejoint aucun job!");
	     else
	     for(JobProgression progress : jpprogress) {
	     lores.add("§7Job: " + progress.getJob().getChatColor() + "" + progress.getJob().getName() + ", §7Niveau: §f" + progress.getLevel() + ", §7EXP: §f" + progress.getExperience() +"/"+ progress.getMaxExperience());}
	     lores.add("§7Pour voir les détails des Jobs");
	     lores.add("§7passez voir le recruteur!");
	     meta1.setLore(lores);
	     currentpmenuItem.setItemMeta(meta1);
	     GUIpmenu.setItem(1,currentpmenuItem);
	     lores.clear();
	     
	     
	     
	     currentpmenuItem = new ItemStack(Material.IRON_INGOT, 1);
	     ItemMeta meta2 = currentpmenuItem.getItemMeta();
	     meta2.setDisplayName("§b\u25C6 Money $ \u25C6");
	     lores.add("§7Solde: §a" + balance + " $");
	     lores.add("§7Vous gagner de l'argent en  faisant");
	     lores.add("§7des jobs,en Tuant des joueurs...");
	     lores.add("§7Pour plus de détails regarder");
	     lores.add("§7la video tutorial!");
	     meta2.setLore(lores);
	     currentpmenuItem.setItemMeta(meta2);
	     GUIpmenu.setItem(2,currentpmenuItem);
	     lores.clear();
	     
	     
	     currentpmenuItem = new ItemStack(Material.GOLD_INGOT, 1);
	     ItemMeta meta3 = currentpmenuItem.getItemMeta();
	     meta3.setDisplayName("§e\u25C6 KDR (Kill/Mort ratio)  \u25C6");
	     lores.add("§7KDR: §a" + mykdr);
	     lores.add("§6Le KDR est la moyenne de kill/Mort.");
	     lores.add("§dEn ayant un KDR plus important vous avez");
	     lores.add("§dla chance de gagner plus d'argent, skill...");
	     lores.add("§fEn tuant un Ennemie +2Kill");
	     lores.add("§fEn tuant un Neutral +1Kill");
	     lores.add("§fEn tuant un Civile -1Kill");
	     lores.add("§fQuand quelqu'un vous tue +1Mort");
	     lores.add("§fQuand vous êtes tuer par un mob ou");
	     lores.add("§fl'envirennement la mort ne compte pas.");
	     lores.add("§bPour plus de détails regarder");
	     lores.add("§ble menu Team. §c/tm");
	     meta3.setLore(lores);
	     currentpmenuItem.setItemMeta(meta3);
	     GUIpmenu.setItem(3,currentpmenuItem);
	     lores.clear();
	     
	     
	   //claim
		 PlayerData playerData = GriefPrevention.instance.dataStore.getPlayerData(p.getUniqueId());
		 int remainingBlocks = playerData.getRemainingClaimBlocks();
		 int usedBlocks = playerData.getAccruedClaimBlocks() - remainingBlocks;
	     
	     currentpmenuItem = new ItemStack(Material.DIAMOND, 1);
	     ItemMeta meta4 = currentpmenuItem.getItemMeta();
	     meta4.setDisplayName("§9\u25C6 Points de compétence \u25C6");
	     lores.add("§7Skill: §a" + LoginPlayer.skills.get(p.getName()));
	     lores.add("§7Vous gagner des skills en  faisant");
	     lores.add("§7des jobs,et surtout en tuant des joueurs");
	     lores.add("§7et apres avoir gagné un assiègement.");
	     lores.add("§7Pour plus de détails regarder");
	     lores.add("§7la video tutorial!");
	     meta4.setLore(lores);
	     currentpmenuItem.setItemMeta(meta4);
	     GUIpmenu.setItem(4,currentpmenuItem);
	     lores.clear();
	     
	     currentpmenuItem = new ItemStack(Material.GOLD_SPADE, 1);
	     ItemMeta meta5 = currentpmenuItem.getItemMeta();
	     meta5.setDisplayName("§c\u25C6 Mes Claims \u25C6");
	     lores.add("§f-Blocks restant: §6"+ remainingBlocks);
	     lores.add("§f-Blocks utiliser: §6"+ usedBlocks);
	     for(int i = 0; i < playerData.getClaims().size(); i++)
			{
	    	 Claim claim = playerData.getClaims().get(i);
	    	 lores.add("§f-Claim" + i+1  + ": (" + claim.getArea() + ") §bX=" + claim.getLesserBoundaryCorner().getX() + " §6Y=" + claim.getLesserBoundaryCorner().getY()+ " §dZ=" + claim.getLesserBoundaryCorner().getZ());
			}
	     meta5.setLore(lores);
	     currentpmenuItem.setItemMeta(meta5);
	     GUIpmenu.setItem(5,currentpmenuItem);
	     lores.clear();
	     
	     
	     currentpmenuItem = new ItemStack(Material.DIAMOND_SWORD, 1);
	     ItemMeta meta6 = currentpmenuItem.getItemMeta();
	     meta6.setDisplayName("§2\u25C6 Team \u25C6");
	     lores.add("§7Team: §a" + team);
	     lores.add("§7vous pouvez aussi utiliser");
	     lores.add("§c/tm §7pour acceder a ce menu");
	     meta6.setLore(lores);
	     currentpmenuItem.setItemMeta(meta6);
	     GUIpmenu.setItem(6,currentpmenuItem);
	     lores.clear();
	     
	     
	     currentpmenuItem = new ItemStack(Material.EMERALD, 1);
	     ItemMeta meta8 = currentpmenuItem.getItemMeta();
	     meta8.setDisplayName("§d\u25C6 SuperCoins\u25C6");
	     lores.add("§7SuperCoins: §a" + API.getCoins(p));
	     lores.add("§7Les SuperCoins c'est une monnaie");
	     lores.add("§7achetable uniquement depuis le shop.");
	     lores.add("§cshop.craftzone.fr");
	     lores.add("§7Bientôt disponible sur le");
	     lores.add("§7reste des serveurs CraftZone.");
	     meta8.setLore(lores);
	     currentpmenuItem.setItemMeta(meta8);
	     GUIpmenu.setItem(8,currentpmenuItem);
	     lores.clear();
	     
	     
	   //wood door
	     if(retour) {
  	     currentpmenuItem = new ItemStack(Material.WOOD_DOOR, 1);
	     ItemMeta meta44 = currentpmenuItem.getItemMeta();
	     meta44.setDisplayName("§c§l\u27A1 Retour");
	     currentpmenuItem.setItemMeta(meta44);
	     GUIpmenu.setItem(17,currentpmenuItem);
	     lores.clear(); }
	     
		
		return GUIpmenu;
	 }
	
	
	@EventHandler(priority=EventPriority.MONITOR)
	  public void guiClick(InventoryClickEvent event) {
		
		invetaryname = event.getInventory().getName();
		p = ((Player)event.getWhoClicked());
		   
		   if (!invetaryname.contains("§5\u2663 Menu Joueur \u2663")) return;
		   if ((event.getSlot() < 0) || (event.getSlot() > 53)) return;
		   event.setCancelled(true); 
		   if(event.getClick().isShiftClick()) { event.setCancelled(true); return;}
		   if(event.getSlotType() != InventoryType.SlotType.CONTAINER) { p.closeInventory(); return;}
		   
		   
		   if (event.getSlot() == 6)
		   {
			   ClanPlayer cp = SimpleClans.getInstance().getClanManager().getClanPlayer(p);
			   if(cp == null) {
				  p.sendMessage("§cVous n'avez pas encore de Team!");
				   p.closeInventory();
				   return;
			   } else {
			   p.closeInventory();
			   p.openInventory(net.sacredlabyrinth.phaed.simpleclans.menu.Menu.displayMenu(p,true));
			   return;
			   }
			   
		   }
		   
		   if (event.getSlot() == 17)
		   {
			   p.closeInventory();
			   p.openInventory(Menu.displayMenu());
			   event.setCancelled(true);
			   return;
		   }

		
	}

}
