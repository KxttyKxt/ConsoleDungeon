package src.core;

import src.entities.Entity;
import src.items.Item;
import src.tiles.tiles.Floor;
import src.tiles.Tile;
import src.tiles.traps.Trap;

import java.util.Stack;

public class Coordinate {
    private char symbol;            // The character displayed for a specific coordinate. Never decided by user.
    private Entity entity;          // A coordinate can only hold one.
    private Stack<Item> items;      // A coordinate can hold multiple items.
    private Tile tile;              // The ground entities and items stand on.

    public Coordinate() {
        entity = null;
        items = new Stack<>();
        tile = new Floor();
        updateSymbol();
    }

    public void updateCoordinate() {
        // If the tile has an entity and the tile type is a trap
        if (entity != null && tile instanceof Trap) {
            // Trigger the trap
            ((Trap) tile).triggerTrap(entity);
        }

    }

    public void updateSymbol() {
        // Entity overrides items
        if (entity != null)
            symbol = entity.getSymbol();
        // First item in stack is the used symbol otherwise
        else if (!items.isEmpty())
            symbol = items.peek().getSymbol();
        // If there's an exposed trap, show that (if it isn't hidden)
        else if (tile != null) {
            if (tile.isDiscovered())
                symbol = tile.getSymbol();
        }
        // If there's nothing on the tile
        else
            symbol = '.';
    }

    public char getSymbol() {
        return symbol;
    }

    public Entity getEntity() {
        return entity;
    }
    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public Stack<Item> getItems() {
        return items;
    }
    public void setItems(Stack<Item> items) {
        this.items = items;
    }
    public void addItem(Item item) {
        items.push(item);
    }
    public void removeItem(Item item) {
        items.remove(item);
    }
    public void removeItem(int index) {
        items.remove(index);
    }

    public Tile getTile() {
        return tile;
    }
    public void setTile(Tile tile) {
        this.tile = tile;
    }

    /**
     * Checks if the Coordinate lacks an entity and lacks items.
     * @return true if coordinate has no entity nor items.
     */
    public boolean isEmpty() {
        return entity == null && items.isEmpty();
    }

    /**
     * Checks if the Coordinate lacks an entity and lacks items.
     *
     * This version also checks if the Tile in the Coordinate mismatches a list of Tile SubClasses
     * @param tilesToIgnore A list of Tile subclasses to check against.
     *                      If the tile is in this list, the coordinate is empty.
     *                      If the tile is NOT in this list, the coordinate is NOT empty.
     * @return true if the tile has an entity or items or if a tile not listed as one to ignore
     */
    public boolean isEmpty(Tile[] tilesToIgnore) {
        // If there exists an entity or item(s)
        if (!isEmpty())
            return false; // coordinate is not empty

        // If this.tile matches any of the ignored ones
        for (Tile ignoredTile : tilesToIgnore) {
            if (this.tile.getClass() == tile.getClass()) {
                return true; // coordinate is empty
            }
        }

        // Finally, this means that the tile is NOT ignored, and the coordinate has a "non-empty" tile.
        return false;
    }
}
