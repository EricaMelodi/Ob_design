package TheOG;

import java.awt.*;

public class Scania extends Vehicle implements IHasPlatform {
    private double platformAngle;

    public Scania() {
        super(2, Color.green, 90, "Scania");
        this.platformAngle = 0;
    }

    public double speedFactor() {
        return 0;
    }

    public double getPlatformAngle() {
        return platformAngle;
    }


    @Override
    public void raisePlatform(double angle) {
        if (getCurrentSpeed() > 0) {
            throw new IllegalArgumentException("Platform can't raise while theog.Scania is moving.");
        }
        platformAngle += angle;
        if (platformAngle > 70) {
            platformAngle = 70;
        }
    }

    @Override
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
