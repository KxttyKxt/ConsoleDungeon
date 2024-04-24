package src.tiles.tiles;

import src.tiles.Tile;

public class StairsDown extends Tile {
    public StairsDown(int[] position) {
        super(
                "Stairs Down",
                "A way deeper.",
                "↓",
                true,
                true,
                position);
    }

    @Override
    public void updateTile() {}
}
