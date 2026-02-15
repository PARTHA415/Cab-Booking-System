package com.cabbooking.chain;

import com.cabbooking.builder.RideRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * RatingFilter
 * Chain of Responsibility Pattern - Filters drivers with rating >= 4.0
 */
public class RatingFilter extends DriverMatchingHandler {
    private static final double MIN_RATING = 4.0;

    public RatingFilter() {
        super("Rating Filter (>= " + MIN_RATING + ")");
    }

    @Override
    protected List<Driver> filter(RideRequest request, List<Driver> drivers) {
        // For premium rides, require higher rating
        double minRating = request.isPremium() ? 4.5 : MIN_RATING;
        return drivers.stream()
                .filter(d -> d.getRating() >= minRating)
                .collect(Collectors.toList());
    }
}

