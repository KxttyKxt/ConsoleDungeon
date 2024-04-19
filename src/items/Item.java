package src.items;
import src.core.GameObject;

public abstract class Item extends GameObject {

    public Item() {
        super("Undefined Item", "This item is undefined.", '&');
    }

    public Item(String name, String description, char symbol) {
        super(name, description, symbol);
    }


}