package TheOG;

import java.awt.*;

public class Saab95 extends Vehicle {

    private boolean turboOn;

    public Saab95() {
        super(2, Color.red, 125, "theog.Saab95");
        turboOn = false;
        stopEngine();
    }

    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }


}
