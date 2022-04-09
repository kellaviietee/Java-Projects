package ee.taltech.iti0202.delivery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Location {
    private final String name;
    private List<Packet> packetList = new ArrayList<>();
    private final Map<String, Integer> distanceToLocation = new HashMap<>();

    public Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getDistanceTo(String name) {
        if (distanceToLocation.containsKey(name)) {
            return distanceToLocation.get(name);
        }
        return Integer.MAX_VALUE;
    }

    public void addPacket(Packet packet) {
        packetList.add(packet);
    }

    Optional<Packet> getPacket(String name) {
        for (Packet packet : packetList) {
            if (packet.getName().equals(name)) {
                return Optional.of(packet);
            }
        }
        return  Optional.empty();
    }

    public void addDistance(String location, int distance) {
        distanceToLocation.put(location, distance);
    }

    @Override
    public String toString() {
        return name + " PACKETS: " + packetList;
    }
}
