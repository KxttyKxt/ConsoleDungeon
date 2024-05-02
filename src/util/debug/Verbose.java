package src.util.debug;

import src.util.ConsoleColors;

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
        message = buildMessage(message, error);
        if (verbose) {
            System.out.println(message);
        }
    }

    public static void showError(Exception e) {
        if (isVerbose()) {
            log(String.format("A %s error occurred.", e.getCause()), false);
            log("Print Stacktrace? [y] [n]", false);
            System.out.print(ConsoleColors.TEXT_BRIGHT_YELLOW + "[v] >> " + ConsoleColors.TEXT_RESET);
            String input = consoleScanner.nextLine();
            if (input.equals("y")) {
                System.out.print(ConsoleColors.TEXT_BRIGHT_RED);
                e.printStackTrace(System.out);
                System.out.println(ConsoleColors.TEXT_RESET);
            }
        }
        else
            System.out.println("> There was a problem. Turn on verbose logging to see more.");
    }

    private static String buildMessage(String baseMessage, boolean error) {
        StringBuilder messageBuilder = new StringBuilder(baseMessage);
        messageBuilder.insert(0, "[v] ");
        if (error)
            messageBuilder.insert(0, ConsoleColors.TEXT_BRIGHT_RED);
        else
            messageBuilder.insert(0, ConsoleColors.TEXT_BRIGHT_YELLOW);
        messageBuilder.append(ConsoleColors.TEXT_RESET);
        return messageBuilder.toString();
    }
}
