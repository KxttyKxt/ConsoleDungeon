package src.tiles.tiles;

import src.tiles.Tile;

public class Wall extends Tile {
    public Wall(int[] position) {
        super(
                "Wall",
                "It blocks your way.",
                "▓",
                true,
                false,
                position
        );
    }

    @Override
    public void updateTile() {}


}
