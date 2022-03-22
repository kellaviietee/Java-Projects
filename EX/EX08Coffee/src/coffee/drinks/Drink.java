package coffee.drinks;

import coffee.logger.MyLogger;

import java.util.logging.Logger;

public class Drink {
    private final static Logger LOGGER = Logger.getLogger(MyLogger.class.getName());
    private DrinkType drinkType;

    public Drink(DrinkType drinkType) {
        this.drinkType = drinkType;
        LOGGER.info("New " + this.toString() + " just made! Huzzaa!");

    }

    public DrinkType getDrinkType() {
        return drinkType;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "drinkType=" + drinkType +
                '}';
    }
}
