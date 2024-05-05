package util.debug;

import entities.entities.Dummy;
import entities.entities.Pumpkin;
import items.items.Coins;
import items.items.Seeds;
import items.items.Sword;
import items.items.Trinket;
import levels.Feature;
import tiles.tiles.Door;
import tiles.tiles.Statue;
import tiles.tiles.Tallgrass;
import tiles.tiles.Wall;

public class DebugLevelFeature extends Feature {
    public DebugLevelFeature() {
        entities.add(new Dummy(new int[]{8, 9}));

        entities.add(new Pumpkin(new int[]{1, 10}));

        entities.add(new Pumpkin(new int[]{1,11}));

        tiles.add(new Wall(new int[]{0,8}));
        tiles.add(new Wall(new int[]{1,8}));
        tiles.add(new Wall(new int[]{2,8}));
        tiles.add(new Wall(new int[]{3,8}));
        tiles.add(new Wall(new int[]{3,9}));
        tiles.add(new Wall(new int[]{3,11}));

        tiles.add(new Door(new int[]{3,10}));

        tiles.add(new Statue(new int[]{9,11}));

        items.add(new Coins(new int[]{7, 4},200));
        items.add(new Coins(new int[]{9,0}, 99));

        items.add(new Sword(new int[]{9,0}));
        items.add(new Sword(new int[]{9,2}));

        tiles.add(new Tallgrass(new int[]{0,7}, false));
        tiles.add(new Tallgrass(new int[]{0,6}, false));
        tiles.add(new Tallgrass(new int[]{0,5}, false));
        tiles.add(new Tallgrass(new int[]{1,7}, false));
        tiles.add(new Tallgrass(new int[]{1,6}, false));

        items.add(new Coins(new int[]{1,6}, 69));

        items.add(new Trinket(new int[]{8,11}));

        items.add(new Trinket(new int[]{9, 8}));
        items.add(new Trinket(new int[]{9, 8}));

        for (int i = 0; i < 11; i++)
            items.add(new Trinket(new int[]{1, 1}));

        items.add(new Seeds(new int[]{0, 3}, 4));
        items.add(new Seeds(new int[]{1, 5}, 7));
    }
}
