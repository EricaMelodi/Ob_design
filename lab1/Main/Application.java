package Main;
import TheOG.*;
import cook.CarController;
import cook.CarView;
import javax.swing.*;

public class Application {

        public static void main(String[] args) {
                CarController v = new CarController(new CarView("CarSim 1.0"), new Garage<>(5, 300, 300));

                v.addCar("random");
                v.addCar("random");
                v.addCar("random");

                v.frame.drawPanel.setCars(v.cars);

                System.out.println("Timer starting...");
                v.timer.start();
            }
        }



