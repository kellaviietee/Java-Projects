package coffee.builders;

import coffee.machines.CoffeeMachine;

public class CoffeeMachineBuilder extends MachineBuilder<CoffeeMachine,CoffeeMachineBuilder> {
    @Override
    public CoffeeMachine build() {
        return new CoffeeMachine(trashContainer,waterTank);
    }
}
