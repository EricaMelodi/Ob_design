import java.awt.*;

public class Truck extends Vehicle {

    double platformAngle;

    public Truck(int nrDoors, Color color, double enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
    }

    @Override
    public double speedFactor() {
        return 0;
    }

    public void move() {
        if (platformAngle == 0) {
            super.move();
        } else {
            throw new IllegalArgumentException("Truck can't move while platform is up.");
        }
    }



}
