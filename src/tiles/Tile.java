package src.tiles;

import src.core.GameObject;

public abstract class Tile extends GameObject {
    protected boolean discovered;
    protected boolean traversable;

    public Tile() {
        super("Undefined Tile", "This tile is undefined.", '.');
        discovered = true;
        traversable = true;
    }
    public Tile(String name, String description, char symbol, boolean discovered, boolean traversable) {
        super(name, description, symbol);
        this.discovered = discovered;
        this.traversable = traversable;
    }

    public boolean isDiscovered() {
        return discovered;
    }

    public void setDiscovered(boolean discovered) {
        this.discovered = discovered;
    }

    public boolean isTraversable() {
        return traversable;
    }

    public void setTraversable(boolean traversable) {
        this.traversable = traversable;
    }

    public abstract void updateTile();
}
