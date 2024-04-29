package src.entities.entities;

import javaconsolecolors.ConsoleColors;
import src.entities.Entity;

public class Dummy extends Entity {
    public Dummy(int[] position) {
        super(
                "Dummy",
                "A simple practice dummy.",
                new javaconsolecolors.ConsoleColors(ConsoleColors.TEXT_BRIGHT_BLUE, null, "T").getColoredString(),
                Integer.MAX_VALUE,
                0,
                0,
                position
        );
    }
}
