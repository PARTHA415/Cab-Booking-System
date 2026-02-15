package com.cabbooking.chain;

import com.cabbooking.builder.RideRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * VehicleTypeFilter
 * Chain of Responsibility Pattern - Filters drivers by vehicle type
 */
public class VehicleTypeFilter extends DriverMatchingHandler {

    public VehicleTypeFilter() {
        super("Vehicle Type Filter");
    }

    @Override
    protected List<Driver> filter(RideRequest request, List<Driver> drivers) {
        String requestedType = request.getVehicleType();
        return drivers.stream()
                .filter(d -> d.getVehicleType().equalsIgnoreCase(requestedType) ||
                            "STANDARD".equalsIgnoreCase(requestedType))
                .collect(Collectors.toList());
    }
}

