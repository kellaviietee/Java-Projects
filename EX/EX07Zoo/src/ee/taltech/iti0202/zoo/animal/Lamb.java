package ee.taltech.iti0202.zoo.animal;

public class Lamb extends Animal {
    public Lamb(String name, int hungerDays) {
        super(name, "Mää", hungerDays, AnimalType.MAMMAL);
    }

    @Override
    public boolean isAnimalHungry() {
        return false;
    }

}
