package Main;
import TheOG.*;
import cook.CarController;
import cook.CarView;
import cook.ModelFacade;
import cook.Observer;
import javax.swing.*;
import java.util.ArrayList;

public class Application {

        public static void main(String[] args) {
                ModelFacade modelFacade = new ModelFacade();
                CarView carView = new CarView(modelFacade, "CarSim 1.0");
                modelFacade.addObserver(carView);
                Garage<Volvo240> volvoWorkShop = new Garage<>(10, 300, 300);

                modelFacade.addCar("random");
                modelFacade.addCar("random");
                modelFacade.addCar("random");
                modelFacade.startTimer();
                CarController carController = new CarController(carView, volvoWorkShop, modelFacade);
        }
}




