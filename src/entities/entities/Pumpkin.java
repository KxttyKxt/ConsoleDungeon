package src.entities.entities;

import src.entities.Entity;
import src.util.ConsoleColors;

public class Pumpkin extends Entity {
    public Pumpkin(int[] position) {
        super(
                "Pumpkin",
                "A pumpkin. Looks punchable.",
                "o",
                10,
                0,
                0,
                position,
                ConsoleColors.TEXT_YELLOW,
                ""
        );
    }
}
