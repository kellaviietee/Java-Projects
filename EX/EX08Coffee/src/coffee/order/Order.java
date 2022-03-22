package coffee.order;

import coffee.drinks.DrinkType;
import coffee.machines.CoffeeMachine;
import coffee.machines.MachineType;

import java.util.logging.Logger;

public class Order {
    private static final Logger LOGGER  = Logger.getLogger(CoffeeMachine.class.getName());
    private DrinkType drinkType;
    private MachineType machineType;

    public Order(DrinkType drinkType, MachineType machineType) {
        this.drinkType = drinkType;
        this.machineType = machineType;
        LOGGER.info("New " + this);

    }

    public DrinkType getDrinkType() {
        return drinkType;
    }

    public MachineType getMachineType() {
        return machineType;
    }

    @Override
    public String toString() {
        return "Order{"
                + "drinkType="
                + drinkType
                + ", machineType="
                + machineType
                + '}';
    }
}
