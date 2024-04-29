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
 * @TGDRNote I (kxttykxt) have made this class Static so that I need not create a new object inside every class of my own. I have also removed the majority of methods, as many were strictly object-related and therefore redundant.
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
}
