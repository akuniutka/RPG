package dev.akuniutka.skillfactory.rpg;

public class HealingPotion extends Item {

    private final int healingEffect;

    public HealingPotion(String name, int healingEffect, int price) {
        super(name, price);
        if (healingEffect <= 0) {
            throw new IllegalArgumentException("Healing effect must be positive.");
        }
        this.healingEffect = healingEffect;
    }


    @Override
    public String effect(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null.");
        }
        if (getPrice() > player.getGold()) {
            return  "Not enough gold to buy this potion";
        } else {
            player.setGold(player.getGold() - getPrice());
            player.setHealth(player.getHealth() + healingEffect);
            return player.getName() + " bought a " + getName() + " for " + getPrice() + " gold\n" +
                    player.getName() +  " has " + player.getHealth() + "HP now";
        }
    }

    @Override
    public String getDescription() {
        return "A " + getName() + ": +" + healingEffect + " HP for " + getPrice() + " gold";
    }

}
