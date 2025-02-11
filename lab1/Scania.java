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


}
