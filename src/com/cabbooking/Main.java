package com.cabbooking;

import com.cabbooking.strategy.*;
import com.cabbooking.state.*;
import com.cabbooking.observer.*;
import com.cabbooking.builder.*;
import com.cabbooking.chain.*;
import com.cabbooking.singleton.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        printHeader();
        demoStrategyPattern();
        demoStatePattern();
        demoObserverPattern();
        demoBuilderPattern();
        demoChainOfResponsibilityPattern();
        demoSingletonPattern();
        printFooter();
    }

    private static void printHeader() {
        System.out.println("\n============================================================");
        System.out.println("         CAB BOOKING SYSTEM - DEMO");
        System.out.println("         Design Patterns Demonstration");
        System.out.println("============================================================\n");
    }

    private static void printFooter() {
        System.out.println("\n============================================================");
        System.out.println("              DEMO COMPLETED SUCCESSFULLY");
        System.out.println("============================================================\n");
    }

    private static void demoStrategyPattern() {
        System.out.println("\n============================================================");
        System.out.println("  [1] STRATEGY PATTERN - Fare Calculation Strategies");
        System.out.println("============================================================\n");

        double distance = 15.0;
        double duration = 35.0;
        System.out.println("Trip details: " + distance + " km, " + duration + " minutes\n");

        FareCalculator calculator = new FareCalculator(new NormalFareStrategy());
        calculator.printFareDetails(distance, duration);

        calculator.setStrategy(new PeakFareStrategy());
        calculator.printFareDetails(distance, duration);

        calculator.setStrategy(new NightFareStrategy());
        calculator.printFareDetails(distance, duration);

        calculator.setStrategy(new PoolFareStrategy());
        calculator.printFareDetails(distance, duration);
    }

    private static void demoStatePattern() {
        System.out.println("\n============================================================");
        System.out.println("  [2] STATE PATTERN - Ride Lifecycle Management");
        System.out.println("============================================================\n");

        RideContext ride = new RideContext("RIDE-001", "RIDER-123");
        ride.printStatus();

        System.out.println("Attempting invalid transitions:");
        ride.startRide();
        ride.completeRide();
        System.out.println();

        System.out.println("Valid ride lifecycle:");
        ride.acceptRide("DRIVER-456");
        ride.printStatus();
        ride.startRide();
        ride.printStatus();
        ride.completeRide();
        ride.printStatus();

        System.out.println("\n--- New ride with cancellation ---\n");
        RideContext ride2 = new RideContext("RIDE-002", "RIDER-789");
        ride2.acceptRide("DRIVER-111");
        ride2.cancelRide();
        ride2.printStatus();
    }

    private static void demoObserverPattern() {
        System.out.println("\n============================================================");
        System.out.println("  [3] OBSERVER PATTERN - Notification System");
        System.out.println("============================================================\n");

        RideEventPublisher publisher = new RideEventPublisher();
        publisher.subscribe(new RiderNotificationObserver("RIDER-123", "+91-9876543210"));
        publisher.subscribe(new DriverNotificationObserver("DRIVER-456", "+91-1234567890"));
        publisher.subscribe(new AnalyticsObserver());

        RideEvent event = new RideEvent("RIDE-003", "RIDER-123", "RIDE_REQUESTED");
        event.setPickup("Airport");
        event.setDropoff("City Center");

        publisher.publishRideRequested(event);
        event.setDriverId("DRIVER-456");
        publisher.publishRideAccepted(event);
        publisher.publishRideStarted(event);
        event.setFare(285.50);
        publisher.publishRideCompleted(event);
    }

    private static void demoBuilderPattern() {
        System.out.println("\n============================================================");
        System.out.println("  [4] BUILDER PATTERN - Ride Request Creation");
        System.out.println("============================================================\n");

        System.out.println("Creating simple ride request...\n");
        RideRequest simpleRide = new RideRequestBuilder()
                .riderId("RIDER-100")
                .pickup("Home", 12.9716, 77.5946)
                .dropoff("Office", 12.9279, 77.6271)
                .build();
        simpleRide.printDetails();

        System.out.println("Creating premium ride request...\n");
        RideRequest premiumRide = new RideRequestBuilder()
                .riderId("RIDER-200")
                .riderName("John Doe")
                .riderPhone("+91-9876543210")
                .pickup("Airport Terminal 2", 12.9941, 77.7068)
                .dropoff("Taj Hotel", 12.9716, 77.5946)
                .vehicleType("PREMIUM")
                .passengerCount(3)
                .premium(true)
                .paymentMethod("CREDIT_CARD")
                .promoCode("FIRST50")
                .build();
        premiumRide.printDetails();
    }

    private static void demoChainOfResponsibilityPattern() {
        System.out.println("\n============================================================");
        System.out.println("  [5] CHAIN OF RESPONSIBILITY - Driver Matching");
        System.out.println("============================================================\n");

        List<Driver> drivers = Arrays.asList(
            new Driver("D001", "Rahul Kumar").vehicleType("STANDARD").rating(4.8).distance(1.2).available(true).acceptsPool(true),
            new Driver("D002", "Priya Singh").vehicleType("PREMIUM").rating(4.9).distance(2.5).available(true).acceptsPool(false),
            new Driver("D003", "Amit Patel").vehicleType("STANDARD").rating(3.5).distance(0.8).available(true).acceptsPool(true),
            new Driver("D004", "Sneha Reddy").vehicleType("STANDARD").rating(4.6).distance(3.0).available(false).acceptsPool(true),
            new Driver("D005", "Vikram Joshi").vehicleType("SUV").rating(4.7).distance(4.5).available(true).acceptsPool(true)
        );

        System.out.println("Available drivers:");
        for (Driver d : drivers) {
            System.out.println("  " + d);
        }

        RideRequest request = new RideRequestBuilder()
                .riderId("RIDER-TEST")
                .pickup("City Center", 12.9716, 77.5946)
                .dropoff("Tech Park", 12.9279, 77.6271)
                .vehicleType("STANDARD")
                .build();

        DriverMatcher matcher = new DriverMatcher();
        Driver bestDriver = matcher.findBestDriver(request, drivers);
    }

    private static void demoSingletonPattern() {
        System.out.println("\n============================================================");
        System.out.println("  [6] SINGLETON PATTERN - Location Service Cache");
        System.out.println("============================================================\n");

        LocationService service1 = LocationService.getInstance();

        System.out.println("Looking up locations...\n");
        double[] airport = service1.getCoordinates("Airport");
        System.out.println("    Airport: (" + airport[0] + ", " + airport[1] + ")");

        double[] city = service1.getCoordinates("City Center");
        System.out.println("    City Center: (" + city[0] + ", " + city[1] + ")");

        System.out.println("\nCalculating distances...\n");
        double dist = service1.calculateDistance("Airport", "City Center");
        System.out.println("  Airport -> City Center: " + dist + " km");
        System.out.println("    Estimated time: " + service1.estimateTime(dist) + " minutes");

        LocationService service2 = LocationService.getInstance();
        System.out.println("\nSingleton verification: service1 == service2: " + (service1 == service2));

        service1.printStatistics();
    }
}

