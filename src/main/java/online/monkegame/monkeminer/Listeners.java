package online.monkegame.monkeminer;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class Listeners implements Listener {

    public Main plugin;
    public Logger log;
    public List<ItemStack> itemlist = new ArrayList<>();
    public List<Material> materials = new ArrayList<>(Arrays.asList(
            Material.COAL_ORE,
            Material.DEEPSLATE_COAL_ORE,
            Material.DEEPSLATE_DIAMOND_ORE,
            Material.DEEPSLATE_EMERALD_ORE,
            Material.DEEPSLATE_GOLD_ORE,
            Material.DEEPSLATE_COPPER_ORE,
            Material.DEEPSLATE_IRON_ORE,
            Material.DEEPSLATE_LAPIS_ORE,
            Material.DEEPSLATE_REDSTONE_ORE,
            Material.COPPER_ORE,
            Material.DIAMOND_ORE,
            Material.EMERALD_ORE,
            Material.GOLD_ORE,
            Material.NETHER_GOLD_ORE,
            Material.NETHER_QUARTZ_ORE,
            Material.REDSTONE_ORE,
            Material.IRON_ORE,
            Material.LAPIS_ORE,
            Material.AMETHYST_CLUSTER
    ));

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
        if (materials.contains(blockbreak.getBlock().getBlockData().getMaterial())) {
            double weewoo = Math.random();
            if (weewoo <= 0.921) {
                //92.1% chance of single drops
                itemlist.addAll(blockbreak.getBlock().getDrops());
            } else if (weewoo >= 0.931) {
                //6.9% chance of double drops - Smertieboi
                itemlist.addAll(blockbreak.getBlock().getDrops());
                itemlist.addAll(blockbreak.getBlock().getDrops());
            } else {
                //1% chance of triple drops
                blockbreak.getPlayer().sendMessage(Component.text("TRIPLE DROPS!!!", NamedTextColor.GREEN, TextDecoration.BOLD));
                itemlist.addAll(blockbreak.getBlock().getDrops());
                itemlist.addAll(blockbreak.getBlock().getDrops());
                itemlist.addAll(blockbreak.getBlock().getDrops());
            }
        } else {
            itemlist.addAll(blockbreak.getBlock().getDrops());
        }
    }

}