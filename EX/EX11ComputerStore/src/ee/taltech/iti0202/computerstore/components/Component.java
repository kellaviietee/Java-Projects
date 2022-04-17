package ee.taltech.iti0202.computerstore.components;
import java.math.BigDecimal;

public class Component {
    private final int id;
    private final String name;
    private final Type type;
    private final BigDecimal price;
    private int amount = 1;
    private final String manufacturer;
    private final int performancePoints;
    private final int powerConsumption;

    public enum Type {
        CPU, GPU, RAM, MOTHERBOARD, HDD, SSD, PSU, KEYBOARD, TOUCHPAD, SCREEN, BATTERY, FAN
    }

    private static int idAddition = 1;
    public static void resetId() {
        idAddition = 1;
    }

    public Component(String name, Type type, BigDecimal price, String manufacturer,
                     int performancePoints, int powerConsumption) {
        this.id = -1 + idAddition;
        idAddition += 1;
        this.name = name;
        this.type = type;
        this.price = price;
        this.manufacturer = manufacturer;
        this.performancePoints = performancePoints;
        this.powerConsumption = powerConsumption;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getPerformancePoints() {
        return performancePoints;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    @Override
    public String toString() {
        return "Component{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", price=" + price +
                ", amount=" + amount +
                ", manufacturer='" + manufacturer + '\'' +
                ", performancePoints=" + performancePoints +
                ", powerConsumption=" + powerConsumption +
                '}';
    }
}
