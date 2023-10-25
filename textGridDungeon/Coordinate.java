package textGridDungeon;

import textGridDungeon.entities.Entity;
import textGridDungeon.items.Item;
import textGridDungeon.traps.Trap;

import java.util.ArrayList;

public class Coordinate {
    private char symbol; // The character displayed for a specific coordinate. Never decided by user.
    private Entity entity; // A coordinate can only hold one;
    private ArrayList<Item> items; // A coordinate can hold multiple items;
    private Trap trap;

    public Coordinate() {
        entity = null;
        items = new ArrayList<Item>();
        trap = null;
        updateSymbol();
    }

    public void updateSymbol() {
        // Entity overrides items
        if (entity != null)
            symbol = entity.getSymbol();
        // First item in stack is the used symbol otherwise
        else if (!items.isEmpty())
            symbol = items.get(0).getSymbol();
        // If there's an exposed trap, show that (if it isn't hidden)
        else if (trap != null) {
            if (trap.isDiscovered())
                symbol = trap.getSymbol();
        }
        // If there's nothing on the tile
        else
            symbol = '.';
    }

    public char getSymbol() {
        return symbol;
    }


}
