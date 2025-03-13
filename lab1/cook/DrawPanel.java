package cook;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;
import TheOG.*;

public class DrawPanel extends JPanel implements Observer {

    private Map<Class<? extends Vehicle>, BufferedImage> carImages = new HashMap<>();
    private Map<Vehicle, BufferedImage> carMap = new HashMap<>();

    private BufferedImage streetsImage;
    private BufferedImage volvoWorkshopImage;
    private final Point volvoWorkshopPoint = new Point(300, 300);

    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.pink);
        loadImages();
    }

    // Load all images
    private void loadImages() {
        try {
            ClassLoader classLoader = getClass().getClassLoader();

            // Load images and map car classes to images
            carImages.put(Volvo240.class, ImageIO.read(classLoader.getResourceAsStream("pics/OOPSally.png")));
            carImages.put(Saab95.class, ImageIO.read(classLoader.getResourceAsStream("pics/mcqueen1.png")));
            carImages.put(Scania.class, ImageIO.read(classLoader.getResourceAsStream("pics/mater.png")));

            streetsImage = ImageIO.read(classLoader.getResourceAsStream("pics/Streets.png"));
            volvoWorkshopImage = ImageIO.read(classLoader.getResourceAsStream("pics/VolvoBrand.jpg"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Map cars to their images
    public void setCars(List<Vehicle> cars) {
        carMap.clear();
        for (Vehicle car : cars) {
            carMap.put(car, getCarImage(car));
        }
    }

    // Get the correct image for a specific car type
    private BufferedImage getCarImage(Vehicle car) {
        return carImages.getOrDefault(car.getClass(), null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background
        if (streetsImage != null) {
            g.drawImage(streetsImage, 0, 0, null);
        }

        // Draw cars at their positions
        for (Vehicle car : carMap.keySet()) {
            BufferedImage image = getCarImage(car);
            if (image != null) {
                g.drawImage(image, (int) car.getX(), (int) car.getY(), null);
            }
        }

        // Draw the workshop
        if (volvoWorkshopImage != null) {
            g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
        }
    }

    @Override
    public void update() {
        repaint();
    }



}