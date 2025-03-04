package cook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import TheOG.*;
import TheOG.Directions.EastDirection;


public class CarController {
    private final int delay = 50;
    public CarView frame;
    public ArrayList<Vehicle> cars = new ArrayList<>();
    public Garage<Volvo240> volvoWorkShop;
    public Timer timer;
    private final VehicleFactory vehicleFactory;

    //methods:

    public CarController(CarView v, Garage<Volvo240> volvoWorkShop) {
        this.frame = v;
        this.volvoWorkShop = volvoWorkShop;
        this.vehicleFactory = new VehicleFactory();

        Timer timer = new Timer(50, new CarTimerListener(cars, volvoWorkShop, frame));
        timer.start();  // Startar timern här


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

    public void startTimer() {
        timer.start();  // Starta timern här
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
            if (modelName.equals("random")) {
                modelName = vehicleFactory.getAvailableModels().get((int) (Math.random() * vehicleFactory.getAvailableModels().size()));
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