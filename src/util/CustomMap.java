package src.util;

import src.core.Coordinate;
import src.core.Map;
import src.entities.entities.Dummy;
import src.tiles.Tile;
import src.tiles.tiles.Door;
import src.tiles.tiles.Floor;
import src.tiles.tiles.Wall;

import java.util.Arrays;

public class CustomMap extends Map {
    public CustomMap() {
        super(12, 10);

        Coordinate[][] myCoordinates = getCoordinates();
        myCoordinates[0][6].setTile(new Wall());
        myCoordinates[1][6].setTile(new Wall());
        myCoordinates[2][6].setTile(new Wall());
        myCoordinates[3][6].setTile(new Wall());
        myCoordinates[4][6].setTile(new Wall());
        myCoordinates[4][7].setTile(new Wall());
        myCoordinates[4][8].setTile(new Wall());
        myCoordinates[4][10].setTile(new Wall());
        myCoordinates[4][11].setTile(new Wall());

        Door myDoor = new Door();
        myCoordinates[4][9].setTile(myDoor);
        System.out.printf("Found a door at %s.%n", Arrays.toString(find(myDoor)));

        myCoordinates[2][9].setEntity(new Dummy());
    }

    private int[] findUpStairs(Coordinate[][] coordinates) {
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[i].length; j++) {
                if ((coordinates[i][j].isEmpty(new Tile[]{new Floor()}))) {
                    System.out.printf("Ignoring floors, first empty tile (no entities or items) is %d,%d.%n", i,j);
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
