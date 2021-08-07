package online.monkegame.monkeminer.utils;

import net.kyori.adventure.util.HSVLike;

public class ColorGenerator {

    public HSVLike randomKyoriColor() {
        int r = (int) (Math.random() * 256) - 1;
        int g = (int) (Math.random() * 256) - 1;
        int b = (int) (Math.random() * 256) - 1;
        return HSVLike.of(r, g, b);
    }

}
