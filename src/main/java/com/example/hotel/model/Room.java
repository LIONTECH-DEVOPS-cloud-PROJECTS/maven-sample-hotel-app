package com.example.hotel.model;

public class Room {
    private int id;
    private String number;
    private String type;
    private double pricePerNight;
    private boolean available;

    public Room(int id, String number, String type, double pricePerNight, boolean available) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.pricePerNight = pricePerNight;
        this.available = available;
    }

    public int getId() { return id; }
    public String getNumber() { return number; }
    public String getType() { return type; }
    public double getPricePerNight() { return pricePerNight; }
    public boolean isAvailable() { return available; }

    public void setAvailable(boolean available) { this.available = available; }
}
