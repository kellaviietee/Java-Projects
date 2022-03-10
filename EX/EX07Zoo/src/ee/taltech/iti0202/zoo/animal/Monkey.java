package ee.taltech.iti0202.zoo.animal;

import java.util.random.RandomGenerator;

public class Monkey extends Animal {
    public Monkey(String name, String noise, int hungerDays) {
        super(name, noise, hungerDays, AnimalType.MAMMAL);
    }

    @Override
    public String getNoise() {
        if (isAnimalHungry()) {
            return "BANANA";
        } else {
            double randomNumber = Math.random();
            if (randomNumber > 0.5) {
                return "uuh";
            } else {
                return "ääh";
            }
        }
    }
}
