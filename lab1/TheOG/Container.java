package TheOG;

import java.util.ArrayList;

public class Container<T> implements IHasContainer{
    private final int MAX_CAPACITY;
    private ArrayList<T> items;

    public Container(int maxCapacity) {
        this.MAX_CAPACITY = maxCapacity;
        this.items = new ArrayList<>();
    }

    public boolean isFull() {
        return items.size() >= MAX_CAPACITY;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void addItem(T item) {
        if (isFull()) {
            throw new IllegalArgumentException("Container is full");
        }
        items.add(item);
    }

    public void removeItem(T item) {
        if (!items.contains(item)) {
            throw new IllegalArgumentException("Item not found in the container");
        }
        items.remove(item);
    }

    public ArrayList<T> getItems() {
        return items;
    }

    public int getItemCount() {
        return items.size();
    }

    @Override
    public void loadCars(Vehicle car, int weight) {

    }

    @Override
    public void unloadCars() {

    }

    @Override
    public void posWhileCarInTransport() {

    }

    @Override
    public boolean isNear(Vehicle car) {
        return false;
    }

    @Override
    public boolean isPlatformOpen() {
        return false;
    }

    @Override
    public void closePlatform() {

    }

    @Override
    public void openPlatform() {

    }
}

