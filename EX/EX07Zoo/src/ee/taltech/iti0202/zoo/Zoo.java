package ee.taltech.iti0202.zoo;

import ee.taltech.iti0202.zoo.animal.Animal;
import ee.taltech.iti0202.zoo.caretaker.Caretaker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Zoo {
    private final List<Animal> animalsInZoo = new ArrayList<>();
    private final List<Caretaker> caretakers = new ArrayList<>();

    public List<Animal> getAnimalsInZoo() {
        return animalsInZoo;
    }

    public void addAnimalToZoo(Animal animal) {
        animalsInZoo.add(animal);
    }

    public void addAllAnimalsToZoo(List<Animal> animals) {
        for (Animal animal : animals) {
            addAnimalToZoo(animal);
        }
    }

    public void addCaretakerToZoo(Caretaker caretaker) {
        caretakers.add(caretaker);
    }

    public List<Caretaker> getCaretakers() {
        return caretakers;
    }

    public void addAllCaretakersToZoo(List<Caretaker> caretakers) {
        for (Caretaker caretaker : caretakers) {
            addCaretakerToZoo(caretaker);
        }
    }

    public List<Animal> hungryAnimals() {
        List<Animal> hungryAnimals = new ArrayList<>();
        for (Animal animal : getAnimalsInZoo()) {
            if (animal.isAnimalHungry()) {
                hungryAnimals.add(animal);
            }
        }
        return hungryAnimals;
    }

    public String animalNoises() {
        StringBuilder animalNoises = new StringBuilder();
        for (Animal animal : animalsInZoo) {
            animalNoises.append(animal.toString()).append("\n");
        }
        return animalNoises.toString().trim();
    }

    public int howManyAnimalsCaretakerFeeds(Caretaker caretaker) {
        int howManyAnimals = 0;
        for (Animal animal : hungryAnimals()) {
            if (caretaker.getCanFeedType().contains(animal.getAnimalType())) {
                howManyAnimals += 1;
            }
        }
        return howManyAnimals;
    }

    public Caretaker mostEffectiveCaretaker() {
        return getCaretakers().stream()
                .max(Comparator.comparing(this::howManyAnimalsCaretakerFeeds))
                .get();
    }

    public void nextDay() {
        for (Animal animal : animalsInZoo) {
            animal.dayAdvanced();
        }
    }
}
