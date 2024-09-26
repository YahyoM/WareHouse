package org.yahyo;

import org.yahyo.controller.KeyboardController;
import org.yahyo.controller.MainController;
import org.yahyo.controller.MonitorController;
import org.yahyo.controller.MouseController;

import java.util.Collection;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello, this is Computer Equipment Warehouse!");
        System.out.println("First version is released on 17.05.2024");
        System.out.println("Powered by Yahyo Mannonov");
        System.out.println("1. Monitor");
        System.out.println("2. Keyboard");
        System.out.println("3. Mouse");

        MainController<?> mainController = null;

        System.out.print(">>> ");
        int command = scanner.nextInt();

        switch (command) {
            case 1 -> mainController = new MonitorController();
            case 2 -> mainController = new KeyboardController();
            case 3 -> mainController = new MouseController();
            default -> {
                System.out.println("Wrong command");
                return;
            }
        }

        Collection<?> run = mainController.run();
        for (Object o : run) {
            System.out.println(o);
        }
        main(args);
    }
}