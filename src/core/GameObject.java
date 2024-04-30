package src.core;

import src.util.ConsoleColors;

import java.util.Arrays;
import java.util.Objects;

public abstract class GameObject {
    protected String name;
    protected String description;
    protected String symbol;
    protected int[] position; // ordered pair coordinates
    protected String color;
    protected String bgColor;

    public GameObject() {
        name = "Undefined Object";
        description = "This object is undefined.";
        symbol = "_";
    }
    public GameObject(String name, String description, String symbol) {
        this.name = name;
        this.description = description;
        this.symbol = symbol;
    }

    public GameObject(String name, String description, String symbol, int[] position) {
        this.name = name;
        this.description = description;
        this.symbol = symbol;
        this.position = position;
    }

    public GameObject(String name, String description, String symbol, int[] position, String color, String bgColor) {
        this.name = name;
        this.description = description;
        this.position = position;
        this.color = color;
        this.bgColor = bgColor;
        this.symbol = symbol;
    }

    public String getColoredSymbol() {
        return ConsoleColors.buildColoredString(bgColor, color, symbol);
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

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public int[] getPosition() {
        return position;
    }
    public int getRow() {
        if (position != null)
            return position[0];
        return -1;
    }
    public int getColumn() {
        if (position != null)
            return position[1];
        return -1;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        GameObject that = (GameObject) object;
        return Objects.equals(symbol, that.symbol)
                && Objects.equals(name, that.name)
                && Objects.equals(description, that.description)
                && Arrays.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, symbol, Arrays.hashCode(position));
    }
}
