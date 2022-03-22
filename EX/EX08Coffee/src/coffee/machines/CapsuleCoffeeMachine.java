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

    /**
     * Add Capsule to the Machine to be used in the socket.
     * @param capsule New Capsule to be used.
     */
    public void addCapsuleToMachine(Capsule capsule) {
        availableCapsules.add(capsule);
    }

    /**
     * Put the Capsule into the Socket to be used to make the drink.
     * @param capsule Capsule to make the Drink
     * @throws SocketException Another Capsule is already in there.
     */
    public void addCapsuleToSocket(Capsule capsule) throws SocketException {
        if (this.socket.isEmpty()) {
            this.socket = Optional.of(capsule);
        } else {
            throw new SocketException();
        }
    }

    /**
     * Remove Capsule from the socket and from the list.
     * @param drinkType Type of the Drink to be removed.
     */
    public void removeCapsule(DrinkType drinkType) {
        this.socket = Optional.empty();
        Optional<Capsule> removableCapsule = findCapsuleWithDrinkType(drinkType);
        removableCapsule.ifPresent(capsule -> availableCapsules.remove(capsule));
    }

    /**
     * Try to make a Drink of the requested type.
     * @param drinkType Drink to be made.
     * @return Drink if possible.
     * @throws WaterTankException Not enough Water.
     * @throws TrashContainerException Trash Container is full.
     * @throws DrinkTypeException Can't make this type of Drink.
     */
    @Override
    public Drink start(DrinkType drinkType) throws WaterTankException, TrashContainerException, DrinkTypeException {
        if (!waterTank.hasEnoughWater(CUP_SIZE)) {
            LOGGER.info("Not enough Water!");
            throw new WaterTankException();
        } else if (trashContainer.isContainerFull()) {
            LOGGER.info("Trash Container is full!");
            throw new TrashContainerException();
        } else if (socket.isPresent() && !socket.get().isEmpty() && !socket.get().getDrinkType().equals(drinkType)) {
            LOGGER.info("Different Drink Capsule in the Socket!");
            throw new DrinkTypeException();
        } else if (socket.isEmpty() && !checkIfCapsuleAvailable(drinkType)) {
            waterTank.giveWater(CUP_SIZE);
            trashContainer.addTrash();
            LOGGER.info("Here's your water! No available Capsule!");
            return new Drink(DrinkType.WATER);
        }
        else {
            waterTank.giveWater(CUP_SIZE);
            trashContainer.addTrash();
            if (socket.isEmpty() || socket.get().isEmpty()) {
                LOGGER.info("Here's your water! Nothing in the Socket!");
                return new Drink(DrinkType.WATER);
            } else {
                socket.get().useCapsule();
                LOGGER.info("Here's your drink sir, would you like some fries with that?");
                return new Drink(drinkType);
            }
        }
    }

    /**
     * Check if the requested type of Drink can be made.
     * @param drinkType Type of Drink
     * @return If the drink can be made.
     */
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

    /**
     * See if the Machine has a Capsule that includes the required drink.
     * @param drinkType Type of drink.
     * @return If the Capsule exists on a Machine.
     */
    public boolean checkIfCapsuleAvailable(DrinkType drinkType) {
        for (Capsule capsule : availableCapsules) {
            if (capsule.getDrinkType().equals(drinkType)) {
                LOGGER.info("Requested Capsule is available!");
                return true;
            }
        }
        LOGGER.info("Sorry, no capsules of that kind on the machine!");
        return false;
    }

    /**
     * Get the Capsule from the Machine that has the right Drink in it.
     * @param drinkType Type of drink requested.
     * @return Possible Capsule.
     */
    public Optional<Capsule> findCapsuleWithDrinkType(DrinkType drinkType) {
        Optional<Capsule> possibleCapsule = Optional.empty();
        for (Capsule capsule : availableCapsules) {
            if (capsule.getDrinkType().equals(drinkType)) {
                LOGGER.info("Hey found the Capsule of the drink that you wanted!");
                possibleCapsule = Optional.of(capsule);
            }
        }
        LOGGER.info("This is what I can offer to you. Take it or leave it");
        return possibleCapsule;
    }

    @Override
    public String toString() {
        return "CapsuleCoffeeMachine{" +
                "trashContainer=" + trashContainer +
                ", waterTank=" + waterTank +
                '}';
    }
}
