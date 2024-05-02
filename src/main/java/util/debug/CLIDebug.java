package util.debug;

import core.Manager;

import java.util.Scanner;

public class CLIDebug {
    public static void main(String[] args) {
        Scanner consoleScanner = new Scanner(System.in);
        Verbose.toggleVerbose();

        boolean debug = false;
        Verbose.log("Something not working? Be sure you built artifacts!", false);
        System.out.printf("Would you like to use the debug level? [y] [n]%n>> ");
        if (consoleScanner.nextLine().equals("y"))
            debug = true;

        Manager.runGame(debug);
    }
}
