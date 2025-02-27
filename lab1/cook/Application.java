package cook;

import TheOG.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Application {

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                CarController cc = new CarController();
                Garage<Volvo240> volvoWorkShop = new Garage<>(3);
                volvoWorkShop.setPosition(300, 300);
                cc.volvoWorkShop = volvoWorkShop;

                Volvo240 volvo = new Volvo240();
                volvo.turnRight();
                volvo.setPosition(0, 300);

                Saab95 saab95 = new Saab95();
                saab95.turnRight();
                saab95.setPosition(0, 200);

                Scania scania = new Scania();
                scania.turnRight();
                scania.setPosition(0, 100);

                cc.cars.add(volvo);
                cc.cars.add(saab95);
                cc.cars.add(scania);

                cc.frame = new CarView("CarSim 1.0", cc);

                System.out.println("Timer starting...");
                cc.timer.start();  // Anropa ny metod som startar timern
            });
        }
    }



