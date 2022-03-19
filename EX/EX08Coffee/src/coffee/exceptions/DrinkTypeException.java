package coffee.exceptions;

public class DrinkTypeException extends Exception{
    @Override
    public String toString() {
        return "This machine can't make this Drink!";
    }
}
