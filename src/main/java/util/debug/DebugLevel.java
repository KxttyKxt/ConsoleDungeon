package util.debug;

import levels.Level;

public class DebugLevel extends Level {
    public DebugLevel() {
        super(12, 10, new int[]{0,0}, new int[]{2,2});
        addFeature(new DebugLevelFeature());
    }
}