package textGridDungeon.tiles.traps;

import textGridDungeon.GameObject;
import textGridDungeon.tiles.Tile;

public abstract class Trap extends Tile {

    public Trap() {
        super("Undefined Trap", "This trap is undefined.", 'X', true);
    }
    public Trap(String name, String description, char symbol, boolean discovered) {
        super(name, description, symbol, discovered);
    }

    public boolean isDiscovered() {
        return discovered;
    }

    public void setDiscovered(boolean discovered) {
        this.discovered = discovered;
    }

    public abstract void triggerTrap();
}
