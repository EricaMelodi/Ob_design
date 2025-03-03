package TheOG.Directions;

import TheOG.Vehicle;

public interface Direction {
    void move(Vehicle vehicle);
    Direction turnLeft();
    Direction turnRight();
}
