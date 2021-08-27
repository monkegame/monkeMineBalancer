package online.monkegame.monkesimp.thecoolstuff;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;

public class Recipes {

    public FurnaceRecipe rottenFleshLeather(NamespacedKey key) {
        return new FurnaceRecipe(key, new ItemStack(Material.LEATHER), Material.ROTTEN_FLESH, 20f, 200);
    }

}
