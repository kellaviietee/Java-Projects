package ee.taltech.iti0202.delivery;

import java.util.Optional;

public class Courier {
    private final String name;
    private Location location;
    private boolean moving = false;
    private Strategy strategy;

    public Courier(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    Optional<Location> getLocation() {
        if (moving) {
            return Optional.empty();
        }
        return Optional.of(location);
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public String getName() {
        return name;
    }
}
