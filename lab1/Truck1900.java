import java.awt.*;
import java.util.Stack;

public class Truck1900 extends Truck implements IHasPlatform {
    private final Stack<Car> loadedCars;
    final int MAX_CARS = 10;
    final int MAX_WEIGHT_CAR = 2000;

    public Truck1900() {
        super(2, Color.red, 85, "Truck1900");
        this.loadedCars = new Stack<>();
    }

    public boolean isNear (Car car) {
        return Math.abs(car.getX() - this.getX()) < 3 && Math.abs(car.getY() - this.getY()) < 3;
    }

    public void loadCars(Car car, int weight) {
        if (getCurrentSpeed() != 0) {
            throw new IllegalArgumentException("Can't load cars while car is moving");
        }
        if (getPlatformAngle() > 0) {
            throw new IllegalArgumentException("Platform must be down to load the cars.");
        }
        if (weight > MAX_WEIGHT_CAR) {
            throw new IllegalArgumentException("Car is to heavy");
        }
        if (loadedCars.size() >= MAX_CARS) {
            throw new IllegalArgumentException("Truck is full");
        }
        if (!isNear(car)) {
            throw new IllegalArgumentException("Car is too far away to be loaded");
        }
        loadedCars.push(car);
        posWhileInTruck();
        }


    public void unloadCars() {
        if (getCurrentSpeed() != 0) {
            throw new IllegalArgumentException("Can't unload cars while car is moving");
        }
        if (getPlatformAngle() > 0) {
            throw new IllegalArgumentException("Can't unload cars while platform is raised");
        }
        if (loadedCars.isEmpty()) {
            throw new IllegalArgumentException("No cars left to unload");
        }
        loadedCars.pop();
    }

    public void posWhileInTruck() {
        for (Car car : loadedCars) {
            car.setDirection(getDirection());
            car.setPosition(getX(), getY());
        }
    }
}


