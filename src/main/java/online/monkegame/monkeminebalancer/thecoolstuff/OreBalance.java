package online.monkegame.monkeminebalancer.thecoolstuff;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

public class OreBalance {

    public Map<Material, Integer> materials = Map.ofEntries(
            entry(Material.COAL_ORE,5),
            entry(Material.DEEPSLATE_COAL_ORE,5),
            entry(Material.DEEPSLATE_DIAMOND_ORE,2),
            entry(Material.DEEPSLATE_EMERALD_ORE,3),
            entry(Material.DEEPSLATE_GOLD_ORE,3),
            entry(Material.DEEPSLATE_COPPER_ORE,4),
            entry(Material.DEEPSLATE_IRON_ORE,4),
            entry(Material.DEEPSLATE_LAPIS_ORE,4),
            entry(Material.DEEPSLATE_REDSTONE_ORE,3),
            entry(Material.COPPER_ORE,4),
            entry(Material.DIAMOND_ORE,2),
            entry(Material.EMERALD_ORE,3),
            entry(Material.GOLD_ORE,4),
            entry(Material.NETHER_GOLD_ORE,4),
            entry(Material.NETHER_QUARTZ_ORE,4),
            entry(Material.REDSTONE_ORE,3),
            entry(Material.IRON_ORE,4),
            entry(Material.LAPIS_ORE,4),
            entry(Material.AMETHYST_CLUSTER,3),
            entry(Material.ANCIENT_DEBRIS, 1)
    );

    public List<Material> chests = Arrays.asList(
            Material.CHEST,
            Material.CHEST_MINECART,
            Material.BARREL,
            Material.TRAPPED_CHEST
    );

    public void dropRate(BlockBreakEvent blockbreak, List<ItemStack> itemlist) {
        if (materials.containsKey(blockbreak.getBlock().getBlockData().getMaterial()) && !blockbreak.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
            double weewoo = Math.random();
            weewoo = weewoo + (materials.get(blockbreak.getBlock().getBlockData().getMaterial()) * 0.02);
            if (weewoo < 0.931) {
                //92.1% chance of single drops
                itemlist.addAll(blockbreak.getBlock().getDrops());
                blockbreak.setDropItems(true);
            } else if (weewoo >= 0.931 && weewoo < 0.99) {
                //6.9% chance of double drops - Smertieboi
                blockbreak.getPlayer().sendMessage(Component.text("Double drops!").decoration(TextDecoration.ITALIC, true).color(NamedTextColor.GREEN));
                itemlist.addAll(blockbreak.getBlock().getDrops());
                itemlist.addAll(blockbreak.getBlock().getDrops());
                blockbreak.setDropItems(true);
            } else {
                //1% chance of triple drops
                blockbreak.getPlayer().sendMessage(Component.text("TRIPLE DROPS!!!").color(TextColor.color(NamedTextColor.AQUA)).decorate(TextDecoration.BOLD));
                itemlist.addAll(blockbreak.getBlock().getDrops());
                itemlist.addAll(blockbreak.getBlock().getDrops());
                itemlist.addAll(blockbreak.getBlock().getDrops());
                blockbreak.setDropItems(true);
            }
        } else if (blockbreak.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
            // just add the block normally if the player has a silk touch tool
            itemlist.add(new ItemStack(blockbreak.getBlock().getBlockData().getMaterial()));
            blockbreak.setDropItems(false);
        } else if (chests.contains(blockbreak.getBlock().getBlockData().getMaterial())) {
            //drops the block normally if it's a chest like
            blockbreak.setDropItems(true);
        } else {
            //if it's not a special block as defined, up here, just do the normal block drops
            itemlist.addAll(blockbreak.getBlock().getDrops());
        }
    }

}
