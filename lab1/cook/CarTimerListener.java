package cook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import TheOG.*;

public class CarTimerListener implements ActionListener {
    private ModelFacade modelFacade;

    public CarTimerListener(ModelFacade modelFacade) {
        this.modelFacade = modelFacade;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Vehicle car : modelFacade.getCars()) {
            car.move();
        }
        modelFacade.notifyObservers();
    }
}