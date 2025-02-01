import java.awt.*;

public abstract class Scania extends Cars { // tror ej abstract?
    private double platformAngle;

    public Scania() {
        super(2, Color.green, 90, "Scania");
        this.platformAngle = 0;
    }

    public double getPlatformAngle() {
        return platformAngle;
    }

    public void raisePlatform(double angle) {
        if (currentSpeed > 0) {
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

    @Override
    public void move() {
        if (platformAngle == 0) {
            super.move();
        } else {
            throw new IllegalArgumentException("Scania can't move while platform is up.");
        }
    }
}
