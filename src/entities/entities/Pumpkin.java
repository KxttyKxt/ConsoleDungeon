package src.entities.entities;

import src.entities.Entity;
import src.util.ConsoleColors;

public class Pumpkin extends Entity {
    public Pumpkin(int[] position) {
        super(
                "Pumpkin",
                "A pumpkin. Looks punchable.",
                ConsoleColors.buildColoredString(ConsoleColors.TEXT_YELLOW, null, "o"),
                10,
                0,
                0,
                position
        );
    }
}
