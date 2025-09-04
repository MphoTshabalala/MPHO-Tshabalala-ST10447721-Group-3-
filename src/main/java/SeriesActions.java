package N.series;

import java.util.Scanner;

public abstract class SeriesActions {

    // Shared input tool for subclasses
    protected final Scanner sc = new Scanner(System.in);

    // Required behaviours (rubric)
    public abstract void captureSeries();
    public abstract void searchSeries();
    public abstract void updateSeries();
    public abstract void deleteSeries();
    public abstract void seriesReport();
    public abstract void exitSeriesApplication();

    // ===== Shared helpers (inherited by Series) =====

    // Validate age 2–18, numbers only
    protected int validateAge() {
        while (true) {
            System.out.print("Enter the series age restriction (2–18): ");
            String inp = sc.nextLine().trim();
            try {
                int age = Integer.parseInt(inp);
                if (age >= 2 && age <= 18) return age;
                System.out.println("You have entered an incorrect series age! Please re-enter.");
            } catch (NumberFormatException e) {
                System.out.println("You have entered an incorrect series age! Please re-enter.");
            }
        }
    }

    // Validate positive integer with prompt
    protected int validatePositiveInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String inp = sc.nextLine().trim();
            try {
                int n = Integer.parseInt(inp);
                if (n > 0) return n;
                System.out.println("Invalid number! Must be greater than 0.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number! Please enter digits only.");
            }
        }
    }
}
