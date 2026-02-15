package com.cabbooking.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * RideEventPublisher
 * Observer Pattern - Subject that publishes ride events to observers
 */
public class RideEventPublisher {
    private List<RideObserver> observers = new ArrayList<>();

    public void subscribe(RideObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            System.out.println("[PUBLISHER] Subscribed: " + observer.getObserverName());
        }
    }

    public void unsubscribe(RideObserver observer) {
        if (observers.remove(observer)) {
            System.out.println("[PUBLISHER] Unsubscribed: " + observer.getObserverName());
        }
    }

    public void publishRideRequested(RideEvent event) {
        System.out.println("\n[PUBLISHER] Broadcasting RIDE_REQUESTED event...");
        for (RideObserver observer : observers) {
            observer.onRideRequested(event);
        }
    }

    public void publishRideAccepted(RideEvent event) {
        System.out.println("\n[PUBLISHER] Broadcasting RIDE_ACCEPTED event...");
        for (RideObserver observer : observers) {
            observer.onRideAccepted(event);
        }
    }

    public void publishRideStarted(RideEvent event) {
        System.out.println("\n[PUBLISHER] Broadcasting RIDE_STARTED event...");
        for (RideObserver observer : observers) {
            observer.onRideStarted(event);
        }
    }

    public void publishRideCompleted(RideEvent event) {
        System.out.println("\n[PUBLISHER] Broadcasting RIDE_COMPLETED event...");
        for (RideObserver observer : observers) {
            observer.onRideCompleted(event);
        }
    }

    public void publishRideCancelled(RideEvent event) {
        System.out.println("\n[PUBLISHER] Broadcasting RIDE_CANCELLED event...");
        for (RideObserver observer : observers) {
            observer.onRideCancelled(event);
        }
    }

    public int getObserverCount() {
        return observers.size();
    }
}

