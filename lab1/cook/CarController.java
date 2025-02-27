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
    public Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();
    Garage<Volvo240> volvoWorkShop;


    //methods:

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

                    car.turnLeft();
                    car.turnLeft();
                }

                frame.drawPanel.moveit(car, x, y);

                // repaint() calls the paintComponent method of the panel

                frame.drawPanel.repaint();
            }
            collision();
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
            if (car instanceof IHasPlatform c) {
                c.raisePlatform(70);
            }
        }
    }

    void lowerPlatform() {
        for (Vehicle car : cars) {
            if (car instanceof Scania scania) {
                scania.lowerPlatform(70);
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
        ArrayList<Vehicle> toRemove = new ArrayList<>();
        for (Vehicle car : cars) {
            if (car instanceof Volvo240 volvo) {
                Point carPos = car.getPosition();
                Point workshopPos = volvoWorkShop.getPosition();
                System.out.printf("Car is at %s, workshop is at %s\r", carPos, workshopPos);
                if (carPos.x > 300 && carPos.x <= 350 && carPos.y >= 300 && carPos.y <= 400) {
                    volvo.setPosition(300, volvo.getY());
                    volvoWorkShop.takeInCar(volvo);
                    toRemove.add(volvo);
                }
            }
        }
        cars.removeAll(toRemove);
    }
}




