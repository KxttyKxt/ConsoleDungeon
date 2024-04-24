package src.tiles.tiles;

import src.tiles.Tile;

public class StairsUp extends Tile {
    public StairsUp(int[] position) {
        super(
                "Stairs",
                "The way out.",
                '↑',
                true,
                true,
                position
        );
    }

    @Override
    public void updateTile() {}

}
