package com.cabbooking.state;

/**
 * CancelledState
 * State Pattern - State when ride is cancelled
 */
public class CancelledState implements RideState {

    @Override
    public void handleRequest(RideContext context) {
        System.out.println("[STATE] Previous ride was cancelled. Creating new request...");
        System.out.println("  → Transitioning from CANCELLED to REQUESTED");
        context.setState(new RequestedState());
    }

    @Override
    public void accept(RideContext context) {
        System.out.println("[STATE] Ride was cancelled. Please create a new request.");
    }

    @Override
    public void start(RideContext context) {
        System.out.println("[STATE] Ride was cancelled. Please create a new request.");
    }

    @Override
    public void complete(RideContext context) {
        System.out.println("[STATE] Ride was cancelled. Cannot complete.");
    }

    @Override
    public void cancel(RideContext context) {
        System.out.println("[STATE] Ride already cancelled.");
    }

    @Override
    public String getStateName() {
        return "CANCELLED";
    }
}

