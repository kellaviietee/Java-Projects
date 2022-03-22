package coffee.capsule;

import coffee.drinks.DrinkType;

public class Capsule {
    private final DrinkType drinkType;
    private boolean isEmpty = false;

    public Capsule(DrinkType drinkType) {
        this.drinkType = drinkType;
    }

    public DrinkType getDrinkType() {
        return drinkType;
    }

    public void useCapsule() {
        isEmpty = true;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

}
