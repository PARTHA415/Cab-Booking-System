package com.cabbooking.singleton;

import java.util.*;

public class LocationService {
    private static LocationService instance;
    private Map<String, double[]> locationCache;
    private Map<String, Double> distanceCache;
    private int cacheHits;
    private int cacheMisses;
    private Date startTime;

    private LocationService() {
        this.locationCache = new HashMap<>();
        this.distanceCache = new HashMap<>();
        this.cacheHits = 0;
        this.cacheMisses = 0;
        this.startTime = new Date();
        initializeDefaultLocations();
        System.out.println("[SINGLETON] LocationService instance created");
    }

    public static synchronized LocationService getInstance() {
        if (instance == null) {
            instance = new LocationService();
        }
        return instance;
    }

    private void initializeDefaultLocations() {
        locationCache.put("Airport", new double[]{12.9941, 77.7068});
        locationCache.put("Railway Station", new double[]{12.9762, 77.5726});
        locationCache.put("City Center", new double[]{12.9716, 77.5946});
        locationCache.put("Tech Park", new double[]{12.9279, 77.6271});
        locationCache.put("Shopping Mall", new double[]{12.9352, 77.6245});
    }

    public double[] getCoordinates(String location) {
        if (locationCache.containsKey(location)) {
            cacheHits++;
            System.out.println("  [LOCATION CACHE] HIT: " + location);
            return locationCache.get(location);
        }
        cacheMisses++;
        System.out.println("  [LOCATION CACHE] MISS: " + location + " (fetching...)");
        double[] coords = new double[]{12.9 + Math.random() * 0.2, 77.5 + Math.random() * 0.3};
        locationCache.put(location, coords);
        return coords;
    }

    public double calculateDistance(String from, String to) {
        String cacheKey = from + "->" + to;
        if (distanceCache.containsKey(cacheKey)) {
            cacheHits++;
            return distanceCache.get(cacheKey);
        }
        cacheMisses++;
        double[] fromCoords = getCoordinates(from);
        double[] toCoords = getCoordinates(to);
        double distance = calculateHaversineDistance(fromCoords[0], fromCoords[1], toCoords[0], toCoords[1]);
        distanceCache.put(cacheKey, distance);
        return distance;
    }

    private double calculateHaversineDistance(double lat1, double lon1, double lat2, double lon2) {
        double R = 6371;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                   Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return Math.round(R * c * 100.0) / 100.0;
    }

    public double estimateTime(double distanceKm) {
        double hours = distanceKm / 25.0;
        return Math.round(hours * 60 * 10.0) / 10.0;
    }

    public void printStatistics() {
        System.out.println("\n============================================================");
        System.out.println("              LOCATION SERVICE STATISTICS");
        System.out.println("============================================================");
        System.out.println("  Service started: " + startTime);
        System.out.println("  Locations cached: " + locationCache.size());
        System.out.println("  Distances cached: " + distanceCache.size());
        System.out.println("  Cache hits: " + cacheHits);
        System.out.println("  Cache misses: " + cacheMisses);
        double hitRate = (cacheHits + cacheMisses) > 0 ? (cacheHits * 100.0 / (cacheHits + cacheMisses)) : 0;
        System.out.println("  Hit rate: " + Math.round(hitRate) + "%");
        System.out.println("============================================================\n");
    }
}

