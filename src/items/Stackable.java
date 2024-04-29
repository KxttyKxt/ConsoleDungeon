package src.items;

public abstract class Stackable extends Item{
    protected int amount;
    protected final int MAX_SIZE;

    public Stackable(String name, String description, String symbol, int MAX_SIZE) {
        super(name, description, symbol);
        this.MAX_SIZE = MAX_SIZE;
        this.amount = 1;
    }

    public Stackable(String name, String description, String symbol, int MAX_SIZE, int[] position) {
        super(name, description, symbol, position);
        this.MAX_SIZE = MAX_SIZE;
        this.amount = 1;
    }

    public Stackable(String name, String description, String symbol, int MAX_SIZE, int[] position, String color, String bgColor) {
        super(name, description, symbol, position, color, bgColor);
        this.MAX_SIZE = MAX_SIZE;
        this.amount = 1;
    }
}
