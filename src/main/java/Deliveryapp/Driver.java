package Deliveryapp;

public class Driver extends Person {
    private String vehicleType;

    public Driver(String name, String vehicleType) {
        super(name);
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() {
        return vehicleType;
    }
}
