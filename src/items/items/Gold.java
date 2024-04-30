package src.items.items;

import src.items.Stackable;
import src.util.ConsoleColors;

public class Gold extends Stackable {

    public Gold(String name, String description, String symbol, int MAX_SIZE, int[] position, String color, String bgColor) {
        super(
                "Gold Coins",
                "A dungeoneer's favorite treasure.",
                "©",
                Integer.MAX_VALUE,
                new int[]{-1, -1},
                ConsoleColors.TEXT_BRIGHT_YELLOW,
                ""
        );
    }
}
