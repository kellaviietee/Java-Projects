package coffee.machine;

import coffee.capsule.Capsule;
import coffee.trashcontainer.TrashContainer;
import coffee.waterReservoir.WaterReservoir;

public class CoffeeMachineBuilder {
    private TrashContainer trashContainer;
    private WaterReservoir waterReservoir;
    private MachineType machineType;
    private Capsule capsule;

    public CoffeeMachineBuilder withTrashContainer(TrashContainer trashContainer) {
        this.trashContainer = trashContainer;
        return this;
    }

    public CoffeeMachineBuilder withWaterReservoir(WaterReservoir waterReservoir) {
        this.waterReservoir = waterReservoir;
        return this;
    }

    public CoffeeMachineBuilder withMachineType(MachineType machineType) {
        this.machineType = machineType;
        return this;
    }

    public CoffeeMachineBuilder withCapsule(Capsule capsule) {
        this.capsule = capsule;
        return this;
    }

    public CoffeeMachine createCoffeeMachine() {
        return new CoffeeMachine(trashContainer, waterReservoir,machineType);
    }
}