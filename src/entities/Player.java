package entities;

import items.Item;
import util.ConsoleColors;

public class Player extends Entity {
    public Player() {
        super(
                "Player",
                "It's you!",
                "@",
                20,
                5,
                0,
                new int[]{},
                ConsoleColors.TEXT_BRIGHT_BLUE,
                ""
        );
    }

    @Override
    public Item dropOnDeath() {
        return null;
    }
}
