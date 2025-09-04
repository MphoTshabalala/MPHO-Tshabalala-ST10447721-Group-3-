package Deliveryapp;

public class DeliverySystem {
    private Customer[] customers;
    private Driver[] drivers;
    private Delivery[] deliveries;
    private int customerCount = 0;
    private int driverCount = 0;
    private int deliveryCount = 0;

    public DeliverySystem(int maxCustomers, int maxDrivers, int maxDeliveries) {
        customers = new Customer[maxCustomers];
        drivers = new Driver[maxDrivers];
        deliveries = new Delivery[maxDeliveries];
    }

    public boolean addCustomer(Customer c) {
        if (customerCount >= customers.length) return false;
        customers[customerCount++] = c;
        return true;
    }

    public boolean addDriver(Driver d) {
        if (driverCount >= drivers.length) return false;
        drivers[driverCount++] = d;
        return true;
    }

    public Delivery createDelivery(int custIndex, int driverIndex, String pickup, String drop) {
        if (custIndex < 0 || custIndex >= customerCount || driverIndex < 0 || driverIndex >= driverCount)
            return null;

        Delivery d = new Delivery(customers[custIndex], drivers[driverIndex], pickup, drop);
        deliveries[deliveryCount++] = d;
        return d;
    }

    public Delivery getDeliveryById(int id) {
        for (int i = 0; i < deliveryCount; i++) {
            if (deliveries[i].getDeliveryId() == id)
                return deliveries[i];
        }
        return null;
    }

    public void printReport() {
        System.out.println("\n=== Delivery Report ===");
        for (int i = 0; i < deliveryCount; i++) {
            System.out.println(deliveries[i].getReport());
        }
    }

    public void listCustomers() {
        for (int i = 0; i < customerCount; i++) {
            System.out.println(i + ": " + customers[i].getName() + " (" + customers[i].getAddress() + ")");
        }
    }

    public void listDrivers() {
        for (int i = 0; i < driverCount; i++) {
            System.out.println(i + ": " + drivers[i].getName() + " (" + drivers[i].getVehicleType() + ")");
        }
    }

    public int getCustomerCount() { return customerCount; }
    public int getDriverCount() { return driverCount; }
}
