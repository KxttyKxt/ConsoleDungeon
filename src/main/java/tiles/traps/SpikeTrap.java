package tiles.traps;

import entities.Entity;
import util.ConsoleColors;

public class SpikeTrap extends Trap{
    public SpikeTrap(boolean discovered, int[] position) {
        super(
                "Spike Trap",
                String.format("In some gaps in the floor, you see an array of sharp metal spikes.%nProbably best not to step on them; they would deal considerable damage."),
                "^^^",
                discovered,
                position,
                ConsoleColors.TEXT_BRIGHT_BLACK,
                null
        );
    }

    @Override
    public void triggerTrap(Entity target) {
        target.setHealth(target.getHealth() - 5);
        discovered = true;
    }

    @Override
    public void updateTile() {

    }
}
