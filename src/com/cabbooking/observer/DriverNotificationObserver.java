package com.cabbooking.observer;

/**
 * DriverNotificationObserver
 * Observer Pattern - Sends notifications to drivers
 */
public class DriverNotificationObserver implements RideObserver {
    private String driverId;
    private String phoneNumber;

    public DriverNotificationObserver(String driverId, String phoneNumber) {
        this.driverId = driverId;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void onRideRequested(RideEvent event) {
        System.out.println("  🚗 [DRIVER PUSH → " + driverId + "] New ride request! Pickup: " +
            event.getPickup() + " → " + event.getDropoff());
    }

    @Override
    public void onRideAccepted(RideEvent event) {
        if (driverId.equals(event.getDriverId())) {
            System.out.println("  🚗 [DRIVER PUSH → " + driverId + "] You accepted the ride. Navigate to pickup location.");
        }
    }

    @Override
    public void onRideStarted(RideEvent event) {
        if (driverId.equals(event.getDriverId())) {
            System.out.println("  🚗 [DRIVER PUSH → " + driverId + "] Ride started. Navigate to: " + event.getDropoff());
        }
    }

    @Override
    public void onRideCompleted(RideEvent event) {
        if (driverId.equals(event.getDriverId())) {
            System.out.println("  🚗 [DRIVER PUSH → " + driverId + "] Ride completed! You earned: ₹" +
                (event.getFare() * 0.8) + " (80% of ₹" + event.getFare() + ")");
        }
    }

    @Override
    public void onRideCancelled(RideEvent event) {
        if (driverId.equals(event.getDriverId())) {
            System.out.println("  🚗 [DRIVER PUSH → " + driverId + "] Ride cancelled by rider.");
        }
    }

    @Override
    public String getObserverName() {
        return "DriverNotification(" + driverId + ")";
    }
}

