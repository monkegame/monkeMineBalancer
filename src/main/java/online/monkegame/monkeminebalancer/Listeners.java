package online.monkegame.monkeminebalancer;

import online.monkegame.monkeminebalancer.balance.OreBalance;
import online.monkegame.monkeminebalancer.utils.ColorGenerator;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Listeners implements Listener {

    public Main plugin;
    public Logger log;
    public List<ItemStack> itemlist = new ArrayList<>();
    public OreBalance orebal;
    BukkitScheduler scheduler;

    public Listeners(Main main, Logger logger) {
        this.plugin = main;
        this.log = logger;
        this.orebal = new OreBalance();
        this.scheduler = main.getServer().getScheduler();
    }

    @EventHandler
    public void onBlockDrop(BlockBreakEvent blockbreak) {
        Player p = blockbreak.getPlayer();
        orebal.dropRate(blockbreak, itemlist);
        blockbreak.setDropItems(false);
        for (ItemStack item : itemlist) {
            p.getInventory().addItem(item);
        }
        //log.info(p.getName() + ": " + itemlist);
        itemlist.clear();
    }

}