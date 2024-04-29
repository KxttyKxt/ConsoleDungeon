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
        message = buildMessage(message);
        if (verbose) {
            if (error)
                System.err.println(message);
            else
                System.out.println(message);
        }
    }

    public static void log(String message) {
        message = buildMessage(message);
        if (verbose) System.out.println(message);
    }

    public static void showError(Exception e) {
        if (isVerbose()) {
            log(String.format("A %s error occurred.", e.getCause()));
            log("Print Stacktrace? [y] [n]");
            System.out.print(ConsoleColors.TEXT_YELLOW + "[v] >> " + ConsoleColors.TEXT_RESET);
            String input = consoleScanner.nextLine();
            if (input.equals("y"))
                e.printStackTrace();
        }
        else
            System.out.println("> There was a problem. Turn on verbose logging to see more.");
    }

    private static String buildMessage(String baseMessage) {
        StringBuilder messageBuilder = new StringBuilder(baseMessage);
        messageBuilder.insert(0, "[v] ");
        messageBuilder.insert(0, ConsoleColors.TEXT_YELLOW);
        messageBuilder.append(ConsoleColors.TEXT_RESET);
        return messageBuilder.toString();
    }
}
