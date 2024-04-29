package src.core;

import src.util.ConsoleColors;

public class Coordinate {
    private String symbol;  // The character(s) displayed for a specific coordinate.
                            // Never decided by user. Conventionally 1 or 3 characters
    public static final String DEFAULT_SYMBOL = ConsoleColors.buildColoredString(ConsoleColors.TEXT_BRIGHT_BLACK, null, ".");

    public Coordinate() {
        symbol = DEFAULT_SYMBOL;
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
