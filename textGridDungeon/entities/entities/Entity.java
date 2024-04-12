package textGridDungeon.entities.entities;
import textGridDungeon.GameObject;

public abstract class Entity extends GameObject{
    protected int health;
    protected int damage;
    protected int armor;

    public Entity() {
        super("Undefined Entity", "This entity is undefined.", '?');
        health = 20;
        damage = 1;
        armor = 0;
        symbol = '?';
    }
    public Entity(String name, String description, char symbol, int health, int damage, int armor) {
        super(name, description, symbol);
        this.health = health;
        this.damage = damage;
        this.armor = armor;
    }
}
