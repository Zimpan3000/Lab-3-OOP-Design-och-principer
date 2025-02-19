import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    
    BufferedImage image;
    private final HashMap<String, ImageData> images = new HashMap<>();  
    
    // TODO : add multiple images for every car
    // To keep track of a single car's position
    Point volvoPoint = new Point();
    // TODO : add multiple points for every car

    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(0,300);

    // TODO: Make this general for all cars
    void moveit(int x, int y, String modelName){
        images.get(modelName).position = new Point(x,y);

    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
        
            
            


            image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            images.put("Saab95", new ImageData(image, new Point(0, 0)));
            image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            images.put("Scania", new ImageData(image, new Point(100, 0)));
            image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            images.put("Volvo240",new ImageData(image, new Point(200, 0)));
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
            
        } catch (IOException ex)
        
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    
    private static class ImageData {
        Image image;
        Point position;

        public ImageData(Image image, Point position) {
            this.image = image;
            this.position = position;
        }
    }
    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (ImageData imageData : images.values()) {
        g.drawImage(imageData.image, imageData.position.x, imageData.position.y, null); // see javadoc for more info on the parameters
        }

        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }
}

