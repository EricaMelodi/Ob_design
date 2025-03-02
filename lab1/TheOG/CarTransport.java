package TheOG;

import java.awt.*;
import java.util.Stack;

public class CarTransport extends Vehicle implements IHasContainer {
    private final Container<Vehicle> loadedCars;
    public final int MAX_CARS = 10;
    public final int MAX_WEIGHT_CAR = 2000;
    private boolean isPlatformOpen = false;

    public CarTransport() {
        super(2, Color.red, 85, "CarTransport");
        this.loadedCars = new Container<>(MAX_CARS);
    }

    public void openPlatform() {
        if (getCurrentSpeed() > 0) {
            throw new IllegalArgumentException("Cannot open platform while the transport is moving.");
        }
        isPlatformOpen = true;
    }

    public void closePlatform() {
        isPlatformOpen = false;
    }

    public boolean isPlatformOpen() {
        return isPlatformOpen;
    }

    public boolean isNear (Vehicle car) {
        return Math.abs(car.getX() - this.getX()) < 3 && Math.abs(car.getY() - this.getY()) < 3;
    }

    public void loadCars(Vehicle car, int weight) {
        if (getCurrentSpeed() != 0) {
            throw new IllegalArgumentException("Can't load cars while car is moving");
        }
        if (!isPlatformOpen) {
            throw new IllegalArgumentException("Platform must be open to load the cars.");
        }
        if (weight > MAX_WEIGHT_CAR) {
            throw new IllegalArgumentException("Car is too heavy");
        }
        if (loadedCars.isFull()) {
            throw new IllegalArgumentException("Truck is full");
        }
        if (!isNear(car)) {
            throw new IllegalArgumentException("Car is too far away to be loaded");
        }
        loadedCars.addItem(car);
        posWhileCarInTransport();
        }


    public void unloadCars() {
        if (getCurrentSpeed() != 0) {
            throw new IllegalArgumentException("Can't unload cars while car is moving");
        }
        if (!isPlatformOpen) {
            throw new IllegalArgumentException("Can't unload cars while platform is closed");
        }
        if (loadedCars.isEmpty()) {
            throw new IllegalArgumentException("No cars left to unload");
        }
        loadedCars.removeItem(loadedCars.getItems().get(loadedCars.getItemCount() - 1));
    }

    public void posWhileCarInTransport() {
        for (Vehicle car : loadedCars.getItems()) {
            car.setDirection(getDirection());
            car.setPosition(getX(), getY());
        }
    }

    @Override
    protected double speedFactor() {
        return 0;
    }

    @Override
    public void move(){
        super.move();
        posWhileCarInTransport();
    }
}


