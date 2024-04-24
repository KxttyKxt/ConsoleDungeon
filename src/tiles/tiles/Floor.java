package src.tiles.tiles;

import src.tiles.Tile;

public class Floor extends Tile {
    public Floor(int[] position) {
        super(
                "Floor",
                "The dark cobblestone tiles extend endlessly through the dungeon.",
                '.',
                true,
                true,
                position
        );
    }

    @Override
    public void updateTile() {}
}
