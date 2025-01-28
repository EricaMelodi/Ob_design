
import java.awt.Color;

    public abstract class Cars implements Movable {
        private int nrDoors;
        private Color color;
        public double currentSpeed;
        public double enginePower;
        private String modelName;

        public Cars(int nrDoors, Color color, double enginePower, String modelName) {
            this.nrDoors = nrDoors;
            this.color = color;
            this.enginePower = enginePower;
            this.modelName = modelName;
            stopEngine();
        }

        public double y = 0;
        public double x = 0;

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        @Override
        public void move(String direction) {
            if (("forward").equals(direction)){
                x += currentSpeed;
            } else if (("backward".equals(direction))) {
                x -= currentSpeed;
            } else {
                System.out.println("Please enter a valid direction, forward or backwards.");
                // Hur får man in forward?
            }
        }

        @Override
        public void turnLeft(){
             currentSpeed += y;
        }
        // Hur lösa detta?

        @Override
       public void turnRight(){
            currentSpeed -= y;
       }
       // Hur lösa så den inte ökar speed, svänger istället.




        public int getNrDoors() {
            return nrDoors;
        }

        public double getEnginePower() {
            return enginePower;
        }


        public double getCurrentSpeed() {
            if (currentSpeed < 0 || currentSpeed > enginePower) {
                throw new IllegalArgumentException("Current speed need to be between 0 and 1");
        }
            return currentSpeed;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color clr) {
            color = clr;
        }

        public void startEngine() {
            currentSpeed = 0.1;
        }

        public void stopEngine() {
            currentSpeed = 0;
        }

        public abstract double speedFactor();

        public abstract void incrementSpeed(double amount);

        public abstract void decrementSpeed(double amount);


       public void gas(double amount) {
            if (amount < 0 || amount > 1) {
                throw new IllegalArgumentException("Amount must be between 0 and 1");
            }
            incrementSpeed(amount);
            double oldSpeed = currentSpeed;
            if ( currentSpeed < oldSpeed){
                throw new IllegalArgumentException("Gas method should not reduce speed");
            }
        }

        public void brake(double amount) {
            if (amount < 0 || amount > 1) {
                throw new IllegalArgumentException("Amount must be between 0 and 1");
            }
            decrementSpeed(amount);
            double oldSpeed = currentSpeed;
            if (currentSpeed > oldSpeed) {
                throw new IllegalArgumentException("Break method should not increase speed");
            }
        }
    }

    // fråga: gemensammma metoder skall också implementera i superklassen men vad
    // händer med ej gemensamma metoder, stannar dem kvar i respektive klass?

    /*
    gemensamma:
    - getNrDoors
    - getEnginePower
    - getCurrentSpeed
    - getColor
    - setColor
    - startEngine
    - stopEngine
    - speedFactor
    - incrementSpeed
    - decrementSpeed
    - gas
    - break

    Vad Saab har men inte volvo:
    - setTurboOn
    - setTurboOff

    Vad volvo har men inte Saab:≈
    - trimFactor
     */

