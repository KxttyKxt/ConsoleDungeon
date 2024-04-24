package src.tiles.traps;

import src.entities.Entity;
import src.tiles.Tile;

public abstract class Trap extends Tile {

    public Trap(int[] position) {
        super(
                "Undefined Trap",
                "This trap is undefined.",
                "X",
                true,
                true,
                position
        );
    }

    public Trap(String name, String description, String symbol, boolean discovered, int[] position) {
        super(name, description, symbol, discovered, true, position);
    }

    public abstract void triggerTrap(Entity target);
}
