package textGridDungeon.tiles.traps;

import textGridDungeon.tiles.Tile;

public abstract class Trap extends Tile {

    public Trap() {
        super("Undefined Trap", "This trap is undefined.", 'X', true);
    }
    public Trap(String name, String description, char symbol, boolean discovered) {
        super(name, description, symbol, discovered);
    }

    public abstract void triggerTrap();
}
