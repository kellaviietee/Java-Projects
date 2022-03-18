package coffee;

import coffee.machine.CoffeeMachine;
import coffee.machine.CoffeeMachineBuilder;
import coffee.machine.MachineType;
import coffee.trashcontainer.TrashContainer;
import coffee.waterReservoir.WaterReservoir;

import java.util.logging.Logger;


public class Main {
    public static void main(String[]args){
        CoffeeMachine firstTest = new CoffeeMachineBuilder()
                .withMachineType(MachineType.AUTOMATIC)
                .withTrashContainer(new TrashContainer())
                .withWaterReservoir(new WaterReservoir(100))
                .createCoffeeMachine();
    }
}
