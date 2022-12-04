package dev.akuniutka.skillfactory.rpg;

import java.io.IOException;

public class Main {

    private final static int SERVER_PORT_NUMBER = 1234;


    public static void main(String[] args) {
        try {
            new Thread(new Listener(SERVER_PORT_NUMBER), "Listener").start();
        } catch (IOException e) {
            System.err.println("Cannot open port number " + SERVER_PORT_NUMBER + '.');
        }
    }

}
