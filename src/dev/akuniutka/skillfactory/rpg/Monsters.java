package dev.akuniutka.skillfactory.rpg;

import java.util.Random;

public class Monsters {

    private final static Random random = new Random();


    public static Monster nextMonster() {
        Monster monster;
        if (random.nextInt(2) == 0) {
            monster = new Goblin(nextMonsterName());
        } else {
            monster = new Skeleton(nextMonsterName());
        }
        return monster;
    }


    private static String nextMonsterName() {
        String[] prefixes = new String[] {
                "Soul",
                "Skull",
                "Bone"
        };
        String[] suffixes = new String[] {
                "Breaker",
                "Crusher",
                "Cracker"
        };
        return prefixes[random.nextInt(prefixes.length)] +
                suffixes[random.nextInt(suffixes.length)];
    }

}
