package online.monkegame.monkeminer;

import net.kyori.adventure.sound.Sound;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import online.monkegame.monkeminer.utils.ColorGenerator;
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
import java.util.Map;
import java.util.logging.Logger;

import static java.util.Map.entry;

public class Listeners implements Listener {

    public Main plugin;
    public Logger log;
    public ColorGenerator cg;
    public List<ItemStack> itemlist = new ArrayList<>();
    public Map<Material, Integer> materials = Map.ofEntries(
            entry(Material.COAL_ORE,1),
            entry(Material.DEEPSLATE_COAL_ORE,1),
            entry(Material.DEEPSLATE_DIAMOND_ORE,5),
            entry(Material.DEEPSLATE_EMERALD_ORE,4),
            entry(Material.DEEPSLATE_GOLD_ORE,3),
            entry(Material.DEEPSLATE_COPPER_ORE,2),
            entry(Material.DEEPSLATE_IRON_ORE,2),
            entry(Material.DEEPSLATE_LAPIS_ORE,3),
            entry(Material.DEEPSLATE_REDSTONE_ORE,3),
            entry(Material.COPPER_ORE,2),
            entry(Material.DIAMOND_ORE,5),
            entry(Material.EMERALD_ORE,4),
            entry(Material.GOLD_ORE,3),
            entry(Material.NETHER_GOLD_ORE,1),
            entry(Material.NETHER_QUARTZ_ORE,2),
            entry(Material.REDSTONE_ORE,3),
            entry(Material.IRON_ORE,2),
            entry(Material.LAPIS_ORE,3),
            entry(Material.AMETHYST_CLUSTER,3),
            entry(Material.ANCIENT_DEBRIS, 6)
    );

    public Listeners(Main main, Logger logger) {
        this.plugin = main;
        this.log = logger;
        this.cg = new ColorGenerator();
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
        if (materials.containsKey(blockbreak.getBlock().getBlockData().getMaterial())) {
            double weewoo = Math.random();
            weewoo = weewoo + (materials.get(blockbreak.getBlock().getBlockData().getMaterial()) * 0.1);
            if (weewoo < 0.931) {
                //92.1% chance of single drops
                itemlist.addAll(blockbreak.getBlock().getDrops());
            } else if (weewoo >= 0.931  && weewoo < 0.99) {
                //6.9% chance of double drops - Smertieboi
                itemlist.addAll(blockbreak.getBlock().getDrops());
                itemlist.addAll(blockbreak.getBlock().getDrops());
            } else {
                //1% chance of triple drops
                blockbreak.getPlayer().sendMessage(generateTripleMessage());
                itemlist.addAll(blockbreak.getBlock().getDrops());
                itemlist.addAll(blockbreak.getBlock().getDrops());
                itemlist.addAll(blockbreak.getBlock().getDrops());
            }
        } else {
            itemlist.addAll(blockbreak.getBlock().getDrops());
        }
    }

    public Component generateTripleMessage() {
        char[] message = {'T','R', 'I', 'P', 'L', 'E', ' ', 'D', 'R', 'O', 'P', 'S', '!', '!', '!'};
        TextComponent.Builder component = Component.text();
        for(char chare : message) {
            component.append(Component.text(chare).color(TextColor.color(cg.randomKyoriColor())).decorate(TextDecoration.BOLD));
        }
        return component.build();
    }
}