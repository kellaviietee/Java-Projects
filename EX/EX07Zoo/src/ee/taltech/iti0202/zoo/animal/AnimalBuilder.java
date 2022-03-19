package ee.taltech.iti0202.zoo.animal;

public class AnimalBuilder {
    private String name;
    private String noise;
    private int hungerDays;
    private AnimalType animalType;

    public AnimalBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public AnimalBuilder setNoise(String noise) {
        this.noise = noise;
        return this;
    }

    public AnimalBuilder setHungerDays(int hungerDays) {
        this.hungerDays = hungerDays;
        return this;
    }

    public AnimalBuilder setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
        return this;
    }

    public Animal createAnimal() {
        return new Animal(name, noise, hungerDays, animalType);
    }
}