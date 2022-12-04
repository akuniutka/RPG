package dev.akuniutka.skillfactory.rpg;

import java.io.IOException;
import java.net.ServerSocket;
//import java.net.Socket;

public class Listener implements Runnable {

    private final ServerSocket serverSocket;


    public Listener(int serverPortNumber) throws IOException {
        serverSocket = new ServerSocket(serverPortNumber);
    }


    @Override
    public void run() {
//        while (!serverSocket.isClosed()) {
//            System.out.println("Waiting for a new connection...");
//            try {
//                Socket clientSocket = serverSocket.accept();
//                System.out.println("Starting a new connection...");
//                new Thread(new GateKeeper(clientSocket), "GateKeeper").start();
//            } catch (IOException e) {
//                System.err.println("Cannot open port for a client connection.");
//            }
//        }
        try {
            serverSocket.close();
        } catch (IOException e) {
            System.err.println("Cannot close a server port.");
        }
        try {
            new Thread(new GateKeeper(null), "GateKeeper").start();
        } catch (IOException e) {
            System.err.println("Cannot open streams for a client connections.");
        }
    }

}
