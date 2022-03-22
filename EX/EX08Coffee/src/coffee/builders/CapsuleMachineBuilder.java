package coffee.builders;


import coffee.machines.CapsuleCoffeeMachine;
import coffee.trashcontainer.TrashContainer;


public class CapsuleMachineBuilder extends MachineBuilder<CapsuleCoffeeMachine, CapsuleMachineBuilder> {
    private static final int CAPACITY = 10;
    protected TrashContainer trashContainer = new TrashContainer(CAPACITY);

    @Override
    public CapsuleMachineBuilder withTrashContainer(TrashContainer trashContainer) {
        LOGGER.info("With specified" + trashContainer.toString());
        this.trashContainer = trashContainer;
        return this;
    }

    @Override
    public CapsuleCoffeeMachine build() {
        LOGGER.info("Created new Capsule coffee machine");
        return new CapsuleCoffeeMachine(trashContainer, waterTank);
    }
}
