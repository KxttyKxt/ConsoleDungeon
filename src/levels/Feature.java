package src.levels;

import src.entities.Entity;
import src.items.Item;
import src.tiles.Tile;

import java.util.ArrayList;

/**
 * Features may look similar to levels, but don't be fooled:
 * Features are kind of like sublevels in a way, but they only store Items, Entities, and Tiles.
 * When a feature is added to a level, all it does is go down the list and add each thing like the level normally would.
 */
public class Feature {
    protected ArrayList<Entity> entities = new ArrayList<>();
    protected ArrayList<Item> items = new ArrayList<>();
    protected ArrayList<Tile> tiles = new ArrayList<>();

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }
}
