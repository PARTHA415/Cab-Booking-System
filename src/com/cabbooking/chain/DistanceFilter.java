package com.cabbooking.chain;

import com.cabbooking.builder.RideRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * DistanceFilter
 * Chain of Responsibility Pattern - Filters drivers within 5km radius
 */
public class DistanceFilter extends DriverMatchingHandler {
    private static final double MAX_DISTANCE_KM = 5.0;

    public DistanceFilter() {
        super("Distance Filter (within " + MAX_DISTANCE_KM + "km)");
    }

    @Override
    protected List<Driver> filter(RideRequest request, List<Driver> drivers) {
        return drivers.stream()
                .filter(d -> d.getDistanceFromPickup() <= MAX_DISTANCE_KM)
                .collect(Collectors.toList());
    }
}

