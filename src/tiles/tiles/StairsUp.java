package src.tiles.tiles;

import src.tiles.Tile;

public class StairsUp extends Tile {
    public StairsUp(int[] position) {
        super(
                "Stairs",
                "The way out.",
                "↑",
                true,
                true,
                position
        );
    }
    public StairsUp() {
        super(
                "Stairs",
                "The way out.",
                "↑",
                true,
                true
        );
    }

    @Override
    public void updateTile() {}

}
