package dev.akuniutka.skillfactory.rpg;

public abstract class Item {

    private final String name;
    private final int price;


    public Item(String name, int price) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null.");
        }
        this.name = name;
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be positive.");
        }
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }


    public abstract String effect(Player player);

    public abstract String getDescription();

}
