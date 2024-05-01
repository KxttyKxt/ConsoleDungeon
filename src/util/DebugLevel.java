package src.util;

import src.items.items.Coins;
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

        Dummy dummy = new Dummy(new int[]{8, 9});
        this.addEntity(dummy);

        Pumpkin firstPumpkin = new Pumpkin(new int[]{1, 10});
        this.addEntity(firstPumpkin);

        Pumpkin secondPumpkin = new Pumpkin(new int[]{1,11});
        this.addEntity(secondPumpkin);

        this.addTile(new Wall(new int[]{0,8}));
        this.addTile(new Wall(new int[]{1,8}));
        this.addTile(new Wall(new int[]{2,8}));
        this.addTile(new Wall(new int[]{3,8}));
        this.addTile(new Wall(new int[]{3,9}));
        this.addTile(new Wall(new int[]{3,11}));

        this.addTile(new Door(new int[]{3,10}));

        this.addTile(new Statue(new int[]{9,11}));

        this.addItem(new Coins(new int[]{7, 4},200));
        this.addItem(new Coins(new int[]{9,0}, 99));

        this.addItem(new Sword(new int[]{9,0}));
        this.addItem(new Sword(new int[]{9,2}));

        this.addTile(new Tallgrass(new int[]{0,7}, false));
        this.addTile(new Tallgrass(new int[]{0,6}, false));
        this.addTile(new Tallgrass(new int[]{0,5}, false));
        this.addTile(new Tallgrass(new int[]{1,7}, false));
        this.addTile(new Tallgrass(new int[]{1,6}, false));

        this.addItem(new Coins(new int[]{1,6}, 69));

        this.addItem(new Trinket(new int[]{8,11}));

        this.addItem(new Trinket(new int[]{9, 8}));
        this.addItem(new Trinket(new int[]{9, 8}));
    }
}