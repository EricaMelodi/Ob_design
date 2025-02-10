import java.util.ArrayList;

public class Bilverkstad<Vehicle extends Car> {
     private Vehicle v;
     private int MAX_CARS;
     private ArrayList<Vehicle> carsInGarage;


    public Bilverkstad (int MAX_CARS){
        this.MAX_CARS = MAX_CARS;
        this.carsInGarage = new ArrayList<>();
    }

    public Vehicle getVehicle(){
        return v;
    }

    public void takeInCar(Vehicle car){
       if (carsInGarage.size() < MAX_CARS){
           carsInGarage.add(car);
       } else {
           throw new IllegalArgumentException("Garage is full");
       }

    }

    public void takeOutCar(Vehicle car) {
        if (carsInGarage.contains(car)) {
            carsInGarage.remove(car);
        } else {
            throw new IllegalArgumentException("Car is not in the garage!");
        }
    }
}


