package src.core;

import src.items.Item;
import src.items.Stackable;
import src.items.items.*;
import src.util.Verbose;

import java.util.ArrayList;

public class Inventory {
    private final int MAX_SIZE = 20;
    private ArrayList<Item> items = new ArrayList<>(MAX_SIZE);
    private Coins currency = new Coins(null,0);

    private int lengthOfLongestItemName = 1;

    public boolean addItem(Item item) {
        // Special Items
        if (item instanceof Coins) {
            currency.setAmount(currency.getAmount() + ((Coins) item).getAmount());
            return true;
        }

        // Everything else
        else if (items.size() < MAX_SIZE) {
            if (item instanceof Stackable) {
                if (!addStackable((Stackable) item)) {
                    items.add(item);
                    Verbose.log(String.format("Item %s was added as new stack.", item), false);
                    if (lengthOfLongestItemName < item.getName().length() + String.valueOf(((Stackable) items.get(checkForStackable((Stackable) item))).getAmount()).length() + 3) {
                        lengthOfLongestItemName = item.getName().length() + String.valueOf(((Stackable) items.get(checkForStackable((Stackable) item))).getAmount()).length() + 3;
                        Verbose.log(String.format("Length of longest item name set to %d. [%d stack adjustment]", lengthOfLongestItemName, String.valueOf(((Stackable) item).getAmount()).length() + 3), false);
                    }
                }
            }
            else {
                items.add(item);
                Verbose.log(String.format("Non-stackable item %s was added to inventory.", item), false);
                if (lengthOfLongestItemName < item.getName().length()) {
                    lengthOfLongestItemName = item.getName().length();
                    Verbose.log(String.format("Length of longest item name set to %d.", lengthOfLongestItemName), false);
                }
            }
            return true;
        }
        return false;
    }

    public boolean removeItem(Item item) {
        return items.remove(item);
    }

    public Item getItem(int index) {
        return items.get(index);
    }
    public int getStackAmount(Stackable stackable) {
        int index = checkForStackable(stackable);
        if (index != -1)
            return ((Stackable) items.get(index)).getAmount();
        else return 0;
    }

    /**
     * Checks if the inventory contains a stackable item of the same type or not. If it does, add to the existing stack.
     * @param stackable The Stackable item attempting to be added to the inventory
     * @return true if the item was merged to an existing stack; false otherwise
     */
    public boolean addStackable(Stackable stackable) {
        int index = checkForStackable(stackable);

        if (index > -1) {
            Stackable found = (Stackable) items.get(index);
            found.setAmount(found.getAmount() + stackable.getAmount());
            Verbose.log(String.format("Existing stack of %s found: adding %d (total: %d)", stackable.getClass(), stackable.getAmount(), found.getAmount()), false);
            return true;
        }

        return false;
    }

    public int checkForStackable(Stackable stackable) {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (item instanceof Stackable && item.getClass().getSuperclass() == Stackable.class) {
                Verbose.log(String.format("Stackable %s found at index %d.", stackable, i), false);
                return i;
            }
        }
        Verbose.log(String.format("Object of stackable subclass %s not found in inventory.", stackable.getClass().getName()), true);
        return -1;
    }

    public int getCurrency() {
        return currency.getAmount();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("[Gold: %d]%n%n", currency.getAmount()));

        for (int i = 0; i < MAX_SIZE; i++) {
            String itemName = "";

            // If there is indeed an item
            if (i < items.size()) {
                // Add its name
                itemName += items.get(i).getName();
                // If the item is stackable
                if (items.get(i) instanceof Stackable)
                    // add that too
                    itemName += String.format(" (%d)", ((Stackable) items.get(i)).getAmount());
            }
            stringBuilder.append(String.format("[%-3s %s] ", String.format("%d:", i+1), String.format(("%" + lengthOfLongestItemName + "s"), itemName)));
            if ((i+1) % 5 == 0)
                stringBuilder.append(String.format("%n"));
        }
        return stringBuilder.toString();
    }

}
