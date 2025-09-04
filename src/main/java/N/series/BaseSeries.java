package N.series;

import java.util.Scanner;

public abstract class BaseSeries {
    protected final Scanner sc;

    public BaseSeries(Scanner sc) {
        this.sc = sc;
    }

    protected String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine();
            if (input != null) {
                input = input.trim();
                if (!input.isEmpty()) return input;
            }
            System.out.println("Input cannot be empty. Please try again.");
        }
    }

    protected int readIntInRange(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                int val = Integer.parseInt(input);
                if (val >= min && val <= max) return val;
                System.out.printf("Please enter a number between %d and %d.%n", min, max);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Only numbers allowed. Try again.");
            }
        }
    }

    protected int readPositiveInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                int val = Integer.parseInt(input);
                if (val > 0) return val;
                System.out.println("Number must be greater than 0.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Only numbers allowed. Try again.");
            }
        }
    }

    protected boolean confirmYes(String prompt) {
        System.out.print(prompt);
        String input = sc.nextLine().trim();
        return input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes");
    }
}
