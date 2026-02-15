# Cab Booking System - Design Patterns Implementation

A comprehensive Java project demonstrating 6 different design patterns using a cab booking/ride-hailing system as the example domain.

## Project Overview

**Cab Booking System** is an educational project that showcases industry-standard design patterns applied to a real-world ride-hailing system similar to Uber/Ola. The project demonstrates how each pattern solves specific design problems.

## Design Patterns Implemented

| Pattern | Use Case | Package |
|---------|----------|---------|
| **Strategy** | Fare calculation (normal, peak, night, pool) | `com.cabbooking.strategy` |
| **State** | Ride lifecycle (Requested → Accepted → Started → Completed) | `com.cabbooking.state` |
| **Observer** | Rider/Driver notifications | `com.cabbooking.observer` |
| **Builder** | Ride request creation | `com.cabbooking.builder` |
| **Chain of Responsibility** | Driver matching filters | `com.cabbooking.chain` |
| **Singleton** | LocationService cache | `com.cabbooking.singleton` |

## Project Structure

```
CabBookingSystem/
├── src/
│   └── com/
│       └── cabbooking/
│           ├── Main.java                    # Main demonstration class
│           │
│           ├── strategy/                    # Strategy Pattern
│           │   ├── FareStrategy.java        # Strategy interface
│           │   ├── NormalFareStrategy.java  # Base fare calculation
│           │   ├── PeakFareStrategy.java    # Surge pricing (1.5x)
│           │   ├── NightFareStrategy.java   # Night pricing (1.25x)
│           │   ├── PoolFareStrategy.java    # Shared ride discount
│           │   └── FareCalculator.java      # Context class
│           │
│           ├── state/                       # State Pattern
│           │   ├── RideState.java           # State interface
│           │   ├── RequestedState.java      # Initial state
│           │   ├── AcceptedState.java       # Driver accepted
│           │   ├── StartedState.java        # Ride in progress
│           │   ├── CompletedState.java      # Ride finished
│           │   ├── CancelledState.java      # Ride cancelled
│           │   └── RideContext.java         # Context maintaining state
│           │
│           ├── observer/                    # Observer Pattern
│           │   ├── RideObserver.java        # Observer interface
│           │   ├── RideEvent.java           # Event object
│           │   ├── RideEventPublisher.java  # Subject/Publisher
│           │   ├── RiderNotificationObserver.java
│           │   ├── DriverNotificationObserver.java
│           │   └── AnalyticsObserver.java
│           │
│           ├── builder/                     # Builder Pattern
│           │   ├── RideRequestBuilder.java  # Fluent builder
│           │   └── RideRequest.java         # Built object
│           │
│           ├── chain/                       # Chain of Responsibility
│           │   ├── Driver.java              # Driver entity
│           │   ├── DriverMatchingHandler.java # Abstract handler
│           │   ├── AvailabilityFilter.java  # Filter available drivers
│           │   ├── VehicleTypeFilter.java   # Filter by vehicle type
│           │   ├── DistanceFilter.java      # Filter by distance
│           │   ├── RatingFilter.java        # Filter by rating
│           │   ├── PoolRideFilter.java      # Filter pool-accepting drivers
│           │   └── DriverMatcher.java       # Chain orchestrator
│           │
│           └── singleton/                   # Singleton Pattern
│               └── LocationService.java     # Cached location service
│
└── README.md                                # This file
```

## Pattern Details

### 1. Strategy Pattern - Fare Calculation
Different pricing strategies that can be switched at runtime:
- **NormalFareStrategy**: Base fare + per km + per minute
- **PeakFareStrategy**: 1.5x surge pricing during high demand
- **NightFareStrategy**: 1.25x for late night rides (11 PM - 5 AM)
- **PoolFareStrategy**: 30% discount for shared rides

### 2. State Pattern - Ride Lifecycle
Manages ride state transitions:
```
REQUESTED → ACCEPTED → STARTED → COMPLETED
    ↓           ↓
 CANCELLED  CANCELLED
```

### 3. Observer Pattern - Notifications
Publishes ride events to multiple subscribers:
- Rider receives SMS notifications
- Driver receives push notifications
- Analytics system logs all events

### 4. Builder Pattern - Ride Request
Fluent builder for creating complex ride requests with optional parameters:
- Rider details
- Pickup/dropoff locations with coordinates
- Vehicle type preferences
- Pool ride options
- Payment method
- Promo codes

### 5. Chain of Responsibility - Driver Matching
Sequential filters to find the best driver:
1. **AvailabilityFilter** - Only available drivers
2. **VehicleTypeFilter** - Matches requested vehicle type
3. **DistanceFilter** - Within 5km radius
4. **RatingFilter** - Rating >= 4.0 (4.5 for premium)
5. **PoolRideFilter** - Accepts pool rides (if applicable)

### 6. Singleton Pattern - LocationService
Global location service with caching:
- Pre-cached popular locations
- Distance calculations using Haversine formula
- Travel time estimates
- Cache hit/miss statistics

## How to Run

### Using IntelliJ IDEA (Recommended)
1. Open IntelliJ IDEA
2. File → Open → Select `CabBookingSystem` folder
3. Choose "Open as Project" when prompted for `build.gradle`
4. Wait for Gradle sync
5. Navigate to `src/com/cabbooking/Main.java`
6. Right-click → Run 'Main.main()'

### Using Command Line

**Windows:**
```cmd
# Navigate to project
cd CabBookingSystem

# Compile
cd src
javac -encoding UTF-8 -d ..\bin com\cabbooking\*.java com\cabbooking\strategy\*.java com\cabbooking\state\*.java com\cabbooking\observer\*.java com\cabbooking\builder\*.java com\cabbooking\chain\*.java com\cabbooking\singleton\*.java
cd ..

# Run
java -Dfile.encoding=UTF-8 -cp bin com.cabbooking.Main
```

**Linux/Mac:**
```bash
# Navigate to project
cd CabBookingSystem

# Compile
mkdir -p bin
cd src
javac -encoding UTF-8 -d ../bin com/cabbooking/*.java com/cabbooking/**/*.java
cd ..

# Run
java -cp bin com.cabbooking.Main
```

## Sample Output

```
============================================================
         CAB BOOKING SYSTEM - DEMO
         Design Patterns Demonstration
============================================================

[1] STRATEGY PATTERN - Fare Calculation
  Normal Fare: ₹280.00
  Peak Fare (1.5x): ₹420.00
  Night Fare (1.25x): ₹350.00
  Pool Fare (30% off): ₹196.00

[2] STATE PATTERN - Ride Lifecycle
  REQUESTED → ACCEPTED → STARTED → COMPLETED

[3] OBSERVER PATTERN - Notifications
  📱 Rider notified via SMS
  🚗 Driver notified via Push
  📊 Analytics event logged

[4] BUILDER PATTERN - Ride Request
  Complex ride request created with all options

[5] CHAIN OF RESPONSIBILITY - Driver Matching
  7 drivers → Availability → Vehicle → Distance → Rating → Pool
  Best Match: Rahul Kumar (4.8⭐, 1.2km away)

[6] SINGLETON PATTERN - LocationService
  Cache hits: 5, Cache misses: 2
  Single instance verified: true
```

## Learning Outcomes

- Understand when and how to apply each design pattern
- See real-world applications in a ride-hailing context
- Learn best practices for maintainable, extensible code
- Master the SOLID principles through practical examples

