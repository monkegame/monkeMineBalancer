package online.monkegame.monkesimp.qol;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import javax.xml.stream.events.Namespace;
import java.util.List;
import java.util.UUID;

public class Recipes {

    public FurnaceRecipe rottenFleshLeather(NamespacedKey key) {
        return new FurnaceRecipe(key, new ItemStack(Material.LEATHER), Material.ROTTEN_FLESH, 1f, 200);
    }

    public ShapedRecipe ironGoldHelmet(NamespacedKey key) {

        ItemStack ironGoldHelmet = new ItemStack(Material.GOLDEN_HELMET);

        ItemMeta ironGoldHelmetMeta = ironGoldHelmet.getItemMeta();

        ironGoldHelmetMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(),"armor",6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD));
        ironGoldHelmetMeta.displayName(Component.text("Iron-strengthened Gold Helmet").decoration(TextDecoration.ITALIC,false));
        ironGoldHelmetMeta.lore(List.of(Component.text("Does not increase durability.", NamedTextColor.RED), Component.text("Does increase armor value.", NamedTextColor.GRAY)));
        ironGoldHelmet.setItemMeta(ironGoldHelmetMeta);

        ShapedRecipe recipe = new ShapedRecipe(key, ironGoldHelmet);
        recipe.shape("i i", "igi", "i i");
        recipe.setIngredient('i', Material.IRON_INGOT);
        recipe.setIngredient('g', Material.GOLDEN_HELMET);

        return recipe;
    }

    public ShapedRecipe ironGoldChestplate(NamespacedKey key) {

        ItemStack ironGoldHelmet = new ItemStack(Material.GOLDEN_CHESTPLATE);

        ItemMeta ironGoldHelmetMeta = ironGoldHelmet.getItemMeta();

        ironGoldHelmetMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(),"armor",6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD));
        ironGoldHelmetMeta.displayName(Component.text("Iron-strengthened Golden Chestplate").decoration(TextDecoration.ITALIC,false));
        ironGoldHelmetMeta.lore(List.of(Component.text("Does not increase durability.", NamedTextColor.RED), Component.text("Does increase armor value.", NamedTextColor.GRAY)));
        ironGoldHelmet.setItemMeta(ironGoldHelmetMeta);

        ShapedRecipe recipe = new ShapedRecipe(key, ironGoldHelmet);
        recipe.shape("i i", "igi", "i i");
        recipe.setIngredient('i', Material.IRON_INGOT);
        recipe.setIngredient('g', Material.GOLDEN_CHESTPLATE);

        return recipe;
    }

    public ShapedRecipe ironGoldLeggings(NamespacedKey key) {

        ItemStack ironGoldHelmet = new ItemStack(Material.GOLDEN_LEGGINGS);

        ItemMeta ironGoldHelmetMeta = ironGoldHelmet.getItemMeta();

        ironGoldHelmetMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(),"armor",6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD));
        ironGoldHelmetMeta.displayName(Component.text("Iron-strengthened Golden Chestplate").decoration(TextDecoration.ITALIC,false));
        ironGoldHelmetMeta.lore(List.of(Component.text("Does not increase durability.", NamedTextColor.RED), Component.text("Does increase armor value.", NamedTextColor.GRAY)));
        ironGoldHelmet.setItemMeta(ironGoldHelmetMeta);

        ShapedRecipe recipe = new ShapedRecipe(key, ironGoldHelmet);
        recipe.shape("i i", "igi", "i i");
        recipe.setIngredient('i', Material.IRON_INGOT);
        recipe.setIngredient('g', Material.GOLDEN_LEGGINGS);

        return recipe;
    }

    public ShapedRecipe ironGoldBoots(NamespacedKey key) {

        ItemStack ironGoldHelmet = new ItemStack(Material.GOLDEN_BOOTS);

        ItemMeta ironGoldHelmetMeta = ironGoldHelmet.getItemMeta();

        ironGoldHelmetMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(),"armor",6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD));
        ironGoldHelmetMeta.displayName(Component.text("Iron-strengthened Golden Chestplate").decoration(TextDecoration.ITALIC,false));
        ironGoldHelmetMeta.lore(List.of(Component.text("Does not increase durability.", NamedTextColor.RED), Component.text("Does increase armor value.", NamedTextColor.GRAY)));
        ironGoldHelmet.setItemMeta(ironGoldHelmetMeta);

        ShapedRecipe recipe = new ShapedRecipe(key, ironGoldHelmet);
        recipe.shape("i i", "igi", "i i");
        recipe.setIngredient('i', Material.IRON_INGOT);
        recipe.setIngredient('g', Material.GOLDEN_BOOTS);

        return recipe;
    }

}