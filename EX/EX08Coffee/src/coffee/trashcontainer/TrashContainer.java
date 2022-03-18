package coffee.trashcontainer;

public class TrashContainer {
    private int capacity = 5;
    private int currentTrashAmount = 0;
    public TrashContainer(int capacity) {
        this.capacity = capacity;
    }

    public TrashContainer() {}

    public int getCapacity() {
        return capacity;
    }

    public void addTrash() {
        currentTrashAmount += 1;
    }
    public boolean isTrashContainerFull() {
        return currentTrashAmount >= capacity;
    }
}
