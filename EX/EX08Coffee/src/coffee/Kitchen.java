package coffee;

import coffee.drinks.Drink;
import coffee.exceptions.DrinkTypeException;
import coffee.exceptions.TrashContainerException;
import coffee.exceptions.WaterTankException;
import coffee.logger.MyLogger;
import coffee.machines.CoffeeMachine;
import coffee.machines.MachineType;
import coffee.order.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * Kitchen Constructor.
 */
public class Kitchen {
    private final static Logger LOGGER = Logger.getLogger(MyLogger.class.getName());
    private final List<CoffeeMachine> allCoffeeMachines = new ArrayList<>();
    private final List<Order> orders = new ArrayList<>();

    public Kitchen() {
        LOGGER.info("New Kitcen just opened up!");
    }

    /**
     * Adding Coffe machine to the Kitchen.
     * @param coffeeMachine Machine to be added to the Kitchen.
     */
    public void addCoffeeMachine(CoffeeMachine coffeeMachine) {
        LOGGER.info("Added new Coffee Machine!");
        allCoffeeMachines.add(coffeeMachine);
    }

    /**
     * Adding Orders to the Kitchen.
     * @param order Order to be added.
     */
    public void addOrder(Order order) {
        LOGGER.info("New order in the kitchen!");
        orders.add(order);
    }

    /**
     * Trying to Fulfill the Coffee order.
     * @param order Order to be fulfilled
     * @return If it is successful a Drink is given otherwise an Empty Optional.
     */
    public Optional<Drink> fulfillOrder(Order order) throws TrashContainerException, WaterTankException,
            DrinkTypeException {
        LOGGER.info("Trying to fulfill an Order!");
        Optional<Drink> drink = Optional.empty();
        List<CoffeeMachine> askedMachines = getTypesOfCoffeeMachines(order.getMachineType());
        if (askedMachines.size() != 0) {
            for (CoffeeMachine coffeeMachine : askedMachines) {
                if (coffeeMachine.canMakeTheDrink(order.getDrinkType())) {
                    LOGGER.info("Drink made!");
                    drink = Optional.of(coffeeMachine.start(order.getDrinkType()));
                }
            }
        }
        LOGGER.info("Hope you have a wonderful day! Enjoy your drink!");
        return drink;
    }

    /**
     * Find all the Coffee Machines of the right type in the Kitchen.
     * @param machineType Machine Type.
     * @return List of the Coffee Machines that fulfill the requirement.
     */
    public List<CoffeeMachine> getTypesOfCoffeeMachines(MachineType machineType) {
        LOGGER.info("Finding right Coffee machines!");
        List<CoffeeMachine> machines = new ArrayList<>();
        for (CoffeeMachine coffeeMachine : allCoffeeMachines) {
            if (coffeeMachine.getMachineType().equals(machineType)) {
                LOGGER.info("Found the machine!");
                machines.add(coffeeMachine);
            }
        }
        LOGGER.info("Here's your Machines! If I found any");
        return machines;
    }
}
