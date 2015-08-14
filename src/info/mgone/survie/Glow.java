package info.mgone.survie;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author DarkSeraphim.
 */
public class Glow extends Enchantment
{

    public static Glow glow;

    public Glow()
    {
        super(255);
    }

    @Override
    public String getName()
    {
        return "GLOW";
    }

    @Override
    public int getMaxLevel()
    {
        return 1;
    }

    @Override
    public int getStartLevel()
    {
        return 0;
    }

    @Override
    public EnchantmentTarget getItemTarget()
    {
        return EnchantmentTarget.ALL;
    }

    @Override
    public boolean conflictsWith(Enchantment enchantment)
    {
        return false;
    }

    @Override
    public boolean canEnchantItem(ItemStack itemStack)
    {
        return true;
    }

    /**
     * Invoke in onEnable
     */
    @SuppressWarnings({ "unchecked", "deprecation" })
	public static void register()
    {
        Glow glow = new Glow();
        try
        {
            Field byId = Enchantment.class.getDeclaredField("byId");
            Field byName = Enchantment.class.getDeclaredField("byName");

            byId.setAccessible(true);
            byName.setAccessible(true);

            Map<Integer, Enchantment> byIdMap = (Map<Integer, Enchantment>) byId.get(null);
            Map<String, Enchantment> byNameMap = (Map<String, Enchantment>) byName.get(null);

            byIdMap.put(glow.getId(), glow);
            byNameMap.put(glow.getName(), glow);
            Glow.glow = glow;
        }
        catch(NoSuchFieldException ex)
        {
            ex.printStackTrace();
        }
        catch(IllegalAccessException ex)
        {
            ex.printStackTrace();
        }
    }

    /**
     * Adds a glow to the given ItemStack
     * <p>
     * <i>Note: make sure you register the enchantment before using it!</i>
     * @param stack the stack to add the glow to
     */
    public void addGlow(ItemStack stack)
    {
        // Uncomment for a verbose error
        //Validate.notNull(Glow.glow, "The glow enchantment hasn't been registered yet");
        if(Glow.glow == null)
        {
            return;
        }
        if(stack.getType() == Material.AIR)
            return;

        ItemMeta meta = stack.getItemMeta();
        meta.addEnchant(Glow.glow, 1, false);
        stack.setItemMeta(meta);
    }

    /**
     * Invoke in onDisable
     */
    @SuppressWarnings({ "unchecked", "deprecation" })
	public static void unregister()
    {
        if(Glow.glow == null)
            return;

        try
        {
            Field byId = Enchantment.class.getDeclaredField("byId");
            Field byName = Enchantment.class.getDeclaredField("byName");

            byId.setAccessible(true);
            byName.setAccessible(true);

            Map<Integer, Enchantment> byIdMap = (Map<Integer, Enchantment>) byId.get(null);
            Map<String, Enchantment> byNameMap = (Map<String, Enchantment>) byName.get(null);

            byIdMap.remove(Glow.glow.getId());
            byNameMap.remove(Glow.glow.getName());
        }
        catch(NoSuchFieldException ex)
        {
            ex.printStackTrace();
        }
        catch(IllegalAccessException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            Glow.glow = null;
        }
    }
}
