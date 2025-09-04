package N.series;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NSeries seriesApp = new NSeries(sc);

        System.out.println("LATEST SERIES - 2025");
        System.out.print("Enter (1) to launch menu or any other key to exit: ");
        String start = sc.nextLine().trim();
        if (!"1".equals(start)) {
            System.out.println("Exiting application. Goodbye!");
            return;
        }

        while (true) {
            System.out.println("\nPlease select one of the following:");
            System.out.println("(1) Capture a new series");
            System.out.println("(2) Search for a series");
            System.out.println("(3) Update series");
            System.out.println("(4) Delete a series");
            System.out.println("(5) Print series report - 2025");
            System.out.println("(6) Exit Application");
            System.out.print("Enter your choice: ");

            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1" -> seriesApp.captureSeries();
                case "2" -> seriesApp.searchSeries();
                case "3" -> seriesApp.updateSeries();
                case "4" -> seriesApp.deleteSeries();
                case "5" -> seriesApp.seriesReport();
                case "6" -> seriesApp.exitSeriesApplication();
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
