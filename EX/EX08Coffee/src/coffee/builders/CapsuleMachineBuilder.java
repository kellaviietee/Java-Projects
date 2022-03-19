package coffee.builders;


import coffee.machines.CapsuleCoffeeMachine;


public class CapsuleMachineBuilder extends MachineBuilder<CapsuleCoffeeMachine, CapsuleMachineBuilder> {

    @Override
    public CapsuleCoffeeMachine build() {
        return new CapsuleCoffeeMachine(trashContainer, waterTank);
    }
}
