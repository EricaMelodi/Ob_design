package cook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import TheOG.*;
import TheOG.Directions.EastDirection;

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
    public CarView frame;
    // A list of cars, modify if needed
    public ArrayList<Vehicle> cars = new ArrayList<>();
    public Garage<Volvo240> volvoWorkShop;

    //methods:

    public CarController(CarView v, Garage<Volvo240> volvoWorkShop) {
        this.frame = v;
        this.volvoWorkShop = volvoWorkShop;

        v.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gas(v.gasAmount);
            }
        });
        v.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brake(v.gasAmount);
            }
        });
        v.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turboOn();
            }
        });
        v.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turboOff();
            }
        });
        v.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                raisePlatform();
            }
        });
        v.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lowerPlatform();
            }
        });
        v.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startEngine();
            }
        });
        v.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopEngine();
            }
        });
        v.addCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCar("random");
                // anropa setcars
            }
        });
        v.removeCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeCar();
            } // ta bort bilar från listan
        });

    }

    // Gör klass med workshop + observer lista + timerlistner
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ArrayList<Vehicle> toRemove = new ArrayList<>();
            for (Vehicle car : cars) {
                car.move();

                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());

                if (x >= 700 || x < 0 || y >= 700 || y < 0) {
                    car.turnLeft();
                    car.turnLeft();
                }
                frame.drawPanel.repaint();

                if (car.collision(volvoWorkShop)) {
                    toRemove.add(car);
                }
            }
            for (Vehicle car : toRemove) {
                cars.remove(car);
            }
        }
    }

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

    public void addCar(String modelName) {
        if (cars.size() < 10) {
            VehicleFactory vehicleFactory = new VehicleFactory();

            if (modelName.equals("random")) {
                String[] models = {"Volvo240", "Saab95", "Scania"};
                modelName = models[(int) (Math.random() * models.length)];
            }

            Vehicle newCar = vehicleFactory.createVehicle(modelName);

            double x = Math.random() * 100;
            double y = Math.random() * 500;
            newCar.setPosition(x, y);

            newCar.setDirection(new EastDirection());

            cars.add(newCar);
            newCar.addObserver(frame);

            frame.drawPanel.setCars(cars);
            frame.drawPanel.repaint();
        }
    }

    public void removeCar() {
        if (!cars.isEmpty()) {
            Vehicle carToRemove = cars.get((int) (Math.random() * cars.size()));
            carToRemove.removeObserver(frame);
            cars.remove(carToRemove);

            frame.drawPanel.removeCarFromPanel(carToRemove);
            frame.drawPanel.repaint();

        }
    }
}




