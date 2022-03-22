package coffee.machines;

import coffee.drinks.Drink;
import coffee.drinks.DrinkType;
import coffee.exceptions.DrinkTypeException;
import coffee.exceptions.TrashContainerException;
import coffee.exceptions.WaterTankException;
import coffee.trashcontainer.TrashContainer;
import coffee.watertank.WaterTank;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CoffeeMachine {

    private static final Logger LOGGER  = Logger.getLogger(CoffeeMachine.class.getName());
    protected MachineType machineType;
    protected TrashContainer trashContainer;
    protected WaterTank waterTank;
    protected static final float CUP_SIZE = 0.3f;

    public CoffeeMachine(TrashContainer trashContainer, WaterTank waterTank) {
        this.trashContainer = trashContainer;
        this.waterTank = waterTank;
        this.machineType = MachineType.REGULAR;
    }

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

    public boolean canMakeTheDrink(DrinkType drinkType) {
        if (!waterTank.hasEnoughWater(CUP_SIZE)) {
            return false;
        } else if (trashContainer.isContainerFull()) {
            return false;
        } else if (!drinkType.equals(DrinkType.COFFEE)) {
            return false;
        } else {
            return true;
        }
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
}
