package Deliveryapp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DeliverySystem system = new DeliverySystem(10, 10, 20);
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Delivery Driver Registration ===");
        System.out.print("Enter driver name: ");
        String dname = sc.nextLine();
        System.out.print("Enter vehicle type (Car/Bike/Scooter): ");
        String vtype = sc.nextLine();
        system.addDriver(new Driver(dname, vtype));
        System.out.println("Driver registered successfully!\n");

        // Preload some customers (simulating app users)
        system.addCustomer(new Customer("Alice", "12 Rose Street"));
        system.addCustomer(new Customer("Bob", "45 Maple Avenue"));
        system.addCustomer(new Customer("Charlie", "78 Oak Road"));

        int choice = 0;
        do {
            System.out.println("\n=== Delivery Menu ===");
            System.out.println("1. Create Delivery");
            System.out.println("2. Complete Delivery");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Incorrect input! Returning to main menu.");
                sc.nextLine();
                continue;
            }
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    if (system.getCustomerCount() == 0 || system.getDriverCount() == 0) {
                        System.out.println("No customers or drivers available!");
                        break;
                    }
                    System.out.println("Select Customer:");
                    system.listCustomers();
                    int ci = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter pickup location: ");
                    String pickup = sc.nextLine();
                    System.out.print("Enter drop-off location: ");
                    String drop = sc.nextLine();

                    Delivery d = system.createDelivery(ci, 0, pickup, drop);
                    if (d != null) {
                        System.out.println("Delivery created! Password to complete: " + d.getPassword());
                    } else {
                        System.out.println("Failed to create delivery.");
                    }
                    break;

                case 2:
                    System.out.print("Enter delivery ID to complete: ");
                    int did = sc.nextInt();
                    sc.nextLine();
                    Delivery del = system.getDeliveryById(did);
                    if (del == null) {
                        System.out.println("Delivery not found!");
                        break;
                    }
                    System.out.print("Enter delivery password: ");
                    String epass = sc.nextLine();
                    System.out.print("Enter food picture filename: ");
                    String pic = sc.nextLine();
                    del.completeDelivery(epass, pic);
                    break;

                case 3:
                    System.out.println("All deliveries finished. Showing report...");
                    system.printReport();
                    break;

                default:
                    System.out.println("Incorrect choice! Returning to main menu.");
            }
        } while (choice != 3);

        sc.close();
    }
}
