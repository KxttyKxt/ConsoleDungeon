package src.tiles.tiles;

import src.tiles.Tile;

public class Door extends Tile {
    public Door(int[] position) {
        super(
                "Door",
                "A new opportunity.",
                "#",
                true,
                true,
                position
        );
    }

    @Override
    public void updateTile() {

    }
}
