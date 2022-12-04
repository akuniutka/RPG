package dev.akuniutka.skillfactory.rpg;

public abstract class Entity {

    private final String name;
    private int health;
    private int maxHealth;
    private int experience;
    private int gold;


    public Entity(String name, int health, int experience, int gold) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null.");
        }
        this.name = name;
        if (health <= 0) {
            throw new IllegalArgumentException("Health must be positive.");
        }
        this.health = health;
        this.maxHealth = health;
        if (experience < 0) {
            throw new IllegalArgumentException("Experience cannot be negative.");
        }
        this.experience = experience;
        if (gold < 0) {
            throw new IllegalArgumentException("Gold cannot be negative.");
        }
        this.gold = gold;
    }


    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getExperience() {
        return experience;
    }

    public int getGold() {
        return gold;
    }

    public void setHealth(int health) {
        if (health <= 0) {
            throw new IllegalArgumentException("Health must be positive.");
        }
        this.health = health;
        if (this.health > maxHealth) {
            this.health = maxHealth;
        }
    }

    public void setMaxHealth(int maxHealth) {
        if (health <= 0) {
            throw new IllegalArgumentException("Health must be positive.");
        }
        this.maxHealth = maxHealth;
    }

    public void setExperience(int experience) {
        if (experience < 0) {
            throw new IllegalArgumentException("Experience cannot be negative");
        }
        this.experience = experience;
    }

    public void setGold(int gold) {
        if (gold < 0) {
            throw new IllegalArgumentException("Gold cannot be negative.");
        }
        this.gold = gold;
    }


    public void takeDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Damage cannot be negative.");
        }
        health -= damage;
    }

    public boolean isDestroyed() {
        return health <= 0;
    }

}
