package info.mgone.survie.gui.marchant;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MobSP implements org.bukkit.event.Listener {
	
	
	public static Inventory GUImobsp = null;
	static ItemStack currentmobspItem = null;
	static List<String> lores = new ArrayList<String>();
	Player p = null;
	String invetaryname = null;
	
	
	public static Inventory displayMobSP()
	 {
		
		
		
		return GUImobsp;
	 }

}
