package coffee.watertank;

public class WaterTank {
    private float capacity;
    private float currentWaterAmount;

    public WaterTank(float capacity) {
        this.capacity = capacity;
        this.currentWaterAmount = capacity;
    }

    public void giveWater(float amount) {
        currentWaterAmount -= amount;
    }

    public boolean hasEnoughWater(float amount) {
        return currentWaterAmount >= amount;

    }

    public void fillTank() {
        currentWaterAmount = capacity;
    }

    public float getCurrentWaterAmount() {
        return currentWaterAmount;
    }

    @Override
    public String toString() {
        return "WaterTank{"
                + "capacity="
                + capacity
                + '}';
    }
}
