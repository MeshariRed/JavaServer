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
import java.util.logging.*;

public class Client {
    private static final Logger logger = Logger.getLogger(Client.class.getName());

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
                // Prompt user for input
                System.out.print("\nThe command :\n1 - Ping\n2 - quit\n\nOr ");
                System.out.print("enter any message do you need : ");
                String message = userInput.readLine();

                // Send user input to server
                switch (message) {
                    case "1":
                        out.println("Ping");
                        break;
                    case "2":
                        out.println("quit");
                        break;
                    default:
                        out.println(message);
                        break;
                }

                // Read server response
                String response = in.readLine();
                System.out.println("\nReceived message from " + response + "\n");

                // Exit loop if server sends "Server: quit"
                if (response.equals("Server: quit")) {
                    break;
                }
            }

        } catch (IOException e) {
            // Log error message
            logger.log(Level.SEVERE, "Error: " + e.getMessage(), e);
        }
    }
}