package cook;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;
import TheOG.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel implements Observer{

    private Map<Vehicle,BufferedImage> map = new HashMap<>();
    private Map<Vehicle,Point> mapPoint = new HashMap<>();

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;
    BufferedImage streetsImage;

    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300,300);


    // TODO: Make this general for all cars
    void moveit(Vehicle car){
        mapPoint.put(car, new Point((int) car.getX(), (int) car.getY()));
        }

        public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.pink);

        try {
            ClassLoader classLoader = getClass().getClassLoader();
            volvoImage = ImageIO.read(classLoader.getResourceAsStream("pics/OOPSally.png"));
            saabImage = ImageIO.read(classLoader.getResourceAsStream("pics/mcqueen1.png"));
            scaniaImage = ImageIO.read(classLoader.getResourceAsStream("pics/mater.png"));
            streetsImage = ImageIO.read(classLoader.getResourceAsStream("pics/Streets.png"));

            volvoWorkshopImage = ImageIO.read(classLoader.getResourceAsStream("pics/VolvoBrand.jpg"));



        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(streetsImage, 0, 0, null);

        for (Map.Entry<Vehicle, BufferedImage> entry : map.entrySet()) {
            Vehicle car = entry.getKey();
            BufferedImage image = entry.getValue();
            Point position = mapPoint.get(car);

            if (position != null) {
                g.drawImage(image, position.x, position.y, null);
            }
        }
// Behöver ej movit, kan använda getX,getY från mapPoint

        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }

    public void setCars(List<Vehicle> cars) {
        for (Vehicle car : cars) {
            mapPoint.put(car, new Point((int) car.getX(), (int) car.getY()));
            map.put(car, getCarImage(car));
        }
    }

    private BufferedImage getCarImage(Vehicle car) {
        if (car instanceof Volvo240) return volvoImage;
        if (car instanceof Saab95) return saabImage;
        if (car instanceof Scania) return scaniaImage;
        return null;
    }

    @Override
    public void update() {
        repaint();
    }





}
