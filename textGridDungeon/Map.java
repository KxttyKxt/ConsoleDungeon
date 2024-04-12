package textGridDungeon;

import textGridDungeon.entities.entities.Player;
import textGridDungeon.tiles.StairsDown;
import textGridDungeon.tiles.StairsUp;

import javax.swing.*;
import java.util.Random;

public class Map {

    private Coordinate[][] coordinates; // a 2D array of coordinates according to the length and width

    /**
     * The default constructor for the map class, which creates a map (or "floor") of the dungeon.
     */
    public Map() {
        coordinates = new Coordinate[5][5];
        initMap();
    }

    /**
     * The dynamic constructor for the map class, which creates a map (or "floor") of the dungeon.
     *
     * @param domain the length of the coordinates plane along the x-axis
     * @param range the length of the coordinates plane along the y-axis
     *
     */
    public Map(int domain, int range) {
        coordinates = new Coordinate[range][domain];
        initMap();
    }

    /**
     * Initializes the 2D array of coordinates and adds the necessary Tiles.
     * Used only in the constructor.
     */
    private void initMap() {
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[i].length; j++) {
                coordinates[i][j] = new Coordinate();
            }
        }

        // -=-=- Things here are something every floor needs. -=-=-
        Random tileRNG = new Random();
        int row = tileRNG.nextInt(coordinates.length);
        int column = tileRNG.nextInt(coordinates[0].length);

        // Creates Stairs up to the previous floor and places the player on it.
        Coordinate entryPoint = coordinates[row][column];
        entryPoint.setTile(new StairsUp());
        entryPoint.setEntity(new Player());

        // Continuously try to put StairsDown not on the tile of the StairsUp
        while(true) {
            row = tileRNG.nextInt(coordinates.length);
            column = tileRNG.nextInt(coordinates[0].length);

            if (!coordinates[row][column].equals(entryPoint)) {
                coordinates[row][column].setTile(new StairsDown());
                break;
            }
        }
    }

    public void printMap() {
        StringBuilder mapPrint = new StringBuilder();
        mapPrint.append("=".repeat(coordinates[0].length * 5 + 2));

        mapPrint.append(String.format("%n"));

        for (Coordinate[] x : coordinates) {
            mapPrint.append("|");
            for (Coordinate y : x) {
                y.updateSymbol();
                mapPrint.append("  ").append(y.getSymbol()).append("  ");
            }
            mapPrint.append(String.format("|%n"));
        }

        mapPrint.append("=".repeat(coordinates[0].length * 5 + 2));
        System.out.println(mapPrint);
    }
}
