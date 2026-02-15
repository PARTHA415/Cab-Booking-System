package com.cabbooking.strategy;

/**
 * NormalFareStrategy
 * Strategy Pattern - Normal/base fare calculation
 */
public class NormalFareStrategy implements FareStrategy {
    private static final double BASE_FARE = 50.0;
    private static final double PER_KM_RATE = 12.0;
    private static final double PER_MINUTE_RATE = 2.0;

    @Override
    public double calculateFare(double distanceKm, double durationMinutes) {
        double fare = BASE_FARE + (distanceKm * PER_KM_RATE) + (durationMinutes * PER_MINUTE_RATE);
        return Math.round(fare * 100.0) / 100.0;
    }

    @Override
    public String getStrategyName() {
        return "NORMAL";
    }

    @Override
    public String getDescription() {
        return "Normal pricing: Base ₹" + BASE_FARE + " + ₹" + PER_KM_RATE + "/km + ₹" + PER_MINUTE_RATE + "/min";
    }
}

