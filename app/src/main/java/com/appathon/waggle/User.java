package com.appathon.waggle;

public class User {
    private String id; // Changed to String
    private String name;
    private String phone;
    private String address;
    private String cost; // Changed to String

    // Constructor
    public User(String name, String phone, String address, String cost) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.cost = cost;
    }

    // Getter methods
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCost() {
        return cost;
    }

    // Setter methods
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
