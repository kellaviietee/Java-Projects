package ee.taltech.iti0202.computerstore.database;


import ee.taltech.iti0202.computerstore.components.Component;
import ee.taltech.iti0202.computerstore.exceptions.ProductAlreadyExistsException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

        private Database database = Database.getInstance();
        private Component firstComponent = new Component("Processor",  Component.Type.CPU, BigDecimal.valueOf(500),
                "Intel", 8000, 500);
        private Component secondComponent = new Component("GraphicsCard",  Component.Type.GPU, BigDecimal.valueOf(1500),
                "Nvidia", 6000, 100);
        private Component thirdComponent = new Component("Patarei",  Component.Type.BATTERY, BigDecimal.valueOf(100),
                "Duracell", 500, 10);
        private Component fourthComponent = new Component("Tuulik",  Component.Type.FAN, BigDecimal.valueOf(200),
                "Veski", 200, 50);
        private Component fifthComponent = new Component("Meelis",  Component.Type.HDD, BigDecimal.valueOf(300),
                "Seadja", 20, 150);
        private Component sixthComponent = new Component("Ryzen",  Component.Type.KEYBOARD, BigDecimal.valueOf(20),
                "Mina", 2, 350);
        private Component seventhComponent = new Component("midagi",  Component.Type.MOTHERBOARD, BigDecimal.valueOf(200),
                "suvaline", 210, 55);
    @Test
    void testInstance() {
        Database firstDatabase = Database.getInstance();
        Database secondDatabase = Database.getInstance();
        assertEquals(firstDatabase, secondDatabase);
    }

    @Test
    void testSaveComponent() throws ProductAlreadyExistsException, IOException {
        database.saveComponent(firstComponent);
        assertThrows(ProductAlreadyExistsException.class, () -> database.saveComponent(firstComponent));
        database.saveComponent(secondComponent);
        database.saveToFile("test.txt");
    }

    @Test
    void testLoadComponent() throws IOException, ProductAlreadyExistsException {
        database.loadFromFile("test.txt");
    }
}
