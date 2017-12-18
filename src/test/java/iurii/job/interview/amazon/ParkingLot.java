package iurii.job.interview.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

/**
 * Design parking lot and implement two methods :
 * - placeVehicle
 * - retrieveVehicle
 *
 * Hundreds of parking spots and need a system to manage it.
 *
 * 1) Handling ambiguity - recognizing the breadth of the problem statement.
 * By asking questions like:
 * - Do you want me to come up with system design
 * - Do you want me to come up with class hierarchy
 * - Do you want me to come up with methods based on algorithms and data structures
 *
 * 2) Systematic approach (System Design)
 * How approach to problem:
 * Clear and systematic approach, clarify assumptions, leave out the details (otherwise grade is lower).
 *
 * What does a parking lot? a building or open space or many building or building with multiple levels?
 * How many spots? Thousands, Billions?
 * Are there multiple entrances? (If yes consider concurrency and appropriate data structures)
 * Are there dependencies between levels? (Consider dependencies between levels)
 * Price? Different sizes of spots? What is the price strategy?
 * Charge for the type of vehicle? Premium parking spots? (Based on size, priority, vehicle type, vehicle id?)
 *
 * What matters: how you think about the problem
 * And that you understand Complete picture of business
 * In the end, making money and being valuable to the customer is what matters in business
 *
 * 3) Details (Object oriented design):
 * Design system for vehicles with different sizes: Handicap, motorcycle, car, etc.
 * Smaller can be put to bigger size, but not otherwise.
 * Priority is to place a car to smaller possible parking spot size
 *
 * Class hierarchy
 * - Parking lot - System entrance (Interface can be introduced. Just to be able to provide different systems)
 * - Vehicles: Handicap, Motorcycle, Car (inheritance). To be able to extend system for more vehicles
 * - Parking Spot itself
 *
 * In reality persistence layer, but for algorithm in memory data structures.
 * ArrayList is O(N) to retrieve and put.
 * HashMap is better for putting and retrieval - O(1)
 * For free spots we can have priority - PriorityQueue - retrieve O(N) and put O(logN)
 *
 * In case of concurrency - ConcurrentHashMap can be used (Synchronized HashMap is worse)
 * as well as PriorityBlockingQueue (ArrayBlockingQueue and LinkedBlockingQueue - no priorities)
 * as it supports priorities
 * and ConcurrentLinkedQueue (though it is not blocking) does not support priorities.
 *
 * Advanced:
 * 1) In the solution Size is introduced as an enum.
 * Bigger size indicates different array of queues to use to store parking spots based on priority.
 * Easy to manage just by increasing size by one and going to bigger parking spots
 * In case there are some rules based on the size of vehicle
 * - it can be used to determine sequence of checking the spots
 *
 * 2) By introducing size of spot it is easier to return parking spot to the free parking spots by its size
 *
 * 3) Putting vehicle inside the parking spot will not help and is considered a bad design to this problem,
 * because of parking spot being modifiable...
 *
 * 4) Priority of spots can be determined per each spot or be calculated by some formula. (Based on size, colour, etc.)
 *
 * 5) In case Vehicle with new size has to be added only enum of sizes should be modified
 * Vehicle with same size can be added via introducing new vehicle.
 * Vehicle can have a priority based on which parking spot can ge given - It is advanced,
 * because harder to understand the rules to get the spot. Probably additional queues can be introduced,
 * additionally to the sizes of the spots
 *
 * 6) Having separate Parking spot class instead of just long id
 * - plus is for each size id can be generated independent
 * - each spot can have its price, based on size, etc.
 * - each spot can be prioritised based on some real life factors:
 * closer to shop, closer to entrance/exit, etc. , time - it is possible to leave car at the parking spot
 * in case of timeout (cleat the parking spot - based on scheduling to check or live heartbeat) - advanced
 *
 * https://www.youtube.com/watch?v=DSGsa0pu8-k
 *
 * Created by iurii.dziuban on 14/12/2017.
 */
public class ParkingLot {

    private final String zipCode; // address of the parking in real life

    private final List<PriorityQueue<ParkingSpot>> freeSpots; // maintain free spots based on size and priority
    private final Map<ParkingSpot, Vehicle> occupiedSpots; // maintain mapping from parking spot to vehicle

    // methods to initialize parking spots inside the system should be added

    public ParkingLot(String zipCode) {
        this.zipCode = zipCode;
        freeSpots = new ArrayList<>();
        occupiedSpots = new HashMap<>();
    }

    public ParkingSpot placeVehicle (Vehicle vehicle) {
        int vehicleSize = vehicle.getSize().size;
        while (vehicleSize < freeSpots.size()) {
            PriorityQueue<ParkingSpot> parkingSpots = freeSpots.get(vehicleSize);
            if (!parkingSpots.isEmpty()) {
                ParkingSpot parkingSpot = parkingSpots.poll();
                occupiedSpots.put(parkingSpot, vehicle);
                return parkingSpot;
            }
            vehicleSize++;
        }
        throw new NoSuchElementException("No more parking place for the vehicle with size " + vehicleSize);
    }

    public Vehicle retrieveVehicle(ParkingSpot parkingSpot) {
        Vehicle vehicle = occupiedSpots.remove(parkingSpot);
        if (vehicle == null) {
            throw new NoSuchElementException("Vehicle is not found by parking spot " + parkingSpot);
        }
        freeSpots.get(parkingSpot.size.size).add(parkingSpot);
        return vehicle;
    }

    public interface Vehicle {
        String getId ();
        Colour getColour();
        Size getSize();
    }

    public enum Colour {
        BLUE, RED, GREEN, BLACK
    }

    public class Handicap implements Vehicle {

        private final String id;
        private final Colour colour;
        private final Size size;

        public Handicap(String id, Colour colour, Size size) {
            this.id = id;
            this.colour = colour;
            this.size = size;
        }

        @Override
        public String getId() {
            return id;
        }

        @Override
        public Colour getColour() {
            return colour;
        }

        @Override
        public Size getSize() {
            return size;
        }
    }

    public class Motorcycle implements Vehicle {

        private final String id;
        private final Colour colour;
        private final Size size;

        public Motorcycle(String id, Colour colour, Size size) {
            this.id = id;
            this.colour = colour;
            this.size = size;
        }

        @Override
        public String getId() {
            return id;
        }

        @Override
        public Colour getColour() {
            return colour;
        }

        @Override
        public Size getSize() {
            return size;
        }

    }

    public class Car implements Vehicle {

        private final String id;
        private final Colour colour;
        private final Size size;

        public Car(String id, Colour colour, Size size) {
            this.id = id;
            this.colour = colour;
            this.size = size;
        }

        @Override
        public String getId() {
            return id;
        }

        @Override
        public Colour getColour() {
            return colour;
        }

        @Override
        public Size getSize() {
            return size;
        }

    }

    public class ParkingSpot implements Comparable<ParkingSpot> {
        private final long id;
        private final Size size;
        private final int priority;

        public ParkingSpot(long id, Size size, int priority) {
            this.id = id;
            this.size = size;
            this.priority =  priority;
        }

        public long getId() {
            return id;
        }

        public Size getSize() {
            return size;
        }

        public int getPriority() {
            return priority;
        }

        // smaller is bigger priority. Priority queue stats from smaller by default
        @Override
        public int compareTo(ParkingSpot o) {
            return this.priority - o.priority;
        }
    }

    public enum Size {

        S(0), M(1), L(2);
        private final int size;

        Size(int size) {
            this.size = size;
        }
    }

}
