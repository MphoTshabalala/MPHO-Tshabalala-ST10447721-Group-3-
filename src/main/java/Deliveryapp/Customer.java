package Deliveryapp;

public class Customer extends Person {
    private String address;

    public Customer(String name, String address) {
        super(name);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
