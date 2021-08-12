package online.monkegame.monkeminebalancer;

import online.monkegame.monkeminebalancer.thecoolstuff.Recipes;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public Recipes recipes;

    public Main() {
        this.recipes = new Recipes();
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Listeners(this, getLogger()), this);
        getServer().addRecipe(recipes.rottenFleshLeather());
    }

}
