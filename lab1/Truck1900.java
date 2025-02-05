import java.awt.*;
import java.util.Stack;

public class Truck1900 extends Truck implements IHasPlatform {

        public Truck1900() {
            super(2, Color.red, 85, "Truck1900");
        }

        Stack<Car> loadedCars;
        final int MAX_CARS = 10;
        final int MAX_WEIGHT_CAR = 2000;


        public void loadCars(Car loadCar, int weight) {
            if (getCurrentSpeed() != 0) {
                throw new IllegalArgumentException("Can't load cars while car is moving");
            } if (loadCar instanceof Truck){ //när load car är ett objekt fråpn truck använd instencOf.
                throw new IllegalArgumentException("Can't load truck in a truck");
            } if (weight > MAX_WEIGHT_CAR){
                throw new IllegalArgumentException ("Car is to big");
            }
            else {
                if (loadedCars.size() < MAX_CARS) {
                    loadedCars.push(loadCar);

                } else {
                    throw new IllegalArgumentException("Truck is full");
                }
            }
        }
            // Fråga om vart bil ska befinna sig för att få lastas??

        public void unloadCars(Car unloadCar){
            if (getCurrentSpeed() != 0){
                throw new IllegalArgumentException("Can't unload cars while car is moving");
            } else {
                loadedCars.pop();
            }
        }

        public void whileCarInTruck() {
           for (Car car : loadedCars){
               car.direction = truck1900.direction;
           }
        }


    // lasta på och och av bilar

    // Max anatal bilar på last

    // Max storlek på bilar som ska lastas

}

