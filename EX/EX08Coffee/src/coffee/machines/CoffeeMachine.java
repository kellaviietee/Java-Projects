package coffee.machines;

import coffee.drinks.Drink;
import coffee.drinks.DrinkType;
import coffee.exceptions.DrinkTypeException;
import coffee.exceptions.TrashContainerException;
import coffee.exceptions.WaterTankException;
import coffee.trashcontainer.TrashContainer;
import coffee.watertank.WaterTank;

import java.util.logging.Logger;

public class CoffeeMachine {

    protected static final Logger LOGGER  = Logger.getLogger(CoffeeMachine.class.getName());
    protected MachineType machineType;
    protected TrashContainer trashContainer;
    protected WaterTank waterTank;
    protected static final float CUP_SIZE = 0.3f;

    public CoffeeMachine(TrashContainer trashContainer, WaterTank waterTank) {
        this.trashContainer = trashContainer;
        this.waterTank = waterTank;
        this.machineType = MachineType.REGULAR;
    }
    /**
     * Try to make a Drink of the requested type.
     * @param drinkType Drink to be made.
     * @return Drink if possible.
     * @throws WaterTankException Not enough Water.
     * @throws TrashContainerException Trash Container is full.
     * @throws DrinkTypeException Can't make this type of Drink.
     */
    public Drink start(DrinkType drinkType) throws WaterTankException, TrashContainerException, DrinkTypeException {
        if (!waterTank.hasEnoughWater(CUP_SIZE)) {
            throw new WaterTankException();
        } else if (trashContainer.isContainerFull()) {
            throw new TrashContainerException();
        } else if (!drinkType.equals(DrinkType.COFFEE)) {
            throw new DrinkTypeException();
        } else {
            waterTank.giveWater(CUP_SIZE);
            trashContainer.addTrash();
            return new Drink(DrinkType.COFFEE);
        }
    }
    /**
     * Check if the requested type of Drink can be made.
     * @param drinkType Type of Drink
     * @return If the drink can be made.
     */
    public boolean canMakeTheDrink(DrinkType drinkType) {
        if (!waterTank.hasEnoughWater(CUP_SIZE)) {
            return false;
        } else if (trashContainer.isContainerFull()) {
            return false;
        } else return drinkType.equals(DrinkType.COFFEE);
    }

    public MachineType getMachineType() {
        return machineType;
    }

    public TrashContainer getTrashContainer() {
        return trashContainer;
    }

    public WaterTank getWaterTank() {
        return waterTank;
    }

    @Override
    public String toString() {
        return "CoffeeMachine{"
                + "trashContainer="
                + trashContainer
                + ", waterTank="
                + waterTank
                + '}';
    }
}
