package TheOG.Directions;

import TheOG.Vehicle;

public class EastDirection implements Direction {
    @Override
    public void move(Vehicle vehicle) {
        vehicle.setPosition(vehicle.getX() + vehicle.getCurrentSpeed(), vehicle.getY());
    }

    @Override
    public Direction turnLeft() {
        return new NorthDirection();
    }

    @Override
    public Direction turnRight() {
        return new SouthDirection();
    }
}
