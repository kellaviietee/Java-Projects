package ee.taltech.iti0202.zoo;


import ee.taltech.iti0202.zoo.animal.*;

import ee.taltech.iti0202.zoo.caretaker.Caretaker;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class ZooTest {
    static  final int TEST_HUNGER_DAYS = 6;
    static  final int TEST_HUNGER_DAYS_1 = 20;
    static  final int TEST_HUNGER_DAYS_2 = 21;

    Animal animal1 = new AnimalBuilder().setName("Eedi").setNoise("phrphr").setHungerDays(4).setAnimalType(AnimalType.MAMMAL).createAnimal();
    Animal animal2 = new AnimalBuilder().setName("Žanna").setNoise("hiss").setHungerDays(TEST_HUNGER_DAYS_2).setAnimalType(AnimalType.MAMMAL).createAnimal();
    Animal animal3 = new AnimalBuilder().setName("Vaak").setNoise("kraak").setHungerDays(2).setAnimalType(AnimalType.BIRD).createAnimal();
    Animal animal4 = new AnimalBuilder().setName("Kora").setNoise("mullmull").setHungerDays(TEST_HUNGER_DAYS).setAnimalType(AnimalType.FISH).createAnimal();
    Animal animal5 = new Monkey("Patu", 5);
    Animal animal6 = new Lamb("Lambi");
    Animal animal7 = new Turtle("Qua", 3);
    Animal animal8 = new AnimalBuilder().setName("Xenia").setNoise("hiss").setHungerDays(TEST_HUNGER_DAYS_1).setAnimalType(AnimalType.AMPHIBIAN).createAnimal();
    Animal animal9 = new AnimalBuilder().setName("Villi").setNoise("viuh").setHungerDays(3).setAnimalType(AnimalType.BIRD).createAnimal();

    Caretaker caretaker1 = new Caretaker("Aadam", new ArrayList<AnimalType>(Arrays.asList(AnimalType.MAMMAL,
            AnimalType.BIRD)));
    Caretaker caretaker2 = new Caretaker("Anna", new ArrayList<AnimalType>(Arrays.asList(AnimalType.MAMMAL,
            AnimalType.FISH)));
    Caretaker caretaker3 = new Caretaker("Aime", new ArrayList<AnimalType>(Arrays.asList(AnimalType.AMPHIBIAN,
            AnimalType.FISH)));
    @Test
    void testMonkeyNoises() {
        Animal testMonkey = new Monkey("Manney", 5);
        List<String> monkeyNoises = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            String monkeyNoise = testMonkey.getNoise();
            monkeyNoises.add(monkeyNoise);
        }
        assertEquals("Manney", testMonkey.getName());
        assertTrue(monkeyNoises.contains("uuh"));
        assertTrue(monkeyNoises.contains("ääh"));
    }


    /**
     * Test adding a list of animals to the Zoo.
     */
    @Test
    void testGetAllAnimalsInZoo() {
        List<Animal> testAnimals = new ArrayList<>(Arrays.asList(animal1, animal2, animal3, animal4, animal5,
                animal6, animal7, animal8, animal9));
        Zoo testZoo = new Zoo();
        testZoo.addAllAnimalsToZoo(testAnimals);
        assertEquals(testAnimals, testZoo.getAnimalsInZoo());
    }
    /**
     * Test adding a single animal to Zoo.
     */
    @Test
    void testAddingSingleAnimal() {
        List<Animal> testAnimals = new ArrayList<>(List.of(animal1));
        Zoo testZoo = new Zoo();
        testZoo.addAnimalToZoo(animal1);
        assertEquals(testAnimals, testZoo.getAnimalsInZoo());
    }
    /**
     * Test adding a single caretaker to the Zoo.
     */
    @Test
    void testAddingSingleCaretaker() {
        List<Caretaker> testCaretaker = new ArrayList<>(List.of(caretaker1));
        Zoo testZoo = new Zoo();
        testZoo.addCaretakerToZoo(caretaker1);
        assertEquals(testCaretaker, testZoo.getCaretakers());
    }

    /**
     * Test adding a list of caretakers to the Zoo.
     */
    @Test
    void testAddingMultipleCaretakers() {
        List<Caretaker> testCaretakers = new ArrayList<>(List.of(caretaker1, caretaker2, caretaker3));
        Zoo testZoo = new Zoo();
        testZoo.addAllCaretakersToZoo(testCaretakers);
        assertEquals(testCaretakers, testZoo.getCaretakers());
    }

    /**
     * Test getting hungry animals of the Zoo
     */
    @Test
    void testHungryAnimalsInZoo() {
        List<Animal> testAnimals = new ArrayList<>(Arrays.asList(animal1, animal2, animal3, animal4, animal5,
                animal6, animal7, animal8, animal9));
        Zoo testZoo = new Zoo();
        testZoo.addAllAnimalsToZoo(testAnimals);
        for (int days = 0; days < 10; days++) {
            testZoo.nextDay();
        }
        List<Animal> testHungryAnimals = new ArrayList<>(Arrays.asList(animal1, animal3, animal4,
                animal5, animal7, animal9));
        assertEquals(testHungryAnimals, testZoo.hungryAnimals());
        testZoo.addCaretakerToZoo(caretaker1);
        caretaker1.addAnimalsToFeed(testZoo.hungryAnimals());
        List<Animal> newHungryAnimals = new ArrayList<>(Arrays.asList(animal4, animal7));
        assertEquals(newHungryAnimals, testZoo.hungryAnimals());
    }

    /**
     * Test get animal Noises of the Zoo.
     */
    @Test
    void testNoisesInTheZoo() {
        List<Animal> testAnimals = new ArrayList<>(Arrays.asList(animal1, animal2, animal3, animal4, animal5,
                animal6, animal7, animal8, animal9));
        List<Caretaker> testCaretakers = new ArrayList<>(List.of(caretaker1, caretaker2, caretaker3));
        Zoo testZoo = new Zoo();
        testZoo.addAllCaretakersToZoo(testCaretakers);
        testZoo.addAllAnimalsToZoo(testAnimals);
        for (int days = 0; days < 10; days++) {
            testZoo.nextDay();
        }
        String testNoises = "Eedi MAMMAL:\n"
                + "Žanna MAMMAL:hiss\n"
                + "Vaak BIRD:\n"
                + "Kora FISH:\n"
                + "Patu MAMMAL:BANANA\n"
                + "Lambi MAMMAL:Mää\n"
                + "Qua AMPHIBIAN:\n"
                + "Xenia AMPHIBIAN:hiss\n"
                + "Villi BIRD:";
        assertEquals(testNoises, testZoo.animalNoises());
    }

    @Test
    public void testMostEffectiveCaretaker() {
        List<Animal> testAnimals = new ArrayList<>(Arrays.asList(animal1, animal2, animal3, animal4, animal5,
                animal6, animal7, animal8, animal9));
        List<Caretaker> testCaretakers = new ArrayList<>(List.of(caretaker1, caretaker2, caretaker3));
        Zoo testZoo = new Zoo();
        testZoo.addAllCaretakersToZoo(testCaretakers);
        testZoo.addAllAnimalsToZoo(testAnimals);
        for (int days = 0; days < 10; days++) {
            testZoo.nextDay();
        }
        Caretaker mostEfficientCaretaker = caretaker1;
        assertEquals(mostEfficientCaretaker, testZoo.mostEffectiveCaretaker());
    }
}
