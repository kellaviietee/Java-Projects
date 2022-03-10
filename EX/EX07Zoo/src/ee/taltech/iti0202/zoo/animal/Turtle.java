package ee.taltech.iti0202.zoo.animal;

public class Turtle extends Animal {

    public Turtle(String name, int hungerDays) {
        super(name, "", hungerDays, AnimalType.AMPHIBIAN);
    }

    @Override
    public String getNoise() {
        return "";
    }
}

