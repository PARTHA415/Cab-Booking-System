package com.cabbooking.state;

/**
 * RideState Interface
 * State Pattern - defines the interface for ride states
 */
public interface RideState {
    void handleRequest(RideContext context);
    void accept(RideContext context);
    void start(RideContext context);
    void complete(RideContext context);
    void cancel(RideContext context);
    String getStateName();
}

