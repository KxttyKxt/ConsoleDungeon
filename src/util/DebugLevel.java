package src.util;

import src.items.items.Coins;
import src.levels.Level;
import src.entities.entities.Dummy;
import src.entities.entities.Pumpkin;
import src.tiles.tiles.Door;
import src.tiles.tiles.Statue;
import src.tiles.tiles.Wall;

public class DebugLevel extends Level {
    public DebugLevel() {
        super(12, 10, new int[]{0,0}, new int[]{2,2});

        Dummy dummy = new Dummy(new int[]{8, 9});
        this.addEntity(dummy);

        Pumpkin pumpkin = new Pumpkin(new int[]{1, 10});
        this.addEntity(pumpkin);



        this.addTile(new Wall(new int[]{0,8}));
        this.addTile(new Wall(new int[]{1,8}));
        this.addTile(new Wall(new int[]{2,8}));
        this.addTile(new Wall(new int[]{3,8}));
        this.addTile(new Wall(new int[]{3,9}));
        this.addTile(new Wall(new int[]{3,11}));

        this.addTile(new Door(new int[]{3,10}));

        this.addTile(new Statue(new int[]{9,11}));

        this.addItem(new Coins(new int[]{7, 4},200));
    }
}