package src.core;

import src.entities.entities.Player;
import src.tiles.StairsUp;
import src.util.Verbose;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

public class Manager {
    private static Scanner consoleScanner = new Scanner(System.in);

    private static LinkedList<Map> floors = new LinkedList<>();
    private static Map activeFloor;

    private static Player player = new Player();
    private static Inventory inventory = new Inventory();
    private static int turns = 0;

    private static boolean controlPanel() {

        String input = "";

        input = consoleScanner.nextLine().toLowerCase(Locale.ROOT);

        // hard control commands (i.e., those with no parsing beyond a single word)
        switch (input) {
            // case "q" -> (nothing)
            // if it's a movement number
            case("1"): case("2"): case("3"): case("4"): case("5"): case("6"): case("7"): case("8"): case("9"): {
                movePlayer(Integer.parseInt(input));
                return false;
            }
            case("q"): {
                System.out.printf("Exiting game. You took %d turns.", turns);
                System.exit(0);
            }
            case("inv"): {
                displayInventory();
            }
        }

        // soft controls
        if (input.startsWith("help")) {
            if (input.length() > 5) {
                Verbose.verboseLog(String.format("about to parse an extended help command. help is %d in length and starts at %d. Substring begins after %d.", input.length(), input.indexOf("help"), input.indexOf("help") + 5));
                String helpType = input.substring(input.indexOf("help") + 5);
                StringBuilder helpDetails = new StringBuilder();

                switch (helpType) {
                    case "move" -> {
                        helpDetails.append(String.format("> -=-=- move -=-=-%n"));
                        helpDetails.append(String.format("> takes turn: yes%n"));
                        helpDetails.append(String.format("> usage: >> # (1-9) (e.g., 7)%n"));
                        helpDetails.append(String.format("> Imagine 5 on your Numpad as the center. A key away from 5 moves you in that direction.%n"));
                        helpDetails.append(String.format("> For example, entering 7 moves you northwest (if possible).%n"));
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
                System.out.print(helpDetails);
            }
            else
                System.out.printf("> Here is a list of commands you can use:%n> (move), inv, %n> Type \"help <command>\" for more info.%n");
        }
        System.out.print(">> ");
        return true;
    }

    /**
     * Attempts to move the player based on user input and using the {@code Map.moveEntity()} method.
     * @return true if the player moved, false if they didn't; pulls from moveEntity() return value
     */
    private static boolean movePlayer(int direction) {
        boolean moved = false;
        int[] position = activeFloor.find(player);
        int row = position[0];
        int column = position[1];

        switch (direction) {
            // 1: Southwest: one down(+), one left(-)
            case 1 -> moved = activeFloor.moveEntity(row, column, row+1, column-1);
            // 2: South: one down(+), zero left
            case 2 -> moved = activeFloor.moveEntity(row, column, row+1, column);
            // 3: Southeast: one down (+), one right (+)
            case 3 -> moved = activeFloor.moveEntity(row, column, row+1, column+1);
            // 4: West: zero down, one left (-)
            case 4 -> moved = activeFloor.moveEntity(row, column, row, column-1);
            // 6: East: zero down, one right (+)
            case 6 -> moved = activeFloor.moveEntity(row, column, row, column+1);
            // 7: Northwest: one up (-), one left (-)
            case 7 -> moved = activeFloor.moveEntity(row, column, row-1, column-1);
            // 8: North: one up (-), zero right
            case 8 -> moved = activeFloor.moveEntity(row, column, row-1, column);
            // 9: Northeast: one up (-), one right (+)
            case 9 -> moved = activeFloor.moveEntity(row, column, row-1, column+1);

            case 5 -> System.out.println("Waiting this turn...");
        }

        return moved;
    }

    /**
     * Constructs a new map and automatically adds to the LinkedList of floors.
     * @param domain the length of the coordinate plane along the x-axis
     * @param range the length of the coordinate plane along the y-axis
     * @param makeActive if true, also sets the new floor as the active floor
     */
    private static void newMap(int domain, int range, boolean makeActive){
        Map newMap = new Map(domain,range);
        floors.add(newMap);

        if (makeActive) {
            activeFloor = newMap;

            int[] indexes = activeFloor.find(new StairsUp());
            activeFloor.getCoordinates()[indexes[0]][indexes[1]].setEntity(player);
        }
    }

    private static StringBuilder turnPrompt() {
        // This is easier for me to tell what's going on without concatenating strings
        StringBuilder controlsPrompt = new StringBuilder();
        controlsPrompt.append(String.format(">  1 2 3  |  Use Numpad to Move. Moving ends your turn.%n"));
        controlsPrompt.append(String.format(">  4 5 6  |  Enter \"help\" for more options.%n"));
        controlsPrompt.append(String.format(">  7 8 9  |  Enter \"q\" to quit.%n"));
        controlsPrompt.append(">> ");

        return controlsPrompt;
    }

    public static void runGame() {
        newMap(12, 8, true);
        while (true) {
            activeFloor.printMap();
            System.out.print(turnPrompt());
            while (controlPanel()) {}
            turns++;
        }
    }

    private static void displayInventory() {
        // -=-=- JOptionPane -=-=-  problem is, it pauses code until the window is closed.
//        Verbose.verboseLog("JOptionPane \"Inventory\" opened as OK_CANCEL_OPTION as a PLAIN_MESSAGE. You might have to alt-tab to see it.");
//        int action = JOptionPane.showOptionDialog(null,
//                inventory,
//                "Inventory",
//                JOptionPane.OK_CANCEL_OPTION,
//                JOptionPane.PLAIN_MESSAGE,
//                null,
//                new String[]{"Refresh", "Close"},
//                null);
//        if (action == 0)
//            displayInventory();

        // -=-=- JDialog -=-=-  hopefully this works right, something about JOptionPane being modal
        // I am not about to learn AWT for this shit

        // Desktop version
        try {
            File inventoryFile = new File("src/core/textOutputs/inventory.txt");
            FileWriter fileWriter = new FileWriter(inventoryFile);
            fileWriter.write(String.format("%s%n", inventory.toString()));
            fileWriter.write(String.format("%n%n[Close this window when you're done. Modifying it does nothing.]"));
            fileWriter.close();

            if (Desktop.isDesktopSupported()) {
                Verbose.verboseLog(String.format("Desktop is supported, opening %s...", inventoryFile.getPath()));
                Desktop.getDesktop().open(inventoryFile);
            } else {
                Verbose.verboseLog(String.format("Desktop is not supported. File at %s must be opened manually.", inventoryFile.getAbsolutePath()), true);
                System.out.printf("> Desktop framework is not supported on your device.%n> You'll have to open %s yourself in the project files.%n", inventoryFile.getPath());
            }
        } catch (IOException e) {
            Verbose.verboseLog("A FileIO error occurred.");
        }
    }
}
