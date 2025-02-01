
import java.awt.Color;


    public abstract class Cars implements Movable {
        private int nrDoors;
        private Color color;
        public double currentSpeed;
        public double enginePower;
        private String modelName;

        public enum Coordinates {NORTH, SOUTH, WEST, EAST}

        public Coordinates direction = Coordinates.NORTH;

        public Coordinates getDirection(){
            return direction;
        }

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
            } if (amount > currentSpeed) {
                currentSpeed = 0;
            }
        }
    }
