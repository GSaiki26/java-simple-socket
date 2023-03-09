// Libs
package com.saiki;

import com.saiki.models.*;
import java.util.Scanner;

// Classes
class App {
    public static Scanner scan = new Scanner(System.in);

    /**
     * Main method.
     * @param args - Args.
    */
    public static void main(String[] args) {
        System.out.print("(0 Server | 1 Client): ");
        int choice = scan.nextInt();

        if (choice == 0) new Server().start(4333);
        else new Client(App.scan).start(4333);
    }
}