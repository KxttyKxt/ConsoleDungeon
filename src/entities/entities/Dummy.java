package src.entities.entities;

import src.entities.Entity;
import src.items.Item;
import src.util.ConsoleColors;

public class Dummy extends Entity {
    public Dummy(int[] position) {
        super(
                "Dummy",
                "A simple practice dummy.",
                "T",
                Integer.MAX_VALUE,
                0,
                0,
                position,
                ConsoleColors.TEXT_BLUE,
                ""
        );
    }

    @Override
    public Item dropOnDeath() {
        return null;
    }
}
