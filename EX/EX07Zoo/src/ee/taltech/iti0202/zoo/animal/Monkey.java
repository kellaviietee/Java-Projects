package ee.taltech.iti0202.zoo.animal;


public class Monkey extends Animal {
    public static double PROBABILITY = 0.5;
    public Monkey(String name, String noise, int hungerDays) {
        super(name, noise, hungerDays, AnimalType.MAMMAL);
    }

    @Override
    public String getNoise() {
        if (isAnimalHungry()) {
            return "BANANA";
        } else {
            double randomNumber = Math.random();
            if (randomNumber > PROBABILITY) {
                return "uuh";
            } else {
                return "ääh";
            }
        }
    }
}
