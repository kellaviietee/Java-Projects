package coffee;

import coffee.builders.AutoCoffeeMachineBuilder;
import coffee.builders.CapsuleMachineBuilder;
import coffee.builders.CoffeeMachineBuilder;
import coffee.drinks.DrinkType;
import coffee.exceptions.DrinkTypeException;
import coffee.exceptions.TrashContainerException;
import coffee.exceptions.WaterTankException;
import coffee.machines.AutoCoffeeMachine;
import coffee.machines.CoffeeMachine;
import coffee.trashcontainer.TrashContainer;
import coffee.watertank.WaterTank;

public class Main {
    public static void main(String[]args) throws TrashContainerException, WaterTankException, DrinkTypeException {
        CapsuleMachineBuilder builder = new CapsuleMachineBuilder();
        CoffeeMachine capsuleMachine = builder.build();
        System.out.println(capsuleMachine.getMachineType());
        }
    }
