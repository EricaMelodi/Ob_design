package cook;

import TheOG.*;
import TheOG.Directions.EastDirection;

import javax.swing.Timer;
import java.util.ArrayList;
import java.util.List;

public class ModelFacade implements Subject {

    private final VehicleFactory vehicleFactory;
    private ArrayList<Vehicle> cars = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();
    private Timer timer;
    private Garage<Volvo240> volvoWorkShop;

    public ModelFacade() {
        this.vehicleFactory = new VehicleFactory();
        this.volvoWorkShop = new Garage<>(10, 300, 300);
        this.timer = new Timer(50, new CarTimerListener(cars, volvoWorkShop, this));
    }

    public ArrayList<Vehicle> getCars() {
        return cars;
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
            notifyObservers();
        }
    }

    public void removeCar() {
        if (!cars.isEmpty()) {
            Vehicle carToRemove = cars.get((int) (Math.random() * cars.size()));

            cars.remove(carToRemove);
            notifyObservers();
        }
    }

    public void startTimer() {
        timer.start();
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
            if (car instanceof IHasPlatform scania) {
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

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}