package ee.taltech.iti0202.computerstore.database;

import com.google.gson.Gson;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ee.taltech.iti0202.computerstore.components.Component;
import ee.taltech.iti0202.computerstore.exceptions.OutOfStockException;
import ee.taltech.iti0202.computerstore.exceptions.ProductAlreadyExistsException;
import ee.taltech.iti0202.computerstore.exceptions.ProductNotFoundException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class Database {
    private static Database instance = null;
    private Map<Integer, Component> components = new HashMap<>();

    private Database() { }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public void saveComponent(Component component) throws ProductAlreadyExistsException {
        if (components.containsKey(component.getId())) {
            throw new ProductAlreadyExistsException();
        } else {
            components.put(component.getId(), component);
        }
    }

    public void deleteComponent(int id) throws ProductNotFoundException {
        if (!components.containsKey(id)) {
            throw new ProductNotFoundException();
        } else {
            components.remove(id);
        }
    }

    public void increaseComponentStock(int id, int amount) throws ProductNotFoundException {
        if (!components.containsKey(id)) {
            throw new ProductNotFoundException();
        } else if (amount <= 0) {
            throw new IllegalArgumentException();
        } else {
            Component stockComponent = components.get(id);
            int newAmount = stockComponent.getAmount() + amount;
            stockComponent.setAmount(newAmount);
        }
    }

    public void decreaseComponentStock(int id, int amount) throws OutOfStockException, ProductNotFoundException {
        if (!components.containsKey(id)) {
            throw new ProductNotFoundException();
        } else if (amount <= 0) {
            throw new IllegalArgumentException();
        } else if (components.get(id).getAmount() < amount) {
            throw new OutOfStockException();
        } else {
            Component stockComponent = components.get(id);
            stockComponent.setAmount(stockComponent.getAmount() - amount);
            if (stockComponent.getAmount() - amount <= 0) {
                deleteComponent(id);
            }
        }
    }

    public Map<Integer, Component> getComponents() {
        return components;
    }

    public void resetEntireDatabase() {
        components.clear();
        Component.resetId();
    }

    public void saveToFile(String location) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileWriter writer = new FileWriter(location);
            gson.toJson(components.values(), writer);
            writer.close();
        } catch (IOException e) {
            System.out.println("couldnt save to a file");
        }
    }

    public void loadFromFile(String location) {
        resetEntireDatabase();
        try {
            FileReader fileReader = new FileReader(location);
            Gson gson = new Gson();
            List<Component> result = gson.fromJson(fileReader, new TypeToken<List<Component>>() {
            }.getType());
            for (Component component : result) {
                saveComponent(component);
            }
        } catch (IOException | ProductAlreadyExistsException e) {
            System.out.println("Could not read from a File");
        }
    }
}
