package items.items;

import items.Item;
import util.ConsoleColors;

import java.util.Random;

public class Trinket extends Item {
    public Trinket (int[] position) {
        super(
                "Trinket",
                "A rather useless thingamabob. It looks neat though.",
                "x",
                position,
                "",
                ""
        );
        Random random = new Random();
        int randomColor = random.nextInt(1, 6);
        switch (randomColor) {
            case 1 -> color = ConsoleColors.TEXT_BRIGHT_RED;
            case 2 -> color = ConsoleColors.TEXT_BRIGHT_YELLOW;
            case 3 -> color = ConsoleColors.TEXT_BRIGHT_GREEN;
            case 4 -> color = ConsoleColors.TEXT_BRIGHT_BLUE;
            case 5 -> color = ConsoleColors.TEXT_BRIGHT_PURPLE;
        }
    }
    public Trinket (int[] position, int colorNum) {
        super(
                "Trinket",
                "A rather useless thingamabob. It looks neat though.",
                "x",
                position,
                "",
                ""
        );
        switch (colorNum) {
            case 1 -> color = ConsoleColors.TEXT_BRIGHT_RED;
            case 2 -> color = ConsoleColors.TEXT_BRIGHT_YELLOW;
            case 3 -> color = ConsoleColors.TEXT_BRIGHT_GREEN;
            case 4 -> color = ConsoleColors.TEXT_BRIGHT_BLUE;
            case 5 -> color = ConsoleColors.TEXT_BRIGHT_PURPLE;
        }
    }

}
