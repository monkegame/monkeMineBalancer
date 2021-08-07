package online.monkegame.monkeminer;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Listeners implements Listener {

    public Main plugin;
    public Logger log;
    public List<ItemStack> itemlist = new ArrayList<>();

    public Listeners(Main main, Logger logger) {
        this.plugin = main;
        this.log = logger;
    }

    @EventHandler
    public void onBlockDrop(BlockBreakEvent blockbreak) {
        Player p = blockbreak.getPlayer();
        dropRate(blockbreak);
        blockbreak.setDropItems(false);
        for (ItemStack item : itemlist) {
            p.getInventory().addItem(item);
        }
        log.info(p.getName() + ": " + itemlist);
        itemlist.clear();
    }

    public void dropRate(BlockBreakEvent blockbreak) {
        if (blockbreak.getPlayer().getLevel() > 10) {
            double weewoo = Math.random();
            if (weewoo < 0.65) {
                itemlist.addAll(blockbreak.getBlock().getDrops());
            } else if (weewoo > 0.75) {
                itemlist.addAll(blockbreak.getBlock().getDrops());
                itemlist.addAll(blockbreak.getBlock().getDrops());
            } else {
                itemlist.addAll(blockbreak.getBlock().getDrops());
                itemlist.addAll(blockbreak.getBlock().getDrops());
                itemlist.addAll(blockbreak.getBlock().getDrops());
            }
        }
    }

}