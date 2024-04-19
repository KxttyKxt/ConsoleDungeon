package src.items;

public abstract class Stackable extends Item{
    protected int amount;
    protected final int MAX_SIZE;

    public Stackable(String name, String description, char symbol, int MAX_SIZE) {
        super(name, description, symbol);
        this.MAX_SIZE = MAX_SIZE;
        this.amount = 0;
    }
}
