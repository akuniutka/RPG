package dev.akuniutka.skillfactory.rpg;

public class Player extends Fighter {

    private int level = 1;
    private int experienceForNextLevel = 100;


    Player(String name) {
        super(new FighterRecipe()
                .withName(name + " the Man")
                .withHealth(50)
                .withStrength(10)
                .withDexterity(20)
        );
    }


    @Override
    public String attack(Entity entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null.");
        }
        return super.attack(entity);
    }

    public String takeAward(int experience, int gold) {
        if (experience < 0) {
            throw new IllegalArgumentException("Experience cannot be negative");
        }
        setExperience(getExperience() + experience);
        if (gold < 0) {
            throw new IllegalArgumentException("Gold cannot be negative.");
        }
        setGold(getGold() + gold);
        String outputString = getName() + " received " + experience + " XP and " + gold + " gold";
        if (getExperience() >= experienceForNextLevel) {
            outputString = outputString + '\n' + levelUp();
        }
        return outputString;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + getName() + '\'' +
                ", health=" + getHealth() +
                ", strength=" + getStrength() +
                ". dexterity=" + getDexterity() +
                ", experience=" + getExperience() +
                ", gold=" + getGold() +
                '}';
    }


    private String levelUp() {
        level++;
        experienceForNextLevel *= 2;
        setMaxHealth(getMaxHealth() + 3);
        setHealth(getMaxHealth());
        setStrength(getStrength() + 2);
        setDexterity(getDexterity() + 1);
        return getName() + " reached a new level: " + level;
    }

}
