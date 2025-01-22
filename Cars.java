import java.awt.Color;

    public abstract class Cars implements Movable {
        public int nrDoors;
        public Color color;
        public double currentSpeed;
        public double enginePower;
        public String modelName;

        public Cars (int nrDoors, Color color, double enginePower, String modelName) {
            this.nrDoors = nrDoors;
            this.color = color;
            this.enginePower = enginePower;
            this.modelName = modelName;
            stopEngine();
        }

        public int getNrDoors(){
            return nrDoors;
        }

        public double getEnginePower(){
            return enginePower;
        }

        public double getCurrentSpeed(){
            return currentSpeed;
        }

        public Color getColor(){
            return color;
        }

        public void setColor(Color clr){
            color = clr;
        }

        public void startEngine(){
            currentSpeed = 0.1;
        }

        public void stopEngine(){
            currentSpeed = 0;
        }

        public double speedFactor(){
            // return enginePower * 0.01 * trimFactor;
            return 0;
            // gemensam för både saab och volvo men inte samma utförande
            // dessutom är trimFactor enbart en variabel för volvo,
            // dvs ej definierad i vår superklass...???
        }

        public void incrementSpeed(double amount){
            currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
        }

        public void decrementSpeed(double amount){
            currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
        }

        // TODO fix this method according to lab pm
        public void gas(double amount){
            incrementSpeed(amount);
        }

        // TODO fix this method according to lab pm
        public void brake(double amount){
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

