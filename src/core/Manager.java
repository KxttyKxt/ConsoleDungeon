package src.core;

import src.entities.Entity;
import src.entities.Player;
import src.items.Item;
import src.levels.Level;
import src.tiles.tiles.StairsUp;
import src.util.DebugLevel;
import src.util.Encyclopedia;
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

    private static LinkedList<Level> levels = new LinkedList<>();
    private static Level activeLevel;

    private static Player player = new Player();
    private static Inventory inventory = new Inventory();
    private static int turns = 0;

    public static void runGame() {

        if (Verbose.isVerbose()) {
            Verbose.log("Use custom level instead? [y] [n]", false);
            System.out.print(">> ");
            if (consoleScanner.nextLine().equalsIgnoreCase("y"))
                newLevel(new DebugLevel(), true);
            else {
                Verbose.log("Custom level denied. Moving on...", false);
                newLevel(12,8,true);
            }
        }
        else
            newLevel(12, 8, true);


        while (true) {
            System.out.println(activeLevel.levelLayout());
            System.out.println("> Turns: " + turns);
            System.out.print(turnPrompt());

            // CHAT I FINALLY FOUND A USE FOR DO-WHILE!!!
            do {
                System.out.print(">> ");
            } while (!controlPanel());
            turns++;
        }
    }

    /**
     * The main controller of game interactions. Parses player input commands and handles executing other methods.
     * @return true when a turn is taken and false when a turn is not taken
     * <p>
     * For example, controlPanel() will return true when the player moves successfully,
     * but if the player moves unsuccessfully, then controlPanel() returns false,
     * and the player can attempt to move again.
     * @see Entity
     * @see Player
     * @see Verbose
     */
    private static boolean controlPanel() {

        String input = consoleScanner.nextLine().toLowerCase(Locale.ROOT);

        // -=-=- hard control commands -=-=- (i.e., those with no parsing beyond a single word)
        switch (input) {
            // if it's a movement number
            case("1"): case("2"): case("3"): case("4"): case("5"): case("6"): case("7"): case("8"): case("9"): {
                return enactPlayer(Integer.parseInt(input));
            }
            // if q, quit
            case("q"): {
                System.out.printf("Exiting game. You took %d turns.%n%n", turns);
                System.exit(0);
                return false;
            }
            // if inv, open the inventory dialog
            case("inv"): {
                displayInventory();
                return false;
            }
            // verbose, toggle verbose logging
            case("verbose"): {
                Verbose.toggleVerbose();
                System.out.println("> Verbose logging is now " + Verbose.isVerbose() + ".");
                return false;
            }
        }

        // -=-=- soft controls -=-=-
        // help command
        if (input.startsWith("help")) {
            if (input.length() > 5) {
                Verbose.log(String.format("about to parse an extended help command. help is %d in length and starts at %d. Substring begins after %d.", input.length(), input.indexOf("help"), input.indexOf("help") + 5), false);
                StringBuilder helpDetails = Encyclopedia.getHelpType(input);
                System.out.print(helpDetails);
                return false;
            }
            else {
                System.out.printf("> Here is a list of commands you can use:%n> (move), inv, %n> Type \"help <command>\" for more info.%n");
                return false;
            }
        }
        System.out.println("> Command not recognized.");
        return false;
    }

    /**
     * Attempts to move the player based on user input and using the {@code Level.enactEntity()()} method.
     * @return true if the player moved, false if they didn't; pulls from enactEntity()() return value
     */
    private static boolean enactPlayer(int direction) {
        boolean turnTaken = false;
        int[] position = activeLevel.find(player, true);
        int row = position[0];
        int column = position[1];

        // Based on directional input, moves the player
        switch (direction) {
            // 1: Southwest: one down(+), one left(-)
            case 1 -> turnTaken = activeLevel.enactEntity(row, column, row+1, column-1);
            // 2: South: one down(+), zero left
            case 2 -> turnTaken = activeLevel.enactEntity(row, column, row+1, column);
            // 3: Southeast: one down (+), one right (+)
            case 3 -> turnTaken = activeLevel.enactEntity(row, column, row+1, column+1);
            // 4: West: zero down, one left (-)
            case 4 -> turnTaken = activeLevel.enactEntity(row, column, row, column-1);
            // 6: East: zero down, one right (+)
            case 6 -> turnTaken = activeLevel.enactEntity(row, column, row, column+1);
            // 7: Northwest: one up (-), one left (-)
            case 7 -> turnTaken = activeLevel.enactEntity(row, column, row-1, column-1);
            // 8: North: one up (-), zero right
            case 8 -> turnTaken = activeLevel.enactEntity(row, column, row-1, column);
            // 9: Northeast: one up (-), one right (+)
            case 9 -> turnTaken = activeLevel.enactEntity(row, column, row-1, column+1);

            case 5 -> {
                Item item = activeLevel.interact(player, player.getRow(), player.getColumn());
                if (item != null) {
                    inventory.addItem(item);
                    turnTaken = true;
                }
            }
        }

        return turnTaken;
    }

    /**
     * Constructs a new level and automatically adds to the LinkedList of levels.
     * @param domain the length of the coordinate plane along the x-axis
     * @param range the length of the coordinate plane along the y-axis
     * @param makeActive if true, also sets the new floor as the active level
     */
    private static void newLevel(int domain, int range, boolean makeActive){
        Level newLevel = new Level(domain,range);
        levels.add(newLevel);

        if (makeActive)
            activateLevel(newLevel);
    }
    public static void newLevel(Level newLevel, boolean makeActive) {
        levels.add(newLevel);

        if (makeActive) {
            activateLevel(newLevel);
        }
    }

    private static void activateLevel(Level level) {
        Verbose.log(String.format("Activating level from LinkedList index %d...", levels.indexOf(level)), false);
        activeLevel = level;
        if (activeLevel.find(player, false) == null) {
            player.setPosition(activeLevel.find(new StairsUp(new int[]{}), false));
            Verbose.log("Player wasn't found, adding it now...", false);
            if (activeLevel.addEntity(player)) {
                activeLevel.updateSymbol(player.getRow(), player.getColumn());
                Verbose.log(String.format("Player added at (%d, %d), updated symbol.", player.getRow(), player.getColumn()), false);
            }
            else {
                Verbose.log("Couldn't place player.", true);
            }
        }
        else
            Verbose.log("Player found, moving on...", false);
    }

    private static StringBuilder turnPrompt() {
        // This is easier for me to tell what's going on without concatenating strings
        StringBuilder controlsPrompt = new StringBuilder();
        controlsPrompt.append(String.format(">  7 8 9  |  Use Numpad to Move. Moving ends your turn.%n"));
        controlsPrompt.append(String.format(">  4 5 6  |  Enter \"help\" for more options.%n"));
        controlsPrompt.append(String.format(">  1 2 3  |  Enter \"q\" to quit.%n"));

        return controlsPrompt;
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
        // I am not about to learn AWT for this aaaa

        // Desktop version
        try {
            File inventoryFile = new File("inventory.txt");
            FileWriter fileWriter = new FileWriter(inventoryFile);
            fileWriter.write(String.format("%s%n", inventory.toString()));
            fileWriter.write(String.format("%n%n[Close this window when you're done. Modifying it does nothing.]"));
            fileWriter.close();

            if (Desktop.isDesktopSupported()) {
                Verbose.log(String.format("Desktop is supported, opening %s...", inventoryFile.getPath()), false);
                Desktop.getDesktop().open(inventoryFile);
            } else {
                Verbose.log(String.format("Desktop is not supported. File at %s must be opened manually.", inventoryFile.getAbsolutePath()), true);
                System.out.printf("> Desktop framework is not supported on your device.%n> You'll have to open %s yourself in the project files.%n", inventoryFile.getPath());
            }
        } catch (IOException e) {
            Verbose.showError(e);
        }
    }
}
