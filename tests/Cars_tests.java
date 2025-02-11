

import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;


public class Cars_tests {

    @Test
    public void testMoveUp() {
        Volvo240 car = new Volvo240();
        car.startEngine();
        car.move();
        assertTrue(car.getY() > 0, "Car should have moved up");
    }

    @Test
    public void howManyDoors() {
        Saab95 car = new Saab95();
        assertEquals(2, car.getNrDoors(), "The car should have 2 doors");
    }

    @Test
    public void rightColor() {
        Volvo240 car = new Volvo240();
        assertEquals(Color.black, car.getColor(), "The color is black");
    }

    @Test
    public void doesEngineStop() {
        Saab95 car = new Saab95();
        car.startEngine();
        car.stopEngine();
        assertEquals(0, car.getCurrentSpeed(), "The current speed should be 0 if car has stopped");
    }

    @Test
    public void doesEngineStart() {
        Volvo240 car = new Volvo240();
        car.startEngine();
        assertEquals(0.1, car.getCurrentSpeed(), "The current speed should be over 0 if car has started");
    }

    @Test
    public void doesItTurnLeft() {
        Volvo240 car = new Volvo240();
        car.startEngine();
        car.turnLeft();
        assertEquals(Car.Coordinates.WEST, car.getDirection(), "Car should have moved left.");
    }

    @Test
    public void doesItTurnRight() {
        Saab95 car = new Saab95();
        car.startEngine();
        car.turnRight();
        assertEquals(Car.Coordinates.EAST, car.getDirection(), "Car should have moved right.");
    }


    @Test
    public void gasTest() {
        Saab95 car = new Saab95();
        car.startEngine();
        car.gas(0.5);
        assertTrue(car.getCurrentSpeed() > 0.1, "The current speed should be higher than 0.1 after you have gassed");
    }

    @Test
    public void doesItBrake() {
        Saab95 car = new Saab95();
        car.startEngine();
        car.brake(0.9);
        assertEquals(0, car.getCurrentSpeed());
    }

    @Test
    public void MaxAngleScania() {
        Scania truck = new Scania();
        truck.raisePlatform(90);
        assertEquals(70, truck.getPlatformAngle(), "Should not be more than 70");
    }

    @Test
    public void gasTooMuch() {
        Volvo240 car = new Volvo240();
        car.startEngine();
        assertThrows(IllegalArgumentException.class, () -> car.gas(2));
    }


    @Test
    public void addCarInTruck() {
        Truck1900 truck = new Truck1900();
        Saab95 car = new Saab95();
        truck.startEngine();
        truck.move();
        assertThrows(IllegalArgumentException.class, () -> truck.loadCars(car, 1500));
    }

    @Test
    public void garageIsFull(){
        Bilverkstad<Volvo240> volvoVerkstad = new Bilverkstad<>(2);
        Volvo240 volvo240 = new Volvo240();
        Volvo240 volvo241 = new Volvo240();
        Volvo240 volvo242 = new Volvo240();

        volvoVerkstad.takeInCar(volvo240);
        volvoVerkstad.takeInCar(volvo241);
        assertThrows(IllegalArgumentException.class, () -> volvoVerkstad.takeInCar(volvo240));
    }



//    @Test
//    public void addCarInTruck(){
//        truck1900 truck = new truck1900();
//        Saab95 car = new Saab95();
//        truck.startEngine();
//        truck.loadCars(car);
//        assertTrue(false, "can't load while truck is moving");
//
//    }
//
//
//    @Test
//   public void addCarToTruck(){
//        truck1900 truck = new truck1900();
//        Saab95 car = new Saab95();
//        truck.stopEngine();
//
//        for (int i = 0; i < 11; i++){
//            truck.loadCars(car);
//        }
//        assertTrue(false, "can't load more than 10 cars");
//    }


}




