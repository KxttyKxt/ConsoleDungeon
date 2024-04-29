package src.entities.entities;

import javaconsolecolors.ConsoleColors;
import src.entities.Entity;

public class Pumpkin extends Entity {
    public Pumpkin(int[] position) {
        super(
                "Pumpkin",
                "A pumpkin. Looks punchable.",
                new ConsoleColors(ConsoleColors.TEXT_YELLOW, null, "o").getColoredString(),
                10,
                0,
                0,
                position
        );
    }
}
