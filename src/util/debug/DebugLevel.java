package util.debug;

import items.items.Coins;
import items.items.Seeds;
import items.items.Sword;
import items.items.Trinket;
import levels.Level;
import entities.entities.Dummy;
import entities.entities.Pumpkin;
import tiles.tiles.Door;
import tiles.tiles.Statue;
import tiles.tiles.Tallgrass;
import tiles.tiles.Wall;

public class DebugLevel extends Level {
    public DebugLevel() {
        super(12, 10, new int[]{0,0}, new int[]{2,2});
        addFeature(new DebugLevelFeature());
    }
}