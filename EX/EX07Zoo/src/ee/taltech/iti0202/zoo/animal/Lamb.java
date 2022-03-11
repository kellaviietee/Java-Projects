package ee.taltech.iti0202.zoo.animal;

public class Lamb extends Animal {
    public Lamb(String name) {
        super(name, "Mää", 0, AnimalType.MAMMAL);
    }

    @Override
    public boolean isAnimalHungry() {
        return false;
    }

}
