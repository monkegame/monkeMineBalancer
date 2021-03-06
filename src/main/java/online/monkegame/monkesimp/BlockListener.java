package online.monkegame.monkesimp;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import online.monkegame.monkesimp.qol.OreBalance;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BlockListener implements Listener {

    public Main plugin;
    public Logger log;
    public List<ItemStack> itemlist = new ArrayList<>();
    public OreBalance orebal;
    BukkitScheduler scheduler;

    public BlockListener(Main main, Logger logger) {
        this.plugin = main;
        this.log = logger;
        this.orebal = new OreBalance();
        this.scheduler = main.getServer().getScheduler();
    }

    @EventHandler
    public void onBlockDrop(BlockBreakEvent blockbreak) {
        Player p = blockbreak.getPlayer();
        //annoys you with a message if inventory is full
        if (p.getInventory().firstEmpty() == -1) {
            blockbreak.setCancelled(true);
            blockbreak.setDropItems(false);
            p.sendMessage(Component.text("Your inventory is full!").decoration(TextDecoration.ITALIC, true).color(NamedTextColor.RED));
        } else {
            //does the balancing thing
            orebal.dropRate(blockbreak, itemlist);
            for (ItemStack item : itemlist) {
                p.getInventory().addItem(item);
            }
            //log.info(p.getName() + ": " + itemlist);
            itemlist.clear();
        }
    }

}