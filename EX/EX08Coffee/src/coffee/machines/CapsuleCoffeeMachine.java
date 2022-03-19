package coffee.machines;

import coffee.capsule.Capsule;
import coffee.drinks.Drink;
import coffee.drinks.DrinkType;
import coffee.exceptions.CapsuleException;
import coffee.exceptions.DrinkTypeException;
import coffee.exceptions.TrashContainerException;
import coffee.exceptions.WaterTankException;
import coffee.trashcontainer.TrashContainer;
import coffee.watertank.WaterTank;

import java.util.Optional;

public class CapsuleCoffeeMachine extends CoffeeMachine {
    private Optional<Capsule> capsule = Optional.empty();

    public CapsuleCoffeeMachine(TrashContainer trashContainer, WaterTank waterTank) {
        super(trashContainer, waterTank);
        this.machineType = MachineType.CAPSULE;

    }

    public void addCapsule(Capsule capsule) throws CapsuleException {
        if (this.capsule.isEmpty()) {
            this.capsule = Optional.of(capsule);
        } else {
            throw new CapsuleException();
        }
    }
    public void removeCapsule() {
        this.capsule = Optional.empty();
    }

    @Override
    public Drink start(DrinkType drinkType) throws WaterTankException, TrashContainerException, DrinkTypeException {
        if (!waterTank.hasEnoughWater(CUP_SIZE)) {
            throw new WaterTankException();
        } else if (trashContainer.isContainerFull()) {
            throw new TrashContainerException();
        } else if (capsule.isPresent() && !capsule.get().isEmpty() && !capsule.get().getDrinkType().equals(drinkType)) {
            throw new DrinkTypeException();
        } else {
            waterTank.giveWater(CUP_SIZE);
            trashContainer.addTrash();
            if (capsule.isEmpty() || capsule.get().isEmpty()) {
                return new Drink(DrinkType.WATER);
            } else {
                removeCapsule();
                return new Drink(drinkType);
            }
        }
    }
}
