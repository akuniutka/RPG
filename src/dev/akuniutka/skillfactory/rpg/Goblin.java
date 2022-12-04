package dev.akuniutka.skillfactory.rpg;

import java.util.Random;

public class Goblin extends Monster {

    public Goblin(String name) {
        super(new MonsterRecipe()
                .withName(name + " the Goblin")
                .withHealth(50)
                .withStrength(5)
                .withDexterity(20)
                .withExperience(50)
                .withGold(new Random().nextInt(50))
                .withScream("Arrrrgggghhhh")
        );
    }


    @Override
    public String toString() {
        return "Goblin{" +
                "name='" + getName() + '\'' +
                ", health=" + getHealth() +
                ", strength=" + getStrength() +
                ". dexterity=" + getDexterity() +
                ", experience=" + getExperience() +
                ", gold=" + getGold() +
                '}';
    }

}
