package coffee.machine;

import coffee.drinks.DrinkType;
import coffee.trashcontainer.TrashContainer;
import coffee.waterReservoir.WaterReservoir;

public class CoffeeMachine {
    private final TrashContainer trashContainer;
    private int numOfDrinksMade = 0;
    private final WaterReservoir waterReservoir;
    private final MachineType machineType;


    public CoffeeMachine(TrashContainer trashContainer, WaterReservoir waterReservoir, MachineType machineType) {
        this.trashContainer = trashContainer;
        this.waterReservoir = waterReservoir;
        this.machineType = machineType;
    }

    public boolean start(DrinkType drinkType) {
        if (!trashContainer.isTrashContainerFull())
    }

}
