package textGridDungeon;

import textGridDungeon.core.Manager;
import textGridDungeon.core.Map;

public class Main {
    public static void main(String[] args) {
        Manager.newMap(8, 10, true);
        Manager.runGame();
    }
}