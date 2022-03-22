package coffee.exceptions;

public class SocketException extends Exception {
    @Override
    public String toString() {
        return "Socket already occupied!";
    }
}
