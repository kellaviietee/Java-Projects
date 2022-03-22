package coffee.capsule;

import coffee.drinks.DrinkType;
import coffee.logger.MyLogger;

import java.util.logging.Logger;

public class Capsule {
    private final static Logger LOGGER = Logger.getLogger(MyLogger.class.getName());
    private final DrinkType drinkType;
    private boolean isEmpty = false;

    public Capsule(DrinkType drinkType) {
        this.drinkType = drinkType;
        LOGGER.info("New Capsule is made!" + this.toString());
    }

    public DrinkType getDrinkType() {
        return drinkType;
    }

    /**
     * Use the powder inside the Capsule.
     */
    public void useCapsule() {
        LOGGER.info("Capsule is being emptied.");
        isEmpty = true;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    @Override
    public String toString() {
        return "Capsule{" +
                "drinkType=" + drinkType +
                '}';
    }
}
