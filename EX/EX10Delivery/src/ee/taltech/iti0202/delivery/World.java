package ee.taltech.iti0202.delivery;

import java.util.*;

public class World {
    private Map<String, Courier> couriers = new HashMap<>();
    private Map<String, Location> locations = new HashMap<>();

    public Optional<Location> addLocation(String name, List<String> otherLocations, List<Integer> distances) {
        if (locations.containsKey(name)) {
            return Optional.empty();
            }
        Location newLocation = new Location(name);
        locations.put(name, newLocation);
        for (int i = 0; i < otherLocations.size(); i++) {
            newLocation.addDistance(otherLocations.get(i), distances.get(i));
            locations.get(otherLocations.get(i)).addDistance(name, distances.get(i));
        }
        return Optional.of(newLocation);
    }

    public Optional<Courier> addCourier(String name, String to) {
        if (couriers.containsKey(name) || !locations.containsKey(to)) {
            return Optional.empty();
        }
        Courier newCourier = new Courier(name, locations.get(to));
        couriers.put(name, newCourier);
        return Optional.of(newCourier);
    }
    public boolean giveStrategy(String name, Strategy strategy) {
        if (couriers.containsKey(name)) {
            Courier pickedCourier = couriers.get(name);
            pickedCourier.setStrategy(strategy);
            return true;
        }
        return false;
    }

    public void tick() {
    }
}
