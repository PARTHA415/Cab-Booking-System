package com.cabbooking.chain;

import com.cabbooking.builder.RideRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * PoolRideFilter
 * Chain of Responsibility Pattern - Filters drivers who accept pool rides
 */
public class PoolRideFilter extends DriverMatchingHandler {

    public PoolRideFilter() {
        super("Pool Ride Filter");
    }

    @Override
    protected List<Driver> filter(RideRequest request, List<Driver> drivers) {
        if (!request.isPoolRide()) {
            // Not a pool ride, skip this filter
            return drivers;
        }
        return drivers.stream()
                .filter(Driver::acceptsPool)
                .collect(Collectors.toList());
    }
}

