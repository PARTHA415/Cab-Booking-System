package com.cabbooking.strategy;

/**
 * PoolFareStrategy
 * Strategy Pattern - Shared/Pool ride fare calculation (0.7x multiplier)
 */
public class PoolFareStrategy implements FareStrategy {
    private static final double BASE_FARE = 30.0;
    private static final double PER_KM_RATE = 8.0;
    private static final double PER_MINUTE_RATE = 1.5;
    private static final double POOL_DISCOUNT = 0.7;

    @Override
    public double calculateFare(double distanceKm, double durationMinutes) {
        double baseFare = BASE_FARE + (distanceKm * PER_KM_RATE) + (durationMinutes * PER_MINUTE_RATE);
        double poolFare = baseFare * POOL_DISCOUNT;
        return Math.round(poolFare * 100.0) / 100.0;
    }

    @Override
    public String getStrategyName() {
        return "POOL";
    }

    @Override
    public String getDescription() {
        return "Pool pricing: " + (int)((1 - POOL_DISCOUNT) * 100) + "% discount for shared rides";
    }
}

