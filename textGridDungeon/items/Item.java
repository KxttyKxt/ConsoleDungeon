package textGridDungeon.items;
import textGridDungeon.core.GameObject;

public abstract class Item extends GameObject {
    protected boolean canStack;
    protected int amount;

    public Item() {
        super("Undefined Item", "This item is undefined.", '&');
        canStack = false;
        amount = 1;
    }

    public Item(String name, String description, char symbol, boolean canStack, int amount) {
        super(name, description, symbol);
        this.canStack = canStack;
        this.amount = amount;
    }
}