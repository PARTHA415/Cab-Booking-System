package com.cabbooking.builder;

import java.util.UUID;

/**
 * RideRequestBuilder
 * Builder Pattern - Fluent builder for creating ride requests
 */
public class RideRequestBuilder {
    private String rideId;
    private String riderId;
    private String riderName;
    private String riderPhone;
    private String pickupLocation;
    private String dropoffLocation;
    private double pickupLatitude;
    private double pickupLongitude;
    private double dropoffLatitude;
    private double dropoffLongitude;
    private String vehicleType;
    private int passengerCount;
    private boolean isPoolRide;
    private boolean isPremium;
    private String paymentMethod;
    private String promoCode;
    private String notes;

    public RideRequestBuilder() {
        this.rideId = "RIDE-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.vehicleType = "STANDARD";
        this.passengerCount = 1;
        this.isPoolRide = false;
        this.isPremium = false;
        this.paymentMethod = "CASH";
    }

    public RideRequestBuilder riderId(String riderId) {
        this.riderId = riderId;
        return this;
    }

    public RideRequestBuilder riderName(String riderName) {
        this.riderName = riderName;
        return this;
    }

    public RideRequestBuilder riderPhone(String riderPhone) {
        this.riderPhone = riderPhone;
        return this;
    }

    public RideRequestBuilder pickup(String location, double latitude, double longitude) {
        this.pickupLocation = location;
        this.pickupLatitude = latitude;
        this.pickupLongitude = longitude;
        return this;
    }

    public RideRequestBuilder dropoff(String location, double latitude, double longitude) {
        this.dropoffLocation = location;
        this.dropoffLatitude = latitude;
        this.dropoffLongitude = longitude;
        return this;
    }

    public RideRequestBuilder vehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
        return this;
    }

    public RideRequestBuilder passengerCount(int count) {
        this.passengerCount = count;
        return this;
    }

    public RideRequestBuilder poolRide(boolean isPool) {
        this.isPoolRide = isPool;
        return this;
    }

    public RideRequestBuilder premium(boolean isPremium) {
        this.isPremium = isPremium;
        return this;
    }

    public RideRequestBuilder paymentMethod(String method) {
        this.paymentMethod = method;
        return this;
    }

    public RideRequestBuilder promoCode(String code) {
        this.promoCode = code;
        return this;
    }

    public RideRequestBuilder notes(String notes) {
        this.notes = notes;
        return this;
    }

    public RideRequest build() {
        // Validation
        if (riderId == null || riderId.isEmpty()) {
            throw new IllegalArgumentException("Rider ID is required");
        }
        if (pickupLocation == null || pickupLocation.isEmpty()) {
            throw new IllegalArgumentException("Pickup location is required");
        }
        if (dropoffLocation == null || dropoffLocation.isEmpty()) {
            throw new IllegalArgumentException("Dropoff location is required");
        }
        return new RideRequest(this);
    }

    // Getters for RideRequest
    public String getRideId() { return rideId; }
    public String getRiderId() { return riderId; }
    public String getRiderName() { return riderName; }
    public String getRiderPhone() { return riderPhone; }
    public String getPickupLocation() { return pickupLocation; }
    public String getDropoffLocation() { return dropoffLocation; }
    public double getPickupLatitude() { return pickupLatitude; }
    public double getPickupLongitude() { return pickupLongitude; }
    public double getDropoffLatitude() { return dropoffLatitude; }
    public double getDropoffLongitude() { return dropoffLongitude; }
    public String getVehicleType() { return vehicleType; }
    public int getPassengerCount() { return passengerCount; }
    public boolean isPoolRide() { return isPoolRide; }
    public boolean isPremium() { return isPremium; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getPromoCode() { return promoCode; }
    public String getNotes() { return notes; }
}

