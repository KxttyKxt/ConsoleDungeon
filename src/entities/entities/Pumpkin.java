package entities.entities;

import entities.Entity;
import items.Item;
import items.items.Coins;
import util.ConsoleColors;

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
                ConsoleColors.TEXT_BRIGHT_GREEN,
                ""
        );
    }

    @Override
    public Item dropOnDeath() {
        return new Coins(new int[]{getRow(), getColumn()}, 50);
    }
}
