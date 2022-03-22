package coffee.builders;

import coffee.logger.MyLogger;
import coffee.machines.CoffeeMachine;
import coffee.trashcontainer.TrashContainer;
import coffee.watertank.WaterTank;

import java.util.logging.Logger;

public abstract class MachineBuilder<T extends CoffeeMachine, B extends MachineBuilder<T, B>> {
    protected static final Logger LOGGER = Logger.getLogger(MyLogger.class.getName());
    private static final float TANK_SIZE = 1.5f;
    private static final int CAPACITY = 5;
    protected WaterTank waterTank = new WaterTank(TANK_SIZE);
    protected TrashContainer trashContainer = new TrashContainer(CAPACITY);

    public B withWaterTank(WaterTank waterTank) {
        LOGGER.info("Specified WaterTank" + waterTank.toString());
        this.waterTank = waterTank;
        return (B) this;
    }
    public B withTrashContainer(TrashContainer trashContainer) {
        LOGGER.info("With specified trash container" + trashContainer.toString());
        this.trashContainer = trashContainer;
        return (B) this;
    }
    public abstract T build();
}
