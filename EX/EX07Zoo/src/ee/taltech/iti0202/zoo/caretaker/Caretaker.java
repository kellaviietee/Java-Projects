package ee.taltech.iti0202.zoo.caretaker;

import ee.taltech.iti0202.zoo.animal.Animal;
import ee.taltech.iti0202.zoo.animal.AnimalType;


import java.util.List;


public class Caretaker {

    private final String name;
    private final List<AnimalType> canFeedType;

    public Caretaker(String name, List<AnimalType> canFeedType) {

        this.name = name;
        this.canFeedType = canFeedType;
    }

    public void  addAnimalsToFeed(List<Animal> animals) {
        for (Animal animal : animals) {
            if (canFeedType.contains(animal.getAnimalType()) && animal.isAnimalHungry()) {
                animal.feedAnimal();
            }
        }
    }

    public List<AnimalType> getCanFeedType() {
        return canFeedType;
    }
}
