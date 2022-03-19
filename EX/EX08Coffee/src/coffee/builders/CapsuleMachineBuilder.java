package coffee.builders;

import coffee.machines.AutoCoffeeMachine;
import coffee.machines.CapsuleCoffeeMachine;
import coffee.machines.CoffeeMachine;

public class CapsuleMachineBuilder extends MachineBuilder<CapsuleCoffeeMachine, CapsuleMachineBuilder> {

    @Override
    public CapsuleCoffeeMachine build() {
        return new CapsuleCoffeeMachine(trashContainer,waterTank);
    }
}
