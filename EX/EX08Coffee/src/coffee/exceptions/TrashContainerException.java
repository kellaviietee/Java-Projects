package coffee.exceptions;

public class TrashContainerException extends Exception{
    @Override
    public String toString() {
        return "Trash Container is Full";
    }
}
