package dev.akuniutka.skillfactory.rpg;

import java.io.PrintStream;

class Fight extends Thread {

    private final Player player;
    private final Monster monster;
    private final PrintStream out;


    public Fight(Player player, PrintStream out) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null.");
        }
        this.player = player;
        if (out == null) {
            throw new IllegalArgumentException("Output stream cannot be null.");
        }
        this.out = out;
        this.monster = Monsters.nextMonster();
        this.out.println(player.getName() + " met " + monster.getName());
        this.out.println(monster.growl());
    }


    public void run() {
        try {
            boolean isPlayerTurn = true;
            while (!player.isDestroyed() && !monster.isDestroyed()) {
                sleep(750);
                if (isPlayerTurn) {
                    out.println(player.attack(monster));
                } else {
                    out.println(monster.attack(player));
                }
                isPlayerTurn = !isPlayerTurn;
            }
            if (monster.isDestroyed()) {
                out.println(monster.getName() + " died!");
                out.println(player.takeAward(monster.getExperience(), monster.getGold()));
            } else {
                out.println(player.getName() + " died!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
