package com.cabbooking.state;

/**
 * StartedState
 * State Pattern - State when ride has started (in progress)
 */
public class StartedState implements RideState {

    @Override
    public void handleRequest(RideContext context) {
        System.out.println("[STATE] Ride in progress. Cannot create new request.");
    }

    @Override
    public void accept(RideContext context) {
        System.out.println("[STATE] Ride already in progress.");
    }

    @Override
    public void start(RideContext context) {
        System.out.println("[STATE] Ride already started.");
    }

    @Override
    public void complete(RideContext context) {
        System.out.println("[STATE] Ride completed! Destination reached.");
        System.out.println("  → Transitioning from STARTED to COMPLETED");
        context.setState(new CompletedState());
    }

    @Override
    public void cancel(RideContext context) {
        System.out.println("[STATE] Cannot cancel ride in progress. Please complete the ride.");
    }

    @Override
    public String getStateName() {
        return "STARTED";
    }
}

