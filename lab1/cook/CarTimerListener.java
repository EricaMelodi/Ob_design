package cook;

import TheOG.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CarTimerListener implements ActionListener {
    private ArrayList<Vehicle> cars;
    private Garage<Volvo240> volvoWorkShop;
    private ModelFacade modelFacade;

    public CarTimerListener(ArrayList<Vehicle> cars, Garage<Volvo240> volvoWorkShop, ModelFacade modelFacade) {
        this.cars = cars;
        this.volvoWorkShop = volvoWorkShop;
        this.modelFacade = modelFacade;
    }

    @Override
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
            if (car.collision(volvoWorkShop)) {
                toRemove.add(car);
            }
        }
        cars.removeAll(toRemove);
        modelFacade.notifyObservers();
    }
}