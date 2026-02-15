package com.cabbooking.chain;

/**
 * Driver
 * Represents a driver in the system
 */
public class Driver {
    private String driverId;
    private String name;
    private String vehicleType;
    private double rating;
    private double distanceFromPickup;
    private boolean isAvailable;
    private boolean hasChildSeat;
    private boolean acceptsPool;
    private int completedRides;

    public Driver(String driverId, String name) {
        this.driverId = driverId;
        this.name = name;
        this.isAvailable = true;
        this.acceptsPool = true;
    }

    // Fluent setters for easy initialization
    public Driver vehicleType(String type) { this.vehicleType = type; return this; }
    public Driver rating(double rating) { this.rating = rating; return this; }
    public Driver distance(double distance) { this.distanceFromPickup = distance; return this; }
    public Driver available(boolean available) { this.isAvailable = available; return this; }
    public Driver childSeat(boolean hasChildSeat) { this.hasChildSeat = hasChildSeat; return this; }
    public Driver acceptsPool(boolean accepts) { this.acceptsPool = accepts; return this; }
    public Driver completedRides(int rides) { this.completedRides = rides; return this; }

    // Getters
    public String getDriverId() { return driverId; }
    public String getName() { return name; }
    public String getVehicleType() { return vehicleType; }
    public double getRating() { return rating; }
    public double getDistanceFromPickup() { return distanceFromPickup; }
    public boolean isAvailable() { return isAvailable; }
    public boolean hasChildSeat() { return hasChildSeat; }
    public boolean acceptsPool() { return acceptsPool; }
    public int getCompletedRides() { return completedRides; }

    @Override
    public String toString() {
        return "Driver{" + driverId + ", " + name + ", " + vehicleType +
               ", rating=" + rating + ", distance=" + distanceFromPickup + "km}";
    }
}

