
import java.awt.Color;

    public abstract class Cars implements Movable {
        private int nrDoors;
        private Color color;
        private double currentSpeed;
        private double enginePower;
        private String modelName;

        public Cars(int nrDoors, Color color, double enginePower, String modelName) {
            this.nrDoors = nrDoors;
            this.color = color;
            this.enginePower = enginePower;
            this.modelName = modelName;
            stopEngine();
        }

        public int y = 0;
        public int x = 0;

        @Override
        public void move(String direction) {
            if (("forward").equals(direction)){
                x += currentSpeed;
            } else if (("backward".equals(direction))) {
                x -= currentSpeed;
            } else {
                System.out.println("Please enter a valid direction, fram eller back.");
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
                System.out.println("Can't happen!!!");
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


        // TODO fix this method according to lab pm
        public void gas(double amount) {
            if (amount < 0 || amount > 1) {
                System.out.println("fuck u");
            }
            incrementSpeed(amount);
        }

        // TODO fix this method according to lab pm
        public void brake(double amount) {
            if (amount < 0 || amount > 1) {
                System.out.println("fuck u");
            }
            decrementSpeed(amount);
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

