package src.entities;

import src.util.ConsoleColors;

public class Player extends Entity {
    public Player() {
        super(
                "Player",
                "It's you!",
                ConsoleColors.buildColoredString(ConsoleColors.TEXT_BLUE, null, "@"),
                20,
                5,
                0);
    }
}
