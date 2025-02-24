package TheOG;

import java.awt.*;

public class Scania extends Vehicle implements IHasPlatform {
    private double platformAngle;

    public Scania() {
        super(2, Color.green, 100, "Scania");
        this.platformAngle = 0;
    }

    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    public double getPlatformAngle() {
        return platformAngle;
    }

    @Override
    public void raisePlatform(double angle) {
        if (getCurrentSpeed() > 0) {
            throw new IllegalArgumentException("Platform can't raise while Scania is moving.");
        }
        platformAngle += angle;
        if (platformAngle > 70) {
            platformAngle = 70;
        }
    }

    @Override
    public void lowerPlatform(double angle) {
        if (getCurrentSpeed() > 0) {
            throw new IllegalArgumentException("platform cant be lowered while Scania is moving");
        }
        platformAngle -= angle;
        if (platformAngle < 0) {
            platformAngle = 0;
        }
    }

    @Override
    public void startEngine() {
        if (platformAngle > 0) {
            throw new IllegalStateException("Cannot start engine while platform is up!");
        }
        super.startEngine();
    }
    @Override
    public void gas(double amount) {
         if (platformAngle == 0) {
            super.gas(amount);
         }

    }

    @Override
    public void move() {
        if (platformAngle == 0) {
            super.move();
        }
//         else {
//            throw new IllegalStateException("Cannot start engine while platform is up!");
//        }
    }
}
