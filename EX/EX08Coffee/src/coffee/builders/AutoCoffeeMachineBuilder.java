package coffee.builders;

import coffee.drinks.DrinkType;
import coffee.machines.AutoCoffeeMachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AutoCoffeeMachineBuilder extends MachineBuilder<AutoCoffeeMachine, AutoCoffeeMachineBuilder> {
    private List<DrinkType> drinkTypeList = new ArrayList<>(Arrays.asList(DrinkType.values()));


    public AutoCoffeeMachineBuilder withDrinkList(List<DrinkType> drinkList) {
        LOGGER.info("With the next Drinks" + drinkList.toString());
        this.drinkTypeList = drinkList;
        return this;
    }

    @Override
    public AutoCoffeeMachine build() {
        LOGGER.info("Built a new Automatic Coffee Machine.");
        return new AutoCoffeeMachine(trashContainer, waterTank, drinkTypeList);
    }
}
