package com.cabbooking.state;

/**
 * RequestedState
 * State Pattern - Initial state when ride is requested
 */
public class RequestedState implements RideState {

    @Override
    public void handleRequest(RideContext context) {
        System.out.println("[STATE] Ride already requested. Waiting for driver...");
    }

    @Override
    public void accept(RideContext context) {
        System.out.println("[STATE] Driver accepted the ride request!");
        System.out.println("  → Transitioning from REQUESTED to ACCEPTED");
        context.setState(new AcceptedState());
    }

    @Override
    public void start(RideContext context) {
        System.out.println("[STATE] Cannot start ride. Waiting for driver to accept.");
    }

    @Override
    public void complete(RideContext context) {
        System.out.println("[STATE] Cannot complete ride. Ride not yet started.");
    }

    @Override
    public void cancel(RideContext context) {
        System.out.println("[STATE] Ride cancelled by user.");
        System.out.println("  → Transitioning from REQUESTED to CANCELLED");
        context.setState(new CancelledState());
    }

    @Override
    public String getStateName() {
        return "REQUESTED";
    }
}

