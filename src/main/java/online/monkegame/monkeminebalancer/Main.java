package online.monkegame.monkeminebalancer;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public Main() {
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Listeners(this, getLogger()), this);
    }

}
