package ee.taltech.iti0202.zoo.caretaker;

import ee.taltech.iti0202.zoo.animal.Animal;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Caretaker {

    private final String name;
    private final List<Animal.animalType> canFeedType;


    public Caretaker(String name, List<Animal.animalType> canFeedType) {

        this.name = name;
        this.canFeedType = canFeedType;
    }

    public void  addAnimalsToFeed(List<Animal> animals) {
        for (Animal animal : animals) {

        }
    }
}
