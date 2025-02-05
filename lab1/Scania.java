import java.awt.*;

public class Scania extends Truck implements IHasPlatform {
    private double platformAngle;

    public Scania() {
        super(2, Color.green, 90, "Scania");
        this.platformAngle = 0;
    }

    @Override
    public void move() {
        if (platformAngle == 0) {
            super.move();
        } else {
            throw new IllegalArgumentException("Scania can't move while platform is up.");
        }
    }

    @Override
    public double speedFactor() {
        return 0;
    }


}
