package textGridDungeon.traps;

import textGridDungeon.GameObject;

public abstract class Trap extends GameObject {
    protected boolean discovered;

    public Trap() {
        super("Undefined Trap", "This trap is undefined.", 'X');
        discovered = true;
    }
    public Trap(String name, String description, char symbol, boolean discovered) {
        super(name, description, symbol);
        this.discovered = discovered;
    }

    public boolean isDiscovered() {
        return discovered;
    }

    public void setDiscovered(boolean discovered) {
        this.discovered = discovered;
    }

    public abstract void triggerTrap();
}
