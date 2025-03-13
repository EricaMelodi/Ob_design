package cook;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import TheOG.*;
import TheOG.Directions.EastDirection;

public class CarController {
    private final int delay = 50;
    public CarView frame;
    public Garage<Volvo240> volvoWorkShop;
    public Timer timer;
    public java.util.List<Vehicle> cars;
    private ModelFacade modelFacade;

    // Constructor
    public CarController(CarView v, Garage<Volvo240> volvoWorkShop, ModelFacade modelFacade) {
        this.frame = v;
        this.volvoWorkShop = volvoWorkShop;
        this.modelFacade = modelFacade;

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
            }
        });
        v.removeCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeCar();
            }
        });

        modelFacade.startTimer();
    }

    void gas(int amount) {
        modelFacade.gas(amount);
    }

    void brake(double amount) {
        double brakeAmount = amount / 100;
        modelFacade.brake(brakeAmount);
    }

    void turboOn() {
        modelFacade.turboOn();
    }

    void turboOff() {
        modelFacade.turboOff();
    }

    void raisePlatform() {
        modelFacade.raisePlatform();
    }

    void lowerPlatform() {
        modelFacade.lowerPlatform();
    }

    void startEngine() {
        modelFacade.startEngine();
    }

    void stopEngine() {
        modelFacade.stopEngine();
    }

    public void addCar(String modelName) {
        modelFacade.addCar(modelName);  // Add car to model
        frame.drawPanel.setCars(modelFacade.getCars());  // Update view
        frame.drawPanel.repaint();
    }

    public void removeCar() {
        modelFacade.removeCar();
        frame.drawPanel.setCars(modelFacade.getCars());
        frame.drawPanel.repaint();
    }
}