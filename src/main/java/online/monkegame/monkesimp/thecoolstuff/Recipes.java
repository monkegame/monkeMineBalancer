package online.monkegame.monkesimp.thecoolstuff;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

public class Recipes {

    public FurnaceRecipe rottenFleshLeather(NamespacedKey key) {
        return new FurnaceRecipe(key, new ItemStack(Material.LEATHER), Material.ROTTEN_FLESH, 1f, 200);
    }

    public ShapedRecipe ironGoldHelmet(NamespacedKey key) {



        ItemStack ironGoldHelmet = new ItemStack(Material.GOLDEN_HELMET);

        ItemMeta ironGoldHelmetMeta = ironGoldHelmet.getItemMeta();

        ironGoldHelmetMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier("armor",1, AttributeModifier.Operation.ADD_NUMBER));
        ironGoldHelmet.setItemMeta(ironGoldHelmetMeta);

        Damageable damageable = (Damageable) ironGoldHelmet.getItemMeta();
        damageable.setDamage(300);
        ironGoldHelmet.setItemMeta((ItemMeta) damageable);

        ShapedRecipe recipe = new ShapedRecipe(key, ironGoldHelmet);
        recipe.setIngredient('i', Material.IRON_INGOT);
        recipe.setIngredient('g', Material.GOLDEN_HELMET);

        recipe.shape("i i", "igi", "i i");

        return recipe;
    }

}
