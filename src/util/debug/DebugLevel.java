package src.util.debug;

import src.items.items.Coins;
import src.items.items.Seeds;
import src.items.items.Sword;
import src.items.items.Trinket;
import src.levels.Level;
import src.entities.entities.Dummy;
import src.entities.entities.Pumpkin;
import src.tiles.tiles.Door;
import src.tiles.tiles.Statue;
import src.tiles.tiles.Tallgrass;
import src.tiles.tiles.Wall;

public class DebugLevel extends Level {
    public DebugLevel() {
        super(12, 10, new int[]{0,0}, new int[]{2,2});
        addFeature(new DebugLevelFeature());
    }
}