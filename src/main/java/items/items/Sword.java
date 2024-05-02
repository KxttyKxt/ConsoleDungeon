package items.items;

import items.Item;
import util.ConsoleColors;

public class Sword extends Item {
    public Sword(int[] position) {
        super(
                "Rusted Sword",
                "This blade has seen better days. It's rusted beyond repair and therefore unfit for combat.",
                "/",
                position,
                ConsoleColors.TEXT_YELLOW,
                ""
        );
    }
}
