package org.yahyo.controller;
import org.yahyo.entity.Mouse;
import org.yahyo.service.ServiceFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class MouseController implements MainController<Mouse> {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Collection<Mouse> run() {
        System.out.println("Enter command: ");
        System.out.println("1. Show all products");
        System.out.println("2. Find with parameter");
        System.out.print(">>>");

        int command = scanner.nextInt();
        switch (command) {
            case 1: return showAllMouse();
            case 2: return searchProducts();
            case 3: return new ArrayList<>();
            default: System.out.println("Wrong input");
        }
        return run();
    }

    public Collection<Mouse> showAllMouse() {
        return ServiceFactory.INSTANCE.getService(Mouse.class).findAll();
    }

    private Collection<Mouse> searchProducts() {
        System.out.println("1. by id");
        System.out.println("2. by price");
        System.out.println("3. by brand");
        System.out.println("4. by durability");
        System.out.println("5. by connectivity");
        System.out.println("6. exit");
        System.out.print(">>> ");
        int command = scanner.nextInt();

        switch (command) {
            case 1 -> {
                System.out.print("Id ? : ");
                int id = scanner.nextInt();
                return ServiceFactory.INSTANCE.getService(Mouse.class).findWithId(id);
            }
            case 2 -> {
                System.out.print("Price ? : ");
                float price = scanner.nextFloat();
                return ServiceFactory.INSTANCE.getService(Mouse.class).findWithPrice(price);
            }
            case 3 -> {
                System.out.print("Brand ? : ");
                String brand = scanner.next();
                return ServiceFactory.INSTANCE.getService(Mouse.class).findWithBrand(brand);
            }
            case 4 -> {
                System.out.print("Durability ? : ");
                String durability = scanner.next();
                return ServiceFactory.INSTANCE.getService(Mouse.class).findWithDurability(durability);
            }
            case 5 -> {
                System.out.print("Connectivity ? : ");
                String connectivity = scanner.next();
                return ServiceFactory.INSTANCE.getService(Mouse.class).findWithConnectivity(connectivity);
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
