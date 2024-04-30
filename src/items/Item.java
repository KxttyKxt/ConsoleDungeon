package src.items;
import src.core.GameObject;

public abstract class Item extends GameObject {

    public Item() {
        super("Undefined Item", "This item is undefined.", "&");
    }

    public Item(String name, String description, String symbol) {
        super(name, description, symbol);
    }

    public Item(String name, String description, String symbol, int[] position) {
        super(name, description, symbol, position);
    }

    public Item(String name, String description, String symbol, int[] position, String color, String bgColor) {
        super(name, description, symbol, position, color, bgColor);
    }

}