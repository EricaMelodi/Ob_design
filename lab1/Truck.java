import java.awt.*;

public class Truck extends Car {

    double platformAngle;

    public Truck(int nrDoors, Color color, double enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
    }

    @Override
    public double speedFactor() {
        return 0;
    }

    public double getPlatformAngle() {
        return platformAngle;
    }

    public void raisePlatform(double angle) {
        if (getCurrentSpeed() > 0) {
            throw new IllegalArgumentException("Platform can't raise while Scania is moving.");
        }
        platformAngle += angle;
        if (platformAngle > 70) {
            platformAngle = 70;
        }
    }

    public void lowerPlatform(double angle) {
        platformAngle -= angle;
        if (platformAngle < 0) {
            platformAngle = 0;
        }
    }

    public void move() {
        if (platformAngle == 0) {
            super.move();
        } else {
            throw new IllegalArgumentException("Truck can't move while platform is up.");
        }
    }



}
