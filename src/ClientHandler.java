/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaServer.src;

/**
 *
 * @author MF
 */

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

class ClientHandler extends Thread {

    private static final List<ClientHandler> clients = new ArrayList<>();
    private final Socket clientSocket;
    private final PrintWriter out;

    public ClientHandler(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        this.out = new PrintWriter(clientSocket.getOutputStream(), true);

        // Add new client to list of clients
        clients.add(this);
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            while (true) {
                // Read client message
                String message = in.readLine();

                // Exit loop if client sends "quit"
                if (message == null || message.equals("quit")) {
                    break;
                }

                // Log client message and broadcast to all clients
                System.out.println("\nReceived message from client: " + message + "\n");
                broadcast("Client: " + message);
            }
        } catch (IOException e) {
            // Log error message
            Logger logger = Logger.getLogger("");
            logger.setLevel(Level.ALL);
            ConsoleHandler handler = new ConsoleHandler();
            handler.setLevel(Level.ALL);
            logger.addHandler(handler);
        } finally {
            try {
                // Close client socket and remove client from list of clients
                clientSocket.close();
                clients.remove(this);
                System.out.println("Client disconnected.");
            } catch (IOException e) {
                // Log error message
                Logger logger = Logger.getLogger("");
                logger.setLevel(Level.ALL);
                ConsoleHandler handler = new ConsoleHandler();
                handler.setLevel(Level.ALL);
                logger.addHandler(handler);
            }
        }
    }

    private void broadcast(String message) {
        for (ClientHandler client : clients) {
            client.out.println(message);
        }
    }
}
