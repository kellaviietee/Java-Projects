package coffee.builders;

import coffee.machines.CoffeeMachine;

public class CoffeeMachineBuilder extends MachineBuilder<CoffeeMachine, CoffeeMachineBuilder> {
    @Override
    public CoffeeMachine build() {
        LOGGER.info("Created new regular coffee machine");
        return new CoffeeMachine(trashContainer, waterTank);
    }
}
