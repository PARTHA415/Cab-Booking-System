package com.cabbooking.builder;

import java.util.Date;

public class RideRequest {
    private final String rideId;
    private final String riderId;
    private final String riderName;
    private final String riderPhone;
    private final String pickupLocation;
    private final String dropoffLocation;
    private final double pickupLatitude;
    private final double pickupLongitude;
    private final double dropoffLatitude;
    private final double dropoffLongitude;
    private final String vehicleType;
    private final int passengerCount;
    private final boolean isPoolRide;
    private final boolean isPremium;
    private final String paymentMethod;
    private final String promoCode;
    private final String notes;
    private final Date createdAt;

    public RideRequest(RideRequestBuilder builder) {
        this.rideId = builder.getRideId();
        this.riderId = builder.getRiderId();
        this.riderName = builder.getRiderName();
        this.riderPhone = builder.getRiderPhone();
        this.pickupLocation = builder.getPickupLocation();
        this.dropoffLocation = builder.getDropoffLocation();
        this.pickupLatitude = builder.getPickupLatitude();
        this.pickupLongitude = builder.getPickupLongitude();
        this.dropoffLatitude = builder.getDropoffLatitude();
        this.dropoffLongitude = builder.getDropoffLongitude();
        this.vehicleType = builder.getVehicleType();
        this.passengerCount = builder.getPassengerCount();
        this.isPoolRide = builder.isPoolRide();
        this.isPremium = builder.isPremium();
        this.paymentMethod = builder.getPaymentMethod();
        this.promoCode = builder.getPromoCode();
        this.notes = builder.getNotes();
        this.createdAt = new Date();
    }

    public void printDetails() {
        System.out.println("============================================================");
        System.out.println("                    RIDE REQUEST");
        System.out.println("============================================================");
        System.out.println("  Ride ID: " + rideId);
        System.out.println("  Created: " + createdAt);
        System.out.println("------------------------------------------------------------");
        System.out.println("  RIDER DETAILS:");
        System.out.println("    ID: " + riderId);
        if (riderName != null) System.out.println("    Name: " + riderName);
        if (riderPhone != null) System.out.println("    Phone: " + riderPhone);
        System.out.println("------------------------------------------------------------");
        System.out.println("  TRIP DETAILS:");
        System.out.println("    Pickup: " + pickupLocation);
        System.out.println("    Dropoff: " + dropoffLocation);
        System.out.println("------------------------------------------------------------");
        System.out.println("  RIDE OPTIONS:");
        System.out.println("    Vehicle Type: " + vehicleType);
        System.out.println("    Passengers: " + passengerCount);
        System.out.println("    Pool Ride: " + (isPoolRide ? "Yes" : "No"));
        System.out.println("    Premium: " + (isPremium ? "Yes" : "No"));
        System.out.println("    Payment: " + paymentMethod);
        if (promoCode != null) System.out.println("    Promo Code: " + promoCode);
        if (notes != null) System.out.println("    Notes: " + notes);
        System.out.println("============================================================\n");
    }

    public String getRideId() { return rideId; }
    public String getRiderId() { return riderId; }
    public String getPickupLocation() { return pickupLocation; }
    public String getDropoffLocation() { return dropoffLocation; }
    public String getVehicleType() { return vehicleType; }
    public boolean isPoolRide() { return isPoolRide; }
    public boolean isPremium() { return isPremium; }
}

