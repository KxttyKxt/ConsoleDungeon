package src.util;

import src.core.Map;

public class CustomMap extends Map {
    public CustomMap() {
        super(12, 10);

        // -=-=- old code -=-=-
//        Coordinate[][] myCoordinates = getCoordinates();
//        myCoordinates[0][6].setTile(new Wall());
//        myCoordinates[1][6].setTile(new Wall());
//        myCoordinates[2][6].setTile(new Wall());
//        myCoordinates[3][6].setTile(new Wall());
//        myCoordinates[4][6].setTile(new Wall());
//        myCoordinates[4][7].setTile(new Wall());
//        myCoordinates[4][8].setTile(new Wall());
//        myCoordinates[4][10].setTile(new Wall());
//        myCoordinates[4][11].setTile(new Wall());
//
//        Door myDoor = new Door();
//        myCoordinates[4][9].setTile(myDoor);
//        System.out.printf("Found a door at %s.%n", Arrays.toString(find(myDoor)));
//
//        myCoordinates[2][9].setEntity(new Dummy());
    }
}
