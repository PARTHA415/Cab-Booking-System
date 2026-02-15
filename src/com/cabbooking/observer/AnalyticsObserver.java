package com.cabbooking.observer;

import java.util.Date;

/**
 * AnalyticsObserver
 * Observer Pattern - Logs ride events for analytics
 */
public class AnalyticsObserver implements RideObserver {

    @Override
    public void onRideRequested(RideEvent event) {
        logEvent("RIDE_REQUESTED", event);
    }

    @Override
    public void onRideAccepted(RideEvent event) {
        logEvent("RIDE_ACCEPTED", event);
    }

    @Override
    public void onRideStarted(RideEvent event) {
        logEvent("RIDE_STARTED", event);
    }

    @Override
    public void onRideCompleted(RideEvent event) {
        logEvent("RIDE_COMPLETED", event);
    }

    @Override
    public void onRideCancelled(RideEvent event) {
        logEvent("RIDE_CANCELLED", event);
    }

    private void logEvent(String eventType, RideEvent event) {
        System.out.println("  📊 [ANALYTICS] Event logged: " + eventType +
            " | Ride: " + event.getRideId() +
            " | Time: " + new Date(event.getTimestamp()));
    }

    @Override
    public String getObserverName() {
        return "AnalyticsObserver";
    }
}

