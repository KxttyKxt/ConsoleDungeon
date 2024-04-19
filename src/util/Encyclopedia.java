package src.util;

public class Encyclopedia {
    public static StringBuilder getHelpType(String input) {
        String helpType = input.substring(input.indexOf("help") + 5);
        StringBuilder helpDetails = new StringBuilder();

        switch (helpType) {
            case "move" -> {
                helpDetails.append(String.format("> -=-=- move -=-=-%n"));
                helpDetails.append(String.format("> takes turn: yes%n"));
                helpDetails.append(String.format("> usage: >> # (1-9) (e.g., 7)%n"));
                helpDetails.append(String.format("> Imagine 5 on your Numpad as the center. A key away from 5 moves you in that direction.%n"));
                helpDetails.append(String.format("> For example, entering 7 moves you northwest (if possible).%n"));
                helpDetails.append(String.format("> If you try to move to a non-traversable tile, you will be able to move elsewhere without losing a turn.%n"));
            }
            case "inv" -> {
                helpDetails.append(String.format("> -=-=- inv -=-=-%n"));
                helpDetails.append(String.format("> takes turn: no%n"));
                helpDetails.append(String.format("> usage: >> inv%n"));
                helpDetails.append(String.format("> Writes your inventory contents to a file at folder src/core/textOutputs.%n"));
                helpDetails.append(String.format("> If supported, it will also open the file in your default text editor.%n"));
            }
            default ->
                    helpDetails.append("argument command for \"help <command>\" not recognized.");
        }
        return helpDetails;
    }
}
