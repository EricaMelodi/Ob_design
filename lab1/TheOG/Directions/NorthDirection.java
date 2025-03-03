package TheOG.Directions;

import TheOG.Vehicle;

public class NorthDirection implements Direction {
    @Override
    public void move(Vehicle vehicle) {
        vehicle.setPosition(vehicle.getX(), vehicle.getY() + vehicle.getCurrentSpeed());
    }

    @Override
    public Direction turnLeft() {
        return new WestDirection();
    }

    @Override
    public Direction turnRight() {
        return new EastDirection();
    }
}

