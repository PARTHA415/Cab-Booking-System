package com.cabbooking.strategy;

/**
 * NightFareStrategy
 * Strategy Pattern - Night-time fare calculation (1.25x multiplier)
 */
public class NightFareStrategy implements FareStrategy {
    private static final double BASE_FARE = 50.0;
    private static final double PER_KM_RATE = 12.0;
    private static final double PER_MINUTE_RATE = 2.0;
    private static final double NIGHT_MULTIPLIER = 1.25;

    @Override
    public double calculateFare(double distanceKm, double durationMinutes) {
        double baseFare = BASE_FARE + (distanceKm * PER_KM_RATE) + (durationMinutes * PER_MINUTE_RATE);
        double nightFare = baseFare * NIGHT_MULTIPLIER;
        return Math.round(nightFare * 100.0) / 100.0;
    }

    @Override
    public String getStrategyName() {
        return "NIGHT";
    }

    @Override
    public String getDescription() {
        return "Night pricing: " + NIGHT_MULTIPLIER + "x multiplier (11 PM - 5 AM)";
    }
}

