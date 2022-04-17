package ee.taltech.iti0202.computerstore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import ee.taltech.iti0202.computerstore.components.Component;
import ee.taltech.iti0202.computerstore.exceptions.OutOfStockException;
import ee.taltech.iti0202.computerstore.exceptions.ProductAlreadyExistsException;
import ee.taltech.iti0202.computerstore.exceptions.ProductNotFoundException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    private static Database instance = null;
    private final Map<Integer, Component> components = new HashMap<>();

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
        }
    }

    public Map<Integer, Component> getComponents() {
        return components;
    }

    public void resetEntireDatabase() {
        components.clear();
        Component.resetId();
    }

    public void saveToFile(String location) throws IOException {
        FileWriter writer = new FileWriter(location);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        gson.toJson(components, writer);
        writer.close(); //close write          <---
    }

    public void loadFromFile(String location) throws IOException, ProductAlreadyExistsException {
        resetEntireDatabase();
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get(location));
        Map<Integer, Component> map = gson.fromJson(reader, Map.class);
        reader.close();
    }
}
