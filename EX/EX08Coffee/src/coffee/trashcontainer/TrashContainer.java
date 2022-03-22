package coffee.trashcontainer;

public class TrashContainer {
    private final  int capacity;
    private int currentTrash;

    public TrashContainer(int capacity) {
        this.capacity = capacity;
        this.currentTrash = 0;
    }


    public void addTrash() {
        currentTrash += 1;
    }

    public boolean isContainerFull() {
        return currentTrash >= capacity;
    }

    public void emptyTrash() {
        currentTrash = 0;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "TrashContainer{" +
                "capacity=" + capacity +
                '}';
    }
}
