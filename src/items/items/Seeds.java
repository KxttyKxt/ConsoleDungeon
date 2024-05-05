package items.items;

import items.Stackable;
import util.ConsoleColors;

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
