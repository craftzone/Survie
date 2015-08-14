package info.mgone.survie.weapon;

import java.util.List;

import mkremins.fanciful.FancyMessage;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class WeapeonLvL implements Listener {
	
	Player p = null;
	
	
	@EventHandler(priority=EventPriority.MONITOR)
	  public void guiClickanvil(InventoryClickEvent e) {
		
		
		p = ((Player)e.getWhoClicked());
		 if(e.getInventory().getType() != InventoryType.ANVIL) return;
				 
			ItemStack item3 = e.getCurrentItem();
			if(item3 == null) return;
			if(!item3.hasItemMeta()) return;
			
			ItemMeta meta = item3.getItemMeta();
			if(meta.hasLore()) {
				
				e.setCancelled(true);
				p.sendMessage("§cCet item est irréparable");
				p.closeInventory();
				p.updateInventory();
				return;

			}

		 } 
	
	@EventHandler(priority=EventPriority.MONITOR)
	  public void guiClickenchant(InventoryClickEvent e) {
		
		
		p = ((Player)e.getWhoClicked());
		 if(e.getInventory().getType() != InventoryType.ENCHANTING) return;
				 
			ItemStack item3 = e.getCurrentItem();
			if(item3 == null) return;
			if(!item3.hasItemMeta()) return;
			
			ItemMeta meta = item3.getItemMeta();
			if(meta.hasLore()) {
				
				e.setCancelled(true);
				p.sendMessage("§cVous ne pouvez pas enchanter cet item!");
				p.closeInventory();
				p.updateInventory();
				return;

			}

		 } 
	
	
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event)
	{
		
		   Player pmort =  event.getEntity().getPlayer();
		   String npmort = pmort.getName();
		   
		   if ((event.getEntity().getPlayer().getKiller() instanceof Player) && !(event.getEntity().getKiller().hasMetadata("NPC")))
			 { 

				Player player = event.getEntity().getPlayer().getKiller();
				String nkiller = player.getName();
				ItemStack itemStack = player.getItemInHand();

			    if (itemStack == null || itemStack.getTypeId() == 0 || itemStack.getAmount() > 1) return;
			    if(!IsWeapon(itemStack)) return;
			    
			    if(!itemStack.hasItemMeta()) return;
			    ItemMeta meta = itemStack.getItemMeta();
			    if(!meta.hasLore()) return;
			    String Desc = meta.getDisplayName() + "\n";
			    List<String> loretlist = meta.getLore();
			    for( String s : loretlist ) {
			    	Desc = Desc + s + "\n";
					}
			    
			    for (Player pe : Bukkit.getOnlinePlayers()) new FancyMessage("§7*" + nkiller + " §c§l\u2694 §7" + npmort).then(" §f\u2620 §7[" + meta.getDisplayName() + "§7]").tooltip(Desc).send(pe);
			
			    //Bukkit.broadcastMessage("§7*" + nkiller + " §c§l\u2694 §7" + npmort + " §f\u2620 " + meta.getDisplayName());
					
			 }
	}
	
	
	
  public boolean IsWeapon(ItemStack itemStack){
		
		if(itemStack.getType() == Material.DIAMOND_SWORD) return true;
		if(itemStack.getType() == Material.IRON_SWORD) return true;
		if(itemStack.getType() == Material.DIAMOND_AXE) return true;
		
		return false;
	}
	

}
