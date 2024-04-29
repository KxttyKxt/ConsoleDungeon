package src.util;

import src.core.Level;
import src.entities.entities.Dummy;
import src.entities.entities.Pumpkin;

public class DebugLevel extends Level {
    public DebugLevel() {
        super(12, 10);

        Dummy dummy = new Dummy(new int[]{8, 9});
        this.addEntity(dummy);

        Pumpkin pumpkin = new Pumpkin(new int[]{4, 2});
        this.addEntity(pumpkin);
    }
}