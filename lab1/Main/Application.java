package Main;
import TheOG.*;
import cook.CarController;
import cook.CarView;
import cook.Observer;

import javax.swing.*;
import java.util.ArrayList;

public class Application {

        public static void main(String[] args) {

                CarView carView = new CarView("CarSim 1.0");

                CarController carController = new CarController(carView, new Garage<>(5, 300, 300));

                carController.addCar("random");
                carController.addCar("random");
                carController.addCar("random");

                for (Vehicle car : carController.cars) {
                        car.addObserver(carView);

                        carView.drawPanel.setCars(carController.cars);

                        System.out.println("Timer starting...");
                        carController.timer.start();
                }
        }
}


