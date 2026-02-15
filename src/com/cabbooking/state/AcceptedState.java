package com.cabbooking.state;

/**
 * AcceptedState
 * State Pattern - State when driver has accepted the ride
 */
public class AcceptedState implements RideState {

    @Override
    public void handleRequest(RideContext context) {
        System.out.println("[STATE] Ride already accepted. Driver is on the way.");
    }

    @Override
    public void accept(RideContext context) {
        System.out.println("[STATE] Ride already accepted.");
    }

    @Override
    public void start(RideContext context) {
        System.out.println("[STATE] Ride started! Driver picked up the rider.");
        System.out.println("  → Transitioning from ACCEPTED to STARTED");
        context.setState(new StartedState());
    }

    @Override
    public void complete(RideContext context) {
        System.out.println("[STATE] Cannot complete. Ride not yet started.");
    }

    @Override
    public void cancel(RideContext context) {
        System.out.println("[STATE] Ride cancelled. Driver notified.");
        System.out.println("  → Transitioning from ACCEPTED to CANCELLED");
        context.setState(new CancelledState());
    }

    @Override
    public String getStateName() {
        return "ACCEPTED";
    }
}

