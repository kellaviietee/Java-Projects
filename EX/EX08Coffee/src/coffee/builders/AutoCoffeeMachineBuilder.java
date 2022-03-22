package coffee.builders;

import coffee.drinks.DrinkType;
import coffee.machines.AutoCoffeeMachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AutoCoffeeMachineBuilder extends MachineBuilder<AutoCoffeeMachine, AutoCoffeeMachineBuilder> {
    private List<DrinkType> drinkTypeList = new ArrayList<>(Arrays.asList(DrinkType.values()));


    public AutoCoffeeMachineBuilder withDrinkList(List<DrinkType> drinkList) {
        this.drinkTypeList = drinkList;
        return this;
    }

    @Override
    public AutoCoffeeMachine build() {
        return new AutoCoffeeMachine(trashContainer, waterTank, drinkTypeList);
    }
}
