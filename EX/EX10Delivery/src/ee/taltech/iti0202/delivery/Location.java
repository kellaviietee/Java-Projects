package ee.taltech.iti0202.delivery;

import java.util.*;

public class Location {
    final String name;
    Map<String, Packet> packetMap = new HashMap<>();
    Map<String, Integer> distanceMap = new HashMap<>();

    public Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getDistanceTo(String name) {
    return distanceMap.get(name);
    }
    public void addDistance(String location, int distance) {
    distanceMap.put(location, distance);
    }
    public void addPacket(Packet packet) {
        packetMap.put(packet.getName(), packet);
    }
    public Optional<Packet> getPacket(String name) {
        return Optional.of(packetMap.get(name));
    }
}
