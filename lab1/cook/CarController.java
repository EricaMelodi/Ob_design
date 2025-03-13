package cook;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import TheOG.*;

public class CarController {
    public Garage<Volvo240> volvoWorkShop;
    public java.util.List<Vehicle> cars;
    private ModelFacade modelFacade;


    public CarController(CarView v, Garage<Volvo240> volvoWorkShop, ModelFacade modelFacade) {
        this.volvoWorkShop = volvoWorkShop;
        this.modelFacade = modelFacade;

        modelFacade.startTimer();

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
    }

    void gas(int amount) {
        modelFacade.gas(amount);
    }

    void brake(double amount) {
        double brakeAmount = amount / 100;
        modelFacade.brake(amount);
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

    }

    public void removeCar() {
        modelFacade.removeCar();

    }
}