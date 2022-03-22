package coffee.machines;

import coffee.capsule.Capsule;
import coffee.exceptions.*;
import coffee.drinks.Drink;
import coffee.drinks.DrinkType;
import coffee.trashcontainer.TrashContainer;
import coffee.watertank.WaterTank;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CapsuleCoffeeMachine extends CoffeeMachine {
    private Optional<Capsule> socket = Optional.empty();
    private List<Capsule> availableCapsules = new ArrayList<>();

    public CapsuleCoffeeMachine(TrashContainer trashContainer, WaterTank waterTank) {
        super(trashContainer, waterTank);
        this.machineType = MachineType.CAPSULE;

    }
    
    public void addCapsuleToMachine(Capsule capsule) {
        availableCapsules.add(capsule);
    }
    
    public void addCapsuleToSocket(Capsule capsule) throws SocketException {
        if (this.socket.isEmpty()) {
            this.socket = Optional.of(capsule);
        } else {
            throw new SocketException();
        }
    }
    public void removeCapsule(DrinkType drinkType) {
        this.socket = Optional.empty();
        Optional<Capsule> removableCapsule = findCapsuleWithDrinkType(drinkType);
        removableCapsule.ifPresent(capsule -> availableCapsules.remove(capsule));

    }

    @Override
    public Drink start(DrinkType drinkType) throws WaterTankException, TrashContainerException, DrinkTypeException {
        if (!waterTank.hasEnoughWater(CUP_SIZE)) {
            throw new WaterTankException();
        } else if (trashContainer.isContainerFull()) {
            throw new TrashContainerException();
        } else if (socket.isPresent() && !socket.get().isEmpty() && !socket.get().getDrinkType().equals(drinkType)) {
            throw new DrinkTypeException();
        } else if (socket.isEmpty() && !checkIfCapsuleAvailable(drinkType)) {
            waterTank.giveWater(CUP_SIZE);
            trashContainer.addTrash();
            return new Drink(DrinkType.WATER);
        }
        else {
            waterTank.giveWater(CUP_SIZE);
            trashContainer.addTrash();
            if (socket.isEmpty() || socket.get().isEmpty()) {
                return new Drink(DrinkType.WATER);
            } else {
                socket.get().useCapsule();
                return new Drink(drinkType);
            }
        }
    }

    @Override
    public boolean canMakeTheDrink(DrinkType drinkType) {
        if (!waterTank.hasEnoughWater(CUP_SIZE)) {
            return false;
        } else if (trashContainer.isContainerFull()) {
            return false;
        } else return checkIfCapsuleAvailable(drinkType);
    }

    public Optional<Capsule> getCapsule() {
        return socket;
    }
    
    public boolean checkIfCapsuleAvailable(DrinkType drinkType) {
        for (Capsule capsule : availableCapsules) {
            if (capsule.getDrinkType().equals(drinkType)) {
                return true;
            }
        }
        return false;
    }

    public Optional<Capsule> findCapsuleWithDrinkType(DrinkType drinkType) {
        Optional<Capsule> possibleCapsule = Optional.empty();
        for (Capsule capsule : availableCapsules) {
            if (capsule.getDrinkType().equals(drinkType)) {
                possibleCapsule = Optional.of(capsule);
            }
        }
        return possibleCapsule;
    }
}
