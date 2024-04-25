package src.entities;
import src.core.GameObject;

import java.util.Objects;

public abstract class Entity extends GameObject{
    protected int health;
    protected int damage;
    protected int armor;

    protected boolean alive = true;

    public Entity() {
        super("Undefined Entity", "This entity is undefined.", "?");
        health = 20;
        damage = 1;
        armor = 0;
    }

    public Entity(String name, String description, String symbol, int health, int damage, int armor) {
        super(name, description, symbol);
        this.health = health;
        this.damage = damage;
        this.armor = armor;
    }

    public Entity(String name, String description, String symbol, int health, int damage, int armor, int[] position) {
        super(name, description, symbol);
        this.health = health;
        this.damage = damage;
        this.armor = armor;
        this.position = position;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Entity entity = (Entity) object;
        return health == entity.health && damage == entity.damage && armor == entity.armor && alive == entity.alive;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), health, damage, armor, alive);
    }
}
