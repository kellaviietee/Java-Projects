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

    public List<DrinkType> getDrinkList() {
        return drinkList;
    }

    @Override
    public Drink start(DrinkType drinkType) throws WaterTankException, TrashContainerException, DrinkTypeException {
        if (!waterTank.hasEnoughWater(CUP_SIZE)) {
            throw new WaterTankException();
        } else if (trashContainer.isContainerFull()) {
            throw new TrashContainerException();
        } else if (!drinkList.contains(drinkType)) {
            throw new DrinkTypeException();
        } else {
            waterTank.giveWater(CUP_SIZE);
            trashContainer.addTrash();
            return new Drink(drinkType);
        }
    }

    @Override
    public boolean canMakeTheDrink(DrinkType drinkType) {
        if (!waterTank.hasEnoughWater(CUP_SIZE)) {
            return false;
        } else if (trashContainer.isContainerFull()) {
            return false;
        } else if (!drinkList.contains(drinkType)) {
            return false;
        } else {
            return true;
        }
    }
}
