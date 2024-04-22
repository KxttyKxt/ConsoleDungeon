package src.tiles.tiles;

import src.tiles.Tile;

public class Floor extends Tile {
    public Floor() {
        super(
                "Floor",
                "The dark cobblestone tiles extend endlessly through the dungeon.",
                '.',
                true,
                true
        );
    }

    @Override
    public void updateTile() {}
}
