import java.awt.*;
import java.util.Stack;

public class Truck1900 extends Truck implements IHasPlatform {
    private final Stack<Car> loadedCars;
    final int MAX_CARS = 10;
    final int MAX_WEIGHT_CAR = 2000;
    private String truckdirection;


    public Truck1900() {
        super(2, Color.red, 85, "Truck1900");
        this.loadedCars = new Stack<>();
    }

    public void loadCars(Car car, int weight) {
        if (getCurrentSpeed() != 0) {
            throw new IllegalArgumentException("Can't load cars while car is moving");
        }
        if (getPlatformAngle() > 0) {
            throw new IllegalArgumentException("Platform must be down to load the cars.");
        }
        if (weight > MAX_WEIGHT_CAR) {
            throw new IllegalArgumentException("Car is to big");
        } else {
           if (loadedCars.size() < MAX_CARS) {
               loadedCars.push(car);
               //whileCarInTruck();
            } else {
                throw new IllegalArgumentException("Truck is full");
            }
        }
    }
    // Fråga om vart bil ska befinna sig för att få lastas??

    public void unloadCars(Car car) {
        if (getCurrentSpeed() != 0) {
            throw new IllegalArgumentException("Can't unload cars while car is moving");
        }
        if (getPlatformAngle() > 0) {
            throw new IllegalArgumentException("Can't unload cars while platform is raised");
        }
        if (loadedCars.isEmpty()) {
            throw new IllegalArgumentException("No cars left to unload");
        } else {
            loadedCars.pop();
        }
    }

//    public void whileCarInTruck() {
//        for (Car car : loadedCars) {
//            car.setDirection(truckdirection);  //
//        }
//    }
}


