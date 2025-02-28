package TheOG;

import java.awt.*;
import java.util.ArrayList;

public class Garage<T extends Vehicle> {
     private int MAX_CARS;
     private ArrayList<T> carsInGarage;
     int x;
     int y;
     int size;


    public Garage(int MAX_CARS, int x, int y){
        this.MAX_CARS = MAX_CARS;
        this.carsInGarage = new ArrayList<>();
        this.size = 300;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void takeInCar(T car){
       if (carsInGarage.size() < MAX_CARS){
           carsInGarage.add(car);
       } else {
           throw new IllegalArgumentException("Garage is full");
       }

    }

    public void takeOutCar(T car) {
        if (carsInGarage.contains(car)) {
            carsInGarage.remove(car);
        } else {
            throw new IllegalArgumentException("Car is not in the garage!");
        }
    }
}


