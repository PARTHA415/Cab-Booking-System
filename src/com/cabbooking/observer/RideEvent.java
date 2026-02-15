package com.cabbooking.observer;

/**
 * RideEvent
 * Observer Pattern - Event object containing ride information
 */
public class RideEvent {
    private String rideId;
    private String riderId;
    private String driverId;
    private String pickup;
    private String dropoff;
    private double fare;
    private String eventType;
    private long timestamp;

    public RideEvent(String rideId, String riderId, String eventType) {
        this.rideId = rideId;
        this.riderId = riderId;
        this.eventType = eventType;
        this.timestamp = System.currentTimeMillis();
    }

    // Getters and setters
    public String getRideId() { return rideId; }
    public String getRiderId() { return riderId; }
    public String getDriverId() { return driverId; }
    public String getPickup() { return pickup; }
    public String getDropoff() { return dropoff; }
    public double getFare() { return fare; }
    public String getEventType() { return eventType; }
    public long getTimestamp() { return timestamp; }

    public void setDriverId(String driverId) { this.driverId = driverId; }
    public void setPickup(String pickup) { this.pickup = pickup; }
    public void setDropoff(String dropoff) { this.dropoff = dropoff; }
    public void setFare(double fare) { this.fare = fare; }

    @Override
    public String toString() {
        return "RideEvent{rideId='" + rideId + "', type='" + eventType + "'}";
    }
}

