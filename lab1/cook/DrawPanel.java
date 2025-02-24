package cook;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import TheOG.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;
    BufferedImage streetsImage;
    // To keep track of a single car's position
    Point volvoPoint = new Point(0, 0);
    Point saabPoint = new Point(0, 100);
    Point scaniaPoint = new Point(0, 200);

    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300,300);


    // TODO: Make this general for all cars
    void moveit(Vehicle carName, int x, int y){
        switch (carName) {
            case Volvo240 ignored -> {
                volvoPoint.x = x;
                volvoPoint.y = y;
            }
            case Saab95 ignored -> {
                saabPoint.x = x;
                saabPoint.y = y;
            }
            case Scania ignored -> {
                scaniaPoint.x = x;
                scaniaPoint.y = y;
            }
            default -> throw new IllegalStateException("Unexpected value: " + carName);
        }
    }


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.pink);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.

            ClassLoader classLoader = getClass().getClassLoader();
            volvoImage = ImageIO.read(classLoader.getResourceAsStream("pics/OOPSally.png"));
            volvoWorkshopImage = ImageIO.read(classLoader.getResourceAsStream("pics/VolvoBrand.jpg"));
            saabImage = ImageIO.read(classLoader.getResourceAsStream("pics/mcqueen1.png"));
            scaniaImage = ImageIO.read(classLoader.getResourceAsStream("pics/Mater.png"));
            streetsImage = ImageIO.read(classLoader.getResourceAsStream("pics/Streets.png"));
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
        g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
        g.drawImage(saabImage, saabPoint.x, saabPoint.y, null);
        g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null);

    }
}
