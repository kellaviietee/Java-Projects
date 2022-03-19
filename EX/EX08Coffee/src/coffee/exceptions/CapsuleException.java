package coffee.exceptions;

public class CapsuleException extends Exception {
    @Override
    public String toString() {
        return "Filled capsule already in the Machine!";
    }
}
