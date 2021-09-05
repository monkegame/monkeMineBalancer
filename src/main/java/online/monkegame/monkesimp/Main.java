package online.monkegame.monkesimp;

import online.monkegame.monkesimp.qol.Recipes;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public Recipes recipes;

    public Main() {
        this.recipes = new Recipes();
    }

    @Override
    public void onEnable() {

        getServer().getPluginManager().registerEvents(new BlockListener(this, getLogger()), this);

        getServer().addRecipe(recipes.rottenFleshLeather(new NamespacedKey(this, "rotten_leather")));
        getServer().addRecipe(recipes.ironGoldHelmet(new NamespacedKey(this, "iron_gold_helmet")));
        getServer().addRecipe(recipes.ironGoldChestplate(new NamespacedKey(this, "iron_gold_chestplate")));
        getServer().addRecipe(recipes.ironGoldLeggings(new NamespacedKey(this, "iron_gold_leggings")));
        getServer().addRecipe(recipes.ironGoldBoots(new NamespacedKey(this, "iron_gold_boots")));
    }

}
