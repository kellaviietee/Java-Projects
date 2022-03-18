package coffee.waterReservoir;

public class WaterReservoir {
    private final float capacity;
    private float currentWaterAmount;

    public WaterReservoir(float capacity) {
        this.capacity = capacity;
        this.currentWaterAmount = capacity;
    }

    public boolean hasEnoughWater(float amount) {
        return amount <= currentWaterAmount;
    }

    public boolean takeWater(float amount) {
        if (hasEnoughWater(amount)) {
            currentWaterAmount -= amount;
            return true;
        } else {
            return false;
        }
    }
}
