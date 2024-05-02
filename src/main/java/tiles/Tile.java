package tiles;

import core.GameObject;

import java.util.Objects;

public abstract class Tile extends GameObject {
    protected boolean discovered;
    protected boolean traversable;

    public Tile() {
        super("Undefined Tile", "This tile is undefined.", ".");
        discovered = true;
        traversable = true;
    }
    public Tile(String name, String description, String symbol, boolean discovered, boolean traversable) {
        super(name, description, symbol);
        this.discovered = discovered;
        this.traversable = traversable;
    }

    public Tile(String name, String description, String symbol, boolean discovered, boolean traversable, int[] position) {
        super(name, description, symbol);
        this.discovered = discovered;
        this.traversable = traversable;
        this.position = position;
    }

    public Tile(String name, String description, String symbol, boolean discovered, boolean traversable, int[] position, String color, String bgColor) {
        super(name, description, symbol, position, color, bgColor);
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


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Tile tile = (Tile) object;
        return super.equals(object) && discovered == tile.discovered && traversable == tile.traversable;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discovered, traversable);
    }
}
