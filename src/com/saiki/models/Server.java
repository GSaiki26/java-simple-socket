// Libs
package com.saiki.models;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// Classes
public class Server {
    /**
     * A method to create a server socket.
    */
    public void start(int port) {
        System.out.println("Starting server...");
        // Create the server socket.
        try {
            ServerSocket server = new ServerSocket(port);
            Socket client = server.accept();
            String clientAddr = client.getInetAddress().getHostAddress();
            System.out.printf("Connection stabilished from: %s\n", clientAddr);

            Scanner scan = new Scanner(client.getInputStream());
            while (scan.hasNextLine()) {
                System.out.printf("%s: %s", clientAddr, scan.nextLine());
            }

            server.close();
        } catch (IOException err) {
            err.printStackTrace();
            return;
        }
    }
}
