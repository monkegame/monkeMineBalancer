package online.monkegame.monkeminebalancer.thecoolstuff;

import org.bukkit.Material;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;

public class Recipes {

    public FurnaceRecipe rottenFleshLeather() {
        ItemStack result = new ItemStack(Material.LEATHER);
        FurnaceRecipe recipe = new FurnaceRecipe(result, Material.ROTTEN_FLESH);
        recipe.setExperience(20f);
        return recipe;
    }

}
