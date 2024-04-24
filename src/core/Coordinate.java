package src.core;

public class Coordinate {
    private String symbol;  // The character(s) displayed for a specific coordinate.
                            // Never decided by user. Conventionally 1 or 3 characters

    public Coordinate() {
        symbol = ".";
    }

    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
