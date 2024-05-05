package src.tiles.tiles;

import src.tiles.Tile;
import src.util.ConsoleColors;

public class Wall extends Tile {
    public Wall(int[] position) {
        super(
                "Wall",
                "It blocks your way.",
                "===",
                true,
                false,
                position,
                ConsoleColors.TEXT_BRIGHT_WHITE,
                ""
        );
    }

    @Override
    public void updateTile() {}


}
