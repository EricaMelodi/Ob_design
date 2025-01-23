import java.awt.*;

public class Volvo240 extends Cars{

    private final static double trimFactor = 1.25;
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    
    public Volvo240(){
        super(4, Color.black, 100, "Volvo240");
        stopEngine();
    }
    
    public int getNrDoors(){
        return nrDoors;
    }

    
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    public void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }
    }

