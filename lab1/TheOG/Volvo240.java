package TheOG;

import java.awt.*;

public class Volvo240 extends Vehicle {

    private final static double trimFactor = 1.25;


    public Volvo240(){
        super(4, Color.black, 100, "Volvo240");
        stopEngine();
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

    @Override
    public boolean collision(Garage<?> o) {
            boolean withinX = o.getX() <= this.getX() && this.getX() <= o.getX() + o.getSize();
            boolean withinY = o.getY() <= this.getY() && this.getY() <= o.getY() + o.getSize();
            return withinX && withinY;
    }

}

