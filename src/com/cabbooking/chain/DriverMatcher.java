package com.cabbooking.chain;

import com.cabbooking.builder.RideRequest;
import java.util.Comparator;
import java.util.List;

public class DriverMatcher {
    private DriverMatchingHandler filterChain;

    public DriverMatcher() {
        AvailabilityFilter availabilityFilter = new AvailabilityFilter();
        VehicleTypeFilter vehicleTypeFilter = new VehicleTypeFilter();
        DistanceFilter distanceFilter = new DistanceFilter();
        RatingFilter ratingFilter = new RatingFilter();
        PoolRideFilter poolRideFilter = new PoolRideFilter();

        availabilityFilter
            .setNext(vehicleTypeFilter)
            .setNext(distanceFilter)
            .setNext(ratingFilter)
            .setNext(poolRideFilter);

        this.filterChain = availabilityFilter;
    }

    public Driver findBestDriver(RideRequest request, List<Driver> allDrivers) {
        System.out.println("\n============================================================");
        System.out.println("              DRIVER MATCHING PROCESS");
        System.out.println("============================================================");
        System.out.println("  Processing " + allDrivers.size() + " total drivers...\n");

        List<Driver> eligibleDrivers = filterChain.handle(request, allDrivers);

        System.out.println("\n  Final eligible drivers: " + eligibleDrivers.size());

        if (eligibleDrivers.isEmpty()) {
            System.out.println("  [X] No drivers available matching criteria");
            System.out.println("============================================================\n");
            return null;
        }

        Driver bestDriver = eligibleDrivers.stream()
                .sorted(Comparator.comparingDouble(Driver::getDistanceFromPickup)
                        .thenComparing(Comparator.comparingDouble(Driver::getRating).reversed()))
                .findFirst()
                .orElse(null);

        if (bestDriver != null) {
            System.out.println("\n  [OK] BEST MATCH: " + bestDriver.getName());
            System.out.println("     Driver ID: " + bestDriver.getDriverId());
            System.out.println("     Vehicle: " + bestDriver.getVehicleType());
            System.out.println("     Rating: " + bestDriver.getRating() + " stars");
            System.out.println("     Distance: " + bestDriver.getDistanceFromPickup() + " km away");
        }
        System.out.println("============================================================\n");

        return bestDriver;
    }
}

