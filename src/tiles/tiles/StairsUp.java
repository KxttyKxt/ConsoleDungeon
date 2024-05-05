package tiles.tiles;

import tiles.Tile;
import util.ConsoleColors;

public class StairsUp extends Tile {
    public StairsUp(int[] position) {
        super(
                "Stairs",
                "The way out.",
                "[^]",
                true,
                true,
                position,
                ConsoleColors.TEXT_BRIGHT_WHITE,
                ""
        );
    }

    @Override
    public void updateTile() {}

}
