package com.cabbooking.strategy;

/**
 * FareCalculator
 * Strategy Pattern - Context class that uses FareStrategy
 */
public class FareCalculator {
    private FareStrategy strategy;

    public FareCalculator(FareStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(FareStrategy strategy) {
        this.strategy = strategy;
    }

    public FareStrategy getStrategy() {
        return strategy;
    }

    public double calculateFare(double distanceKm, double durationMinutes) {
        return strategy.calculateFare(distanceKm, durationMinutes);
    }

    public void printFareDetails(double distanceKm, double durationMinutes) {
        double fare = calculateFare(distanceKm, durationMinutes);
        System.out.println("===========================================");
        System.out.println("FARE CALCULATION - " + strategy.getStrategyName());
        System.out.println("===========================================");
        System.out.println("  Strategy: " + strategy.getDescription());
        System.out.println("  Distance: " + distanceKm + " km");
        System.out.println("  Duration: " + durationMinutes + " minutes");
        System.out.println("  Total Fare: ₹" + fare);
        System.out.println("===========================================\n");
    }
}

