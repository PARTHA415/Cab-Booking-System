package com.cabbooking.chain;

import com.cabbooking.builder.RideRequest;
import java.util.List;

/**
 * DriverMatchingHandler
 * Chain of Responsibility Pattern - Abstract handler for driver matching
 */
public abstract class DriverMatchingHandler {
    protected DriverMatchingHandler nextHandler;
    protected String handlerName;

    public DriverMatchingHandler(String handlerName) {
        this.handlerName = handlerName;
    }

    public DriverMatchingHandler setNext(DriverMatchingHandler handler) {
        this.nextHandler = handler;
        return handler;
    }

    public List<Driver> handle(RideRequest request, List<Driver> drivers) {
        System.out.println("  [FILTER] " + handlerName + " processing " + drivers.size() + " drivers...");
        List<Driver> filtered = filter(request, drivers);
        System.out.println("    → " + filtered.size() + " drivers passed");

        if (nextHandler != null && !filtered.isEmpty()) {
            return nextHandler.handle(request, filtered);
        }
        return filtered;
    }

    protected abstract List<Driver> filter(RideRequest request, List<Driver> drivers);
}

