package coffee.machines;

import coffee.drinks.Drink;
import coffee.drinks.DrinkType;
import coffee.exceptions.DrinkTypeException;
import coffee.exceptions.TrashContainerException;
import coffee.exceptions.WaterTankException;
import coffee.trashcontainer.TrashContainer;
import coffee.watertank.WaterTank;

import java.util.List;

public class AutoCoffeeMachine extends CoffeeMachine {
    private final List<DrinkType> drinkList;


    public AutoCoffeeMachine(TrashContainer trashContainer, WaterTank waterTank, List<DrinkType> drinkList) {
        super(trashContainer, waterTank);
        this.machineType = MachineType.AUTOMATIC;
        this.drinkList = drinkList;
    }

    /**
     * Get list of Drinks this machine can actually make.
     * @return List of Drink types.
     */
    public List<DrinkType> getDrinkList() {
        return drinkList;
    }

    /**
     * Try to Make a drink.
     * @param drinkType Type of Drink requested.
     * @return Drink of the requested type.
     * @throws WaterTankException Not enough water in the Tank.
     * @throws TrashContainerException Trash Container already full.
     * @throws DrinkTypeException Machine can not do the requested Drink type for some reason.
     */
    @Override
    public Drink start(DrinkType drinkType) throws WaterTankException, TrashContainerException, DrinkTypeException {
        if (!waterTank.hasEnoughWater(CUP_SIZE)) {
            LOGGER.info("Not enough Water!");
            throw new WaterTankException();
        } else if (trashContainer.isContainerFull()) {
            LOGGER.info("Trash Container is full!");
            throw new TrashContainerException();
        } else if (!drinkList.contains(drinkType)) {
            LOGGER.info("Don't know how to do this!");
            throw new DrinkTypeException();
        } else {
            LOGGER.info("One beverage coming right up!");
            waterTank.giveWater(CUP_SIZE);
            trashContainer.addTrash();
            return new Drink(drinkType);
        }
    }

    /**
     * Check if a requested Drink can be made.
     * @param drinkType Type of Drink requested.
     * @return If drink can be made or not.
     */
    @Override
    public boolean canMakeTheDrink(DrinkType drinkType) {
        if (!waterTank.hasEnoughWater(CUP_SIZE)) {
            return false;
        } else if (trashContainer.isContainerFull()) {
            return false;
        } else return drinkList.contains(drinkType);
    }

    @Override
    public String toString() {
        return "AutoCoffeeMachine{"
                + "drinkList="
                + drinkList
                + ", trashContainer="
                + trashContainer
                + ", waterTank="
                + waterTank
                + '}';
    }
}
