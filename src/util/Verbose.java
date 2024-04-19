package src.util;

public class Verbose {
    private static boolean verbose = false;

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
    public static void verboseLog(String message, boolean error) {
        message = "[v] " + message;
        if (verbose) {
            if (error)
                System.err.println(message);
            else
                System.out.println(message);
        }
    }

    public static void verboseLog(String message) {
        message = "[v] " + message;
        if (verbose) System.out.println(message);
    }
}
