package util.debug;

import core.Manager;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class IDEDebug {
    public static void main(String[] args) throws IOException {
        Scanner consoleScanner = new Scanner(System.in);
        Verbose.toggleVerbose();
        System.out.println(Desktop.isDesktopSupported());

        System.out.printf("Run in command line? [y] [n]%n>> ");
        if (Desktop.isDesktopSupported() && new File("src/main/java/util/debug/runCLIdebug.bat").exists() && consoleScanner.nextLine().equals("y")) {
            Desktop.getDesktop().open(new File("src/main/java/util/debug/runCLIdebug.bat"));
            Verbose.log("Desktop opened Debug.jar in cmd.exe", false);
            System.exit(0);
        }

        Verbose.log(String.format("Running debug in IDE. This will be unstable!%n    - File calls will not work.%n    - System.out print commands will visibly lag."), true);

        boolean debug = false;
        System.out.printf("Would you like to use the debug level? [y] [n]%n>> ");
        if (consoleScanner.nextLine().equals("y"))
            debug = true;

        Manager.runGame(debug);

        System.out.println();
        System.exit(0);
    }
}