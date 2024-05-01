package src.tiles.tiles;

import src.tiles.Tile;
import src.util.ConsoleColors;

public class Tallgrass extends Tile {
    private boolean isTrampled;
    private String defaultSymbol = "i]l";
    private String trampledSymbol = "...";

    public Tallgrass(int[] position, boolean isTrampled) {
        super(
                "Tall Grass",
                "This surprisingly tall grass patch looks a little wilted. Stepping on it would surely make it crumble.",
                "---",
                true,
                true,
                position,
                ConsoleColors.TEXT_BRIGHT_GREEN,
                ""
        );
        this.isTrampled = isTrampled;
        if (isTrampled)
            symbol = trampledSymbol;
        else
            symbol = defaultSymbol;
    }

    @Override
    public void updateTile() {
        isTrampled = true;
        symbol = "...";
    }
}
