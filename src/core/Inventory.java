package src.core;

import src.items.Item;
import src.items.items.*;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items = new ArrayList<>();
    private Coins currency = new Coins(null,0);
    private final int MAX_SIZE = 20;

    public boolean addItem(Item item) {
        // Special Items
        if (item instanceof Coins)
            currency.setAmount(currency.getAmount() + ((Coins) item).getAmount());

        // Everything else
        else if (items.size() < MAX_SIZE) {
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

        stringBuilder.append(String.format("[Gold: %d]%n%n", currency.getAmount()));

        for (int i = 0; i < items.size(); i++) {
            stringBuilder.append(String.format("[%d: %s] ", i+1, items.get(i).getName()));
            if ((i+1) % 5 == 0)
                stringBuilder.append(String.format("%n"));
        }
        return stringBuilder.toString();
    }

}
