package com.cabbooking.observer;

/**
 * RiderNotificationObserver
 * Observer Pattern - Sends notifications to riders
 */
public class RiderNotificationObserver implements RideObserver {
    private String riderId;
    private String phoneNumber;

    public RiderNotificationObserver(String riderId, String phoneNumber) {
        this.riderId = riderId;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void onRideRequested(RideEvent event) {
        if (event.getRiderId().equals(riderId)) {
            System.out.println("  📱 [RIDER SMS → " + phoneNumber + "] Your ride request is being processed...");
        }
    }

    @Override
    public void onRideAccepted(RideEvent event) {
        if (event.getRiderId().equals(riderId)) {
            System.out.println("  📱 [RIDER SMS → " + phoneNumber + "] Great news! Driver " +
                event.getDriverId() + " accepted your ride. They're on their way!");
        }
    }

    @Override
    public void onRideStarted(RideEvent event) {
        if (event.getRiderId().equals(riderId)) {
            System.out.println("  📱 [RIDER SMS → " + phoneNumber + "] Your ride has started. Enjoy your trip!");
        }
    }

    @Override
    public void onRideCompleted(RideEvent event) {
        if (event.getRiderId().equals(riderId)) {
            System.out.println("  📱 [RIDER SMS → " + phoneNumber + "] Ride completed! Fare: ₹" +
                event.getFare() + ". Thank you for riding with us!");
        }
    }

    @Override
    public void onRideCancelled(RideEvent event) {
        if (event.getRiderId().equals(riderId)) {
            System.out.println("  📱 [RIDER SMS → " + phoneNumber + "] Your ride has been cancelled.");
        }
    }

    @Override
    public String getObserverName() {
        return "RiderNotification(" + riderId + ")";
    }
}

