package src.items.items;

import src.items.Item;
import src.util.ConsoleColors;

public class Sword extends Item {
    public Sword(int[] position) {
        super(
                "Rusted Sword",
                "This blade has seen better days.",
                "/",
                position,
                ConsoleColors.TEXT_YELLOW,
                ""
        );
    }
}
