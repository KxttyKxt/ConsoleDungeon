package src.util;

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

        addEntity(new Dummy(new int[]{8, 9}));

        addEntity(new Pumpkin(new int[]{1, 10}));

        addEntity(new Pumpkin(new int[]{1,11}));

        addTile(new Wall(new int[]{0,8}));
        addTile(new Wall(new int[]{1,8}));
        addTile(new Wall(new int[]{2,8}));
        addTile(new Wall(new int[]{3,8}));
        addTile(new Wall(new int[]{3,9}));
        addTile(new Wall(new int[]{3,11}));

        addTile(new Door(new int[]{3,10}));

        addTile(new Statue(new int[]{9,11}));

        addItem(new Coins(new int[]{7, 4},200));
        addItem(new Coins(new int[]{9,0}, 99));

        addItem(new Sword(new int[]{9,0}));
        addItem(new Sword(new int[]{9,2}));

        addTile(new Tallgrass(new int[]{0,7}, false));
        addTile(new Tallgrass(new int[]{0,6}, false));
        addTile(new Tallgrass(new int[]{0,5}, false));
        addTile(new Tallgrass(new int[]{1,7}, false));
        addTile(new Tallgrass(new int[]{1,6}, false));

        this.addItem(new Coins(new int[]{1,6}, 69));

        this.addItem(new Trinket(new int[]{8,11}));

        addItem(new Trinket(new int[]{9, 8}));
        addItem(new Trinket(new int[]{9, 8}));

        for (int i = 0; i < 11; i++)
            addItem(new Trinket(new int[]{1, 1}));

        addItem(new Seeds(new int[]{0, 3}, 4));
        addItem(new Seeds(new int[]{1, 5}, 7));
    }
}