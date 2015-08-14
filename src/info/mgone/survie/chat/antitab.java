package info.mgone.survie.chat;

import info.mgone.survie.Survie;
import io.netty.buffer.Unpooled;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.reflect.FieldAccessException;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.minecraft.server.v1_8_R1.ContainerMerchant;
import net.minecraft.server.v1_8_R1.EntityPlayer;
import net.minecraft.server.v1_8_R1.IMerchant;
import net.minecraft.server.v1_8_R1.MerchantRecipe;
import net.minecraft.server.v1_8_R1.MerchantRecipeList;
import net.minecraft.server.v1_8_R1.NBTTagCompound;
import net.minecraft.server.v1_8_R1.NBTTagList;
import net.minecraft.server.v1_8_R1.PacketDataSerializer;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_8_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;



public class antitab {
	
	private static Field cC;
	
	public static void initPacketListener(){
		ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(Survie.plugin, PacketType.Play.Client.TAB_COMPLETE){
			@Override
			public void onPacketReceiving(PacketEvent e){
				if (e.getPacketType() == PacketType.Play.Client.TAB_COMPLETE) {
				
					if (e.getPlayer().hasPermission("protect.op")) return;
					
					
					PacketContainer packet = e.getPacket();
		            String message = ((String)packet.getSpecificModifier(String.class).read(0)).toLowerCase();
		            
		            if ((message.startsWith("/")) && (!message.contains(" ")))
		            {

		            	e.getPlayer().sendMessage("§f/aide, /s, /p, /tm, /team, /spawn ,/home,/skill, /list, /helpop, /icon, /lobby, /gta, /skyblock, "
		            			+ "/pvpmagie, /faction, /pvpbox, /creatif, /skywars, /quakecraft, /mariokart, /wigames");

		              e.setCancelled(true); }
					
				}
			}

		});
		
		
		
		
		
		
		    try {
        cC = EntityPlayer.class.getDeclaredField("containerCounter");
        cC.setAccessible(true);
    }
    catch(NoSuchFieldException e) {
       // this.setEnabled(false);
    }
    catch(SecurityException e) {
       // this.setEnabled(false);
    }

    Set<PacketType> packets = new HashSet<PacketType>();
    packets.add(PacketType.Play.Server.SET_SLOT);
    packets.add(PacketType.Play.Server.WINDOW_ITEMS);
    packets.add(PacketType.Play.Server.CUSTOM_PAYLOAD);

    ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter( Survie.plugin, packets) {
        @SuppressWarnings("unchecked")
		@Override
        public void onPacketSending(PacketEvent event) {
            PacketContainer packet = event.getPacket();
            PacketType type = packet.getType();
            if(type == PacketType.Play.Server.WINDOW_ITEMS) {
                try {
                    ItemStack[] read = packet.getItemArrayModifier().read(0);
                    for(int i = 0; i < read.length; i++) {
                        read[i] = removeAttributes(read[i]);
                    }
                    packet.getItemArrayModifier().write(0, read);
                }
                catch(FieldAccessException e) {
                    Logger.getLogger(Survie.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            else if(type == PacketType.Play.Server.CUSTOM_PAYLOAD) {
                if(!packet.getStrings().read(0).equalsIgnoreCase("MC|TrList")) {
                    return;
                }
                try {
                    EntityPlayer p = ((CraftPlayer)event.getPlayer()).getHandle();
                    ContainerMerchant cM = ((ContainerMerchant)p.activeContainer);
                    Field fieldMerchant = cM.getClass().getDeclaredField("merchant");
                    fieldMerchant.setAccessible(true);
                    IMerchant imerchant = (IMerchant)fieldMerchant.get(cM);

                    MerchantRecipeList merchantrecipelist = imerchant.getOffers(p);
                    MerchantRecipeList nlist = new MerchantRecipeList();
                    for(Object orecipe : merchantrecipelist) {
                        MerchantRecipe recipe = (MerchantRecipe)orecipe;
                        int uses = recipe.k().getInt("uses");
                        int maxUses = recipe.k().getInt("maxUses");
                        MerchantRecipe nrecipe = new MerchantRecipe(removeAttributes(recipe.getBuyItem1()), removeAttributes(recipe.getBuyItem2()), removeAttributes(recipe.getBuyItem3()));
                        nrecipe.a(maxUses - 7);
                        for(int i = 0; i < uses; i++) {
                            nrecipe.f();
                        }
                        nlist.add(nrecipe);
                    }

                    PacketDataSerializer packetdataserializer = new PacketDataSerializer(Unpooled.buffer());
                    packetdataserializer.writeInt(cC.getInt(p));
                    nlist.a(packetdataserializer);
                    byte[] b = packetdataserializer.array();
                    packet.getByteArrays().write(0, b);
                    packet.getIntegers().write(0, b.length);
                }
                catch(NoSuchFieldException e) {
                    Logger.getLogger(Survie.class.getName()).log(Level.SEVERE, null, e);
                }
                catch(SecurityException e) {
                    Logger.getLogger(Survie.class.getName()).log(Level.SEVERE, null, e);
                }
                catch(IllegalArgumentException e) {
                    Logger.getLogger(Survie.class.getName()).log(Level.SEVERE, null, e);
                }
                catch(IllegalAccessException e) {
                    Logger.getLogger(Survie.class.getName()).log(Level.SEVERE, null, e);
                }
                catch(FieldAccessException e) {
                    Logger.getLogger(Survie.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            else {
                try {
                    packet.getItemModifier().write(0, removeAttributes(packet.getItemModifier().read(0)));
                }
                catch(FieldAccessException e) {
                    Logger.getLogger(Survie.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }

    }); 
		
		
		
	}
	
	
	
	
	
	
	
	
	
	   public static ItemStack removeAttributes(ItemStack i) {
    if(i == null) {
        return i;
    }
    if(i.getType() == Material.BOOK_AND_QUILL) {
        return i;
    }
    ItemStack item = i.clone();
    net.minecraft.server.v1_8_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
    NBTTagCompound tag;
    if(!nmsStack.hasTag()) {
        tag = new NBTTagCompound();
        nmsStack.setTag(tag);
    }
    else {
        tag = nmsStack.getTag();
    }
    NBTTagList am = new NBTTagList();
    tag.set("AttributeModifiers", am);
    nmsStack.setTag(tag);
    return CraftItemStack.asCraftMirror(nmsStack);
}

public static net.minecraft.server.v1_8_R1.ItemStack removeAttributes(net.minecraft.server.v1_8_R1.ItemStack i) {
    if(i == null) {
        return i;
    }
    if(net.minecraft.server.v1_8_R1.Item.getId(i.getItem()) == 386) {
        return i;
    }
    net.minecraft.server.v1_8_R1.ItemStack item = i.cloneItemStack();
    NBTTagCompound tag;
    if(!item.hasTag()) {
        tag = new NBTTagCompound();
        item.setTag(tag);
    }
    else {
        tag = item.getTag();
    }
    NBTTagList am = new NBTTagList();
    tag.set("AttributeModifiers", am);
    item.setTag(tag);
    return item;
} 
	
	
	
	

}
