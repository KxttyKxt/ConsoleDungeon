package textGridDungeon.entities.entities;

import textGridDungeon.entities.interfaces.Controlled;

public class Player extends Entity implements Controlled {
    public Player() {
        super("Player", "It's you!", 'B', 20, 5, 0);
    }
}
