package dev.akuniutka.skillfactory.rpg;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class GateKeeper implements Runnable {

    private static final String WELCOME_MESSAGE = "Welcome to our Realm, Stranger!\nWhat is your name?";
    private static final String ANONYMOUS = "Stranger";
    private static final String GREETING = "Hi, %s!\n";
    private final Socket socket;
    private final Scanner in;
    private final PrintStream out;


    public GateKeeper(Socket socket) throws IOException {
        this.socket = socket;
        if (socket == null) {
            in = new Scanner(System.in);
            out = System.out;
        } else {
            in = new Scanner(socket.getInputStream());
            out = new PrintStream(socket.getOutputStream());
        }
    }


    @Override
    public void run() {
        out.println(WELCOME_MESSAGE);
        String playerName = in.nextLine();
        if (playerName.equals("")) {
            playerName = ANONYMOUS;
        }
        out.printf(GREETING, playerName);
        new Thread(new Game(socket, playerName, in, out), playerName).start();
    }

}
