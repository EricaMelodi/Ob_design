package cook;
import TheOG.*;
import javax.swing.*;

public class Application {

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                CarController v = new CarController(new CarView("CarSim 1.0"));
                Garage<Volvo240> volvoWorkShop = new Garage<>(3);
                volvoWorkShop.setPosition(300, 300);
                v.volvoWorkShop = volvoWorkShop;

                Volvo240 volvo = new Volvo240();
                volvo.turnRight();
                volvo.setPosition(0, 300);

                Saab95 saab95 = new Saab95();
                saab95.turnRight();
                saab95.setPosition(0, 200);

                Scania scania = new Scania();
                scania.turnRight();
                scania.setPosition(0, 100);

                v.cars.add(volvo);
                v.cars.add(saab95);
                v.cars.add(scania);

                v.frame.drawPanel.setCars(v.cars);

                System.out.println("Timer starting...");
                v.timer.start();  // Anropa ny metod som startar timern
            });
        }
    }



