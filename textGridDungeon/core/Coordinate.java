package textGridDungeon.core;

import textGridDungeon.entities.entities.Entity;
import textGridDungeon.items.Item;
import textGridDungeon.tiles.Floor;
import textGridDungeon.tiles.Tile;

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

    public Tile getTile() {
        return tile;
    }
    public void setTile(Tile tile) {
        this.tile = tile;
    }
}
