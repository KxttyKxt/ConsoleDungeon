package src.items.items;

import src.items.Stackable;
import src.util.ConsoleColors;

public class Seeds extends Stackable {
    public Seeds(int[] position, int amount) {
        super(
                "Seeds",
                "Just some random seeds. Probably not useful.",
                ";",
                64,
                amount,
                position,
                ConsoleColors.TEXT_GREEN,
                ""
        );
    }
}
