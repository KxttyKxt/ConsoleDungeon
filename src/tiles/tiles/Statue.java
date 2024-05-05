package tiles.tiles;

import tiles.Tile;
import util.ConsoleColors;

public class Statue extends Tile {
    public Statue(int[] position) {
        super(
                "Statue",
                "Someone tried to adorn this place, but failed, obviously.",
                "{*}",
                true,
                false,
                position,
                ConsoleColors.TEXT_BRIGHT_WHITE,
                ""
        );
    }

    @Override
    public void updateTile() {

    }
}
