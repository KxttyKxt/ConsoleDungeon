package src.util;

import src.core.Map;
import src.tiles.tiles.Wall;

public class CustomMap extends Map {
    public CustomMap() {
        super(12, 10);

        this.getCoordinates()[3][6].setTile(new Wall());
    }
}
