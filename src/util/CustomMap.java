package src.util;

import src.core.Map;
import src.entities.entities.Dummy;
import src.tiles.tiles.Door;
import src.tiles.tiles.Wall;

public class CustomMap extends Map {
    public CustomMap() {
        super(12, 10);

        this.getCoordinates()[0][6].setTile(new Wall());
        this.getCoordinates()[1][6].setTile(new Wall());
        this.getCoordinates()[2][6].setTile(new Wall());
        this.getCoordinates()[3][6].setTile(new Wall());
        this.getCoordinates()[4][6].setTile(new Wall());
        this.getCoordinates()[4][7].setTile(new Wall());
        this.getCoordinates()[4][8].setTile(new Wall());
        this.getCoordinates()[4][9].setTile(new Door());
        this.getCoordinates()[4][10].setTile(new Wall());
        this.getCoordinates()[4][11].setTile(new Wall());

        this.getCoordinates()[2][9].setEntity(new Dummy());
    }
}
