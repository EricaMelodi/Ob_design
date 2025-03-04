package TheOG;
import java.awt.*;
import java.util.ArrayList;

public class Garage<T extends Vehicle> extends Container<T> {
     private int x;
     private int y;
     int size;


    public Garage(int MAX_CARS, int x, int y) {
        super(MAX_CARS);
        this.x = x;
        this.y = y;
        this.size = 100;
    }

    public void takeInCar(T car){
       addItem(car);
    }

    public void takeOutCar(T car) {
        removeItem(car);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }
}


