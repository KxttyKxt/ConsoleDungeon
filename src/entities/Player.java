package src.entities;

import javaconsolecolors.ConsoleColors;

public class Player extends Entity {
    public Player() {
        super(
                "Player",
                "It's you!",
                new javaconsolecolors.ConsoleColors(ConsoleColors.TEXT_CYAN, null, "@").getColoredString(),
                20,
                5,
                0);
    }
}
