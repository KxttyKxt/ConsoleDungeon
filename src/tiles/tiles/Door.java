package src.tiles.tiles;

import src.tiles.Tile;
import src.util.ConsoleColors;

public class Door extends Tile {
    public Door(int[] position) {
        super(
                "Door",
                "A new opportunity.",
                "|#|",
                true,
                true,
                position,
                ConsoleColors.TEXT_BRIGHT_WHITE,
                ""
        );
    }

    @Override
    public void updateTile() {

    }
}
