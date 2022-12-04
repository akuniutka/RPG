package dev.akuniutka.skillfactory.rpg;

public class Merchant {

    private final HealingPotion[] stock = new HealingPotion[3];

    public Merchant() {
        stock[0] = new HealingPotion("small healing potion", 25, 10);
        stock[1] = new HealingPotion("medium healing potion", 50, 15);
        stock[2] = new HealingPotion("large healing potion", 100, 20);
    }


    public String[] displayStock() {
        String[] menu = new String[stock.length + 2];
        menu[0] = "What do you want to buy?";
        for (int i = 0; i < stock.length; i++) {
            menu[i + 1] = String.format("%d. %s.", i + 1, stock[i].getDescription());
        }
        menu[stock.length + 1] = String.format("%d. To leave the trading desk.", stock.length + 1);
        return menu;
    }

    public String trade(Player player, int item) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null.");
        }
        if (item <= 0 || item > stock.length) {
            throw new IllegalArgumentException("Number of an item is out of range.");
        }
        return stock[item - 1].effect(player);
    }

}
