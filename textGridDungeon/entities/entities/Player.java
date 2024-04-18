package textGridDungeon.entities.entities;

import textGridDungeon.entities.interfaces.Neutral;

public class Player extends Entity implements Neutral {
    public Player() {
        super("Player", "It's you!", 'B', 20, 5, 0);
    }
}
