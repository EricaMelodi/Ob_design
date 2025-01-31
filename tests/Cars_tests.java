

import org.junit.jupiter.api.Test;
import java.awt.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class Cars_tests  {

 @Test
 public void testMoveUp(){
    Volvo240 car = new Volvo240();
    car.startEngine();
    car.move();
    assertTrue(car.getY() > 0, "Car should have moved up");

 }

 @Test
 public void howManyDoors(){
     Saab95 car = new Saab95();
     assertEquals(2, car.getNrDoors(), "The car should have 2 doors");
 }

 @Test
    public void rightColor(){
     Volvo240 car = new Volvo240();
     assertEquals(Color.black, car.getColor(), "The color is black" );
 }

 @Test
    public void doesEngineStop(){
     Saab95 car = new Saab95();
     car.startEngine();
     car.stopEngine();
     assertEquals(0, car.getCurrentSpeed(), "The current speed should be 0 if car has stopped");
 }

 @Test
    public void doesEngineStart(){
     Volvo240 car = new Volvo240();
     car.startEngine();
     assertEquals(0.1 , car.getCurrentSpeed(), "The current speed should be over 0 if car has started");
 }

@Test
    public void doesItTurnLeft(){
    Volvo240 car = new Volvo240();
    car.startEngine();
    car.turnLeft();
    assertEquals(Cars.Coordinates.WEST, car.getDirection(), "Car should have moved left.");
}

@Test
    public void doesItTurnRight(){
     Saab95 car = new Saab95();
     car.startEngine();
     car.turnRight();
     assertEquals(Cars.Coordinates.EAST, car.getDirection(), "Car should have moved right.");
}


@Test
    public void gasTest(){
    Saab95 car = new Saab95();
    car.startEngine();
    car.gas(0.5);
    assertTrue(car.currentSpeed > 0.1, "The current speed should be higher than 0.1 after you have gassed");
}

@Test
    public void doesItBrake(){
     Saab95 car = new Saab95();
     car.startEngine();
     car.brake(0.9);
     assertEquals(0, car.getCurrentSpeed());
}

}


