package coffee;

import coffee.exceptions.TrashContainerException;
import coffee.exceptions.WaterTankException;
import coffee.machines.CoffeeMachine;
import coffee.machines.MachineType;
import coffee.trashcontainer.TrashContainer;
import coffee.watertank.WaterTank;

public class Main {
    public static void main(String[]args) throws TrashContainerException, WaterTankException {
        WaterTank testWaterTank = new WaterTank();
        TrashContainer trashContainer = new TrashContainer();
        CoffeeMachine coffeeMachine = new CoffeeMachine(trashContainer, testWaterTank);
        for(int i = 0; i < 15; i++) {
            System.out.println(i);
            coffeeMachine.start();
        }
    }
}
