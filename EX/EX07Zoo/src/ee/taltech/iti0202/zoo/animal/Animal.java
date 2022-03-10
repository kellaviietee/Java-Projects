package ee.taltech.iti0202.zoo.animal;

public class Animal {
    protected String name;
    protected String noise;
    protected int hungerDays;
    protected AnimalType animalType;
    protected int daysWithoutFood = 0;


    public Animal(String name, String noise, int hungerDays, AnimalType animalType) {
        this.name = name;
        this.noise = noise;
        this.hungerDays = hungerDays;
        this.animalType = animalType;
    }

    public String getName() {
        return name;
    }

    public String getNoise() {
        if (isAnimalHungry()) {
            return "";
        } else {
            return noise;
        }
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public boolean isAnimalHungry() {
        return daysWithoutFood > hungerDays;
    }

    public void feedAnimal() {
        daysWithoutFood = 0;
    }

    public void dayAdvanced() {
        daysWithoutFood += 1;
    }

    @Override
    public String toString() {
        return name + " " + animalType.name() +  ":" + getNoise();
    }
}
