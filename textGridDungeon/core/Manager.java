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

    public static boolean movePlayer() {
        System.out.printf("Pick a direction to move with your numpad.%n> 7 8 9%n> 4 - 6%n> 1 2 3%n>> ");
        int direction = Integer.parseInt(consoleScanner.nextLine());
        int[] position = activeFloor.find(player);
        int y = position[0]; int x = position[1];
        boolean moved = false;

        switch (direction) {
            // 1: Southwest: one down(+), one left(-)
            case 1 -> moved = activeFloor.moveEntity(y, x, y+1, x-1);
            // 2: South: one down(+), zero left
            case 2 -> moved = activeFloor.moveEntity(y, x, y+1, x);
            // 3: Southeast: one down (+), one right (+)
            case 3 -> moved = activeFloor.moveEntity(y, x, y+1, x+1);
            // 4: West: zero down, one left (-)
            case 4 -> moved = activeFloor.moveEntity(y, x, y, x-1);
            // 6: East: zero down, one right (+)
            case 6 -> moved = activeFloor.moveEntity(y, x, y, x+1);
            // 7: Northwest: one up (-), one left (-)
            case 7 -> moved = activeFloor.moveEntity(y, x, y-+1, x-1);
            // 8: North: one up (-), zero right
            case 8 -> moved = activeFloor.moveEntity(y, x, y-1, x);
            // 9: Northeast: one up (-), one right (+)
            case 9 -> moved = activeFloor.moveEntity(y, x, y-1, x+1);
            default -> System.err.println("You cannot move there.");
        }

        return moved;
    }

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
