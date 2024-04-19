package src.core;

import java.util.Objects;

public abstract class GameObject {
    protected String name;
    protected String description;
    protected char symbol;

    public GameObject() {
        name = "Undefined Object";
        description = "This object is undefined.";
        symbol = '_';
    }
    public GameObject(String name, String description, char symbol) {
        this.name = name;
        this.description = description;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        GameObject that = (GameObject) object;
        return symbol == that.symbol && Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, symbol);
    }
}
