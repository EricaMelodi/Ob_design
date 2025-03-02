package TheOG;

import java.util.ArrayList;

public class Container<T> {
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

    public int getMaxCapacity() {
        return MAX_CAPACITY;
    }

    public int getItemCount() {
        return items.size();
    }
}

