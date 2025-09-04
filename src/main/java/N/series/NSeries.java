package N.series;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class NSeries extends BaseSeries {

    // In-memory store
    private final List<SeriesModel> seriesList;

    public NSeries(Scanner sc) {
        super(sc);
        seriesList = new ArrayList<>();
    }

    // Capture a new series
    public void captureSeries() {
        System.out.println("\nCAPTURE A NEW SERIES");
        String id = readNonEmptyString("Enter the series id: ");

        // prevent duplicate id
        if (findById(id) != null) {
            System.out.println("Series with ID " + id + " already exists! Capture cancelled.");
            return;
        }

        String name = readNonEmptyString("Enter the series name: ");
        int age = readIntInRange("Enter the series age restriction (2-18): ", 2, 18);
        int episodes = readPositiveInt("Enter the number of episodes for " + name + ": ");

        seriesList.add(new SeriesModel(id, name, age, episodes));
        System.out.println("Series processed successfully!!!");
    }

    // Search for a series
    public void searchSeries() {
        System.out.println("\nSEARCH SERIES");
        String id = readNonEmptyString("Enter the series id to search: ");
        SeriesModel s = findById(id);
        if (s != null) {
            System.out.println("\n" + s);
        } else {
            System.out.println("Series with Series Id: " + id + " was not found!");
        }
    }

    // Update a series
    public void updateSeries() {
        System.out.println("\nUPDATE SERIES");
        String id = readNonEmptyString("Enter the series id to update: ");
        SeriesModel s = findById(id);
        if (s == null) {
            System.out.println("Series with Series Id: " + id + " was not found!");
            return;
        }

        String newName = readNonEmptyString("Enter the series name: ");
        int newAge = readIntInRange("Enter the age restriction (2-18): ", 2, 18);
        int newEpisodes = readPositiveInt("Enter the number of episodes: ");

        s.setSeriesName(newName);
        s.setSeriesAge(newAge);
        s.setSeriesNumberOfEpisodes(newEpisodes);

        System.out.println("Series updated successfully!");
    }

    // Delete a series
    public void deleteSeries() {
        System.out.println("\nDELETE SERIES");
        String id = readNonEmptyString("Enter the series id to delete: ");
        Iterator<SeriesModel> it = seriesList.iterator();
        while (it.hasNext()) {
            SeriesModel s = it.next();
            if (s.getSeriesId().equalsIgnoreCase(id)) {
                boolean ok = confirmYes("Are you sure you want to delete series " + id + " from the system? Yes (y) to delete: ");
                if (ok) {
                    it.remove();
                    System.out.println("Series with Series Id: " + id + " has been deleted!");
                } else {
                    System.out.println("Deletion cancelled.");
                }
                return;
            }
        }
        System.out.println("Series with Series Id: " + id + " was not found!");
    }

    // Series report
    public void seriesReport() {
        System.out.println("\n--- SERIES REPORT ---");
        if (seriesList.isEmpty()) {
            System.out.println("No series available to display.");
            return;
        }
        for (SeriesModel s : seriesList) {
            System.out.println(s);
            System.out.println("-------------------------");
        }
    }

    // Exit
    public void exitSeriesApplication() {
        System.out.println("Exiting application. Goodbye!");
        System.exit(0);
    }

    // Helper
    private SeriesModel findById(String id) {
        for (SeriesModel s : seriesList) {
            if (s.getSeriesId().equalsIgnoreCase(id)) return s;
        }
        return null;
    }
}
