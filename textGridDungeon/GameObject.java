package textGridDungeon;

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
}
