package info.mgone.survie.xpbank;

import info.mgone.survie.Survie;
import info.mgone.survie.utility;
import info.mgone.survie.crate.LootChest;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ExpBottleEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;







import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;


public class ExpBottle implements org.bukkit.event.Listener {
	
	
	static World worldc = Bukkit.getWorld("world");
	static Location loc0 = new Location(worldc,-44,75,-52,0,0);
	static Location loc0h = new Location(worldc,-44,75,-52,0,0);
	
	static Location loc1 = new Location(worldc,-44,75,-38,0,0);
	static Location loc1h = new Location(worldc,-44,75,-38,0,0);
	
	public static void ExpBanque() {
		
		Hologram hb0 = HologramsAPI.createHologram(Survie.plugin, loc0h.add(0.5, 2.3,0.5));
		hb0.appendTextLine("§b\u2618 §b§lBanque d'exp §b\u2618");
		hb0.appendItemLine(new ItemStack(Material.EXP_BOTTLE));
		
		Hologram hb1 = HologramsAPI.createHologram(Survie.plugin, loc1h.add(0.5, 2.3,0.5));
		hb1.appendTextLine("§b\u2618 §b§lBanque d'exp §b\u2618");
		hb1.appendItemLine(new ItemStack(Material.EXP_BOTTLE));
		
	}
	
	

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {

		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			Block b = e.getClickedBlock();
			if(b.getType() != Material.MOB_SPAWNER) return;
			Location locb = b.getLocation();
			Player p = e.getPlayer();
			if (!locb.equals(loc0) && !locb.equals(loc1)) return;
			if (p.getItemInHand().getType() != Material.GLASS_BOTTLE) {
				utility.sendActionBar(p, "§5§l\u2716 Vous devez avoir au moins une bouteille vide dans votre main! \u2716"); 
				if(locb.equals(loc0)) LootChest.pushBack(loc0, p);
				else if(locb.equals(loc1)) LootChest.pushBack(loc1, p);
				return; 
				}
			int exp =  SetExpFix.getTotalExperience(p);
			
			
			if(exp <5) {
				utility.sendActionBar(p, "§5§l\u2716 Vous n'avez pas assez d'exp pour stocker! \u2716");
				if(locb.equals(loc0)) LootChest.pushBack(loc0, p);
				else if(locb.equals(loc1)) LootChest.pushBack(loc1, p);
				return; 
				}
			
			SetExpFix.setTotalExperience(p,exp-5);
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.EXP_BOTTLE) });
			int amount = p.getInventory().getItemInHand().getAmount();
			amount--;
			if (amount == 0) p.getInventory().removeItem(new ItemStack(Material.GLASS_BOTTLE));
			else p.getInventory().getItemInHand().setAmount(amount);
			p.updateInventory();
			

		}
	}
	
	
	
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onExpBottle(ExpBottleEvent e) {
		e.setExperience(5);
		//ThrownExpBottle bottle=e.getEntity();
		//ProjectileSource shooter=bottle.getShooter();
		//Player player=(Player)shooter;
		//UUID uuid = e.getEntity().getUniqueId();
		//ProjectileLaunchEvent projectile instanceof ThrownExpBottle getItemInHand
		}
	
	
	

}
