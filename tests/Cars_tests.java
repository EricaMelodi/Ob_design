

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;



public class Cars_tests  {

 @Test
 public void testMoveForward(){
    Volvo240 car = new Volvo240();
    car.startEngine();
    car.move("forward");
    assertTrue(car.getX() > 0, "Car should have moved forward");

 }

}
