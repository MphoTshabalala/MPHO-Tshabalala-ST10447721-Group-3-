package Deliveryapp;

public class Delivery {
    private static int counter = 1;
    private int deliveryId;
    private Customer customer;
    private Driver driver;
    private String pickupLocation;
    private String dropOffLocation;
    private String status;
    private String password;
    private String foodPicture;

    public Delivery(Customer customer, Driver driver, String pickupLocation, String dropOffLocation) {
        this.deliveryId = counter++;
        this.customer = customer;
        this.driver = driver;
        this.pickupLocation = pickupLocation;
        this.dropOffLocation = dropOffLocation;
        this.status = "Pending";
        this.password = generatePassword();
        this.foodPicture = "Not Provided";
    }

    private String generatePassword() {
        int pwd = 1000 + (int)(Math.random() * 9000);
        return String.valueOf(pwd);
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public String getPassword() {
        return password;
    }

    public void completeDelivery(String enteredPassword, String pictureFile) {
        if (enteredPassword.equals(password)) {
            this.foodPicture = pictureFile;
            this.status = "Completed";
            System.out.println("Delivery completed successfully!");
        } else {
            System.out.println("Incorrect password! Delivery cannot be completed.");
        }
    }

    public String getReport() {
        return "ID: " + deliveryId +
               " | Customer: " + customer.getName() +
               " | Driver: " + driver.getName() + " (" + driver.getVehicleType() + ")" +
               " | Pickup: " + pickupLocation +
               " | Dropoff: " + dropOffLocation +
               " | Status: " + status +
               " | Picture: " + foodPicture;
    }
}
