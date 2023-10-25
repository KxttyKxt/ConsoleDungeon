package TextGridDungeon;

public class Coordinate {
    private char symbol; // The character displayed for a specific coordinate. Never decided by user.

    public Coordinate() {
        symbol = '.';
    }

    public char getSymbol() {
        return symbol;
    }
}
