package textGridDungeon;

import textGridDungeon.core.Manager;

public class Main {
    public static void main(String[] args) {
        Manager.newMap(20, 5, true);
        Manager.runGame();
    }
}