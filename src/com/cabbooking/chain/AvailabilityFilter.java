package com.cabbooking.chain;

import com.cabbooking.builder.RideRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * AvailabilityFilter
 * Chain of Responsibility Pattern - Filters only available drivers
 */
public class AvailabilityFilter extends DriverMatchingHandler {

    public AvailabilityFilter() {
        super("Availability Filter");
    }

    @Override
    protected List<Driver> filter(RideRequest request, List<Driver> drivers) {
        return drivers.stream()
                .filter(Driver::isAvailable)
                .collect(Collectors.toList());
    }
}

