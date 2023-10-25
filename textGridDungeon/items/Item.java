package textGridDungeon.items;
import textGridDungeon.GameObject;

public abstract class Item extends GameObject {
    protected boolean canStack;
    protected int amount;
}