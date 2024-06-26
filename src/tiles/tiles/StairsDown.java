package tiles.tiles;

import tiles.Tile;
import util.ConsoleColors;

public class StairsDown extends Tile {
    public StairsDown(int[] position) {
        super(
                "Stairs Down",
                "A way deeper.",
                "[v]",
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
