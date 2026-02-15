package com.cabbooking.observer;

/**
 * RideObserver Interface
 * Observer Pattern - defines the interface for ride observers
 */
public interface RideObserver {
    void onRideRequested(RideEvent event);
    void onRideAccepted(RideEvent event);
    void onRideStarted(RideEvent event);
    void onRideCompleted(RideEvent event);
    void onRideCancelled(RideEvent event);
    String getObserverName();
}

