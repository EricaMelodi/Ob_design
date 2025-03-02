package TheOG;
import java.awt.*;

public abstract class Platform extends Vehicle implements IHasPlatform  {
    private double platformAngle;
    private final double maxPlatformAngle;

    public Platform(int nrDoors, Color color, double enginePower, String modelName, double maxPlatformAngle) {
        super(nrDoors, color, enginePower, modelName);
        this.platformAngle = 0;
        this.maxPlatformAngle = maxPlatformAngle;
    }

    public double getPlatformAngle() {
        return platformAngle;
    }

    @Override
    public void raisePlatform(double angle) {
        if (getCurrentSpeed() > 0) {
            throw new IllegalArgumentException("Platform can't be raised while moving");
        }
        platformAngle = Math.min(platformAngle + angle, maxPlatformAngle);
    }

    @Override
    public void lowerPlatform(double angle) {
        if (getCurrentSpeed() > 0) {
            throw new IllegalArgumentException("Platform can't be lowered while moving.");
        }
        platformAngle = Math.max(platformAngle - angle, 0);
    }

    public boolean isPlatformDown() {
        return platformAngle == 0;
    }

    @Override
    public void startEngine() {
        if (!isPlatformDown()) {
            throw new IllegalStateException("Cannot start engine while platform is up!");
        }
        super.startEngine();
    }

    @Override
    public void gas(double amount) {
        if (isPlatformDown()) {
            super.gas(amount);
        }
    }

    @Override
    public void move() {
        if (isPlatformDown()) {
            super.move();
        }
    }
}
