package src.core;

import src.entities.Entity;
import src.items.Item;
import src.tiles.tiles.StairsDown;
import src.tiles.tiles.StairsUp;
import src.tiles.Tile;
import src.util.*;

import java.util.ArrayList;
import java.util.Arrays;
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
     * Initializes the data structures contained in the map.
     * Used only in the constructor.
     */
    private void initMap() {
        // Initialize lists
        activeEntities = new ArrayList<>();
        activeItems = new ArrayList<>();
        activeTiles = new ArrayList<>();

        // Initialize each Coordinate
        for (int i = 0; i < coordinates.length; i++)
            for (int j = 0; j < coordinates[i].length; j++)
                coordinates[i][j] = new Coordinate();

        // -=-=- Things here are something every floor needs. -=-=-

        // Creates Stairs up to the previous floor and places the player on it.
        Random tileRNG = new Random();
        int row = tileRNG.nextInt(coordinates.length);
        int column = tileRNG.nextInt(coordinates[0].length);

        StairsUp stairsUp = new StairsUp(new int[]{row, column});
        activeTiles.add(stairsUp);
        updateSymbol(row, column);

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
                activeTiles.add(stairsDown);
                updateSymbol(stairsDown.getRow(), stairsDown.getColumn());
                Verbose.log(String.format("Stairs Down Created with suitable distance %.3f, minimum %.3f", distance, minDistance));
                break;
            }
            Verbose.log(String.format("attempt %d: (%d,%d) was too close to stairs up at (%d,%d), actual distance %.3f, minimum distance %.3f.",
                    ++attempt, row, column, stairsUp.getRow(), stairsUp.getColumn(), distance, minDistance));
        }
    }

    public StringBuilder mapLayout() {
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
        return mapPrint;
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
        Entity endEntity;
        Tile endTile;
        try {
            start = coordinates[startRow][startColumn];
            end = coordinates[endRow][endColumn];
            entityToMove = getEntityByPosition(startRow, startColumn);
            endEntity = getEntityByPosition(endRow, endColumn);
            endTile = getTileByPosition(endRow, endColumn);

            if (entityToMove == null) {
                System.out.println("> Somehow, there was nothing to move!");
                Verbose.log("No entity found at start position.", true);
                return false;
            } else if (endEntity != null) {
                System.out.printf("> A %s stands in your way!%n", endEntity.getName());
                Verbose.log("Entity in the way at end position.", true);
                return false;
            }
            if (endTile != null && !endTile.isTraversable()) {
                System.out.printf("> A %s blocks your path!%n", endTile.getName());
                Verbose.log("The end tile is not traversable.", true);
                return false;
            }

            entityToMove.setPosition(new int[]{endRow, endColumn});

            if (!updateSymbol(startRow, startColumn))
                coordinates[startRow][startColumn].setSymbol(".");
            if (!updateSymbol(endRow, endColumn))
                coordinates[endRow][endColumn].setSymbol(".");

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
     * @param checkPosition Whether the position of the target and potential match must have the same position.
     * @return the ordered pair {@code int[row][column]} indexes for the Entity as it shall appear on the map,
     * or {@code null} if not found.
     */
    public int[] find(Entity target, boolean checkPosition) {
        for (Entity entity : activeEntities)
            if (entity.equals(target, checkPosition))
                return entity.getPosition();

        return null;
    }
    /**
     * Searches linearly through the list of active items to find a match, then gives its position.
     * @param target The Item being searched for, which may or may not exist
     * @param checkPosition Whether the position of the target and potential match must have the same position.
     * @return the ordered pair {@code int[row][column]} indexes for the Item as it shall appear on the map,
     * or {@code null} if not found.
     */
    public int[] find(Item target, boolean checkPosition) {
        for (Item item : activeItems)
            if (item.equals(target, checkPosition))
                return item.getPosition();

        return null;
    }
    /**
     * Searches linearly through the list of active tiles to find a match, then gives its position.
     * @param target The Tile being searched for, which may or may not exist.
     * @param checkPosition Whether the position of the target and potential match must have the same position.
     * @return the ordered pair {@code int[row][column]} indexes for the Tile as it shall appear on the map,
     * or {@code null} if not found.
     */
    public int[] find(Tile target, boolean checkPosition) {
        for (Tile tile : activeTiles)
            if (tile.equals(target, checkPosition))
                return tile.getPosition();

        return null;
    }

    /**
     * The most generic search and return algorithm I could muster.
     * <p>
     * Using generics, simply checks if the runtime class of the input parameter
     * matches an active object ({@code entity}, {@code item}, {@code tile}) on the map.
     * <p>
     * Makes use of subclasses of those three abstract classes. Not intended for casting to an abstract class type.
     * @param type The object which you want to find a class match for.
     * @return The position of the object with the matching class.
     * @param <T> The generalized class type of your object
     */
    public <T> int[] classMatch(T type) {
        if (type instanceof Item) {
            for (Item item : activeItems)
                if (item.getClass() == type.getClass())
                    return item.getPosition();
        }
        else if (type instanceof Entity) {
            for (Entity entity : activeEntities)
                if (entity.getClass() == type.getClass())
                    return entity.getPosition();
        }
        else if (type instanceof Tile) {
            for (Tile tile : activeTiles)
                if (tile.getClass() == type.getClass())
                    return tile.getPosition();
        }
        else
            Verbose.log(String.format("%s is not applicable to classMatch()", type.getClass()), true);

        return new int[]{-1, -1};
    }

    /**
     * Searches linearly through the list of active entities to find a match by position,
     * then returns the entire Entity.
     * @param row The row of the coordinates plane in which the Entity would be.
     * @param column The column of the coordinates plane in which the Entity would be.
     * @return The entire Entity, if a matching one is found.
     */
    public Entity getEntityByPosition(int row, int column) {
        int[] position = new int[]{row, column};

        for (Entity entity : activeEntities)
            if (Arrays.equals(entity.getPosition(), position))
                return entity;

        return null;
    }
    /**
     * Searches linearly through the list of active items to find a match by position,
     * then returns the entire Item.
     * @param row The row of the coordinates plane in which the Item would be.
     * @param column The column of the coordinates plane in which the Item would be.
     * @return The entire Item, if a matching one is found.
     */
    public Item getItemByPosition(int row, int column) {
        int[] position = new int[]{row, column};

        for (Item item : activeItems)
            if (Arrays.equals(item.getPosition(), position))
                return item;

        return null;
    }
    /**
     * Searches linearly through the list of active tiles to find a match by position,
     * then returns the entire Tile.
     * @param row The row of the coordinates plane in which the Tile would be.
     * @param column The column of the coordinates plane in which the Tile would be.
     * @return The entire Tile, if a matching one is found.
     */
    public Tile getTileByPosition(int row, int column) {
        int[] position = new int[]{row, column};

        for (Tile tile : activeTiles)
            if (Arrays.equals(tile.getPosition(), position))
                return tile;

        return null;
    }

    /**
     * Given an ordered pair,attempts to update the symbol of the corresponding
     * coordinate based on its Entity, Item(s), Tile, or not at all.
     * @param row the row in which to find the coordinate in the 2D array.
     * @param column the column in which to find the coordinate in the 2D array.
     * @return true if the symbol was updated, false if it wasn't.
     */
    public boolean updateSymbol(int row, int column) {
        // If there's an entity at the coordinate, use that symbol
        if (getEntityByPosition(row, column) != null) {
            coordinates[row][column].setSymbol(getEntityByPosition(row, column).getSymbol());
            return true;
        }
        // Else, if there's at least one item, use that item's symbol
        else if (getItemByPosition(row, column) != null) {
            coordinates[row][column].setSymbol(getItemByPosition(row, column).getSymbol());
            return true;
        }
        // Else if there's a special tile
        else if (getTileByPosition(row, column) != null) {
            coordinates[row][column].setSymbol(getTileByPosition(row, column).getSymbol());
            return true;
        }
        else
            return false;
    }

    /**
     * Adds an entity to the Map's active entities, given there is not already an entity at the new one's position.
     * @param entity The entity to add to the list of active entities.
     * @return true if entity is added, false otherwise (there was already an entity at the new one's position).
     */
    public boolean addEntity (Entity entity) {
        if (getEntityByPosition(entity.getRow(), entity.getColumn()) != null) {
            Verbose.log(String.format("Entity is already located at [%d][%d].", entity.getRow(), entity.getColumn()), true);
            return false;
        }
        else {
            activeEntities.add(entity);
            updateSymbol(entity.getRow(), entity.getColumn());
            return true;
        }
    }
}
