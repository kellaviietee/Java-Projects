package ee.taltech.iti0202.delivery;

import java.util.List;
import java.util.Optional;

public class World {

    public Optional<Location> addLocation(String name, List<String> otherLocations, List<Integer> distances) {
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
