package src.tiles;

import src.core.GameObject;

public abstract class Tile extends GameObject {
    protected boolean discovered;

    public Tile() {
        super("Undefined Tile", "This tile is undefined.", '.');
        discovered = true;
    }
    public Tile(String name, String description, char symbol, boolean discovered) {
        super(name, description, symbol);
        this.discovered = discovered;
    }

    public boolean isDiscovered() {
        return discovered;
    }

    public void setDiscovered(boolean discovered) {
        this.discovered = discovered;
    }
}
