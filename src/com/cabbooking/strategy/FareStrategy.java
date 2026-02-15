package com.cabbooking.strategy;

/**
 * FareStrategy Interface
 * Strategy Pattern - defines the interface for fare calculation strategies
 */
public interface FareStrategy {
    double calculateFare(double distanceKm, double durationMinutes);
    String getStrategyName();
    String getDescription();
}

