package src.entities.entities;
import src.core.GameObject;

import java.util.Objects;

public abstract class Entity extends GameObject{
    protected int health;
    protected int damage;
    protected int armor;

    protected int isAlive;

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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Entity entity = (Entity) object;
        return health == entity.health && damage == entity.damage && armor == entity.armor && isAlive == entity.isAlive;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), health, damage, armor, isAlive);
    }
}
