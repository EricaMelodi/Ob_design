package cook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import TheOG.*;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();
    Garage<Volvo240> volvoWorkShop = new Garage<>(3);

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        Garage<Volvo240> volvoWorkShop = new Garage<>(3);
        volvoWorkShop.setPosition(300, 300);

        Volvo240 volvo = new Volvo240();
        volvo.setPosition(300, 0);

        Saab95 saab95 = new Saab95();
        saab95.setPosition(200, 0);

        Scania scania = new Scania();
        scania.setPosition(100, 0);

        cc.cars.add(volvo);
        cc.cars.add(saab95);
        cc.cars.add(scania);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars) {
                car.move();

                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());

                if (x >= 700 || x < 0 || y >= 700 || y < 0) {
                    car.stopEngine();

                    car.turnLeft();
                    car.turnLeft();

                    car.setPosition(Math.max(0, Math.min(699, car.getX())), Math.max(0, Math.min(699, car.getY())));

                    car.startEngine();

                }

                frame.drawPanel.moveit(car, y, x);

                // repaint() calls the paintComponent method of the panel

                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.gas(gas);
        }
    }

    void brake(double amount) {
        double brakeAmount = amount / 100;
        for (Vehicle car : cars) {
            car.brake(brakeAmount);
        }
    }

    void turboOn() {
        for (Vehicle car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Vehicle car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void raisePlatform() {
        for (Vehicle car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).raisePlatform(((Scania) car).getPlatformAngle());
            }
        }
    }

    void lowerPlatform() {
        for (Vehicle car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).lowerPlatform(((Scania) car).getPlatformAngle());
            }
        }
    }

    void startEngine() {
        for (Vehicle car : cars) {
            car.startEngine();
        }
    }

    void stopEngine() {
        for (Vehicle car : cars) {
            car.stopEngine();
        }
    }

    void collision() {
        for (Vehicle car : cars) {
            Point carPos = car.getPosition();
            volvoWorkpos = volvoWorkShop.setPosition(300, 300);
            if (carPos.equals(volvoWorkPos) {


            }
        }
    }
}