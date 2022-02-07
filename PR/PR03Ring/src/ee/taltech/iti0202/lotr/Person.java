package ee.taltech.iti0202.lotr;

import java.util.Objects;

public class Person {
        String race;
        String name;
        Ring currentRing;

        public Person(String race, String name) {
            this.race = race;
            this.name = name;
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
            if (Objects.equals(name, "Sauron") && currentRing.getType() == Ring.Type.THE_ONE && currentRing.getMaterial() == Ring.Material.GOLD) {
                return "Affirmative";
            } else if (Objects.equals(name, "Sauron") && currentRing.getType() == Ring.Type.THE_ONE && currentRing.getMaterial() != Ring.Material.GOLD) {
                return "No, the ring is fake!";
            } else if (!Objects.equals(name, "Sauron") && currentRing.getType() == Ring.Type.THE_ONE && currentRing.getMaterial() == Ring.Material.GOLD) {
                return "No, he just stole the ring";
            } else if (Objects.equals(name, "Sauron") && currentRing.getType() != Ring.Type.THE_ONE || currentRing == null) {
                return "No, but he's claiming to be";
            } else {
                return "No";
            }
        }

    }
