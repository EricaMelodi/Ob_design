
import java.awt.Color;


    public abstract class Car implements Movable {
        private int nrDoors;
        private Color color;
        private double currentSpeed;
        private double enginePower;
        private String modelName;

        public Car(int nrDoors, Color color, double enginePower, String modelName) {
            this.nrDoors = nrDoors;
            this.color = color;
            this.enginePower = enginePower;
            this.modelName = modelName;
            stopEngine();
        }

        public enum Coordinates { NORTH, SOUTH, WEST, EAST}

        private Coordinates direction = Coordinates.NORTH;

        public Coordinates getDirection(){
            return direction;
        }

        public void setDirection(Coordinates direction){
            this.direction = direction;
        }

        private double y = 0;
        private double x = 0;

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public void setPosition(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void move() {
            switch (direction){
                case NORTH -> y += currentSpeed;
                case SOUTH -> y-= currentSpeed;
                case EAST  -> x -= currentSpeed;
                case WEST  -> x += currentSpeed;
            }
        }

        @Override
        public void turnLeft(){
            switch (direction) {
                case NORTH -> direction = Coordinates.WEST;
                case SOUTH -> direction = Coordinates.EAST;
                case EAST  -> direction = Coordinates.NORTH;
                case WEST  -> direction = Coordinates.SOUTH;
            }
        }
        // Hur lösa detta?

        @Override
        public void turnRight(){
            switch (direction) {
                case NORTH -> direction = Coordinates.EAST;
                case SOUTH -> direction = Coordinates.WEST;
                case EAST  -> direction = Coordinates.SOUTH;
                case WEST  -> direction = Coordinates.NORTH;
            }
       }

        public int getNrDoors() {
            return nrDoors;
        }

        public double getEnginePower() {
            return enginePower;
        }


        public double getCurrentSpeed() {
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

        protected abstract double speedFactor();

        private void incrementSpeed(double amount) {
            currentSpeed = getCurrentSpeed() + speedFactor() * amount;
            if (currentSpeed > enginePower){
                currentSpeed = enginePower;
            }
        }

        private void decrementSpeed(double amount) {
            currentSpeed = getCurrentSpeed() - speedFactor() * amount;
            if (currentSpeed < 0){
                currentSpeed = 0;
            }
        }

       public void gas(double amount) {
            if (amount < 0 || amount > 1) {
                throw new IllegalArgumentException("Amount must be between 0 and 1");
            }
            incrementSpeed(amount);
        }

        public void brake(double amount) {
            if (amount < 0 || amount > 1) {
                throw new IllegalArgumentException("Amount must be between 0 and 1");
            }
            decrementSpeed(amount);
            }
        }





