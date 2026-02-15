package com.cabbooking.strategy;

/**
 * PeakFareStrategy
 * Strategy Pattern - Peak/surge pricing calculation (1.5x multiplier)
 */
public class PeakFareStrategy implements FareStrategy {
    private static final double BASE_FARE = 50.0;
    private static final double PER_KM_RATE = 12.0;
    private static final double PER_MINUTE_RATE = 2.0;
    private static final double SURGE_MULTIPLIER = 1.5;

    @Override
    public double calculateFare(double distanceKm, double durationMinutes) {
        double baseFare = BASE_FARE + (distanceKm * PER_KM_RATE) + (durationMinutes * PER_MINUTE_RATE);
        double surgeFare = baseFare * SURGE_MULTIPLIER;
        return Math.round(surgeFare * 100.0) / 100.0;
    }

    @Override
    public String getStrategyName() {
        return "PEAK";
    }

    @Override
    public String getDescription() {
        return "Peak pricing: " + SURGE_MULTIPLIER + "x surge multiplier applied";
    }
}

