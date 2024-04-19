package src.tiles.tiles;

import src.tiles.Tile;

public class Wall extends Tile {
    public Wall() {
        super("Wall", "It blocks your way.", '▓', true);
    }

    @Override
    public void updateTile() {}


}
