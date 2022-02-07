package ee.taltech.iti0202.lotr;

import java.util.Objects;

public class Person {
    private final String  race;
    private final String  name;
    private Ring currentRing;

    public Person(String race, String name) {
        this.race = race;
        this.name = name;
    }

    public Person(String race, String name, Ring ring) {
        this.race = race;
        this.name = name;
        this.currentRing = ring;
    }

    public void setRing(Ring ring) {
        currentRing = ring;
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public Ring getRing() {
        return currentRing;
    }

    public String isSauron() {
        if (Objects.equals(name, "Sauron")) {
            if (currentRing == null) {
                return "No, but he's claiming to be";
            } else if (currentRing.getType() != Ring.Type.THE_ONE) {
                return "No, but he's claiming to be";
            } else if (currentRing.getType() == Ring.Type.THE_ONE
                    && currentRing.getMaterial() == Ring.Material.GOLD) {
                return "Affirmative";
            } else if (currentRing.getType() == Ring.Type.THE_ONE
                    && currentRing.getMaterial() != Ring.Material.GOLD) {
                return "No, the ring is fake!";
            }
        }else {
            if (currentRing == null) {
                return "No";
            } else if (currentRing.getType() == Ring.Type.THE_ONE && currentRing.getMaterial() == Ring.Material.GOLD) {
                return "No, he just stole the ring";
            }
        }
        return "No";
    }
}

