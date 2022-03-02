package ee.taltech.iti0202.zoo.animal;

public class Animal {
    protected final String name;
    protected String noise;
    protected final int hungerDays;
    protected int daysWithoutFood = 0;

    public enum animalType {
        MAMMAL, BIRD, FISH, REPTILE, AMPHIBIAN
    }
    public Animal(String name, String noise, int hungerDays) {
        this.name = name;
        this.noise = noise;
        this.hungerDays = hungerDays;
    }

    public String getName() {
        return name;
    }

    public String getNoise() {
        if (isAnimalHungry()) {
            return "";
        }
        else {
            return noise;
        }
    }

    public boolean isAnimalHungry () {
        return daysWithoutFood > hungerDays;
    }

    public void feedAnimal() {
        daysWithoutFood = 0;
    }


}
