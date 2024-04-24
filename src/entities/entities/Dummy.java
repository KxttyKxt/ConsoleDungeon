package src.entities.entities;

import src.entities.Entity;

public class Dummy extends Entity {
    public Dummy(int[] position) {
        super(
                "Dummy",
                "A simple practice dummy.",
                "☺",
                Integer.MAX_VALUE,
                0,
                0,
                position
        );
    }
}
