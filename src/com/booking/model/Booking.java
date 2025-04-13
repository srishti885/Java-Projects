package com.booking.model;

public class Booking {
    private String name;
    private String movie;
    private int seats;

    public Booking(String name, String movie, int seats) {
        this.name = name;
        this.movie = movie;
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Movie: " + movie + ", Seats: " + seats;
    }
}