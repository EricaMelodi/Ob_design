package Main;
import TheOG.*;
import cook.CarController;
import cook.CarView;
import javax.swing.*;

public class Application {

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                CarController v = new CarController(new CarView("CarSim 1.0"));

                v.addWorkShop(new Garage<>(new Volvo240(), 300, 300));
                v.addCar(new Volvo240(), 0, 300);
                v.addCar(new Saab95(), 0 , 200);
                v.addCar(new Scania(), 0 , 100);

                v.frame.drawPanel.setCars(v.cars);

                System.out.println("Timer starting...");
                v.timer.start();
            });
        }
    }



