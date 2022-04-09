package ee.taltech.iti0202.delivery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class World {
    Map<String, Location> worldLocations = new HashMap<>();

    public Optional<Location> addLocation(String name, List<String> otherLocations, List<Integer> distances) {
        if (!worldLocations.containsKey(name)) {
            Location newLocation = new Location(name);
            worldLocations.put(name, newLocation);
            return Optional.of(newLocation);
        }
        return Optional.empty();
    }

    public Optional<Courier> addCourier(String name, String to) {
        return Optional.empty();
    }

    public boolean giveStrategy(String name, Strategy strategy) {
        return false;
    }

    public void tick() { }
}
