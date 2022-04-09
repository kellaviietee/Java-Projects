package ee.taltech.iti0202.delivery.courier;

import ee.taltech.iti0202.delivery.location.Location;
import ee.taltech.iti0202.delivery.packet.Packet;
import ee.taltech.iti0202.delivery.strategy.Strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Courier {

    private final String name;
    private Location location;
    private final List<Packet> packets = new ArrayList<>();
    private Strategy strategy;
    public boolean moving = false;

    public Courier(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public Optional<Location> getLocation() {
        return Optional.of(location);
    }

    public String getName() {
        return name;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public String toString() {
        return name + " (" + location.getName() + ") " +  " PACKETS: " + packets;
    }
}
