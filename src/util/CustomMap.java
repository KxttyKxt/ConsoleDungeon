package src.util;

import src.core.Map;
import src.entities.entities.Dummy;
import src.entities.entities.Pumpkin;

public class CustomMap extends Map {
    public CustomMap() {
        super(12, 10);

        Dummy dummy = new Dummy(new int[]{8, 9});
        this.addEntity(dummy);

        Pumpkin pumpkin = new Pumpkin(new int[]{4, 2});
        this.addEntity(pumpkin);
    }
}