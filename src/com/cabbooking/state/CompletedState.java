package com.cabbooking.state;

/**
 * CompletedState
 * State Pattern - Final state when ride is completed
 */
public class CompletedState implements RideState {

    @Override
    public void handleRequest(RideContext context) {
        System.out.println("[STATE] Ride completed. Please create a new ride request.");
    }

    @Override
    public void accept(RideContext context) {
        System.out.println("[STATE] Ride already completed.");
    }

    @Override
    public void start(RideContext context) {
        System.out.println("[STATE] Ride already completed.");
    }

    @Override
    public void complete(RideContext context) {
        System.out.println("[STATE] Ride already completed.");
    }

    @Override
    public void cancel(RideContext context) {
        System.out.println("[STATE] Cannot cancel. Ride already completed.");
    }

    @Override
    public String getStateName() {
        return "COMPLETED";
    }
}

