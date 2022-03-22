package coffee.order;

import coffee.drinks.DrinkType;
import coffee.machines.MachineType;

public class Order {
    private DrinkType drinkType;
    private MachineType machineType;

    public Order(DrinkType drinkType, MachineType machineType) {
        this.drinkType = drinkType;
        this.machineType = machineType;
    }

    public DrinkType getDrinkType() {
        return drinkType;
    }

    public MachineType getMachineType() {
        return machineType;
    }
}
