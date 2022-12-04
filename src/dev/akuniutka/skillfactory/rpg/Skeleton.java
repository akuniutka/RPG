package dev.akuniutka.skillfactory.rpg;

import java.util.Random;

public class Skeleton extends Monster {

    public Skeleton(String name) {
        super(new MonsterRecipe()
                .withName(name + " the Skeleton")
                .withHealth(25)
                .withStrength(6)
                .withDexterity(30)
                .withExperience(25)
                .withGold(new Random().nextInt(25))
                .withScream("Raaaauuughhhh")
        );
    }


    @Override
    public String toString() {
        return "Skeleton{" +
                "name='" + getName() + '\'' +
                ", health=" + getHealth() +
                ", strength=" + getStrength() +
                ". dexterity=" + getDexterity() +
                ", experience=" + getExperience() +
                ", gold=" + getGold() +
                '}';
    }

}
