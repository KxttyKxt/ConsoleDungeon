package src.tiles.tiles;

import src.tiles.Tile;

public class StairsDown extends Tile {
    public StairsDown() {
        super("Stairs Down", "A way deeper.", '↓', true);
    }

    @Override
    public void updateTile() {}
}
