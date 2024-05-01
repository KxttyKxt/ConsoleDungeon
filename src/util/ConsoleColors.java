/*
 * This software is licensed under the LPGLv3.
 */
package src.util;

/**
 * This is a class to help printing colored text in the console
 * 2021.04.18
 * This software is licensed under the LGPLv3
 * @author Christian van Langendonck
 * <p>
 * @TGDRNote I (kxttykxt) have made this class Static so that I need not create a new object inside every class of my own.
 * I have also removed the majority of methods, as many were strictly object-related and therefore redundant.
 * <p>
 * [{@code See Also:} is things I have added as well.]
 * @see src.entities.Player
 * @see src.entities.entities.Pumpkin
 */
public class ConsoleColors {

    //Set of strings with the preset ANSI color codes
    public static final String TEXT_RESET  = "\u001B[0m";

    public static final String TEXT_BLACK  = "\u001B[30m";
    public static final String TEXT_RED    = "\u001B[31m";
    public static final String TEXT_GREEN  = "\u001B[32m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_BLUE   = "\u001B[34m";
    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_CYAN   = "\u001B[36m";
    public static final String TEXT_WHITE  = "\u001B[37m";

    public static final String TEXT_BRIGHT_BLACK  = "\u001B[90m";
    public static final String TEXT_BRIGHT_RED    = "\u001B[91m";
    public static final String TEXT_BRIGHT_GREEN  = "\u001B[92m";
    public static final String TEXT_BRIGHT_YELLOW = "\u001B[93m";
    public static final String TEXT_BRIGHT_BLUE   = "\u001B[94m";
    public static final String TEXT_BRIGHT_PURPLE = "\u001B[95m";
    public static final String TEXT_BRIGHT_CYAN   = "\u001B[96m";
    public static final String TEXT_BRIGHT_WHITE  = "\u001B[97m";

    public static final String TEXT_BG_BLACK  = "\u001B[40m";
    public static final String TEXT_BG_RED    = "\u001B[41m";
    public static final String TEXT_BG_GREEN  = "\u001B[42m";
    public static final String TEXT_BG_YELLOW = "\u001B[43m";
    public static final String TEXT_BG_BLUE   = "\u001B[44m";
    public static final String TEXT_BG_PURPLE = "\u001B[45m";
    public static final String TEXT_BG_CYAN   = "\u001B[46m";
    public static final String TEXT_BG_WHITE  = "\u001B[47m";

    public static final String TEXT_BRIGHT_BG_BLACK  = "\u001B[100m";
    public static final String TEXT_BRIGHT_BG_RED    = "\u001B[101m";
    public static final String TEXT_BRIGHT_BG_GREEN  = "\u001B[102m";
    public static final String TEXT_BRIGHT_BG_YELLOW = "\u001B[103m";
    public static final String TEXT_BRIGHT_BG_BLUE   = "\u001B[104m";
    public static final String TEXT_BRIGHT_BG_PURPLE = "\u001B[105m";
    public static final String TEXT_BRIGHT_BG_CYAN   = "\u001B[106m";
    public static final String TEXT_BRIGHT_BG_WHITE  = "\u001B[107m";

    //Array with all color codes, used to validate colors
    private static final String[] ALL_COLORS = {TEXT_BLACK, TEXT_RED, TEXT_GREEN,
        TEXT_YELLOW, TEXT_BLUE, TEXT_PURPLE, TEXT_CYAN, TEXT_WHITE, TEXT_BRIGHT_BLACK,
        TEXT_BRIGHT_RED, TEXT_BRIGHT_GREEN, TEXT_BRIGHT_YELLOW, TEXT_BRIGHT_BLUE,
        TEXT_BRIGHT_PURPLE, TEXT_BRIGHT_CYAN, TEXT_BRIGHT_WHITE, TEXT_BG_BLACK,
        TEXT_BG_RED, TEXT_BG_GREEN, TEXT_BG_YELLOW, TEXT_BG_BLUE, TEXT_BG_PURPLE,
        TEXT_BG_CYAN, TEXT_BG_WHITE, TEXT_BRIGHT_BG_BLACK, TEXT_BRIGHT_BG_RED,
        TEXT_BRIGHT_BG_GREEN, TEXT_BRIGHT_BG_YELLOW, TEXT_BRIGHT_BG_BLUE,
        TEXT_BRIGHT_BG_PURPLE, TEXT_BRIGHT_BG_CYAN, TEXT_BRIGHT_BG_WHITE};

    /**
     * This method checks if the color String has a valid ANSI color code
     * @param color (ANSI string color code)
     * @return true if parameter is a valid color
     */
    private static boolean isValidColor(String color){
        if (color == null) color = "";
        for (String checker : ALL_COLORS) {
            if (color.equals(checker)) return true;
        }
        return false;
    }

    /**
     * Builds a String concatenated with the ANSI color code. The ANSI code to
     * reset the formatting is appended to the end of the new String. If String
     * color is NULL, or if it contains an invalid ANSI code, no formatting will
     * be applied
     * @param bgColor ANSI String with the background color
     * @param textColor ANSI String with the text color
     * @param str Text String to apply color styles
     * @return String
     */
    public static String buildColoredString(String bgColor, String textColor, String str){
        String toReturn = "";
        if (bgColor != null && isValidColor(bgColor)) toReturn += bgColor;
        if (textColor != null && isValidColor(textColor)) toReturn += textColor;
        return toReturn + str + TEXT_RESET;
    }

    /**
     * Builds a String concatenated with the ANSI color code. The ANSI code to
     * reset the formatting is appended to the end of the new String. If String
     * color is NULL, or if it contains an invalid ANSI code, no formatting will
     * be applied.
     * @TGDRNote I overloaded the above method to apply more text formatting after instead of the reset code.
     * @param bgColor ANSI String with the background color
     * @param textColor ANSI String with the text color
     * @param str Text String to apply color styles
     * @param afterBgColor Instead of the TEXT_RESET, this is applied at the end.
     * @param afterTextColor Instead of the TEXT_RESET, this is applied at the end.
     * @return String
     */
    public static String buildColoredString(String bgColor, String textColor, String str, String afterBgColor, String afterTextColor) {
        String toReturn = "";
        if (bgColor != null && isValidColor(bgColor)) toReturn += bgColor;
        if (textColor != null && isValidColor(textColor)) toReturn += textColor;
        toReturn += str;
        if (afterBgColor != null && isValidColor(afterBgColor)) toReturn += afterBgColor;
        if (afterTextColor != null && isValidColor(afterTextColor)) toReturn += afterTextColor;
        return toReturn;
    }

    /**
     * Prints a key for what all the color (background) codes look like.
     * @TGDRNote I made this myself smile
     */
    public static void main(String[] args) {
        StringBuilder toPrint = new StringBuilder();
        toPrint.append(TEXT_RESET).append(String.format("%-27s", "[Reset Text]"));

        toPrint.append("\n\n");

        toPrint.append(TEXT_BLACK).append(String.format("%-27s", "[Black Text] "));
        toPrint.append(TEXT_RED).append(String.format("%-27s", "[Red Text] "));
        toPrint.append(TEXT_GREEN).append(String.format("%-27s", "[Green Text] "));
        toPrint.append(TEXT_YELLOW).append(String.format("%-27s", "[Yellow Text] "));
        toPrint.append(TEXT_RESET).append("\n");
        toPrint.append(TEXT_BLUE).append(String.format("%-27s", "[Blue Text] "));
        toPrint.append(TEXT_PURPLE).append(String.format("%-27s", "[Purple Text] "));
        toPrint.append(TEXT_CYAN).append(String.format("%-27s", "[Cyan Text] "));
        toPrint.append(TEXT_WHITE).append(String.format("%-27s", "[White Text]"));

        toPrint.append(TEXT_RESET).append("\n\n");

        toPrint.append(TEXT_BRIGHT_BLACK).append(String.format("%-27s", "[Bright Black Text] "));
        toPrint.append(TEXT_BRIGHT_RED).append(String.format("%-27s", "[Bright Red Text] "));
        toPrint.append(TEXT_BRIGHT_GREEN).append(String.format("%-27s", "[Bright Green Text] "));
        toPrint.append(TEXT_BRIGHT_YELLOW).append(String.format("%-27s", "[Bright Yellow Text] "));
        toPrint.append(TEXT_RESET).append("\n");
        toPrint.append(TEXT_BRIGHT_BLUE).append(String.format("%-27s", "[Bright Blue Text] "));
        toPrint.append(TEXT_BRIGHT_PURPLE).append(String.format("%-27s", "[Bright Purple Text] "));
        toPrint.append(TEXT_BRIGHT_CYAN).append(String.format("%-27s", "[Bright Cyan Text] "));
        toPrint.append(TEXT_BRIGHT_WHITE).append(String.format("%-27s", "[Bright White Text]"));

        toPrint.append(TEXT_RESET).append("\n\n");

        toPrint.append(TEXT_BG_BLACK).append(String.format("%-27s", "[Black Background] "));
        toPrint.append(TEXT_BG_RED).append(String.format("%-27s", "[Red Background] "));
        toPrint.append(TEXT_BG_GREEN).append(String.format("%-27s", "[Green Background] "));
        toPrint.append(TEXT_BG_YELLOW).append(String.format("%-27s", "[Yellow Background] "));
        toPrint.append(TEXT_RESET).append("\n");
        toPrint.append(TEXT_BG_BLUE).append(String.format("%-27s", "[Blue Background] "));
        toPrint.append(TEXT_BG_PURPLE).append(String.format("%-27s", "[Purple Background] "));
        toPrint.append(TEXT_BG_CYAN).append(String.format("%-27s", "[Cyan Background] "));
        toPrint.append(TEXT_BG_WHITE).append(String.format("%-27s", "[White Background]"));

        toPrint.append(TEXT_RESET).append("\n\n");

        toPrint.append(TEXT_BRIGHT_BG_BLACK).append(String.format("%-27s", "[Bright Black Background] "));
        toPrint.append(TEXT_BRIGHT_BG_RED).append(String.format("%-27s", "[Bright Red Background] "));
        toPrint.append(TEXT_BRIGHT_BG_GREEN).append(String.format("%-27s", "[Bright Green Background] "));
        toPrint.append(TEXT_BRIGHT_BG_YELLOW).append(String.format("%-27s", "[Bright Yellow Background] "));
        toPrint.append(TEXT_RESET).append("\n");
        toPrint.append(TEXT_BRIGHT_BG_BLUE).append(String.format("%-27s", "[Bright Blue Background] "));
        toPrint.append(TEXT_BRIGHT_BG_PURPLE).append(String.format("%-27s", "[Bright Purple Background] "));
        toPrint.append(TEXT_BRIGHT_BG_CYAN).append(String.format("%-27s", "[Bright Cyan Background] "));
        toPrint.append(TEXT_BRIGHT_BG_WHITE).append(TEXT_BLACK).append(String.format("%-27s", "[Bright White Background]"));

        toPrint.append(TEXT_RESET).append(String.format("%n%nANSI codes (as strings) in each section are %s | %s | %s | %s | %s characters long respectively.",
                        TEXT_RESET.length(),
                        TEXT_WHITE.length(),
                        TEXT_BRIGHT_WHITE.length(),
                        TEXT_BG_WHITE.length(),
                        TEXT_BRIGHT_BG_WHITE.length()
                ));
        // Interesting...that must mean the escaped "\u001B" is a special character.
        // Copy-pasting it gives me "".

        System.out.println(toPrint);
    }
}
