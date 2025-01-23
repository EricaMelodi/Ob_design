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

        void move(String direction) {
            if (direction == "framåt") {
                // y + 1
            } else if (direction == "bakåt") {
                // y - 1
                System.out.println("Please enter a valid direction.");
            }
        }

        void turnLeft();

        void turnRight();



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

        public double speedFactor() {
            return 0;
        }

        public void incrementSpeed(double amount) {
        }

        public void decrementSpeed(double amount) {
        }


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

