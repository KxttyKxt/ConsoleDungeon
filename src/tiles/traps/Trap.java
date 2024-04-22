package src.tiles.traps;

import src.entities.Entity;
import src.tiles.Tile;

public abstract class Trap extends Tile {

    public Trap() {
        super(
                "Undefined Trap",
                "This trap is undefined.",
                'X',
                true,
                true
        );
    }

    public Trap(String name, String description, char symbol, boolean discovered) {
        super(name, description, symbol, discovered, true);
    }

    public abstract void triggerTrap(Entity target);
}
