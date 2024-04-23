package src.util;

import src.core.Manager;

public class Debug {
    public static void main(String[] args) {
        Verbose.toggleVerbose();
        Manager.runGame();



        System.out.println();
        System.exit(0);
    }
}