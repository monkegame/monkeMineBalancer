package online.monkegame.monkesimp;

import online.monkegame.monkesimp.thecoolstuff.Recipes;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public Recipes recipes;

    public Main() {
        this.recipes = new Recipes();
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Listeners(this, getLogger()), this);
        getServer().addRecipe(recipes.rottenFleshLeather(new NamespacedKey(this, "rotten_leather")));
    }

}
