package src.items.items;

import src.items.Stackable;
import src.util.ConsoleColors;

public class Coins extends Stackable {

    public Coins(int[] position, int amount) {
        super(
                "Gold Coins",
                "A dungeoneer's favorite treasure.",
                "¢",
                Integer.MAX_VALUE,
                position,
                ConsoleColors.TEXT_BRIGHT_YELLOW,
                ""
        );
        this.amount = amount;
    }
}
