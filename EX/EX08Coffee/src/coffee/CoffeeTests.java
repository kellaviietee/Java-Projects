package coffee;

import coffee.builders.AutoCoffeeMachineBuilder;
import coffee.builders.CapsuleMachineBuilder;
import coffee.builders.CoffeeMachineBuilder;
import coffee.capsule.Capsule;
import coffee.drinks.Drink;
import coffee.drinks.DrinkType;
import coffee.exceptions.*;
import coffee.logger.MyLogger;
import coffee.machines.AutoCoffeeMachine;
import coffee.machines.CapsuleCoffeeMachine;
import coffee.machines.CoffeeMachine;
import coffee.machines.MachineType;
import coffee.order.Order;
import coffee.trashcontainer.TrashContainer;
import coffee.watertank.WaterTank;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


import static org.junit.jupiter.api.Assertions.*;

class CoffeeTests {
    private final static Logger LOGGER = Logger.getLogger(MyLogger.class.getName());

    @BeforeAll
    static void setup() throws IOException {
        FileHandler fileHandler = new FileHandler("log.txt");
        fileHandler.setFormatter(new SimpleFormatter());
        LOGGER.addHandler(fileHandler);
        LOGGER.info("Tests initialized!");
    }

    @AfterAll
            static void end() {
        LOGGER.info("Tests done!");
    }
    /*
    Tests setup.
     */
    // Set up builders.
    CoffeeMachineBuilder regularBuilder = new CoffeeMachineBuilder();
    AutoCoffeeMachineBuilder autoBuilder = new AutoCoffeeMachineBuilder();
    CapsuleMachineBuilder capsuleBuilder = new CapsuleMachineBuilder();

    /**
     * Test if all CoffeeMachines have Containers.
     */
    @Test
    public void allMachinesHaveTrashContainers() {
        CoffeeMachine regular = regularBuilder.build();
        assertNotNull(regular.getTrashContainer());
        AutoCoffeeMachine automatic = autoBuilder.build();
        assertNotNull(automatic.getTrashContainer());
        CapsuleCoffeeMachine capsuleMachine = capsuleBuilder.build();
        assertNotNull(capsuleMachine.getTrashContainer());
    }

    /**
     * Test if default TrashContainer size is five.
     */
    @Test
    public void defaultTrashContainerSize() {
        CoffeeMachine regular = regularBuilder.build();
        assertEquals(5, regular.getTrashContainer().getCapacity());
    }

    /**
     * Test Trash container needs emptying if it is full.
     */
    @Test
    public void trashContainerFullNoCoffee() throws TrashContainerException, WaterTankException, DrinkTypeException {
        CoffeeMachine regular = regularBuilder.withTrashContainer(new TrashContainer(1)).build();
        regular.start(DrinkType.COFFEE);
        assertThrows(TrashContainerException.class,() -> regular.start(DrinkType.COFFEE));
    }

    /**
     * Test that automatic coffee machine can make different drinks.
     */
    @Test
    public void automaticDifferentDrinks() throws TrashContainerException, WaterTankException, DrinkTypeException {
        AutoCoffeeMachine autoCoffeeMachine = autoBuilder.build();
        Drink drink1 = autoCoffeeMachine.start(DrinkType.COFFEE);
        assertEquals(DrinkType.COFFEE,drink1.getDrinkType());
        Drink drink2 = autoCoffeeMachine.start(DrinkType.CAPPUCCINO);
        assertEquals(DrinkType.CAPPUCCINO,drink2.getDrinkType());
        Drink drink3 = autoCoffeeMachine.start(DrinkType.COCOA);
        assertEquals(DrinkType.COCOA,drink3.getDrinkType());
        Drink drink4 = autoCoffeeMachine.start(DrinkType.TEA);
        assertEquals(DrinkType.TEA,drink4.getDrinkType());
        Drink drink5 = autoCoffeeMachine.start(DrinkType.WATER);
        assertEquals(DrinkType.WATER,drink5.getDrinkType());
    }

    /**
     * Test if initially Capsule Machine has a capsule in it. Also tests if it gives water if no capsule is present.
     */
    @Test
    public void capsuleMachineWithoutCapsule() throws TrashContainerException, WaterTankException, DrinkTypeException {
        CapsuleCoffeeMachine capsuleCoffeeMachine = capsuleBuilder.build();
        assertEquals(Optional.empty(),capsuleCoffeeMachine.getCapsule());
        assertEquals(DrinkType.WATER, capsuleCoffeeMachine.start(DrinkType.COFFEE).getDrinkType());
    }

    /**
     * Test if you can add more than one Capsule.
     */
    @Test
    public void capsuleMachineMultipleCapsules() throws SocketException {
        CapsuleCoffeeMachine capsuleCoffeeMachine = capsuleBuilder.build();
        capsuleCoffeeMachine.addCapsuleToSocket(new Capsule(DrinkType.COFFEE));
        assertThrows(SocketException.class, () -> capsuleCoffeeMachine.addCapsuleToSocket(new Capsule(DrinkType.TEA)));
    }

    /**
     * Test that Capsule makes the drinkType of the Machine and that Empty capsule makes water.
     */
    @Test
    public void testCapsuleMachineCapsuleAssignsDrinkType() throws TrashContainerException,
            WaterTankException, DrinkTypeException, SocketException {
        CapsuleCoffeeMachine capsuleCoffeeMachine = capsuleBuilder.build();
        capsuleCoffeeMachine.addCapsuleToSocket(new Capsule(DrinkType.COFFEE));
        assertEquals(DrinkType.COFFEE,capsuleCoffeeMachine.start(DrinkType.COFFEE).getDrinkType());
        assertEquals(DrinkType.WATER,capsuleCoffeeMachine.start(DrinkType.COCOA).getDrinkType());
    }

    /**
     * Test Capsule machine Trash Capacity.
     */
    @Test
    public void testCapsuleMachineTrashCapacity() {
        CapsuleCoffeeMachine capsuleCoffeeMachine = capsuleBuilder.build();
        assertEquals(10,capsuleCoffeeMachine.getTrashContainer().getCapacity());
    }

    /**
     * Test if WaterTank shares resources between multiple Coffee Machines.
     */
    @Test
    public void testOneWaterTankMultipleMachines() throws TrashContainerException, WaterTankException,
            DrinkTypeException {
        WaterTank testWatertank = new WaterTank(1.5f);
        CoffeeMachine regular1 = regularBuilder.withWaterTank(testWatertank).build();
        CoffeeMachine regular2 = regularBuilder.withWaterTank(testWatertank).build();
        CoffeeMachine regular3 = regularBuilder.withWaterTank(testWatertank).build();
        regular1.start(DrinkType.COFFEE);
        regular1.start(DrinkType.COFFEE);
        regular2.start(DrinkType.COFFEE);
        regular2.start(DrinkType.COFFEE);
        regular3.start(DrinkType.COFFEE);
        assertThrows(WaterTankException.class,() -> regular3.start(DrinkType.COFFEE));
    }


    /**
     * Test if Kitchen can fulfill orders.
     */
    @Test
    public void testKitchen() throws TrashContainerException, WaterTankException, DrinkTypeException {
        Kitchen kitchen = new Kitchen();
        CoffeeMachine coffeeMachine = regularBuilder.build();
        AutoCoffeeMachine autoCoffeeMachine = autoBuilder.build();
        CapsuleCoffeeMachine capsuleCoffeeMachine = capsuleBuilder.build();
        kitchen.addCoffeeMachine(coffeeMachine);
        kitchen.addCoffeeMachine(autoCoffeeMachine);
        kitchen.addCoffeeMachine( capsuleCoffeeMachine);
        Order order = new Order(DrinkType.TEA, MachineType.REGULAR);
        kitchen.addOrder(order);
        assertEquals(Optional.empty(),kitchen.fulfillOrder(order));
        assertEquals(DrinkType.COFFEE,kitchen.fulfillOrder(new Order(DrinkType.COFFEE,MachineType.REGULAR))
                .get().getDrinkType());


    }

    /**
     * Test Emptying the Trash Container.
     */
    @Test
    public void testEmptyingTrash() throws TrashContainerException, WaterTankException, DrinkTypeException {
        AutoCoffeeMachine autoCoffeeMachine = autoBuilder.withTrashContainer(new TrashContainer(1)).build();
        autoCoffeeMachine.start(DrinkType.COFFEE);
        assertFalse(autoCoffeeMachine.canMakeTheDrink(DrinkType.COFFEE));
        autoCoffeeMachine.getTrashContainer().emptyTrash();
        assertTrue(autoCoffeeMachine.canMakeTheDrink(DrinkType.COFFEE));
    }

    /**
     * Test Filling the Water Tank to the brim.
     */
    @Test
    public void testFillWaterTank() throws TrashContainerException, WaterTankException, DrinkTypeException {
        AutoCoffeeMachine autoCoffeeMachine = autoBuilder.build();
        autoCoffeeMachine.start(DrinkType.COFFEE);
        autoCoffeeMachine.start(DrinkType.COCOA);
        assertNotEquals(1.5f,autoCoffeeMachine.getWaterTank().getCurrentWaterAmount());
        autoCoffeeMachine.getWaterTank().fillTank();
        assertEquals(1.5f,autoCoffeeMachine.getWaterTank().getCurrentWaterAmount());

    }

    /**
     * Test adding a Drinks list to the Automatic Coffee Machine.
     */
    @Test
    public void testAutoCoffeeMachineSetDrinkList() {
        List<DrinkType> drinkTypeList = new ArrayList<>(Arrays.asList(DrinkType.COCOA,DrinkType.TEA,DrinkType.WATER));
        AutoCoffeeMachine autoCoffeeMachine = autoBuilder.withDrinkList(drinkTypeList).build();
        assertEquals(drinkTypeList,autoCoffeeMachine.getDrinkList());
    }

    /**
     * Test adding Capsules to Capsule Coffee Machine.
     * If it removes the Capsules after usage from its list.
     */
    @Test
    public void testCapsuleCoffeeMachine() throws TrashContainerException, WaterTankException, DrinkTypeException {
        CapsuleCoffeeMachine capsuleCoffeeMachine = capsuleBuilder.withWaterTank(new WaterTank(0.4f)).build();
        capsuleCoffeeMachine.addCapsuleToMachine(new Capsule(DrinkType.COCOA));
        assertFalse(capsuleCoffeeMachine.canMakeTheDrink(DrinkType.TEA));
        capsuleCoffeeMachine.addCapsuleToMachine(new Capsule(DrinkType.TEA));
        capsuleCoffeeMachine.start(DrinkType.COCOA);
        assertFalse(capsuleCoffeeMachine.canMakeTheDrink(DrinkType.TEA));
        capsuleCoffeeMachine.getWaterTank().fillTank();
        assertEquals(DrinkType.WATER,capsuleCoffeeMachine.start(DrinkType.COFFEE).getDrinkType());
    }

    /**
     * Test Capsule coffee machines Water Tank exception.
     * */
    @Test
    public void testCapsuleWaterTank() throws TrashContainerException, WaterTankException, DrinkTypeException {
        CapsuleCoffeeMachine capsuleCoffeeMachine = capsuleBuilder.withWaterTank(new WaterTank(0.4f)).build();
        capsuleCoffeeMachine.start(DrinkType.COFFEE);
        assertFalse(capsuleCoffeeMachine.canMakeTheDrink(DrinkType.TEA));
        assertThrows(WaterTankException.class, () -> capsuleCoffeeMachine.start(DrinkType.TEA));
    }

    /**
     * Test Capsule coffee machines Trash Container exception.
     * */
    @Test
    public void testCapsuleTrashContainer() throws TrashContainerException, WaterTankException, DrinkTypeException {
        CapsuleCoffeeMachine capsuleCoffeeMachine = capsuleBuilder.withTrashContainer(new TrashContainer(1))
                .build();
        capsuleCoffeeMachine.start(DrinkType.COFFEE);
        assertFalse(capsuleCoffeeMachine.canMakeTheDrink(DrinkType.TEA));
        assertThrows(TrashContainerException.class, () -> capsuleCoffeeMachine.start(DrinkType.TEA));
    }

    /**
     * Test if Capsule machine can find the right Capsule if it exists.
     */
    @Test
    public void testFindingCapsule() throws SocketException {
        CapsuleCoffeeMachine capsuleCoffeeMachine = capsuleBuilder.build();
        Capsule testCapsule = new Capsule(DrinkType.COCOA);
        capsuleCoffeeMachine.addCapsuleToMachine(testCapsule);
        assertEquals(testCapsule,capsuleCoffeeMachine.findCapsuleWithDrinkType(DrinkType.COCOA).get());
        capsuleCoffeeMachine.addCapsuleToSocket(testCapsule);
        assertThrows(DrinkTypeException.class, () -> capsuleCoffeeMachine.start(DrinkType.CAPPUCCINO));
        capsuleCoffeeMachine.removeCapsule(testCapsule.getDrinkType());
    }



}