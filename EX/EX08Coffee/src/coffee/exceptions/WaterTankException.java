package coffee.exceptions;

public class WaterTankException extends Exception {

    @Override
    public String toString() {
        return "Not Enough Water in the Tank";
    }
}
