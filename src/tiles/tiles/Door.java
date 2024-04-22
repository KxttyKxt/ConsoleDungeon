package src.tiles.tiles;

import src.tiles.Tile;

public class Door extends Tile {
    public Door() {
        super(
                "Door",
                "A new opportunity.",
                '#',
                true,
                true
        );
    }

    @Override
    public void updateTile() {

    }
}
