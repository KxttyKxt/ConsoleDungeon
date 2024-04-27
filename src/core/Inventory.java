package src.core;

import src.items.Item;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items = new ArrayList<>();
    private final int MAX_SIZE = 20;

    public boolean addItem(Item item) {
        if (items.size() < MAX_SIZE) {
            items.add(item);
            return true;
        }
        return false;
    }

    public boolean removeItem(Item item) {
        return items.remove(item);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= items.size(); i++) {
            stringBuilder.append(String.format("[%d: %s]", i, items.get(i)));
            if (i % 5 == 0)
                stringBuilder.append(String.format("%n"));
        }
        return stringBuilder.toString();
    }

}
