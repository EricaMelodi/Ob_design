package TheOG;

import java.awt.*;

public class Scania extends Platform {

    public Scania() {
        super(2, Color.green, 100, "Scania", 70);
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }
}