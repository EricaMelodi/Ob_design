package TheOG.Directions;

import TheOG.Vehicle;

public class WestDirection implements Direction {
    @Override
    public void move(Vehicle vehicle) {
        vehicle.setPosition(vehicle.getX() - vehicle.getCurrentSpeed(), vehicle.getY());
    }

    @Override
    public Direction turnLeft() {
        return new SouthDirection();
    }

    @Override
    public Direction turnRight() {
        return new NorthDirection();
    }
}
