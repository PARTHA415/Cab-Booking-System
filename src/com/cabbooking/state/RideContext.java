package com.cabbooking.state;

/**
 * RideContext
 * State Pattern - Context class that maintains current state
 */
public class RideContext {
    private RideState currentState;
    private String rideId;
    private String riderId;
    private String driverId;

    public RideContext(String rideId, String riderId) {
        this.rideId = rideId;
        this.riderId = riderId;
        this.currentState = new RequestedState();
        System.out.println("\n[RIDE CREATED] Ride ID: " + rideId);
        System.out.println("  Rider: " + riderId);
        System.out.println("  Initial State: " + currentState.getStateName() + "\n");
    }

    public void setState(RideState state) {
        this.currentState = state;
    }

    public RideState getState() {
        return currentState;
    }

    public String getStateName() {
        return currentState.getStateName();
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getDriverId() {
        return driverId;
    }

    public String getRideId() {
        return rideId;
    }

    public String getRiderId() {
        return riderId;
    }

    // State transition methods
    public void requestRide() {
        currentState.handleRequest(this);
    }

    public void acceptRide(String driverId) {
        this.driverId = driverId;
        System.out.println("[ACTION] Driver " + driverId + " accepting ride...");
        currentState.accept(this);
    }

    public void startRide() {
        System.out.println("[ACTION] Starting ride...");
        currentState.start(this);
    }

    public void completeRide() {
        System.out.println("[ACTION] Completing ride...");
        currentState.complete(this);
    }

    public void cancelRide() {
        System.out.println("[ACTION] Cancelling ride...");
        currentState.cancel(this);
    }

    public void printStatus() {
        System.out.println("─────────────────────────────────────────");
        System.out.println("RIDE STATUS");
        System.out.println("─────────────────────────────────────────");
        System.out.println("  Ride ID: " + rideId);
        System.out.println("  Rider: " + riderId);
        System.out.println("  Driver: " + (driverId != null ? driverId : "Not assigned"));
        System.out.println("  State: " + currentState.getStateName());
        System.out.println("─────────────────────────────────────────\n");
    }
}

