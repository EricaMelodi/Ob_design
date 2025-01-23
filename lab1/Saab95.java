
import java.awt.*;

public class Saab95 extends Cars {

    public boolean turboOn;
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name

    public Saab95() {
        super(2, Color.red, 125, "Saab95");
        turboOn = false;
        stopEngine();
    }

    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    public void setTurboOn(){
        turboOn = true;
    }


    public void setTurboOff(){
        turboOn = false;
    }

    @Override
    public void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    @Override
    public void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }
}
