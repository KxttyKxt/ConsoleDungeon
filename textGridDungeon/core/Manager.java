package textGridDungeon.core;

import textGridDungeon.entities.entities.Player;
import textGridDungeon.tiles.StairsUp;

import java.util.LinkedList;
import java.util.Scanner;

public class Manager {
    private static Scanner consoleScanner = new Scanner(System.in);

    private static LinkedList<Map> floors = new LinkedList<>();
    private static Map activeFloor;

    private static Player player = new Player();
    private static Inventory inventory = new Inventory();

    /**
     * Attempts to move the player based on user input and using the {@code Map.moveEntity()} method.
     * @return
     */
    public static boolean movePlayer() {
        System.out.printf("Pick a direction to move with your numpad.%n> 7 8 9%n> 4 - 6%n> 1 2 3%n> (or type q to quit)%n>> ");
        String input = consoleScanner.nextLine();
        if (input.equals("q"))
            System.exit(0);

        int direction = Integer.parseInt(input);
        int[] position = activeFloor.find(player);
        int row = position[0]; int column = position[1];
        boolean moved = false;

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
            case 7 -> moved = activeFloor.moveEntity(row, column, row-+1, column-1);
            // 8: North: one up (-), zero right
            case 8 -> moved = activeFloor.moveEntity(row, column, row-1, column);
            // 9: Northeast: one up (-), one right (+)
            case 9 -> moved = activeFloor.moveEntity(row, column, row-1, column+1);
            default -> System.err.println("You cannot move there.");
        }

        return moved;
    }

    /**
     * Constructs a new map and automatically adds to the LinkedList of floors.
     * @param domain the length of the coordinate plane along the x-axis
     * @param range the length of the coordinate plane along the y-axis
     * @param makeActive if true, also sets the new floor as the active floor
     */
    public static void newMap(int domain, int range, boolean makeActive){
        Map newMap = new Map(domain,range);
        floors.add(newMap);

        if (makeActive) {
            activeFloor = newMap;

            int[] indexes = activeFloor.find(new StairsUp());
            activeFloor.getCoordinates()[indexes[0]][indexes[1]].setEntity(player);
        }
    }

    public static void runGame() {
        while (true) {
            activeFloor.printMap();
            movePlayer();
        }
    }
}
