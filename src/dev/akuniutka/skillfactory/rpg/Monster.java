package dev.akuniutka.skillfactory.rpg;

abstract class Monster extends Fighter {

    private final String scream;

    public static class MonsterRecipe extends FighterRecipe {

        private String scream;


        public String getScream() {
            return scream;
        }


        public MonsterRecipe withName(String name) {
            if (name == null) {
                throw new IllegalArgumentException("Name cannot be null.");
            }
            super.withName(name);
            return this;
        }

        public MonsterRecipe withHealth(int health) {
            if (health <= 0) {
                throw new IllegalArgumentException("Health must be positive.");
            }
            super.withHealth(health);
            return this;
        }

        public MonsterRecipe withStrength(int strength) {
            if (strength <= 0) {
                throw new IllegalArgumentException("Strength must be positive.");
            }
            super.withStrength(strength);
            return this;
        }

        public MonsterRecipe withDexterity(int dexterity) {
            if (dexterity <= 0) {
                throw new IllegalArgumentException("Dexterity must be positive.");
            }
            super.withDexterity(dexterity);
            return this;
        }

        public MonsterRecipe withExperience(int experience) {
            if (experience < 0) {
                throw new IllegalArgumentException("Experience cannot be negative.");
            }
            super.withExperience(experience);
            return this;
        }

        public MonsterRecipe withGold(int gold) {
            if (gold < 0) {
                throw new IllegalArgumentException("Gold cannot be negative.");
            }
            super.withGold(gold);
            return this;
        }

        public MonsterRecipe withScream(String scream) {
            if (scream == null) {
                throw new IllegalArgumentException("Scream cannot be null.");
            }
            this.scream = scream;
            return this;
        }

    }

    Monster(MonsterRecipe recipe) {
        super(recipe);
        scream = recipe.getScream();
    }

    @Override
    public String attack(Entity entity) {
        return super.attack(entity) + '\n' + growl();
    }

    public String growl() {
        return '\'' + scream + "!' growled " + getName();
    }

}
