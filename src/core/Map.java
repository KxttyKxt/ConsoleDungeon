package src.core;

import src.entities.Entity;
import src.items.Item;
import src.tiles.tiles.Floor;
import src.tiles.tiles.StairsDown;
import src.tiles.tiles.StairsUp;
import src.tiles.Tile;
import src.util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map {

    private Coordinate[][] coordinates; // a 2D array of coordinates according to the length and width

    private ArrayList<Entity> activeEntities;   // Entities stored on the Map...
    private ArrayList<Item> activeItems;        // Items stored on the Map...
    private ArrayList<Tile> activeTiles;        // Tiles stored on the Map...
    // ... to be updated as needed, probably every turn.

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
     * @param domain the length of the coordinate plane along the x-axis
     * @param range the length of the coordinate plane along the y-axis
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
        // Initialize lists
        activeEntities = new ArrayList<>();
        activeItems = new ArrayList<>();
        activeTiles = new ArrayList<>();

        // -=-=- Things here are something every floor needs. -=-=-

        // Creates Stairs up to the previous floor and places the player on it.
        Random tileRNG = new Random();
        int row = tileRNG.nextInt(coordinates.length);
        int column = tileRNG.nextInt(coordinates[0].length);

        StairsUp stairsUp = new StairsUp(new int[]{row, column});
        activeTiles.add(stairsUp);
        Verbose.log(String.format("Stairs Up created at %d, %d", row, column));

        // Continuously try to put StairsDown far away from StairsUp
        int attempt = 0;
        while(true) {
            StairsDown stairsDown;
            row = tileRNG.nextInt(coordinates.length);
            column = tileRNG.nextInt(coordinates[0].length);

            double distance = Math.hypot(stairsUp.getRow()-row, stairsUp.getColumn()-column);
            double minDistance = ((coordinates.length / 3.0) + (coordinates[0].length / 3.0) * (1 - (attempt*0.05)));

            if (distance > minDistance) {
                stairsDown = new StairsDown(new int[]{row, column});
                Verbose.log(String.format("Stairs Down Created with suitable distance %.3f, minimum %.3f", distance, minDistance));
                break;
            }
            Verbose.log(String.format("attempt %d: (%d,%d) was too close to stairs up at (%d,%d), actual distance %.3f, minimum distance %.3f.",
                    ++attempt, row, column, stairsUp.getRow(), stairsUp.getColumn(), distance, minDistance));
        }
    }

    public void printMap() {
        StringBuilder mapPrint = new StringBuilder();
        mapPrint.append("=".repeat(coordinates[0].length * 5 + 2)).append(String.format("%n"));

        for (Coordinate[] x : coordinates) {
            mapPrint.append("|");
            for (Coordinate y : x) {
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

    /**
     * Move an entity from one coordinate to another, then update the coordinate it left and the coordinate it entered.
     * Coordinates is a 2D array.
     * @param startRow      The first array index of the starting position
     * @param startColumn   The second array index of the starting position
     * @param endRow        The first array index of the ending position
     * @param endColumn     The second array index of the ending position
     * @return true if the entity moved successfully, false if movement was unsuccessful.
     */
    public boolean moveEntity(int startRow, int startColumn, int endRow, int endColumn) {
        Coordinate start;
        Coordinate end;
        Entity entityToMove;
        try {
            start = coordinates[startRow][startColumn];
            end = coordinates[endRow][endColumn];
            entityToMove = start.getEntity();

            if (entityToMove == null) {
                System.out.println("> Somehow, there was nothing to move!");
                Verbose.log("No entity found at start position.", true);
                return false;
            } else if (end.getEntity() != null) {
                System.out.printf("> A %s stands in your way!%n", end.getEntity().getName());
                Verbose.log("Entity in the way at end position.", true);
                return false;
            }
            if (!end.getTile().isTraversable()) {
                System.out.printf("> A %s blocks your path!%n", end.getTile().getName());
                Verbose.log("The end tile is not traversable.", true);
                return false;
            }

            start.setEntity(null);
            end.setEntity(entityToMove);
            start.updateSymbol();
            end.updateSymbol();
            return true;

        } catch (Exception e) {
            if (e.getClass() == ArrayIndexOutOfBoundsException.class)
                System.out.println("> You cannot move there!");
            if (Verbose.isVerbose())
                Verbose.showError(e);
            return false;
        }
    }

    /**
     * Searches linearly through the list of active entities to find a match, then gives its position.
     * @param target The Entity being searched for, which may or may not exist
     * @return the ordered pair {@code int[row][column]} indexes for the Entity as it shall appear on the map,
     * or {@code null} if not found.
     */
    public int[] find(Entity target) {
        for (Entity entity : activeEntities)
            if (entity.equals(target))
                return entity.getPosition();

        return null;
    }
    /**
     * Searches linearly through the list of active items to find a match, then gives its position.
     * @param target The Item being searched for, which may or may not exist
     * @return the ordered pair {@code int[row][column]} indexes for the Item as it shall appear on the map,
     * or {@code null} if not found.
     */
    public int[] find(Item target) {
        for (Item item : activeItems)
            if (item.equals(target))
                return item.getPosition();

        return null;
    }
    /**
     * Searches linearly through the list of active tiles to find a match, then gives its position.
     * @param target The Tile being searched for, which may or may not exist.
     * @return the ordered pair {@code int[row][column]} indexes for the Tile as it shall appear on the map,
     * or {@code null} if not found.
     */
    public int[] find(Tile target) {
        for (Tile tile : activeTiles)
            if (tile.equals(target))
                return tile.getPosition();

        return null;
    }

    public Entity getByPosition(int row, int column) {
        int[] position = new int[]{row, column};

        for (Entity entity : activeEntities)
            if (entity.getPosition() == position)
                return entity;

        return null;
    }
}
