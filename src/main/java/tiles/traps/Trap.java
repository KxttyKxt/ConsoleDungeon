package tiles.traps;

import entities.Entity;
import tiles.Tile;

public abstract class Trap extends Tile {

    public Trap(int[] position) {
        super(
                "Undefined Trap",
                "This trap is undefined.",
                "XXX",
                true,
                true,
                position
        );
    }

    public Trap(String name, String description, String symbol, boolean discovered, int[] position, String color, String bgColor) {
        super(name, description, symbol, discovered, true, position, color, bgColor);
    }

    public abstract void triggerTrap(Entity target);
}
