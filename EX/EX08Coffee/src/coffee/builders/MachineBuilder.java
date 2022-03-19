package coffee.builders;

import coffee.machines.CoffeeMachine;
import coffee.trashcontainer.TrashContainer;
import coffee.watertank.WaterTank;

public abstract class MachineBuilder<T extends CoffeeMachine, B extends MachineBuilder<T,B>> {
    private final float TANK_SIZE = 1.5f;
    private final int CAPACITY = 5;
    protected WaterTank waterTank = new WaterTank(TANK_SIZE);
    protected TrashContainer trashContainer = new TrashContainer(CAPACITY);

    public B withWaterTank(WaterTank waterTank) {
        this.waterTank = waterTank;
        return (B) this;
    }
    public B withTrashContainer(TrashContainer trashContainer) {
        this.trashContainer = trashContainer;
        return (B) this;
    }
    public abstract T build ();
}
