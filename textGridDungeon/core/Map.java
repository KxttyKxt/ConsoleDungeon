package textGridDungeon.core;

import textGridDungeon.entities.entities.Entity;
import textGridDungeon.entities.entities.Player;
import textGridDungeon.items.Item;
import textGridDungeon.tiles.StairsDown;
import textGridDungeon.tiles.StairsUp;
import textGridDungeon.tiles.Tile;

import java.util.List;
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

        // Creates Stairs up to the previous floor and places the player on it.
        Random tileRNG = new Random();
        int row = tileRNG.nextInt(coordinates.length);
        int column = tileRNG.nextInt(coordinates[0].length);

        Coordinate entryPoint = coordinates[row][column];
        int stairsUpRow = row;
        int stairsUpCol = column;
        entryPoint.setTile(new StairsUp());

        System.out.printf("Stairs Up created at %d, %d%n", row, column);

        // Continuously try to put StairsDown far away from StairsUp
        int attempt = 1;
        while(true) {
            if (attempt <= 10) {
                row = tileRNG.nextInt(coordinates.length);
                column = tileRNG.nextInt(coordinates[0].length);

                double distance = calculateDistance(stairsUpRow, stairsUpCol, row, column);
                double minDistance = (((double) coordinates.length / 2) + ((double) coordinates[0].length / 2)) / 1.5;

                if (distance > minDistance) {
                    coordinates[row][column].setTile(new StairsDown());
                    System.out.printf("Stairs Down Created with suitable distance %.3f, minimum %.3f%n", distance, minDistance);
                    break;
                }
                System.out.printf("(%d,%d) was too close to stairs up at (%d,%d), actual distance %.3f, minimum distance%.3f.%n",
                        row, column, stairsUpRow, stairsUpCol, distance, minDistance);
            }
            else {
                if (!coordinates[row][column].equals(entryPoint)) {
                    coordinates[row][column].setTile(new StairsDown());
                    System.out.println("Stairs down created after giving up.");
                    break;
                }
            }
            attempt++;
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

    public Coordinate[][] getCoordinates() {
        return coordinates;
    }

    public boolean insert(int row, int column, Item item) {
        coordinates[row][column].addItem(item);
        return true;
    }
    public boolean insert(int row, int column, Entity entity) {
        if (coordinates[row][column].getEntity() == null)
            return false;

        coordinates[row][column].setEntity(entity);
        return true;
    }
    public boolean moveEntity(int startRow, int startColumn, int endRow, int endColumn) {
        Coordinate start;
        Coordinate end;
        Entity entityToMove;
        try {
            start = coordinates[startRow][startColumn];
            end = coordinates[endRow][endColumn];
            entityToMove = start.getEntity();

            if (entityToMove == null || end.getEntity() != null)
                return false;

            start.setEntity(null);
            end.setEntity(entityToMove);
            start.updateSymbol();
            end.updateSymbol();
            return true;

        } catch (Exception e) {
            System.err.println("Entity cannot move there.");
            return false;
        }
    }

    /**
     * Searches linearly through the map for an Entity.
     * @param entity The Entity being searched for, which may or may not exist
     * @return the 2D {@code array[i][j]} index for the Entity, or {@code null} if not found.
     */
    public int[] find(Entity entity) {
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[i].length; j++) {
                if (entity.equals(coordinates[i][j].getEntity()))
                    return new int[]{i, j};
            }
        }
        return null;
    }

    /**
     * Searches linearly through the map for a specified Item.
     * @param item The Item being searched for, which may or may not exist.
     * @return the 2D {@code array[i][j]} index for the Item, as well as its index {@code k} in the Stack/List, or {@code null} if not found
     */
    public int[] find(Item item) {
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[i].length; j++) {
                List<Item> items = coordinates[i][j].getItems();
                if (!items.isEmpty()) {
                    for (int k = 0; k < coordinates[i][j].getItems().size(); k++) {
                        if (item.equals(items.get(k)))
                            return new int[]{i, j, k};
                    }
                }
            }
        }
        return null;
    }
    /**
     * Searches linearly through the map for a Tile.
     * @param tile The Tile being searched for, which may or may not exist
     * @return the 2D {@code array[i][j]} index for the Tile, or {@code null} if not found.
     */
    public int[] find(Tile tile) {
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[i].length; j++) {
                if (coordinates[i][j].getTile().equals(tile))
                    return new int[]{i, j};
            }
        }
        return null;
    }

    public double calculateDistance(int startRow, int startCol, int endRow, int endCol) {
        double a, b, c;
        a = Math.abs(endRow - startRow);
        b = Math.abs(endCol - startCol);
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }
}
