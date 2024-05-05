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

        System.out.printf("Run latest Debug.jar in cmd.exe? [y] [n]%n>> ");

        if (Desktop.isDesktopSupported() && new File("src/util/debug/runCLIdebug.bat").exists() && consoleScanner.nextLine().equals("y")) {
            Desktop.getDesktop().open(new File("src/util/debug/runCLIdebug.bat"));
            Verbose.log("Desktop opened Debug.jar in cmd.exe", false);
            System.exit(0);
        }

        Verbose.log(String.format("Running debug in IDE. This will be unstable!%n    - Files and FileWriters will not work%n    - Console may not appear the same as cmd.exe%n    - Colors and BRIGHT colors will appear swapped."), true);

        boolean debug = false;
        System.out.printf("Would you like to use the debug level? [y] [n]%n>> ");
        if (consoleScanner.nextLine().equals("y"))
            debug = true;

        Manager.runGame(debug);

//        if (Verbose.isVerbose()) {
//            System.out.printf("Would you like to run this in cmd.exe with the latest artifact build? [y] [n]%n>> ");
//            if (consoleScanner.nextLine().equals("y") && Desktop.isDesktopSupported() && Verbose.isVerbose()) {
//                try {
//                    File batchFile = new File("start.bat - Shortcut.lnk");
//                    Desktop desktop = Desktop.getDesktop();
//                    desktop.open(batchFile);
//                    Verbose.log("Batch file successfully opened via shortcut.", false);
//                } catch (IOException e) {
//                    Verbose.log("IOException found; opening batch file failed. Sorry!", true);
//                    Verbose.showError(e);
//                }
//            }
//            else
//                Manager.runGame();
//        }
//        else {
//            System.out.printf("Would you like to turn on verbose logging now, before running the game? [y] [n]%n>> ");
//            if (consoleScanner.nextLine().equals("y"))
//                Verbose.toggleVerbose();
//            Manager.runGame();
//        }


        System.out.println();
        System.exit(0);
    }
}