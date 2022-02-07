package ee.taltech.iti0202.lotr;

import java.util.Objects;

public class Ring {
    enum Type {
        THE_ONE,
        GOLDEN,
        NENYA,
        OTHER
    }

    enum Material {
        GOLD,
        SILVER,
        BRONZE,
        PLASTIC,
        DIAMOND
    }

    Type type;
    Material material;

    public Ring(Type type, Material material) {
        this.type = type;
        this.material = material;
    }

    public Type getType() {
        return type;
    }

    public Material getMaterial() {
        return material;
    }

    public static class Person {
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

        public String isSauron() {
            if (Objects.equals(name, "Sauron") && currentRing.type == Type.THE_ONE && currentRing.material == Material.GOLD) {
                return "Affirmative";
            } else if (Objects.equals(name, "Sauron") && currentRing.type == Type.THE_ONE && currentRing.material != Material.GOLD) {
                return "No, the ring is fake!";
            } else if (!Objects.equals(name, "Sauron") && currentRing.type == Type.THE_ONE && currentRing.material == Material.GOLD) {
                return "No, he just stole the ring";
            } else if (Objects.equals(name, "Sauron") && currentRing.type != Type.THE_ONE || currentRing == null) {
                return "No, but he's claiming to be";
            } else {
                return "No";
            }
        }

    }


        public static void main(String[] args) {

// LOTR simplified play through
            Ring theRing = new Ring(Ring.Type.THE_ONE, Ring.Material.GOLD);
            Ring.Person sauron = new Ring.Person("Maiar", "Sauron");
            sauron.setRing(theRing);
// after some 4000 years, Gollum got the ring
            Ring.Person gollum = new Ring.Person("Hobbit", "Gollum");
// let's remove ring from Sauron
            sauron.setRing(null);
            gollum.setRing(theRing);
// after about 500 years, Bilbo got the ring
            Ring.Person bilbo = new Ring.Person("Hobbit", "Bilbo Baggins");
            gollum.setRing(null);
            bilbo.setRing(theRing);
// after 60 years, Frodo got the ring
            Ring.Person frodo = new Ring.Person("Hobbit", "Frodo Baggins");
            bilbo.setRing(null);
            frodo.setRing(theRing);
// check Sauron
            Ring fakeOne = new Ring(Ring.Type.THE_ONE, Ring.Material.PLASTIC);
            sauron.setRing(fakeOne);
            System.out.println(sauron.isSauron()); // No, the ring is fake!
            System.out.println(frodo.isSauron()); // No, he just stole the ring
            Ring nenya = new Ring(Ring.Type.NENYA, Ring.Material.DIAMOND);
            sauron.setRing(nenya);
            System.out.println(sauron.isSauron()); // No, but he's claiming to be
            frodo.setRing(nenya);
            System.out.println(frodo.isSauron()); // No
            sauron.setRing(theRing);
            System.out.println(sauron.isSauron()); // Affirmative

        }
    }
