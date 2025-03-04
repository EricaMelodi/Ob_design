package TheOG;

import java.awt.*;
import java.util.ArrayList;

public class Garage<T extends Vehicle> {
     private Container<T> container;
     private int x;
     private int y;
     int size;


    public Garage(int MAX_CARS, int x, int y){
        this.container = new Container<T>(MAX_CARS);
        this.x = x;
        this.y = y;
        this.size = 100;
    }

    public void takeInCar(T car){
       container.addItem(car);
    }

    public void takeOutCar(T car) {
        container.removeItem(car);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getSize() {
        return size;
    }
}


