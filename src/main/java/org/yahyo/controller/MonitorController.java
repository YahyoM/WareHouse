package org.yahyo.controller;

import org.yahyo.entity.Monitor;
import org.yahyo.service.ServiceFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class MonitorController implements MainController<Monitor> {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Collection<Monitor> run() {
        System.out.println("Enter command: ");
        System.out.println("1. Show all products");
        System.out.println("2. Find with parameter");
        System.out.print(">>>");

        int command = scanner.nextInt();
        switch (command) {
            case 1: return showAllMonitors();
            case 2: return searchProducts();
            case 3: return new ArrayList<>();
            default: System.out.println("Wrong input");
        }
        return run();
    }

    public Collection<Monitor> showAllMonitors() {
        return ServiceFactory.INSTANCE.getService(Monitor.class).findAll();
    }

    private Collection<Monitor> searchProducts() {
        System.out.println("1. by id");
        System.out.println("2. by price");
        System.out.println("3. by brand");
        System.out.println("4. by durability");
        System.out.println("5. by resolution");
        System.out.println("6. exit");
        System.out.print(">>> ");
        int command = scanner.nextInt();

        switch (command) {
            case 1 -> {
                System.out.print("Id ? : ");
                int id = scanner.nextInt();
                return ServiceFactory.INSTANCE.getService(Monitor.class).findWithId(id);
            }
            case 2 -> {
                System.out.print("Price ? : ");
                float price = scanner.nextFloat();
                return ServiceFactory.INSTANCE.getService(Monitor.class).findWithPrice(price);
            }
            case 3 -> {
                scanner.nextLine();
                System.out.print("Brand ? : ");
                String brand = scanner.nextLine();
                return ServiceFactory.INSTANCE.getService(Monitor.class).findWithBrand(brand);
            }
            case 4 -> {
                scanner.nextLine();
                System.out.print("Durability ? : ");
                String durability = scanner.nextLine();
                return ServiceFactory.INSTANCE.getService(Monitor.class).findWithDurability(durability);
            }
            case 5 -> {
                scanner.nextLine();
                System.out.print("Resolution ? : ");
                String resolution = scanner.nextLine();
                return ServiceFactory.INSTANCE.getService(Monitor.class).findWithResolution(resolution);
            }
            case 6 -> {
                return new ArrayList<>();
            }
            default -> {
                System.out.println("Wrong command.");
            }
        }
        return searchProducts();
    }
}
