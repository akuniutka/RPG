package dev.akuniutka.skillfactory.rpg;

import java.util.Random;

public abstract class Fighter extends Entity {

    private final static int CRITICAL_MULTIPLIER = 2;
    private final static Random random = new Random();
    private int strength;
    private int dexterity;


    public static class FighterRecipe {

        private String name;
        private int health;
        private int strength;
        private int dexterity;
        private int experience;
        private int gold;


        public String getName() {
            return name;
        }

        public int getHealth() {
            return health;
        }

        public int getStrength() {
            return strength;
        }

        public int getDexterity() {
            return dexterity;
        }

        public int getExperience() {
            return experience;
        }

        public int getGold() {
            return gold;
        }


        public FighterRecipe withName(String name) {
            if (name == null) {
                throw new IllegalArgumentException("Name cannot be null.");
            }
            this.name = name;
            return this;
        }

        public FighterRecipe withHealth(int health) {
            if (health <= 0) {
                throw new IllegalArgumentException("Health must be positive.");
            }
            this.health = health;
            return this;
        }

        public FighterRecipe withStrength(int strength) {
            if (strength <= 0) {
                throw new IllegalArgumentException("Strength must be positive.");
            }
            this.strength = strength;
            return this;
        }

        public FighterRecipe withDexterity(int dexterity) {
            if (dexterity <= 0) {
                throw new IllegalArgumentException("Dexterity must be positive.");
            }
            this.dexterity = dexterity;
            return this;
        }

        public FighterRecipe withExperience(int experience) {
            if (experience < 0) {
                throw new IllegalArgumentException("Experience cannot be negative.");
            }
            this.experience = experience;
            return this;
        }

        public FighterRecipe withGold(int gold) {
            if (gold < 0) {
                throw new IllegalArgumentException("Gold cannot be negative.");
            }
            this.gold = gold;
            return this;
        }

    }


    public Fighter(FighterRecipe recipe) {
        super(recipe.getName(), recipe.getHealth(), recipe.getExperience(), recipe.getGold());
        if (recipe.getStrength() <= 0) {
            throw new IllegalArgumentException("Strength must be positive.");
        }
        strength = recipe.getStrength();
        if (recipe.getDexterity() <= 0) {
            throw new IllegalArgumentException("Dexterity must be positive.");
        }
        dexterity = recipe.getDexterity();
    }


    public int getDexterity() {
        return dexterity;
    }

    public int getStrength() {
        return strength;
    }

    public void setDexterity(int dexterity) {
        if (dexterity <= 0) {
            throw new IllegalArgumentException("Dexterity must be positive.");
        }
        this.dexterity = dexterity;
    }

    public void setStrength(int strength) {
        if (strength <= 0) {
            throw new IllegalArgumentException("Strength must be positive.");
        }
        this.strength = strength;
    }


    public String attack(Entity entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }
        if (hasToMissNow()) {
            return getName() + " missed";
        } else if (isTimeForCriticalAttack()) {
            entity.takeDamage(strength * CRITICAL_MULTIPLIER);
            return getName() + " attacked with damage of " + (strength * CRITICAL_MULTIPLIER) + '!';
        } else {
            entity.takeDamage(getStrength());
            return getName() + " attacked with damage of " + strength;
        }
    }


    private boolean hasToMissNow() {
        return dexterity * 3 <= random.nextInt(100);
    }

    private boolean isTimeForCriticalAttack() {
        return random.nextInt(5) == 0;
    }

}
