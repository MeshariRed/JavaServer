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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.*;

public class Server {
    private static final Logger logger = Logger.getLogger(Server.class.getName());

    public static void main(String[] args) {
        // Create thread pool to handle multiple clients
        ExecutorService executor = Executors.newFixedThreadPool(10);

        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Server started on port 5000...");

            while (true) {
                // Accept new client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected : " + clientSocket.getInetAddress());

                // Create new thread to handle client communication
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                executor.execute(clientHandler);
            }
        } catch (IOException e) {
            // Log error message
            logger.log(Level.SEVERE, "Error: " + e.getMessage(), e);
        } finally {
            // Shutdown thread pool
            executor.shutdown();
        }
    }
}