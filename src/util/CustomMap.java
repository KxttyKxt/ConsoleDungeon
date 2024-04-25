package src.util;

import src.core.Map;
import src.entities.entities.Dummy;

public class CustomMap extends Map {
    public CustomMap() {
        super(12, 10);

        Dummy dummy = new Dummy(new int[]{8, 9});
        this.addEntity(dummy);
    }
}