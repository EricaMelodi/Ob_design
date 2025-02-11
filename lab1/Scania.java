import java.awt.*;

public class Scania extends Truck implements HasPlatform{
    private double platformAngle;

    public Scania() {
        super(2, Color.green, 90, "Scania");
        this.platformAngle = 0;
    }


    @Override
    public double speedFactor() {
        return 0;
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
        platformAngle -= angle;
        if (platformAngle < 0) {
            platformAngle = 0;
        }
    }

}
