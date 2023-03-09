// Libs
package com.saiki.models;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

// Classes
public class Client {
    private Scanner scan;

    public Client(Scanner scan) {
        this.scan = scan;
    }

    /**
     * A method to create a client socket.
    */
    public void start(int port) {
        System.out.println("Starting client...");

        // Create the client socket.
        try {
            Socket client = new Socket("127.0.0.1", port);

            while (this.scan.hasNextLine()) {
                PrintStream input = new PrintStream(client.getOutputStream());
                input.println(this.scan.nextLine());
            }

            client.close();
        } catch (IOException err) {
            err.printStackTrace();
            return;
        }
    }
}
