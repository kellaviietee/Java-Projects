package ee.taltech.iti0202.delivery.packet;

import ee.taltech.iti0202.delivery.location.Location;

public class Packet {

    private final String name;
    private final Location target;

    public Packet(String name, Location target) {

        this.name = name;
        this.target = target;
    }

    public String getName() {
        return name;
    }

    public Location getTarget() {
        return target;
    }

    @Override
    public String toString() {
        return name;
    }
}
