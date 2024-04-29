package src.entities.entities;

import src.entities.Entity;
import src.util.ConsoleColors;

public class Dummy extends Entity {
    public Dummy(int[] position) {
        super(
                "Dummy",
                "A simple practice dummy.",
                ConsoleColors.buildColoredString(ConsoleColors.TEXT_BRIGHT_YELLOW, null, "T"),
                Integer.MAX_VALUE,
                0,
                0,
                position
        );
    }
}
