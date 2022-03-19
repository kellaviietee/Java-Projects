package coffee.machines;

import coffee.exceptions.TrashContainerException;
import coffee.exceptions.WaterTankException;
import coffee.trashcontainer.TrashContainer;
import coffee.watertank.WaterTank;

public class CoffeeMachine {
    protected MachineType machineType;
    protected TrashContainer trashContainer;
    protected WaterTank waterTank;

    public CoffeeMachine(TrashContainer trashContainer, WaterTank waterTank) {
        this.trashContainer = trashContainer;
        this.waterTank = waterTank;
        this.machineType = MachineType.REGULAR;
    }

    public void start() throws WaterTankException, TrashContainerException {
        if (!waterTank.hasEnoughWater(0.3f)) {
            throw new WaterTankException();
        } else if(trashContainer.isContainerFull()) {
            throw new TrashContainerException();
        } else {
            waterTank.giveWater(0.3f);
            trashContainer.addTrash();
        }
    }

    public MachineType getMachineType() {
        return machineType;
    }

    public TrashContainer getTrashContainer() {
        return trashContainer;
    }

    public WaterTank getWaterTank() {
        return waterTank;
    }
}
