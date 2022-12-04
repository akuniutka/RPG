package dev.akuniutka.skillfactory.rpg;

import java.net.Socket;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Game implements Runnable {

    private final static int TOWN = 0;
    private final static int FOREST = 1;
    private final static int SHOP = 2;
    private final static int TRADING_DESK = 3;
    private final static String[][] menus = {
            {"Where do want to go to?", "1. To the Merchant.", "2. To the Dark Forest.", "3. To the exit."},
            {"What do want to do next?", "1. To go back to the town.", "2. To continue to fight."},
            {"What do want to do next?", "1. To go back to the town.", "2. To continue to trade."}
    };
    private final Socket socket;
    private final Scanner in;
    private final PrintStream out;
    private final Player player;
    private final Merchant merchant = new Merchant();


    public Game(Socket socket, String playerName, Scanner in, PrintStream out) {
        this.socket = socket;
        this.in = in;
        this.out = out;
        this.player = new Player(playerName);
    }


    @Override
    public void run() {
        setLocation(TOWN);
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println("Cannot close a client connection.");
            }
        }
    }


    private void setLocation(int location) {
        String command;
        do {
            switch (location) {
                case SHOP:
                    setLocation(TRADING_DESK);
                case TOWN:
                case FOREST:
                    displayMenu(menus[location]);
                    break;
                case TRADING_DESK:
                    out.println("You have " + player.getHealth() + " HP of " + player.getMaxHealth() +
                            " and " + player.getGold() + " gold");
                    displayMenu(merchant.displayStock());
                    break;
            }
            command = in.nextLine();
            switch (location) {
                case TOWN:
                    switch (command) {
                        case "1":
                            setLocation(SHOP);
                            break;
                        case "2":
                            commenceFight();
                            if (!player.isDestroyed()) {
                                setLocation(FOREST);
                            }
                            break;
                        case "3":
                            return;
                    }
                    break;
                case FOREST:
                    switch (command) {
                        case "1":
                            return;
                        case "2":
                            commenceFight();
                            break;
                    }
                    break;
                case SHOP:
                    switch (command) {
                        case "1":
                            return;
                        case "2":
                            break;
                    }
                    break;
                case TRADING_DESK:
                    switch (command) {
                        case "1":
                        case "2":
                        case "3":
                            out.println(merchant.trade(player, Integer.parseInt(command)));
                        case "4":
                            return;
                    }
            }
        } while (!player.isDestroyed());
    }

    private void displayMenu(String[] menu) {
        for (String s : menu) {
            out.println(s);
        }
    }

    private void commenceFight() {
        try {
            Fight fight = new Fight(player, out);
            fight.start();
            fight.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
