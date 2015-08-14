package info.mgone.survie.gui.AttributesLore;

import info.mgone.survie.Glow;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.server.v1_8_R1.NBTTagCompound;
import net.minecraft.server.v1_8_R1.NBTTagList;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemLores {
	
	static List<String> lores = new ArrayList<String>();
	
	
	public static ItemStack FreeClose() {
	    ItemStack item = new ItemStack(Material.IRON_DOOR, 1);
	    ItemMeta meta = item.getItemMeta();
	    meta.setDisplayName("§4\u2716 Fermer");
	    item.setItemMeta(meta);
	    return item;
	  }
	
	public static ItemStack FreeRetour() {
	    ItemStack item = new ItemStack(Material.WOOD_DOOR, 1);
	    ItemMeta meta = item.getItemMeta();
	    meta.setDisplayName("§c\u27A1 Retour");
	    item.setItemMeta(meta);
	    return item;
	  }
	
	
	public static ItemStack FreeName(Material material, int amount, int shrt,String name) {
	    ItemStack item = new ItemStack(material, amount, (short)shrt);
	    ItemMeta meta = item.getItemMeta();
	    if(name != null) meta.setDisplayName(name);
	    item.setItemMeta(meta);
	    return item;
	  }
	
	
	public static ItemStack FreeLore(Material material, int amount, int shrt,String name, String lore1) {
	    ItemStack item = new ItemStack(material, amount, (short)shrt);
	    ItemMeta meta = item.getItemMeta();
	    if(name != null) meta.setDisplayName(name);
	    if(lore1 != null) lores.add(lore1);
	    meta.setLore(lores);
	    item.setItemMeta(meta);
	    lores.clear();
	    return item;
	  }
	
	
	public static ItemStack FreeLore(Material material, int amount, int shrt,String name, String lore1, String lore2) {
	    ItemStack item = new ItemStack(material, amount, (short)shrt);
	    ItemMeta meta = item.getItemMeta();
	    if(name != null) meta.setDisplayName(name);
	    if(lore1 != null) lores.add(lore1);
	    if(lore2 != null) lores.add(lore2);
	    meta.setLore(lores);
	    item.setItemMeta(meta);
	    lores.clear();
	    return item;
	  }
	
	public static ItemStack FreeLore(Material material, int amount, int shrt,String name, String lore1, String lore2, String lore3) {
	    ItemStack item = new ItemStack(material, amount, (short)shrt);
	    ItemMeta meta = item.getItemMeta();
	    if(name != null) meta.setDisplayName(name);
	    if(lore1 != null) lores.add(lore1);
	    if(lore2 != null) lores.add(lore2);
	    if(lore3 != null) lores.add(lore3);
	    meta.setLore(lores);
	    item.setItemMeta(meta);
	    lores.clear();
	    return item;
	  }
	
	
	public static ItemStack FreeLore(Material material, int amount, int shrt,String name, String lore1, String lore2, String lore3, String lore4) {
	    ItemStack item = new ItemStack(material, amount, (short)shrt);
	    ItemMeta meta = item.getItemMeta();
	    if(name != null) meta.setDisplayName(name);
	    if(lore1 != null) lores.add(lore1);
	    if(lore2 != null) lores.add(lore2);
	    if(lore3 != null) lores.add(lore3);
	    if(lore4 != null) lores.add(lore4);
	    meta.setLore(lores);
	    item.setItemMeta(meta);
	    lores.clear();
	    return item;
	  }
	
	
	public static ItemStack FreeLore(Material material, int amount, int shrt,String name, String lore1, String lore2, String lore3, String lore4, String lore5) {
	    ItemStack item = new ItemStack(material, amount, (short)shrt);
	    ItemMeta meta = item.getItemMeta();
	    if(name != null) meta.setDisplayName(name);
	    if(lore1 != null) lores.add(lore1);
	    if(lore2 != null) lores.add(lore2);
	    if(lore3 != null) lores.add(lore3);
	    if(lore4 != null) lores.add(lore4);
	    if(lore5 != null) lores.add(lore5);
	    meta.setLore(lores);
	    item.setItemMeta(meta);
	    lores.clear();
	    return item;
	  }
	
	
	public static ItemStack FreeLore(Material material, int amount, int shrt,String name, String lore1, String lore2, String lore3, String lore4, String lore5, String lore6) {
	    ItemStack item = new ItemStack(material, amount, (short)shrt);
	    ItemMeta meta = item.getItemMeta();
	    if(name != null) meta.setDisplayName(name);
	    if(lore1 != null) lores.add(lore1);
	    if(lore2 != null) lores.add(lore2);
	    if(lore3 != null) lores.add(lore3);
	    if(lore4 != null) lores.add(lore4);
	    if(lore5 != null) lores.add(lore5);
	    if(lore6 != null) lores.add(lore6);
	    meta.setLore(lores);
	    item.setItemMeta(meta);
	    lores.clear();
	    return item;
	  }
	
	
	
	public static ItemStack FreeLore(Material material, int amount, int shrt,String name, String lore1, String lore2, String lore3, String lore4, String lore5, String lore6, String lore7) {
	    ItemStack item = new ItemStack(material, amount, (short)shrt);
	    ItemMeta meta = item.getItemMeta();
	    if(name != null) meta.setDisplayName(name);
	    if(lore1 != null) lores.add(lore1);
	    if(lore2 != null) lores.add(lore2);
	    if(lore3 != null) lores.add(lore3);
	    if(lore4 != null) lores.add(lore4);
	    if(lore5 != null) lores.add(lore5);
	    if(lore6 != null) lores.add(lore6);
	    if(lore7 != null) lores.add(lore7);
	    meta.setLore(lores);
	    item.setItemMeta(meta);
	    lores.clear();
	    return item;
	  }
	
	
	public static ItemStack FreeLore(Material material, int amount, int shrt,String name, String lore1, String lore2, String lore3, String lore4, String lore5, String lore6, String lore7, String lore8) {
	    ItemStack item = new ItemStack(material, amount, (short)shrt);
	    ItemMeta meta = item.getItemMeta();
	    if(name != null) meta.setDisplayName(name);
	    if(lore1 != null) lores.add(lore1);
	    if(lore2 != null) lores.add(lore2);
	    if(lore3 != null) lores.add(lore3);
	    if(lore4 != null) lores.add(lore4);
	    if(lore5 != null) lores.add(lore5);
	    if(lore6 != null) lores.add(lore6);
	    if(lore7 != null) lores.add(lore7);
	    if(lore8 != null) lores.add(lore8);
	    meta.setLore(lores);
	    item.setItemMeta(meta);
	    lores.clear();
	    return item;
	  }
	
	
	
	public static ItemStack FreeLore(Material material, int amount, int shrt,String name, String lore1, String lore2, String lore3, String lore4, String lore5, String lore6, String lore7, String lore8, String lore9) {
	    ItemStack item = new ItemStack(material, amount, (short)shrt);
	    ItemMeta meta = item.getItemMeta();
	    if(name != null) meta.setDisplayName(name);
	    if(lore1 != null) lores.add(lore1);
	    if(lore2 != null) lores.add(lore2);
	    if(lore3 != null) lores.add(lore3);
	    if(lore4 != null) lores.add(lore4);
	    if(lore5 != null) lores.add(lore5);
	    if(lore6 != null) lores.add(lore6);
	    if(lore7 != null) lores.add(lore7);
	    if(lore8 != null) lores.add(lore8);
	    if(lore9 != null) lores.add(lore9);
	    meta.setLore(lores);
	    item.setItemMeta(meta);
	    lores.clear();
	    return item;
	  }
	
	
	
	public static ItemStack FreeLore(Material material, int amount, int shrt,String name, String lore1, String lore2, String lore3, String lore4, String lore5, String lore6, String lore7, String lore8, String lore9, String lore10) {
	    ItemStack item = new ItemStack(material, amount, (short)shrt);
	    ItemMeta meta = item.getItemMeta();
	    if(name != null) meta.setDisplayName(name);
	    if(lore1 != null) lores.add(lore1);
	    if(lore2 != null) lores.add(lore2);
	    if(lore3 != null) lores.add(lore3);
	    if(lore4 != null) lores.add(lore4);
	    if(lore5 != null) lores.add(lore5);
	    if(lore6 != null) lores.add(lore6);
	    if(lore7 != null) lores.add(lore7);
	    if(lore8 != null) lores.add(lore8);
	    if(lore9 != null) lores.add(lore9);
	    if(lore10 != null) lores.add(lore10);
	    meta.setLore(lores);
	    item.setItemMeta(meta);
	    lores.clear();
	    return item;
	  }
	
	
	public static ItemStack FreeLore(Material material, int amount, int shrt,String name, String lore1, String lore2, String lore3, String lore4, String lore5, String lore6, String lore7, String lore8, String lore9, String lore10, String lore11) {
	    ItemStack item = new ItemStack(material, amount, (short)shrt);
	    ItemMeta meta = item.getItemMeta();
	    if(name != null) meta.setDisplayName(name);
	    if(lore1 != null) lores.add(lore1);
	    if(lore2 != null) lores.add(lore2);
	    if(lore3 != null) lores.add(lore3);
	    if(lore4 != null) lores.add(lore4);
	    if(lore5 != null) lores.add(lore5);
	    if(lore6 != null) lores.add(lore6);
	    if(lore7 != null) lores.add(lore7);
	    if(lore8 != null) lores.add(lore8);
	    if(lore9 != null) lores.add(lore9);
	    if(lore10 != null) lores.add(lore10);
	    if(lore11 != null) lores.add(lore11);
	    meta.setLore(lores);
	    item.setItemMeta(meta);
	    lores.clear();
	    return item;
	  }
	
	
	public static ItemStack FreeLore(Material material, int amount, int shrt,String name, String lore1, String lore2, String lore3, String lore4, String lore5, String lore6, String lore7, String lore8, String lore9, String lore10, String lore11, String lore12) {
	    ItemStack item = new ItemStack(material, amount, (short)shrt);
	    ItemMeta meta = item.getItemMeta();
	    if(name != null) meta.setDisplayName(name);
	    if(lore1 != null) lores.add(lore1);
	    if(lore2 != null) lores.add(lore2);
	    if(lore3 != null) lores.add(lore3);
	    if(lore4 != null) lores.add(lore4);
	    if(lore5 != null) lores.add(lore5);
	    if(lore6 != null) lores.add(lore6);
	    if(lore7 != null) lores.add(lore7);
	    if(lore8 != null) lores.add(lore8);
	    if(lore9 != null) lores.add(lore9);
	    if(lore10 != null) lores.add(lore10);
	    if(lore11 != null) lores.add(lore11);
	    if(lore12 != null) lores.add(lore12);
	    meta.setLore(lores);
	    item.setItemMeta(meta);
	    lores.clear();
	    return item;
	  }


	public static ItemStack Free(Material material, int amount, int shrt) {
	    ItemStack item = new ItemStack(material, amount, (short)shrt);
	    ItemMeta meta = item.getItemMeta();
	    item.setItemMeta(meta);
	    return item;
	  }
	
	
	public static ItemStack removeAttributes(ItemStack item) {
		
	    if(item == null) {
	        return item;
	    }
	    
	    net.minecraft.server.v1_8_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
	    
	    if (nmsStack == null) return item;
	    
	    NBTTagCompound tag;
	    if (!nmsStack.hasTag()){
	        tag = new NBTTagCompound();
	        nmsStack.setTag(tag);
	    }
	    else {
	        tag = nmsStack.getTag();
	    }
	    NBTTagList am = new NBTTagList();
	    tag.set("AttributeModifiers", am);
	    tag.remove("AttributeModifiers");
	    nmsStack.setTag(tag);
	    return CraftItemStack.asCraftMirror(nmsStack); 
	    
	} 


	public static ItemStack addGlow(ItemStack item) {
	/*	net.minecraft.server.v1_8_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
		NBTTagCompound tag = null;
		if (!nmsStack.hasTag()) {
			tag = new NBTTagCompound();
			nmsStack.setTag(tag);
		}
		if (tag == null) tag = nmsStack.getTag();
		NBTTagList ench = new NBTTagList();
		tag.set("ench", ench);
		nmsStack.setTag(tag);
		return CraftItemStack.asCraftMirror(nmsStack); */
		
		ItemMeta item1 = item.getItemMeta();
		item1.addEnchant(Glow.glow, 1, false);
		item.setItemMeta(item1);
		
		return item;
	}

	/**
	 * Removes the glow.
	 * 
	 * @param item
	 *            the item
	 * @return the item stack
	 */
	public static ItemStack removeGlow(ItemStack item) {
		/*net.minecraft.server.v1_8_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
		NBTTagCompound tag = null;
		if (!nmsStack.hasTag()) return item;
		tag = nmsStack.getTag();
		tag.set("ench", null);
		nmsStack.setTag(tag);
		return CraftItemStack.asCraftMirror(nmsStack); */
		
		ItemMeta item1 = item.getItemMeta();
		item1.removeEnchant(Glow.glow);
		item.setItemMeta(item1);
		
		return item;
	}

}
