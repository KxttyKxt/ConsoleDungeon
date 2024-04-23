package src.util;

import java.util.Scanner;

public class Verbose {
    private static boolean verbose = false;
    private static Scanner consoleScanner = new Scanner(System.in);

    public static boolean isVerbose() {
        return verbose;
    }

    public static void toggleVerbose() {
        verbose = !verbose;
    }

    /**
     * Prints out messages if verbose logging is enabled
     *
     * @param message The message to print
     * @param error   if true, prints in the System.err PrintStream instead of System.out.
     */
    public static void log(String message, boolean error) {
        message = "[v] " + message;
        if (verbose) {
            if (error)
                System.err.println(message);
            else
                System.out.println(message);
        }
    }

    public static void log(String message) {
        message = "[v] " + message;
        if (verbose) System.out.println(message);
    }

    public static void showError(Exception e) {
        if (isVerbose()) {
            log(String.format("A %s error occurred.", e.getCause()));
            log("Print Stacktrace? [y] [n]");
            System.out.print("[v] >> ");
            String input = consoleScanner.nextLine();
            if (input.equals("y"))
                e.printStackTrace();
        }
        else
            System.out.println("> There was a problem. Turn on verbose logging to see more.");
    }
}
